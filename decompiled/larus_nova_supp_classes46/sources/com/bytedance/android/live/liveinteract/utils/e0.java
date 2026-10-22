package com.bytedance.android.live.liveinteract.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0 {
    public static final SimpleDateFormat a = null;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ o5 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ IBanUser c;

        public a(o5 r1, Context r2, IBanUser r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            String r5 = this.c.getUrl();
            if (r5 == null) goto L25;
            u30.b r6 = jc1.k.n(IBaseBrowserService.class).buildFullScreenWebPage(this.b, r5);
            Resources r0 = this.b.getResources();
            if (r0 == null) goto L7;
            String r1 = r0.getString(2131915260);
        L8:
            u30.a r7 = r6.setTitle(r1);
            r7.b = true;
            r7.b();
            o5 r8 = this.a;
            Handler r2 = DialogLancet.resolveDialogHandler(r8);
            if (r2 != null) goto L11;
        L13:
            DialogLancet.beforeDialogDismiss(r8);
            r8.dismiss();     // Catch: Throwable -> L16 Exception -> L18
        L22:
            DialogLancet.afterDialogDismiss(r8);
            return;
        L16:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r8);
            throw th;
        L18:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
            Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
            if (r3 == null) goto L22;
            com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
            goto L22
        L11:
            if (Looper.myLooper() == r2.getLooper()) goto L13;
            r2.post(DialogLancet.createDismissRunnable(r8));
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ o5 a;

        public b(o5 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            o5 r5 = this.a;
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

    static {
        a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static void a(o5 r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static String b(int r5, com.bytedance.android.live.network.response.e r6) {
        return s1.C(r5, new Object[]{a.format(new Date(((long) 1000) * (((bf2.a) r6.data).getBanTime() + ((bf2.a) r6.data).getBanDuration())))});
    }

    public static void c(Context r8, com.bytedance.android.live.network.response.e r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "latestBanRecord");
        Intrinsics.checkNotNullParameter(r10, "banType");
        if (r8 != null) goto L6;
        return;
    L6:
        if (((bf2.a) r9.data).isBannedForever() == false) goto L8;
        String r0 = "";
    L9:
        o5 r1 = new o5(r8);
        TextView r2 = r1.b;
        String r3 = null;
        if (r2 == null) goto L16;
        Resources r4 = r8.getResources();
        if (r4 == null) goto L14;
        String r5 = r4.getString(2131917454);
    L15:
        r2.setText(r5);
        goto L16
    L14:
        r5 = null;
    L16:
        TextView r6 = r1.c;
        if (r6 == null) goto L19;
        r6.setText(r0);
    L19:
        TextView r7 = r1.c;
        if (r7 == null) goto L22;
        UtilityKotlinExtentionsKt.z(r7, !StringsKt.isBlank(r0));
    L22:
        String r11 = ((bf2.a) r9.data).getBanDetailText();
        TextView r12 = r1.d;
        if (r12 != null) goto L25;
    L32:
        View r13 = r1.a;
        if (r13 == null) goto L35;
        r13.setOnClickListener(new z(r1, r8, r9, r10));
    L35:
        Button r14 = r1.f;
        if (r14 == null) goto L42;
        Resources r15 = r8.getResources();
        if (r15 == null) goto L40;
        String r16 = r15.getString(2131917832);
    L41:
        r14.setText(r16);
        goto L42
    L40:
        r16 = null;
    L42:
        Button r17 = r1.f;
        if (r17 == null) goto L45;
        r17.setOnClickListener(new a0(r1, r10));
    L45:
        String r18 = ((bf2.a) r9.data).getAppealUrl();
        if (r18 == null) goto L57;
        String r19 = UriProtector.getQueryParameter(UriProtector.parse(r18), "url");
        if (r19 == null) goto L59;
        String r20 = UriProtector.parse(r19).buildUpon().appendQueryParameter("enter_from", "link_popup").build().toString();
        Uri r21 = UriProtector.parse(r18);
        Uri.Builder r22 = r21.buildUpon().clearQuery();
        Iterator r23 = UriProtector.getQueryParameterNames(r21).iterator();
    L52:
        if (r23.hasNext() == false) goto L56;
        String r24 = (String) r23.next();
        if ((!Intrinsics.areEqual(r24, "url")) == false) goto L52;
        r22.appendQueryParameter(r24, UriProtector.getQueryParameter(r21, r24));
        goto L52
    L56:
        r22.appendQueryParameter("url", r20);
        r18 = r22.build().toString();
    L59:
        if (TextUtils.isEmpty(r18) == false) goto L66;
        Button r25 = r1.g;
        if (r25 == null) goto L63;
        r25.setVisibility(8);
    L63:
        TextView r26 = r1.h;
        if (r26 == null) goto L75;
        r26.setVisibility(8);
    L75:
        a(r1);
        HashMap r27 = new HashMap();
        r27.put("ban_type", r10);
        com.bytedance.android.livesdk.log.j0.l().sendLog("audience_ban_feature_disable_popup_show", r27, new Object[0]);
        return;
    L66:
        Button r28 = r1.g;
        if (r28 == null) goto L72;
        Resources r29 = r8.getResources();
        if (r29 == null) goto L71;
        r3 = r29.getString(2131917831);
    L71:
        r28.setText(r3);
    L72:
        Button r30 = r1.g;
        if (r30 == null) goto L75;
        r30.setOnClickListener(new b0(r1, r18, r10));
        goto L75
    L57:
        r18 = null;
        goto L59
    L25:
        if (TextUtils.isEmpty(r11) == false) goto L31;
        Resources r31 = r8.getResources();
        if (r31 == null) goto L30;
        r11 = r31.getString(2131915262);
        goto L31
    L30:
        r11 = null;
    L31:
        r12.setText(r11);
        goto L32
    L8:
        r0 = b(2131917791, r9);
        goto L9
    }

    public static void d(Context r5, IBanUser r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "banUser");
        ALogger.e("ttlive_link", "showAudienceLinkBanDialog " + r6);
        o5 r0 = new o5(r5);
        TextView r1 = r0.b;
        String r2 = null;
        if (r1 == null) goto L9;
        Resources r3 = r5.getResources();
        if (r3 == null) goto L7;
        String r4 = r3.getString(2131917804);
    L8:
        r1.setText(r4);
        goto L9
    L7:
        r4 = null;
    L9:
        TextView r8 = r0.c;
        if (r8 == null) goto L16;
        if (r7 == false) goto L13;
        String r9 = r6.getAnchorExplain();
    L14:
        r8.setText(r9);
        goto L16
    L13:
        r9 = r6.getAudienceExplain();
    L16:
        if (r7 == true) goto L18;
    L36:
        TextView r10 = r0.d;
        if (r10 == null) goto L39;
        r10.setVisibility(8);
    L39:
        View r11 = r0.e;
        if (r11 == null) goto L42;
        r11.setVisibility(8);
    L42:
        Button r12 = r0.f;
        if (r12 == null) goto L48;
        Resources r13 = r5.getResources();
        if (r13 == null) goto L47;
        r2 = r13.getString(2131918183);
    L47:
        r12.setText(r2);
    L48:
        Button r14 = r0.g;
        if (r14 == null) goto L51;
        r14.setVisibility(8);
    L51:
        TextView r15 = r0.h;
        if (r15 == null) goto L54;
        r15.setVisibility(8);
    L54:
        Button r16 = r0.f;
        if (r16 == null) goto L57;
        r16.setOnClickListener(new b(r0));
    L57:
        a(r0);
        return;
    L18:
        if (TextUtils.isEmpty(r6.getUrl()) == true) goto L36;
        TextView r17 = r0.d;
        if (r17 == null) goto L23;
        r17.setVisibility(0);
    L23:
        View r18 = r0.e;
        if (r18 == null) goto L26;
        r18.setVisibility(0);
    L26:
        TextView r19 = r0.d;
        if (r19 == null) goto L33;
        Resources r20 = r5.getResources();
        if (r20 == null) goto L31;
        String r21 = r20.getString(2131915262);
    L32:
        r19.setText(r21);
        goto L33
    L31:
        r21 = null;
    L33:
        View r22 = r0.a;
        if (r22 == null) goto L42;
        r22.setOnClickListener(new a(r0, r5, r6));
        goto L42
    }
}
