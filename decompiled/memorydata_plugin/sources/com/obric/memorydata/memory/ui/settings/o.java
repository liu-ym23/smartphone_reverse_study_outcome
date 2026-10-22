package com.obric.memorydata.memory.ui.settings;

import com.obric.aiproactive.api.ProactiveShortcutCompletion;
import com.obric.aiproactive.api.ProactiveShortcutRequestResult;
import com.obric.aiproactive.api.ProactiveShortcutState;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.obric.memorydata.memory.utils.PinShortcutRequestSupport;
import com.obric.memorydata.memory.utils.PinShortcutStartResult;
import com.obric.memorydata.memory.utils.PinShortcutSupersedeProvenance;
import com.obric.memorydata.memory.utils.PinnedShortcutState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u000eJ\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutCoordinator;", "", "isEnterprise", "Lkotlin/Function0;", "", "gateway", "Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutGateway;", "optOutStore", "Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutOptOutStore;", "optInRequests", "Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutOptInRequests;", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutGateway;Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutOptOutStore;Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutOptInRequests;)V", "queryState", "Lcom/obric/aiproactive/api/ProactiveShortcutState;", "requestByUser", "Lcom/obric/aiproactive/api/ProactiveShortcutRequestResult;", "resolvePinResult", "Lcom/obric/aiproactive/api/ProactiveShortcutCompletion;", PendingPersonalInfoNotificationTask.KEY_GENERATION, "", "disableByUser", "reconcileSupersededPin", "persistUserOptOutIfInactive", "disableByPolicy", "recoverByPolicy", "featureEnabled", "supersedePinRequests", "", "provenance", "Lcom/obric/memorydata/memory/utils/PinShortcutSupersedeProvenance;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Boolean> f11495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f11496b;
    private final s c;
    private final r d;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11497a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11498b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[PinShortcutRequestSupport.values().length];
            r0[PinShortcutRequestSupport.SUPPORTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L40:
            r0[PinShortcutRequestSupport.UNSUPPORTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L52:
            r0[PinShortcutRequestSupport.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L8:
            f11497a = r0;
            int[] r1 = new int[ProactiveShortcutUserRequestAction.values().length];
            r1[ProactiveShortcutUserRequestAction.RESTRICT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L42:
            r1[ProactiveShortcutUserRequestAction.REFRESH_ACTIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L54:
            r1[ProactiveShortcutUserRequestAction.ENABLE_DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L34:
            r1[ProactiveShortcutUserRequestAction.REQUEST_PIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L44:
            r1[ProactiveShortcutUserRequestAction.FAIL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L15:
            f11498b = r1;
            int[] r2 = new int[ProactiveShortcutPolicyAction.values().length];
            r2[ProactiveShortcutPolicyAction.DISABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L38:
            r2[ProactiveShortcutPolicyAction.REFRESH_ACTIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L46:
            r2[ProactiveShortcutPolicyAction.ENABLE_DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L36:
            r2[ProactiveShortcutPolicyAction.NO_OP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L20:
            c = r2;
        }
    }

    public o(Function0<Boolean> r3, q r4, s r5, r r6) {
        Function0<Boolean> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        q r8 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "isEnterprise");
        Intrinsics.checkNotNullParameter(r8, "gateway");
        Intrinsics.checkNotNullParameter(r5, "optOutStore");
        Intrinsics.checkNotNullParameter(r6, "optInRequests");
        this.f11495a = r7;
        this.f11496b = r8;
        this.c = r5;
        this.d = r6;
    }

    private final void a(PinShortcutSupersedeProvenance r4) {
        this.f11496b.a(r4, (Function1) ZeusTransformUtils.preCheckCast(new ProactiveShortcutCoordinator$supersedePinRequests$1(this.d), Function1.class, "com.obric.memorydata.plugin"));
    }

    public final ProactiveShortcutCompletion a(long r4) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f11495a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        ProactiveShortcutState r0 = t.b(false, this.f11496b.a());
        if (r0 != ProactiveShortcutState.ACTIVE) goto L12;
        if (this.d.c(r4) == false) goto L12;
        this.c.c();
    L12:
        return t.a(r0);
    L5:
        return ProactiveShortcutCompletion.NOT_PINNED;
    }

    public final ProactiveShortcutState a() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f11495a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        return ProactiveShortcutState.RESTRICTED;
    L7:
        return t.b(false, this.f11496b.a());
    }

    public final ProactiveShortcutState a(boolean r4) {
        boolean r0 = ((Boolean) ZeusTransformUtils.preCheckCast(this.f11495a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        this.f11496b.d();
        PinnedShortcutState r1 = this.f11496b.a();
        if (r0 == true) goto L11;
        if (r4 == false) goto L11;
        if (t.a(r1) == false) goto L11;
        if (this.c.a() == true) goto L11;
        this.c.b();
    L11:
        return t.b(r0, r1);
    }

    public final ProactiveShortcutRequestResult b() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f11495a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        ProactiveShortcutUserRequestAction r0 = t.a(false, this.f11496b.a());
        int r1 = a.f11498b[r0.ordinal()];
        if (r1 == 1) goto L37;
        if (r1 == 2) goto L34;
        if (r1 == 3) goto L31;
        if (r1 != 4) goto L15;
        PinShortcutRequestSupport r2 = this.f11496b.c();
        int r3 = a.f11497a[r2.ordinal()];
        if (r3 == 1) goto L28;
        if (r3 == 2) goto L39;
        if (r3 != 3) goto L25;
    L38:
        return ProactiveShortcutRequestResult.FAILED;
    L25:
        throw new NoWhenBranchMatchedException();
    L39:
        return ProactiveShortcutRequestResult.UNSUPPORTED;
    L28:
        if (this.f11496b.a((Function1) ZeusTransformUtils.preCheckCast(new ProactiveShortcutCoordinator$requestByUser$1(this.d), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new ProactiveShortcutCoordinator$requestByUser$2(this.d), Function1.class, "com.obric.memorydata.plugin")) != PinShortcutStartResult.STARTED_NEW) goto L38;
        return ProactiveShortcutRequestResult.STARTED_PIN_REQUEST;
    L15:
        if (r1 == 5) goto L38;
        throw new NoWhenBranchMatchedException();
    L31:
        if (this.f11496b.b() != PinnedShortcutState.ACTIVE) goto L38;
        this.c.c();
        return ProactiveShortcutRequestResult.ENABLED_EXISTING;
    L34:
        if (this.f11496b.b() != PinnedShortcutState.ACTIVE) goto L38;
        this.c.c();
        return ProactiveShortcutRequestResult.ALREADY_ACTIVE;
    L37:
        return ProactiveShortcutRequestResult.RESTRICTED;
    L5:
        return ProactiveShortcutRequestResult.RESTRICTED;
    }

    public final ProactiveShortcutState b(boolean r5) {
        boolean r0 = ((Boolean) ZeusTransformUtils.preCheckCast(this.f11495a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r0 == true) goto L21;
        if (r5 == false) goto L21;
        PinnedShortcutState r6 = this.f11496b.a();
        ProactiveShortcutPolicyAction r1 = t.a(false, true, this.c.a(), r6);
        int r2 = a.c[r1.ordinal()];
        if (r2 != 1) goto L9;
        a(PinShortcutSupersedeProvenance.POLICY);
        this.f11496b.d();
        PinnedShortcutState r4 = this.f11496b.a();
    L20:
        return t.b(false, r4);
    L9:
        if (r2 != 2) goto L11;
    L17:
        r4 = this.f11496b.b();
        goto L20
    L11:
        if (r2 == 3) goto L17;
        if (r2 != 4) goto L16;
        return t.b(false, r6);
    L16:
        throw new NoWhenBranchMatchedException();
    L21:
        a(PinShortcutSupersedeProvenance.POLICY);
        this.f11496b.d();
        return t.b(r0, this.f11496b.a());
    }

    public final ProactiveShortcutState c() {
        boolean r0 = ((Boolean) ZeusTransformUtils.preCheckCast(this.f11495a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r0 == false) goto L5;
        PinShortcutSupersedeProvenance r1 = PinShortcutSupersedeProvenance.POLICY;
    L6:
        a(r1);
        if (r0 == true) goto L9;
        this.f11496b.d();
        PinnedShortcutState r2 = this.f11496b.a();
        if (t.a(r2) == false) goto L14;
        this.c.b();
    L14:
        return t.b(false, r2);
    L9:
        return ProactiveShortcutState.RESTRICTED;
    L5:
        r1 = PinShortcutSupersedeProvenance.USER_DISABLE;
        goto L6
    }

    public final ProactiveShortcutState d() {
        boolean r0 = ((Boolean) ZeusTransformUtils.preCheckCast(this.f11495a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        a(PinShortcutSupersedeProvenance.POLICY);
        this.f11496b.d();
        return t.b(r0, this.f11496b.a());
    }
}
