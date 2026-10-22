package com.ss.android.lark.insets;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroupCompat;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements OnApplyWindowInsetsListener {
    public final /* synthetic */ OnApplyWindowInsetsListener a;
    public final /* synthetic */ ViewGroup b;

    public a(ForsetiNormalChainViewGroupCompat.a r1, ViewGroup r2) {
        this.a = r1;
        this.b = r2;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r3, WindowInsetsCompat r4) {
        Intrinsics.checkNotNullParameter(r3, "v");
        Intrinsics.checkNotNullParameter(r4, "insets");
        WindowInsetsCompat r5 = this.a.onApplyWindowInsets(r3, r4);
        Iterator r6 = ViewGroupKt.getChildren(this.b).iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        ((View) r6.next()).dispatchApplyWindowInsets(r5.toWindowInsets());
        goto L4
    L7:
        return WindowInsetsCompat.CONSUMED;
    }
}
