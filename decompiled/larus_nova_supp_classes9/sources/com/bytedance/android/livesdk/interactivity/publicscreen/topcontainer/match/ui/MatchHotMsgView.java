package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.g3;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.s51;
import com.bytedance.bdlocation.BuildConfig;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import ec2.u0;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pa2.a;
import ra2.m;
import ra2.n;
import ra2.r;
import ra2.s;
import ra2.t;
import ra2.u;
import ra2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010T\u001a\u00020S\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U\u0012\b\b\u0002\u0010W\u001a\u000204¢\u0006\u0004\bX\u0010YJ\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR$\u0010,\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\"\u00100\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00109\u001a\u0002048\u0006X\u0086D¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001a\u0010<\u001a\u0002048\u0006X\u0086D¢\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u00108R\"\u0010@\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00106\u001a\u0004\b=\u00108\"\u0004\b>\u0010?R\"\u0010C\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u00106\u001a\u0004\bA\u00108\"\u0004\bB\u0010?R\u0017\u0010F\u001a\u0002048\u0006¢\u0006\f\n\u0004\bD\u00106\u001a\u0004\bE\u00108R\u0017\u0010I\u001a\u0002048\u0006¢\u0006\f\n\u0004\bG\u00106\u001a\u0004\bH\u00108R\u0017\u0010L\u001a\u0002048\u0006¢\u0006\f\n\u0004\bJ\u00106\u001a\u0004\bK\u00108R\u0017\u0010O\u001a\u0002048\u0006¢\u0006\f\n\u0004\bM\u00106\u001a\u0004\bN\u00108R\u0017\u0010R\u001a\u0002048\u0006¢\u0006\f\n\u0004\bP\u00106\u001a\u0004\bQ\u00108¨\u0006Z"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/MatchHotMsgView;", "Landroid/widget/FrameLayout;", "Lra2/m;", "Ljava/util/concurrent/PriorityBlockingQueue;", "Lcom/bytedance/android/live/base/model/message/g3;", "getQueue", "Lpa2/a;", "c", BuildConfig.FLAVOR, "setManagerCallBack", BuildConfig.FLAVOR, "a", "J", "getIconIndex", "()J", "setIconIndex", "(J)V", "iconIndex", "A", "Lcom/bytedance/android/live/base/model/message/g3;", "getCurShowMsg", "()Lcom/bytedance/android/live/base/model/message/g3;", "setCurShowMsg", "(Lcom/bytedance/android/live/base/model/message/g3;)V", "curShowMsg", "Landroid/animation/AnimatorSet;", "B", "Landroid/animation/AnimatorSet;", "getEnterInAnimSet", "()Landroid/animation/AnimatorSet;", "setEnterInAnimSet", "(Landroid/animation/AnimatorSet;)V", "enterInAnimSet", "C", "getScaleAnimatorSets", "setScaleAnimatorSets", "scaleAnimatorSets", "D", "getExitAnimatorSets", "setExitAnimatorSets", "exitAnimatorSets", "E", "getComboAnimSet", "setComboAnimSet", "comboAnimSet", BuildConfig.FLAVOR, "F", "Z", "isRunning", "()Z", "setRunning", "(Z)V", BuildConfig.FLAVOR, "G", "I", "getUnInit", "()I", "UnInit", "H", "getNeedExit", "NeedExit", "getStatus", "setStatus", "(I)V", "status", "getImgLoadCount", "setImgLoadCount", "imgLoadCount", "K", "getContentPartMarginLeft", "contentPartMarginLeft", "L", "getComboPartMarginLeft", "comboPartMarginLeft", "M", "getComboCountMarginLeft", "comboCountMarginLeft", "N", "getComboPartMarginRight", "comboPartMarginRight", "O", "getSpreadBgOverlapWidth", "spreadBgOverlapWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchHotMsgView extends FrameLayout implements m {
    public static final /* synthetic */ int P = 0;
    public g3 A;
    public AnimatorSet B;
    public AnimatorSet C;
    public AnimatorSet D;
    public AnimatorSet E;
    public boolean F;
    public final int G;
    public final int H;
    public int I;
    public int J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public long a;
    public final HSImageView b;
    public final HSImageView c;
    public final ViewGroup d;
    public final ViewGroup e;
    public final ImageView f;
    public final ViewGroup g;
    public a h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public s l;
    public r m;
    public t n;
    public u o;
    public v p;
    public AnimatedDrawable2 q;
    public AnimatedDrawable2 r;
    public long s;
    public long t;
    public int u;
    public int v;
    public final long w;
    public final long x;
    public boolean y;
    public PriorityBlockingQueue<g3> z;

    private final PriorityBlockingQueue<g3> getQueue() {
        PriorityBlockingQueue<g3> r0 = this.z;
        if (r0 != null) goto L6;
        PriorityBlockingQueue<g3> r1 = new PriorityBlockingQueue(11, n.a);
        this.z = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // ra2.m
    public final boolean a() {
        s51 r0 = (s51) u0.a.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.c() != true) goto L7;
        return true;
    }

    public final AnimatorSet getComboAnimSet() {
        return this.E;
    }

    public final int getComboCountMarginLeft() {
        return this.M;
    }

    public final int getComboPartMarginLeft() {
        return this.L;
    }

    public final int getComboPartMarginRight() {
        return this.N;
    }

    public final int getContentPartMarginLeft() {
        return this.K;
    }

    public final g3 getCurShowMsg() {
        return this.A;
    }

    public final AnimatorSet getEnterInAnimSet() {
        return this.B;
    }

    public final AnimatorSet getExitAnimatorSets() {
        return this.D;
    }

    public final long getIconIndex() {
        return this.a;
    }

    public final int getImgLoadCount() {
        return this.J;
    }

    public final int getNeedExit() {
        return this.H;
    }

    public final AnimatorSet getScaleAnimatorSets() {
        return this.C;
    }

    public final int getSpreadBgOverlapWidth() {
        return this.O;
    }

    public final int getStatus() {
        return this.I;
    }

    public final int getUnInit() {
        return this.G;
    }

    public static void b(AnimatorSet r0) {
        if (r0 == null) goto L4;
        r0.removeAllListeners();
    L4:
        if (r0 == null) goto L7;
        r0.cancel();
        return;
    }

    public final void c(g3 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        getQueue().add(r2);
    }

    public final void d(g3 r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        long r0 = r6.getTriggerTimestamp();
        g3 r2 = this.A;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r0 != r2.getTriggerTimestamp()) goto L9;
        getQueue().add(r6);
        return;
    }

    public final void setComboAnimSet(AnimatorSet r1) {
        this.E = r1;
    }

    public final void setCurShowMsg(g3 r1) {
        this.A = r1;
    }

    public final void setEnterInAnimSet(AnimatorSet r1) {
        this.B = r1;
    }

    public final void setExitAnimatorSets(AnimatorSet r1) {
        this.D = r1;
    }

    public final void setIconIndex(long r1) {
        this.a = r1;
    }

    public final void setImgLoadCount(int r1) {
        this.J = r1;
    }

    public void setManagerCallBack(a r2) {
        Intrinsics.checkNotNullParameter(r2, "c");
        this.h = r2;
    }

    public final void setRunning(boolean r1) {
        this.F = r1;
    }

    public final void setScaleAnimatorSets(AnimatorSet r1) {
        this.C = r1;
    }

    public final void setStatus(int r1) {
        this.I = r1;
    }

    public MatchHotMsgView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.s = 50;
        this.t = 50;
        this.w = 5000;
        this.x = 500;
        this.G = -1;
        this.H = 2;
        this.I = -1;
        this.K = s1.j(2131168905);
        this.L = s1.j(2131168903);
        this.M = s1.j(2131168902);
        this.N = s1.j(2131168904);
        this.O = s1.j(2131168906);
        LayoutInflater.from(r2).inflate(2131566883, this);
        this.b = findViewById(2131376730);
        this.c = findViewById(2131379685);
        this.d = (ViewGroup) findViewById(2131379686);
        this.e = (ViewGroup) findViewById(2131388410);
        this.f = (ImageView) findViewById(2131388411);
        this.g = (ViewGroup) findViewById(2131367235);
        this.i = (TextView) findViewById(2131374537);
        this.j = (TextView) findViewById(2131374538);
        this.k = (TextView) findViewById(2131374540);
        this.m = new r(this);
        this.l = new s(this);
        this.n = new t(this);
        this.o = new u(this);
        this.p = new v(this);
    }
}
