package com.bytedance.android.livesdk.gift.configmodel;

import android.text.TextUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R*\u0010'\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/s1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "a", "()Z", "setEnable", "(Z)V", BuildConfig.FLAVOR, "dailyMaxTimes", "I", "getDailyMaxTimes", "()I", "setDailyMaxTimes", "(I)V", "defaultGapTimes", "getDefaultGapTimes", "setDefaultGapTimes", "gapDays", "getGapDays", "setGapDays", BuildConfig.FLAVOR, "noticeText", "Ljava/lang/String;", "getNoticeText", "()Ljava/lang/String;", "setNoticeText", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "level2GapTimes", "Ljava/util/List;", "getLevel2GapTimes", "()Ljava/util/List;", "setLevel2GapTimes", "(Ljava/util/List;)V", "level2MaxShowTimes", "getLevel2MaxShowTimes", "setLevel2MaxShowTimes", "level2GapDays", "getLevel2GapDays", "setLevel2GapDays", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s1 {

    @SerializedName("max_show_times")
    private int dailyMaxTimes;

    @SerializedName("default_gap_times")
    private int defaultGapTimes;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("gap_days")
    private int gapDays;

    @SerializedName("level_to_gap_days")
    private List<Integer> level2GapDays;

    @SerializedName("level_to_gap_times")
    private List<Integer> level2GapTimes;

    @SerializedName("level_to_max_show_times")
    private List<Integer> level2MaxShowTimes;

    @SerializedName("notice_text")
    private String noticeText;

    public s1() {
        this.dailyMaxTimes = 10;
        this.defaultGapTimes = 2;
        this.gapDays = 1;
        this.noticeText = "平台严禁未成年人打赏消费";
    }

    public final int b() {
        int r0 = ay1.b.u();
        List<Integer> r1 = this.level2GapDays;
        if (r1 == null) goto L8;
        Integer r2 = (Integer) CollectionsKt.getOrNull(r1, r0);
        if (r2 == null) goto L8;
        return r2.intValue();
    L8:
        return this.gapDays;
    }

    public final int c() {
        int r0 = ay1.b.u();
        List<Integer> r1 = this.level2GapTimes;
        if (r1 == null) goto L8;
        Integer r2 = (Integer) CollectionsKt.getOrNull(r1, r0);
        if (r2 == null) goto L8;
        return r2.intValue();
    L8:
        return this.defaultGapTimes;
    }

    public final int d() {
        int r0 = ay1.b.u();
        List<Integer> r1 = this.level2MaxShowTimes;
        if (r1 == null) goto L7;
        Integer r2 = (Integer) CollectionsKt.getOrNull(r1, r0);
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L9:
        if (nz1.a.f().b() == true) goto L11;
        return r3;
    L11:
        return r3 + nz1.a.f().c();
    L7:
        r3 = this.dailyMaxTimes;
        goto L9
    }

    public final String e() {
        if (nz1.a.f().b() == false) goto L20;
        boolean r1 = false;
        if (nz1.a.f().a().length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L20;
        com.bytedance.tools.kcp.spongepreference.runtime.a r2 = ay1.b.m0;
        KProperty[] r3 = ay1.b.a;
        if (((String) r2.getValue(null, r3[76])).length() != 0) goto L12;
        r1 = true;
    L12:
        if (r1 == true) goto L18;
        if (TextUtils.equals((String) r2.getValue(null, r3[76]), this.noticeText) == true) goto L18;
        return this.noticeText;
    L18:
        return nz1.a.f().a();
    L7:
        r0 = false;
    L20:
        return this.noticeText;
    }

    public final boolean a() {
        return this.enable;
    }
}
