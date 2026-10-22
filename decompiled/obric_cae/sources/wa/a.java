package wa;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.data.PackageResource;
import com.qualcomm.qti.qesdk.QesdkUtils;
import ge.p;
import he.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import ke.b;
import ke.c;
import org.json.JSONArray;
import org.json.JSONObject;
import xd.e;
import yd.f;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f13086a = 0;

    static {
        Bundle r8 = new Bundle();
        r8.putInt(IdlKeys.ErrorCode, 0);
        r8.putString(IdlKeys.ErrorInfo, "");
        r8.putBoolean(IdlKeys.IsFinish, true);
        l(new Bundle(), 0, null, 7);
    }

    public static void a(Bundle r8, String r10, String r11, String r12, String r13, String r14, String r15, int r16) {
        if ((r16 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r16 & 2) == 0) goto L9;
        r11 = "";
    L9:
        if ((r16 & 8) == 0) goto L12;
        r13 = "";
    L12:
        if ((r16 & 64) == 0) goto L14;
        String[] r17 = new String[0];
    L15:
        i.f(r8, "<this>");
        r8.putString(IdlKeys.Args_BizName, r10);
        r8.putString(IdlKeys.Call_Type, r12);
        r8.putString(IdlKeys.MethodName, r11);
        r8.putString(IdlKeys.Args_SCENE, r13);
        r8.putString(IdlKeys.Args_ApiEntrance, r15);
        r8.putString(IdlKeys.Args_ApiDomain, r14);
        r8.putStringArray(IdlKeys.Args_PACKAGE_ARR, r17);
        if (r8.containsKey(IdlKeys.Args_TraceId) == true) goto L18;
        r8.putString(IdlKeys.Args_TraceId, UUID.randomUUID().toString());
    L18:
        r8.putString(IdlKeys.Args_SdkVer, ra.a.f11539b);
        r8.putLong(IdlKeys.Args_ReqTime, SystemClock.elapsedRealtime());
        AIKernelConfig r18 = ra.a.f11538a;
        if (r18 == null) goto L22;
        r8.putLong(IdlKeys.Args_AppId, r18.getAppId());
        r8.putString(IdlKeys.Args_PackageName, r18.getPackageName());
        return;
    L22:
        return;
    L14:
        r17 = null;
        goto L15
    }

    public static final int b(Bundle r8) {
        if (r8 != null) goto L6;
        return 108;
    L6:
        return r8.getInt(IdlKeys.ErrorCode, 0);
    }

    public static final ArrayList c(Bundle r8) {
        i.f(r8, "<this>");
        r8.setClassLoader(PackageResource.class.getClassLoader());
        Parcelable[] r10 = r8.getParcelableArray(IdlKeys.Args_Pkgs);
        if (r10 == null) goto L10;
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L15;
        Parcelable r14 = r10[r13];
        if ((r14 instanceof PackageResource) == false) goto L9;
        r11.add(r14);
    L9:
        r13 = r13 + 1;
        goto L5
    L15:
        return r11;
    L10:
        return null;
    }

    public static final long d(Bundle r8) {
        i.f(r8, "<this>");
        return r8.getLong(IdlKeys.Result);
    }

    public static final boolean e(Bundle r8) {
        i.f(r8, "<this>");
        return r8.getBoolean(IdlKeys.IsFinish, true);
    }

    public static final boolean f(Bundle r8) {
        i.f(r8, "<this>");
        int r10 = r8.getInt(IdlKeys.ErrorCode, 0);
        if (r10 == 0) goto L6;
        if (r10 == 1) goto L6;
        return false;
    L6:
        return true;
    }

    public static final boolean g(Bundle r8) {
        i.f(r8, "<this>");
        return r8.getBoolean(IdlKeys.IsTaskId);
    }

    public static final Bundle h(JSONObject r10, boolean r11) {
        i.f(r10, QesdkUtils.TAGS.JSON_TAG_ARGS);
        Bundle r8 = new Bundle();
        Iterator<String> r12 = r10.keys();
        i.e(r12, "args.keys()");
    L4:
        if (r12.hasNext() == false) goto L106;
        String r13 = r12.next();
        Object r14 = r10.get(r13);
        if ((r14 instanceof String) == true) goto L7;
        if ((r14 instanceof Integer) == true) goto L10;
        if ((r14 instanceof Long) == true) goto L13;
        if ((r14 instanceof Boolean) == true) goto L16;
        if ((r14 instanceof Float) == true) goto L19;
        if ((r14 instanceof Double) == true) goto L22;
        if ((r14 instanceof JSONArray) == true) goto L29;
        if ((r14 instanceof JSONObject) == false) goto L4;
        r8.putBundle(r13, h((JSONObject) r14, r11));
        goto L4
    L29:
        JSONArray r15 = (JSONArray) r14;
        i.e(r13, "key");
        i.f(r15, "arr");
        if (r15.length() == 0) goto L4;
        int r16 = 0;
        Object r17 = r15.opt(0);
        if (r17 == null) goto L4;
        c r18 = new c(0, r15.length() - 1);
        if ((r17 instanceof String) == true) goto L37;
        if ((r17 instanceof Integer) == true) goto L44;
        if ((r17 instanceof Long) == true) goto L51;
        if ((r17 instanceof Boolean) == true) goto L62;
        if ((r17 instanceof Float) == true) goto L73;
        if ((r17 instanceof Double) == true) goto L80;
        if ((r17 instanceof JSONObject) == true) goto L97;
        boolean r19 = r17 instanceof JSONArray;
        goto L4
    L97:
        ArrayList r20 = new ArrayList(f.f1(r18));
        b r21 = r18.a();
    L99:
        if (r21.f9114m == false) goto L101;
        JSONObject r22 = r15.getJSONObject(r21.nextInt());
        i.e(r22, "arr.getJSONObject(it)");
        r20.add(h(r22, r11));
        goto L99
    L101:
        r8.putParcelableArray(r13, (Parcelable[]) r20.toArray(new Bundle[0]));
        goto L4
    L80:
        if (r11 == true) goto L81;
        ArrayList r23 = new ArrayList(f.f1(r18));
        b r24 = r18.a();
    L88:
        if (r24.f9114m == false) goto L90;
        r23.add(Double.valueOf(r15.getDouble(r24.nextInt())));
        goto L88
    L90:
        double[] r25 = new double[r23.size()];
        Iterator r26 = r23.iterator();
    L92:
        if (r26.hasNext() == false) goto L94;
        r25[r16] = ((Number) r26.next()).doubleValue();
        r16 = r16 + 1;
        goto L92
    L94:
        r8.putDoubleArray(r13, r25);
        goto L4
    L81:
        ArrayList r27 = new ArrayList(f.f1(r18));
        b r28 = r18.a();
    L83:
        if (r28.f9114m == false) goto L85;
        r27.add(Float.valueOf((float) r15.getDouble(r28.nextInt())));
        goto L83
    L85:
        r8.putFloatArray(r13, yd.i.l1(r27));
        goto L4
    L73:
        ArrayList r29 = new ArrayList(f.f1(r18));
        b r30 = r18.a();
    L75:
        if (r30.f9114m == false) goto L77;
        r29.add(Float.valueOf((float) r15.getDouble(r30.nextInt())));
        goto L75
    L77:
        r8.putFloatArray(r13, yd.i.l1(r29));
        goto L4
    L62:
        ArrayList r31 = new ArrayList(f.f1(r18));
        b r32 = r18.a();
    L64:
        if (r32.f9114m == false) goto L66;
        r31.add(Boolean.valueOf(r15.getBoolean(r32.nextInt())));
        goto L64
    L66:
        boolean[] r33 = new boolean[r31.size()];
        Iterator r34 = r31.iterator();
    L68:
        if (r34.hasNext() == false) goto L70;
        r33[r16] = ((Boolean) r34.next()).booleanValue();
        r16 = r16 + 1;
        goto L68
    L70:
        r8.putBooleanArray(r13, r33);
        goto L4
    L51:
        ArrayList r35 = new ArrayList(f.f1(r18));
        b r36 = r18.a();
    L53:
        if (r36.f9114m == false) goto L55;
        r35.add(Long.valueOf(r15.getLong(r36.nextInt())));
        goto L53
    L55:
        long[] r37 = new long[r35.size()];
        Iterator r38 = r35.iterator();
    L57:
        if (r38.hasNext() == false) goto L59;
        r37[r16] = ((Number) r38.next()).longValue();
        r16 = r16 + 1;
        goto L57
    L59:
        r8.putLongArray(r13, r37);
        goto L4
    L44:
        ArrayList r39 = new ArrayList(f.f1(r18));
        b r40 = r18.a();
    L46:
        if (r40.f9114m == false) goto L48;
        r39.add(Integer.valueOf(r15.getInt(r40.nextInt())));
        goto L46
    L48:
        r8.putIntArray(r13, yd.i.m1(r39));
        goto L4
    L37:
        ArrayList r41 = new ArrayList(f.f1(r18));
        b r42 = r18.a();
    L39:
        if (r42.f9114m == false) goto L41;
        r41.add(r15.getString(r42.nextInt()));
        goto L39
    L41:
        r8.putStringArray(r13, (String[]) r41.toArray(new String[0]));
        goto L4
    L22:
        double r43 = ((Number) r14).doubleValue();
        if (r11 == true) goto L24;
        r8.putDouble(r13, r43);
        goto L4
    L24:
        float r44 = (float) r43;
    L25:
        r8.putFloat(r13, r44);
        goto L4
    L19:
        r44 = ((Number) r14).floatValue();
        goto L25
    L16:
        r8.putBoolean(r13, ((Boolean) r14).booleanValue());
        goto L4
    L13:
        r8.putLong(r13, ((Number) r14).longValue());
        goto L4
    L10:
        r8.putInt(r13, ((Number) r14).intValue());
        goto L4
    L7:
        r8.putString(r13, (String) r14);
        goto L4
    L106:
        return r8;
    }

    public static final void i(Bundle r8) {
        i.f(r8, "<this>");
        Object r10 = Integer.valueOf(b(r8));     // Catch: Throwable -> L5
    L7:
        Throwable r11 = e.a(r10);
        if (r11 == null) goto L13;
        AIKLog.INSTANCE.w("AIK-SDK-DataParser", "safeUnparcel exception: " + r11);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        r10 = defpackage.c.D(th);
        goto L7
    }

    public static final void j(Bundle r10, String r11, String r12, String r13) {
        i.f(r10, "<this>");
        i.f(r11, "bizName");
        a(r10, r11, IdlKeys.Method_RunBiz, IdlKeys.Call_Type_CallBiz, null, r12, r13, 200);
    }

    public static final void k(String r8, Bundle r10) {
        r10.putInt(IdlKeys.ErrorCode, 102);
        r10.putString(IdlKeys.ErrorInfo, r8);
        r10.putBoolean(IdlKeys.IsFinish, true);
    }

    public static void l(Bundle r8, int r10, String r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r10 = 108;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = IdlErrors.INSTANCE.toString(r10);
    L9:
        if ((r12 & 4) == 0) goto L11;
        boolean r13 = true;
    L12:
        i.f(r11, "errInfo");
        r8.putInt(IdlKeys.ErrorCode, r10);
        r8.putString(IdlKeys.ErrorInfo, r11);
        r8.putBoolean(IdlKeys.IsFinish, r13);
        return;
    L11:
        r13 = false;
        goto L12
    }

    public static final <T> xa.a<T> m(Bundle r10) {
        i.f(r10, "<this>");
        return new xa.a(r10.getInt(IdlKeys.ErrorCode, 0), r10.getString(IdlKeys.ErrorInfo), r10.get(IdlKeys.Result), r10.getBoolean(IdlKeys.IsFinish, true), r10.getBoolean(IdlKeys.IsTaskId, false), o(r10), r10);
    }

    public static final void n(Bundle r8) {
        i.f(r8, "<this>");
        long r10 = r8.getLong(IdlKeys.Args_ReqTime, -1);
        if (r10 <= 0) goto L6;
        r8.putLong(IdlKeys.Args_End2EndCost, SystemClock.elapsedRealtime() - r10);
        return;
    }

    public static final JSONObject o(Bundle r8) {
        i.f(r8, "<this>");
        JSONObject r10 = new JSONObject();
        r10.put(IdlKeys.Args_TraceId, r8.getString(IdlKeys.Args_TraceId, ""));
        r10.put(IdlKeys.Args_TraceEventKey, r8.getString(IdlKeys.Args_TraceEventKey, ""));
        r10.put(IdlKeys.Args_TraceEventArgs, r8.getString(IdlKeys.Args_TraceEventArgs, ""));
        r10.put(IdlKeys.Args_UseCloud, r8.getBoolean(IdlKeys.Args_UseCloud));
        r10.put(IdlKeys.Args_Timeout, r8.getLong(IdlKeys.Args_Timeout));
        long r11 = r8.getLong(IdlKeys.Args_ReqTime, -1);
        if (r11 <= 0) goto L5;
        r10.put(IdlKeys.Args_End2EndCost, SystemClock.elapsedRealtime() - r11);
    L5:
        return r10;
    }

    public static final <T> xa.a<T> p(Bundle r10, p<? super Bundle, ? super String, ? extends T> r11) {
        i.f(r10, "<this>");
        i.f(r11, "block");
        int r8 = r10.getInt(IdlKeys.ErrorCode, 0);
        String r12 = r10.getString(IdlKeys.ErrorInfo);
        boolean r13 = r10.getBoolean(IdlKeys.IsFinish, true);
        boolean r14 = r10.getBoolean(IdlKeys.IsTaskId, false);
        return new xa.a(r8, r12, r11.invoke(r10, IdlKeys.Result), r13, r14, o(r10), r10);
    }
}
