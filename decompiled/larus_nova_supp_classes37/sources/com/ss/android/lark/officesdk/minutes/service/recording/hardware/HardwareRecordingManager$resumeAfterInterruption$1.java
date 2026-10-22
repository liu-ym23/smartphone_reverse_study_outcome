package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 1, 1, 2, 3, 3, 4, 5, 5, 6}, l = {882, 706, 709, 712, 718, 723, 736}, m = "resumeAfterInterruption", n = {"expectedState", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$1", "L$0", "L$0", "L$1", "L$0"})
final class HardwareRecordingManager$resumeAfterInterruption$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$resumeAfterInterruption$1(d r1, Continuation<? super HardwareRecordingManager$resumeAfterInterruption$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r13) {
        this.result = r13;
        this.label |= Integer.MIN_VALUE;
        d r14 = this.this$0;
        r14.getClass();
        int r5 = this.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r5 - Integer.MIN_VALUE;
        HardwareRecordingManager$resumeAfterInterruption$1 r0 = this;
    L6:
        Object r6 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r0.label) {
            case 0: goto L66;
            case 1: goto L34;
            case 2: goto L31;
            case 3: goto L28;
            case 4: goto L25;
            case 5: goto L28;
            case 6: goto L10;
            case 7: goto L28;
            default: goto L9;
        };
    L10:
        e r2 = (e) r0.L$1;
        kotlinx.coroutines.sync.a r1 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L19
        a r8 = (a) r6;     // Catch: Throwable -> L19
        if (Intrinsics.areEqual(r8, a.c.a) == false) goto L14;
    L23:
        r14.a = e.a(r2, HardwareRecordingSessionState.RECORDING, null, 111);     // Catch: Throwable -> L19
        throw null;     // Catch: Throwable -> L19
    L14:
        if ((r8 instanceof a.b) == true) goto L23;
        if ((r8 instanceof a.C0052a) == false) goto L22;
        lvb.a.b(null, "[resumeAfterInterruption] resume OfficeSDK failed, session=" + r2 + ", result=" + r8);     // Catch: Throwable -> L19
        throw null;     // Catch: Throwable -> L19
    L22:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L19
    L25:
        e r15 = (e) r0.L$1;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L19
    L52:
        cvb.a r9 = (cvb.a) r6;     // Catch: Throwable -> L19
        if ((r9 instanceof cvb.a.C0133a) == false) goto L55;
        lvb.a.b(null, "[resumeAfterInterruption] resume hardware failed, session=" + r15 + ", result=" + r9);     // Catch: Throwable -> L19
        throw null;     // Catch: Throwable -> L19
    L55:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L19
    L28:
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L19
    L38:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r4.unlock(null);
        return Unit.INSTANCE;
    L31:
        r15 = (e) r0.L$1;
        kotlinx.coroutines.sync.a r10 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L62
    L46:
        b r11 = (b) r6;     // Catch: Throwable -> L62
        if (r11 == null) goto L58;
        long r12 = r15.d;     // Catch: Throwable -> L62
        r0.L$0 = r10;     // Catch: Throwable -> L62
        r0.L$1 = r15;     // Catch: Throwable -> L62
        r0.label = 4;     // Catch: Throwable -> L62
        r6 = r11.resumeRecord();     // Catch: Throwable -> L62
        if (r6 != r7) goto L52;
        return r7;
    L58:
        lvb.a.b(null, "[resumeAfterInterruption] missing hardware adapter, session=" + r15);     // Catch: Throwable -> L62
        throw null;     // Catch: Throwable -> L62
    L34:
        r10 = (kotlinx.coroutines.sync.a) r0.L$1;
        HardwareRecordingSessionState r17 = (HardwareRecordingSessionState) r0.L$0;
        ResultKt.throwOnFailure(r6);
        e r18 = r14.a;     // Catch: Throwable -> L62
        if (r18 != null) goto L41;
        r4 = r10;
        goto L38
    L41:
        if (r18.e != r17) goto L60;
        r0.L$0 = r10;     // Catch: Throwable -> L62
        r0.L$1 = r18;     // Catch: Throwable -> L62
        r0.label = 2;     // Catch: Throwable -> L62
        Object r19 = r14.n(r18, "resumeAfterInterruption", r0);     // Catch: Throwable -> L62
        if (r19 == r7) goto L69;
        r6 = r19;
        r15 = r18;
        goto L46
    L69:
        return r7;
    L60:
        lvb.a.e(null, "[resumeAfterInterruption] ignore unexpected session=" + r18 + ", expectedState=" + r17);     // Catch: Throwable -> L62
        throw null;     // Catch: Throwable -> L62
    L66:
        ResultKt.throwOnFailure(r6);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 1;
        throw null;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L62:
        th = th;
        kotlinx.coroutines.sync.a r20 = "[resumeAfterInterruption] resume OfficeSDK failed, session=";
    L64:
        r20.unlock(null);
        throw th;
    L19:
        th = th;
        r20 = r0;
        goto L64
    L5:
        r0 = new HardwareRecordingManager$resumeAfterInterruption$1(r14, this);
        goto L6
    }
}
