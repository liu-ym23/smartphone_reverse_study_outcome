package com.larus.bmhome.chat.deepresearch.view;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.e5;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p0 {
    public final Integer a;
    public final BotModel b;
    public final ChatParam c;
    public final String d;
    public final de8.c e;
    public final e5 f;
    public final Boolean g;
    public final Integer h;
    public final com.larus.bmhome.chat.api.q0 i;
    public final int j;
    public final RecyclerView.Adapter<?> k;
    public final boolean l;
    public final Function1<CustomMarkdownTextView, Unit> m;
    public final Function1<CustomMarkdownTextView, Unit> n;
    public final Function1<CustomMarkdownTextView, Unit> o;

    public p0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r6 = (p0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        Boolean r4 = this.g;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.h;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        com.larus.bmhome.chat.api.q0 r10 = this.i;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.j) * 31;
        RecyclerView.Adapter<?> r13 = this.k;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.l == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        Function1<CustomMarkdownTextView, Unit> r18 = this.m;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        Function1<CustomMarkdownTextView, Unit> r21 = this.n;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        Function1<CustomMarkdownTextView, Unit> r24 = this.o;
        if (r24 == null) goto L39;
        r1 = r24.hashCode();
    L39:
        return r23 + r1;
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MarkdownTextBlockConfig(boxType=" + this.a + ", botModel=" + this.b + ", chatParam=" + this.c + ", chatType=" + this.d + ", chatArgumentData=" + this.e + ", chatSettingsConfig=" + this.f + ", isImmersive=" + this.g + ", immerseBgColor=" + this.h + ", adapter=" + this.i + ", viewHolderPosition=" + this.j + ", shareMessageListAdapter=" + this.k + ", isSelectMode=" + this.l + ", clickAction=" + this.m + ", longClickAction=" + this.n + ", onGenerateAction=" + this.o + ')';
    }

    public /* synthetic */ p0(int r79) {
        this(null, new BotModel(null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, Integer.MAX_VALUE, null), new ChatParam(null, null, null, null, null, 255), "other_default", new de8.c(null, null, false, null, null, false, null, null, null, null, false, false, null, 0, 32767), new e5(0), Boolean.FALSE, null, null, 0, null, false, null, null, null);
    }

    public p0(Integer r8, BotModel r9, ChatParam r10, String r11, de8.c r12, e5 r13, Boolean r14, Integer r15, com.larus.bmhome.chat.api.q0 r16, int r17, RecyclerView.Adapter<?> r18, boolean r19, Function1<? super CustomMarkdownTextView, Unit> r20, Function1<? super CustomMarkdownTextView, Unit> r21, Function1<? super CustomMarkdownTextView, Unit> r22) {
        Intrinsics.checkNotNullParameter(r9, "botModel");
        Intrinsics.checkNotNullParameter(r10, "chatParam");
        Intrinsics.checkNotNullParameter(r11, "chatType");
        Intrinsics.checkNotNullParameter(r12, "chatArgumentData");
        Intrinsics.checkNotNullParameter(r13, "chatSettingsConfig");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r20;
        this.n = r21;
        this.o = r22;
    }
}
