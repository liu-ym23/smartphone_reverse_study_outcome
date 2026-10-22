package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/discovery/AnchorPerfMonitorDialog;", "Lcom/bytedance/android/live/room/discovery/IAnchorPerMonitorDialog;", "Landroid/view/View$OnClickListener;", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPerfMonitorDialog extends IAnchorPerMonitorDialog implements View.OnClickListener {
    public static final /* synthetic */ int m = 0;
    public int a;
    public int b;
    public int c;
    public List<String> d;
    public List<? extends CharSequence> e;
    public Room f;
    public boolean g;
    public ArrayAdapter<String> h;
    public AnchorPerfMonitorDialogDetail i;
    public final Map<Integer, Drawable> j;
    public boolean k;
    public com.bytedance.android.live.room.discovery.c l;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AnchorPerfMonitorDialog a;

        public a(AnchorPerfMonitorDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            AnchorPerfMonitorDialog r5 = this.a;
            if (r5.i != null) goto L5;
            r5.i = new AnchorPerfMonitorDialogDetail(this.a.getContext(), this.a.e);
        L5:
            AnchorPerfMonitorDialogDetail r6 = this.a.i;
            if (r6 != null) goto L8;
        L12:
            LinkedHashMap r7 = new LinkedHashMap();
            Room r0 = this.a.f;
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

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AnchorPerfMonitorDialog a;

        public b(AnchorPerfMonitorDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.bytedance.android.live.room.discovery.AnchorPerfMonitorDialog, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ?? r5 = this.a;
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

    public static final class c implements AdjustPercentBar.d {
        public final /* synthetic */ AnchorPerfMonitorDialog a;

        public final void b() {
        }

        public c(AnchorPerfMonitorDialog r1) {
            this.a = r1;
        }

        public final void a(int r6) {
            AnchorPerfMonitorDialog r0 = this.a;
            int r1 = AnchorPerfMonitorDialog.m;
            r0.getClass();
            com.bytedance.android.live.pushstream.d r2 = null;
            RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r3 == null) goto L7;
            com.bytedance.live.datacontext.j r4 = r3.getLiveStream();
            if (r4 == null) goto L7;
            r2 = (com.bytedance.android.live.pushstream.d) r4.getValue();
        L7:
            if (r2 == null) goto L9;
            r2.p1(r6 / 100.0f);
        L9:
            LinkedHashMap r5 = new LinkedHashMap();
            Room r7 = this.a.f;
            if (r7 == null) goto L12;
            r5.put("room_id", String.valueOf(r7.id));
            r5.put("anchor_id", r7.getOwnerUserIdString());
        L12:
            r5.put("status", String.valueOf(r6));
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_quality_sound_click", r5, new Object[0]);
        }

        public final void onChanged(int r3) {
            TextView r0 = (TextView) this.a.findViewById(2131375219);
            if (r0 == null) goto L6;
            r0.setText(String.valueOf(r3));
            return;
        }
    }

    public final int getLayoutId() {
        return 2131565371;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    public final void R0() {
        if (this.k == false) goto L5;
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
        com.bytedance.android.live.room.discovery.c r4 = this.l;
        if (r4 == null) goto L17;
        r4.cancel();
    L17:
        com.bytedance.android.live.room.discovery.c r5 = new com.bytedance.android.live.room.discovery.c(this, r3 * ((long) WebcastRedirectException.UNKNOWN));
        this.l = r5;
        r5.start();
        this.k = true;
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
    @Override // com.bytedance.android.live.room.discovery.IAnchorPerMonitorDialog
    public final void Q0() {
        if (isShowing() == true) goto L6;
        return;
    L6:
        if ((!this.d.isEmpty()) == false) goto L25;
        UtilityKotlinExtentionsKt.w(findViewById(2131378817));
        ArrayAdapter<String> r0 = this.h;
        if (r0 == null) goto L10;
        r0.clear();
    L10:
        ArrayAdapter<String> r1 = this.h;
        if (r1 != null) goto L13;
    L17:
        ArrayAdapter<String> r2 = this.h;
        if (r2 == null) goto L20;
        r2.notifyDataSetChanged();
    L20:
        AnchorPerfMonitorDialogDetail r3 = this.i;
        if (r3 == null) goto L27;
        ArrayAdapter<CharSequence> r4 = r3.a;
        if (r4 == null) goto L28;
        r4.notifyDataSetChanged();
        return;
    L28:
        return;
    L27:
        return;
    L13:
        if (this.d.size() <= 1) goto L15;
        List<String> r5 = this.d.subList(0, 2);
    L16:
        r1.addAll(r5);
        goto L17
    L15:
        r5 = this.d.subList(0, 1);
        goto L16
    L25:
        UtilityKotlinExtentionsKt.t(findViewById(2131378817));
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
        com.bytedance.android.live.room.discovery.c r1 = this.l;
        if (r1 == null) goto L20;
        r1.cancel();
    L20:
        this.k = false;
        CommonBottomDialog r2 = this.i;
        if (r2 == null) goto L39;
        Handler r3 = DialogLancet.resolveDialogHandler(r2);
        if (r3 != null) goto L25;
    L27:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L30 Exception -> L32
    L36:
        DialogLancet.afterDialogDismiss(r2);
        return;
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
        return;
    L39:
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

    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        R0();
        Q0();
        M0(this.c, true);
        N0(this.b);
        P0(this.a);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public AnchorPerfMonitorDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.j = new LinkedHashMap();
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
        S0(r6, 2131251268);
    L44:
        TextView r7 = (TextView) findViewById(2131390982);
        if (r7 == null) goto L47;
        r7.setText("Wi-Fi/移动网络良好");
    L47:
        TextView r8 = (TextView) findViewById(2131390983);
        if (r8 == null) goto L57;
        r8.setText("建议不要频繁切换网络");
        return;
    L57:
        return;
    L8:
        if (r5 != 2) goto L10;
        ImageView r9 = (ImageView) findViewById(2131374704);
        if (r9 == null) goto L35;
        S0(r9, 2131251270);
    L35:
        TextView r10 = (TextView) findViewById(2131390982);
        if (r10 == null) goto L38;
        r10.setText("Wi-Fi/移动网络波动");
    L38:
        TextView r12 = (TextView) findViewById(2131390983);
        if (r12 == null) goto L55;
        r12.setText("可能影响开播，请检查网络状态");
        return;
    L55:
        return;
    L10:
        if (r5 != 3) goto L12;
        ImageView r13 = (ImageView) findViewById(2131374704);
        if (r13 == null) goto L26;
        S0(r13, 2131251272);
    L26:
        TextView r14 = (TextView) findViewById(2131390982);
        if (r14 == null) goto L29;
        r14.setText("Wi-Fi/移动网络不佳");
    L29:
        TextView r15 = (TextView) findViewById(2131390983);
        if (r15 == null) goto L53;
        r15.setText("建议切换网络");
        return;
    L53:
        return;
    L12:
        if (r5 != 4) goto L58;
        ImageView r16 = (ImageView) findViewById(2131374704);
        if (r16 == null) goto L17;
        S0(r16, 2131251266);
    L17:
        TextView r17 = (TextView) findViewById(2131390982);
        if (r17 == null) goto L20;
        r17.setText("当前未连接网络");
    L20:
        TextView r18 = (TextView) findViewById(2131390983);
        if (r18 == null) goto L51;
        r18.setText("请检查网络状态");
        return;
    L51:
        return;
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
        S0(r6, 2131251548);
    L33:
        TextView r7 = (TextView) findViewById(2131391566);
        if (r7 == null) goto L36;
        r7.setText("设备温度正常");
    L36:
        TextView r8 = (TextView) findViewById(2131391567);
        if (r8 == null) goto L44;
        r8.setText("建议适时检查，保障流畅开播");
        return;
    L44:
        return;
    L8:
        if (r5 != 2) goto L10;
        ImageView r9 = (ImageView) findViewById(2131374715);
        if (r9 == null) goto L24;
        S0(r9, 2131251549);
    L24:
        TextView r10 = (TextView) findViewById(2131391566);
        if (r10 == null) goto L27;
        r10.setText("设备发热明显");
    L27:
        TextView r12 = (TextView) findViewById(2131391567);
        if (r12 == null) goto L42;
        r12.setText("设备发热，可能影响开播，建议采取降温措施");
        return;
    L42:
        return;
    L10:
        if (r5 != 3) goto L45;
        ImageView r13 = (ImageView) findViewById(2131374715);
        if (r13 == null) goto L15;
        S0(r13, 2131251547);
    L15:
        TextView r14 = (TextView) findViewById(2131391566);
        if (r14 == null) goto L18;
        r14.setText("设备发热严重");
    L18:
        TextView r15 = (TextView) findViewById(2131391567);
        if (r15 == null) goto L40;
        r15.setText("设备发热严重，建议采取降温措施");
        return;
    L40:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        int r9 = b1.a;
        b1.b(true, new AnchorPerfMonitorDialog$initDialogUI$1(this));
        TextView r10 = (TextView) findViewById(2131391256);
        if (r10 == null) goto L5;
        r10.setOnClickListener(new a(this));
    L5:
        ImageView r12 = (ImageView) findViewById(2131371853);
        if (r12 == null) goto L8;
        r12.setOnClickListener(new b(this));
    L8:
        AdjustPercentBar r1 = findViewById(2131363963);
        if (r1 == null) goto L11;
        r1.c(s1.h(2131107027), s1.h(2131107017), s1.h(2131107027));
    L11:
        AdjustPercentBar r2 = findViewById(2131363963);
        if (r2 == null) goto L14;
        r2.b();
    L14:
        AdjustPercentBar r3 = findViewById(2131363963);
        if (r3 == null) goto L17;
        r3.e(100, 1, 100, true);
    L17:
        AdjustPercentBar r0 = findViewById(2131363963);
        Integer r4 = null;
        if (r0 == null) goto L29;
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L24;
        com.bytedance.live.datacontext.j r6 = r5.getLiveStream();
        if (r6 == null) goto L24;
        com.bytedance.android.live.pushstream.d r7 = (com.bytedance.android.live.pushstream.d) r6.getValue();
    L25:
        if (r7 == null) goto L27;
        r7.N0();
        float r13 = 0.0f;
    L28:
        r0.setPercent((int) (r13 * 100));
        goto L29
    L27:
        r13 = 0.01f;
    L24:
        r7 = null;
    L29:
        TextView r14 = (TextView) findViewById(2131375219);
        if (r14 == null) goto L35;
        AdjustPercentBar r15 = findViewById(2131363963);
        if (r15 == null) goto L34;
        r4 = Integer.valueOf(r15.getPercent());
    L34:
        r14.setText(String.valueOf(r4.intValue()));
    L35:
        AdjustPercentBar r16 = findViewById(2131363963);
        if (r16 == null) goto L38;
        r16.setOnLevelChangeListener(new c(this));
    L38:
        this.h = new ArrayAdapter(getContext(), 2131565131);
        ListView r17 = (ListView) findViewById(2131378057);
        if (r17 == null) goto L41;
        r17.setAdapter(this.h);
    L41:
        RelativeLayout r18 = (RelativeLayout) findViewById(2131384695);
        int r19 = 8;
        if (r18 != null) goto L44;
    L48:
        LinearLayout r20 = (LinearLayout) findViewById(2131378621);
        if (r20 != null) goto L51;
        return;
    L51:
        if (this.g == false) goto L53;
        r19 = 0;
    L53:
        r20.setVisibility(r19);
        return;
    L44:
        if (this.g == false) goto L46;
        int r22 = 0;
    L47:
        r18.setVisibility(r22);
        goto L48
    L46:
        r22 = 8;
        goto L47
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.room.discovery.IAnchorPerMonitorDialog
    public final void M0(int r6, boolean r7) {
        this.c = r6;
        if (isShowing() == true) goto L6;
        return;
    L6:
        if (r6 != 5) goto L8;
        ImageView r8 = (ImageView) findViewById(2131374701);
        if (r8 == null) goto L58;
        S0(r8, 2131251230);
    L58:
        TextView r9 = (TextView) findViewById(2131390949);
        if (r9 == null) goto L61;
        r9.setText("已设置静音");
    L61:
        TextView r10 = (TextView) findViewById(2131390950);
        if (r10 == null) goto L64;
        r10.setText("请前往连线设置取消静音");
    L64:
        RelativeLayout r12 = (RelativeLayout) findViewById(2131384695);
        if (r12 == null) goto L67;
        UtilityKotlinExtentionsKt.w(r12);
    L67:
        LinearLayout r13 = (LinearLayout) findViewById(2131378621);
        if (r13 == null) goto L70;
        UtilityKotlinExtentionsKt.t(r13);
    L70:
        ILinkServiceExternal r14 = jc1.k.f(ILinkServiceExternal.class);
        if (r14 == null) goto L75;
        lc0.d r15 = r14.getPkService();
        if (r15 == null) goto L75;
        long r16 = r15.A();
    L77:
        if (r16 <= 0) goto L93;
        R0();
        ImageView r17 = (ImageView) findViewById(2131374701);
        if (r17 == null) goto L81;
        S0(r17, 2131251231);
    L81:
        TextView r18 = (TextView) findViewById(2131390949);
        if (r18 == null) goto L94;
        r18.setText("已被系统静音");
        return;
    L94:
        return;
    L93:
        return;
    L75:
        r16 = 0;
        goto L77
    L8:
        if (r6 != 6) goto L10;
        ImageView r19 = (ImageView) findViewById(2131374701);
        if (r19 == null) goto L46;
        S0(r19, 2131251228);
    L46:
        TextView r20 = (TextView) findViewById(2131390949);
        if (r20 == null) goto L49;
        r20.setText("音频音量过大");
    L49:
        TextView r22 = (TextView) findViewById(2131390950);
        if (r22 == null) goto L52;
        r22.setText("建议调低音量或调整麦克风距离");
    L52:
        LinearLayout r23 = (LinearLayout) findViewById(2131378621);
        if (r23 == null) goto L91;
        UtilityKotlinExtentionsKt.w(r23);
        return;
    L91:
        return;
    L10:
        if (r6 != 7) goto L12;
        ImageView r24 = (ImageView) findViewById(2131374701);
        if (r24 == null) goto L34;
        S0(r24, 2131251226);
    L34:
        TextView r25 = (TextView) findViewById(2131390949);
        if (r25 == null) goto L37;
        r25.setText("无声音输出");
    L37:
        TextView r26 = (TextView) findViewById(2131390950);
        if (r26 == null) goto L40;
        r26.setText("建议检查音频设置");
    L40:
        LinearLayout r27 = (LinearLayout) findViewById(2131378621);
        if (r27 == null) goto L89;
        UtilityKotlinExtentionsKt.t(r27);
        return;
    L89:
        return;
    L12:
        if (r6 != 8) goto L14;
        RelativeLayout r28 = (RelativeLayout) findViewById(2131384695);
        if (r28 == null) goto L87;
        UtilityKotlinExtentionsKt.t(r28);
        return;
    L87:
        return;
    L14:
        if (this.g == true) goto L16;
        return;
    L16:
        ImageView r29 = (ImageView) findViewById(2131374701);
        if (r29 == null) goto L19;
        S0(r29, 2131251232);
    L19:
        TextView r30 = (TextView) findViewById(2131390949);
        if (r30 == null) goto L22;
        r30.setText("音频状态正常");
    L22:
        TextView r32 = (TextView) findViewById(2131390950);
        if (r32 == null) goto L25;
        r32.setText("适当的音量可以保障观众观看体验");
    L25:
        LinearLayout r33 = (LinearLayout) findViewById(2131378621);
        if (r33 == null) goto L85;
        UtilityKotlinExtentionsKt.w(r33);
        return;
    }

    public final void S0(ImageView r4, int r5) {
        if (this.j.containsKey(Integer.valueOf(r5)) == true) goto L5;
        this.j.put(Integer.valueOf(r5), s1.m(r5));
    L5:
        Map<Integer, Drawable> r0 = this.j;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        r4.setImageDrawable((Drawable) r1.get(Integer.valueOf(r5)));
    }
}
