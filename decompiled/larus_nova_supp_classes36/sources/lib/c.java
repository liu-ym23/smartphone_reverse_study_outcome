package lib;

import android.content.Context;
import com.bytedance.lark.pb.im.v1.FilePermCheckBlockInfo;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ FilePermCheckBlockInfo b;

    public /* synthetic */ c(Context r1, FilePermCheckBlockInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r0 = this.a;
        FilePermCheckBlockInfo r1 = this.b;
        new UDDialogBuilder(r0).title(r1.popup_title).message(r1.popup_text).addActionButton(2131391777, r1.button, new e()).show();
    }
}
