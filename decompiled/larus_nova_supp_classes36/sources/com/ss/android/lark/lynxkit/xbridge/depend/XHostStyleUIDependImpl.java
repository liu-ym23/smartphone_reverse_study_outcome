package com.ss.android.lark.lynxkit.xbridge.depend;

import android.app.Activity;
import com.bytedance.ies.xbridge.base.runtime.depend.ActionSheetBuilder;
import com.bytedance.ies.xbridge.base.runtime.depend.DialogBuilder;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.PageTitleBar;
import com.bytedance.ies.xbridge.base.runtime.depend.ShowActionSheetListener;
import com.bytedance.ies.xbridge.base.runtime.depend.ToastBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import g66.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s56.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/depend/XHostStyleUIDependImpl;", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostStyleUIDepend;", "<init>", "()V", "showToast", "", "toastBuilder", "Lcom/bytedance/ies/xbridge/base/runtime/depend/ToastBuilder;", "(Lcom/bytedance/ies/xbridge/base/runtime/depend/ToastBuilder;)Ljava/lang/Boolean;", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class XHostStyleUIDependImpl implements IHostStyleUIDepend {
    public XHostStyleUIDependImpl() {
    }

    public Boolean hideLoading(c r1) {
        return null;
    }

    public void setPageNaviStyle(c r1, Activity r2, PageTitleBar r3) {
    }

    public Boolean showLoading(c r1) {
        return null;
    }

    public Boolean showDialog(DialogBuilder r2) {
        Intrinsics.checkNotNullParameter(r2, "dialogBuilder");
        return null;
    }

    public Boolean showToast(ToastBuilder r4) {
        Intrinsics.checkNotNullParameter(r4, "toastBuilder");
        String r0 = r4.getMessage();
        if (r0 == null) goto L12;
        String r1 = r4.getType();
        if (Intrinsics.areEqual(r1, "success") == false) goto L8;
        UDToast.show(r4.getContext(), r0);
        goto L12
    L8:
        if (Intrinsics.areEqual(r1, "error") == false) goto L10;
        UDToast.show(r4.getContext(), r0);
        goto L12
    L10:
        UDToast.show(r4.getContext(), r0);
    L12:
        return Boolean.TRUE;
    }

    public Boolean showActionSheet(ActionSheetBuilder r2, ShowActionSheetListener r3) {
        Intrinsics.checkNotNullParameter(r2, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r3, "showActionSheetListener");
        return null;
    }

    public Boolean showLoading(f r1, c r2) {
        Intrinsics.checkNotNullParameter(r1, "showLoadingParams");
        return null;
    }
}
