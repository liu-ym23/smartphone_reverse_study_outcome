package ke8;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.bmhome.chat.layout.widget.ThreeLoadingIndicator;
import com.larus.bmhome.chat.layout.widget.v0;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends le8.a<he8.a> {
    public final Lazy b;
    public ThreeLoadingIndicator c;
    public Boolean d;

    @Override // le8.a
    public final void b() {
        this.a = null;
        ThreeLoadingIndicator r1 = this.c;
        if (r1 == null) goto L5;
        r1.a();
    L5:
        this.c = null;
        this.d = null;
    }

    private final TextView getTextView() {
        return (TextView) this.b.getValue();
    }

    public b(final Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.b = LazyKt.lazy(new a(r4));
        getTextView().setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        addView(getTextView());
        TextView r5 = getTextView();
        r5.setTextSize(0, we8.a.a(i5.t(), false));
        r5.setLineSpacing(0.0f, 1.1f);
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
    L6:
        if (r7 == null) goto L9;
        r7.setMarginStart(c7.b(16));
        r7.setMarginEnd(c7.b(16));
        r7.bottomMargin = c7.b(12);
        r7.topMargin = c7.b(12);
        return;
    L9:
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // le8.b
    public final void a(ie8.a r9) {
        Intrinsics.checkNotNullParameter(r9, "state");
        SpannableStringBuilder r10 = new SpannableStringBuilder("\u200b");
        ThreeLoadingIndicator r0 = this.c;
        if (r0 != null) goto L5;
    L9:
        r0 = new ThreeLoadingIndicator(getTextView(), 2131240017, getTextView().getContext(), null);
    L10:
        this.c = r0;
        this.d = Boolean.FALSE;
        Iterator<T> r1 = r0.b.iterator();
    L11:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L23;
        v0 r2 = (v0) r1.next();
        if (r2 == null) goto L19;
        Drawable r5 = r2.getDrawable();
        if (r5 == null) goto L19;
        int r6 = (int) (i5.r0() * 1.0f);
        r5.setBounds(0, 0, r6, r6);
    L19:
        if (r10.length() == 0) goto L22;
        r3 = false;
    L22:
        r2.f = r3;
        r10.append("⚫", r2, 17);
        goto L11
    L23:
        r0.b(true);
        r0.d();
        getTextView().setText(r10);
        return;
    L5:
        if (Intrinsics.areEqual(this.d, Boolean.FALSE) == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        goto L9
    }
}
