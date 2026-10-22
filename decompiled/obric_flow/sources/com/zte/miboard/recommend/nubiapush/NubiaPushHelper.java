package com.zte.miboard.recommend.nubiapush;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import cn.nubia.neopush.sdk.NeoPushClient;
import cn.nubia.neopush.sdk.NeoPushMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import m.b0;
import m.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class NubiaPushHelper {
    private static final String APP_ID = "1910751";
    private static final String APP_KEY = "183cda25ba7a4628a599c99b94372137";
    private static final String CMD_MID_AIRPLANE = "20";
    private static final String CMD_MID_AIRPLANE_CANCEL = "22";
    private static final String CMD_MID_AIRPLANE_MODIFY = "21";
    private static final int PUSH_TYPE_REG = 2;
    private static final int PUSH_TYPE_TRAVEL = 1;
    private static final String SECRET_KEY = "de7781317ca94456929e7e81d9457e7b";
    private static final String TAG = "Mi_R_NubiaPushHelper";
    private boolean mCanceled;

    public NubiaPushHelper() {
        this.mCanceled = false;
    }

    private void handleNeoPush(String r5) {
        int r10 = new JSONObject(r5).getInt("pushType");     // Catch: Exception -> L7
        if (r10 != 2) goto L10;
        handleReg(r5);     // Catch: Exception -> L7
        return;
    L10:
        if (r10 != 1) goto L13;
        handleTravelNew(r5);     // Catch: Exception -> L7
        return;
    L13:
        Log.d(TAG, "handleNeoPush error. type=" + r10);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        kotlin.collections.a.m(e, "handleNeoPush. e=", TAG);
    }

    private void handleReg(String r5) {
        String r10 = TAG;
        Log.d(r10, "handleReg.");
        JSONObject r11 = new JSONObject(new JSONObject(r5).getString("subscribeInfo"));     // Catch: Exception -> L11
        String r12 = r11.getString("regId");     // Catch: Exception -> L11
        String r13 = PushUtils.getRegId();     // Catch: Exception -> L11
        Log.d(r10, "handleReg. myRegId=" + r13 + " regId=" + r12);     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r13) == false) goto L6;
        return;
    L6:
        if (r13.equals(r12) == false) goto L17;
        boolean r14 = r11.getBoolean("pushStatus");     // Catch: Exception -> L11
        PushUtils.setRegisteredState(r14);     // Catch: Exception -> L11
        if (r14 == false) goto L18;
        PushUtils.setRegAgainMiboardCache("");     // Catch: Exception -> L11
        return;
    L18:
        return;
    L17:
        return;
    L11:
        e = move-exception;
        kotlin.collections.a.m(e, "handleReg. e=", TAG);
    }

    private void handleTravelNew(String r10) {
        String r5 = TAG;
        Log.d(r5, "handleTravelNew start.");
        Uri r11 = b0.a(h.a());
        Bundle r12 = new Bundle();
        JSONObject r13 = new JSONObject(r10).getJSONObject("flightInfo");     // Catch: Exception -> L5
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L5
        r14.put("dataKey", "flight");     // Catch: Exception -> L5
        r14.put("eventType", "push");     // Catch: Exception -> L5
        r14.put("travelDataObj", r13);     // Catch: Exception -> L5
        String r15 = r14.toString();     // Catch: Exception -> L5
        Log.d(r5, "dataStr for miboard = " + r15);     // Catch: Exception -> L5
        r12.putString("travel_data", r15);     // Catch: Exception -> L5
    L30:
        ContentProviderClient r16 = h.a().getContentResolver().acquireUnstableContentProviderClient(r11);     // Catch: Exception -> L18
        Bundle r17 = r16.call("on_travel_data_changed", null, r12);     // Catch: Throwable -> L13
        boolean r18 = false;
        if (r17 != null) goto L11;
    L15:
        Log.d(TAG, "handleTravelNew handled=" + r18);     // Catch: Throwable -> L13
        r16.close();     // Catch: Exception -> L18
        return;
    L11:
        if (r17.getBoolean("boolean_result", false) == false) goto L15;
        r18 = true;
    L13:
        th = move-exception;
        if (r16 != null) goto L31;
    L25:
        throw th;     // Catch: Exception -> L18
    L31:
        r16.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        kotlin.collections.a.m(e, "handleTravelNew e2=", TAG);
        return;
    L5:
        e = move-exception;
        kotlin.collections.a.m(e, "handleTravelNew e=", TAG);
        goto L30
    }

    public void onReceivePassThroughMessage(List<NeoPushMessage> r5) {
        Log.d(TAG, "onReceivePassThroughMessage.");
        if (r5 == null) goto L12;
        Iterator<NeoPushMessage> r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L20;
        NeoPushMessage r11 = r10.next();
        Log.e(TAG, "onReceivePassThroughMessage np=" + r11);
        if (r11 == null) goto L6;
        if (TextUtils.isEmpty(r11.getContent()) == true) goto L6;
        handleNeoPush(r11.getContent());
        goto L6
    L20:
        return;
    }

    public void registerPush(@NonNull Context r5) {
        ArrayList r10 = new ArrayList(Arrays.asList(new String[]{PushUtils.getRegId()}));
        String r11 = TAG;
        Log.e(r11, "registerPush.");
        NeoPushClient.registerPush(r5, APP_ID, APP_KEY, r10, null);
        if (TextUtils.isEmpty(PushUtils.getRegAgainMiboardCache()) == true) goto L5;
    L8:
        Log.d(r11, "registerPush. RegisterAgainUtils!");
        RegisterAgainUtils.getInstance();
        new VeryZhunRegister().tryRegisterAgain();
        return;
    L5:
        if (PushUtils.isRegisteredState() == false) goto L8;
    }

    public void unregisterPush(Context r5) {
        Log.d(TAG, "unregisterPush!");
        NeoPushClient.unRegisterPush(r5);
    }
}
