package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final String a;
    public final String b;
    public final MinutesForegroundService.ForegroundServiceType c;

    public /* synthetic */ d() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "MmRecordingForegroundNotificationAction(title=" + this.a + ", content=" + this.b + ", foregroundServiceType=" + this.c + ')';
    }

    public d(String r2, String r3, MinutesForegroundService.ForegroundServiceType r4) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "foregroundServiceType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
