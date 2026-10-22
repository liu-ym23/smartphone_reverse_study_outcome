package com.obric.widget.host.runtime;

import android.os.Messenger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0017J5\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0017J\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\rJ*\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\rJ=\u0010\"\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010#J=\u0010$\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010#J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\rJ\u0006\u0010(\u001a\u00020\u0003J\u0006\u0010)\u001a\u00020\u0003J?\u0010*\u001a\u0004\u0018\u00010\u00072\b\u0010+\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006-"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSession;", "", "invalidInstanceId", "", "<init>", "(I)V", "value", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "boundSnapshot", "getBoundSnapshot", "()Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "registeredMessengerSnapshot", "getRegisteredMessengerSnapshot", "", "suppressed", "getSuppressed", "()Z", "currentBoundSnapshot", "fallbackAppletId", "", "fallbackWidgetId", "fallbackInstanceId", "instanceIdOverride", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "currentMessengerSnapshot", "bindIfNeeded", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingDispatchResult;", "snapshot", "controller", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController;", "force", "registerMessengerIfNeeded", "messenger", "Landroid/os/Messenger;", "unbindCurrent", "(Ljava/lang/String;Ljava/lang/String;ILcom/obric/widget/host/runtime/WidgetRuntimeBindingController;Ljava/lang/Integer;)Lcom/obric/widget/host/runtime/WidgetRuntimeBindingDispatchResult;", "unregisterMessengerCurrent", "suppress", "", "clearSuppression", "boundInstanceId", "registeredMessengerInstanceId", "resolveSnapshot", "current", "(Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetRuntimeBindingSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetRuntimeBindingSession.kt\ncom/obric/widget/host/runtime/WidgetRuntimeBindingSession\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n1#2:181\n*E\n"})
public final class WidgetRuntimeBindingSession {
    private WidgetRuntimeBindingSnapshot boundSnapshot;
    private final int invalidInstanceId;
    private WidgetRuntimeBindingSnapshot registeredMessengerSnapshot;
    private boolean suppressed;

    public WidgetRuntimeBindingSession() {
        int r5 = 0;
        this(r5, 1, null);
    }

    public static /* synthetic */ WidgetRuntimeBindingDispatchResult bindIfNeeded$default(WidgetRuntimeBindingSession r5, WidgetRuntimeBindingSnapshot r10, WidgetRuntimeBindingController r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = false;
    L6:
        return r5.bindIfNeeded(r10, r11, r12);
    }

    public static /* synthetic */ WidgetRuntimeBindingSnapshot currentBoundSnapshot$default(WidgetRuntimeBindingSession r5, String r10, String r11, int r12, Integer r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = null;
    L6:
        return r5.currentBoundSnapshot(r10, r11, r12, r13);
    }

    public static /* synthetic */ WidgetRuntimeBindingSnapshot currentMessengerSnapshot$default(WidgetRuntimeBindingSession r5, String r10, String r11, int r12, Integer r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = null;
    L6:
        return r5.currentMessengerSnapshot(r10, r11, r12, r13);
    }

    public static /* synthetic */ WidgetRuntimeBindingDispatchResult registerMessengerIfNeeded$default(WidgetRuntimeBindingSession r5, WidgetRuntimeBindingSnapshot r10, Messenger r11, WidgetRuntimeBindingController r12, boolean r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = false;
    L6:
        return r5.registerMessengerIfNeeded(r10, r11, r12, r13);
    }

    private final WidgetRuntimeBindingSnapshot resolveSnapshot(WidgetRuntimeBindingSnapshot r5, String r10, String r11, int r12, Integer r13) {
        if (r5 == null) goto L8;
        String r14 = r5.getAppletId();
        if (r14 == null) goto L8;
        r10 = r14;
    L10:
        if (r5 == null) goto L15;
        String r15 = r5.getWidgetId();
        if (r15 == null) goto L15;
        r11 = r15;
    L17:
        if (r13 == null) goto L19;
        r12 = r13.intValue();
    L27:
        if (r12 != this.invalidInstanceId) goto L30;
        return null;
    L30:
        return new WidgetRuntimeBindingSnapshot(r10, r11, r12);
    L19:
        if (r5 == null) goto L23;
        Integer r16 = Integer.valueOf(r5.getInstanceId());
        if (r16.intValue() == this.invalidInstanceId) goto L23;
    L24:
        if (r16 == null) goto L27;
        r12 = r16.intValue();
    L23:
        r16 = null;
    L15:
        if (r11 != null) goto L17;
        return null;
    L8:
        if (r10 != null) goto L10;
        return null;
    }

    public static /* synthetic */ WidgetRuntimeBindingDispatchResult unbindCurrent$default(WidgetRuntimeBindingSession r10, String r11, String r12, int r13, WidgetRuntimeBindingController r14, Integer r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = null;
    L6:
        return r10.unbindCurrent(r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ WidgetRuntimeBindingDispatchResult unregisterMessengerCurrent$default(WidgetRuntimeBindingSession r10, String r11, String r12, int r13, WidgetRuntimeBindingController r14, Integer r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = null;
    L6:
        return r10.unregisterMessengerCurrent(r11, r12, r13, r14, r15);
    }

    public final WidgetRuntimeBindingDispatchResult bindIfNeeded(WidgetRuntimeBindingSnapshot r10, WidgetRuntimeBindingController r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "snapshot");
        if (this.suppressed == true) goto L5;
        if (r12 == false) goto L8;
    L11:
        this.boundSnapshot = r10;
        if (r11 != null) goto L14;
    L16:
        boolean r5 = false;
    L18:
        return new WidgetRuntimeBindingDispatchResult(r10, r5, null, 4, null);
    L14:
        if (r11.bind(r10) != true) goto L16;
        r5 = true;
        goto L18
    L8:
        if (Intrinsics.areEqual(this.boundSnapshot, r10) == false) goto L11;
        return new WidgetRuntimeBindingDispatchResult(r10, false, "alreadyBound");
    L5:
        return new WidgetRuntimeBindingDispatchResult(r10, false, "suppressed");
    }

    public final int boundInstanceId() {
        WidgetRuntimeBindingSnapshot r5 = this.boundSnapshot;
        if (r5 == null) goto L6;
        return r5.getInstanceId();
    L6:
        return this.invalidInstanceId;
    }

    public final boolean clearSuppression() {
        if (this.suppressed == true) goto L5;
        return false;
    L5:
        this.suppressed = false;
        return true;
    }

    public final WidgetRuntimeBindingSnapshot currentBoundSnapshot(String r10, String r11, int r12, Integer r13) {
        return resolveSnapshot(this.boundSnapshot, r10, r11, r12, r13);
    }

    public final WidgetRuntimeBindingSnapshot currentMessengerSnapshot(String r10, String r11, int r12, Integer r13) {
        return resolveSnapshot(this.registeredMessengerSnapshot, r10, r11, r12, r13);
    }

    public final WidgetRuntimeBindingSnapshot getBoundSnapshot() {
        return this.boundSnapshot;
    }

    public final WidgetRuntimeBindingSnapshot getRegisteredMessengerSnapshot() {
        return this.registeredMessengerSnapshot;
    }

    public final boolean getSuppressed() {
        return this.suppressed;
    }

    public final WidgetRuntimeBindingDispatchResult registerMessengerIfNeeded(WidgetRuntimeBindingSnapshot r10, Messenger r11, WidgetRuntimeBindingController r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "snapshot");
        Intrinsics.checkNotNullParameter(r11, "messenger");
        if (this.suppressed == true) goto L5;
        if (r13 == false) goto L8;
    L11:
        this.registeredMessengerSnapshot = r10;
        if (r12 != null) goto L14;
    L16:
        boolean r5 = false;
    L18:
        return new WidgetRuntimeBindingDispatchResult(r10, r5, null, 4, null);
    L14:
        if (r12.registerMessenger(r10, r11) != true) goto L16;
        r5 = true;
        goto L18
    L8:
        if (Intrinsics.areEqual(this.registeredMessengerSnapshot, r10) == false) goto L11;
        return new WidgetRuntimeBindingDispatchResult(r10, false, "alreadyRegistered");
    L5:
        return new WidgetRuntimeBindingDispatchResult(r10, false, "suppressed");
    }

    public final int registeredMessengerInstanceId() {
        WidgetRuntimeBindingSnapshot r5 = this.registeredMessengerSnapshot;
        if (r5 == null) goto L6;
        return r5.getInstanceId();
    L6:
        return this.invalidInstanceId;
    }

    public final void suppress() {
        this.suppressed = true;
    }

    public final WidgetRuntimeBindingDispatchResult unbindCurrent(String r5, String r10, int r11, WidgetRuntimeBindingController r12, Integer r13) {
        WidgetRuntimeBindingSnapshot r14 = currentBoundSnapshot(r5, r10, r11, r13);
        boolean r15 = false;
        if (r14 == null) goto L5;
        if (r12 == null) goto L11;
        if (r12.unbind(r14) != true) goto L11;
        r15 = true;
    L11:
        if (Intrinsics.areEqual(r14, this.boundSnapshot) == false) goto L14;
        this.boundSnapshot = null;
    L14:
        return new WidgetRuntimeBindingDispatchResult(r14, r15, null, 4, null);
    L5:
        return new WidgetRuntimeBindingDispatchResult(null, false, "missingSnapshot");
    }

    public final WidgetRuntimeBindingDispatchResult unregisterMessengerCurrent(String r5, String r10, int r11, WidgetRuntimeBindingController r12, Integer r13) {
        WidgetRuntimeBindingSnapshot r14 = currentMessengerSnapshot(r5, r10, r11, r13);
        boolean r15 = false;
        if (r14 == null) goto L5;
        if (r12 == null) goto L11;
        if (r12.unregisterMessenger(r14) != true) goto L11;
        r15 = true;
    L11:
        if (Intrinsics.areEqual(r14, this.registeredMessengerSnapshot) == false) goto L14;
        this.registeredMessengerSnapshot = null;
    L14:
        return new WidgetRuntimeBindingDispatchResult(r14, r15, null, 4, null);
    L5:
        return new WidgetRuntimeBindingDispatchResult(null, false, "missingSnapshot");
    }

    public WidgetRuntimeBindingSession(int r5) {
        this.invalidInstanceId = r5;
    }

    public /* synthetic */ WidgetRuntimeBindingSession(int r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = -1;
    L5:
        this(r5);
    }
}
