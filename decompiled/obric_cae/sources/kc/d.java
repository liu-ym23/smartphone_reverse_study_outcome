package kc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.obric.cae.R;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PopupWindow f9106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f9107b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f9108m;

    public d(Context r8) {
        i.f(r8, "context");
        super(r8, null);
        View r10 = LayoutInflater.from(r8).inflate(R.layout.o_index_scrollbar_popup_circle, null);
        this.f9108m = (ImageView) r10.findViewById(R.id.popup_img);
        this.f9107b = (TextView) r10.findViewById(R.id.popup_text);
        this.f9106a = new PopupWindow(r10, -2, -2, false);
    }

    public final void a() {
        PopupWindow r8 = this.f9106a;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isShowing() != true) goto L11;
        PopupWindow r10 = this.f9106a;
        if (r10 == null) goto L12;
        r10.dismiss();
        return;
    L12:
        return;
    }

    public final boolean b() {
        PopupWindow r8 = this.f9106a;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.isShowing() != true) goto L7;
        return true;
    }

    public final PopupWindow getPopupWindow() {
        return this.f9106a;
    }

    public final void setPopupWindow(PopupWindow r8) {
        this.f9106a = r8;
    }
}
