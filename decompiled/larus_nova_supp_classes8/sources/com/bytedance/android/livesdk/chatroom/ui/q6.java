package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdk.config.i10;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.model.InnerDrawPreloadDisableConfig;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q6 implements md0.a.a, gs0.b {
    public final String a;
    public IInteractFeedView b;
    public Room c;
    public int d;
    public int e;
    public Pair<Integer, ? extends JSONObject> f;
    public final com.bytedance.android.live.liveinteract.api.utils.j g;
    public r6 h;
    public List<? extends SeiRegion> i;
    public final ViewGroup j;
    public final ii1.a k;

    public static final class a {
    }

    static {
    }

    public final boolean isVersionSupported(int r1, int r2) {
        return true;
    }

    public final /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r1) {
    }

    public final void a() {
        ALogger.d(this.a, "[layoutLoad] clearInteractFeedView");
        IInteractFeedView r0 = this.b;
        if (r0 == null) goto L11;
        if (r0 == null) goto L6;
        r0.reset();
    L6:
        ViewGroup r1 = this.j;
        if (r1 == null) goto L9;
        r1.removeAllViews();
    L9:
        this.b = null;
        return;
    }

    public final void onSeiUpdated(SeiAppData r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        int r0 = r11.getUiLayout();
        int r1 = r11.getVersion();
        int r2 = r11.getSubScene();
        boolean r4 = false;
        if (this.d != r1) goto L9;
        if (this.e != r2) goto L9;
    L64:
        List r3 = r11.getGrids();
        if (r3 != null) goto L67;
    L91:
        IInteractFeedView r5 = this.b;
        if (r5 == null) goto L106;
        r5.onSeiUpdated(r11);
        return;
    L106:
        return;
    L67:
        if ((!r3.isEmpty()) != true) goto L91;
        List<? extends SeiRegion> r6 = r11.getGrids();
        List<? extends SeiRegion> r7 = this.i;
        if (r7 != null) goto L71;
    L87:
        ALogger.d(this.a, "[layoutLoad] onOnlineListChanged");
        IInteractFeedView r8 = this.b;
        if (r8 == null) goto L90;
        r8.onOnlineListChanged();
    L90:
        this.i = r6;
        goto L91
    L71:
        if (r7.size() != r6.size()) goto L87;
        List<? extends SeiRegion> r9 = this.i;
        if (r9 != null) goto L75;
        r9 = CollectionsKt.emptyList();
    L75:
        List<? extends SeiRegion> r10 = r9;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r13 = r10.iterator();
    L77:
        if (r13.hasNext() == false) goto L79;
        r12.add(((SeiRegion) r13.next()).uidStr);
        goto L77
    L79:
        Set r14 = CollectionsKt.toMutableSet(r12);
        int r15 = r14.size();
        List<? extends SeiRegion> r16 = r6;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L81:
        if (r18.hasNext() == false) goto L83;
        r17.add(((SeiRegion) r18.next()).uidStr);
        goto L81
    L83:
        r14.addAll(r17);
        if (r14.size() == r15) goto L86;
        r4 = true;
    L86:
        if (r4 == false) goto L90;
    L9:
        if (this.j == null) goto L64;
        a();
        List<? extends InnerDrawPreloadDisableConfig> r19 = i10.a.getValue();
        if (r19 == null) goto L25;
        Iterator<T> r20 = r19.iterator();
    L15:
        if (r20.hasNext() == false) goto L25;
        InnerDrawPreloadDisableConfig r21 = (InnerDrawPreloadDisableConfig) r20.next();
        if (r21.getSeiVer() == (-1)) goto L15;
        if (r11.getVersion() != r21.getSeiVer()) goto L15;
        if (r21.getSubScene() == (-1)) goto L24;
        if (r11.getSubScene() != r21.getSubScene()) goto L15;
    L24:
        boolean r22 = true;
    L27:
        if (r22 == false) goto L29;
        this.b = null;
    L30:
        IInteractFeedView r23 = this.b;
        if ((r23 instanceof View) == true) goto L33;
        r23 = null;
    L33:
        View r24 = (View) r23;
        if (r24 == null) goto L63;
        this.j.removeAllViews();
        this.j.setVisibility(0);
        this.j.addView(r24);
        IInteractFeedView r25 = this.b;
        if ((r25 instanceof View) == true) goto L38;
        r25 = null;
    L38:
        View r26 = (View) r25;
        if (r26 == null) goto L43;
        ViewTreeObserver r27 = r26.getViewTreeObserver();
        if (r27 == null) goto L43;
        r27.removeOnDrawListener(this.h);
    L43:
        this.h = new r6(this);
        IInteractFeedView r28 = this.b;
        if ((r28 instanceof View) == true) goto L46;
        r28 = null;
    L46:
        View r29 = (View) r28;
        if (r29 == null) goto L51;
        ViewTreeObserver r30 = r29.getViewTreeObserver();
        if (r30 == null) goto L51;
        r30.addOnDrawListener(this.h);
    L51:
        ALogger.d(this.a, "[layoutLoad] update room " + this.c);
        Room r31 = this.c;
        if (r31 == null) goto L56;
        IInteractFeedView r32 = this.b;
        if (r32 == null) goto L56;
        r32.updateRoom(r31);
    L56:
        IInteractFeedView r33 = this.b;
        if (r33 == null) goto L59;
        r33.refreshSeiCanvasAndSeiVersion((JSONObject) this.f.getSecond(), (Integer) this.f.getFirst());
    L59:
        IInteractFeedView r34 = this.b;
        if (r34 == null) goto L62;
        r34.setLivePlayerView(null);
    L62:
        this.j.requestLayout();
    L63:
        this.d = r1;
        this.e = r2;
        goto L64
    L29:
        this.b = jc1.k.n(IInteractService.class).getInteractFeedView(this.j.getContext(), r11, r0, 3);
    L25:
        r22 = false;
        goto L27
    }

    public q6(ViewGroup r2, MultiSceneEnterRoomStatisticsUtils r3, ii1.a r4) {
        Intrinsics.checkNotNullParameter(r3, "enterRoomStatistic");
        this.j = r2;
        this.k = r4;
        this.a = "InteractPreloadManager";
        new HashMap();
        this.f = new Pair(0, new JSONObject());
        this.g = new com.bytedance.android.live.liveinteract.api.utils.j(this);
    }
}
