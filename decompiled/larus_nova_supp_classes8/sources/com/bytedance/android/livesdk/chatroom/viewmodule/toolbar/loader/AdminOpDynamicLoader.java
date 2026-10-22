package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.ManageRoomButtonHelper;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.o4;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AdminOpDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdminOpDynamicLoader extends AbsDynamicLoader {
    public o4 h;
    public i4 i;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        HashSet r0 = new HashSet();
        IUser r1 = (IUser) this.a.get("data_user_in_room", null);
        if (this.c == true) goto L32;
        if (r1 == null) goto L32;
        if (r1.getUserAttr() == null) goto L32;
        t r2 = r1.getUserAttr();
        Intrinsics.checkNotNull(r2);
        if (r2.isAdmin() == false) goto L10;
        LiveRoomPermission.Companion r3 = LiveRoomPermission.D;
        t r4 = r1.getUserAttr();
        Intrinsics.checkNotNull(r4);
        List r5 = r4.getAdminPrivileges();
        r3.getClass();
        Collection r6 = LiveRoomPermission.Companion.b(r5, -1);
    L12:
        if (RoomPermissionContext.a.c(RoomPermissionContext.Companion) == false) goto L23;
        ManageRoomButtonHelper r7 = ManageRoomButtonHelper.b;
        DataCenter r8 = this.a;
        t r9 = r1.getUserAttr();
        Intrinsics.checkNotNull(r9);
        boolean r10 = r9.isAdmin();
        List r11 = CollectionsKt.toMutableList(r6);
        Room r12 = this.g;
        r7.getClass();
        ManageRoomButtonHelper.e(r8, r10, r0, r11, r12);
        o4 r13 = this.h;
        if (r13 != null) goto L16;
    L18:
        i4 r14 = this.i;
        if (r14 == null) goto L32;
        if (r14.b() != true) goto L32;
        r0.add(ToolbarButton.WISH_LIST);
        goto L32
    L16:
        if (r13.b() != true) goto L18;
        r0.add(ToolbarButton.PROMPT);
        goto L18
    L23:
        t r15 = r1.getUserAttr();
        Intrinsics.checkNotNull(r15);
        if (r15.isAdmin() == false) goto L26;
        r0.add(ToolbarButton.MANAGE);
    L26:
        t r16 = r1.getUserAttr();
        Intrinsics.checkNotNull(r16);
        List r17 = r16.getAdminPrivileges();
        if (r17 == null) goto L32;
        if (r17.contains(2) == false) goto L32;
        r0.add(ToolbarButton.PROMPT);
        goto L32
    L10:
        r6 = new ArrayList();
    L32:
        return CollectionsKt.toList(r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        if (UserSetting.a() == false) goto L5;
        this.a.observe("data_user_in_room", this);
    L5:
        g3 r0 = y3.f(this.a);
        if (r0 == null) goto L10;
        o4 r1 = new o4();
        r0.J(r1);
        Unit r2 = Unit.INSTANCE;
        this.h = r1;
        i4 r3 = new i4();
        r0.J(r3);
        this.i = r3;
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarFoldManager");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onUnLoad() {
        super.onUnLoad();
        this.a.removeObserver(this);
    }

    public AdminOpDynamicLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader
    public final void e(KVData r6) {
        RoomPermissionContext r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getKey();
    L7:
        if ((!Intrinsics.areEqual("data_user_in_room", r1)) == false) goto L9;
        return;
    L9:
        IUser r7 = (IUser) r6.getData();
        if (this.c == true) goto L30;
        if (r7 != null) goto L13;
        return;
    L13:
        if (r7.getUserAttr() == null) goto L32;
        t r2 = r7.getUserAttr();
        Intrinsics.checkNotNull(r2);
        if (r2.isAdmin() == false) goto L17;
        LiveRoomPermission.Companion r3 = LiveRoomPermission.D;
        t r8 = r7.getUserAttr();
        Intrinsics.checkNotNull(r8);
        List r9 = r8.getAdminPrivileges();
        r3.getClass();
        List r10 = LiveRoomPermission.Companion.b(r9, -1);
    L18:
        RoomContext.a r4 = RoomContext.Companion;
        DataCenter r5 = this.a;
        r4.getClass();
        RoomContext r11 = RoomContext.a.a(r5, 0);
        if (r11 == null) goto L24;
        n r12 = r11.getPermissionContext();
        if (r12 == null) goto L24;
        r0 = (RoomPermissionContext) r12.getValue();
    L24:
        if (RoomPermissionContext.a.c(RoomPermissionContext.Companion) == false) goto L33;
        if (r0 == null) goto L34;
        m r13 = r0.getCurrentPermissions();
        if (r13 == null) goto L35;
        r13.setValue(r10);
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L17:
        r10 = CollectionsKt.emptyList();
        goto L18
    L32:
        return;
    L30:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        e((KVData) r1);
    }
}
