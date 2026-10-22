package com.ss.android.lark.filedetail.impl.folder.manage.page;

import com.larksuite.component.universe_design.breadcrumb.UDBreadcrumb;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.detail.FileDetailController;
import com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.FileListView$switchAction$2;
import com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.h;
import com.ss.android.lark.filedetail.impl.folder.manage.page.title.FolderTitleFragment;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements h {
    public final /* synthetic */ FolderManageActivity a;

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.h
    public final Triple<Long, Integer, Integer> a() {
        return (Triple) this.a.d.getValue();
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.h
    public final void c() {
        FolderTitleFragment r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.U90();
        return;
    }

    public b(FolderManageActivity r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.h
    public final void d(nfb.a r4) {
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        int r1 = FolderManageActivity.A1(this.a, r4);
        if (r1 != 0) goto L5;
    L11:
        FolderTitleFragment r2 = this.a.a;
        if (r2 == null) goto L19;
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        UDBreadcrumb r0 = r2.h;
        if (r0 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("breadcrumb");
        r0 = null;
    L16:
        r0.b(r4.c);
        ((ArrayList) r2.o).add(r4);
        r2.V90();
        r2.e.a(r4);
        return;
    L19:
        return;
    L5:
        if (r1 == 1) goto L11;
        Set<String> r3 = FileDetailController.a;
        FolderManageActivity r5 = this.a;
        FolderManageLaunchParams r6 = r5.D1();
        if (r6 == null) goto L10;
        FileDetailController.d(FolderManageActivity.z1(r5, r4, r6));
        return;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.h
    public final void b(boolean r2, FileListView$switchAction$2.a r3) {
        Intrinsics.checkNotNullParameter(r3, "extraAction");
        FolderTitleFragment r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.W90(r2, r3);
        return;
    }
}
