package com.larus.bmhome.chat.detail.table;

import androidx.appcompat.widget.AppCompatImageView;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n implements IIMCallback<Message> {
    public final /* synthetic */ AppCompatImageView a;

    public final boolean mustInMain() {
        return true;
    }

    public n(AppCompatImageView r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.setEnabled(false);
        this.a.setAlpha(0.5f);
    }

    public final /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        Message r2 = (Message) r1;
    }
}
