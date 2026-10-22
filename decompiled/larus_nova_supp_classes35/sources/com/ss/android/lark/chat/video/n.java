package com.ss.android.lark.chat.video;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n extends v0c.a {
    public ViewGroup e;
    public View.OnClickListener f;
    public View.OnClickListener g;
    public TextView h;

    public class a extends OnSingleClickListener {
        public final /* synthetic */ n a;

        public a(n r1) {
            this.a = r1;
        }

        public final void onSingleClick(View r2) {
            View.OnClickListener r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public final void g() {
    }

    public final void k() {
        q(8);
        this.e.setOnClickListener(new a(this));
        this.e.findViewById(2131371751).setOnClickListener(new m(this));
    }

    public n(FragmentActivity r1) {
        super(r1);
    }

    public final View m(Context r3) {
        ViewGroup r4 = (ViewGroup) LayoutInflater.from(r3).inflate(2131564127, null);
        this.e = r4;
        this.h = (TextView) r4.findViewById(2131392300);
        return this.e;
    }

    public final void a(int r1, Bundle r2) {
        q(8);
    }

    public final void h(int r1, Bundle r2) {
        this.h.setText(2131892120);
        q(0);
    }
}
