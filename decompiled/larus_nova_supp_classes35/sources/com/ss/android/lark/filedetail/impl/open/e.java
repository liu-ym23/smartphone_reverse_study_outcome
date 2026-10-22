package com.ss.android.lark.filedetail.impl.open;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.filedetail.impl.detail.FileHitPointUtil;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements com.ss.android.lark.widget.menu.b.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ j b;

    public final void a() {
        FileContent r0 = this.b.d.mFileContent;
        if (r0 != null) goto L5;
        return;
    L5:
        com.ss.android.lark.vfs.h r1 = sfb.c.b();
        String r2 = r0.getFilePath();
        r0.getName();
        VFSFile r3 = r1.i(sfb.c.a(r2));
        FileOpenUtils.b(this.b.e, r3, r0.getMime(), this.a, this.b.d.mMessageId);
        String r4 = this.b.d.mChatId;
        Lazy r5 = FileHitPointUtil.a;
        Intrinsics.checkNotNullParameter(r0, "fileContent");
        Intrinsics.checkNotNullParameter("menu", "source");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.filedetail.impl.detail.f(r4, r0, "menu"));
    }

    public e(j r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
