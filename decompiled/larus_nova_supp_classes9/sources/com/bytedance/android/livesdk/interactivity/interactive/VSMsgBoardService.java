package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainVSToolbarConfigData;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u0016H\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/VSMsgBoardService;", "Lqh1/a;", "Lyq1/b;", "Lcom/bytedance/android/scope/o;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", BuildConfig.FLAVOR, "canShowMsgBoard", BuildConfig.FLAVOR, "getVsMsgBoardLiveEpisodeId", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episode", "replayToolbarDataHasDress", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "roomToolbarDataHasDress", BuildConfig.FLAVOR, "requestDressData", "paidStatusChanged", "getMsgBoardSchema", "Lpy/k;", "getVsMsgBoardIcon", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getLiveElementClass", "getReplayElementClass", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VSMsgBoardService implements qh1.a, yq1.b, com.bytedance.android.scope.o {
    public VSMsgBoardService() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public Class<? extends Widget> getLiveElementClass() {
        return VSMsgBoardServiceWidget.class;
    }

    public Class<? extends Widget> getReplayElementClass() {
        return ReplayVSMsgBoardServiceWidget.class;
    }

    public boolean canShowMsgBoard(DataCenter r9) {
        int r0 = k1.a;
        String r1 = null;
        if (r9 != null) goto L6;
    L60:
        boolean r3 = false;
    L61:
        if (r3 == true) goto L70;
        int r2 = com.ss.ugc.effectplatform.util.r.a;
        if (r9 == null) goto L66;
        r1 = (String) r9.get("comment_id");
    L66:
        if (com.ss.ugc.effectplatform.util.r.b(r1) == true) goto L70;
        f2.c("当前留言活动已结束", 0);
        if (r9 == null) goto L70;
        r9.put("comment_id", BuildConfig.FLAVOR);
    L70:
        return r3;
    L6:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.b == true) goto L60;
        nm1.e r4 = pm1.f.c();
        if (r4 == null) goto L13;
        ReplayDataContext r5 = r4.h(r9);
        if (r5 == null) goto L13;
        com.bytedance.live.datacontext.j r6 = r5.getVsMsgBoardDataContext();
    L14:
        r3 = true;
        if (r6 != null) goto L37;
        IRoom r7 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r9);
        if (r7 == null) goto L60;
        ILiveToolbarData r8 = r7.getToolbarData();
        if (r8 == null) goto L34;
        List r10 = r8.getToolbarDataList();
        if (r10 == null) goto L34;
        Iterator r11 = r10.iterator();
    L25:
        if (r11.hasNext() == false) goto L32;
        Object r13 = r11.next();
        if (((IToolbarComponentData) r13).getId() != 27) goto L29;
        boolean r14 = true;
    L30:
        if (r14 == false) goto L25;
    L33:
        IToolbarComponentData r15 = (IToolbarComponentData) r13;
    L35:
        if (r15 == null) goto L60;
    L29:
        r14 = false;
        goto L30
    L32:
        r13 = null;
    L34:
        r15 = null;
        goto L35
    L37:
        Episode r16 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r9);
        if (r16 == null) goto L60;
        List r17 = r16.getPannelToolbarList();
        if (r17 == null) goto L57;
        Iterator r18 = r17.iterator();
    L44:
        if (r18.hasNext() == false) goto L55;
        Object r19 = r18.next();
        IVSToolbarConfigData r20 = (IVSToolbarConfigData) r19;
        if (r20.getToolbarType() == 12) goto L48;
    L52:
        boolean r21 = false;
    L53:
        if (r21 == false) goto L44;
    L56:
        IVSToolbarConfigData r23 = (IVSToolbarConfigData) r19;
    L58:
        if (r23 == null) goto L60;
    L48:
        if (r20.getDisplayType() != 1) goto L50;
    L51:
        r21 = true;
        goto L53
    L50:
        if (r20.getDisplayType() != 3) goto L52;
    L55:
        r19 = null;
        goto L56
    L57:
        r23 = null;
    L13:
        r6 = null;
        goto L14
    }

    public String getMsgBoardSchema(DataCenter r7) {
        int r0 = k1.a;
        if (r7 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        nm1.e r1 = pm1.f.c();
        if (r1 == null) goto L10;
        ReplayDataContext r2 = r1.h(r7);
        if (r2 == null) goto L10;
        com.bytedance.live.datacontext.j r3 = r2.getVsMsgBoardDataContext();
    L12:
        if (r3 != null) goto L30;
        ILiveToolbarData r8 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r7).getToolbarData();
        if (r8 == null) goto L48;
        List r9 = r8.getToolbarDataList();
        if (r9 == null) goto L48;
        Iterator r10 = r9.iterator();
    L19:
        if (r10.hasNext() == false) goto L26;
        Object r4 = r10.next();
        if (((IToolbarComponentData) r4).getId() != 27) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == false) goto L19;
    L27:
        IToolbarComponentData r6 = (IToolbarComponentData) r4;
        if (r6 == null) goto L48;
        return r6.getScheme();
    L23:
        r5 = false;
        goto L24
    L26:
        r4 = null;
    L48:
        return null;
    L30:
        Episode r11 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r7);
        if (r11 == null) goto L48;
        List r13 = r11.getPannelToolbarList();
        if (r13 == null) goto L48;
        Iterator r14 = r13.iterator();
    L36:
        if (r14.hasNext() == false) goto L43;
        Object r15 = r14.next();
        if (((IVSToolbarConfigData) r15).getToolbarType() != 12) goto L40;
        boolean r16 = true;
    L41:
        if (r16 == false) goto L36;
    L44:
        IVSToolbarConfigData r17 = (IVSToolbarConfigData) r15;
        if (r17 == null) goto L48;
        return r17.getSchema();
    L40:
        r16 = false;
        goto L41
    L43:
        r15 = null;
    L10:
        r3 = null;
        goto L12
    }

    public py.k getVsMsgBoardIcon(DataCenter r5) {
        int r0 = k1.a;
        if (r5 != null) goto L5;
        return null;
    L5:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r5) == null) goto L50;
        Episode r6 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r5);
        if (r6 == null) goto L22;
        List r7 = r6.getPannelToolbarList();
        if (r7 == null) goto L22;
        Iterator r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L20;
        Object r1 = r8.next();
        if (((IVSToolbarConfigData) r1).getToolbarType() != 12) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == false) goto L13;
    L21:
        IVSToolbarConfigData r3 = (IVSToolbarConfigData) r1;
    L23:
        if (r3 == null) goto L26;
        py.k r9 = r3.getIcon();
        if (r9 == null) goto L26;
    L29:
        if (r9 != null) goto L33;
        if (r3 == null) goto L32;
        r9 = r3.getBottomIcon();
        goto L33
    L32:
        r9 = null;
    L33:
        if (r9 != null) goto L37;
        if (r3 == null) goto L36;
        r9 = r3.getDynamicBottomIcon();
        goto L37
    L36:
        r9 = null;
    L37:
        if (r9 != null) goto L41;
        if (r3 != null) goto L49;
        return null;
    L49:
        return r3.getDynamicIcon();
    L41:
        return r9;
    L26:
        if (r3 == null) goto L28;
        r9 = r3.getVerticalIcon();
        goto L29
    L28:
        r9 = null;
        goto L29
    L17:
        r2 = false;
        goto L18
    L20:
        r1 = null;
    L22:
        r3 = null;
        goto L23
    L50:
        return null;
    }

    public String getVsMsgBoardLiveEpisodeId(DataCenter r3) {
        int r0 = k1.a;
        if (r3 != null) goto L5;
    L12:
        return null;
    L5:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r3) == null) goto L12;
        Episode r4 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r3);
        if (r4 == null) goto L12;
        EpisodeBasicInfo r5 = r4.episodeBasicInfo;
        if (r5 == null) goto L12;
        return String.valueOf(r5.getOriginEpisodeId());
    }

    public void paidStatusChanged(DataCenter r4) {
        int r0 = k1.a;
        nm1.e r1 = pm1.f.c();
        com.bytedance.android.livesdk.chatroom.msgboard.a r2 = null;
        if (r1 == null) goto L7;
        ReplayDataContext r3 = r1.h(r4);
        if (r3 == null) goto L7;
        com.bytedance.live.datacontext.j r5 = r3.getVsMsgBoardDataContext();
    L9:
        if ((r5 instanceof com.bytedance.live.datacontext.j) == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.msgboard.a r6 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r5.getValue();
        if (r6 == null) goto L14;
    L23:
        if (r6 == null) goto L26;
        r6.setPaidStatusChanged(true);
        return;
    L26:
        return;
    L14:
        vr1.u r7 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r4, null, 2);
        if (r7 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.msgboard.a r8 = r7.L0();
    L19:
        if ((r8 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == false) goto L22;
        r2 = r8;
    L22:
        r6 = r2;
        goto L23
    L17:
        r8 = null;
    L7:
        r5 = null;
        goto L9
    }

    public boolean replayToolbarDataHasDress(Episode r7) {
        int r0 = k1.a;
        if (r7 == null) goto L40;
        List r8 = r7.getPannelToolbarList();
        String r1 = null;
        if (r8 == null) goto L27;
        Iterator r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L20;
        Object r2 = r9.next();
        IVSToolbarConfigData r3 = (IVSToolbarConfigData) r2;
        if (r3.getToolbarType() != 12) goto L17;
        boolean r5 = true;
        if (r3.getDisplayType() == 1) goto L18;
        if (r3.getDisplayType() != 3) goto L17;
    L18:
        if (r5 == false) goto L9;
    L21:
        IVSToolbarConfigData r4 = (IVSToolbarConfigData) r2;
        if (r4 == null) goto L27;
        IMainVSToolbarConfigData r10 = r4.castToOrNull(IMainVSToolbarConfigData.class);
        if (r10 == null) goto L27;
        r1 = r10.getExtra();
    L17:
        r5 = false;
        goto L18
    L20:
        r2 = null;
    L27:
        if (com.ss.ugc.effectplatform.util.r.b(r1) == true) goto L41;
        JSONObject r11 = new JSONObject(r1);
        if (r11.has("has_dress") == true) goto L32;
        return false;
    L32:
        return r11.optBoolean("has_dress");
    L41:
        return false;
    L40:
        return false;
    }

    public void requestDressData(DataCenter r4) {
        int r0 = k1.a;
        nm1.e r1 = pm1.f.c();
        com.bytedance.android.livesdk.chatroom.msgboard.a r2 = null;
        if (r1 == null) goto L7;
        ReplayDataContext r3 = r1.h(null);
        if (r3 == null) goto L7;
        com.bytedance.live.datacontext.j r5 = r3.getVsMsgBoardDataContext();
    L9:
        if ((r5 instanceof com.bytedance.live.datacontext.j) == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.msgboard.a r6 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r5.getValue();
        if (r6 == null) goto L14;
    L23:
        if (r6 != null) goto L25;
    L27:
        if (r6 == null) goto L32;
        Observable r7 = r6.getInteractDressInfo();
        if (r7 == null) goto L33;
        r7.subscribe(i1.a, new j1(r6));
        return;
    L33:
        return;
    L32:
        return;
    L25:
        if (r6.getRequestDressAlready() != true) goto L27;
        return;
    L14:
        vr1.u r8 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r4, null, 2);
        if (r8 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.msgboard.a r9 = r8.L0();
    L19:
        if ((r9 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == false) goto L22;
        r2 = r9;
    L22:
        r6 = r2;
        goto L23
    L17:
        r9 = null;
    L7:
        r5 = null;
        goto L9
    }

    public boolean roomToolbarDataHasDress(IRoom r6) {
        int r0 = k1.a;
        if (r6 == null) goto L35;
        ILiveToolbarData r7 = r6.getToolbarData();
        String r1 = null;
        if (r7 == null) goto L23;
        List r8 = r7.getToolbarDataList();
        if (r8 == null) goto L23;
        Iterator r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L18;
        Object r2 = r9.next();
        if (((IToolbarComponentData) r2).getId() != 27) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L11;
    L19:
        IToolbarComponentData r4 = (IToolbarComponentData) r2;
        if (r4 == null) goto L23;
        r1 = r4.getExtraData();
        goto L23
    L15:
        r3 = false;
        goto L16
    L18:
        r2 = null;
    L23:
        if (com.ss.ugc.effectplatform.util.r.b(r1) == true) goto L36;
        JSONObject r10 = new JSONObject(r1);
        if (r10.has("has_dress") == true) goto L28;
        return false;
    L28:
        return r10.optBoolean("has_dress");
    L36:
        return false;
    L35:
        return false;
    }
}
