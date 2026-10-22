package com.bytedance.android.live.room.discovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.model.AnchorVideoResolutionManager;
import com.bytedance.android.live.broadcast.api.stable.AnchorStrategy;
import com.bytedance.android.live.broadcast.api.stable.TaskLevel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.discovery.presenter.SoundCardModeManager;
import com.bytedance.android.live.room.utils.UsbDeviceUtils;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.bi;
import com.bytedance.android.livesdk.config.hh;
import com.bytedance.android.livesdk.config.lq0;
import com.bytedance.android.livesdk.config.rh;
import com.bytedance.android.livesdk.config.xg;
import com.bytedance.android.livesdk.config.za0;
import com.bytedance.android.livesdk.linkvideo.DialogLifecycleOwner;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.live.ILiveExternalCameraServiceForOther;
import com.bytedance.crash.Npth;
import com.bytedance.dux.duxswitch.DuxSwitch;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/discovery/AnchorPerfMonitorDialogNew;", "Lcom/bytedance/android/live/room/discovery/IAnchorPerMonitorDialog;", "Landroid/view/View$OnClickListener;", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPerfMonitorDialogNew extends IAnchorPerMonitorDialog implements View.OnClickListener {
    public static final /* synthetic */ int B = 0;
    public final HashMap<String, String> A;
    public int a;
    public int b;
    public int c;
    public int d;
    public DataCenter e;
    public List<String> f;
    public List<? extends CharSequence> g;
    public Room h;
    public boolean i;
    public boolean j;
    public AnchorPerfMonitorDialogDetail k;
    public final Lazy l;
    public final ms1.g m;
    public String n;
    public final Map<Integer, Drawable> o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public int v;
    public final AnchorPerfMonitorDialogNew$usbReceiver$1 w;
    public boolean x;
    public boolean y;
    public m z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AnchorPerfMonitorDialogNew a;

        public b(AnchorPerfMonitorDialogNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            AnchorPerfMonitorDialogNew r5 = this.a;
            if (r5.k != null) goto L5;
            r5.k = new AnchorPerfMonitorDialogDetail(this.a.getContext(), this.a.g);
        L5:
            AnchorPerfMonitorDialogDetail r6 = this.a.k;
            if (r6 != null) goto L8;
        L12:
            LinkedHashMap r7 = new LinkedHashMap();
            Room r0 = this.a.h;
            if (r0 == null) goto L15;
            r7.put("room_id", String.valueOf(r0.id));
            r7.put("anchor_id", r0.getOwnerUserIdString());
        L15:
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_quality_log_show", r7, new Object[0]);
            return;
        L8:
            if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L18;
            DialogLancet.handleBlockedDialogShow(r6);
            goto L12
        L18:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
        L11:
            DialogLancet.beforeDialogShow(r6);
            r6.show();
            DialogLancet.afterDialogShow(r6);
            goto L12
        }
    }

    public static final class c implements AdjustPercentBar.d {
        public final /* synthetic */ AnchorPerfMonitorDialogNew a;

        public final void b() {
        }

        public c(AnchorPerfMonitorDialogNew r1) {
            this.a = r1;
        }

        public final void a(int r5) {
            AnchorPerfMonitorDialogNew r0 = this.a;
            int r1 = AnchorPerfMonitorDialogNew.B;
            com.bytedance.android.live.pushstream.d r2 = r0.S0();
            if (r2 == null) goto L5;
            r2.p1(r5 / 100.0f);
        L5:
            LinkedHashMap r3 = new LinkedHashMap();
            Room r4 = this.a.h;
            if (r4 == null) goto L8;
            r3.put("room_id", String.valueOf(r4.id));
            r3.put("anchor_id", r4.getOwnerUserIdString());
        L8:
            r3.put("status", String.valueOf(r5));
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_quality_sound_click", r3, new Object[0]);
        }

        public final void onChanged(int r3) {
            TextView r0 = (TextView) this.a.findViewById(2131375219);
            if (r0 == null) goto L6;
            r0.setText(String.valueOf(r3));
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ AnchorPerfMonitorDialogNew a;

        public d(AnchorPerfMonitorDialogNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r14) {
            RoomContext.a r15 = RoomContext.Companion;
            RoomContext r4 = RoomContext.a.c(r15, null, 0, 3);
            if (r4 == null) goto L9;
            com.bytedance.live.datacontext.m r5 = r4.isAnchorStableMode();
            if (r5 == null) goto L9;
            if (((Boolean) r5.getValue()).booleanValue() != true) goto L9;
            boolean r6 = true;
        L11:
            if (r6 == false) goto L44;
            String r9 = "";
            ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).exitStableModel("");
            LinkedHashMap r8 = new LinkedHashMap();
            IRoomService r10 = (IRoomService) jc1.k.f(IRoomService.class);
            if (r10 == null) goto L15;
            Room r12 = r10.getCurrentRoom();
        L16:
            if (r12 == null) goto L19;
            String r13 = String.valueOf(r12.id);
            if (r13 == null) goto L19;
        L20:
            r8.put("room_id", r13);
            if (r12 == null) goto L26;
            String r16 = r12.getAnchorId();
            if (r16 == null) goto L26;
            r9 = r16;
        L26:
            r8.put("anchor_id", r9);
            AnchorPerfMonitorDialogNew r17 = this.a;
            int r18 = r17.v;
            if (r18 != 0) goto L30;
        L41:
            String r19 = "high";
        L43:
            r8.put("anchor_capability_status", r19);
            r8.put("capability_issue", "stuck");
            r8.put("capability_button_action", "off");
            r8.put("event_page", "capability_panel");
            r8.put("button_type", "stable_mode");
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_capability_button_click", r8, new Object[]{am2.x.class});
        L46:
            if (com.bytedance.android.livesdk.config.setting.b.a() == true) goto L52;
            RoomContext r110 = RoomContext.a.c(r15, null, 0, 3);
            if (r110 == null) goto L52;
            com.bytedance.live.datacontext.m r111 = r110.isAnchorStableMode();
            if (r111 == null) goto L52;
            r111.setValue(Boolean.valueOf(!r6));
        L52:
            ILinkServiceExternal r112 = jc1.k.f(ILinkServiceExternal.class);
            if (r112 == null) goto L55;
            r112.updateStableMode(!r6);
        L55:
            AnchorPerfMonitorDialogNew r113 = this.a;
            int r0 = AnchorPerfMonitorDialogNew.B;
            r113.a1();
            return;
        L30:
            if (r18 != r17.p) goto L33;
            r19 = "medium";
            goto L43
        L33:
            if (r18 != r17.q) goto L35;
        L42:
            r19 = "low";
            goto L43
        L35:
            if (r18 == r17.s) goto L42;
            if (r18 == r17.t) goto L42;
            if (r18 != r17.r) goto L41;
        L19:
            r13 = "";
            goto L20
        L15:
            r12 = null;
            goto L16
        L44:
            jc1.k.n(IBroadcastService.class).enterStableModel(false, "capability_panel");
        L9:
            r6 = false;
            goto L11
        }
    }

    public static final class e implements View.OnClickListener {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            LinkedHashMap r6 = new LinkedHashMap();
            IRoomService r0 = (IRoomService) jc1.k.f(IRoomService.class);
            if (r0 == null) goto L5;
            Room r1 = r0.getCurrentRoom();
        L6:
            String r2 = "";
            if (r1 == null) goto L10;
            String r3 = String.valueOf(r1.id);
            if (r3 == null) goto L10;
        L11:
            r6.put("room_id", r3);
            if (r1 == null) goto L17;
            String r4 = r1.getAnchorId();
            if (r4 == null) goto L17;
            r2 = r4;
        L17:
            r6.put("anchor_id", r2);
            r6.put("anchor_capability_status", "low");
            r6.put("capability_issue", "stuck");
            r6.put("capability_button_action", "on");
            r6.put("event_page", "capability_panel");
            r6.put("button_type", "restart");
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_capability_button_click", r6, new Object[]{am2.x.class});
            jc1.k.n(IBroadcastService.class).showRestartBroadcastConfirmDialog(jc1.k.n(IHostApp.class).getTopActivity());
            return;
        L10:
            r3 = "";
            goto L11
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ AnchorPerfMonitorDialogNew a;

        public f(AnchorPerfMonitorDialogNew r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [android.app.Dialog, com.bytedance.android.live.room.discovery.AnchorPerfMonitorDialogNew, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            AnchorVideoResolutionManager.l(this.a.getContext(), this.a.h);
            ?? r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ AnchorPerfMonitorDialogNew a;

        public g(AnchorPerfMonitorDialogNew r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [android.app.Dialog, com.bytedance.android.live.room.discovery.AnchorPerfMonitorDialogNew, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            AnchorVideoResolutionManager.l(this.a.getContext(), this.a.h);
            ?? r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ AnchorPerfMonitorDialogNew a;

        public h(AnchorPerfMonitorDialogNew r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [android.app.Dialog, com.bytedance.android.live.room.discovery.AnchorPerfMonitorDialogNew, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            AnchorVideoResolutionManager.l(this.a.getContext(), this.a.h);
            ?? r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ AnchorPerfMonitorDialogNew a;

        public i(AnchorPerfMonitorDialogNew r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [android.app.Dialog, com.bytedance.android.live.room.discovery.AnchorPerfMonitorDialogNew, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            AnchorVideoResolutionManager.l(this.a.getContext(), this.a.h);
            ?? r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ AnchorPerfMonitorDialogNew a;

        public j(AnchorPerfMonitorDialogNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.W0();
        }
    }

    public static final class k implements View.OnClickListener {
        public final /* synthetic */ AnchorPerfMonitorDialogNew a;

        public k(AnchorPerfMonitorDialogNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.W0();
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565373;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    public final com.bytedance.android.live.pushstream.d S0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.j r1 = r0.getLiveStream();
        if (r1 != null) goto L7;
        return null;
    L7:
        return (com.bytedance.android.live.pushstream.d) r1.getValue();
    L8:
        return null;
    }

    public final String T0() {
        HashMap<String, String> r0 = this.A;
        Map r1 = AnchorVideoResolutionManager.a;
        String r2 = r0.get(AnchorVideoResolutionManager.c);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return AnchorVideoResolutionManager.c;
    }

    public final void U0() {
        if (this.y == false) goto L5;
        return;
    L5:
        ILinkServiceExternal r0 = jc1.k.f(ILinkServiceExternal.class);
        if (r0 == null) goto L10;
        lc0.d r1 = r0.getPkService();
        if (r1 == null) goto L10;
        Long r2 = Long.valueOf(r1.A());
    L11:
        if (r2 == null) goto L19;
        long r3 = r2.longValue();
        if (r3 <= 0) goto L20;
        m r4 = this.z;
        if (r4 == null) goto L17;
        r4.cancel();
    L17:
        m r5 = new m(this, r3 * ((long) WebcastRedirectException.UNKNOWN));
        this.z = r5;
        r5.start();
        this.y = true;
        return;
    L20:
        return;
    L19:
        return;
    L10:
        r2 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W0() {
        if (((Boolean) za0.a.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.c != 5) goto L24;
        xs2.b.a().post(new zg1.g());
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(this);
        return;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r1 == null) goto L21;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L10:
        if (Looper.myLooper() == r0.getLooper()) goto L12;
        r0.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    public final void a1() {
        int r0 = this.d;
        boolean r3 = true;
        if (r0 < 4) goto L5;
        int r1 = this.t;
    L29:
        RoomContext.a r2 = RoomContext.Companion;
        RoomContext r8 = RoomContext.a.c(r2, null, 0, 3);
        if (r8 == null) goto L36;
        com.bytedance.live.datacontext.m r9 = r8.isAnchorStableMode();
        if (r9 == null) goto L36;
        if (((Boolean) r9.getValue()).booleanValue() != true) goto L36;
    L38:
        if (com.bytedance.android.livesdk.config.setting.b.a() == false) goto L53;
        RoomContext r4 = RoomContext.a.c(r2, null, 0, 3);
        if (r4 == null) goto L48;
        com.bytedance.live.datacontext.j r5 = r4.getAnchorStableViewModel();
        if (r5 == null) goto L48;
        nz.n r6 = (nz.n) r5.getValue();
        if (r6 == null) goto L48;
        AnchorStrategy r7 = AnchorStrategy.StableMode;
        Integer r10 = r6.a();
        if (r10 == null) goto L48;
        int r12 = r10.intValue();
    L49:
        if (r3 == false) goto L56;
        if (r12 != TaskLevel.P2.getLevel()) goto L56;
        r1 = this.s;
    L56:
        if (r1 == this.v) goto L85;
        this.v = r1;
        TextView r13 = (TextView) findViewById(2131384440);
        if (r13 == null) goto L60;
        r13.setVisibility(8);
    L60:
        ((LinearLayout) findViewById(2131387159)).setVisibility(8);
        int r14 = this.v;
        if (r14 != this.t) goto L64;
        ((LinearLayout) findViewById(2131388843)).setBackground(s1.m(2131248813));
        ((TextView) findViewById(2131388772)).setText(s1.B(2131911549));
        ((TextView) findViewById(2131387160)).setVisibility(8);
        ((TextView) findViewById(2131384440)).setVisibility(0);
        ((TextView) findViewById(2131387156)).setText(s1.B(2131911565));
        return;
    L64:
        if (r14 != this.s) goto L67;
        ((LinearLayout) findViewById(2131388843)).setBackground(s1.m(2131248813));
        ((TextView) findViewById(2131388772)).setText(s1.B(2131911549));
        ((TextView) findViewById(2131387160)).setVisibility(0);
        ((TextView) findViewById(2131387160)).setText(s1.B(2131911561));
        ((TextView) findViewById(2131387160)).setBackground(s1.m(2131249962));
        ((TextView) findViewById(2131387156)).setText(s1.B(2131911563));
        ((TextView) findViewById(2131387160)).setTextColor(s1.h(2131107010));
        return;
    L67:
        if (r14 != this.r) goto L70;
        ((LinearLayout) findViewById(2131388843)).setBackground(s1.m(2131248813));
        ((TextView) findViewById(2131388772)).setText(s1.B(2131911549));
        ((TextView) findViewById(2131387160)).setVisibility(0);
        ((TextView) findViewById(2131387160)).setText(s1.B(2131911564));
        ((TextView) findViewById(2131387156)).setText(s1.B(2131911562));
        ((TextView) findViewById(2131387160)).setBackground(s1.m(2131249963));
        ((TextView) findViewById(2131387160)).setTextColor(s1.h(2131108154));
        return;
    L70:
        if (r14 != this.q) goto L77;
        ((LinearLayout) findViewById(2131388843)).setBackground(s1.m(2131248813));
        ((TextView) findViewById(2131388772)).setText(s1.B(2131911549));
        if (this.x == false) goto L74;
        ((TextView) findViewById(2131387156)).setText(s1.B(2131911551));
    L75:
        ((TextView) findViewById(2131387160)).setVisibility(8);
        return;
    L74:
        Z0(this.q);
        goto L75
    L77:
        if (r14 != this.p) goto L79;
    L83:
        ((LinearLayout) findViewById(2131388843)).setBackground(s1.m(2131248815));
        ((TextView) findViewById(2131388772)).setText(s1.B(2131911555));
        Z0(this.v);
        ((TextView) findViewById(2131387160)).setVisibility(8);
        return;
    L79:
        if (r14 == this.u) goto L83;
        if (r14 != 0) goto L90;
        ((LinearLayout) findViewById(2131388843)).setBackground(s1.m(2131248814));
        Z0(0);
        ((TextView) findViewById(2131388772)).setText(s1.B(2131911554));
        ((TextView) findViewById(2131387160)).setVisibility(8);
        return;
    L90:
        return;
    L85:
        return;
    L48:
        r12 = -1;
        goto L49
    L53:
        if (r3 == false) goto L56;
        r1 = this.s;
    L36:
        r3 = false;
        goto L38
    L5:
        if (r0 < 3) goto L7;
        r1 = this.r;
        goto L29
    L7:
        if (r0 != 1) goto L9;
        r1 = this.u;
        goto L29
    L9:
        int r15 = this.c;
        if (r15 != 7) goto L12;
    L28:
        r1 = this.q;
        goto L29
    L12:
        if (r15 == 5) goto L28;
        if (r15 == 9) goto L28;
        int r16 = this.b;
        if (r16 >= 3) goto L28;
        int r17 = this.a;
        if (r17 >= 3) goto L28;
        if (r15 != 6) goto L23;
    L27:
        r1 = this.p;
        goto L29
    L23:
        if (r16 >= 2) goto L27;
        if (r17 >= 2) goto L27;
        r1 = 0;
        goto L29
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        if (this.m.a() == true) goto L10;
    L8:
        super.onAttachedToWindow();
        return;
    L10:
        ((LifecycleRegistry) ((DialogLifecycleOwner) this.l.getValue()).a.getValue()).handleLifecycleEvent(Lifecycle.Event.ON_START);     // Catch: Exception -> L6
        X0(getContext(), this.w);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.toString();
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        if (this.m.a() == true) goto L25;
    L21:
        super.onDetachedFromWindow();
        return;
    L25:
        Context r0 = getContext();     // Catch: Exception -> L19
        AnchorPerfMonitorDialogNew$usbReceiver$1 r1 = this.w;     // Catch: Exception -> L19
        Intrinsics.checkNotNullParameter(r1, "usbReceiver");     // Catch: Exception -> L19
        if (r0 == null) goto L17;
        ReceiverRegisterLancet.loge(r1, false);     // Catch: Exception -> L19
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L23;
        r0.unregisterReceiver(r1);     // Catch: Exception -> L19
        goto L17
    L23:
    L12:
        e = move-exception;
        if (r1 == null) goto L15;
        Npth.addTag("unregisterReceiver", r1.toString());     // Catch: Exception -> L19
    L15:
        e.printStackTrace();     // Catch: Exception -> L19
        goto L17
    L9:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r1, r0) == false) goto L17;
        r0.unregisterReceiver(r1);     // Catch: Exception -> L12
    L17:
        ((LifecycleRegistry) ((DialogLifecycleOwner) this.l.getValue()).a.getValue()).handleLifecycleEvent(Lifecycle.Event.ON_STOP);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        e.toString();
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.room.discovery.IAnchorPerMonitorDialog
    public final void Q0() {
        if (isShowing() == true) goto L6;
        return;
    L6:
        if ((!this.f.isEmpty()) == false) goto L12;
        if (this.x == false) goto L10;
        a1.k(findViewById(2131384840), s1.f(545.0f));
    L10:
        UtilityKotlinExtentionsKt.w(findViewById(2131378817));
        return;
    L12:
        if (this.x == false) goto L14;
        a1.k(findViewById(2131384840), s1.f(460.0f));
    L14:
        UtilityKotlinExtentionsKt.t(findViewById(2131378817));
    }

    public final void Y0() {
        com.bytedance.android.livesdk.log.g r0 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r1 = new Pair[2];
        r1[0] = TuplesKt.to("event_page", "capability_panel");
        View r2 = findViewById(2131386999);
        if ((r2 instanceof DuxSwitch) == true) goto L5;
        r2 = null;
    L5:
        DuxSwitch r3 = (DuxSwitch) r2;
        if (r3 != null) goto L8;
    L10:
        String r4 = "off";
    L11:
        r1[1] = TuplesKt.to("soundcard_button_status", r4);
        r0.sendLog("livesdk_live_soundcard_button_show", MapsKt.mapOf(r1), new Object[]{Room.class});
        return;
    L8:
        if (r3.isChecked() != true) goto L10;
        r4 = "on";
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        m r1 = this.z;
        if (r1 == null) goto L20;
        r1.cancel();
    L20:
        this.y = false;
        CommonBottomDialog r2 = this.k;
        if (r2 == null) goto L39;
        Handler r3 = DialogLancet.resolveDialogHandler(r2);
        if (r3 != null) goto L25;
    L27:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L30 Exception -> L32
    L36:
        DialogLancet.afterDialogDismiss(r2);
        goto L39
    L30:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L32:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L30
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L30
        if (r4 == null) goto L36;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L30
        goto L36
    L25:
        if (Looper.myLooper() == r3.getLooper()) goto L27;
        r3.post(DialogLancet.createDismissRunnable(r2));
    L39:
        this.v = -1;
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r5 == null) goto L16;
        com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L127;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        U0();
        Q0();
        M0(this.c, this.j);
        N0(this.b);
        P0(this.a);
        O0(this.d);
        int r1 = 0;
        Integer r2 = null;
        int r3 = 8;
        if (this.m.a() == true) goto L10;
    L29:
        ConstraintLayout r0 = findViewById(2131386997);
        if (r0 == null) goto L32;
        r0.setVisibility(8);
    L32:
        LinkedHashMap r4 = new LinkedHashMap();
        IRoomService r5 = (IRoomService) jc1.k.f(IRoomService.class);
        if (r5 == null) goto L35;
        Room r6 = r5.getCurrentRoom();
    L36:
        String r7 = "";
        if (r6 == null) goto L40;
        String r8 = String.valueOf(r6.id);
        if (r8 == null) goto L40;
    L41:
        r4.put("room_id", r8);
        if (r6 == null) goto L45;
        String r9 = r6.getAnchorId();
        if (r9 == null) goto L45;
    L46:
        r4.put("anchor_id", r9);
        int r10 = this.v;
        if (r10 != 0) goto L50;
    L61:
        String r12 = "high";
    L63:
        r4.put("anchor_capability_status", r12);
        int r13 = this.v;
        if (r13 != this.q) goto L66;
    L73:
        String r14 = "stuck";
    L74:
        r4.put("capability_issue", r14);
        int r15 = this.v;
        if (r15 != this.s) goto L78;
        String r16 = "on";
    L84:
        r4.put("capability_button_status", r16);
        int r17 = this.v;
        if (r17 != this.s) goto L87;
    L92:
        r7 = "stable_mode";
    L93:
        r4.put("button_type", r7);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_capability_panel_show", r4, new Object[]{am2.x.class});
        if (this.x == false) goto L129;
        ALogger.d("AnchorVolumnOptiTAG", "setSpeakerBarPercent");
        if (t81.a.a(getContext()) > 0) goto L98;
        AdjustPercentBar r18 = findViewById(2131387059);
        if (r18 == null) goto L116;
        r18.setPercent(1);
    L116:
        TextView r19 = (TextView) findViewById(2131387062);
        if (r19 == null) goto L130;
        AdjustPercentBar r20 = findViewById(2131387059);
        if (r20 == null) goto L121;
        r2 = Integer.valueOf(r20.getPercent());
    L121:
        r19.setText(String.valueOf(r2.intValue()));
        return;
    L130:
        return;
    L98:
        if (t81.a.b(getContext()) == false) goto L125;
    L102:
        int r22 = -1;
    L103:
        int r23 = (int) ((r22 / t81.a.a(getContext())) * 100.0f);
        AdjustPercentBar r24 = findViewById(2131387059);
        if (r24 == null) goto L108;
        if (r23 <= 0) goto L107;
        r1 = r23;
    L107:
        r24.setPercent(r1);
    L108:
        StringBuilder r25 = new StringBuilder("speaker_bar?.percent:");
        AdjustPercentBar r26 = findViewById(2131387059);
        if (r26 == null) goto L111;
        Integer r27 = Integer.valueOf(r26.getPercent());
    L112:
        r25.append(r27.intValue());
        ALogger.d("AnchorVolumnOptiTAG", r25.toString());
        goto L116
    L111:
        r27 = null;
        goto L112
    L125:
        r22 = t81.a.a.getStreamVolume(3);     // Catch: Exception -> L123
    L129:
        return;
    L87:
        if (r17 == this.r) goto L92;
        if (r17 != this.t) goto L93;
        r7 = "restart";
        goto L93
    L78:
        if (r15 != this.r) goto L81;
    L82:
        r16 = "off";
        goto L84
    L81:
        if (r15 == this.t) goto L82;
        r16 = "null";
        goto L84
    L66:
        if (r13 == this.s) goto L73;
        if (r13 == this.t) goto L73;
        if (r13 == this.r) goto L73;
        r14 = "";
        goto L74
    L50:
        if (r10 != this.p) goto L53;
        r12 = "medium";
        goto L63
    L53:
        if (r10 != this.q) goto L55;
    L62:
        r12 = "low";
        goto L63
    L55:
        if (r10 == this.s) goto L62;
        if (r10 == this.t) goto L62;
        if (r10 != this.r) goto L61;
    L45:
        r9 = "";
    L40:
        r8 = "";
        goto L41
    L35:
        r6 = null;
        goto L36
    L10:
        if (this.i == false) goto L29;
        ConstraintLayout r28 = findViewById(2131386997);
        if (r28 == null) goto L17;
        UsbManager r29 = UsbDeviceUtils.a;
        if (UsbDeviceUtils.a() == false) goto L16;
        r3 = 0;
    L16:
        r28.setVisibility(r3);
    L17:
        View r30 = findViewById(2131386999);
        if ((r30 instanceof DuxSwitch) == true) goto L20;
        r30 = null;
    L20:
        DuxSwitch r32 = (DuxSwitch) r30;
        if (r32 == null) goto L23;
        SharedPreferences r33 = SoundCardModeManager.a;
        SoundCardModeManager.c();
        r32.setChecked(false);
    L23:
        Y0();
        SharedPreferences r34 = SoundCardModeManager.a;
        ((NextLiveData) SoundCardModeManager.b.getValue()).observe((DialogLifecycleOwner) this.l.getValue(), new com.bytedance.android.live.room.discovery.g(this));
        View r35 = findViewById(2131386999);
        if ((r35 instanceof DuxSwitch) == true) goto L26;
        r35 = null;
    L26:
        DuxSwitch r36 = (DuxSwitch) r35;
        if (r36 == null) goto L32;
        r36.setOnClickListener(new com.bytedance.android.live.room.discovery.h(this));
        goto L32
    L127:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L124
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [com.bytedance.android.live.room.discovery.AnchorPerfMonitorDialogNew$usbReceiver$1] */
    public AnchorPerfMonitorDialogNew(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.j = true;
        this.l = LazyKt.lazy(AnchorPerfMonitorDialogNew$lifecycleOwner$2.INSTANCE);
        this.m = (ms1.g) bi.a.getValue();
        this.n = "";
        this.o = new LinkedHashMap();
        this.p = 1;
        this.q = 2;
        this.r = 3;
        this.s = 4;
        this.t = 5;
        this.u = 6;
        this.v = -1;
        this.w = new AnchorPerfMonitorDialogNew$usbReceiver$1(this);
        this.A = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("ld", "标清"), TuplesKt.to("sd", "高清"), TuplesKt.to("hd", "超清"), TuplesKt.to("uhd", "蓝光")});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.room.discovery.IAnchorPerMonitorDialog
    public final void N0(int r5) {
        this.b = r5;
        if (isShowing() == true) goto L6;
        return;
    L6:
        if (r5 != 1) goto L8;
        ImageView r6 = (ImageView) findViewById(2131374704);
        if (r6 == null) goto L44;
        V0(r6, 2131251268);
    L44:
        TextView r7 = (TextView) findViewById(2131390982);
        if (r7 == null) goto L47;
        r7.setText("Wi-Fi/移动网络良好");
    L47:
        TextView r8 = (TextView) findViewById(2131390983);
        if (r8 == null) goto L50;
        r8.setText("建议不要频繁切换网络");
    L50:
        a1();
        return;
    L8:
        if (r5 != 2) goto L10;
        ImageView r9 = (ImageView) findViewById(2131374704);
        if (r9 == null) goto L35;
        V0(r9, 2131251270);
    L35:
        TextView r10 = (TextView) findViewById(2131390982);
        if (r10 == null) goto L38;
        r10.setText("Wi-Fi/移动网络波动");
    L38:
        TextView r12 = (TextView) findViewById(2131390983);
        if (r12 == null) goto L50;
        r12.setText("可能影响开播，请检查网络状态");
        goto L50
    L10:
        if (r5 != 3) goto L12;
        ImageView r13 = (ImageView) findViewById(2131374704);
        if (r13 == null) goto L26;
        V0(r13, 2131251272);
    L26:
        TextView r14 = (TextView) findViewById(2131390982);
        if (r14 == null) goto L29;
        r14.setText("Wi-Fi/移动网络不佳");
    L29:
        TextView r15 = (TextView) findViewById(2131390983);
        if (r15 == null) goto L50;
        r15.setText("建议切换网络");
        goto L50
    L12:
        if (r5 != 4) goto L50;
        ImageView r16 = (ImageView) findViewById(2131374704);
        if (r16 == null) goto L17;
        V0(r16, 2131251266);
    L17:
        TextView r17 = (TextView) findViewById(2131390982);
        if (r17 == null) goto L20;
        r17.setText("当前未连接网络");
    L20:
        TextView r18 = (TextView) findViewById(2131390983);
        if (r18 == null) goto L50;
        r18.setText("请检查网络状态");
        goto L50
    }

    @Override // com.bytedance.android.live.room.discovery.IAnchorPerMonitorDialog
    public final void O0(int r1) {
        this.d = r1;
        a1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.room.discovery.IAnchorPerMonitorDialog
    public final void P0(int r5) {
        this.a = r5;
        if (isShowing() == true) goto L6;
        return;
    L6:
        if (r5 != 1) goto L8;
        ImageView r6 = (ImageView) findViewById(2131374715);
        if (r6 == null) goto L33;
        V0(r6, 2131251548);
    L33:
        TextView r7 = (TextView) findViewById(2131391566);
        if (r7 == null) goto L36;
        r7.setText("设备温度正常");
    L36:
        TextView r8 = (TextView) findViewById(2131391567);
        if (r8 == null) goto L39;
        r8.setText("建议适时检查，保障流畅开播");
    L39:
        a1();
        return;
    L8:
        if (r5 != 2) goto L10;
        ImageView r9 = (ImageView) findViewById(2131374715);
        if (r9 == null) goto L24;
        V0(r9, 2131251549);
    L24:
        TextView r10 = (TextView) findViewById(2131391566);
        if (r10 == null) goto L27;
        r10.setText("设备发热明显");
    L27:
        TextView r12 = (TextView) findViewById(2131391567);
        if (r12 == null) goto L39;
        r12.setText("设备发热，可能影响开播，建议采取降温措施");
        goto L39
    L10:
        if (r5 != 3) goto L39;
        ImageView r13 = (ImageView) findViewById(2131374715);
        if (r13 == null) goto L15;
        V0(r13, 2131251547);
    L15:
        TextView r14 = (TextView) findViewById(2131391566);
        if (r14 == null) goto L18;
        r14.setText("设备发热严重");
    L18:
        TextView r15 = (TextView) findViewById(2131391567);
        if (r15 == null) goto L39;
        r15.setText("设备发热严重，建议采取降温措施");
        goto L39
    }

    public final void Z0(int r10) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.e, 0, 2);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.i r1 = r0.getLiveMode();
        if (r1 == null) goto L7;
        LiveMode r2 = (LiveMode) r1.getValue();
    L9:
        if (r2 != LiveMode.VIDEO) goto L28;
        if (((Boolean) rh.a.getValue()).booleanValue() == false) goto L28;
        if (r10 != this.u) goto L16;
        ((TextView) findViewById(2131387156)).setText("画面轻微卡顿");
        ((LinearLayout) findViewById(2131387159)).setVisibility(0);
        ((TextView) findViewById(2131387157)).setText("实际清晰度：" + T0());
        ((LinearLayout) findViewById(2131387159)).setOnClickListener(new f(this));
        ((ImageView) findViewById(2131387158)).setVisibility(0);
        return;
    L16:
        if (r10 != this.p) goto L19;
        ((TextView) findViewById(2131387156)).setText(s1.B(2131911553));
        ((LinearLayout) findViewById(2131387159)).setVisibility(0);
        ((TextView) findViewById(2131387157)).setText("实际清晰度：" + T0());
        ((LinearLayout) findViewById(2131387159)).setOnClickListener(new g(this));
        ((ImageView) findViewById(2131387158)).setVisibility(0);
        return;
    L19:
        if (r10 != this.q) goto L21;
        ((TextView) findViewById(2131387156)).setText("难以流畅开播，请采取措施");
        ((LinearLayout) findViewById(2131387159)).setVisibility(0);
        ((TextView) findViewById(2131387157)).setText("实际清晰度：" + T0());
        ((LinearLayout) findViewById(2131387159)).setOnClickListener(new h(this));
        ((ImageView) findViewById(2131387158)).setVisibility(0);
        return;
    L21:
        if (r10 != 0) goto L26;
        ((TextView) findViewById(2131387156)).setText("开播画面流畅");
        ((LinearLayout) findViewById(2131387159)).setVisibility(0);
        String r12 = "实际清晰度：" + T0();
        if (r12 == null) goto L25;
        ((TextView) findViewById(2131387157)).setText(r12);
    L25:
        ((LinearLayout) findViewById(2131387159)).setOnClickListener(new i(this));
        return;
    L26:
        ((LinearLayout) findViewById(2131387159)).setVisibility(8);
        return;
    L28:
        if (r10 != this.q) goto L31;
        ((TextView) findViewById(2131387156)).setText(s1.B(2131911550));
    L35:
        ((LinearLayout) findViewById(2131387159)).setVisibility(8);
        return;
    L31:
        if (r10 != this.p) goto L33;
        ((TextView) findViewById(2131387156)).setText(s1.B(2131911553));
        goto L35
    L33:
        if (r10 != 0) goto L35;
        ((TextView) findViewById(2131387156)).setText(s1.B(2131911552));
    L7:
        r2 = null;
        goto L9
    }

    public final void onCreate(Bundle r17) {
        super.onCreate(r17);
        int r1 = b1.a;
        b1.b(true, new AnchorPerfMonitorDialogNew$initDialogUI$1(this));
        TextView r2 = (TextView) findViewById(2131391256);
        if (r2 == null) goto L6;
        r2.setOnClickListener(new b(this));
    L6:
        if (((Boolean) lq0.a.getValue()).booleanValue() == false) goto L17;
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, this.e, 0, 2);
        if (r3 == null) goto L12;
        com.bytedance.live.datacontext.i r4 = r3.getLiveMode();
        if (r4 == null) goto L12;
        LiveMode r5 = (LiveMode) r4.getValue();
    L14:
        if (r5 != LiveMode.SCREEN_RECORD) goto L17;
        this.x = true;
    L12:
        r5 = null;
    L17:
        if (this.x == false) goto L155;
        ALogger.d("AnchorVolumnOptiTAG", "showBarLayout");
        RelativeLayout r6 = (RelativeLayout) findViewById(2131381580);
        if (r6 == null) goto L21;
        UtilityKotlinExtentionsKt.w(r6);
    L21:
        TextView r7 = (TextView) findViewById(2131381578);
        if (r7 == null) goto L24;
        r7.setOnClickListener(new com.bytedance.android.live.room.discovery.j(this));
    L24:
        kjc.c r8 = new kjc.c();
        if (7 != kjc.a.a()) goto L31;
        kjc.b r9 = r8.a;
        FrameLayout r10 = (FrameLayout) findViewById(2131381582);
        if (r10 == null) goto L29;
        r10.setOnClickListener(com.bytedance.android.live.room.discovery.k.a);
    L29:
        r9.a = Unit.INSTANCE;
        r8.b = true;
    L31:
        if (r8.b == true) goto L36;
        kjc.b r12 = r8.a;
        FrameLayout r13 = (FrameLayout) findViewById(2131381582);
        if (r13 == null) goto L35;
        r13.setOnClickListener(l.a);
    L35:
        r12.a = Unit.INSTANCE;
    L36:
        Object r14 = r8.a.a;
        RelativeLayout r15 = (RelativeLayout) findViewById(2131388313);
        if (r15 == null) goto L39;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
    L40:
        if (r16 == null) goto L154;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r16;
        r18.topMargin = s1.f(15.0f);
        RelativeLayout r19 = (RelativeLayout) findViewById(2131388313);
        if (r19 == null) goto L44;
        r19.setLayoutParams(r18);
    L44:
        ALogger.d("AnchorVolumnOptiTAG", "initSpeakerBarLayout");
        AdjustPercentBar r20 = findViewById(2131387059);
        if (r20 == null) goto L47;
        r20.c(s1.h(2131107027), s1.h(2131107017), s1.h(2131107027));
    L47:
        AdjustPercentBar r22 = findViewById(2131387059);
        if (r22 == null) goto L50;
        r22.b();
    L50:
        AdjustPercentBar r23 = findViewById(2131387059);
        if (r23 == null) goto L53;
        r23.e(100, 0, 100, true);
    L53:
        AdjustPercentBar r24 = findViewById(2131387059);
        if (r24 == null) goto L56;
        r24.setOnLevelChangeListener(new com.bytedance.android.live.room.discovery.i(this));
    L56:
        ALogger.d("AnchorVolumnOptiTAG", "initMicBarLayout");
        if (this.i == false) goto L97;
        TextView r25 = (TextView) findViewById(2131380053);
        if (r25 == null) goto L61;
        UtilityKotlinExtentionsKt.w(r25);
    L61:
        AdjustPercentBar r26 = findViewById(2131380050);
        if (r26 == null) goto L64;
        UtilityKotlinExtentionsKt.w(r26);
    L64:
        TextView r27 = (TextView) findViewById(2131380052);
        if (r27 == null) goto L67;
        UtilityKotlinExtentionsKt.w(r27);
    L67:
        AdjustPercentBar r28 = findViewById(2131380050);
        if (r28 == null) goto L70;
        r28.c(s1.h(2131107027), s1.h(2131107017), s1.h(2131107027));
    L70:
        AdjustPercentBar r29 = findViewById(2131380050);
        if (r29 == null) goto L73;
        r29.b();
    L73:
        AdjustPercentBar r30 = findViewById(2131380050);
        if (r30 == null) goto L76;
        r30.e(100, 1, 100, true);
    L76:
        AdjustPercentBar r32 = findViewById(2131380050);
        if (r32 == null) goto L83;
        com.bytedance.android.live.pushstream.d r33 = S0();
        if (r33 == null) goto L81;
        r33.N0();
        float r34 = 0.0f;
    L82:
        r32.setPercent((int) (r34 * 100));
        goto L83
    L81:
        r34 = 0.01f;
    L83:
        StringBuilder r35 = new StringBuilder("liveStream?.micVolume:");
        com.bytedance.android.live.pushstream.d r36 = S0();
        if (r36 == null) goto L86;
        r36.N0();
        Float r37 = Float.valueOf(0.0f);
    L87:
        r35.append(r37);
        ALogger.d("AnchorVolumnOptiTAG", r35.toString());
        TextView r38 = (TextView) findViewById(2131380052);
        if (r38 == null) goto L94;
        AdjustPercentBar r39 = findViewById(2131380050);
        if (r39 == null) goto L92;
        Integer r40 = Integer.valueOf(r39.getPercent());
    L93:
        r38.setText(String.valueOf(r40.intValue()));
        goto L94
    L92:
        r40 = null;
    L94:
        AdjustPercentBar r42 = findViewById(2131380050);
        if (r42 == null) goto L106;
        r42.setOnLevelChangeListener(new com.bytedance.android.live.room.discovery.f(this));
    L106:
        ALogger.d("AnchorVolumnOptiTAG", "initInternalBarLayout");
        if (((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).isInAudioPlayBackCapture() == true) goto L117;
        LinearLayout r43 = (LinearLayout) findViewById(2131375562);
        if (r43 == null) goto L111;
        UtilityKotlinExtentionsKt.t(r43);
    L111:
        AdjustPercentBar r44 = findViewById(2131375559);
        if (r44 == null) goto L114;
        UtilityKotlinExtentionsKt.t(r44);
    L114:
        TextView r45 = (TextView) findViewById(2131375561);
        if (r45 == null) goto L147;
        UtilityKotlinExtentionsKt.t(r45);
    L147:
        RelativeLayout r46 = (RelativeLayout) findViewById(2131384695);
        if (r46 == null) goto L150;
        r46.setVisibility(0);
    L150:
        LinearLayout r47 = (LinearLayout) findViewById(2131378621);
        if (r47 == null) goto L195;
        r47.setVisibility(8);
    L195:
        TextView r48 = (TextView) findViewById(2131387160);
        if (r48 == null) goto L206;
        RoomContext r49 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r49 == null) goto L204;
        com.bytedance.live.datacontext.m r50 = r49.isAnchorStableMode();
        if (r50 == null) goto L204;
        if (((Boolean) r50.getValue()).booleanValue() != true) goto L204;
        int r52 = 2131911561;
    L205:
        r48.setText(s1.B(r52));
    L204:
        r52 = 2131911564;
    L206:
        TextView r53 = (TextView) findViewById(2131387160);
        if (r53 == null) goto L209;
        r53.setOnClickListener(new d(this));
    L209:
        TextView r54 = (TextView) findViewById(2131384440);
        if (r54 == null) goto L213;
        r54.setOnClickListener(e.a);
        return;
    L213:
        return;
    L117:
        AdjustPercentBar r55 = findViewById(2131375559);
        if (r55 == null) goto L120;
        r55.c(s1.h(2131107027), s1.h(2131107017), s1.h(2131107027));
    L120:
        AdjustPercentBar r56 = findViewById(2131375559);
        if (r56 == null) goto L123;
        r56.b();
    L123:
        AdjustPercentBar r57 = findViewById(2131375559);
        if (r57 == null) goto L126;
        r57.e(100, 1, 100, true);
    L126:
        AdjustPercentBar r58 = findViewById(2131375559);
        if (r58 == null) goto L129;
        r58.setPercent(100);
    L129:
        StringBuilder r59 = new StringBuilder("liveStream?.internalBuilder?.gameInnerVolume:");
        com.bytedance.android.live.pushstream.d r60 = S0();
        if (r60 == null) goto L136;
        uf2.d0 r62 = r60.A();
        if (r62 == null) goto L136;
        uf2.d0.a r63 = r62.getBuilder();
        if (r63 == null) goto L136;
        Float r64 = Float.valueOf(r63.q0());
    L137:
        r59.append(r64);
        ALogger.d("AnchorVolumnOptiTAG", r59.toString());
        TextView r65 = (TextView) findViewById(2131375561);
        AdjustPercentBar r66 = findViewById(2131375559);
        if (r66 == null) goto L140;
        Integer r67 = Integer.valueOf(r66.getPercent());
    L141:
        r65.setText(String.valueOf(r67.intValue()));
        FrameLayout r68 = (FrameLayout) findViewById(2131375560);
        if (r68 == null) goto L144;
        r68.setOnClickListener(com.bytedance.android.live.room.discovery.d.a);
    L144:
        AdjustPercentBar r69 = findViewById(2131375559);
        if (r69 == null) goto L147;
        r69.setOnLevelChangeListener(new com.bytedance.android.live.room.discovery.e(this));
        goto L147
    L140:
        r67 = null;
    L136:
        r64 = null;
        goto L137
    L86:
        r37 = null;
        goto L87
    L97:
        TextView r70 = (TextView) findViewById(2131380053);
        if (r70 == null) goto L100;
        UtilityKotlinExtentionsKt.t(r70);
    L100:
        AdjustPercentBar r72 = findViewById(2131380050);
        if (r72 == null) goto L103;
        UtilityKotlinExtentionsKt.t(r72);
    L103:
        TextView r73 = (TextView) findViewById(2131380052);
        if (r73 == null) goto L106;
        UtilityKotlinExtentionsKt.t(r73);
        goto L106
    L154:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L39:
        r16 = null;
        goto L40
    L155:
        AdjustPercentBar r74 = findViewById(2131363963);
        if (r74 == null) goto L158;
        r74.c(s1.h(2131107027), s1.h(2131107017), s1.h(2131107027));
    L158:
        AdjustPercentBar r75 = findViewById(2131363963);
        if (r75 == null) goto L161;
        r75.b();
    L161:
        AdjustPercentBar r76 = findViewById(2131363963);
        if (r76 == null) goto L164;
        r76.e(100, 1, 100, true);
    L164:
        AdjustPercentBar r77 = findViewById(2131363963);
        if (r77 == null) goto L171;
        com.bytedance.android.live.pushstream.d r78 = S0();
        if (r78 == null) goto L169;
        r78.N0();
        float r79 = 0.0f;
    L170:
        r77.setPercent((int) (r79 * 100));
        goto L171
    L169:
        r79 = 0.01f;
    L171:
        TextView r80 = (TextView) findViewById(2131375219);
        if (r80 == null) goto L178;
        AdjustPercentBar r82 = findViewById(2131363963);
        if (r82 == null) goto L176;
        Integer r83 = Integer.valueOf(r82.getPercent());
    L177:
        r80.setText(String.valueOf(r83.intValue()));
        goto L178
    L176:
        r83 = null;
    L178:
        AdjustPercentBar r84 = findViewById(2131363963);
        if (r84 == null) goto L181;
        r84.setOnLevelChangeListener(new c(this));
    L181:
        RelativeLayout r85 = (RelativeLayout) findViewById(2131384695);
        if (r85 != null) goto L184;
    L188:
        LinearLayout r86 = (LinearLayout) findViewById(2131378621);
        if (r86 == null) goto L195;
        if (this.i == false) goto L193;
        int r87 = 0;
    L194:
        r86.setVisibility(r87);
        goto L195
    L193:
        r87 = 8;
        goto L194
    L184:
        if (this.i == false) goto L186;
        int r88 = 0;
    L187:
        r85.setVisibility(r88);
        goto L188
    L186:
        r88 = 8;
        goto L187
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.room.discovery.IAnchorPerMonitorDialog
    public final void M0(int r10, boolean r12) {
        if (this.x == true) goto L5;
    L7:
        ILiveExternalCameraServiceForOther r0 = jc1.k.f(ILiveExternalCameraServiceForOther.class);
        if (r0 != null) goto L10;
    L12:
        this.c = r10;
        this.j = r12;
        if (isShowing() == true) goto L16;
        return;
    L16:
        switch(r10) {
            case 5: goto L90;
            case 6: goto L76;
            case 7: goto L55;
            case 8: goto L46;
            case 9: goto L20;
            default: goto L18;
        };
    L20:
        kjc.c r13 = new kjc.c();
        if (7 != kjc.a.a()) goto L33;
        kjc.b r14 = r13.a;
        ImageView r4 = (ImageView) findViewById(2131374701);
        if (r4 == null) goto L25;
        V0(r4, 2131251226);
    L25:
        TextView r5 = (TextView) findViewById(2131390949);
        if (r5 == null) goto L28;
        r5.setText("音频无声音");
    L28:
        TextView r6 = (TextView) findViewById(2131390950);
        if (r6 == null) goto L31;
        r6.setText("麦克风被占用，建议关闭游戏内或其他应用麦克风");
    L31:
        r14.a = Unit.INSTANCE;
        r13.b = true;
    L33:
        if (r13.b == true) goto L44;
        kjc.b r15 = r13.a;
        ImageView r7 = (ImageView) findViewById(2131374701);
        if (r7 == null) goto L37;
        V0(r7, 2131251226);
    L37:
        TextView r3 = (TextView) findViewById(2131390949);
        if (r3 == null) goto L40;
        r3.setText("音频无声音");
    L40:
        TextView r2 = (TextView) findViewById(2131390950);
        if (r2 == null) goto L43;
        r2.setText("麦克风被占用，建议开启无障碍功能");
    L43:
        r15.a = Unit.INSTANCE;
    L44:
        Object r16 = r13.a.a;
    L159:
        a1();
        if (this.x == false) goto L186;
        ALogger.d("AnchorVolumnOptiTAG", "refreshOptiMicBarLayoutUI:" + this.c);
        if (this.c != 9) goto L179;
        kjc.c r17 = new kjc.c();
        if (7 != kjc.a.a()) goto L170;
        kjc.b r18 = r17.a;
        FrameLayout r1 = (FrameLayout) findViewById(2131381582);
        if (r1 == null) goto L168;
        UtilityKotlinExtentionsKt.w(r1);
    L168:
        r18.a = Unit.INSTANCE;
        r17.b = true;
    L170:
        if (r17.b == true) goto L178;
        kjc.b r19 = r17.a;
        TextView r8 = (TextView) findViewById(2131381578);
        if (r8 == null) goto L174;
        UtilityKotlinExtentionsKt.w(r8);
    L174:
        FrameLayout r9 = (FrameLayout) findViewById(2131381582);
        if (r9 == null) goto L177;
        UtilityKotlinExtentionsKt.w(r9);
    L177:
        r19.a = Unit.INSTANCE;
    L178:
        Object r110 = r17.a.a;
        return;
    L179:
        TextView r111 = (TextView) findViewById(2131381578);
        if (r111 == null) goto L182;
        UtilityKotlinExtentionsKt.t(r111);
    L182:
        FrameLayout r112 = (FrameLayout) findViewById(2131381582);
        if (r112 == null) goto L188;
        UtilityKotlinExtentionsKt.t(r112);
        return;
    L188:
        return;
    L186:
        return;
    L55:
        ImageView r113 = (ImageView) findViewById(2131374701);
        if (r113 == null) goto L58;
        V0(r113, 2131251226);
    L58:
        if (r12 == false) goto L65;
        TextView r114 = (TextView) findViewById(2131390949);
        if (r114 == null) goto L62;
        r114.setText("无声音输出");
    L62:
        TextView r115 = (TextView) findViewById(2131390950);
        if (r115 == null) goto L72;
        r115.setText("建议检查音频设置");
    L72:
        if (((Boolean) hh.a.getValue()).booleanValue() == true) goto L159;
        LinearLayout r116 = (LinearLayout) findViewById(2131378621);
        if (r116 == null) goto L159;
        UtilityKotlinExtentionsKt.t(r116);
        goto L159
    L65:
        TextView r117 = (TextView) findViewById(2131390949);
        if (r117 == null) goto L68;
        r117.setText("音频无声音输出");
    L68:
        TextView r118 = (TextView) findViewById(2131390950);
        if (r118 == null) goto L72;
        r118.setText("麦克风权限被抢占，建议关闭其他使用麦克风的应用");
        goto L72
    L76:
        ImageView r119 = (ImageView) findViewById(2131374701);
        if (r119 == null) goto L79;
        V0(r119, 2131251228);
    L79:
        TextView r120 = (TextView) findViewById(2131390949);
        if (r120 == null) goto L82;
        r120.setText("音频音量过大");
    L82:
        TextView r121 = (TextView) findViewById(2131390950);
        if (r121 == null) goto L86;
        r121.setText("建议调低音量或调整麦克风距离");
    L86:
        if (this.x == true) goto L159;
        LinearLayout r122 = (LinearLayout) findViewById(2131378621);
        if (r122 == null) goto L159;
        UtilityKotlinExtentionsKt.w(r122);
        goto L159
    L90:
        ILiveExternalCameraServiceForOther r123 = jc1.k.f(ILiveExternalCameraServiceForOther.class);
        if (r123 != null) goto L93;
    L95:
        String r124 = "已设置静音";
    L96:
        ImageView r125 = (ImageView) findViewById(2131374701);
        if (r125 == null) goto L99;
        V0(r125, 2131251230);
    L99:
        TextView r126 = (TextView) findViewById(2131390949);
        if (r126 == null) goto L102;
        r126.setText(r124);
    L102:
        TextView r127 = (TextView) findViewById(2131390950);
        if (r127 == null) goto L106;
        r127.setText((String) xg.a.getValue());
    L106:
        if (this.x == true) goto L113;
        RelativeLayout r128 = (RelativeLayout) findViewById(2131384695);
        if (r128 == null) goto L110;
        UtilityKotlinExtentionsKt.w(r128);
    L110:
        LinearLayout r129 = (LinearLayout) findViewById(2131378621);
        if (r129 == null) goto L113;
        UtilityKotlinExtentionsKt.t(r129);
    L113:
        ILiveExternalCameraServiceForOther r130 = jc1.k.f(ILiveExternalCameraServiceForOther.class);
        if (r130 == null) goto L121;
        if (r130.isConnected() != true) goto L121;
        TextView r131 = (TextView) findViewById(2131390950);
        if (r131 == null) goto L131;
        r131.setText(s1.B(2131911547));
    L131:
        ILinkServiceExternal r132 = jc1.k.f(ILinkServiceExternal.class);
        if (r132 == null) goto L136;
        lc0.d r133 = r132.getPkService();
        if (r133 == null) goto L136;
        long r134 = r133.A();
    L138:
        if (r134 <= 0) goto L159;
        U0();
        ImageView r135 = (ImageView) findViewById(2131374701);
        if (r135 == null) goto L142;
        V0(r135, 2131251231);
    L142:
        TextView r136 = (TextView) findViewById(2131390949);
        if (r136 == null) goto L159;
        r136.setText(s1.B(2131911542));
    L136:
        r134 = 0;
    L121:
        if (((Boolean) za0.a.getValue()).booleanValue() == false) goto L131;
        TextView r137 = (TextView) findViewById(2131390950);
        if (r137 == null) goto L125;
        r137.setText(s1.B(2131911548));
    L125:
        TextView r138 = (TextView) findViewById(2131390949);
        if (r138 == null) goto L128;
        r138.setOnClickListener(new j(this));
    L128:
        TextView r139 = (TextView) findViewById(2131390950);
        if (r139 == null) goto L131;
        r139.setOnClickListener(new k(this));
        goto L131
    L93:
        if (r123.isConnected() != true) goto L95;
        r124 = "相机收音";
        goto L96
    L18:
        if (this.i == true) goto L145;
        return;
    L145:
        ImageView r140 = (ImageView) findViewById(2131374701);
        if (r140 == null) goto L148;
        V0(r140, 2131251232);
    L148:
        TextView r141 = (TextView) findViewById(2131390949);
        if (r141 == null) goto L151;
        r141.setText("音频状态正常");
    L151:
        TextView r142 = (TextView) findViewById(2131390950);
        if (r142 == null) goto L155;
        r142.setText("适当的音量可以保障观众观看体验");
    L155:
        if (this.x == true) goto L159;
        LinearLayout r143 = (LinearLayout) findViewById(2131378621);
        if (r143 == null) goto L159;
        UtilityKotlinExtentionsKt.w(r143);
        goto L159
    L46:
        if (this.x == true) goto L159;
        if (((Boolean) hh.a.getValue()).booleanValue() == false) goto L52;
        RelativeLayout r144 = (RelativeLayout) findViewById(2131384695);
        if (r144 == null) goto L159;
        UtilityKotlinExtentionsKt.w(r144);
        goto L159
    L52:
        RelativeLayout r145 = (RelativeLayout) findViewById(2131384695);
        if (r145 == null) goto L159;
        UtilityKotlinExtentionsKt.t(r145);
        goto L159
    L10:
        if (r0.isConnected() != true) goto L12;
        r10 = 5;
        goto L12
    L5:
        if (r10 != 6) goto L7;
        r10 = 4;
        goto L7
    }

    public final void V0(ImageView r4, int r5) {
        if (this.o.containsKey(Integer.valueOf(r5)) == true) goto L5;
        this.o.put(Integer.valueOf(r5), s1.m(r5));
    L5:
        Map<Integer, Drawable> r0 = this.o;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        r4.setImageDrawable((Drawable) r1.get(Integer.valueOf(r5)));
    }

    public final void X0(Context r3, BroadcastReceiver r4) {
        Intrinsics.checkNotNullParameter(r4, "usbReceiver");
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        r0.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        if (r3 == null) goto L11;
        R0(r3, (AnchorPerfMonitorDialogNew$usbReceiver$1) r4, r0);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        ALogger.e("AnchorPerfMonitorWidget", "register usb Receiver fail " + e);
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void R0(Context r8, AnchorPerfMonitorDialogNew$usbReceiver$1 r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
