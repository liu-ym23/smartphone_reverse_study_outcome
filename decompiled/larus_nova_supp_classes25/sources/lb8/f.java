package lb8;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.im.bean.message.Message;
import java.util.List;
import kc8.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f extends FrameLayout implements hb8.a {
    public final hk9.a a;
    public boolean b;
    public Integer c;
    public h d;

    @Override // hb8.a
    public final void f() {
        this.a.a();
        this.b = false;
        this.c = null;
        this.d = null;
    }

    public f(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        int r0 = ra8.a.a;
        hk9.a r5 = ra8.a.a(r4);
        addView(r5, new FrameLayout.LayoutParams(-1, -2));
        this.a = r5;
    }

    /* JADX WARN: Type inference failed for: r11v0, types: [lb8.e] */
    private final void setupPassData(g r53) {
        tb8.a r1 = new tb8.a(new c(this), new d(this), null, new e(this), r53.c, r53.d, 4);
        this.a.b(tb8.a.class, r1);
        kc8.b r2 = r53.e;
        this.a.b(kc8.b.class, r2);
        int r3 = com.larus.bmhome.chat.markdown.imagetool.f.a;
        Context r4 = getContext();
        Message r0 = r53.b;
        if (r0 != null) goto L5;
        r0 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L5:
        Message r5 = r0;
        if (r2 == null) goto L10;
        y r6 = r2.a;
        if (r6 == null) goto L10;
        Integer r7 = r6.j;
    L11:
        Integer r8 = r7;
        boolean r9 = false;
        if (r2 == null) goto L16;
        y r10 = r2.a;
        if (r10 == null) goto L16;
        boolean r11 = Intrinsics.areEqual(r10.i, Boolean.TRUE);
    L17:
        Boolean r12 = Boolean.valueOf(r11);
        if (r2 == null) goto L22;
        y r13 = r2.a;
        if (r13 == null) goto L22;
        r9 = Intrinsics.areEqual(r13.h, Boolean.TRUE);
    L22:
        int r14 = com.larus.bmhome.chat.markdown.imagetool.f.a(r4, r5, r8, r12, Boolean.valueOf(r9), this);
        this.a.b(cd8.a.class, new cd8.a(r14, -1));
        return;
    L16:
        r11 = false;
    L10:
        r7 = null;
        goto L11
    }

    public final void a(g r5, h r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r6, "output");
        this.d = r6;
        setupPassData(r5);
        int r7 = ra8.a.a;
        hk9.a r8 = this.a;
        List<jc8.a> r0 = r5.a;
        Integer r2 = null;
        if (r5.f == false) goto L5;
    L14:
        boolean r1 = true;
    L15:
        ra8.a.e(r8, r0, r1);
        this.b = r5.c;
        Message r9 = r5.b;
        if (r9 == null) goto L18;
        r2 = Integer.valueOf(r9.getMessageStatusLocal());
    L18:
        this.c = r2;
        return;
    L5:
        if (this.b != r5.c) goto L14;
        Integer r3 = this.c;
        Message r4 = r5.b;
        if (r4 == null) goto L9;
        Integer r10 = Integer.valueOf(r4.getMessageStatusLocal());
    L11:
        if (Intrinsics.areEqual(r3, r10) == false) goto L14;
        r1 = false;
        goto L15
    L9:
        r10 = null;
        goto L11
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        if (getVisibility() != 8) goto L5;
        int r4 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    L6:
        super.onMeasure(r2, r4);
        return;
    L5:
        r4 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        goto L6
    }
}
