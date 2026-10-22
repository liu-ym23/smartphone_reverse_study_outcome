package qy8;

import com.bytedance.applet.debugger.AppletDebuggerHostFragment;
import com.larus.bmhome.chat.g4;
import com.larus.chat.ChatTitleBarIcon;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final c a;
    public final f b;
    public final d c;
    public final b d;
    public final boolean e;
    public final Set<ChatTitleBarIcon> f;
    public final g4 g;
    public final Boolean h;
    public final Set<String> i;
    public final Boolean j;

    public a() {
        this(null, null, null, null, false, null, null, null, null, 32767);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof a) == true) goto L8;
        return false;
    L8:
        a r7 = (a) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(null, null) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L30;
        return false;
    L30:
        if (this.e == r7.e) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(null, null) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(null, null) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        c r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        f r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((((r3 + r5) * 31) + 0) * 31) + 0) * 31) + 0) * 31;
        d r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        b r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.e == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (((((r12 + r13) * 31) + 0) * 31) + 0) * 31;
        Set<ChatTitleBarIcon> r15 = this.f;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        g4 r18 = this.g;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        Boolean r21 = this.h;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        Set<String> r24 = this.i;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        Boolean r27 = this.j;
        if (r27 == null) goto L43;
        r1 = r27.hashCode();
    L43:
        return r26 + r1;
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = 1237;
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
        return "ChatHostConfig(backInterceptor=" + this.a + ", createSubCvsInterceptor=" + this.b + ", conversationChangeListener=null, searchInterceptor=null, sideNavInterceptor=null, linkInterceptor=" + this.c + ", artifactInterceptor=" + this.d + ", enableMobilePreviewEnhancement=" + this.e + ", pageSizeSlotProvider=null, titleBarIconAnimationProgressProvider=null, titleBarVisibleIcons=" + this.f + ", titleBarConfig=" + this.g + ", userPromptHoverEverytimeOverride=" + this.h + ", bottomPanelVisibleItems=" + this.i + ", imageSkipDownscaleOverride=" + this.j + ')';
    }

    public a(c r3, AppletDebuggerHostFragment.d r4, d r5, b r6, boolean r7, Set r8, g4 r9, Boolean r10, Boolean r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r12 & 32) == 0) goto L12;
        r5 = null;
    L12:
        if ((r12 & 64) == 0) goto L15;
        r6 = null;
    L15:
        if ((r12 & 128) == 0) goto L18;
        r7 = false;
    L18:
        if ((r12 & 1024) == 0) goto L21;
        r8 = null;
    L21:
        if ((r12 & 2048) == 0) goto L24;
        r9 = null;
    L24:
        if ((r12 & 4096) == 0) goto L27;
        r10 = null;
    L27:
        if ((r12 & 16384) == 0) goto L29;
        r11 = null;
    L29:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = null;
        this.j = r11;
    }
}
