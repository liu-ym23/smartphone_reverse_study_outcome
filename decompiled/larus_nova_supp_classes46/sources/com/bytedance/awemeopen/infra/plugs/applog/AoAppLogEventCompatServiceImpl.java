package com.bytedance.awemeopen.infra.plugs.applog;

import android.app.Application;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.g;
import com.bytedance.applog.h;
import com.bytedance.applog.q;
import com.bytedance.applog.util.EventsSenderUtils;
import com.bytedance.applog.util.UriConstants;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.awemeopen.servicesapi.event.AoEventService;
import com.bytedance.awemeopen.servicesapi.log.AoLogService;
import com.bytedance.bdinstall.f0;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/applog/AoAppLogEventCompatServiceImpl;", "Lcom/bytedance/awemeopen/servicesapi/event/AoEventService;", "a", "ao_plugin_applog_release"}, k = 1, mv = {1, 7, 1})
public class AoAppLogEventCompatServiceImpl implements AoEventService {
    public final com.bytedance.awemeopen.infra.plugs.applog.c a;
    public final String b;
    public final Lazy c;
    public final Lazy d;
    public final boolean e;
    public g f;
    public volatile boolean g;
    public final ArrayList<a> h;
    public k64.a i;

    public static final class a {
        public final String a;
        public final JSONObject b;
        public final String c;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            String r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "TempEventBufferData(event=" + this.a + ", params=" + this.b + ", hostRawData=" + this.c + ')';
        }

        public a(String r2, JSONObject r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Intrinsics.checkNotNullParameter(r3, "params");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b implements h {
        public final /* synthetic */ AoAppLogEventCompatServiceImpl a;

        public b(AoAppLogEventCompatServiceImpl r1) {
            this.a = r1;
        }

        public final void a(boolean r4, JSONObject r5) {
            this.a.F2().d("AppLogIniter", "onRemoteConfigGet: changed = " + r4 + ", config = " + r5);
        }

        public final void onIdLoaded(String r4, String r5, String r6) {
            this.a.F2().d("AppLogIniter", "onIdLoaded: did = " + r4 + ", iid = " + r5 + ", ssid = " + r6);
        }

        public final void onRemoteIdGet(boolean r4, String r5, String r6, String r7, String r8, String r9, String r10) {
            this.a.F2().d("AppLogIniter", "onRemoteIdGet: changed = " + r4 + ", oldDid = " + r5 + ", newDid = " + r6 + ", oldIid = " + r7 + ", newIid = " + r8 + ", oldSsid = " + r9 + ", newSsid = " + r10);
        }
    }

    public static final class c implements f0 {
        public final /* synthetic */ AoAppLogEventCompatServiceImpl a;

        public c(AoAppLogEventCompatServiceImpl r1) {
            this.a = r1;
        }

        public final void d(String r3, Throwable r4) {
            AoLogService r0 = this.a.F2();
            StringBuilder r1 = new StringBuilder();
            r1.append(r3);
            if (r4 == null) goto L5;
            String r5 = r4.toString();
        L6:
            r1.append(r5);
            r0.d("AppLog", r1.toString());
            return;
        L5:
            r5 = null;
            goto L6
        }

        public final void e(String r3, Throwable r4) {
            AoLogService r0 = this.a.F2();
            StringBuilder r1 = new StringBuilder();
            r1.append(r3);
            if (r4 == null) goto L5;
            String r5 = r4.toString();
        L6:
            r1.append(r5);
            r0.e("AppLog", r1.toString());
            return;
        L5:
            r5 = null;
            goto L6
        }

        public final void i(String r3, Throwable r4) {
            AoLogService r0 = this.a.F2();
            StringBuilder r1 = new StringBuilder();
            r1.append(r3);
            if (r4 == null) goto L5;
            String r5 = r4.toString();
        L6:
            r1.append(r5);
            r0.i("AppLog", r1.toString());
            return;
        L5:
            r5 = null;
            goto L6
        }

        public final void v(String r3, Throwable r4) {
            AoLogService r0 = this.a.F2();
            StringBuilder r1 = new StringBuilder();
            r1.append(r3);
            if (r4 == null) goto L5;
            String r5 = r4.toString();
        L6:
            r1.append(r5);
            r0.d("AppLog", r1.toString());
            return;
        L5:
            r5 = null;
            goto L6
        }

        public final void w(String r3, Throwable r4) {
            AoLogService r0 = this.a.F2();
            StringBuilder r1 = new StringBuilder();
            r1.append(r3);
            if (r4 == null) goto L5;
            String r5 = r4.toString();
        L6:
            r1.append(r5);
            r0.w("AppLog", r1.toString());
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public final void init() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.g == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        g r0 = G2();     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r0, "<set-?>");     // Catch: Throwable -> L14
        this.f = r0;     // Catch: Throwable -> L14
        Iterator<a> r1 = this.h.iterator();     // Catch: Throwable -> L14
    L9:
        if (r1.hasNext() == false) goto L11;
        a r2 = r1.next();     // Catch: Throwable -> L14
        E2(r2.a, r2.b);     // Catch: Throwable -> L14
        goto L9
    L11:
        this.h.clear();     // Catch: Throwable -> L14
        this.g = true;     // Catch: Throwable -> L14
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    public final AoLogService F2() {
        return (AoLogService) this.c.getValue();
    }

    public final g G2() {
        g r0 = AppLog.newInstance();
        int r1 = j64.b.a;
        AoHostService r2 = j64.b.a(AoHostService.class);
        Application r3 = r2.getHostApplication();
        int r4 = com.bytedance.awemeopen.infra.plugs.applog.a.a;
        q r5 = new q("352969", r2.getHostChannel());
        r5.k = "aweme_open_sdk_for_event";
        r5.l = UriConstants.a;
        r5.b = true;
        r5.t = NetworkClientForApplog.a;
        boolean r6 = j64.b.a(AoHostService.class).hostIsDebug();
        r0.t1(!r6);
        r0.E0(new b(this));
        r5.e = new c(this);
        r0.O(r3, r5);
        if (r6 == false) goto L5;
        EventsSenderUtils.setEventsSenderEnable("352969", true, r3);
        EventsSenderUtils.setEventVerifyHost("352969", "https://log.snssdk.com");
    L5:
        return r0;
    }

    public AoAppLogEventCompatServiceImpl(d r2) {
        Intrinsics.checkNotNullParameter(r2, "compat");
        this.a = r2;
        this.b = "AoAppLogEventCompatServiceImpl";
        this.c = LazyKt.lazy(AoAppLogEventCompatServiceImpl$logger$2.INSTANCE);
        this.d = LazyKt.lazy(AoAppLogEventCompatServiceImpl$aoHostEnv$2.INSTANCE);
        this.e = true;
        this.h = new ArrayList();
    }

    public final void D1(com.bytedance.awemeopen.infra.base.event.a r1) {
        this.i = r1;
    }

    public final String k(String r7) {
        if (this.g == true) goto L24;
        F2().w(this.b, "getDid applog not inited");
        if (r7 == null) goto L7;
        return r7;
    L7:
        return "";
    L24:
        String r0 = this.a.k(r7);     // Catch: Exception -> L10
    L12:
        if (r0 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L27;
        F2().w(this.b, "newUrl is null or empty");
        if (r7 == null) goto L23;
        return r7;
    L23:
        return "";
    L27:
        return r0;
    L14:
        if (r0.length() == 0) goto L17;
        r2 = false;
    L10:
        e = move-exception;
        F2().w(this.b, "compat get url fail: " + e);
        r0 = null;
        goto L12
    }

    public final JSONObject z2(JSONObject r2) {
        k64.a r0 = this.i;
        if (r0 == null) goto L5;
        JSONObject r1 = ((com.bytedance.awemeopen.infra.base.event.a) r0).a.getParams();
    L6:
        e.a(r2, r1);
        return r2;
    L5:
        r1 = null;
        goto L6
    }

    public final void E2(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "params");
        k64.a r0 = this.i;
        if (r0 == null) goto L6;
        e.a(r3, ((com.bytedance.awemeopen.infra.base.event.a) r0).a.getParams());
    L6:
        if (this.e == false) goto L12;
        g r1 = this.f;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mNewInstanceApplog");
        r1 = null;
    L11:
        r1.onEventV3(r2, r3);
        return;
    L12:
        AppLog.onEventV3(r2, r3);
    }

    public final void k2(String r5, JSONObject r6, String r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r6, "params");
        if (this.g == true) goto L22;
        F2().w(this.b, "sendEventV3 applog not inited");
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.g == false) goto L9;
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
        goto L22
    L9:
        if (this.h.size() <= 5000) goto L13;
        F2().w(this.b, "sendEventV3 event buffer too much");     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L13:
        this.h.add(new a(r5, r6, r7));     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L22:
        if (r7 != null) goto L24;
    L27:
        boolean r1 = true;
    L28:
        if (r1 == false) goto L32;
        if (r8 == null) goto L34;
        if (r8.length() > 0) goto L32;
    L34:
        if (Intrinsics.areEqual(r5, "tobsdk_livesdk_live_show") == true) goto L38;
        E2(r5, r6);
        return;
    L38:
        return;
    L32:
        F2().i(this.b, "send event(" + r5 + ") with hostRawData(" + r7 + ") and hostExtraParams(" + r8 + ')');
        goto L34
    L24:
        if (r7.length() == 0) goto L27;
        r1 = false;
        goto L28
    }
}
