package yw1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends LinearLayout {
    public final CheckedTextView a;
    public final ImageView b;

    public a(Context r2) {
        super(r2);
        LinearLayout.inflate(r2, 2131566407, this);
        this.a = (CheckedTextView) findViewById(2131389784);
        this.b = (ImageView) findViewById(2131389782);
    }

    public void setChecked(boolean r2) {
        this.a.setChecked(r2);
        if (r2 == false) goto L5;
        this.a.setTypeface(Typeface.DEFAULT_BOLD);
        this.b.setVisibility(0);
        return;
    L5:
        this.a.setTypeface(Typeface.DEFAULT);
        this.b.setVisibility(8);
    }

    public void setIndicatorWidth(int r2) {
        ViewGroup.LayoutParams r0 = this.b.getLayoutParams();
        r0.width = r2;
        this.b.setLayoutParams(r0);
    }

    public void setText(String r2) {
        this.a.setText(r2);
    }

    public void setTextColor(ColorStateList r2) {
        this.a.setTextColor(r2);
    }
}
