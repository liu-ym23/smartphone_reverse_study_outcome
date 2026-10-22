package oob;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.keyboard.keyboard2.f;
import com.ss.android.lark.keyboard.utils.h;
import com.ss.android.lark.keyboard.widget.KBMenuContainerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends KBMenuContainerView {
    public final Function0<Unit> m;
    public View n;
    public int o;
    public int p;
    public int q;

    public static final class a implements f {
        public final int b;

        public a(Context r2) {
            this.b = y9c.d.d(r2, 2131166598);
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.f
        public final void a(KBMenuContainerView r3, List<? extends View> r4) {
            Intrinsics.checkNotNullParameter(r3, "container");
            Intrinsics.checkNotNullParameter(r4, "visibleChildViews");
            Iterator<T> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L10;
            View r6 = (View) r5.next();
            ViewGroup.LayoutParams r0 = r6.getLayoutParams();
            if (r0 == null) goto L9;
            ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
            r1.rightMargin = this.b;
            r6.setLayoutParams(r1);
            goto L4
        L9:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    /* JADX INFO: renamed from: oob.b$b, reason: collision with other inner class name */
    public static final class C0308b {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.widget.KBMenuContainerView
    public int getIconWidth() {
        return this.p;
    }

    @Override // com.ss.android.lark.keyboard.widget.KBMenuContainerView
    public int getSendWrapperWidth() {
        return this.q;
    }

    @Override // com.ss.android.lark.keyboard.widget.KBMenuContainerView
    public int getVerticalPadding() {
        return this.o;
    }

    public final void setBackViewVisibility$keyboard_biz_aa_release(int r2) {
        View r0 = this.n;
        if (r0 == null) goto L6;
        r0.setVisibility(r2);
        return;
    }

    @Override // com.ss.android.lark.keyboard.widget.KBMenuContainerView
    public void setIconWidth(int r1) {
        this.p = r1;
    }

    @Override // com.ss.android.lark.keyboard.widget.KBMenuContainerView
    public void setSendWrapperWidth(int r1) {
        this.q = r1;
    }

    @Override // com.ss.android.lark.keyboard.widget.KBMenuContainerView
    public void setVerticalPadding(int r1) {
        this.o = r1;
    }

    public b(Context r6, Function0 r7) {
        Intrinsics.checkNotNullParameter(null, "subIcons");
        Intrinsics.checkNotNullParameter(r7, "exitAction");
        super(r6, null, 0, 14);
        this.m = r7;
        LinkedList r8 = new LinkedList(null);
        this.o = y9c.d.d(r6, 2131166601);
        this.p = y9c.d.a(32);
        this.q = y9c.d.a(100);
        setOrientation(0);
        setGravity(8388627);
        AppCompatImageView r0 = h.a(getContext(), 2131376766, 2131237532);
        r0.setSelected(true);
        r0.setOnClickListener(new c(this));
        r0.setPadding(0, 0, y9c.d.d(getContext(), 2131166600), 0);
        r8.add(0, r0);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        View r2 = (View) r9.next();
        FrameLayout r3 = new FrameLayout(getContext());
        r3.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        r3.addView(r2);
        r1.add(r3);
        goto L4
    L6:
        this.n = (View) CollectionsKt.first(r1);
        Iterator r10 = r1.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        addView((FrameLayout) r10.next());
        goto L8
    L10:
        setOnClickListener(oob.a.a);
        setMenuLayoutManager(new a(r6));
    }
}
