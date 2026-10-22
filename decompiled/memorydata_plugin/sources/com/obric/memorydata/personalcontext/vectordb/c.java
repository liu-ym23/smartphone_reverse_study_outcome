package com.obric.memorydata.personalcontext.vectordb;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrationSpec;", "", "baseDbName", "", "<init>", "(Ljava/lang/String;)V", "getBaseDbName", "()Ljava/lang/String;", "modelSourceName", "getModelSourceName", "vlmSourceName", "getVlmSourceName", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12407b;
    private final String c;

    public c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "baseDbName");
        this.f12406a = r2;
        this.f12407b = r2;
        this.c = r2 + "_vlm";
    }

    public final String a() {
        return this.f12406a;
    }

    public final String b() {
        return this.f12407b;
    }

    public final String c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12406a, r6.f12406a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f12406a.hashCode();
    }

    public String toString() {
        return "PersonalVectorDbFileMigrationSpec(baseDbName=" + this.f12406a + ')';
    }
}
