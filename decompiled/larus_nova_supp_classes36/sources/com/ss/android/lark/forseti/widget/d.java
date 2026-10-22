package com.ss.android.lark.forseti.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Sequence<View> {
    public final /* synthetic */ ViewGroup a;

    public static final class a implements Iterator<View>, KMutableIterator {
        public int a;
        public final /* synthetic */ ViewGroup b;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.a >= this.b.getChildCount()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final View next() {
            ViewGroup r0 = this.b;
            int r1 = this.a;
            this.a = r1 + 1;
            View r2 = r0.getChildAt(r1);
            if (r2 == null) goto L6;
            return r2;
        L6:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            ViewGroup r0 = this.b;
            int r1 = this.a - 1;
            this.a = r1;
            r0.removeViewAt(r1);
        }

        public a(ViewGroup r1) {
            this.b = r1;
        }
    }

    public final Iterator<View> iterator() {
        return new a(this.a);
    }

    public d(ViewGroup r1) {
        this.a = r1;
    }
}
