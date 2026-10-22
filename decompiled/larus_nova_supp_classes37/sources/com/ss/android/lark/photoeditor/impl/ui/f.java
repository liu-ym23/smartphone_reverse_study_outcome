package com.ss.android.lark.photoeditor.impl.ui;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements Consumer<Throwable> {
    public final /* synthetic */ a.InterfaceC0097a a;

    public f(m.a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        Log.e("PhotoEditorModel", UIHelper.getString(2131892140) + " : " + ((Throwable) r4).toString());
        a.InterfaceC0097a r5 = this.a;
        String r0 = UIHelper.getString(2131892140);
        m.a r6 = (m.a) r5;
        ((b) r6.c.a.getView()).K3();
        ((b) r6.c.a.getView()).showToast(r0);
    }
}
