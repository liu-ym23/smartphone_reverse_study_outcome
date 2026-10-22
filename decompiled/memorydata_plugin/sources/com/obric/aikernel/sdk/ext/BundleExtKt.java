package com.obric.aikernel.sdk.ext;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.b;
import com.obric.aikernel.core.a;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.response.Response;
import com.obric.memorydata.database.entity.ChatMessage;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001\u001a\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001ae\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b¢\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u001e\u001a\u00020\r*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0011\u001a\n\u0010#\u001a\u00020\u0011*\u00020\u0001\u001a\n\u0010$\u001a\u00020\u0011*\u00020\u0001\u001a\f\u0010%\u001a\u00020!*\u0004\u0018\u00010\u0001\u001a\f\u0010&\u001a\u00020\u0011*\u0004\u0018\u00010\u0001\u001a\u0018\u0010'\u001a\u0004\u0018\u00010\u0011\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0)\u001a\f\u0010*\u001a\u0004\u0018\u00010\u0011*\u00020\u0001\u001a\f\u0010+\u001a\u0004\u0018\u00010\u0011*\u00020\u0001\u001a\u0012\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-*\u00020\u0001\u001a\n\u0010/\u001a\u00020\u0011*\u00020\u0001\u001a\n\u00100\u001a\u000201*\u00020\u0001\u001a\n\u00102\u001a\u000201*\u00020\u0001\u001a\u0018\u00103\u001a\u0004\u0018\u00010\u0011\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0)\u001a\n\u00104\u001a\u00020\u000b*\u00020\u0001\u001a\n\u00105\u001a\u00020\u000b*\u00020\u0001\u001a\n\u00106\u001a\u00020\u000b*\u00020\u0001\u001a\n\u00107\u001a\u00020\u000b*\u00020\u0001\u001a\n\u00108\u001a\u00020\u000b*\u00020\u0001\u001a\n\u00109\u001a\u00020\u000b*\u00020\u0001\u001a\n\u0010:\u001a\u00020\u000b*\u00020\u0001\u001a\n\u0010;\u001a\u00020\u000b*\u00020\u0001\u001a\n\u0010<\u001a\u00020\u000b*\u00020\u0001\u001a\n\u0010=\u001a\u00020\u000b*\u00020\u0001\u001a\u0014\u0010>\u001a\u00020\u000b*\u00020\u001f2\b\b\u0002\u0010?\u001a\u00020\u0001\u001a\n\u0010@\u001a\u00020\u0001*\u00020\u0001\u001a3\u0010A\u001a\u00020\u0001\"\u0004\b\u0000\u0010(*\u00020\u00012\u0006\u0010B\u001a\u0002H(2\b\b\u0002\u0010C\u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010D\u001a\"\u0010E\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011\u001a(\u0010F\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010:\u001a\u00020\u000b\u001a\u001e\u0010F\u001a\u00020\u0001*\u00020\u00012\u0006\u0010C\u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0011\u001a\"\u0010G\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011\u001a\u0014\u0010H\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\"\u001a\u00020\u0011\u001a\u0012\u0010I\u001a\u00020\u0001*\u00020\u00012\u0006\u0010J\u001a\u00020\u0011\u001a\u001e\u0010K\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010C\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0011\u001a(\u0010L\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010C\u001a\u00020!2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0N\u001a\u0012\u0010O\u001a\u00020\u0001*\u00020\u00012\u0006\u0010P\u001a\u000201\u001a\u0016\u0010Q\u001a\b\u0012\u0004\u0012\u0002H(0)\"\u0004\b\u0000\u0010(*\u00020\u0001\u001a\n\u0010R\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010S\u001a\u00020\u0007*\u00020\u0001\u001a\u0010\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00070)*\u00020\u0001\u001a0\u0010U\u001a\b\u0012\u0004\u0012\u0002H(0)\"\u0004\b\u0000\u0010(*\u00020\u00012\u0018\u0010M\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H(0V\u001a0\u0010W\u001a\b\u0012\u0004\u0012\u0002H(0)\"\u0004\b\u0000\u0010(*\u00020\u00012\u0018\u0010M\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H(0V\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006X"}, d2 = {"FAIL", "Landroid/os/Bundle;", "getFAIL", "()Landroid/os/Bundle;", "OK", "getOK", "bundle2json", "Lorg/json/JSONObject;", "args", "json2Bundle", "compressFloat", "", "saveArr", "", "arr", "Lorg/json/JSONArray;", "key", "", "bundle", "commonParams", "bizName", "methodName", "callType", "sceneName", "apiDomain", "apiEntrance", "packageArr", "", "skipSource", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Z)Landroid/os/Bundle;", NotificationCompat.CATEGORY_ERROR, "Lcom/obric/aikernel/AIKListener;", "errCode", "", "errInfo", "getAIKTraceId", "getBizName", "getErrorCode", "getErrorMsg", "getLogId", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/aikernel/sdk/response/Response;", "getMethod", "getModelName", "getPackageInfos", "", "Lcom/obric/aikernel/sdk/data/PackageResource;", "getPackageName", "getSdkVer", "", "getTaskId", "getTraceId", "isCallBiz", "isCallGlobal", "isCallGlobalBiz", "isCallModel", "isCallScene", "isError", "isFinish", "isGetModel", "isSuccess", "isTaskId", "safeOnResult", ChatMessage.TYPE_RESPONSE, "safeUnparcel", "setBasicTypeRes", "data", "code", "(Landroid/os/Bundle;Ljava/lang/Object;ILjava/lang/String;)Landroid/os/Bundle;", "setBizCall", "setErr", "setGlobalCall", "setInvalidArg", "setMethod", ActivityLifecycle.NAME, "setOK", "setResApply", "block", "Lkotlin/Function1;", "setTaskIdRes", "taskId", "toBasicTypeResponse", "toE2EDurationResponse", "toExtraResponse", "toJsonResult", "toNetResponse", "Lkotlin/Function2;", "toUserResponse", "sdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BundleExtKt {
    private static final Bundle FAIL = null;
    private static final Bundle OK = null;

    static {
        OK = setOK$default(new Bundle(), 0, null, 3, null);
        FAIL = setErr$default(new Bundle(), 0, null, false, 7, null);
    }

    public static final JSONObject bundle2json(Bundle r15) {
        Intrinsics.checkNotNullParameter(r15, "args");
        JSONObject r5 = new JSONObject();
        Iterator<String> r6 = r15.keySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L73;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        Object r8 = r15.get(r7);
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == true) goto L7;
        if ((r8 instanceof int[]) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r8, Long.class) == false) goto L19;
        r5.put(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L4
    L19:
        if ((r8 instanceof long[]) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, Boolean.class) == false) goto L28;
        r5.put(r7, ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        goto L4
    L28:
        if ((r8 instanceof boolean[]) == true) goto L29;
        if (ZeusTransformUtils.instanceOf(r8, Double.class) == false) goto L37;
        r5.put(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L4
    L37:
        if ((r8 instanceof double[]) == true) goto L38;
        if (ZeusTransformUtils.instanceOf(r8, Float.class) == true) goto L44;
        if ((r8 instanceof float[]) == true) goto L47;
        if (ZeusTransformUtils.instanceOf(r8, String.class) == true) goto L44;
        if (ZeusTransformUtils.instanceOf(r8, Bundle.class) == false) goto L58;
        r8 = bundle2json((Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.memorydata.plugin"));
        goto L44
    L58:
        if ((r8 instanceof Object[]) == true) goto L60;
        AIKLog.INSTANCE.w("bundle2json", "unknown type " + r8);
        goto L4
    L60:
        if (((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin")).length <= 0) goto L4;
        if (ZeusTransformUtils.instanceOf(((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin"))[0], Bundle.class) == false) goto L68;
        JSONArray r10 = new JSONArray();
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, ((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin")).length), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L66:
        if (r11.hasNext() == false) goto L14;
        int r12 = ((IntIterator) ZeusTransformUtils.preCheckCast(r11, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        Object r13 = ((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin"))[r12];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.os.Bundle");
        r10.put(r12, bundle2json((Bundle) ZeusTransformUtils.preCheckCast(r13, Bundle.class, "com.obric.memorydata.plugin")));
    L14:
        Unit r9 = Unit.INSTANCE;
        r5.put(r7, r10);
        goto L4
    L68:
        r10 = new JSONArray();
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, ((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin")).length), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L70:
        if (r14.hasNext() == false) goto L14;
        int r16 = ((IntIterator) ZeusTransformUtils.preCheckCast(r14, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        r10.put(r16, ((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin"))[r16]);
        goto L70
    L47:
        r10 = new JSONArray();
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, ((float[]) ZeusTransformUtils.preCheckCast(r8, float[].class, "com.obric.memorydata.plugin")).length), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L49:
        if (r17.hasNext() == false) goto L14;
        int r18 = ((IntIterator) ZeusTransformUtils.preCheckCast(r17, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        r10.put(r18, Float.valueOf(((float[]) ZeusTransformUtils.preCheckCast(r8, float[].class, "com.obric.memorydata.plugin"))[r18]));
    L44:
        r5.put(r7, r8);
        goto L4
    L38:
        r10 = new JSONArray();
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, ((double[]) ZeusTransformUtils.preCheckCast(r8, double[].class, "com.obric.memorydata.plugin")).length), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L40:
        if (r19.hasNext() == false) goto L14;
        int r110 = ((IntIterator) ZeusTransformUtils.preCheckCast(r19, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        r10.put(r110, ((double[]) ZeusTransformUtils.preCheckCast(r8, double[].class, "com.obric.memorydata.plugin"))[r110]);
        goto L40
    L29:
        r10 = new JSONArray();
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, ((boolean[]) ZeusTransformUtils.preCheckCast(r8, boolean[].class, "com.obric.memorydata.plugin")).length), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L31:
        if (r111.hasNext() == false) goto L14;
        int r112 = ((IntIterator) ZeusTransformUtils.preCheckCast(r111, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        r10.put(r112, ((boolean[]) ZeusTransformUtils.preCheckCast(r8, boolean[].class, "com.obric.memorydata.plugin"))[r112]);
        goto L31
    L20:
        r10 = new JSONArray();
        Iterator r113 = ((Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, ((long[]) ZeusTransformUtils.preCheckCast(r8, long[].class, "com.obric.memorydata.plugin")).length), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L22:
        if (r113.hasNext() == false) goto L14;
        int r114 = ((IntIterator) ZeusTransformUtils.preCheckCast(r113, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        r10.put(r114, ((long[]) ZeusTransformUtils.preCheckCast(r8, long[].class, "com.obric.memorydata.plugin"))[r114]);
        goto L22
    L10:
        r10 = new JSONArray();
        Iterator r115 = ((Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, ((int[]) ZeusTransformUtils.preCheckCast(r8, int[].class, "com.obric.memorydata.plugin")).length), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r115.hasNext() == false) goto L14;
        int r116 = ((IntIterator) ZeusTransformUtils.preCheckCast(r115, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        r10.put(r116, ((int[]) ZeusTransformUtils.preCheckCast(r8, int[].class, "com.obric.memorydata.plugin"))[r116]);
        goto L12
    L7:
        r5.put(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L4
    L73:
        return r5;
    }

    public static final Bundle commonParams(Bundle r1, String r2, String r3, String r4, String r5, String r6, String r7, String[] r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "methodName");
        Intrinsics.checkNotNullParameter(r4, "callType");
        Intrinsics.checkNotNullParameter(r6, "apiDomain");
        Intrinsics.checkNotNullParameter(r7, "apiEntrance");
        r1.putString(IdlKeys.Args_BizName, r2);
        r1.putString(IdlKeys.Call_Type, r4);
        r1.putString(IdlKeys.MethodName, r3);
        r1.putString(IdlKeys.Args_SCENE, r5);
        r1.putString(IdlKeys.Args_ApiEntrance, r7);
        r1.putString(IdlKeys.Args_ApiDomain, r6);
        r1.putStringArray(IdlKeys.Args_PACKAGE_ARR, r8);
        if (r1.containsKey(IdlKeys.Args_TraceId) == true) goto L5;
        r1.putString(IdlKeys.Args_TraceId, UUID.randomUUID().toString());
    L5:
        if (r9 == true) goto L9;
        r1.putString(IdlKeys.Args_SdkVer, a.f5987a.b());
        r1.putLong(IdlKeys.Args_ReqTime, SystemClock.elapsedRealtime());
        AIKernelConfig r10 = a.f5987a.a();
        if (r10 == null) goto L9;
        r1.putLong(IdlKeys.Args_AppId, r10.getAppId());
        r1.putString(IdlKeys.Args_PackageName, r10.getPackageName());
    L9:
        return r1;
    }

    public static /* synthetic */ Bundle commonParams$default(Bundle r12, String r13, String r14, String r15, String r16, String r17, String r18, String[] r19, boolean r20, int r21, Object r22) {
        if ((r21 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r21 & 8) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r21 & 64) == 0) goto L17;
        String[] r10 = new String[0];
    L19:
        if ((r21 & 128) == 0) goto L21;
        boolean r11 = false;
    L23:
        return commonParams(r12, r4, r5, r15, r7, r17, r18, r10, r11);
    L21:
        r11 = r20;
        goto L23
    L17:
        r10 = r19;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    public static final void err(b r7, int r8, String r9) {
        b r10 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r9, "errInfo");
        safeOnResult(r10, setErr$default(new Bundle(), r8, r9, false, 4, null));
    }

    public static /* synthetic */ void err$default(b r1, int r2, String r3, int r4, Object r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r1, b.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = IdlErrors.INSTANCE.toString(r2);
    L5:
        err(r6, r2, r3);
    }

    public static final String getAIKTraceId(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = r2.getString(IdlKeys.Args_TraceId, "");
        Intrinsics.checkNotNullExpressionValue(r3, "this.getString(IdlKeys.Args_TraceId, \"\")");
        return r3;
    }

    public static final String getBizName(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = r2.getString(IdlKeys.Args_BizName, null);
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    public static final int getErrorCode(Bundle r2) {
        if (r2 != null) goto L6;
        return 108;
    L6:
        return r2.getInt(IdlKeys.ErrorCode, 0);
    }

    public static final String getErrorMsg(Bundle r1) {
        if (r1 == null) goto L4;
        String r2 = r1.getString(IdlKeys.ErrorInfo);
    L5:
        if (r2 != null) goto L8;
        return "";
    L8:
        return r2;
    L4:
        r2 = null;
        goto L5
    }

    public static final Bundle getFAIL() {
        return FAIL;
    }

    public static final <T> String getLogId(Response<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Bundle r2 = r1.getSrc();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getString("log_id");
    }

    public static final String getMethod(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getString(IdlKeys.MethodName);
    }

    public static final String getModelName(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getString(IdlKeys.Args_ModelName);
    }

    public static final Bundle getOK() {
        return OK;
    }

    public static final List<PackageResource> getPackageInfos(Bundle r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        r6.setClassLoader(PackageResource.class.getClassLoader());
        Parcelable[] r7 = r6.getParcelableArray(IdlKeys.Args_Pkgs);
        if (r7 == null) goto L11;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        int r3 = r7.length;
    L5:
        if (r1 >= r3) goto L16;
        Parcelable r4 = r7[r1];
        if (ZeusTransformUtils.instanceOf(r4, PackageResource.class) == false) goto L9;
        r0.add(r4);
    L9:
        r1 = r1 + 1;
        goto L5
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L11:
        return null;
    }

    public static final String getPackageName(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = r2.getString(IdlKeys.Args_PackageName, null);
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    public static final long getSdkVer(Bundle r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        String r13 = r12.getString(IdlKeys.Args_SdkVer, "");
        Intrinsics.checkNotNullExpressionValue(r13, "sdkVer");
        List r0 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"-"}, false, 0, 6, null);
        if (r0.size() <= 1) goto L5;
        List r14 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r0.get(0), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null), Collection.class, "com.obric.memorydata.plugin"));
    L7:
        if (r14.size() == 3) goto L9;
        return -1;
    L9:
        Integer r1 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r14.get(0), String.class, "com.obric.memorydata.plugin"));
        Integer r2 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r14.get(1), String.class, "com.obric.memorydata.plugin"));
        Integer r15 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r14.get(2), String.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L22;
        if (r2 == null) goto L22;
        if (r15 == null) goto L22;
        if (new IntRange(0, 1000).contains(r1.intValue()) == false) goto L22;
        if (new IntRange(0, 1000).contains(r2.intValue()) == false) goto L22;
        if (new IntRange(0, 1000).contains(r15.intValue()) == false) goto L22;
        return ((((long) r1.intValue()) * TimeUtils.NANOSECONDS_PER_MILLISECOND) + (((long) r2.intValue()) * 1000)) + ((long) r15.intValue());
    L22:
        return -1;
    L5:
        r14 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null);
        goto L7
    }

    public static final long getTaskId(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.getLong(IdlKeys.Result);
    }

    public static final <T> String getTraceId(Response<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Bundle r2 = r1.getSrc();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getString("trace_id");
    }

    public static final boolean isCallBiz(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1.getString(IdlKeys.Call_Type), IdlKeys.Call_Type_CallBiz);
    }

    public static final boolean isCallGlobal(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1.getString(IdlKeys.Call_Type), IdlKeys.Call_Type_CallGlobal);
    }

    public static final boolean isCallGlobalBiz(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1.getString(IdlKeys.Call_Type), IdlKeys.Call_Type_CallGlobalBiz);
    }

    public static final boolean isCallModel(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1.getString(IdlKeys.Call_Type), IdlKeys.Call_Type_CallModel);
    }

    public static final boolean isCallScene(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(r1.getString(IdlKeys.Call_Type), IdlKeys.Call_Type_CallScene);
    }

    public static final boolean isError(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return !isSuccess(r1);
    }

    public static final boolean isFinish(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.getBoolean(IdlKeys.IsFinish, true);
    }

    public static final boolean isGetModel(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (Intrinsics.areEqual(r2.getString(IdlKeys.Call_Type), IdlKeys.Call_Type_CallGlobal) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.getString(IdlKeys.MethodName), IdlKeys.Method_GetModel) == false) goto L7;
        return true;
    }

    public static final boolean isSuccess(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r3 = r2.getInt(IdlKeys.ErrorCode, 0);
        if (r3 == 0) goto L6;
        if (r3 == 1) goto L6;
        return false;
    L6:
        return true;
    }

    public static final boolean isTaskId(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getBoolean(IdlKeys.IsTaskId);
    }

    public static final Bundle json2Bundle(JSONObject r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "args");
        Bundle r0 = new Bundle();
        Iterator<String> r1 = r6.keys();
        Intrinsics.checkNotNullExpressionValue(r1, "args.keys()");
    L4:
        if (r1.hasNext() == false) goto L33;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        Object r3 = r6.get(r2);
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, Long.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r3, Float.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r3, Double.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r3, JSONArray.class) == true) goto L29;
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L4;
        r0.putBundle(r2, json2Bundle((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin"), r7));
        goto L4
    L29:
        JSONArray r4 = (JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "key");
        saveArr(r4, r2, r0, r7);
        goto L4
    L23:
        double r5 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r7 == true) goto L25;
        r0.putDouble(r2, r5);
        goto L4
    L25:
        float r8 = (float) r5;
    L20:
        r0.putFloat(r2, r8);
        goto L4
    L19:
        r8 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).floatValue();
        goto L20
    L16:
        r0.putBoolean(r2, ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        goto L4
    L13:
        r0.putLong(r2, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L4
    L10:
        r0.putInt(r2, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L4
    L7:
        r0.putString(r2, (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        goto L4
    L33:
        return r0;
    }

    public static /* synthetic */ Bundle json2Bundle$default(JSONObject r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = true;
    L6:
        return json2Bundle(r0, r1);
    }

    public static final boolean safeOnResult(b r2, Bundle r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, ChatMessage.TYPE_RESPONSE);
        r4.onResult(r3);     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        AIKLog.INSTANCE.e("TaskOnResult", String.valueOf(th.getMessage()));
        return false;
    }

    public static /* synthetic */ boolean safeOnResult$default(b r1, Bundle r2, int r3, Object r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r1, b.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = OK;
    L6:
        return safeOnResult(r5, r2);
    }

    public static final Bundle safeUnparcel(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.m1421constructorimpl(Integer.valueOf(getErrorCode(r4)));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r1);
        if (r2 == null) goto L10;
        AIKLog.INSTANCE.w("AIK-SDK-DataParser", "safeUnparcel exception: " + r2);
    L10:
        return r4;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final void saveArr(JSONArray r6, String r7, Bundle r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "arr");
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r8, "bundle");
        if (r6.length() != 0) goto L5;
        return;
    L5:
        Object r1 = r6.opt(0);
        if (r1 != null) goto L8;
        return;
    L8:
        IntRange r2 = new IntRange(0, r6.length() - 1);
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L16;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        r3.add(r6.getString(((IntIterator) ZeusTransformUtils.preCheckCast(r11, IntIterator.class, "com.obric.memorydata.plugin")).nextInt()));
        goto L12
    L14:
        r8.putStringArray(r7, (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"));
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L23;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L19:
        if (r13.hasNext() == false) goto L21;
        r0.add(Integer.valueOf(r6.getInt(((IntIterator) ZeusTransformUtils.preCheckCast(r13, IntIterator.class, "com.obric.memorydata.plugin")).nextInt())));
        goto L19
    L21:
        r8.putIntArray(r7, CollectionsKt.toIntArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(r1, Long.class) == false) goto L30;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L26:
        if (r15.hasNext() == false) goto L28;
        r4.add(Long.valueOf(r6.getLong(((IntIterator) ZeusTransformUtils.preCheckCast(r15, IntIterator.class, "com.obric.memorydata.plugin")).nextInt())));
        goto L26
    L28:
        r8.putLongArray(r7, CollectionsKt.toLongArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        return;
    L30:
        if (ZeusTransformUtils.instanceOf(r1, Boolean.class) == false) goto L37;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L33:
        if (r17.hasNext() == false) goto L35;
        r5.add(Boolean.valueOf(r6.getBoolean(((IntIterator) ZeusTransformUtils.preCheckCast(r17, IntIterator.class, "com.obric.memorydata.plugin")).nextInt())));
        goto L33
    L35:
        r8.putBooleanArray(r7, CollectionsKt.toBooleanArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        return;
    L37:
        if (ZeusTransformUtils.instanceOf(r1, Float.class) == false) goto L44;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L40:
        if (r20.hasNext() == false) goto L42;
        r19.add(Float.valueOf((float) r6.getDouble(((IntIterator) ZeusTransformUtils.preCheckCast(r20, IntIterator.class, "com.obric.memorydata.plugin")).nextInt())));
        goto L40
    L42:
        r8.putFloatArray(r7, CollectionsKt.toFloatArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        return;
    L44:
        if (ZeusTransformUtils.instanceOf(r1, Double.class) == false) goto L57;
        if (r9 == false) goto L51;
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r23 = r21.iterator();
    L48:
        if (r23.hasNext() == false) goto L50;
        r22.add(Float.valueOf((float) r6.getDouble(((IntIterator) ZeusTransformUtils.preCheckCast(r23, IntIterator.class, "com.obric.memorydata.plugin")).nextInt())));
        goto L48
    L50:
        r8.putFloatArray(r7, CollectionsKt.toFloatArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        return;
    L51:
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r24.iterator();
    L53:
        if (r26.hasNext() == false) goto L55;
        r25.add(Double.valueOf(r6.getDouble(((IntIterator) ZeusTransformUtils.preCheckCast(r26, IntIterator.class, "com.obric.memorydata.plugin")).nextInt())));
        goto L53
    L55:
        r8.putDoubleArray(r7, CollectionsKt.toDoubleArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        return;
    L57:
        if (ZeusTransformUtils.instanceOf(r1, JSONObject.class) == false) goto L63;
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r29 = r27.iterator();
    L60:
        if (r29.hasNext() == false) goto L62;
        JSONObject r30 = r6.getJSONObject(((IntIterator) ZeusTransformUtils.preCheckCast(r29, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        Intrinsics.checkNotNullExpressionValue(r30, "arr.getJSONObject(it)");
        r28.add(json2Bundle(r30, r9));
        goto L60
    L62:
        r8.putParcelableArray(r7, (Parcelable[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new Bundle[0]), Parcelable[].class, "com.obric.memorydata.plugin"));
        return;
    L63:
        ZeusTransformUtils.instanceOf(r1, JSONArray.class);
    }

    public static final <T> Bundle setBasicTypeRes(Bundle r2, T r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.putInt(IdlKeys.ErrorCode, r4);
        r2.putString(IdlKeys.ErrorInfo, r5);
        boolean r0 = true;
        if (r4 != 1) goto L6;
        r0 = false;
    L6:
        r2.putBoolean(IdlKeys.IsFinish, r0);
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L10;
        r2.putInt(IdlKeys.Result, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue());
    L42:
        return r2;
    L10:
        if ((r3 instanceof int[]) == false) goto L13;
        r2.putIntArray(IdlKeys.Result, (int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.memorydata.plugin"));
        goto L42
    L13:
        if (ZeusTransformUtils.instanceOf(r3, Float.class) == false) goto L16;
        r2.putFloat(IdlKeys.Result, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L42
    L16:
        if ((r3 instanceof float[]) == false) goto L19;
        r2.putFloatArray(IdlKeys.Result, (float[]) ZeusTransformUtils.preCheckCast(r3, float[].class, "com.obric.memorydata.plugin"));
        goto L42
    L19:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L22;
        r2.putString(IdlKeys.Result, (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        goto L42
    L22:
        if (ZeusTransformUtils.instanceOf(r3, Byte.class) == false) goto L25;
        r2.putByte(IdlKeys.Result, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).byteValue());
        goto L42
    L25:
        if ((r3 instanceof byte[]) == false) goto L28;
        r2.putByteArray(IdlKeys.Result, (byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"));
        goto L42
    L28:
        if (ZeusTransformUtils.instanceOf(r3, Character.class) == false) goto L31;
        r2.putChar(IdlKeys.Result, ((Character) ZeusTransformUtils.preCheckCast(r3, Character.class, "com.obric.memorydata.plugin")).charValue());
        goto L42
    L31:
        if ((r3 instanceof char[]) == false) goto L34;
        r2.putCharArray(IdlKeys.Result, (char[]) ZeusTransformUtils.preCheckCast(r3, char[].class, "com.obric.memorydata.plugin"));
        goto L42
    L34:
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == false) goto L37;
        r2.putBoolean(IdlKeys.Result, ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        goto L42
    L37:
        if ((r3 instanceof boolean[]) == false) goto L40;
        r2.putBooleanArray(IdlKeys.Result, (boolean[]) ZeusTransformUtils.preCheckCast(r3, boolean[].class, "com.obric.memorydata.plugin"));
        goto L42
    L40:
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L42;
        r2.putBundle(IdlKeys.Result, json2Bundle$default((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin"), false, 2, null));
        goto L42
    }

    public static /* synthetic */ Bundle setBasicTypeRes$default(Bundle r0, Object r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return setBasicTypeRes(r0, r1, r2, r3);
    }

    public static final Bundle setBizCall(Bundle r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "bizName");
        Intrinsics.checkNotNullParameter(r14, "apiDomain");
        Intrinsics.checkNotNullParameter(r15, "apiEntrance");
        return commonParams$default(r12, r13, IdlKeys.Method_RunBiz, IdlKeys.Call_Type_CallBiz, null, r14, r15, null, false, 200, null);
    }

    public static final Bundle setErr(Bundle r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.putInt(IdlKeys.ErrorCode, r2);
        r1.putString(IdlKeys.ErrorInfo, r3);
        r1.putBoolean(IdlKeys.IsFinish, true);
        return r1;
    }

    public static final Bundle setErr(Bundle r1, int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "errInfo");
        r1.putInt(IdlKeys.ErrorCode, r2);
        r1.putString(IdlKeys.ErrorInfo, r3);
        r1.putBoolean(IdlKeys.IsFinish, r4);
        return r1;
    }

    public static /* synthetic */ Bundle setErr$default(Bundle r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = IdlErrors.INSTANCE.toString(r1);
    L6:
        return setErr(r0, r1, r2);
    }

    public static /* synthetic */ Bundle setErr$default(Bundle r0, int r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 108;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = IdlErrors.INSTANCE.toString(r1);
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = true;
    L12:
        return setErr(r0, r1, r2, r3);
    }

    public static final Bundle setGlobalCall(Bundle r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "methodName");
        Intrinsics.checkNotNullParameter(r14, "apiDomain");
        Intrinsics.checkNotNullParameter(r15, "apiEntrance");
        return commonParams$default(r12, "", r13, IdlKeys.Call_Type_CallGlobalBiz, null, r14, r15, null, false, 200, null);
    }

    public static final Bundle setInvalidArg(Bundle r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "errInfo");
        setErr$default(r7, 101, r8, false, 4, null);
        return r7;
    }

    public static /* synthetic */ Bundle setInvalidArg$default(Bundle r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "invalid arguments.";
    L6:
        return setInvalidArg(r0, r1);
    }

    public static final Bundle setMethod(Bundle r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        r1.putString(IdlKeys.MethodName, r2);
        return r1;
    }

    public static final Bundle setOK(Bundle r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "errInfo");
        r1.putInt(IdlKeys.ErrorCode, r2);
        r1.putString(IdlKeys.ErrorInfo, r3);
        boolean r4 = true;
        if (r2 != 1) goto L6;
        r4 = false;
    L6:
        r1.putBoolean(IdlKeys.IsFinish, r4);
        return r1;
    }

    public static /* synthetic */ Bundle setOK$default(Bundle r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = "";
    L9:
        return setOK(r0, r1, r2);
    }

    public static final Bundle setResApply(Bundle r2, int r3, Function1<? super Bundle, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r5, "block");
        r2.putInt(IdlKeys.ErrorCode, r3);
        r2.putString(IdlKeys.ErrorInfo, null);
        boolean r0 = true;
        if (r3 != 1) goto L6;
        r0 = false;
    L6:
        r2.putBoolean(IdlKeys.IsFinish, r0);
        r5.invoke(r2);
        return r2;
    }

    public static /* synthetic */ Bundle setResApply$default(Bundle r1, int r2, Function1 r3, int r4, Object r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        return setResApply(r1, r2, r6);
    }

    public static final Bundle setTaskIdRes(Bundle r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.putInt(IdlKeys.ErrorCode, 1);
        r2.putBoolean(IdlKeys.IsTaskId, true);
        r2.putLong(IdlKeys.Result, r3);
        return r2;
    }

    public static final <T> Response<T> toBasicTypeResponse(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new Response(r10.getInt(IdlKeys.ErrorCode, 0), r10.getString(IdlKeys.ErrorInfo), r10.get(IdlKeys.Result), r10.getBoolean(IdlKeys.IsFinish, true), r10.getBoolean(IdlKeys.IsTaskId, false), toExtraResponse(r10), r10);
    }

    public static final Bundle toE2EDurationResponse(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        long r0 = r4.getLong(IdlKeys.Args_ReqTime, -1);
        if (r0 <= 0) goto L5;
        r4.putLong(IdlKeys.Args_End2EndCost, SystemClock.elapsedRealtime() - r0);
    L5:
        return r4;
    }

    public static final JSONObject toExtraResponse(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JSONObject r0 = new JSONObject();
        r0.put(IdlKeys.Args_TraceId, r5.getString(IdlKeys.Args_TraceId, ""));
        r0.put(IdlKeys.Args_TraceEventKey, r5.getString(IdlKeys.Args_TraceEventKey, ""));
        r0.put(IdlKeys.Args_TraceEventArgs, r5.getString(IdlKeys.Args_TraceEventArgs, ""));
        r0.put(IdlKeys.Args_UseCloud, r5.getBoolean(IdlKeys.Args_UseCloud));
        r0.put(IdlKeys.Args_Timeout, r5.getLong(IdlKeys.Args_Timeout));
        long r1 = r5.getLong(IdlKeys.Args_ReqTime, -1);
        if (r1 <= 0) goto L5;
        r0.put(IdlKeys.Args_End2EndCost, SystemClock.elapsedRealtime() - r1);
    L5:
        return r0;
    }

    public static final Response<JSONObject> toJsonResult(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r3 = r10.getInt(IdlKeys.ErrorCode, 0);
        String r4 = r10.getString(IdlKeys.ErrorInfo);
        Bundle r0 = r10.getBundle(IdlKeys.Result);
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        Intrinsics.checkNotNullExpressionValue(r0, "getBundle(IdlKeys.Result)?: Bundle()");
        return new Response(r3, r4, bundle2json(r0), r10.getBoolean(IdlKeys.IsFinish, true), r10.getBoolean(IdlKeys.IsTaskId, false), toExtraResponse(r10), r10);
    }

    public static final <T> Response<T> toNetResponse(Bundle r10, Function2<? super Bundle, ? super String, ? extends T> r11) {
        Function2 r12 = (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "block");
        int r3 = r10.getInt(IdlKeys.ErrorCode, 0);
        String r4 = r10.getString(IdlKeys.ErrorInfo);
        boolean r6 = r10.getBoolean(IdlKeys.IsFinish, true);
        boolean r7 = r10.getBoolean(IdlKeys.IsTaskId, false);
        return new Response(r3, r4, r12.invoke(r10, IdlKeys.Result), r6, r7, toExtraResponse(r10), r10);
    }

    public static final <T> Response<T> toUserResponse(Bundle r10, Function2<? super Bundle, ? super String, ? extends T> r11) {
        Function2 r12 = (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "block");
        int r3 = r10.getInt(IdlKeys.ErrorCode, 0);
        String r4 = r10.getString(IdlKeys.ErrorInfo);
        boolean r6 = r10.getBoolean(IdlKeys.IsFinish, true);
        boolean r7 = r10.getBoolean(IdlKeys.IsTaskId, false);
        return new Response(r3, r4, r12.invoke(r10, IdlKeys.Result), r6, r7, toExtraResponse(r10), r10);
    }
}
