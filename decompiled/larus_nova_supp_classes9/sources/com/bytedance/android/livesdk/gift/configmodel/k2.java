package com.bytedance.android.livesdk.gift.configmodel;

import androidx.lifecycle.LiveData;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncData;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.kmp.core.KmpEnv;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/k2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "giftGuideFollowShowDelay", "J", "b", "()J", "setGiftGuideFollowShowDelay", "(J)V", "giftGuideUnFollowShowDelay", "getGiftGuideUnFollowShowDelay", "setGiftGuideUnFollowShowDelay", "giftGuideLoopTime", "getGiftGuideLoopTime", "setGiftGuideLoopTime", BuildConfig.FLAVOR, "giftGuideMaxTimes", "I", "getGiftGuideMaxTimes", "()I", "setGiftGuideMaxTimes", "(I)V", BuildConfig.FLAVOR, "giftWebpUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setGiftWebpUrl", "(Ljava/lang/String;)V", "<init>", "()V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k2 {
    public static final /* synthetic */ int b = 0;
    public Map<String, String> a;

    @SerializedName("gift_guide_follow_show_delay")
    private long giftGuideFollowShowDelay;

    @SerializedName("gift_guide_loop_time")
    private long giftGuideLoopTime;

    @SerializedName("gift_guide_max_times")
    private int giftGuideMaxTimes;

    @SerializedName("gift_guide_unfollow_show_delay")
    private long giftGuideUnFollowShowDelay;

    @SerializedName("gift_webp_url")
    private String giftWebpUrl;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Map<String, String> r0 = new LinkedHashMap();
        LiveData r1 = vh6.c.b(tr2.a.class).Ki("live_rev_animation_config", r0);
        if (r1 == null) goto L8;
        Map<String, String> r2 = (Map) r1.getValue();
        if (r2 == null) goto L8;
        r0 = r2;
    L8:
        this.a = r0;
    }

    public final long d() {
        if (this.a != null) goto L5;
        a();
    L5:
        Map<String, String> r0 = this.a;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L23;
        Map<String, String> r2 = this.a;
        if (r2 == null) goto L22;
        String r3 = r2.get("giftGuideFollowShowDelay");
        if (r3 == null) goto L22;
        Long r4 = StringsKt.toLongOrNull(r3);
        if (r4 == null) goto L22;
        return r4.longValue();
    L22:
        return this.giftGuideFollowShowDelay;
    L23:
        return this.giftGuideFollowShowDelay;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    }

    public final long e() {
        if (this.a != null) goto L5;
        a();
    L5:
        Map<String, String> r0 = this.a;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L23;
        Map<String, String> r2 = this.a;
        if (r2 == null) goto L22;
        String r3 = r2.get("giftGuideLoopTime");
        if (r3 == null) goto L22;
        Long r4 = StringsKt.toLongOrNull(r3);
        if (r4 == null) goto L22;
        return r4.longValue();
    L22:
        return this.giftGuideLoopTime;
    L23:
        return this.giftGuideLoopTime;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    }

    public final int f() {
        if (this.a != null) goto L5;
        a();
    L5:
        Map<String, String> r0 = this.a;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L23;
        Map<String, String> r2 = this.a;
        if (r2 == null) goto L22;
        String r3 = r2.get("giftGuideMaxTimes");
        if (r3 == null) goto L22;
        Integer r4 = StringsKt.toIntOrNull(r3);
        if (r4 == null) goto L22;
        return r4.intValue();
    L22:
        return this.giftGuideMaxTimes;
    L23:
        return this.giftGuideMaxTimes;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    }

    public final long g() {
        if (this.a != null) goto L5;
        a();
    L5:
        Map<String, String> r0 = this.a;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L23;
        Map<String, String> r2 = this.a;
        if (r2 == null) goto L22;
        String r3 = r2.get("giftGuideUnFollowShowDelay");
        if (r3 == null) goto L22;
        Long r4 = StringsKt.toLongOrNull(r3);
        if (r4 == null) goto L22;
        return r4.longValue();
    L22:
        return this.giftGuideUnFollowShowDelay;
    L23:
        return this.giftGuideUnFollowShowDelay;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    }

    public k2() {
        this.giftGuideFollowShowDelay = RiskAdviseSyncData.PRIORITY;
        this.giftGuideUnFollowShowDelay = 70000;
        this.giftGuideLoopTime = RiskAdviseSyncData.PRIORITY;
        this.giftGuideMaxTimes = 10;
        KmpEnv r0 = KmpEnv.a;
        KmpEnv.a();
        this.giftWebpUrl = "https://p3.douyinpic.com/aweme-client-static-resource/dy_gift_motion.webp~tplv-obj.image";
    }

    public final long b() {
        return this.giftGuideFollowShowDelay;
    }

    public final String c() {
        return this.giftWebpUrl;
    }
}
