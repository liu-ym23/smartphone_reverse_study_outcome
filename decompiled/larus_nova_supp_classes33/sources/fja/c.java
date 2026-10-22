package fja;

import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public long a;
    public float b;
    public RunMode c;
    public RepeatMode d;
    public List<? extends bja.a<?>> e;
    public WeakReference<View> f;
    public long g;
    public int h;
    public float i;
    public long j;
    public long k;
    public boolean l;
    public boolean m;

    public c() {
        this.b = 60.0f;
        this.c = RunMode.PARALLEL;
        this.d = RepeatMode.NORMAL;
        this.e = CollectionsKt.emptyList();
        this.h = -1;
        this.i = 1.0f;
        this.l = true;
    }

    public final void a(boolean r5) {
        WeakReference<View> r0 = this.f;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Iterator<T> r1 = this.e.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        bja.a r2 = (bja.a) r1.next();
        r2.d = false;
        if (r5 == false) goto L11;
        float r3 = 0.0f;
    L12:
        r2.k = r3;
        r2.b = -1;
        r2.c = -1;
        goto L7
    L11:
        r3 = r2.k;
        goto L12
    L13:
        this.g = 0;
        this.h = -1;
        this.i = 1.0f;
        this.j = 0;
        this.k = 0;
    }
}
