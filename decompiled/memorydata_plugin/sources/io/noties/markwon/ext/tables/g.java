package io.noties.markwon.ext.tables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/ext/tables/TableOptions;", "", "generateExcelLiteral", "", "(Z)V", "getGenerateExcelLiteral", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16498a;

    public g() {
        this(false, 1, null);
    }

    public g(boolean r1) {
        this.f16498a = r1;
    }

    public /* synthetic */ g(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }

    public final boolean a() {
        return this.f16498a;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
    L13:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L7;
    L12:
        return false;
    L7:
        if (this.f16498a != ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin")).f16498a) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
    L9:
        r4 = false;
        goto L10
    }

    public int hashCode() {
        boolean r0 = this.f16498a;
        if (r0 == false) goto L6;
        return 1;
    L6:
        return r0 ? 1 : 0;
    }

    public String toString() {
        return "TableOptions(generateExcelLiteral=" + this.f16498a + ")";
    }
}
