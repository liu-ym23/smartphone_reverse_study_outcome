package nb8;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import sg8.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements a {
    public final bd8.b a;
    public final wg8.c b;
    public final wg8.f c;
    public Function0<Unit> d;
    public final Lazy e;

    @Override // nb8.a
    public final void onRefresh() {
        Function0<Unit> r0 = this.d;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    @Override // nb8.a
    public final void a(Message r4, ow8.a r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "view");
        wg8.c r0 = this.b;
        if ((r5 instanceof CustomMarkdownTextView) == false) goto L5;
        CustomMarkdownTextView r6 = (CustomMarkdownTextView) r5;
    L6:
        int r1 = wg8.c.k;
        r0.a(r4, r6, 0);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public c(b0 r2, wg8.c r3, wg8.f r4) {
        Intrinsics.checkNotNullParameter(r2, "baseComponent");
        Intrinsics.checkNotNullParameter(r3, "textCellClickProcessor");
        Intrinsics.checkNotNullParameter(r4, "textCellLongClickProcessor");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = LazyKt.lazy(new b(this));
    }

    @Override // nb8.a
    public final void b(Message r79, ow8.a r80, st8.a r81, LongClickSource r82) {
        Intrinsics.checkNotNullParameter(r79, "message");
        Intrinsics.checkNotNullParameter(r82, "longClickSource");
        com.larus.utils.l.c(r79, "need_filter_select", BooleanCompanionObject.INSTANCE);
        wg8.f r3 = this.c;
        y r4 = (y) this.e.getValue();
        if (r4 == null) goto L6;
        BotModel r5 = r4.j0();
        if (r5 == null) goto L6;
    L11:
        if ((r80 instanceof CustomMarkdownTextView) == false) goto L13;
        CustomMarkdownTextView r1 = (CustomMarkdownTextView) r80;
    L14:
        BotModel r6 = r5;
        wg8.f.a(r3, r79, r6, r1, r81, this.a.e, null, null, r82, 96);
        return;
    L13:
        r1 = null;
    L6:
        String r7 = r79.getSenderId();
        if (r7 != null) goto L9;
        r7 = "unknown";
    L9:
        r5 = new BotModel(r7, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L11
    }
}
