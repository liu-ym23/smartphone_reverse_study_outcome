package com.obric.memorydata.memory.ui.automemory.create;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/CreateTaskImeHeightCacheRecord;", "", "key", "Lcom/obric/memorydata/memory/ui/automemory/create/CreateTaskImeHeightCacheKey;", "imeBottomPx", "", "<init>", "(Lcom/obric/memorydata/memory/ui/automemory/create/CreateTaskImeHeightCacheKey;I)V", "getKey", "()Lcom/obric/memorydata/memory/ui/automemory/create/CreateTaskImeHeightCacheKey;", "getImeBottomPx", "()I", "encode", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10667a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f10668b;
    private final int c;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/CreateTaskImeHeightCacheRecord$Companion;", "", "<init>", "()V", "VERSION", "", "SEPARATOR", "decode", "Lcom/obric/memorydata/memory/ui/automemory/create/CreateTaskImeHeightCacheRecord;", EventBody.KEY_VALUE, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final e a(String r9) {
            Intrinsics.checkNotNullParameter(r9, EventBody.KEY_VALUE);
            List r10 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"\u001f"}, false, 6, 2, null);
            Object r2 = null;
            if (r10.size() == 6) goto L5;
        L23:
            return null;
        L5:
            if (Intrinsics.areEqual(r10.get(0), "1") == false) goto L23;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
            a r8 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            int r11 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r10.get(1), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
            int r1 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r10.get(2), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
            int r3 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r10.get(3), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
            int r4 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r10.get(4), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
            if (r11 <= 0) goto L14;
            if (r1 <= 0) goto L14;
            if (r4 <= 0) goto L14;
            Object r12 = Result.m1421constructorimpl(new e(new d(r11, r1, r3, (String) ZeusTransformUtils.preCheckCast(r10.get(5), String.class, "com.obric.memorydata.plugin")), r4));     // Catch: Throwable -> L15
        L18:
            if (Result.m1427isFailureimpl(r12) == true) goto L22;
            r2 = r12;
        L22:
            return (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.memorydata.plugin");
        L14:
            return null;
        L15:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L18
        }
    }

    static {
        f10667a = new a(null);
    }

    public e(d r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.f10668b = r2;
        this.c = r3;
    }

    public final d a() {
        return this.f10668b;
    }

    public final int b() {
        return this.c;
    }

    public final String c() {
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new Object[]{"1", Integer.valueOf(this.f10668b.a()), Integer.valueOf(this.f10668b.b()), Integer.valueOf(this.f10668b.c()), Integer.valueOf(this.c), this.f10668b.d()}), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\u001f", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10668b, r6.f10668b) == true) goto L12;
        return false;
    L12:
        if (this.c == r6.c) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f10668b.hashCode() * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "CreateTaskImeHeightCacheRecord(key=" + this.f10668b + ", imeBottomPx=" + this.c + ')';
    }
}
