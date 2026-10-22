package z52;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.common.InterceptLinearLayout;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.x8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;
import r52.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends Dialog implements com.bytedance.android.live.matchroom.b, n22.c {
    public static final /* synthetic */ int K = 0;
    public BarrageSetting A;
    public boolean B;
    public final float C;
    public final float D;
    public final float E;
    public final int F;
    public final float G;
    public Disposable H;
    public boolean I;
    public final a J;
    public View a;
    public final int b;
    public RadioGroup c;
    public RadioGroup d;
    public RadioButton e;
    public RadioButton f;
    public RadioButton g;
    public RadioButton h;
    public RadioButton i;
    public RadioButton j;
    public RadioButton k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public Button r;
    public SeekBar s;
    public ToggleButton t;
    public ToggleButton u;
    public InterceptLinearLayout v;
    public View w;
    public final boolean x;
    public BarrageSetting y;
    public BarrageSettingArea z;

    public class a implements SeekBar.OnSeekBarChangeListener {
        public final /* synthetic */ b a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r1) {
        }

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r3) {
            b r4 = this.a;
            r4.e(r4.y);
            xs2.b.a().post(new q22.b(this.a.y));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r3, int r4, boolean r5) {
            TextView r6 = this.a.q;
            StringBuilder r7 = new StringBuilder();
            b r0 = this.a;
            float r8 = r4;
            r7.append((int) ((((r0.F - 20) / r0.G) * r8) + 20.0f));
            r7.append("%");
            r6.setText(r7.toString());
            b r9 = this.a;
            r9.y.setAlpha((((r9.F - 20) / r9.G) * r8) + 20.0f);
        }
    }

    /* JADX INFO: renamed from: z52.b$b, reason: collision with other inner class name */
    public class ViewOnClickListenerC0299b implements View.OnClickListener {
        public final /* synthetic */ b a;

        public ViewOnClickListenerC0299b(b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            b r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[BarrageSettingFont.values().length];
            b = r0;
            r0[BarrageSettingFont.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            b[BarrageSettingFont.MID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L27:
            b[BarrageSettingFont.BIG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            int[] r3 = new int[BarrageSettingArea.values().length];
            a = r3;
            r3[BarrageSettingArea.CLOSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L33:
            a[BarrageSettingArea.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L21:
            a[BarrageSettingArea.HALF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L25:
            a[BarrageSettingArea.FULL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    public final void b() {
        if (this.I == false) goto L5;
        return;
    L5:
        int r1 = 0;
        this.v.setIsIntercept(false);
        this.m.setAlpha(this.E);
        this.n.setAlpha(this.E);
        this.o.setAlpha(this.E);
        this.p.setAlpha(this.E);
        this.q.setAlpha(this.E);
        this.s.setAlpha(this.E);
        this.c.setEnabled(true);
        this.t.setAlpha(this.E);
        this.u.setAlpha(this.E);
    L7:
        if (r1 >= this.c.getChildCount()) goto L9;
        this.c.getChildAt(r1).setEnabled(true);
        r1 = r1 + 1;
        goto L7
    }

    @Override // android.app.Dialog, android.content.DialogInterface, n22.c
    public final void dismiss() {
        MatchRoomLandScapeAnimUtil.E.j("LandscapeBarrageSettingDialog");
        com.bytedance.android.livesdk.f.d().f();
        Disposable r0 = this.H;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Handler r1 = DialogLancet.resolveDialogHandler(this);
        if (r1 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r1.getLooper()) goto L10;
        r1.post(DialogLancet.createDismissRunnable(this));
    }

    public final int getActualContentWidth() {
        return s1.f(248.0f);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        if (this.y.getBarrageArea() == this.A.getBarrageArea()) goto L5;
    L14:
        this.B = true;
    L15:
        BarrageSetting r0 = this.y;
        j0.l().sendLog("livesdk_landscape_barrage_settings_change", c(r0), new Object[]{new x(), IRoom.class});
        e(this.y);
        super.onStop();
        return;
    L5:
        if (this.y.getFontSize() != this.A.getFontSize()) goto L14;
        if (this.y.getAlpha() != this.A.getAlpha()) goto L14;
        if (this.y.isGiftOpen() != this.A.isGiftOpen()) goto L14;
        if (this.y.isNeedRollback() != this.A.isNeedRollback()) goto L14;
        this.B = false;
        goto L15
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        BarrageSetting r0 = (BarrageSetting) l42.a.d.getValue();
        this.y = r0;
        if (r0 != null) goto L10;
    L13:
        BarrageSetting r1 = new BarrageSetting();
        r1.setBarrageArea(BarrageSettingArea.HALF);
        r1.setFontSize(BarrageSettingFont.MID);
        r1.setAlpha(75.0f);
        r1.setGiftOpen(true);
        r1.setChatChannelOpen(true);
        this.y = r1;
    L14:
        BarrageSetting r2 = this.y;
        BarrageSetting r3 = new BarrageSetting();
        r3.setBarrageArea(r2.getBarrageArea());
        r3.setFontSize(r2.getFontSize());
        r3.setAlpha(r2.getAlpha());
        r3.setGiftOpen(r2.isGiftOpen());
        r3.setChatChannelOpen(r2.isChatChannelOpen());
        r3.setNeedRollback(r2.isNeedRollback());
        this.A = r3;
        if (((Boolean) l42.a.g.getValue()).booleanValue() == false) goto L18;
        this.z = this.y.getBarrageArea();
        this.y.setBarrageArea(BarrageSettingArea.CLOSE);
    L20:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r4 = q.b();
        if (r4 == null) goto L23;
        this.I = ((Boolean) r4.isCarnivalStarted().getValue()).booleanValue();
        this.H = r4.isCarnivalStarted().a().subscribe(new z52.a(this));
    L23:
        d(this.y);
        this.r.setOnClickListener(new z52.c(this));
        this.d.setOnCheckedChangeListener(new d(this));
        this.c.setOnCheckedChangeListener(new e(this));
        this.s.setOnSeekBarChangeListener(this.J);
        this.t.setOnCheckedChangeListener(new f(this));
        this.u.setOnCheckedChangeListener(new g(this));
        boolean r5 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.x("LandscapeBarrageSettingDialog", this, -1);
        com.bytedance.android.livesdk.f.d().a();
        BarrageSetting r6 = this.y;
        j0.l().sendLog("livesdk_landscape_barrage_settings_panel_show", c(r6), new Object[]{x.class, IRoom.class});
        return;
    L18:
        if (this.y.getBarrageArea().equals(BarrageSettingArea.CLOSE) == false) goto L20;
        this.y.setBarrageArea(BarrageSettingArea.HALF);
        goto L20
    L10:
        if (r0.getBarrageArea() == null) goto L13;
        if (this.y.getFontSize() != null) goto L14;
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public b(Context r2) {
        super(r2, 2131954620);
        this.b = 340;
        this.x = ((Boolean) h0.a.getValue()).booleanValue();
        this.B = false;
        this.C = 0.5f;
        this.D = 0.34f;
        this.E = 1.0f;
        this.F = 100;
        this.G = 100.0f;
        this.J = new a(this);
    }

    public final void a(boolean r3) {
        if (r3 == false) goto L4;
        this.y.setBarrageArea(BarrageSettingArea.CLOSE);
    L4:
        this.v.setIsIntercept(true);
        this.c.clearCheck();
        this.m.setAlpha(this.D);
        this.n.setAlpha(this.D);
        this.o.setAlpha(this.D);
        this.p.setAlpha(this.D);
        this.q.setAlpha(this.D);
        this.s.setAlpha(this.C);
        this.c.setEnabled(false);
        this.t.setAlpha(this.C);
        this.u.setAlpha(this.C);
        int r4 = 0;
    L6:
        if (r4 >= this.c.getChildCount()) goto L8;
        this.c.getChildAt(r4).setEnabled(false);
        r4 = r4 + 1;
        goto L6
    }

    public final Map<String, String> c(BarrageSetting r9) {
        HashMap r0 = new HashMap();
        if (this.y != null) goto L5;
        return r0;
    L5:
        int r1 = c.a[r9.getBarrageArea().ordinal()];
        String r2 = "null";
        String r6 = "close";
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        if (r1 != 3) goto L10;
        String r3 = "half";
    L16:
        r0.put("barrage_position", r3);
        int r4 = c.b[r9.getFontSize().ordinal()];
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L22;
        if (r4 != 3) goto L24;
        r2 = "large";
    L24:
        r0.put("barrage_size", r2);
        r0.put("opacity", r9.getAlpha() + BuildConfig.FLAVOR);
        if (r9.isGiftOpen() == false) goto L27;
        Object r5 = "open";
    L28:
        r0.put("gift_message", r5);
        if (this.B == false) goto L31;
        String r7 = "1";
    L32:
        r0.put("is_change", r7);
        if (this.x == true) goto L35;
    L38:
        return r0;
    L35:
        if (r9.isLotteryOpen() == false) goto L37;
        r6 = "open";
    L37:
        r0.put("lottery_message", r6);
        goto L38
    L31:
        r7 = "0";
        goto L32
    L27:
        r5 = "close";
        goto L28
    L22:
        r2 = "medium";
        goto L24
    L23:
        r2 = "small";
        goto L24
    L10:
        if (r1 == 4) goto L12;
        r3 = "null";
        goto L16
    L12:
        r3 = "full_screen";
        goto L16
    L14:
        r3 = "top";
        goto L16
    L15:
        r3 = "close";
        goto L16
    }

    public final void d(BarrageSetting r8) {
        BarrageSettingArea r0 = r8.getBarrageArea();
        int r1 = c.a[r0.ordinal()];
        boolean r4 = true;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L11;
        if (r1 != 3) goto L7;
        this.i.setChecked(true);
    L13:
        int r2 = c.b[r8.getFontSize().ordinal()];
        if (r2 == 1) goto L20;
        if (r2 == 2) goto L19;
        if (r2 != 3) goto L21;
        this.e.setChecked(true);
    L21:
        float r3 = r8.getAlpha();
        this.s.setProgress((int) ((r3 - 20.0f) / ((this.F - 20) / this.G)));
        this.q.setText(((int) r3) + "%");
        this.t.setChecked(r8.isGiftOpen());
        ToggleButton r5 = this.u;
        if (p61.a.a() == false) goto L24;
    L26:
        r4 = false;
    L27:
        r5.setChecked(r4);
        BarrageSettingArea r6 = BarrageSettingArea.CLOSE;
        if (r0.equals(r6) == false) goto L30;
    L33:
        a(r0.equals(r6));
    L34:
        xs2.b.a().post(new q22.b(r8));
        return;
    L30:
        if (this.I == true) goto L33;
        b();
        goto L34
    L24:
        if (r8.isLotteryOpen() == false) goto L26;
    L19:
        this.f.setChecked(true);
        goto L21
    L20:
        this.g.setChecked(true);
        goto L21
    L7:
        if (r1 != 4) goto L13;
        this.k.setChecked(true);
        goto L13
    L11:
        this.j.setChecked(true);
        goto L13
    L12:
        this.h.setChecked(true);
        goto L13
    }

    public final void e(BarrageSetting r2) {
        if (r2.isNeedRollback() == false) goto L7;
        BarrageSettingArea r0 = this.z;
        if (r0 == null) goto L7;
        r2.setBarrageArea(r0);
    L7:
        com.bytedance.android.livesdk.sharedpref.e<BarrageSetting> r1 = l42.a.d;
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r2);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        if (this.x == false) goto L5;
        ScrollView r5 = new ScrollView(getContext());
        r5.addView(LayoutInflater.from(getContext()).inflate(2131566626, null));
        this.a = r5;
    L7:
        if (Build.VERSION.SDK_INT <= 23) goto L9;
        this.a.setBackgroundResource(2131248722);
    L10:
        setContentView(this.a);
        getWindow().setLayout((int) UIUtils.dip2Px(getContext(), this.b), -1);
        getWindow().setGravity(8388613);
        this.c = (RadioGroup) findViewById(2131378314);
        this.d = (RadioGroup) findViewById(2131378225);
        this.r = (Button) findViewById(2131378247);
        this.s = (SeekBar) findViewById(2131378236);
        this.t = (ToggleButton) findViewById(2131378244);
        this.u = (ToggleButton) findViewById(2131378245);
        this.e = (RadioButton) findViewById(2131378241);
        this.f = (RadioButton) findViewById(2131378242);
        this.g = (RadioButton) findViewById(2131378243);
        this.h = (RadioButton) findViewById(2131378246);
        this.j = (RadioButton) findViewById(2131378250);
        this.i = (RadioButton) findViewById(2131378249);
        this.k = (RadioButton) findViewById(2131378248);
        this.v = (InterceptLinearLayout) findViewById(2131389596);
        this.l = (TextView) findViewById(2131389471);
        this.q = (TextView) findViewById(2131378237);
        this.m = (TextView) findViewById(2131389472);
        this.n = (TextView) findViewById(2131389470);
        this.o = (TextView) findViewById(2131389473);
        this.p = (TextView) findViewById(2131389475);
        View r6 = findViewById(2131389474);
        this.w = r6;
        if (this.x == true) goto L13;
        r6.setVisibility(8);
    L13:
        this.l.setOnClickListener(new ViewOnClickListenerC0299b(this));
        x8.b(this);
        return;
    L9:
        this.a.setBackgroundResource(2131249572);
        goto L10
    L5:
        this.a = LayoutInflater.from(getContext()).inflate(2131566626, null);
        goto L7
    }
}
