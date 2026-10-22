package com.ss.android.lark.inline.ai.api.ui;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/Operates;", "Ljava/io/Serializable;", "show", "", "data", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/inline/ai/api/ui/Operate;", "Lkotlin/collections/ArrayList;", "<init>", "(ZLjava/util/ArrayList;)V", "getShow", "()Z", "setShow", "(Z)V", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "toString", "", "component1", "component2", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class Operates implements Serializable {
    private ArrayList<Operate> data;
    private boolean show;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Operates copy$default(Operates r0, boolean r1, ArrayList r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.show;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.data;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.show;
    }

    public final ArrayList<Operate> component2() {
        return this.data;
    }

    public final Operates copy(boolean r2, ArrayList<Operate> r3) {
        return new Operates(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Operates) == true) goto L8;
        return false;
    L8:
        Operates r6 = (Operates) r5;
        if (this.show == r6.show) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.show == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        ArrayList<Operate> r2 = this.data;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "Operates(show=" + this.show + ", data=" + this.data + ')';
    }

    public final ArrayList<Operate> getData() {
        return this.data;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final void setData(ArrayList<Operate> r1) {
        this.data = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }

    public Operates(boolean r1, ArrayList<Operate> r2) {
        this.show = r1;
        this.data = r2;
    }

    public /* synthetic */ Operates(boolean r1, ArrayList r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
