package com.bytedance.badger.z;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.module.BadgerModuleBase;
import com.bytedance.bd_sec_tee.core.model.TeeResult;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b1 extends u0 {
    public static volatile SharedPreferences a;

    public b1() {
    }

    public static v64.c c(Context r15) {
        String r0 = Build.BRAND;
        int r3 = 0;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L6:
        String r1 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r1) == false) goto L9;
    L11:
        boolean r2 = false;
    L12:
        String r7 = null;
        if (r2 == false) goto L16;
        String r4 = "huawei";
    L28:
        long r8 = SystemClock.elapsedRealtime();
        int r10 = r4.hashCode();     // Catch: Throwable -> L53
        if (r10 == (-1206476313)) goto L48;
        if (r10 == (-447510395)) goto L45;
        if (r10 == 3418016) goto L42;
        if (r10 == 99462250) goto L39;
    L50:
        v64.c r16 = null;
    L51:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L53
    L56:
        if (Result.isFailure-impl(r17) == false) goto L58;
        r17 = null;
    L58:
        v64.c r18 = (v64.c) r17;
        long r5 = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r8, 0);
        if (r18 == null) goto L61;
        long r9 = r18.d;
    L62:
        Long r12 = Long.valueOf(r9);
        if (r12.longValue() <= 0) goto L65;
        boolean r13 = true;
    L66:
        if (r13 == true) goto L69;
        r12 = null;
    L69:
        if (r12 == null) goto L71;
        r5 = r12.longValue();
    L71:
        if (r18 == null) goto L73;
        String r14 = r18.a;
    L74:
        if (r18 != null) goto L76;
    L78:
        int r19 = 0;
    L79:
        if (r14 != null) goto L81;
    L84:
        boolean r110 = true;
    L85:
        if (r110 == false) goto L87;
    L89:
        if (r18 == null) goto L91;
        String r6 = r18.c;
    L93:
        if (r6 != null) goto L96;
        r6 = "";
    L96:
        if (r18 == null) goto L98;
        r7 = r18.e;
    L98:
        if (r7 != null) goto L101;
        r7 = "";
    L101:
        int r20 = v64.b.a;
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L106
        r111.put("isLimit", r19);     // Catch: Throwable -> L106
        r111.put("vender", r4);     // Catch: Throwable -> L106
        r111.put("error", r6);     // Catch: Throwable -> L106
        r111.put(Constants.Keys.duration, (int) RangesKt.coerceIn(r5, 0, Integer.MAX_VALUE));     // Catch: Throwable -> L106
        r111.put("result", r3);     // Catch: Throwable -> L106
        r111.put("type", r7);     // Catch: Throwable -> L106
        com.bytedance.badger.e.d("oaid_info", r111);     // Catch: Throwable -> L106
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L106
    L108:
        if (r18 != null) goto L110;
    L112:
        return r18;
    L110:
        if (r18.d > 0) goto L112;
        r18.d = r5;
    L106:
        th = move-exception;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L108
    L91:
        r6 = null;
        goto L93
    L87:
        if ((!Intrinsics.areEqual(r14, "00000000-0000-0000-0000-000000000000")) == false) goto L89;
        r3 = 1;
        goto L89
    L81:
        if (r14.length() == 0) goto L84;
        r110 = false;
        goto L85
    L76:
        if (r18.b != true) goto L78;
        r19 = 1;
        goto L79
    L73:
        r14 = null;
        goto L74
    L65:
        r13 = false;
        goto L66
    L61:
        r9 = 0;
        goto L62
    L39:
        if (r4.equals("honor") == false) goto L50;
        r16 = v64.a.b(r15);     // Catch: Throwable -> L53
        goto L51
    L42:
        if (r4.equals("oppo") == false) goto L50;
        r16 = com.bm.badgervi.b.g(r15);     // Catch: Throwable -> L53
        goto L51
    L45:
        if (r4.equals("honor hw") == false) goto L50;
    L49:
        r16 = v64.a.d(r15);     // Catch: Throwable -> L53
        goto L51
    L48:
        if (r4.equals("huawei") == false) goto L50;
    L53:
        th = move-exception;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L16:
        if (com.bytedance.badger.utils.y.e() == false) goto L21;
        if (com.bytedance.badger.utils.y.c() == false) goto L21;
        r4 = "honor hw";
    L21:
        if (com.bytedance.badger.utils.y.e() == false) goto L26;
        if (com.bytedance.badger.utils.y.c() == true) goto L26;
        r4 = "honor";
    L26:
        if (com.bytedance.badger.utils.y.d() == false) goto L113;
        r4 = "oppo";
        goto L28
    L113:
        return null;
    L9:
        if (r1.toLowerCase().startsWith("huawei") == false) goto L11;
    L10:
        r2 = true;
        goto L12
    L5:
        if (r0.toLowerCase().startsWith("huawei") == true) goto L10;
        goto L6
    }

    public static String d(ContentResolver r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, "android_id"};
        f06.b r12 = new f06.b();
        f06.d r14 = r8.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, "java.lang.String", r12);
        if (r14.a == false) goto L6;
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, null, r12, false);
        return (String) r14.b;
    L6:
        String r15 = Settings.Secure.getString(r13, "android_id");
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, r15, r12, true);
        return r15;
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r12, BadgerModuleBase.BadgerRequestData r13) {
        if (com.bytedance.badger.utils.a0.b == null) goto L5;
    L14:
        TeeResult r14 = com.bytedance.badger.utils.a0.b.a.a("badger", null);
        if (r14.c == 0) goto L17;
    L19:
        int r15 = 0;
    L20:
        JSONObject r0 = new JSONObject();
        JSONObject r3 = new JSONObject();
        SharedPreferences r4 = a;
        if (r4 != null) goto L24;
        r4 = r12.getApplicationContext().getSharedPreferences("bd_badger", 0);
        a = r4;
    L24:
        String r7 = r4.getString("badger_android_id", "");
        String r6 = r4.getString("device_id", "");
        String r9 = d(r12.getContentResolver());     // Catch: Exception -> L27
    L29:
        if (TextUtils.isEmpty(r7) == true) goto L34;
        boolean r1 = StringsKt.equals$default(r7, r9, false, 2, null);
        if (r1 == true) goto L33;
        r4.edit().putString("badger_android_id", r9).apply();
    L33:
        r3.putOpt("openudid_equal", Integer.valueOf(r1 ? 1 : 0));
    L35:
        BadgerCore.Companion.getClass();
        String r2 = com.bytedance.badger.j.a().getDeviceId();
        if (TextUtils.isEmpty(r6) == false) goto L38;
        r4.edit().putString("device_id", r2).apply();
    L38:
        r3.putOpt("device_id", r2);
        r3.putOpt("old_device_id", r6);
        r3.putOpt("migrate", Integer.valueOf(r15));
        r0.putOpt("d_migrate", r3);
        if (r15 == 0) goto L57;
        r4.edit().putString("device_id", r2).apply();
    L57:
        v64.c r16 = c(r12);     // Catch: Exception -> L54
        if (r16 == null) goto L53;
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L54
        r17.putOpt("id", r16.a);     // Catch: Exception -> L54
        r17.putOpt("is_track_limited", Boolean.valueOf(r16.b));     // Catch: Exception -> L54
        r17.putOpt("take_ms", Long.valueOf(r16.d));     // Catch: Exception -> L54
        r17.putOpt("type", r16.e);     // Catch: Exception -> L54
        r0.putOpt("oaid", r17);     // Catch: Exception -> L54
    L53:
        return new BadgerResult.Success(new DataJson(r0));
    L34:
        r4.edit().putString("badger_android_id", r9).apply();
    L27:
        r9 = null;
        goto L29
    L17:
        if (r14.g != TeeResult.ResultType.PUB_COMPARE_NOT_EQUAL) goto L19;
        r15 = 1;
        goto L20
    L5:
        monitor-enter(com.bytedance.badger.utils.a0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.bytedance.badger.utils.a0.b != null) goto L9;
        com.bytedance.badger.utils.a0.b = new com.bytedance.badger.utils.a0(r12);     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.badger.utils.a0.class);     // Catch: Throwable -> L11
        goto L14
    }
}
