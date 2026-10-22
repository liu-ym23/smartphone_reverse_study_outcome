package com.ss.android.lark.filedetail.impl.open;

import android.content.Context;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.filedetail.impl.detail.FileDetailController;
import com.ss.android.lark.filedetail.impl.detail.z;
import com.ss.android.lark.filedetailapi.container.IFileDetailPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static boolean a(OpenFileParams r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String r5 = FileUtils.k(r4.getFileContent().getFilePath());
        IFileDetailPlugin r1 = FileDetailController.c;
        if (r1 != null) goto L9;
        return false;
    L9:
        if ((r1 instanceof gfb.a) == false) goto L17;
        gfb.a r2 = (gfb.a) r1;
        if (r2.canPreview() == false) goto L14;
        return true;
    L14:
        if (r2.a() == false) goto L19;
        return true;
    L19:
        return false;
    L17:
        if (r1.canPreview(r5) == false) goto L19;
        return true;
    }

    public static boolean b(final z r10, final Context r11, final FileContent r12, final OpenFileParams r13) {
        if (r12 == null) goto L22;
        String r1 = r12.getFilePath();
        r12.getName();
        if (sfb.c.c(r1) == false) goto L22;
        final IFileDetailPlugin r3 = FileDetailController.c;
        if (r3 != null) goto L10;
        return false;
    L10:
        final String r0 = r12.getFilePath();
        String r2 = FileUtils.k(r0);
        if ((r3 instanceof gfb.a) == false) goto L19;
        gfb.a r4 = (gfb.a) r3;
        if (r4.canPreview() == false) goto L16;
        UICallbackExecutor.post(new a(r3, r11, r12, r13, r10, r0));
        return true;
    L16:
        r4.open();
        r10.y();
        return true;
    L19:
        if (r3.canPreview(r2) == false) goto L21;
        UICallbackExecutor.post(new b(r3, r11, r12, r0, r10));
    L21:
        return true;
    L22:
        return false;
    }
}
