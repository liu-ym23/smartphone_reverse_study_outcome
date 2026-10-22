package com.obric.oui.checkbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rB!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\t\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/checkbox/OCheckMark;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "", "checked", "", "setChecked", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OCheckMark extends AppCompatImageView implements Checkable {
    public final Drawable a;
    public boolean b;

    /* JADX WARN: Multi-variable type inference failed */
    public final void init() {
        setMinimumWidth(this.a.getMinimumWidth());
        setMinimumHeight(this.a.getMinimumHeight());
        setBackgroundDrawable(this.a);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.b);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OCheckMark(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = getResources().getDrawable(2131244115);
        this.b = true;
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        if (this.b != r2) goto L5;
        return;
    L5:
        this.b = r2;
        if (r2 == false) goto L8;
        Drawable r3 = this.a;
    L9:
        setBackgroundDrawable(r3);
        invalidate();
        return;
    L8:
        r3 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OCheckMark(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.a = getResources().getDrawable(2131244115);
        this.b = true;
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OCheckMark(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        this.a = getResources().getDrawable(2131244115);
        this.b = true;
        init();
    }
}
