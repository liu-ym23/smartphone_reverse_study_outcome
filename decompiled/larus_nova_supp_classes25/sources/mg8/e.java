package mg8;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import by7.g;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.q;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lg8.h;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e extends bd8.b {
    public String l;
    public TextView m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;

    @Override // bd8.b
    public final void C() {
        TextView r0 = this.m;
        if (r0 == null) goto L6;
        e1.o(r0);
        return;
    }

    public e(int r2) {
        super(true, r2);
        this.n = LazyKt.lazy(new b(this));
        this.o = LazyKt.lazy(new c(this));
        this.p = LazyKt.lazy(new d(this));
    }

    @Override // bd8.b
    public final boolean G(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Map r3 = r2.getExt();
        if (r3 == null) goto L5;
        String r4 = (String) r3.get("need_auth_identity");
    L7:
        return Intrinsics.areEqual(r4, "1");
    L5:
        r4 = null;
        goto L7
    }

    public final boolean K(Message r3) {
        if (com.larus.bmhome.chat.bean.d.I0(r3) == false) goto L5;
    L20:
        return true;
    L5:
        if (r3.getMessageStatusLocal() != 21) goto L20;
        if (com.larus.bmhome.chat.bean.d.Q0(r3) == true) goto L20;
        if (h.b(this.e, r3) == false) goto L20;
        Map r0 = r3.getExt();
        if (r0 == null) goto L13;
        String r1 = (String) r0.get("need_auth_identity");
    L15:
        if (Intrinsics.areEqual(r1, "1") == false) goto L20;
        if (h.a(this.e, r3) == false) goto L20;
        return false;
    L13:
        r1 = null;
        goto L15
    }

    @Override // bd8.b
    public final void v(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r2, "message");
        L(r2, false);
    }

    public final void J(Message r6, BotModel r7) {
        i r0 = this.d;
        if (r0 == null) goto L8;
        Context r1 = r0.getContext();
        if (r1 == null) goto L9;
        q.a.e(r1, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", AppHost.a.d() + "/inapp/authentication?hide_title_bar=1&bot_id=" + r7.getBotId() + "&message_id=" + r6.getMessageId())}), null);
        return;
    L9:
        return;
    }

    public final void L(Message r3, boolean r4) {
        if (r4 == false) goto L4;
    L5:
        g r5 = g.d;
        JSONObject r0 = new JSONObject();
        r0.put("message_id", r3.getMessageId());
        y r6 = (y) this.p.getValue();
        if (r6 == null) goto L10;
        BotModel r7 = r6.j0();
        if (r7 == null) goto L10;
        String r8 = r7.getBotId();
    L11:
        r0.put("bot_id", r8);
        Unit r9 = Unit.INSTANCE;
        r5.onEvent("adult_validation_button_show", r0);
        return;
    L10:
        r8 = null;
        goto L11
    L4:
        if (K(r3) == false) goto L5;
    }

    @Override // bd8.b
    public final void w(final Message r72, int r73, ec8.b r74) {
        Intrinsics.checkNotNullParameter(r72, "message");
        Intrinsics.checkNotNullParameter(r72, "message");
        y r2 = (y) this.p.getValue();
        if (r2 == null) goto L6;
        final BotModel r3 = r2.j0();
        if (r3 == null) goto L6;
    L10:
        String r4 = null;
        if (K(r72) == false) goto L27;
        TextView r5 = this.m;
        if (r5 == null) goto L16;
        e1.o(r5);
    L16:
        if (r72.getMessageStatusLocal() == 20) goto L18;
        return;
    L18:
        if (h.b(this.e, r72) == false) goto L45;
        Map r6 = r72.getExt();
        if (r6 == null) goto L23;
        r4 = (String) r6.get("need_auth_identity");
    L23:
        if (Intrinsics.areEqual(r4, "1") == true) goto L25;
        return;
    L25:
        if (h.a(this.e, r72) == false) goto L47;
        this.l = r72.getMessageId();
        return;
    L47:
        return;
    L45:
        return;
    L27:
        TextView r7 = this.m;
        if (r7 == null) goto L30;
        e1.x(r7);
    L30:
        TextView r8 = this.m;
        if (r8 == null) goto L34;
        e1.d(r8, new a(this, r72, r3));
    L34:
        if (o0.d(com.larus.bmhome.chat.auth.o0.a) == false) goto L41;
        if (Intrinsics.areEqual(com.larus.bmhome.chat.auth.o0.a, r72.getMessageId()) == false) goto L41;
        if (AccountService.a.isLogin().booleanValue() == false) goto L41;
        com.larus.bmhome.chat.auth.o0.a = null;
        J(r72, r3);
    L41:
        if (Intrinsics.areEqual(this.l, r72.getMessageId()) == false) goto L49;
        L(r72, true);
        this.l = null;
        return;
    L49:
        return;
    L6:
        String r9 = r72.getSenderId();
        if (r9 != null) goto L9;
        r9 = "unknown";
    L9:
        r3 = new BotModel(r9, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L10
    }

    @Override // bd8.b
    public final List<View> x(int r2, Context r3, BaseMessageListCell<?> r4, i r5, q0 r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.x(r2, r3, r4, r5, r6, r7);
        TextView r8 = new TextView(r3);
        r8.setVisibility(8);
        r8.setBackgroundResource(v19.c.b(2130970790, r8.getContext(), 2131239542));
        r8.setTextSize(0, i5.q());
        r8.setTextColor(ContextCompat.getColor(r3, v19.c.b(2130972079, r3, 2131103136)));
        r8.setText(2131909999);
        r8.setGravity(17);
        r8.setTypeface(null, 1);
        this.m = r8;
        if (r5 == null) goto L6;
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-1, i5.c0());
        r9.bottomMargin = i5.q();
        r9.setMarginStart(i5.q());
        r9.setMarginEnd(i5.q());
        Unit r10 = Unit.INSTANCE;
        r5.addView(r8, r2, r9);
    L6:
        return CollectionsKt.listOf(r8);
    }
}
