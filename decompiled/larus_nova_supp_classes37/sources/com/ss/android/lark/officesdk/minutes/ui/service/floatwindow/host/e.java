package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatSide;
import kotlin.Pair;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static final /* synthetic */ int o = 0;
    public View a;
    public h b;
    public View c;
    public FrameLayout d;
    public View e;
    public FrameLayout f;
    public FrameLayout g;
    public FrameLayout h;
    public qub.g i;
    public String j;
    public g k;
    public Context l;
    public int m;
    public Runnable n;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ e a;
        public final /* synthetic */ hwb.c b;
        public final /* synthetic */ Configuration c;

        public b(e r1, hwb.c r2, Configuration r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e(this.b, this.c);     // Catch: Throwable -> L4
            this.a.n = null;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public e() {
    }

    public final void c() {
        h r0 = this.b;
        if (r0 == null) goto L7;
        View r1 = this.a;
        if (r1 == null) goto L7;
        r1.removeCallbacks(r0);
    L7:
        this.a = null;
        this.b = null;
    }

    public final void d() {
        Runnable r0 = this.n;
        if (r0 == null) goto L7;
        View r1 = this.e;
        if (r1 == null) goto L7;
        r1.removeCallbacks(r0);
    L7:
        this.n = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.a = null;
    }

    public final void i() {
        Runnable r0 = this.n;
        if (r0 == null) goto L7;
        View r1 = this.e;
        if (r1 == null) goto L7;
        r1.removeCallbacks(r0);
    L7:
        this.n = null;
        String r2 = this.j;
        if (r2 == null) goto L12;
        int r3 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "unregisterUiModeChangeListener", "recordingId=".concat(r2), null, 8);
        qub.g r4 = this.i;
        if (r4 == null) goto L12;
        r4.z0();
    L12:
        this.j = null;
        this.i = null;
        g r5 = this.k;
        if (r5 == null) goto L17;
        Context r6 = this.l;
        if (r6 == null) goto L17;
        r6.unregisterComponentCallbacks(r5);
    L17:
        this.k = null;
        this.l = null;
        this.m = 0;
    }

    public final void e(hwb.c r9, Configuration r10) {
        yub.d r0 = yub.d.a;
        Context r1 = com.ss.android.lark.appcontext.applifecycle2.api.a.a();
        if (r1 != null) goto L16;
        View r2 = this.c;
        if (r2 == null) goto L8;
        r1 = r2.getContext();
    L9:
        if (r1 != null) goto L16;
        View r3 = this.e;
        if (r3 == null) goto L13;
        r1 = r3.getContext();
    L14:
        if (r1 != null) goto L16;
        Context r11 = null;
    L22:
        if (r11 != null) goto L24;
        return;
    L24:
        FrameLayout r4 = this.d;
        if (r4 == null) goto L28;
        ConstraintLayout r5 = r9.b.a(r11, new hwb.b(r9.a, r9.f, r9.g, new f(r9)));
        this.c = r5;
        r4.removeAllViews();
        r4.addView(r5, new FrameLayout.LayoutParams(-1, -1));
    L28:
        FrameLayout r6 = this.f;
        if (r6 == null) goto L31;
        r6.setBackground(UIUtils.getDrawable(r11, 2131244717));
    L31:
        ColorStateList r7 = ColorStateList.valueOf(UIUtils.getColor(r11, 2131108742));
        FrameLayout r8 = this.g;
        if (r8 == null) goto L36;
        AppCompatImageView r12 = r8.findViewById(2131380204);
        if (r12 == null) goto L36;
        r12.setImageTintList(r7);
    L36:
        FrameLayout r13 = this.h;
        if (r13 == null) goto L41;
        AppCompatImageView r14 = r13.findViewById(2131380206);
        if (r14 == null) goto L41;
        r14.setImageTintList(r7);
    L41:
        int r15 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "refreshTheme", "recordingId=" + r9.a + ", context=" + r11.getClass().getName(), null, 8);
        return;
    L13:
        r1 = null;
        goto L14
    L8:
        r1 = null;
    L16:
        if (r10 == null) goto L21;
        Context r16 = r1.createConfigurationContext(r10);
        NewMiraResourcesManager.getInstance().install(r16);
        if (r16 == null) goto L21;
        r1 = r16;
    L21:
        r11 = com.ss.android.lark.officesdk.minutes.ui.style.c.c(r1, r9.g);
        goto L22
    }

    public final void f(Context r6, final hwb.c r7) {
        i();
        qub.g r0 = r7.h;
        if (r0 != null) goto L5;
        int r1 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "registerUiModeChangeListener", "uiModeBridge missing, recordingId=" + r7.a, null, 8);
    L8:
        this.m = r6.getResources().getConfiguration().uiMode & 48;
        Context r8 = r6.getApplicationContext();
        this.l = r8;
        g r2 = new g(this, r7);
        if (r8 == null) goto L11;
        r8.registerComponentCallbacks(r2);
    L11:
        this.k = r2;
        return;
    L5:
        new MmSystemRecordingFloatHost$registerUiModeChangeListener$handled$1(r7, this);
        if (r0.L0() == false) goto L8;
        this.i = r0;
        this.j = r7.a;
        goto L8
    }

    public final void g(hwb.c r5, Configuration r6) {
        View r0 = this.e;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r6 == null) goto L8;
        Configuration r2 = new Configuration(r6);
    L9:
        Runnable r7 = this.n;
        if (r7 == null) goto L14;
        View r3 = this.e;
        if (r3 == null) goto L14;
        r3.removeCallbacks(r7);
    L14:
        this.n = null;
        b r8 = new b(this, r5, r2);
        r0.postDelayed(r8, 100);
        this.n = r8;
        return;
    L8:
        r2 = null;
        goto L9
    }

    public static final void a(e r3, View r4, hwb.c r5) {
        r3.getClass();
        if (r5.d.e == false) goto L9;
        if (r4 == null) goto L10;
        r3.c();
        r3.a = r4;
        h r0 = new h(r5);
        r4.postDelayed(r0, r5.c.a());
        r3.b = r0;
        return;
    L10:
        return;
    }

    public static final hwb.d b(e r9, String r10, boolean r11, boolean r12, boolean r13) {
        r9.getClass();
        tfb.a.b r14 = tfb.a.a;
        Pair r15 = tfb.a.b.a(r10);
        Integer r16 = null;
        if (r11 == true) goto L7;
        if (r15 == null) goto L7;
        Integer r7 = (Integer) r15.getFirst();
    L8:
        if (r11 == true) goto L12;
        if (r15 == null) goto L12;
        Integer r8 = (Integer) r15.getSecond();
    L13:
        if (r15 == null) goto L15;
        Integer r4 = (Integer) r15.getFirst();
    L16:
        if (r15 == null) goto L18;
        r16 = (Integer) r15.getSecond();
    L18:
        Integer r5 = r16;
        boolean r2 = !r11;
        if (r12 == false) goto L21;
        MmRecordingFloatSide r17 = MmRecordingFloatSide.RIGHT;
    L23:
        return new hwb.d(r2, r17, r4, r5, r13, r7, r8);
    L21:
        r17 = MmRecordingFloatSide.LEFT;
        goto L23
    L15:
        r4 = null;
    L12:
        r8 = null;
    L7:
        r7 = null;
        goto L8
    }

    public static final void h(Ref.ObjectRef<View> r2, Ref.ObjectRef<FrameLayout> r3, Ref.ObjectRef<FrameLayout> r4, Ref.ObjectRef<FrameLayout> r5, Ref.ObjectRef<FrameLayout> r6, boolean r7, boolean r8) {
        View r0 = (View) r2.element;
        int r1 = 0;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        View r9 = (View) r2.element;
        if (r9 == null) goto L8;
        r9.setAlpha(1.0f);
    L8:
        FrameLayout r10 = (FrameLayout) r3.element;
        if (r10 == null) goto L11;
        r10.setAlpha(1.0f);
    L11:
        FrameLayout r11 = (FrameLayout) r4.element;
        if (r11 == null) goto L14;
        r11.setAlpha(1.0f);
    L14:
        FrameLayout r12 = (FrameLayout) r5.element;
        if (r12 == null) goto L17;
        r12.setAlpha(1.0f);
    L17:
        FrameLayout r13 = (FrameLayout) r6.element;
        if (r13 == null) goto L20;
        r13.setAlpha(1.0f);
    L20:
        FrameLayout r14 = (FrameLayout) r3.element;
        if (r14 == null) goto L26;
        if (r7 == false) goto L24;
        int r15 = 4;
    L25:
        r14.setVisibility(r15);
        goto L26
    L24:
        r15 = 0;
    L26:
        FrameLayout r16 = (FrameLayout) r4.element;
        if (r16 == null) goto L32;
        if (r7 == false) goto L30;
        int r17 = 0;
    L31:
        r16.setVisibility(r17);
        goto L32
    L30:
        r17 = 4;
    L32:
        FrameLayout r18 = (FrameLayout) r5.element;
        if (r18 == null) goto L39;
        if (r7 == false) goto L37;
        if (r8 == false) goto L37;
        int r19 = 0;
    L38:
        r18.setVisibility(r19);
    L37:
        r19 = 4;
    L39:
        FrameLayout r20 = (FrameLayout) r6.element;
        if (r20 == null) goto L47;
        if (r7 == false) goto L44;
        if (r8 == true) goto L44;
    L45:
        r20.setVisibility(r1);
        return;
    L44:
        r1 = 4;
        goto L45
    }
}
