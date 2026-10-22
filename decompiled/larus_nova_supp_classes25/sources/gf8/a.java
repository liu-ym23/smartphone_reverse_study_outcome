package gf8;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.chat.layout.holder.helper.v1;
import com.larus.bmhome.chat.layout.holder.menu.item.n;
import com.larus.bmhome.chat.layout.holder.menu.item.n0;
import com.larus.bmhome.chat.layout.holder.menu.item.s0;
import com.larus.bmhome.chat.layout.holder.menu.item.w0;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements t0 {
    public a() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r1, Message r2, Function0<Message> r3, q0 r4, BotModel r5, e r6, q0.a r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r5, "chatBot");
        ArrayList r9 = new ArrayList();
        r9.add(s0.b());
        l0 r10 = w0.c();
        if (r10 == null) goto L5;
        r9.add(r10);
    L5:
        Intrinsics.checkNotNullParameter(r1, "context");
        r9.add(new i0(0, ContextCompat.getColor(r1, v19.c.b(2130972086, null, 2131103159))));
        r9.add(n0.a());
        r9.addAll(n.b(new n(), r1, r5, false, 8));
        v1.a(r9);
        v1.b(r9, r7);
        return r9;
    }
}
