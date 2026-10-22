package com.bytedance.android.live.panel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.panel.panelobserver.PanelCoverObserver;
import com.bytedance.android.live.panel.panelobserver.PanelObserverType;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.live.room.api.panel.RemoveReason;
import com.bytedance.android.live.room.api.panel.c;
import com.bytedance.android.live.room.api.panel.e;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.LivePanelConfig;
import com.bytedance.android.livesdk.config.mf0;
import com.bytedance.android.livesdk.config.r6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0003R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/panel/PanelManager;", "Lcom/bytedance/android/live/room/api/panel/c;", "Lcom/bytedance/live/datacontext/DataContext;", "", "init", "Lcom/bytedance/android/live/room/api/panel/PanelName;", "panelName", "Lcom/bytedance/android/live/room/api/panel/b;", "panelInfoProvider", "notifyPanelOpen", "notifyPanelClose", "Lcom/bytedance/android/live/room/api/panel/a;", "panelListener", "registerPanelListener", "", "sticky", "unregisterPanelListener", "Lcom/bytedance/android/live/panel/a;", "observer", "registerPanelObserver", "destroy", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lqr0/a;", "panelStore", "Lqr0/a;", "", "Lcom/bytedance/android/live/panel/panelobserver/PanelObserverType;", "panelObservers", "Ljava/util/Map;", "<init>", "()V", "Companion", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelManager extends DataContext implements c {
    public static final a Companion = null;
    public static final String TAG = "PanelManager";
    private final CompositeDisposable cd;
    private Map<PanelObserverType, com.bytedance.android.live.panel.a> panelObservers;
    private final qr0.a panelStore;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ PanelManager a;

        public b(PanelManager r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.destroy();
            PanelManager.access$getCd$p(this.a).clear();
        }
    }

    static {
        Companion = new a();
    }

    public final void destroy() {
        qr0.a r0 = this.panelStore;
        Map<PanelName, Map<Integer, com.bytedance.android.live.room.api.panel.b>> r1 = r0.a;
        if (r1 == null) goto L5;
        ((LinkedHashMap) r1).clear();
    L5:
        r0.a = null;
        Map<PanelObserverType, com.bytedance.android.live.panel.a> r2 = this.panelObservers;
        if (r2 == null) goto L11;
        Iterator<Map.Entry<PanelObserverType, com.bytedance.android.live.panel.a>> r3 = r2.entrySet().iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        r3.next().getValue().destroy();
    L11:
        Map<PanelObserverType, com.bytedance.android.live.panel.a> r4 = this.panelObservers;
        if (r4 == null) goto L14;
        r4.clear();
    L14:
        this.panelObservers = null;
    }

    public PanelManager() {
        this.cd = new CompositeDisposable();
        this.panelStore = new qr0.a();
    }

    public final void init() {
        RxUtilKt.c(getOnCleared().subscribe(new b(this)), this.cd);
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PanelManager r0) {
        return r0.cd;
    }

    public void registerPanelListener(com.bytedance.android.live.room.api.panel.a r2) {
        Intrinsics.checkNotNullParameter(r2, "panelListener");
        registerPanelListener(r2, false);
    }

    public final void registerPanelObserver(com.bytedance.android.live.panel.a r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        if (this.panelObservers != null) goto L5;
        this.panelObservers = new LinkedHashMap();
    L5:
        PanelObserverType r0 = r4.c();
        ALogger.i(TAG, "registerPanelObserver, type = " + r0);
        Map<PanelObserverType, com.bytedance.android.live.panel.a> r1 = this.panelObservers;
        if (r1 == null) goto L9;
        com.bytedance.android.live.panel.a r5 = r1.put(r0, r4);
        return;
    }

    public void unregisterPanelListener(com.bytedance.android.live.room.api.panel.a r5) {
        Intrinsics.checkNotNullParameter(r5, "panelListener");
        Map<PanelObserverType, com.bytedance.android.live.panel.a> r1 = this.panelObservers;
        com.bytedance.android.live.panel.a r2 = null;
        if (r1 == null) goto L5;
        com.bytedance.android.live.panel.a r3 = r1.get(PanelObserverType.CoverObserver);
    L7:
        if ((r3 instanceof PanelCoverObserver) == false) goto L10;
        r2 = r3;
    L10:
        PanelCoverObserver r4 = (PanelCoverObserver) r2;
        if (r4 == null) goto L19;
        Intrinsics.checkNotNullParameter(r5, "panelListener");
        String r6 = r5.getName();
        Map<String, com.bytedance.android.live.room.api.panel.a> r0 = r4.a;
        if (r0 == null) goto L17;
        com.bytedance.android.live.room.api.panel.a r7 = r0.remove(r6);
        if (r7 == null) goto L17;
        ALogger.i("PanelCoverObserver", "unregisterPanelListener, listenerName = " + r6);
        r7.c(RemoveReason.UnRegister);
        return;
    L17:
        ALogger.i("PanelCoverObserver", "unregisterPanelListener, not find listenerName = " + r6);
        return;
    L19:
        return;
    L5:
        r3 = null;
        goto L7
    }

    public void notifyPanelClose(PanelName r4, com.bytedance.android.live.room.api.panel.b r5) {
        Intrinsics.checkNotNullParameter(r4, "panelName");
        qr0.a r1 = this.panelStore;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "panelName");
        ALogger.i("PanelStore", "panelClose, panelName = " + r4 + ", panelInfoProvider = " + r5);
        ArrayList r0 = new ArrayList();
        if (r5 != null) goto L9;
        Map<PanelName, Map<Integer, com.bytedance.android.live.room.api.panel.b>> r6 = r1.a;
        if (r6 == null) goto L18;
        Map r7 = (Map) ((LinkedHashMap) r6).get(r4);
        if (r7 == null) goto L18;
        r0.addAll(r7.values());
        r7.clear();
    L18:
        if ((!r0.isEmpty()) == false) goto L25;
        Map<PanelObserverType, com.bytedance.android.live.panel.a> r8 = this.panelObservers;
        if (r8 == null) goto L27;
        Iterator<Map.Entry<PanelObserverType, com.bytedance.android.live.panel.a>> r9 = r8.entrySet().iterator();
    L23:
        if (r9.hasNext() == false) goto L28;
        r9.next().getValue().b(r0);
        goto L23
    L28:
        return;
    L27:
        return;
    L25:
        return;
    L9:
        Map<PanelName, Map<Integer, com.bytedance.android.live.room.api.panel.b>> r2 = r1.a;
        if (r2 == null) goto L14;
        Map r10 = (Map) ((LinkedHashMap) r2).get(r4);
        if (r10 == null) goto L14;
        com.bytedance.android.live.room.api.panel.b r11 = (com.bytedance.android.live.room.api.panel.b) r10.remove(Integer.valueOf(r5.getUnionId()));
    L15:
        if (r11 == null) goto L18;
        r0.add(r11);
    L14:
        r11 = null;
        goto L15
    }

    public void notifyPanelOpen(PanelName r9, com.bytedance.android.live.room.api.panel.b r10) {
        Intrinsics.checkNotNullParameter(r9, "panelName");
        Intrinsics.checkNotNullParameter(r10, "panelInfoProvider");
        Lazy r2 = PanelSetting.a;
        List r3 = CollectionsKt.toMutableList(((LivePanelConfig) mf0.a.getValue()).getPanelBlockList());
        Room r7 = null;
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r4 == null) goto L7;
        m r5 = r4.getRoom();
        if (r5 == null) goto L7;
        r7 = (Room) r5.getValue();
    L7:
        if (r7 != null) goto L9;
    L10:
        r3.addAll(((r6) PanelSetting.a.getValue()).b());
    L12:
        if (r3.contains(r9.getPanelName()) == false) goto L16;
        ALogger.i(TAG, "panel: " + r9.getPanelName() + " in panel block list");
        return;
    L16:
        if (r9 != PanelName.UnKnown) goto L19;
        ALogger.i(TAG, "panelName is UnKnown");
        return;
    L19:
        qr0.a r6 = this.panelStore;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r9, "panelName");
        Intrinsics.checkNotNullParameter(r10, "panelInfoProvider");
        int r0 = r10.getUnionId();
        ALogger.i("PanelStore", "panelOpen, panelName = " + r9 + ", panelId = " + r0);
        if (r6.a != null) goto L22;
        r6.a = new LinkedHashMap();
    L22:
        Map<PanelName, Map<Integer, com.bytedance.android.live.room.api.panel.b>> r1 = r6.a;
        if (r1 == null) goto L28;
        Object r8 = ((LinkedHashMap) r1).get(r9);
        if (r8 != null) goto L27;
        r8 = new LinkedHashMap();
        r1.put(r9, (Map<Integer, com.bytedance.android.live.room.api.panel.b>) r8);
    L27:
        com.bytedance.android.live.room.api.panel.b r11 = (com.bytedance.android.live.room.api.panel.b) ((Map) r8).put(Integer.valueOf(r0), r10);
    L28:
        Map<PanelObserverType, com.bytedance.android.live.panel.a> r12 = this.panelObservers;
        if (r12 == null) goto L34;
        Iterator<Map.Entry<PanelObserverType, com.bytedance.android.live.panel.a>> r13 = r12.entrySet().iterator();
    L32:
        if (r13.hasNext() == false) goto L36;
        r13.next().getValue().a(r10);
        goto L32
    L36:
        return;
    L34:
        return;
    L9:
        if (r7.isGameRoom() == 1) goto L12;
        goto L10
    }

    public void registerPanelListener(com.bytedance.android.live.room.api.panel.a r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "panelListener");
        Lazy r1 = PanelSetting.a;
        if (((LivePanelConfig) mf0.a.getValue()).getListenerBlockList().contains(r6.getName()) == false) goto L6;
        ALogger.i(TAG, "panelListener: " + r6.getName() + " in listener block list");
        return;
    L6:
        Map<PanelObserverType, com.bytedance.android.live.panel.a> r2 = this.panelObservers;
        Integer r3 = null;
        if (r2 == null) goto L9;
        com.bytedance.android.live.panel.a r4 = r2.get(PanelObserverType.CoverObserver);
    L11:
        if ((r4 instanceof PanelCoverObserver) == true) goto L13;
        r4 = null;
    L13:
        PanelCoverObserver r5 = (PanelCoverObserver) r4;
        if (r5 == null) goto L39;
        Intrinsics.checkNotNullParameter(r6, "panelListener");
        if (r5.a != null) goto L18;
        r5.a = new LinkedHashMap();
    L18:
        String r0 = r6.getName();
        StringBuilder r8 = new StringBuilder("registerPanelListener, listenerName = ");
        r8.append(r0);
        r8.append(" , sticky = ");
        r8.append(r7);
        r8.append(" , panels size ");
        Map<PanelName, e> r9 = r5.b;
        if (r9 == null) goto L21;
        r3 = Integer.valueOf(r9.size());
    L21:
        r8.append(r3);
        ALogger.i("PanelCoverObserver", r8.toString());
        Map<String, com.bytedance.android.live.room.api.panel.a> r10 = r5.a;
        if (r10 == null) goto L24;
        com.bytedance.android.live.room.api.panel.a r11 = r10.put(r0, r6);
    L24:
        if (r7 == false) goto L41;
        Map<PanelName, e> r12 = r5.b;
        if (r12 != null) goto L28;
        return;
    L28:
        if ((!r12.isEmpty()) == true) goto L30;
        return;
    L30:
        if (((Boolean) PanelSetting.b.getValue()).booleanValue() == false) goto L44;
        Map<PanelName, e> r13 = r5.b;
        if (r13 == null) goto L45;
        Collection r14 = ((LinkedHashMap) r13).values();
        if (r14 == null) goto L46;
        Iterator r15 = r14.iterator();
    L37:
        if (r15.hasNext() == false) goto L47;
        e r16 = (e) r15.next();
        ALogger.i("PanelCoverObserver", "onPanelOpen sticky , listener name = " + r0 + " , panel name = " + r16.a + ", panel id = " + r16.b);
        r6.b(r16);
        goto L37
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L41:
        return;
    L39:
        return;
    L9:
        r4 = null;
        goto L11
    }
}
