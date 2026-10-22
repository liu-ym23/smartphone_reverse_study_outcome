package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import android.view.View;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.v0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends s {
    public final long l;
    public final s.c m;
    public final PublicScreenConfig$MessageModelType n;
    public final f o;
    public PSMessageAction p;
    public final v0 q;
    public final boolean r;

    public static final class a implements DisplayTimeRecorder.a {
        public final /* synthetic */ e a;

        @Override // com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder.a
        public final void b(DisplayTimeRecorder.b r2) {
            Intrinsics.checkNotNullParameter(r2, "record");
        }

        public a(e r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder.a
        public final void a(int r2) {
            if (r2 != 1) goto L6;
            com.bytedance.android.livesdk.interactivity.api.base.b.a r3 = com.bytedance.android.livesdk.interactivity.api.base.b.m;
            q r0 = q.a;
            boolean r1 = this.a.q.isFromOtherIntercomRoom();
            r3.getClass();
            com.bytedance.android.livesdk.interactivity.api.base.b.a.c(r1);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final IPublicAreaCommon c() {
        return this.q.getOrInitPublicAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final IBaseUser f() {
        return this.q.getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final DisplayTimeRecorder j() {
        return new DisplayTimeRecorder(this.q, new a(this));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final PSMessageAction a() {
        return this.p;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s, com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.j<? extends com.bytedance.android.livesdk.interactivity.api.publicscreen.i, ? extends PSMessageViewHolder> b() {
        return this.o;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final long d() {
        return this.l;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public PublicScreenConfig$MessageModelType getType() {
        return this.n;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final boolean h() {
        return this.r;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
    public final s.c k() {
        return this.m;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
    public final boolean m(View r18) {
        Intrinsics.checkNotNullParameter(r18, "view");
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        String r2 = null;
        if (r1 == null) goto L12;
        o r3 = IRoomContextService.a.a(r1, null, 0, 3);
        if (r3 == null) goto L12;
        m r4 = r3.getRoom();
        if (r4 == null) goto L12;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L12;
        String r6 = r5.getAnchorId();
        if (r6 == null) goto L12;
    L13:
        IBaseUser r7 = this.q.getUserInfo();
        if (r7 == null) goto L31;
        String r8 = r7.getIdString();
        if (r8 == null) goto L31;
        if (r8.length() <= 0) goto L20;
        boolean r9 = true;
    L21:
        if (r9 != true) goto L31;
        IBaseUser r10 = this.q.getUserInfo();
        if (r10 == null) goto L25;
        String r11 = r10.getIdString();
    L27:
        if (Intrinsics.areEqual(r11, r6) == false) goto L31;
        if ((!Intrinsics.areEqual(r6, "0")) == false) goto L31;
        boolean r13 = true;
    L32:
        String r14 = gm2.q.a(this.q.getUserInfo(), r13);
        u22.m r15 = new u22.m(r14);
        r15.l = OpenInputSource.LongPressMessage;
        IBaseUser r16 = this.q.getUserInfo();
        if (r16 == null) goto L38;
        String r17 = r16.getIdString();
        if (r17 == null) goto L38;
        String r19 = r17;
    L39:
        long r110 = this.q.getMessageId();
        IBaseUser r20 = this.q.getUserInfo();
        if (r20 == null) goto L42;
        r2 = r20.getWebcastUid();
    L42:
        u22.m.a r21 = new u22.m.a("message", r13, r19, 2, r14, r110, r2);
        r21.k = this.q.isFromOtherIntercomRoom();
        r21.j = this.q.getUserInfo();
        r21.a("message_type", this.q.getMessageMethod());
        r21.a("is_reply_user_show", "0");
        r15.e = r21;
        xs2.b.a().post(r15);
        return true;
    L38:
        r19 = BuildConfig.FLAVOR;
        goto L39
    L25:
        r11 = null;
        goto L27
    L20:
        r9 = false;
    L31:
        r13 = false;
    L12:
        r6 = BuildConfig.FLAVOR;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
    public final boolean n(View r4, tb2.b r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if ((r5 instanceof tb2.e) == false) goto L5;
        v0 r6 = this.q;
        LinkedHashMap r1 = new LinkedHashMap();
        p.a(r1, r6);
        p.b(r6.getMessageMethod(), "schema", r1);
    L5:
        Intrinsics.checkNotNullParameter(r4, "view");
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
    public final void l(View r1, g52.d r2, g52.c r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        IBaseUser r4 = this.q.getUserInfo();
        if (r4 != null) goto L5;
        return;
    L5:
        UserProfileEvent r5 = new UserProfileEvent(r4);
        v0 r6 = this.q;
        r5.mClickFromMessage = r6;
        r5.setFromOtherIntercomRoom(r6.isFromOtherIntercomRoom());
        xs2.b.a().post(r5);
        v0 r7 = this.q;
        LinkedHashMap r8 = new LinkedHashMap();
        p.a(r8, r7);
        p.b(r7.getMessageMethod(), "default_user", r8);
    }

    public e(v0 r3, tb2.d r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "renderText");
        this.q = r3;
        this.r = r5;
        this.e = Long.valueOf(r3.getMessageId());
        this.f = r3.getMessageMethod();
        this.g = Long.valueOf(r3.getTimestamp());
        m0 r0 = r3.getBaseMessage();
        if (r0 == null) goto L5;
        r0.isDispatch();
    L5:
        this.l = r3.getReceiveTime();
        this.m = new s.c(r4, r6, 2);
        this.n = PublicScreenConfig$MessageModelType.EMOJI_CHAT;
        this.o = f.c;
        if (r5 == false) goto L8;
        PSMessageAction r7 = PSMessageAction.SYSTEM;
    L9:
        this.p = r7;
        return;
    L8:
        r7 = PSMessageAction.CHAT;
        goto L9
    }
}
