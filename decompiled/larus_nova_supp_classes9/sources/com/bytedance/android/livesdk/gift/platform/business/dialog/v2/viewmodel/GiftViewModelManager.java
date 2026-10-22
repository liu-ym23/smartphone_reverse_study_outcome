package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftSendPreCheckService;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import i12.e;
import i12.o;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class GiftViewModelManager extends ViewModel {
    public static final int LIVE_GIFT_DIALOG_RECHARGE_LOGIN = 1002;
    public static final int LIVE_GIFT_DIALOG_SEND_LOGIN = 1001;
    public static final int LIVE_GIFT_DIALOG_TASK_GIFT_LOGIN = 1003;
    public static final int PAGE_COUNT = 8;
    public static final String TAG = "GiftViewModelManager";
    private DataCenter mDataCenter;
    private boolean mIsAnchor;
    private boolean mIsVertical;
    private IRoom mRoom;

    public void onCleared() {
        this.mDataCenter = null;
        super.onCleared();
    }

    public boolean isGiftUpdateOptimizeOpen() {
        if (((Boolean) nz1.a.h.getValue(null, nz1.a.a[6])).booleanValue() == true) goto L8;
        getDataCenter();
        if (u.p() == true) goto L8;
        return false;
    L8:
        return true;
    }

    public GiftViewModelManager() {
    }

    public DataCenter getDataCenter() {
        return this.mDataCenter;
    }

    public boolean getIsVertical() {
        return this.mIsVertical;
    }

    public IRoom getRoom() {
        return this.mRoom;
    }

    public boolean getSendToAnchor(IBaseUser r1) {
        return d.l(r1);
    }

    public boolean isPreCheckSendGift(IBaseUser r5) {
        KProperty[] r0 = s.a;
        e r1 = o.b();
        if (r1 == null) goto L5;
        Object r2 = m.e.d(r1, GiftSendPreCheckService.class);
    L7:
        if (((GiftSendPreCheckService) r2) == null) goto L16;
        e r3 = o.b();
        if (r3 == null) goto L11;
        Object r4 = m.e.d(r3, GiftSendPreCheckService.class);
    L12:
        GiftSendPreCheckService r6 = (GiftSendPreCheckService) r4;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "receiver");
        if (r6.d(r5, null, null) == 0) goto L16;
        return false;
    L11:
        r4 = null;
    L16:
        return true;
    L5:
        r2 = null;
        goto L7
    }

    public void setDataCenter(DataCenter r1) {
        this.mDataCenter = r1;
    }

    public void setAllCommonData(Context r2, DataCenter r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        this.mDataCenter = r3;
        this.mRoom = x.a();
        this.mIsAnchor = ((Boolean) this.mDataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.mIsVertical = ((Boolean) this.mDataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        return;
    L8:
        return;
    }
}
