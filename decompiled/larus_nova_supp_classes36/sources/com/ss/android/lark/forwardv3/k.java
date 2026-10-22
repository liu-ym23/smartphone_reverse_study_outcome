package com.ss.android.lark.forwardv3;

import android.view.View;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ ForwardNewFragment a;

    public k(ForwardNewFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        Log.i("NewForward", "start create group chat");
        tib.g r5 = ForwardModuleV3.a();
        ForwardNewFragment r0 = this.a;
        ForwardV3ViewModel r1 = r0.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        r5.startCreateGroup(r0, r1.getEnableChatPreview(), IImBrowserService.SCENE_FROM_CHAT_GROUP);
    }
}
