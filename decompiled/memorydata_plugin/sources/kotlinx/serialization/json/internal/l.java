package kotlinx.serialization.json.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\rJ\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPath;", "", "()V", "currentDepth", "", "currentObjectPath", "", "[Ljava/lang/Object;", "indicies", "", "getPath", "", "popDescriptor", "", "prettyString", "it", "pushDescriptor", "sd", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "resetCurrentMapKey", "resize", "toString", "updateCurrentMapKey", "key", "updateDescriptorIndex", "index", "Tombstone", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f17846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f17847b;
    private int c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPath$Tombstone;", "", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17848a = null;

        static {
            f17848a = new a();
        }

        private a() {
        }
    }

    public l() {
        this.f17846a = new Object[8];
        int[] r1 = new int[8];
        int r2 = 0;
    L4:
        if (r2 >= 8) goto L6;
        r1[r2] = -1;
        r2 = r2 + 1;
        goto L4
    L6:
        this.f17847b = r1;
        this.c = -1;
    }

    public final String a() {
        StringBuilder r0 = new StringBuilder();
        r0.append("$");
        int r1 = this.c + 1;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L19;
        Object r3 = this.f17846a[r2];
        if (ZeusTransformUtils.instanceOf(r3, kotlinx.serialization.descriptors.f.class) == false) goto L15;
        if (Intrinsics.areEqual(((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).e(), kotlinx.serialization.descriptors.k.b.f17692a) == true) goto L9;
        int r4 = this.f17847b[r2];
        if (r4 < 0) goto L18;
        r0.append(".");
        r0.append(((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).c(r4));
    L18:
        r2 = r2 + 1;
        goto L3
    L9:
        if (this.f17847b[r2] == (-1)) goto L18;
        r0.append("[");
        r0.append(this.f17847b[r2]);
    L17:
        r0.append("]");
        goto L18
    L15:
        if (r3 == a.f17848a) goto L18;
        r0.append("[");
        r0.append("'");
        r0.append(r3);
        r0.append("'");
        goto L17
    L19:
        String r9 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "StringBuilder().apply(builderAction).toString()");
        return r9;
    }

    public String toString() {
        return a();
    }
}
