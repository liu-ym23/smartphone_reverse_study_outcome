package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkLastEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.livesdk.config.kk;
import com.bytedance.android.livesdk.config.r60;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/datamergev2/WindowListHelperV2;", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class WindowListHelperV2 extends com.bytedance.android.live.liveinteract.plantform.datamerge.a implements Observer<KVData> {
    public static final Integer l = null;
    public ih0.b j;
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ WindowListHelperV2 a;

        public b(WindowListHelperV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            List r5 = (List) r4;
            Lazy r0 = MultiLinkLoadWidgetUtils.a;
            WindowListHelperV2 r1 = this.a;
            Integer r2 = WindowListHelperV2.l;
            MultiLinkLoadWidgetUtils.n(r1.e, "WindowListHelperV2", "call linkedUserMergeDataListObservable, hasInited = " + this.a.a + "， itSize = " + r5.size());
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelperV2", "linkedUserMergeDataListObservable change, size: " + r5.size() + ", it = " + this.a);
            this.a.u();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ WindowListHelperV2 a;

        public c(WindowListHelperV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "specialStubListObservable change, size: " + r4.size());
            this.a.u();
            return;
        }
    }

    static {
        l = (Integer) kk.a.getValue();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void b() {
        if (this.a == false) goto L6;
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(this.e, "WindowListHelperV2", "already attach, hasInited: " + this.a);
        return;
    L6:
        Lazy r1 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(this.e, "WindowListHelperV2", "call attach");
        int r2 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r3 = this.e;
        IRoom r4 = this.d;
        if (r4 == null) goto L9;
        long r5 = r4.getId();
    L10:
        MultiSceneEnterRoomStatisticsUtils r6 = MultiSceneEnterRoomStatisticsUtils.a.a(r3, Long.valueOf(r5));
        if (r6 == null) goto L13;
        r6.c();
    L13:
        System.currentTimeMillis();
        x();
        u();
        this.a = true;
        this.j = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.e);
        return;
    L9:
        r5 = 0;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public void u() {
        int r0 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r1 = this.e;
        IRoom r2 = this.d;
        if (r2 == null) goto L5;
        long r3 = r2.getId();
    L6:
        MultiSceneEnterRoomStatisticsUtils r4 = MultiSceneEnterRoomStatisticsUtils.a.a(r1, Long.valueOf(r3));
        if (r4 == null) goto L9;
        r4.c();
    L9:
        hashCode();
        System.currentTimeMillis();
        if (this.g.getUiLayout() != 2) goto L13;
        Integer r5 = 9;
    L16:
        ArrayList r6 = new ArrayList(r5.intValue());
        int r7 = r5.intValue();
        int r8 = 0;
        int r9 = 0;
    L17:
        if (r9 >= r7) goto L19;
        r6.add(g(r9));
        r9 = r9 + 1;
        goto L17
    L19:
        d r10 = this.k.P1();
        if (r10 == null) goto L25;
        IRoom r11 = r10.getRoom();
        if (r11 == null) goto L25;
        String r12 = r11.getOwnerUserIdString();
        if (r12 == null) goto L25;
    L26:
        List<ch0.e> r13 = (List) this.k.f().getValue();
        if (r13 != null) goto L29;
        r13 = new ArrayList();
    L29:
        i(r12, r6, r13, r5.intValue());
        int r14 = r6.size();
        int r15 = 0;
    L30:
        if (r15 >= r14) goto L32;
        ((tf0.e) ListProtector.get(r6, r15)).b = r15;
        r15 = r15 + 1;
        goto L30
    L32:
        IRoom r16 = this.d;
        if (r16 != null) goto L35;
    L36:
        int r17 = r5.intValue();
        if (j() == true) goto L39;
    L71:
        if (((Boolean) r60.a.getValue()).booleanValue() == false) goto L73;
    L81:
        Iterator r18 = r6.iterator();
    L83:
        if (r18.hasNext() == false) goto L99;
        Object r19 = r18.next();
        tf0.e r110 = (tf0.e) r19;
        if ((r110 instanceof MultiLinkGuestViewBinder.a) == true) goto L87;
        r110 = null;
    L87:
        MultiLinkGuestViewBinder.a r111 = (MultiLinkGuestViewBinder.a) r110;
        if (r111 == null) goto L96;
        ch0.e r112 = r111.k;
        if (r112 == null) goto L96;
        ILinkPlayerInfoBridge r113 = r112.a;
        if (r113 == null) goto L96;
        if (r113.isEnlarged() != true) goto L96;
        boolean r114 = true;
    L97:
        if (r114 == false) goto L83;
    L100:
        if (r19 == null) goto L102;
        boolean r20 = true;
    L103:
        if (r20 == true) goto L106;
    L126:
        o(r12, r6);
        n(r12, r6);
        p(r6);
        m(r12, r6, new ch0.l(0, null));
        boolean r21 = Intrinsics.areEqual((Boolean) this.k.F0().getValue(), Boolean.TRUE);
        if (this.g.getUiLayout() != 2) goto L165;
        Iterator r22 = r6.iterator();
        boolean r23 = true;
    L130:
        if (r22.hasNext() == false) goto L150;
        tf0.e r115 = (tf0.e) r22.next();
        if ((r115 instanceof MultiLinkGuestViewBinder.a) == false) goto L130;
        IBaseUser r116 = ((MultiLinkGuestViewBinder.a) r115).k.a.getUser();
        if (r116 == null) goto L137;
        String r117 = r116.getIdString();
        if (r117 == null) goto L137;
    L138:
        d r118 = this.k.P1();
        if (r118 == null) goto L144;
        IRoom r119 = r118.getRoom();
        if (r119 == null) goto L144;
        String r120 = r119.getOwnerUserIdString();
        if (r120 == null) goto L144;
    L146:
        if ((!Intrinsics.areEqual(r117, r120)) == false) goto L130;
        if (r2.a(r120) == false) goto L130;
        r23 = false;
    L144:
        r120 = "";
    L137:
        r117 = "";
        goto L138
    L150:
        boolean r24 = j();
        List r25 = (List) this.k.N0().getValue();
        if (r25 == null) goto L153;
        int r26 = r25.size();
    L154:
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a r121 = (com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a) this.k.p1().getValue();
        if (r121 == null) goto L157;
        int r122 = r121.c;
    L158:
        if (r24 == false) goto L161;
        if (r122 > r26) goto L163;
    L164:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a.q(r6, r8);
    L163:
        r8 = 1;
        goto L164
    L161:
        if (r21 == true) goto L163;
        if (r23 == false) goto L164;
    L157:
        r122 = 0;
        goto L158
    L153:
        r26 = 0;
    L165:
        l(r6, r13, r5.intValue(), r12);
        y(r6);
        v((IVoiceLiveTheme) this.k.G0().getValue(), r6);
        hashCode();
        System.currentTimeMillis();
        this.b.onNext(r6);
        return;
    L106:
        if (j() == true) goto L126;
        Iterator r27 = r6.iterator();
    L110:
        if (r27.hasNext() == false) goto L123;
        Object r123 = r27.next();
        if ((r123 instanceof MultiLinkGuestViewBinder.a) == true) goto L114;
        r123 = null;
    L114:
        MultiLinkGuestViewBinder.a r124 = (MultiLinkGuestViewBinder.a) r123;
        if (r124 == null) goto L110;
        ch0.e r125 = r124.k;
        if (r125 == null) goto L110;
        ILinkPlayerInfoBridge r126 = r125.a;
        if (r126 == null) goto L110;
        if (r126.isEnlarged() != true) goto L110;
        r27.remove();
    L124:
        if (r124 == null) goto L126;
        ListProtector.add(r6, 0, r124);
        goto L126
    L123:
        r124 = null;
        goto L124
    L102:
        r20 = false;
    L96:
        r114 = false;
        goto L97
    L99:
        r19 = null;
        goto L100
    L73:
        if (this.g.getUiLayout() == 3) goto L81;
        if (this.g.getUiLayout() == 6) goto L81;
        if (this.g.getUiLayout() == 11) goto L81;
        if (this.g.getUiLayout() == 12) goto L81;
    L39:
        if (this.g.getUiLayout() == 51) goto L71;
        ArrayList r127 = new ArrayList(r17);
        int r128 = 0;
    L41:
        if (r128 >= r17) goto L43;
        r127.add(g(r128));
        r128 = r128 + 1;
        goto L41
    L43:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a.t(r127, r13, r17);
        int r28 = r127.size();
        int r129 = 0;
    L44:
        if (r129 >= r28) goto L46;
        ((tf0.e) ListProtector.get(r127, r129)).b = r129;
        r129 = r129 + 1;
        goto L44
    L46:
        Iterator r29 = r127.iterator();
    L48:
        if (r29.hasNext() == false) goto L61;
        Object r130 = r29.next();
        if ((r130 instanceof MultiLinkGuestViewBinder.a) == true) goto L52;
        r130 = null;
    L52:
        MultiLinkGuestViewBinder.a r131 = (MultiLinkGuestViewBinder.a) r130;
        if (r131 == null) goto L48;
        ch0.e r132 = r131.k;
        if (r132 == null) goto L48;
        ILinkPlayerInfoBridge r133 = r132.a;
        if (r133 == null) goto L48;
        if (r133.isEnlarged() != true) goto L48;
        r29.remove();
    L62:
        if (r131 == null) goto L64;
        ListProtector.add(r127, 0, r131);
    L64:
        int r30 = r127.size();
        int r134 = 0;
    L65:
        if (r134 >= r30) goto L71;
        if (r6.size() <= r134) goto L69;
        ((tf0.e) ListProtector.get(r6, r134)).b = ((tf0.e) ListProtector.get(r127, r134)).b;
    L69:
        r134 = r134 + 1;
        goto L65
    L61:
        r131 = null;
        goto L62
    L35:
        if (r16.isLiveTypeAudio() == true) goto L71;
    L25:
        r12 = "";
        goto L26
    L13:
        if (this.g.getUiLayout() != 62) goto L15;
        r5 = l;
        goto L16
    L15:
        r5 = Integer.valueOf(this.h.a);
        goto L16
    L5:
        r3 = 0;
        goto L6
    }

    public void x() {
        RxUtilKt.c(this.k.f().subscribe(new b(this)), this.c);
        RxUtilKt.c(this.k.g().subscribe(new c(this)), this.c);
        DataCenter r0 = this.e;
        if (r0 == null) goto L5;
        r0.observeForever("data_order_sing_stage_is_inert", this);
    L5:
        DataCenter r1 = this.e;
        if (r1 == null) goto L8;
        r1.observeForever("data_inner_interactive_song_context_init", this);
    L8:
        DataCenter r2 = this.e;
        if (r2 == null) goto L12;
        r2.observeForever("data_interactive_song_show_player_status_change", this);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public void d() {
        super.d();
        DataCenter r0 = this.e;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final MultiLinkNormalEmptyViewBinder.a g(int r13) {
        return new MultiLinkNormalEmptyViewBinder.a(r13, null, null, false, false, k(), false, false, false, 960);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final MultiLinkLastEmptyViewBinder.a h(int r10) {
        return new MultiLinkLastEmptyViewBinder.a(r10, false, false, k(), false, false, 448);
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (this.a == false) goto L33;
        if (r6 == null) goto L34;
        Object r0 = r6.getData();
        if ((r0 instanceof Object) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L43;
        String r1 = r6.getKey();
        int r2 = r1.hashCode();
        if (r2 == (-423042615)) goto L28;
        if (r2 == 561074735) goto L23;
        if (r2 == 701156312) goto L18;
        return;
    L18:
        if (r1.equals("data_order_sing_stage_is_inert") == false) goto L35;
        ALogger.i("WindowListHelperV2", "order sing stage insert status change value=" + ((Boolean) r6.getData()));
        if (this.a == false) goto L36;
        u();
        return;
    L36:
        return;
    L35:
        return;
    L23:
        if (r1.equals("data_inner_interactive_song_context_init") == false) goto L38;
        ALogger.i("WindowListHelperV2", "interactiveSongContext init success");
        if (this.a == false) goto L39;
        u();
        return;
    L39:
        return;
    L38:
        return;
    L28:
        if (r1.equals("data_interactive_song_show_player_status_change") == false) goto L41;
        ALogger.i("WindowListHelperV2", "interactiveSongContext showPlayer status change value=" + ((Boolean) r6.getData()));
        if (this.a == false) goto L42;
        u();
        return;
    L42:
        return;
    L41:
        return;
    L43:
        return;
    L34:
        return;
    }

    public final void y(List<tf0.e> r13) {
        Intrinsics.checkNotNullParameter(r13, "windowList");
        List r0 = (List) this.k.g().getValue();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L39;
        LinkmicPositionItem r2 = (LinkmicPositionItem) r1.next();
        Iterator<T> r3 = r13.iterator();
        int r4 = 0;
    L10:
        if (r3.hasNext() == false) goto L7;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        tf0.e r7 = (tf0.e) r5;
        if ((r7 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L34;
        if (aj0.b.c(this.g.getUiLayout()) == false) goto L19;
        int r8 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        int r9 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.e((int) r2.getPosition(), this.g.getUiLayout());
    L20:
        MultiLinkNormalEmptyViewBinder.a r10 = (MultiLinkNormalEmptyViewBinder.a) r7;
        if (r10.b() != r9) goto L38;
        int r11 = r2.getStatus();
        LinkmicPositionItem.LinkmicPositionStatus r12 = LinkmicPositionItem.LinkmicPositionStatus.LOCKED;
        if (r11 != r12.ordinal()) goto L32;
        int r14 = r10.b();
        int r15 = r12.ordinal();
        LinkmicPositionItem r16 = com.bytedance.android.live.liveinteract.multianchor.model.h.a(r2);
        Integer r17 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r17 != null) goto L28;
    L30:
        boolean r18 = false;
    L31:
        ListProtector.set(r13, r4, new MultiLinkSpecialViewBinder.a(r14, r15, r16, r18));
        goto L38
    L28:
        if (2 != r17.intValue()) goto L30;
        r18 = true;
        goto L31
    L32:
        r10.l(com.bytedance.android.live.liveinteract.multianchor.model.h.a(r2));
    L38:
        r4 = r6;
        goto L10
    L19:
        r9 = (int) r2.getPosition();
        goto L20
    L34:
        if ((r7 instanceof MultiLinkGuestViewBinder.a) == false) goto L38;
        MultiLinkGuestViewBinder.a r19 = (MultiLinkGuestViewBinder.a) r7;
        if (r19.k.a.getUserPosition() != ((int) r2.getPosition())) goto L38;
        r19.l = com.bytedance.android.live.liveinteract.multianchor.model.h.a(r2);
        b0.a(r19.k.a, r2);
        goto L38
    }

    public WindowListHelperV2(IRoom r8, DataCenter r9, boolean r10, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r11, com.bytedance.android.live.liveinteract.plantform.datamerge.k r12, com.bytedance.android.live.liveinteract.plantform.datamerge.d r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "layoutConfig");
        Intrinsics.checkNotNullParameter(r12, "windowConfig");
        Intrinsics.checkNotNullParameter(r13, "linkUserDataMergeCenter");
        super(r8, r9, r10, r11, r12, r14);
        this.k = r13;
    }
}
