package com.bytedance.android.live.liveinteract.linkpanel.vm;

import am2.x;
import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.livesdk.chatroom.model.f3;
import com.bytedance.android.livesdk.chatroom.model.k1;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zf0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 <2\u00020\u0001:\u0001=B\u0017\u0012\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010.¢\u0006\u0004\b:\u0010;J.\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J \u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0002JF\u0010\u001e\u001a\u00020\t2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00022\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0002J\u000e\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0003J*\u0010&\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010\u001bR \u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070(0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R \u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070(0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010*R\u001c\u0010/\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001d\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070(018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00107\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b5\u00106R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020,018F¢\u0006\u0006\u001a\u0004\b8\u00103¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/vm/PlayModeListViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "", "Lzf0/g;", "roomModeList", "Lzf0/i;", "playModeList", "Lzf0/a;", "extractDisplayList", "", "switchRadio", "switchRoomChat", "switchKtv", "Lkotlin/Pair;", "", "getVoiceTalkRoomSceneAndUILayout", "switchChorus", "", "functionType", "logVoiceChatRoomOpenClick", "logIconClick", "type", "requestPage", "source", "logVoiceRoomPanelItemClick", "Lcom/bytedance/android/livesdk/chatroom/model/f3;", "roomMethodList", "Lcom/bytedance/android/livesdk/chatroom/model/k1;", "", "playingList", "updateList", "data", "onLinkModeClick", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "item", "onPlayModeClick", "Landroidx/lifecycle/MutableLiveData;", "", "_modeDisplayList", "Landroidx/lifecycle/MutableLiveData;", "_modeTotalList", "", "_shouldShowMore", "Ljava/lang/ref/WeakReference;", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroidx/lifecycle/LiveData;", "getModeDisplayList", "()Landroidx/lifecycle/LiveData;", "modeDisplayList", "getTotalSize", "()I", "totalSize", "getShouldShowMore", "shouldShowMore", "<init>", "(Ljava/lang/ref/WeakReference;)V", "Companion", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PlayModeListViewModel extends DataContext {
    public static final a Companion = null;
    public static final int LINK_MODE_CNT = 3;
    public static final int LIST_LENGTH = 6;
    public static final int PLAY_MODE_CNT = 3;
    public static final int SPAN_COUNT = 3;
    public static final String TAG = "PlayModeViewModel";
    private final MutableLiveData<List<zf0.a>> _modeDisplayList;
    private final MutableLiveData<List<zf0.a>> _modeTotalList;
    private final MutableLiveData<Boolean> _shouldShowMore;
    private final WeakReference<Context> contextRef;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final void logIconClick() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("request_page", "interact_panel");
        r0.put("function_type", ((IInteractService) k.n(IInteractService.class)).getCurrentFunctionType());
        IInteractService r1 = (IInteractService) k.f(IInteractService.class);
        if (r1 == null) goto L5;
        r1.updateSwitchSceneSource("interaction_button");
    L5:
        r0.put("source", "interaction_button");
        j0.l().sendLog("livesdk_room_grouppk_icon_click", r0, new Object[0]);
    }

    private final void switchChorus() {
        logVoiceChatRoomOpenClick("chorus");
        if (k.n(IKtvService.class).requestConflictCheck(KtvConflictScene.SCENE_KTV) == true) goto L6;
        return;
    L6:
        if (((Number) getVoiceTalkRoomSceneAndUILayout().component1()).intValue() == 0) goto L22;
        IInteractService r1 = (IInteractService) k.f(IInteractService.class);
        if (r1 == null) goto L26;
        WeakReference<Context> r0 = this.contextRef;
        if (r0 == null) goto L12;
        Context r2 = r0.get();
    L14:
        if ((r2 instanceof Activity) == false) goto L16;
        Context r3 = this.contextRef.get();
    L17:
        Context r4 = r3;
        IInteractService r5 = (IInteractService) k.f(IInteractService.class);
        if (r5 == null) goto L20;
        int r6 = r5.getCurrentScene();
    L21:
        r1.switchSceneWithConfirmCheck(r4, r6, 9, "", 61, 0);
        return;
    L20:
        r6 = 0;
        goto L21
    L16:
        r3 = com.bytedance.android.live.core.utils.a.d();
        goto L17
    L12:
        r2 = null;
        goto L14
    L26:
        return;
    L22:
        IInteractService r7 = (IInteractService) k.f(IInteractService.class);
        if (r7 == null) goto L28;
        r7.initAndTurnOnChorusKTV();
        return;
    }

    private final void switchKtv() {
        logVoiceChatRoomOpenClick("ktv");
        Context r4 = null;
        j0.l().sendLog("anchor_ktv_open", null, new Object[]{IRoom.class, x.class});
        if (k.n(IKtvService.class).requestConflictCheck(KtvConflictScene.SCENE_KTV) == true) goto L5;
        return;
    L5:
        Pair<Integer, Integer> r0 = getVoiceTalkRoomSceneAndUILayout();
        int r1 = ((Number) r0.component1()).intValue();
        ((Number) r0.component2()).intValue();
        if (r1 == 0) goto L21;
        IInteractService r5 = (IInteractService) k.f(IInteractService.class);
        if (r5 == null) goto L25;
        WeakReference<Context> r2 = this.contextRef;
        if (r2 == null) goto L13;
        r4 = r2.get();
    L13:
        if ((r4 instanceof Activity) == false) goto L15;
        Context r3 = this.contextRef.get();
    L16:
        Context r6 = r3;
        IInteractService r7 = (IInteractService) k.f(IInteractService.class);
        if (r7 == null) goto L19;
        int r8 = r7.getCurrentScene();
    L20:
        r5.switchSceneWithConfirmCheck(r6, r8, 9, "", 0, 0);
        return;
    L19:
        r8 = 0;
        goto L20
    L15:
        r3 = com.bytedance.android.live.core.utils.a.d();
        goto L16
    L25:
        return;
    L21:
        IInteractService r9 = (IInteractService) k.f(IInteractService.class);
        if (r9 == null) goto L27;
        r9.initAndTurnOnKTV();
        return;
    }

    private final void switchRadio() {
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 == null) goto L12;
        qd0.a r1 = r0.getAudioTalkService();
        if (r1 == null) goto L13;
        WeakReference<Context> r2 = this.contextRef;
        if (r2 == null) goto L9;
        Context r3 = r2.get();
    L10:
        r1.switchVoiceSceneWithCheck(r3, "radio");
        return;
    L9:
        r3 = null;
        goto L10
    L13:
        return;
    }

    private final void switchRoomChat() {
        logVoiceChatRoomOpenClick("radio");
        Pair<Integer, Integer> r0 = getVoiceTalkRoomSceneAndUILayout();
        int r1 = ((Number) r0.component1()).intValue();
        int r2 = ((Number) r0.component2()).intValue();
        if (r1 == 0) goto L19;
        IInteractService r3 = (IInteractService) k.f(IInteractService.class);
        if (r3 == null) goto L23;
        WeakReference<Context> r4 = this.contextRef;
        if (r4 == null) goto L9;
        Context r5 = r4.get();
    L11:
        if ((r5 instanceof Activity) == false) goto L13;
        Context r6 = this.contextRef.get();
    L14:
        Context r7 = r6;
        IInteractService r8 = (IInteractService) k.f(IInteractService.class);
        if (r8 == null) goto L17;
        int r9 = r8.getCurrentScene();
    L18:
        r3.switchSceneWithConfirmCheck(r7, r9, 5, "", Integer.valueOf(r2), 0);
        return;
    L17:
        r9 = 0;
        goto L18
    L13:
        r6 = com.bytedance.android.live.core.utils.a.d();
        goto L14
    L9:
        r5 = null;
        goto L11
    L23:
        return;
    L19:
        IInteractService r10 = (IInteractService) k.f(IInteractService.class);
        if (r10 == null) goto L25;
        r10.initAndTurnOnVoiceChatRoom();
        return;
    }

    public final int getTotalSize() {
        List r0 = (List) this._modeTotalList.getValue();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    private final Pair<Integer, Integer> getVoiceTalkRoomSceneAndUILayout() {
        u r0 = m.d();
        int r1 = 0;
        if (r0 == null) goto L11;
        j r2 = r0.s();
        if (r2 == null) goto L11;
        f r3 = (f) r2.getValue();
        if (r3 == null) goto L11;
        i r4 = r3.t();
        if (r4 == null) goto L11;
        int r5 = r4.a;
    L12:
        u r6 = m.d();
        if (r6 == null) goto L22;
        j r7 = r6.s();
        if (r7 == null) goto L22;
        f r8 = (f) r7.getValue();
        if (r8 == null) goto L22;
        i r9 = r8.t();
        if (r9 == null) goto L22;
        r1 = r9.b;
    L22:
        return new Pair(Integer.valueOf(r5), Integer.valueOf(r1));
    L11:
        r5 = 0;
        goto L12
    }

    public final LiveData<List<zf0.a>> getModeDisplayList() {
        return this._modeDisplayList;
    }

    public final LiveData<Boolean> getShouldShowMore() {
        return this._shouldShowMore;
    }

    public PlayModeListViewModel(WeakReference<Context> r3) {
        this.contextRef = r3;
        MutableLiveData<List<zf0.a>> r4 = new MutableLiveData();
        r4.setValue(null);
        Unit r1 = Unit.INSTANCE;
        this._modeDisplayList = r4;
        MutableLiveData<List<zf0.a>> r5 = new MutableLiveData();
        r5.setValue(null);
        this._modeTotalList = r5;
        MutableLiveData<Boolean> r6 = new MutableLiveData();
        r6.setValue(Boolean.FALSE);
        this._shouldShowMore = r6;
    }

    private final void logVoiceChatRoomOpenClick(String r5) {
        HashMap r0 = new HashMap();
        r0.put("room_type", "radio");
        r0.put("live_type", "voice_live");
        r0.put("function_type", r5);
        r0.put("function_type2", r5);
        j0 r6 = j0.l();
        x r2 = new x();
        r2.b = "live_detail";
        r2.a = "live";
        r2.e = "click";
        r6.sendLog("anchor_audience_connection_open", r0, new Object[]{r2, IRoom.class});
    }

    public final void onLinkModeClick(g r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        long r0 = r5.c;
        ALogger.i(TAG, "onLinkModeClick:" + r5);
        if (r0 != 100) goto L6;
        switchRoomChat();
    L14:
        logVoiceRoomPanelItemClick((int) r0, "Link_panel", "link_setting_panel");
        return;
    L6:
        if (r0 != 101) goto L9;
        switchKtv();
        goto L14
    L9:
        if (r0 != 102) goto L12;
        switchChorus();
        goto L14
    L12:
        if (r0 != 103) goto L14;
        switchRadio();
        goto L14
    }

    private final List<zf0.a> extractDisplayList(List<g> r2, List<zf0.i> r3) {
        if (r2 == null) goto L6;
        List r4 = CollectionsKt.take(r2, 3);
        if (r4 == null) goto L6;
    L7:
        if (r3 == null) goto L10;
        List r5 = CollectionsKt.take(r3, 3);
        if (r5 == null) goto L10;
    L11:
        ArrayList r0 = new ArrayList();
        r0.addAll(r4);
        r0.addAll(r5);
        return r0;
    L10:
        r5 = CollectionsKt.emptyList();
    L6:
        r4 = CollectionsKt.emptyList();
        goto L7
    }

    private final void logVoiceRoomPanelItemClick(int r3, String r4, String r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.K(r0);
        r0.put("request_page", r4);
        r0.put("source", r5);
        switch(r3) {
            case 100: goto L8;
            case 101: goto L7;
            case 102: goto L6;
            case 103: goto L5;
            default: goto L4;
        };
    L4:
        String r6 = "";
    L9:
        r0.put("room_mode", r6);
        j0.l().sendLog("livesdk_live_function_interact_playmode_panel_item_click", r0, new Object[]{IRoom.class});
        return;
    L5:
        r6 = "live";
        goto L9
    L6:
        r6 = "chorus";
        goto L9
    L7:
        r6 = "ktv";
        goto L9
    L8:
        r6 = "chatroom";
        goto L9
    }

    public final void onPlayModeClick(Context r2, DataCenter r3, String r4, k1 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "source");
        if (r3 == null) goto L7;
        gd0.m r0 = ((IInteractService) k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r0 == null) goto L7;
        ((LinkPanelTransitService) r0).c(r2, r3, r4, r5);
    L7:
        logIconClick();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Iterable, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.LinkedList] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Iterable, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.util.LinkedList] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.android.live.liveinteract.linkpanel.vm.PlayModeListViewModel] */
    public final void updateList(List<? extends f3> r8, List<Integer> r9, List<? extends k1> r10, List<Long> r11) {
        if (r10 == null) goto L7;
        Intrinsics.checkNotNullParameter(r10, "$this$convertToPlayModeData");
        ?? r0 = new LinkedList();
        Iterator r12 = r10.iterator();
    L5:
        if (r12.hasNext() == false) goto L8;
        k1 r1 = (k1) r12.next();
        r0.add(new zf0.i(r1.getTitle(), r1.getIcon(), r1));
    L8:
        Iterator r13 = r0.iterator();
    L10:
        if (r13.hasNext() == false) goto L15;
        zf0.i r2 = (zf0.i) r13.next();
        if (r11 == null) goto L14;
        r11.contains(Long.valueOf(r2.d.getType()));
    L14:
        r2.getClass();
        goto L10
    L15:
        if (r8 == null) goto L20;
        Intrinsics.checkNotNullParameter(r8, "$this$convertToLinkModeData");
        ?? r14 = new LinkedList();
        Iterator r15 = r8.iterator();
    L18:
        if (r15.hasNext() == false) goto L21;
        f3 r16 = (f3) r15.next();
        r14.add(new g(r16.title, r16.icon, r16.interactType));
    L21:
        Iterator r17 = r14.iterator();
    L23:
        if (r17.hasNext() == false) goto L28;
        g r18 = (g) r17.next();
        if (r9 == null) goto L27;
        r9.contains(Integer.valueOf((int) r18.c));
    L27:
        r18.getClass();
        goto L23
    L28:
        ArrayList r19 = new ArrayList();
        r19.addAll(r0);
        r19.addAll(r14);
        if (r14.size() <= 3) goto L31;
    L34:
        this._shouldShowMore.setValue(Boolean.TRUE);
    L35:
        this._modeTotalList.setValue(r19);
        this._modeDisplayList.setValue(CollectionsKt.toMutableList(CollectionsKt.take(extractDisplayList(r14, r0), 6)));
        return;
    L31:
        if (r0.size() > 3) goto L34;
        this._shouldShowMore.setValue(Boolean.FALSE);
        goto L35
    L20:
        r14 = new ArrayList();
        goto L21
    L7:
        r0 = new ArrayList();
        goto L8
    }
}
