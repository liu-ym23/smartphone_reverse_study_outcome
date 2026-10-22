package com.larus.bmhome.chat.deepresearch.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l {
    public final String a;
    public final String b;
    public final ChatParam c;
    public final Message d;
    public final boolean e;
    public final Long f;
    public final by7.e g;
    public final Block h;
    public final fh8.f i;
    public final RecyclerView j;
    public final Function0<BotModel> k;
    public final Integer l;
    public final Integer m;
    public final Integer n;
    public final Function0<Boolean> o;
    public final boolean p;
    public final Boolean q;
    public final Function2<View, Message, Boolean> r;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
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
        if (this.e == r6.e) goto L24;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.c.hashCode()) * 31;
        Message r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        int r10 = 1231;
        if (this.e == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        by7.e r16 = this.g;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Block r19 = this.h;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (((r18 + r20) * 31) + this.i.hashCode()) * 31;
        RecyclerView r22 = this.j;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (((r21 + r23) * 31) + this.k.hashCode()) * 31;
        Integer r25 = this.l;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.m;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.n;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Function0<Boolean> r34 = this.o;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        if (this.p == true) goto L54;
        r10 = 1237;
    L54:
        int r37 = (r36 + r10) * 31;
        Boolean r38 = this.q;
        if (r38 != null) goto L57;
        int r39 = 0;
    L58:
        int r40 = (r37 + r39) * 31;
        Function2<View, Message, Boolean> r41 = this.r;
        if (r41 == null) goto L63;
        r1 = r41.hashCode();
    L63:
        return r40 + r1;
    L57:
        r39 = r38.hashCode();
        goto L58
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = 1237;
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
        return "ExpandTitleCodeBlockConfig(botId=" + this.a + ", chatType=" + this.b + ", chatParam=" + this.c + ", message=" + this.d + ", isImmersive=" + this.e + ", uniqueKey=" + this.f + ", trackNode=" + this.g + ", block=" + this.h + ", markdownCommonInputData=" + this.i + ", recyclerView=" + this.j + ", getBotModel=" + this.k + ", toolHeaderBackgroundRes=" + this.l + ", codeBackgroundRes=" + this.m + ", codeSeparatorColor=" + this.n + ", interceptClickCard=" + this.o + ", disableFoldExpandClick=" + this.p + ", initialFoldState=" + this.q + ", codeSelectionHandler=" + this.r + ')';
    }

    public l(String r6, String r7, ChatParam r8, Message r9, boolean r10, Long r11, by7.e r12, Block r13, fh8.f r14, RecyclerView r15, com.larus.bmhome.block.holder.deepthink.n r16, Integer r17, Integer r18, Integer r19, com.larus.bmhome.block.holder.deepthink.o r20, boolean r21, Boolean r22, Function2 r23) {
        Intrinsics.checkNotNullParameter(r8, "chatParam");
        Intrinsics.checkNotNullParameter(r14, "markdownCommonInputData");
        Intrinsics.checkNotNullParameter(r16, "getBotModel");
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.h = r13;
        this.i = r14;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.n = r19;
        this.o = r20;
        this.p = r21;
        this.q = r22;
        this.r = r23;
    }
}
