package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorWindowV2;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiMicPanelIcon;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerKickOutContent;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/dialog/MediaMultiLinkAnchorMicDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", BuildConfig.FLAVOR, "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLinkAnchorMicDialog extends CommonBottomDialog implements q46.a {
    public static final /* synthetic */ int f = 0;
    public u82.m a;
    public final String b;
    public final String c;
    public final DataCenter d;
    public final int e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MediaMultiLinkAnchorMicDialog a;

        public b(MediaMultiLinkAnchorMicDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            x82.b.u2.getClass();
            x82.b r5 = x82.b.a.a();
            if (r5 == null) goto L5;
            r5.Z8(this.a.b, LinkerKickOutContent.KickOutSource.FromOrganizer);
        L5:
            q46.a r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L8;
        L10:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L13 Exception -> L15
        L19:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L13:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r1 == null) goto L19;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
            goto L19
        L8:
            if (Looper.myLooper() == r0.getLooper()) goto L10;
            r0.post(DialogLancet.createDismissRunnable(r6));
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566918;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u82.m r0 = this.a;
        if (r0 == null) goto L6;
        r0.detachView();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r11 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        if (r11 == null) goto L7;
        hy.e r13 = r11.Np();
        if (r13 == null) goto L7;
        AnchorLinkUser r14 = r13.getGuestInfo(this.b, null);
    L8:
        if (r14 == null) goto L13;
        IBaseUser r15 = r14.getUser();
        if (r15 == null) goto L13;
        String r16 = r15.getNickName();
        if (r16 == null) goto L13;
    L15:
        if (r16.length() <= 12) goto L17;
        r16 = r16.substring(0, 11) + "...";
    L17:
        TextView r1 = (TextView) findViewById(2131389658);
        if (r1 == null) goto L20;
        r1.setText(getContext().getString(2131920318, new Object[]{r16}));
    L20:
        x82.d.z2.getClass();
        x82.d r17 = x82.d.a.a();
        if (r17 != null) goto L23;
    L25:
        final boolean r18 = false;
    L27:
        if (e92.m.e() == false) goto L34;
        int r2 = e92.d.a;
        if (e92.m.h() != 4) goto L31;
        boolean r3 = true;
    L32:
        if (r3 == false) goto L34;
        boolean r4 = true;
    L36:
        if (r4 == false) goto L48;
        LinearLayout r5 = (LinearLayout) findViewById(2131389657);
        if (r5 == null) goto L48;
        MediaMultiMicPanelIcon r6 = new MediaMultiMicPanelIcon(getContext(), null, 6, 0);
        if (r18 == false) goto L42;
        int r7 = 2131920306;
    L43:
        r6.setDesc(s1.B(r7));
        if (r18 == false) goto L46;
        int r8 = 2131252428;
    L47:
        r6.setIcon(r8);
        r6.setOnClick(new MediaMultiLinkAnchorMicDialog$onCreate$$inlined$apply$lambda$1(this, r18));
        Unit r19 = Unit.INSTANCE;
        r5.addView(r6);
        goto L48
    L46:
        r8 = 2131252430;
        goto L47
    L42:
        r7 = 2131920308;
    L48:
        x82.b.u2.getClass();
        x82.b r110 = x82.b.a.a();
        if (r110 == null) goto L51;
        final com.bytedance.android.livesdk.interactivity.medialink.ui.m r111 = r110.getMuteManager();
    L52:
        if (r111 != null) goto L54;
    L56:
        final boolean r9 = false;
    L57:
        LinearLayout r20 = (LinearLayout) findViewById(2131389657);
        if (r20 == null) goto L68;
        MediaMultiMicPanelIcon r21 = new MediaMultiMicPanelIcon(getContext(), null, 6, 0);
        if (r9 == false) goto L62;
        String r23 = s1.B(2131920320);
    L63:
        r21.setDesc(r23);
        if (r9 == false) goto L66;
        int r24 = 2131252438;
    L67:
        r21.setIcon(r24);
        r21.setOnClick(new MediaMultiLinkAnchorMicDialog$onCreate$$inlined$apply$lambda$2(this, r9, r111));
        Unit r112 = Unit.INSTANCE;
        r20.addView(r21);
        goto L68
    L66:
        r24 = 2131252433;
        goto L67
    L62:
        r23 = s1.B(2131920316);
    L68:
        int r113 = this.e;
        int r25 = MediaMultiAnchorWindowV2.I;
        if (r113 != 0) goto L71;
    L85:
        LinearLayout r114 = (LinearLayout) findViewById(2131389657);
        if (r114 == null) goto L89;
        MediaMultiMicPanelIcon r26 = new MediaMultiMicPanelIcon(getContext(), null, 6, 0);
        r26.setDesc(s1.B(2131920321));
        r26.setIcon(2131252440);
        r26.setOnClick(new MediaMultiLinkAnchorMicDialog$onCreate$$inlined$apply$lambda$4(this));
        Unit r0 = Unit.INSTANCE;
        r114.addView(r26);
    L89:
        if (e92.m.e() == false) goto L96;
        TextView r27 = (TextView) findViewById(2131389659);
        if (r27 == null) goto L93;
        r27.setOnClickListener(new b(this));
    L93:
        TextView r115 = (TextView) findViewById(2131389659);
        if (r115 == null) goto L96;
        UtilityKotlinExtentionsKt.z(r115, true);
    L96:
        u82.m r116 = new u82.m();
        this.a = r116;
        ((q46.b) r116).a = this;
        if (this.e != 0) goto L101;
        String r28 = this.b;
        MediaMultiLinkAnchorMicDialog$tryQueryUser$1 r29 = new MediaMultiLinkAnchorMicDialog$tryQueryUser$1(this);
        Intrinsics.checkNotNullParameter(r28, "uid");
        Intrinsics.checkNotNullParameter(r29, "onSuccess");
        RxUtilKt.c(jc1.k.n(IUserService.class).user().r(r28).map(u82.j.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new u82.k(r29), u82.l.a), r116.b);
        return;
    L101:
        return;
    L71:
        if (r113 != 2) goto L73;
        final boolean r117 = true;
    L74:
        LinearLayout r30 = (LinearLayout) findViewById(2131389657);
        if (r30 == null) goto L85;
        MediaMultiMicPanelIcon r31 = new MediaMultiMicPanelIcon(getContext(), null, 6, 0);
        if (r117 == false) goto L79;
        String r33 = s1.B(2131920319);
    L80:
        r31.setDesc(r33);
        if (r117 == false) goto L83;
        int r34 = 2131252436;
    L84:
        r31.setIcon(r34);
        r31.setOnClick(new MediaMultiLinkAnchorMicDialog$onCreate$$inlined$apply$lambda$3(this, r117));
        Unit r118 = Unit.INSTANCE;
        r30.addView(r31);
        goto L85
    L83:
        r34 = 2131252431;
        goto L84
    L79:
        r33 = s1.B(2131920313);
        goto L80
    L73:
        r117 = false;
        goto L74
    L54:
        if (r111.e(this.b, this.c) != true) goto L56;
        r9 = true;
        goto L57
    L51:
        r111 = null;
        goto L52
    L31:
        r3 = false;
    L34:
        r4 = false;
        goto L36
    L23:
        if (r17.x5(this.b) != true) goto L25;
        r18 = true;
    L13:
        r16 = BuildConfig.FLAVOR;
    L7:
        r14 = null;
        goto L8
    }

    public MediaMultiLinkAnchorMicDialog(Context r2, String r3, String r4, DataCenter r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r4, "linkerID");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        super(r2);
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
