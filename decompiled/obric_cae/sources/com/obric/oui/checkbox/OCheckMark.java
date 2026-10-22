package com.obric.oui.checkbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.cae.R;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public class OCheckMark extends AppCompatImageView implements Checkable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Drawable f6267n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6268o;

    public OCheckMark(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        i.f(r10, "attrs");
        super(r8, r10);
        Drawable r11 = getResources().getDrawable(R.drawable.o_card_list_item_tail_icon_mark);
        this.f6267n = r11;
        this.f6268o = true;
        i.e(r11, "markDrawable");
        setMinimumWidth(r11.getMinimumWidth());
        setMinimumHeight(r11.getMinimumHeight());
        setBackgroundDrawable(r11);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f6268o;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r8) {
        if (this.f6268o != r8) goto L5;
        return;
    L5:
        this.f6268o = r8;
        if (r8 == false) goto L8;
        Drawable r10 = this.f6267n;
    L9:
        setBackgroundDrawable(r10);
        invalidate();
        return;
    L8:
        r10 = null;
        goto L9
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f6268o);
    }
}
