package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ$\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000eH\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/internal/InlineList;", ExifInterface.LONGITUDE_EAST, "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "equals", "", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "forEachReversed", "", "action", "Lkotlin/Function1;", "forEachReversed-impl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "plus", "element", "plus-FjFbRPM", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class q<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f17591a;

    public static /* synthetic */ Object a(Object r0, int r1, DefaultConstructorMarker r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = null;
    L6:
        return c(r0);
    }

    public static final Object a(Object r2, E r3) {
        if (kotlinx.coroutines.an.a() == true) goto L5;
    L9:
        if (r2 != null) goto L12;
        return c(r3);
    L12:
        if (ZeusTransformUtils.instanceOf(r2, ArrayList.class) == false) goto L14;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ((ArrayList) ZeusTransformUtils.preCheckCast(r2, ArrayList.class, "com.obric.memorydata.plugin")).add(r3);
        return c(r2);
    L14:
        ArrayList r0 = new ArrayList(4);
        r0.add(r2);
        r0.add(r3);
        return c(r0);
    L5:
        if ((!ZeusTransformUtils.instanceOf(r3, List.class)) == true) goto L9;
        throw new AssertionError();
    }

    public static String a(Object r2) {
        return "InlineList(holder=" + r2 + ')';
    }

    public static int b(Object r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.hashCode();
    }

    public static boolean b(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, q.class) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r3, ((q) ZeusTransformUtils.preCheckCast(r4, q.class, "com.obric.memorydata.plugin")).a()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public static <E> Object c(Object r0) {
        return r0;
    }

    public final /* synthetic */ Object a() {
        return this.f17591a;
    }

    public boolean equals(Object r1) {
        return b(this.f17591a, r1);
    }

    public int hashCode() {
        return b(this.f17591a);
    }

    public String toString() {
        return a(this.f17591a);
    }
}
