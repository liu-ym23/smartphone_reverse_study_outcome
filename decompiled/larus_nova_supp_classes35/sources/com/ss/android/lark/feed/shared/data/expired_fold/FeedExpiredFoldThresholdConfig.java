package com.ss.android.lark.feed.shared.data.expired_fold;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import keb.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@AppConfig(key = "im_feed_expired_fold_threshold")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/feed/shared/data/expired_fold/FeedExpiredFoldThresholdConfig;", BuildConfig.FLAVOR, "<init>", "()V", "expireDays", BuildConfig.FLAVOR, "getExpireDays", "()Ljava/lang/Integer;", "setExpireDays", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "localeDisplayWords", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/ss/android/lark/feed/shared/data/expired_fold/LocaleWord;", "getLocaleDisplayWords", "()Ljava/util/Map;", "setLocaleDisplayWords", "(Ljava/util/Map;)V", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedExpiredFoldThresholdConfig {

    @SerializedName("expired_day")
    private Integer expireDays;

    @SerializedName("wording")
    private Map<String, b> localeDisplayWords;

    public FeedExpiredFoldThresholdConfig() {
    }

    public final Integer a() {
        return this.expireDays;
    }

    public final Map<String, b> b() {
        return this.localeDisplayWords;
    }
}
