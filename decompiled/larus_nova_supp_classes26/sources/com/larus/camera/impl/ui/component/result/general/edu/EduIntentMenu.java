package com.larus.camera.impl.ui.component.result.general.edu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.bmhome.view.screenmenu.widget.MaxWidthLinearLayout;
import com.larus.camera.impl.databinding.LarusLayoutIntentMenuItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J<\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u0019R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/edu/EduIntentMenu;", "Lcom/larus/bmhome/view/screenmenu/widget/MaxWidthLinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindings", "Landroid/util/SparseArray;", "Lcom/larus/camera/impl/databinding/LarusLayoutIntentMenuItemBinding;", "init", "", "prepare", "Landroid/view/View;", "items", "", "Lcom/larus/bmhome/view/screenmenu/MenuItem;", "padding", "width", "listener", "Lkotlin/Function1;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EduIntentMenu extends MaxWidthLinearLayout {
    public static final /* synthetic */ int c = 0;
    public final SparseArray<LarusLayoutIntentMenuItemBinding> b;

    public EduIntentMenu(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = new SparseArray();
        d(r2, null);
    }

    public EduIntentMenu(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = new SparseArray();
        d(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(Context r2, AttributeSet r3) {
        setOrientation(1);
        setBackgroundResource(v19.c.b(2130970627, r2, 2131238879));
        setDividerDrawable(AppCompatResources.getDrawable(r2, v19.c.b(2130970952, r2, 2131240110)));
        setShowDividers(2);
        setMinimumWidth(i5.B());
        setMaxWidth(i5.y0(v19.c.b(2130971356, null, 2131167081)));
    }

    public EduIntentMenu(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new SparseArray();
        d(r2, r3);
    }
}
