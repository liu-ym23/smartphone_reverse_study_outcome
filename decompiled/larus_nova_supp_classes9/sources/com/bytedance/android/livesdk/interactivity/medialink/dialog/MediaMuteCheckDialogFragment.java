package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class MediaMuteCheckDialogFragment extends LiveDialogFragment {
    public static final /* synthetic */ int l = 0;
    public View d;
    public View e;
    public View f;
    public View g;
    public AppCompatRadioButton h;
    public TextView i;
    public String j;
    public View.OnClickListener k;

    public MediaMuteCheckDialogFragment() {
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Window r4 = getDialog().getWindow();
        if (r4 == null) goto L6;
        WindowManager.LayoutParams r0 = r4.getAttributes();
        r0.width = -1;
        r0.height = s1.f(180.0f);
        r4.setAttributes(r0);
        r4.setBackgroundDrawable(new ColorDrawable(0));
        r4.setGravity(80);
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new v(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        super.onViewCreated(r5, r6);
        View r7 = getView();
        this.d = r7.findViewById(2131389494);
        this.f = r7.findViewById(2131389542);
        this.e = r7.findViewById(2131389502);
        this.g = r7.findViewById(2131383718);
        this.h = r7.findViewById(2131383716);
        this.i = (TextView) r7.findViewById(2131391606);
        this.d.setOnClickListener(new w(this));
        View.OnClickListener r8 = this.k;
        if (r8 == null) goto L5;
        this.f.setOnClickListener(r8);
    L5:
        this.e.setOnClickListener(new x(this));
        this.g.setOnClickListener(new y(this));
        this.e.setVisibility(8);
        TextView r9 = this.i;
        Object[] r10 = new Object[1];
        String r0 = this.j;
        if (r0 != null) goto L8;
    L13:
        r0 = s1.B(2131920284);
    L14:
        r10[0] = r0;
        r9.setText(s1.C(2131920283, r10));
        return;
    L8:
        if (r0.isEmpty() == true) goto L13;
        if (r0.length() <= 7) goto L14;
        r0 = r0.substring(0, 7) + "...";
        goto L14
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131565635, r3, false);
    }
}
