package nuc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import juc.d;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@InternalSerializationApi
public final class f<E> extends w<E, List<? extends E>, ArrayList<E>> {
    public final e b;

    @Override // nuc.a
    public final Object a() {
        return new ArrayList();
    }

    @Override // nuc.v, juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.b;
    }

    public f(d<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        super(r2);
        this.b = new e(r2.getDescriptor());
    }

    @Override // nuc.a
    public final int b(Object r2) {
        ArrayList r3 = (ArrayList) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.size();
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        Intrinsics.checkNotNullParameter(null, "<this>");
        return new ArrayList(null);
    }

    @Override // nuc.a
    public final Object j(Object r2) {
        ArrayList r3 = (ArrayList) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3;
    }

    @Override // nuc.a
    public final void c(Object r2, int r3) {
        ArrayList r4 = (ArrayList) r2;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r4.ensureCapacity(r3);
    }

    public void insert(ArrayList<E> r2, int r3, E r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ListProtector.add(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nuc.v
    public /* bridge */ /* synthetic */ void insert(Object r1, int r2, Object r3) {
        insert((ArrayList) r1, r2, r3);
    }
}
