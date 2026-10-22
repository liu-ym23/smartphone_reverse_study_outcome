package com.ss.android.lark.photoeditor.impl.ui;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o extends BasePresenter<com.ss.android.lark.photoeditor.impl.ui.a, b, b.a> {
    public final Activity a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final a f;
    public final String g;
    public final String h;
    public final String i;
    public final q0c.a j;

    public interface a {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new m(this);
    }

    public final void create() {
        super.create();
    }

    public o(String r9, String r10, String r11, boolean r12, boolean r13, String r14, String r15, String r16, FragmentActivity r17, View r18, PhotoEditorFragment.a r19, PhotoEditorFragment.b r20, q0c.a r21) {
        this.b = r10;
        this.f = r20;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.a = r17;
        this.j = r21;
        r r7 = new r(r17, r18, r11, r9, r19);
        h r1 = new h();
        r7.f = new m(this);
        setView(r7);
        setModel(r1);
    }
}
