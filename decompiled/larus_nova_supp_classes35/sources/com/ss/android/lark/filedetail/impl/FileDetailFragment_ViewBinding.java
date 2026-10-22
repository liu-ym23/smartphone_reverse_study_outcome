package com.ss.android.lark.filedetail.impl;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FileDetailFragment_ViewBinding implements Unbinder {
    public FileDetailFragment a;

    public final void unbind() {
        FileDetailFragment r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mRootView = null;
        r0.vTitleBar = null;
        r0.vBtnFunction = null;
        r0.vImageFileIcon = null;
        r0.vTextFileName = null;
        r0.vTextFileSize = null;
        r0.vTextFileSpeed = null;
        r0.mCloseIv = null;
        r0.vLayoutProgress = null;
        r0.vProgressBar = null;
        r0.mTipsTv = null;
        r0.mDecryptLoadingIV = null;
        r0.mDecryptTipsTV = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public FileDetailFragment_ViewBinding(FileDetailFragment r4, View r5) {
        this.a = r4;
        r4.mRootView = (ViewGroup) Utils.findRequiredViewAsType(r5, 2131384840, "field 'mRootView'", ViewGroup.class);
        r4.vTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r5, 2131388930, "field 'vTitleBar'", CommonTitleBar.class);
        r4.vBtnFunction = (TextView) Utils.findRequiredViewAsType(r5, 2131364725, "field 'vBtnFunction'", TextView.class);
        r4.vImageFileIcon = (ImageView) Utils.findRequiredViewAsType(r5, 2131374983, "field 'vImageFileIcon'", ImageView.class);
        r4.vTextFileName = (TextView) Utils.findRequiredViewAsType(r5, 2131388439, "field 'vTextFileName'", TextView.class);
        r4.vTextFileSize = (TextView) Utils.findRequiredViewAsType(r5, 2131388440, "field 'vTextFileSize'", TextView.class);
        r4.vTextFileSpeed = (TextView) Utils.findRequiredViewAsType(r5, 2131388441, "field 'vTextFileSpeed'", TextView.class);
        r4.mCloseIv = (ImageView) Utils.findRequiredViewAsType(r5, 2131364726, "field 'mCloseIv'", ImageView.class);
        r4.vLayoutProgress = (Group) Utils.findRequiredViewAsType(r5, 2131377498, "field 'vLayoutProgress'", Group.class);
        r4.vProgressBar = (ProgressBar) Utils.findRequiredViewAsType(r5, 2131383334, "field 'vProgressBar'", ProgressBar.class);
        r4.mTipsTv = (TextView) Utils.findRequiredViewAsType(r5, 2131388769, "field 'mTipsTv'", TextView.class);
        r4.mDecryptLoadingIV = (ImageView) Utils.findRequiredViewAsType(r5, 2131368640, "field 'mDecryptLoadingIV'", ImageView.class);
        r4.mDecryptTipsTV = (TextView) Utils.findRequiredViewAsType(r5, 2131368641, "field 'mDecryptTipsTV'", TextView.class);
    }
}
