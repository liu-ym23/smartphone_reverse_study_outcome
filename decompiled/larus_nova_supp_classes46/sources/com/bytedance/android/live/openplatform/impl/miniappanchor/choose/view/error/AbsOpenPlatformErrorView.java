package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.error;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import op0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/view/error/AbsOpenPlatformErrorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getLayoutId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsOpenPlatformErrorView extends ConstraintLayout {
    public ImageView a;
    public TextView b;
    public TextView c;

    public abstract int getLayoutId();

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        setVisibility(8);
    }

    public AbsOpenPlatformErrorView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void S5(String r10) {
        Intrinsics.checkNotNullParameter(r10, "errorTips");
        Intrinsics.checkNotNullParameter(r10, "errorTips");
        T5(new a(true, 2131252370, true, r10, false, "", null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5(a r5) {
        Intrinsics.checkNotNullParameter(r5, "errorViewConfig");
        setVisibility(0);
        if (r5.a == false) goto L10;
        ImageView r1 = this.a;
        if (r1 == null) goto L7;
        r1.setVisibility(0);
    L7:
        ImageView r2 = this.a;
        if (r2 == null) goto L14;
        r2.setImageResource(r5.b);
    L14:
        if (r5.c == false) goto L21;
        TextView r3 = this.b;
        if (r3 == null) goto L18;
        r3.setVisibility(0);
    L18:
        TextView r4 = this.b;
        if (r4 == null) goto L25;
        r4.setText(r5.d);
    L25:
        if (r5.e == false) goto L35;
        TextView r6 = this.c;
        if (r6 == null) goto L29;
        r6.setVisibility(0);
    L29:
        TextView r0 = this.c;
        if (r0 == null) goto L32;
        r0.setText(r5.f);
    L32:
        TextView r7 = this.c;
        if (r7 == null) goto L39;
        r7.setOnClickListener(r5.g);
        return;
    L39:
        return;
    L35:
        TextView r8 = this.c;
        if (r8 == null) goto L41;
        r8.setVisibility(8);
        return;
    L41:
        return;
    L21:
        TextView r9 = this.b;
        if (r9 == null) goto L25;
        r9.setVisibility(8);
        goto L25
    L10:
        ImageView r10 = this.a;
        if (r10 == null) goto L14;
        r10.setVisibility(8);
        goto L14
    }

    public final void U5(View.OnClickListener r10) {
        String r4 = s1.B(2131920376);
        Intrinsics.checkNotNullParameter(r4, "errorTips");
        String r6 = s1.B(2131920377);
        Intrinsics.checkNotNullParameter(r6, "errorButtonTips");
        T5(new a(true, 2131252378, true, r4, true, r6, r10));
    }

    public AbsOpenPlatformErrorView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbsOpenPlatformErrorView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(getLayoutId(), this);
        this.a = (ImageView) findViewById(2131371758);
        this.b = (TextView) findViewById(2131371775);
        this.c = (TextView) findViewById(2131371749);
        setVisibility(8);
    }
}
