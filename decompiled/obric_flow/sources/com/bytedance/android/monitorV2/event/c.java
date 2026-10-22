package com.bytedance.android.monitorV2.event;

import ko.r;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f3555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3556c;
    public final JSONObject d;

    public c(String r5, r r10, String r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r5, "eventType");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "eventId");
        Intrinsics.checkNotNullParameter(r12, "info");
        this.f3554a = r5;
        this.f3555b = r10;
        this.f3556c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        String r11 = r10.f3554a;
        if (Intrinsics.areEqual(this.f3554a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3555b, r10.f3555b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f3556c, r10.f3556c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f3554a.hashCode() * 31;
        int r10 = (this.f3555b.hashCode() + r5) * 31;
        int r11 = kk.a.b(this.f3556c, r10, 31);
        return this.d.hashCode() + r11;
    }

    public final String toString() {
        return "EventInfo(eventType=" + this.f3554a + ", state=" + this.f3555b + ", eventId=" + this.f3556c + ", info=" + this.d + ')';
    }
}
