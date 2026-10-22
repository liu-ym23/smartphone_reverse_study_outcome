package com.lynx.animax.setting;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f9701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnimaXSettingValue$SettingType f9702c;

    public a(String r5) {
        this.f9700a = r5;
        this.f9701b = null;
        this.f9702c = AnimaXSettingValue$SettingType.f9697a;
    }

    public final Collection a() {
        if (this.f9702c != AnimaXSettingValue$SettingType.f9698b) goto L7;
        return this.f9701b;
    L7:
        return Collections.EMPTY_LIST;
    }

    public final String b() {
        if (this.f9702c == AnimaXSettingValue$SettingType.f9697a) goto L5;
        return "";
    L5:
        return this.f9700a;
    }

    public final boolean c() {
        if (this.f9702c != AnimaXSettingValue$SettingType.f9698b) goto L6;
        return true;
    L6:
        return false;
    }

    public final boolean d() {
        if (this.f9702c != AnimaXSettingValue$SettingType.f9697a) goto L6;
        return true;
    L6:
        return false;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("{type=");
        AnimaXSettingValue$SettingType r10 = this.f9702c;
        r5.append(r10.name());
        r5.append(", value=");
        int r11 = r10.ordinal();
        String r12 = "";
        if (r11 != 0) goto L5;
        String r13 = this.f9700a;
        if (r13 == null) goto L23;
        r12 = r13;
    L23:
        r5.append(r12);
    L24:
        r5.append("}");
        return r5.toString();
    L5:
        if (r11 != 1) goto L7;
        List r14 = this.f9701b;
        if (r14 == null) goto L19;
        r5.append('[');
        r5.append(String.join(", ", r14));
        r5.append(']');
        goto L24
    L19:
        r5.append("[]");
        goto L24
    L7:
        if (r11 != 2) goto L9;
        r5.append("false");
        goto L24
    L9:
        if (r11 != 3) goto L11;
        r5.append("0");
        goto L24
    L11:
        if (r11 == 4) goto L13;
        r5.append("");
        goto L24
    L13:
        r5.append("0.0");
        goto L24
    }

    public a(List r5) {
        this.f9700a = null;
        this.f9701b = r5;
        this.f9702c = AnimaXSettingValue$SettingType.f9698b;
    }
}
