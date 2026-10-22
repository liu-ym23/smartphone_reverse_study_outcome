package com.obric.memorydata.database.account_split;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0000¨\u0006\u0005"}, d2 = {"buildLegacyBackupReplaceSql", "", "targetTableName", "targetColumns", "", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class m {
    private static final CharSequence a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final String a(String r11, List<String> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "targetTableName");
        Intrinsics.checkNotNullParameter(r13, "targetColumns");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L7;
        return "INSERT OR REPLACE INTO " + com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r11) + " (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$m$8eMpuo8bXS7CPfME8rgOICaryY.INSTANCE, 30, null) + ") VALUES (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$m$lss75jXRf3Gc0kzg_6t8L5je4w8.INSTANCE, 30, null) + ')';
    L7:
        throw new IllegalArgumentException(("No columns found for legacy backup restore target " + r11).toString());
    }

    private static final CharSequence b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$8eMpuo8bXS7CPfME8rgOICa-ryY, reason: not valid java name */
    public static /* synthetic */ CharSequence m533lambda$8eMpuo8bXS7CPfME8rgOICaryY(String r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$lss75jXRf3Gc0kzg_6t8L5je4w8(String r0) {
        return b(r0);
    }
}
