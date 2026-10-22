package com.larus.enterprise.impl.apptheme;

import com.larus.bmhome.view.CreateBotButton;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.platform.api.IFlowCreationThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.n0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/enterprise/impl/apptheme/FlowCreationThemeConfigProvider;", "Lcom/larus/platform/api/IFlowCreationThemeConfigProvider;", "<init>", "()V", "disableFeature", "", "entryView", "Landroid/view/View;", "srcFeature", "Lkotlin/Function0;", "", "featureKey", "Lcom/larus/platform/model/apptheme/AdaptThemeFeatureKey;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCreationThemeConfigProvider implements IFlowCreationThemeConfigProvider {

    public static final class a {
    }

    static {
    }

    public FlowCreationThemeConfigProvider() {
    }

    public final boolean a(CreationOperateContainerView r5, AdaptThemeFeatureKey r6) {
        Intrinsics.checkNotNullParameter(r6, "featureKey");
        boolean r0 = n0.a.b();
        FLogger.a.i("FlowProfileThemeConfigProvider", "disableFeature to view isInEnterpriseMode=" + r0 + " featureKey=" + r6);
        if (r0 == false) goto L8;
        if (r5 == null) goto L10;
        e1.o(r5);
        return true;
    L10:
        return true;
    L8:
        return false;
    }

    public final boolean b(CreateBotButton r5, Function0 r6, AdaptThemeFeatureKey r7) {
        Intrinsics.checkNotNullParameter(r6, "srcFeature");
        Intrinsics.checkNotNullParameter(r7, "featureKey");
        boolean r0 = n0.a.b();
        FLogger.a.i("FlowProfileThemeConfigProvider", "disableFeature to view isInEnterpriseMode=" + r0 + " featureKey=" + r7);
        if (r0 == false) goto L8;
        if (r5 == null) goto L10;
        e1.o(r5);
        return true;
    L10:
        return true;
    L8:
        r6.invoke();
        return false;
    }
}
