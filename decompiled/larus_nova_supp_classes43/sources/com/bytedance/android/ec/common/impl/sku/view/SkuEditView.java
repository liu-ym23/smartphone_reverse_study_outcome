package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SkuEditView;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lkotlin/Function0;", "", "listener", "setOnKeyPreImeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributes", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuEditView extends AppCompatEditText {
    public Function0<Unit> a;

    public SkuEditView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public SkuEditView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void setOnKeyPreImeListener(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.a = r10;
    }

    public final boolean onKeyPreIme(int r1, KeyEvent r10) {
        if (r1 != 4) goto L10;
        Function0<Unit> r11 = this.a;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("listener");
    L7:
        r11.invoke();
        return true;
    L10:
        return true;
    }

    public SkuEditView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
    }

    public /* synthetic */ SkuEditView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r11 & 4) == 0) goto L8;
        int r13 = 2130969939;
    L9:
        this(r1, r10, r13);
        return;
    L8:
        r13 = 0;
        goto L9
    }
}
