package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftLynxPageConfig;", BuildConfig.FLAVOR, "pageType", BuildConfig.FLAVOR, "pageSchema", BuildConfig.FLAVOR, "(Ljava/lang/Integer;Ljava/lang/String;)V", "getPageSchema", "()Ljava/lang/String;", "getPageType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftLynxPageConfig {
    private final String pageSchema;
    private final Integer pageType;

    /* JADX WARN: Multi-variable type inference failed */
    public GiftLynxPageConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public final String getPageSchema() {
        return this.pageSchema;
    }

    public final Integer getPageType() {
        return this.pageType;
    }

    public GiftLynxPageConfig(Integer r1, String r2) {
        this.pageType = r1;
        this.pageSchema = r2;
    }

    public /* synthetic */ GiftLynxPageConfig(Integer r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
