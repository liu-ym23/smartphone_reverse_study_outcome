package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FileListView_ViewBinding implements Unbinder {
    public FileListView a;

    public final void unbind() {
        FileListView r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mFileListRv = null;
        r0.mPtrView = null;
        r0.mContentLayout = null;
        r0.mLoadingLayout = null;
        r0.loadingIv = null;
        r0.mEmptyLayout = null;
        r0.mEmptyIv = null;
        r0.mEmptyHint = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public FileListView_ViewBinding(FileListView r4, View r5) {
        this.a = r4;
        r4.mFileListRv = (RecyclerView) Utils.findRequiredViewAsType(r5, 2131372412, "field 'mFileListRv'", RecyclerView.class);
        r4.mPtrView = (LKUIPtrClassicFrameLayout) Utils.findRequiredViewAsType(r5, 2131383411, "field 'mPtrView'", LKUIPtrClassicFrameLayout.class);
        r4.mContentLayout = (ViewGroup) Utils.findRequiredViewAsType(r5, 2131367833, "field 'mContentLayout'", ViewGroup.class);
        r4.mLoadingLayout = Utils.findRequiredView(r5, 2131372321, "field 'mLoadingLayout'");
        r4.loadingIv = (ImageView) Utils.findRequiredViewAsType(r5, 2131372322, "field 'loadingIv'", ImageView.class);
        r4.mEmptyLayout = Utils.findRequiredView(r5, 2131372324, "field 'mEmptyLayout'");
        r4.mEmptyIv = (ImageView) Utils.findRequiredViewAsType(r5, 2131371586, "field 'mEmptyIv'", ImageView.class);
        r4.mEmptyHint = (TextView) Utils.findRequiredViewAsType(r5, 2131371576, "field 'mEmptyHint'", TextView.class);
    }
}
