package com.larksuite.component.card.component.text;

import com.larksuite.component.card.protocol.component.BaseComponentShareData;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larksuite/component/card/component/text/UniversalCardTextShareData;", "Lcom/larksuite/component/card/protocol/component/BaseComponentShareData;", "id", "", "<init>", "(Ljava/lang/String;)V", "totalTextLines", "", "getTotalTextLines", "()I", "setTotalTextLines", "(I)V", "textInfoList", "", "Lcom/larksuite/component/card/component/text/UniversalCardTextShareData$TextLineInfo;", "getAvailableLines", "textId", "calcAvailableLines", "tryOccupyLines", "lines", "TextLineInfo", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UniversalCardTextShareData extends BaseComponentShareData {
    public static final a Companion = null;
    private static final String TAG = "UniversalCardTextShareData";
    private final List<b> textInfoList;
    private int totalTextLines;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final String a;
        public int b;
        public int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "TextLineInfo(textId=" + this.a + ", availableLines=" + this.b + ", occupiedLines=" + this.c + ')';
        }

        public b(String r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "textId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        Companion = new a();
    }

    public final int getTotalTextLines() {
        return this.totalTextLines;
    }

    public UniversalCardTextShareData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        super(r2);
        this.totalTextLines = LKUIToast.DURATION_MAX;
        this.textInfoList = new ArrayList();
    }

    private final int calcAvailableLines(String r6) {
        int r0 = this.totalTextLines;
        Iterator<b> r1 = this.textInfoList.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        b r2 = r1.next();
        if (Intrinsics.areEqual(r2.a, r6) == true) goto L8;
        r0 = r0 - r2.c;
        if (r0 >= 0) goto L4;
        r0 = 0;
        goto L13
    L8:
        return RangesKt.coerceAtLeast(r0, 0);
    L13:
        return RangesKt.coerceAtLeast(r0, 0);
    }

    public final int getAvailableLines(String r2) {
        Intrinsics.checkNotNullParameter(r2, "textId");
        return calcAvailableLines(r2);
    }

    public final void setTotalTextLines(int r1) {
        this.totalTextLines = r1;
    }

    public final b tryOccupyLines(String r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "textId");
        int r0 = calcAvailableLines(r6);
        if (r0 >= r7) goto L6;
        r7 = r0;
    L6:
        Log.d(TAG, "tryOccupyLines, id: " + r6 + ", avail: " + r0 + ", occ: " + r7);
        Iterator<T> r1 = this.textInfoList.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r3 = r1.next();
        if (Intrinsics.areEqual(((b) r3).a, r6) == false) goto L8;
    L13:
        b r4 = (b) r3;
        if (r4 == null) goto L17;
        Log.d(TAG, "tryOccupyLines, find and update");
        r4.b = r0;
        r4.c = r7;
        return r4;
    L17:
        Log.d(TAG, "tryOccupyLines, create new");
        b r2 = new b(r6, r0, r7);
        this.textInfoList.add(r2);
        return r2;
    L12:
        r3 = null;
        goto L13
    }
}
