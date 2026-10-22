package com.larus.business.markdown.impl.common;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007J\u001c\u0010\u000f\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0002¨\u0006\u0011"}, d2 = {"Lcom/larus/business/markdown/impl/common/StreamOptimizeUtils;", "", "()V", "deleteUnCompleteHtmlTag", "", AILabCheckPermissionTask.KEY_SOURCE, "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "findLastUnescapedBracket", "", "input", "", "startIndex", "tryCompleteLink", "", "tryOptImgExclamationMarkChar", "index", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f5173a = null;

    static {
        f5173a = new c();
    }

    private c() {
    }

    private final int a(String r3, int r4) {
    L3:
        if ((-1) >= r4) goto L16;
        Character r2 = StringsKt.getOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
        if (r2 == null) goto L15;
        if (r2.charValue() != '[') goto L15;
        Character r5 = StringsKt.getOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4 - 1);
        if (r5 == null) goto L14;
        if (r5.charValue() == '\\') goto L15;
    L14:
        return r4;
    L15:
        r4 = r4 - 1;
        goto L3
    L16:
        return -1;
    }

    private final void a(StringBuilder r3, int r4) {
        Character r2 = StringsKt.getOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.charValue() != '!') goto L14;
        Character r5 = StringsKt.getOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4 - 1);
        if (r5 != null) goto L11;
    L12:
        r3.delete(r4, r3.length());
        return;
    L11:
        if (r5.charValue() != '\\') goto L12;
        return;
    }

    public final boolean a(StringBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, AILabCheckPermissionTask.KEY_SOURCE);
        int r0 = r10.length();
    L4:
        if (r0 <= 0) goto L57;
        r0 = r0 - 1;
        char r2 = r10.charAt(r0);
        if (r2 == ')') goto L7;
        if (r2 == '\n') goto L16;
        if (r2 == '(') goto L19;
        if (r2 == ']') goto L36;
        if (r2 != '[') goto L4;
        int r3 = r0 - 1;
        Character r1 = StringsKt.getOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), r3);
        if (r1 == null) goto L55;
        if (r1.charValue() == '\\') goto L4;
    L55:
        r10.deleteCharAt(r0);
        a(r10, r3);
        return true;
    L36:
        int r4 = r0 - 1;
        Character r5 = StringsKt.getOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), r4);
        if (r5 == null) goto L42;
        if (r5.charValue() == '\\') goto L4;
    L42:
        String r6 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "source.toString()");
        int r7 = a(r6, r4);
        if (r7 >= 0) goto L45;
        return false;
    L45:
        r10.delete(r0, r10.length());
        r10.deleteCharAt(r7);
        a(r10, r7 - 1);
        return true;
    L19:
        int r8 = r0 - 1;
        Character r9 = StringsKt.getOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), r8);
        if (r9 == null) goto L25;
        if (r9.charValue() == '\\') goto L4;
    L25:
        Character r11 = StringsKt.getOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), r8);
        if (r11 == null) goto L4;
        if (r11.charValue() != ']') goto L4;
        String r12 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "source.toString()");
        int r13 = a(r12, r0 - 2);
        if (r13 >= 0) goto L33;
        return false;
    L33:
        r10.delete(r8, r10.length());
        r10.deleteCharAt(r13);
        a(r10, r13 - 1);
        return true;
    L16:
        return false;
    L7:
        Character r14 = StringsKt.getOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), r0 - 1);
        if (r14 == null) goto L13;
        if (r14.charValue() == '\\') goto L4;
    L13:
        return false;
    L57:
        return false;
    }
}
