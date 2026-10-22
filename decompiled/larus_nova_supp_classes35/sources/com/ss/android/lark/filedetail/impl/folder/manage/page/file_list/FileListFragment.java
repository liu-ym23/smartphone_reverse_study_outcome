package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.folder.manage.page.BaseFolderContentFragment;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListFragment;", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/BaseFolderContentFragment;", "params", "Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;", "dependency", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/IFileListDependency;", "<init>", "(Lcom/ss/android/lark/filedetail/dto/FolderManageLaunchParams;Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/IFileListDependency;)V", "mPresenter", "Lcom/ss/android/lark/filedetail/impl/folder/manage/page/file_list/FileListPresenter;", "mRootView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", BuildConfig.FLAVOR, "view", "onBackPressed", BuildConfig.FLAVOR, "fetchData", Keys.API_RETURN_KEY_DATA, "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FilePreviewInfo;", "isCachedData", "updateFileList", "folderKey", BuildConfig.FLAVOR, "response", "Lcom/ss/android/lark/filedetail/impl/folder/manage/entity/FolderPreviewResponse;", "ViewDependency", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileListFragment extends BaseFolderContentFragment {
    public final FolderManageLaunchParams d;
    public final h e;
    public com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.a f;
    public View g;

    public final class a implements FileListView.b {
        public final /* synthetic */ FileListFragment a;

        @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.FileListView.b
        public final Triple<Long, Integer, Integer> a() {
            return this.a.e.a();
        }

        @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.FileListView.b
        public final void c() {
            this.a.e.c();
        }

        public a(FileListFragment r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.FileListView.b
        public final void d(nfb.a r12) {
            Intrinsics.checkNotNullParameter(r12, Keys.API_RETURN_KEY_DATA);
            String r0 = this.a.d.s;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == true) goto L19;
            String r3 = r12.k;
            if (r3 != null) goto L13;
        L16:
            boolean r4 = true;
        L17:
            if (r4 == false) goto L19;
            r12.k = this.a.d.s;
            goto L19
        L13:
            if (r3.length() == 0) goto L16;
            r4 = false;
        L19:
            String r5 = r12.k;
            String r6 = r12.c;
            if (r5 != null) goto L22;
        L25:
            boolean r7 = true;
        L26:
            if (r7 == true) goto L40;
            String[] r8 = {".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".csv"};
            int r9 = 0;
        L30:
            if (r9 >= 7) goto L40;
            String r10 = r8[r9];
            if (r6 != null) goto L34;
        L36:
            boolean r11 = false;
        L37:
            if (r11 == true) goto L38;
            r9 = r9 + 1;
            goto L30
        L38:
            r1 = true;
            goto L40
        L34:
            if (StringsKt.endsWith$default(r6, r10, false, 2, null) != true) goto L36;
            r11 = true;
        L40:
            if (r1 == false) goto L42;
            return;
        L42:
            this.a.e.d(r12);
            return;
        L22:
            if (r5.length() == 0) goto L25;
            r7 = false;
            goto L26
        L5:
            if (r0.length() == 0) goto L8;
            r2 = false;
            goto L9
        }

        @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.FileListView.b
        public final void e(j r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            View r0 = this.a.g;
            if (r0 == null) goto L8;
            ButterKnife.bind(r2, r0);
            return;
        }

        @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.FileListView.b
        public final void b(boolean r2, FileListView$switchAction$2.a r3) {
            Intrinsics.checkNotNullParameter(r3, "extraAction");
            this.a.e.b(r2, r3);
        }
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.c
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.BaseFolderContentFragment
    public final void S90(nfb.a r6) {
        Intrinsics.checkNotNullParameter(r6, Keys.API_RETURN_KEY_DATA);
        com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.a r1 = this.f;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r6, Keys.API_RETURN_KEY_DATA);
        UICallbackExecutor.execute(new c(r1, r6));
        ((i) r1.getModel()).I2(r6.a, r6.k, r6.l, new UIGetDataCallback(r1.d));
        return;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.BaseFolderContentFragment
    public final boolean T90(nfb.a r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.a r1 = this.f;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        return ((i) r1.getModel()).l7(r3);
    L5:
        return false;
    }

    public FileListFragment(FolderManageLaunchParams r2, com.ss.android.lark.filedetail.impl.folder.manage.page.b r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        this.d = r2;
        this.e = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        if (this.g != null) goto L5;
    L9:
        finish();
        return;
    L5:
        if (getContext() == null) goto L9;
        com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.a r5 = new com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.a(requireContext(), new a(this), this.d);
        this.f = r5;
        r5.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131561191, r3, false);
        this.g = r5;
        return r5;
    }
}
