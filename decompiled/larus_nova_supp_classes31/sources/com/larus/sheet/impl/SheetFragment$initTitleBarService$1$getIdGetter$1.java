package com.larus.sheet.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class SheetFragment$initTitleBarService$1$getIdGetter$1 extends FunctionReferenceImpl implements Function0<String> {
    public SheetFragment$initTitleBarService$1$getIdGetter$1(Object r8) {
        super(0, r8, SheetFragment.class, "generateDocLogicKeyForFindService", "generateDocLogicKeyForFindService()Ljava/lang/String;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m101invoke() {
        return ((SheetFragment) ((CallableReference) this).receiver).ja0();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m101invoke();
    }
}
