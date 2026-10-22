package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "mm_bilingual_subtitle_display_config")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmBilingualSubtitleDisplayConfig;", "Ljava/io/Serializable;", "maxSimilarity", "", "maxTargetWordsSize", "", "<init>", "(FI)V", "getMaxSimilarity", "()F", "getMaxTargetWordsSize", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmBilingualSubtitleDisplayConfig implements Serializable {
    public static final a Companion = null;
    public static final float DEFAULT_MAX_SIMILARITY = 0.7f;
    public static final int DEFAULT_MAX_TARGET_WORDS_SIZE = 20;
    private final float maxSimilarity;
    private final int maxTargetWordsSize;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MmBilingualSubtitleDisplayConfig() {
        float r2 = 0.0f;
        int r3 = 0;
        this(r2, r3, 3, null);
    }

    public static /* synthetic */ MmBilingualSubtitleDisplayConfig copy$default(MmBilingualSubtitleDisplayConfig r0, float r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.maxSimilarity;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.maxTargetWordsSize;
    L9:
        return r0.copy(r1, r2);
    }

    public final float component1() {
        return this.maxSimilarity;
    }

    public final int component2() {
        return this.maxTargetWordsSize;
    }

    public final MmBilingualSubtitleDisplayConfig copy(float r2, int r3) {
        return new MmBilingualSubtitleDisplayConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmBilingualSubtitleDisplayConfig) == true) goto L8;
        return false;
    L8:
        MmBilingualSubtitleDisplayConfig r6 = (MmBilingualSubtitleDisplayConfig) r5;
        if (Float.compare(this.maxSimilarity, r6.maxSimilarity) == 0) goto L12;
        return false;
    L12:
        if (this.maxTargetWordsSize == r6.maxTargetWordsSize) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.maxSimilarity) * 31) + this.maxTargetWordsSize;
    }

    public String toString() {
        return "MmBilingualSubtitleDisplayConfig(maxSimilarity=" + this.maxSimilarity + ", maxTargetWordsSize=" + this.maxTargetWordsSize + ')';
    }

    public final float getMaxSimilarity() {
        return this.maxSimilarity;
    }

    public final int getMaxTargetWordsSize() {
        return this.maxTargetWordsSize;
    }

    public MmBilingualSubtitleDisplayConfig(float r1, int r2) {
        this.maxSimilarity = r1;
        this.maxTargetWordsSize = r2;
    }

    public /* synthetic */ MmBilingualSubtitleDisplayConfig(float r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0.7f;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 20;
    L8:
        this(r1, r2);
    }
}
