package rv8;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.music.applet.MusicAppletPage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(Context r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        Context r6 = this.a;
        String r0 = this.b;
        i r7 = SmartRouter.buildRoute(r6, "//debug/markdown_input");
        r7.c.putExtra(MusicAppletPage.KEY_MESSAGE_ID, r0);
        r7.d();
        r4.dismiss();
    }
}
