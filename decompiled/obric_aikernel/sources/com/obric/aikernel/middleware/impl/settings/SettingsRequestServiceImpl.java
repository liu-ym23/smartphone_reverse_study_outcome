package com.obric.aikernel.middleware.impl.settings;

import com.bytedance.bdinstall.Level;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.network.NetworkAllowState;
import java.util.LinkedHashMap;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingsRequestServiceImpl implements f4.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4588b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f4589c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f4590a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
        f4588b = "SettingsRequest";
        f4589c = "/service/settings/v3/";
    }

    public SettingsRequestServiceImpl() {
        this.f4590a = LazyKt.lazy(new SettingsRequestServiceImpl$request$2(this));
    }

    public static final /* synthetic */ String b(SettingsRequestServiceImpl r10) {
        return r10.c();
    }

    private final String c() {
        return "https://is.snssdk.com";
    }

    private final com.obric.aikernel.model.cloud.common.e d() {
        return (com.obric.aikernel.model.cloud.common.e) this.f4590a.getValue();
    }

    private final f4.c f() {
        String r10 = "";
        f4.c r11 = new f4.c();
        AppContext r12 = AppContext.INSTANCE;
        boolean r13 = false;
        if (NetworkUtils.g(r12.getContext()) == true) goto L5;
    L7:
        boolean r14 = false;
    L8:
        if (r14 == true) goto L34;
        return r11;
    L34:
        LinkedHashMap r15 = new LinkedHashMap();     // Catch: Exception -> L14
        com.bytedance.applog.a.n(r12.getContext(), r15, true, Level.L1);     // Catch: Exception -> L14
        String r16 = com.obric.aikernel.model.cloud.common.e.a.a(d(), f4589c, r15, null, 4, null).b();     // Catch: Exception -> L14
        if (r16 == null) goto L17;
        r10 = r16;
    L17:
        if (AppContext.INSTANCE.isAdminMode() == false) goto L20;
        AIKLog.INSTANCE.d(f4588b, "settings:  " + r10);
    L20:
        if (r10.length() != 0) goto L22;
        r13 = true;
    L22:
        if (r13 == false) goto L24;
        return r11;
    L24:
        JSONObject r17 = new JSONObject(r10);
        if (e(r17) == true) goto L32;
        return r11;
    L32:
        JSONObject r18 = r17.optJSONObject("data");     // Catch: Exception -> L29
        r11.f8845b = new f4.d(r18.optJSONObject("settings"), null);     // Catch: Exception -> L29
        r11.f8846c = r18.optJSONObject("vid_info");     // Catch: Exception -> L29
        r11.f8847d = r18.optString("ctx_infos");     // Catch: Exception -> L29
        r11.f8844a = true;     // Catch: Exception -> L29
    L31:
        return r11;
    L29:
        e = move-exception;
        AIKLog.INSTANCE.e(f4588b, "settings parse data error : " + e);
    L14:
        e = move-exception;
        AIKLog.INSTANCE.e(f4588b, "settings request error : " + e);
        goto L17
    L5:
        if (NetworkAllowState.INSTANCE.isAllowNetworkRequestNow() == false) goto L7;
        r14 = true;
        goto L8
    }

    @Override // f4.b
    public f4.c a() {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        Object r11 = Result.m32constructorimpl(f());     // Catch: Throwable -> L4
    L6:
        Throwable r12 = Result.m35exceptionOrNullimpl(r11);
        if (r12 == null) goto L10;
        AIKLog.INSTANCE.e(f4588b, "request failed: " + ExceptionsKt.stackTraceToString(r12));
    L10:
        if (Result.m38isFailureimpl(r11) == false) goto L12;
        r11 = null;
    L12:
        f4.c r13 = (f4.c) r11;
        if (r13 != null) goto L18;
        f4.c r14 = new f4.c();
        r14.f8844a = false;
        return r14;
    L18:
        return r13;
    L4:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r11 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final boolean e(JSONObject r10) {
        if (r10 == null) goto L4;
        String r11 = r10.optString("message");
    L6:
        return Intrinsics.areEqual("success", r11);
    L4:
        r11 = null;
        goto L6
    }
}
