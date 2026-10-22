package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import py.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/record/AdminRecordPermissionChanger;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdminRecordPermissionChanger implements Observer<KVData>, vlc.l {
    public final String a;
    public vlc.d b;
    public final CompositeDisposable c;
    public final DataCenter d;
    public final Function1<Boolean, Unit> e;

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == (-1741164106)) goto L12;
        return;
    L12:
        if (r0.equals("data_user_in_room") == false) goto L23;
        IUser r6 = (IUser) r5.getData();
        if (r6 == null) goto L24;
        t r7 = r6.getUserAttr();
        if (r7 != null) goto L18;
        return;
    L18:
        if (r7.isAdmin() == true) goto L26;
        ALogger.i(this.a, "管理员权限被下掉了");
        Function1<Boolean, Unit> r8 = this.e;
        if (r8 == null) goto L27;
        Unit r9 = (Unit) r8.invoke(Boolean.FALSE);
        return;
    L27:
        return;
    L26:
        return;
    L24:
        return;
    L23:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onMessage(tlc.d r5) {
        if ((r5 instanceof com.bytedance.android.livesdk.message.model.k) == false) goto L25;
        if (r5 == null) goto L24;
        com.bytedance.android.livesdk.message.model.k r6 = (com.bytedance.android.livesdk.message.model.k) r5;
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L20;
        com.bytedance.android.livesdk.message.model.k.a r7 = r6.E();
        if (r7 == null) goto L26;
        int r0 = r7.c();
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r1 = LiveRoomPermission.y;
        if (r0 == r1.a) goto L12;
    L13:
        List r8 = r7.a();
        if (r8 != null) goto L16;
    L18:
        boolean r9 = false;
    L19:
        if (r9 == true) goto L20;
        return;
    L16:
        if (r8.contains(Integer.valueOf(r1.a)) == true) goto L18;
    L17:
        r9 = true;
        goto L19
    L12:
        if (r7.b() == 2) goto L17;
    L26:
        return;
    L20:
        ALogger.i(this.a, "录屏权限被下掉了");
        Function1<Boolean, Unit> r10 = this.e;
        if (r10 == null) goto L28;
        Unit r11 = (Unit) r10.invoke(Boolean.FALSE);
        return;
    L28:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.AdminPrivilegeMessage");
    }

    public AdminRecordPermissionChanger(DataCenter r2, j r3) {
        Intrinsics.checkNotNullParameter(r3, "onChange");
        this.d = r2;
        this.e = r3;
        this.a = "AdminRecordPermissionChanger";
        this.c = new CompositeDisposable();
    }
}
