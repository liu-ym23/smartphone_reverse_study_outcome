package com.obric.dejavu.library.cipher;

import com.obric.dejavu.library.DbStatus;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherErrors;", "", "()V", "ERR_DB_DATA_NULL", "Lcom/obric/dejavu/library/DbStatus;", "getERR_DB_DATA_NULL", "()Lcom/obric/dejavu/library/DbStatus;", "ERR_DECRYPT_VEC", "getERR_DECRYPT_VEC", "ERR_SEED_TOO_LARGE", "getERR_SEED_TOO_LARGE", "ERR_SEED_TOO_SHORT", "getERR_SEED_TOO_SHORT", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7881a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final DbStatus f7882b = null;
    private static final DbStatus c = null;
    private static final DbStatus d = null;
    private static final DbStatus e = null;

    static {
        f7881a = new b();
        f7882b = new DbStatus(-1000, "db.data is null");
        c = new DbStatus(-1001, "seed is too short");
        d = new DbStatus(-1002, "seed is too large");
        e = new DbStatus(-1003, "decrypt vec failed");
    }

    private b() {
    }

    public final DbStatus a() {
        return f7882b;
    }

    public final DbStatus b() {
        return c;
    }

    public final DbStatus c() {
        return d;
    }

    public final DbStatus d() {
        return e;
    }
}
