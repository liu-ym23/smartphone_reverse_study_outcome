package com.larus.bmhome.utils;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static n a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L22;
        r0.d0();
        ClipData r3 = com.larus.home.impl.sdk.i1.a.e(r2, "bpea-input-long-press");
        if (r3 == null) goto L22;
        if (r3.getItemCount() <= 0) goto L20;
        ClipData.Item r4 = r3.getItemAt(0);
        CharSequence r1 = r4.getText();
        if (r1 != null) goto L12;
    L15:
        Uri r5 = r4.getUri();
        if (r5 == null) goto L20;
        return new n.a(CollectionsKt.listOf(r5));
    L12:
        if ((!StringsKt.isBlank(r1)) == false) goto L15;
        return new n.c(r1.toString());
    L20:
        return n.b.a;
    L22:
        return n.b.a;
    }

    public static ClipData b(CharSequence r4, CharSequence r5) {
        Intrinsics.checkNotNullParameter(ShareType.TEXT, "label");
        Intrinsics.checkNotNullParameter(r4, "plainText");
        if (r5 == null) goto L24;
        String r6 = r5.toString();
        if (r6 == null) goto L24;
        boolean r2 = true;
        if ((!StringsKt.isBlank(r6)) == true) goto L10;
        r6 = null;
    L10:
        if (r6 == null) goto L24;
        if (r4.length() > 0) goto L16;
        r2 = false;
    L16:
        if (r2 == true) goto L19;
        r4 = null;
    L19:
        if (r4 != null) goto L22;
        r4 = r6;
    L22:
        return new ClipData(ShareType.TEXT, new String[]{"text/plain", "text/markdown"}, new ClipData.Item(r4, r6));
    L24:
        return ClipData.newPlainText(ShareType.TEXT, r4);
    }
}
