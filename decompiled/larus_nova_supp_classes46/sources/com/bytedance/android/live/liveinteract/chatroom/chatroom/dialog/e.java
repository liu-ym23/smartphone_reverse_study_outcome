package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends com.bytedance.android.livesdk.common.b implements View.OnClickListener {
    public final IRoom b;
    public final int c;
    public int d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public final boolean j;
    public final boolean k;
    public int l;
    public int m;
    public final String n;

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(e r3) {
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        boolean r0 = je0.d.Y();
        if (r13 == null) goto L5;
        Integer r14 = Integer.valueOf(r13.getId());
    L7:
        if (r14 != null) goto L10;
    L17:
        if (r14 != null) goto L20;
    L30:
        if (r14 != null) goto L33;
    L41:
        if (r14 != null) goto L44;
        return;
    L44:
        if (r14.intValue() != 2131365114) goto L56;
        a(this);
        return;
    L56:
        return;
    L33:
        if (r14.intValue() != 2131362287) goto L41;
        TeamFightContext.a r15 = TeamFightContext.Companion;
        if (r15.d() == false) goto L39;
        com.bytedance.android.live.liveinteract.revenue.fight.c r1 = r15.c();
        if (r1 == null) goto L40;
        r1.e5(this.m, this.l, this.c, this.n);
    L40:
        a(this);
        return;
    L39:
        f2.c(s1.B(2131915773), 0);
        goto L40
    L20:
        if (r14.intValue() != 2131362284) goto L30;
        Integer r16 = je0.d.h();
        if (r16 == null) goto L29;
        AdjustGuestPositionDialog r17 = new AdjustGuestPositionDialog(getContext(), je0.d.f(), r16.intValue(), this.b, this.c);
        if (DialogLancet.shouldBlockDialogShow(r17) == false) goto L49;
        DialogLancet.handleBlockedDialogShow(r17);
    L28:
        a(this);
        goto L29
    L49:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L48
    L27:
        DialogLancet.beforeDialogShow(r17);
        r17.show();
        DialogLancet.afterDialogShow(r17);
    L29:
        jf0.a r18 = jf0.a.a;
        jf0.a.a(this.c, true, true, "order", r0);
        return;
    L10:
        if (r14.intValue() != 2131385960) goto L17;
        InputPositionNameDialog r19 = new InputPositionNameDialog(getContext(), this.c, this.b, null, true, true, 8);
        if (DialogLancet.shouldBlockDialogShow(r19) == false) goto L51;
        DialogLancet.handleBlockedDialogShow(r19);
    L16:
        a(this);
        jf0.a r110 = jf0.a.a;
        jf0.a.a(this.c, true, true, "name", r0);
        return;
    L51:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L47
    L15:
        DialogLancet.beforeDialogShow(r19);
        r19.show();
        DialogLancet.afterDialogShow(r19);
        goto L16
    L5:
        r14 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r12) {
        super/*android.app.Dialog*/.onCreate(r12);
        String r1 = null;
        setContentView(LayoutInflater.from(getContext()).inflate(2131565364, null));
        Window r13 = getWindow();
        if (r13 == null) goto L5;
        r13.setGravity(80);
        r13.setLayout(-1, -2);
    L5:
        this.e = (TextView) findViewById(2131385960);
        this.f = (TextView) findViewById(2131362284);
        this.g = (TextView) findViewById(2131362287);
        this.h = (TextView) findViewById(2131365114);
        this.i = (TextView) findViewById(2131374360);
        Integer r3 = je0.d.h();
        if (r3 != null) goto L9;
    L10:
        Integer r4 = je0.d.h();
        if (r4 != null) goto L14;
    L21:
        TextView r5 = this.e;
        if (r5 == null) goto L24;
        r5.setOnClickListener(this);
    L24:
        TextView r6 = this.f;
        if (r6 == null) goto L27;
        r6.setOnClickListener(this);
    L27:
        TextView r7 = this.g;
        if (r7 == null) goto L30;
        r7.setOnClickListener(this);
    L30:
        TextView r8 = this.h;
        if (r8 == null) goto L34;
        r8.setOnClickListener(this);
    L34:
        if (je0.d.N() == false) goto L38;
        if (je0.d.w() == true) goto L38;
    L41:
        boolean r9 = true;
    L43:
        if (r9 == false) goto L46;
        this.d++;
    L46:
        if (je0.d.N() == true) goto L48;
    L50:
        int r10 = this.d + 1;
    L51:
        TextView r11 = this.i;
        if (r11 == null) goto L54;
        r11.setText(s1.C(2131919009, new Object[]{String.valueOf(r10)}));
    L54:
        IInteractService r14 = (IInteractService) jc1.k.n(IInteractService.class);
        Integer r15 = je0.d.h();
        if (r15 == null) goto L57;
        int r16 = r15.intValue();
    L59:
        if (r14.isVoiceMultiEnlargeSeat(r16, this.d) == false) goto L64;
        TextView r17 = this.i;
        if (r17 == null) goto L64;
        r17.setText(s1.B(2131919008));
    L64:
        if (gh0.a.d() == true) goto L72;
        com.bytedance.android.livesdk.user.e r18 = jc1.k.n(IMiddlewareUserService.class).user();
        IRoom r19 = this.b;
        if (r19 == null) goto L68;
        Long r20 = Long.valueOf(r19.getRoomId());
    L70:
        if (r18.t(r20) == true) goto L72;
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        goto L72
    L68:
        r20 = null;
    L72:
        Integer r110 = je0.d.h();
        if (r110 != null) goto L76;
    L78:
        boolean r111 = false;
    L80:
        if (d.e() == false) goto L82;
    L125:
        TextView r112 = this.f;
        if (r112 == null) goto L129;
        r112.setVisibility(8);
    L129:
        if (TeamFightContext.Companion.d() == true) goto L131;
    L149:
        String r113 = this.n;
        if (r113 == null) goto L152;
        int r114 = li0.d.c(r113);
    L153:
        int r0 = 2;
        if (r114 != 1) goto L156;
        int r2 = 2;
    L157:
        this.l = r2;
        if (this.n == null) goto L161;
        r0 = 1;
    L161:
        this.m = r0;
        TextView r21 = this.g;
        if (r21 == null) goto L168;
        if (r114 != 1) goto L165;
        String r115 = s1.B(2131915771);
    L166:
        r21.setText(r115);
        return;
    L165:
        r115 = s1.B(2131915772);
        goto L166
    L168:
        return;
    L156:
        r2 = 1;
        goto L157
    L152:
        r114 = li0.d.b(this.c);
        goto L153
    L131:
        if (li0.d.g(null) == false) goto L149;
        String r116 = this.n;
        if (r116 != null) goto L135;
    L136:
        String r117 = je0.d.b0();
        IRoom r22 = this.b;
        if (r22 == null) goto L140;
        r1 = r22.getOwnerUserIdString();
    L140:
        if (Intrinsics.areEqual(r117, r1) == false) goto L149;
        if (li0.d.c(je0.d.b0()) == (-1)) goto L149;
    L143:
        TextView r118 = (TextView) findViewById(2131362287);
        if (r118 == null) goto L146;
        UtilityKotlinExtentionsKt.w(r118);
    L146:
        View r119 = findViewById(2131377910);
        if (r119 == null) goto L149;
        UtilityKotlinExtentionsKt.w(r119);
        goto L149
    L135:
        if (li0.d.c(r116) != (-1)) goto L143;
    L82:
        if (this.j == false) goto L85;
        if (r111 == false) goto L125;
    L85:
        if (d.b(this.c) == true) goto L125;
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == true) goto L125;
        if (this.k == false) goto L116;
        if (d.a() == false) goto L116;
        IRoom r120 = this.b;
        if (r120 == null) goto L108;
        if (r120.isLiveTypeAudio() != true) goto L108;
        if (vm2.d.c() == true) goto L100;
    L104:
        TextView r121 = this.f;
        if (r121 == null) goto L129;
        r121.setVisibility(8);
        goto L129
    L100:
        if (d.h() == false) goto L104;
        TextView r122 = this.f;
        if (r122 == null) goto L129;
        r122.setVisibility(0);
    L108:
        if (d.c() == false) goto L112;
        TextView r123 = this.f;
        if (r123 == null) goto L129;
        r123.setVisibility(8);
        goto L129
    L112:
        TextView r124 = this.f;
        if (r124 == null) goto L129;
        r124.setVisibility(0);
    L116:
        if (je0.d.Y() == true) goto L118;
    L122:
        TextView r125 = this.f;
        if (r125 == null) goto L129;
        r125.setVisibility(0);
        goto L129
    L118:
        if (this.k != true) goto L122;
        TextView r126 = this.f;
        if (r126 == null) goto L129;
        r126.setVisibility(8);
        goto L129
    L76:
        if (r110.intValue() != 28) goto L78;
        r111 = true;
        goto L80
    L57:
        r16 = 0;
        goto L59
    L48:
        if (je0.d.w() == true) goto L50;
        r10 = this.d;
    L38:
        if (je0.d.u() == true) goto L40;
    L42:
        r9 = false;
        goto L43
    L40:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(this.b) == true) goto L42;
    L14:
        if (r4.intValue() != 30) goto L21;
    L15:
        TextView r23 = this.e;
        if (r23 == null) goto L18;
        r23.setVisibility(8);
    L18:
        View r24 = findViewById(2131377927);
        if (r24 == null) goto L21;
        r24.setVisibility(8);
        goto L21
    L9:
        if (r3.intValue() == 28) goto L15;
        goto L10
    }

    public /* synthetic */ e(Context r9, IRoom r10, int r11, boolean r12, boolean r13, int r14) {
        this(r9, r10, r11, r12, r13, r14, null);
    }

    public e(Context r2, IRoom r3, int r4, boolean r5, boolean r6, int r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, true);
        this.n = r8;
        this.b = r3;
        this.c = r4;
        this.d = r7;
        this.j = r5;
        this.k = r6;
        this.l = -1;
    }
}
