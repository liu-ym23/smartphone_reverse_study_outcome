package com.bytedance.android.btm.impl.page.lifecycle.layer2;

import android.app.Dialog;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFilterReason;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DialogFilter extends BaseFilter<Dialog> {
    public static final String h = "DialogFilter_onCreated";
    public static final String i = "DialogFilter_buildPageTree";
    public static final String j = "DialogFilter_isResumeFiltered";
    public static final DialogFilter k = null;

    static {
        k = new DialogFilter();
        h = "DialogFilter_onCreated";
        i = "DialogFilter_buildPageTree";
        j = "DialogFilter_isResumeFiltered";
    }

    public DialogFilter() {
    }

    @Override // com.bytedance.android.btm.impl.page.lifecycle.layer2.BaseFilter
    public final /* bridge */ /* synthetic */ ResumeFilterReason b(Dialog r1, ResumeFuncOrigin r10) {
        return g(r1, r10);
    }

    public final ResumeFilterReason g(Dialog r10, final ResumeFuncOrigin r11) {
        final String r0 = r10.getClass().getName();
        ALogger r1 = ALogger.d;
        String r12 = j;
        ALogger.f(r1, r12, new DialogFilter$isResumeFiltered$1(r0, r11));
        ResumeFilterReason r13 = super.b(r10, r11);
        if (r13 == null) goto L7;
        ALogger.f(r1, r12, new DialogFilter$isResumeFiltered$2(r0));
        return r13;
    L7:
        if (r10.isShowing() == true) goto L10;
        ALogger.f(r1, r12, new DialogFilter$isResumeFiltered$3(r0));
        return ResumeFilterReason.DialogNotShowing;
    L10:
        return null;
    }
}
