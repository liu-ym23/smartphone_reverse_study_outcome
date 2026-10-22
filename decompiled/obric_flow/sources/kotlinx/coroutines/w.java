package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w {
    public static final Object a(Object r5) {
        if ((r5 instanceof v) == false) goto L6;
        Result.Companion r10 = Result.Companion;
        return Result.m124constructorimpl(ResultKt.createFailure(((v) r5).f19025a));
    L6:
        return Result.m124constructorimpl(r5);
    }
}
