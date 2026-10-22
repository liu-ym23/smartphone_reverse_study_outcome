package sr0;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.performance.adapter.DebugNormalInfoAdapter;
import com.bytedance.android.live.performance.adapter.DebugPerformanceTextAdapter;
import com.bytedance.android.live.performance.api.IPerfToolsService;
import com.bytedance.android.live.performance.views.PerftoolsLinearLayout;
import com.bytedance.android.live.performance.views.PerftoolsRelativeLayout;
import com.bytedance.android.live.performance.views.charts.LineChartView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Arrays;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements ur0.a, ur0.b {
    public final Handler A;
    public Button B;
    public Button C;
    public WindowManager a;
    public final WindowManager.LayoutParams b;
    public PerftoolsRelativeLayout c;
    public PerftoolsLinearLayout d;
    public FrameLayout e;
    public FrameLayout f;
    public boolean g;
    public boolean h;
    public GridView i;
    public tr0.b j;
    public RecyclerView k;
    public DebugNormalInfoAdapter l;
    public LineChartView m;
    public LinearLayout n;
    public GridView o;
    public tr0.g p;
    public TextView q;
    public RecyclerView r;
    public DebugPerformanceTextAdapter s;
    public final IPerfToolsService t;
    public Dialog u;
    public boolean v;
    public final a w;
    public Activity x;
    public int y;
    public int z;

    public class a implements View.OnTouchListener {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r8, MotionEvent r9) {
            i r10 = this.a;
            if (r10.g == false) goto L6;
            View r11 = r10.c;
        L10:
            if (r11 == null) goto L15;
            View r1 = wr0.d.a(r11, r9);
            if (r1 == null) goto L15;
            r1.dispatchTouchEvent(r9);
            return true;
        L15:
            Dialog r2 = this.a.u;
            if (r2 != null) goto L18;
        L35:
            Activity r12 = this.a.x;
            if (r12 == null) goto L38;
            r12.dispatchTouchEvent(r9);
        L38:
            return false;
        L18:
            if (r2.isShowing() == false) goto L35;
            if (this.a.v == true) goto L34;
            int[] r3 = new int[2];
            if (r11 == null) goto L24;
            r11.getLocationOnScreen(r3);
        L25:
            int[] r13 = new int[2];
            Window r4 = this.a.u.getWindow();
            if (r4 == null) goto L33;
            View r5 = r4.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L32;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r6 = ThreadMethodProxy.currentThread();
            if (r6 == com.larus.home.impl.utils.c.a) goto L32;
            com.larus.home.impl.utils.c.a(r6, "getDecorView");
        L32:
            r5.getLocationOnScreen(r13);
        L33:
            r9.offsetLocation(r3[0] - r13[0], r3[1] - r13[1]);
            goto L34
        L24:
            Arrays.fill(r3, 0);
        L34:
            this.a.u.dispatchTouchEvent(r9);
            goto L38
        L6:
            if (r10.h == false) goto L8;
            r11 = r10.d;
            goto L10
        L8:
            r11 = null;
            goto L10
        }
    }

    public final void a() {
        if (this.a != null) goto L5;
        return;
    L5:
        if (this.c != null) goto L7;
        return;
    L7:
        if (this.g == true) goto L9;
        return;
    L9:
        if (wr0.c.a() == false) goto L11;
        this.a.removeViewImmediate(this.c);
    L12:
        this.g = false;
        return;
    L11:
        this.a.removeView(this.c);
        goto L12
    }

    public final void b() {
        if (this.a != null) goto L5;
        return;
    L5:
        if (this.d != null) goto L7;
        return;
    L7:
        if (this.h == true) goto L9;
        return;
    L9:
        if (wr0.c.a() == false) goto L11;
        this.a.removeViewImmediate(this.d);
    L12:
        this.h = false;
        return;
    L11:
        this.a.removeView(this.d);
        goto L12
    }

    public final void c() {
        Activity r0 = this.x;
        if (r0 != null) goto L5;
        return;
    L5:
        PerftoolsLinearLayout r1 = (PerftoolsLinearLayout) LayoutInflater.from(r0).inflate(2131567148, null);
        this.d = r1;
        r1.setActivity(this.x);
        this.i = (GridView) this.d.findViewById(2131373900);
        tr0.b r2 = new tr0.b(this.x, this);
        this.j = r2;
        r2.a(0);
        r2.a(1);
        r2.a(4);
        r2.a(2);
        r2.a(3);
        r2.a(5);
        r2.a(6);
        r2.a(7);
        r2.a(8);
        FrameLayout r3 = (FrameLayout) this.d.findViewById(2131366995);
        this.f = r3;
        r3.setOnClickListener(new b(this));
        this.i.setAdapter(this.j);
        WindowManager.LayoutParams r4 = this.b;
        r4.width = -1;
        r4.height = -2;
        r4.x = 0;
        r4.y = 0;
        r4.gravity = 80;
        f();
        this.d.setOnTouchListener(this.w);
        WindowManager r5 = this.a;
        PerftoolsLinearLayout r6 = this.d;
        WindowManager.LayoutParams r7 = this.b;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r6, r7);
        r5.addView(r6, r7);
        this.h = true;
    }

    public final boolean d() {
        RecyclerView r0 = this.k;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        return true;
    }

    public final boolean e() {
        LinearLayout r0 = this.n;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        return true;
    }

    public final void f() {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.b.type = 2038;
    L6:
        WindowManager.LayoutParams r0 = this.b;
        r0.format = -3;
        r0.flags = (r0.flags | 32) | 8;
        r0.softInputMode = 16;
        return;
    L5:
        this.b.type = 2002;
        goto L6
    }

    public i() {
        this.b = new WindowManager.LayoutParams();
        this.w = new a(this);
        this.y = -1;
        this.z = 1000;
        this.A = new Handler(Looper.getMainLooper());
        this.t = (IPerfToolsService) k.f(IPerfToolsService.class);
    }
}
