package com.obric.search.extension;

import com.tencent.wcdb.extension.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0019\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0082 ¨\u0006\t"}, d2 = {"Lcom/obric/search/extension/OFts5Extension;", "Lcom/tencent/wcdb/extension/SQLiteExtension;", "()V", "initialize", "", "sqlite3Ptr", "", "apiPtr", "nativeInitialize", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OFts5Extension implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OFts5Extension f14960a = null;

    static {
        f14960a = new OFts5Extension();
    }

    private OFts5Extension() {
    }

    private final native void nativeInitialize(long r1, long r3);

    @Override // com.tencent.wcdb.extension.a
    public void a(long r1, long r3) {
        nativeInitialize(r1, r3);
    }
}
