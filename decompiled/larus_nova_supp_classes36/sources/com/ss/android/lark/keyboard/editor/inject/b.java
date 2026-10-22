package com.ss.android.lark.keyboard.editor.inject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.keyboard.base.d;
import com.ss.android.lark.keyboard.event.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final com.ss.android.lark.keyboard.b a;
    public final Map<d.a<?>, d<?>> b;
    public final Map<d.a<?>, View> c;
    public final k d;
    public final FrameLayout e;

    public b(ViewGroup r3, com.ss.android.lark.keyboard.b r4) {
        Intrinsics.checkNotNullParameter(r3, "inputBottomContainer");
        Intrinsics.checkNotNullParameter(r4, "keyboard");
        this.a = r4;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = r4.e();
        FrameLayout r5 = new FrameLayout(r3.getContext());
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.e = r5;
        r3.addView(r5);
    }
}
