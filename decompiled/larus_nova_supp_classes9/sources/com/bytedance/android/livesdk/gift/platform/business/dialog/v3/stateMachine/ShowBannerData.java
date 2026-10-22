package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import android.net.Uri;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowBannerData;", BuildConfig.FLAVOR, "canShow", BuildConfig.FLAVOR, "renderParams", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "schemaUrl", "Landroid/net/Uri;", "(ZLjava/util/Map;Landroid/net/Uri;)V", "getCanShow", "()Z", "getRenderParams", "()Ljava/util/Map;", "getSchemaUrl", "()Landroid/net/Uri;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowBannerData {
    private final boolean canShow;
    private final Map<String, Object> renderParams;
    private final Uri schemaUrl;

    public ShowBannerData() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShowBannerData copy$default(ShowBannerData r0, boolean r1, Map r2, Uri r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.canShow;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.renderParams;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.schemaUrl;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.canShow;
    }

    public final Map<String, Object> component2() {
        return this.renderParams;
    }

    public final Uri component3() {
        return this.schemaUrl;
    }

    public final ShowBannerData copy(boolean r2, Map<String, ? extends Object> r3, Uri r4) {
        return new ShowBannerData(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ShowBannerData) == false) goto L12;
        ShowBannerData r4 = (ShowBannerData) r3;
        if (this.canShow == r4.canShow) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.renderParams, r4.renderParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.schemaUrl, r4.schemaUrl) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r0 = this.canShow;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        Map<String, Object> r3 = this.renderParams;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        Uri r7 = this.schemaUrl;
        if (r7 == null) goto L13;
        r4 = r7.hashCode();
    L13:
        return r6 + r4;
    L8:
        r5 = 0;
        goto L9
    }

    public String toString() {
        return "ShowBannerData(canShow=" + this.canShow + ", renderParams=" + this.renderParams + ", schemaUrl=" + this.schemaUrl + ")";
    }

    public final boolean getCanShow() {
        return this.canShow;
    }

    public final Map<String, Object> getRenderParams() {
        return this.renderParams;
    }

    public final Uri getSchemaUrl() {
        return this.schemaUrl;
    }

    public ShowBannerData(boolean r1, Map<String, ? extends Object> r2, Uri r3) {
        this.canShow = r1;
        this.renderParams = r2;
        this.schemaUrl = r3;
    }

    public /* synthetic */ ShowBannerData(boolean r2, Map r3, Uri r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
