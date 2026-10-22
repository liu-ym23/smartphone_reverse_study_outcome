package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b¨\u0006\u0004"}, d2 = {"charset", "Ljava/nio/charset/Charset;", "charsetName", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CharsetsKt {
    private static final Charset charset(String r1) {
        Intrinsics.checkNotNullParameter(r1, "charsetName");
        Charset r2 = Charset.forName(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "forName(...)");
        return r2;
    }
}
