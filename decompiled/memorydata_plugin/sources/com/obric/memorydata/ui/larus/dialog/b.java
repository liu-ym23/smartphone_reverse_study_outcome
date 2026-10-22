package com.obric.memorydata.ui.larus.dialog;

import android.content.res.Resources;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0007\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"dp", "", "", "getDp", "(Ljava/lang/Number;)I", "visible", "", "Landroid/view/View;", "gone", "larus_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {
    public static final /* synthetic */ int a(Number r0) {
        return b(r0);
    }

    public static final void a(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setVisibility(0);
    }

    private static final int b(Number r1) {
        return (int) ((r1.floatValue() * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final void b(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setVisibility(8);
    }
}
