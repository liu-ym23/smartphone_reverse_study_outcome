package com.bytedance.ai.resource;

import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AppletResourceTool$forceGeckoUpdate$1", f = "AppletResourceTool.kt", i = {0}, l = {961}, m = "invokeSuspend", n = {"updateSucceed"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nAppletResourceTool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppletResourceTool.kt\ncom/bytedance/ai/resource/AppletResourceTool$forceGeckoUpdate$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1132:1\n1863#2:1133\n1863#2,2:1134\n1864#2:1136\n1863#2,2:1137\n*S KotlinDebug\n*F\n+ 1 AppletResourceTool.kt\ncom/bytedance/ai/resource/AppletResourceTool$forceGeckoUpdate$1\n*L\n917#1:1133\n926#1:1134,2\n917#1:1136\n961#1:1137,2\n*E\n"})
final class AppletResourceTool$forceGeckoUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Ref.BooleanRef f2547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.r f2549c;
    public final /* synthetic */ u d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Application f;

    public AppletResourceTool$forceGeckoUpdate$1(kotlinx.coroutines.r r5, u r10, int r11, Application r12, Continuation r13) {
        this.f2549c = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r10, Continuation r11) {
        return new AppletResourceTool$forceGeckoUpdate$1(this.f2549c, this.d, this.e, this.f, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((AppletResourceTool$forceGeckoUpdate$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f2548b;
        boolean r11 = true;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        Ref.BooleanRef r12 = this.f2547a;
        ResultKt.throwOnFailure(r18);
        Object r13 = r18;
    L57:
        Iterator r14 = ((Iterable) r13).iterator();
    L59:
        if (r14.hasNext() == false) goto L64;
        if (((Boolean) r14.next()).booleanValue() == true) goto L59;
        r12.element = false;
        goto L59
    L64:
        if (r12.element == false) goto L66;
        e0.p().storeInt("offlineFileVersion", this.e);
    L66:
        String r15 = "forceGeckoUpdate result: " + r12.element;
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L69;
        r16.d("AppletResourceLoader", r15);
    L69:
        ((kotlinx.coroutines.s) this.f2549c).N(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        Set r17 = CollectionsKt.toSet(AISDKSettingConfigManager.INSTANCE.getFORCE_UPDATE_CHANNEL_LIST().getValue());
        if (r17.isEmpty() == false) goto L15;
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L13;
        r19.d("AppletResourceLoader", "update channel list is empty");
    L13:
        ((kotlinx.coroutines.s) this.f2549c).N(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L15:
        ArrayList r20 = new ArrayList();
        ArrayList r21 = this.d.f2759a;
        Application r22 = this.f;
        Iterator r23 = r21.iterator();
    L17:
        if (r23.hasNext() == false) goto L53;
        t r110 = (t) r23.next();
        String r111 = r110.f2757a;
        File r112 = new File(r22.getFilesDir(), r110.f2758b);
        if (TextUtils.isEmpty(r111) == false) goto L21;
        ArrayList r113 = null;
        r23 = r23;
    L35:
        ArrayList r24 = new ArrayList();
        if (r113 == null) goto L47;
        Iterator r25 = r113.iterator();
    L39:
        if (r25.hasNext() == false) goto L47;
        Pair r26 = (Pair) r25.next();
        if (r17.contains(r26.first) == false) goto L39;
        String r114 = ug.a.c(new StringBuilder("add "), (String) r26.first, " into update list.", "AppletResourceLoader");
        t0.d r115 = com.bytedance.ai.utils.c.f2846a;
        if (r115 == null) goto L45;
        r115.d("AppletResourceLoader", r114);
    L45:
        r24.add(new CheckRequestBodyModel.TargetChannel((String) r26.first));
    L47:
        if (r24.isEmpty() == true) goto L51;
        Ref.BooleanRef r27 = new Ref.BooleanRef();
        kotlinx.coroutines.s r28 = j0.a();
        r20.add(r28);
        com.bytedance.geckox.g r116 = com.bytedance.geckox.h.a(r111);
        if (r116 == null) goto L52;
        r116.b(MapsKt.mapOf(TuplesKt.to(r111, r24)), new OptionCheckUpdateParams().setListener(new p(r27, r28, 1)));
        goto L51
    L52:
        Boxing.boxBoolean(r28.N(Boxing.boxBoolean(true)));
        r11 = true;
    L51:
        r11 = true;
        goto L17
    L21:
        File r117 = new File(r112, r111);
        String[] r118 = r117.list();
        ArrayList r119 = new ArrayList();
        if (r118 != null) goto L24;
    L34:
        r23 = r23;
        r113 = r119;
        goto L35
    L24:
        if (r118.length <= 0) goto L34;
        int r120 = r118.length;
        int r121 = 0;
    L26:
        if (r121 >= r120) goto L34;
        String r29 = r118[r121];
        File r30 = new File(r117, r29);
        if (r30.isDirectory() == false) goto L33;
        Long r31 = com.bytedance.geckox.utils.d.a(r30);
        if (r31 == null) goto L33;
        r119.add(new Pair(r29, r31));
    L33:
        r121 = r121 + 1;
        r23 = r23;
        goto L26
    L53:
        boolean r32 = r11;
        Ref.BooleanRef r33 = new Ref.BooleanRef();
        r33.element = r32;
        this.f2547a = r33;
        this.f2548b = r32 ? 1 : 0;
        r13 = j0.c(r20, this);
        if (r13 != r5) goto L56;
        return r5;
    L56:
        r12 = r33;
        goto L57
    }
}
