package com.zte.miboard.recommend;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.a;
import androidx.core.app.NotificationCompat;
import androidx.room.RoomMasterTable;
import com.google.gson.Gson;
import com.lynx.tasm.behavior.v0;
import com.zte.aimodel.IVendorAIModelService;
import com.zte.miboard.recommend.agent.HandleService;
import com.zte.miboard.recommend.nubiapush.PushUtils;
import com.zte.miboard.recommend.nubiapush.RegisterAgainUtils;
import com.zte.miboard.recommend.nubiapush.VeryZhunRegister;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Pattern;
import m.h;
import m.l;
import m.m;
import m.o;
import m.p;
import m.q;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class RecommendProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16481a = "Mi_R_RecommendProvider";

    public RecommendProvider() {
    }

    private Bundle a(Bundle r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (RecommendManager.isRecommendEnable() == true) goto L9;
        Log.e(f16481a, "handleRecommendAi !isRecommendEnable.");
        return null;
    L9:
        String r11 = r10.getString("value", "");
        if ("userdebug".equals(Build.TYPE) == false) goto L12;
        a.A("sms_call_txt=", r11, f16481a);
    L14:
        if (m.f19885h != null) goto L16;
        m.f19885h = new m();
    L16:
        m r5 = m.f19885h;
        com.bytedance.ai.resource.core.net.a r12 = new com.bytedance.ai.resource.core.net.a(19);
        r5.getClass();
        boolean r13 = Pattern.compile("[a-zA-Z0-9\\s+]+").matcher(r11).matches();
        String r14 = m.g;
        if (r13 == false) goto L19;
        Log.e(r14, "execute. isNumberAndAlphaSpace");
    L33:
        return null;
    L19:
        String[] r15 = {"http://", "https://", "ftp://", "file://"};
        int r16 = 0;
    L21:
        if (r16 >= 4) goto L27;
        if (r11.toLowerCase().startsWith(r15[r16]) == true) goto L24;
        r16 = r16 + 1;
        goto L21
    L24:
        Log.e(r14, "execute. isWebAddress");
        goto L33
    L27:
        if (TextUtils.isEmpty(r11) == false) goto L29;
        Log.d(r14, "execute. empty.");
        goto L33
    L29:
        Log.d(r14, "execute. isLocal=false");
        ArrayList r17 = r5.f19890c;
        r17.add(new l(1, r11, r12, new StringBuilder()));
        l r18 = (l) r17.get(r17.size() - 1);
        if (r5.f19889b != null) goto L32;
        ComponentName r19 = new ComponentName("com.zte.aimodel", "com.zte.aimodel.VendorAIModelService");
        Intent r20 = new Intent();
        r20.setAction(IVendorAIModelService.DESCRIPTOR);
        r20.setComponent(r19);
        Log.d(r14, "bindService. ret=" + h.a().bindService(r20, r5.e, 1));
        goto L33
    L32:
        r5.f19888a.post(r5.d);
        goto L33
    L12:
        Log.d(f16481a, "sms_call_txt.");
        goto L14
    }

    public static /* synthetic */ void b(String r5, boolean r10, Bundle r11) {
        a(r5, r10, r11);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String r10, @Nullable String r11, @Nullable Bundle r12) {
        String r5 = f16481a;
        Log.d(r5, "call method=" + r10 + " arg=" + r11);
        if ("recommend".equals(r10) == false) goto L13;
        if (TextUtils.isEmpty(r11) == false) goto L9;
        return a(r12);
    L9:
        if (NotificationCompat.CATEGORY_STATUS.equals(r11) == false) goto L37;
        Log.d(r5, "recommend status.");
        Bundle r13 = new Bundle();
        r13.putBoolean("TripStatus", true);
        r13.putString("RecommendName", "");
        r13.putString("RecommendPath", "");
        r13.putString("VeryZhunDevId", PushUtils.getDevId());
        r13.putString("VeryZhunRegId", PushUtils.getRegId());
        Log.d(r5, "recommend status return.");
        return r13;
    L37:
        Log.d(r5, "return null.");
        return null;
    L13:
        if ("veryzhun".equals(r10) == false) goto L37;
        if ("registerAgain".equals(r11) == false) goto L17;
    L18:
        if (r12 == null) goto L21;
        PushUtils.setMiboardPersist(r12.getString("miboard", ""), false);
    L21:
        if ("registerAgain".equals(r11) == false) goto L26;
        if (r12 == null) goto L26;
        return b(r12);
    L26:
        if (RecommendManager.isRecommendEnable() == true) goto L30;
        Bundle r14 = new Bundle();
        r14.putString("result", "-2");
        return r14;
    L30:
        if ("register".equals(r11) == false) goto L34;
        int r15 = new VeryZhunRegister().startRegister(r12);
        Bundle r16 = new Bundle();
        r16.putString("result", "" + r15);
        return r16;
    L34:
        if ("unregister".equals(r11) == false) goto L37;
        int r17 = new VeryZhunRegister().unRegister();
        Bundle r18 = new Bundle();
        r18.putString("result", "" + r17);
        return r18;
    L17:
        if ("register".equals(r11) == false) goto L21;
        goto L18
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri r5, @Nullable String r10, @Nullable String[] r11) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri r5, @Nullable ContentValues r10) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri r5, @Nullable String[] r10, @Nullable String r11, @Nullable String[] r12, @Nullable String r13) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri r5, @Nullable ContentValues r10, @Nullable String r11, @Nullable String[] r12) {
        return 0;
    }

    private Bundle b(Bundle r5) {
        if (r5 == null) goto L5;
        PushUtils.setRegAgainMiboardCache(r5.getString("miboard", ""));
        RegisterAgainUtils.getInstance();
    L5:
        if (RecommendManager.isRecommendEnable() == true) goto L9;
        Bundle r10 = new Bundle();
        r10.putString("result", "-2");
        return r10;
    L9:
        return new VeryZhunRegister().tryRegisterAgain();
    }

    private static void a(String r17, boolean r18, Bundle r19) {
        if (r18 == true) goto L6;
        Log.e(f16481a, "handleRecommendAi cb hasProcessed false.");
        return;
    L6:
        int r10 = r19.getInt("value", 0);
        if (r10 == 16) goto L10;
        Log.e(f16481a, "handleRecommendAi cb return type=" + r10);
        return;
    L10:
        q r11 = new q();
        r11.f19904b = new ArrayList();
        String r12 = q.f19902c;
        Log.d(r12, "initData.");
        r11.f19903a = r19.getString("value_extra1");
        String r5 = r19.getString("value_extra2");
        if (TextUtils.isEmpty(r5) == false) goto L126;
        Log.d(r12, "initData. json empty.");
    L56:
        Iterator r13 = r11.f19904b.iterator();
    L58:
        if (r13.hasNext() == false) goto L122;
        ArrayList r14 = (ArrayList) r13.next();
        HashMap r15 = new HashMap();
        a.B(new StringBuilder("parseAndSend mCmdId="), r11.f19903a, r12);
        String r16 = r11.f19903a;
        r16.getClass();
        byte r110 = -1;
        switch(r16.hashCode()) {
            case 1598: goto L96;
            case 1599: goto L92;
            case 1600: goto L88;
            case 1629: goto L83;
            case 1630: goto L79;
            case 1631: goto L75;
            case 1660: goto L71;
            case 1661: goto L67;
            case 1662: goto L63;
            default: goto L99;
        };
    L99:
        switch(r110) {
            case 0: goto L113;
            case 1: goto L112;
            case 2: goto L111;
            case 3: goto L110;
            case 4: goto L109;
            case 5: goto L107;
            case 6: goto L106;
            case 7: goto L103;
            case 8: goto L101;
            default: goto L100;
        };
    L101:
        r15.put("dataType", o.f19891a[2]);
        r15.put("bookingType", o.f19892b[2]);
        q.d(r14, r15, o.f19899m);
    L124:
        String r20 = new Gson().toJson(r15);     // Catch: Exception -> L116
    L118:
        Intent r21 = new Intent("com.zte.intent.action.AGENT_RECOMMEND_ACTION");
        r21.putExtra("agentRecommendKey", r20);
        r21.setClass(h.a(), HandleService.class);
        h.a().startService(r21);
        if ("userdebug".equals(Build.TYPE) == true) goto L120;
        Log.d(r12, "send.");
        goto L58
    L120:
        a.A("send, extra=", r20, r12);
    L116:
        e = move-exception;
        kotlin.collections.a.m(e, "hashMapToStr, e=", r12);
        r20 = null;
        goto L118
    L103:
        r15.put("dataType", o.f19891a[2]);
        r15.put("bookingType", o.f19892b[1]);
        q.d(r14, r15, o.f19896j);
        q.d(r14, r15, o.f19897k);
        q.d(r14, r15, o.f19898l);
        goto L124
    L106:
        r15.put("dataType", o.f19891a[2]);
        r15.put("bookingType", o.f19892b[0]);
        q.d(r14, r15, o.f19895i);
        goto L124
    L107:
        boolean r111 = true;
        r15.put("dataType", o.f19891a[1]);
        r15.put("bookingType", o.f19892b[2]);
        q.d(r14, r15, o.f19894h);
        goto L124
    L109:
        r111 = true;
        r15.put("dataType", o.f19891a[1]);
        r15.put("bookingType", o.f19892b[1]);
        q.d(r14, r15, o.g);
        goto L124
    L110:
        r15.put("dataType", o.f19891a[1]);
        r15.put("bookingType", o.f19892b[0]);
        q.d(r14, r15, o.f);
        goto L124
    L111:
        r15.put("dataType", o.f19891a[0]);
        r15.put("bookingType", o.f19892b[2]);
        q.d(r14, r15, o.e);
        goto L124
    L112:
        r15.put("dataType", o.f19891a[0]);
        r15.put("bookingType", o.f19892b[1]);
        q.d(r14, r15, o.d);
        goto L124
    L113:
        r15.put("dataType", o.f19891a[0]);
        r15.put("bookingType", o.f19892b[0]);
        q.d(r14, r15, o.f19893c);
        goto L124
    L100:
        a.B(new StringBuilder("parseAndSend error. mCmdId="), r11.f19903a, r12);
        goto L58
    L63:
        if (r16.equals(RoomMasterTable.DEFAULT_ID) == false) goto L99;
        byte r22 = 8;
    L86:
        r110 = r22;
        goto L99
    L67:
        if (r16.equals("41") == false) goto L99;
        r22 = 7;
        goto L86
    L71:
        if (r16.equals("40") == false) goto L99;
        r22 = 6;
        goto L86
    L75:
        if (r16.equals("32") == false) goto L99;
        r22 = 5;
        goto L86
    L79:
        if (r16.equals("31") == false) goto L99;
        r22 = 4;
        goto L86
    L83:
        if (r16.equals("30") == false) goto L99;
        r22 = 3;
        goto L86
    L88:
        if (r16.equals("22") == false) goto L99;
        r110 = 2;
        goto L99
    L92:
        if (r16.equals("21") == false) goto L99;
        r110 = 1;
        goto L99
    L96:
        if (r16.equals("20") == false) goto L99;
        r110 = 0;
        goto L99
    L122:
        Log.d(r12, "parse end!");
        return;
    L126:
        JSONArray r112 = new JSONArray(r5);     // Catch: Exception -> L16
        if (r112.length() >= 1) goto L18;
        Log.d(r12, "initData. array empty.");     // Catch: Exception -> L16
        goto L56
    L18:
        int r23 = 0;
    L20:
        if (r23 >= r112.length()) goto L33;
        JSONObject r113 = r112.getJSONObject(r23);     // Catch: Exception -> L16
        Iterator<String> r114 = r113.keys();     // Catch: Exception -> L16
        ArrayList r115 = new ArrayList();     // Catch: Exception -> L16
    L23:
        if (r114.hasNext() == false) goto L32;
        String r24 = r114.next();     // Catch: Exception -> L16
        String r116 = (String) r113.get(r24);     // Catch: Exception -> L16
        if ("入住日期".equals(r24) == false) goto L27;
    L30:
        String r25 = v0.m(r116);     // Catch: Exception -> L16
        Log.d(r12, "initData. new value=" + r25);     // Catch: Exception -> L16
    L31:
        r115.add(new p(r24, r25));     // Catch: Exception -> L16
        r112 = r112;
        goto L23
    L27:
        if ("退房日期".equals(r24) == true) goto L30;
        r25 = r116;
        goto L31
    L32:
        r11.f19904b.add(r115);     // Catch: Exception -> L16
        r23 = r23 + 1;     // Catch: Exception -> L16
        r112 = r112;
        goto L20
    L33:
        String r26 = "乘机人姓名";
        if (Objects.equals(r11.f19903a, "30") == false) goto L36;
    L47:
        r26 = "乘车人姓名";
    L48:
        r11.f19904b = q.a(r26, r11.f19904b);     // Catch: Exception -> L16
        if (Objects.equals(r11.f19903a, "40") == false) goto L51;
    L52:
        r11.c();     // Catch: Exception -> L16
    L55:
        Log.d(r12, "initData exit.");
        goto L56
    L51:
        if (Objects.equals(r11.f19903a, RoomMasterTable.DEFAULT_ID) == false) goto L55;
    L36:
        if (Objects.equals(r11.f19903a, "31") == true) goto L47;
        if (Objects.equals(r11.f19903a, "32") == true) goto L47;
        if (Objects.equals(r11.f19903a, "40") == false) goto L43;
    L46:
        r26 = "入住人姓名";
        goto L48
    L43:
        if (Objects.equals(r11.f19903a, RoomMasterTable.DEFAULT_ID) == true) goto L46;
        if (Objects.equals(r11.f19903a, "41") == false) goto L48;
    L16:
        e = move-exception;
        kotlin.collections.a.m(e, "initData e=", r12);
        goto L55
    }
}
