package com.bytedance.android.livesdk.interactivity.comment.mention;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MentionCheckBoxWrapper {
    public boolean a;
    public final Lazy b;
    public final View c;

    public interface a {
        void a(boolean r1);
    }

    public final void a() {
        this.a = !this.a;
        Iterator r0 = ((List) this.b.getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).a(this.a);
        goto L4
    }

    public MentionCheckBoxWrapper(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.c = r2;
        this.b = LazyKt.lazy(MentionCheckBoxWrapper$listeners$2.INSTANCE);
    }
}
