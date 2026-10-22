package com.larus.bmhome.chat;

import android.view.ViewTreeObserver;
import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.immerse.ChatImmersViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ h1 a;

    public /* synthetic */ z0(h1 r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ChatImmersViewModel r0 = (ChatImmersViewModel) this.a.g.getValue();
        if (r0 == null) goto L8;
        MutableLiveData<Boolean> r1 = r0.getListShown();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.TRUE);
        return;
    L9:
        return;
    }
}
