package of8;

import android.view.View;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import dg8.t;
import kc8.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l implements z {
    public final wg8.f a;
    public final wg8.c b;
    public y c;
    public com.larus.bmhome.chat.layout.item.l d;
    public Message e;
    public q0 f;

    public l() {
        this.a = new wg8.f();
        this.b = new wg8.c();
    }

    @Override // kc8.z
    public final void a(View r5) {
        wg8.c r0 = this.b;
        Message r1 = this.e;
        if ((r5 instanceof CustomMarkdownTextView) == false) goto L5;
        CustomMarkdownTextView r6 = (CustomMarkdownTextView) r5;
    L6:
        int r2 = wg8.c.k;
        r0.a(r1, r6, 0);
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // kc8.z
    public final void b(View r81, st8.a r82, LongClickSource r83) {
        Intrinsics.checkNotNullParameter(r83, "longClickSource");
        y r2 = this.c;
        if (r2 == null) goto L8;
        BotModel r3 = r2.j0();
        if (r3 == null) goto L8;
    L7:
        BotModel r5 = r3;
        Message r4 = this.e;
        if (r4 != null) goto L19;
        return;
    L19:
        if (t.a(r4) == false) goto L21;
        return;
    L21:
        wg8.f r6 = this.a;
        if ((r81 instanceof CustomMarkdownTextView) == false) goto L24;
        CustomMarkdownTextView r7 = (CustomMarkdownTextView) r81;
    L25:
        if (r82 != null) goto L27;
        st8.a r8 = this.d;
    L28:
        wg8.f.a(r6, r4, r5, r7, r8, this.f, null, null, r83, 96);
        return;
    L27:
        r8 = r82;
        goto L28
    L24:
        r7 = null;
    L8:
        Message r9 = this.e;
        if (r9 == null) goto L11;
        String r10 = r9.getSenderId();
    L12:
        if (r10 != null) goto L14;
        r10 = "";
    L14:
        r3 = new BotModel(r10, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L7
    L11:
        r10 = null;
        goto L12
    }

    public final void update(y r1, Message r2, q0 r3) {
        this.c = r1;
        this.e = r2;
        this.f = r3;
    }
}
