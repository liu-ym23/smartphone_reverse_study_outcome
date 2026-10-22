package rj8;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import by7.e;
import com.bytedance.android.live.multilink.impl.n0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cotdetail.list.processor.f;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.trace.tracknode.TraceFragment;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import qj8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public a a;
    public b b;

    public d() {
    }

    public final m a() {
        a r0 = this.a;
        if (r0 == null) goto L5;
        String r2 = r0.a;
    L6:
        if (r0 == null) goto L8;
        Message r3 = r0.b;
    L10:
        if (r0 == null) goto L12;
        boolean r5 = r0.c;
    L13:
        if (r0 == null) goto L15;
        Long r6 = r0.d;
    L16:
        if (r0 == null) goto L18;
        int r7 = r0.e;
    L19:
        if (r0 == null) goto L21;
        e r8 = r0.f;
    L22:
        if (r0 == null) goto L24;
        RecyclerView r9 = r0.g;
    L25:
        if (r0 == null) goto L28;
        Function0<BotModel> r10 = r0.h;
        if (r10 == null) goto L28;
    L29:
        if (r0 == null) goto L32;
        Function0<ChatParam> r11 = r0.i;
        if (r11 == null) goto L32;
    L33:
        if (r0 == null) goto L35;
        hh8.a r12 = r0.j;
    L36:
        if (r0 == null) goto L38;
        Function0<Map<String, Object>> r13 = r0.k;
    L39:
        if (r0 == null) goto L41;
        String r14 = r0.l;
    L42:
        if (r0 == null) goto L44;
        String r1 = r0.m;
    L45:
        String r17 = "";
        if (r1 != null) goto L48;
        String r18 = "";
    L49:
        if (r0 == null) goto L51;
        String r19 = r0.n;
    L52:
        if (r0 == null) goto L54;
        String r4 = r0.o;
    L55:
        if (r4 == null) goto L58;
        r17 = r4;
    L58:
        if (r0 == null) goto L60;
        boolean r20 = r0.p;
    L61:
        if (r0 == null) goto L63;
        boolean r21 = r0.q;
    L64:
        if (r0 == null) goto L66;
        Integer r22 = r0.r;
    L67:
        if (r0 == null) goto L69;
        Integer r23 = r0.s;
    L70:
        if (r0 == null) goto L72;
        q0 r24 = r0.t;
    L73:
        if (r0 == null) goto L75;
        q0.a r25 = r0.u;
    L76:
        if (r0 == null) goto L78;
        ry8.d r26 = r0.v;
    L79:
        if (r0 == null) goto L81;
        String r27 = r0.w;
    L82:
        if (r0 == null) goto L84;
        boolean r28 = r0.x;
    L85:
        if (r0 == null) goto L87;
        boolean r30 = r0.y;
    L88:
        if (r0 == null) goto L90;
        Integer r31 = r0.z;
    L91:
        if (r0 == null) goto L93;
        Integer r32 = r0.A;
    L94:
        if (r0 == null) goto L96;
        Function2<View, Message, Boolean> r33 = r0.B;
    L98:
        return new m(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r18, r19, r17, r20, r21, r22, r23, r24, r25, r26, r27, r28, r30, r31, r32, r33);
    L96:
        r33 = null;
        goto L98
    L93:
        r32 = null;
        goto L94
    L90:
        r31 = null;
        goto L91
    L87:
        r30 = false;
        goto L88
    L84:
        r28 = false;
        goto L85
    L81:
        r27 = null;
        goto L82
    L78:
        r26 = null;
        goto L79
    L75:
        r25 = null;
        goto L76
    L72:
        r24 = null;
        goto L73
    L69:
        r23 = null;
        goto L70
    L66:
        r22 = null;
        goto L67
    L63:
        r21 = false;
        goto L64
    L60:
        r20 = false;
        goto L61
    L54:
        r4 = null;
        goto L55
    L51:
        r19 = null;
        goto L52
    L48:
        r18 = r1;
        goto L49
    L44:
        r1 = null;
        goto L45
    L41:
        r14 = null;
        goto L42
    L38:
        r13 = null;
        goto L39
    L35:
        r12 = null;
    L32:
        r11 = new n0();
    L28:
        r10 = new n0();
        goto L29
    L24:
        r9 = null;
        goto L25
    L21:
        r8 = null;
        goto L22
    L18:
        r7 = 0;
        goto L19
    L15:
        r6 = null;
        goto L16
    L12:
        r5 = false;
        goto L13
    L8:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final String b() {
        a r0 = this.a;
        if (r0 == null) goto L5;
        e r1 = r0.f;
    L7:
        if ((r1 instanceof TraceFragment) == false) goto L9;
        TraceFragment r2 = (TraceFragment) r1;
    L10:
        if (r2 == null) goto L15;
        String r3 = r2.k();
        if (r3 == null) goto L15;
        return r3;
    L15:
        a r4 = this.a;
        if (r4 != null) goto L18;
        return null;
    L18:
        if ((r4.f instanceof f) == true) goto L21;
        r4 = null;
    L21:
        if (r4 != null) goto L23;
        return null;
    L23:
        return r4.l;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }
}
