package io.noties.markwon.core.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.ListBlock;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"KEY_LIST_BLOCK_INDENT", "", "getIndent", "", "Lorg/commonmark/node/ListBlock;", "setIndent", "", "indent", "markdown-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class a {
    public static final int a(ListBlock r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(com.larus.business.markdown.impl.common.utils.a.a(r2, "key_list_block_indent"), Integer.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.intValue();
    }

    public static final void a(ListBlock r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        com.larus.business.markdown.impl.common.utils.a.a(r1, "key_list_block_indent", Integer.valueOf(r2));
    }
}
