package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.UserType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerFollowStrongGuideContent;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/LinkUserFollowGuideDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkUserFollowGuideDialog extends CommonBottomDialog {
    public static final /* synthetic */ int h = 0;
    public String a;
    public final int b;
    public final CompositeDisposable c;
    public final LifecycleOwner d;
    public final ILinkerFollowStrongGuideContent e;
    public final gd0.u f;
    public final a g;

    public interface a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LinkUserFollowGuideDialog a;

        public b(LinkUserFollowGuideDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r10v1, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.widget.widget.LinkUserFollowGuideDialog, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            ?? r11 = this.a;
            int r0 = LinkUserFollowGuideDialog.h;
            r11.getClass();
            if (jc1.k.n(IMiddlewareUserService.class).user().isLogin() == true) goto L5;
            com.bytedance.android.livesdk.user.e r1 = jc1.k.n(IMiddlewareUserService.class).user();
            Context r12 = r11.getContext();
            com.bytedance.android.livesdk.user.l.a r2 = new com.bytedance.android.livesdk.user.l.a();
            r2.a = CoreSettingUtil.getLoginPromptForFollow();
            r2.b = CoreSettingUtil.getLoginImageForFollow();
            r2.e = "live_detail";
            r2.g = "follow";
            r2.d = "live";
            r2.c = 1;
            r1.login(r12, new com.bytedance.android.livesdk.user.l(r2)).subscribe(new com.bytedance.android.livesdk.user.h());
            return;
        L5:
            Room r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
            String r4 = "";
            if (r3 == null) goto L21;
            long r5 = r3.getRoomId();
            com.bytedance.android.livesdk.user.e r6 = jc1.k.n(IMiddlewareUserService.class).user();
            com.bytedance.android.livesdk.user.b.c r7 = new com.bytedance.android.livesdk.user.b.c();
            ILinkerFollowStrongGuideContent r8 = r11.e;
            if (r8 == null) goto L12;
            IBaseUser r9 = r8.getUser();
            if (r9 == null) goto L12;
            String r13 = r9.getIdString();
        L13:
            com.bytedance.android.livesdk.user.b.a r14 = r7.c(r13);
            ILinkerFollowStrongGuideContent r15 = r11.e;
            if (r15 == null) goto L19;
            IBaseUser r16 = r15.getUser();
            if (r16 == null) goto L19;
            Intrinsics.checkNotNullParameter(r16, "$this$secUidExt");
            String r17 = r16.getCastSecUid();
            if (r17 == null) goto L19;
        L20:
            com.bytedance.android.livesdk.user.b.c r18 = r14.b(r17).h(r5).f(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.FOLLOW_BACK));
            r18.getClass();
            ((ObservableSubscribeProxy) r6.h(new com.bytedance.android.livesdk.user.b(r18)).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r11.d))).subscribe(new t(r11), new u(r11));
        L19:
            r17 = "";
        L12:
            r13 = null;
        L21:
            HashMap r19 = new HashMap();
            TalkRoomLogUtils.B0(r19, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), null, 4);
            TalkRoomLogUtils.J0(r19);
            TalkRoomLogUtils.f1(r19, r11.e.getFromUserType());
            IBaseUser r20 = r11.e.getUser();
            if (r20 == null) goto L27;
            String r21 = r20.getIdString();
            if (r21 == null) goto L27;
            r4 = r21;
        L27:
            r19.put("to_user_id", r4);
            r19.put("request_page", "link_user_popup");
            com.bytedance.live.datacontext.m r22 = com.bytedance.android.live.liveinteract.api.utils.m.i().isCleanMode();
            if (r22 != null) goto L30;
        L32:
            String r23 = "0";
        L33:
            r19.put("if_clear_mode", r23);
            j0.l().sendLog("livesdk_follow", r19, new Object[]{IRoom.class});
            Handler r24 = DialogLancet.resolveDialogHandler(r11);
            if (r24 != null) goto L36;
        L38:
            DialogLancet.beforeDialogDismiss(r11);
            r11.dismiss();     // Catch: Throwable -> L41 Exception -> L43
        L47:
            DialogLancet.afterDialogDismiss(r11);
            return;
        L43:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L41
            Throwable r25 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L41
            if (r25 == null) goto L47;
            com.bytedance.crash.d.d(r25, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r11);
            throw th;
        L36:
            if (Looper.myLooper() == r24.getLooper()) goto L38;
            r24.post(DialogLancet.createDismissRunnable(r11));
            return;
        L30:
            if (((Boolean) r22.getValue()).booleanValue() != true) goto L32;
            r23 = "1";
            goto L33
        }
    }

    public final int getLayoutId() {
        return 2131565591;
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
        ((LinkMultiControlPresenter) this.g).p = false;
        this.c.dispose();
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.c.isDisposed() == true) goto L6;
        this.c.dispose();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        setCanceledOnTouchOutside(true);
        ((Button) findViewById(2131364730)).setOnClickListener(new b(this));
        if (this.e.getFromUserType() != UserType.ANCHOR.getValue()) goto L6;
        this.a = getContext().getString(2131917477);
    L8:
        ImageView r4 = (ImageView) findViewById(2131376019);
        IBaseUser r0 = this.e.getUser();
        String r1 = null;
        if (r0 == null) goto L11;
        py.k r2 = r0.getAvatarThumbKt();
    L12:
        ImageUtil.loadRoundImage(r4, r2);
        TextView r5 = (TextView) findViewById(2131391668);
        IBaseUser r6 = this.e.getUser();
        if (r6 == null) goto L15;
        r1 = r6.getNickName();
    L15:
        r5.setText(r1);
        TextView r7 = (TextView) findViewById(2131390763);
        String r8 = this.a;
        if (r8 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("identityText");
    L18:
        r7.setText(r8);
        this.c.add(du2.a.d(1, TimeUnit.SECONDS).take(this.b).map(new r(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new s(this)));
        return;
    L11:
        r2 = null;
        goto L12
    L6:
        if (this.e.getFromUserType() != UserType.AUDIENCE.getValue()) goto L8;
        this.a = getContext().getString(2131917510);
        goto L8
    }

    public LinkUserFollowGuideDialog(Context r2, LifecycleOwner r3, ILinkerFollowStrongGuideContent r4, gd0.u r5, a r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "linkerFollowStringGuideContent");
        Intrinsics.checkNotNullParameter(r5, "linkUserFollowGuideCallback");
        Intrinsics.checkNotNullParameter(r6, "dismissCallback");
        super(r2);
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.b = 10;
        this.c = new CompositeDisposable();
    }
}
