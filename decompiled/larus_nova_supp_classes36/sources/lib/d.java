package lib;

import android.content.Context;
import com.bytedance.lark.pb.im.v1.FilePermCheckBlockInfo;
import com.larksuite.component.universe_design.toast.UDToast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ FilePermCheckBlockInfo b;

    public /* synthetic */ d(Context r1, FilePermCheckBlockInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(this.a, this.b.toast);
    }
}
