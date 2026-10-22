package com.larus.enterprise.impl.apptheme;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.n0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\r\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J0\u0010\u000e\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lcom/larus/enterprise/impl/apptheme/FlowChatThemeConfigProvider;", "Lcom/larus/platform/api/IFlowChatThemeConfigProvider;", "<init>", "()V", "disableFeature", "", "srcFeature", "Lkotlin/Function0;", "", "featureKey", "Lcom/larus/platform/model/apptheme/AdaptThemeFeatureKey;", "entryView", "Landroid/view/View;", "enableFeature", "changeFeature", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowChatThemeConfigProvider implements IFlowChatThemeConfigProvider {

    public static final class a {
    }

    static {
    }

    public FlowChatThemeConfigProvider() {
    }

    public final boolean a(Function0<Unit> r5, AdaptThemeFeatureKey r6) {
        Intrinsics.checkNotNullParameter(r6, "featureKey");
        boolean r0 = n0.a.b();
        FLogger.a.i("FlowChatThemeConfigProvider", "disableFeature to srcFeature isInEnterpriseMode=" + r0 + " featureKey=" + r6);
        if (r0 == false) goto L6;
        return true;
    L6:
        r5.invoke();
        return false;
    }

    public final boolean b(View r5, AdaptThemeFeatureKey r6) {
        Intrinsics.checkNotNullParameter(r6, "featureKey");
        boolean r0 = n0.a.b();
        FLogger.a.i("FlowChatThemeConfigProvider", "disableFeature to entryView isInEnterpriseMode=" + r0 + " featureKey=" + r6);
        if (r0 == false) goto L8;
        if (r5 == null) goto L10;
        e1.o(r5);
        return true;
    L10:
        return true;
    L8:
        return false;
    }

    public final boolean c(AppCompatImageView r5, AdaptThemeFeatureKey r6) {
        Intrinsics.checkNotNullParameter(r6, "featureKey");
        boolean r0 = n0.a.b();
        FLogger.a.i("FlowChatThemeConfigProvider", "enableFeature to view isInEnterpriseMode=" + r0 + " featureKey=" + r6);
        if (r0 == false) goto L8;
        if (r5 == null) goto L10;
        e1.x(r5);
        return true;
    L10:
        return true;
    L8:
        return false;
    }

    public final boolean e(Function0<Unit> r5, AdaptThemeFeatureKey r6) {
        Intrinsics.checkNotNullParameter(r6, "featureKey");
        boolean r0 = n0.a.b();
        FLogger.a.i("FlowChatThemeConfigProvider", "enableFeature to newFeature isInEnterpriseMode=" + r0 + " featureKey=" + r6);
        if (r0 == false) goto L6;
        r5.invoke();
        return true;
    L6:
        return false;
    }

    public final boolean d(Function0<Unit> r5, Function0<Unit> r6, AdaptThemeFeatureKey r7) {
        Intrinsics.checkNotNullParameter(r7, "featureKey");
        boolean r0 = n0.a.b();
        FLogger.a.i("FlowChatThemeConfigProvider", "changeFeature to view isInEnterpriseMode=" + r0 + " featureKey=" + r7);
        if (r0 == false) goto L8;
        if (r6 == null) goto L12;
        r6.invoke();
        return true;
    L12:
        return true;
    L8:
        if (r5 == null) goto L13;
        r5.invoke();
        return false;
    L13:
        return false;
    }
}
