package org.apache.commons.lang3.time;

import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeZone f20976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20977b;

    public m(TimeZone r5, boolean r10) {
        this.f20976a = r5;
        if (r10 == false) goto L5;
        int r11 = r5.getDSTSavings();
    L6:
        this.f20977b = r11;
        return;
    L5:
        r11 = 0;
        goto L6
    }
}
