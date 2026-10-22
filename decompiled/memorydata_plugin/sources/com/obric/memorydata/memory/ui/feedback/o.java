package com.obric.memorydata.memory.ui.feedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackUiState;", "", "options", "", "Lcom/obric/memorydata/memory/ui/feedback/FeedbackOption;", "inputText", "", "loading", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Z)V", "getOptions", "()Ljava/util/List;", "getInputText", "()Ljava/lang/String;", "getLoading", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<d> f10962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10963b;
    private final boolean c;

    public o() {
        this(null, null, false, 7, null);
    }

    public o(List<d> r3, String r4, boolean r5) {
        List<d> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "options");
        Intrinsics.checkNotNullParameter(r4, "inputText");
        this.f10962a = r6;
        this.f10963b = r4;
        this.c = r5;
    }

    public /* synthetic */ o(List r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = CollectionsKt.emptyList();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r7, r3, r4);
    }

    public static /* synthetic */ o a(o r1, List r2, String r3, boolean r4, int r5, Object r6) {
        List<d> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.f10962a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.f10963b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r1.c;
    L12:
        return r1.a(r7, r3, r4);
    }

    public final o a(List<d> r2, String r3, boolean r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "options");
        Intrinsics.checkNotNullParameter(r3, "inputText");
        return new o(r1, r3, r4);
    }

    public final List<d> a() {
        return this.f10962a;
    }

    public final String b() {
        return this.f10963b;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L8;
        return false;
    L8:
        o r6 = (o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10962a, r6.f10962a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10963b, r6.f10963b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f10962a.hashCode() * 31) + this.f10963b.hashCode()) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "MemoryFeedbackUiState(options=" + this.f10962a + ", inputText=" + this.f10963b + ", loading=" + this.c + ')';
    }
}
