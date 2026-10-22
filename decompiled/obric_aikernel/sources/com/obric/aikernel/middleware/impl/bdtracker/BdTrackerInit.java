package com.obric.aikernel.middleware.impl.bdtracker;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.applog.n;
import com.bytedance.applog.o;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.ILogger;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.ISstInfoProvider;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.InstallUrl;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.IAppConfig;
import com.obric.aikernel.middleware.api.bdtracker.IBdTrackerInit;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.network.NetworkAllowState;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class BdTrackerInit implements IBdTrackerInit {
    public static final a Companion = null;
    public static final String TAG = "BdTrackerInitTask";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b implements ILogger {
        b() {
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void d(String r10, Throwable r11) {
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void e(String r10, Throwable r11) {
            AIKLog r12 = AIKLog.INSTANCE;
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            r12.e("BDInstall", r10);
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void i(String r10, Throwable r11) {
            AIKLog r12 = AIKLog.INSTANCE;
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            r12.i("BDInstall", r10);
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void v(String r10, Throwable r11) {
            AIKLog r12 = AIKLog.INSTANCE;
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            r12.v("BDInstall", r10);
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void w(String r10, Throwable r11) {
            AIKLog r12 = AIKLog.INSTANCE;
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            r12.w("BDInstall", r10);
        }
    }

    public static final class c extends DefaultSensitiveInterceptor {
        c() {
        }

        @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
        public String getImeiByIndex(int r10) {
            return null;
        }

        @Override // com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor, com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
        public String getMacAddress(WifiInfo r10) {
            return null;
        }
    }

    public static final class d implements INetworkClient {
        d() {
        }

        @Override // com.bytedance.bdinstall.INetworkClient
        public String get(String r10, Map<String, String> r11) {
            if (NetworkAllowState.INSTANCE.isAllowNetworkRequestNow() == true) goto L15;
            return "";
        L15:
            String r12 = com.bytedance.common.utility.e.b().a(r10, r11, null);     // Catch: Exception -> L8
            Intrinsics.checkNotNullExpressionValue(r12, "{\n                    mC…, null]\n                }");     // Catch: Exception -> L8
            return r12;
        L8:
            e = move-exception;
            if ((e instanceof CommonHttpException) == false) goto L14;
            throw new RangersHttpException(((CommonHttpException) e).getResponseCode(), e.getCause());
        L14:
            throw new RangersHttpException(400, e.getCause());
        }

        @Override // com.bytedance.bdinstall.INetworkClient
        public String post(String r10, List<Pair<String, String>> r11) {
            if (NetworkAllowState.INSTANCE.isAllowNetworkRequestNow() == true) goto L6;
            return "";
        L6:
            String r12 = com.bytedance.common.utility.e.b().c(r10, r11);
            Intrinsics.checkNotNullExpressionValue(r12, "mClient.post(url, params)");
            return r12;
        }

        @Override // com.bytedance.bdinstall.INetworkClient
        public String post(String r10, byte[] r11, String r12) {
            if (NetworkAllowState.INSTANCE.isAllowNetworkRequestNow() == true) goto L6;
            return "";
        L6:
            HashMap r13 = new HashMap();
            if (TextUtils.isEmpty(r12) == true) goto L14;
            r13.put(NetConst.KEY_CONTENT_TYPE, r12);
        L14:
            String r14 = com.bytedance.common.utility.e.b().e(r10, r11, r13, null);     // Catch: CommonHttpException -> L11
            Intrinsics.checkNotNullExpressionValue(r14, "{\n                    mC…, null)\n                }");     // Catch: CommonHttpException -> L11
            return r14;
        L11:
            e = move-exception;
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        }

        @Override // com.bytedance.bdinstall.INetworkClient
        public String post(String r10, byte[] r11, Map<String, String> r12) {
            if (NetworkAllowState.INSTANCE.isAllowNetworkRequestNow() == true) goto L11;
            return "";
        L11:
            String r13 = com.bytedance.common.utility.e.b().e(r10, r11, r12, null);     // Catch: CommonHttpException -> L8
            Intrinsics.checkNotNullExpressionValue(r13, "{\n                    mC…, null)\n                }");     // Catch: CommonHttpException -> L8
            return r13;
        L8:
            e = move-exception;
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        }

        @Override // com.bytedance.bdinstall.INetworkClient
        public byte[] postStream(String r10, byte[] r11, Map<String, String> r12) {
            byte[] r13 = com.bytedance.common.utility.e.b().f(r10, r11, r12, null);     // Catch: CommonHttpException -> L4
            Intrinsics.checkNotNullExpressionValue(r13, "{\n                    mC…, null)\n                }");     // Catch: CommonHttpException -> L4
            return r13;
        L4:
            e = move-exception;
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        }
    }

    public static final class e implements ILogger {
        e() {
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void d(String r10, Throwable r11) {
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void e(String r10, Throwable r11) {
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void i(String r10, Throwable r11) {
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void v(String r10, Throwable r11) {
        }

        @Override // com.bytedance.bdinstall.ILogger
        public void w(String r10, Throwable r11) {
        }
    }

    public static final class f implements ISstInfoProvider {
        f() {
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getDefaultImeiOrMeid(Context r10, InstallOptions r11) {
            return "";
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public JSONArray getIPV6Address(Context r18) {
            String r10 = "dummy0";
            JSONArray r11 = new JSONArray();
        L61:
            e = move-exception;
            e.printStackTrace();
        L63:
            return r11;
        L4:
            if (NetworkInterface.getNetworkInterfaces() == null) goto L6;
            Iterator r12 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Exception -> L61
        L9:
            if (r12.hasNext() == false) goto L63;
            NetworkInterface r13 = (NetworkInterface) r12.next();     // Catch: Exception -> L61
            String r14 = r13.getName();     // Catch: Exception -> L61
            if (Intrinsics.areEqual(r10, r14) == true) goto L16;
            if (Intrinsics.areEqual("wlan0", r14) == false) goto L9;
        L16:
            Iterator r15 = Collections.list(r13.getInetAddresses()).iterator();     // Catch: Exception -> L61
        L18:
            if (r15.hasNext() == false) goto L9;
            String r16 = ((InetAddress) r15.next()).getHostAddress();     // Catch: Exception -> L61
            if (TextUtils.isEmpty(r16) == true) goto L18;
            Intrinsics.checkNotNullExpressionValue(r16, "hostAddress");     // Catch: Exception -> L61
            if (StringsKt.indexOf$default(r16, ':', 0, false, 6, null) >= 0) goto L24;
            boolean r17 = true;
        L25:
            if (r17 == true) goto L18;
            int r19 = StringsKt.indexOf$default(r16, '%', 0, false, 6, null);     // Catch: Exception -> L61
            if (Intrinsics.areEqual(r10, r14) == true) goto L29;
            if (Intrinsics.areEqual("wlan0", r14) == true) goto L53;
            List<String> r110 = new Regex("::").split(r16, 0);     // Catch: Exception -> L61
            if (r110.isEmpty() == true) goto L48;
            ListIterator<String> r111 = r110.listIterator(r110.size());     // Catch: Exception -> L61
        L41:
            if (r111.hasPrevious() == false) goto L48;
            if (r111.previous().length() != 0) goto L45;
            boolean r112 = true;
        L46:
            if (r112 == true) goto L41;
            List r113 = CollectionsKt.take(r110, r111.nextIndex() + 1);     // Catch: Exception -> L61
        L49:
            String r114 = r10;
            if (StringsKt.equals("fe80", ((String[]) r113.toArray(new String[0]))[0], true) == true) goto L54;
        L52:
            r10 = r114;
        L54:
            JSONObject r20 = new JSONObject();     // Catch: Exception -> L61
            r20.put(WsConstants.KEY_CONNECTION_TYPE, SstLoader.KEY_IPV6_TYPE_ANPI);     // Catch: Exception -> L61
            if (r19 >= 0) goto L58;
            Locale r21 = Locale.getDefault();     // Catch: Exception -> L61
            Intrinsics.checkNotNullExpressionValue(r21, "getDefault()");     // Catch: Exception -> L61
            String r22 = r16.toUpperCase(r21);     // Catch: Exception -> L61
        L57:
            Intrinsics.checkNotNullExpressionValue(r22, "this as java.lang.String).toUpperCase(locale)");     // Catch: Exception -> L61
            r20.put(EventBody.KEY_VALUE, r22);     // Catch: Exception -> L61
            r11.put(r20);     // Catch: Exception -> L61
            goto L52
        L58:
            String r23 = r16.substring(0, r19);     // Catch: Exception -> L61
            Intrinsics.checkNotNullExpressionValue(r23, "this as java.lang.String…ing(startIndex, endIndex)");     // Catch: Exception -> L61
            Locale r24 = Locale.getDefault();     // Catch: Exception -> L61
            Intrinsics.checkNotNullExpressionValue(r24, "getDefault()");     // Catch: Exception -> L61
            r22 = r23.toUpperCase(r24);     // Catch: Exception -> L61
            goto L57
        L45:
            r112 = false;
        L48:
            r113 = CollectionsKt.emptyList();     // Catch: Exception -> L61
            goto L49
        L53:
            r114 = r10;
            goto L54
        L29:
            JSONObject r25 = new JSONObject();     // Catch: Exception -> L61
            r25.put(WsConstants.KEY_CONNECTION_TYPE, SstLoader.KEY_IPV6_TYPE_TUN);     // Catch: Exception -> L61
            if (r19 >= 0) goto L33;
            Locale r26 = Locale.getDefault();     // Catch: Exception -> L61
            Intrinsics.checkNotNullExpressionValue(r26, "getDefault()");     // Catch: Exception -> L61
            String r27 = r16.toUpperCase(r26);     // Catch: Exception -> L61
        L32:
            Intrinsics.checkNotNullExpressionValue(r27, "this as java.lang.String).toUpperCase(locale)");     // Catch: Exception -> L61
            r25.put(EventBody.KEY_VALUE, r27);     // Catch: Exception -> L61
            r11.put(r25);     // Catch: Exception -> L61
            goto L18
        L33:
            String r28 = r16.substring(0, r19);     // Catch: Exception -> L61
            Intrinsics.checkNotNullExpressionValue(r28, "this as java.lang.String…ing(startIndex, endIndex)");     // Catch: Exception -> L61
            Locale r29 = Locale.getDefault();     // Catch: Exception -> L61
            Intrinsics.checkNotNullExpressionValue(r29, "getDefault()");     // Catch: Exception -> L61
            r27 = r28.toUpperCase(r29);     // Catch: Exception -> L61
            goto L32
        L24:
            r17 = false;
            goto L25
        L6:
            return new JSONArray();
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getImei(Context r10, int r11, InstallOptions r12) {
            return "";
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getMac(Context r10, InstallOptions r11) {
            return "";
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getMeid(Context r10, int r11, InstallOptions r12) {
            return "";
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String getSerial(Context r10, InstallOptions r11) {
            return "";
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String[] getSimSerialNumbers(Context r10, InstallOptions r11) {
            return new String[0];
        }

        @Override // com.bytedance.bdinstall.ISstInfoProvider
        public String reflectGetDeviceIdWithSlotIndex(Context r10, int r11) {
            return "";
        }
    }

    static {
        Companion = new a(null);
    }

    public BdTrackerInit() {
    }

    @Override // com.obric.aikernel.middleware.api.bdtracker.IBdTrackerInit
    public void init() {
        StringBuilder r10 = new StringBuilder();
        r10.append("bdtracker init ");
        AppContext r11 = AppContext.INSTANCE;
        r10.append(r11.getChannel());
        Log.d("BdTrackerInitTask", r10.toString());
        BDInstall.setLogger(new b());
        n r12 = new n(String.valueOf(r11.getAid()), r11.getChannel());
        r12.b0(new c());
        r12.Z(r11.getAppName());
        r12.h0(new o.b().h(new Env(InstallUrl.createUriByDomain("https://log-klink.zijieapi.com"), false, false)).j(new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}).i(new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"}).k("https://log.zijieapi.com/service/2/log_settings/").g());
        r12.d0(new d());
        r12.a0(true);
        r12.c0(new e());
        if (Intrinsics.areEqual(r11.getAIKBizType(), IAppConfig.f4504a.b()) == false) goto L5;
        r12.f0(new f());
    L5:
        com.bytedance.applog.a.o(true ^ r11.isAdminMode());
        com.bytedance.applog.a.a(new AnonymousClass6());
        com.bytedance.applog.a.i(r11.getApplication(), r12);
        com.bytedance.applog.a.k("com.obric.aikernel.AIKernelActivity", r11.getContext().hashCode());
        com.bytedance.applog.a.m(r11.getContext());
    }
}
