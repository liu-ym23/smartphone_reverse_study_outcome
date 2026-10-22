package com.larus.bmhome.chat.list.cell.text.components.middle;

import android.content.Context;
import android.widget.LinearLayout;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h0 {
    public final long a;
    public final gw8.c b;
    public final Context c;
    public final Message d;
    public final boolean e;
    public final BotModel f;
    public final boolean g;
    public final lw8.d h;
    public final int i;
    public final LinearLayout j;
    public final List<pw8.b> k;
    public final boolean l;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r9 = (h0) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        int r2 = 1231;
        if (this.e == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (((r1 + r3) * 31) + this.f.hashCode()) * 31;
        if (this.g == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (((((((((r4 + r5) * 31) + this.h.hashCode()) * 31) + this.i) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        if (this.l == true) goto L15;
        r2 = 1237;
    L15:
        return r6 + r2;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = 1237;
        goto L6
    }

    public final String toString() {
        return "RenderParams(startTime=" + this.a + ", markdownService=" + this.b + ", context=" + this.c + ", data=" + this.d + ", finished=" + this.e + ", bot=" + this.f + ", enableDataTagOptimize=" + this.g + ", customMarkDownInfo=" + this.h + ", maxContentWidth=" + this.i + ", contentViewGroup=" + this.j + ", mdWidgetsHandlerList=" + this.k + ", needForceUpdate=" + this.l + ')';
    }

    public final Context getContext() {
        return this.c;
    }

    public static h0 a(h0 r14, Message r15) {
        long r1 = r14.a;
        gw8.c r3 = r14.b;
        Context r4 = r14.c;
        boolean r6 = r14.e;
        BotModel r7 = r14.f;
        boolean r8 = r14.g;
        lw8.d r9 = r14.h;
        int r10 = r14.i;
        LinearLayout r11 = r14.j;
        List<pw8.b> r12 = r14.k;
        boolean r13 = r14.l;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r3, "markdownService");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r15, "data");
        Intrinsics.checkNotNullParameter(r7, "bot");
        Intrinsics.checkNotNullParameter(r9, "customMarkDownInfo");
        Intrinsics.checkNotNullParameter(r11, "contentViewGroup");
        Intrinsics.checkNotNullParameter(r12, "mdWidgetsHandlerList");
        return new h0(r1, r3, r4, r15, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public h0(long r2, gw8.c r4, Context r5, Message r6, boolean r7, BotModel r8, boolean r9, lw8.d r10, int r11, LinearLayout r12, List<pw8.b> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r4, "markdownService");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r8, "bot");
        Intrinsics.checkNotNullParameter(r10, "customMarkDownInfo");
        Intrinsics.checkNotNullParameter(r12, "contentViewGroup");
        Intrinsics.checkNotNullParameter(r13, "mdWidgetsHandlerList");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }
}
