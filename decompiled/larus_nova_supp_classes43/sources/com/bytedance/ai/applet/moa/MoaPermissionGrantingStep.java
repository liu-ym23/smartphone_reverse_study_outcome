package com.bytedance.ai.applet.moa;

import android.content.Context;
import com.bytedance.ai.applet.granting.GrantStatus;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.bridge.remote.model.ScopePermissionInfo;
import com.bytedance.ai.model.AppletRuntimeManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class MoaPermissionGrantingStep implements n {
    public static final /* synthetic */ int c = 0;
    public final u2.f a;
    public final u2.k b;

    public static final class a {
    }

    public static final class b implements Function1<Boolean, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;

        public b(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10) {
            boolean r11 = ((Boolean) r10).booleanValue();
            if (this.a.isActive() == false) goto L6;
            Boolean r12 = Boolean.valueOf(r11);
            this.a.resumeWith(Result.constructor-impl(r12));
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final void a(o r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    public MoaPermissionGrantingStep(u2.f r10, u2.k r11) {
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r11, "relatedData");
        this.a = r10;
        this.b = r11;
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final Object c(o r10, Continuation<? super MoaStepResult> r11) {
        if ((r11 instanceof MoaPermissionGrantingStep$requestConfirmation$1) == false) goto L7;
        MoaPermissionGrantingStep$requestConfirmation$1 r0 = (MoaPermissionGrantingStep$requestConfirmation$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        g2.b r15 = (g2.b) r0.L$2;
        String r16 = (String) r0.L$1;
        o r17 = (o) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L39:
        if (((Boolean) r12).booleanValue() == false) goto L42;
        return MoaStepResult.CONTINUE;
    L42:
        if (this.a.f() == false) goto L45;
        return MoaStepResult.REFUSED;
    L45:
        return MoaStepResult.CONTINUE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        String r18 = this.b.c();
        if (r18 == null) goto L47;
        Context r19 = null;
        if ((!StringsKt.isBlank(r18)) == true) goto L20;
        r18 = null;
    L20:
        if (r18 == null) goto L47;
        String r20 = com.bytedance.ai.applet.permission.h.b(r18);
        if (r20 == null) goto L25;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r21 = AppletRuntimeManager.d;
        if (r21 == null) goto L29;
        r0.L$0 = r10;
        r0.L$1 = r20;
        r0.L$2 = r21;
        r0.label = 1;
        kotlinx.coroutines.j r22 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r22.C();
        WeakReference<Context> r23 = r10.d;
        if (r23 == null) goto L33;
        r19 = r23.get();
    L33:
        r21.y(r19, r20, new b(r22));
        r12 = r22.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L36:
        if (r12 != r13) goto L39;
        return r13;
    L29:
        return MoaStepResult.FAILED;
    L25:
        return MoaStepResult.FAILED;
    L47:
        return MoaStepResult.FAILED;
    L7:
        r0 = new MoaPermissionGrantingStep$requestConfirmation$1(this, r11);
        goto L8
    }

    public final Object b(String r10, String r11, Continuation<? super Result<? extends GrantStatus>> r12) {
        if ((r12 instanceof MoaPermissionGrantingStep$fetchPermissionStatus$1) == false) goto L7;
        MoaPermissionGrantingStep$fetchPermissionStatus$1 r0 = (MoaPermissionGrantingStep$fetchPermissionStatus$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        r11 = (String) r0.L$1;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
        Object r16 = ((Result) r13).unbox-impl();
    L18:
        if (Result.isSuccess-impl(r16) == false) goto L40;
        Iterator r17 = ((List) r16).iterator();     // Catch: Throwable -> L37
    L21:
        if (r17.hasNext() == false) goto L25;
        Object r18 = r17.next();     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(((AppletPermissionDetail) r18).getAppletId(), r10) == false) goto L21;
    L26:
        AppletPermissionDetail r19 = (AppletPermissionDetail) r18;     // Catch: Throwable -> L37
        if (r19 == null) goto L36;
        Map<String, ScopePermissionInfo> r20 = r19.getScopesStatus();     // Catch: Throwable -> L37
        if (r20 == null) goto L34;
        ScopePermissionInfo r21 = r20.get(r11);     // Catch: Throwable -> L37
        if (r21 == null) goto L34;
        GrantStatus.a r22 = GrantStatus.Companion;     // Catch: Throwable -> L37
        Integer r23 = r21.getGrantStatus();     // Catch: Throwable -> L37
        r22.getClass();     // Catch: Throwable -> L37
        return Result.constructor-impl(GrantStatus.a.a(r23));
    L34:
        throw new IllegalStateException(("Permission status is missing for " + r11).toString());     // Catch: Throwable -> L37
    L36:
        throw new IllegalStateException(("Permission detail is missing for " + r10).toString());     // Catch: Throwable -> L37
    L25:
        r18 = null;
    L37:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        return Result.constructor-impl(r16);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        UserAuthService r25 = UserAuthService.a;
        List r26 = CollectionsKt.listOf(r10);
        List r27 = CollectionsKt.listOf(r11);
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.label = 1;
        r16 = UserAuthService.p(r26, r27, r0);
        if (r16 != r14) goto L18;
        return r14;
    L7:
        r0 = new MoaPermissionGrantingStep$fetchPermissionStatus$1(this, r12);
        goto L8
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final Object g(o r10, boolean r11, Continuation<? super MoaStepResult> r12) {
        if ((r12 instanceof MoaPermissionGrantingStep$handleAction$1) == false) goto L7;
        MoaPermissionGrantingStep$handleAction$1 r0 = (MoaPermissionGrantingStep$handleAction$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L18;
        if (r15 == 1) goto L17;
        if (r15 == 2) goto L16;
        if (r15 != 3) goto L15;
        ResultKt.throwOnFailure(r13);
        Object r16 = ((Result) r13).unbox-impl();
    L61:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L64;
        com.bytedance.ai.utils.g.a.e("MoaPermissionGrantingStep", "Failed to post granted permission status", r17);
        return MoaStepResult.FAILED;
    L64:
        if (((Boolean) r16).booleanValue() == true) goto L70;
        return MoaStepResult.FAILED;
    L70:
        return MoaStepResult.REQUIRES_CONFIRMATION;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r13);
        Object r18 = ((Result) r13).unbox-impl();
    L43:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L46;
        com.bytedance.ai.utils.g.a.e("MoaPermissionGrantingStep", "Failed to post denied permission status", r19);
        return MoaStepResult.FAILED;
    L46:
        if (((Boolean) r18).booleanValue() == true) goto L50;
        return MoaStepResult.FAILED;
    L50:
        if (this.a.f() == false) goto L53;
        return MoaStepResult.REFUSED;
    L53:
        return MoaStepResult.CONTINUE;
    L17:
        r11 = r0.Z$0;
        String r20 = (String) r0.L$1;
        String r21 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
        Object r110 = ((Result) r13).unbox-impl();
    L32:
        Throwable r22 = Result.exceptionOrNull-impl(r110);
        if (r22 != null) goto L71;
        GrantStatus r111 = (GrantStatus) r110;
        if (r11 == false) goto L37;
        GrantStatus r112 = GrantStatus.GRANTED;
        if (r111 == r112) goto L70;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
        r16 = d(r20, r21, r112, r0);
        if (r16 != r14) goto L61;
        return r14;
    L37:
        if (r111 == GrantStatus.GRANTED) goto L39;
        GrantStatus r113 = GrantStatus.DENIED;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        r18 = d(r20, r21, r113, r0);
        if (r18 != r14) goto L43;
        return r14;
    L39:
        return MoaStepResult.REFUSED;
    L71:
        com.bytedance.ai.utils.g.a.e("MoaPermissionGrantingStep", "Failed to query permission status", r22);
        return MoaStepResult.FAILED;
    L18:
        ResultKt.throwOnFailure(r13);
        String r114 = this.b.c();
        if (r114 != null) goto L21;
    L73:
        com.bytedance.ai.utils.g.a.e("MoaPermissionGrantingStep", "scopeName is empty");
        return MoaStepResult.FAILED;
    L21:
        if ((!StringsKt.isBlank(r114)) == false) goto L23;
        r21 = r114;
    L24:
        if (r21 == null) goto L73;
        r20 = r10.a.d();
        if (r20 != null) goto L29;
        r20 = "";
    L29:
        r0.L$0 = r21;
        r0.L$1 = r20;
        r0.Z$0 = r11;
        r0.label = 1;
        r110 = b(r20, r21, r0);
        if (r110 != r14) goto L32;
        return r14;
    L23:
        r21 = null;
    L7:
        r0 = new MoaPermissionGrantingStep$handleAction$1(this, r12);
        goto L8
    }

    public final Object d(String r10, String r11, GrantStatus r12, Continuation<? super Result<Boolean>> r13) {
        if ((r13 instanceof MoaPermissionGrantingStep$postPermissionStatus$1) == false) goto L7;
        MoaPermissionGrantingStep$postPermissionStatus$1 r0 = (MoaPermissionGrantingStep$postPermissionStatus$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
        return ((Result) r14).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        UserAuthService r17 = UserAuthService.a;
        Integer r18 = Boxing.boxInt(u2.g.a(r12));
        r0.label = 1;
        Object r19 = UserAuthService.r(r10, r11, r18, r0);
        if (r19 != r15) goto L18;
        return r15;
    L18:
        return r19;
    L7:
        r0 = new MoaPermissionGrantingStep$postPermissionStatus$1(this, r13);
        goto L8
    }
}
