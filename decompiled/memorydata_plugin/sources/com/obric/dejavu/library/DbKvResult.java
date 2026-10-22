package com.obric.dejavu.library;

import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/dejavu/library/DbKvResult;", "", "status", "Lcom/obric/dejavu/library/DbStatus;", "vec", "", EventBody.KEY_VALUE, "", "(Lcom/obric/dejavu/library/DbStatus;[FLjava/lang/String;)V", "getStatus", "()Lcom/obric/dejavu/library/DbStatus;", "getValue", "()Ljava/lang/String;", "getVec", "()[F", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DbKvResult {
    private final DbStatus status;
    private final String value;
    private final float[] vec;

    public DbKvResult(DbStatus r2, float[] r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this.status = r2;
        this.vec = r3;
        this.value = r4;
    }

    public final DbStatus getStatus() {
        return this.status;
    }

    public final String getValue() {
        return this.value;
    }

    public final float[] getVec() {
        return this.vec;
    }
}
