package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.message.model.k;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AdminRecordUpdateLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "Lvlc/l;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdminRecordUpdateLoader extends AbsDynamicLoader implements l {
    public final Lazy h;
    public Disposable i;
    public final Function0<Unit> j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ AdminRecordUpdateLoader a;

        public a(AdminRecordUpdateLoader r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            List r5 = (List) r4;
            AdminRecordUpdateLoader r6 = this.a;
            com.bytedance.android.live.user.api.a r0 = com.bytedance.android.live.user.api.b.a(r6.a);
            if (r0 == null) goto L10;
            com.bytedance.android.live.core.arch.mvvm.d r1 = r0.isAdmin();
            if (r1 != null) goto L7;
            return;
        L7:
            if (((Boolean) r1.getValue()).booleanValue() != true) goto L12;
            r6.f.a.put("cmd_update_admin_record", Unit.INSTANCE);
            r6.j.invoke();
            return;
        L12:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        LiveRoomPermission.D.getClass();
        if (LiveRoomPermission.Companion.c() == false) goto L6;
        return CollectionsKt.listOf(ToolbarButton.RECORD);
    L6:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        if (UserSetting.b() == false) goto L14;
        Disposable r0 = this.i;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        com.bytedance.android.live.user.api.a r1 = com.bytedance.android.live.user.api.b.a(this.a);
        if (r1 == null) goto L12;
        LiveRoomPermission.D.getClass();
        Observable r2 = r1.onPermissionChangeType(new LiveRoomPermission[]{LiveRoomPermission.y});
        if (r2 == null) goto L12;
        Disposable r3 = r2.subscribe(new a(this));
    L13:
        this.i = r3;
    L17:
        LiveRoomPermission.D.getClass();
        if (LiveRoomPermission.Companion.c() == false) goto L29;
        DataCenter r4 = this.a;
        if (r4 == null) goto L30;
        Room r5 = z.o(r4);
        if (r5 == null) goto L31;
        RoomAuthStatus r6 = r5.getMRoomAuthStatus();
        if (r6 != null) goto L26;
        return;
    L26:
        if (r6.isEnableRecordScreen() == true) goto L33;
        this.f.a.put("cmd_update_admin_record", Unit.INSTANCE);
        return;
    L33:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L12:
        r3 = null;
        goto L13
    L14:
        vlc.d r7 = (vlc.d) this.h.getValue();
        if (r7 == null) goto L17;
        r7.addMessageListener(MessageType.ADMIN_PRIVILEGE_CHANGE.getIntType(), this);
        goto L17
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onUnLoad() {
        if (UserSetting.a() == false) goto L7;
        vlc.d r0 = (vlc.d) this.h.getValue();
        if (r0 == null) goto L7;
        r0.removeMessageListener(MessageType.ADMIN_PRIVILEGE_CHANGE.getIntType(), this);
    L7:
        Disposable r1 = this.i;
        if (r1 == null) goto L10;
        r1.dispose();
    L10:
        this.i = null;
    }

    public final void onMessage(tlc.d r11) {
        if ((r11 instanceof k) == false) goto L22;
        if (r11 == null) goto L21;
        k r12 = (k) r11;
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L23;
        k.a r13 = r12.E();
        if (r13 == null) goto L24;
        int r0 = r13.c();
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r1 = LiveRoomPermission.y;
        if (r0 == r1.a) goto L17;
        List r14 = r13.a();
        if (r14 != null) goto L14;
    L16:
        boolean r15 = false;
    L18:
        if (r15 != true) goto L25;
        UtilityKotlinExtentionsKt.s(500, false, false, new AdminRecordUpdateLoader$handlePrivilegeChange$2(this), 6);
        return;
    L25:
        return;
    L14:
        if (r14.contains(Integer.valueOf(r1.a)) != true) goto L16;
    L17:
        r15 = true;
        goto L18
    L24:
        return;
    L23:
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.AdminPrivilegeMessage");
    }

    public AdminRecordUpdateLoader(e r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "env");
        Intrinsics.checkNotNullParameter(r3, "update");
        super(r2);
        this.j = r3;
        this.h = LazyKt.lazy(new AdminRecordUpdateLoader$msgManager$2(this));
    }
}
