package com.larus.voicecall.impl.subtitle;

import com.larus.audio.call.subtitle.DisplayType;
import com.larus.im.bean.message.block.Block;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public final String a;
    public final List<Block> b;
    public final DisplayType c;
    public final String d;
    public final long e;
    public final String f;
    public String g;
    public boolean h;
    public x3a.a i;
    public String j;
    public final Map<String, Object> k;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        List<Block> r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        String r5 = this.d;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        long r6 = this.e;
        return ((((r4 + r2) * 31) + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.f.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DisplaySubtitleData(data=" + this.a + ", blockData=" + this.b + ", displayType=" + this.c + ", littleSubtitleData=" + this.d + ", subtitleCreateTime=" + this.e + ", questionId=" + this.f + ')';
    }

    public /* synthetic */ c(String r11, DisplayType r12, long r13, int r15) {
        int r0 = r15 & 1;
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
        if (r0 == 0) goto L5;
        String r3 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        if ((r15 & 4) == 0) goto L9;
        r12 = DisplayType.REPLY_TXT;
    L9:
        DisplayType r5 = r12;
        if ((r15 & 32) != 0) goto L13;
        r1 = null;
    L13:
        this(r3, null, r5, null, r13, r1);
        return;
    L5:
        r3 = r11;
        goto L7
    }

    public c(String r2, List<Block> r3, DisplayType r4, String r5, long r6, String r8) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
        Intrinsics.checkNotNullParameter(r4, "displayType");
        Intrinsics.checkNotNullParameter(r8, "questionId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.j = NameKeys.UnloadStrategy_No_Strategy;
        this.k = new LinkedHashMap();
    }

    public static c a(c r8, String r9, List r10, DisplayType r11, String r12, String r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r9 = r8.a;
    L5:
        String r1 = r9;
        if ((r14 & 2) == 0) goto L8;
        r10 = r8.b;
    L8:
        List r2 = r10;
        if ((r14 & 4) == 0) goto L11;
        r11 = r8.c;
    L11:
        DisplayType r3 = r11;
        if ((r14 & 8) == 0) goto L14;
        r12 = r8.d;
    L14:
        String r4 = r12;
        if ((r14 & 16) == 0) goto L17;
        long r15 = r8.e;
    L18:
        long r5 = r15;
        if ((r14 & 32) == 0) goto L21;
        r13 = r8.f;
    L21:
        String r7 = r13;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.DATA_KEY);
        Intrinsics.checkNotNullParameter(r3, "displayType");
        Intrinsics.checkNotNullParameter(r7, "questionId");
        return new c(r1, r2, r3, r4, r5, r7);
    L17:
        r15 = 0;
        goto L18
    }
}
