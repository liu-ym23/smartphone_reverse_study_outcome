package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import android.view.View;
import com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr;
import com.larus.im.bean.message.block.GenericImageItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements z {
    public b() {
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.z
    public final void a(fn8.c r8, View r9, final Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r9, "anchor");
        Intrinsics.checkNotNullParameter(r10, "onCompleted");
        fn8.b r11 = r8.h;
        if ((r11 instanceof fn8.b.C0108b) == false) goto L5;
        fn8.b.C0108b r12 = (fn8.b.C0108b) r11;
    L6:
        if (r12 == null) goto L22;
        GenericImageItem r13 = r12.a;
        if (r13 == null) goto L22;
        String r14 = r13.resource;
        if (r14 != null) goto L13;
    L20:
        r10.invoke();
        return;
    L13:
        if ((!StringsKt.isBlank(r14)) == false) goto L15;
        String r1 = r14;
    L16:
        if (r1 == null) goto L20;
        ImageDownloadLoadingMgr.c(r1, null, new a(r10), false, null, 54);
        return;
    L15:
        r1 = null;
    L22:
        r10.invoke();
        return;
    L5:
        r12 = null;
        goto L6
    }
}
