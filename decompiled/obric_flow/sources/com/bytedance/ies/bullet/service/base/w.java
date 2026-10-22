package com.bytedance.ies.bullet.service.base;

import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6019c;
    public final ArrayList d;
    public final int e;
    public final boolean f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f6020h;

    public w(String r5, boolean r10, String r11, ArrayList r12, int r13, boolean r14, boolean r15, long r16) {
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r12, "url");
        this.f6017a = r5;
        this.f6018b = r10;
        this.f6019c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f6020h = r16;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof w) == true) goto L8;
        return false;
    L8:
        w r11 = (w) r10;
        String r5 = r11.f6017a;
        if (Intrinsics.areEqual(this.f6017a, r5) == true) goto L12;
        return false;
    L12:
        if (this.f6018b == r11.f6018b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f6019c, r11.f6019c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L27;
        return false;
    L27:
        if (this.g == r11.g) goto L30;
        return false;
    L30:
        if (this.f6020h == r11.f6020h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r5 = kn.e.a(this.f6017a.hashCode() * 31, 31, this.f6018b);
        int r10 = kk.a.b(this.f6019c, r5, 31);
        int r11 = (this.d.hashCode() + r10) * 31;
        int r12 = kn.e.a(kn.e.a(k5.d.a(this.e, r11), 31, this.f), 31, this.g);
        return Long.hashCode(this.f6020h) + r12;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PreloadVideoConfig(id=");
        r5.append(this.f6017a);
        r5.append(", h265=");
        r5.append(this.f6018b);
        r5.append(", uri=");
        r5.append(this.f6019c);
        r5.append(", url=");
        r5.append(this.d);
        r5.append(", priority=");
        r5.append(this.e);
        r5.append(", serial=");
        r5.append(this.f);
        r5.append(", enableMemory=");
        r5.append(this.g);
        r5.append(", expire=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.f6020h, ')');
    }
}
