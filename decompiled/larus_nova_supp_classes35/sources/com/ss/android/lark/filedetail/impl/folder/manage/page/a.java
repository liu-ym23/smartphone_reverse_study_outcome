package com.ss.android.lark.filedetail.impl.folder.manage.page;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.detail.FileDetailController;
import com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.g;
import com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.FileListFragment;
import com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.d;
import com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.i;
import com.ss.android.lark.filedetail.impl.folder.manage.page.title.FolderTitleFragment;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Set;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements g {
    public final /* synthetic */ FolderManageActivity a;

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.g
    public final Triple<Long, Integer, Integer> a() {
        return (Triple) this.a.d.getValue();
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.g
    public final String b() {
        FolderTitleFragment r0 = this.a.a;
        if (r0 == null) goto L8;
        nfb.a r1 = (nfb.a) CollectionsKt.lastOrNull(r0.o);
        if (r1 == null) goto L8;
        String r2 = r1.a;
        if (r2 == null) goto L8;
        return r2;
    L8:
        return BuildConfig.FLAVOR;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.g
    public final void c() {
        FolderTitleFragment r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.U90();
        return;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.g
    public final void d() {
        FolderTitleFragment r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.W90(true, null);
        return;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.g
    public final void f() {
        FolderTitleFragment r0 = this.a.a;
        if (r0 == null) goto L11;
        nfb.a r1 = (nfb.a) CollectionsKt.lastOrNull(r0.o);
        if (r1 == null) goto L12;
        FolderManageActivity r2 = this.a;
        Set<String> r3 = FileDetailController.a;
        FolderManageLaunchParams r4 = r2.D1();
        if (r4 == null) goto L10;
        FileDetailController.c(FolderManageActivity.z1(r2, r1, r4));
        return;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    L12:
        return;
    }

    public a(FolderManageActivity r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package.g
    public final void e(String r4, nfb.c r5) {
        Intrinsics.checkNotNullParameter(r4, "folderKey");
        FolderManageActivity.B1(this.a, 1);
        BaseFolderContentFragment r1 = this.a.C1(1);
        if ((r1 instanceof FileListFragment) == false) goto L8;
        Intrinsics.checkNotNullParameter(r4, "folderKey");
        com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.a r2 = ((FileListFragment) r1).f;
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r4, "folderKey");
        UICallbackExecutor.execute(new d(r2));
        ((i) r2.getModel()).v7(r4, r5, new UIGetDataCallback(r2.d));
        return;
    L9:
        return;
    }
}
