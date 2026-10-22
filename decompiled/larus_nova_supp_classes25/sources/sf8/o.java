package sf8;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.chat.layout.holder.helper.v1;
import com.larus.bmhome.chat.layout.holder.menu.item.n0;
import com.larus.bmhome.chat.layout.holder.menu.item.p;
import com.larus.bmhome.chat.layout.holder.menu.item.w0;
import com.larus.bmhome.chat.layout.holder.menu.item.x;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.bmhome.view.screenmenu.y;
import com.larus.home.impl.sdk.j1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o implements t0 {
    public o() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r3, Message r4, Function0<Message> r5, q0 r6, BotModel r7, wc9.e r8, q0.a r9, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r7, "chatBot");
        ArrayList r11 = new ArrayList();
        r11.add(new y(x.a(r4), p.a(r4)));
        Intrinsics.checkNotNullParameter(r3, "context");
        r11.add(new i0(0, ContextCompat.getColor(r3, v19.c.b(2130972086, null, 2131103159))));
        l0 r12 = w0.a(r4, r9);
        if (r12 == null) goto L5;
        r11.add(r12);
    L5:
        IFlowSdkDepend r13 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r13 == null) goto L10;
        r13.getCollectService();
        boolean r14 = true;
        if (j1.a.e() != true) goto L10;
    L11:
        if (r14 == true) goto L13;
    L18:
        r11.add(n0.a());
        r11.addAll(com.larus.bmhome.chat.layout.holder.menu.item.n.b(new com.larus.bmhome.chat.layout.holder.menu.item.n(), r3, r7, false, 8));
        v1.a(r11);
        v1.b(r11, r9);
        return com.larus.bmhome.chat.layout.holder.helper.e.b(r11);
    L13:
        if (com.larus.bmhome.utils.i.f(r8) == false) goto L18;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (com.larus.bmhome.chat.bean.d.x(r4).isCollected() == false) goto L17;
        r11.add(com.larus.bmhome.chat.layout.holder.menu.item.f.a());
        goto L18
    L17:
        r11.add(com.larus.bmhome.chat.layout.holder.menu.item.i.a());
    L10:
        r14 = false;
        goto L11
    }
}
