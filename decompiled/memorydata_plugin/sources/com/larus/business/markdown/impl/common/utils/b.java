package com.larus.business.markdown.impl.common.utils;

import com.larus.business.markdown.api.depend.f;
import com.larus.business.markdown.api.model.j;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/business/markdown/impl/common/utils/MarkdownContentPredealHelper;", "", "()V", "TAG", "", "config", "Lcom/larus/business/markdown/api/model/SyntaxErrorCoverConfig;", "getIndentCount", "", "line", "isOrderedListLine", "", "predealContentForSyntaxErrorCover", Params.CONTENT, "finished", "refineTableInList", "setConfig", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5175a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static j f5176b;

    static {
        f5175a = new b();
        f5176b = new j(false, 1, null);
    }

    private b() {
    }

    private final String a(String r12) {
        List r0 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"\n"}, false, 0, 6, null), Collection.class, "com.obric.memorydata.plugin"));
        int r3 = 0;
    L4:
        if (r3 >= (r0.size() - 3)) goto L35;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r0.get(r3), String.class, "com.obric.memorydata.plugin");
        int r5 = b(r4);
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.CharSequence");
        String r6 = StringsKt.trimStart((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.startsWith$default(r6, "- ", false, 2, null) == false) goto L8;
    L13:
        boolean r7 = true;
    L14:
        boolean r8 = c(r6);
        if (r7 == true) goto L19;
        if (r8 == true) goto L19;
        r3 = r3 + 1;
    L19:
        int r9 = r3 + 1;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r0.get(r9), String.class, "com.obric.memorydata.plugin");
        if (b(r10) > r5) goto L21;
        Objects.requireNonNull(r10, "null cannot be cast to non-null type kotlin.CharSequence");
        if (StringsKt.startsWith$default(StringsKt.trimStart((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString(), "|", false, 2, null) == false) goto L21;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r0.get(r3 + 2), String.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r11, "null cannot be cast to non-null type kotlin.CharSequence");
        String r13 = StringsKt.trimStart((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.startsWith$default(r13, "|--", false, 2, null) == true) goto L30;
        if (StringsKt.startsWith$default(r13, "|:-", false, 2, null) == true) goto L30;
        if (StringsKt.startsWith$default(r13, "| --", false, 2, null) == false) goto L21;
    L30:
        r0.add(r9, "\n");
        f r14 = com.larus.business.markdown.api.a.f5138a.b();
        if (r14 == null) goto L33;
        r14.i("MarkdownContentPredealHelper", "refineTableInList adding triggered, tableStartIndex[" + r9 + ']');
    L33:
        r3 = r3 + 4;
    L21:
        r3 = r9;
        goto L4
    L8:
        if (StringsKt.startsWith$default(r6, "* ", false, 2, null) == true) goto L13;
        if (StringsKt.startsWith$default(r6, "+ ", false, 2, null) == true) goto L13;
        r7 = false;
        goto L14
    L35:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    private final int b(String r5) {
        int r4 = r5.length();
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r4) goto L7;
        if (r5.charAt(r0) != ' ') goto L7;
        r1 = r1 + 1;
        r0 = r0 + 1;
    L7:
        return r1;
    }

    private final boolean c(String r5) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        return false;
    L8:
        int r6 = 0;
    L10:
        if (r6 >= r5.length()) goto L14;
        if (Character.isDigit(r5.charAt(r6)) == false) goto L14;
        r6 = r6 + 1;
    L14:
        if (r6 != 0) goto L16;
    L28:
        return false;
    L16:
        if (r6 >= r5.length()) goto L28;
        if (r5.charAt(r6) == '.') goto L21;
        return false;
    L21:
        int r7 = r6 + 1;
        if (r7 >= r5.length()) goto L27;
        if (r5.charAt(r7) != ' ') goto L27;
        return true;
    L27:
        return false;
    L5:
        r4 = false;
        goto L6
    }

    public final String a(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        if (r3 == true) goto L6;
        return r2;
    L6:
        if (f5176b.a() == true) goto L8;
        return r2;
    L8:
        return a(r2);
    }

    public final void a(j r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        f5176b = r1;
    }
}
