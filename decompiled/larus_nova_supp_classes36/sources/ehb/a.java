package ehb;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.flow.feed.component.title.FlowTitleView;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends FeedCardComponent<b, FlowTitleView> {
    public final View a() {
        return new FlowTitleView(getContext());
    }

    public final ViewGroup.MarginLayoutParams b() {
        ViewGroup.MarginLayoutParams r0 = super.b();
        r0.width = 0;
        return r0;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.widget.FrameLayout, com.ss.android.lark.flow.feed.component.title.FlowTitleView, java.lang.Object] */
    public final void d(b r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        ?? r1 = (FlowTitleView) c();
        String r2 = r9.a;
        List<com.ss.android.lark.flow.feed.component.title.a> r3 = r9.b;
        boolean r4 = r9.c;
        int r10 = r9.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "titleText");
        Intrinsics.checkNotNullParameter(r3, "tags");
        com.ss.android.lark.flow.feed.component.title.b r5 = r1.getTitleViewComponent();
        com.ss.android.lark.flow.feed.component.title.b.C0048b r6 = new com.ss.android.lark.flow.feed.component.title.b.C0048b(r2, r4, r10);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "data");
        ((TextView) r5.c()).setTextSize(0, zz7.b.h(r5.getContext(), r6.c));
        if (r6.b == false) goto L5;
        ((TextView) r5.c()).setTypeface(Typeface.DEFAULT, 1);
    L5:
        ((TextView) r5.c()).setText(r6.a);
        Iterator<vdb.a> r11 = r1.c.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r1.removeView(r11.next().c());
        goto L7
    L9:
        r1.c.clear();
        Iterator<View> r12 = r1.d.iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        r1.removeView(r12.next());
        goto L11
    L13:
        r1.d.clear();
        if (r3.isEmpty() == true) goto L30;
        Iterator<T> r13 = r3.iterator();
    L18:
        if (r13.hasNext() == false) goto L43;
        com.ss.android.lark.flow.feed.component.title.a r7 = (com.ss.android.lark.flow.feed.component.title.a) r13.next();
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -2);
        r8.leftMargin = UIHelper.dp2px(6.0f);
        r8.gravity = 16;
        if ((r7 instanceof com.ss.android.lark.flow.feed.component.title.a.C0047a) == true) goto L21;
        if ((r7 instanceof com.ss.android.lark.flow.feed.component.title.a.b) == false) goto L29;
        com.ss.android.lark.flow.feed.component.title.a.b r14 = (com.ss.android.lark.flow.feed.component.title.a.b) r7;
        r1.d.add(r14.a);
        r1.addView(r14.a, r8);
        goto L18
    L29:
        throw new NoWhenBranchMatchedException();
    L21:
        vdb.a r15 = new vdb.a(r1.getContext());
        r1.c.add(r15);
        r1.addView(r15.c(), r8);
        Drawable r16 = ((com.ss.android.lark.flow.feed.component.title.a.C0047a) r7).a;
        Intrinsics.checkNotNullParameter(new vdb.a.b(r16), "data");
        if (r16 != null) goto L23;
        r15.c().setVisibility(8);
        goto L18
    L23:
        r15.c().setVisibility(0);
        r15.c().setImageDrawable(r16);
        goto L18
    L43:
        return;
    }
}
