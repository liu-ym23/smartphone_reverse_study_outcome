package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.SpannableStringUtils;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.collection.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Date;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m8 extends Dialog {
    public final View a;
    public TextView b;
    public TextView c;
    public Button d;
    public Button e;
    public final WeakHandler f;
    public final s5 g;
    public final Runnable h;
    public final b i;
    public int j;
    public final String k;
    public boolean l;
    public boolean m;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ m8 a;

        public final void a() {
            m8 r0 = this.a;
            if (r0.j < 1000) goto L7;
            r0.b();
            WeakHandler r1 = this.a.f;
            if (r1 == null) goto L31;
            r1.postDelayed(this, BubbleId.PadCast);
            return;
        L31:
            return;
        L7:
            WeakHandler r2 = r0.f;
            if (r2 == null) goto L10;
            r2.removeCallbacks(this);
        L10:
            m8 r3 = this.a;
            Handler r4 = DialogLancet.resolveDialogHandler(r3);
            if (r4 != null) goto L13;
        L15:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L18 Exception -> L20
        L24:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
            Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
            if (r5 == null) goto L24;
            com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            if (Looper.myLooper() == r4.getLooper()) goto L15;
            r4.post(DialogLancet.createDismissRunnable(r3));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(m8 r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void b() {
        String r0 = this.k;
        int r1 = r0.length();
        int r3 = 0;
    L3:
        int r4 = -1;
        if (r3 >= r1) goto L12;
        if (r0.charAt(r3) != '{') goto L8;
        boolean r6 = true;
    L9:
        if (r6 == true) goto L14;
        r3 = r3 + 1;
    L14:
        if (r0 == null) goto L34;
        String r2 = r0.substring(0, r3);
        String r5 = this.k;
        int r7 = r5.length();
        int r8 = 0;
    L16:
        if (r8 >= r7) goto L24;
        if (r5.charAt(r8) != '}') goto L20;
        boolean r9 = true;
    L21:
        if (r9 == true) goto L22;
        r8 = r8 + 1;
        goto L16
    L22:
        r4 = r8;
        goto L24
    L20:
        r9 = false;
    L24:
        int r10 = r4 + 1;
        int r11 = this.k.length();
        if (r5 == null) goto L32;
        String r12 = r5.substring(r10, r11);
        String r13 = TimeUtils.formatVideoDuration(this.j);
        SpannableString r14 = SpannableStringUtils.getDiffColorSpannable(r2 + r13 + r12, r2.length(), r2.length() + r13.length(), -65536);
        TextView r15 = this.b;
        if (r15 == null) goto L29;
        r15.setText(r14);
    L29:
        this.j -= 1000;
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L34:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L8:
        r6 = false;
        goto L9
    L12:
        r3 = -1;
        goto L14
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        WeakHandler r1 = this.f;
        if (r1 == null) goto L21;
        r1.removeCallbacks(this.i);
    L21:
        if (this.l == false) goto L23;
        return;
    L23:
        if (this.m == true) goto L32;
        a("close");
        return;
    L32:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        WeakHandler r0 = this.f;
        if (r0 == null) goto L14;
        r0.postDelayed(this.i, BubbleId.PadCast);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public final void a(String r6) {
        Pair[] r0 = new Pair[3];
        r0[0] = TuplesKt.to("remaining", String.valueOf(this.j / BubbleId.PadCast));
        s5 r1 = this.g;
        if (r1 == null) goto L8;
        i6 r2 = r1.b();
        if (r2 == null) goto L8;
        String r3 = r2.b();
        if (r3 == null) goto L8;
    L9:
        r0[1] = TuplesKt.to("score", r3);
        r0[2] = TuplesKt.to("click_type", r6);
        Map r7 = MapsKt.mutableMapOf(r0);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_keep_popup_click", r7, new Object[]{Room.class, am2.x.class});
        return;
    L8:
        r3 = "";
        goto L9
    }

    public m8(Context r7, WeakHandler r8, Runnable r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "weakHandler");
        Intrinsics.checkNotNullParameter(r9, "afterQuitRunnable");
        super(r7, 2131954708);
        this.i = new b(this);
        this.j = 180000;
        this.k = "再逛{count_down}可获得500金币，确定要退出吗？";
        String r1 = null;
        View r10 = LayoutInflater.from(getContext()).inflate(2131565762, null);
        this.a = r10;
        setContentView(r10);
        this.f = r8;
        s5 r11 = l8.b();
        this.g = r11;
        if (r11 == null) goto L9;
        i6 r0 = r11.b();
        if (r0 == null) goto L9;
        Long r2 = r0.a();
        if (r2 == null) goto L9;
        int r3 = (int) (r2.longValue() - new Date().getTime());
    L10:
        this.j = r3;
        this.h = r9;
        if (r11 == null) goto L15;
        String r12 = r11.a();
        if (r12 == null) goto L15;
        this.k = r12;
    L15:
        this.b = (TextView) r10.findViewById(2131383576);
        this.c = (TextView) r10.findViewById(2131383577);
        this.d = (Button) r10.findViewById(2131383574);
        this.e = (Button) r10.findViewById(2131367902);
        Button r13 = this.d;
        if (r13 == null) goto L18;
        r13.setOnClickListener(new n8(this));
    L18:
        Button r14 = this.e;
        if (r14 == null) goto L21;
        r14.setOnClickListener(new o8(this));
    L21:
        setOnShowListener(new p8(this));
        b();
        if (r11 == null) goto L25;
        r1 = r11.a;
    L25:
        if ("ad_reward_retain_data".equals(r1) == false) goto L27;
        int r15 = 2131919185;
        int r16 = 2131919186;
    L28:
        Button r17 = this.d;
        if (r17 == null) goto L31;
        r17.setText(r15);
    L31:
        TextView r18 = this.c;
        if (r18 == null) goto L35;
        r18.setText(r16);
        return;
    L35:
        return;
    L27:
        r15 = 2131919181;
        r16 = 2131921824;
    L9:
        r3 = 0;
        goto L10
    }
}
