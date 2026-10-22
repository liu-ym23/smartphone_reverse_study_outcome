package com.bytedance.android.ec.adapter.api;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface f {
    void callInjection();

    void chooseCategory(String r1, String r10);

    void handleWebcastInRoomSchema(Map<String, Object> r1);

    void roomEnter(String r1, String r10, String r11, Map<String, String> r12);

    void sendMessage(JSONObject r1, Function1<? super JSONObject, Unit> r10);

    boolean showEnterRoomTicketExpandDialog(boolean r1);

    boolean showExitRoomTicketExpandDialog(boolean r1, Runnable r10);

    DialogFragment showLiveFlashFragment(Context r1, Bundle r10);

    Fragment showLivePromotionListFragment(Context r1, JSONObject r10);

    void switchFlashConfig(boolean r1);

    void tryShowSaasCouponDialog(Context r1, Bundle r10, Function1<? super JSONObject, Unit> r11);

    void updatePromotionList();
}
