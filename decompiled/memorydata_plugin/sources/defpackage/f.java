package defpackage;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"LTableRegion;", "", "range", "Lorg/apache/poi/ss/util/CellRangeAddress;", "headerRowIndex", "", "<init>", "(Lorg/apache/poi/ss/util/CellRangeAddress;I)V", "getRange", "()Lorg/apache/poi/ss/util/CellRangeAddress;", "getHeaderRowIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CellRangeAddress f16369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16370b;

    public f(CellRangeAddress r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "range");
        this.f16369a = r2;
        this.f16370b = r3;
    }

    public final CellRangeAddress a() {
        return this.f16369a;
    }

    public final int b() {
        return this.f16370b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f16369a, r6.f16369a) == true) goto L12;
        return false;
    L12:
        if (this.f16370b == r6.f16370b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f16369a.hashCode() * 31) + Integer.hashCode(this.f16370b);
    }

    public String toString() {
        return "TableRegion(range=" + this.f16369a + ", headerRowIndex=" + this.f16370b + ')';
    }
}
