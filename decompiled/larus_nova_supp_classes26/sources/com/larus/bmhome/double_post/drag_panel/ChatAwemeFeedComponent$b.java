package com.larus.bmhome.double_post.drag_panel;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.view.ChatConstraintLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatAwemeFeedComponent$b {
    public final ConstraintLayout a;
    public final Function1<Context, View> b;
    public final Lazy c;

    public final void a() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L7;
        this.a.post(new a0(this));
        return;
    L7:
        if (this.a.findViewById(((View) this.c.getValue()).getId()) != null) goto L10;
        return;
    L10:
        if (((View) this.c.getValue()).getVisibility() == 8) goto L13;
        ((View) this.c.getValue()).setVisibility(8);
        return;
    }

    public final void b() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        this.a.post(new z(this));
        return;
    L6:
        View r0 = (View) this.c.getValue();
        if (r0.getVisibility() == 0) goto L10;
        r0.setVisibility(0);
        return;
    }

    public ChatAwemeFeedComponent$b(ChatConstraintLayout r2, i r3) {
        Intrinsics.checkNotNullParameter(r2, "parentLayout");
        Intrinsics.checkNotNullParameter(r3, "createViewLambda");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new b0(this));
    }
}
