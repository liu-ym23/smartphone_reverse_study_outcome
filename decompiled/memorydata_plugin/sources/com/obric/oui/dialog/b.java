package com.obric.oui.dialog;

import android.view.ViewGroup;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"applyDialogSubtitleWidth", "", "Landroid/widget/TextView;", "message", "", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class b {
    public static final void a(TextView r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r7, "message");
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (StringsKt.contains$default(r7, '\n', false, 2, null) == false) goto L5;
        int r8 = -1;
    L6:
        r0.width = r8;
        r5.setLayoutParams(r0);
        return;
    L5:
        r8 = -2;
        goto L6
    }
}
