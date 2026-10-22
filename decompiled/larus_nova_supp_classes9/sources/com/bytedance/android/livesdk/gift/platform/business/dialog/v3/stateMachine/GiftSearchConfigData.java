package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u000e\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\t\u001a\u00020\u0007HÆ\u0003J;\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001f\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\r\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\r\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftSearchConfigData;", BuildConfig.FLAVOR, "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "component1", BuildConfig.FLAVOR, "component2", BuildConfig.FLAVOR, "component3", "component4", "icon", "schema", "closeGiftPanel", "isNormalSearch", "copy", "toString", BuildConfig.FLAVOR, "hashCode", "other", "equals", "Lpy/k;", "getIcon", "()Lpy/k;", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "Z", "getCloseGiftPanel", "()Z", "<init>", "(Lpy/k;Ljava/lang/String;ZZ)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftSearchConfigData {
    private final boolean closeGiftPanel;
    private final k icon;
    private final boolean isNormalSearch;
    private final String schema;

    public static /* synthetic */ GiftSearchConfigData copy$default(GiftSearchConfigData r0, k r1, String r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.icon;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.schema;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.closeGiftPanel;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.isNormalSearch;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final k component1() {
        return this.icon;
    }

    public final String component2() {
        return this.schema;
    }

    public final boolean component3() {
        return this.closeGiftPanel;
    }

    public final boolean component4() {
        return this.isNormalSearch;
    }

    public final GiftSearchConfigData copy(k r2, String r3, boolean r4, boolean r5) {
        return new GiftSearchConfigData(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof GiftSearchConfigData) == false) goto L14;
        GiftSearchConfigData r4 = (GiftSearchConfigData) r3;
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L10;
        return false;
    L10:
        if (this.closeGiftPanel == r4.closeGiftPanel) goto L12;
        return false;
    L12:
        if (this.isNormalSearch == r4.isNormalSearch) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        k r0 = this.icon;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.schema;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.closeGiftPanel;
        ?? r7 = 1;
        ?? r8 = r6;
        if (r6 == false) goto L12;
        r8 = 1;
    L12:
        int r9 = (r5 + r8) * 31;
        boolean r10 = this.isNormalSearch;
        if (r10 == true) goto L17;
        r7 = r10;
    L17:
        return r9 + r7;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "GiftSearchConfigData(icon=" + this.icon + ", schema=" + this.schema + ", closeGiftPanel=" + this.closeGiftPanel + ", isNormalSearch=" + this.isNormalSearch + ")";
    }

    public final boolean getCloseGiftPanel() {
        return this.closeGiftPanel;
    }

    public final k getIcon() {
        return this.icon;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final boolean isNormalSearch() {
        return this.isNormalSearch;
    }

    public GiftSearchConfigData(k r1, String r2, boolean r3, boolean r4) {
        this.icon = r1;
        this.schema = r2;
        this.closeGiftPanel = r3;
        this.isNormalSearch = r4;
    }
}
