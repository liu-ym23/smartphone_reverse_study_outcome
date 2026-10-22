package com.obric.sva.sdk.service;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.ArrayMap;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.ipc.TrackAPI;
import com.obric.sva.sdk.session.SessionType;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\bJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\bJ,\u0010\u0016\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\"\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010\u001e\u001a\u00020\u000eJ\u0012\u0010\u001f\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010 \u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/sva/sdk/service/WakeupClientRegistry;", "", "tag", "", "<init>", "(Ljava/lang/String;)V", "clients", "", "", "Landroid/os/Messenger;", "deathRecipients", "Landroid/os/IBinder;", "Landroid/os/IBinder$DeathRecipient;", "bindClientDeath", "", "clientMessenger", "callback", "Lcom/obric/sva/sdk/service/WakeupClientRegistry$ClientDeathCallback;", "registerClient", "clientId", "deregisterClient", "", "sendResponse", "what", "obj", "sessionType", "Lcom/obric/sva/sdk/session/SessionType;", "sendResponseToAllClients", "prepareDetectionBundle", "Landroid/os/Bundle;", "clear", "removeClientByMessenger", "unlinkDeathRecipient", "binder", "ClientDeathCallback", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class WakeupClientRegistry {
    private final Map<Integer, Messenger> clients;
    private final Map<IBinder, IBinder.DeathRecipient> deathRecipients;
    private final String tag;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/service/WakeupClientRegistry$ClientDeathCallback;", "", "onClientDeath", "", "clientToken", "Landroid/os/IBinder;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public interface ClientDeathCallback {
        void onClientDeath(IBinder r1);
    }

    public final void clear() {
        Iterator<Map.Entry<IBinder, IBinder.DeathRecipient>> r0 = this.deathRecipients.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<IBinder, IBinder.DeathRecipient> r1 = r0.next();
        r1.getKey().unlinkToDeath(r1.getValue(), 0);     // Catch: Exception -> L8
        goto L4
    L9:
        this.deathRecipients.clear();
        this.clients.clear();
    }

    public WakeupClientRegistry(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.tag = r2;
        this.clients = new HashMap();
        this.deathRecipients = new ArrayMap();
    }

    public static final /* synthetic */ Map access$getDeathRecipients$p(WakeupClientRegistry r0) {
        return r0.deathRecipients;
    }

    public static final /* synthetic */ String access$getTag$p(WakeupClientRegistry r0) {
        return r0.tag;
    }

    private final void removeClientByMessenger(Messenger r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<Integer, Messenger>> r1 = this.clients.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<Integer, Messenger> r2 = r1.next();
        int r3 = r2.getKey().intValue();
        if (r2.getValue() != r5) goto L6;
        r0.add(Integer.valueOf(r3));
        goto L6
    L10:
        Iterator r4 = r0.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        int r6 = ((Number) r4.next()).intValue();
        this.clients.remove(Integer.valueOf(r6));
        goto L12
    L14:
        unlinkDeathRecipient(r5.getBinder());
    }

    private final void unlinkDeathRecipient(IBinder r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        IBinder.DeathRecipient r0 = this.deathRecipients.remove(r3);
        if (r0 != null) goto L11;
        return;
    L11:
        r3.unlinkToDeath(r0, 0);     // Catch: Exception -> L10
        return;
    }

    private final Bundle prepareDetectionBundle(int r3, Object r4) {
        if (r3 == 4353) goto L6;
        return null;
    L6:
        if ((r4 instanceof Bundle) == false) goto L8;
        Bundle r5 = (Bundle) r4;
    L9:
        if (r5 == null) goto L12;
        WakeProcessStartupEvidence.INSTANCE.attachTo(r5);
        return r5;
    L12:
        return null;
    L8:
        r5 = null;
        goto L9
    }

    public final void bindClientDeath(Messenger r5, final ClientDeathCallback r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (r5 != null) goto L5;
        return;
    L5:
        final IBinder r7 = r5.getBinder();
        unlinkDeathRecipient(r7);
        IBinder.DeathRecipient r1 = new WakeupClientRegistry$bindClientDeath$recipient$1(this, r6, r7);
        LogUtils.d(this.tag, "linkToDeath " + r7, new Object[0]);     // Catch: RemoteException -> L8
        r7.linkToDeath(r1, 0);     // Catch: RemoteException -> L8
        this.deathRecipients.put(r7, r1);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public final boolean deregisterClient(Messenger r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "clientMessenger");
        if (this.clients.containsValue(r3) == true) goto L5;
        return false;
    L5:
        if (this.clients.containsKey(Integer.valueOf(r4)) == true) goto L7;
        return false;
    L7:
        if (Build.VERSION.SDK_INT < 24) goto L9;
        this.clients.remove(Integer.valueOf(r4), r3);
    L10:
        unlinkDeathRecipient(r3.getBinder());
        return true;
    L9:
        this.clients.remove(Integer.valueOf(r4));
        goto L10
    }

    public final void registerClient(Messenger r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "clientMessenger");
        if (this.clients.containsKey(Integer.valueOf(r5)) == false) goto L17;
        LogUtils.d(this.tag, "handleRegisterClientReq containKey replace", new Object[0]);
        Messenger r0 = this.clients.get(Integer.valueOf(r5));
        if (r0 == null) goto L7;
        IBinder r1 = r0.getBinder();
    L8:
        IBinder r2 = r4.getBinder();
        if (r1 == null) goto L14;
        if (Intrinsics.areEqual(r1, r2) == true) goto L14;
        unlinkDeathRecipient(r1);
    L14:
        if (Build.VERSION.SDK_INT < 24) goto L16;
        this.clients.replace(Integer.valueOf(r5), r4);
        return;
    L16:
        Integer r6 = Integer.valueOf(r5);
        this.clients.put(r6, r4);
        return;
    L7:
        r1 = null;
        goto L8
    L17:
        LogUtils.d(this.tag, "handleRegisterClientReq not contain , just put it in", new Object[0]);
        Integer r7 = Integer.valueOf(r5);
        this.clients.put(r7, r4);
    }

    public final void sendResponseToAllClients(int r10, Object r11, SessionType r12) {
        LogUtils.v(this.tag, "sendResponseToAllClients to client size: " + this.clients.size(), new Object[0]);
        ArrayList r0 = new ArrayList(this.clients.entrySet());
        if (r10 != 4353) goto L21;
        Bundle r3 = prepareDetectionBundle(r10, r11);
        Iterator r13 = r0.iterator();
    L5:
        Messenger r1 = null;
        if (r13.hasNext() == false) goto L13;
        Object r2 = r13.next();
        boolean r5 = true;
        if (((Number) ((Map.Entry) r2).getKey()).intValue() == 1) goto L11;
        r5 = false;
    L11:
        if (r5 == false) goto L5;
    L14:
        Map.Entry r4 = (Map.Entry) r2;
        if (r4 == null) goto L17;
        r1 = (Messenger) r4.getValue();
    L17:
        if (r1 != null) goto L19;
        TrackAPI.trackWakeupInterrupted$default(r3, "stage2_entry", "voice interaction client unavailable", null, 8, null);
        return;
    L19:
        sendResponse(r1, r10, r3, r12);
        return;
    L13:
        r2 = null;
        goto L14
    L21:
        Iterator r6 = r0.iterator();
    L23:
        if (r6.hasNext() == false) goto L25;
        Map.Entry r7 = (Map.Entry) r6.next();
        int r8 = ((Number) r7.getKey()).intValue();
        Messenger r9 = (Messenger) r7.getValue();
        LogUtils.v(this.tag, "sendResponseToAllClients: key = " + r8 + " clientMessenger = " + r9 + " what = " + r10 + " obj = " + r11 + " hex-what is :" + Integer.toHexString(r10), new Object[0]);
        sendResponse(r9, r10, r11, r12);
        goto L23
    }

    public final void sendResponse(Messenger r7, int r8, Object r9, SessionType r10) {
        Bundle r0 = prepareDetectionBundle(r8, r9);
        if (r7 != null) goto L5;
    L16:
        LogUtils.v(this.tag, "sendResponse: invalid clientMessenger = " + r7, new Object[0]);
        if (4353 != r8) goto L24;
        TrackAPI.trackWakeupInterrupted$default(r0, "stage2_entry", "invalid clientMessenger", null, 8, null);
        return;
    L24:
        return;
    L5:
        if (this.clients.containsValue(r7) == false) goto L16;
        LogUtils.v(this.tag, "sendResponse: clientMessenger = " + r7 + " what =  " + r8 + " obj = " + r9 + " hex-what is :" + Integer.toHexString(r8), new Object[0]);     // Catch: RemoteException -> L12
        Message r11 = Message.obtain(null, r8);     // Catch: RemoteException -> L12
        if (4353 != r8) goto L9;
        r11.getData().putParcelable("data", r0);     // Catch: RemoteException -> L12
    L10:
        r7.send(r11);     // Catch: RemoteException -> L12
        return;
    L9:
        r11.obj = r9;     // Catch: RemoteException -> L12
    L12:
        e = move-exception;
        LogUtils.v(this.tag, "sendResponse: removing clientMessenger = " + r7, new Object[0]);
        e.printStackTrace();
        removeClientByMessenger(r7);
        if (4353 != r8) goto L22;
        TrackAPI.trackWakeupInterrupted(r0, "stage2_entry", "sendResponse RemoteException", e.getMessage());
        return;
    }
}
