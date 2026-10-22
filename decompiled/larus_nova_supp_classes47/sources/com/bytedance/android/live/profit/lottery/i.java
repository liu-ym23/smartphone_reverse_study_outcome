package com.bytedance.android.live.profit.lottery;

import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface i extends dy0.d {
    public static final a B0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        B0 = a.a;
    }

    com.bytedance.live.datacontext.m<? extends ParticipateStatus> getCurCandidateState();

    com.bytedance.live.datacontext.n<? extends g> getCurrentLottery();

    o getLotteryPluginStore();

    com.bytedance.live.datacontext.k<LotteryState.b> getOnFinish();

    com.bytedance.live.datacontext.k<Unit> getOnHidePanel();

    com.bytedance.live.datacontext.k<Integer> getOnIconClick();

    com.bytedance.live.datacontext.k<JSONObject> getOnPopupSchemaFailed();

    com.bytedance.live.datacontext.k<Unit> getOnToolbarButtonClick();
}
