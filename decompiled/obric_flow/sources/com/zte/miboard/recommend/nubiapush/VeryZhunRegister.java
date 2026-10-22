package com.zte.miboard.recommend.nubiapush;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import m.h;
import okhttp3.OkHttpClient;
import okhttp3.h0;
import okhttp3.l0;
import okhttp3.n0;
import okhttp3.q0;
import okhttp3.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class VeryZhunRegister {
    private static final String ORIGIN_ID = "gh_63bebc919103";
    private static final int RESULT_FAILED_ALREADY_REGISTERED = 1;
    private static final int RESULT_FAILED_NOT_HAVE_REG_ID = 2;
    private static final int RESULT_FAILED_OTHER = 3;
    private static final int RESULT_SUCCESS = 0;
    private static final String TAG = "Mi_R_VeryZhunRegister";
    private Bundle mBundle;

    public static class ExtrasData {
        private String miboard;
        private String phone;
        private String regId;

        private ExtrasData() {
        }

        public static /* synthetic */ String access$402(ExtrasData r5, String r10) {
            r5.regId = r10;
            return r10;
        }

        public static /* synthetic */ String access$502(ExtrasData r5, String r10) {
            r5.phone = r10;
            return r10;
        }

        public static /* synthetic */ String access$602(ExtrasData r5, String r10) {
            r5.miboard = r10;
            return r10;
        }

        public /* synthetic */ ExtrasData(AnonymousClass1 r5) {
            this();
        }
    }

    public VeryZhunRegister() {
        this.mBundle = null;
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ void access$100(VeryZhunRegister r5, String r10) {
        r5.parseUnRegisterString(r10);
    }

    public static /* synthetic */ void access$200(VeryZhunRegister r5, String r10) {
        r5.parseRegisterAgain(r10);
    }

    public static /* synthetic */ void access$700(VeryZhunRegister r5) {
        r5.zteRegisterFail();
    }

    public static /* synthetic */ void access$800(VeryZhunRegister r5, String r10) {
        r5.parseZteRegister(r10);
    }

    private int apkRegister() {
        Context r5 = h.a();
        Intent r10 = new Intent("android.intent.action.VIEW");
        r10.setFlags(268435456);
        r10.setData(Uri.parse(getApkUri()));
        Log.d(TAG, "apkRegister.");     // Catch: Exception -> L6
        r5.startActivity(r10);     // Catch: Exception -> L6
        return 0;
    L6:
        e = move-exception;
        kotlin.collections.a.m(e, "apkRegister, e=", TAG);
        return 3;
    }

    private boolean apkSupport() {
        String r5 = TAG;
        Log.d(r5, "apkSupport URI=" + getApkUri());
        Intent r10 = new Intent("android.intent.action.VIEW");
        r10.setFlags(268435456);
        r10.setData(Uri.parse(getApkUri()));
    L8:
        e = move-exception;
        kotlin.collections.a.m(e, "apkSupport e=", TAG);
    L10:
        Log.d(TAG, "apkSupport false.");
        return false;
    L4:
        if (h.a().getPackageManager().queryIntentActivities(r10, 0).isEmpty() == true) goto L10;
        Log.d(r5, "apkSupport true.");     // Catch: Exception -> L8
        return true;
    }

    private String getApkUri() {
        Bundle r5 = this.mBundle;
        String r10 = "";
        if (r5 == null) goto L6;
        r10 = r5.getString("miboard", "");
    L6:
        return "veryzhun://com.feeyo.vz/my_certificate?zxDevId=" + PushUtils.getDevId() + "&extras={\"miboard\":\"" + r10 + "\",\"regId\":\"" + PushUtils.getRegId() + "\",\"phone\":\"" + PushUtils.getPhoneId() + "\"}";
    }

    private q0 getRegisterAgainBody() {
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L4
        r5.put("deviceId", PushUtils.getDevId());     // Catch: Exception -> L4
        r5.put("regId", PushUtils.getRegId());     // Catch: Exception -> L4
        r5.put("phone", PushUtils.getPhoneId());     // Catch: Exception -> L4
        r5.put("action", "bind");     // Catch: Exception -> L4
        r5.put("miboard", PushUtils.getRegAgainMiboardCache());     // Catch: Exception -> L4
        String r10 = r5.toString();     // Catch: Exception -> L4
    L6:
        Pattern r11 = h0.e;
        return q0.create(z.j("application/json"), r10);
    L4:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "getRegisterAgainBody e=", TAG);
        r10 = "";
        goto L6
    }

    private q0 getUnRegisterBody() {
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L4
        r5.put("deviceId", PushUtils.getDevId());     // Catch: Exception -> L4
        r5.put("regId", PushUtils.getRegId());     // Catch: Exception -> L4
        String r10 = r5.toString();     // Catch: Exception -> L4
    L6:
        Pattern r11 = h0.e;
        return q0.create(z.j("application/json"), r10);
    L4:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "getUnRegisterBody e=", TAG);
        r10 = "";
        goto L6
    }

    private String getWeiChatPath() {
        Bundle r5 = this.mBundle;
        String r10 = "";
        if (r5 == null) goto L5;
        r10 = r5.getString("miboard", "");
    L5:
        ExtrasData r11 = new ExtrasData(null);
        ExtrasData.access$402(r11, PushUtils.getRegId());
        ExtrasData.access$502(r11, PushUtils.getPhoneId());
        ExtrasData.access$602(r11, r10);
        String r12 = "/pages/h5/h5?login=1&url=" + Uri.encode(androidx.constraintlayout.motion.widget.a.p("https://app.variflight.com/html/module/account/auth.html?zxDevId=", PushUtils.getDevId(), "&zxExtras=", new Gson().toJson(r11)));
        androidx.constraintlayout.motion.widget.a.A("getWeiChatPath miniProgramPath=", r12, TAG);
        return r12;
    }

    private q0 getZteRegisterBody() {
        Bundle r5 = this.mBundle;
        String r10 = "";
        if (r5 == null) goto L5;
        String r11 = r5.getString("miboard", "");
    L12:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L8
        r12.put("deviceId", PushUtils.getDevId());     // Catch: Exception -> L8
        r12.put("regId", PushUtils.getRegId());     // Catch: Exception -> L8
        r12.put("phone", PushUtils.getPhoneId());     // Catch: Exception -> L8
        r12.put("miboard", r11);     // Catch: Exception -> L8
        r10 = r12.toString();     // Catch: Exception -> L8
    L10:
        Pattern r13 = h0.e;
        return q0.create(z.j("application/json"), r10);
    L8:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "getZteRegisterBody e=", TAG);
        goto L10
    L5:
        r11 = "";
        goto L12
    }

    private void parseRegisterAgain(String r5) {
    L6:
        e = move-exception;
        kotlin.collections.a.m(e, "parseRegisterAgain e=", TAG);
        return;
    L3:
        if (new JSONObject(r5).getBoolean(NotificationCompat.CATEGORY_STATUS) == false) goto L11;
        Log.d(TAG, "parseRegisterAgain true.");     // Catch: Exception -> L6
        PushUtils.setRegisteredState(true);     // Catch: Exception -> L6
        PushUtils.setRegAgainMiboardCache("");     // Catch: Exception -> L6
        return;
    }

    private void parseUnRegisterString(String r5) {
    L6:
        e = move-exception;
        kotlin.collections.a.m(e, "parseUnRegisterString e=", TAG);
        return;
    L3:
        if (new JSONObject(r5).getBoolean(NotificationCompat.CATEGORY_STATUS) == false) goto L11;
        Log.d(TAG, "parseUnRegisterString true.");     // Catch: Exception -> L6
        PushUtils.setRegisteredState(false);     // Catch: Exception -> L6
        return;
    }

    private void parseZteRegister(String r5) {
    L6:
        e = move-exception;
        kotlin.collections.a.m(e, "parseZteRegister e=", TAG);
        return;
    L3:
        if (new JSONObject(r5).getBoolean(NotificationCompat.CATEGORY_STATUS) == false) goto L8;
        Log.d(TAG, "parseZteRegister true.");     // Catch: Exception -> L6
        PushUtils.setRegisteredState(true);     // Catch: Exception -> L6
        PushUtils.setRegAgainMiboardCache("");     // Catch: Exception -> L6
        return;
    L8:
        zteRegisterFail();     // Catch: Exception -> L6
    }

    private Bundle registerAgain() {
        if (TextUtils.isEmpty(PushUtils.getRegId()) == false) goto L5;
    L9:
        Log.e(TAG, "registerAgain. empty");
        return null;
    L5:
        if (TextUtils.isEmpty(PushUtils.getDevId()) == true) goto L9;
        return startRegisterAgain();
    }

    private Bundle startRegisterAgain() {
        Log.e(TAG, "startRegisterAgain.");
        OkHttpClient r5 = new OkHttpClient(new l0());     // Catch: Exception -> L5
        q0 r10 = getRegisterAgainBody();     // Catch: Exception -> L5
        n0 r11 = new n0();     // Catch: Exception -> L5
        r11.g("https://travel-api.ztems.com/travel/client/unBindDevice");     // Catch: Exception -> L5
        r11.c("Content-Type", "application/json");     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r10, "body");     // Catch: Exception -> L5
        r11.d("POST", r10);     // Catch: Exception -> L5
        r5.a(r11.b()).enqueue(new AnonymousClass2(this));     // Catch: Exception -> L5
    L7:
        Bundle r12 = new Bundle();
        r12.putString("result", "0");
        return r12;
    L5:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "startRegisterAgain e=", TAG);
        goto L7
    }

    private void startUnRegister() {
        OkHttpClient r5 = new OkHttpClient(new l0());     // Catch: Exception -> L5
        q0 r10 = getUnRegisterBody();     // Catch: Exception -> L5
        n0 r11 = new n0();     // Catch: Exception -> L5
        r11.g("https://travel-api.ztems.com/travel/client/unBindDevice");     // Catch: Exception -> L5
        r11.c("Content-Type", "application/json");     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r10, "body");     // Catch: Exception -> L5
        r11.d("POST", r10);     // Catch: Exception -> L5
        r5.a(r11.b()).enqueue(new AnonymousClass1(this));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "startRecognize e=", TAG);
    }

    private int weiChatRegister() {
        Context r5 = h.a();
        String r10 = getWeiChatPath();
        Intent r11 = new Intent();     // Catch: Exception -> L6
        r11.setClassName("com.zte.fingerflashpay", "com.zte.fingerflashpay.FingerFlashPayActivity");     // Catch: Exception -> L6
        r11.setFlags(268468224);     // Catch: Exception -> L6
        r11.setAction("com.zte.fingerflashpay.WECHAT_TASK");     // Catch: Exception -> L6
        r11.putExtra("miniProgramOriginId", ORIGIN_ID);     // Catch: Exception -> L6
        r11.putExtra("miniProgramPath", r10);     // Catch: Exception -> L6
        r11.putExtra("floatassist", true);     // Catch: Exception -> L6
        r11.putExtra("userid", -2);     // Catch: Exception -> L6
        r11.setPackage("com.zte.fingerflashpay");     // Catch: Exception -> L6
        r5.startActivity(r11);     // Catch: Exception -> L6
        Log.d(TAG, "weiChatRegister.");     // Catch: Exception -> L6
        return 0;
    L6:
        e = move-exception;
        kotlin.collections.a.m(e, "weiChatRegister, e=", TAG);
        return 3;
    }

    private int zteRegister() {
        Log.e(TAG, "zteRegister.");
        OkHttpClient r5 = new OkHttpClient(new l0());     // Catch: Exception -> L6
        q0 r10 = getZteRegisterBody();     // Catch: Exception -> L6
        n0 r11 = new n0();     // Catch: Exception -> L6
        r11.g("https://travel-api.ztems.com/travel/client/querySubscribe");     // Catch: Exception -> L6
        r11.c("Content-Type", "application/json");     // Catch: Exception -> L6
        Intrinsics.checkNotNullParameter(r10, "body");     // Catch: Exception -> L6
        r11.d("POST", r10);     // Catch: Exception -> L6
        r5.a(r11.b()).enqueue(new AnonymousClass3(this));     // Catch: Exception -> L6
        return 0;
    L6:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "zteRegister e=", TAG);
        return 3;
    }

    private void zteRegisterFail() {
        if (apkSupport() == true) goto L6;
        weiChatRegister();
        return;
    L6:
        apkRegister();
    }

    public int startRegister(Bundle r5) {
        this.mBundle = r5;
        if (PushUtils.isRegisteredState() == false) goto L7;
        Log.d(TAG, "startRegister. RESULT_FAILED_ALREADY_REGISTERED");
        return 1;
    L7:
        if (TextUtils.isEmpty(PushUtils.getRegId()) == false) goto L11;
        Log.d(TAG, "startRegister. RESULT_FAILED_NOT_HAVE_REG_ID");
        return 2;
    L11:
        if (zteRegister() != 0) goto L15;
        return 0;
    L15:
        if (apkSupport() == true) goto L19;
        return weiChatRegister();
    L19:
        return apkRegister();
    }

    public Bundle tryRegisterAgain() {
        if (TextUtils.isEmpty(PushUtils.getRegAgainMiboardCache()) == false) goto L5;
    L9:
        Log.e(TAG, "tryRegisterAgain. error!");
        return null;
    L5:
        if (PushUtils.isRegisteredState() == true) goto L9;
        return registerAgain();
    }

    public int unRegister() {
        if (TextUtils.isEmpty(PushUtils.getRegId()) == false) goto L5;
    L9:
        Log.e(TAG, "unRegister. empty");
        return -1;
    L5:
        if (TextUtils.isEmpty(PushUtils.getDevId()) == true) goto L9;
        startUnRegister();
        return 0;
    }
}
