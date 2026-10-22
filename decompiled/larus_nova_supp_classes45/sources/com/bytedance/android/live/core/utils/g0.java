package com.bytedance.android.live.core.utils;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/core/utils/g0;", "", "", "feedUrl", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setFeedUrl", "(Ljava/lang/String;)V", "followFeedUrl", "b", "setFollowFeedUrl", "topFollowUrl", "d", "multiFeedUrl", "c", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("feed_url")
    private String feedUrl;

    @SerializedName("follow_feed_url")
    private String followFeedUrl;

    @SerializedName("multi_feed_url")
    private final String multiFeedUrl;

    @SerializedName("top_follow_url")
    private final String topFollowUrl;

    public static final class a {
        @JvmStatic
        public static String a(int r4) {
            String r0 = null;
            boolean r1 = false;
            switch(r4) {
                case 1000: goto L42;
                case 1001: goto L29;
                case 1002: goto L54;
                case 1003: goto L17;
                case 1004: goto L5;
                default: goto L54;
            };
        L5:
            SettingKey r5 = LiveConfigSettingKeys.LIVE_FEED_URL;
            g0 r3 = (g0) r5.getValue();
            if (r3 == null) goto L54;
            String r6 = r3.c();
            if (r6 == null) goto L54;
            if (r6.length() <= 0) goto L12;
            r1 = true;
        L12:
            if (r1 != true) goto L54;
            g0 r7 = (g0) r5.getValue();
            if (r7 == null) goto L16;
            r0 = r7.c();
        L16:
            Intrinsics.checkNotNull(r0);
            return r0;
        L17:
            SettingKey r8 = LiveConfigSettingKeys.LIVE_FEED_URL;
            g0 r9 = (g0) r8.getValue();
            if (r9 == null) goto L41;
            String r11 = r9.d();
            if (r11 == null) goto L41;
            if (r11.length() <= 0) goto L24;
            r1 = true;
        L24:
            if (r1 != true) goto L41;
            g0 r12 = (g0) r8.getValue();
            if (r12 == null) goto L28;
            r0 = r12.d();
        L28:
            Intrinsics.checkNotNull(r0);
            return r0;
        L41:
            return "https://webcast-open.douyin.com/webcast/openapi/feed/";
        L29:
            SettingKey r13 = LiveConfigSettingKeys.LIVE_FEED_URL;
            g0 r14 = (g0) r13.getValue();
            if (r14 == null) goto L41;
            String r15 = r14.b();
            if (r15 == null) goto L41;
            if (r15.length() <= 0) goto L36;
            r1 = true;
        L36:
            if (r1 != true) goto L41;
            g0 r16 = (g0) r13.getValue();
            if (r16 == null) goto L40;
            r0 = r16.b();
        L40:
            Intrinsics.checkNotNull(r0);
            return r0;
        L42:
            SettingKey r17 = LiveConfigSettingKeys.LIVE_FEED_URL;
            g0 r18 = (g0) r17.getValue();
            if (r18 == null) goto L54;
            String r19 = r18.a();
            if (r19 == null) goto L54;
            if (r19.length() <= 0) goto L49;
            r1 = true;
        L49:
            if (r1 != true) goto L54;
            g0 r21 = (g0) r17.getValue();
            if (r21 == null) goto L53;
            r0 = r21.a();
        L53:
            Intrinsics.checkNotNull(r0);
            return r0;
        L54:
            return "https://webcast-open.douyin.com/webcast/openapi/feed/?channel_id=162001";
        }
    }

    static {
    }

    public g0() {
    }

    public final String a() {
        return this.feedUrl;
    }

    public final String b() {
        return this.followFeedUrl;
    }

    public final String c() {
        return this.multiFeedUrl;
    }

    public final String d() {
        return this.topFollowUrl;
    }
}
