package ka;

import ha.c0;
import ha.d0;

/* JADX INFO: loaded from: classes.dex */
public final class v implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f9092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0 f9093b;

    public class a extends c0<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f9094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f9095b;

        public a(v r8, Class r10) {
            this.f9095b = r8;
            this.f9094a = r10;
        }

        @Override // ha.c0
        public final Object a(pa.a r8) {
            Object r10 = this.f9095b.f9093b.a(r8);
            if (r10 == null) goto L9;
            Class r11 = this.f9094a;
            if (r11.isInstance(r10) == true) goto L9;
            throw new ha.q("Expected a " + r11.getName() + " but was " + r10.getClass().getName() + "; at path " + r8.A());
        L9:
            return r10;
        }

        @Override // ha.c0
        public final void b(pa.c r8, Object r10) {
            this.f9095b.f9093b.b(r8, r10);
        }
    }

    public v(Class r8, c0 r10) {
        this.f9092a = r8;
        this.f9093b = r10;
    }

    @Override // ha.d0
    public final <T2> c0<T2> a(ha.j r8, oa.a<T2> r10) {
        Class<? super T2> r11 = r10.getRawType();
        if (this.f9092a.isAssignableFrom(r11) == true) goto L7;
        return null;
    L7:
        return new a(this, r11);
    }

    public final String toString() {
        return "Factory[typeHierarchy=" + this.f9092a.getName() + ",adapter=" + this.f9093b + "]";
    }
}
