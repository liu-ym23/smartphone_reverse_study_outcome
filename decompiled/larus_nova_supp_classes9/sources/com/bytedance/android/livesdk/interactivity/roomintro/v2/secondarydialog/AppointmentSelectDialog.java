package com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.interactivity.api.settings.config.o;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.message.AppointmentInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomintro/v2/secondarydialog/AppointmentSelectDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppointmentSelectDialog extends LiveDialogFragment {
    public static final /* synthetic */ int l = 0;
    public RoomIntroDataSource d;
    public Integer e;
    public View f;
    public LiveSwitchButton g;
    public TextView h;
    public TextView i;
    public HSImageView j;
    public View k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AppointmentSelectDialog a;

        public b(AppointmentSelectDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            this.a.dismiss();     // Catch: Exception -> L5
        L9:
            AppointmentSelectDialog r9 = this.a;
            int r0 = AppointmentSelectDialog.l;
            r9.getClass();
            g r1 = u.l();
            Pair[] r2 = new Pair[4];
            RoomIntroDataSource r3 = r9.d;
            String r4 = BuildConfig.FLAVOR;
            if (r3 == null) goto L14;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r5 = r3.n;
            if (r5 == null) goto L14;
            String r6 = r5.c();
        L15:
            r2[0] = TuplesKt.to("live_type", r6);
            RoomIntroDataSource r7 = r9.d;
            if (r7 == null) goto L22;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r10 = r7.n;
            if (r10 == null) goto L22;
            String r11 = r10.a();
            if (r11 == null) goto L22;
            r4 = r11;
        L22:
            r2[1] = TuplesKt.to("anchor_id", r4);
            LiveSwitchButton r13 = r9.g;
            if (r13 != null) goto L25;
        L27:
            String r14 = "close";
        L28:
            r2[2] = TuplesKt.to("status", r14);
            RoomIntroDataSource r15 = r9.d;
            Long r16 = null;
            if (r15 == null) goto L33;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r17 = r15.n;
            if (r17 == null) goto L33;
            Long r18 = r17.d();
        L34:
            if (r18 == null) goto L45;
            RoomIntroDataSource r19 = r9.d;
            if (r19 == null) goto L40;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r20 = r19.n;
            if (r20 == null) goto L40;
            r16 = r20.d();
        L40:
            if (r16 != null) goto L43;
        L44:
            String r21 = "live_take_detail";
        L46:
            r2[3] = TuplesKt.to("event_page", r21);
            r1.sendLog("livesdk_live_room_detail_announce_info_popup_back", MapsKt.mutableMapOf(r2), new Object[0]);
            return;
        L43:
            if (r16.longValue() != 0) goto L44;
        L45:
            r21 = "live_take_page";
        L33:
            r18 = null;
            goto L34
        L25:
            if (r13.isChecked() != true) goto L27;
            r14 = "open";
        L14:
            r6 = BuildConfig.FLAVOR;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r23 = DialogFragmentLancet.sLastShowStack;
            if (r23 == null) goto L9;
            d.d(r23, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    static {
    }

    public AppointmentSelectDialog() {
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setGravity(80);
        r5.setLayout(-1, -2);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954638);
        setShouldUseNewPanel(true);
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        View r7 = this.f;
        if (r7 == null) goto L9;
        Integer r0 = this.e;
        if (r0 == null) goto L7;
        int r1 = r0.intValue();
    L8:
        a1.k(r7, Math.max(466, r1));
        goto L9
    L7:
        r1 = 0;
    L9:
        LiveSwitchButton r8 = this.g;
        if (r8 == null) goto L12;
        r8.setOnCheckedChangeListener(new com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog.a(this));
    L12:
        RoomIntroDataSource r9 = this.d;
        if (r9 == null) goto L19;
        PropertyOwner r10 = r9.l;
        if (r10 == null) goto L19;
        Boolean r11 = (Boolean) r10.a;
        if (r11 == null) goto L19;
        boolean r13 = r11.booleanValue();
    L20:
        LiveSwitchButton r2 = this.g;
        if (r2 == null) goto L23;
        boolean r3 = r2.isChecked();
    L24:
        if (r13 == r3) goto L28;
        LiveSwitchButton r14 = this.g;
        if (r14 == null) goto L28;
        r14.f(false, false);
    L28:
        int r15 = s1.y() - UtilityKotlinExtentionsKt.i(40);
        RoomIntroDataSource r16 = this.d;
        if (r16 == null) goto L31;
        double r4 = ((double) ((o) r16.b.getValue()).b()) / ((double) ((o) r16.b.getValue()).d());
    L32:
        int r17 = (int) (r4 * ((double) r15));
        HSImageView r18 = this.j;
        if (r18 == null) goto L35;
        a1.k(r18, r17);
    L35:
        HSImageView r19 = this.j;
        if (r19 == null) goto L38;
        a1.p(r19, r15);
    L38:
        HSImageView r20 = this.j;
        RoomIntroDataSource r21 = this.d;
        String r23 = null;
        if (r21 == null) goto L43;
        String r24 = ((o) r21.b.getValue()).c();
        if (r24 != null) goto L44;
        r24 = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/webcast/webcast_room_intro_appointment_preview.png";
    L44:
        ImageLoader.bindImage(r20, r24);
        TextView r25 = this.i;
        if (r25 == null) goto L53;
        RoomIntroDataSource r26 = this.d;
        if (r26 == null) goto L51;
        String r27 = ((o) r26.b.getValue()).e();
        if (r27 != null) goto L52;
        r27 = "开启后，当前设置的预告会展示在直播间介绍，观众可点击预约你的直播";
    L52:
        r25.setText(r27);
        goto L53
    L51:
        r27 = null;
    L53:
        TextView r28 = this.h;
        if (r28 == null) goto L63;
        RoomIntroDataSource r29 = this.d;
        if (r29 == null) goto L62;
        AppointmentInfo r30 = r29.o.b();
        if (r30 == null) goto L61;
        r23 = r30.getScheduledTimeText();
        if (r23 != null) goto L62;
    L61:
        r23 = BuildConfig.FLAVOR;
    L62:
        r28.setText(r23);
    L63:
        View r31 = this.k;
        if (r31 == null) goto L67;
        r31.setOnClickListener(new b(this));
        return;
    L67:
        return;
    L43:
        r24 = null;
        goto L44
    L31:
        r4 = 0.5283582089552239d;
        goto L32
    L23:
        r3 = false;
    L19:
        r13 = false;
        goto L20
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565389, r3, false);
        this.f = r5;
        this.g = r5.findViewById(2131363213);
        this.h = (TextView) r5.findViewById(2131363206);
        this.i = (TextView) r5.findViewById(2131363209);
        this.j = r5.findViewById(2131363208);
        this.k = r5.findViewById(2131363207);
        return r5;
    }
}
