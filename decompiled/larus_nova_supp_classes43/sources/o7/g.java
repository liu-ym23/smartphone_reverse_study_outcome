package o7;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.WebView;
import com.ss.android.socialbase.downloader.downloader.Downloader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements View.OnLongClickListener {
    public static final g a = null;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ String b;

        public a(View r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r10, int r11) {
            int r12 = k.a;
            Context r13 = ((WebView) this.a).getContext();
            String r14 = this.b;
            String r0 = r13.getCacheDir().getAbsolutePath() + "/webview/";
            Downloader.with(r13).url(r14).name("long_click_img.tmp").savePath(r0).monitorScene("annie_web_img").mainThreadListener(new h(r13, r14, r0)).download();
        }
    }

    static {
        a = new g();
    }

    public g() {
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r10) {
        if ((r10 instanceof WebView) == true) goto L22;
    L20:
        return false;
    L22:
        WebView.HitTestResult r0 = ((WebView) r10).getHitTestResult();     // Catch: Exception -> L21
        if (((WebView) r10).getSettings() != null) goto L8;
        return false;
    L8:
        if (r0.getType() != 5) goto L10;
    L11:
        String r1 = r0.getExtra();     // Catch: Exception -> L21
        if (r1 == null) goto L20;
        if (((WebView) r10).getContext() == null) goto L20;
        if (l.f(r1) == false) goto L20;
        new AlertDialog.Builder(((WebView) r10).getContext()).setTitle(r1).setItems(new String[]{((WebView) r10).getContext().getString(2131894125)}, new a(r10, r1)).show();     // Catch: Exception -> L21
        return true;
    L10:
        if (r0.getType() != 8) goto L20;
        goto L11
    }
}
