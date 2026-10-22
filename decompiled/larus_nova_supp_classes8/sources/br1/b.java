package br1;

import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends GestureDetector.SimpleOnGestureListener {
    public static final SparseArray<b> d = null;
    public final LinkedList<View.OnTouchListener> a;
    public final List<br1.a> b;
    public final C0008b c;

    public static final class a {
        public static b a(DataCenter r2) {
            Intrinsics.checkNotNullParameter(r2, "dataCenter");
            SparseArray<b> r0 = b.d;
            b r1 = r0.get(r2.hashCode());
            if (r1 == null) goto L5;
            return r1;
        L5:
            b r3 = new b();
            r0.put(r2.hashCode(), r3);
            return r3;
        }
    }

    /* JADX INFO: renamed from: br1.b$b, reason: collision with other inner class name */
    public static final class C0008b<T> implements Comparator {
        public static final C0008b a = null;

        static {
            a = new C0008b();
        }

        public C0008b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r3, Object r4) {
            br1.a r5 = (br1.a) r3;
            br1.a r6 = (br1.a) r4;
            if (r5.a() <= r6.a()) goto L6;
            return -1;
        L6:
            if (r5.a() >= r6.a()) goto L8;
            return 1;
        L8:
            return 0;
        }
    }

    static {
        d = new SparseArray();
    }

    public b() {
        this.a = new LinkedList();
        this.b = new ArrayList();
        this.c = C0008b.a;
    }
}
