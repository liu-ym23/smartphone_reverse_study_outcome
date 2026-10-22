package com.bytedance.ai.resource;

import android.content.Context;
import android.util.Pair;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AppletResourceTool$forceGeckoUpdate$1", f = "AppletResourceTool.kt", i = {0}, l = {1107}, m = "invokeSuspend", n = {"updateSucceed"}, s = {"L$0"})
final class AppletResourceTool$forceGeckoUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ k $geckoConfigs;
    final /* synthetic */ CompletableDeferred<Boolean> $geckoInit;
    final /* synthetic */ int $offlineFileVersion;
    Object L$0;
    int label;

    public static final class a extends GeckoUpdateListener {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ CompletableDeferred<Boolean> b;

        public final void onUpdateFinish() {
            super.onUpdateFinish();
            com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
            StringBuilder r1 = new StringBuilder("onUpdateFinish ");
            r1.append(!this.a.element);
            r0.d("AppletResourceLoader", r1.toString());
            this.b.complete(Boolean.valueOf(!this.a.element));
        }

        public a(Ref.BooleanRef r1, CompletableDeferred<Boolean> r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void onUpdateFailed(UpdatePackage r10, Throwable r11) {
            super.onUpdateFailed(r10, r11);
            com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
            StringBuilder r1 = new StringBuilder("failed to update ");
            if (r10 == null) goto L5;
            String r12 = r10.getChannel();
        L6:
            r1.append(r12);
            r1.append(", ");
            r1.append(r11);
            r0.e("AppletResourceLoader", r1.toString());
            this.a.element = true;
            return;
        L5:
            r12 = null;
            goto L6
        }
    }

    public AppletResourceTool$forceGeckoUpdate$1(CompletableDeferred<Boolean> r1, k r10, int r11, Context r12, Continuation<? super AppletResourceTool$forceGeckoUpdate$1> r13) {
        this.$geckoInit = r1;
        this.$geckoConfigs = r10;
        this.$offlineFileVersion = r11;
        this.$context = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletResourceTool$forceGeckoUpdate$1(this.$geckoInit, this.$geckoConfigs, this.$offlineFileVersion, this.$context, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Ref.BooleanRef r10 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r14);
    L37:
        Iterator r15 = ((Iterable) r14).iterator();
    L39:
        if (r15.hasNext() == false) goto L44;
        if (((Boolean) r15.next()).booleanValue() == true) goto L39;
        r10.element = false;
        goto L39
    L44:
        if (r10.element == false) goto L46;
        AppletResourceTool.a.getClass();
        AppletResourceTool.i().storeInt("offlineFileVersion", this.$offlineFileVersion);
    L46:
        com.bytedance.ai.utils.g.a.d("AppletResourceLoader", "forceGeckoUpdate result: " + r10.element);
        this.$geckoInit.complete(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        Set r16 = CollectionsKt.toSet(com.bytedance.ai.settings.b.o.a());
        if (r16.isEmpty() == false) goto L12;
        com.bytedance.ai.utils.g.a.d("AppletResourceLoader", "update channel list is empty");
        this.$geckoInit.complete(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L12:
        ArrayList r11 = new ArrayList();
        List<j> r12 = this.$geckoConfigs.a;
        Context r13 = this.$context;
        Iterator r17 = ((ArrayList) r12).iterator();
    L14:
        if (r17.hasNext() == false) goto L33;
        j r18 = (j) r17.next();
        String r19 = r18.a;
        if (r18.c == false) goto L18;
        PolarisFileWrapper r20 = new PolarisFileWrapper(r13.getFilesDir(), r18.b);
    L19:
        List r21 = ResLoadUtils.getAllLocalChannels(r20, r19);
        ArrayList r22 = new ArrayList();
        if (r21 == null) goto L28;
        Iterator r23 = r21.iterator();
    L23:
        if (r23.hasNext() == false) goto L28;
        Pair r24 = (Pair) r23.next();
        if (r16.contains(r24.first) == false) goto L23;
        com.bytedance.ai.utils.g.a.d("AppletResourceLoader", "add " + ((String) r24.first) + " into update list.");
        r22.add(new CheckRequestBodyModel.TargetChannel((String) r24.first));
    L28:
        if ((!r22.isEmpty()) == false) goto L14;
        Ref.BooleanRef r25 = new Ref.BooleanRef();
        CompletableDeferred r110 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r11.add(r110);
        GeckoClient r111 = com.bytedance.geckox.a.a(r19);
        if (r111 != null) goto L31;
        Boxing.boxBoolean(r110.complete(Boxing.boxBoolean(true)));
        goto L14
    L31:
        r111.checkUpdateMulti(null, new a(r25, r110), MapsKt.mapOf(TuplesKt.to(r19, r22)));
        goto L14
    L18:
        r20 = new PolarisFileWrapper(r18.b);
        goto L19
    L33:
        Ref.BooleanRef r112 = new Ref.BooleanRef();
        r112.element = true;
        this.L$0 = r112;
        this.label = 1;
        Object r26 = AwaitKt.a(r11, this);
        if (r26 != r0) goto L36;
        return r0;
    L36:
        r10 = r112;
        r14 = r26;
        goto L37
    }
}
