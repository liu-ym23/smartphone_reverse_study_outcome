package rvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmBilingualSubtitleDisplayConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final String b;
    public final boolean c;
    public Boolean d;
    public boolean e;
    public boolean f;
    public String g;
    public boolean h;
    public final float i;
    public final int j;

    public d(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r5) {
        Intrinsics.checkNotNullParameter(r5, "mmUccApi");
        this.a = r5;
        String r0 = "MmSubtitleBilingualHelper_" + hashCode();
        this.b = r0;
        int r1 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a;
        com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r2 = r5.getFeatureService();
        Intrinsics.checkNotNullParameter(r2, "featureService");
        boolean r3 = r2.h(MmOfficeSdkFeature.TranslationTextHidden);
        this.c = r3;
        this.e = true;
        this.f = true;
        this.g = "";
        this.i = 0.7f;
        this.j = 20;
        if (r3 == false) goto L5;
        MmBilingualSubtitleDisplayConfig r6 = r5.getSettingsService().e;
        float r4 = r6.getMaxSimilarity();
        this.i = r4;
        int r7 = r6.getMaxTargetWordsSize();
        this.j = r7;
        lvb.a.e(r0, "init, maxSimilarity=" + r4 + ", minTargetLength=" + r7);
        return;
    L5:
        lvb.a.e(r0, "init, feature disabled");
    }

    public final void a(boolean r4) {
        if (Intrinsics.areEqual(this.d, Boolean.valueOf(r4)) == false) goto L5;
        return;
    L5:
        this.d = Boolean.valueOf(r4);
        lvb.a.e(this.b, "onBilingualSettingChanged, isBilingual=" + r4);
        if (r4 == true) goto L9;
        this.f = true;
        this.e = true;
        this.h = false;
        this.g = "";
        return;
    }
}
