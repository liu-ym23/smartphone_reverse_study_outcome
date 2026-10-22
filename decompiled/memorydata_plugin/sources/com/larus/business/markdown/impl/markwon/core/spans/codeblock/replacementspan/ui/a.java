package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.ui;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/ui/MarkdownCodeUtil;", "", "()V", "takeFirstLines", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "n", "", "takeLastLines", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5226a = null;

    static {
        f5226a = new a();
    }

    private a() {
    }

    public final String a(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        if (r5 > 0) goto L6;
        return "";
    L6:
        int r3 = 0;
        int r0 = r4.length() - 1;
    L7:
        if (r0 < 0) goto L15;
        if (r4.charAt(r0) != '\n') goto L14;
        r3 = r3 + 1;
        if (r3 != r5) goto L14;
        String r6 = r4.substring(r0 + 1);
        Intrinsics.checkNotNullExpressionValue(r6, "(this as java.lang.String).substring(startIndex)");
        return r6;
    L14:
        r0 = r0 - 1;
        goto L7
    L15:
        return r4;
    }

    public final String b(String r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        if (r7 > 0) goto L6;
        return "";
    L6:
        int r5 = r6.length();
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= r5) goto L15;
        if (r6.charAt(r1) != '\n') goto L14;
        r2 = r2 + 1;
        if (r2 != r7) goto L14;
        String r8 = r6.substring(0, r1);
        Intrinsics.checkNotNullExpressionValue(r8, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return r8;
    L14:
        r1 = r1 + 1;
        goto L7
    L15:
        return r6;
    }
}
