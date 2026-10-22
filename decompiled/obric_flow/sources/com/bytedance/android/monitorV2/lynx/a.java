package com.bytedance.android.monitorV2.lynx;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends t4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f3633c;

    public a(String r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "eventType");
        Intrinsics.checkNotNullParameter(r10, "data");
        super(r5);
        this.f3632b = r5;
        this.f3633c = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        String r11 = r10.f3632b;
        if (Intrinsics.areEqual(this.f3632b, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3633c, r10.f3633c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f3632b.hashCode() * 31;
        return this.f3633c.hashCode() + r5;
    }

    @Override // sj.g
    public final void m(JSONObject r5) {
        qo.a.m(r5, this.f3633c);
    }

    @Override // t4.a
    public final String toString() {
        return "EventNativeInfo(eventType=" + this.f3632b + ", data=" + this.f3633c + ')';
    }
}
