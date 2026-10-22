package com.larus.dora.impl.network;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.bmhome.auth.CocoSetting;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.core.DoraUserManager;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.dynamic.quicknote.entity.QuickNoteKeys;
import com.larus.dora.impl.ota.g2.G2OtaFacade;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraNetworkApi {
    public static final DoraNetworkApi a = null;

    static {
        a = new DoraNetworkApi();
    }

    public DoraNetworkApi() {
    }

    public static boolean o(int r1) {
        if (r1 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static String D(com.larus.network.http.a r3) {
        if ((r3 instanceof com.larus.network.http.y) == false) goto L6;
        StringBuilder r0 = new StringBuilder("Success(code=");
        com.larus.network.http.y r4 = (com.larus.network.http.y) r3;
        r0.append(r4.g);
        r0.append(", msg=");
        r0.append(r4.f);
        r0.append(')');
        return r0.toString();
    L6:
        if ((r3 instanceof com.larus.network.http.f) == false) goto L9;
        return "Fail(error=" + ((com.larus.network.http.f) r3).d + ')';
    L9:
        if ((r3 instanceof com.larus.network.http.w) == false) goto L12;
        return "Loading";
    L12:
        if (Intrinsics.areEqual(r3, com.larus.network.http.z.d) == false) goto L16;
        return "Uninitialized";
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public static String E(a49.h r8) {
        if (r8 != null) goto L5;
        return "null";
    L5:
        a49.a r9 = r8.a();
        a49.a r0 = null;
        a49.i r1 = null;
        if (r9 == null) goto L20;
        a49.e r2 = r9.a();
        if (r2 != null) goto L10;
        a49.e r3 = null;
    L16:
        if (r9.b() == null) goto L18;
        r1 = new a49.i("<redacted>", "<redacted>", "<redacted>", "<redacted>", "<redacted>");
    L18:
        r0 = new a49.a(r3, r1);
        goto L20
    L10:
        if (r2.e() == null) goto L12;
        a49.g r4 = new a49.g("<redacted>", "<redacted>", "<redacted>");
    L13:
        r3 = a49.e.a(r2, r4);
        goto L16
    L12:
        r4 = null;
    L20:
        return new a49.h(r0).toString();
    }

    public static final e0 a(com.larus.bmhome.auth.e0 r13) {
        if (r13 == null) goto L9;
        List r14 = r13.p();
        if (r14 == null) goto L9;
        List r15 = r14;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r16 = r15.iterator();
    L7:
        if (r16.hasNext() == false) goto L11;
        CocoSetting r1 = (CocoSetting) r16.next();
        r0.add(new c(r1.a(), r1.e(), r1.d(), r1.c(), r1.b(), r1.h(), r1.i(), r1.g(), 256));
    L11:
        return new e0(r0);
    L9:
        r0 = null;
        goto L11
    }

    public static String m(JSONObject r1) {
        Object r2 = r1.opt("product_id");
        if (r2 != null) goto L5;
    L10:
        return null;
    L5:
        if (Intrinsics.areEqual(r2, JSONObject.NULL) == true) goto L10;
        String r3 = r2.toString();
        if (p(r3) == false) goto L10;
        return r3;
    }

    public static boolean p(String r1) {
        Integer r2 = StringsKt.toIntOrNull(r1);
        if (r2 != null) goto L6;
    L8:
        return false;
    L6:
        if (r2.intValue() != (-1)) goto L8;
        return true;
    }

    public static String q(Object r3) {
        if (r3 != null) goto L5;
        return "null";
    L5:
        String r4 = r3.toString();
        int r0 = (r4.length() + 1) / 2;
        return StringsKt.repeat("*", r0) + StringsKt.drop(r4, r0);
    }

    public static String r(DoraDevice r2) {
        return "id1=" + q(r2.getSerialNumber()) + ", id2=" + q(r2.sn) + ", id3=" + r2.productId;
    }

    public final Object M(Continuation<? super Result<e0>> r6) {
        if ((r6 instanceof DoraNetworkApi$userLaunch$1) == false) goto L7;
        DoraNetworkApi$userLaunch$1 r0 = (DoraNetworkApi$userLaunch$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L18:
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        DoraNetworkApi$userLaunch$2 r4 = new DoraNetworkApi$userLaunch$2(null);
        r0.label = 1;
        r7 = BuildersKt.withContext(r8, r4, r0);
        if (r7 != r2) goto L18;
        return r2;
    L7:
        r0 = new DoraNetworkApi$userLaunch$1(this, r6);
        goto L8
    }

    public static Object n(String r1, Object r2) {
        String r3 = r1 + " skip request because product_id is invalid, productId=" + r2;
        g49.d.b("DoraNetworkApi", r3);
        Result.Companion r4 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException(r3)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v4 */
    public final Object F(DoraDevice r24, Continuation<? super Result<Integer>> r25) {
        DoraDevice r0 = r24;
        String r2 = "unbindDevice: call is failed ";
        char r5 = "request_success(";
        if ((r25 instanceof DoraNetworkApi$unbindDevice$1) == false) goto L7;
        DoraNetworkApi$unbindDevice$1 r9 = (DoraNetworkApi$unbindDevice$1) r25;
        int r10 = r9.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r9.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r1 = r9.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r9.label;
        if (r11 == 0) goto L16;
        if (r11 != 1) goto L15;
        r0 = (DoraDevice) r9.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L79
        r2 = "unbindDevice: call is failed ";
    L35:
        com.larus.network.http.f r3 = (com.larus.network.http.a) r1;     // Catch: Throwable -> L79
        boolean r4 = r3 instanceof com.larus.network.http.y;     // Catch: Throwable -> L79
        if (r4 != 0) goto L85;
    L58:
        r5 = 41;
        if ((r3 instanceof com.larus.network.http.f) == false) goto L62;
        String r6 = "call is Fail(" + fm9.a.a(r3.d) + ')';     // Catch: Throwable -> L77
    L70:
        g49.d.b("DoraNetworkApi", "unbindDevice: failed, " + r6 + ", call = " + r3);     // Catch: Throwable -> L77
        int r7 = m.a;     // Catch: Throwable -> L77
        m.c(false, "request_failure(" + r6 + ')');     // Catch: Throwable -> L75
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L75
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException(r2 + r3)));
    L62:
        if ((r3 instanceof com.larus.network.http.w) == false) goto L65;
        r6 = "call is Loading";
        goto L70
    L65:
        if ((r3 instanceof com.larus.network.http.y) == false) goto L68;
        r6 = "call is Success(" + ((com.larus.network.http.y) r3).g + ", " + ((com.larus.network.http.y) r3).f + ')';     // Catch: Throwable -> L77
        goto L70
    L68:
        if (Intrinsics.areEqual(r3, com.larus.network.http.z.d) == false) goto L74;
        r6 = "call is Uninitialized";
        goto L70
    L74:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L75
    L75:
        th = th;
    L81:
        String r12 = fm9.a.a(th).toString();
        int r13 = m.a;
        m.c(r4, "request_failure(" + r12 + r5);
        Result.Companion r14 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L85:
        r4 = ((com.larus.network.http.y) r3).g;     // Catch: Throwable -> L56
        if (r4 == 0) goto L58;
        r4 = (r4.longValue() > 0 ? 1 : (r4.longValue() == 0 ? 0 : -1));
        if (r4 != 0) goto L58;
        c0 r16 = (c0) ((com.larus.network.http.a) ((com.larus.network.http.y) r3)).b;     // Catch: Throwable -> L56
        if (r16 == null) goto L46;
        Integer r17 = Boxing.boxInt(r16.a());     // Catch: Throwable -> L79
    L47:
        int r18 = m.a;     // Catch: Throwable -> L56
        StringBuilder r20 = new StringBuilder("request_success(");     // Catch: Throwable -> L56
        r20.append(r17);     // Catch: Throwable -> L56
        r20.append(')');     // Catch: Throwable -> L77
        m.c(true, r20.toString());     // Catch: Throwable -> L77
        if (r17 != null) goto L52;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L77
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("unbindDevice: data is null " + r3)));
    L52:
        if (r17.intValue() != 1) goto L89;
        G2OtaFacade.INSTANCE.getClass();     // Catch: Throwable -> L77
        G2OtaFacade.M(r0);     // Catch: Throwable -> L77
    L89:
        return Result.constructor-impl(r17);
    L46:
        r17 = null;
    L56:
        th = th;
        r5 = 41;
    L78:
        r4 = 0;
    L77:
        th = th;
        goto L78
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r1);
        JSONObject r22 = new JSONObject();     // Catch: Throwable -> L79
        int r110 = r0.type;     // Catch: Throwable -> L79
        if (r110 != 0) goto L20;
        int r111 = 1;
    L21:
        if (r110 != 0) goto L23;
        r110 = 1;
    L23:
        long r112 = (((long) r110) * 100) + 1;     // Catch: Throwable -> L79
        String r113 = r0.typeName;     // Catch: Throwable -> L79
        if (r113 != null) goto L27;
        r113 = "";
    L27:
        String r23 = r113;
        if (r0.vendorId != 4096) goto L30;
        int r114 = r0.productId;     // Catch: Throwable -> L79
        r112 = ((long) (r114 * 100)) + 1;     // Catch: Throwable -> L79
        String r115 = "";
    L31:
        r22.put("hardware_device_type", r114);     // Catch: Throwable -> L79
        r22.put("dora_type", r112);     // Catch: Throwable -> L79
        r22.put("product_code", r115);     // Catch: Throwable -> L79
        r22.put("serial_number", r24.getSerialNumber());     // Catch: Throwable -> L79
        g49.d.d("DoraNetworkApi", "unbindDevice: " + r(r24));     // Catch: Throwable -> L79
        com.larus.dora.api.network.a r116 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L79
        r9.L$0 = r0;     // Catch: Throwable -> L79
        r9.label = 1;     // Catch: Throwable -> L79
        Object r26 = com.larus.dora.api.network.a.c(r116, c0.class, "https://api-normal.doubao.com/alice/device/unbind", r22, null, r9, 248);     // Catch: Throwable -> L79
        if (r26 != r15) goto L34;
        return r15;
    L34:
        r1 = r26;
        goto L35
    L30:
        r114 = r111;
        r115 = r23;
        goto L31
    L20:
        r111 = r110;
    L79:
        th = th;
        r4 = 0;
        r5 = 41;
    L7:
        r9 = new DoraNetworkApi$unbindDevice$1(this, r25);
        goto L8
    }

    public final Object I(JSONObject r12, Continuation<? super Result<Boolean>> r13) {
        if ((r13 instanceof DoraNetworkApi$updateUserSettingsJson$1) == false) goto L7;
        DoraNetworkApi$updateUserSettingsJson$1 r2 = (DoraNetworkApi$updateUserSettingsJson$1) r13;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$updateUserSettingsJson$1 r8 = r2;
        Object r14 = r8.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r8.label;
        boolean r10 = true;
        if (r5 == 0) goto L15;
        if (r5 != 1) goto L14;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L34
    L22:
        com.larus.network.http.y r15 = (com.larus.network.http.a) r14;     // Catch: Throwable -> L34
        g49.d.d("DoraNetworkApi", "updateUserSettingsJson call is " + r15);     // Catch: Throwable -> L34
        if ((r15 instanceof com.larus.network.http.y) == false) goto L32;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L34
        Long r17 = r15.g;     // Catch: Throwable -> L34
        if (r17 != null) goto L28;
    L30:
        r10 = false;
    L38:
        return Result.constructor-impl(Boxing.boxBoolean(r10));
    L28:
        if (r17.longValue() != 0) goto L30;
    L32:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L34
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("updateUserSettings: call is failed " + r15)));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        String r110 = m(r12);
        if (r110 != null) goto L18;
        com.larus.dora.api.network.a r6 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L34
        r8.label = 1;     // Catch: Throwable -> L34
        r14 = com.larus.dora.api.network.a.c(r6, String.class, "https://api-normal.doubao.com/alice/device/update_user_settings", r12, null, r8, 248);     // Catch: Throwable -> L34
        if (r14 != r4) goto L22;
        return r4;
    L18:
        return n("updateUserSettingsJson", r110);
    L34:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new DoraNetworkApi$updateUserSettingsJson$1(this, r13);
        goto L8
    }

    public final Object J(DoraDevice r14, Continuation<? super Result<Integer>> r15) {
        if ((r15 instanceof DoraNetworkApi$uploadDeviceBasicInfo$1) == false) goto L7;
        DoraNetworkApi$uploadDeviceBasicInfo$1 r3 = (DoraNetworkApi$uploadDeviceBasicInfo$1) r15;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$uploadDeviceBasicInfo$1 r9 = r3;
        Object r16 = r9.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r9.label;
        if (r6 == 0) goto L16;
        if (r6 != 1) goto L15;
        JSONObject r17 = (JSONObject) r9.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L44
    L21:
        com.larus.network.http.y r18 = (com.larus.network.http.a) r16;     // Catch: Throwable -> L44
        g49.d.d("DoraNetworkApi", "uploadDeviceBasicInfo call is " + r18 + ", req: " + r17);     // Catch: Throwable -> L44
        if ((r18 instanceof com.larus.network.http.y) == false) goto L30;
        Long r110 = r18.g;     // Catch: Throwable -> L44
        if (r110 == null) goto L30;
        if (r110.longValue() != 0) goto L30;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L44
        return Result.constructor-impl(Boxing.boxInt(0));
    L30:
        if ((r18 instanceof com.larus.network.http.f) == false) goto L33;
        g49.d.c("DoraNetworkApi", "uploadDeviceBasicInfo: call is fail", ((com.larus.network.http.f) r18).d.getCause());     // Catch: Throwable -> L44
    L42:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L44
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("uploadDeviceBasicInfo: call is failed " + r18)));
    L33:
        if ((r18 instanceof com.larus.network.http.w) == true) goto L42;
        if ((r18 instanceof com.larus.network.http.y) == false) goto L38;
        g49.d.b("DoraNetworkApi", "uploadDeviceBasicInfo: failed, but call is success, call = " + r18);     // Catch: Throwable -> L44
        goto L42
    L38:
        if (Intrinsics.areEqual(r18, com.larus.network.http.z.d) == true) goto L42;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L44
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r16);
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L44
        r113.put("w_did", r14.getDeviceId());     // Catch: Throwable -> L44
        r113.put("real_mac", r14.mac);     // Catch: Throwable -> L44
        r113.put("real_sn", r14.sn);     // Catch: Throwable -> L44
        com.larus.dora.api.network.a r7 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L44
        r9.L$0 = r113;     // Catch: Throwable -> L44
        r9.label = 1;     // Catch: Throwable -> L44
        Object r114 = com.larus.dora.api.network.a.c(r7, f.class, "https://api-normal.doubao.com/alice/w/device/basic_info", r113, null, r9, 248);     // Catch: Throwable -> L44
        if (r114 != r5) goto L20;
        return r5;
    L20:
        r16 = r114;
        r17 = r113;
    L44:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "uploadDeviceBasicInfo exception", th);
        Result.Companion r115 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r3 = new DoraNetworkApi$uploadDeviceBasicInfo$1(this, r15);
        goto L8
    }

    public final Object d(List<String> r13, Continuation<? super Result<Boolean>> r14) {
        if ((r14 instanceof DoraNetworkApi$batchDeleteNotificationRules$1) == false) goto L7;
        DoraNetworkApi$batchDeleteNotificationRules$1 r2 = (DoraNetworkApi$batchDeleteNotificationRules$1) r14;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$batchDeleteNotificationRules$1 r8 = r2;
        Object r15 = r8.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r8.label;
        boolean r10 = true;
        if (r5 == 0) goto L15;
        if (r5 != 1) goto L14;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L31
    L19:
        com.larus.network.http.y r16 = (com.larus.network.http.a) r15;     // Catch: Throwable -> L31
        g49.d.d("DoraNetworkApi", "batchDeleteNotificationRules call is " + r16);     // Catch: Throwable -> L31
        if ((r16 instanceof com.larus.network.http.y) == false) goto L29;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L31
        Long r18 = r16.g;     // Catch: Throwable -> L31
        if (r18 != null) goto L25;
    L27:
        r10 = false;
    L35:
        return Result.constructor-impl(Boxing.boxBoolean(r10));
    L25:
        if (r18.longValue() != 0) goto L27;
    L29:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L31
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("batchDeleteNotificationRules: call is failed " + r16)));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r15);
        com.larus.dora.api.network.a r6 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L31
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L31
        r7.put("rule_id", new JSONArray(r13));     // Catch: Throwable -> L31
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L31
        r8.label = 1;     // Catch: Throwable -> L31
        r15 = com.larus.dora.api.network.a.c(r6, Object.class, "https://api-normal.doubao.com/alice/w/notification/custom_rule/batch_delete", r7, null, r8, 248);     // Catch: Throwable -> L31
        if (r15 != r4) goto L19;
        return r4;
    L31:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "batchDeleteNotificationRules exception", th);
        Result.Companion r112 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new DoraNetworkApi$batchDeleteNotificationRules$1(this, r14);
        goto L8
    }

    public final Object h(String r12, Continuation<? super Result<? extends List<String>>> r13) {
        if ((r13 instanceof DoraNetworkApi$clarifyNotificationRule$1) == false) goto L7;
        DoraNetworkApi$clarifyNotificationRule$1 r2 = (DoraNetworkApi$clarifyNotificationRule$1) r13;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$clarifyNotificationRule$1 r8 = r2;
        Object r14 = r8.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r8.label;
        if (r5 == 0) goto L15;
        if (r5 != 1) goto L14;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L40
    L19:
        com.larus.network.http.y r15 = (com.larus.network.http.a) r14;     // Catch: Throwable -> L40
        g49.d.d("DoraNetworkApi", "clarifyNotificationRule call is " + r15);     // Catch: Throwable -> L40
        if ((r15 instanceof com.larus.network.http.y) == false) goto L30;
        u r16 = (u) ((com.larus.network.http.a) r15).b;     // Catch: Throwable -> L40
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L40
        if (r16 == null) goto L27;
        List<String> r18 = r16.a();     // Catch: Throwable -> L40
        if (r18 == null) goto L27;
        List r110 = CollectionsKt.filterNotNull(r18);     // Catch: Throwable -> L40
        if (r110 == null) goto L27;
    L44:
        return Result.constructor-impl(r110);
    L27:
        r110 = CollectionsKt.emptyList();     // Catch: Throwable -> L40
        goto L44
    L30:
        if ((r15 instanceof com.larus.network.http.f) == false) goto L32;
        com.larus.network.http.f r111 = (com.larus.network.http.f) r15;     // Catch: Throwable -> L40
    L33:
        if (r111 == null) goto L37;
        AsyncThrowable r112 = r111.d;     // Catch: Throwable -> L40
        if (r112 == null) goto L37;
    L38:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L40
        return Result.constructor-impl(ResultKt.createFailure(r112));
    L37:
        r112 = new RuntimeException("clarifyNotificationRule: call is failed " + r15);     // Catch: Throwable -> L40
        goto L38
    L32:
        r111 = null;
        goto L33
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        com.larus.dora.api.network.a r6 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L40
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L40
        r7.put("original_desc", r12);     // Catch: Throwable -> L40
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L40
        r8.label = 1;     // Catch: Throwable -> L40
        r14 = com.larus.dora.api.network.a.c(r6, u.class, "https://api-normal.doubao.com/alice/w/notification/custom_rule/clarify", r7, null, r8, 248);     // Catch: Throwable -> L40
        if (r14 != r4) goto L19;
        return r4;
    L40:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "clarifyNotificationRule exception", th);
        Result.Companion r115 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new DoraNetworkApi$clarifyNotificationRule$1(this, r13);
        goto L8
    }

    public final Object i(List<String> r12, Continuation<? super Result<Boolean>> r13) {
        if ((r13 instanceof DoraNetworkApi$createNotificationRule$1) == false) goto L7;
        DoraNetworkApi$createNotificationRule$1 r2 = (DoraNetworkApi$createNotificationRule$1) r13;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$createNotificationRule$1 r8 = r2;
        Object r14 = r8.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r8.label;
        if (r5 == 0) goto L15;
        if (r5 != 1) goto L14;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L35
    L19:
        com.larus.network.http.y r15 = (com.larus.network.http.a) r14;     // Catch: Throwable -> L35
        g49.d.d("DoraNetworkApi", "createNotificationRule call is " + r15);     // Catch: Throwable -> L35
        if ((r15 instanceof com.larus.network.http.y) == false) goto L33;
        Long r16 = r15.g;     // Catch: Throwable -> L35
        if (r16 == null) goto L33;
        if (r16.longValue() != 0) goto L33;
        t r17 = (t) ((com.larus.network.http.a) r15).b;     // Catch: Throwable -> L35
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L35
        if (r17 == null) goto L31;
        Boolean r110 = r17.a();     // Catch: Throwable -> L35
        if (r110 == null) goto L31;
        boolean r111 = r110.booleanValue();     // Catch: Throwable -> L35
    L39:
        return Result.constructor-impl(Boxing.boxBoolean(r111));
    L31:
        r111 = false;
    L33:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L35
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("createNotificationRule: call is failed " + r15)));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        com.larus.dora.api.network.a r6 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L35
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L35
        r7.put("rule_desc", new JSONArray(r12));     // Catch: Throwable -> L35
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L35
        r8.label = 1;     // Catch: Throwable -> L35
        r14 = com.larus.dora.api.network.a.c(r6, t.class, "https://api-normal.doubao.com/alice/w/notification/custom_rule/create", r7, null, r8, 248);     // Catch: Throwable -> L35
        if (r14 != r4) goto L19;
        return r4;
    L35:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "createNotificationRule exception", th);
        Result.Companion r114 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new DoraNetworkApi$createNotificationRule$1(this, r13);
        goto L8
    }

    public final Object s(Boolean r11, Continuation<? super Result<? extends List<NotificationRule>>> r12) {
        if ((r12 instanceof DoraNetworkApi$queryNotificationRules$1) == false) goto L7;
        DoraNetworkApi$queryNotificationRules$1 r2 = (DoraNetworkApi$queryNotificationRules$1) r12;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$queryNotificationRules$1 r7 = r2;
        Object r13 = r7.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r7.label;
        if (r5 == 0) goto L15;
        if (r5 != 1) goto L14;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L46
    L29:
        com.larus.network.http.y r14 = (com.larus.network.http.a) r13;     // Catch: Throwable -> L46
        g49.d.d("DoraNetworkApi", "queryNotificationRules call is " + r14);     // Catch: Throwable -> L46
        if ((r14 instanceof com.larus.network.http.y) == false) goto L44;
        Long r15 = r14.g;     // Catch: Throwable -> L46
        if (r15 == null) goto L44;
        if (r15.longValue() != 0) goto L44;
        v r16 = (v) ((com.larus.network.http.a) r14).b;     // Catch: Throwable -> L46
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L46
        if (r16 == null) goto L42;
        List<NotificationRule> r18 = r16.a();     // Catch: Throwable -> L46
        if (r18 == null) goto L42;
        List r110 = CollectionsKt.filterNotNull(r18);     // Catch: Throwable -> L46
        if (r110 == null) goto L42;
    L50:
        return Result.constructor-impl(r110);
    L42:
        r110 = CollectionsKt.emptyList();     // Catch: Throwable -> L46
    L44:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L46
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("queryNotificationRules: call is failed " + r14)));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
        LinkedHashMap r112 = new LinkedHashMap();     // Catch: Throwable -> L46
        if (r11 == null) goto L24;
        if (r11.booleanValue() == false) goto L21;
        boolean r113 = true;
    L22:
        r112.put("status", String.valueOf(r113));     // Catch: Throwable -> L46
        goto L24
    L21:
        r113 = false;
    L24:
        if (r112.isEmpty() == false) goto L26;
        r112 = null;
    L26:
        r7.label = 1;     // Catch: Throwable -> L46
        r13 = HttpExtKt.h("DORA", v.class, "https://api-normal.doubao.com/alice/w/notification/custom_rule/list", r112, r7, BaiduNaviStatus.NO_PERMISSION);     // Catch: Throwable -> L46
        if (r13 != r4) goto L29;
        return r4;
    L46:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "queryNotificationRules exception", th);
        Result.Companion r114 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new DoraNetworkApi$queryNotificationRules$1(this, r12);
        goto L8
    }

    public final Object u(DoraDevice r14, Continuation<? super Result<y>> r15) {
        if ((r15 instanceof DoraNetworkApi$queryQuickNoteLink$1) == false) goto L7;
        DoraNetworkApi$queryQuickNoteLink$1 r4 = (DoraNetworkApi$queryQuickNoteLink$1) r15;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$queryQuickNoteLink$1 r9 = r4;
        Object r16 = r9.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r9.label;
        if (r7 == 0) goto L15;
        if (r7 != 1) goto L14;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L35
    L22:
        com.larus.network.http.y r17 = (com.larus.network.http.a) r16;     // Catch: Throwable -> L35
        g49.d.d("DoraNetworkApi", "queryQuickNoteLink call is " + r17);     // Catch: Throwable -> L35
        if ((r17 instanceof com.larus.network.http.y) == false) goto L33;
        Long r18 = r17.g;     // Catch: Throwable -> L35
        if (r18 == null) goto L33;
        if (r18.longValue() != 0) goto L33;
        y r110 = (y) ((com.larus.network.http.a) r17).b;     // Catch: Throwable -> L35
        if (r110 != null) goto L39;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L35
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("queryQuickNoteLink: data is null " + r17)));
    L39:
        return Result.constructor-impl(r110);
    L33:
        g49.d.b("DoraNetworkApi", "queryQuickNoteLink: call is failed " + r17);     // Catch: Throwable -> L35
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L35
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("syncStatus: call is failed " + r17)));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
        int r113 = o59.a.c(r14);
        if (o(r113) == true) goto L18;
        HashMap r114 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("w_did", r14.getSerialNumber()), TuplesKt.to("product_id", String.valueOf(r113))});     // Catch: Throwable -> L35
        r9.label = 1;     // Catch: Throwable -> L35
        r16 = HttpExtKt.h("DORA", y.class, "https://api-normal.doubao.com/alice/w/note/url", r114, r9, BaiduNaviStatus.NO_PERMISSION);     // Catch: Throwable -> L35
        if (r16 != r6) goto L22;
        return r6;
    L18:
        return n("queryQuickNoteLink", Boxing.boxInt(r113));
    L35:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "queryQuickNoteLink exception", th);
        Result.Companion r115 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r4 = new DoraNetworkApi$queryQuickNoteLink$1(this, r15);
        goto L8
    }

    public final Object v(boolean r13, Continuation<? super Result<f0>> r14) {
        if ((r14 instanceof DoraNetworkApi$queryUserSettings$1) == false) goto L7;
        DoraNetworkApi$queryUserSettings$1 r3 = (DoraNetworkApi$queryUserSettings$1) r14;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$queryUserSettings$1 r9 = r3;
        Object r15 = r9.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r9.label;
        int r11 = 0;
        if (r6 == 0) goto L15;
        if (r6 != 1) goto L14;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L54
    L35:
        com.larus.network.http.y r16 = (com.larus.network.http.a) r15;     // Catch: Throwable -> L54
        g49.d.d("DoraNetworkApi", "queryUserSettings call is " + r16);     // Catch: Throwable -> L54
        if ((r16 instanceof com.larus.network.http.y) == false) goto L52;
        Long r17 = r16.g;     // Catch: Throwable -> L54
        if (r17 == null) goto L52;
        if (r17.longValue() != 0) goto L52;
        h0 r18 = (h0) ((com.larus.network.http.a) r16).b;     // Catch: Throwable -> L54
        if (r18 == null) goto L45;
        f0 r1 = r18.a();     // Catch: Throwable -> L54
    L46:
        if (r1 == null) goto L51;
        DoraAVLinkDelegate r110 = DoraAVLinkDelegate.b;     // Catch: Throwable -> L54
        g0 r0 = r18.a().d();     // Catch: Throwable -> L54
        if (r0 == null) goto L50;
        r11 = r0.d();     // Catch: Throwable -> L54
    L50:
        r110.E(r11);     // Catch: Throwable -> L54
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L54
        return Result.constructor-impl(r18.a());
    L51:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L54
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("queryUserSettings: data is null " + r16)));
    L45:
        r1 = null;
    L52:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L54
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("queryUserSettings: call is failed " + r16)));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r15);
        DoraDevice r114 = kj4.a.g().c();     // Catch: Throwable -> L54
        com.larus.dora.api.network.a r7 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L54
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L54
        if (r13 == false) goto L19;
        boolean r115 = true;
    L20:
        r8.put("with_app_list", r115);     // Catch: Throwable -> L54
        if (r114 != null) goto L23;
    L25:
        boolean r116 = false;
    L26:
        if (r116 == true) goto L28;
    L32:
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L54
        r9.label = 1;     // Catch: Throwable -> L54
        r15 = com.larus.dora.api.network.a.c(r7, h0.class, "https://api-normal.doubao.com/alice/device/query_user_settings", r8, null, r9, 248);     // Catch: Throwable -> L54
        if (r15 != r5) goto L35;
        return r5;
    L28:
        if (r114 == null) goto L30;
        Object r118 = Boxing.boxInt(r114.productId);     // Catch: Throwable -> L54
    L31:
        r8.put("product_id", r118.toString());     // Catch: Throwable -> L54
        goto L32
    L30:
        r118 = "";
        goto L31
    L23:
        if (o59.a.l(r114) != true) goto L25;
        r116 = true;
        goto L26
    L19:
        r115 = false;
    L54:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r3 = new DoraNetworkApi$queryUserSettings$1(this, r14);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public final Object w(DoraDevice r27, Continuation<? super Result<Integer>> r28) {
        DoraDevice r0 = r27;
        String r4 = "replaceBindDevice: ";
        if ((r28 instanceof DoraNetworkApi$replaceBindDevice$1) == false) goto L7;
        DoraNetworkApi$replaceBindDevice$1 r11 = (DoraNetworkApi$replaceBindDevice$1) r28;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r1 = r11.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r11.label;
        ?? r3 = "request_failure(";
        if (r13 != 0) goto L11;
        ResultKt.throwOnFailure(r1);
        ?? r2 = new JSONObject();     // Catch: Throwable -> L83
        int r14 = r0.type;     // Catch: Throwable -> L83
        if (r14 != 0) goto L21;
        int r16 = 1;
    L22:
        int r17 = r16;
        if (r14 != 0) goto L25;
        r14 = 1;
    L25:
        long r18 = (((long) r14) * 100) + 1;     // Catch: Throwable -> L83
        String r110 = r0.typeName;     // Catch: Throwable -> L83
        if (r110 != null) goto L29;
        String r23 = "";
    L31:
        if (r0.vendorId != 4096) goto L34;
        int r111 = r0.productId;     // Catch: Throwable -> L83
        r17 = r111;
        long r112 = ((long) (r111 * 100)) + 1;
        String r5 = "";
    L35:
        int r25 = r17;
        r2.put("hardware_device_type", r25);     // Catch: Throwable -> L80
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L80
        r8.put("hardware_device_type", r25);     // Catch: Throwable -> L80
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L80
        r113.put("dora_type", r112);     // Catch: Throwable -> L80
        r113.put("product_code", r5);     // Catch: Throwable -> L80
        r113.put("firmware_version", r0.softVersion);     // Catch: Throwable -> L80
        r113.put("serial_number", r27.getSerialNumber());     // Catch: Throwable -> L80
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L80
        r8.put("dora_info", r113);     // Catch: Throwable -> L80
        r2.put("device_info", r8);     // Catch: Throwable -> L80
        g49.d.d("DoraNetworkApi", "replaceBindDevice: " + r(r27));     // Catch: Throwable -> L80
        com.larus.dora.api.network.a r114 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L80
        r11.L$0 = r0;     // Catch: Throwable -> L80
        r11.label = 1;     // Catch: Throwable -> L80
        boolean r7 = false;
        Object r9 = r15;
        r1 = com.larus.dora.api.network.a.c(r114, b0.class, "https://api-normal.doubao.com/alice/device/replace_bind", r2, null, r11, 248);     // Catch: Throwable -> L78
        r3 = r9;
        ?? r21 = r3;
        if (r1 != r9) goto L41;
        return r9;
    L41:
        com.larus.network.http.y r10 = (com.larus.network.http.a) r1;     // Catch: Throwable -> L78
        g49.d.d("DoraNetworkApi", "call is " + r10);     // Catch: Throwable -> L78
        if ((r10 instanceof com.larus.network.http.y) == false) goto L90;
        Long r20 = r10.g;     // Catch: Throwable -> L78
        if (r20 == null) goto L90;
        if (r20.longValue() != 0) goto L90;
        b0 r22 = (b0) ((com.larus.network.http.a) r10).b;     // Catch: Throwable -> L78
        if (r22 == null) goto L51;
        Integer r24 = Boxing.boxInt(r22.a());     // Catch: Throwable -> L78
    L52:
        int r26 = m.a;     // Catch: Throwable -> L78
        m.b(true, "request_success(" + r24 + ')');     // Catch: Throwable -> L78
        if (r24 != null) goto L55;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L78
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("replaceBindDevice: data is null " + r10)));
    L55:
        if (r24.intValue() != 1) goto L92;
        G2OtaFacade.INSTANCE.J(r0);     // Catch: Throwable -> L78
    L92:
        return Result.constructor-impl(r24);
    L51:
        r24 = null;
    L90:
        if ((r10 instanceof com.larus.network.http.f) == false) goto L63;
        String r31 = "call is Fail(" + fm9.a.a(((com.larus.network.http.f) r10).d) + ')';     // Catch: Throwable -> L78
    L71:
        g49.d.b("DoraNetworkApi", "replaceBindDevice: failed, " + r31 + ", call = " + r10);     // Catch: Throwable -> L78
        int r32 = m.a;     // Catch: Throwable -> L78
        m.b(r7, r21 + r31 + ')');     // Catch: Throwable -> L76
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L76
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("replaceBindDevice: call is failed " + r10)));
    L63:
        if ((r10 instanceof com.larus.network.http.w) == false) goto L66;
        r31 = "call is Loading";
        goto L71
    L66:
        if ((r10 instanceof com.larus.network.http.y) == false) goto L69;
        r31 = "call is Success(" + r10.g + ", " + r10.f + ')';     // Catch: Throwable -> L78
        goto L71
    L69:
        if (Intrinsics.areEqual(r10, com.larus.network.http.z.d) == false) goto L75;
        r31 = "call is Uninitialized";
        goto L71
    L75:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L76
    L76:
        th = th;
    L85:
        String r34 = fm9.a.a(th).toString();
        int r35 = m.a;
        m.b(r7, r3 + r34 + ')');
        Result.Companion r36 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L78:
        th = th;
        r3 = r3;
    L80:
        th = th;
    L82:
        r7 = false;
        goto L85
    L34:
        r112 = r18;
        r5 = r23;
        goto L35
    L29:
        r23 = r110;
        goto L31
    L21:
        r16 = r14;
        goto L22
    L11:
        if (r13 != 1) goto L16;
        r0 = (DoraDevice) r11.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L83
        r21 = "request_failure(";
        r7 = false;
        r3 = r4;
        goto L41
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L83:
        th = th;
    L7:
        r11 = new DoraNetworkApi$replaceBindDevice$1(this, r28);
        goto L8
    }

    public final Object A(DoraDevice r13, JSONObject r14, Continuation<? super Result<Boolean>> r15) {
        if ((r15 instanceof DoraNetworkApi$syncDeviceInfo$1) == false) goto L7;
        DoraNetworkApi$syncDeviceInfo$1 r2 = (DoraNetworkApi$syncDeviceInfo$1) r15;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$syncDeviceInfo$1 r8 = r2;
        Object r16 = r8.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r8.label;
        if (r5 == 0) goto L16;
        if (r5 != 1) goto L15;
        r14 = (JSONObject) r8.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L33
    L23:
        com.larus.network.http.y r17 = (com.larus.network.http.a) r16;     // Catch: Throwable -> L33
        g49.d.d("DoraNetworkApi", "syncDeviceInfo call is " + r17 + ", info is " + r14);     // Catch: Throwable -> L33
        if ((r17 instanceof com.larus.network.http.y) == false) goto L31;
        Long r18 = r17.g;     // Catch: Throwable -> L33
        if (r18 == null) goto L31;
        if (r18.longValue() != 0) goto L31;
        g49.d.d("DoraNetworkApi", "syncDeviceInfo success");     // Catch: Throwable -> L33
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L33
        return Result.constructor-impl(Boxing.boxBoolean(true));
    L31:
        g49.d.b("DoraNetworkApi", "syncDeviceInfo: call is failed " + r17);     // Catch: Throwable -> L33
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L33
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("syncDeviceInfo: call is failed " + r17)));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r16);
        int r112 = n1.c(r13);
        if (o(r112) == true) goto L19;
        com.larus.dora.api.network.a r6 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L33
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L33
        r7.put("w_did", r13.getSerialNumber());     // Catch: Throwable -> L33
        r7.put("info", r14);     // Catch: Throwable -> L33
        r7.put("product_id", String.valueOf(r112));     // Catch: Throwable -> L33
        r7.put("did", r13.getDeviceId());     // Catch: Throwable -> L33
        r7.put("uid", AccountService.a.getUserId());     // Catch: Throwable -> L33
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L33
        r8.L$0 = r14;     // Catch: Throwable -> L33
        r8.label = 1;     // Catch: Throwable -> L33
        r16 = com.larus.dora.api.network.a.c(r6, Object.class, "https://api-normal.doubao.com/alice/w/device/sync_info", r7, null, r8, 248);     // Catch: Throwable -> L33
        if (r16 != r4) goto L23;
        return r4;
    L19:
        return n("syncDeviceInfo", Boxing.boxInt(r112));
    L33:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "syncDeviceInfo exception", th);
        Result.Companion r114 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new DoraNetworkApi$syncDeviceInfo$1(this, r15);
        goto L8
    }

    public final Object B(DoraDevice r18, z r110, Continuation<? super Result<Boolean>> r20) {
        if ((r20 instanceof DoraNetworkApi$syncQuickNoteConfigInfo$1) == false) goto L7;
        DoraNetworkApi$syncQuickNoteConfigInfo$1 r3 = (DoraNetworkApi$syncQuickNoteConfigInfo$1) r20;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$syncQuickNoteConfigInfo$1 r10 = r3;
        Object r0 = r10.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r10.label;
        if (r6 == 0) goto L16;
        if (r6 != 1) goto L15;
        z r7 = (z) r10.L$1;
        DoraDevice r8 = (DoraDevice) r10.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L33
        z r14 = r7;
        Object r9 = r0;
        DoraDevice r1 = r8;
    L23:
        com.larus.network.http.y r11 = (com.larus.network.http.a) r9;     // Catch: Throwable -> L33
        g49.d.d("DoraNetworkApi", "syncQuickNoteConfigInfo call is " + r11 + ", info is " + r14 + ", wd:" + r1.getSerialNumber());     // Catch: Throwable -> L33
        if ((r11 instanceof com.larus.network.http.y) == false) goto L31;
        Long r2 = r11.g;     // Catch: Throwable -> L33
        if (r2 == null) goto L31;
        if (r2.longValue() != 0) goto L31;
        g49.d.d("DoraNetworkApi", "syncQuickNoteConfigInfo success");     // Catch: Throwable -> L33
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L33
        return Result.constructor-impl(Boxing.boxBoolean(true));
    L31:
        g49.d.b("DoraNetworkApi", "syncQuickNoteConfigInfo: call is failed " + r11);     // Catch: Throwable -> L33
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L33
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("syncQuickNoteConfigInfo: call is failed " + r11)));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
        int r15 = o59.a.c(r18);
        if (o(r15) == true) goto L19;
        com.larus.dora.api.network.a r16 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L33
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L33
        r17.put("w_did", r18.getSerialNumber());     // Catch: Throwable -> L33
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L33
        r111.putOpt(QuickNoteKeys.LEFT_LONG_PRESS.getValue(), r110.c());     // Catch: Throwable -> L33
        r111.putOpt(QuickNoteKeys.RIGHT_LONG_PRESS.getValue(), r110.e());     // Catch: Throwable -> L33
        r111.putOpt(QuickNoteKeys.LEFT_DOUBLE_CLICK.getValue(), r110.b());     // Catch: Throwable -> L33
        r111.putOpt(QuickNoteKeys.RIGHT_DOUBLE_CLICK.getValue(), r110.d());     // Catch: Throwable -> L33
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L33
        r17.put("info", r111);     // Catch: Throwable -> L33
        r17.put("product_id", String.valueOf(r15));     // Catch: Throwable -> L33
        r1 = r18;
        r10.L$0 = r1;     // Catch: Throwable -> L33
        r14 = r110;
        r10.L$1 = r14;     // Catch: Throwable -> L33
        r10.label = 1;     // Catch: Throwable -> L33
        r9 = com.larus.dora.api.network.a.c(r16, Object.class, "https://api-normal.doubao.com/alice/w/device/sync_info", r17, null, r10, 248);     // Catch: Throwable -> L33
        if (r9 != r5) goto L23;
        return r5;
    L19:
        return n("syncQuickNoteConfigInfo", Boxing.boxInt(r15));
    L33:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "syncQuickNoteConfigInfo exception", th);
        Result.Companion r21 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r3 = new DoraNetworkApi$syncQuickNoteConfigInfo$1(this, r20);
        goto L8
    }

    public final Object e(DoraDevice r31, boolean r32, Continuation<? super Result<b>> r33) {
        DoraDevice r0 = r31;
        boolean r1 = r32;
        String r10 = "call is Success(";
        if ((r33 instanceof DoraNetworkApi$bindDevice$1) == false) goto L7;
        DoraNetworkApi$bindDevice$1 r13 = (DoraNetworkApi$bindDevice$1) r33;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r2 = r13.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r13.label;
        String r4 = "DoraNetworkApi";
        String r9 = "request_failure(";
        if (r16 != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L100
        int r17 = r0.type;     // Catch: Throwable -> L100
        if (r17 != 0) goto L21;
        int r18 = 1;
    L22:
        int r110 = r18;
        if (r17 != 0) goto L25;
        r17 = 1;
    L25:
        long r111 = (((long) r17) * 100) + 1;     // Catch: Throwable -> L100
        String r112 = r0.typeName;     // Catch: Throwable -> L100
        if (r112 != null) goto L29;
        String r24 = "";
    L31:
        if (r0.vendorId != 4096) goto L34;
        int r113 = r0.productId;     // Catch: Throwable -> L100
        long r114 = ((long) (r113 * 100)) + 1;
        int r11 = r113;
        String r12 = "";
    L105:
        r3.put("hardware_device_type", r11);     // Catch: Throwable -> L98
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L98
        r5.put("hardware_device_type", r11);     // Catch: Throwable -> L98
        JSONObject r20 = new JSONObject();     // Catch: Throwable -> L98
        r20.put("dora_type", r114);     // Catch: Throwable -> L98
        r20.put("product_code", r12);     // Catch: Throwable -> L98
        r20.put("firmware_version", r0.softVersion);     // Catch: Throwable -> L98
        r20.put("serial_number", r31.getSerialNumber());     // Catch: Throwable -> L98
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L98
        r5.put("dora_info", r20);     // Catch: Throwable -> L98
        r3.put("device_info", r5);     // Catch: Throwable -> L98
        StringBuilder r6 = new StringBuilder("bindDevice: ");     // Catch: Throwable -> L98
        r6.append(r(r31));     // Catch: Throwable -> L98
        r6.append(", onlyCheck=");     // Catch: Throwable -> L98
        if (r1 == false) goto L38;
        boolean r8 = true;
    L39:
        r6.append(r8);     // Catch: Throwable -> L98
        g49.d.d("DoraNetworkApi", r6.toString());     // Catch: Throwable -> L98
        com.larus.dora.api.network.a r115 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L98
        r13.L$0 = r0;     // Catch: Throwable -> L98
        r13.Z$0 = r1;     // Catch: Throwable -> L98
        r13.label = 1;     // Catch: Throwable -> L98
        r2 = com.larus.dora.api.network.a.c(r115, b.class, "https://api-normal.doubao.com/alice/device/bindv2", r3, null, r13, 248);     // Catch: Throwable -> L98
        if (r2 != r15) goto L42;
        return r15;
    L42:
        com.larus.network.http.y r21 = (com.larus.network.http.a) r2;     // Catch: Throwable -> L98
        g49.d.d("DoraNetworkApi", "call is " + r21);     // Catch: Throwable -> L98
        if ((r21 instanceof com.larus.network.http.y) == false) goto L75;
        Long r22 = r21.g;     // Catch: Throwable -> L98
        if (r22 == null) goto L75;
        if (r22.longValue() != 0) goto L75;
        b r23 = (b) ((com.larus.network.http.a) r21).b;     // Catch: Throwable -> L98
        int r25 = m.a;     // Catch: Throwable -> L98
        StringBuilder r26 = new StringBuilder("request_success(");     // Catch: Throwable -> L98
        if (r23 == null) goto L52;
        Integer r27 = r23.b();     // Catch: Throwable -> L98
    L53:
        r26.append(r27);     // Catch: Throwable -> L98
        r26.append(')');     // Catch: Throwable -> L98
        String r28 = r26.toString();     // Catch: Throwable -> L98
        if (r1 == false) goto L56;
        boolean r30 = true;
    L57:
        m.a(true, r28, r30);     // Catch: Throwable -> L98
        if (r23 == null) goto L74;
        g49.d.d("DoraNetworkApi", "bindDevice: data=" + r23);     // Catch: Throwable -> L98
        Integer r34 = r23.c();     // Catch: Throwable -> L98
        if (r34 == null) goto L62;
        r34.intValue();     // Catch: Throwable -> L98
        DoraUserManager r35 = DoraUserManager.a;     // Catch: Throwable -> L98
    L62:
        Integer r36 = r23.b();     // Catch: Throwable -> L98
        if (r36 != null) goto L66;
    L67:
        Integer r37 = r23.b();     // Catch: Throwable -> L98
        if (r37 != null) goto L71;
    L107:
        return Result.constructor-impl(r23);
    L71:
        if (r37.intValue() != 4) goto L107;
    L72:
        G2OtaFacade.INSTANCE.J(r0);     // Catch: Throwable -> L98
        goto L107
    L66:
        if (r36.intValue() == 1) goto L72;
    L74:
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L98
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("bindDevice: data is null " + r21)));
    L56:
        r30 = false;
        goto L57
    L52:
        r27 = null;
    L75:
        boolean r40 = true;
        if ((r21 instanceof com.larus.network.http.f) == false) goto L79;
        String r41 = "call is Fail(" + fm9.a.a(((com.larus.network.http.f) r21).d) + ')';     // Catch: Throwable -> L98
    L87:
        g49.d.b("DoraNetworkApi", "bindDevice: failed, " + r41 + ", call = " + r21);     // Catch: Throwable -> L98
        int r42 = m.a;     // Catch: Throwable -> L98
        String r43 = r9 + r41 + ')';     // Catch: Throwable -> L96
        if (r1 == true) goto L93;
        r40 = false;
    L93:
        m.a(false, r43, r40);     // Catch: Throwable -> L96
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L96
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("bindDevice: call is failed " + r21)));
    L79:
        if ((r21 instanceof com.larus.network.http.w) == false) goto L82;
        r41 = "call is Loading";
        goto L87
    L82:
        if ((r21 instanceof com.larus.network.http.y) == false) goto L85;
        r41 = r10 + r21.g + ", " + r21.f + ')';     // Catch: Throwable -> L98
        goto L87
    L85:
        if (Intrinsics.areEqual(r21, com.larus.network.http.z.d) == false) goto L95;
        r41 = "call is Uninitialized";
        goto L87
    L95:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L96
    L96:
        th = th;
    L102:
        String r45 = fm9.a.a(th).toString();
        int r46 = m.a;
        m.a(false, r4 + r45 + ')', r1);
        Result.Companion r47 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L38:
        r8 = false;
    L98:
        th = th;
        r4 = r9;
        goto L102
    L34:
        r114 = r111;
        r12 = r24;
        r11 = r110;
        goto L105
    L29:
        r24 = r112;
        goto L31
    L21:
        r18 = r17;
        goto L22
    L11:
        if (r16 != 1) goto L16;
        r1 = r13.Z$0;
        r0 = (DoraDevice) r13.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L100
        r9 = "request_failure(";
        r10 = "call is Success(";
        goto L42
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L100:
        th = th;
        r4 = "request_failure(";
    L7:
        r13 = new DoraNetworkApi$bindDevice$1(this, r33);
        goto L8
    }

    public final Object g(String r11, String r12, Continuation<? super Result<w>> r13) {
        if ((r13 instanceof DoraNetworkApi$checkUserOnboardingStatus$1) == false) goto L7;
        DoraNetworkApi$checkUserOnboardingStatus$1 r2 = (DoraNetworkApi$checkUserOnboardingStatus$1) r13;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$checkUserOnboardingStatus$1 r7 = r2;
        Object r14 = r7.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r7.label;
        if (r5 == 0) goto L16;
        if (r5 != 1) goto L15;
        HashMap r15 = (HashMap) r7.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L37
    L24:
        com.larus.network.http.y r16 = (com.larus.network.http.a) r14;     // Catch: Throwable -> L37
        g49.d.d("DoraNetworkApi", "checkUserOnboardingStatus call is " + r16 + ", query=" + r15);     // Catch: Throwable -> L37
        if ((r16 instanceof com.larus.network.http.y) == false) goto L35;
        Long r17 = r16.g;     // Catch: Throwable -> L37
        if (r17 == null) goto L35;
        if (r17.longValue() != 0) goto L35;
        w r18 = (w) ((com.larus.network.http.a) r16).b;     // Catch: Throwable -> L37
        if (r18 != null) goto L41;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L37
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("checkUserOnboardingStatus: data is null")));
    L41:
        return Result.constructor-impl(r18);
    L35:
        g49.d.b("DoraNetworkApi", "checkUserOnboardingStatus: call is failed " + r16);     // Catch: Throwable -> L37
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L37
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("checkUserOnboardingStatus: call is failed " + r16)));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r14);
        if (p(r11) == false) goto L21;
        return n("checkUserOnboardingStatus", r11);
    L21:
        r15 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("product_id", r11), TuplesKt.to("w_did", r12)});     // Catch: Throwable -> L37
        r7.L$0 = r15;     // Catch: Throwable -> L37
        r7.label = 1;     // Catch: Throwable -> L37
        r14 = HttpExtKt.h("DORA", w.class, "https://api-normal.doubao.com/alice/w/user/guide/should_show", r15, r7, BaiduNaviStatus.NO_PERMISSION);     // Catch: Throwable -> L37
        if (r14 != r4) goto L24;
        return r4;
    L37:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "checkUserOnboardingStatus exception", th);
        Result.Companion r112 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new DoraNetworkApi$checkUserOnboardingStatus$1(this, r13);
        goto L8
    }

    public final Object j(int r13, List<String> r14, Continuation<? super Result<a49.c>> r15) {
        if ((r15 instanceof DoraNetworkApi$fetchDiaryBetaLatestCard$1) == false) goto L7;
        DoraNetworkApi$fetchDiaryBetaLatestCard$1 r3 = (DoraNetworkApi$fetchDiaryBetaLatestCard$1) r15;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$fetchDiaryBetaLatestCard$1 r9 = r3;
        Object r16 = r9.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r9.label;
        if (r6 == 0) goto L16;
        if (r6 != 1) goto L15;
        r13 = r9.I$0;
        r14 = (List) r9.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L33
    L20:
        com.larus.network.http.y r17 = (com.larus.network.http.a) r16;     // Catch: Throwable -> L33
        if ((r17 instanceof com.larus.network.http.y) == false) goto L31;
        Long r7 = r17.g;     // Catch: Throwable -> L33
        if (r7 == null) goto L31;
        if (r7.longValue() != 0) goto L31;
        a49.c r2 = (a49.c) ((com.larus.network.http.a) r17).b;     // Catch: Throwable -> L33
        if (r2 == null) goto L30;
        g49.d.a("DoraNetworkApi", "fetchDiaryBetaLatestCard success bizId=" + r13 + " types=" + r14);     // Catch: Throwable -> L33
        return Result.constructor-impl(r2);
    L30:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L33
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("fetchDiaryBetaLatestCard: data is null " + D(r17))));
    L31:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L33
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("fetchDiaryBetaLatestCard failed: " + D(r17))));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r16);
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L33
        r8.put("biz_id", r13);     // Catch: Throwable -> L33
        r8.put("card_types", new JSONArray(r14));     // Catch: Throwable -> L33
        com.larus.dora.api.network.a r10 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L33
        r9.L$0 = r14;     // Catch: Throwable -> L33
        r9.I$0 = r13;     // Catch: Throwable -> L33
        r9.label = 1;     // Catch: Throwable -> L33
        r16 = com.larus.dora.api.network.a.c(r10, a49.c.class, "/alice/wearable/diary_taste/latest_card", r8, null, r9, 248);     // Catch: Throwable -> L33
        if (r16 != r5) goto L20;
        return r5;
    L33:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "fetchDiaryBetaLatestCard error", th);
        Result.Companion r111 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r3 = new DoraNetworkApi$fetchDiaryBetaLatestCard$1(this, r15);
        goto L8
    }

    public final Object l(DoraDevice r24, List<String> r25, Continuation<? super Result<d>> r26) {
        if ((r26 instanceof DoraNetworkApi$getDeviceInfo$1) == false) goto L7;
        DoraNetworkApi$getDeviceInfo$1 r5 = (DoraNetworkApi$getDeviceInfo$1) r26;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$getDeviceInfo$1 r11 = r5;
        Object r0 = r11.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r11.label;
        if (r8 == 0) goto L16;
        if (r8 != 1) goto L15;
        String r9 = (String) r11.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L37
    L24:
        com.larus.network.http.y r1 = (com.larus.network.http.a) r0;     // Catch: Throwable -> L37
        g49.d.d("DoraNetworkApi", "getSettingsSwitchStatus call is " + r1 + "， key is " + r9);     // Catch: Throwable -> L37
        if ((r1 instanceof com.larus.network.http.y) == false) goto L35;
        Long r4 = r1.g;     // Catch: Throwable -> L37
        if (r4 == null) goto L35;
        if (r4.longValue() != 0) goto L35;
        d r2 = (d) ((com.larus.network.http.a) r1).b;     // Catch: Throwable -> L37
        if (r2 != null) goto L41;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L37
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("getDeviceInfo: data is null " + r1)));
    L41:
        return Result.constructor-impl(r2);
    L35:
        g49.d.b("DoraNetworkApi", "getSettingsSwitchStatus: call is failed " + r1);     // Catch: Throwable -> L37
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L37
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("syncStatus: call is failed " + r1)));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
        int r12 = n1.c(r24);
        if (o(r12) == true) goto L19;
        String r14 = CollectionsKt.joinToString$default(r25, ",", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L37
        HashMap r13 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("w_did", r24.getSerialNumber()), TuplesKt.to("keys", r14), TuplesKt.to("product_id", String.valueOf(r12))});     // Catch: Throwable -> L37
        r11.L$0 = r14;     // Catch: Throwable -> L37
        r11.label = 1;     // Catch: Throwable -> L37
        r0 = HttpExtKt.h("DORA", d.class, "https://api-normal.doubao.com/alice/w/device/info", r13, r11, BaiduNaviStatus.NO_PERMISSION);     // Catch: Throwable -> L37
        if (r0 != r7) goto L23;
        return r7;
    L23:
        r9 = r14;
        goto L24
    L19:
        return n("getDeviceInfo", Boxing.boxInt(r12));
    L37:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "getSettingsSwitchStatus exception", th);
        Result.Companion r15 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r5 = new DoraNetworkApi$getDeviceInfo$1(this, r26);
        goto L8
    }

    public final Object t(DoraDevice r24, List<String> r25, Continuation<? super Result<a0>> r26) {
        if ((r26 instanceof DoraNetworkApi$queryQuickNoteConfigInfo$1) == false) goto L7;
        DoraNetworkApi$queryQuickNoteConfigInfo$1 r5 = (DoraNetworkApi$queryQuickNoteConfigInfo$1) r26;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$queryQuickNoteConfigInfo$1 r11 = r5;
        Object r0 = r11.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r11.label;
        if (r8 == 0) goto L16;
        if (r8 != 1) goto L15;
        String r9 = (String) r11.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L37
    L24:
        com.larus.network.http.y r1 = (com.larus.network.http.a) r0;     // Catch: Throwable -> L37
        g49.d.d("DoraNetworkApi", "queryQuickNoteConfigInfo call is " + r1 + ", key is " + r9);     // Catch: Throwable -> L37
        if ((r1 instanceof com.larus.network.http.y) == false) goto L35;
        Long r4 = r1.g;     // Catch: Throwable -> L37
        if (r4 == null) goto L35;
        if (r4.longValue() != 0) goto L35;
        a0 r2 = (a0) ((com.larus.network.http.a) r1).b;     // Catch: Throwable -> L37
        if (r2 != null) goto L41;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L37
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("queryQuickNoteConfigInfo: data is null " + r1)));
    L41:
        return Result.constructor-impl(r2);
    L35:
        g49.d.b("DoraNetworkApi", "queryQuickNoteConfigInfo: call is failed " + r1);     // Catch: Throwable -> L37
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L37
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("syncStatus: call is failed " + r1)));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
        int r12 = o59.a.c(r24);
        if (o(r12) == true) goto L19;
        String r14 = CollectionsKt.joinToString$default(r25, ",", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L37
        HashMap r13 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("w_did", r24.getSerialNumber()), TuplesKt.to("product_id", String.valueOf(r12)), TuplesKt.to("keys", r14)});     // Catch: Throwable -> L37
        r11.L$0 = r14;     // Catch: Throwable -> L37
        r11.label = 1;     // Catch: Throwable -> L37
        r0 = HttpExtKt.h("DORA", a0.class, "https://api-normal.doubao.com/alice/w/device/info", r13, r11, BaiduNaviStatus.NO_PERMISSION);     // Catch: Throwable -> L37
        if (r0 != r7) goto L23;
        return r7;
    L23:
        r9 = r14;
        goto L24
    L19:
        return n("queryQuickNoteConfigInfo", Boxing.boxInt(r12));
    L37:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "queryQuickNoteConfigInfo exception", th);
        Result.Companion r15 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r5 = new DoraNetworkApi$queryQuickNoteConfigInfo$1(this, r26);
        goto L8
    }

    public final Object x(DoraDevice r20, List<String> r21, Continuation<? super Result<h>> r22) {
        if ((r22 instanceof DoraNetworkApi$requestDeviceGetInfo$1) == false) goto L7;
        DoraNetworkApi$requestDeviceGetInfo$1 r2 = (DoraNetworkApi$requestDeviceGetInfo$1) r22;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L15;
        if (r5 != 1) goto L14;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L38
    L25:
        com.larus.network.http.y r6 = (com.larus.network.http.a) r1;     // Catch: Throwable -> L38
        if ((r6 instanceof com.larus.network.http.y) == false) goto L36;
        Long r0 = r6.g;     // Catch: Throwable -> L38
        if (r0 == null) goto L36;
        if (r0.longValue() != 0) goto L36;
        h r7 = (h) ((com.larus.network.http.a) r6).b;     // Catch: Throwable -> L38
        if (r7 != null) goto L42;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L38
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("resp is null")));
    L42:
        return Result.constructor-impl(r7);
    L36:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L38
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("call is failed or code != 0")));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r1);
        int r10 = r20.productId;
        if (o(r10) == true) goto L18;
        String r11 = o59.a.A(r20.getSerialNumber(), r20.mac, Boxing.boxInt(r10));     // Catch: Throwable -> L38
        if (r11 != null) goto L22;
        r11 = "";
    L22:
        com.larus.dora.api.network.a r12 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L38
        Map r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("w_did", r11), TuplesKt.to("product_id", String.valueOf(r10)), TuplesKt.to("keys", CollectionsKt.joinToString$default(r21, ",", null, null, 0, null, null, 62, null))});     // Catch: Throwable -> L38
        r2.label = 1;     // Catch: Throwable -> L38
        r1 = com.larus.dora.api.network.a.b(r12, h.class, "https://api-normal.doubao.com/alice/w/device/info", r13, r2);     // Catch: Throwable -> L38
        if (r1 != r4) goto L25;
        return r4;
    L18:
        return n("requestDeviceGetInfo", Boxing.boxInt(r10));
    L38:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new DoraNetworkApi$requestDeviceGetInfo$1(this, r22);
        goto L8
    }

    public final Object y(DoraDevice r10, List<? extends Pair<String, ? extends Object>> r11, Continuation<? super Result<i>> r12) {
        if ((r12 instanceof DoraNetworkApi$requestDeviceSyncInfo$1) == false) goto L7;
        DoraNetworkApi$requestDeviceSyncInfo$1 r0 = (DoraNetworkApi$requestDeviceSyncInfo$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$requestDeviceSyncInfo$1 r6 = r0;
        Object r13 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L52
    L29:
        com.larus.network.http.y r14 = (com.larus.network.http.a) r13;     // Catch: Throwable -> L52
        if ((r14 instanceof com.larus.network.http.y) == false) goto L38;
        Long r15 = r14.g;     // Catch: Throwable -> L52
        if (r15 == null) goto L38;
        if (r15.longValue() != 0) goto L38;
        g49.d.d("DoraNetworkApi", "request device sync info success");     // Catch: Throwable -> L52
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L52
        return Result.constructor-impl(new i(r14.g, r14.f));
    L38:
        if ((r14 instanceof com.larus.network.http.f) == false) goto L41;
        String r17 = "call is Fail(" + fm9.a.a(((com.larus.network.http.f) r14).d) + ')';     // Catch: Throwable -> L52
    L49:
        g49.d.b("DoraNetworkApi", "request device sync info failed, " + r17 + ", call=" + r14);     // Catch: Throwable -> L52
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L52
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("call is failed or code != 0, " + r17)));
    L41:
        if ((r14 instanceof com.larus.network.http.w) == false) goto L44;
        r17 = "call is Loading";
        goto L49
    L44:
        if ((r14 instanceof com.larus.network.http.y) == false) goto L47;
        r17 = "call is Success(" + r14.g + ", " + r14.f + ')';     // Catch: Throwable -> L52
        goto L49
    L47:
        if (Intrinsics.areEqual(r14, com.larus.network.http.z.d) == false) goto L51;
        r17 = "call is Uninitialized";
        goto L49
    L51:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L52
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
        int r110 = r10.productId;
        if (o(r110) == true) goto L18;
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L52
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L52
        Iterator<? extends Pair<String, ? extends Object>> r111 = r11.iterator();     // Catch: Throwable -> L52
    L21:
        if (r111.hasNext() == false) goto L23;
        Pair<String, ? extends Object> r7 = r111.next();     // Catch: Throwable -> L52
        r5.put((String) r7.getFirst(), r7.getSecond());     // Catch: Throwable -> L52
        goto L21
    L23:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L52
        r4.put("info", r5);     // Catch: Throwable -> L52
        String r113 = o59.a.A(r10.getSerialNumber(), r10.mac, Boxing.boxInt(r110));     // Catch: Throwable -> L52
        if (r113 != null) goto L26;
        r113 = "";
    L26:
        com.larus.dora.api.network.a r8 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L52
        r6.label = 1;     // Catch: Throwable -> L52
        r13 = com.larus.dora.api.network.a.c(r8, i.class, "https://api-normal.doubao.com/alice/w/device/sync_info?w_did=" + r113 + "&product_id=" + r110, r4, null, r6, 248);     // Catch: Throwable -> L52
        if (r13 != r2) goto L29;
        return r2;
    L18:
        return n("requestDeviceSyncInfo", Boxing.boxInt(r110));
    L52:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "request device sync info err:", th);
        Result.Companion r114 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new DoraNetworkApi$requestDeviceSyncInfo$1(this, r12);
        goto L8
    }

    public final Object z(int r13, String r14, Continuation<? super Result<Integer>> r15) {
        if ((r15 instanceof DoraNetworkApi$requestSodaBannerClose$1) == false) goto L7;
        DoraNetworkApi$requestSodaBannerClose$1 r4 = (DoraNetworkApi$requestSodaBannerClose$1) r15;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$requestSodaBannerClose$1 r10 = r4;
        Object r16 = r10.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r10.label;
        if (r7 == 0) goto L15;
        if (r7 != 1) goto L14;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L42
    L19:
        com.larus.network.http.y r17 = (com.larus.network.http.a) r16;     // Catch: Throwable -> L42
        g49.d.d("DoraNetworkApi", "call is " + r17);     // Catch: Throwable -> L42
        if ((r17 instanceof com.larus.network.http.y) == false) goto L28;
        Long r18 = r17.g;     // Catch: Throwable -> L42
        if (r18 == null) goto L28;
        if (r18.longValue() != 0) goto L28;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L42
        return Result.constructor-impl(Boxing.boxInt(0));
    L28:
        if ((r17 instanceof com.larus.network.http.f) == false) goto L31;
        g49.d.c("DoraNetworkApi", "SodaBannerClose: call is fail", ((com.larus.network.http.f) r17).d.getCause());     // Catch: Throwable -> L42
    L40:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L42
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("SodaBannerClose: call is failed " + r17)));
    L31:
        if ((r17 instanceof com.larus.network.http.w) == true) goto L40;
        if ((r17 instanceof com.larus.network.http.y) == false) goto L36;
        g49.d.b("DoraNetworkApi", "SodaBannerClose: failed, but call is success, call = " + r17);     // Catch: Throwable -> L42
        goto L40
    L36:
        if (Intrinsics.areEqual(r17, com.larus.network.http.z.d) == true) goto L40;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L42
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L42
        r8.put("banner_type", r13);     // Catch: Throwable -> L42
        r8.put("serial_number", r14);     // Catch: Throwable -> L42
        com.larus.dora.api.network.a r9 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L42
        r10.label = 1;     // Catch: Throwable -> L42
        r16 = com.larus.dora.api.network.a.c(r9, String.class, "https://api-normal.doubao.com/alice/device/close_banner", r8, null, r10, 248);     // Catch: Throwable -> L42
        if (r16 != r6) goto L19;
        return r6;
    L42:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r4 = new DoraNetworkApi$requestSodaBannerClose$1(this, r15);
        goto L8
    }

    public final Object C(String r16, int r17, String r18, Continuation<? super Result<o>> r110) {
        if ((r110 instanceof DoraNetworkApi$syncStatus$1) == false) goto L7;
        DoraNetworkApi$syncStatus$1 r6 = (DoraNetworkApi$syncStatus$1) r110;
        int r7 = r6.label;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r7 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$syncStatus$1 r13 = r6;
        Object r0 = r13.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r13.label;
        if (r9 == 0) goto L15;
        if (r9 != 1) goto L14;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L45
    L19:
        com.larus.network.http.y r1 = (com.larus.network.http.a) r0;     // Catch: Throwable -> L45
        if ((r1 instanceof com.larus.network.http.y) == false) goto L31;
        Long r10 = r1.g;     // Catch: Throwable -> L45
        if (r10 == null) goto L31;
        if (r10.longValue() != 0) goto L31;
        o r2 = (o) ((com.larus.network.http.a) r1).b;     // Catch: Throwable -> L45
        if (r2 != null) goto L49;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L45
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("syncStatus: data is null " + r1)));
    L49:
        return Result.constructor-impl(r2);
    L31:
        if ((r1 instanceof com.larus.network.http.f) == false) goto L34;
        String r4 = "call is Fail(" + fm9.a.a(((com.larus.network.http.f) r1).d) + ')';     // Catch: Throwable -> L45
    L42:
        g49.d.b("DoraNetworkApi", "syncStatus: failed, " + r4 + ", call = " + r1);     // Catch: Throwable -> L45
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L45
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("syncStatus: call is failed " + r1)));
    L34:
        if ((r1 instanceof com.larus.network.http.w) == false) goto L37;
        r4 = "call is Loading";
        goto L42
    L37:
        if ((r1 instanceof com.larus.network.http.y) == false) goto L40;
        r4 = "call is Success(" + r1.g + ", " + r1.f + ')';     // Catch: Throwable -> L45
        goto L42
    L40:
        if (Intrinsics.areEqual(r1, com.larus.network.http.z.d) == false) goto L44;
        r4 = "call is Uninitialized";
        goto L42
    L44:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L45
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r0);
        com.larus.dora.api.network.a r11 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L45
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L45
        r12.put("series_no", r16);     // Catch: Throwable -> L45
        r12.put("sync_type", r17);     // Catch: Throwable -> L45
        r12.put("sync_event", r18);     // Catch: Throwable -> L45
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L45
        r13.label = 1;     // Catch: Throwable -> L45
        r0 = com.larus.dora.api.network.a.c(r11, o.class, "https://api-normal.doubao.com/alice/device/sync_status", r12, null, r13, 248);     // Catch: Throwable -> L45
        if (r0 != r8) goto L19;
        return r8;
    L45:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r6 = new DoraNetworkApi$syncStatus$1(this, r110);
        goto L8
    }

    public final Object G(String r17, boolean r18, String r110, Continuation<? super Result<Boolean>> r20) {
        if ((r20 instanceof DoraNetworkApi$updateNotificationRuleStatus$1) == false) goto L7;
        DoraNetworkApi$updateNotificationRuleStatus$1 r4 = (DoraNetworkApi$updateNotificationRuleStatus$1) r20;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$updateNotificationRuleStatus$1 r11 = r4;
        Object r1 = r11.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r11.label;
        boolean r13 = false;
        if (r7 == 0) goto L15;
        if (r7 != 1) goto L14;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L46
    L26:
        com.larus.network.http.y r2 = (com.larus.network.http.a) r1;     // Catch: Throwable -> L46
        g49.d.d("DoraNetworkApi", "updateNotificationRuleStatus call is " + r2);     // Catch: Throwable -> L46
        if ((r2 instanceof com.larus.network.http.y) == false) goto L36;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L46
        Long r3 = r2.g;     // Catch: Throwable -> L46
        if (r3 != null) goto L32;
    L50:
        return Result.constructor-impl(Boxing.boxBoolean(r13));
    L32:
        if (r3.longValue() != 0) goto L50;
        r13 = true;
        goto L50
    L36:
        if ((r2 instanceof com.larus.network.http.f) == false) goto L38;
        com.larus.network.http.f r8 = (com.larus.network.http.f) r2;     // Catch: Throwable -> L46
    L39:
        if (r8 == null) goto L43;
        AsyncThrowable r9 = r8.d;     // Catch: Throwable -> L46
        if (r9 == null) goto L43;
    L44:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L46
        return Result.constructor-impl(ResultKt.createFailure(r9));
    L43:
        r9 = new RuntimeException("updateNotificationRuleStatus: call is failed " + r2);     // Catch: Throwable -> L46
        goto L44
    L38:
        r8 = null;
        goto L39
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r1);
        com.larus.dora.api.network.a r12 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L46
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L46
        r14.put("rule_id", r17);     // Catch: Throwable -> L46
        if (r18 == false) goto L19;
        boolean r15 = true;
    L20:
        r14.put("new_status", r15);     // Catch: Throwable -> L46
        if (r110 == null) goto L23;
        r14.put("new_desc", r110);     // Catch: Throwable -> L46
    L23:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L46
        r11.label = 1;     // Catch: Throwable -> L46
        r1 = com.larus.dora.api.network.a.c(r12, Object.class, "https://api-normal.doubao.com/alice/w/notification/custom_rule/update", r14, null, r11, 248);     // Catch: Throwable -> L46
        if (r1 != r6) goto L26;
        return r6;
    L19:
        r15 = false;
    L46:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "updateNotificationRuleStatus exception", th);
        Result.Companion r21 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r4 = new DoraNetworkApi$updateNotificationRuleStatus$1(this, r20);
        goto L8
    }

    public final Object K(String r17, String r18, JSONArray r110, Continuation<? super Result<Boolean>> r20) {
        if ((r20 instanceof DoraNetworkApi$uploadImuPackageData$1) == false) goto L7;
        DoraNetworkApi$uploadImuPackageData$1 r5 = (DoraNetworkApi$uploadImuPackageData$1) r20;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$uploadImuPackageData$1 r12 = r5;
        Object r0 = r12.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r12.label;
        if (r8 == 0) goto L15;
        if (r8 != 1) goto L14;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L42
    L19:
        com.larus.network.http.y r1 = (com.larus.network.http.a) r0;     // Catch: Throwable -> L42
        if ((r1 instanceof com.larus.network.http.y) == false) goto L28;
        Long r4 = r1.g;     // Catch: Throwable -> L42
        if (r4 == null) goto L28;
        if (r4.longValue() != 0) goto L28;
        g49.d.d("DoraNetworkApi", "uploadImuPackageData success");     // Catch: Throwable -> L42
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L42
        return Result.constructor-impl(Boxing.boxBoolean(true));
    L28:
        if ((r1 instanceof com.larus.network.http.f) == false) goto L31;
        String r3 = "call is Fail(" + fm9.a.a(((com.larus.network.http.f) r1).d) + ')';     // Catch: Throwable -> L42
    L39:
        g49.d.b("DoraNetworkApi", "uploadImuPackageData failed: " + r3);     // Catch: Throwable -> L42
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L42
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("uploadImuPackageData failed: " + r3)));
    L31:
        if ((r1 instanceof com.larus.network.http.w) == false) goto L34;
        r3 = "call is Loading";
        goto L39
    L34:
        if ((r1 instanceof com.larus.network.http.y) == false) goto L37;
        r3 = "call is Success(" + r1.g + ", " + r1.f + ')';     // Catch: Throwable -> L42
        goto L39
    L37:
        if (Intrinsics.areEqual(r1, com.larus.network.http.z.d) == false) goto L41;
        r3 = "call is Uninitialized";
        goto L39
    L41:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L42
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r0);
        g49.d.d("DoraNetworkApi", "uploadImuPackageData: data count=" + r110.length());     // Catch: Throwable -> L42
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L42
        r10.put("w_did", r17);     // Catch: Throwable -> L42
        r10.put("product_id", r18);     // Catch: Throwable -> L42
        r10.put("data", r110);     // Catch: Throwable -> L42
        com.larus.dora.api.network.a r11 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L42
        r12.label = 1;     // Catch: Throwable -> L42
        r0 = com.larus.dora.api.network.a.c(r11, Object.class, "https://api-normal.doubao.com/alice/w/sensor/data_sync/batch", r10, null, r12, 248);     // Catch: Throwable -> L42
        if (r0 != r7) goto L19;
        return r7;
    L42:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "uploadImuPackageData exception", th);
        Result.Companion r13 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r5 = new DoraNetworkApi$uploadImuPackageData$1(this, r20);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final Object k(String r26, String r27, List<String> r28, Continuation<? super Result<a49.h>> r210) {
        if ((r210 instanceof DoraNetworkApi$fetchLatestCardContent$1) == false) goto L7;
        DoraNetworkApi$fetchLatestCardContent$1 r8 = (DoraNetworkApi$fetchLatestCardContent$1) r210;
        int r9 = r8.label;
        if ((r9 & Integer.MIN_VALUE) == 0) goto L7;
        r8.label = r9 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$fetchLatestCardContent$1 r14 = r8;
        Object r0 = r14.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r14.label;
        ?? r15 = "DoraNetworkApi";
        if (r11 == 0) goto L15;
        if (r11 != 1) goto L14;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L49
        Object r12 = r0;
        ?? r2 = "DoraNetworkApi";
        r15 = r15;
    L21:
        com.larus.network.http.y r13 = (com.larus.network.http.a) r12;     // Catch: Throwable -> L47
        g49.d.d(r2, "fetchLatestCardContent call is " + D(r13));     // Catch: Throwable -> L47
        if ((r13 instanceof com.larus.network.http.y) == false) goto L33;
        Long r7 = r13.g;     // Catch: Throwable -> L47
        if (r7 == null) goto L33;
        if (r7.longValue() != 0) goto L33;
        a49.h r1 = (a49.h) ((com.larus.network.http.a) r13).b;     // Catch: Throwable -> L47
        g49.d.d(r2, "fetchLatestCardContent response=" + E(r1));     // Catch: Throwable -> L47
        if (r1 != null) goto L56;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L47
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("fetchLatestCardContent: data is null " + D(r13))));
    L56:
        return Result.constructor-impl(r1);
    L33:
        if ((r13 instanceof com.larus.network.http.f) == false) goto L36;
        String r4 = "call is Fail(" + fm9.a.a(((com.larus.network.http.f) r13).d) + ')';     // Catch: Throwable -> L47
    L44:
        g49.d.b(r2, "fetchLatestCardContent: failed, " + r4 + ", call = " + D(r13));     // Catch: Throwable -> L47
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L47
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("fetchLatestCardContent: call is failed " + D(r13))));
    L36:
        if ((r13 instanceof com.larus.network.http.w) == false) goto L39;
        r4 = "call is Loading";
        goto L44
    L39:
        if ((r13 instanceof com.larus.network.http.y) == false) goto L42;
        r4 = "call is Success(" + r13.g + ", " + r13.f + ')';     // Catch: Throwable -> L47
        goto L44
    L42:
        if (Intrinsics.areEqual(r13, com.larus.network.http.z.d) == false) goto L46;
        r4 = "call is Uninitialized";
        goto L44
    L46:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L47
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r0);
        HashMap r16 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("w_did", r26), TuplesKt.to("product_id", r27), TuplesKt.to("card_keys", CollectionsKt.joinToString$default(r28, ",", null, null, 0, null, null, 62, null))});     // Catch: Throwable -> L49
        r14.label = 1;     // Catch: Throwable -> L49
        ?? r6 = "DoraNetworkApi";
        r15 = 240(0xf0, float:3.36E-43);
        r12 = HttpExtKt.h("DORA", a49.h.class, "https://api-normal.doubao.com/alice/w/user/latest_card_content", r16, r14, BaiduNaviStatus.NO_PERMISSION);     // Catch: Throwable -> L47
        r2 = r6;
        if (r12 != r10) goto L21;
        return r10;
    L47:
        th = th;
    L51:
        g49.d.c(r6, "fetchLatestCardContent exception:", th);
        Result.Companion r17 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L49:
        th = th;
        r6 = r15;
    L7:
        r8 = new DoraNetworkApi$fetchLatestCardContent$1(this, r210);
        goto L8
    }

    public final Object c(String r110, String r20, String r21, String r22, Continuation<? super Result<Boolean>> r23) {
        String r0 = r110;
        String r1 = r20;
        if ((r23 instanceof DoraNetworkApi$atomicFuncCallback$1) == false) goto L7;
        DoraNetworkApi$atomicFuncCallback$1 r7 = (DoraNetworkApi$atomicFuncCallback$1) r23;
        int r8 = r7.label;
        if ((r8 & Integer.MIN_VALUE) == 0) goto L7;
        r7.label = r8 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$atomicFuncCallback$1 r14 = r7;
        Object r2 = r14.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = r14.label;
        if (r10 == 0) goto L16;
        if (r10 != 1) goto L15;
        String r3 = (String) r14.L$1;
        String r4 = (String) r14.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L68
        Object r11 = r2;
        String r12 = "DoraNetworkApi";
        boolean r5 = true;
        r1 = r3;
        r0 = r4;
    L39:
        com.larus.network.http.y r13 = (com.larus.network.http.a) r11;     // Catch: Throwable -> L66
        StringBuilder r15 = new StringBuilder("atomicFuncCallback call is ");     // Catch: Throwable -> L66
        r15.append(r13);     // Catch: Throwable -> L66
        r15.append(", productId=");     // Catch: Throwable -> L66
        r15.append(r0);     // Catch: Throwable -> L66
        r15.append(", hasWDid=");     // Catch: Throwable -> L66
        if (r1.length() <= 0) goto L42;
        boolean r6 = true;
    L43:
        r15.append(r6);     // Catch: Throwable -> L66
        g49.d.d(r12, r15.toString());     // Catch: Throwable -> L66
        if ((r13 instanceof com.larus.network.http.y) == false) goto L52;
        Long r16 = r13.g;     // Catch: Throwable -> L66
        if (r16 == null) goto L52;
        if (r16.longValue() != 0) goto L52;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L66
        return Result.constructor-impl(Boxing.boxBoolean(r5));
    L52:
        if ((r13 instanceof com.larus.network.http.f) == false) goto L55;
        String r18 = "call is Fail(" + fm9.a.a(((com.larus.network.http.f) r13).d) + ')';     // Catch: Throwable -> L66
    L63:
        g49.d.b(r12, "atomicFuncCallback failed: " + r18);     // Catch: Throwable -> L66
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L66
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("atomicFuncCallback failed: " + r18)));
    L55:
        if ((r13 instanceof com.larus.network.http.w) == false) goto L58;
        r18 = "call is Loading";
        goto L63
    L58:
        if ((r13 instanceof com.larus.network.http.y) == false) goto L61;
        r18 = "call is Success(" + r13.g + ", " + r13.f + ')';     // Catch: Throwable -> L66
        goto L63
    L61:
        if (Intrinsics.areEqual(r13, com.larus.network.http.z.d) == false) goto L65;
        r18 = "call is Uninitialized";
        goto L63
    L65:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L66
    L42:
        r6 = false;
        goto L43
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r2);
        if (p(r110) == true) goto L19;
        String r111 = UriProtector.parse("https://api-normal.doubao.com/alice/w/atomic_function/callback").buildUpon().appendQueryParameter("product_id", r0).appendQueryParameter("w_did", r1).build().toString();     // Catch: Throwable -> L68
        if (r22 != null) goto L23;
    L33:
        Map r25 = MapsKt.emptyMap();     // Catch: Throwable -> L68
    L34:
        com.larus.dora.api.network.a r26 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L68
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L68
        r112.put("body_etp_base64", r21);     // Catch: Throwable -> L68
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L68
        r14.L$0 = r0;     // Catch: Throwable -> L68
        r14.L$1 = r1;     // Catch: Throwable -> L68
        r14.label = 1;     // Catch: Throwable -> L68
        r12 = "DoraNetworkApi";
        Map r113 = r25;
        r5 = true;
        r11 = com.larus.dora.api.network.a.c(r26, Object.class, r111, r112, r113, r14, 232);     // Catch: Throwable -> L66
        if (r11 != r9) goto L39;
        return r9;
    L66:
        th = th;
    L70:
        g49.d.c(r12, "atomicFuncCallback exception", th);
        Result.Companion r28 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L23:
        if (r22.length() <= 0) goto L25;
        boolean r30 = true;
    L26:
        if (r30 == false) goto L28;
        String r31 = r22;
    L29:
        if (r31 == null) goto L33;
        r25 = MapsKt.mapOf(TuplesKt.to("X-Tt-Env", r31));     // Catch: Throwable -> L68
        if (r25 == null) goto L33;
    L28:
        r31 = null;
        goto L29
    L25:
        r30 = false;
        goto L26
    L19:
        return n("atomicFuncCallback", r0);
    L68:
        th = th;
        r12 = "DoraNetworkApi";
    L7:
        r7 = new DoraNetworkApi$atomicFuncCallback$1(this, r23);
        goto L8
    }

    public final Object H(String r15, Object r16, String r17, JSONObject r18, JSONObject r110, Continuation<? super Result<Boolean>> r20) {
        if ((r20 instanceof DoraNetworkApi$updateUserSettings$1) == false) goto L7;
        DoraNetworkApi$updateUserSettings$1 r3 = (DoraNetworkApi$updateUserSettings$1) r20;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        DoraNetworkApi$updateUserSettings$1 r10 = r3;
        Object r2 = r10.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r10.label;
        boolean r12 = true;
        if (r6 == 0) goto L16;
        if (r6 != 1) goto L15;
        JSONObject r0 = (JSONObject) r10.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L47
    L35:
        com.larus.network.http.y r7 = (com.larus.network.http.a) r2;     // Catch: Throwable -> L47
        g49.d.d("DoraNetworkApi", "updateUserSettings bodyJson is " + r0 + ", call is " + r7);     // Catch: Throwable -> L47
        if ((r7 instanceof com.larus.network.http.y) == false) goto L45;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L47
        Long r8 = r7.g;     // Catch: Throwable -> L47
        if (r8 != null) goto L41;
    L43:
        r12 = false;
    L52:
        return Result.constructor-impl(Boxing.boxBoolean(r12));
    L41:
        if (r8.longValue() != 0) goto L43;
    L45:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L47
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("updateUserSettings: call is failed " + r7)));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r2);
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L47
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L47
        r13.put(r15, r16);     // Catch: Throwable -> L47
        if (o0.d(r17) == false) goto L21;
        if (r18 == null) goto L21;
        r13.put(r17, r18);     // Catch: Throwable -> L47
    L21:
        r11.put("user_settings", r13);     // Catch: Throwable -> L47
        if (r110 == null) goto L27;
        Iterator<String> r14 = r110.keys();     // Catch: Throwable -> L47
    L25:
        if (r14.hasNext() == false) goto L27;
        String r21 = r14.next();     // Catch: Throwable -> L47
        r11.put(r21, r110.get(r21));     // Catch: Throwable -> L47
    L27:
        String r22 = m(r11);     // Catch: Throwable -> L47
        if (r22 != null) goto L30;
        com.larus.dora.api.network.a r23 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L47
        r10.L$0 = r11;     // Catch: Throwable -> L47
        r10.label = 1;     // Catch: Throwable -> L47
        Object r24 = com.larus.dora.api.network.a.c(r23, String.class, "https://api-normal.doubao.com/alice/device/update_user_settings", r11, null, r10, 248);     // Catch: Throwable -> L47
        if (r24 != r5) goto L34;
        return r5;
    L34:
        r2 = r24;
        r0 = r11;
        goto L35
    L30:
        return n("updateUserSettings", r22);
    L47:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r3 = new DoraNetworkApi$updateUserSettings$1(this, r20);
        goto L8
    }

    public final Object L(String r110, String r20, String r21, String r22, long r23, long r25, Continuation<? super Result<Boolean>> r27) {
        if ((r27 instanceof DoraNetworkApi$uploadImuRealTimeData$1) == false) goto L7;
        DoraNetworkApi$uploadImuRealTimeData$1 r11 = (DoraNetworkApi$uploadImuRealTimeData$1) r27;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r6 = r11.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r11.label;
        if (r14 == 0) goto L15;
        if (r14 != 1) goto L14;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L42
    L19:
        com.larus.network.http.y r7 = (com.larus.network.http.a) r6;     // Catch: Throwable -> L42
        if ((r7 instanceof com.larus.network.http.y) == false) goto L28;
        Long r0 = r7.g;     // Catch: Throwable -> L42
        if (r0 == null) goto L28;
        if (r0.longValue() != 0) goto L28;
        g49.d.d("DoraNetworkApi", "uploadImuRealTimeData success");     // Catch: Throwable -> L42
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L42
        return Result.constructor-impl(Boxing.boxBoolean(true));
    L28:
        if ((r7 instanceof com.larus.network.http.f) == false) goto L31;
        String r2 = "call is Fail(" + fm9.a.a(((com.larus.network.http.f) r7).d) + ')';     // Catch: Throwable -> L42
    L39:
        g49.d.b("DoraNetworkApi", "uploadImuRealTimeData failed: " + r2);     // Catch: Throwable -> L42
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L42
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("uploadImuRealTimeData failed: " + r2)));
    L31:
        if ((r7 instanceof com.larus.network.http.w) == false) goto L34;
        r2 = "call is Loading";
        goto L39
    L34:
        if ((r7 instanceof com.larus.network.http.y) == false) goto L37;
        r2 = "call is Success(" + r7.g + ", " + r7.f + ')';     // Catch: Throwable -> L42
        goto L39
    L37:
        if (Intrinsics.areEqual(r7, com.larus.network.http.z.d) == false) goto L41;
        r2 = "call is Uninitialized";
        goto L39
    L41:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L42
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r6);
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L42
        r8.put("w_did", r110);     // Catch: Throwable -> L42
        r8.put("product_id", r20);     // Catch: Throwable -> L42
        JSONArray r15 = new JSONArray();     // Catch: Throwable -> L42
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L42
        r9.put("key", r21);     // Catch: Throwable -> L42
        r9.put("value", r22);     // Catch: Throwable -> L42
        r9.put("timestamp", r23);     // Catch: Throwable -> L42
        r9.put("primary_timestamp", r25);     // Catch: Throwable -> L42
        r15.put(r9);     // Catch: Throwable -> L42
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L42
        r8.put("data", r15);     // Catch: Throwable -> L42
        g49.d.d("DoraNetworkApi", "uploadImuRealTimeData: key=" + r21 + ", value=" + r22 + ", timestamp=" + r23 + ", primaryTimestamp=" + r25);     // Catch: Throwable -> L42
        com.larus.dora.api.network.a r4 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L42
        r11.label = 1;     // Catch: Throwable -> L42
        r6 = com.larus.dora.api.network.a.c(r4, Object.class, "https://api-normal.doubao.com/alice/w/sensor/data_sync/real_time", r8, null, r11, 248);     // Catch: Throwable -> L42
        if (r6 != r13) goto L19;
        return r13;
    L42:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "uploadImuRealTimeData exception", th);
        Result.Companion r5 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r11 = new DoraNetworkApi$uploadImuRealTimeData$1(this, r27);
        goto L8
    }

    public final Object b(String r24, String r25, String r26, int r27, JSONArray r28, String r210, Continuation<? super Result<Boolean>> r30) {
        String r0 = r24;
        if ((r30 instanceof DoraNetworkApi$atomicFuncCallback$2) == false) goto L7;
        DoraNetworkApi$atomicFuncCallback$2 r10 = (DoraNetworkApi$atomicFuncCallback$2) r30;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r4 = r10.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r10.label;
        if (r12 == 0) goto L16;
        if (r12 != 1) goto L15;
        int r1 = r10.I$0;
        JSONArray r2 = (JSONArray) r10.L$2;
        String r3 = (String) r10.L$1;
        String r5 = (String) r10.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L73
        Object r13 = r4;
        boolean r21 = true;
        JSONArray r6 = r2;
        String r7 = "DoraNetworkApi";
        int r8 = r1;
        r0 = r5;
    L42:
        com.larus.network.http.y r14 = (com.larus.network.http.a) r13;     // Catch: Throwable -> L69
        StringBuilder r16 = new StringBuilder("atomicFuncCallback app result: code=");     // Catch: Throwable -> L69
        r16.append(r8);     // Catch: Throwable -> L69
        r16.append(", productId=");     // Catch: Throwable -> L69
        r16.append(r0);     // Catch: Throwable -> L69
        r16.append(", hasWDid=");     // Catch: Throwable -> L69
        if (r3.length() <= 0) goto L45;
        boolean r9 = true;
    L46:
        r16.append(r9);     // Catch: Throwable -> L69
        r16.append(", responseCount=");     // Catch: Throwable -> L69
        r16.append(r6.length());     // Catch: Throwable -> L69
        g49.d.a(r7, r16.toString());     // Catch: Throwable -> L69
        if ((r14 instanceof com.larus.network.http.y) == false) goto L55;
        Long r17 = r14.g;     // Catch: Throwable -> L69
        if (r17 == null) goto L55;
        if (r17.longValue() != 0) goto L55;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L69
        return Result.constructor-impl(Boxing.boxBoolean(r21));
    L55:
        if ((r14 instanceof com.larus.network.http.f) == false) goto L58;
        String r20 = "call is Fail(" + ((com.larus.network.http.f) r14).d + ')';     // Catch: Throwable -> L69
    L66:
        g49.d.b(r7, "atomicFuncCallback app result failed: " + r20);     // Catch: Throwable -> L69
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L69
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("atomicFuncCallback failed: " + r20)));
    L58:
        if ((r14 instanceof com.larus.network.http.w) == false) goto L61;
        r20 = "call is Loading";
        goto L66
    L61:
        if ((r14 instanceof com.larus.network.http.y) == false) goto L64;
        r20 = "call is Success(" + r14.g + ", " + r14.f + ')';     // Catch: Throwable -> L69
        goto L66
    L64:
        if (Intrinsics.areEqual(r14, com.larus.network.http.z.d) == false) goto L68;
        r20 = "call is Uninitialized";
        goto L66
    L68:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L69
    L45:
        r9 = false;
        goto L46
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r4);
        if (p(r24) == true) goto L19;
        String r23 = UriProtector.parse("https://api-normal.doubao.com/alice/w/atomic_function/callback").buildUpon().appendQueryParameter("product_id", r0).appendQueryParameter("w_did", r25).build().toString();     // Catch: Throwable -> L73
        if (r210 != null) goto L23;
    L33:
        Map r110 = MapsKt.emptyMap();     // Catch: Throwable -> L73
    L34:
        Map r111 = r110;
        com.larus.dora.api.network.a r112 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L73
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L73
        r113.put("req_id", r26);     // Catch: Throwable -> L71
        r113.put("code", r27);     // Catch: Throwable -> L71
        r113.put("body_etp_base64", "");     // Catch: Throwable -> L71
        r113.put("json_rpc_resps", r28);     // Catch: Throwable -> L71
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L71
        r10.L$0 = r0;     // Catch: Throwable -> L71
        r10.L$1 = r25;     // Catch: Throwable -> L71
        r10.L$2 = r28;     // Catch: Throwable -> L71
        r10.I$0 = r27;     // Catch: Throwable -> L71
        r10.label = 1;     // Catch: Throwable -> L71
        r7 = "DoraNetworkApi";
        r21 = true;
        r13 = com.larus.dora.api.network.a.c(r112, Object.class, r23, r113, r111, r10, 232);     // Catch: Throwable -> L69
        if (r13 != r15) goto L41;
        return r15;
    L41:
        r6 = r28;
        r8 = r27;
        r3 = r25;
    L69:
        th = th;
    L75:
        g49.d.c(r7, "atomicFuncCallback app result exception", th);
        Result.Companion r31 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L71:
        th = th;
        r7 = "DoraNetworkApi";
        goto L75
    L23:
        if (r210.length() <= 0) goto L25;
        boolean r115 = true;
    L26:
        if (r115 == false) goto L28;
        String r116 = r210;
    L29:
        if (r116 == null) goto L33;
        r110 = MapsKt.mapOf(TuplesKt.to("X-Tt-Env", r116));     // Catch: Throwable -> L73
        if (r110 == null) goto L33;
    L28:
        r116 = null;
        goto L29
    L25:
        r115 = false;
        goto L26
    L19:
        return n("atomicFuncCallback", r0);
    L73:
        th = th;
        r7 = "DoraNetworkApi";
    L7:
        r10 = new DoraNetworkApi$atomicFuncCallback$2(this, r30);
        goto L8
    }

    public final Object f(String r16, String r17, String r18, Long r110, int r20, int r21, int r22, Continuation<? super Result<Boolean>> r23) {
        String r0 = r16;
        if ((r23 instanceof DoraNetworkApi$checkGuideModalShow$1) == false) goto L7;
        DoraNetworkApi$checkGuideModalShow$1 r5 = (DoraNetworkApi$checkGuideModalShow$1) r23;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r2 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        boolean r9 = false;
        if (r8 == 0) goto L16;
        if (r8 != 1) goto L15;
        HashMap r1 = (HashMap) r5.L$1;
        String r3 = (String) r5.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L44
        HashMap r4 = r1;
        r0 = r3;
    L29:
        com.larus.network.http.y r10 = (com.larus.network.http.a) r2;     // Catch: Throwable -> L44
        g49.d.d("DoraNetworkApi", "checkGuideModelShow guideName=" + r0 + " call is " + r10 + ", query=" + r4);     // Catch: Throwable -> L44
        if ((r10 instanceof com.larus.network.http.y) == false) goto L42;
        Long r11 = r10.g;     // Catch: Throwable -> L44
        if (r11 == null) goto L42;
        if (r11.longValue() != 0) goto L42;
        q r12 = (q) ((com.larus.network.http.a) r10).b;     // Catch: Throwable -> L44
        if (r12 == null) goto L41;
        Boolean r13 = r12.a();     // Catch: Throwable -> L44
        if (r13 == null) goto L41;
        r9 = r13.booleanValue();     // Catch: Throwable -> L44
    L41:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L44
        return Result.constructor-impl(Boxing.boxBoolean(r9));
    L42:
        g49.d.b("DoraNetworkApi", "checkGuideModelShow: call is failed " + r10);     // Catch: Throwable -> L44
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L44
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("checkGuideModelShow: call is failed " + r10)));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r2);
        if (p(r18) == false) goto L21;
        return n("checkGuideModalShow", r18);
    L21:
        r4 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("w_did", r17), TuplesKt.to("product_id", r18)});     // Catch: Throwable -> L44
        if (r110 == null) goto L25;
        String r24 = r110.toString();     // Catch: Throwable -> L44
        if (r24 == null) goto L25;
    L26:
        r4.put("last_show_time", r24);     // Catch: Throwable -> L44
        r4.put("show_times", String.valueOf(r20));     // Catch: Throwable -> L44
        r4.put("close_times", String.valueOf(r21));     // Catch: Throwable -> L44
        r4.put("click_times", String.valueOf(r22));     // Catch: Throwable -> L44
        StringCompanionObject r25 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L44
        String r26 = String.format("https://api-normal.doubao.com/alice/w/feature/%s/show", Arrays.copyOf(new Object[]{r0}, 1));     // Catch: Throwable -> L44
        r5.L$0 = r0;     // Catch: Throwable -> L44
        r5.L$1 = r4;     // Catch: Throwable -> L44
        r5.label = 1;     // Catch: Throwable -> L44
        r2 = HttpExtKt.h("DORA", q.class, r26, r4, r5, BaiduNaviStatus.NO_PERMISSION);     // Catch: Throwable -> L44
        if (r2 != r7) goto L29;
        return r7;
    L25:
        r24 = "0";
    L44:
        th = move-exception;
        g49.d.c("DoraNetworkApi", "checkGuideModelShow exception", th);
        Result.Companion r27 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r5 = new DoraNetworkApi$checkGuideModalShow$1(this, r23);
        goto L8
    }
}
