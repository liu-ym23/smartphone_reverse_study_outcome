package com.ss.android.lark.officewebview.pool;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class DuplicateRegisterException extends Exception {
    public DuplicateRegisterException(String r3) {
        super("found duplicate biz tag register , biz tag " + r3 + " already exist.");
    }
}
