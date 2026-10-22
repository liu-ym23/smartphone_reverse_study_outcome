package com.larus.common_ui.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/common_ui/dialog/CommonLoadView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "useShadow", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonLoadView extends FrameLayout {
    public CommonLoadView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, false, 14);
    }

    public CommonLoadView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, false, 12);
    }

    public CommonLoadView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, r10, false, 8);
    }

    public CommonLoadView(Context r3, AttributeSet r4, int r5, boolean r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = false;
    L11:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LayoutInflater r8 = LayoutInflater.from(r3);     // Catch: Exception -> L18
        if (r6 == false) goto L15;
        int r9 = 2131561767;
    L16:
        r8.inflate(r9, this, true);     // Catch: Exception -> L18
        return;
    L15:
        r9 = 2131561766;
    L18:
        e = move-exception;
        FLogger.a.e("CommonLoadView", "inflate layout failed", e);
        com.larus.platform.service.g.a.ensureNotReachHere(e);
    }
}
