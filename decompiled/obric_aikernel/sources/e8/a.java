package e8;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.data.PackageResource;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bundle f8753a = null;

    static {
        f8753a = E(new Bundle(), 0, null, 3, null);
        B(new Bundle(), 0, null, false, 7, null);
    }

    public static /* synthetic */ Bundle A(Bundle r10, int r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = IdlErrors.INSTANCE.toString(r11);
    L6:
        return y(r10, r11, r12);
    }

    public static /* synthetic */ Bundle B(Bundle r10, int r11, String r12, boolean r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 108;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = IdlErrors.INSTANCE.toString(r11);
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = true;
    L12:
        return z(r10, r11, r12, r13);
    }

    public static final Bundle C(Bundle r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "methodName");
        Intrinsics.checkNotNullParameter(r14, "apiDomain");
        Intrinsics.checkNotNullParameter(r15, "apiEntrance");
        return b(r12, "", r13, IdlKeys.Call_Type_CallGlobalBiz, null, r14, r15, null, false, 200, null);
    }

    public static final Bundle D(Bundle r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "errInfo");
        r10.putInt(IdlKeys.ErrorCode, r11);
        r10.putString(IdlKeys.ErrorInfo, r12);
        boolean r13 = true;
        if (r11 != 1) goto L6;
        r13 = false;
    L6:
        r10.putBoolean(IdlKeys.IsFinish, r13);
        return r10;
    }

    public static /* synthetic */ Bundle E(Bundle r10, int r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = "";
    L9:
        return D(r10, r11, r12);
    }

    public static final Bundle F(Bundle r10, int r11, Function1<? super Bundle, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "block");
        r10.putInt(IdlKeys.ErrorCode, r11);
        r10.putString(IdlKeys.ErrorInfo, null);
        boolean r13 = true;
        if (r11 != 1) goto L6;
        r13 = false;
    L6:
        r10.putBoolean(IdlKeys.IsFinish, r13);
        r12.invoke(r10);
        return r10;
    }

    public static /* synthetic */ Bundle G(Bundle r10, int r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        return F(r10, r11, r12);
    }

    public static final <T> f8.a<T> H(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new f8.a(r10.getInt(IdlKeys.ErrorCode, 0), r10.getString(IdlKeys.ErrorInfo), r10.get(IdlKeys.Result), r10.getBoolean(IdlKeys.IsFinish, true), r10.getBoolean(IdlKeys.IsTaskId, false), J(r10), r10);
    }

    public static final Bundle I(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        long r11 = r10.getLong(IdlKeys.Args_ReqTime, -1);
        if (r11 <= 0) goto L5;
        r10.putLong(IdlKeys.Args_End2EndCost, SystemClock.elapsedRealtime() - r11);
    L5:
        return r10;
    }

    public static final JSONObject J(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JSONObject r11 = new JSONObject();
        r11.put(IdlKeys.Args_TraceId, r10.getString(IdlKeys.Args_TraceId, ""));
        r11.put(IdlKeys.Args_TraceEventKey, r10.getString(IdlKeys.Args_TraceEventKey, ""));
        r11.put(IdlKeys.Args_TraceEventArgs, r10.getString(IdlKeys.Args_TraceEventArgs, ""));
        r11.put(IdlKeys.Args_UseCloud, r10.getBoolean(IdlKeys.Args_UseCloud));
        r11.put(IdlKeys.Args_Timeout, r10.getLong(IdlKeys.Args_Timeout));
        long r12 = r10.getLong(IdlKeys.Args_ReqTime, -1);
        if (r12 <= 0) goto L5;
        r11.put(IdlKeys.Args_End2EndCost, SystemClock.elapsedRealtime() - r12);
    L5:
        return r11;
    }

    public static final <T> f8.a<T> K(Bundle r10, Function2<? super Bundle, ? super String, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        int r12 = r10.getInt(IdlKeys.ErrorCode, 0);
        String r13 = r10.getString(IdlKeys.ErrorInfo);
        boolean r14 = r10.getBoolean(IdlKeys.IsFinish, true);
        boolean r15 = r10.getBoolean(IdlKeys.IsTaskId, false);
        return new f8.a(r12, r13, r11.invoke(r10, IdlKeys.Result), r14, r15, J(r10), r10);
    }

    public static final <T> f8.a<T> L(Bundle r10, Function2<? super Bundle, ? super String, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        int r12 = r10.getInt(IdlKeys.ErrorCode, 0);
        String r13 = r10.getString(IdlKeys.ErrorInfo);
        boolean r14 = r10.getBoolean(IdlKeys.IsFinish, true);
        boolean r15 = r10.getBoolean(IdlKeys.IsTaskId, false);
        return new f8.a(r12, r13, r11.invoke(r10, IdlKeys.Result), r14, r15, J(r10), r10);
    }

    public static final Bundle a(Bundle r10, String r11, String r12, String r13, String r14, String r15, String r16, String[] r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "methodName");
        Intrinsics.checkNotNullParameter(r13, "callType");
        Intrinsics.checkNotNullParameter(r15, "apiDomain");
        Intrinsics.checkNotNullParameter(r16, "apiEntrance");
        r10.putString(IdlKeys.Args_BizName, r11);
        r10.putString(IdlKeys.Call_Type, r13);
        r10.putString(IdlKeys.MethodName, r12);
        r10.putString(IdlKeys.Args_SCENE, r14);
        r10.putString(IdlKeys.Args_ApiEntrance, r16);
        r10.putString(IdlKeys.Args_ApiDomain, r15);
        r10.putStringArray(IdlKeys.Args_PACKAGE_ARR, r17);
        if (r10.containsKey(IdlKeys.Args_TraceId) == true) goto L5;
        r10.putString(IdlKeys.Args_TraceId, UUID.randomUUID().toString());
    L5:
        if (r18 == true) goto L9;
        f7.a r19 = f7.a.f8866a;
        r10.putString(IdlKeys.Args_SdkVer, r19.b());
        r10.putLong(IdlKeys.Args_ReqTime, SystemClock.elapsedRealtime());
        AIKernelConfig r20 = r19.a();
        if (r20 == null) goto L9;
        r10.putLong(IdlKeys.Args_AppId, r20.getAppId());
        r10.putString(IdlKeys.Args_PackageName, r20.getPackageName());
    L9:
        return r10;
    }

    public static /* synthetic */ Bundle b(Bundle r12, String r13, String r14, String r15, String r16, String r17, String r18, String[] r19, boolean r20, int r21, Object r22) {
        if ((r21 & 1) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r11 = "";
    L11:
        if ((r21 & 8) == 0) goto L13;
        String r23 = "";
    L15:
        if ((r21 & 64) == 0) goto L17;
        String[] r110 = new String[0];
    L19:
        if ((r21 & 128) == 0) goto L21;
        boolean r111 = false;
    L23:
        return a(r12, r10, r11, r15, r23, r17, r18, r110, r111);
    L21:
        r111 = r20;
        goto L23
    L17:
        r110 = r19;
        goto L19
    L13:
        r23 = r16;
        goto L15
    L9:
        r11 = r14;
        goto L11
    L5:
        r10 = r13;
        goto L7
    }

    public static final void c(com.obric.aikernel.b r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "errInfo");
        r(r10, B(new Bundle(), r11, r12, false, 4, null));
    }

    public static final String d(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.getString(IdlKeys.Args_TraceId, "");
        Intrinsics.checkNotNullExpressionValue(r11, "this.getString(IdlKeys.Args_TraceId, \"\")");
        return r11;
    }

    public static final String e(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.getString(IdlKeys.Args_BizName, null);
        if (r11 != null) goto L6;
        return "";
    L6:
        return r11;
    }

    public static final int f(Bundle r10) {
        if (r10 != null) goto L6;
        return 108;
    L6:
        return r10.getInt(IdlKeys.ErrorCode, 0);
    }

    public static final String g(Bundle r10) {
        if (r10 == null) goto L4;
        String r11 = r10.getString(IdlKeys.ErrorInfo);
    L5:
        if (r11 != null) goto L8;
        return "";
    L8:
        return r11;
    L4:
        r11 = null;
        goto L5
    }

    public static final String h(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getString(IdlKeys.MethodName);
    }

    public static final List<PackageResource> i(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setClassLoader(PackageResource.class.getClassLoader());
        Parcelable[] r11 = r10.getParcelableArray(IdlKeys.Args_Pkgs);
        if (r11 == null) goto L10;
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        int r14 = r11.length;
    L5:
        if (r13 >= r14) goto L15;
        Parcelable r15 = r11[r13];
        if ((r15 instanceof PackageResource) == false) goto L9;
        r12.add(r15);
    L9:
        r13 = r13 + 1;
        goto L5
    L15:
        return r12;
    L10:
        return null;
    }

    public static final String j(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.getString(IdlKeys.Args_PackageName, null);
        if (r11 != null) goto L6;
        return "";
    L6:
        return r11;
    }

    public static final long k(Bundle r17) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        String r10 = r17.getString(IdlKeys.Args_SdkVer, "");
        Intrinsics.checkNotNullExpressionValue(r10, "sdkVer");
        List r11 = StringsKt.split$default(r10, new String[]{"-"}, false, 0, 6, null);
        if (r11.size() <= 1) goto L5;
        List r12 = CollectionsKt.toMutableList(StringsKt.split$default((CharSequence) r11.get(0), new String[]{"."}, false, 0, 6, null));
    L7:
        if (r12.size() == 3) goto L9;
        return -1;
    L9:
        Integer r13 = StringsKt.toIntOrNull((String) r12.get(0));
        Integer r14 = StringsKt.toIntOrNull((String) r12.get(1));
        Integer r15 = StringsKt.toIntOrNull((String) r12.get(2));
        if (r13 == null) goto L22;
        if (r14 == null) goto L23;
        if (r15 != null) goto L14;
        return -1;
    L14:
        if (new IntRange(0, 1000).contains(r13.intValue()) == true) goto L16;
        return -1;
    L16:
        if (new IntRange(0, 1000).contains(r14.intValue()) == true) goto L18;
        return -1;
    L18:
        if (new IntRange(0, 1000).contains(r15.intValue()) == true) goto L21;
        return -1;
    L21:
        return ((((long) r13.intValue()) * TimeUtils.NANOSECONDS_PER_MILLISECOND) + (((long) r14.intValue()) * 1000)) + ((long) r15.intValue());
    L23:
        return -1;
    L22:
        return -1;
    L5:
        r12 = StringsKt.split$default(r10, new String[]{"."}, false, 0, 6, null);
        goto L7
    }

    public static final long l(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getLong(IdlKeys.Result);
    }

    public static final boolean m(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getBoolean(IdlKeys.IsFinish, true);
    }

    public static final boolean n(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.getInt(IdlKeys.ErrorCode, 0);
        if (r11 == 0) goto L6;
        if (r11 == 1) goto L6;
        return false;
    L6:
        return true;
    }

    public static final boolean o(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getBoolean(IdlKeys.IsTaskId);
    }

    public static final Bundle p(JSONObject r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "args");
        Bundle r12 = new Bundle();
        Iterator<String> r13 = r10.keys();
        Intrinsics.checkNotNullExpressionValue(r13, "args.keys()");
    L4:
        if (r13.hasNext() == false) goto L33;
        String r14 = r13.next();
        Object r15 = r10.get(r14);
        if ((r15 instanceof String) == true) goto L7;
        if ((r15 instanceof Integer) == true) goto L10;
        if ((r15 instanceof Long) == true) goto L13;
        if ((r15 instanceof Boolean) == true) goto L16;
        if ((r15 instanceof Float) == true) goto L19;
        if ((r15 instanceof Double) == true) goto L23;
        if ((r15 instanceof JSONArray) == true) goto L29;
        if ((r15 instanceof JSONObject) == false) goto L4;
        r12.putBundle(r14, p((JSONObject) r15, r11));
        goto L4
    L29:
        Intrinsics.checkNotNullExpressionValue(r14, "key");
        u((JSONArray) r15, r14, r12, r11);
        goto L4
    L23:
        double r16 = ((Number) r15).doubleValue();
        if (r11 == true) goto L25;
        r12.putDouble(r14, r16);
        goto L4
    L25:
        float r17 = (float) r16;
    L20:
        r12.putFloat(r14, r17);
        goto L4
    L19:
        r17 = ((Number) r15).floatValue();
        goto L20
    L16:
        r12.putBoolean(r14, ((Boolean) r15).booleanValue());
        goto L4
    L13:
        r12.putLong(r14, ((Number) r15).longValue());
        goto L4
    L10:
        r12.putInt(r14, ((Number) r15).intValue());
        goto L4
    L7:
        r12.putString(r14, (String) r15);
        goto L4
    L33:
        return r12;
    }

    public static /* synthetic */ Bundle q(JSONObject r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = true;
    L6:
        return p(r10, r11);
    }

    public static final boolean r(com.obric.aikernel.b r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "response");
        r10.j2(r11);     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        AIKLog.INSTANCE.e("TaskOnResult", String.valueOf(th.getMessage()));
        return false;
    }

    public static /* synthetic */ boolean s(com.obric.aikernel.b r10, Bundle r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = f8753a;
    L6:
        return r(r10, r11);
    }

    public static final Bundle t(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m32constructorimpl(Integer.valueOf(f(r10)));     // Catch: Throwable -> L5
    L7:
        Throwable r13 = Result.m35exceptionOrNullimpl(r12);
        if (r13 == null) goto L10;
        AIKLog.INSTANCE.w("AIK-SDK-DataParser", "safeUnparcel exception: " + r13);
    L10:
        return r10;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final void u(JSONArray r10, String r11, Bundle r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "arr");
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, "bundle");
        if (r10.length() != 0) goto L5;
        return;
    L5:
        Object r14 = r10.opt(0);
        if (r14 != null) goto L8;
        return;
    L8:
        IntRange r15 = new IntRange(0, r10.length() - 1);
        if ((r14 instanceof String) == false) goto L16;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<Integer> r17 = r15.iterator();
    L12:
        if (r17.hasNext() == false) goto L14;
        r16.add(r10.getString(((IntIterator) r17).nextInt()));
        goto L12
    L14:
        r12.putStringArray(r11, (String[]) r16.toArray(new String[0]));
        return;
    L16:
        if ((r14 instanceof Integer) == false) goto L23;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<Integer> r19 = r15.iterator();
    L19:
        if (r19.hasNext() == false) goto L21;
        r18.add(Integer.valueOf(r10.getInt(((IntIterator) r19).nextInt())));
        goto L19
    L21:
        r12.putIntArray(r11, CollectionsKt.toIntArray(r18));
        return;
    L23:
        if ((r14 instanceof Long) == false) goto L30;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<Integer> r21 = r15.iterator();
    L26:
        if (r21.hasNext() == false) goto L28;
        r20.add(Long.valueOf(r10.getLong(((IntIterator) r21).nextInt())));
        goto L26
    L28:
        r12.putLongArray(r11, CollectionsKt.toLongArray(r20));
        return;
    L30:
        if ((r14 instanceof Boolean) == false) goto L37;
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<Integer> r23 = r15.iterator();
    L33:
        if (r23.hasNext() == false) goto L35;
        r22.add(Boolean.valueOf(r10.getBoolean(((IntIterator) r23).nextInt())));
        goto L33
    L35:
        r12.putBooleanArray(r11, CollectionsKt.toBooleanArray(r22));
        return;
    L37:
        if ((r14 instanceof Float) == false) goto L44;
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<Integer> r25 = r15.iterator();
    L40:
        if (r25.hasNext() == false) goto L42;
        r24.add(Float.valueOf((float) r10.getDouble(((IntIterator) r25).nextInt())));
        goto L40
    L42:
        r12.putFloatArray(r11, CollectionsKt.toFloatArray(r24));
        return;
    L44:
        if ((r14 instanceof Double) == false) goto L57;
        if (r13 == false) goto L51;
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<Integer> r27 = r15.iterator();
    L48:
        if (r27.hasNext() == false) goto L50;
        r26.add(Float.valueOf((float) r10.getDouble(((IntIterator) r27).nextInt())));
        goto L48
    L50:
        r12.putFloatArray(r11, CollectionsKt.toFloatArray(r26));
        return;
    L51:
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<Integer> r29 = r15.iterator();
    L53:
        if (r29.hasNext() == false) goto L55;
        r28.add(Double.valueOf(r10.getDouble(((IntIterator) r29).nextInt())));
        goto L53
    L55:
        r12.putDoubleArray(r11, CollectionsKt.toDoubleArray(r28));
        return;
    L57:
        if ((r14 instanceof JSONObject) == false) goto L63;
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<Integer> r31 = r15.iterator();
    L60:
        if (r31.hasNext() == false) goto L62;
        JSONObject r32 = r10.getJSONObject(((IntIterator) r31).nextInt());
        Intrinsics.checkNotNullExpressionValue(r32, "arr.getJSONObject(it)");
        r30.add(p(r32, r13));
        goto L60
    L62:
        r12.putParcelableArray(r11, (Parcelable[]) r30.toArray(new Bundle[0]));
        return;
    L63:
        boolean r33 = r14 instanceof JSONArray;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Bundle v(Bundle r10, T r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.putInt(IdlKeys.ErrorCode, r12);
        r10.putString(IdlKeys.ErrorInfo, r13);
        boolean r14 = true;
        if (r12 != 1) goto L6;
        r14 = false;
    L6:
        r10.putBoolean(IdlKeys.IsFinish, r14);
        if ((r11 instanceof Integer) == false) goto L10;
        r10.putInt(IdlKeys.Result, ((Number) r11).intValue());
    L42:
        return r10;
    L10:
        if ((r11 instanceof int[]) == false) goto L13;
        r10.putIntArray(IdlKeys.Result, (int[]) r11);
        goto L42
    L13:
        if ((r11 instanceof Float) == false) goto L16;
        r10.putFloat(IdlKeys.Result, ((Number) r11).floatValue());
        goto L42
    L16:
        if ((r11 instanceof float[]) == false) goto L19;
        r10.putFloatArray(IdlKeys.Result, (float[]) r11);
        goto L42
    L19:
        if ((r11 instanceof String) == false) goto L22;
        r10.putString(IdlKeys.Result, (String) r11);
        goto L42
    L22:
        if ((r11 instanceof Byte) == false) goto L25;
        r10.putByte(IdlKeys.Result, ((Number) r11).byteValue());
        goto L42
    L25:
        if ((r11 instanceof byte[]) == false) goto L28;
        r10.putByteArray(IdlKeys.Result, (byte[]) r11);
        goto L42
    L28:
        if ((r11 instanceof Character) == false) goto L31;
        r10.putChar(IdlKeys.Result, ((Character) r11).charValue());
        goto L42
    L31:
        if ((r11 instanceof char[]) == false) goto L34;
        r10.putCharArray(IdlKeys.Result, (char[]) r11);
        goto L42
    L34:
        if ((r11 instanceof Boolean) == false) goto L37;
        r10.putBoolean(IdlKeys.Result, ((Boolean) r11).booleanValue());
        goto L42
    L37:
        if ((r11 instanceof boolean[]) == false) goto L40;
        r10.putBooleanArray(IdlKeys.Result, (boolean[]) r11);
        goto L42
    L40:
        if ((r11 instanceof JSONObject) == false) goto L42;
        r10.putBundle(IdlKeys.Result, q((JSONObject) r11, false, 2, null));
        goto L42
    }

    public static /* synthetic */ Bundle w(Bundle r10, Object r11, int r12, String r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = null;
    L9:
        return v(r10, r11, r12, r13);
    }

    public static final Bundle x(Bundle r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "bizName");
        Intrinsics.checkNotNullParameter(r14, "apiDomain");
        Intrinsics.checkNotNullParameter(r15, "apiEntrance");
        return b(r12, r13, IdlKeys.Method_RunBiz, IdlKeys.Call_Type_CallBiz, null, r14, r15, null, false, 200, null);
    }

    public static final Bundle y(Bundle r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.putInt(IdlKeys.ErrorCode, r11);
        r10.putString(IdlKeys.ErrorInfo, r12);
        r10.putBoolean(IdlKeys.IsFinish, true);
        return r10;
    }

    public static final Bundle z(Bundle r10, int r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "errInfo");
        r10.putInt(IdlKeys.ErrorCode, r11);
        r10.putString(IdlKeys.ErrorInfo, r12);
        r10.putBoolean(IdlKeys.IsFinish, r13);
        return r10;
    }
}
