package com.obric.memorydata.memory.ui.settings;

import com.obric.aiproactive.api.ProactiveShortcutRequestResult;
import com.obric.aiproactive.api.ProactiveShortcutState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutDefaultTrigger;", "", "readTriggered", "Lkotlin/Function0;", "", "writeTriggered", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "isHandled", "onUserChoice", "triggerIfNeeded", "Lcom/obric/aiproactive/api/ProactiveShortcutRequestResult;", "coordinator", "Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutCoordinator;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Boolean> f11499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<Boolean, Unit> f11500b;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11501a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11502b = null;

        static {
            int[] r0 = new int[ProactiveShortcutState.values().length];
            r0[ProactiveShortcutState.RESTRICTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[ProactiveShortcutState.UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r0[ProactiveShortcutState.ACTIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r0[ProactiveShortcutState.INACTIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            f11501a = r0;
            int[] r1 = new int[ProactiveShortcutRequestResult.values().length];
            r1[ProactiveShortcutRequestResult.RESTRICTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L30:
            r1[ProactiveShortcutRequestResult.UNSUPPORTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L22:
            r1[ProactiveShortcutRequestResult.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            f11502b = r1;
        }
    }

    public p(Function0<Boolean> r3, Function1<? super Boolean, Unit> r4) {
        Function0<Boolean> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function1<Boolean, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "readTriggered");
        Intrinsics.checkNotNullParameter(r6, "writeTriggered");
        this.f11499a = r5;
        this.f11500b = r6;
    }

    public final synchronized ProactiveShortcutRequestResult a(o r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "coordinator");     // Catch: Throwable -> L31
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f11499a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ProactiveShortcutState r0 = r6.a();     // Catch: Throwable -> L31
        int r1 = a.f11501a[r0.ordinal()];     // Catch: Throwable -> L31
        if (r1 != 1) goto L11;
    L29:
        monitor-exit(this);
        return null;
    L11:
        if (r1 == 2) goto L29;
        if (r1 != 3) goto L15;
        this.f11500b.invoke(true);     // Catch: Throwable -> L31
        ProactiveShortcutRequestResult r7 = ProactiveShortcutRequestResult.ALREADY_ACTIVE;     // Catch: Throwable -> L31
        monitor-exit(this);
        return r7;
    L15:
        if (r1 != 4) goto L25;
        this.f11500b.invoke(true);     // Catch: Throwable -> L31
        ProactiveShortcutRequestResult r8 = r6.b();     // Catch: Throwable -> L31
        int r2 = a.f11502b[r8.ordinal()];     // Catch: Throwable -> L31
        if (r2 == 1) goto L21;
        if (r2 == 2) goto L21;
        if (r2 == 3) goto L21;
    L22:
        monitor-exit(this);
        return r8;
    L21:
        this.f11500b.invoke(false);     // Catch: Throwable -> L31
        goto L22
    L25:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public final boolean a() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f11499a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final synchronized void b() {
        monitor-enter(this);
        this.f11500b.invoke(true);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
