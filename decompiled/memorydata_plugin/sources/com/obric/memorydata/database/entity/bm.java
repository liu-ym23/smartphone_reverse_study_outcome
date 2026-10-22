package com.obric.memorydata.database.entity;

import com.obric.aikernel.sdk.ext.Params;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/database/entity/EpisodicMemoryIndexPolicy;", "", "<init>", "()V", "CONTENT_COLUMN", "", "CONTENT_SEMANTIC_INDEX_PRODUCT_TYPE", "", "NO_INDEX_PRODUCT_TYPE_START", "NO_INDEX_PRODUCT_TYPE_END", "shouldGenerateIndex", "", "productType", "columnName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bm f8933a = null;

    static {
        f8933a = new bm();
    }

    private bm() {
    }

    public final boolean a(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "columnName");
        if (1021 <= r3) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r4, Params.CONTENT) == true) goto L13;
        return true;
    L13:
        if (r3 != 1003) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r3 >= 1025) goto L7;
        r1 = true;
        goto L8
    }
}
