package com.obric.memorydata.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/utils/ImageHeaderUtil;", "", "<init>", "()V", "hasExpectedImageHeader", "", "bytes", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f13266a = null;

    static {
        f13266a = new w();
    }

    private w() {
    }

    public final boolean a(byte[] r11) {
        Intrinsics.checkNotNullParameter(r11, "bytes");
        if (r11.length >= 4) goto L6;
        return false;
    L6:
        if (r11[0] != (-1)) goto L13;
        if (r11[1] != (-40)) goto L13;
        if (r11[2] != (-1)) goto L13;
        return true;
    L13:
        if (r11[0] != (-119)) goto L22;
        if (r11[1] != 80) goto L22;
        if (r11[2] != 78) goto L22;
        if (r11[3] != 71) goto L22;
        return true;
    L22:
        if (r11[0] != 71) goto L31;
        if (r11[1] != 73) goto L31;
        if (r11[2] != 70) goto L31;
        if (r11[3] != 56) goto L31;
        return true;
    L31:
        if (r11.length < 12) goto L50;
        if (r11[0] != 82) goto L50;
        if (r11[1] != 73) goto L50;
        if (r11[2] != 70) goto L50;
        if (r11[3] != 70) goto L50;
        if (r11[8] != 87) goto L50;
        if (r11[9] != 69) goto L50;
        if (r11[10] != 66) goto L50;
        if (r11[11] != 80) goto L50;
        return true;
    L50:
        if (r11.length >= 12) goto L52;
    L60:
        return false;
    L52:
        if (r11[4] != 102) goto L60;
        if (r11[5] != 116) goto L60;
        if (r11[6] != 121) goto L60;
        if (r11[7] != 112) goto L60;
        return true;
    }
}
