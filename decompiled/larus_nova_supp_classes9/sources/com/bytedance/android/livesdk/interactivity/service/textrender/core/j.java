package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements Disposable {
    public static final int e = 0;
    public final PriorityQueue<m> a;
    public h b;
    public boolean c;
    public final List<b> d;

    public static final class a {
    }

    public final void dispose() {
        this.c = true;
    }

    static {
        e = (int) UIUtils.dip2Px(s1.getContext(), 16);
    }

    public final boolean isDisposed() {
        return this.c;
    }

    public j(List<b> r3) {
        Intrinsics.checkNotNullParameter(r3, "asyncInfos");
        this.d = r3;
        this.a = new PriorityQueue(10, new l());
    }

    public final void b(int r3, Drawable r4) {
        if (this.c == false) goto L5;
        return;
    L5:
        if (r4 != null) goto L9;
        h r0 = this.b;
        if (r0 == null) goto L9;
        r0.b(((b) ListProtector.get(this.d, r3)).d);
    L9:
        this.a.add(new m(r4, r3));
        if (this.a.size() == this.d.size()) goto L12;
        return;
    L12:
        if (this.c == true) goto L20;
        h r5 = this.b;
        if (r5 == null) goto L19;
        r5.a(this.a);
        return;
    L19:
        return;
    }
}
