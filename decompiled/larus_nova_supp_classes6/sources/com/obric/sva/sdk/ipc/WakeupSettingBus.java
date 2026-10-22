package com.obric.sva.sdk.ipc;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/sva/sdk/ipc/WakeupSettingBus;", "", "<init>", "()V", "TAG", "", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/sva/sdk/ipc/WakeupSettingBus$Listener;", "register", "", "listener", "unregister", "emit", "property", "Lcom/obric/sva/sdk/ipc/WakeupSettingBus$Property;", "status", "", "Property", "Listener", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class WakeupSettingBus {
    public static final WakeupSettingBus INSTANCE = null;
    private static final String TAG = "WakeupSettingBus";
    private static final CopyOnWriteArrayList<Listener> listeners = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/sva/sdk/ipc/WakeupSettingBus$Listener;", "", "onSettingChanged", "", "property", "Lcom/obric/sva/sdk/ipc/WakeupSettingBus$Property;", "status", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public interface Listener {
        void onSettingChanged(Property r1, boolean r2);
    }

    private WakeupSettingBus() {
    }

    static {
        INSTANCE = new WakeupSettingBus();
        listeners = new CopyOnWriteArrayList();
    }

    public final void register(Listener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        CopyOnWriteArrayList<Listener> r0 = listeners;
        if (r0.contains(r3) == true) goto L6;
        r0.add(r3);
        return;
    }

    public final void unregister(Listener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        listeners.remove(r2);
    }

    public final void emit(Property r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "property");
        StringBuilder r0 = new StringBuilder("emit property=");
        r0.append(r7.getKey());
        r0.append(" status=");
        r0.append(r8);
        r0.append(" listeners=");
        CopyOnWriteArrayList<Listener> r1 = listeners;
        r0.append(r1.size());
        LogUtils.d(TAG, r0.toString(), new Object[0]);
        Iterator<Listener> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        r2.next().onSettingChanged(r7, r8);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        LogUtils.e(TAG, "listener onSettingChanged failed: " + th.getMessage(), new Object[0]);
        goto L4
    }
}
