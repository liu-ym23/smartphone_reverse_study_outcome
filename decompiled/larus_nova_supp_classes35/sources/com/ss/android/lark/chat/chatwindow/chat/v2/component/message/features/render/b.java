package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Runnable {
    public final /* synthetic */ MessageListRendererFeature a;

    public b(MessageListRendererFeature r1) {
        this.a = r1;
    }

    public final void a() {
        RecyclerView r0 = this.a.d;
        LKUIPtrFrameLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
        r0 = null;
    L5:
        LinearLayoutManager r2 = r0.getLayoutManager();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        boolean r3 = true;
        if ((this.a.I().getItemCount() - r2.findLastVisibleItemPosition()) >= 10) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L23;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r5 = this.a.G();
        if (r5 != null) goto L13;
    L15:
        r3 = false;
    L16:
        if (r3 == false) goto L24;
        Log.i(TitlebarViewModel.LOG_TAG, "autoLoadMore");
        LKUIPtrFrameLayout r6 = this.a.e;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mPtrFrame");
    L21:
        r1.autoLoadMore();
        return;
    L20:
        r1 = r6;
        goto L21
    L24:
        return;
    L13:
        if (r5.canLoadMore() != true) goto L15;
    L23:
        return;
    L8:
        r4 = false;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
