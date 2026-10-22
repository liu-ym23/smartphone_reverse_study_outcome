package com.obric.memorydata.personalcontext.vectordb;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/VectorDbDao;", "Lcom/obric/memorydata/personalcontext/vectordb/AbstractVectorDao;", "rawTableName", "", "isVlm", "", "<init>", "(Ljava/lang/String;Z)V", "getDbInstance", "Lcom/obric/dejavu/library/cipher/DbCipherInstance;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12409b;

    public d(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "rawTableName");
        this.f12408a = r2;
        this.f12409b = r3;
    }

    @Override // com.obric.memorydata.personalcontext.vectordb.a
    public com.obric.dejavu.library.cipher.d c() {
        return f.f12411a.a(this.f12408a, this.f12409b);
    }
}
