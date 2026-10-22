package com.ctc.wstx.shaded.msv_core.grammar;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public interface Grammar extends Serializable {
    ExpressionPool getPool();

    Expression getTopLevel();
}
