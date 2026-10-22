package com.obric.memorydata.database.util.file_utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0004J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0004¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/AbstractWordFileProcessor;", "Lcom/obric/memorydata/database/util/file_utils/BaseDocumentImageProcessor;", "<init>", "()V", "handleHeading", "Lcom/obric/memorydata/database/util/file_utils/DocNode;", "para", "", "level", "", "tree", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "stack", "", "handleNormalParagraph", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a extends b {
    public a() {
    }

    public final h a(String r4, int r5, j r6, List<h> r7) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "para");
        Intrinsics.checkNotNullParameter(r6, "tree");
        Intrinsics.checkNotNullParameter(r3, "stack");
    L4:
        if (r3.size() <= r5) goto L6;
        r3.remove(CollectionsKt.getLastIndex(r3));
        goto L4
    L6:
        h r8 = r6.a(NodeType.TITLE, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString(), r5, Integer.valueOf(((h) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r3), h.class, "com.obric.memorydata.plugin")).a()));
        r3.add(r8);
        return r8;
    }

    public final h a(String r3, j r4, List<h> r5) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "para");
        Intrinsics.checkNotNullParameter(r4, "tree");
        Intrinsics.checkNotNullParameter(r2, "stack");
        return r4.a(NodeType.PARAGRAPH, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString(), -1, Integer.valueOf(((h) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r2), h.class, "com.obric.memorydata.plugin")).a()));
    }
}
