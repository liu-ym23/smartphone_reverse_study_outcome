package com.bytedance.android.live.room.share.util;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.ssposter.api.LivePosterApi;
import com.bytedance.android.live.room.api.ssposter.api.PosterResponse;
import com.bytedance.android.live.room.share.LiveShareService;
import com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper;
import com.bytedance.android.livehostapi.business.depend.share.LiveQrCodeConfig;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.config.nf0;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.ToolbarComponentData;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper;
import com.bytedance.live.datacontext.i;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(i81.a r3) {
        if (r3 == null) goto L30;
        Dialog r0 = r3.m;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isShowing() != true) goto L35;
        Activity r1 = r3.getActivity();
        if (r1 != null) goto L10;
    L11:
        Dialog r4 = r3.m;
        if (r4 == null) goto L37;
        Handler r2 = DialogLancet.resolveDialogHandler(r4);
        if (r2 != null) goto L16;
    L18:
        DialogLancet.beforeDialogDismiss(r4);
        r4.dismiss();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        DialogLancet.afterDialogDismiss(r4);
        return;
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r5 == null) goto L27;
        com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r4);
        throw th;
    L16:
        if (Looper.myLooper() == r2.getLooper()) goto L18;
        r2.post(DialogLancet.createDismissRunnable(r4));
        return;
    L37:
        return;
    L10:
        if (r1.isFinishing() != true) goto L11;
        return;
    L35:
        return;
    }

    @JvmStatic
    public static final void a(final i81.a r16, final ShareParams r17, final Function0<Unit> r18) {
        Intrinsics.checkNotNullParameter(r17, "shareParams");
        IRoom r0 = r17.getRoom();
        CompositeDisposable r8 = null;
        if ((r0 instanceof Room) == true) goto L5;
        r0 = null;
    L5:
        final Room r2 = (Room) r0;
        if (r2 == null) goto L16;
        RoomAuthStatus r3 = r2.getMRoomAuthStatus();
        if (r3 == null) goto L16;
        if (r3.enablePreviewPosterCache() != true) goto L16;
        ALogger.i(LiveShareService.TAG, "try to get config from cache");
        long r4 = r17.getRoom().getRoomId();
        int r5 = k81.c.a;
        String r6 = r4 + '-' + new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        j81.a r7 = k81.c.a();
        if (r7 == null) goto L16;
        HashMap<String, LiveQrCodeConfig> r9 = r7.a;
        if (r9 == null) goto L16;
        LiveQrCodeConfig r10 = r9.get(r6);
    L17:
        if (r10 == null) goto L19;
        ALogger.i(LiveShareService.TAG, "share with cached panel config. current config is " + r10);
        b(r16);
        r17.setLiveQrCodeConfig(r10);
        Unit r1 = (Unit) r18.invoke();
        return;
    L19:
        ALogger.i(LiveShareService.TAG, "share with panel config");
        final LiveQrCodeConfig r12 = new LiveQrCodeConfig();
        int r13 = 0;
        if (((Boolean) nf0.a.getValue()).booleanValue() == false) goto L60;
        if (r2 == null) goto L60;
        int r14 = k81.c.a;
        LiveToolbarData r15 = r2.getToolbarData();
        if (r15 == null) goto L39;
        List r19 = r15.getToolbarDataList();
        if (r19 == null) goto L39;
        Iterator r20 = r19.iterator();
    L28:
        if (r20.hasNext() == false) goto L35;
        Object r110 = r20.next();
        if (((IToolbarComponentData) r110).getId() != 20) goto L32;
        boolean r111 = true;
    L33:
        if (r111 == false) goto L28;
    L36:
        IToolbarComponentData r112 = (IToolbarComponentData) r110;
        if (r112 == null) goto L39;
        String r22 = r112.getExtraData();
    L41:
        if (k81.c.b(r22) == true) goto L61;
        LiveToolbarData r23 = r2.getToolbarData();
        if (r23 == null) goto L60;
        List r24 = r23.getMorePanelDataList();
        if (r24 == null) goto L60;
        Iterator r25 = r24.iterator();
    L49:
        if (r25.hasNext() == false) goto L56;
        Object r113 = r25.next();
        if (((ToolbarComponentData) r113).getId() != 20) goto L53;
        boolean r114 = true;
    L54:
        if (r114 == false) goto L49;
    L57:
        ToolbarComponentData r115 = (ToolbarComponentData) r113;
        if (r115 == null) goto L60;
        r22 = r115.getExtraData();
        goto L61
    L53:
        r114 = false;
        goto L54
    L56:
        r113 = null;
    L61:
        r12.setPanelType(r17.getExtras().getInt("panel_type", 0));
        int r26 = k81.c.a;
        if (r2 == null) goto L89;
        ALogger.i("QrCodeConfig", "extra data is " + r22);
        j81.b r27 = (j81.b) JsonUtil.parse(r22, j81.b.class);
        if (r2.isMergeVSRoom() == true) goto L69;
        MiddlewareRoomContext.a r28 = MiddlewareRoomContext.Companion;
        long r116 = r2.id;
        r28.getClass();
        if (VSMediaUIConfigHelper.a(MiddlewareRoomContext.a.a(null, r116)) == true) goto L69;
    L78:
        if (r27 != null) goto L80;
    L82:
        RoomAuthStatus r29 = r2.getRoomAuthStatus();
        if (r29 != null) goto L85;
    L87:
        r12.setPanelType(r13);
        goto L89
    L85:
        if (r29.getPoster() != 1) goto L87;
        ALogger.i("QrCodeConfig", "show poster share due to room auth");
        r13 = 1;
        goto L87
    L80:
        if (r27.shareType != 2) goto L82;
        ALogger.i("QrCodeConfig", "show ss panel due to toolbar data");
        r13 = 2;
    L69:
        if (r12.getPanelType() == 0) goto L78;
        r13 = r12.getPanelType();
        ILiveService r30 = TTLiveService.getLiveService();
        if (r30 == null) goto L73;
        ILiveQrCodeShareHelper r32 = r30.getQrCodeShareHelper(7);
    L75:
        if ((r32 instanceof IQrCodeShareHelper) == true) goto L77;
        r32 = null;
    L77:
        r12.setQrCodeShareHelper((IQrCodeShareHelper) r32);
        goto L87
    L73:
        r32 = null;
    L89:
        if (r12.getPanelType() != 2) goto L124;
        if (r2 == null) goto L124;
        if (r16 == null) goto L94;
        Activity r33 = r16.getActivity();
    L95:
        if (r33 == null) goto L116;
        if (r16 == null) goto L98;
        Activity r34 = r16.getActivity();
    L100:
        if (e5.g(r34) == false) goto L116;
        if (r16 == null) goto L107;
        Dialog r35 = r16.m;
        if (r35 == null) goto L107;
        if (r35.isShowing() == true) goto L116;
    L107:
        if (r16 == null) goto L116;
        Dialog r36 = r16.m;
        if (r36 == null) goto L116;
        if (DialogLancet.shouldBlockDialogShow(r36) == false) goto L127;
        DialogLancet.handleBlockedDialogShow(r36);
        goto L116
    L127:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L126
    L114:
        DialogLancet.beforeDialogShow(r36);
        r36.show();
        DialogLancet.afterDialogShow(r36);
        goto L116
    L98:
        r34 = null;
    L116:
        if (r17.getRoom() != null) goto L118;
        ALogger.i(LiveShareService.TAG, "room is null.....");
        b(r16);
        return;
    L118:
        HashMap<String, String> r117 = new HashMap();
        r117.put("room_id", String.valueOf(r17.getRoom().getRoomId()));
        Function1<PosterResponse, Unit> r118 = new LiveShareHelper$tryGetPanelConfigAndShare$1(r12, r2, r17, r16, r18);
        Function1<Throwable, Unit> r37 = new LiveShareHelper$tryGetPanelConfigAndShare$2(r12, r16, r17, r18);
        int r38 = k81.c.a;
        Intrinsics.checkNotNullParameter(r117, "requestParas");
        Intrinsics.checkNotNullParameter(r37, "onFail");
        Disposable r39 = ((LivePosterApi) com.bytedance.android.live.network.c.b().e(LivePosterApi.class)).queryLivePoster(r117).timeout(2, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new k81.a(r118), new k81.b(r37));
        RoomContext r40 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r40 == null) goto L123;
        i r42 = r40.getCompositeDisposable();
        if (r42 == null) goto L123;
        r8 = (CompositeDisposable) r42.getValue();
    L123:
        RxUtilKt.c(r39, r8);
        return;
    L94:
        r33 = null;
    L124:
        ALogger.i(LiveShareService.TAG, "Disable fetch config on click. Current panel config is " + r12);
        b(r16);
        r17.setLiveQrCodeConfig(r12);
        Unit r43 = (Unit) r18.invoke();
        return;
    L32:
        r111 = false;
        goto L33
    L35:
        r110 = null;
    L39:
        r22 = null;
    L60:
        r22 = null;
    L16:
        r10 = null;
        goto L17
    }
}
