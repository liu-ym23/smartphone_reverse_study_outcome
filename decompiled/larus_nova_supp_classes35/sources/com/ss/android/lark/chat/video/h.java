package com.ss.android.lark.chat.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.transition.TransitionManager;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.util.AppInfoUtils;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h extends v0c.a implements y0c.b, com.ss.android.lark.player.player.o {
    public final Image e;
    public ViewGroup f;
    public View g;
    public ImageView h;
    public View i;
    public View j;
    public View k;
    public View l;
    public ImageView m;
    public TextView n;
    public SeekBar o;
    public TextView p;
    public ObjectAnimator q;
    public ObjectAnimator r;
    public int s;
    public int t;
    public boolean u;
    public View.OnClickListener v;
    public f w;
    public final a x;
    public final b y;
    public final c z;

    public class a extends Handler {
        public final /* synthetic */ h a;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            super.handleMessage(r2);
            if (r2.what != 101) goto L7;
            this.a.s(false);
            return;
        }

        public a(h r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ h a;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.a.t < 0) goto L10;
            Bundle r0 = w0c.a.a();     // Catch: Throwable -> L7
            r0.putInt("int_data", this.a.t);     // Catch: Throwable -> L7
            this.a.j(-66005, r0);     // Catch: Throwable -> L7
            return;
        }

        public b(h r1) {
            this.a = r1;
        }
    }

    public class c implements SeekBar.OnSeekBarChangeListener {
        public final /* synthetic */ h a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r1) {
        }

        public c(h r1) {
            this.a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r4) {
            h r0 = this.a;
            int r5 = r4.getProgress();
            r0.u = false;
            r0.t = r5;
            r0.x.removeCallbacks(r0.y);
            r0.x.postDelayed(r0.y, 300);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
            if (r3 == false) goto L5;
            this.a.u(r2, r1.getMax());
            return;
        }
    }

    public class d extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ h b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            super.onAnimationEnd(r2);
            if (this.a == true) goto L6;
            this.b.i.setVisibility(8);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            super.onAnimationStart(r2);
            if (this.a == false) goto L6;
            this.b.i.setVisibility(0);
            return;
        }

        public d(h r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class e extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ h b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            super.onAnimationEnd(r2);
            if (this.a == true) goto L6;
            this.b.l.setVisibility(8);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            super.onAnimationStart(r2);
            if (this.a == false) goto L6;
            this.b.l.setVisibility(0);
            return;
        }

        public e(h r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public interface f {
        void onPlay();
    }

    public final /* synthetic */ void f() {
    }

    public final void onDoubleTap(MotionEvent r1) {
    }

    public final void onDown(MotionEvent r1) {
    }

    public final void onLongPress(MotionEvent r1) {
    }

    public final /* synthetic */ void onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
    }

    public final void g() {
        n();
        this.g = this.f.findViewById(2131382436);
        this.h = (ImageView) this.f.findViewById(2131392289);
        this.i = this.f.findViewById(2131367937);
        this.k = this.f.findViewById(2131368310);
        this.l = this.f.findViewById(2131367936);
        this.m = (ImageView) this.f.findViewById(2131392335);
        this.n = (TextView) this.f.findViewById(2131368342);
        this.p = (TextView) this.f.findViewById(2131392297);
        this.o = (SeekBar) this.f.findViewById(2131392372);
        View r0 = this.f.findViewById(2131392334);
        this.j = r0;
        r0.setVisibility(8);
        this.m.setSelected(true);
        this.n.setText(com.larksuite.framework.utils.e.f(0));
        this.p.setText(com.larksuite.framework.utils.e.f(0));
        UIUtils.display(this.i, false);
        UIUtils.display(this.l, false);
        this.j.setOnClickListener(new i(this));
        j r1 = new j(this);
        this.m.setOnClickListener(r1);
        this.g.setOnClickListener(r1);
        this.k.setOnClickListener(new k(this));
        this.o.setOnSeekBarChangeListener(this.z);
        this.l.setOnTouchListener(new l(this));
        if (this.e == null) goto L6;
        ImageLoader.with(getContext()).load(new EncryptImage(this.e.getKey())).error(2131231112).into(this.h);
        return;
    }

    public final void d(int r2) {
        switch(r2) {
            case -66018: goto L6;
            case -66017: goto L5;
            default: goto L9;
        };
    L5:
        s(false);
        UIUtils.display(this.g, false);
        return;
    L6:
        q(0);
        s(true);
        return;
    }

    public final View m(Context r3) {
        ViewGroup r4 = (ViewGroup) LayoutInflater.from(r3).inflate(2131564125, null);
        this.f = r4;
        return r4;
    }

    public final void onSingleTapUp(MotionEvent r3) {
        if (this.l.getVisibility() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        s(false);
        return;
    L8:
        s(true);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final void r(boolean r7) {
        this.l.clearAnimation();
        ObjectAnimator r0 = this.q;
        if (r0 == null) goto L5;
        r0.cancel();
        this.q.removeAllListeners();
        this.q.removeAllUpdateListeners();
    L5:
        View r1 = this.l;
        float[] r2 = new float[2];
        float r3 = 1.0f;
        if (r7 == false) goto L8;
        float r4 = 0.0f;
    L9:
        r2[0] = r4;
        if (r7 == true) goto L13;
        r3 = 0.0f;
    L13:
        r2[1] = r3;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r1, AppInfoUtils.VERSION_TYPE.VERSION_ALPHA, r2).setDuration(300);
        this.q = r5;
        r5.addListener(new e(this, r7));
        this.q.start();
        if (r7 == false) goto L16;
        n();
        return;
    L16:
        j(-66016, null);
        return;
    L8:
        r4 = 1.0f;
        goto L9
    }

    public final void s(boolean r5) {
        if (r5 == false) goto L5;
        this.x.removeMessages(101);
        this.x.sendEmptyMessageDelayed(101, 5000);
    L6:
        t(r5);
        r(r5);
        return;
    L5:
        this.x.removeMessages(101);
        goto L6
    }

    public final void t(boolean r7) {
        this.i.clearAnimation();
        ObjectAnimator r0 = this.r;
        if (r0 == null) goto L5;
        r0.cancel();
        this.r.removeAllListeners();
        this.r.removeAllUpdateListeners();
    L5:
        View r1 = this.i;
        float[] r2 = new float[2];
        float r3 = 0.0f;
        if (r7 == false) goto L8;
        float r4 = 0.0f;
    L9:
        r2[0] = r4;
        if (r7 == false) goto L12;
        r3 = 1.0f;
    L12:
        r2[1] = r3;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r1, AppInfoUtils.VERSION_TYPE.VERSION_ALPHA, r2).setDuration(300);
        this.r = r5;
        r5.addListener(new d(this, r7));
        this.r.start();
        return;
    L8:
        r4 = 1.0f;
        goto L9
    }

    public h(FragmentActivity r2, Image r3) {
        super(r2);
        this.t = -1;
        this.u = true;
        this.x = new a(this, Looper.getMainLooper());
        this.y = new b(this);
        this.z = new c(this);
        this.e = r3;
    }

    public final void a(int r3, Bundle r4) {
        switch(r3) {
            case -99031: goto L10;
            case -99016: goto L9;
            case -99015: goto L8;
            case -99014: goto L7;
            case -99010: goto L6;
            case -99004: goto L5;
            default: goto L24;
        };
    L5:
        t(false);
        r(false);
        return;
    L6:
        UIUtils.display(this.g, false);
        return;
    L7:
        this.u = true;
        return;
    L8:
        TransitionManager.beginDelayedTransition(this.f);
        this.h.setVisibility(8);
        TransitionManager.endTransitions(this.f);
        this.u = true;
        return;
    L9:
        int r5 = this.o.getMax();
        p();
        s(true);
        u(0, this.o.getMax());
        this.m.setSelected(true);
        UIUtils.display(this.g, true);
        UIUtils.display(this.h, true);
        u(r5, r5);
        return;
    L10:
        int r6 = r4.getInt("int_data");
        if (r6 != 4) goto L14;
        this.m.setSelected(true);
        return;
    L14:
        if (r6 != 3) goto L23;
        this.m.setSelected(false);
        UIUtils.display(this.g, false);
        return;
    L23:
        return;
    }

    public final void h(int r2, Bundle r3) {
        Log.e("play video eventCode: " + r2);
        UIUtils.display(this.i, false);
        UIUtils.display(this.l, false);
    }

    public final void u(int r3, int r4) {
        this.o.setMax(r4);
        this.o.setProgress(r3);
        this.o.setSecondaryProgress((int) (((this.s * 1.0f) / 100.0f) * r4));
        this.n.setText(com.larksuite.framework.utils.e.f(r3));
        this.p.setText(com.larksuite.framework.utils.e.f(r4));
    }

    public final void e(int r2, int r3, int r4) {
        if (this.u == true) goto L5;
        return;
    L5:
        this.s = r4;
        u(r2, r3);
    }
}
