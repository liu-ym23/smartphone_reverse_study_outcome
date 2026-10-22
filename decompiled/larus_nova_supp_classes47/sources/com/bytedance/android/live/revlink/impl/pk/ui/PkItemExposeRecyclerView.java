package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0018\u0010\u001cB#\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0018\u0010\u001fJ\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PkItemExposeRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "setAdapter", "", "a", "Ljava/lang/String;", "getInviteIconPanelType", "()Ljava/lang/String;", "setInviteIconPanelType", "(Ljava/lang/String;)V", "inviteIconPanelType", "", "b", "Z", "getDisableScrollTouch", "()Z", "setDisableScrollTouch", "(Z)V", "disableScrollTouch", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defaultStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class PkItemExposeRecyclerView extends RecyclerView {
    public String a;
    public boolean b;
    public final HashSet<String> c;

    public static final class a implements ViewTreeObserver.OnScrollChangedListener {
        public final /* synthetic */ PkItemExposeRecyclerView a;

        public a(PkItemExposeRecyclerView r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            this.a.t();
        }
    }

    public final void r() {
        this.c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t() {
        Rect r0 = new Rect();
        if (isShown() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        int r2 = getChildCount();
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L47;
        View r4 = getChildAt(r3);
        if (r4 == null) goto L46;
        j r5 = getChildViewHolder(r4);
        RecyclerView.LayoutManager r6 = getLayoutManager();
        if ((r6 instanceof LinearLayoutManager) == true) goto L18;
        r6 = null;
    L18:
        LinearLayoutManager r7 = (LinearLayoutManager) r6;
        if (r7 == null) goto L21;
        int r8 = r7.getOrientation();
    L22:
        Rect r9 = new Rect();
        if (r4.isShown() == true) goto L25;
    L39:
        boolean r10 = false;
    L40:
        if (r10 == false) goto L46;
        if ((r5 instanceof j) == false) goto L46;
        j r12 = r5;
        String r13 = r12.G();
        if (this.c.contains(r13) == true) goto L46;
        r12.N(this.a);
        this.c.add(r12.G());
        goto L46
    L25:
        if (r4.getGlobalVisibleRect(r9) == false) goto L39;
        if (r8 == 1) goto L28;
    L30:
        boolean r14 = false;
    L31:
        if (r8 == 0) goto L33;
    L35:
        boolean r15 = false;
    L36:
        if (r14 == true) goto L38;
        if (r15 == false) goto L39;
    L38:
        r10 = true;
        goto L40
    L33:
        if (r9.width() <= (r4.getMeasuredWidth() / 2)) goto L35;
        r15 = true;
        goto L36
    L28:
        if (r9.height() <= (r4.getMeasuredHeight() / 2)) goto L30;
        r14 = true;
        goto L31
    L21:
        r8 = -1;
    L46:
        r3 = r3 + 1;
        goto L11
    L47:
        return;
    L5:
        if (getGlobalVisibleRect(r0) == false) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean getDisableScrollTouch() {
        return this.b;
    }

    public final String getInviteIconPanelType() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkItemExposeRecyclerView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = "";
        this.c = new HashSet();
        getViewTreeObserver().addOnScrollChangedListener(new a(this));
        addOnScrollListener(new AnonymousClass2(this));
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.b == false) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r2);
    }

    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.b == false) goto L7;
        return true;
    L7:
        return super.onTouchEvent(r2);
    }

    public void setAdapter(RecyclerView.Adapter<?> r2) {
        super.setAdapter(r2);
        if (r2 == null) goto L6;
        r2.registerAdapterDataObserver(new AnonymousClass1(this));
        return;
    }

    public final void setDisableScrollTouch(boolean r1) {
        this.b = r1;
    }

    public final void setInviteIconPanelType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkItemExposeRecyclerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = "";
        this.c = new HashSet();
        getViewTreeObserver().addOnScrollChangedListener(new a(this));
        addOnScrollListener(new AnonymousClass2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkItemExposeRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = "";
        this.c = new HashSet();
        getViewTreeObserver().addOnScrollChangedListener(new a(this));
        addOnScrollListener(new AnonymousClass2(this));
    }
}
