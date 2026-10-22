package com.obric.aiproactive.ui.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/obric/aiproactive/ui/model/FeedPageUiState;", "", "batchId", "", "loading", "", "items", "", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "showTip", "<init>", "(JZLjava/util/List;Z)V", "getBatchId", "()J", "getLoading", "()Z", "getItems", "()Ljava/util/List;", "getShowTip", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6726b;
    private final List<j> c;
    private final boolean d;

    public g() {
        this(0, false, null, false, 15, null);
    }

    public g(long r3, boolean r5, List<? extends j> r6, boolean r7) {
        List<j> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "items");
        this.f6725a = r3;
        this.f6726b = r5;
        this.c = r8;
        this.d = r7;
    }

    public /* synthetic */ g(long r7, boolean r9, List r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = 0;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        boolean r3 = false;
    L10:
        if ((r12 & 4) == 0) goto L12;
        r14 = CollectionsKt.emptyList();
    L12:
        List r4 = r14;
        if ((r12 & 8) == 0) goto L15;
        boolean r5 = false;
    L16:
        this(r1, r3, r4, r5);
        return;
    L15:
        r5 = r11;
        goto L16
    L8:
        r3 = r9;
        goto L10
    }

    public static /* synthetic */ g a(g r6, long r7, boolean r9, List r10, boolean r11, int r12, Object r13) {
        List<j> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.f6725a;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.f6726b;
    L8:
        boolean r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r14 = r6.c;
    L11:
        List<j> r4 = r14;
        if ((r12 & 8) == 0) goto L15;
        r11 = r6.d;
    L15:
        return r6.a(r1, r3, r4, r11);
    }

    public final long a() {
        return this.f6725a;
    }

    public final g a(long r7, boolean r9, List<? extends j> r10, boolean r11) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "items");
        return new g(r7, r9, r4, r11);
    }

    public final boolean b() {
        return this.f6726b;
    }

    public final List<j> c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
        return false;
    L8:
        g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.memorydata.plugin");
        if (this.f6725a == r10.f6725a) goto L12;
        return false;
    L12:
        if (this.f6726b == r10.f6726b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f6725a) * 31) + Boolean.hashCode(this.f6726b)) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "FeedPageUiState(batchId=" + this.f6725a + ", loading=" + this.f6726b + ", items=" + this.c + ", showTip=" + this.d + ')';
    }
}
