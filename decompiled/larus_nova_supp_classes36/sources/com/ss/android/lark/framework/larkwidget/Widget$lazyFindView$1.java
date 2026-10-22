package com.ss.android.lark.framework.larkwidget;

import android.view.View;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "Landroid/view/View;", "invoke", "()Landroid/view/View;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class Widget$lazyFindView$1 extends Lambda implements Function0<View> {
    final /* synthetic */ int $id;
    final /* synthetic */ Widget this$0;

    public Widget$lazyFindView$1(Widget r1, int r2) {
        this.this$0 = r1;
        this.$id = r2;
        super(0);
    }

    public final View invoke() {
        Widget r0 = this.this$0;
        int r1 = this.$id;
        View r2 = r0.e;
        if (r2 == null) goto L7;
        return r2.findViewById(r1);
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m701invoke() {
        return invoke();
    }
}
