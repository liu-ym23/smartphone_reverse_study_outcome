package io.noties.markwon.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import org.commonmark.internal.util.Parsing;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"checkOpener", "Lio/noties/markwon/maybe/MaybeFencedCodeBlockParser;", "line", "", "index", "", "indent", "markwon-maybe_release"}, k = 2, mv = {1, 1, 15})
public final class c {
    public static final /* synthetic */ b a(CharSequence r2, int r3, int r4) {
        return b((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    private static final b b(CharSequence r7, int r8, int r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r10.length();
        int r1 = 0;
        int r3 = r8;
        int r2 = 0;
    L4:
        if (r3 >= r0) goto L13;
        char r6 = r10.charAt(r3);
        if (r6 == '`') goto L10;
        if (r6 != '~') goto L13;
        r2 = r2 + 1;
    L11:
        r3 = r3 + 1;
        goto L4
    L10:
        r1 = r1 + 1;
    L13:
        if (r1 < 3) goto L19;
        if (r2 != 0) goto L19;
        if (Parsing.find('`', r10, r8 + r1) == (-1)) goto L27;
        return null;
    L27:
        return new b('`', r1, r9);
    L19:
        if (r2 < 3) goto L28;
        if (r1 == 0) goto L22;
        return null;
    L22:
        return new b('~', r2, r9);
    L28:
        return null;
    }
}
