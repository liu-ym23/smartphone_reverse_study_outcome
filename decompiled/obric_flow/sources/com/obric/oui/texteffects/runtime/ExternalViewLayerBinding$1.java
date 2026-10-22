package com.obric.oui.texteffects.runtime;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ExternalViewLayerBinding$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ View $view;

    public ExternalViewLayerBinding$1(View r5) {
        this.$view = r5;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Float invoke() {
        Integer r5 = Integer.valueOf(this.$view.getWidth());
        Float r10 = null;
        if (r5.intValue() > 0) goto L6;
        r5 = null;
    L6:
        if (r5 == null) goto L9;
        r10 = Float.valueOf(r5.intValue());
    L9:
        if (r10 != null) goto L11;
        float r11 = this.$view.getMeasuredWidth();
    L13:
        return Float.valueOf(r11);
    L11:
        r11 = r10.floatValue();
        goto L13
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Float invoke() {
        return invoke();
    }
}
