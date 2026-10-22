package com.bytedance.ai.resource;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/resource/AIManager$AppletFullReadyResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager$ensureAppletFullReady$2", f = "AIManager.kt", i = {}, l = {329, 331, 341, 357}, m = "invokeSuspend", n = {}, s = {})
final class AIManager$ensureAppletFullReady$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AIManager.a>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ Map<String, Object> $extraInfo;
    final /* synthetic */ long $versionCode;
    int label;

    public AIManager$ensureAppletFullReady$2(String r1, long r10, Map<String, Object> r11, Continuation<? super AIManager$ensureAppletFullReady$2> r12) {
        this.$appletId = r1;
        this.$versionCode = r10;
        this.$extraInfo = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIManager$ensureAppletFullReady$2(this.$appletId, this.$versionCode, this.$extraInfo, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AIManager.a> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        ResultKt.throwOnFailure(r12);
    L40:
        return r12;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r12);
    L44:
        Applet r13 = (Applet) r12;
        if (r13 == null) goto L48;
        return new AIManager.a.b(r13);
    L48:
        return new AIManager.a.C0046a(7, "failed to load full applet from gecko or remote. appletId: " + this.$appletId);
    L12:
        ResultKt.throwOnFailure(r12);
    L20:
        AIPackage r14 = (AIPackage) r12;
        if ((r14 instanceof Applet) == false) goto L28;
        Applet r10 = (Applet) r14;
        if (r10.y != AIPackage.PackageStatus.READY) goto L28;
        if (r10.c != this.$versionCode) goto L28;
        com.bytedance.ai.utils.g.a.i("AIManager", "ensureAppletFullReady hit READY cache. appletId: " + this.$appletId + ", versionCode: " + r10.c);
        return new AIManager.a.b(r10);
    L28:
        AIManager r11 = AIManager.a;
        if (AIManager.g(this.$appletId) == true) goto L41;
        n5.a.a.getClass();
        com.bytedance.ai.utils.g r15 = com.bytedance.ai.utils.g.a;
        StringBuilder r16 = new StringBuilder("ensureAppletFullReady wait full install. appletId: ");
        r16.append(this.$appletId);
        r16.append(", currentStatus: ");
        Long r17 = null;
        if (r14 == null) goto L33;
        AIPackage.PackageStatus r18 = r14.y;
    L34:
        r16.append(r18);
        r16.append(", expectedVersionCode: ");
        r16.append(this.$versionCode);
        r16.append(", cachedVersionCode: ");
        if (r14 == null) goto L37;
        r17 = Boxing.boxLong(r14.c);
    L37:
        r16.append(r17);
        r15.i("AIManager", r16.toString());
        String r19 = this.$appletId;
        Deferred r110 = AIManager.J(r19, r19, this.$versionCode);
        this.label = 4;
        r12 = r110.await(this);
        if (r12 != r0) goto L40;
        return r0;
    L33:
        r18 = null;
        goto L34
    L41:
        AIManager r111 = AIManager.a;
        String r20 = this.$appletId;
        Map<String, Object> r21 = this.$extraInfo;
        this.label = 3;
        r12 = r111.C(r20, r21, this);
        if (r12 != r0) goto L44;
        return r0;
    L13:
        ResultKt.throwOnFailure(r12);
    L17:
        AIPackage.AIPackageType r22 = AIPackage.AIPackageType.APPLET;
        AIManager r23 = AIManager.a;
        String r24 = this.$appletId;
        String r25 = this.$appletId;
        this.label = 2;
        r12 = r23.k(r24, r25, r22, null, this);
        if (r12 != r0) goto L20;
        return r0;
    L14:
        ResultKt.throwOnFailure(r12);
        AIManager r112 = AIManager.a;
        this.label = 1;
        if (r112.i(this) != r0) goto L17;
        return r0;
    }
}
