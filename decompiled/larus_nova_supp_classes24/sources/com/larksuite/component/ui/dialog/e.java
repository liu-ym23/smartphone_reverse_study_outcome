package com.larksuite.component.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e extends UDDialogController {
    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        if (getMContentLayoutRes() == 0) goto L5;
        View r0 = LayoutInflater.from(getContext()).inflate(getMContentLayoutRes(), null);
        setMContentLayoutRes(0);
    L6:
        setMContentLayout(r0);
        View r1 = getMContentLayout();
        if (r1 == null) goto L10;
        TraverseLayoutChildIdUtilsKt.a(r1);
    L10:
        return super.onCreateContent();
    L5:
        r0 = getMContentLayout();
        goto L6
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateFooter() {
        if (getMFooterLayoutRes() == 0) goto L5;
        View r0 = LayoutInflater.from(getContext()).inflate(getMFooterLayoutRes(), null);
        setMFooterLayoutRes(0);
    L6:
        setMFooterLayout(r0);
        View r1 = getMFooterLayout();
        if (r1 == null) goto L10;
        TraverseLayoutChildIdUtilsKt.a(r1);
    L10:
        return super.onCreateFooter();
    L5:
        r0 = getMFooterLayout();
        goto L6
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateHeader() {
        if (getMHeaderLayoutRes() == 0) goto L5;
        View r0 = LayoutInflater.from(getContext()).inflate(getMHeaderLayoutRes(), null);
        setMHeaderLayoutRes(0);
    L6:
        setMHeaderLayout(r0);
        View r1 = getMHeaderLayout();
        if (r1 == null) goto L10;
        TraverseLayoutChildIdUtilsKt.a(r1);
    L10:
        return super.onCreateHeader();
    L5:
        r0 = getMHeaderLayout();
        goto L6
    }

    public e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
