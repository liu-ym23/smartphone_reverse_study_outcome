package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nRegion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Region.kt\nandroidx/core/graphics/RegionKt\n*L\n1#1,158:1\n71#1,3:159\n35#1,3:162\n44#1,3:165\n*S KotlinDebug\n*F\n+ 1 Region.kt\nandroidx/core/graphics/RegionKt\n*L\n79#1:159,3\n84#1:162,3\n89#1:165,3\n*E\n"})
public final class RegionKt {

    /* JADX INFO: renamed from: androidx.core.graphics.RegionKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<Rect>, KMappedMarker {
        private boolean hasMore;
        private final RegionIterator iterator;
        private final Rect rect;

        AnonymousClass1(Region r10) {
            RegionIterator r11 = new RegionIterator(r10);
            this.iterator = r11;
            Rect r12 = new Rect();
            this.rect = r12;
            this.hasMore = r11.next(r12);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasMore;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Rect next() {
            if (this.hasMore == false) goto L7;
            Rect r10 = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return r10;
        L7:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Rect next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final Region and(Region r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Region r12 = new Region(r10);
        r12.op(r11, Region.Op.INTERSECT);
        return r12;
    }

    public static final Region and(Region r10, Region r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Region r12 = new Region(r10);
        r12.op(r11, Region.Op.INTERSECT);
        return r12;
    }

    public static final boolean contains(Region r10, Point r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        return r10.contains(r11.x, r11.y);
    }

    public static final void forEach(Region r10, Function1<? super Rect, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        RegionIterator r12 = new RegionIterator(r10);
    L3:
        Rect r13 = new Rect();
        if (r12.next(r13) == false) goto L5;
        r11.invoke(r13);
        goto L3
    }

    public static final Iterator<Rect> iterator(Region r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass1(r10);
    }

    public static final Region minus(Region r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Region r12 = new Region(r10);
        r12.op(r11, Region.Op.DIFFERENCE);
        return r12;
    }

    public static final Region minus(Region r10, Region r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Region r12 = new Region(r10);
        r12.op(r11, Region.Op.DIFFERENCE);
        return r12;
    }

    public static final Region not(Region r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Region r11 = new Region(r10.getBounds());
        r11.op(r10, Region.Op.DIFFERENCE);
        return r11;
    }

    public static final Region or(Region r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Region r12 = new Region(r10);
        r12.union(r11);
        return r12;
    }

    public static final Region or(Region r10, Region r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Region r12 = new Region(r10);
        r12.op(r11, Region.Op.UNION);
        return r12;
    }

    public static final Region plus(Region r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Region r12 = new Region(r10);
        r12.union(r11);
        return r12;
    }

    public static final Region plus(Region r10, Region r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Region r12 = new Region(r10);
        r12.op(r11, Region.Op.UNION);
        return r12;
    }

    public static final Region unaryMinus(Region r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Region r11 = new Region(r10.getBounds());
        r11.op(r10, Region.Op.DIFFERENCE);
        return r11;
    }

    public static final Region xor(Region r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Region r12 = new Region(r10);
        r12.op(r11, Region.Op.XOR);
        return r12;
    }

    public static final Region xor(Region r10, Region r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "r");
        Region r12 = new Region(r10);
        r12.op(r11, Region.Op.XOR);
        return r12;
    }
}
