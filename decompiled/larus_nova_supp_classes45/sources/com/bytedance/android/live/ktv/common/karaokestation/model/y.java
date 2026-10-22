package com.bytedance.android.live.ktv.common.karaokestation.model;

import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y {
    public ArrayList<y> a;
    public y b;
    public String c;
    public String d;
    public Map<String, String> e;
    public final a0 f;
    public int g;
    public final List<MusicPanel> h;
    public final List<Object> i;
    public boolean j;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public boolean o;

    public y() {
        this(0, 0, 65535);
    }

    public final boolean a() {
        ArrayList<y> r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if ((!r0.isEmpty()) != true) goto L7;
        return true;
    }

    public y(int r9, int r11, int r12) {
        String r2 = "";
        if ((r12 & 1) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r12 & 2) != 0) goto L11;
        r2 = null;
    L11:
        if ((r12 & 16) == 0) goto L13;
        a0 r3 = new a0();
    L15:
        if ((r12 & 128) == 0) goto L17;
        ArrayList r4 = new ArrayList();
    L19:
        if ((r12 & 256) == 0) goto L21;
        ArrayList r5 = new ArrayList();
    L23:
        if ((r12 & RomUtils.SZ) == 0) goto L26;
        r9 = FirstLevelTab.Unknown.getValue();
    L26:
        if ((r12 & 2048) == 0) goto L28;
        boolean r6 = true;
    L30:
        if ((r12 & 16384) == 0) goto L32;
        r11 = 0;
    L32:
        Intrinsics.checkNotNullParameter(r0, "name");
        Intrinsics.checkNotNullParameter(r2, "description");
        Intrinsics.checkNotNullParameter(r3, "titleFont");
        Intrinsics.checkNotNullParameter(r4, "musicList");
        Intrinsics.checkNotNullParameter(r5, "businessDataList");
        this.c = r0;
        this.d = r2;
        this.e = null;
        this.f = r3;
        this.g = 0;
        this.h = r4;
        this.i = r5;
        this.j = false;
        this.k = r9;
        this.l = r6;
        this.m = 0;
        this.n = r11;
        this.o = false;
        return;
    L28:
        r6 = false;
        goto L30
    L21:
        r5 = null;
        goto L23
    L17:
        r4 = null;
        goto L19
    L13:
        r3 = null;
        goto L15
    L5:
        r0 = null;
        goto L7
    }
}
