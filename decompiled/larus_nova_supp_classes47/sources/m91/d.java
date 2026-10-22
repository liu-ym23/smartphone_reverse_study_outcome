package m91;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAvator;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements c {
    public LifecycleOwner a;
    public Fragment b;
    public DataCenter c;
    public DataContext d;
    public aa1.a e;
    public final boolean f;

    public static final class a {
    }

    static {
    }

    @Override // m91.c
    public final boolean c() {
        String r2 = null;
        IRoom r0 = (IRoom) this.c.get("data_room", null);
        if (r0 != null) goto L14;
        StringBuilder r1 = new StringBuilder("cur room is null.room id :");
        DataContext r3 = this.d;
        if (r3 == null) goto L13;
        Intrinsics.checkNotNullParameter(r3, "$this$getRoomDataCtxExt");
        o r4 = z51.a.g(r3);
        if (r4 == null) goto L13;
        m r5 = r4.getRoom();
        if (r5 == null) goto L13;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L13;
        r2 = r6.getIdStr();
    L13:
        r1.append(r2);
        ALogger.e("UserInfoWidgetAbility", r1.toString());
    L14:
        o r7 = z51.a.h(this.c, 2);
        if (r7 == null) goto L21;
        n r8 = r7.getTemplateContext();
        if (r8 == null) goto L21;
        z70.b r9 = (z70.b) r8.getValue();
        if (r9 == null) goto L21;
        boolean r10 = r9.j("anchor_avatar");
    L23:
        if (r10 == false) goto L31;
        if (r0 == null) goto L32;
        RoomAvator r12 = gb2.b.c(r0);
        if (r12 != null) goto L28;
        return false;
    L28:
        if (r12.getFansClubType() != 0) goto L34;
        return true;
    L34:
        return false;
    L32:
        return false;
    L31:
        return true;
    L21:
        r10 = false;
        goto L23
    }

    @Override // m91.c
    public final k getAvatarThumb() {
        RoomAuthStatus r2 = null;
        Room r0 = (Room) this.c.get("data_room", null);
        if (r0 != null) goto L15;
        StringBuilder r1 = new StringBuilder("cur room is null.room id :");
        DataContext r3 = this.d;
        if (r3 == null) goto L13;
        Intrinsics.checkNotNullParameter(r3, "$this$getRoomDataCtxExt");
        o r4 = z51.a.g(r3);
        if (r4 == null) goto L13;
        m r5 = r4.getRoom();
        if (r5 == null) goto L13;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L13;
        String r7 = r6.getIdStr();
    L14:
        r1.append(r7);
        ALogger.e("UserInfoWidgetAbility", r1.toString());
    L13:
        r7 = null;
    L15:
        o r8 = z51.a.h(this.c, 2);
        if (r8 == null) goto L22;
        n r9 = r8.getTemplateContext();
        if (r9 == null) goto L22;
        z70.b r10 = (z70.b) r9.getValue();
        if (r10 == null) goto L22;
        boolean r12 = r10.j("anchor_avatar");
    L23:
        if (r12 == false) goto L29;
        if (r0 == null) goto L37;
        RoomAvator r13 = gb2.b.c(r0);
        if (r13 != null) goto L28;
        return null;
    L28:
        return r13.getAvatar();
    L37:
        return null;
    L29:
        User r14 = r0.getOwner();
        if (r14 == null) goto L39;
        RoomAuthStatus r15 = r0.getMRoomAuthStatus();
        if ((r15 instanceof RoomAuthStatus) == false) goto L36;
        r2 = r15;
    L36:
        return r14.getAvatarThumbByRoomAuth(r2);
    L39:
        return null;
    L22:
        r12 = false;
        goto L23
    }

    @Override // m91.c
    public Context getContext() {
        return this.b.getContext();
    }

    @Override // m91.c
    public final String getName() {
        RoomAuthStatus r2 = null;
        Room r0 = (Room) this.c.get("data_room", null);
        if (r0 != null) goto L15;
        StringBuilder r1 = new StringBuilder("cur room is null.room id :");
        DataContext r3 = this.d;
        if (r3 == null) goto L13;
        Intrinsics.checkNotNullParameter(r3, "$this$getRoomDataCtxExt");
        o r4 = z51.a.g(r3);
        if (r4 == null) goto L13;
        m r5 = r4.getRoom();
        if (r5 == null) goto L13;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L13;
        String r7 = r6.getIdStr();
    L14:
        r1.append(r7);
        ALogger.e("UserInfoWidgetAbility", r1.toString());
    L13:
        r7 = null;
    L15:
        User r8 = r0.getOwner();
        if (r8 == null) goto L23;
        RoomAuthStatus r9 = r0.getMRoomAuthStatus();
        if ((r9 instanceof RoomAuthStatus) == false) goto L22;
        r2 = r9;
    L22:
        return r8.getRealNickNameByRoomAuth(r2);
    L23:
        return null;
    }

    @Override // m91.c
    public final IRoom getRoom() {
        String r2 = null;
        IRoom r0 = (IRoom) this.c.get("data_room", null);
        if (r0 != null) goto L14;
        StringBuilder r1 = new StringBuilder("cur room is null.room id :");
        DataContext r3 = this.d;
        if (r3 == null) goto L13;
        Intrinsics.checkNotNullParameter(r3, "$this$getRoomDataCtxExt");
        o r4 = z51.a.g(r3);
        if (r4 == null) goto L13;
        m r5 = r4.getRoom();
        if (r5 == null) goto L13;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L13;
        r2 = r6.getIdStr();
    L13:
        r1.append(r2);
        ALogger.e("UserInfoWidgetAbility", r1.toString());
    L14:
        return r0;
    }

    @Override // m91.c
    public final boolean isAnchor() {
        return ((Boolean) this.c.get("data_is_anchor", Boolean.FALSE)).booleanValue();
    }

    @Override // m91.c
    public final boolean isPortrait() {
        return ((Boolean) this.c.get("data_is_portrait", Boolean.FALSE)).booleanValue();
    }

    @Override // m91.c
    public final boolean a() {
        return this.f;
    }

    @Override // m91.c
    public final aa1.a b() {
        return this.e;
    }

    @Override // m91.c
    public final LifecycleOwner e() {
        return this.a;
    }

    @Override // m91.c
    public final DataCenter getDataCenter() {
        return this.c;
    }

    @Override // m91.c
    public final Fragment getFragment() {
        return this.b;
    }

    @Override // m91.c
    public final DataContext getRoomContext() {
        return this.d;
    }

    public d(MiddlewareRoomRecyclableWidget r2, Fragment r3, DataCenter r4, DataContext r5, aa1.a r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "widgetLifeOwner");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "userInfoVM");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
