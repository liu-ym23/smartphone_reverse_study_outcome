package com.bytedance.android.live.profit.fansclub;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface o extends dy0.d {

    public static final class a {
        public static /* synthetic */ void a(o r6, Context r7, DataCenter r8, ViewGroup r9) {
            r6.p1(r7, r8, r9, true, true);
        }
    }

    ViewGroup D5();

    void E5();

    boolean Ei(DataCenter r1);

    void Gd(int r1);

    g P5(IBaseUser r1);

    int R2();

    p Z8(FansClubEntranceParams r1);

    void ae(Context r1, DataCenter r2, ViewGroup r3, View r4, ViewGroup r5, ViewGroup r6, ViewGroup r7);

    View e1();

    com.bytedance.live.datacontext.m<? extends Map<String, String>> getExtra();

    com.bytedance.live.datacontext.m<? extends l> getFansGroupInfo();

    com.bytedance.live.datacontext.m<e> getParticipateIncentive();

    com.bytedance.live.datacontext.m<? extends g> getProfile();

    com.bytedance.live.datacontext.m<? extends Integer> getScene();

    com.bytedance.live.datacontext.m<? extends r> getShopFansClubData();

    boolean h5(DataCenter r1);

    boolean isMember();

    ViewGroup na();

    void p1(Context r1, DataCenter r2, ViewGroup r3, boolean r4, boolean r5);

    Observable<c> r1();

    ViewGroup yl();
}
