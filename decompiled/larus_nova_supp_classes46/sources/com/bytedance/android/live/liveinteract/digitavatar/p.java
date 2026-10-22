package com.bytedance.android.live.liveinteract.digitavatar;

import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements com.bytedance.android.live.room.g.b {
    public final /* synthetic */ DigitAvatarRecognitionDialog a;

    public static final class a implements Runnable {
        public final /* synthetic */ p a;

        public a(p r1) {
            this.a = r1;
        }

        public final void a() {
            this.a.a.getClass();
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L22;
            DigitAvatarContext.a r0 = DigitAvatarContext.Companion;
            DigitAvatarContext r1 = r0.getContext();
            if (r1 == null) goto L9;
            com.bytedance.live.datacontext.m<Boolean> r2 = r1.isPickImageWithGallery();
            if (r2 == null) goto L9;
            r2.setValue(Boolean.FALSE);
        L9:
            DigitAvatarContext r3 = r0.getContext();
            if (r3 == null) goto L22;
            com.bytedance.live.datacontext.m<Boolean> r4 = r3.isPickImageWidthCamera();
            if (r4 == null) goto L22;
            r4.setValue(Boolean.FALSE);
        L22:
            this.a.a.dismissAllowingStateLoss();     // Catch: Exception -> L17
            return;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L24;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final /* synthetic */ void c() {
    }

    public final /* synthetic */ void e(String r1, String r2, String r3) {
    }

    public final /* synthetic */ void g(String r1, int r2) {
    }

    public final /* synthetic */ void h() {
    }

    public final /* synthetic */ void onError(String r1) {
    }

    public final void onCanceled() {
        int r0 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        com.bytedance.android.live.liveinteract.plantform.utils.x.g("user cancel pick/take photo");
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.k("user cancel pick/take photo");
        DigitAvatarRecognitionDialog r1 = this.a;
        int r2 = DigitAvatarRecognitionDialog.L;
        ((Handler) r1.H.getValue()).post(new a(this));
    }

    public p(DigitAvatarRecognitionDialog r1) {
        this.a = r1;
    }

    public final void b(String r4, String r5, IThemeShowArea r6, ThemeUpLoadListener r7, int r8) {
        this.a.getClass();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L15;
        DigitAvatarContext.a r9 = DigitAvatarContext.Companion;
        DigitAvatarContext r10 = r9.getContext();
        if (r10 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r11 = r10.isPickImageWithGallery();
        if (r11 == null) goto L9;
        r11.setValue(Boolean.FALSE);
    L9:
        DigitAvatarContext r12 = r9.getContext();
        if (r12 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r13 = r12.isPickImageWidthCamera();
        if (r13 == null) goto L15;
        r13.setValue(Boolean.FALSE);
    L15:
        if (this.a.isViewValid() == true) goto L19;
        this.a.U90("image picked, but recognition dialog view invalid");
        return;
    L19:
        if (r4 != null) goto L21;
    L24:
        boolean r14 = true;
    L26:
        if (r14 == false) goto L35;
        ALogger.e("KtvDigitAvatar", "user selected photo path is null or empty");
        f2.b(2131918213, 0);
        int r15 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        com.bytedance.android.live.liveinteract.plantform.utils.x.g("user selected photo path is null or empty");
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.k("user selected photo path is null or empty");
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r16 = DialogFragmentLancet.sLastShowStack;
        if (r16 == null) goto L62;
        com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L62:
        return;
    L35:
        PolarisFileWrapper r17 = new PolarisFileWrapper(r4);
        if (r17.exists() == true) goto L45;
        ALogger.e("KtvDigitAvatar", "user selected photo don't exists in path " + r4);
        f2.b(2131918213, 0);
        int r18 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        com.bytedance.android.live.liveinteract.plantform.utils.x.g("user selected photo don't exists in path " + r4);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.k("user selected photo don't exists in path " + r4);
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L40
        return;
    L40:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r19 = DialogFragmentLancet.sLastShowStack;
        if (r19 == null) goto L64;
        com.bytedance.crash.d.d(r19, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L64:
        return;
    L45:
        DigitAvatarRecognitionDialog r20 = this.a;
        r20.E = r17;
        LinearLayout r21 = r20.o;
        if (r21 == null) goto L48;
        UtilityKotlinExtentionsKt.w(r21);
    L48:
        boolean r22 = tb1.d.a;
        LiveDoubleColorBallAnimationView r23 = r20.p;
        if (r23 == null) goto L51;
        UtilityKotlinExtentionsKt.w(r23);
    L51:
        LiveDoubleColorBallAnimationView r24 = r20.p;
        if (r24 == null) goto L54;
        r24.b();
    L54:
        r20.U90("image picked, but not ready. so waiting for ready");
        TextView r25 = r20.q;
        if (r25 == null) goto L66;
        r25.setText(2131918221);
        return;
    L66:
        return;
    L21:
        if (r4.length() == 0) goto L24;
        r14 = false;
        goto L26
    }
}
