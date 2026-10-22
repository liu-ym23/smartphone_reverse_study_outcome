package com.tencent.wcdb.core;

import com.tencent.wcdb.base.WCDBException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface Transaction {
    boolean insideTransaction(Handle r1) throws WCDBException;
}
