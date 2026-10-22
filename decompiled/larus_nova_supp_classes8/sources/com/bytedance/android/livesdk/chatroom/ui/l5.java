package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l5 {
    public boolean a;
    public final String b;
    public String c;
    public final int d;
    public String e;
    public final boolean f;
    public final String g;
    public final AudienceResolutionType h;
    public final c8 i;
    public final String j;
    public String k;

    public static final class a {
    }

    static {
    }

    public final AudienceResolutionType getType() {
        return this.h;
    }

    public l5(String r5, String r6, int r7, String r8, boolean r9, String r10, c8 r11, String r12, int r13) {
        String r1 = "";
        if ((r13 & 32) == 0) goto L6;
        r10 = "";
    L6:
        if ((r13 & 64) == 0) goto L8;
        AudienceResolutionType r0 = AudienceResolutionType.normal;
    L10:
        if ((r13 & 128) == 0) goto L13;
        r11 = new c8(false, false);
    L13:
        if ((r13 & 256) == 0) goto L16;
        r12 = "";
    L16:
        if ((r13 & 512) != 0) goto L19;
        r1 = null;
    L19:
        Intrinsics.checkNotNullParameter(r5, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r6, "subname");
        Intrinsics.checkNotNullParameter(r8, "status");
        Intrinsics.checkNotNullParameter(r10, "sdkKey");
        Intrinsics.checkNotNullParameter(r0, "type");
        Intrinsics.checkNotNullParameter(r11, "paidInfo");
        Intrinsics.checkNotNullParameter(r12, "resolutionKey");
        Intrinsics.checkNotNullParameter(r1, "bottomDesc");
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r0;
        this.i = r11;
        this.j = r12;
        this.k = r1;
        return;
    L8:
        r0 = null;
        goto L10
    }
}
