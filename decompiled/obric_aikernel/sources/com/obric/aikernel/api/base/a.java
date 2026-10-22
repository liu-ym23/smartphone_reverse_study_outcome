package com.obric.aikernel.api.base;

import android.os.Build;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.runtime.utils.DeviceUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.obric.aikernel.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f4434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f4435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4436c;

    public a() {
        String r10 = Build.SOC_MODEL;
        if ((!Intrinsics.areEqual(r10, "unknown")) == true) goto L6;
        r10 = null;
    L6:
        if (r10 != null) goto L8;
        r10 = g();
    L8:
        this.f4436c = r10;
    }

    protected final String a() {
        String r10 = this.f4435b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("cachedChannel");
        return null;
    }

    protected final String b() {
        String r10 = this.f4434a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("cachedDidFrommOs");
        return null;
    }

    public final String c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "channel");
        if (this.f4435b == null) goto L7;
        return a();
    L7:
        if (StringsKt.isBlank(r10) == false) goto L9;
        r10 = "local_test";
    L9:
        DeviceUtils r11 = DeviceUtils.f5383a;
        m(b.a(r10, r11.k(), r11.f()));
        return a();
    }

    protected String d() {
        return com.bytedance.applog.a.d();
    }

    public final String e() {
        if (this.f4434a != null) goto L5;
        String r10 = d();
        if (r10 != null) goto L9;
    L17:
        return "";
    L9:
        if (r10.length() <= 0) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == true) goto L15;
        r10 = null;
    L15:
        if (r10 == null) goto L17;
        n(r10);
        AIKLog.INSTANCE.i("AppConfigs", "init device_id succeed " + b());
        return r10;
    L11:
        r11 = false;
        goto L12
    L5:
        return b();
    }

    public String f() {
        return this.f4436c;
    }

    protected String g() {
        return "SM8750";
    }

    public Map<String, String> h() {
        return null;
    }

    public boolean i() {
        DeviceUtils r10 = DeviceUtils.f5383a;
        if (r10.h() == false) goto L5;
    L8:
        return true;
    L5:
        if (r10.i() == true) goto L8;
        return false;
    }

    public boolean j() {
        return DeviceUtils.f5383a.i();
    }

    public boolean k(String r10) {
        Intrinsics.checkNotNullParameter(r10, "channel");
        if (StringsKt.isBlank(r10) == false) goto L6;
        r10 = "local_test";
    L6:
        return StringsKt.startsWith$default(r10, "local_test", false, 2, null);
    }

    public String l(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "currentProcessName");
        return null;
    }

    protected final void m(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f4435b = r10;
    }

    protected final void n(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f4434a = r10;
    }

    public boolean o() {
        return false;
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        return false;
    }

    public boolean r() {
        return false;
    }
}
