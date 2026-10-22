package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nz.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x extends mx.l {
    public final Lazy p;
    public final Context q;
    public final ListDialogAbility r;
    public final boolean s;
    public final Function0<Boolean> t;
    public final Function0<Boolean> u;
    public final boolean v;
    public final boolean w;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ x a;
        public final /* synthetic */ FragmentActivity b;
        public final /* synthetic */ Room c;
        public final /* synthetic */ SwitchSettingViewHolder d;

        public a(x r1, FragmentActivity r2, Room r3, SwitchSettingViewHolder r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "dialog");
            x r12 = this.a;
            FragmentActivity r0 = this.b;
            Room r1 = this.c;
            SwitchSettingViewHolder r2 = this.d;
            r12.getClass();
            int r3 = a0.a;
            boolean r4 = ((mx.l) r12).l;
            if (r1 == null) goto L5;
            long r5 = r1.id;
        L6:
            long r6 = r5;
            a0.c(r0, 0, r4, r6, new RecordReplayHighlightsSetting$doCheckStateChangedNew$1(r12, r2, false, r1), RecordReplayHighlightsSetting$doCheckStateChangedNew$2.INSTANCE);
            r10.dismiss();
            return;
        L5:
            r5 = 0;
            goto L6
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ x a;

        public c(x r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            lm3.c r4 = new lm3.c();
            r4.b = "确定";
            Context r1 = this.a.q;
            Intrinsics.checkNotNull(r1);
            lm3.d.a r0 = new lm3.d.a(r1);
            r0.b = s1.B(2131919707);
            r0.e = CollectionsKt.listOf(r4);
            r0.a();
        }
    }

    public final View.OnClickListener f() {
        if (this.w == true) goto L5;
        return null;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.J0.getValue()).booleanValue() == true) goto L8;
        return null;
    L8:
        return new c(this);
    }

    public final boolean b(boolean r3) {
        Function0<Boolean> r4 = this.t;
        if (r4 == null) goto L8;
        if (((Boolean) r4.invoke()).booleanValue() != true) goto L8;
        return true;
    L8:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.M0.getValue()).booleanValue() == true) goto L10;
    L16:
        return true;
    L10:
        if (this.v == false) goto L16;
        c9 r5 = (c9) this.p.getValue();
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(r5);
        goto L16
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        goto L16
    }

    public final void c(SwitchSettingViewHolder r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r18, "holder");
        Function0<Boolean> r4 = this.t;
        if (r4 != null) goto L5;
    L8:
        Intrinsics.checkNotNullParameter(r18, "holder");
        ((mx.l) this).l = r19;
        FragmentActivity r6 = ContextUtil.contextToFragmentActivity(((RecyclerView.ViewHolder) r18).itemView.getContext());
        if (r6 != null) goto L11;
        return;
    L11:
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.m r5 = r3.getRoom();
        if (r5 == null) goto L16;
        Room r7 = (Room) r5.getValue();
    L17:
        if (r19 == false) goto L25;
        int r2 = a0.a;
        boolean r8 = ((mx.l) this).l;
        if (r7 == null) goto L21;
        long r9 = r7.id;
    L22:
        a0.c(r6, 0, r8, r9, new RecordReplayHighlightsSetting$doCheckStateChangedNew$1(this, r18, true, r7), RecordReplayHighlightsSetting$doCheckStateChangedNew$2.INSTANCE);
        return;
    L21:
        r9 = 0;
        goto L22
    L25:
        if (r19 == false) goto L48;
        int r1 = a0.a;
        boolean r10 = ((mx.l) this).l;
        if (r7 == null) goto L29;
        long r11 = r7.id;
    L30:
        a0.c(r6, 0, r10, r11, new RecordReplayHighlightsSetting$doCheckStateChanged$1(this), RecordReplayHighlightsSetting$doCheckStateChanged$2.INSTANCE);
        if (r7 != null) goto L33;
    L35:
        IUserService r12 = jc1.k.f(IUserService.class);
        if (r12 == null) goto L40;
        com.bytedance.android.livesdk.user.f r13 = r12.user();
        if (r13 == null) goto L40;
        String r14 = r13.n();
    L41:
        com.bytedance.android.livesdk.log.g r15 = com.bytedance.android.livesdk.log.u.l();
        HashMap r16 = new HashMap();
        r16.put("is_open", "open");
        r16.put("request_page", "live_room");
        r16.put("live_status_type", "live_on");
        r16.put("to_status", "on");
        r16.put("anchor_id", String.valueOf(r14));
        if (r7 == null) goto L44;
        String r17 = r7.getIdStr();
    L45:
        r16.put("room_id", String.valueOf(r17));
        Unit r20 = Unit.INSTANCE;
        r15.sendLog("livesdk_live_record_status", r16, new Object[]{Room.class});
        Map r21 = MapsKt.mapOf(new Pair[]{TuplesKt.to("is_open", "open"), TuplesKt.to("request_page", "live_room"), TuplesKt.to("live_status_type", "live_on"), TuplesKt.to("to_status", "on")});
        Intrinsics.checkNotNullParameter(r21, "map");
        ((com.bytedance.android.live.ui.s) this).d.putAll(r21);
        return;
    L44:
        r17 = null;
    L40:
        r14 = null;
        goto L41
    L33:
        if (r7.id == 0) goto L35;
        f2.b(2131919683, 0);
        goto L35
    L29:
        r11 = 0;
        goto L30
    L48:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.M0.getValue()).booleanValue() == true) goto L50;
    L52:
        c9.b r22 = new c9.b();
        r22.a = r6;
        r22.b = 2;
        r22.c = 2131565759;
        r22.f = r22.a.getText(2131923419);
        r22.g = 17;
        r22.p = true;
        r22.q = true;
        r22.r = 2131954724;
        a r23 = new a(this, r6, r7, r18);
        r22.j = r22.a.getText(2131915913);
        r22.k = r23;
        b r24 = b.a;
        r22.l = r22.a.getText(2131919682);
        r22.m = r24;
        c9 r25 = new c9(r22.a, r22);
        if (DialogLancet.shouldBlockDialogShow(r25) == false) goto L59;
        DialogLancet.handleBlockedDialogShow(r25);
        return;
    L59:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L58
    L56:
        DialogLancet.beforeDialogShow(r25);
        r25.show();
        DialogLancet.afterDialogShow(r25);
        return;
    L50:
        if (this.v == false) goto L52;
        return;
    L16:
        r7 = null;
        goto L17
    L5:
        if (((Boolean) r4.invoke()).booleanValue() != true) goto L8;
        String r26 = rm3.c.a;
        rm3.c.f(this.q, 2131914851, true, 20);
    }

    public x(Context r14, ListDialogAbility r15, Function0 r16, Function0 r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "dialogAbility");
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.J0.getValue()).booleanValue() == false) goto L5;
        int r0 = 2131919706;
    L6:
        String r1 = s1.B(r0);
        if (((Boolean) r16.invoke()).booleanValue() != true) goto L13;
        Boolean r2 = (Boolean) r17.invoke();
        if (r2 == null) goto L11;
        boolean r3 = r2.booleanValue();
    L12:
        Boolean r4 = Boolean.valueOf(r3);
    L14:
        super(r1, null, r4.booleanValue(), false, false, null, 122);
        this.q = r14;
        this.r = r15;
        this.s = false;
        this.t = r16;
        this.u = r17;
        this.v = true;
        this.w = r18;
        this.p = InfraKotlinExtsKt.mainThreadLazy(new RecordReplayHighlightsSetting$forbidCloseRealTimePlaybackDialog$2(this));
        return;
    L11:
        r3 = false;
        goto L12
    L13:
        r4 = (Boolean) com.bytedance.android.livesdk.sharedpref.b.L0.getValue();
        goto L14
    L5:
        r0 = 2131919693;
        goto L6
    }
}
