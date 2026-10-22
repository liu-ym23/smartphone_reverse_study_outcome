package com.obric.memorydata.personalcontext.search.kg;

import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/kg/KGPOEntity;", "", i.m, "", "", "O", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getP", "()Ljava/util/List;", "getO", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KGPOEntity {
    private final String O;
    private final List<String> P;

    public KGPOEntity(List<String> r3, String r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "O");
        this.P = r5;
        this.O = r4;
    }

    public /* synthetic */ KGPOEntity(List r2, String r3, int r4, DefaultConstructorMarker r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L5;
        r6 = null;
    L5:
        this(r6, r3);
    }

    public static /* synthetic */ KGPOEntity copy$default(KGPOEntity r1, List r2, String r3, int r4, Object r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.P;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.O;
    L9:
        return r1.copy(r6, r3);
    }

    public final List<String> component1() {
        return this.P;
    }

    public final String component2() {
        return this.O;
    }

    public final KGPOEntity copy(List<String> r2, String r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "O");
        return new KGPOEntity(r1, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, KGPOEntity.class) == true) goto L8;
        return false;
    L8:
        KGPOEntity r6 = (KGPOEntity) ZeusTransformUtils.preCheckCast(r5, KGPOEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.P, r6.P) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.O, r6.O) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getO() {
        return this.O;
    }

    public final List<String> getP() {
        return this.P;
    }

    public int hashCode() {
        List<String> r0 = this.P;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.O.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "KGPOEntity(P=" + this.P + ", O=" + this.O + ')';
    }
}
