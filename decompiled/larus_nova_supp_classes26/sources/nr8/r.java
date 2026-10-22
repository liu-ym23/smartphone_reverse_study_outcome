package nr8;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.model.NotificationType;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import hq9.e4;
import hq9.n3;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r extends b {
    public final n3 g;

    @Override // nr8.b
    public final void b() {
        setContentView(2131562087);
    }

    public static void c(r r3) {
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

    @Override // nr8.b, android.app.Dialog
    public final void onCreate(Bundle r15) {
        super.onCreate(r15);
        FLogger r16 = FLogger.a;
        r16.i("NotificationDialog", "show");
        final n3 r1 = this.g;
        CardView r2 = (ViewGroup) findViewById(2131381043);
        TitleAvatarImageView r3 = findViewById(2131363623);
        TextView r4 = (TextView) findViewById(2131388772);
        TextView r5 = (TextView) findViewById(2131367794);
        final ImageView r6 = (ImageView) findViewById(2131372297);
        final ImageView r7 = (ImageView) findViewById(2131372281);
        TextView r8 = (TextView) findViewById(2131391311);
        String r9 = r1.b;
        boolean r11 = false;
        if (r9.length() <= 0) goto L5;
        boolean r10 = true;
    L6:
        final Function0 r13 = null;
        if (r10 == true) goto L10;
        r9 = null;
    L10:
        if (r9 != null) goto L12;
        Intrinsics.checkNotNull(r3);
        e1.o(r3);
    L21:
        String r12 = r1.d;
        if (r12.length() <= 0) goto L24;
        boolean r14 = true;
    L25:
        if (r14 == true) goto L28;
        r12 = null;
    L28:
        if (r12 != null) goto L30;
        Intrinsics.checkNotNull(r4);
        e1.o(r4);
    L38:
        String r17 = r1.e;
        if (r17.length() <= 0) goto L41;
        boolean r18 = true;
    L42:
        if (r18 == true) goto L45;
        r17 = null;
    L45:
        if (r17 == null) goto L47;
        r5.setText(r17);
        Intrinsics.checkNotNull(r5);
        e1.x(r5);
    L49:
        if (r1.r == null) goto L52;
        e1.d(r2, new m(r1, this));
    L52:
        if (r1.j == null) goto L73;
        if (r1.getType() != NotificationType.FEEDBACK) goto L73;
        r16.i("NotificationDialog", "feedbackUseDark = " + this.b);
        if (this.b == false) goto L65;
        if ((r2 instanceof CardView) == false) goto L60;
        CardView r19 = r2;
    L61:
        if (r19 == null) goto L63;
        r19.setCardBackgroundColor(getContext().getResources().getColor(2131102551));
    L63:
        r6.setBackgroundResource(2131239356);
        r7.setBackgroundResource(2131239356);
        r6.setImageResource(2131241487);
        r7.setImageResource(2131241191);
    L71:
        Intrinsics.checkNotNull(r6);
        e1.x(r6);
        Intrinsics.checkNotNull(r7);
        e1.x(r7);
        e1.d(r6, new n(r6, r1, this));
        e1.d(r7, new o(r7, r1, this));
    L78:
        e4 r110 = r1.k;
        if (r110 != null) goto L81;
    L83:
        boolean r0 = false;
    L84:
        if (r0 == false) goto L112;
        final String r20 = "";
        if (r110 == null) goto L89;
        String r111 = r110.c;
        if (r111 == null) goto L89;
    L91:
        if (r111.length() <= 0) goto L93;
        boolean r21 = true;
    L94:
        if (r21 == false) goto L96;
        r8.setText(r111);
        Intrinsics.checkNotNull(r8);
        e1.x(r8);
        Intrinsics.checkNotNull(r7);
        e1.o(r7);
        Intrinsics.checkNotNull(r6);
        e1.o(r6);
    L97:
        e4 r112 = r1.k;
        if (r112 == null) goto L100;
        r13 = r112.d;
    L100:
        if (r112 == null) goto L105;
        String r113 = r112.b;
        if (r113 == null) goto L105;
        r20 = r113;
    L105:
        if (r13 == null) goto L108;
        e1.d(r8, new p(r13, this));
    L113:
        t0.a.postDelayed(this.f, r1.g);
        return;
    L108:
        if (r20.length() <= 0) goto L110;
        r11 = true;
    L110:
        if (r11 == false) goto L113;
        e1.d(r8, new q(r20, this));
        goto L113
    L96:
        Intrinsics.checkNotNull(r8);
        e1.o(r8);
        goto L97
    L93:
        r21 = false;
    L89:
        r111 = "";
        goto L91
    L112:
        Intrinsics.checkNotNull(r8);
        e1.o(r8);
        goto L113
    L81:
        if (r110.a != true) goto L83;
        r0 = true;
        goto L84
    L60:
        r19 = null;
        goto L61
    L65:
        if ((r2 instanceof CardView) == false) goto L67;
        CardView r22 = r2;
    L68:
        if (r22 == null) goto L70;
        r22.setCardBackgroundColor(getContext().getResources().getColor(2131102551));
    L70:
        r6.setBackgroundResource(2131239355);
        r7.setBackgroundResource(2131239355);
        r6.setImageResource(2131241486);
        r7.setImageResource(2131241190);
        goto L71
    L67:
        r22 = null;
    L73:
        if (r1.getType() != NotificationType.AWEME_FEED) goto L76;
        Intrinsics.checkNotNull(r6);
        e1.o(r6);
        Intrinsics.checkNotNull(r7);
        e1.o(r7);
        goto L78
    L76:
        if (r1.getType() != NotificationType.QUOTA_LIMIT) goto L78;
        Intrinsics.checkNotNull(r6);
        e1.o(r6);
        Intrinsics.checkNotNull(r7);
        e1.o(r7);
        Intrinsics.checkNotNull(r8);
        e1.o(r8);
        goto L78
    L47:
        Intrinsics.checkNotNull(r5);
        e1.o(r5);
        goto L49
    L41:
        r18 = false;
        goto L42
    L30:
        if (r1.e.length() <= 0) goto L32;
        boolean r23 = true;
    L33:
        if (r23 == false) goto L35;
        int r24 = 1;
    L36:
        r4.setMaxLines(r24);
        r4.setText(r12);
        Intrinsics.checkNotNull(r4);
        e1.x(r4);
        goto L38
    L35:
        r24 = 10;
        goto L36
    L32:
        r23 = false;
        goto L33
    L24:
        r14 = false;
        goto L25
    L12:
        if (r1.c == false) goto L16;
        RoundingParams r114 = r3.getHierarchy().getRoundingParams();
        if (r114 == null) goto L19;
        r114.setRoundAsCircle(true);
    L19:
        ImageLoaderKt.u(r3, r9, "notification");
        Intrinsics.checkNotNull(r3);
        e1.x(r3);
        goto L21
    L16:
        RoundingParams r115 = r3.getHierarchy().getRoundingParams();
        if (r115 == null) goto L19;
        r115.setRoundAsCircle(false);
        goto L19
    L5:
        r10 = false;
        goto L6
    }

    public r(Context r2, n3 r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "request");
        super(r2, r3);
        this.g = r3;
    }
}
