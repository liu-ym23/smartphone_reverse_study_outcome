package com.bytedance.android.livesdk.interactivity.api.like.utils;

import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncData;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.message.model.d4;
import com.bytedance.android.livesdk.model.b1;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import u32.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class UserInfoDiggBridge implements l.a, WeakHandler.IHandler {
    public static final int e = 0;
    public static final int f = 0;
    public final WeakHandler a;
    public long b;
    public long c;
    public final DataCenter d;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/like/utils/UserInfoDiggBridge$Companion$HandlerMessage;", BuildConfig.FLAVOR, "MSG_CHECK_RENEWAL", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum HandlerMessage extends Enum<HandlerMessage> {
            public static final HandlerMessage MSG_CHECK_RENEWAL = null;
            public static final /* synthetic */ HandlerMessage[] a = null;

            static {
                HandlerMessage r1 = new HandlerMessage();
                MSG_CHECK_RENEWAL = r1;
                a = new HandlerMessage[]{r1};
            }

            public static HandlerMessage valueOf(String r1) {
                return (HandlerMessage) r27.a.a(HandlerMessage.class, r1);
            }

            public static HandlerMessage[] values() {
                return (HandlerMessage[]) a.clone();
            }

            public HandlerMessage() {
                super("MSG_CHECK_RENEWAL", 0);
            }
        }
    }

    static {
        e = ColorProtector.parseColor("#FACE15");
        f = ColorProtector.parseColor("#b3ffffff");
    }

    public final l a() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.d, 0, 2);
        if (r0 == null) goto L9;
        DiggContext r1 = com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a(r0);
        if (r1 == null) goto L9;
        j<l> r2 = r1.getDoubleLikeManager();
        if (r2 == null) goto L9;
        return (l) r2.getValue();
    L9:
        return null;
    }

    public final void c() {
        this.c = -1;
        this.b = -1;
        this.a.removeMessages(Companion.HandlerMessage.MSG_CHECK_RENEWAL.ordinal());
    }

    public UserInfoDiggBridge(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.d = r3;
        this.a = new WeakHandler(Looper.getMainLooper(), this);
        this.b = -1;
        this.c = -1;
    }

    public final void handleMsg(Message r6) {
        if (r6 == null) goto L4;
        Integer r7 = Integer.valueOf(r6.what);
    L5:
        Companion.HandlerMessage r0 = Companion.HandlerMessage.MSG_CHECK_RENEWAL;
        int r1 = r0.ordinal();
        if (r7 != null) goto L9;
        return;
    L9:
        if (r7.intValue() == r1) goto L11;
        return;
    L11:
        if (this.c == this.b) goto L13;
        this.d.put("cmd_user_info_sub_title_anim", new b1("双倍点赞中", e));
        this.c = this.b;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L16;
        this.a.sendEmptyMessageDelayed(r0.ordinal(), RiskAdviseSyncData.PRIORITY);
        return;
    L16:
        this.a.sendEmptyMessageDelayed(r0.ordinal(), 2000);
        return;
    L13:
        r8 = false;
        goto L14
    L4:
        r7 = null;
        goto L5
    }

    @Override // u32.l.a
    public final void b(l r4, com.bytedance.android.livesdk.interactivity.api.like.model.a r5) {
        Intrinsics.checkNotNullParameter(r4, "vm");
        Intrinsics.checkNotNullParameter(r5, "detail");
        c();
        this.b = r5.b();
        DiggContext r6 = com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a(RoomContext.a.c(RoomContext.Companion, this.d, 0, 2));
        if (r6 == null) goto L7;
        m<Boolean> r7 = r6.getInDoubleLike();
        if (r7 == null) goto L7;
        r7.setValue(Boolean.TRUE);
    L7:
        this.a.sendEmptyMessage(Companion.HandlerMessage.MSG_CHECK_RENEWAL.ordinal());
    }

    @Override // u32.l.a
    public final void e(l r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "vm");
        c();
        DiggContext r6 = com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a(RoomContext.a.c(RoomContext.Companion, this.d, 0, 2));
        if (r6 == null) goto L8;
        m<Boolean> r7 = r6.getInDoubleLike();
        if (r7 == null) goto L9;
        r7.setValue(Boolean.FALSE);
        return;
    L9:
        return;
    }

    @Override // u32.l.a
    public final void k(l r3, List<d4> r4) {
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "userRank");
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "userRank");
    }

    @Override // u32.l.a
    public final void l(l r2, com.bytedance.android.livesdk.interactivity.api.like.model.a r3) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        Intrinsics.checkNotNullParameter(r3, "detail");
        this.b = r3.b();
    }

    @Override // u32.l.a
    public final void d(l r4, int r5, int r6, Text r7, Text r8) {
        Intrinsics.checkNotNullParameter(r4, "vm");
        Intrinsics.checkNotNullParameter(r7, "normalText");
        Intrinsics.checkNotNullParameter(r8, "joinText");
        if (r5 <= 0) goto L30;
        RoomContext.a r9 = RoomContext.Companion;
        RoomContext r10 = RoomContext.a.c(r9, this.d, 0, 2);
        if (r10 == null) goto L12;
        i r11 = r10.isAnchor();
        if (r11 == null) goto L12;
        Boolean r13 = (Boolean) r11.getValue();
        if (r13 == null) goto L12;
        boolean r14 = r13.booleanValue();
    L13:
        if (r14 == true) goto L26;
        RoomContext r15 = RoomContext.a.c(r9, this.d, 0, 2);
        if (r15 == null) goto L24;
        m r16 = r15.getRoom();
        if (r16 == null) goto L24;
        Room r17 = (Room) r16.getValue();
        if (r17 == null) goto L24;
        User r18 = r17.getOwner();
        if (r18 == null) goto L24;
        boolean r19 = r18.isFollowing();
    L25:
        if (r19 == true) goto L26;
        String r20 = "%s赞值得关注";
    L28:
        DataCenter r21 = this.d;
        StringCompanionObject r23 = StringCompanionObject.INSTANCE;
        r21.put("cmd_user_info_sub_title_anim", new b1(String.format(r20, Arrays.copyOf(new Object[]{Integer.valueOf(r5 * 2)}, 1)), e));
        return;
    L24:
        r19 = false;
    L26:
        r20 = "%s赞";
    L12:
        r14 = false;
        goto L13
    }
}
