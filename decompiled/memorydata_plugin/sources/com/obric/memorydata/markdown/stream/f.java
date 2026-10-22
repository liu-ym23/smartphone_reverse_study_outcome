package com.obric.memorydata.markdown.stream;

import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eJ\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/markdown/stream/IncrementalLineCache;", "", "<init>", "()V", "lines", "", "", "lastParsedPos", "", "incompleteLineStart", BuildConfig.CHANNEL, "", "fullText", "getLines", "", "getLineCount", "getLineStartPos", "lineIndex", "getLineEndPos", "findLineIndexByPos", "charPos", "reset", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f10018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10019b;
    private int c;

    public f() {
        this.f10018a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public final int a(int r6) {
        int r7 = RangesKt.coerceAtMost(r6, this.f10018a.size());
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r7) goto L5;
        r1 = r1 + (((String) ZeusTransformUtils.preCheckCast(this.f10018a.get(r0), String.class, "com.obric.memorydata.plugin")).length() + 1);
        r0 = r0 + 1;
        goto L3
    L5:
        return r1;
    }

    public final List<String> a() {
        return this.f10018a;
    }

    public final int b(int r3) {
        int r0 = a(r3);
        String r2 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(this.f10018a, r3), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        int r4 = r2.length();
    L7:
        return r0 + r4;
    L5:
        r4 = 0;
        goto L7
    }

    public final void b() {
        this.f10018a.clear();
        this.f10019b = 0;
        this.c = 0;
    }

    public final int c(int r8) {
        int r0 = ((Collection) ZeusTransformUtils.preCheckCast(this.f10018a, Collection.class, "com.obric.memorydata.plugin")).size();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r0) goto L9;
        r4 = (r4 + ((String) ZeusTransformUtils.preCheckCast(this.f10018a.get(r3), String.class, "com.obric.memorydata.plugin")).length()) + 1;
        if (r8 < r4) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return RangesKt.coerceAtLeast(CollectionsKt.getLastIndex(this.f10018a), 0);
    }

    public final void update(String r10) {
        Intrinsics.checkNotNullParameter(r10, "fullText");
        if (r10.length() >= this.f10019b) goto L5;
        b();
    L5:
        int r0 = this.c;
    L7:
        if (r0 >= r10.length()) goto L20;
        int r1 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), '\n', r0, false, 4, null);
        if (r1 == (-1)) goto L10;
        String r2 = r10.substring(r0, r1);
        Intrinsics.checkNotNullExpressionValue(r2, "substring(...)");
        if (r0 == this.c) goto L14;
    L17:
        this.f10018a.add(r2);
    L18:
        r0 = r1 + 1;
        this.c = r0;
        goto L7
    L14:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f10018a, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        if (r0 <= 0) goto L17;
        List<String> r3 = this.f10018a;
        r3.set(CollectionsKt.getLastIndex(r3), ((String) ZeusTransformUtils.preCheckCast(CollectionsKt.last(this.f10018a), String.class, "com.obric.memorydata.plugin")) + r2);
        goto L18
    L10:
        this.c = r0;
    L20:
        if (this.c >= r10.length()) goto L36;
        String r4 = r10.substring(this.c);
        Intrinsics.checkNotNullExpressionValue(r4, "substring(...)");
        if (this.f10018a.isEmpty() == false) goto L24;
    L23:
        this.f10018a.add(r4);
        goto L36
    L24:
        int r5 = this.f10019b;
        int r6 = this.c;
        if (r5 > r6) goto L34;
        if (r6 <= 0) goto L33;
        Character r7 = StringsKt.getOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), this.c - 1);
        if (r7 == null) goto L33;
        if (r7.charValue() == '\n') goto L23;
    L33:
        List<String> r8 = this.f10018a;
        int r9 = CollectionsKt.getLastIndex(r8);
        r4 = ((String) ZeusTransformUtils.preCheckCast(CollectionsKt.last(this.f10018a), String.class, "com.obric.memorydata.plugin")) + r4;
    L35:
        r8.set(r9, r4);
        goto L36
    L34:
        r8 = this.f10018a;
        r9 = CollectionsKt.getLastIndex(r8);
    L36:
        this.f10019b = r10.length();
    }
}
