package com.bytedance.android.livesdk.interactivity;

import android.content.Context;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.IPSOperatePanelService;
import com.bytedance.android.livesdk.interactivity.utils.PSMessageTypeMap;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/PSOperatePanelService;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/api/IPSOperatePanelService;", "Lcom/bytedance/android/live/base/model/message/t;", "message", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/s;", "messageModel", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/r;", "callback", BuildConfig.FLAVOR, "openOperatePanel", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PSOperatePanelService implements IPSOperatePanelService {
    public PSOperatePanelService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.IPSOperatePanelService
    public void openOperatePanel(com.bytedance.android.live.base.model.message.t r9, Context r10, com.bytedance.android.livesdk.interactivity.api.publicscreen.s r11, com.bytedance.android.livesdk.interactivity.api.publicscreen.r r13) {
        Intrinsics.checkNotNullParameter(r9, "message");
        Intrinsics.checkNotNullParameter(r10, "context");
        int r1 = com.bytedance.android.livesdk.interactivity.utils.s.a;
        Intrinsics.checkNotNullParameter(r9, "message");
        Boolean r0 = PSMessageTypeMap.a;
        List r2 = PSMessageTypeMap.b(r9.getMessageMethod());
        boolean r3 = false;
        if (r2 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L14;
        com.bytedance.live.datacontext.i r6 = r5.isAnchor();
        if (r6 == null) goto L14;
        if (((Boolean) r6.getValue()).booleanValue() != true) goto L14;
    L22:
        boolean r7 = true;
    L24:
        ALogger.d("PSOperatePanel", "isValidMessageType:" + r4 + ",isValidPermission:" + r7);
        if (r4 == false) goto L28;
        if (r7 == false) goto L28;
        r3 = true;
    L28:
        if (r3 == false) goto L30;
        ALogger.d("PSOperatePanel", "canOpenPSOperatePanel");
        xs2.b r8 = xs2.b.a();
        com.bytedance.android.livesdk.interactivity.api.entity.l r14 = new com.bytedance.android.livesdk.interactivity.api.entity.l(r9, r10, r13);
        r14.a = r11;
        Unit r15 = Unit.INSTANCE;
        r8.post(r14);
        return;
    L30:
        ALogger.d("PSOperatePanel", "can't OpenPSOperatePanel");
        if (r13 == null) goto L35;
        r13.onFailed();
        return;
    L35:
        return;
    L14:
        IMiddlewareUserService r16 = jc1.k.f(IMiddlewareUserService.class);
        if (r16 == null) goto L23;
        com.bytedance.android.livesdk.user.e r17 = r16.user();
        if (r17 == null) goto L23;
        UserAttr r18 = r17.q();
        if (r18 == null) goto L23;
        if (r18.isAdmin() == true) goto L22;
    L23:
        r7 = false;
        goto L24
    L5:
        if ((!r2.isEmpty()) != true) goto L7;
        r4 = true;
        goto L8
    }
}
