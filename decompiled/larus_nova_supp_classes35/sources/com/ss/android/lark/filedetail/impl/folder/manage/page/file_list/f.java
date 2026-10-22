package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.folder.manage.adapter.FileInfoAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements FileInfoAdapter.b {
    public final /* synthetic */ FileListView a;

    public f(FileListView r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.adapter.FileInfoAdapter.b
    public final void a(nfb.a r6) {
        Intrinsics.checkNotNullParameter(r6, "item");
        int r0 = pfb.d.a;
        pfb.d.a.e(this.a.k, "single_file", "none", pfb.d.a.a(r6.getType(), r6.c, r6.d));
        FileListView r1 = this.a;
        FolderManageLaunchParams r2 = r1.c;
        pfb.d.a.d(r2.b, r1.h, r2.e);
        this.a.b.d(r6);
    }
}
