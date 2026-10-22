package com.bytedance.android.live.livepkaudience.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.utils.HostEnv;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.au0;
import com.bytedance.android.livesdk.config.lg1;
import com.bytedance.android.livesdk.config.uq;
import com.bytedance.android.livesdk.config.zg1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkWithAudienceSettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Landroidx/fragment/app/FragmentActivity;", "i", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkWithAudienceSettingDialog extends CommonBottomDialog {
    public static final /* synthetic */ int k = 0;
    public final CompositeDisposable a;
    public final Animation b;
    public final Animation c;
    public final Animation d;
    public final Animation e;
    public RoomContext f;
    public final Map<String, Boolean> g;
    public final Room h;
    public final FragmentActivity i;
    public final boolean j;

    public static final class a {
    }

    public static final class b implements Animation.AnimationListener {
        public final /* synthetic */ PkWithAudienceSettingDialog a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public b(PkWithAudienceSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r4) {
            CommonBottomDialog r5 = this.a;
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

    public final int getLayoutId() {
        return 2131565535;
    }

    static {
    }

    public final void M0() {
        this.e.setDuration(250);
        Animation r0 = this.e;
        if (r0 == null) goto L5;
        ((LinearLayout) findViewById(2131385978)).startAnimation(r0);
    L5:
        this.e.setAnimationListener(new b(this));
        Animation r1 = this.c;
        if (r1 == null) goto L8;
        findViewById(2131381758).startAnimation(r1);
    L8:
        ((LinkedHashMap) this.g).clear();
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.dispose();
    }

    public final FragmentActivity getActivity() {
        return this.i;
    }

    public final void onBackPressed() {
        M0();
    }

    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        this.d.setDuration(250);
        Animation r9 = this.d;
        if (r9 == null) goto L5;
        ((LinearLayout) findViewById(2131385978)).startAnimation(r9);
    L5:
        Animation r10 = this.b;
        if (r10 == null) goto L8;
        findViewById(2131381758).startAnimation(r10);
    L8:
        this.b.setFillAfter(true);
        Map<String, Boolean> r11 = this.g;
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.c.q1;
        r11.put(r2.getName(), (Boolean) r2.getValue());
        findViewById(2131381758).setOnClickListener(x0.a(new AnonymousClass1(this)));
        if (((Boolean) uq.a.getValue()).booleanValue() == false) goto L15;
        ((FrameLayout) findViewById(2131372814)).setVisibility(0);
        TextView r12 = (TextView) findViewById(2131390821);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.t1.getValue()).booleanValue() == false) goto L13;
        String r4 = s1.B(2131917699);
    L14:
        r12.setText(r4);
        ((FrameLayout) findViewById(2131372814)).setOnClickListener(x0.a(new AnonymousClass2(this)));
    L16:
        this.f = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        Switch r3 = (Switch) findViewById(2131382369);
        if (r3 == null) goto L19;
        r3.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.u1.getValue()).booleanValue());
    L19:
        FrameLayout r5 = (FrameLayout) findViewById(2131382373);
        if (r5 == null) goto L22;
        r5.setOnClickListener(x0.a(new AnonymousClass3(this)));
    L22:
        lg1 r6 = lg1.a;
        if (((zg1) r6.getValue()).allowSendGiftToLinker == true) goto L25;
    L52:
        RelativeLayout r13 = (RelativeLayout) findViewById(2131382340);
        if (r13 == null) goto L55;
        r13.setVisibility(8);
    L55:
        FrameLayout r1 = (FrameLayout) findViewById(2131382368);
        if (r1 == null) goto L58;
        r1.setVisibility(0);
    L58:
        FrameLayout r14 = (FrameLayout) findViewById(2131382368);
        if (r14 == null) goto L62;
        r14.setOnClickListener(x0.a(new PkWithAudienceSettingDialog$initAdminOperation$1(this)));
        return;
    L62:
        return;
    L25:
        if (((zg1) r6.getValue()).bigPartySwitch == false) goto L52;
        RelativeLayout r7 = (RelativeLayout) findViewById(2131382340);
        if (r7 == null) goto L30;
        r7.setVisibility(0);
    L30:
        if (((Boolean) au0.a.getValue()).booleanValue() == true) goto L32;
    L45:
        boolean r15 = false;
    L46:
        if (r15 == false) goto L48;
        ((ImageView) findViewById(2131382341)).setVisibility(0);
        int r16 = el0.j.b;
        Intrinsics.checkNotNullParameter(PbRequest.SwitchType.GIFT, "requestPage");
        final LinkedHashMap r17 = new LinkedHashMap();
        el0.j.k(r17);
        el0.j.m(r17);
        r17.put("request_page", PbRequest.SwitchType.GIFT);
        r17.put("pk_id", String.valueOf(jc1.k.n(ILinkServiceExternal.class).getMultiDataHolder().getPkId()));
        r17.put("is_in_pk", "1");
        el0.j.n(r17, Integer.valueOf(dl0.n.a()));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_audience_connection_profit_info_show", r17, new Object[]{Room.class});
        ((ImageView) findViewById(2131382341)).setOnClickListener(x0.a(new AnonymousClass4(this, r17)));
    L48:
        Switch r18 = (Switch) findViewById(2131382369);
        if (r18 == null) goto L51;
        r18.setClickable(false);
    L51:
        ((FrameLayout) findViewById(2131382370)).setOnClickListener(x0.a(new AnonymousClass5(this)));
        goto L55
    L32:
        if (HostEnv.b() == false) goto L34;
    L35:
        RoomContext r19 = this.f;
        if (r19 == null) goto L42;
        com.bytedance.live.datacontext.i r20 = r19.isAnchor();
        if (r20 == null) goto L42;
        Boolean r21 = (Boolean) r20.getValue();
        if (r21 == null) goto L42;
        boolean r22 = r21.booleanValue();
    L43:
        if (r22 == false) goto L45;
        r15 = true;
    L42:
        r22 = false;
        goto L43
    L34:
        if (HostEnv.c() == false) goto L45;
    L13:
        r4 = s1.B(2131917700);
        goto L14
    L15:
        ((FrameLayout) findViewById(2131372814)).setVisibility(8);
        goto L16
    }

    public PkWithAudienceSettingDialog(Room r2, Context r3, FragmentActivity r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.h = r2;
        this.i = r4;
        this.j = r5;
        this.a = new CompositeDisposable();
        this.b = AnimationUtils.loadAnimation(r3, 2130772762);
        this.c = AnimationUtils.loadAnimation(r3, 2130772763);
        this.d = AnimationUtils.loadAnimation(r3, 2130772764);
        this.e = AnimationUtils.loadAnimation(r3, 2130772765);
        this.g = new LinkedHashMap();
    }
}
