package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.config.s51;
import com.bytedance.bdlocation.BuildConfig;
import ec2.u0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pa2.a;
import ra2.c;
import ra2.d;
import ra2.e;
import ra2.f;
import ra2.g;
import ra2.h;
import ra2.i;
import ra2.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/ui/ConfrontMsgView;", "Landroid/widget/FrameLayout;", "Lra2/m;", "Lpa2/a;", "c", BuildConfig.FLAVOR, "setManagerCallBack", BuildConfig.FLAVOR, "isRunning", "Z", "()Z", "setRunning", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConfrontMsgView extends FrameLayout implements m {
    public final ViewGroup a;
    public final GroupMsgView b;
    public final GroupMsgView c;
    public a d;
    public i e;
    public final View f;
    public c g;
    public d h;
    public e i;
    public f j;
    public g k;
    public h l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public int q;
    public final long r;
    public final long s;
    public final long t;

    public final void setRunning(boolean r1) {
    }

    @Override // ra2.m
    public final boolean a() {
        s51 r0 = (s51) u0.a.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a() != true) goto L7;
        return true;
    }

    public final void b() {
        GroupMsgView r0 = this.b;
        long r1 = 0;
        if (r0 == null) goto L5;
        long r3 = r0.getCurCombo();
    L6:
        GroupMsgView r2 = this.c;
        if (r2 == null) goto L9;
        r1 = r2.getCurCombo();
    L9:
        GroupMsgView.GroupAnimType r4 = null;
        if (r3 >= r1) goto L29;
        GroupMsgView r5 = this.b;
        if (r5 == null) goto L14;
        GroupMsgView.GroupAnimType r6 = r5.getPos();
    L15:
        GroupMsgView.GroupAnimType r7 = GroupMsgView.GroupAnimType.TOP;
        if (r6 != r7) goto L29;
        GroupMsgView r8 = this.c;
        if (r8 == null) goto L20;
        GroupMsgView.GroupAnimType r9 = r8.getPos();
    L21:
        GroupMsgView.GroupAnimType r10 = GroupMsgView.GroupAnimType.DOWN;
        if (r9 != r10) goto L29;
        GroupMsgView r11 = this.b;
        if (r11 == null) goto L26;
        r11.m(r10);
    L26:
        GroupMsgView r13 = this.c;
        if (r13 == null) goto L48;
        r13.m(r7);
        return;
    L48:
        return;
    L20:
        r9 = null;
        goto L21
    L14:
        r6 = null;
    L29:
        if (r3 <= r1) goto L50;
        GroupMsgView r14 = this.b;
        if (r14 == null) goto L33;
        GroupMsgView.GroupAnimType r15 = r14.getPos();
    L34:
        GroupMsgView.GroupAnimType r16 = GroupMsgView.GroupAnimType.DOWN;
        if (r15 != r16) goto L51;
        GroupMsgView r17 = this.c;
        if (r17 == null) goto L39;
        r4 = r17.getPos();
    L39:
        GroupMsgView.GroupAnimType r18 = GroupMsgView.GroupAnimType.TOP;
        if (r4 != r18) goto L52;
        GroupMsgView r19 = this.b;
        if (r19 == null) goto L44;
        r19.m(r18);
    L44:
        GroupMsgView r20 = this.c;
        if (r20 == null) goto L53;
        r20.m(r16);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L33:
        r15 = null;
        goto L34
    L50:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public final void c() {
        GroupMsgView r0 = this.b;
        if (r0 == null) goto L5;
        r0.l();
    L5:
        GroupMsgView r1 = this.c;
        if (r1 == null) goto L8;
        r1.l();
    L8:
        this.q = this.m;
        this.e = null;
        this.d = null;
        removeCallbacks(this.g);
        removeCallbacks(this.j);
        removeCallbacks(this.h);
        removeCallbacks(this.i);
        removeCallbacks(this.k);
        removeCallbacks(this.l);
        clearAnimation();
    }

    public void setManagerCallBack(a r2) {
        Intrinsics.checkNotNullParameter(r2, "c");
        this.d = r2;
    }

    public ConfrontMsgView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.m = -1;
        this.n = 1;
        this.o = 2;
        this.p = 3;
        this.q = 0;
        this.r = 3000;
        this.s = 15000;
        this.t = 500;
        this.f = LayoutInflater.from(r3).inflate(2131567646, this);
        ViewGroup r6 = (ViewGroup) findViewById(2131367677);
        this.a = r6;
        GroupMsgView r7 = (GroupMsgView) findViewById(2131379441);
        this.b = r7;
        GroupMsgView r0 = (GroupMsgView) findViewById(2131374062);
        this.c = r0;
        if (r6 == null) goto L7;
        ViewGroup r8 = UtilityKotlinExtentionsKt.p(r6);
        if (r8 == null) goto L7;
        r8.setClipChildren(false);
    L7:
        i r9 = new i(this);
        this.e = r9;
        if (r7 == null) goto L10;
        r7.setCallback(r9);
    L10:
        if (r0 == null) goto L12;
        r0.setCallback(this.e);
    L12:
        this.g = new c(this);
        this.h = new d(this);
        this.i = new e(this);
        this.j = new f(this);
        this.k = new g(this);
        this.l = new h(this);
    }
}
