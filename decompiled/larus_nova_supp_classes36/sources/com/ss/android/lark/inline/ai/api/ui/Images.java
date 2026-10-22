package com.ss.android.lark.inline.ai.api.ui;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001&BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001c\u001a\u00020\u000bH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003J\u001d\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tHÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006'"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/Images;", "Ljava/io/Serializable;", "show", "", "status", "", "data", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/inline/ai/api/ui/ImageData;", "Lkotlin/collections/ArrayList;", "checkList", "", "<init>", "(ZILjava/util/ArrayList;Ljava/util/ArrayList;)V", "getShow", "()Z", "setShow", "(Z)V", "getStatus", "()I", "setStatus", "(I)V", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "getCheckList", "setCheckList", "toString", "component1", "component2", "component3", "component4", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "Status", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class Images implements Serializable {
    private ArrayList<String> checkList;
    private ArrayList<ImageData> data;
    private boolean show;
    private int status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Images copy$default(Images r0, boolean r1, int r2, ArrayList r3, ArrayList r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.show;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.status;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.data;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.checkList;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.show;
    }

    public final int component2() {
        return this.status;
    }

    public final ArrayList<ImageData> component3() {
        return this.data;
    }

    public final ArrayList<String> component4() {
        return this.checkList;
    }

    public final Images copy(boolean r2, int r3, ArrayList<ImageData> r4, ArrayList<String> r5) {
        return new Images(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Images) == true) goto L8;
        return false;
    L8:
        Images r6 = (Images) r5;
        if (this.show == r6.show) goto L12;
        return false;
    L12:
        if (this.status == r6.status) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.checkList, r6.checkList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.show == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.status) * 31;
        ArrayList<ImageData> r2 = this.data;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        ArrayList<String> r6 = this.checkList;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Images(show=");
        r0.append(this.show);
        r0.append(", status=");
        r0.append(this.status);
        r0.append(", data=");
        r0.append(this.data);
        r0.append(", checkList=");
        ArrayList<String> r1 = this.checkList;
        if (r1 == null) goto L8;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L9;
        r2.add(Integer.valueOf(((String) r3.next()).hashCode()));
    L9:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L8:
        r2 = null;
        goto L9
    }

    public final ArrayList<String> getCheckList() {
        return this.checkList;
    }

    public final ArrayList<ImageData> getData() {
        return this.data;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setCheckList(ArrayList<String> r1) {
        this.checkList = r1;
    }

    public final void setData(ArrayList<ImageData> r1) {
        this.data = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }

    public final void setStatus(int r1) {
        this.status = r1;
    }

    public Images(boolean r1, int r2, ArrayList<ImageData> r3, ArrayList<String> r4) {
        this.show = r1;
        this.status = r2;
        this.data = r3;
        this.checkList = r4;
    }
}
