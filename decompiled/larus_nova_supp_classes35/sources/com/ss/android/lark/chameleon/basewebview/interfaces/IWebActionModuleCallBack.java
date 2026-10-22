package com.ss.android.lark.chameleon.basewebview.interfaces;

import android.view.ActionMode;
import com.ss.android.lark.chameleon.basewebview.LarkWebView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/basewebview/interfaces/IWebActionModuleCallBack;", BuildConfig.FLAVOR, "buildCallBack", "Landroid/view/ActionMode$Callback;", "larkWebView", "Lcom/ss/android/lark/chameleon/basewebview/LarkWebView;", "callback", "containerDestroyed", BuildConfig.FLAVOR, "onWebViewTextSelected", "title", BuildConfig.FLAVOR, "selectedStr", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IWebActionModuleCallBack {
    ActionMode.Callback buildCallBack(LarkWebView r1, ActionMode.Callback r2);

    void containerDestroyed();

    void onWebViewTextSelected(String r1, String r2);
}
