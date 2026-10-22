package com.larus.bmhome.chat.helper;

import android.view.View;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.RecommendFrom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o0 {
    public final ChatFragment a;
    public final View b;
    public final RecommendFrom c;
    public final boolean d;
    public final wc9.e e;
    public final BotModel f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r6 = (o0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        View r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        RecommendFrom r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.d == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        wc9.e r10 = this.e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        BotModel r13 = this.f;
        if (r13 == null) goto L23;
        r2 = r13.hashCode();
    L23:
        return r12 + r2;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "SubConversationMenuContext(fragment=" + this.a + ", hostView=" + this.b + ", recommendFrom=" + this.c + ", enableNewChat=" + this.d + ", conversation=" + this.e + ", botModel=" + this.f + ')';
    }

    public o0(ChatFragment r2, View r3, RecommendFrom r4, boolean r5, wc9.e r6, BotModel r7) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
