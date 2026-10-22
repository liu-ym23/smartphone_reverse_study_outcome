package nr8;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import hq9.e4;
import hq9.n3;
import hq9.r3;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l extends b {
    public final n3 g;
    public final Lazy h;
    public final Lazy i;
    public View j;
    public float k;
    public float l;
    public boolean m;
    public boolean n;

    public final void d() {
        View r0 = this.j;
        if (r0 == null) goto L14;
        ViewPropertyAnimator r1 = r0.animate();
        if (r1 == null) goto L15;
        ViewPropertyAnimator r2 = r1.translationY(0.0f);
        if (r2 == null) goto L16;
        ViewPropertyAnimator r3 = r2.alpha(1.0f);
        if (r3 == null) goto L17;
        ViewPropertyAnimator r4 = r3.setDuration(120);
        if (r4 == null) goto L18;
        r4.start();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // nr8.b
    public final void b() {
        setContentView(2131562088);
    }

    public static void c(l r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        if (this.n == false) goto L5;
        return true;
    L5:
        int r0 = r9.getActionMasked();
        boolean r3 = false;
        if (r0 != 0) goto L8;
        this.k = r9.getRawX();
        this.l = r9.getRawY();
        this.m = false;
        this.n = false;
        View r1 = this.j;
        if (r1 == null) goto L72;
        ViewPropertyAnimator r2 = r1.animate();
        if (r2 == null) goto L72;
        r2.cancel();
    L72:
        View r4 = this.j;
        if (r4 == null) goto L75;
        r4.setAlpha(1.0f);
    L75:
        View r5 = this.j;
        if (r5 == null) goto L79;
        r5.setTranslationY(0.0f);
    L79:
        return super.dispatchTouchEvent(r9);
    L8:
        if (r0 == 1) goto L30;
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L79;
        d();
        this.m = false;
        this.n = false;
        goto L79
    L15:
        if (this.m == true) goto L23;
        float r6 = r9.getRawY() - this.l;
        float r7 = r9.getRawX() - this.k;
        if (r6 < (-((Number) this.h.getValue()).intValue())) goto L19;
    L21:
        if (r3 == false) goto L79;
    L19:
        if (Math.abs(r6) <= (Math.abs(r7) * 1.2f)) goto L21;
        r3 = true;
    L23:
        if (this.m == true) goto L25;
        this.m = true;
        MotionEvent r8 = MotionEvent.obtain(r9);
        r8.setAction(3);
        super.dispatchTouchEvent(r8);
        r8.recycle();
    L25:
        float r10 = r9.getRawY() - this.l;
        View r11 = this.j;
        if (r11 == null) goto L28;
        r11.setTranslationY(RangesKt.coerceAtMost(r10, 0.0f));
    L28:
        return true;
    L30:
        if (this.m == false) goto L66;
        float r12 = r9.getRawY() - this.l;
        View r13 = this.j;
        if (r13 == null) goto L34;
        r13.setTranslationY(RangesKt.coerceAtMost(r12, 0.0f));
    L34:
        float r14 = r9.getRawY() - this.l;
        float r15 = r9.getRawX() - this.k;
        View r16 = this.j;
        if (r16 == null) goto L37;
        int r17 = r16.getHeight();
    L39:
        if (r14 <= (-Math.max(((Number) this.i.getValue()).floatValue(), r17 * 0.45f))) goto L41;
    L43:
        boolean r18 = false;
    L44:
        if (r18 == true) goto L46;
        d();
        this.m = false;
        this.n = false;
    L65:
        return true;
    L46:
        if (this.n == true) goto L65;
        this.n = true;
        View r19 = this.j;
        if (r19 != null) goto L54;
        r3 r20 = this.g.o;
        if (r20 == null) goto L53;
        r20.a();
    L53:
        c(this);
        goto L65
    L54:
        Integer r21 = Integer.valueOf(r19.getHeight());
        if (r21.intValue() <= 0) goto L57;
        r3 = true;
    L57:
        if (r3 == true) goto L60;
        r21 = null;
    L60:
        if (r21 == null) goto L62;
        int r22 = r21.intValue();
    L63:
        r19.animate().translationY(-r22).alpha(0.0f).setDuration(120).withEndAction(new i(this)).start();
        goto L65
    L62:
        Resources r23 = getContext().getResources();
        r22 = WindowDisplayMetricsOverride.apply(r23, r23.getDisplayMetrics()).heightPixels;
        goto L63
    L41:
        if (Math.abs(r14) <= (Math.abs(r15) * 1.2f)) goto L43;
        r18 = true;
        goto L44
    L37:
        r17 = 0;
        goto L39
    L66:
        this.m = false;
        this.n = false;
        goto L79
    }

    @Override // nr8.b, android.app.Dialog
    public final void onCreate(Bundle r18) {
        super.onCreate(r18);
        FLogger.a.i("NotificationDialog", "show");
        final n3 r1 = this.g;
        SimpleDraweeView r2 = findViewById(2131377781);
        TextView r3 = (TextView) findViewById(2131388772);
        TextView r4 = (TextView) findViewById(2131367794);
        ImageView r5 = (ImageView) findViewById(2131374722);
        ImageView r6 = (ImageView) findViewById(2131374723);
        View r7 = findViewById(2131381044);
        this.j = findViewById(2131381043);
        boolean r9 = false;
        if (r1.l.length() <= 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L30;
        int r10 = getContext().getResources().getDimensionPixelSize(2131166212);
        String r12 = r1.l;
        if (r12 != null) goto L10;
    L13:
        boolean r13 = true;
    L14:
        if (r13 == false) goto L16;
        Bitmap r11 = null;
    L29:
        Intrinsics.checkNotNull(r2);
        e1.x(r2);
        r2.setImageBitmap(r11);
    L40:
        String r14 = r1.d;
        if (r14.length() <= 0) goto L43;
        boolean r15 = true;
    L44:
        if (r15 == true) goto L47;
        r14 = null;
    L47:
        if (r14 != null) goto L49;
        Intrinsics.checkNotNull(r3);
        e1.o(r3);
    L57:
        String r16 = r1.e;
        if (r16.length() <= 0) goto L60;
        boolean r17 = true;
    L61:
        if (r17 == true) goto L64;
        r16 = null;
    L64:
        if (r16 == null) goto L66;
        r4.setText(r16);
        Intrinsics.checkNotNull(r4);
        e1.x(r4);
    L67:
        Integer r19 = (Integer) CollectionsKt.getOrNull(r1.n, 0);
        if (r19 == null) goto L70;
        int r20 = r19.intValue();
        Intrinsics.checkNotNull(r5);
        e1.x(r5);
        r5.setImageResource(r20);
        e1.d(r5, new c(r1));
        r19.intValue();
    L71:
        Integer r21 = (Integer) CollectionsKt.getOrNull(r1.n, 1);
        if (r21 == null) goto L74;
        int r22 = r21.intValue();
        Intrinsics.checkNotNull(r6);
        e1.x(r6);
        r6.setImageResource(r22);
        e1.d(r6, new d(r1));
        r21.intValue();
    L76:
        if (r1.n.size() != 1) goto L79;
        e1.d(r7, new e(r1));
    L79:
        if (r1.n.isEmpty() == false) goto L81;
        e1.d(r7, new f(r1));
    L81:
        TextView r23 = (TextView) findViewById(2131391311);
        e4 r24 = r1.k;
        if (r24 != null) goto L84;
    L86:
        boolean r25 = false;
    L87:
        if (r25 == false) goto L116;
        final String r26 = "";
        if (r24 == null) goto L92;
        String r27 = r24.c;
        if (r27 == null) goto L92;
    L94:
        if (r27.length() <= 0) goto L96;
        boolean r28 = true;
    L97:
        if (r28 == false) goto L99;
        r23.setText(r27);
        Intrinsics.checkNotNull(r23);
        e1.x(r23);
        e1.o(r5);
        e1.o(r6);
    L100:
        e4 r29 = r1.k;
        if (r29 == null) goto L103;
        final Function0 r110 = r29.d;
    L104:
        if (r29 == null) goto L109;
        String r30 = r29.b;
        if (r30 == null) goto L109;
        r26 = r30;
    L109:
        if (r110 == null) goto L112;
        e1.d(r23, new g(r110, this));
    L117:
        t0.a.postDelayed(this.f, r1.g);
        return;
    L112:
        if (r26.length() <= 0) goto L114;
        r9 = true;
    L114:
        if (r9 == false) goto L117;
        e1.d(r23, new h(r26, this));
        goto L117
    L103:
        r110 = null;
        goto L104
    L99:
        Intrinsics.checkNotNull(r23);
        e1.o(r23);
        goto L100
    L96:
        r28 = false;
    L92:
        r27 = "";
        goto L94
    L116:
        Intrinsics.checkNotNull(r23);
        e1.o(r23);
        goto L117
    L84:
        if (r24.a != true) goto L86;
        r25 = true;
        goto L87
    L74:
        Intrinsics.checkNotNull(r6);
        e1.o(r6);
        goto L76
    L70:
        Intrinsics.checkNotNull(r5);
        e1.o(r5);
        goto L71
    L66:
        Intrinsics.checkNotNull(r4);
        e1.o(r4);
        goto L67
    L60:
        r17 = false;
        goto L61
    L49:
        if (r1.e.length() <= 0) goto L51;
        boolean r31 = true;
    L52:
        if (r31 == false) goto L54;
        int r32 = 1;
    L55:
        r3.setMaxLines(r32);
        r3.setText(r14);
        Intrinsics.checkNotNull(r3);
        e1.x(r3);
        goto L57
    L54:
        r32 = 10;
        goto L55
    L51:
        r31 = false;
        goto L52
    L43:
        r15 = false;
        goto L44
    L16:
        BitmapFactory.Options r111 = new BitmapFactory.Options();
        r111.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r12, r111);
        Pair r112 = TuplesKt.to(Integer.valueOf(r111.outHeight), Integer.valueOf(r111.outWidth));
        int r113 = ((Number) r112.component1()).intValue();
        int r114 = ((Number) r112.component2()).intValue();
        if (r113 > r10) goto L21;
        if (r114 > r10) goto L21;
        int r33 = 1;
    L28:
        r111.inJustDecodeBounds = false;
        r111.inSampleSize = r33;
        r11 = BitmapFactory.decodeFile(r12, r111);
    L21:
        int r115 = r113 / 2;
        int r116 = r114 / 2;
        int r117 = 1;
    L23:
        if ((r115 / r117) < r10) goto L27;
        if ((r116 / r117) < r10) goto L27;
        r117 = r117 * 2;
    L27:
        r33 = r117;
        goto L28
    L10:
        if (r12.length() == 0) goto L13;
        r13 = false;
        goto L14
    L30:
        String r34 = r1.m;
        if (r34.length() <= 0) goto L33;
        boolean r118 = true;
    L34:
        if (r118 == true) goto L37;
        r34 = null;
    L37:
        if (r34 == null) goto L39;
        ImageLoaderKt.u(r2, r34, "notificationV2");
        Intrinsics.checkNotNull(r2);
        e1.x(r2);
        goto L40
    L39:
        Intrinsics.checkNotNull(r2);
        e1.o(r2);
        goto L40
    L33:
        r118 = false;
        goto L34
    L5:
        r8 = false;
        goto L6
    }

    public l(final Context r2, n3 r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "request");
        super(r2, r3);
        this.g = r3;
        this.h = LazyKt.lazy(new j(r2));
        this.i = LazyKt.lazy(new k(r2));
    }
}
