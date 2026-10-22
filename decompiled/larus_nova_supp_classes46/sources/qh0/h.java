package qh0;

import am2.x;
import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.MaybeSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.utils.s;
import com.bytedance.android.live.liveinteract.utils.t;
import com.bytedance.android.live.liveinteract.utils.u;
import com.bytedance.android.live.room.IMiddlewareLiveSDKService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.user.VcdAuthorizationSource;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.config.eb0;
import com.bytedance.android.livesdk.config.mb1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public k a;
    public boolean b;
    public final int c;
    public final Function0<Unit> d;
    public final Function0<Unit> e;

    public static final class a {
    }

    public static final class b implements OnBindPhoneListener {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        public final void onBindPhone(boolean r4) {
            if (r4 == false) goto L5;
            f2.b(2131917577, 0);
            j0 r5 = j0.l();
            x r0 = new x();
            r0.d = "guest_connection";
            r5.sendLog("livesdk_guest_connection_phone_bind_success", null, new Object[]{IRoom.class, r0});
            this.a.d.invoke();
            return;
        }
    }

    static {
    }

    public static String a(String r3) {
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r0 != 1) goto L5;
        String r1 = "pk_room";
    L15:
        ALogger.i("ServerPermissionHandler", "source=" + r3 + ", enterFrom=" + r1);
        return r1;
    L5:
        if (r0 != 5) goto L7;
        r1 = "audio_chat_room";
        goto L15
    L7:
        if (r0 != 8) goto L9;
        r1 = "video_chatroom";
        goto L15
    L9:
        if (r0 == 12) goto L11;
        r1 = "guest_connection";
        goto L15
    L11:
        r1 = "video_friend_room";
        goto L15
    }

    public static void b(String r1) {
        ALogger.w("ServerPermissionHandler", r1.concat(" no valid activity."));
    }

    public final void c(Throwable r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        if ((r15 instanceof ApiServerException) == false) goto L82;
        ApiServerException r0 = (ApiServerException) r15;
        switch(r0.getErrorCode()) {
            case 20048: goto L57;
            case 20089: goto L56;
            case 30010: goto L44;
            case 31002: goto L40;
            case 31009: goto L35;
            case 31011: goto L30;
            case 4002168: goto L29;
            case 4004091: goto L25;
            case 4004272: goto L12;
            case 4004277: goto L9;
            default: goto L68;
        };
    L12:
        Activity r16 = com.bytedance.android.live.core.utils.a.d();
        if (r16 == null) goto L24;
        HashMap r1 = new HashMap();
        String r2 = a("face_verify");
        j0.l().sendLog("livesdk_anchor_face_recognition_show", r1, new Object[0]);
        SpannableString r3 = new SpannableString(s1.B(2131923049));
        r3.setSpan(new ForegroundColorSpan(s1.h(2131107193)), 0, r3.length(), 33);
        c9.b r4 = new c9.b();
        r4.a = r16;
        r4.b = 2;
        r4.c = 2131565734;
        r4.p = false;
        r4.e = r16.getText(2131923055);
        r4.f = r4.a.getText(2131923051);
        String r5 = s1.B(2131915442);
        q r6 = new q(r1);
        r4.j = r5;
        r4.k = r6;
        o r7 = new o(r2, r16, r1, this);
        r4.l = r3;
        r4.m = r7;
        c9 r8 = new c9(r4.a, r4);
        mb1 r9 = (mb1) eb0.a.getValue();
        if (r9 == null) goto L20;
        if (r9.a() != true) goto L20;
        LinearLayout r10 = (LinearLayout) r8.e.findViewById(2131384759);
        CheckBox r11 = (CheckBox) r8.e.findViewById(2131384758);
        TextView r12 = (TextView) r8.e.findViewById(2131384760);
        SpannableString r13 = new SpannableString(s1.B(2131914609));
        r13.setSpan(new r(r16), 3, 11, 33);
        r10.setVisibility(0);
        r11.setOnCheckedChangeListener(new p(this));
        r12.setText(r13);
        r12.setMovementMethod(LinkMovementMethod.getInstance());
        String r17 = s1.B(2131914612);
        String r14 = s1.B(2131914610);
        r8.k.setText(r17);
        r8.l.setText(r14);
        r8.k.setTextSize(14.0f);
        r8.l.setTextSize(14.0f);
    L20:
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L77;
        DialogLancet.handleBlockedDialogShow(r8);
        return;
    L77:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L73
    L23:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        return;
    L24:
        b("showFaceVerifyDialog");
        return;
    L25:
        Activity r18 = com.bytedance.android.live.core.utils.a.d();
        if (r18 == null) goto L28;
        r0.setBlockNotice(true);
        ExceptionUtils.handleException(r18, r0);
        return;
    L28:
        b("onCheckPermissionFailed");
        return;
    L29:
        d(4002168);
        return;
    L30:
        this.e.invoke();
        Activity r19 = com.bytedance.android.live.core.utils.a.d();
        if (r19 != null) goto L33;
    L34:
        b("handleBannedError");
        Unit r110 = Unit.INSTANCE;
        return;
    L33:
        if (((SingleSubscribeProxy) ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).getLatestBanRecord(13).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(ContextUtil.contextToFragmentActivity(r19)))).subscribe(new i(r19, this), j.a) == null) goto L34;
        return;
    L35:
        Activity r111 = com.bytedance.android.live.core.utils.a.d();
        if (r111 == null) goto L39;
        IMiddlewareUserService r20 = jc1.k.n(IMiddlewareUserService.class);
        FragmentActivity r21 = ContextUtil.contextToFragmentActivity(r111);
        Intrinsics.checkNotNull(r21);
        if (((MaybeSubscribeProxy) r20.ensureVcdAuthorized(r21, VcdAuthorizationSource.LINK_IN_ROOM).observeOn(AndroidSchedulers.mainThread()).filter(n.a).as(AutoDispose.bind(ContextUtil.contextToFragmentActivity(r111)))).subscribe(new m(this)) == null) goto L39;
        return;
    L39:
        b("onVcdAuthorizationError");
        Unit r112 = Unit.INSTANCE;
        return;
    L40:
        Activity r22 = com.bytedance.android.live.core.utils.a.d();
        if (r22 == null) goto L43;
        ExceptionUtils.handleException(r22, r15);
        return;
    L43:
        b("onCheckPermissionFailed");
        return;
    L44:
        Activity r113 = com.bytedance.android.live.core.utils.a.d();
        if (r113 == null) goto L55;
        HashMap r23 = new HashMap();
        r23.put("verify_type", "realname");
        j0.l().sendLog("livesdk_guest_connection_verify_popup_show", r23, new Object[]{IRoom.class, x.class});
        com.bytedance.android.live.base.model.verify.c r24 = (com.bytedance.android.live.base.model.verify.c) GsonHelper.get().fromJson(r0.getExtra(), com.bytedance.android.live.base.model.verify.c.class);     // Catch: Exception -> L49
    L51:
        com.bytedance.android.live.base.model.verify.c r114 = r24;
        Activity r25 = ContextUtil.contextToActivity(r113);
        Bundle r115 = new Bundle();
        r115.putString("enter_from", a("real_name"));
        r115.putBoolean("use_new_cert_api", true);
        this.a = new k(this);
        IMiddlewareLiveSDKService r26 = jc1.k.n(IMiddlewareLiveSDKService.class);
        String r116 = r0.getPrompt();
        if (r116 != null) goto L54;
        r116 = "";
    L54:
        r26.handleRealNameConflict(r25, 111, r114, r115, r116, this.a);
        return;
    L49:
        e = move-exception;
        ALogger.e("ServerPermissionHandler", e);
        ALogger.d("ServerPermissionHandler", r0.getExtra());
        r24 = null;
        goto L51
    L55:
        b("onRealNameError");
        return;
    L56:
        d(20089);
        return;
    L57:
        Activity r117 = com.bytedance.android.live.core.utils.a.d();
        if (r117 == null) goto L67;
        HashMap r27 = new HashMap();
        r27.put("verify_type", "underage");
        j0.l().sendLog("livesdk_guest_connection_verify_popup_show", r27, new Object[]{IRoom.class, x.class});
        x0.d r28 = new x0.d();
        r28.b = r117;
        r28.a = 0;
        r28.k = true;
        r28.c = r28.b.getText(2131918049);
        l r118 = new l(this);
        CharSequence r29 = r28.b.getText(2131918183);
        x0.c[] r30 = r28.g;
        x0.c r31 = r30[0];
        if (r31 != null) goto L62;
        r31 = new x0.c();
        r30[0] = r31;
    L62:
        r31.a = r29;
        r31.b = r118;
        x0 r119 = new x0(r28.b, r28);
        if (DialogLancet.shouldBlockDialogShow(r119) == false) goto L75;
        DialogLancet.handleBlockedDialogShow(r119);
        return;
    L75:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L74
    L66:
        DialogLancet.beforeDialogShow(r119);
        r119.show();
        DialogLancet.afterDialogShow(r119);
        return;
    L67:
        b("onUnderageError");
        return;
    L68:
        Activity r32 = com.bytedance.android.live.core.utils.a.d();
        if (r32 == null) goto L71;
        ExceptionUtils.handleException(r32, r15);
        return;
    L71:
        b("onCheckPermissionFailed");
        return;
    L9:
        if (com.bytedance.android.live.core.utils.a.d() == null) goto L11;
        f2.c(r0.getPrompt(), 0);
        return;
    L11:
        b("handlePaidLiveLinkError");
        return;
    }

    public final void d(int r9) {
        Activity r0 = com.bytedance.android.live.core.utils.a.d();
        if (r0 == null) goto L11;
        int r1 = u.a;
        Activity r2 = ContextUtil.contextToActivity(r0);
        b r3 = new b(this);
        Intrinsics.checkNotNullParameter("guest_connection", "source");
        Intrinsics.checkNotNullParameter(r3, "listener");
        HashMap r4 = new HashMap();
        r4.put("verify_type", "phone");
        j0.l().sendLog("livesdk_guest_connection_verify_popup_show", r4, new Object[]{IRoom.class, x.class});
        if (r2 == null) goto L16;
        x0.b r5 = new x0.b(r2, 0);
        r5.a.k = true;
        r5.m(2131917576);
        r5.i(0, 2131918887, s.a);
        r5.i(1, 2131918888, new t(r2, r9, r3));
        x0 r10 = r5.h();
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r10);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L10:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        return;
    L16:
        return;
    L11:
        b("onBindPhoneError");
    }

    public h(int r2, Function0 r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r3, "onCheckSuccess");
        Intrinsics.checkNotNullParameter(r4, "onCheckFailed");
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
