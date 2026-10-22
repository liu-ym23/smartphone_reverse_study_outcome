package lb8;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.platform.spi.IAIChatControlTraceService;
import ib8.d0;
import kc8.y;
import kc8.z;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements a {
    public final Function0<kc8.b> a;
    public Function2<? super Boolean, ? super d0, Unit> b;

    @Override // lb8.a
    public final void b() {
        Function2<? super Boolean, ? super d0, Unit> r0 = this.b;
        if (r0 == null) goto L6;
        r0.invoke(Boolean.FALSE, new d0(true, "think_title"));
        return;
    }

    public b(com.larus.bmhome.block.holder.deepthink.h r2) {
        Intrinsics.checkNotNullParameter(r2, "blockDependConfigGetter");
        this.a = r2;
    }

    @Override // lb8.a
    public final void a(ow8.a r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        kc8.b r0 = (kc8.b) this.a.invoke();
        if (r0 == null) goto L14;
        y r1 = r0.a;
        if (r1 == null) goto L15;
        z r2 = r1.A;
        if (r2 != null) goto L9;
        return;
    L9:
        if ((r3 instanceof CustomMarkdownTextView) == false) goto L11;
        CustomMarkdownTextView r4 = (CustomMarkdownTextView) r3;
    L12:
        r2.a(r4);
        return;
    L11:
        r4 = null;
        goto L12
    L15:
        return;
    }

    @Override // lb8.a
    public final void c(ow8.a r3, st8.a r4, LongClickSource r5) {
        Intrinsics.checkNotNullParameter(r5, "longClickSource");
        LruCache r6 = ko8.a.a;
        CustomMarkdownTextView r0 = null;
        if ((r4 instanceof CustomMarkdownTextView) == false) goto L5;
        CustomMarkdownTextView r7 = (CustomMarkdownTextView) r4;
    L6:
        IAIChatControlTraceService.a.jb(r7);
        kc8.b r8 = (kc8.b) this.a.invoke();
        if (r8 == null) goto L17;
        y r9 = r8.a;
        if (r9 == null) goto L18;
        z r10 = r9.A;
        if (r10 != null) goto L13;
        return;
    L13:
        if ((r3 instanceof CustomMarkdownTextView) == false) goto L15;
        r0 = (CustomMarkdownTextView) r3;
    L15:
        r10.b(r0, r4, LongClickSource.Thinking);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r7 = null;
        goto L6
    }
}
