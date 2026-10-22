package com.ss.android.lark.feed.cardcomponent.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/HandlerValueAnimator$AnimatorType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "FLOAT", "INT", "COLOR", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum HandlerValueAnimator$AnimatorType extends Enum<HandlerValueAnimator$AnimatorType> {
    public static final HandlerValueAnimator$AnimatorType COLOR = null;
    public static final HandlerValueAnimator$AnimatorType FLOAT = null;
    public static final HandlerValueAnimator$AnimatorType INT = null;
    public static final /* synthetic */ HandlerValueAnimator$AnimatorType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HandlerValueAnimator$AnimatorType> getEntries() {
        return b;
    }

    static {
        HandlerValueAnimator$AnimatorType r0 = new HandlerValueAnimator$AnimatorType("FLOAT", 0);
        FLOAT = r0;
        HandlerValueAnimator$AnimatorType r1 = new HandlerValueAnimator$AnimatorType("INT", 1);
        INT = r1;
        HandlerValueAnimator$AnimatorType r3 = new HandlerValueAnimator$AnimatorType("COLOR", 2);
        COLOR = r3;
        HandlerValueAnimator$AnimatorType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static HandlerValueAnimator$AnimatorType[] values() {
        return (HandlerValueAnimator$AnimatorType[]) a.clone();
    }

    public static HandlerValueAnimator$AnimatorType valueOf(String r1) {
        return (HandlerValueAnimator$AnimatorType) r27.a.a(HandlerValueAnimator$AnimatorType.class, r1);
    }

    public HandlerValueAnimator$AnimatorType(String r1, int r2) {
        super(r1, r2);
    }
}
