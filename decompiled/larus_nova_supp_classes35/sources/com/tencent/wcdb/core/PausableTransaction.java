package com.tencent.wcdb.core;

import com.tencent.wcdb.base.WCDBException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface PausableTransaction {
    boolean insideTransaction(Handle r1, boolean r2) throws WCDBException;
}
