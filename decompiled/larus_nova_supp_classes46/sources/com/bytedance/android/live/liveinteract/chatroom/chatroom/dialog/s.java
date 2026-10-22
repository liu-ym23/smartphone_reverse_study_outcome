package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.content.Context;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ LinkResultDialogFragmentV2 a;

    public s(LinkResultDialogFragmentV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Context r0 = this.a.getContext();
        ExceptionUtils.handleException(r0, (Throwable) r2);
    }
}
