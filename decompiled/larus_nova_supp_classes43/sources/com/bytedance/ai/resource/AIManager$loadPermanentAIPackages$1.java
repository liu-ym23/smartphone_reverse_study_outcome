package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager$loadPermanentAIPackages$1", f = "AIManager.kt", i = {1}, l = {1227, 1231, 1259}, m = "invokeSuspend", n = {"permanentInstallList"}, s = {"L$0"})
final class AIManager$loadPermanentAIPackages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public static final class a implements AIPackageManager.b {
        public a() {
        }

        @Override // com.bytedance.ai.resource.AIPackageManager.b
        public final void a(AIPackage r10, String r11, String r12, AIPackage.AIPackageType r13, int r14, String r15) {
            Intrinsics.checkNotNullParameter(r11, "packageName");
            Intrinsics.checkNotNullParameter(r12, BdpAwemeConstant.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r13, "packageType");
            if (r14 != 0) goto L6;
            if (r10 == null) goto L6;
            com.bytedance.ai.utils.g.a.i("applet_lifecycle", "<initApplet><" + r11 + ", " + r12 + '>' + r13.name() + " install success");
            AIManager r16 = AIManager.a;
            AIManager.e(r10, false);
            return;
        L6:
            com.bytedance.ai.utils.g r17 = com.bytedance.ai.utils.g.a;
            r17.e("AIManager", "failed to install permanent AI Package with packageName: " + r11 + ", appId: " + r12);
            r17.i("applet_lifecycle", "<initApplet><" + r11 + ", " + r12 + '>' + r13.name() + " install failed");
        }
    }

    public AIManager$loadPermanentAIPackages$1(Continuation<? super AIManager$loadPermanentAIPackages$1> r10) {
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r10) {
        return new AIManager$loadPermanentAIPackages$1(r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r10);
    L53:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        List<? extends AIPackageManager.a> r11 = (List) this.L$0;
        ResultKt.throwOnFailure(r10);
    L28:
        List r12 = (List) r10;
        ConcurrentHashMap r13 = new ConcurrentHashMap();
        Iterator<T> r14 = r11.iterator();
    L30:
        if (r14.hasNext() == false) goto L39;
        AIPackageManager.a r15 = (AIPackageManager.a) r14.next();
        if (AIManager.l == true) goto L33;
        n5.a.C0181a r16 = n5.a.a;
        r15.getPackageName();
        r16.getClass();
        int r17 = AIPackage.J;
        r13.put(AIPackage.a.a(r15.getPackageName(), r15.getAppId()), r15);
        goto L30
    L33:
        Set<String> r18 = AIManager.n;
        if ((!r18.isEmpty()) == false) goto L30;
        if (r18.contains(r15.getPackageName()) == false) goto L30;
        int r19 = AIPackage.J;
        r13.put(AIPackage.a.a(r15.getPackageName(), r15.getAppId()), r15);
        goto L30
    L39:
        Iterator r20 = r12.iterator();
    L41:
        if (r20.hasNext() == false) goto L44;
        AIPackage r21 = (AIPackage) r20.next();
        AIManager r22 = AIManager.a;
        AIManager.e(r21, false);
        r13.remove(r21.d());
        goto L41
    L44:
        if ((!r13.isEmpty()) == false) goto L53;
        ArrayList r23 = new ArrayList();
        Iterator r24 = r13.entrySet().iterator();
    L47:
        if (r24.hasNext() == false) goto L49;
        r23.add(((Map.Entry) r24.next()).getValue());
        goto L47
    L49:
        AIPackageManager r25 = AIPackageManager.a;
        a r26 = new a();
        this.L$0 = null;
        this.label = 3;
        if (r25.k(r23, r26, this) != r0) goto L53;
        return r0;
    L11:
        ResultKt.throwOnFailure(r10);
    L22:
        r11 = (List) r10;
        if (r11.isEmpty() == false) goto L25;
        com.bytedance.ai.utils.g.a.w("AIManager", "permanent package list is empty");
        goto L53
    L25:
        AIPackageManager r27 = AIPackageManager.a;
        this.L$0 = r11;
        this.label = 2;
        r27.getClass();
        r10 = AIPackageStorage.a.m(r11, true, this);
        if (r10 != r0) goto L28;
        return r0;
    L12:
        ResultKt.throwOnFailure(r10);
        com.bytedance.ai.utils.g.a.d("AIManager", "load AIPackage in permanent list");
        AIPackageManager r28 = AIPackageManager.a;
        this.label = 1;
        r28.getClass();
        com.bytedance.ai.resource.core.d r29 = AIPackageManager.b;
        monitor-enter(r29);
    L54:
        th = move-exception;
        throw th;
    L15:
        if (((ArrayList) r29.a).isEmpty() == false) goto L17;
        r29.b();     // Catch: Throwable -> L54
    L17:
        List r30 = CollectionsKt.toList(r29.a);     // Catch: Throwable -> L54
        monitor-exit(r29);
        if (r30 != r0) goto L21;
        return r0;
    L21:
        r10 = r30;
        goto L22
    }
}
