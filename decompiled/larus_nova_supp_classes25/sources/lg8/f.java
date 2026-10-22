package lg8;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.auth.model.PluginAuth;
import com.larus.bmhome.chat.auth.model.PluginAuthType;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.view.MessagePluginAuthView;
import com.larus.bmhome.view.r3;
import com.larus.bmhome.view.s3;
import com.larus.bmhome.view.t3;
import com.larus.chat.common.databinding.LarusViewMessagePluginAuthBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f extends bd8.b {
    public MessagePluginAuthView l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public Message q;

    public static final class a {
    }

    static {
    }

    @Override // bd8.b
    public final void C() {
        MessagePluginAuthView r0 = this.l;
        if (r0 == null) goto L6;
        e1.o(r0);
        return;
    }

    public f(int r2) {
        super(true, r2);
        this.m = LazyKt.lazy(new lg8.a(this));
        this.n = LazyKt.lazy(new b(this));
        this.o = LazyKt.lazy(new c(this));
        this.p = LazyKt.lazy(new d(this));
    }

    @Override // bd8.b
    public final boolean G(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return K(r2);
    }

    public final boolean K(Message r5) {
        boolean r0 = h.b(this.e, r5);
        hc8.c r1 = hc8.c.a;
        boolean r2 = r1.j(r5);
        int r3 = 0;
        if (r0 == false) goto L27;
        if (r2 == false) goto L27;
        q0 r6 = this.e;
        if (r6 == null) goto L25;
        List r7 = r6.getCurrentList();
        if (r7 == null) goto L43;
        Iterator r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L44;
        Object r4 = r8.next();
        int r9 = r3 + 1;
        if (r3 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        Message r10 = (Message) r4;
        if (r3 == 0) goto L24;
        if (hc8.c.a.a(r10) == false) goto L24;
        u7 r11 = (u7) this.m.getValue();
        if (r11 == null) goto L23;
        r11.vv(r10);
    L23:
        FLogger.a.i("MessagePluginAuthComponent", "show final one auth and others should hide");
    L24:
        r3 = r9;
        goto L12
    L44:
        return true;
    L43:
        return true;
    L25:
        return true;
    L27:
        MessagePluginAuthView r12 = this.l;
        if (r12 == null) goto L30;
        e1.o(r12);
    L30:
        if (r0 == false) goto L32;
    L38:
        return false;
    L32:
        if (r1.j(r5) == false) goto L38;
        if (r1.a(r5) == false) goto L38;
        u7 r13 = (u7) this.m.getValue();
        if (r13 == null) goto L38;
        r13.vv(r5);
        goto L38
    }

    @Override // bd8.b
    public final void v(Message r12) {
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r12, "message");
        Message r13 = this.q;
        if (r13 == null) goto L58;
        y r0 = (y) this.p.getValue();
        if (r0 == null) goto L55;
        BotModel r1 = r0.j0();
        if (r1 == null) goto L59;
        boolean r2 = h.b(this.e, r13);
        hc8.c r3 = hc8.c.a;
        boolean r4 = r3.j(r13);
        if (r2 == false) goto L56;
        if (r4 == false) goto L60;
        String r5 = r1.getBotId();
        String r6 = "";
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        if (r3.e(r13, r5) == true) goto L61;
        PluginAuth r7 = r3.h(r13);
        if (r7 == null) goto L62;
        String r8 = r7.pluginId;
        if (r8 == null) goto L63;
        String r9 = r1.getBotId();
        if (r9 != null) goto L29;
        r9 = "";
    L29:
        hc8.a r10 = r3.f(r9);
        if (r10 == null) goto L57;
        String r11 = r13.getMessageId();
        if (r11 != null) goto L34;
        r11 = "";
    L34:
        String r14 = r13.getConversationId();
        if (r14 != null) goto L37;
        String r15 = "";
    L38:
        String r16 = r7.pluginName;
        if (r16 != null) goto L41;
        String r17 = "";
    L42:
        ChatParam r18 = (ChatParam) this.o.getValue();
        if (r18 == null) goto L45;
        String r19 = r18.c;
    L46:
        if (r19 != null) goto L48;
        String r20 = "";
    L49:
        String r110 = r1.getBotId();
        if (r110 == null) goto L53;
        r6 = r110;
    L53:
        r10.a(r11, r15, r17, r8, r20, r3.k(r6, r8));
        return;
    L48:
        r20 = r19;
        goto L49
    L45:
        r19 = null;
        goto L46
    L41:
        r17 = r16;
        goto L42
    L37:
        r15 = r14;
        goto L38
    L57:
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L56:
        return;
    L59:
        return;
    L55:
        return;
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object, lg8.e] */
    @Override // bd8.b
    public final void w(final Message r72, int r73, ec8.b r74) {
        Intrinsics.checkNotNullParameter(r72, "message");
        Intrinsics.checkNotNullParameter(r72, "message");
        y r2 = (y) this.p.getValue();
        if (r2 == null) goto L6;
        final BotModel r3 = r2.j0();
        if (r3 == null) goto L6;
    L11:
        if (K(r72) == false) goto L152;
        q0 r4 = this.e;
        RoundTextView r5 = null;
        if (r4 == null) goto L16;
        final Message r6 = r4.C7(r72);
    L17:
        hc8.c r7 = hc8.c.a;
        String r8 = r3.getBotId();
        if (r8 != null) goto L21;
        r8 = "";
    L21:
        if (r7.e(r72, r8) == false) goto L23;
        J(r72, r6, r3, PluginAuthType.Once);
        goto L152
    L23:
        boolean r9 = true;
        if (AppHost.a.isOversea() == true) goto L26;
    L28:
        boolean r10 = false;
    L29:
        MessagePluginAuthView r11 = this.l;
        if (r11 == null) goto L152;
        de8.c r12 = (de8.c) this.n.getValue();
        if (r12 == null) goto L34;
        Integer r13 = r12.m();
    L35:
        ?? r14 = new e(this, r72, r6, r3);
        Intrinsics.checkNotNullParameter(r14, "clickListener");
        if (r13 != null) goto L39;
        r9 = false;
    L39:
        if (r10 == false) goto L43;
        LarusViewMessagePluginAuthBinding r15 = r11.a;
        if (r15 == null) goto L46;
        RoundTextView r16 = r15.c;
    L48:
        if ((r16 instanceof RoundTextView) == true) goto L51;
        r16 = null;
    L51:
        int r17 = 2131103298;
        if (r16 == null) goto L62;
        Resources r18 = r16.getContext().getResources();
        if (r9 == false) goto L56;
        int r19 = 2131103298;
    L57:
        r16.setBackgroundColor(r18.getColor(r19));
        if (r13 == null) goto L60;
        int r20 = r13.intValue();
    L61:
        r16.setTextColor(r20);
        goto L62
    L60:
        r20 = r16.getContext().getResources().getColor(2131103298);
        goto L61
    L56:
        r19 = v19.c.b(2130972123, r16.getContext(), 2131103203);
    L62:
        if (r10 == false) goto L66;
        LarusViewMessagePluginAuthBinding r21 = r11.a;
        if (r21 == null) goto L69;
        RoundTextView r22 = r21.i;
    L71:
        if ((r22 instanceof RoundTextView) == true) goto L74;
        r22 = null;
    L74:
        int r23 = 2131106537;
        if (r22 == null) goto L85;
        Resources r110 = r22.getContext().getResources();
        if (r9 == false) goto L79;
        int r111 = 2131106537;
    L80:
        r22.setBackgroundColor(r110.getColor(r111));
        Resources r112 = r22.getContext().getResources();
        if (r9 == false) goto L83;
        int r113 = 2131103298;
    L84:
        r22.setTextColor(r112.getColor(r113));
        goto L85
    L83:
        r113 = v19.c.b(2130972079, r22.getContext(), 2131103136);
        goto L84
    L79:
        r111 = v19.c.b(2130970529, r22.getContext(), 2131102529);
    L85:
        if (r10 == false) goto L89;
        LarusViewMessagePluginAuthBinding r24 = r11.a;
        if (r24 == null) goto L92;
        RoundTextView r25 = r24.g;
    L94:
        if ((r25 instanceof RoundTextView) == true) goto L97;
        r25 = null;
    L97:
        if (r25 == null) goto L107;
        Resources r114 = r25.getContext().getResources();
        if (r9 == false) goto L101;
        int r115 = 2131106537;
    L102:
        r25.setBackgroundColor(r114.getColor(r115));
        Resources r116 = r25.getContext().getResources();
        if (r9 == true) goto L106;
        r17 = v19.c.b(2130972079, r25.getContext(), 2131103136);
    L106:
        r25.setTextColor(r116.getColor(r17));
        goto L107
    L101:
        r115 = v19.c.b(2130970529, r25.getContext(), 2131102529);
    L107:
        LarusViewMessagePluginAuthBinding r26 = r11.a;
        if (r26 == null) goto L116;
        View r27 = r26.j;
        if (r27 == null) goto L116;
        Resources r28 = r11.getContext().getResources();
        if (r9 == true) goto L115;
        r23 = v19.c.b(2130972087, null, 2131103162);
    L115:
        r27.setBackgroundColor(r28.getColor(r23));
    L116:
        LarusViewMessagePluginAuthBinding r29 = r11.a;
        if (r29 == null) goto L122;
        if (r10 == false) goto L121;
        e1.o(r29.d);
        e1.x(r29.e);
        goto L122
    L121:
        e1.x(r29.d);
        e1.o(r29.e);
    L122:
        e1.x(r11);
        if (r10 == false) goto L127;
        LarusViewMessagePluginAuthBinding r30 = r11.a;
        if (r30 == null) goto L130;
        RoundTextView r31 = r30.c;
    L131:
        if (r31 == null) goto L133;
        e1.d(r31, new r3(r14, r11));
    L133:
        if (r10 == false) goto L137;
        LarusViewMessagePluginAuthBinding r32 = r11.a;
        if (r32 == null) goto L140;
        RoundTextView r33 = r32.i;
    L141:
        if (r33 == null) goto L143;
        e1.d(r33, new s3(r14, r11));
    L143:
        if (r10 == false) goto L147;
        LarusViewMessagePluginAuthBinding r34 = r11.a;
        if (r34 == null) goto L150;
        r5 = r34.g;
    L150:
        if (r5 == null) goto L152;
        e1.d(r5, new t3(r14, r11));
        goto L152
    L147:
        LarusViewMessagePluginAuthBinding r35 = r11.a;
        if (r35 == null) goto L150;
        r5 = r35.f;
    L140:
        r33 = null;
        goto L141
    L137:
        LarusViewMessagePluginAuthBinding r36 = r11.a;
        if (r36 == null) goto L140;
        r33 = r36.h;
    L130:
        r31 = null;
        goto L131
    L127:
        LarusViewMessagePluginAuthBinding r37 = r11.a;
        if (r37 == null) goto L130;
        r31 = r37.b;
    L92:
        r25 = null;
        goto L94
    L89:
        LarusViewMessagePluginAuthBinding r38 = r11.a;
        if (r38 == null) goto L92;
        r25 = r38.f;
    L69:
        r22 = null;
        goto L71
    L66:
        LarusViewMessagePluginAuthBinding r39 = r11.a;
        if (r39 == null) goto L69;
        r22 = r39.h;
    L46:
        r16 = null;
        goto L48
    L43:
        LarusViewMessagePluginAuthBinding r40 = r11.a;
        if (r40 == null) goto L46;
        r16 = r40.b;
        goto L48
    L34:
        r13 = null;
        goto L35
    L26:
        if (StringsKt.contains$default(Locale.getDefault().getLanguage(), Locale.CHINA.getLanguage(), false, 2, null) == true) goto L28;
        r10 = true;
        goto L29
    L16:
        r6 = null;
    L152:
        this.q = r72;
        return;
    L6:
        String r41 = r72.getSenderId();
        if (r41 != null) goto L9;
        r41 = "unknown";
    L9:
        r3 = new BotModel(r41, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L11
    }

    public final void J(Message r19, Message r20, BotModel r21, PluginAuthType r22) {
        hc8.c r7 = hc8.c.a;
        PluginAuth r9 = r7.h(r19);
        if (r9 != null) goto L5;
        return;
    L5:
        String r14 = r9.pluginId;
        if (r14 != null) goto L8;
        return;
    L8:
        String r1 = r21.getBotId();
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        PluginAuthType r16 = r7.k(r1, r14);
        r7.g(r19, r20, r21, r22, (u7) this.m.getValue());
        String r2 = r21.getBotId();
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        hc8.a r3 = r7.f(r2);
        if (r3 == null) goto L37;
        String r4 = r19.getMessageId();
        if (r4 != null) goto L19;
        String r11 = "";
    L20:
        String r5 = r19.getConversationId();
        if (r5 != null) goto L23;
        String r12 = "";
    L24:
        String r6 = r9.pluginName;
        if (r6 != null) goto L27;
        String r13 = "";
    L28:
        ChatParam r8 = (ChatParam) this.o.getValue();
        if (r8 == null) goto L31;
        String r10 = r8.c;
    L32:
        if (r10 != null) goto L34;
        String r15 = "";
    L35:
        r3.b(r11, r12, r13, r14, r15, r16, r22);
        return;
    L34:
        r15 = r10;
        goto L35
    L31:
        r10 = null;
        goto L32
    L27:
        r13 = r6;
        goto L28
    L23:
        r12 = r5;
        goto L24
    L19:
        r11 = r4;
        goto L20
    }

    @Override // bd8.b
    public final List<View> x(int r2, Context r3, BaseMessageListCell<?> r4, i r5, q0 r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.x(r2, r3, r4, r5, r6, r7);
        MessagePluginAuthView r8 = new MessagePluginAuthView(r3, null, 6, 0);
        int r9 = i5.q();
        int r10 = i5.h();
        int r11 = i5.q();
        r8.setPadding(r9, r10, i5.q(), r11);
        e1.o(r8);
        if (r5 == null) goto L5;
        r5.addView(r8, r2);
    L5:
        this.l = r8;
        return CollectionsKt.listOf(r8);
    }
}
