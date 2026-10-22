package m;

import ai.j0;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.writer.DaoWriter;
import cn.nubia.neopush.commons.AppUtil;
import com.obric.oui.lisitem.a;
import com.zte.aimodel.IVendorAIModelService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final String g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static m f19885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f19886i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap f19887j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f19888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IVendorAIModelService f19889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f19890c;
    public final a d;
    public final j e;
    public final k f;

    static {
        g = "Mi_R_".concat(m.class.getSimpleName());
        f19886i = "userdebug".equals(Build.TYPE);
        f19887j = new b.a();
    }

    public m() {
        this.f19890c = new ArrayList();
        this.d = new a(this, 15);
        this.e = new j(this);
        this.f = new k();
        HandlerThread r5 = new HandlerThread("float_ai_cmd2");
        r5.start();
        this.f19888a = new Handler(r5.getLooper());
    }

    public static String a(String r13) {
        String r5 = g;
        JSONObject r10 = new JSONObject(r13);     // Catch: Exception -> L26
        String r11 = r10.getString("出发时间");     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r11) == true) goto L39;
        Matcher r12 = Pattern.compile("^(\\d{1,2})-(\\d{1,2})(\\s+\\d{1,2}:\\d{1,2})?$").matcher(r11.trim());     // Catch: Exception -> L26
        if (r12.matches() == false) goto L40;
        String r14 = r12.group(1);     // Catch: Exception -> L26
        int r15 = Integer.parseInt(r14);     // Catch: Exception -> L26 NumberFormatException -> L30
        if (r15 >= 1) goto L12;
        return r13;
    L12:
        if (r15 > 12) goto L47;
        Calendar r16 = Calendar.getInstance();     // Catch: Exception -> L26
        int r17 = r16.get(2) + 1;     // Catch: Exception -> L26
        if (r15 != 1) goto L42;
        if (r17 != 12) goto L43;
        int r18 = r16.get(1) + 1;     // Catch: Exception -> L26
        String r19 = r12.group(2);     // Catch: Exception -> L26
        r12.group(3);     // Catch: Exception -> L26
        int r20 = Integer.parseInt(r19);     // Catch: Exception -> L26 NumberFormatException -> L29
        if (r20 >= 1) goto L21;
        return r13;
    L21:
        if (r20 > 31) goto L48;
        String r21 = r18 + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r11.trim();     // Catch: Exception -> L26
        r10.put("出发时间", r21);     // Catch: Exception -> L26
        if (f19886i == false) goto L45;
        Log.d(r5, "correctTrainTimeInternal. field=出发时间, original=" + r11 + ", corrected=" + r21);     // Catch: Exception -> L26
    L45:
        return r10.toString();
    L48:
        return r13;
    L29:
        Log.d(r5, "correctTrainTimeInternal. invalid day=" + r19);     // Catch: Exception -> L26
        return r13;
    L43:
        return r13;
    L42:
        return r13;
    L47:
        return r13;
    L30:
        Log.d(r5, "correctTrainTimeInternal. invalid month=" + r14);     // Catch: Exception -> L26
        return r13;
    L40:
        return r13;
    L39:
        return r13;
    L26:
        e = move-exception;
        kotlin.collections.a.m(e, "correctTrainTimeInternal. e=", r5);
        return r13;
    }

    public static String b(l r22, String r23) {
        int r5 = r22.f19882a;
        String r10 = g;
        if (r5 != 21) goto L24;
        JSONObject r11 = new JSONObject(r23);     // Catch: Exception -> L20
        String r12 = r11.getString("乘机人姓名");     // Catch: Exception -> L20
        String r13 = r11.getString("原出发地");     // Catch: Exception -> L20
        String r14 = r11.getString("原到达地");     // Catch: Exception -> L20
        String r15 = r11.getString("原出发时间");     // Catch: Exception -> L20
        String r16 = r11.getString("原到达时间");     // Catch: Exception -> L20
        String r17 = r11.getString("原航班号");     // Catch: Exception -> L20
        String r18 = r11.getString("现出发地");     // Catch: Exception -> L20
        String r19 = r11.getString("现到达地");     // Catch: Exception -> L20
        String r110 = r11.getString("现出发时间");     // Catch: Exception -> L20
        String r20 = r11.getString("现到达时间");     // Catch: Exception -> L20
        String r21 = r11.getString("现航班号");     // Catch: Exception -> L18
        if (e(r13, r18) == true) goto L9;
    L50:
        return r23;
    L9:
        if (e(r14, r19) == false) goto L50;
        if (e(r15, r110) == false) goto L50;
        if (e(r16, r20) == false) goto L50;
        if (e(r17, r21) == false) goto L50;
        r22.f19882a = 22;     // Catch: Exception -> L18
        JSONObject r24 = new JSONObject();     // Catch: Exception -> L18
        r24.put("乘机人姓名", r12);     // Catch: Exception -> L18
        r24.put("出发地", r13);     // Catch: Exception -> L18
        r24.put("到达地", r14);     // Catch: Exception -> L18
        r24.put("出发时间", r15);     // Catch: Exception -> L18
        r24.put("到达时间", r16);     // Catch: Exception -> L18
        r24.put("航班号", r17);     // Catch: Exception -> L18
        return r24.toString();
    L18:
        e = e;
    L22:
        kotlin.collections.a.m(e, "changeModifyContent. e=", r10);
    L20:
        e = e;
        goto L22
    L24:
        if (r5 != 31) goto L50;
        JSONObject r25 = new JSONObject(r23);     // Catch: Exception -> L47
        String r26 = r25.getString("乘车人姓名");     // Catch: Exception -> L47
        String r27 = r25.getString("原出发站");     // Catch: Exception -> L47
        String r111 = r25.getString("原到达站");     // Catch: Exception -> L47
        String r112 = r25.getString("原出发时间");     // Catch: Exception -> L47
        String r113 = r25.getString("原到达时间");     // Catch: Exception -> L47
        String r114 = r25.getString("原车次");     // Catch: Exception -> L47
        String r115 = r25.getString("原车厢号");     // Catch: Exception -> L47
        String r28 = r25.getString("原座位号");     // Catch: Exception -> L47
        String r29 = r25.getString("原检票口");     // Catch: Exception -> L45
        String r30 = r25.getString("现出发站");     // Catch: Exception -> L45
        String r31 = r25.getString("现到达站");     // Catch: Exception -> L45
        String r116 = r25.getString("现出发时间");     // Catch: Exception -> L45
        String r32 = r25.getString("现到达时间");     // Catch: Exception -> L45
        String r33 = r25.getString("现车次");     // Catch: Exception -> L45
        String r34 = r25.getString("现车厢号");     // Catch: Exception -> L45
        String r35 = r25.getString("现座位号");     // Catch: Exception -> L45
        String r36 = r25.getString("现检票口");     // Catch: Exception -> L45
        if (e(r27, r30) == false) goto L50;
        if (e(r111, r31) == false) goto L50;
        if (e(r112, r116) == false) goto L50;
        if (e(r113, r32) == false) goto L50;
        if (e(r114, r33) == false) goto L50;
        if (e(r115, r34) == false) goto L50;
        if (e(r28, r35) == false) goto L50;
        if (e(r29, r36) == false) goto L50;
        r22.f19882a = 32;     // Catch: Exception -> L45
        JSONObject r37 = new JSONObject();     // Catch: Exception -> L45
        r37.put("乘车人姓名", r26);     // Catch: Exception -> L45
        r37.put("出发站", r27);     // Catch: Exception -> L45
        r37.put("到达站", r111);     // Catch: Exception -> L45
        r37.put("出发时间", r112);     // Catch: Exception -> L45
        r37.put("到达时间", r113);     // Catch: Exception -> L45
        r37.put("车次", r114);     // Catch: Exception -> L45
        r37.put("车厢号", r115);     // Catch: Exception -> L45
        r37.put("座位号", r28);     // Catch: Exception -> L45
        r37.put("检票口", r29);     // Catch: Exception -> L45
        return r37.toString();
    L45:
        e = e;
    L49:
        kotlin.collections.a.m(e, "changeModifyContent. e2=", r10);
    L47:
        e = e;
        goto L49
    }

    public static void c(l r5, boolean r10, Bundle r11) {
        new Handler().post(new com.bytedance.pia.core.tracing.c(r5, r10, r11));
    }

    public static void d(l r5, String r10) {
        Bundle r11 = new Bundle();
        r11.putInt("value", 16);
        r11.putString("value_extra1", "" + r5.f19882a);
        r11.putString("value_extra2", r10);
        r11.putString("value_extra3", r5.f19883b);
        boolean r12 = f19886i;
        String r13 = g;
        if (r12 == false) goto L5;
        Log.d(r13, "doNotifyTrip cmd=" + r5.f19882a + " data=" + r10);
    L6:
        c(r5, true, r11);
        return;
    L5:
        Log.d(r13, "doNotifyTrip");
        goto L6
    }

    public static boolean e(String r5, String r10) {
        if (TextUtils.isEmpty(r5) == true) goto L10;
        if (TextUtils.isEmpty(r10) == true) goto L10;
        return r5.equals(r10);
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r10) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public static void f(l r10, String r11) {
        int r5 = r10.f19882a;
        if (r5 != 80) goto L5;
        return;
    L5:
        if (r5 == 81) goto L54;
        String r12 = "";
        String r13 = r11.replaceFirst("(?s).*?\\[", "[").replaceAll("\n", "");
        boolean r14 = f19886i;
        String r15 = g;
        if (r14 == false) goto L10;
        androidx.constraintlayout.motion.widget.a.A("handleContent. ret=", r13, r15);
    L45:
        StringBuilder r16 = new StringBuilder();     // Catch: Exception -> L20
        JSONArray r17 = new JSONArray(r13);     // Catch: Exception -> L20
        if (r17.length() <= 0) goto L30;
        int r18 = 0;
    L16:
        if (r18 >= r17.length()) goto L32;
        Log.d(r15, "handleContent. i=" + r18);     // Catch: Exception -> L20
        String r19 = r17.getJSONObject(r18).toString();     // Catch: Exception -> L20
        if (r10.f19882a != 30) goto L23;
        r19 = a(r19);     // Catch: Exception -> L20
    L23:
        if (k(r10, r19) == true) goto L25;
        Log.d(r15, "handleContent. !isContentCorrect");     // Catch: Exception -> L20
    L29:
        r18 = r18 + 1;     // Catch: Exception -> L20
        goto L16
    L25:
        String r20 = b(r10, r19);     // Catch: Exception -> L20
        if (r16.length() <= 0) goto L28;
        r16.append(",");     // Catch: Exception -> L20
        r16.append(r20);     // Catch: Exception -> L20
        goto L29
    L28:
        r16.append("[");     // Catch: Exception -> L20
        r16.append(r20);     // Catch: Exception -> L20
    L32:
        if (r16.length() <= 0) goto L37;
        r16.append("]");     // Catch: Exception -> L20
        r12 = r16.toString();     // Catch: Exception -> L20
    L37:
        if (TextUtils.isEmpty(r12) == false) goto L47;
        Log.d(r15, "handleContent. isEmpty!");
        c(r10, false, null);
        return;
    L47:
        d(r10, r12);     // Catch: Exception -> L42
        return;
    L42:
        e = move-exception;
        kotlin.collections.a.m(e, "handleContent e2=", r15);
        c(r10, false, null);
        return;
    L30:
        Log.d(r15, "handleContent. array error!");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        kotlin.collections.a.m(e, "handleContent. e1=", r15);
        goto L37
    L10:
        Log.d(r15, "handleContent.");
        goto L45
    }

    public static boolean j(String r11) {
        String r5 = g;
        SimpleDateFormat r10 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar r12 = Calendar.getInstance();
        r12.setTime(r10.parse(r11));     // Catch: Exception -> L9
        long r13 = System.currentTimeMillis();
        if ((r12.getTimeInMillis() + AppUtil.MILLIS_IN_DAYS) > r13) goto L8;
        Log.d(r5, "isDateCorrect error, current=" + r13);
        return false;
    L8:
        return true;
    L9:
        SimpleDateFormat r14 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar r15 = Calendar.getInstance();
        r15.setTime(r14.parse(Calendar.getInstance().get(1) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r11));     // Catch: Exception -> L15
        long r16 = System.currentTimeMillis();
        if ((r15.getTimeInMillis() + AppUtil.MILLIS_IN_DAYS) > r16) goto L17;
        Log.d(r5, "isDateCorrect error, current=" + r16);
    L22:
        return false;
    L17:
        return true;
    L15:
        e = move-exception;
        kotlin.collections.a.m(e, "isDateCorrect e=", r5);
        goto L22
    }

    public static boolean k(l r5, String r10) {
        boolean r11 = TextUtils.isEmpty(r10);
        String r12 = g;
        if (r11 == false) goto L7;
        Log.d(r12, "isContentCorrect. empty.");
        return false;
    L7:
        if (r10.contains("XXX") == false) goto L10;
        Log.d(r12, "isContentCorrect. contains XXX.");
        return false;
    L10:
        int r13 = r5.f19882a;
        switch(r13) {
            case 20: goto L92;
            case 21: goto L90;
            case 22: goto L92;
            default: goto L12;
        };
    L12:
        switch(r13) {
            case 30: goto L88;
            case 31: goto L98;
            case 32: goto L88;
            default: goto L14;
        };
    L88:
        JSONObject r14 = new JSONObject(r10);     // Catch: Exception -> L59
        if (TextUtils.isEmpty(r14.getString("出发站")) == true) goto L110;
        String r15 = r14.getString("出发时间");     // Catch: Exception -> L59
        if (TextUtils.isEmpty(r15) == true) goto L111;
        if (l(r15) == true) goto L112;
        return false;
    L112:
        return true;
    L111:
        return false;
    L110:
        return false;
    L59:
        e = move-exception;
        kotlin.collections.a.m(e, "isTrainCorrect. e=", r12);
        return false;
    L98:
        JSONObject r16 = new JSONObject(r10);     // Catch: Exception -> L46
        if (TextUtils.isEmpty(r16.getString("现出发站")) == true) goto L106;
        String r17 = r16.getString("现出发时间");     // Catch: Exception -> L46
        if (TextUtils.isEmpty(r17) == true) goto L107;
        if (l(r17) == true) goto L108;
        return false;
    L108:
        return true;
    L107:
        return false;
    L106:
        return false;
    L46:
        e = move-exception;
        kotlin.collections.a.m(e, "isTrainModifyCorrect. e=", r12);
        return false;
    L14:
        switch(r13) {
            case 40: goto L96;
            case 41: goto L94;
            case 42: goto L96;
            default: goto L15;
        };
    L15:
        return true;
    L94:
        if (TextUtils.isEmpty(new JSONObject(r10).getString("酒店名称")) == false) goto L100;
        return false;
    L100:
        return true;
    L20:
        e = move-exception;
        kotlin.collections.a.m(e, "isHotelModifyCorrect. e=", r12);
        return false;
    L96:
        JSONObject r18 = new JSONObject(r10);     // Catch: Exception -> L33
        if (TextUtils.isEmpty(r18.getString("酒店名称")) == true) goto L102;
        String r19 = r18.getString("入住日期");     // Catch: Exception -> L33
        if (TextUtils.isEmpty(r19) == true) goto L103;
        if (j(r19) == true) goto L104;
        return false;
    L104:
        return true;
    L103:
        return false;
    L102:
        return false;
    L33:
        e = move-exception;
        kotlin.collections.a.m(e, "isHotelCorrect. e=", r12);
        return false;
    L90:
        JSONObject r20 = new JSONObject(r10);     // Catch: Exception -> L72
        if (TextUtils.isEmpty(r20.getString("现出发地")) == true) goto L114;
        String r21 = r20.getString("现出发时间");     // Catch: Exception -> L72
        if (TextUtils.isEmpty(r21) == true) goto L115;
        if (l(r21) == true) goto L116;
        return false;
    L116:
        return true;
    L115:
        return false;
    L114:
        return false;
    L72:
        e = move-exception;
        kotlin.collections.a.m(e, "isAirplaneModifyCorrect. e=", r12);
        return false;
    L92:
        JSONObject r22 = new JSONObject(r10);     // Catch: Exception -> L85
        if (TextUtils.isEmpty(r22.getString("出发地")) == true) goto L118;
        String r23 = r22.getString("出发时间");     // Catch: Exception -> L85
        if (TextUtils.isEmpty(r23) == true) goto L119;
        if (l(r23) == true) goto L120;
        return false;
    L120:
        return true;
    L119:
        return false;
    L118:
        return false;
    L85:
        e = move-exception;
        kotlin.collections.a.m(e, "isAirplaneCorrect. e=", r12);
        return false;
    }

    public static boolean l(String r10) {
        String r5 = g;
        String r11 = r10.trim();
        Calendar r12 = Calendar.getInstance();
        if (r11.length() != 5) goto L5;
    L6:
        r11 = r12.get(1) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r11;
    L8:
        if (r11.length() != 10) goto L10;
        String r13 = "yyyy-MM-dd";
    L11:
        SimpleDateFormat r14 = new SimpleDateFormat(r13, Locale.ENGLISH);
        Calendar r15 = Calendar.getInstance();
        r15.setTime(r14.parse(r11));     // Catch: Exception -> L18
        long r16 = System.currentTimeMillis();
        if (r15.getTimeInMillis() > r16) goto L17;
        Log.d(r5, "isTimeCorrect error, current=" + r16);
        return false;
    L17:
        return true;
    L18:
        e = move-exception;
        kotlin.collections.a.m(e, "isTimeCorrect e=", r5);
        return false;
    L10:
        r13 = "yyyy-MM-dd HH:mm";
        goto L11
    L5:
        if (r11.length() != 11) goto L8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [int] */
    public final void g(l r10, String r11) {
        String r5 = g;
        ?? r12 = Integer.parseInt(r11);     // Catch: Exception -> L11
        Log.d(r5, "handleType1. type=" + r12);     // Catch: Exception -> L11
        ArrayList r13 = this.f19890c;
        if (r12 == 3) goto L7;
        if (r12 != 2) goto L18;
        r13.add(new l(3, r10.f19883b, r10.f19884c, r10.d));     // Catch: Exception -> L9
        return;
    L18:
        if (r12 == 4) goto L20;
        c(r10, false, null);     // Catch: Exception -> L11
        return;
    L20:
        r13.add(new l(7, r10.f19883b, r10.f19884c, r10.d));     // Catch: Exception -> L9
        return;
    L7:
        r13.add(new l(2, r10.f19883b, r10.f19884c, r10.d));     // Catch: Exception -> L9
        return;
    L9:
        e = e;
        r10 = r12;
    L24:
        kotlin.collections.a.m(e, "handleType1 e=", r5);
        c(r10, false, null);
        return;
    L11:
        e = e;
        goto L24
    }

    public final void h() {
        if (this.f19890c.isEmpty() == false) goto L15;
        Handler r5 = this.f19888a;
        if (r5 == null) goto L11;
        if (r5.hasCallbacks(this.d) == false) goto L11;
        return;
    L11:
        if (this.f19889b != null) goto L13;
        return;
    L13:
        h.a().unbindService(this.e);
        this.f19889b = null;
        Log.d(g, "unbindService. ");
        return;
    }

    public final void i(l r10, String r11) {
        String r12 = Pattern.compile("[^\\u4e00-\\u9fa5]").matcher(r11).replaceAll("").replace("。", "");
        String r5 = j0.C("handleType2. ret=", r12);
        String r13 = g;
        Log.d(r13, r5);
        Integer r14 = (Integer) f19887j.get(r12);     // Catch: Exception -> L27
        if (r14 != null) goto L6;
        int r15 = 0;
    L8:
        if (r15 != 5) goto L10;
    L22:
        l r16 = new l(r15, r10.f19883b, r10.f19884c, r10.d);     // Catch: Exception -> L27
        this.f19890c.add(r16);     // Catch: Exception -> L25
        return;
    L25:
        e = e;
        r10 = r16;
    L28:
        kotlin.collections.a.m(e, "handleType2 e=", r13);
        c(r10, false, null);
        return;
    L10:
        if (r15 != 6) goto L12;
        return;
    L12:
        if (r15 == 50) goto L22;
        if (r15 == 80) goto L22;
        if (r15 == 81) goto L22;
        switch(r15) {
            case 20: goto L22;
            case 21: goto L22;
            case 22: goto L22;
            default: goto L18;
        };     // Catch: Exception -> L27
    L18:
        switch(r15) {
            case 30: goto L22;
            case 31: goto L22;
            case 32: goto L22;
            default: goto L19;
        };     // Catch: Exception -> L27
    L19:
        switch(r15) {
            case 40: goto L22;
            case 41: goto L22;
            case 42: goto L22;
            default: goto L20;
        };     // Catch: Exception -> L27
    L20:
        Log.d(r13, "handleType2. error cmd=" + r15);     // Catch: Exception -> L27
        c(r10, false, null);     // Catch: Exception -> L27
        return;
    L6:
        r15 = r14.intValue();     // Catch: Exception -> L27
    L27:
        e = e;
        goto L28
    }
}
