package com.bytedance.android.livesdk.gift.platform.business.effect.service;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Operation", "MediaDecorationBehindSeat", "MediaDecorationFrontSeat", "FourthLineCard", "MediaContainer", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ViewIdentifier extends Enum<ViewIdentifier> {
    public static final ViewIdentifier FourthLineCard = null;
    public static final ViewIdentifier MediaContainer = null;
    public static final ViewIdentifier MediaDecorationBehindSeat = null;
    public static final ViewIdentifier MediaDecorationFrontSeat = null;
    public static final ViewIdentifier Operation = null;
    public static final /* synthetic */ ViewIdentifier[] a = null;
    private final String value;

    static {
        ViewIdentifier r1 = new ViewIdentifier("Operation", 0, "operation");
        Operation = r1;
        ViewIdentifier r2 = new ViewIdentifier("MediaDecorationBehindSeat", 1, "media_decoration_behind_seat");
        MediaDecorationBehindSeat = r2;
        ViewIdentifier r3 = new ViewIdentifier("MediaDecorationFrontSeat", 2, "media_decoration_front_seat");
        MediaDecorationFrontSeat = r3;
        ViewIdentifier r4 = new ViewIdentifier("FourthLineCard", 3, "fourth_line");
        FourthLineCard = r4;
        ViewIdentifier r5 = new ViewIdentifier("MediaContainer", 4, "media_container");
        MediaContainer = r5;
        a = new ViewIdentifier[]{r1, r2, r3, r4, r5};
    }

    public static ViewIdentifier valueOf(String r1) {
        return (ViewIdentifier) a.a(ViewIdentifier.class, r1);
    }

    public static ViewIdentifier[] values() {
        return (ViewIdentifier[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ViewIdentifier(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
