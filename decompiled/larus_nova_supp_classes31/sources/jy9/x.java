package jy9;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.layout.holder.image.BaseImageBox;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x {
    public final Message a;
    public final q0.a b;
    public final iy9.b c;
    public final String d;
    public final Function0<Unit> e;
    public final CreationItem f;
    public final int g;
    public final CoroutineScope h;
    public final by7.e i;
    public final String j;
    public final View k;
    public final Fragment l;
    public final com.larus.bmhome.bigimg.e m;
    public final Function0<String> n;
    public final Function0<BotModel> o;
    public final Function0<wc9.e> p;
    public final boolean q;
    public final boolean r;
    public final rd8.b s;
    public final Function4<nr9.g, String, Map<String, String>, Map<String, String>, Unit> t;
    public final Function0<List<Message>> u;
    public final Function1<Integer, Unit> v;
    public final Function1<ICoreInputAbility.OnSendParams, Unit> w;
    public final Function4<Serializable, String, String, zs8.a, Unit> x;
    public final Function1<DialogFragment, Unit> y;
    public final Function0<Unit> z;

    public x() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L8;
        return false;
    L8:
        x r6 = (x) r5;
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
        if (this.g == r6.g) goto L30;
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
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (this.q == r6.q) goto L60;
        return false;
    L60:
        if (this.r == r6.r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r6.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r6.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r6.z) == true) goto L86;
        return false;
    L86:
        return true;
    }

    public final int hashCode() {
        Message r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        q0.a r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        iy9.b r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Function0<Unit> r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        CreationItem r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (((r15 + r17) * 31) + this.g) * 31;
        CoroutineScope r19 = this.h;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        by7.e r22 = this.i;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.j;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        View r28 = this.k;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Fragment r31 = this.l;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        com.larus.bmhome.bigimg.e r34 = this.m;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Function0<String> r37 = this.n;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        Function0<BotModel> r40 = this.o;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        Function0<wc9.e> r43 = this.p;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        int r46 = 1231;
        if (this.q == false) goto L65;
        int r47 = 1231;
    L66:
        int r48 = (r45 + r47) * 31;
        if (this.r == true) goto L70;
        r46 = 1237;
    L70:
        int r49 = (r48 + r46) * 31;
        rd8.b r50 = this.s;
        if (r50 != null) goto L73;
        int r51 = 0;
    L74:
        int r52 = (r49 + r51) * 31;
        Function4<nr9.g, String, Map<String, String>, Map<String, String>, Unit> r53 = this.t;
        if (r53 != null) goto L77;
        int r54 = 0;
    L78:
        int r55 = (r52 + r54) * 31;
        Function0<List<Message>> r56 = this.u;
        if (r56 != null) goto L81;
        int r57 = 0;
    L82:
        int r58 = (r55 + r57) * 31;
        Function1<Integer, Unit> r59 = this.v;
        if (r59 != null) goto L85;
        int r60 = 0;
    L86:
        int r61 = (r58 + r60) * 31;
        Function1<ICoreInputAbility.OnSendParams, Unit> r62 = this.w;
        if (r62 != null) goto L89;
        int r63 = 0;
    L90:
        int r64 = (r61 + r63) * 31;
        Function4<Serializable, String, String, zs8.a, Unit> r65 = this.x;
        if (r65 != null) goto L93;
        int r66 = 0;
    L94:
        int r67 = (r64 + r66) * 31;
        Function1<DialogFragment, Unit> r68 = this.y;
        if (r68 != null) goto L97;
        int r69 = 0;
    L98:
        int r70 = (r67 + r69) * 31;
        Function0<Unit> r71 = this.z;
        if (r71 == null) goto L103;
        r1 = r71.hashCode();
    L103:
        return r70 + r1;
    L97:
        r69 = r68.hashCode();
        goto L98
    L93:
        r66 = r65.hashCode();
        goto L94
    L89:
        r63 = r62.hashCode();
        goto L90
    L85:
        r60 = r59.hashCode();
        goto L86
    L81:
        r57 = r56.hashCode();
        goto L82
    L77:
        r54 = r53.hashCode();
        goto L78
    L73:
        r51 = r50.hashCode();
        goto L74
    L65:
        r47 = 1237;
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
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
        return "CreationGalleryContext(message=" + this.a + ", modelProvider=" + this.b + ", videoPlayParams=" + this.c + ", clickTaskId=" + this.d + ", onPagerDestroy=" + this.e + ", clickItem=" + this.f + ", clickIndex=" + this.g + ", scope=" + this.h + ", trackNode=" + this.i + ", previousPage=" + this.j + ", startView=" + this.k + ", compactForsetiFragment=" + this.l + ", scrollListener=" + this.m + ", botIdProvider=" + this.n + ", botProvider=" + this.o + ", conversationProvider=" + this.p + ", isCollectMode=" + this.q + ", isReadonlyForwardDetail=" + this.r + ", creationVideoAction=" + this.s + ", sendRemoteVideo=" + this.t + ", messageListProvider=" + this.u + ", scrollToPositionAction=" + this.v + ", doSend=" + this.w + ", sendImageRemoveMessage=" + this.x + ", showDialogFragment=" + this.y + ", dismissCreationPage=" + this.z + ')';
    }

    public x(Message r25, q0.a r26, iy9.b r27, String r28, CreationItem r29, int r30, CoroutineScope r31, BaseImageBox r32, View r33, Fragment r34, com.larus.bmhome.bigimg.e r35, Function0 r36, Function0 r37, Function0 r38, boolean r39, boolean r40, rd8.b r41, Function4 r42, com.larus.bmhome.chat.layout.holder.image.p r43, Function1 r44, Function4 r45, Function1 r46, Function0 r47, int r48) {
        if ((r48 & 2) == 0) goto L5;
        q0.a r2 = null;
    L7:
        if ((r48 & 4) == 0) goto L9;
        iy9.b r4 = null;
    L11:
        if ((r48 & 8) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r48 & 32) == 0) goto L17;
        CreationItem r6 = null;
    L19:
        if ((r48 & 64) == 0) goto L21;
        int r7 = 0;
    L23:
        if ((r48 & 256) == 0) goto L25;
        BaseImageBox r9 = null;
    L27:
        if ((r48 & 1024) == 0) goto L29;
        View r10 = null;
    L31:
        if ((r48 & 2048) == 0) goto L33;
        Fragment r11 = null;
    L35:
        if ((r48 & 4096) == 0) goto L37;
        com.larus.bmhome.bigimg.e r12 = null;
    L39:
        if ((r48 & 8192) == 0) goto L41;
        Function0 r13 = null;
    L43:
        if ((r48 & 16384) == 0) goto L45;
        Function0 r14 = null;
    L47:
        if ((32768 & r48) == 0) goto L49;
        Function0 r15 = null;
    L51:
        if ((r48 & 65536) == 0) goto L53;
        boolean r8 = false;
    L55:
        if ((r48 & 131072) == 0) goto L57;
        boolean r17 = false;
    L59:
        if ((r48 & 262144) == 0) goto L61;
        rd8.b r18 = null;
    L63:
        if ((r48 & 524288) == 0) goto L65;
        Function4 r19 = null;
    L67:
        if ((r48 & 1048576) == 0) goto L69;
        com.larus.bmhome.chat.layout.holder.image.p r20 = null;
    L71:
        if ((r48 & 4194304) == 0) goto L73;
        Function1 r21 = null;
    L75:
        if ((r48 & 8388608) == 0) goto L77;
        Function4 r22 = null;
    L79:
        if ((r48 & 16777216) == 0) goto L81;
        Function1 r23 = null;
    L83:
        if ((r48 & 33554432) == 0) goto L85;
        Function0 r1 = null;
    L86:
        this.a = r25;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = null;
        this.f = r6;
        this.g = r7;
        this.h = r31;
        this.i = r9;
        this.j = null;
        this.k = r10;
        this.l = r11;
        this.m = r12;
        this.n = r13;
        this.o = r14;
        this.p = r15;
        this.q = r8;
        this.r = r17;
        this.s = r18;
        this.t = r19;
        this.u = r20;
        this.v = null;
        this.w = r21;
        this.x = r22;
        this.y = r23;
        this.z = r1;
        return;
    L85:
        r1 = r47;
        goto L86
    L81:
        r23 = r46;
        goto L83
    L77:
        r22 = r45;
        goto L79
    L73:
        r21 = r44;
        goto L75
    L69:
        r20 = r43;
        goto L71
    L65:
        r19 = r42;
        goto L67
    L61:
        r18 = r41;
        goto L63
    L57:
        r17 = r40;
        goto L59
    L53:
        r8 = r39;
        goto L55
    L49:
        r15 = r38;
        goto L51
    L45:
        r14 = r37;
        goto L47
    L41:
        r13 = r36;
        goto L43
    L37:
        r12 = r35;
        goto L39
    L33:
        r11 = r34;
        goto L35
    L29:
        r10 = r33;
        goto L31
    L25:
        r9 = r32;
        goto L27
    L21:
        r7 = r30;
        goto L23
    L17:
        r6 = r29;
        goto L19
    L13:
        r5 = r28;
        goto L15
    L9:
        r4 = r27;
        goto L11
    L5:
        r2 = r26;
        goto L7
    }
}
