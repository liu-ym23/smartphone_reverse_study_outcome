package kotlinx.serialization.descriptors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\"$\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"elementDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getElementDescriptors", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/lang/Iterable;", "elementNames", "", "getElementNames$annotations", "getElementNames", "kotlinx-serialization-core"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class h {

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"kotlinx/serialization/descriptors/SerialDescriptorKt$elementDescriptors$1$1", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementsLeft", "", "hasNext", "", "next", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Iterator<f>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f17683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f17684b;

        a(f r3) {
            f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
            this.f17683a = r4;
            this.f17684b = r4.b();
        }

        public f a() {
            f r0 = this.f17683a;
            int r1 = r0.b();
            int r2 = this.f17684b;
            this.f17684b = r2 - 1;
            return r0.b(r1 - r2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f17684b <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* synthetic */ f next() {
            return a();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"kotlinx/serialization/descriptors/SerialDescriptorKt$elementNames$1$1", "", "", "elementsLeft", "", "hasNext", "", "next", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements Iterator<String>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f17685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f17686b;

        b(f r3) {
            f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
            this.f17685a = r4;
            this.f17686b = r4.b();
        }

        public String a() {
            f r0 = this.f17685a;
            int r1 = r0.b();
            int r2 = this.f17686b;
            this.f17686b = r2 - 1;
            return r0.c(r1 - r2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f17686b <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* synthetic */ String next() {
            return a();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements Iterable<f>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f17687a;

        public c(f r3) {
            this.f17687a = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Iterable
        public Iterator<f> iterator() {
            return (Iterator) ZeusTransformUtils.preCheckCast(new a(this.f17687a), Iterator.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements Iterable<String>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f17688a;

        public d(f r3) {
            this.f17688a = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return (Iterator) ZeusTransformUtils.preCheckCast(new b(this.f17688a), Iterator.class, "com.obric.memorydata.plugin");
        }
    }

    public static final Iterable<f> a(f r2) {
        f r3 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return (Iterable) ZeusTransformUtils.preCheckCast(new c(r3), Iterable.class, "com.obric.memorydata.plugin");
    }

    public static final Iterable<String> b(f r2) {
        f r3 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return (Iterable) ZeusTransformUtils.preCheckCast(new d(r3), Iterable.class, "com.obric.memorydata.plugin");
    }
}
