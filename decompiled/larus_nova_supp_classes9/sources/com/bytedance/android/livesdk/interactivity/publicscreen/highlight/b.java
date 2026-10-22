package com.bytedance.android.livesdk.interactivity.publicscreen.highlight;

import android.content.Context;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.h;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements h {
    public final List<i> a;
    public final Context b;
    public final k c;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.h
    public final void a() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((i) r0.next()).a();
        goto L4
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.h
    public final void b() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((i) r0.next()).b();
        goto L4
    }

    public b(Context r2, PSHighlightContext r3) {
        Intrinsics.checkNotNullParameter(r3, "psHighlightContext");
        this.b = r2;
        this.c = r3;
        this.a = new ArrayList();
    }
}
