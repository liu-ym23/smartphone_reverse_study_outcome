package com.obric.dejavu.library.cipher;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class DbCipherUtils$Companion$generateRandomSeed$1 extends Lambda implements Function1<Byte, CharSequence> {
    public static final DbCipherUtils$Companion$generateRandomSeed$1 INSTANCE = null;

    static {
        INSTANCE = new DbCipherUtils$Companion$generateRandomSeed$1();
    }

    DbCipherUtils$Companion$generateRandomSeed$1() {
        super(1);
    }

    public final CharSequence invoke(byte r3) {
        String r2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r2, "format(this, *args)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ CharSequence invoke(Byte r3) {
        return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).byteValue());
    }
}
