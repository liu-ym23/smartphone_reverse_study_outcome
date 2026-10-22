package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ge1 {
    public final int a;
    public final int b;
    public final String c;
    public final String d;
    public final boolean e;
    public final Function0<Unit> f;
    public final Function0<Unit> g;

    public static final class a {
    }

    static {
    }

    public ge1() {
        int r0 = 0;
        this(r0, r0, 127);
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("PlayerTips(state=");
        int r1 = this.a;
        String r2 = "unknown";
        if (r1 == 0) goto L9;
        if (r1 == 1) goto L8;
        if (r1 == 2) goto L7;
        String r3 = "unknown";
    L10:
        r0.append(r3);
        r0.append(", source=");
        int r4 = this.b;
        if (r4 == 0) goto L17;
        if (r4 == 1) goto L16;
        if (r4 != 2) goto L18;
        r2 = LiveEndPageData.TAG_RECOMMEND;
    L18:
        r0.append(r2);
        r0.append(", content='");
        r0.append(this.c);
        r0.append("', agreeText='");
        r0.append(this.d);
        r0.append("', enableClose=");
        r0.append(this.e);
        r0.append(')');
        return r0.toString();
    L16:
        r2 = "stall";
        goto L18
    L17:
        r2 = "none";
        goto L18
    L7:
        r3 = "hide";
        goto L10
    L8:
        r3 = "show";
        goto L10
    L9:
        r3 = "init";
        goto L10
    }

    public /* synthetic */ ge1(int r11, int r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r13 & 2) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r13 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r13 & 16) == 0) goto L21;
        boolean r7 = true;
    L22:
        this(r3, r4, r5, r6, r7, null, null);
        return;
    L21:
        r7 = false;
        goto L22
    L17:
        r6 = null;
        goto L19
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public ge1(int r2, int r3, String r4, String r5, boolean r6, Function0<Unit> r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r5, "agreeText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
