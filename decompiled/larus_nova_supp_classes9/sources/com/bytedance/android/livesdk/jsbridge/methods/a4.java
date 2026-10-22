package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.SetAdminPermissionResultResultModel;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.roommanage.AnchorManageAdminDataContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import w20.e6;
import w20.le;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "set_admin_permission_result")
public final class a4 extends e6<le, SetAdminPermissionResultResultModel> {
    public a4() {
    }

    public final void invoke(Object r5, CallContext r6) {
        le r7 = (le) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        DataContext r8 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(AnchorManageAdminDataContext.class));
        if ((r8 instanceof AnchorManageAdminDataContext) == true) goto L5;
        r8 = null;
    L5:
        AnchorManageAdminDataContext r9 = (AnchorManageAdminDataContext) r8;
        if (r9 == null) goto L34;
        td1.d r0 = (td1.d) r9.getAdminUserOperating().getValue();
        if (r0 == null) goto L33;
        Integer r1 = r7.b();
        if (r1 != null) goto L14;
    L15:
        List r2 = r0.adminPrivileges;
        String r10 = r7.a();
        if (r10 == null) goto L18;
        int r11 = CastIntegerProtector.parseInt(r10);
    L19:
        r2.remove(Integer.valueOf(r11));
    L31:
        com.bytedance.live.datacontext.m r13 = r9.getAdminUserOperatingPermissions();
        LiveRoomPermission.Companion r14 = LiveRoomPermission.D;
        List r3 = r0.adminPrivileges;
        r14.getClass();
        r13.setValue(LiveRoomPermission.Companion.b(r3, -1));
        return;
    L18:
        r11 = -1;
        goto L19
    L14:
        if (r1.intValue() != 1) goto L15;
        List r4 = r0.adminPrivileges;
        String r15 = r7.a();
        if (r15 == null) goto L23;
        int r16 = CastIntegerProtector.parseInt(r15);
    L25:
        if (r4.contains(Integer.valueOf(r16)) == true) goto L31;
        List r17 = r0.adminPrivileges;
        String r18 = r7.a();
        if (r18 == null) goto L29;
        int r19 = CastIntegerProtector.parseInt(r18);
    L30:
        r17.add(Integer.valueOf(r19));
        goto L31
    L29:
        r19 = -1;
        goto L30
    L23:
        r16 = -1;
        goto L25
    L33:
        return;
    }
}
