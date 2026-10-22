package com.obric.oui.checkbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.common.oui.R$drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/checkbox/OCheckMark;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "checked", "", "setChecked", "(Z)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCheckMark extends AppCompatImageView implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f12317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12318b;

    public OCheckMark(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.f12317a = getResources().getDrawable(R$drawable.o_card_list_item_tail_icon_mark);
        this.f12318b = true;
        e();
    }

    public final void e() {
        Drawable r5 = this.f12317a;
        setMinimumWidth(r5.getMinimumWidth());
        setMinimumHeight(r5.getMinimumHeight());
        setBackgroundDrawable(r5);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f12318b;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r5) {
        if (this.f12318b != r5) goto L5;
        return;
    L5:
        this.f12318b = r5;
        if (r5 == false) goto L8;
        Drawable r10 = this.f12317a;
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
        setChecked(!this.f12318b);
    }

    public OCheckMark(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "attrs");
        super(r5, r10);
        this.f12317a = getResources().getDrawable(R$drawable.o_card_list_item_tail_icon_mark);
        this.f12318b = true;
        e();
    }

    public OCheckMark(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "attrs");
        super(r5, r10, r11);
        this.f12317a = getResources().getDrawable(R$drawable.o_card_list_item_tail_icon_mark);
        this.f12318b = true;
        e();
    }
}
