package com.larus.setting.impl.modeltraining;

import android.widget.LinearLayout;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.network.HttpConst;
import com.larus.search.api.IBrowserService;
import com.larus.setting.impl.databinding.LarusPagePrivacyModelTrainingSettingBinding;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j implements UrlSpanTextView.a {
    public final /* synthetic */ PrivacyModelTrainingFragment a;

    public j(PrivacyModelTrainingFragment r1) {
        this.a = r1;
    }

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        if (Intrinsics.areEqual(r5, "pp") == false) goto L12;
        LarusPagePrivacyModelTrainingSettingBinding r6 = this.a.e;
        if (r6 == null) goto L13;
        LinearLayout r7 = r6.a;
        if (r7 == null) goto L14;
        IBrowserService r0 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r0 == null) goto L15;
        HttpConst.a.getClass();
        r0.i(r7, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", HttpConst.S)}), null);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
