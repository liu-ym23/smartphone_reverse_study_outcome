package com.ss.android.lark.integrator.ccm.im.export;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.ccm_api.ICCMApi;
import com.ss.android.lark.chat.message.menu.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import yya.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements i {
    public final Map<String, Object> R4() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "export_doc"), TuplesKt.to("target", "none")});
    }

    public final boolean c() {
        return false;
    }

    public final Integer e() {
        return null;
    }

    public final boolean f() {
        return false;
    }

    public final d g() {
        return null;
    }

    public final void onHide() {
    }

    public final void onShow() {
    }

    public final boolean isVisible() {
        ICCMApi r0 = (ICCMApi) ApiUtils.getApi(ICCMApi.class);
        if (r0 == null) goto L6;
        r0.checkAndInit();
    L6:
        if (((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("ccm_create_doc") == true) goto L9;
        Log.i("CcmChatExportDocActionProvider", "don't has benefit");
        return false;
    L9:
        throw null;
    }

    public MessageActionType getType() {
        return MessageActionType.EXPORT_MESSAGE_TO_DOC;
    }

    public final boolean isEnable() {
        throw null;
    }

    public final void d(c r2) {
        Intrinsics.checkNotNullParameter(r2, "actionControl");
    }

    public final Drawable getIcon(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return UDIconUtils.getIconDrawable(r2, kac.a.b(2131254550));
    }

    public final String getLabel(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        throw null;
    }

    public final View getView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return null;
    }

    public final void b(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        throw null;
    }
}
