package com.obric.memorydata.database.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/model/EntityHashCodeResult;", "", "entityId", "", "hashCodeValue", "", "<init>", "(Ljava/lang/String;I)V", "getEntityId", "()Ljava/lang/String;", "getHashCodeValue", "()I", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9610b;

    public c(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        this.f9609a = r2;
        this.f9610b = r3;
    }

    public final String a() {
        return this.f9609a;
    }

    public final int b() {
        return this.f9610b;
    }
}
