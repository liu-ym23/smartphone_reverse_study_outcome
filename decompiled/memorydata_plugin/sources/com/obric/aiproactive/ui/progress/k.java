package com.obric.aiproactive.ui.progress;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/aiproactive/ui/progress/AgentRunUiGroup;", "", OaidModel.KEY_ID, "", "title", "items", "", "Lcom/obric/aiproactive/ui/progress/AgentRunUiItem;", "listStyle", "Lcom/obric/aiproactive/ui/progress/AgentRunSecondaryListStyle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/obric/aiproactive/ui/progress/AgentRunSecondaryListStyle;)V", "getId", "()Ljava/lang/String;", "getTitle", "getItems", "()Ljava/util/List;", "getListStyle", "()Lcom/obric/aiproactive/ui/progress/AgentRunSecondaryListStyle;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6828b;
    private final List<l> c;
    private final AgentRunSecondaryListStyle d;

    public k(String r3, String r4, List<l> r5, AgentRunSecondaryListStyle r6) {
        List<l> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r7, "items");
        Intrinsics.checkNotNullParameter(r6, "listStyle");
        this.f6827a = r3;
        this.f6828b = r4;
        this.c = r7;
        this.d = r6;
    }

    public /* synthetic */ k(String r2, String r3, List r4, AgentRunSecondaryListStyle r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L5;
        r5 = AgentRunSecondaryListStyle.UNORDERED;
    L5:
        this(r2, r3, r8, r5);
    }

    public static /* synthetic */ k a(k r1, String r2, String r3, List r4, AgentRunSecondaryListStyle r5, int r6, Object r7) {
        List<l> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.f6827a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.f6828b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.c;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.d;
    L15:
        return r1.a(r2, r3, r8, r5);
    }

    public final k a(String r2, String r3, List<l> r4, AgentRunSecondaryListStyle r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r1, "items");
        Intrinsics.checkNotNullParameter(r5, "listStyle");
        return new k(r2, r3, r1, r5);
    }

    public final String a() {
        return this.f6827a;
    }

    public final String b() {
        return this.f6828b;
    }

    public final List<l> c() {
        return this.c;
    }

    public final AgentRunSecondaryListStyle d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6827a, r6.f6827a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6828b, r6.f6828b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f6827a.hashCode() * 31) + this.f6828b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "AgentRunUiGroup(id=" + this.f6827a + ", title=" + this.f6828b + ", items=" + this.c + ", listStyle=" + this.d + ')';
    }
}
