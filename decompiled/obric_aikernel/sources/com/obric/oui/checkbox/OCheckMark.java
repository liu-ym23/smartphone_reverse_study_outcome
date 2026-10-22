package com.obric.oui.checkbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.apm6.util.constant.CommonConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u8.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\u0019\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0011\u0010\u0015B!\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0011\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\nR\u001e\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/checkbox/OCheckMark;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "checked", "setChecked", "isChecked", "toggle", "Z", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "markDrawable", "Landroid/graphics/drawable/Drawable;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OCheckMark extends AppCompatImageView implements Checkable {
    private boolean isChecked;
    private Drawable markDrawable;

    public OCheckMark(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.markDrawable = getResources().getDrawable(e.o_card_list_item_tail_icon_mark);
        this.isChecked = true;
        init();
    }

    public OCheckMark(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "attrs");
        super(r10, r11);
        this.markDrawable = getResources().getDrawable(e.o_card_list_item_tail_icon_mark);
        this.isChecked = true;
        init();
    }

    public OCheckMark(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "attrs");
        super(r10, r11, r12);
        this.markDrawable = getResources().getDrawable(e.o_card_list_item_tail_icon_mark);
        this.isChecked = true;
        init();
    }

    private final void init() {
        Drawable r10 = this.markDrawable;
        Intrinsics.checkNotNullExpressionValue(r10, "markDrawable");
        setMinimumWidth(r10.getMinimumWidth());
        Drawable r11 = this.markDrawable;
        Intrinsics.checkNotNullExpressionValue(r11, "markDrawable");
        setMinimumHeight(r11.getMinimumHeight());
        setBackgroundDrawable(this.markDrawable);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isChecked;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        if (this.isChecked != r10) goto L5;
        return;
    L5:
        this.isChecked = r10;
        if (r10 == false) goto L8;
        Drawable r11 = this.markDrawable;
    L9:
        setBackgroundDrawable(r11);
        invalidate();
        return;
    L8:
        r11 = null;
        goto L9
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.isChecked);
    }
}
