package com.larus.bmhome.chat.layout.item;

import android.view.View;
import android.view.animation.PathInterpolator;
import com.larus.bmhome.chat.bean.PromptContent;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c3 {
    public static final PathInterpolator g = null;
    public final View a;
    public final Function0<PromptContent> b;
    public final Function0<Integer> c;
    public boolean d;
    public int e;
    public List<? extends View> f;

    public static final class a {
    }

    static {
        g = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
    }

    public c3(View r2, q2 r3, r2 r4) {
        Intrinsics.checkNotNullParameter(r2, "targetView");
        Intrinsics.checkNotNullParameter(r3, "contentProvider");
        Intrinsics.checkNotNullParameter(r4, "childCountProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.f = CollectionsKt.emptyList();
    }
}
