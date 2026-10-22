package com.obric.memorydata.screencapture.service;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/screencapture/service/InternalMemoryAccessibilityService;", "Lcom/obric/memorydata/screencapture/service/IMemoryAccessibilityDelegate;", "<init>", "()V", "lastEventPackageName", "", "service", "Landroid/accessibilityservice/AccessibilityService;", "onAccessibilityEvent", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onInterrupt", "onDestroy", "onServiceConnected", "setMinimumIntervalObric", ObricMemoryConstants.KEY_PACKAGE_NAME, "eventType", "", "interval", "Companion", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements IMemoryAccessibilityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12812a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12813b;
    private AccessibilityService c;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/screencapture/service/InternalMemoryAccessibilityService$Companion;", "", "<init>", "()V", "TAG", "", "MIN_INTERVAL", "", "register", "", "unregister", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a() {
            MemoryAccessibilityRegistry.registerDelegate((IMemoryAccessibilityDelegate) ZeusTransformUtils.preCheckCast(new b(), IMemoryAccessibilityDelegate.class, "com.obric.memorydata.plugin"));
        }

        public final void b() {
            MemoryAccessibilityRegistry.unregisterDelegate();
        }
    }

    static {
        f12812a = new a(null);
    }

    public b() {
        this.f12813b = "";
    }

    private final void a(String r7, int r8, int r9) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        AccessibilityService r6 = this.c;
        if (r6 != null) goto L17;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryAccessibilityService", "setMinimumIntervalObric failed: service is null", null, 4, null);
        return;
    L17:
        ao.call(r6, "setMinumumIntervalObric", new Object[]{r7, Integer.valueOf(r8), Integer.valueOf(r9)});     // Catch: Throwable -> L14
        RunLog.INSTANCE.debug("MemoryAccessibilityService", "setMinimumIntervalObric called successfully");     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        RunLog.INSTANCE.error("MemoryAccessibilityService", "Failed to call setMinimumIntervalObric", th);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void onAccessibilityEvent(AccessibilityEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        CharSequence r0 = r4.getPackageName();
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
    L8:
        if (Intrinsics.areEqual(this.f12813b, r1) == true) goto L10;
        a(r1, 2048, 1000);
        this.f12813b = r1;
    L10:
        RunLog.INSTANCE.debugLocalTest("MemoryAccessibilityService", "onAccessibilityEvent", r4.toString());
        com.obric.memorydata.screencapture.accessibility.a.a(com.obric.memorydata.screencapture.accessibility.a.f12771a, r4, null, 2, null);
        return;
    L6:
        r1 = "";
        goto L8
    }

    public void onDestroy() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryAccessibilityService", "onDestroy", false, 4, null);
        com.obric.memorydata.screencapture.accessibility.a.f12771a.a(null);
        this.c = null;
    }

    public void onInterrupt() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryAccessibilityService", "onInterrupt", false, 4, null);
    }

    public void onServiceConnected(AccessibilityService r3) {
        AccessibilityService r4 = (AccessibilityService) ZeusTransformUtils.wrapperContextForParams(r3, AccessibilityService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "service");
        this.c = r4;
        RunLog.INSTANCE.debug("MemoryAccessibilityService", "onServiceConnected");
        com.obric.memorydata.screencapture.accessibility.a.f12771a.a(r4);
    }
}
