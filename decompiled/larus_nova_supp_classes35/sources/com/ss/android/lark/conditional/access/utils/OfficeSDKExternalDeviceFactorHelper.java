package com.ss.android.lark.conditional.access.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.alibaba.fastjson.JSON;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.display.DisplayUtilsKt;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import e0c.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class OfficeSDKExternalDeviceFactorHelper {
    public static final List<String> a = null;
    public static final List<String> b = null;
    public static final List<String> c = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/conditional/access/utils/OfficeSDKExternalDeviceFactorHelper$OpenResult;", BuildConfig.FLAVOR, "handledByOfficeSDK", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;IZ)V", "getHandledByOfficeSDK", "()Z", "NOT_HANDLED", "LAUNCHED", "FAILED", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum OpenResult extends Enum<OpenResult> {
        public static final OpenResult FAILED = null;
        public static final OpenResult LAUNCHED = null;
        public static final OpenResult NOT_HANDLED = null;
        public static final /* synthetic */ OpenResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final boolean handledByOfficeSDK;

        public static EnumEntries<OpenResult> getEntries() {
            return b;
        }

        static {
            OpenResult r0 = new OpenResult("NOT_HANDLED", 0, false);
            NOT_HANDLED = r0;
            OpenResult r1 = new OpenResult("LAUNCHED", 1, true);
            LAUNCHED = r1;
            OpenResult r3 = new OpenResult("FAILED", 2, true);
            FAILED = r3;
            OpenResult[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static OpenResult[] values() {
            return (OpenResult[]) a.clone();
        }

        public final boolean getHandledByOfficeSDK() {
            return this.handledByOfficeSDK;
        }

        public static OpenResult valueOf(String r1) {
            return (OpenResult) r27.a.a(OpenResult.class, r1);
        }

        public OpenResult(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.handledByOfficeSDK = r3;
        }
    }

    public static final class a {
        public final String a;
        public final int b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "DeviceAuthInfo(nonce=" + this.a + ", challengeType=" + this.b + ", needCertVerify=" + this.c + ')';
        }

        public a(String r2, int r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_NONCE);
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public OfficeSDKExternalDeviceFactorHelper() {
    }

    static {
        a = CollectionsKt.listOf(new String[]{"com.ss.android.lark.debug", "com.ss.android.lark", "com.larksuite.suite.debug", "com.larksuite.suite"});
        b = CollectionsKt.listOf(new String[]{"com.ss.android.lark", "com.larksuite.suite"});
        c = CollectionsKt.listOf(new String[]{"applink.feishu.cn", "applink.larksuite.com"});
    }

    public static Intent a(Context r2, String r3) {
        Intent r0 = new Intent("android.intent.action.VIEW", UriProtector.parse(r3));
        if ((r2 instanceof Activity) == true) goto L5;
        r0.addFlags(268435456);
    L5:
        return r0;
    }

    public static boolean d(Context r2, Intent r3, String r4) {
        r2.startActivity(r3);     // Catch: Exception -> L5 ActivityNotFoundException -> L7
        return true;
    L7:
        e = move-exception;
        int r5 = ScsLogger.a;
        ScsLogger.e("SecurityPolicy_OfficeSDKExternalDeviceFactorHelper", "launchFeishuAppLink failed, scene: " + r4 + ", no activity found: " + e.getMessage());
    L9:
        return false;
    L5:
        e = move-exception;
        int r6 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_OfficeSDKExternalDeviceFactorHelper", "launchFeishuAppLink failed, scene: " + r4 + ", error: " + e.getMessage());
        goto L9
    }

    public static /* synthetic */ boolean c(Context r6, String r7, InternalSecurityAction r8, String r9, Function0 r10) {
        return b(r6, r7, r8, r9, r7, r10);
    }

    public static boolean b(Context r18, String r19, InternalSecurityAction r20, String r21, String r22, Function0 r23) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "handlerType");
        Intrinsics.checkNotNullParameter(r21, "containerType");
        Intrinsics.checkNotNullParameter(r22, "reportHandlerType");
        Intrinsics.checkNotNullParameter(r23, "onLaunched");
        String r17 = BuildConfig.FLAVOR;
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "handlerType");
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L5;
        OpenResult r0 = OpenResult.NOT_HANDLED;
    L180:
        if (r0.getHandledByOfficeSDK() == true) goto L184;
        return false;
    L184:
        if (r0 != OpenResult.LAUNCHED) goto L186;
        r23.invoke();
        return true;
    L186:
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r22, "handlerType");
        Intrinsics.checkNotNullParameter(r21, "containerType");
        int r1 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_OfficeSDKExternalDeviceFactorHelper", "handleOpenFailure, handlerType=" + r22 + ", containerType=" + r21);
        FileAuthMonitor.UpdateTrigger[] r2 = FileAuthMonitor.a;
        FileAuthMonitor.p(r22, r21, "office_sdk_external_device_factor_open_failed");
        UDToast.show(r18, 2131890543);
        return true;
    L5:
        int r9 = r19.hashCode();
        if (r9 == (-2055224702)) goto L22;
        if (r9 == (-1520881346)) goto L17;
        if (r9 == 97165976) goto L13;
    L23:
        int r7 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_OfficeSDKExternalDeviceFactorHelper", "open failed, unsupported handlerType=".concat(r19));
        r0 = OpenResult.FAILED;
        goto L180
    L13:
        if (r19.equals("DeviceApply") == false) goto L23;
        String r3 = "device_ownership";
    L20:
        String r10 = r3;
    L191:
        yzb.b r4 = (yzb.b) k.a(LarkContext.getApplication(), yzb.b.class);     // Catch: Exception -> L32
        String r13 = r4.d();     // Catch: Exception -> L32
        if (r13.length() != 0) goto L28;
        boolean r15 = true;
    L29:
        if (r15 == false) goto L35;
        r13 = r4.c();     // Catch: Exception -> L32
    L35:
        if (r13.length() != 0) goto L37;
        boolean r5 = true;
    L38:
        if (r5 == false) goto L41;
        ScsLogger.c("SecurityPolicy_OfficeSDKExternalDeviceFactorHelper", "buildAppLink failed, current uid is empty");
        List r6 = CollectionsKt.emptyList();
        r17 = r17;
    L122:
        if (r6.isEmpty() == false) goto L124;
        ScsLogger.c("SecurityPolicy_OfficeSDKExternalDeviceFactorHelper", "open failed, buildAppLink failed");
        r0 = OpenResult.FAILED;
        goto L180
    L124:
        List r8 = r6;
        if ((r8 instanceof Collection) == true) goto L127;
    L129:
        Iterator r11 = r8.iterator();
    L131:
        if (r11.hasNext() == false) goto L175;
        String r12 = (String) r11.next();
        Iterator<T> r14 = a.iterator();
    L134:
        if (r14.hasNext() == false) goto L138;
        String r16 = (String) r14.next();
        Intent r110 = a(r18, r12);
        r110.setPackage(r16);
        if (d(r18, r110, "package: " + r16) == false) goto L134;
    L171:
        boolean r111 = true;
    L173:
        if (r111 == false) goto L131;
        boolean r112 = true;
    L176:
        if (r112 == false) goto L178;
        r0 = OpenResult.LAUNCHED;
        goto L180
    L178:
        r0 = OpenResult.FAILED;
        goto L180
    L138:
        Iterator r24 = r18.getPackageManager().queryIntentActivities(a(r18, r12), 0).iterator();
    L140:
        if (r24.hasNext() == false) goto L163;
        Object r25 = r24.next();
        ActivityInfo r113 = ((ResolveInfo) r25).activityInfo;
        if (r113 == null) goto L144;
        String r114 = r113.packageName;
    L145:
        if (r114 != null) goto L147;
        r114 = r17;
    L147:
        List<String> r115 = b;
        if ((r115 instanceof Collection) == true) goto L150;
    L152:
        Iterator<T> r116 = r115.iterator();
    L154:
        if (r116.hasNext() == false) goto L159;
        Iterator r117 = r24;
        Intent r118 = null;
        if (StringsKt.startsWith$default(r114, (String) r116.next(), false, 2, null) == true) goto L157;
        r24 = r117;
        goto L154
    L157:
        boolean r119 = true;
    L160:
        if (r119 == true) goto L164;
        r24 = r117;
    L164:
        ResolveInfo r26 = (ResolveInfo) r25;
        if (r26 == null) goto L167;
        ActivityInfo r27 = r26.activityInfo;
        String r28 = r27.packageName;
        String r29 = r27.name;
        Intent r30 = a(r18, r12);
        r30.setClassName(r28, r29);
    L168:
        if (r30 != null) goto L170;
    L172:
        ScsLogger.c("SecurityPolicy_OfficeSDKExternalDeviceFactorHelper", "launchFeishuAppLink failed, no Feishu AppLink handler");
        r111 = false;
        goto L173
    L170:
        if (d(r18, r30, "package query activity") == false) goto L172;
    L167:
        ScsLogger.c("SecurityPolicy_OfficeSDKExternalDeviceFactorHelper", "resolve feishu appLink package failed");
        r30 = r118;
    L159:
        r117 = r24;
        r118 = null;
        r119 = false;
        goto L160
    L150:
        if (r115.isEmpty() == false) goto L152;
    L144:
        r114 = null;
        goto L145
    L163:
        r118 = null;
        r25 = null;
    L175:
        r112 = false;
        goto L176
    L127:
        if (r8.isEmpty() == false) goto L129;
    L41:
        if (Intrinsics.areEqual(r10, "device_cert_auth") == true) goto L193;
        a r120 = null;
    L69:
        int r31 = v4c.a.a;
        Intrinsics.checkNotNullParameter("applink", "alias");
        String r32 = jcb.b.c().a("applink");
        if (r32 != null) goto L72;
    L81:
        String r33 = null;
    L82:
        if (r33 != null) goto L189;
        String r34 = null;
    L96:
        if (r34 != null) goto L98;
        r34 = r17;
    L98:
        List<String> r35 = c;
        if (r35.contains(r34) == false) goto L101;
        String r36 = r34;
    L103:
        if (r34.length() <= 0) goto L105;
        boolean r121 = true;
    L106:
        if (r121 == false) goto L109;
        if (r36 != null) goto L109;
        int r122 = ScsLogger.a;
        ScsLogger.e("SecurityPolicy_OfficeSDKExternalDeviceFactorHelper", "skip dynamic applink host unsupported by Android manifest: ".concat(r34));
    L109:
        List r37 = CollectionsKt.distinct(CollectionsKt.plus(CollectionsKt.listOfNotNull(r36), r35));
        if (r37.isEmpty() == false) goto L112;
        ScsLogger.c("SecurityPolicy_OfficeSDKExternalDeviceFactorHelper", "buildAppLink failed, applink host is empty");
        r6 = CollectionsKt.emptyList();
        goto L122
    L112:
        List r38 = r37;
        ArrayList r39 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10));
        Iterator r40 = r38.iterator();
    L114:
        if (r40.hasNext() == false) goto L120;
        Uri.Builder r41 = new Uri.Builder().scheme("https").authority((String) r40.next()).path("/client/security/device_external_auth").appendQueryParameter("action_type", r10).appendQueryParameter("uid", r13).appendQueryParameter("source", "doubao");
        if (r120 == null) goto L119;
        r41.appendQueryParameter(Keys.API_RETURN_KEY_NONCE, r120.a).appendQueryParameter("challenge_type", String.valueOf(r120.b)).appendQueryParameter("challenge[deviceCertConfig][needCertVerify]", String.valueOf(r120.c));
    L119:
        r39.add(r41.build().toString());
        r40 = r40;
        goto L114
    L120:
        r6 = r39;
        goto L122
    L105:
        r121 = false;
        goto L106
    L101:
        r36 = null;
        goto L103
    L189:
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L89
        String r43 = StringsKt.trim(r33).toString();     // Catch: Throwable -> L89
        String r44 = UriProtector.parse(r43).getHost();     // Catch: Throwable -> L89
        if (r44 == null) goto L87;
        r43 = r44;
    L87:
        Object r45 = Result.constructor-impl(r43);     // Catch: Throwable -> L89
    L91:
        String r46 = StringsKt.trim(r33).toString();
        if (Result.isFailure-impl(r45) == false) goto L94;
        r45 = r46;
    L94:
        r34 = (String) r45;
    L89:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L91
    L72:
        if (r32.length() != 0) goto L74;
        boolean r123 = true;
    L75:
        if (r123 == true) goto L81;
        if (StringsKt.startsWith$default(r32, "http", false, 2, null) == true) goto L80;
        r32 = "https://".concat(r32);
    L80:
        r33 = r32;
        goto L82
    L74:
        r123 = false;
        goto L75
    L193:
        Map<String, String> r48 = DisplayUtilsKt.a(r20);     // Catch: Exception -> L66
        String r124 = r48.get("challengeType");     // Catch: Exception -> L66
        if (r124 == null) goto L47;
        Integer r125 = StringsKt.toIntOrNull(r124);     // Catch: Exception -> L66
        if (r125 == null) goto L47;
        int r126 = r125.intValue();     // Catch: Exception -> L66
    L48:
        String r127 = r48.get(Keys.API_RETURN_KEY_NONCE);     // Catch: Exception -> L66
        if (r127 != null) goto L51;
        String r128 = r17;
    L52:
        String r49 = r48.get("certInfo");     // Catch: Exception -> L66
        if (r49 != null) goto L56;
        r49 = r17;
    L56:
        if (r49.length() <= 0) goto L58;
        boolean r129 = true;
    L59:
        if (r129 == false) goto L63;
        Boolean r50 = JSON.parseObject(r49).getBoolean("needCertVerify");     // Catch: Exception -> L66
        if (r50 == null) goto L63;
        boolean r51 = r50.booleanValue();     // Catch: Exception -> L66
    L64:
        r120 = new a(r128, r126, r51);     // Catch: Exception -> L66
    L63:
        r51 = false;
        goto L64
    L58:
        r129 = false;
        goto L59
    L51:
        r128 = r127;
    L47:
        r126 = 0;
    L66:
        e = move-exception;
        int r130 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_OfficeSDKExternalDeviceFactorHelper", "parseDeviceAuthInfo error: " + e.getMessage());
        r120 = new a(r17, 0, false);
        goto L69
    L37:
        r5 = false;
        goto L38
    L28:
        r15 = false;
    L32:
        e = move-exception;
        int r131 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_OfficeSDKExternalDeviceFactorHelper", "getCurrentUserId failed: " + e.getMessage());
        r13 = r17;
        goto L35
    L17:
        if (r19.equals("DeviceAuth") == false) goto L23;
        r3 = "device_cert";
        goto L20
    L22:
        if (r19.equals("DeviceCertAuth") == false) goto L23;
        r10 = "device_cert_auth";
        goto L191
    }
}
