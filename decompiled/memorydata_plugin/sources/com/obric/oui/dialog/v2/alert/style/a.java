package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/AlertDialogButtonStyleController;", "Lcom/obric/oui/dialog/v2/alert/style/DefaultButtonStyleController;", "context", "Landroid/content/Context;", "style", "", "(Landroid/content/Context;I)V", "getButtonContainerLayout", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a extends c {
    public a(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r4);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.c
    public int a(int r2) {
        if (r2 != 0) goto L9;
        if (h.a(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().fontScale) == false) goto L6;
        int r1 = R.layout.o_dialog_button_vertical_v2_primary;
        String r0 = "o_dialog_button_vertical_v2_primary";
    L10:
        return ZeusTransformUtils.mapRes(r1, "layout", r0);
    L6:
        r1 = R.layout.o_dialog_button_horizontal_v2_primary;
        r0 = "o_dialog_button_horizontal_v2_primary";
        goto L10
    L9:
        return super.a(r2);
    }
}
