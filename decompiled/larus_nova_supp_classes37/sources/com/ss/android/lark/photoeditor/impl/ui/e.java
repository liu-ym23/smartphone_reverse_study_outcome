package com.ss.android.lark.photoeditor.impl.ui;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.functions.Consumer;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements Consumer<File> {
    public final /* synthetic */ a.InterfaceC0097a a;

    public e(m.a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        File r5 = (File) r4;
        Log.i("PhotoEditorModel", UIHelper.getString(2131892249) + " : " + r5.getAbsolutePath());
        m.a r0 = (m.a) this.a;
        ((b) r0.c.a.getView()).K3();
        ((a) r0.c.a.getModel()).g5(r5, new l(r0, r5));
    }
}
