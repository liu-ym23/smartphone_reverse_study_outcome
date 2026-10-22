package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.AnchorLinkTopViewConfirmationDialog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB%\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/MultiAnchorLinkInfoTopView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorLinkInfoTopView extends FrameLayout implements View.OnClickListener {
    public TextView a;
    public MultiAnchorLinkInfoTopSubView b;
    public MultiAnchorLinkInfoTopSubView c;
    public MultiAnchorLinkInfoTopSubView d;
    public MultiAnchorLinkInfoTopSubView e;
    public final CompositeDisposable f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567782, this, true);
        ImageView r1 = (ImageView) r0.findViewById(2131376365);
        TextView r2 = (TextView) r0.findViewById(2131390883);
        this.a = (TextView) r0.findViewById(2131391236);
        this.b = (MultiAnchorLinkInfoTopSubView) r0.findViewById(2131380419);
        this.c = (MultiAnchorLinkInfoTopSubView) r0.findViewById(2131380420);
        this.d = (MultiAnchorLinkInfoTopSubView) r0.findViewById(2131380421);
        this.e = (MultiAnchorLinkInfoTopSubView) r0.findViewById(2131380422);
        MultiAnchorLinkInfoTopSubView r3 = this.b;
        if (r3 == null) goto L5;
        r3.setOnClickListener(this);
    L5:
        MultiAnchorLinkInfoTopSubView r4 = this.c;
        if (r4 == null) goto L8;
        r4.setOnClickListener(this);
    L8:
        MultiAnchorLinkInfoTopSubView r5 = this.d;
        if (r5 == null) goto L11;
        r5.setOnClickListener(this);
    L11:
        MultiAnchorLinkInfoTopSubView r6 = this.e;
        if (r6 == null) goto L14;
        r6.setOnClickListener(this);
    L14:
        TextView r7 = this.a;
        if (r7 == null) goto L18;
        r7.setOnClickListener(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f.clear();
    }

    public MultiAnchorLinkInfoTopView(Context r1) {
        Intrinsics.checkNotNull(r1);
        super(r1);
        this.f = new CompositeDisposable();
        a();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        if (r4.getId() == 2131391236) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(null);
        new AnchorLinkTopViewConfirmationDialog(0, null, getContext());
        throw null;
    }

    public MultiAnchorLinkInfoTopView(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNull(r1);
        super(r1, r2);
        this.f = new CompositeDisposable();
        a();
    }

    public MultiAnchorLinkInfoTopView(Context r1, AttributeSet r2, int r3) {
        Intrinsics.checkNotNull(r1);
        super(r1, r2, r3);
        this.f = new CompositeDisposable();
        a();
    }
}
