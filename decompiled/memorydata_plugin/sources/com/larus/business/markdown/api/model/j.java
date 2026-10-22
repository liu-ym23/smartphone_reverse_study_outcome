package com.larus.business.markdown.api.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/larus/business/markdown/api/model/SyntaxErrorCoverConfig;", "", "refineTableInList", "", "(Z)V", "getRefineTableInList", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5167a;

    public j() {
        this(false, 1, null);
    }

    public j(boolean r1) {
        this.f5167a = r1;
    }

    public /* synthetic */ j(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }

    public final boolean a() {
        return this.f5167a;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.memorydata.plugin");
        if (this.f5167a == r6.f5167a) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        boolean r0 = this.f5167a;
        if (r0 == false) goto L6;
        return 1;
    L6:
        return r0 ? 1 : 0;
    }

    public String toString() {
        return "SyntaxErrorCoverConfig(refineTableInList=" + this.f5167a + ')';
    }
}
