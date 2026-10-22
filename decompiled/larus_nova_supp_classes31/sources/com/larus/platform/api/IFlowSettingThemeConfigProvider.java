package com.larus.platform.api;

import android.view.View;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J0\u0010\u0004\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH&¨\u0006\r"}, d2 = {"Lcom/larus/platform/api/IFlowSettingThemeConfigProvider;", "", "getHelpFeedbackUrl", "", "disableFeature", "", "itemView", "Landroid/view/View;", "featureKey", "Lcom/larus/platform/model/apptheme/AdaptThemeFeatureKey;", "srcFeature", "Lkotlin/Function0;", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IFlowSettingThemeConfigProvider {
    boolean a(Function0<Unit> r1, Function0<Unit> r2, AdaptThemeFeatureKey r3);

    boolean b(View r1, AdaptThemeFeatureKey r2);

    String c();
}
