package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ BaseMultiLinkWindowManager a;

    public a(BaseMultiLinkWindowManager r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        BaseMultiLinkWindowManager r6 = this.a;
        int r0 = BaseMultiLinkWindowManager.H;
        r6.getClass();
        ALogger.e("BaseMultiLinkWindowManager", "[smoothEnterRoom] resetContainerViewVisibilityForTimeout for timeout");
        r6.C.put("cmd_multi_enter_room_remove_view_mock", Boolean.TRUE);
        UtilityKotlinExtentionsKt.x(r6.y);
    }
}
