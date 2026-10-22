package com.bytedance.android.live.core.gift;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.gift.model.Gift;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import g50.b;
import g50.c;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.revenue.service.gift.GiftServiceWrapper")
public interface IGiftCoreService extends c {
    public static final int OPEN_INTERACT_SOURCE_FROM_LIVING = 2;
    public static final int OPEN_INTERACT_SOURCE_FROM_OPEN_LIVE = 1;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.gift.IGiftCoreService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ h1 $default$findGiftById(IGiftCoreService r0, long r1) {
            return r0.findGiftById(r1);
        }
    }

    void addGiftSendResultListener(b r1);

    boolean allowSendToGuest();

    boolean checkGroupContainerType(int r1);

    void closeGiftDialog();

    Gift findGiftById(long r1);

    /* JADX INFO: renamed from: findGiftById, reason: collision with other method in class */
    /* bridge */ /* synthetic */ h1 m567findGiftById(long r1);

    @Override // g50.c
    h2 findLiteGiftById(long r1);

    String getAssetsPath(String r1, long r2);

    IBaseUser getDefaultUserToSendGift();

    boolean getGiftTraySwitch();

    boolean getNeedShowGiftEffectSwitch();

    void initGiftEffectDialog();

    boolean isVSGiftIconShow(DataCenter r1);

    boolean needFrequencyRoomNotifyMessage();

    void openGiftDialog(int r1);

    void openGiftDialog(int r1, long r2, Bundle r4, String r5, long r6);

    @Override // g50.c
    /* synthetic */ void openGiftDialog(int r1, long r2, Bundle r4, List<String> r5, boolean r6, String r7);

    void openGiftDialog(int r1, long r2, String r4, Bundle r5, int r6, JSONObject r7);

    @Override // g50.c
    /* synthetic */ void openGiftDialog(int r1, long r2, String r4, Bundle r5, int r6, JSONObject r7, String r8);

    void openGiftDialog(int r1, long r2, String r4, Bundle r5, JSONObject r6);

    void openGiftDialog(int r1, User r2);

    @Override // g50.c
    /* synthetic */ void openGiftDialog(IBaseUser r1);

    @Override // g50.c
    /* synthetic */ void openGiftDialog(IBaseUser r1, Bundle r2);

    void openGiftDialog(String r1);

    void openGiftDialog(String r1, User r2);

    void openInteractGiftDialog(Context r1, int r2, Long r3, String r4, Function0<Unit> r5, DialogInterface.OnDismissListener r6);

    void registerRecommendReceiver(long r1, String r3, Map<String, String> r4, Map<String, String> r5);

    @Override // g50.c
    /* synthetic */ void registerRecommendReceiver(String r1, String r2, Map<String, String> r3, Map<String, String> r4);

    void removeGiftSendResultListener(b r1);

    void setDefaultUserToSendGift(User r1);

    void setGiftTraySwitch(boolean r1);

    void setNeedShowGiftEffectSwitch(boolean r1);

    void unRegisterRecommendReceiver(String r1, Map<String, String> r2);
}
