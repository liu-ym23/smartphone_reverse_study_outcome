package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class Regex$findAll$2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
    public static final Regex$findAll$2 INSTANCE = null;

    static {
        INSTANCE = new Regex$findAll$2();
    }

    public Regex$findAll$2() {
        super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
    }

    public final MatchResult invoke(MatchResult r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return r2.next();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((MatchResult) r1);
    }
}
