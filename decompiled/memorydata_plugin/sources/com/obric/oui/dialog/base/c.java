package com.obric.oui.dialog.base;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/dialog/base/OBaseDialogModal;", "Lcom/obric/oui/dialog/base/AbstractDialogModal;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isDismissing", "", "()Z", "setDismissing", "(Z)V", "dismiss", "", "originDismiss", "show", "parent", "Landroid/view/ViewGroup;", "ButtonConfig", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class c extends AbstractDialogModal {
    private boolean e;

    public c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, false, false);
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public void c() {
        this.e = false;
        super.c();
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal, android.content.DialogInterface
    public void dismiss() {
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        super.dismiss();
    }

    public final void setDismissing(boolean r1) {
        this.e = r1;
    }
}
