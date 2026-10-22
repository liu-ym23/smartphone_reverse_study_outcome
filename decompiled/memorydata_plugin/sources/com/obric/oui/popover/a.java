package com.obric.oui.popover;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/popover/LongClickUtil;", "", "()V", "setOnLongClickListenerEx", "", "Landroid/view/View;", "longClickListenerEx", "Lcom/obric/oui/popover/OnLongClickListenerEx;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14317a = null;

    static {
        f14317a = new a();
    }

    private a() {
    }

    private static final boolean a(f r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "$longClickListenerEx");
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        return r1.a(r2, r1.a());
    }

    public static /* synthetic */ boolean lambda$mMjh0xB1NeaXBQsNCn6Im3LWUzs(f r0, View r1) {
        return a(r0, r1);
    }

    public final void a(View r1, final f r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "longClickListenerEx");
        r1.setOnTouchListener(r2.b());
        r1.setOnLongClickListener(new $$Lambda$a$mMjh0xB1NeaXBQsNCn6Im3LWUzs(r2));
    }
}
