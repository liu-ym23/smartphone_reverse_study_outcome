package kotlinx.serialization.json.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0000\u001a \u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0000\u001a \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0016\u0010\u0014\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0000¨\u0006\u0019"}, d2 = {"InvalidFloatingPointDecoded", "Lkotlinx/serialization/json/internal/JsonDecodingException;", EventBody.KEY_VALUE, "", "key", "", "output", "InvalidFloatingPointEncoded", "Lkotlinx/serialization/json/internal/JsonEncodingException;", "InvalidKeyKindException", "keyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "JsonDecodingException", TypedValues.CycleType.S_WAVE_OFFSET, "", "message", "input", "", "UnknownKeyException", "unexpectedFpErrorMessage", "minify", "throwInvalidFloatingPointDecoded", "", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "result", "kotlinx-serialization-json"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class j {
    private static final CharSequence a(CharSequence r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r8.length() >= 200) goto L5;
        return r8;
    L5:
        String r2 = ".....";
        if (r7 != (-1)) goto L13;
        int r9 = r8.length() - 60;
        if (r9 > 0) goto L10;
        return r8;
    L10:
        StringBuilder r10 = new StringBuilder().append(".....").append(r8.subSequence(r9, r8.length()).toString());
    L12:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r10.toString(), CharSequence.class, "com.obric.memorydata.plugin");
    L13:
        int r0 = r7 - 30;
        int r11 = r7 + 30;
        if (r0 > 0) goto L16;
        String r4 = "";
    L18:
        if (r11 < r8.length()) goto L20;
        r2 = "";
    L20:
        r10 = new StringBuilder().append(r4).append(r8.subSequence(RangesKt.coerceAtLeast(r0, 0), RangesKt.coerceAtMost(r11, r8.length())).toString()).append(r2);
        goto L12
    L16:
        r4 = ".....";
        goto L18
    }

    static /* synthetic */ CharSequence a(CharSequence r1, int r2, int r3, Object r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = -1;
    L6:
        return a(r5, r2);
    }

    public static final JsonDecodingException a(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if (r3 < 0) goto L6;
        r4 = "Unexpected JSON token at offset " + r3 + ": " + r4;
    L6:
        return new JsonDecodingException(r4);
    }

    public static final JsonDecodingException a(int r2, String r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r5, "input");
        return a(r2, r3 + "\nJSON input: " + a(r5, r2));
    }

    public static final JsonDecodingException a(Number r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "output");
        return a(-1, b(r1, r2, r3));
    }

    public static final JsonDecodingException a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "input");
        return a(-1, "Encountered unknown key '" + r3 + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), 0, 1, null));
    }

    public static final JsonEncodingException a(kotlinx.serialization.descriptors.f r3) {
        kotlinx.serialization.descriptors.f r4 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + r4.f() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + r4.e() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    private static final String b(Number r2, String r3, String r4) {
        return "Unexpected special floating-point value " + r2 + " with key " + r3 + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), 0, 1, null);
    }
}
