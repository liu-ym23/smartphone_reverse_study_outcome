package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "", "attachToDialog", "", "dialog", "Lcom/obric/oui/dialog/base/AbstractDialog;", "attachToHost", "host", "Lcom/obric/oui/dialog/v2/alert/style/AlertDialogHost;", "attachToParent", "context", "Landroid/content/Context;", "dialogContainer", "Lcom/obric/oui/dialog/v2/alert/style/DialogContainer;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface g {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static void a(g r2, AbstractDialog r3) {
            Intrinsics.checkNotNullParameter((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), "this");
            Intrinsics.checkNotNullParameter(r3, "dialog");
        }

        public static void a(g r2, b r3) {
            g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            Intrinsics.checkNotNullParameter(r5, "host");
            if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.dialog.v2.alert.a.class) == false) goto L6;
            r4.a((AbstractDialog) ZeusTransformUtils.preCheckCast(r5, AbstractDialog.class, "com.obric.memorydata.plugin"));
            return;
        }
    }

    void a(Context r1, d r2);

    void a(AbstractDialog r1);

    void a(b r1);
}
