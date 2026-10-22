package com.obric.memorydata.markdown.stream;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J&\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J&\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\u0006\u0010 \u001a\u00020!R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\""}, d2 = {"Lcom/obric/memorydata/markdown/stream/BlockStateTracker;", "", "<init>", "()V", EventBody.KEY_VALUE, "", "confirmedSafePos", "getConfirmedSafePos", "()I", "Lcom/obric/memorydata/markdown/stream/BlockType;", "pendingBlockType", "getPendingBlockType", "()Lcom/obric/memorydata/markdown/stream/BlockType;", "pendingBlockStart", "getPendingBlockStart", BuildConfig.CHANNEL, "lineCache", "Lcom/obric/memorydata/markdown/stream/IncrementalLineCache;", "targetCharPos", "findCodeBlockState", "Lcom/obric/memorydata/markdown/stream/CodeBlockResult;", "lines", "", "", "fromLine", "toLine", "findTableState", "Lcom/obric/memorydata/markdown/stream/TableResult;", "isTableRow", "", "line", "isTableSeparator", "reset", "", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BlockType f10013b;
    private int c;

    public c() {
    }

    private final d a(List<String> r9, int r10, int r11) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r0 > r11) goto L16;
        if (r0 >= r8.size()) goto L16;
        if (StringsKt.startsWith$default(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r8.get(r0), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString(), "```", false, 2, null) == false) goto L15;
        if (r1 == true) goto L11;
        r2 = r0;
        r1 = true;
        goto L15
    L11:
        if (r11 <= r0) goto L13;
        r1 = false;
        goto L15
    L13:
        return new d(true, true, r2, r0);
    L15:
        r0 = r0 + 1;
    L16:
        if (r1 == false) goto L20;
        return new d(true, false, r2, CollectionsKt.getLastIndex(r8));
    L20:
        return new d(false, false, 0, 0);
    }

    private final boolean a(String r7) {
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L9;
        return false;
    L9:
        if (StringsKt.startsWith$default(r6, "```", false, 2, null) == false) goto L12;
        return false;
    L12:
        if (StringsKt.startsWith$default(r6, "|", false, 2, null) == false) goto L14;
    L16:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        int r10 = 0;
        int r0 = 0;
    L18:
        if (r10 >= r9.length()) goto L26;
        if (r9.charAt(r10) != '|') goto L22;
        boolean r4 = true;
    L23:
        if (r4 == false) goto L25;
        r0 = r0 + 1;
    L25:
        r10 = r10 + 1;
        goto L18
    L22:
        r4 = false;
        goto L23
    L26:
        if (r0 < 2) goto L29;
        return true;
    L29:
        return false;
    L14:
        if (StringsKt.endsWith$default(r6, "|", false, 2, null) == true) goto L16;
        return false;
    L5:
        r8 = false;
        goto L6
    }

    private final q b(List<String> r10, int r11, int r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        int r0 = RangesKt.coerceAtMost(r12, CollectionsKt.getLastIndex(r13));
        boolean r3 = false;
        int r5 = -1;
        boolean r6 = false;
        if (r11 > r0) goto L20;
    L4:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r13.get(r11), String.class, "com.obric.memorydata.plugin");
        if (a(r7) == false) goto L13;
        if (r5 != (-1)) goto L9;
        r5 = r11;
    L9:
        if (r11 == (r5 + 1)) goto L11;
    L18:
        if (r11 == r0) goto L20;
        r11 = r11 + 1;
        goto L4
    L11:
        if (b(r7) == false) goto L18;
        r6 = true;
        goto L18
    L13:
        if (r5 == (-1)) goto L17;
        if (r6 == false) goto L17;
        return new q(true, true, r5, r11 - 1);
    L17:
        r5 = -1;
        r6 = false;
    L20:
        if (r5 == (-1)) goto L29;
        if (r6 == false) goto L29;
        int r14 = r12 + 1;
        if (r14 < r13.size()) goto L25;
    L26:
        r3 = true;
    L28:
        return new q(true, r3, r5, r12);
    L25:
        if (a((String) ZeusTransformUtils.preCheckCast(r13.get(r14), String.class, "com.obric.memorydata.plugin")) == true) goto L28;
    L29:
        if (r5 == (-1)) goto L34;
        if (r6 == true) goto L34;
        return new q(true, false, r5, r12);
    L34:
        return new q(false, false, 0, 0);
    }

    private final boolean b(String r7) {
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), '|', false, 2, null) == true) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), '-', false, 2, null) == false) goto L27;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        int r9 = 0;
    L8:
        boolean r3 = true;
        if (r9 >= r8.length()) goto L23;
        char r0 = r8.charAt(r9);
        if (r0 == '|') goto L19;
        if (r0 == '-') goto L19;
        if (r0 == ':') goto L19;
        if (CharsKt.isWhitespace(r0) == true) goto L19;
        r3 = false;
    L19:
        if (r3 == false) goto L28;
        r9 = r9 + 1;
        goto L8
    L28:
        return false;
    L23:
        return true;
    L27:
        return false;
    }

    public final void a() {
        this.f10012a = 0;
        this.f10013b = null;
        this.c = 0;
    }

    public final int update(f r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "lineCache");
        List<String> r0 = r7.a();
        if (r0.isEmpty() == false) goto L5;
        return 0;
    L5:
        int r1 = r7.c(r8);
        int r3 = r7.c(this.f10012a);
        d r4 = a(r0, r3, r1);
        if (r4.a() == true) goto L8;
    L12:
        q r2 = b(r0, r3, r1);
        if (r2.a() == true) goto L15;
    L17:
        this.f10013b = null;
        this.c = 0;
        if (r4.a() == false) goto L24;
        if (r4.b() == false) goto L24;
        int r5 = r4.d();
    L22:
        int r9 = r7.b(r5) + 1;
    L29:
        this.f10012a = RangesKt.coerceAtMost(r9, r8);
        return r8;
    L24:
        if (r2.a() == true) goto L26;
    L28:
        r9 = r8;
        goto L29
    L26:
        if (r2.b() == false) goto L28;
        r5 = r2.d();
        goto L22
    L15:
        if (r2.b() == true) goto L17;
        this.f10013b = BlockType.TABLE;
        int r10 = r2.c();
    L10:
        int r11 = r7.a(r10);
        this.c = r11;
        return RangesKt.coerceAtLeast(r11, this.f10012a);
    L8:
        if (r4.b() == true) goto L12;
        this.f10013b = BlockType.CODE_BLOCK;
        r10 = r4.c();
        goto L10
    }
}
