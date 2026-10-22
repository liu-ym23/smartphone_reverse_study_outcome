package com.obric.memorydata.database.manager;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0000¨\u0006\u0004"}, d2 = {"migrationBatchIdentity", "", "entityIds", "", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class r {
    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final String a(List<String> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "entityIds");
        byte[] r13 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\u0000", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r13, "getBytes(...)");
        byte[] r2 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256).digest(r13);
        Intrinsics.checkNotNullExpressionValue(r2, "digest(...)");
        return ArraysKt.joinToString$default(r2, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$r$23BRm0exuWh8hX0COZMdTAVctf4.INSTANCE, 30, null);
    }

    public static /* synthetic */ CharSequence lambda$23BRm0exuWh8hX0COZMdTAVctf4(byte r0) {
        return a(r0);
    }
}
