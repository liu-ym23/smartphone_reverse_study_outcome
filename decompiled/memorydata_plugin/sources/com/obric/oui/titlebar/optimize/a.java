package com.obric.oui.titlebar.optimize;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\n\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u000b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004\u001a\u0012\u0010\u000f\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0010\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0011\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\r¨\u0006\u0014"}, d2 = {"addLeftImageView", "Landroid/widget/ImageView;", "Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "drawableId", "", "addRightButton", "Lcom/obric/oui/button/OButton;", "style", "stringId", "addRightImageView", "addRightTransButton", "createButton", "context", "Landroid/content/Context;", "layoutResId", "createNeutralButton", "createPrimaryButton", "createPrimaryLightButton", "createTransButton", "createTransIconButton", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class a {
    public static final OButton a(OCTitleBar r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r5, "context");
        return a(r3, r5, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_trans_icon_button, "layout", "o_widget_titlebar_trans_icon_button"));
    }

    public static final OButton a(OCTitleBar r2, Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r5, "context");
        View r6 = ZeusTransformUtils.inflate(LayoutInflater.from(r5), r4, (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        return (OButton) ZeusTransformUtils.preCheckCast(r6, OButton.class, "com.obric.memorydata.plugin");
    }
}
