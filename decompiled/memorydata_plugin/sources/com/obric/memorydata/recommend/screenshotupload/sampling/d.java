package com.obric.memorydata.recommend.screenshotupload.sampling;

import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.obric.memorydata.middleware.impl.settings.AppSettingsManager;
import com.obric.memorydata.sdk.screencapture.rule.HeifOutputOption;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/RecommendScreenshotOptions;", "", "<init>", "()V", "buildPeriodicScreenshotOption", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "buildScreenshotOption", "onlyAppWindow", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12586a = null;

    static {
        f12586a = new d();
    }

    private d() {
    }

    public static /* synthetic */ ScreenshotOption a(d r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.a(r1);
    }

    public final ScreenshotOption a() {
        return a(this, false, 1, null);
    }

    public final ScreenshotOption a(boolean r19) {
        IRecommendSettings r0 = AppSettingsManager.INSTANCE.getRecommendSettings();
        float r4 = r0.getResolutionCompressRation() / 100.0f;
        if (StringsKt.equals(r0.getImageStyle(), "heif", true) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        if (r19 == true) goto L12;
        return new ScreenshotOption(r4, false, 0, null, null, false, new HeifOutputOption(0, 0, RangesKt.coerceIn(r0.getHeifQuality(), 1, 51), 0, 11, null), 62, null);
    L12:
        if (r19 == true) goto L15;
        return new ScreenshotOption(r4, false, 0, null, null, true, null, 94, null);
    L15:
        return new ScreenshotOption(r4, true, 0, null, null, false, null, 124, null);
    L5:
        if (com.obric.memorydata.utils.e.b.f13208a.a() == false) goto L7;
        r1 = true;
        goto L8
    }
}
