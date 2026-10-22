package q99;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.applet.aibridge.p;
import com.larus.bmhome.chat.component.list.l4;
import com.larus.bmhome.chat.component.list.n4;
import com.larus.bmhome.chat.component.list.o4;
import com.larus.bmhome.chat.component.list.s4;
import com.larus.bmhome.chat.component.list.t4;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Function0<String> e;
    public final Function0<Boolean> f;
    public final Function0<Boolean> g;
    public final Function0<LifecycleOwner> h;
    public final Function0<FragmentManager> i;
    public final List<String> j;
    public final String k;
    public final Function0<String> l;
    public final boolean m;
    public final Function0<Context> n;
    public final Function1<Message, Boolean> o;
    public final Function2<String, e, JSONObject> p;
    public final o99.a q;

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
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Function0<String> r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((((r7 + r9) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Function0<LifecycleOwner> r11 = this.h;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Function0<FragmentManager> r14 = this.i;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        List<String> r17 = this.j;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r20 = (r16 + r18) * 31;
        String r21 = this.k;
        if (r21 != null) goto L29;
        int r22 = 0;
    L30:
        int r23 = (r20 + r22) * 31;
        Function0<String> r24 = this.l;
        if (r24 != null) goto L33;
        int r25 = 0;
    L34:
        int r26 = (r23 + r25) * 31;
        if (this.m == false) goto L37;
        int r27 = 1231;
    L38:
        int r28 = (r26 + r27) * 31;
        Function0<Context> r30 = this.n;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (((((r28 + r31) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31;
        o99.a r33 = this.q;
        if (r33 == null) goto L47;
        r2 = r33.hashCode();
    L47:
        return r32 + r2;
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r27 = 1237;
        goto L38
    L33:
        r25 = r24.hashCode();
        goto L34
    L29:
        r22 = r21.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
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
        return "FlowFeedbackHost(pageKey=" + this.a + ", businessScene=" + this.b + ", conversationId=" + this.c + ", callId=" + this.d + ", currentSectionIdProvider=" + this.e + ", activeChecker=" + this.f + ", inputChecker=" + this.g + ", lifecycleOwnerProvider=" + this.h + ", fragmentManagerProvider=" + this.i + ", popupDisplayPageNames=" + this.j + ", popupNotificationBusiness=" + this.k + ", popupAvatarUrlProvider=" + this.l + ", dislikePanelDisableCopyButton=" + this.m + ", contextProvider=" + this.n + ", canShowLikeOrDislike=" + this.o + ", mobParamsProvider=" + this.p + ", feedbackListener=" + this.q + ')';
    }

    public final String a() {
        Function0<String> r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (String) r0.invoke();
    }

    public final boolean b() {
        return ((Boolean) this.f.invoke()).booleanValue();
    }

    public i(String r21, String r22, String r23, String r24, l4 r25, n4 r26, o4 r27, Function0 r28, Function0 r210, List r30, String r31, Function0 r32, s4 r33, t4 r34, Function2 r35, o99.a r36, int r37) {
        if ((r37 & 4) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r37 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r37 & 16) == 0) goto L13;
        l4 r7 = null;
    L15:
        if ((r37 & 32) == 0) goto L17;
        n4 r8 = new p();
    L19:
        if ((r37 & 64) == 0) goto L21;
        o4 r9 = new zb8.c();
    L23:
        if ((r37 & 128) == 0) goto L25;
        Function0 r10 = null;
    L27:
        if ((r37 & 256) == 0) goto L29;
        Function0 r11 = null;
    L31:
        if ((r37 & 512) == 0) goto L33;
        List r12 = null;
    L35:
        if ((r37 & 1024) == 0) goto L37;
        String r13 = null;
    L39:
        if ((r37 & 2048) == 0) goto L41;
        Function0 r14 = null;
    L43:
        if ((r37 & 8192) == 0) goto L45;
        s4 r15 = null;
    L47:
        if ((r37 & 16384) == 0) goto L49;
        t4 r5 = new g();
    L51:
        if ((r37 & 32768) == 0) goto L53;
        Function2 r16 = new h();
    L55:
        if ((r37 & 65536) == 0) goto L57;
        o99.a r17 = null;
    L58:
        Intrinsics.checkNotNullParameter(r21, "pageKey");
        Intrinsics.checkNotNullParameter(r22, "businessScene");
        Intrinsics.checkNotNullParameter(r8, "activeChecker");
        Intrinsics.checkNotNullParameter(r9, "inputChecker");
        Intrinsics.checkNotNullParameter(r5, "canShowLikeOrDislike");
        Intrinsics.checkNotNullParameter(r16, "mobParamsProvider");
        this.a = r21;
        this.b = r22;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = false;
        this.n = r15;
        this.o = r5;
        this.p = r16;
        this.q = r17;
        return;
    L57:
        r17 = r36;
        goto L58
    L53:
        r16 = r35;
        goto L55
    L49:
        r5 = r34;
        goto L51
    L45:
        r15 = r33;
        goto L47
    L41:
        r14 = r32;
        goto L43
    L37:
        r13 = r31;
        goto L39
    L33:
        r12 = r30;
        goto L35
    L29:
        r11 = r210;
        goto L31
    L25:
        r10 = r28;
        goto L27
    L21:
        r9 = r27;
        goto L23
    L17:
        r8 = r26;
        goto L19
    L13:
        r7 = r25;
        goto L15
    L9:
        r6 = r24;
        goto L11
    L5:
        r4 = r23;
        goto L7
    }
}
