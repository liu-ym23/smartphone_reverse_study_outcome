package xc;

import ac.h;
import ac.n;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.obric.cae.R;
import com.obric.cae.statusReport.network.NetworkReportUtil;
import com.obric.oui.button.OButton;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.obric.oui.toast.ToastBackgroundView;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import he.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f13842i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f13843j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f13844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Toast f13845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f13847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OButton f13848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Activity f13849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f13850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f13851h;

    /* JADX INFO: renamed from: xc.a$a, reason: collision with other inner class name */
    public static final class C0194a {
        public static void a() {
            int r8 = a.f13842i;
        }
    }

    public final class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f13852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f13854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f13855d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f13856e;

        public b(a r8) {
            this.f13856e = r8;
            this.f13853b = -4;
            this.f13854c = 1.0f;
            this.f13855d = 0.9f;
            this.f13852a = new Rect();
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r10) {
            Rect r11 = this.f13852a;
            if (r8 == null) goto L7;
            Drawable r12 = r8.getBackground();
            if (r12 == null) goto L7;
            r12.copyBounds(r11);
        L7:
            float r13 = this.f13854c;
            if (r13 == 1.0f) goto L10;
            r11.left = (int) ((r11.left * r13) + 0.5f);
            r11.right = (int) ((r11.right * r13) + 0.5f);
        L10:
            float r14 = this.f13855d;
            if (r14 == 1.0f) goto L13;
            r11.top = (int) ((r11.top * r14) + 0.5f);
            r11.bottom = (int) ((r11.bottom * r14) + 0.5f);
        L13:
            r11.offset(0, this.f13853b);
            if (r10 == null) goto L17;
            r10.setRoundRect(r11, this.f13856e.f13849f.getResources().getDimension(R.dimen.oui_r_l1));
            return;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowManager.LayoutParams f13857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerC0195a f13858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13860d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f13861e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f13862f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f13863g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Activity f13864h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public WindowManager f13865i;

        /* JADX INFO: renamed from: xc.a$c$a, reason: collision with other inner class name */
        public static final class HandlerC0195a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f13866a;

            public HandlerC0195a(c r8) {
                this.f13866a = r8;
            }

            @Override // android.os.Handler
            public final void handleMessage(Message r8) {
                i.f(r8, "msg");
                int r10 = r8.what;
                c r11 = this.f13866a;
                if (r10 != 1) goto L6;
                c.a(r11);
                return;
            L6:
                if (r10 != 2) goto L10;
                r11.b();
                r11.f13863g = null;
                r11.f13864h = null;
                return;
            }
        }

        public c() {
            WindowManager.LayoutParams r8 = new WindowManager.LayoutParams();
            this.f13857a = r8;
            this.f13858b = new HandlerC0195a(this);
            this.f13861e = NetworkReportUtil.INTERVENTION_REPORT_EVENT_DELAY;
            r8.height = -2;
            r8.width = -2;
            r8.format = -3;
            int r10 = Class.forName("com.android.internal.R$".concat("style")).getField("Animation_Toast").getInt(null);     // Catch: Exception -> L5
        L7:
            r8.windowAnimations = r10;
            r8.type = 2;
            r8.flags = 168;
            r8.setTitle("CustomToast");
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            r10 = 0;
            goto L7
        }

        public static final void a(c r15) {
            r15.getClass();
            int r8 = a.f13842i;
            C0194a.a();
            Log.v("OToast", "HANDLE SHOW: " + r15 + " mView=" + r15.f13862f + " mNextView=" + r15.f13863g);
            r15.b();
            Activity r10 = r15.f13864h;
            View r11 = r15.f13863g;
            i.c(r11);
            int r12 = r15.f13860d;
            View r13 = r11;
            if (r10 != null) goto L6;
        L31:
            r15.f13862f = r13;
            Context r14 = r13.getContext();
            i.e(r14, "mView!!.context");
            Context r16 = r14.getApplicationContext();
            View r17 = r15.f13862f;
            i.c(r17);
            Context r18 = r17.getContext();
            i.e(r18, "mView!!.context");
            String r19 = r18.getPackageName();
            if (r16 != null) goto L34;
            View r20 = r15.f13862f;
            i.c(r20);
            r16 = r20.getContext();
        L34:
            i.c(r16);
            Object r21 = r16.getSystemService("window");
            if (r21 == null) goto L52;
            r15.f13865i = (WindowManager) r21;
            View r22 = r15.f13862f;
            i.c(r22);
            Context r23 = r22.getContext();
            i.e(r23, "mView!!.context");
            Resources r24 = r23.getResources();
            i.e(r24, "mView!!.context.resources");
            Configuration r25 = r24.getConfiguration();
            int r26 = r15.f13859c;
            i.e(r25, "config");
            int r27 = Gravity.getAbsoluteGravity(r26, r25.getLayoutDirection());
            WindowManager.LayoutParams r28 = r15.f13857a;
            r28.gravity = r27;
            if ((r27 & 7) != 7) goto L40;
            r28.horizontalWeight = 1.0f;
        L40:
            if ((r27 & BWDLInnerConstant.LINK_RECOVERY) != 112) goto L42;
            r28.verticalWeight = 1.0f;
        L42:
            r28.x = 0;
            r28.verticalMargin = 0.0f;
            r28.horizontalMargin = 0.0f;
            r28.y = 0;
            r28.width = -1;
            Activity r29 = r15.f13864h;
            i.c(r29);
            Window r30 = r29.getWindow();
            i.e(r30, "mActivity!!.window");
            r28.token = r30.getAttributes().token;
            r28.packageName = r19;
            View r31 = r15.f13862f;
            i.c(r31);
            if (r31.getParent() == null) goto L45;
            int r32 = a.f13842i;
            C0194a.a();
            Log.v("OToast", "REMOVE! " + r15.f13862f + " in " + r15);
            WindowManager r33 = r15.f13865i;
            i.c(r33);
            r33.removeView(r15.f13862f);
        L45:
            int r34 = a.f13842i;
            C0194a.a();
            Log.v("OToast", "ADD! " + r15.f13862f + " in " + r15);
            WindowManager r35 = r15.f13865i;     // Catch: Exception -> L48
            i.c(r35);     // Catch: Exception -> L48
            r35.addView(r15.f13862f, r28);     // Catch: Exception -> L48
            return;
        L48:
            e = move-exception;
            e.printStackTrace();
            return;
        L52:
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        L6:
            if ((r11 instanceof ToastBackgroundView) == false) goto L8;
            View r36 = r11;
        L9:
            ToastBackgroundView r37 = (ToastBackgroundView) r36;
            if (r37 == null) goto L12;
            int r38 = r37.getCornerRadius();
        L13:
            View r39 = LayoutInflater.from(r10).inflate(R.layout.o_layout_popover_shadow_frame, null);
            if (r39 == null) goto L54;
            SingleChildFrameLayout r40 = (SingleChildFrameLayout) r39;
            r40.addView(r11, new FrameLayout.LayoutParams(-2, -2));
            r40.setShadowCornerRadius(r38);
            Iterator r41 = h.j(r10, R.style.OUIShadow_3_2_low_elevation).iterator();
            int r42 = 0;
            int r43 = 0;
            int r110 = 0;
            int r111 = 0;
        L17:
            if (r41.hasNext() == false) goto L30;
            n r112 = (n) r41.next();
            float r113 = r112.f335b - r112.f336c;
            if (r113 <= r43) goto L21;
            r43 = l6.a.I0(r113);
        L21:
            float r114 = r112.f335b + r112.f336c;
            if (r114 <= r110) goto L24;
            r110 = l6.a.I0(r114);
        L24:
            float r115 = r112.f335b - r112.f337d;
            if (r115 <= r42) goto L27;
            r42 = l6.a.I0(r115);
        L27:
            float r116 = r112.f335b + r112.f337d;
            if (r116 <= r111) goto L17;
            r111 = l6.a.I0(r116);
            goto L17
        L30:
            SingleChildFrameLayout r44 = new SingleChildFrameLayout(r10, null);
            r44.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
            FrameLayout.LayoutParams r45 = new FrameLayout.LayoutParams(-2, -2);
            r45.gravity = 1;
            j r46 = j.f13877a;
            r44.addView(r40, r45);
            r44.setClipChildren(false);
            r44.setClipToPadding(false);
            r44.setPadding(0, r42, 0, r12);
            r13 = r44;
            goto L31
        L54:
            throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
        L12:
            r38 = (int) 24.0f;
            goto L13
        L8:
            r36 = null;
            goto L9
        }

        public final void b() {
            View r8 = this.f13862f;
            if (r8 != null) goto L5;
            return;
        L5:
            if (r8.getParent() == null) goto L7;
            int r10 = a.f13842i;
            C0194a.a();
            Log.v("OToast", "REMOVE! " + this.f13862f + " in " + this);
            WindowManager r11 = this.f13865i;
            i.c(r11);
            r11.removeView(this.f13862f);
        L7:
            this.f13862f = null;
        }

        public final void c() {
            int r8 = a.f13842i;
            Log.v("OToast", "SHOW: " + this);
            HandlerC0195a r10 = this.f13858b;
            r10.sendEmptyMessage(1);
            r10.removeMessages(2);
            r10.sendEmptyMessageDelayed(2, this.f13861e);
        }
    }

    static {
        Resources r8 = Resources.getSystem();
        i.e(r8, "Resources.getSystem()");
        TypedValue.applyDimension(1, 8, r8.getDisplayMetrics());
        f13842i = android.aimedia.a.a("Resources.getSystem()", 1, 20);
        f13843j = android.aimedia.a.a("Resources.getSystem()", 1, 96);
        new WeakReference(null);
    }

    public a(Activity r8, String r10) {
        i.f(r8, "mContext");
        i.f(r10, "msg");
        this.f13849f = r8;
        this.f13850g = r10;
        this.f13851h = 80;
        c r11 = new c();
        this.f13844a = r11;
        this.f13846c = android.aimedia.a.a("Resources.getSystem()", 1, 288);
        int r12 = android.aimedia.a.a("Resources.getSystem()", 1, 73);
        View r13 = LayoutInflater.from(r8).inflate(R.layout.o_toast, null);
        i.e(r13, "LayoutInflater\n        .…e(R.layout.o_toast, null)");
        this.f13847d = r13;
        r11.f13860d = f13843j;
        r11.f13859c = 80;
        if (t2.b.J(r8) == true) goto L9;
        Resources r14 = r8.getResources();
        i.e(r14, "resources");
        DisplayMetrics r15 = r14.getDisplayMetrics();
        if (r15 == null) goto L7;
        int r16 = r15.widthPixels;
    L8:
        this.f13846c = r16 - r12;
        goto L9
    L7:
        r16 = 0;
    L9:
        TextView r17 = (TextView) r13.findViewById(R.id.tv_msg);
        i.e(r17, "it");
        r17.setText(r10);
        View r18 = r13.findViewById(R.id.right_button);
        i.e(r18, "contentView.findViewById(R.id.right_button)");
        this.f13848e = (OButton) r18;
        r13.setOutlineProvider(new b(this));
    }

    public final void a() {
        OButton r8 = this.f13848e;
        Activity r10 = this.f13849f;
        View r11 = this.f13847d;
        int r12 = this.f13851h;
        if (r12 != 17) goto L5;
    L11:
        int r13 = 0;
    L12:
        View r14 = r11.findViewById(R.id.tv_msg);     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        i.e(r14, "contentView.findViewById<TextView>(R.id.tv_msg)");     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        ((TextView) r14).setMaxWidth(this.f13846c);     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        r11.measure(0, 0);     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        if ((r11 instanceof ToastBackgroundView) == false) goto L15;
        View r15 = r11;
    L16:
        ToastBackgroundView r16 = (ToastBackgroundView) r15;     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        if (r16 == null) goto L19;
        r16.setupBackground(r11.getMeasuredHeight());     // Catch: DeadObjectException -> L31 RuntimeException -> L33
    L19:
        c r17 = this.f13844a;     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        r17.f13863g = r11;     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        r17.f13864h = r10;     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        r17.f13859c = r12;     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        r17.f13860d = r13;     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        i.f(r8, "$this$isGone");     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        if (r8.getVisibility() != 8) goto L22;
        boolean r18 = true;
    L23:
        if (r18 == false) goto L25;
    L28:
        Resources r19 = Resources.getSystem();     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        i.e(r19, "Resources.getSystem()");     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        r11.setElevation(TypedValue.applyDimension(1, 8, r19.getDisplayMetrics()));     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        Toast r20 = Toast.makeText(r10, this.f13850g, 0);     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        r20.setView(r11);     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        r20.setGravity(r12, r20.getXOffset(), r13);     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        this.f13845b = r20;     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        r20.show();     // Catch: DeadObjectException -> L31 RuntimeException -> L33
    L29:
        j r110 = j.f13877a;     // Catch: DeadObjectException -> L31 RuntimeException -> L33
    L39:
        return;
    L25:
        if (r8.isClickable() == false) goto L28;
        r17.c();     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        goto L29
    L22:
        r18 = false;
        goto L23
    L15:
        r15 = null;
        goto L16
    L5:
        if (r12 != 48) goto L7;
        r13 = f13842i;     // Catch: DeadObjectException -> L31 RuntimeException -> L33
        goto L12
    L7:
        if (r12 != 80) goto L11;
        r13 = f13843j;     // Catch: DeadObjectException -> L31 RuntimeException -> L33
    L31:
        e = move-exception;
        StringBuilder r21 = new StringBuilder("Try DeadObjectException occur, ");
        String r111 = e.getMessage();
    L35:
        r21.append(r111);
        l6.a.A0(r21.toString());
        l6.a.A0("OToast, showAsDropDown exception occur, try showAtLocation");
        return;
    L33:
        e = move-exception;
        r21 = new StringBuilder("Try runtimeException occur, ");
        r111 = e.getMessage();
        goto L35
    }
}
