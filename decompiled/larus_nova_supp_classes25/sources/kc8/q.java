package kc8;

import androidx.fragment.app.Fragment;
import cb8.a1;
import cb8.p1;
import cb8.r1;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q {
    public final Fragment a;
    public final Boolean b;
    public final Boolean c;
    public final a0 d;
    public final Function0<Boolean> e;
    public final CoroutineScope f;
    public final rd8.b g;
    public final rd8.a h;
    public final Function0<List<Message>> i;
    public final c0 j;
    public final b0 k;
    public final com.larus.bmhome.chat.api.q0 l;
    public final Function1<Integer, Unit> m;

    public q() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 8191);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        Fragment r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        a0 r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Function0<Boolean> r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        CoroutineScope r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        rd8.b r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        rd8.a r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Function0<List<Message>> r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        c0 r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        b0 r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        com.larus.bmhome.chat.api.q0 r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Function1<Integer, Unit> r37 = this.m;
        if (r37 == null) goto L55;
        r1 = r37.hashCode();
    L55:
        return r36 + r1;
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
        return "CreateBlockConfig(hostFragment=" + this.a + ", disableCreateImagePreview=" + this.b + ", showShare=" + this.c + ", conversationProvider=" + this.d + ", isCollectMode=" + this.e + ", coroutineScope=" + this.f + ", creationVideoAction=" + this.g + ", creationLoadingState=" + this.h + ", messageListProvider=" + this.i + ", interactionHandler=" + this.j + ", editAction=" + this.k + ", messageAdapter=" + this.l + ", customClickListener=" + this.m + ')';
    }

    public q(Fragment r3, Boolean r4, a0 r5, cb8.z0 r6, CoroutineScope r7, rd8.b r8, p1 r9, a1 r10, c0 r11, r1 r12, com.larus.bmhome.chat.api.q0 r13, com.larus.larkfeed.impl.lark.holder.content.n r14, int r15) {
        if ((r15 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r5 = null;
    L12:
        if ((r15 & 16) == 0) goto L15;
        r6 = null;
    L15:
        if ((r15 & 32) == 0) goto L18;
        r7 = null;
    L18:
        if ((r15 & 64) == 0) goto L21;
        r8 = null;
    L21:
        if ((r15 & 128) == 0) goto L24;
        r9 = null;
    L24:
        if ((r15 & 256) == 0) goto L27;
        r10 = null;
    L27:
        if ((r15 & 512) == 0) goto L30;
        r11 = null;
    L30:
        if ((r15 & 1024) == 0) goto L33;
        r12 = null;
    L33:
        if ((r15 & 2048) == 0) goto L36;
        r13 = null;
    L36:
        if ((r15 & 4096) == 0) goto L38;
        r14 = null;
    L38:
        this.a = r3;
        this.b = r4;
        this.c = null;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
    }
}
