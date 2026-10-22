package kotlin.text;

import java.nio.charset.Charset;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "CharsetsKt")
public final class CharsetsKt {
    @InlineOnly
    private static final Charset charset(String r10) {
        Intrinsics.checkNotNullParameter(r10, "charsetName");
        Charset r11 = Charset.forName(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "forName(charsetName)");
        return r11;
    }
}
