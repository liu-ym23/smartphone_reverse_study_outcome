package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.live.base.model.message.a5;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelTouchData;", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelTouchData$a;", "component1", "rechargeButton", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelTouchData$a;", "getRechargeButton", "()Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelTouchData$a;", "<init>", "(Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelTouchData$a;)V", "a", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftPanelTouchData {
    private final a rechargeButton;

    public static final class a {
        public final a5 a;
        public final String b;
        public final Map<String, String> c;

        public a() {
            this(null, null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            a5 r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Map<String, String> r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "RechargeButton(buttonText=" + this.a + ", schema=" + this.b + ", extra=" + this.c + ")";
        }

        public a(a5 r1, String r2, Map<String, String> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public GiftPanelTouchData() {
        a r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ GiftPanelTouchData copy$default(GiftPanelTouchData r0, a r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.rechargeButton;
    L6:
        return r0.copy(r1);
    }

    public final a component1() {
        return this.rechargeButton;
    }

    public final GiftPanelTouchData copy(a r2) {
        return new GiftPanelTouchData(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof GiftPanelTouchData) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.rechargeButton, ((GiftPanelTouchData) r2).rechargeButton) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        a r0 = this.rechargeButton;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "GiftPanelTouchData(rechargeButton=" + this.rechargeButton + ")";
    }

    public final a getRechargeButton() {
        return this.rechargeButton;
    }

    public GiftPanelTouchData(a r1) {
        this.rechargeButton = r1;
    }

    public /* synthetic */ GiftPanelTouchData(a r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
