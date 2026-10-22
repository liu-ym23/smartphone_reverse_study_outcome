package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.common.utility.UIUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t6 extends Dialog implements com.bytedance.android.live.matchroom.b {
    public View a;
    public final int b;
    public LinearLayout c;
    public LinearLayout d;
    public LinearLayout e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public boolean i;
    public TextView j;
    public TextView k;
    public TextView l;
    public final Function1<Integer, Unit> m;

    public static final class a {
    }

    static {
    }

    public final void b() {
        LinearLayout r0 = this.c;
        Intrinsics.checkNotNull(r0);
        r0.setBackgroundResource(0);
        ImageView r1 = this.f;
        Intrinsics.checkNotNull(r1);
        r1.setBackgroundResource(0);
        TextView r2 = this.j;
        Intrinsics.checkNotNull(r2);
        r2.setTextColor(getContext().getResources().getColor(2131107030));
    }

    public final void c() {
        LinearLayout r0 = this.e;
        Intrinsics.checkNotNull(r0);
        r0.setBackgroundResource(0);
        ImageView r1 = this.h;
        Intrinsics.checkNotNull(r1);
        r1.setBackgroundResource(0);
        TextView r2 = this.l;
        Intrinsics.checkNotNull(r2);
        r2.setTextColor(getContext().getResources().getColor(2131107030));
    }

    public final void d() {
        LinearLayout r0 = this.d;
        Intrinsics.checkNotNull(r0);
        r0.setBackgroundResource(0);
        ImageView r1 = this.g;
        Intrinsics.checkNotNull(r1);
        r1.setBackgroundResource(0);
        TextView r2 = this.k;
        Intrinsics.checkNotNull(r2);
        r2.setTextColor(getContext().getResources().getColor(2131107030));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        m50 r0 = m50.a;
        if (r0.getValue().n() == true) goto L5;
    L9:
        this.i = false;
        boolean r1 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.q("LandscapePicTypeSettingDialog");
        MatchRoomLandScapeAnimUtil.u(0);
        Handler r2 = DialogLancet.resolveDialogHandler(this);
        if (r2 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(this);
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r3 == null) goto L23;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        if (Looper.myLooper() == r2.getLooper()) goto L14;
        r2.post(DialogLancet.createDismissRunnable(this));
        return;
    L5:
        if (this.i == true) goto L9;
        if (r0.getValue().m() == false) goto L9;
        MatchRoomLandScapeAnimUtil.E.j("LandscapePicTypeSettingDialog");
        goto L9
    }

    public final int getActualContentWidth() {
        return UtilityKotlinExtentionsKt.i(252);
    }

    @Override // android.app.Dialog
    public final void show() {
        m50 r0 = m50.a;
        if (r0.getValue().j() == false) goto L13;
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(this);
    L10:
        if (m50.a.getValue().n() == false) goto L20;
        boolean r1 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.x("LandscapePicTypeSettingDialog", this, -1);
    L20:
        LinearLayout r2 = this.c;
        Intrinsics.checkNotNull(r2);
        r2.setOnClickListener(new u6(this));
        LinearLayout r3 = this.d;
        Intrinsics.checkNotNull(r3);
        r3.setOnClickListener(new v6(this));
        LinearLayout r4 = this.e;
        Intrinsics.checkNotNull(r4);
        r4.setOnClickListener(new w6(this));
        return;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L8:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L10
    L13:
        if (r0.getValue().n() == false) goto L16;
        boolean r5 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.x("LandscapePicTypeSettingDialog", this, -1);
    L16:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(this);
        goto L20
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L19:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L20
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        requestWindowFeature(1);
        View r8 = LayoutInflater.from(getContext()).inflate(2131566733, null);
        this.a = r8;
        if (Build.VERSION.SDK_INT <= 23) goto L5;
        Intrinsics.checkNotNull(r8);
        r8.setBackgroundResource(2131252583);
    L6:
        View r9 = this.a;
        Intrinsics.checkNotNull(r9);
        setContentView(r9);
        int r10 = this.b;
        Window r0 = getWindow();
        if (r0 == null) goto L14;
        r0.setBackgroundDrawable(new ColorDrawable(0));
        View r2 = r0.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L13;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L13;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L13:
        com.bytedance.android.live.core.utils.statusbar.a.a r4 = com.bytedance.android.live.core.utils.statusbar.a.b;
        r4.a();
        r4.a();
        r2.setSystemUiVisibility(1280);
        r4.a();
        r0.addFlags(Integer.MIN_VALUE);
        r0.setLayout((int) UIUtils.dip2Px(getContext(), r10), -1);
        r0.setGravity(8388613);
    L14:
        com.bytedance.android.livesdk.x8.b(this);
        View r11 = this.a;
        Intrinsics.checkNotNull(r11);
        this.c = (LinearLayout) r11.findViewById(2131378612);
        View r12 = this.a;
        Intrinsics.checkNotNull(r12);
        this.d = (LinearLayout) r12.findViewById(2131378891);
        View r13 = this.a;
        Intrinsics.checkNotNull(r13);
        this.e = (LinearLayout) r13.findViewById(2131378679);
        View r14 = this.a;
        Intrinsics.checkNotNull(r14);
        this.f = (ImageView) r14.findViewById(2131376018);
        View r15 = this.a;
        Intrinsics.checkNotNull(r15);
        this.g = (ImageView) r15.findViewById(2131376643);
        View r16 = this.a;
        Intrinsics.checkNotNull(r16);
        this.h = (ImageView) r16.findViewById(2131376214);
        View r17 = this.a;
        Intrinsics.checkNotNull(r17);
        this.j = (TextView) r17.findViewById(2131390187);
        View r18 = this.a;
        Intrinsics.checkNotNull(r18);
        this.k = (TextView) r18.findViewById(2131391515);
        View r19 = this.a;
        Intrinsics.checkNotNull(r19);
        this.l = (TextView) r19.findViewById(2131390568);
        int r20 = x6.a;
        a(x6.a, false);
        return;
    L5:
        Intrinsics.checkNotNull(r8);
        r8.setBackgroundResource(2131249572);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t6(Context r2, Function1<? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onClick");
        super(r2, 2131954620);
        this.m = r3;
        this.b = 200;
    }

    public final void a(int r6, boolean r7) {
        if (r7 == false) goto L39;
        this.m.invoke(Integer.valueOf(r6));
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L10;
        com.bytedance.live.datacontext.m r9 = r8.isRestoreSandwich();
        if (r9 == null) goto L10;
        r9.setValue(Boolean.TRUE);
    L10:
        if (r6 == x6.a) goto L12;
    L16:
        ALogger.d("SandwichBorderInfo", "LandscapePicTypeSettingManager setCurrentPicType " + r6 + " , lastPicType  " + x6.a);
        xs2.b.a().post(new do1.a(x6.a, r6, x6.f() ? 1 : 0));
        x6.a = r6;
        if (r6 == 0) goto L20;
        x6.c = false;
    L20:
        if (m50.a.getValue().m() == false) goto L39;
        this.i = true;
        Handler r10 = DialogLancet.resolveDialogHandler(this);
        if (r10 != null) goto L24;
    L26:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L29 Exception -> L31
    L35:
        DialogLancet.afterDialogDismiss(this);
        goto L39
    L31:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L29
        Throwable r11 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L29
        if (r11 == null) goto L35;
        com.bytedance.crash.d.d(r11, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L24:
        if (Looper.myLooper() == r10.getLooper()) goto L26;
        r10.post(DialogLancet.createDismissRunnable(this));
        goto L39
    L12:
        if (x6.e == true) goto L16;
        if (MatchRoomLandScapeAnimUtil.a == true) goto L16;
        ALogger.d("SandwichBorderInfo", "LandscapePicTypeSettingManager setCurrentPicType " + r6 + " not need reset");
    L39:
        if (r6 == 0) goto L46;
        if (r6 != 1) goto L42;
        LinearLayout r12 = this.d;
        Intrinsics.checkNotNull(r12);
        r12.setBackgroundResource(2131248912);
        ImageView r13 = this.g;
        Intrinsics.checkNotNull(r13);
        r13.setBackgroundResource(2131251679);
        TextView r14 = this.k;
        Intrinsics.checkNotNull(r14);
        r14.setTextColor(getContext().getResources().getColor(2131107041));
        b();
        c();
        return;
    L42:
        if (r6 != 2) goto L53;
        LinearLayout r15 = this.e;
        Intrinsics.checkNotNull(r15);
        r15.setBackgroundResource(2131248912);
        ImageView r16 = this.h;
        Intrinsics.checkNotNull(r16);
        r16.setBackgroundResource(2131251679);
        TextView r17 = this.l;
        Intrinsics.checkNotNull(r17);
        r17.setTextColor(getContext().getResources().getColor(2131107041));
        b();
        d();
        return;
    L53:
        return;
    L46:
        LinearLayout r18 = this.c;
        Intrinsics.checkNotNull(r18);
        r18.setBackgroundResource(2131248912);
        ImageView r19 = this.f;
        Intrinsics.checkNotNull(r19);
        r19.setBackgroundResource(2131251679);
        TextView r20 = this.j;
        Intrinsics.checkNotNull(r20);
        r20.setTextColor(getContext().getResources().getColor(2131107041));
        c();
        d();
    }
}
