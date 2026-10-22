package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmPanelHeightConfig;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmPanelHostMode;
import com.ss.android.lark.officesdk.minutes.ui.service.MmPanelProviderHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmDoubaoPanelProvider implements qub.e {
    public final Map<String, String> a;

    public MmDoubaoPanelProvider() {
        this.a = new LinkedHashMap();
    }

    @Override // qub.e
    public final void T(FragmentManager r3) {
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
        String r1 = "MmStandaloneAIInterpretationLanguagePanel";
        Intrinsics.checkNotNullParameter("MmStandaloneAIInterpretationLanguagePanel", "id");
        String r0 = this.a.remove("MmStandaloneAIInterpretationLanguagePanel");
        if (r0 == null) goto L6;
        r1 = r0;
    L6:
        Handler r2 = MmPanelProviderHelper.a;
        MmPanelProviderHelper.d(r3, r1);
    }

    @Override // qub.e
    public final void m0(FragmentManager r3) {
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
        List r0 = CollectionsKt.toList(((LinkedHashMap) this.a).values());
        ((LinkedHashMap) this.a).clear();
        Handler r1 = MmPanelProviderHelper.a;
        MmPanelProviderHelper.c(r3, r0);
    }

    @Override // qub.e
    public final void w(FragmentManager r20, final rub.d r21) {
        Intrinsics.checkNotNullParameter(r20, "fragmentManager");
        Intrinsics.checkNotNullParameter(r21, "config");
        this.a.put(r21.b, r21.a);
        Function0<Unit> r12 = new MmDoubaoPanelProvider$showPanel$trackedConfig$1(this, r21);
        String r7 = r21.a;
        String r8 = r21.b;
        Function1<Context, View> r9 = r21.c;
        Bundle r10 = r21.d;
        boolean r11 = r21.e;
        Function0<Unit> r13 = r21.g;
        MmPanelHeightConfig r14 = r21.h;
        MmRecordingUILaunchMode r15 = r21.i;
        rub.c r3 = r21.j;
        MmPanelHostMode r4 = r21.k;
        boolean r2 = r21.l;
        Intrinsics.checkNotNullParameter(r7, "tag");
        Intrinsics.checkNotNullParameter(r8, "id");
        Intrinsics.checkNotNullParameter(r9, "contentViewProvider");
        Intrinsics.checkNotNullParameter(r15, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r3, "backgroundConfig");
        Intrinsics.checkNotNullParameter(r4, "hostMode");
        rub.d r5 = new rub.d(r7, r8, r9, r10, r11, r12, r13, r14, r15, r3, r4, r2);
        Handler r6 = MmPanelProviderHelper.a;
        MmPanelProviderHelper.f(r20, r5, new MmDoubaoPanelProvider$showPanel$1(this));
    }
}
