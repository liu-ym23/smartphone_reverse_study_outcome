package com.obric.memorydata.database.dao;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/SemanticDeleteVersionChangedException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "<init>", "()V", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticDeleteVersionChangedException extends IllegalStateException {
    public SemanticDeleteVersionChangedException() {
        super("semantic snapshot changed before delete");
    }
}
