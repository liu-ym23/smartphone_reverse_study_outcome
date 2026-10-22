package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.linkbase.SupportUpdatePlayMode;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.videotalk.ui.BaseEqualGridItemDecoration;
import com.bytedance.android.live.ui.ClipFrameLayout;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface l extends xg0.a {

    public static final class a {
        public static /* synthetic */ Pair a(l r2) {
            return r2.Yl(1, null);
        }

        public static /* synthetic */ void b(l r15, IRoom r16, DataCenter r17, m r18, BaseEqualGridItemDecoration r19, vg0.a r20, SeatAnimEngineWrapper r21, int r22, int r23, int r24, se0.c r25, com.bytedance.android.live.liveinteract.plantform.datamerge.d r26, int r27) {
            if ((r27 & 32) == 0) goto L5;
            SeatAnimEngineWrapper r9 = null;
        L7:
            if ((r27 & 256) == 0) goto L9;
            int r12 = 0;
        L11:
            if ((r27 & 512) == 0) goto L13;
            se0.c r13 = null;
        L15:
            if ((r27 & 1024) == 0) goto L17;
            com.bytedance.android.live.liveinteract.plantform.datamerge.d r14 = null;
        L18:
            r15.Sm(r16, r17, r18, r19, r20, r9, r22, r23, r12, r13, r14);
            return;
        L17:
            r14 = r26;
            goto L18
        L13:
            r13 = r25;
            goto L15
        L9:
            r12 = r24;
            goto L11
        L5:
            r9 = r21;
            goto L7
        }
    }

    boolean Gi();

    void Ha(m r1, boolean r2);

    void K1(String r1);

    void Ma();

    void O7(List<? extends tf0.e> r1);

    void Pj(String r1, View r2, boolean r3);

    int S0(String r1);

    void Sm(IRoom r1, DataCenter r2, m r3, BaseEqualGridItemDecoration r4, vg0.a r5, SeatAnimEngineWrapper r6, int r7, int r8, int r9, se0.c r10, com.bytedance.android.live.liveinteract.plantform.datamerge.d r11);

    void Sp(m r1, int r2, int r3);

    void T8();

    void U3(m r1, int r2, int r3);

    void Xl(com.bytedance.android.live.liveinteract.plantform.datamerge.a r1);

    void Yd(m r1, int r2, int r3);

    void Ye(View r1);

    Pair<Integer, Integer> Yl(int r1, pn0.f r2);

    void a6(tf0.o.a r1);

    void b7(@SupportUpdatePlayMode int r1);

    ConstraintLayout.LayoutParams getCurRvLayoutParams();

    m getCurrentLayoutConfig();

    List<tf0.e> getDataList();

    Long getEnterRoomTime();

    ClipFrameLayout getFirstSeatVHShadowContainer();

    ClipFrameLayout getFirstSeatVHShadowFloatContainer();

    BaseLinkSeatWindowView getLinkSeatWindowView();

    JsonObject getLinkmicAreaFrameInfo();

    JsonObject getLinkmicSeatListInfo();

    RecyclerView getMicSeatRecyclerView();

    fg0.a getMultiAdapterWrapper();

    LinkMicRecyclerView getRecyclerView();

    ug0.a getRvLayoutManager();

    ConstraintLayout getSingleSurfaceViewContainer();

    boolean gg();

    void hi(String r1, boolean r2, boolean r3, boolean r4);

    void jf();

    void le(SurfaceView r1);

    void m3(MultiLinkGuestViewBinder.a r1, boolean r2);

    void pd(View r1);

    void release();

    void setMFirstVHShadowViewChange(CommonLinkSeatWindowView.a r1);

    void setUIViewValid(boolean r1);

    ViewGroup td();

    View vb();

    Pair<Integer, Integer> vn(int r1, pn0.f r2);

    void x8();

    void zk(String r1, View r2, boolean r3);
}
