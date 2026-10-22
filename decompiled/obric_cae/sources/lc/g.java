package lc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.cae.R;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f9230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f9231b;

    public g(Context r8) {
        i.f(r8, "context");
        super(r8, null, 0);
        View r10 = LayoutInflater.from(r8).inflate(R.layout.o_settings_trailing_view_2, this, false);
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-1, -2);
        r11.gravity = 8388629;
        addView(r10, r11);
        View r12 = findViewById(R.id.trailingText);
        i.e(r12, "findViewById(R.id.trailingText)");
        this.f9230a = (TextView) r12;
        View r13 = findViewById(R.id.trailingImage);
        i.e(r13, "findViewById(R.id.trailingImage)");
        ImageView r14 = (ImageView) r13;
        this.f9231b = r14;
        r14.setImageDrawable(r8.getDrawable(R.drawable.ic_arrow_forward_list_item));
    }

    public final ImageView getIconImageView() {
        return this.f9231b;
    }

    public final TextView getTextView() {
        return this.f9230a;
    }

    public final void setIconImageView(ImageView r8) {
        i.f(r8, "<set-?>");
        this.f9231b = r8;
    }

    public final void setTextView(TextView r8) {
        i.f(r8, "<set-?>");
        this.f9230a = r8;
    }

    public final void setTrailingImage(Drawable r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.f9231b.setImageDrawable(r8);
    }

    public final void setTrailingText(String r8) {
        i.f(r8, "text");
        this.f9230a.setText(r8);
    }
}
