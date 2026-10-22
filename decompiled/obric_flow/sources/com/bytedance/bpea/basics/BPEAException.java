package com.bytedance.bpea.basics;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/bpea/basics/BPEAException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "basics_release"}, k = 1, mv = {1, 4, 0})
public final class BPEAException extends Exception {
    public BPEAException() {
        super("certToken is empty");
    }
}
