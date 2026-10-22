package com.larus.bmhome.chat.api;

import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wh8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public final Fragment a;
    public final by7.e b;
    public final String c;
    public final String d;
    public final boolean e;
    public final Function0<View> f;
    public final Function0<View> g;
    public final Function1<a, String> h;
    public final Function0<Unit> i;
    public final Function2<ConversationFeedActionType, a, Unit> j;

    public i() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        by7.e r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.e == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r10 + r11) * 31;
        Function0<View> r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Function0<View> r16 = this.g;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Function1<a, String> r19 = this.h;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Function0<Unit> r22 = this.i;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Function2<ConversationFeedActionType, a, Unit> r25 = this.j;
        if (r25 == null) goto L39;
        r2 = r25.hashCode();
    L39:
        return r24 + r2;
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
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConversationFeedActionContext(fragment=" + this.a + ", trackNode=" + this.b + ", currentPage=" + this.c + ", clickFrom=" + this.d + ", isNavigationSideBar=" + this.e + ", actionAnchorProvider=" + this.f + ", primaryMenuViewProvider=" + this.g + ", recommendFromProvider=" + this.h + ", onCloseMenu=" + this.i + ", onActionFinished=" + this.j + ')';
    }

    public i(Fragment r3, by7.e r4, String r5, String r6, boolean r7, Function0 r8, Function0 r9, Function1 r10, Function0 r11, int r12) {
        if ((r12 & 2) == 0) goto L9;
        if ((r3 instanceof by7.e) == false) goto L7;
        r4 = (by7.e) r3;
        goto L9
    L7:
        r4 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r7 = false;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r8 = null;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r12 & 128) == 0) goto L27;
        r10 = null;
    L27:
        if ((r12 & 256) == 0) goto L29;
        r11 = null;
    L29:
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = null;
    }
}
