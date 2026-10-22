package com.bytedance.android.live.core.monitor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.crash.d;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class SafetyGuard {
    public static final a a = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/monitor/SafetyGuard$SafetyGuardCustomException;", "Ljava/lang/RuntimeException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SafetyGuardCustomException extends RuntimeException {
        public SafetyGuardCustomException(String r1, Throwable r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R2\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/core/monitor/SafetyGuard$a;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "logTypeAllowlist", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "setLogTypeAllowlist", "(Ljava/util/ArrayList;)V", "msgAllowlist", "d", "setMsgAllowlist", "crashInVirtualEnv", "a", "setCrashInVirtualEnv", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("crash_in_virtualenv")
        private boolean crashInVirtualEnv;

        @SerializedName("enable")
        private boolean enable;

        @SerializedName("log_type_allowlist")
        private ArrayList<String> logTypeAllowlist;

        @SerializedName("message_allowlist")
        private ArrayList<String> msgAllowlist;

        public a() {
            this.logTypeAllowlist = new ArrayList();
            this.msgAllowlist = new ArrayList();
            this.crashInVirtualEnv = true;
        }

        public final boolean a() {
            return this.crashInVirtualEnv;
        }

        public final boolean b() {
            return this.enable;
        }

        public final ArrayList<String> c() {
            return this.logTypeAllowlist;
        }

        public final ArrayList<String> d() {
            return this.msgAllowlist;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Throwable b;
        public final /* synthetic */ String c;

        public b(String r1, Throwable r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.f(this.a, this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        a = LiveInfraSettingKeys.LIVE_SAFETY_GUARD_CONFIG.getValue();
    }

    @JvmStatic
    public static final void b(Throwable r1) {
        a(null, r1, null);
    }

    @JvmStatic
    public static final void a(String r4, Throwable r5, String r6) {
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r4 = "ttlive_safety_guard_log_type";
    L14:
        if (r6 != null) goto L16;
        String r7 = "[SafetyGuard]";
    L17:
        if (r5 != null) goto L19;
        Throwable r0 = new Throwable(r7);
    L20:
        ALogger.e("SafetyGuard", r7, r5);
        a r2 = a;
        if (r2.b() == false) goto L30;
        ThreadPlus.submitRunnable(new b(r4, r0, r7));
        if (r2.a() == true) goto L25;
        return;
    L25:
        if (jc1.a.c() == false) goto L32;
        if (r5 == null) goto L29;
        throw r5;
    L29:
        throw new IllegalStateException(r7);
    L32:
        return;
    L30:
        return;
    L19:
        r0 = r5;
        goto L20
    L16:
        r7 = "[SafetyGuard] ".concat(r6);
        goto L17
    L12:
        if (StringsKt.startsWith$default(r4, "ttlive_", false, 2, null) == true) goto L14;
        r4 = "ttlive_" + r4;
        goto L14
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @JvmStatic
    public static final void c(String r2, Throwable r3, String r4) {
        a(r2, r3, r4);
        if (v.a() == true) goto L10;
        a r0 = a;
        if (CollectionsKt.contains(r0.c(), r2) == false) goto L7;
        return;
    L7:
        if (CollectionsKt.contains(r0.d(), r4) == false) goto L10;
        return;
    L10:
        throw new SafetyGuardCustomException(r4, r3);
    }
}
