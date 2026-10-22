package com.ss.android.lark.keyboard.biz.mention;

import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Chat r5 = (Chat) r4;
        d r0 = this.a;
        Intrinsics.checkNotNull(r5);
        r0.getClass();
        boolean r1 = com.ss.android.lark.keyboard.utils.b.a(r5);
        if (this.a.i == r1) goto L10;
        Log.i("AtKBPlugin", "Doubao mention availability changed, group=" + r5.isGroup() + ", enabled=" + r1);
        d r6 = this.a;
        r6.i = r1;
        if (r6.j.isInitialized() == false) goto L9;
        ((DoubaoMentionViewModel) this.a.j.getValue()).updateDoubaoMentionEnabled(r1);
        return;
    L9:
        return;
    }
}
