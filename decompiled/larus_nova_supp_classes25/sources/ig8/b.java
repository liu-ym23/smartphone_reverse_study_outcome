package ig8;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.utils.r0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends bd8.b {
    public final Lazy l;

    public b() {
        super(false, -1);
        this.l = LazyKt.lazy(new a(this));
    }

    @Override // bd8.b
    public final void w(Message r72, int r73, ec8.b r74) {
        Intrinsics.checkNotNullParameter(r72, "message");
        Intrinsics.checkNotNullParameter(r72, "message");
        r0.a.a(2);
        AudioServiceDelegate.a.i0().h(r72);
        i r2 = this.d;
        if (r2 == null) goto L12;
        Context r3 = r2.getContext();
        if (r3 == null) goto L12;
        if (Intrinsics.areEqual(r72.getBizContentType(), "deep_search_card") == false) goto L12;
        i r4 = this.d;
        if (r4 == null) goto L12;
        r4.setBackground(e1.e(0.0f, ContextCompat.getColor(r3, v19.c.b(2130972364, r3, 2131103343))));
    L12:
        y r5 = (y) this.l.getValue();
        if (r5 == null) goto L16;
        BotModel r6 = r5.j0();
        if (r6 == null) goto L16;
    L20:
        hc8.c r7 = hc8.c.a;
        String r1 = r72.getConversationId();
        String r8 = "";
        if (r1 != null) goto L23;
        r1 = "";
    L23:
        String r9 = r6.getBotId();
        if (r9 == null) goto L27;
        r8 = r9;
    L27:
        r7.m(r1, r8);
        return;
    L16:
        String r10 = r72.getSenderId();
        if (r10 != null) goto L19;
        r10 = "unknown";
    L19:
        r6 = new BotModel(r10, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L20
    }
}
