package com.bytedance.android.live.broadcastgame.widget;

import android.app.Activity;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.effectgame.base.ResourceLoadingController;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveGameControlWidget$fetchCallBack$1 implements com.bytedance.android.live.broadcastgame.effectgame.base.a {
    public final Lazy a;
    public final /* synthetic */ LiveGameControlWidget b;

    public LiveGameControlWidget$fetchCallBack$1(LiveGameControlWidget r1) {
        this.b = r1;
        this.a = LazyKt.lazy(new LiveGameControlWidget$fetchCallBack$1$controller$2(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void c(int r2, Sticker r3) {
        Intrinsics.checkNotNullParameter(r3, "sticker");
        ResourceLoadingController r4 = (ResourceLoadingController) this.a.getValue();
        LiveGameControlWidget r5 = this.b;
        u r0 = r5.a;
        Map<String, ? extends Object> r6 = r5.b;
        r4.b = r0;
        r4.c = r6;
        ResourceLoadingController r7 = (ResourceLoadingController) this.a.getValue();
        if ((r7.d instanceof Activity) == false) goto L19;
        ResourceLoadingController.LoadingDialog r8 = r7.a;
        if (r8 != null) goto L7;
    L9:
        ResourceLoadingController.LoadingDialog r9 = new ResourceLoadingController.LoadingDialog(r7.d);
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r9);
    L14:
        r9.a(0);
        Unit r1 = Unit.INSTANCE;
        r7.a = r9;
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        goto L14
    L7:
        if (r8.isShowing() != true) goto L9;
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void d(int r2, Sticker r3, ExceptionResult r4) {
        Intrinsics.checkNotNullParameter(r3, "sticker");
        ((ResourceLoadingController) this.a.getValue()).a(LiveGameControlWidget$fetchCallBack$1$onFail$1.INSTANCE);
        IESUIUtils.displayToast(s1.getContext(), 2131919146);
        JSONObject r5 = new JSONObject();
        r5.put("status_code", IInteractGameMonitorService.FAILURE_CODE_EFFECT_GAME_START_RESOURCE_ERROR);
        if (r4 == null) goto L5;
        r5.put(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, r4.getErrorCode());
        r5.put(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r4.getMsg());
    L5:
        int r6 = com.bytedance.android.live.broadcastgame.effectgame.base.b.a;
        ((IInteractGameMonitorService) k.n(IInteractGameMonitorService.class)).logGameStartupResult(1, this.b.a, r5);
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void a(int r1, boolean r2, int r3, final Sticker r4) {
        Intrinsics.checkNotNullParameter(r4, "sticker");
        if (r1 != 2) goto L6;
        ((ResourceLoadingController) this.a.getValue()).a(new LiveGameControlWidget$fetchCallBack$1$onSuccess$1(this, r4));
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void b(int r1, int r2, long r3, Sticker r5) {
        Intrinsics.checkNotNullParameter(r5, "sticker");
        if (r1 != 1) goto L8;
        ResourceLoadingController.LoadingDialog r4 = ((ResourceLoadingController) this.a.getValue()).a;
        if (r4 == null) goto L9;
        r4.a(r2);
        return;
    L9:
        return;
    }
}
