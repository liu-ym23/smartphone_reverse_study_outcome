package com.obric.aikernel.model.cloud.common;

import android.os.Bundle;
import com.bytedance.apm6.util.constant.CommonConsts;
import java.io.BufferedReader;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f4656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BufferedReader f4659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Throwable f4660g;

    public c(String r10, int r11, Map<String, String> r12, String r13, String r14, BufferedReader r15, Throwable r16) {
        Intrinsics.checkNotNullParameter(r10, "url");
        this.f4654a = r10;
        this.f4655b = r11;
        this.f4656c = r12;
        this.f4657d = r13;
        this.f4658e = r14;
        this.f4659f = r15;
        this.f4660g = r16;
    }

    public /* synthetic */ c(String r11, int r12, Map r13, String r14, String r15, BufferedReader r16, Throwable r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 32) == 0) goto L5;
        BufferedReader r10 = null;
    L7:
        if ((r18 & 64) == 0) goto L9;
        Throwable r20 = null;
    L10:
        this(r11, r12, r13, r14, r15, r10, r20);
        return;
    L9:
        r20 = r17;
        goto L10
    L5:
        r10 = r16;
        goto L7
    }

    public final Bundle a() {
        Bundle r10 = new Bundle();
        r10.putString("body", this.f4657d);
        r10.putString("message", this.f4658e);
        Throwable r11 = this.f4660g;
        if (r11 == null) goto L5;
        String r12 = r11.toString();
    L6:
        r10.putString(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r12);
        r10.putString("url", this.f4654a);
        r10.putInt("status", this.f4655b);
        return r10;
    L5:
        r12 = null;
        goto L6
    }

    public final String b() {
        return this.f4657d;
    }

    public final Throwable c() {
        return this.f4660g;
    }

    public final Map<String, String> d() {
        return this.f4656c;
    }

    public final String e() {
        return this.f4658e;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.f4654a, r11.f4654a) == true) goto L12;
        return false;
    L12:
        if (this.f4655b == r11.f4655b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f4656c, r11.f4656c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f4657d, r11.f4657d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f4658e, r11.f4658e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f4659f, r11.f4659f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f4660g, r11.f4660g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int f() {
        return this.f4655b;
    }

    public final BufferedReader g() {
        return this.f4659f;
    }

    public final String h() {
        return this.f4654a;
    }

    public int hashCode() {
        int r10 = ((this.f4654a.hashCode() * 31) + Integer.hashCode(this.f4655b)) * 31;
        Map<String, String> r11 = this.f4656c;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        String r15 = this.f4657d;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r14 + r16) * 31;
        String r18 = this.f4658e;
        if (r18 != null) goto L13;
        int r19 = 0;
    L14:
        int r20 = (r17 + r19) * 31;
        BufferedReader r21 = this.f4659f;
        if (r21 != null) goto L17;
        int r22 = 0;
    L18:
        int r23 = (r20 + r22) * 31;
        Throwable r24 = this.f4660g;
        if (r24 == null) goto L23;
        r12 = r24.hashCode();
    L23:
        return r23 + r12;
    L17:
        r22 = r21.hashCode();
        goto L18
    L13:
        r19 = r18.hashCode();
        goto L14
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final boolean i() {
        int r10 = this.f4655b;
        if (200 <= r10) goto L5;
        return false;
    L5:
        if (r10 >= 300) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString() {
        return "CommonNetworkResult(url=" + this.f4654a + ", status=" + this.f4655b + ", headers=" + this.f4656c + ", body=" + this.f4657d + ", message=" + this.f4658e + ", stream=" + this.f4659f + ", exception=" + this.f4660g + ')';
    }
}
