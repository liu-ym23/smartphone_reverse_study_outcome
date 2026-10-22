package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.video.IVideoDownloadLoadingMgrService;
import com.larus.im.bean.message.block.GenericVideoItem;
import com.larus.im.bean.message.block.MediaType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements z {
    public final f0 a;

    public d(f0 r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.z
    public final void a(fn8.c r27, View r28, final Function0<Unit> r29) {
        Intrinsics.checkNotNullParameter(r27, "item");
        Intrinsics.checkNotNullParameter(r28, "anchor");
        Intrinsics.checkNotNullParameter(r29, "onCompleted");
        fn8.b r2 = r27.h;
        if ((r2 instanceof fn8.b.c) == false) goto L5;
        fn8.b.c r3 = (fn8.b.c) r2;
    L6:
        if (r3 == null) goto L48;
        GenericVideoItem r4 = r3.a;
        if (r4 == null) goto L48;
        String r5 = r4.resource;
        if (r5 == null) goto L46;
        boolean r7 = true;
        if ((!StringsKt.isBlank(r5)) == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L46;
        if (r4.type == MediaType.MediaTypeLocalFile.getValue()) goto L22;
        r7 = false;
    L22:
        f0 r8 = this.a;
        if (r8 == null) goto L44;
        CoroutineScope r13 = r8.c();
        if (r13 == null) goto L44;
        IVideoDownloadLoadingMgrService.a.getClass();
        IVideoDownloadLoadingMgrService r9 = (IVideoDownloadLoadingMgrService) IVideoDownloadLoadingMgrService.a.b.getValue();
        if (r9 != null) goto L31;
        r29.invoke();
        return;
    L31:
        Context r10 = r28.getContext();
        String r11 = r27.a;
        String r0 = r4.id;
        if (r0 != null) goto L34;
        r0 = r4.uri;
    L34:
        String r15 = r0;
        if (r7 == true) goto L37;
        String r17 = r5;
    L39:
        if (r7 == false) goto L41;
        String r22 = r5;
    L42:
        r9.b(r10, r11, new nr9.g(r15, null, r17, null, null, null, null, r22, null, null, 890), r13, null, false, null, new c(r29), null, null, false);
        return;
    L41:
        r22 = null;
        goto L42
    L37:
        r17 = null;
    L44:
        r29.invoke();
        return;
    L46:
        r29.invoke();
        return;
    L48:
        r29.invoke();
        return;
    L5:
        r3 = null;
        goto L6
    }
}
