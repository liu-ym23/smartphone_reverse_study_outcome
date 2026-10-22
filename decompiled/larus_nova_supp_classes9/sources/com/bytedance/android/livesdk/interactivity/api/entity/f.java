package com.bytedance.android.livesdk.interactivity.api.entity;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.message.m4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.PublicAreaBadgeInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder;
import com.bytedance.android.livesdk.w7;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.android.livesdkapi.message.PersonalizedDisplayInfo;
import com.bytedance.bdlocation.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class f<T extends t> {
    public PSMessageAction A;
    public long B;
    public u42.b C;
    public Map<String, String> D;
    public boolean E;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d F;
    public String a;
    public final T b;
    public final int c;
    public long d;
    public boolean e;
    public String f;
    public boolean g;
    public boolean h;
    public final MessageSceneType i;
    public Spannable j;
    public h80.c<DisplayTimeRecorder> k;
    public PublicAreaBadgeInfo l;
    public final Map<String, String> m;
    public final Map<String, String> n;
    public Long o;
    public Long p;
    public Long q;
    public Boolean r;
    public long s;
    public final long t;
    public long u;
    public boolean v;
    public long w;
    public boolean x;
    public boolean y;
    public PSMessagePriority z;

    public f() {
        throw null;
    }

    public void C() {
    }

    public void F(tb2.b r1) {
    }

    public DisplayTimeRecorder I() {
        return null;
    }

    public boolean d() {
        return false;
    }

    public Spannable f() {
        return null;
    }

    public abstract Spannable g();

    public String h() {
        return null;
    }

    public void i(HashMap<String, String> r1) {
    }

    public MessageIdentity n() {
        return null;
    }

    public com.bytedance.android.livesdk.interactivity.api.publicscreen.i s() {
        return null;
    }

    public abstract IBaseUser x();

    public boolean z() {
        return false;
    }

    public final boolean A() {
        if (jc1.k.f(IMiddlewareUserService.class) != null) goto L7;
        return false;
    L7:
        return TextUtils.equals(y(), jc1.k.f(IMiddlewareUserService.class).user().n());
    }

    public final h80.c<DisplayTimeRecorder> D() {
        if (this.k != null) goto L6;
        this.k = h80.c.c(I());
    L6:
        return this.k;
    }

    public int k() {
        int r0 = MessageCommonColorUtil.a;
        MessageSceneType r1 = MessageSceneType.DEFAULT;
        return MessageCommonColorUtil.d();
    }

    public final com.bytedance.android.live.base.model.data.b l() {
        m4 r0 = this.b;
        if ((r0 instanceof m4) == true) goto L5;
        return null;
    L5:
        return r0.getStatusInfo();
    }

    public Spannable m() {
        if (this.j != null) goto L6;
        this.j = f();
    L6:
        return this.j;
    }

    public final long o() {
        T r0 = this.b;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.getMessageId();
    }

    public Long p() {
        T r0 = this.b;
        if (r0 == null) goto L7;
        return Long.valueOf(r0.getReceiveTime());
    L7:
        return 0L;
    }

    public Spannable q() {
        if (this.j != null) goto L6;
        this.j = f();
    L6:
        return this.j;
    }

    public int r() {
        int r0 = MessageCommonColorUtil.a;
        MessageSceneType r1 = MessageSceneType.DEFAULT;
        return MessageCommonColorUtil.d();
    }

    public final long u() {
        if (this.b.getBaseMessage() == null) goto L10;
        if (this.b.getBaseMessage().getPriorityScore() == 0) goto L10;
        return this.b.getBaseMessage().getPriorityScore();
    L10:
        return this.d;
    }

    public IPublicAreaCommon v() {
        if (((Boolean) w7.a.getValue()).booleanValue() == false) goto L8;
        u3 r0 = this.b;
        if ((r0 instanceof u3) == false) goto L8;
        return r0.getOrInitPublicAreaCommon();
    L8:
        return null;
    }

    public tb2.d w() {
        return new tb2.d();
    }

    public final String e() {
        C();
        return null;
    }

    public yb2.a j() {
        yb2.a r0 = w.a();
        User r2 = null;
        if (jc1.k.f(IRoomContextService.class) != null) goto L5;
    L7:
        User r1 = null;
    L9:
        if (jc1.k.f(IMiddlewareUserService.class) == null) goto L11;
        r2 = jc1.k.f(IMiddlewareUserService.class).user().b();
    L11:
        if (r2 == null) goto L16;
        if (r1 != null) goto L14;
    L15:
        r1 = r2;
        goto L16
    L14:
        if (TextUtils.equals(r2.getIdString(), r1.getIdString()) == false) goto L15;
    L16:
        r0.a = r();
        r0.d = k();
        r0.c = k();
        r0.b = k();
        int r3 = MessageCommonColorUtil.a;
        MessageSceneType r4 = MessageSceneType.DEFAULT;
        r0.e = MessageCommonColorUtil.d();
        C();
        r0.j = false;
        if (r1 == null) goto L19;
        r0.g = r1.getIdString();
        r0.h = r1.getWebcastUid();
        r0.i = r1.getNickName();
    L19:
        return r0;
    L5:
        if (jc1.k.f(IRoomContextService.class).getRoomDataContext(null, 0).getUser() == null) goto L7;
        r1 = jc1.k.f(IRoomContextService.class).getRoomDataContext(null, 0).getUser();
        goto L9
    }

    public PersonalizedDisplayInfo t() {
        if (v() != null) goto L5;
        return null;
    L5:
        if (v().getPersonalizedInfo() != null) goto L7;
        return null;
    L7:
        return v().getPersonalizedInfo();
    }

    public final String y() {
        if (x() != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return x().getIdString();
    }

    public Boolean B() {
        return Boolean.FALSE;
    }

    public int getType() {
        return this.c;
    }

    public boolean E(g52.c r2) {
        if (x() != null) goto L6;
        return false;
    L6:
        UserProfileEvent r3 = new UserProfileEvent(x());
        r3.setClickUserPosition("comment_area");
        xs2.b.a().post(r3);
        J("default_user");
        return true;
    }

    public boolean G(Context r11) {
        if (x() != null) goto L6;
        return false;
    L6:
        String r5 = gm2.q.b(x());
        T r13 = this.b;
        if (r13 != null) goto L9;
        long r0 = 0;
    L10:
        long r6 = r0;
        u22.m r14 = new u22.m(r5);
        r14.l = OpenInputSource.LongPressMessage;
        r14.g = System.currentTimeMillis();
        boolean r2 = TextUtils.equals(y(), this.f);
        String r3 = y();
        if (x() != null) goto L13;
        String r1 = null;
    L14:
        u22.m.a r9 = new u22.m.a("message", r2, r3, 2, r5, r6, r1);
        r9.k = this.b.isFromOtherIntercomRoom();
        r9.j = x();
        r9.a("message_type", this.b.getMessageMethod());
        r9.a("is_reply_user_show", "0");
        r14.e = r9;
        xs2.b.a().post(r14);
        return true;
    L13:
        r1 = x().getWebcastUid();
        goto L14
    L9:
        r0 = r13.getMessageId();
        goto L10
    }

    public final void J(String r3) {
        HashMap<String, String> r0 = new HashMap();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p.a(r0, this.b);
        Map<String, String> r1 = this.D;
        if (r1 == null) goto L5;
        r0.putAll(r1);
    L5:
        i(r0);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p.b(this.b.getMessageMethod(), r3, r0);
    }

    public final void c(tb2.d r5) {
        if (this.b != null) goto L5;
        return;
    L5:
        if (x() == null) goto L25;
        MessageIdentity r0 = n();
        if (r0 != null) goto L10;
    L12:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L18;
        if (r0 == null) goto L18;
        final py.k r1 = r0.getIdentityLabel();
    L19:
        if (r1 == null) goto L21;
        r5.a(new b(this, r1));
        return;
    L21:
        IBaseUser r3 = x();
        C();
        r5.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r3, null, true, this.e));
        return;
    L18:
        r1 = null;
        goto L19
    L10:
        if (r0.getShowIdentity() != 1) goto L12;
        r2 = true;
        goto L14
    }

    public f(T r8, int r9) {
        this.a = "默认优先级";
        this.d = 0;
        this.g = false;
        this.h = false;
        this.i = MessageSceneType.PUBLIC_SCREEN;
        this.l = null;
        this.m = new HashMap();
        this.n = new HashMap();
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = null;
        this.s = 0;
        this.t = System.nanoTime();
        this.u = 0;
        this.w = 0;
        this.x = false;
        this.y = false;
        this.z = PSMessagePriority.NORMAL;
        this.A = PSMessageAction.UNKNOW;
        this.B = 0;
        this.C = null;
        this.D = null;
        this.b = r8;
        this.c = r9;
    }

    public f(T r2, MessageSceneType r3) {
        this(r2, 0);
        this.i = r3;
    }

    public f(T r1, MessageSceneType r2, int r3) {
        this(r1, r3);
        this.i = r2;
    }

    public void H(View r4, g52.c r5, final TextMessageRenderViewHolder r6, WeakReference r7) {
        ALogger.d("PSOperatePanel", "onViewClickStandardize");
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.h.b(this.b) == false) goto L19;
        if (com.bytedance.android.livesdk.interactivity.api.q.a() == null) goto L19;
        if (com.bytedance.android.livesdk.interactivity.api.q.a().e(this.b, r4, new c(this, r6)) == false) goto L14;
        this.h = true;
        if (r5 == null) goto L11;
        ((TextMessageWidget) r5).Aq();
    L11:
        J("audience_action_sheet");
        Function1 r8 = (Function1) r7.get();
        if (r8 == null) goto L26;
        r8.invoke(Boolean.TRUE);
        return;
    L26:
        return;
    L14:
        this.h = false;
        boolean r9 = E(r5);
        Function1 r10 = (Function1) r7.get();
        if (r10 == null) goto L28;
        r10.invoke(Boolean.valueOf(r9));
        return;
    L28:
        return;
    L19:
        if (jc1.k.f(IInteractivityInjectService.class) == null) goto L21;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).openPSOperatePanel(this.b, r4.getContext(), null, new e(this, r7, r5));
    L24:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p.d(this, "content");
        return;
    L21:
        boolean r11 = E(r5);
        Function1 r13 = (Function1) r7.get();
        if (r13 == null) goto L24;
        r13.invoke(Boolean.valueOf(r11));
        goto L24
    }
}
