package com.obric.memorydata.realtimecontext.screen;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\nHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/realtimecontext/screen/ScreenViewTree;", "", "viewNodeList", "", "Lcom/obric/memorydata/realtimecontext/screen/ViewNode;", "<init>", "(Ljava/util/List;)V", "getViewNodeList", "()Ljava/util/List;", "textLength", "", "getTextLength", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenViewTree {
    public static final a Companion = null;
    private final int textLength;
    private final List<ViewNode> viewNodeList;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/realtimecontext/screen/ScreenViewTree$Companion;", "", "<init>", "()V", "fromStringList", "Lcom/obric/memorydata/realtimecontext/screen/ScreenViewTree;", "stringList", "", "", "fromViewNodeList", "inViewNodeList", "Lcom/obric/memorydata/realtimecontext/screen/ViewNode;", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public ScreenViewTree(List<ViewNode> r5) {
        List<ViewNode> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "viewNodeList");
        this.viewNodeList = r6;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L6;
        r0 = r0 + ((ViewNode) ZeusTransformUtils.preCheckCast(r7.next(), ViewNode.class, "com.obric.memorydata.plugin")).getText().length();
        goto L4
    L6:
        this.textLength = r0;
    }

    public static /* synthetic */ ScreenViewTree copy$default(ScreenViewTree r1, List r2, int r3, Object r4) {
        List<ViewNode> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.viewNodeList;
    L6:
        return r1.copy(r5);
    }

    public final List<ViewNode> component1() {
        return this.viewNodeList;
    }

    public final ScreenViewTree copy(List<ViewNode> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "viewNodeList");
        return new ScreenViewTree(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenViewTree.class) == true) goto L8;
        return false;
    L8:
        ScreenViewTree r6 = (ScreenViewTree) ZeusTransformUtils.preCheckCast(r5, ScreenViewTree.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.viewNodeList, r6.viewNodeList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int getTextLength() {
        return this.textLength;
    }

    public final List<ViewNode> getViewNodeList() {
        return this.viewNodeList;
    }

    public int hashCode() {
        return this.viewNodeList.hashCode();
    }

    public String toString() {
        return "ScreenViewTree(viewNodeList=" + this.viewNodeList + ')';
    }
}
