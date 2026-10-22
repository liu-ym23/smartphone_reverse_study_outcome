package com.bytedance.android.livesdk.init;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "LivePreinitUnit", "LiveBaseinitUnit", "LivePlayerInitUnit", "LiveCommunityInitUnit", "LiveInteractInitUnit", "LiveMultiLinkInitUnit", "LiveOpenPlatformInitUnit", "LiveRevenueInitUnit", "LiveOtherInitUnit", "LiveOtherLazyInitUnit", "LiveBroadcastInitUnit", "LiveCompleteAfterInitUnit", "LivesdkInitUnit", "LiveInitLazyTaskUnit", "LiveInitLazyTaskUnit_V2", "LiveRevenueLazyInitUnit", "LiveInitLiveIOTask", "LiveEnsureLazyUnit", "live-spi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveInitUnitKey extends Enum<LiveInitUnitKey> {
    private static final /* synthetic */ LiveInitUnitKey[] $VALUES = null;
    public static final LiveInitUnitKey LiveBaseinitUnit = null;
    public static final LiveInitUnitKey LiveBroadcastInitUnit = null;
    public static final LiveInitUnitKey LiveCommunityInitUnit = null;
    public static final LiveInitUnitKey LiveCompleteAfterInitUnit = null;
    public static final LiveInitUnitKey LiveEnsureLazyUnit = null;
    public static final LiveInitUnitKey LiveInitLazyTaskUnit = null;
    public static final LiveInitUnitKey LiveInitLazyTaskUnit_V2 = null;
    public static final LiveInitUnitKey LiveInitLiveIOTask = null;
    public static final LiveInitUnitKey LiveInteractInitUnit = null;
    public static final LiveInitUnitKey LiveMultiLinkInitUnit = null;
    public static final LiveInitUnitKey LiveOpenPlatformInitUnit = null;
    public static final LiveInitUnitKey LiveOtherInitUnit = null;
    public static final LiveInitUnitKey LiveOtherLazyInitUnit = null;
    public static final LiveInitUnitKey LivePlayerInitUnit = null;
    public static final LiveInitUnitKey LivePreinitUnit = null;
    public static final LiveInitUnitKey LiveRevenueInitUnit = null;
    public static final LiveInitUnitKey LiveRevenueLazyInitUnit = null;
    public static final LiveInitUnitKey LivesdkInitUnit = null;

    static {
        LiveInitUnitKey r1 = new LiveInitUnitKey("LivePreinitUnit", 0);
        LivePreinitUnit = r1;
        LiveInitUnitKey r2 = new LiveInitUnitKey("LiveBaseinitUnit", 1);
        LiveBaseinitUnit = r2;
        LiveInitUnitKey r3 = new LiveInitUnitKey("LivePlayerInitUnit", 2);
        LivePlayerInitUnit = r3;
        LiveInitUnitKey r4 = new LiveInitUnitKey("LiveCommunityInitUnit", 3);
        LiveCommunityInitUnit = r4;
        LiveInitUnitKey r5 = new LiveInitUnitKey("LiveInteractInitUnit", 4);
        LiveInteractInitUnit = r5;
        LiveInitUnitKey r6 = new LiveInitUnitKey("LiveMultiLinkInitUnit", 5);
        LiveMultiLinkInitUnit = r6;
        LiveInitUnitKey r7 = new LiveInitUnitKey("LiveOpenPlatformInitUnit", 6);
        LiveOpenPlatformInitUnit = r7;
        LiveInitUnitKey r8 = new LiveInitUnitKey("LiveRevenueInitUnit", 7);
        LiveRevenueInitUnit = r8;
        LiveInitUnitKey r9 = new LiveInitUnitKey("LiveOtherInitUnit", 8);
        LiveOtherInitUnit = r9;
        LiveInitUnitKey r10 = new LiveInitUnitKey("LiveOtherLazyInitUnit", 9);
        LiveOtherLazyInitUnit = r10;
        LiveInitUnitKey r11 = new LiveInitUnitKey("LiveBroadcastInitUnit", 10);
        LiveBroadcastInitUnit = r11;
        LiveInitUnitKey r13 = new LiveInitUnitKey("LiveCompleteAfterInitUnit", 11);
        LiveCompleteAfterInitUnit = r13;
        LiveInitUnitKey r14 = new LiveInitUnitKey("LivesdkInitUnit", 12);
        LivesdkInitUnit = r14;
        LiveInitUnitKey r15 = new LiveInitUnitKey("LiveInitLazyTaskUnit", 13);
        LiveInitLazyTaskUnit = r15;
        LiveInitUnitKey r16 = new LiveInitUnitKey("LiveInitLazyTaskUnit_V2", 14);
        LiveInitLazyTaskUnit_V2 = r16;
        LiveInitUnitKey r17 = new LiveInitUnitKey("LiveRevenueLazyInitUnit", 15);
        LiveRevenueLazyInitUnit = r17;
        LiveInitUnitKey r18 = new LiveInitUnitKey("LiveInitLiveIOTask", 16);
        LiveInitLiveIOTask = r18;
        LiveInitUnitKey r19 = new LiveInitUnitKey("LiveEnsureLazyUnit", 17);
        LiveEnsureLazyUnit = r19;
        $VALUES = new LiveInitUnitKey[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19};
    }

    public static LiveInitUnitKey valueOf(String r1) {
        return (LiveInitUnitKey) r27.a.a(LiveInitUnitKey.class, r1);
    }

    public static LiveInitUnitKey[] values() {
        return (LiveInitUnitKey[]) $VALUES.clone();
    }

    private LiveInitUnitKey(String r1, int r2) {
        super(r1, r2);
    }
}
