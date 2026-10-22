package bpc;

import android.view.View;
import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.suite.lark.platform.component.widget_biz_fileview.FileView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends OnSingleClickListener {
    public final /* synthetic */ FileView a;

    public a(FileView r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.ViewGroup, com.suite.lark.platform.component.widget_biz_fileview.FileView] */
    public final void onSingleClick(View r5) {
        ?? r6 = this.a;
        FileView.b r0 = r6.q;
        if (r0.f == true) goto L6;
        return;
    L6:
        if (r0.s == null) goto L9;
        r6.T5();
        return;
    L9:
        if (r0.e == false) goto L12;
        LKUIToast.show(r6.getContext(), 2131891433);
        return;
    L12:
        if (r0.o == true) goto L18;
        String r1 = r0.g;
        Statistics.sendEvent("open_attach_card", new JSONObject().put("file_type", r1));     // Catch: JSONException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        FileView.b r2 = r6.q;
        if (r2.b == false) goto L22;
        LKUIToast.show(r6.getContext(), 2131891768);
        return;
    L22:
        if (r2.d == false) goto L27;
        r6.T5();
        if (r6.r == null) goto L47;
        Log.i("FileView", "current fileDeleteStatus is Recoverable, call getFileState.");
        r6.r.a();
        return;
    L47:
        return;
    L27:
        if (r2.c == false) goto L30;
        r6.T5();
        return;
    L30:
        if (r2.m == true) goto L53;
        int r3 = r2.h.a;
        if (r3 != 1) goto L35;
    L38:
        FileView.c r7 = r6.r;
        if (r7 == null) goto L51;
        r7.c(r2);
        return;
    L51:
        return;
    L35:
        if (r3 == 2) goto L38;
        if (r3 == 6) goto L38;
        return;
    }
}
