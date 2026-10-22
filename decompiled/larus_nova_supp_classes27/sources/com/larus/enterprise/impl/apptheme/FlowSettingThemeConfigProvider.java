package com.larus.enterprise.impl.apptheme;

import android.view.View;
import com.larus.platform.api.IFlowSettingThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.n0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J0\u0010\u0006\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0012"}, d2 = {"Lcom/larus/enterprise/impl/apptheme/FlowSettingThemeConfigProvider;", "Lcom/larus/platform/api/IFlowSettingThemeConfigProvider;", "<init>", "()V", "getHelpFeedbackUrl", "", "disableFeature", "", "itemView", "Landroid/view/View;", "featureKey", "Lcom/larus/platform/model/apptheme/AdaptThemeFeatureKey;", "srcFeature", "Lkotlin/Function0;", "", "shouldDisableFeature", "isInEnterpriseMode", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowSettingThemeConfigProvider implements IFlowSettingThemeConfigProvider {

    public static final class a {
    }

    static {
    }

    public FlowSettingThemeConfigProvider() {
    }

    public final String c() {
        if (n0.a.b() == true) goto L5;
        return "";
    L5:
        int r0 = pa9.a.a;
        return ga9.a.e("enterprise_help_feedback_url", "");
    }

    public final boolean b(View r4, AdaptThemeFeatureKey r5) {
        Intrinsics.checkNotNullParameter(r5, "featureKey");
        FLogger.a.d("FlowSettingThemeConfigProvider", "disableFeature featureKey=" + r5);
        if (r4 != null) goto L6;
        return false;
    L6:
        if (n0.a.b() == true) goto L9;
    L13:
        boolean r6 = false;
    L15:
        if (r6 == false) goto L18;
        e1.o(r4);
        return true;
    L18:
        return false;
    L9:
        if (r5 == AdaptThemeFeatureKey.SETTING_ITEM_FEEDBACK) goto L11;
    L14:
        r6 = true;
        goto L15
    L11:
        if (StringsKt.isBlank(c()) == false) goto L13;
        goto L13
    }

    public final boolean a(Function0<Unit> r5, Function0<Unit> r6, AdaptThemeFeatureKey r7) {
        Intrinsics.checkNotNullParameter(r7, "featureKey");
        boolean r0 = n0.a.b();
        FLogger.a.i("FlowSettingThemeConfigProvider", "disableFeature to srcFeature>disableFeature isInEnterpriseMode=" + r0 + " featureKey=" + r7);
        if (r0 == true) goto L6;
    L10:
        boolean r8 = false;
    L12:
        if (r8 == false) goto L15;
        r6.invoke();
        return true;
    L15:
        r5.invoke();
        return false;
    L6:
        if (r7 == AdaptThemeFeatureKey.SETTING_ITEM_FEEDBACK) goto L8;
    L11:
        r8 = true;
        goto L12
    L8:
        if (StringsKt.isBlank(c()) == false) goto L10;
        goto L10
    }
}
