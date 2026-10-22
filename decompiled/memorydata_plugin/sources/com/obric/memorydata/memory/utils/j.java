package com.obric.memorydata.memory.utils;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ0\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/utils/PinShortcutTerminalCoordinator;", "", "pendingRequests", "Lcom/obric/memorydata/memory/utils/PendingShortcutRequests;", "<init>", "(Lcom/obric/memorydata/memory/utils/PendingShortcutRequests;)V", "onSystemCallback", "", "shortcutId", "", PendingPersonalInfoNotificationTask.KEY_GENERATION, "", "operations", "Lcom/obric/memorydata/memory/utils/PinShortcutTerminalOperations;", "onFallback", "dispatch", "action", "Lcom/obric/memorydata/memory/utils/PinShortcutTerminalAction;", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/memory/utils/PinShortcutTerminalSource;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f11547a;

    public j(h r2) {
        Intrinsics.checkNotNullParameter(r2, "pendingRequests");
        this.f11547a = r2;
    }

    private final void a(PinShortcutTerminalAction r12, PinShortcutTerminalSource r13, String r14, long r15, l r17) {
        l r0 = (l) ZeusTransformUtils.wrapperContextForParams(r17, l.class, "com.obric.memorydata.plugin");
        if (r12 != PinShortcutTerminalAction.IGNORE) goto L5;
        return;
    L5:
        boolean r1 = r0.a();
        i r2 = this.f11547a.a(r14, r15, r13, r12);
        PinShortcutTerminalAction r3 = r2.a();
        if (r3 != PinShortcutTerminalAction.IGNORE) goto L9;
        return;
    L9:
        if (r3 == PinShortcutTerminalAction.RECONCILE_OFF) goto L11;
    L13:
        boolean r9 = false;
    L15:
        if (r3 != PinShortcutTerminalAction.DELIVER_UI_COMPLETION) goto L17;
        boolean r7 = true;
    L19:
        if (r3 != PinShortcutTerminalAction.RECONCILE_OFF) goto L21;
        boolean r8 = true;
    L22:
        r0.a(new k(r14, r15, r1, r7, r8, r9));
        return;
    L21:
        r8 = false;
        goto L22
    L17:
        r7 = false;
        goto L19
    L11:
        if (r2.b() != PinShortcutSupersedeProvenance.USER_DISABLE) goto L13;
        r9 = true;
        goto L15
    }

    public final void a(String r8, long r9, l r11) {
        l r6 = (l) ZeusTransformUtils.wrapperContextForParams(r11, l.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "shortcutId");
        Intrinsics.checkNotNullParameter(r6, "operations");
        a(this.f11547a.b(r8, r9), PinShortcutTerminalSource.SYSTEM_CALLBACK, r8, r9, r6);
    }

    public final void b(String r8, long r9, l r11) {
        l r6 = (l) ZeusTransformUtils.wrapperContextForParams(r11, l.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "shortcutId");
        Intrinsics.checkNotNullParameter(r6, "operations");
        a(this.f11547a.a(r8, r9), PinShortcutTerminalSource.FALLBACK, r8, r9, r6);
    }
}
