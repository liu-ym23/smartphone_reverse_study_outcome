package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SendFile;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DownloadFileMenuHandler extends a {
    public DownloadFileMenuHandler() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != MenuActionType.DOWNLOAD_FILE.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r12, View r13, ef8.b r14) {
        Intrinsics.checkNotNullParameter(r12, "item");
        Intrinsics.checkNotNullParameter(r13, "view");
        Intrinsics.checkNotNullParameter(r14, "menuContext");
        if (r12.getId() == MenuActionType.DOWNLOAD_FILE.getType()) goto L5;
        return false;
    L5:
        Context r4 = r13.getContext();
        if (r4 != null) goto L8;
        return true;
    L8:
        com.larus.bmhome.chat.api.q0.a r15 = r14.b;
        if (r15 == null) goto L44;
        LifecycleCoroutineScope r16 = r15.F9();
        if (r16 == null) goto L44;
        Message r0 = r14.a;
        UplinkFileEntity r2 = r14.k;
        r r3 = null;
        String r5 = null;
        r3 = null;
        if (r2 == null) goto L18;
        UplinkEntityContent r6 = r2.getUplinkEntityContent();
        if (r6 == null) goto L18;
        UplinkFileInfo r7 = r6.getUplinkFileInfo();
    L19:
        if (r7 == null) goto L25;
        SendFile r8 = new SendFile(r7.getLocalResPath(), r7.getFileName(), r7.getTosKey(), r7.getResourceId());
        if (lr8.c.a(r0) == false) goto L23;
        r5 = r2.getFileIdentifier();
    L23:
        r r1 = new r(r8, r5);
    L24:
        r3 = r1;
    L33:
        if (r3 != null) goto L35;
        return false;
    L35:
        SendFile r9 = r3.a;
        String r10 = r9.getFileName();
        if (r10 != null) goto L39;
        return false;
    L39:
        if (NetworkUtils.isNetworkAvailable(r4) == true) goto L42;
        t19.s.a.g(r4, 2131908080, false);
        return true;
    L42:
        BuildersKt.launch$default(r16, Dispatchers.getIO(), null, new DownloadFileMenuHandler$handleAction$1(r9, r4, r10, r14, null), 2, null);
        return true;
    L25:
        List r11 = com.larus.bmhome.chat.sendimage.e.f(r0.getContent()).getFileList();
        if (r11 == null) goto L28;
        SendFile r17 = (SendFile) CollectionsKt.firstOrNull(r11);
    L29:
        if (r17 == null) goto L33;
        if (lr8.c.a(r0) == true) goto L33;
        r1 = new r(r17, null);
        goto L24
    L28:
        r17 = null;
    L18:
        r7 = null;
    L44:
        return false;
    }
}
