package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AttachmentCiteCopyMenuHandler extends com.larus.bmhome.chat.layout.holder.menu.item.a {

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != 2131907401) goto L5;
        return true;
    L5:
        return false;
    }

    public AttachmentCiteCopyMenuHandler() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r17, View r18, ef8.b r19) {
        Intrinsics.checkNotNullParameter(r17, "item");
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r19, "menuContext");
        Context r6 = r18.getContext();
        if (r6 != null) goto L5;
        return true;
    L5:
        Message r2 = r19.a;
        String r3 = c.c(r19);
        if (c.d(r19, r3) == false) goto L8;
        return true;
    L8:
        b r5 = c.b(r19);
        UplinkFileEntity r0 = c.a(r19, r3);
        CoroutineScope r7 = null;
        if (r0 == null) goto L16;
        if (r5 == null) goto L15;
        UplinkFileEntity r9 = (UplinkFileEntity) r5.invoke(r0);
        if (r9 == null) goto L15;
        r0 = r9;
    L15:
        UplinkFileEntity r10 = r0;
    L17:
        com.larus.bmhome.chat.api.q0.a r1 = r19.b;
        if (r1 == null) goto L23;
        CoroutineScope r4 = r1.F9();
        if (r4 == null) goto L23;
        CoroutineScope r11 = r4;
    L27:
        if (r11 != null) goto L30;
        FLogger.a.w("AttachmentCiteCopy", "copy click but scope is null");
        return true;
    L30:
        BuildersKt.launch$default(r11, null, null, new AttachmentCiteCopyMenuHandler$handleAction$1(r2, r3, r10, r19, r5, r6, null), 3, null);
        return true;
    L23:
        LifecycleOwner r8 = ViewTreeLifecycleOwner.get(r18);
        if (r8 == null) goto L26;
        r7 = LifecycleOwnerKt.getLifecycleScope(r8);
    L26:
        r11 = r7;
        goto L27
    L16:
        r10 = null;
        goto L17
    }
}
