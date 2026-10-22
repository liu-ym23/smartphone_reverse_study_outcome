package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.digitavatar.AvatarGender;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarMsgController;
import com.bytedance.android.live.liveinteract.digitavatar.c0;
import com.bytedance.android.live.liveinteract.digitavatar.y;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.live.bizlink.api.platform.status.common.LinkBizApiLocalException;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o {
    public final CompositeDisposable a;
    public String b;
    public VideoShowMode c;
    public final e d;
    public final com.bytedance.android.live.liveinteract.digitavatar.h e;
    public boolean f;
    public AvatarGender g;
    public AvatarGender h;
    public final a i;
    public long j;
    public final boolean k;
    public VideoShowMode l;
    public boolean m;
    public final DigitAvatarMsgController n;
    public final com.bytedance.android.live.effect.api.o o;
    public final j1 p;

    public static final class a<T> implements Observer {
        public final /* synthetic */ o a;

        public a(o r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Integer r6 = (Integer) r5;
            if (r6 != null) goto L6;
        L7:
            this.a.c(VideoShowMode.AUDIO);
        L8:
            o r1 = this.a;
            if (r6 != null) goto L12;
        L14:
            boolean r7 = false;
        L16:
            if (r1.m == r7) goto L26;
            r1.m = r7;
            if (r7 == false) goto L24;
            DigitAvatarContext r8 = DigitAvatarContext.Companion.getContext();
            if (r8 == null) goto L24;
            com.bytedance.live.datacontext.m<Boolean> r9 = r8.getUsedAvatarThisLinkRound();
            if (r9 == null) goto L24;
            r9.setValue(Boolean.FALSE);
        L24:
            r1.e(r1.l, true, null, "online");
            return;
        L26:
            return;
        L12:
            if (r6.intValue() != 2) goto L14;
            r7 = true;
            goto L16
        L6:
            if (r6.intValue() == 2) goto L8;
            goto L7
        }
    }

    public static final class b implements lg6.a<Unit> {
        public final /* synthetic */ o a;
        public final /* synthetic */ Sticker b;
        public final /* synthetic */ AvatarGender c;
        public final /* synthetic */ VideoShowMode d;

        public final void a(Unit r7) {
            Intrinsics.checkNotNullParameter(r7, "data");
            this.a.o.a("livedigitavatar", this.b, "VideoShowModeProcessor_startAvatarModeInner_onSuccess");
            DigitAvatarContext.a r8 = DigitAvatarContext.Companion;
            DigitAvatarContext r0 = r8.getContext();
            if (r0 == null) goto L30;
            com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r1 = r0.getDigitAvatar();
            if (r1 == null) goto L30;
            com.bytedance.android.live.liveinteract.digitavatar.n r2 = (com.bytedance.android.live.liveinteract.digitavatar.n) r1.getValue();
            if (r2 == null) goto L30;
            ALogger.i("KtvDigitAvatar", "avatar形象审核情况：audited=" + r2.e + ",auditOk=" + r2.c + ", avatarData=" + r2.d + ' ');
            String r3 = r2.d;
            if (r2.c == false) goto L19;
            if (r3 != null) goto L12;
        L15:
            boolean r4 = true;
        L16:
            if (r4 == true) goto L19;
            ALogger.i("KtvDigitAvatar", "等待avatar演唱道具ready");
            this.a.getClass();
            this.a.b = r3;
            goto L30
        L12:
            if (r3.length() == 0) goto L15;
            r4 = false;
        L19:
            if (r2.a == true) goto L30;
            if (r3 != null) goto L22;
        L25:
            boolean r5 = true;
        L26:
            if (r5 == true) goto L30;
            if (r2.e == true) goto L30;
            f2.b(2131918205, 0);
            goto L30
        L22:
            if (r3.length() == 0) goto L25;
            r5 = false;
        L30:
            this.a.h = this.c;
            o.g(true);
            DigitAvatarContext r6 = r8.getContext();
            if (r6 == null) goto L35;
            com.bytedance.live.datacontext.m<Boolean> r9 = r6.getUsedAvatarThisLinkRound();
            if (r9 == null) goto L35;
            r9.setValue(Boolean.TRUE);
        L35:
            this.a.b(this.c);
            this.a.j = System.currentTimeMillis();
            DigitAvatarContext r10 = r8.getContext();
            if (r10 == null) goto L38;
            DigitAvatarContext.setVideoShowMode$default(r10, VideoShowMode.DIGIT_AVATAR, null, 2, null);
        L38:
            DigitAvatarContext r11 = r8.getContext();
            if (r11 == null) goto L44;
            com.bytedance.live.datacontext.k<d> r12 = r11.getSetVideoShowModeResult();
            if (r12 == null) goto L45;
            r12.post(new d(this.d, VideoShowMode.DIGIT_AVATAR, true));
            return;
        L45:
            return;
        }

        public final void onFailed(Exception r7) {
            Intrinsics.checkNotNullParameter(r7, "exception");
            StringBuilder r0 = new StringBuilder("show mode 切换失败，from=");
            r0.append(this.d);
            r0.append(", to=");
            VideoShowMode r1 = VideoShowMode.DIGIT_AVATAR;
            r0.append(r1);
            ALogger.e("KtvDigitAvatar", r0.toString(), r7);
            int r2 = x.a;
            x.i(r1.name(), r7);
            TalkRoomBusinessFullLinkMonitor r3 = TalkRoomBusinessFullLinkMonitor.a;
            String r4 = r1.name();
            r3.getClass();
            TalkRoomBusinessFullLinkMonitor.n(r4, r7);
            this.a.getClass();
            if ((r7 instanceof LinkBizApiLocalException) == true) goto L5;
        L7:
            DigitAvatarContext.a r8 = DigitAvatarContext.Companion;
            DigitAvatarContext r5 = r8.getContext();
            if (r5 == null) goto L10;
            r5.setIsDigitAvatarLoading(false);
        L10:
            o r6 = this.a;
            r6.l = this.d;
            DigitAvatarContext r9 = r8.getContext();
            if (r9 == null) goto L13;
            DigitAvatarContext.setVideoShowMode$default(r9, this.a.c, null, 2, null);
        L13:
            this.a.o.b("livedigitavatar", "VideoShowModeProcessor_startAvatarModeInner_onError");
            DigitAvatarContext r10 = r8.getContext();
            if (r10 == null) goto L19;
            com.bytedance.live.datacontext.k<d> r11 = r10.getSetVideoShowModeResult();
            if (r11 == null) goto L20;
            r11.post(new d(this.d, r1, false));
            return;
        L20:
            return;
        L19:
            return;
        L5:
            if (((LinkBizApiLocalException) r7).getErrorCode() != (-10)) goto L7;
            f2.b(2131917584, 0);
            goto L7
        }

        public b(o r1, Sticker r2, AvatarGender r3, com.bytedance.android.live.liveinteract.digitavatar.videoavatar.b r4, VideoShowMode r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }
    }

    public static final class c implements lg6.a<Unit> {
        public final /* synthetic */ o a;
        public final /* synthetic */ VideoShowMode b;
        public final /* synthetic */ VideoShowMode c;

        public final void a(Unit r5) {
            Intrinsics.checkNotNullParameter(r5, "data");
            this.a.o.b("livedigitavatar", "VideoShowModeProcessor_startUseNonDigitAvatarMode_onSuccess");
            this.a.getClass();
            o.g(false);
            this.a.a();
            DigitAvatarContext.a r6 = DigitAvatarContext.Companion;
            DigitAvatarContext r0 = r6.getContext();
            if (r0 == null) goto L5;
            DigitAvatarContext.setVideoShowMode$default(r0, this.b, null, 2, null);
        L5:
            DigitAvatarContext r7 = r6.getContext();
            if (r7 == null) goto L11;
            com.bytedance.live.datacontext.k<d> r8 = r7.getSetVideoShowModeResult();
            if (r8 == null) goto L12;
            r8.post(new d(this.c, this.b, true));
            return;
        L12:
            return;
        }

        public final void onFailed(Exception r6) {
            Intrinsics.checkNotNullParameter(r6, "exception");
            ALogger.e("KtvDigitAvatar", "show mode 切换失败，from=" + this.c + ", to=" + this.b, r6);
            int r0 = x.a;
            x.i(this.b.name(), r6);
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            String r2 = this.b.name();
            r1.getClass();
            TalkRoomBusinessFullLinkMonitor.n(r2, r6);
            this.a.getClass();
            if ((r6 instanceof LinkBizApiLocalException) == true) goto L5;
        L7:
            this.a.l = this.c;
            DigitAvatarContext.a r7 = DigitAvatarContext.Companion;
            DigitAvatarContext r3 = r7.getContext();
            if (r3 == null) goto L10;
            DigitAvatarContext.setVideoShowMode$default(r3, this.c, null, 2, null);
        L10:
            DigitAvatarContext r8 = r7.getContext();
            if (r8 == null) goto L16;
            com.bytedance.live.datacontext.k<d> r9 = r8.getSetVideoShowModeResult();
            if (r9 == null) goto L17;
            r9.post(new d(this.c, this.b, false));
            return;
        L17:
            return;
        L16:
            return;
        L5:
            if (((LinkBizApiLocalException) r6).getErrorCode() != (-10)) goto L7;
            f2.b(2131917584, 0);
            goto L7
        }

        public c(o r1, VideoShowMode r2, com.bytedance.android.live.liveinteract.digitavatar.videoavatar.b r3, VideoShowMode r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }
    }

    public final void a() {
        if (this.j <= 0) goto L6;
        long r0 = System.currentTimeMillis() - this.j;
        int r4 = com.bytedance.android.live.liveinteract.digitavatar.x.a;
        boolean r5 = this.k;
        LinkedHashMap r6 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.digitavatar.x.c(r6, r5);
        r6.put("duration", String.valueOf(r0));
        j0.l().sendLog("livesdk_anchor_audinece_connection_avatar_model_duration", r6, new Object[]{am2.x.class, IRoom.class});
        this.j = 0;
        return;
    }

    public static void g(boolean r2) {
        DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.getCurrentUsingDigitAvatarInVideoTalkRoom();
        if (r1 != null) goto L7;
        return;
    L7:
        if (((Boolean) r1.getValue()).booleanValue() == r2) goto L12;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L12:
        return;
    }

    public final void b(AvatarGender r3) {
        if (this.k == true) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.d.getClass();
        this.d.b(r3, r0);
        return;
    L5:
        if (je0.d.f() == 12) goto L8;
        r0 = false;
        goto L9
    }

    public final void c(VideoShowMode r2) {
        this.c = r2;
        DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
        if (r0 == null) goto L6;
        r0.setLastVideoShowMode(r2);
        return;
    }

    public final void e(VideoShowMode r8, boolean r9, com.bytedance.android.live.liveinteract.digitavatar.videoavatar.b r10, String r11) {
        if (this.m == true) goto L6;
        g(false);
        return;
    L6:
        ALogger.i("KtvDigitAvatar", "start show mode: " + r8);
        int r0 = n.a[r8.ordinal()];
        if (r0 != 1) goto L9;
        VideoShowMode r5 = this.c;
        DigitAvatarContext r1 = DigitAvatarContext.Companion.getContext();
        if (r1 == null) goto L31;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r2 = r1.getDigitAvatar();
        if (r2 == null) goto L31;
        com.bytedance.android.live.liveinteract.digitavatar.n r3 = (com.bytedance.android.live.liveinteract.digitavatar.n) r2.getValue();
        if (r3 == null) goto L31;
        AvatarGender r4 = r3.b;
        if (r4 == null) goto L31;
    L32:
        AvatarGender r6 = r4;
        Sticker r7 = (Sticker) ((LinkedHashMap) y.a).get(r6);
        if (r7 == null) goto L35;
        this.f = false;
        d(r6, r7, r5, r9, r10, r11);
        return;
    L35:
        ALogger.w("KtvDigitAvatar", "使用avatar展示模式，but形象道具还未下载好, so等待avatar下载完成");
        f2.b(2131918208, 0);
        this.f = true;
        this.g = r6;
        return;
    L31:
        r4 = c0.b();
        goto L32
    L9:
        if (r0 != 2) goto L11;
        f(r8, this.c, r9, r10, r11);
        return;
    L11:
        if (r0 == 3) goto L14;
        return;
    L14:
        if (this.k == true) goto L16;
    L21:
        f(r8, this.c, r9, r10, r11);
        return;
    L16:
        if (aj0.a.d() == true) goto L18;
    L20:
        f2.b(2131916212, 0);
        ALogger.e("KtvDigitAvatar", "anchor no support show mode: " + r8);
        return;
    L18:
        if (aj0.a.b(o3.f().getCurrentRoom()) == false) goto L20;
        goto L20
    }

    public final void f(VideoShowMode r3, VideoShowMode r4, boolean r5, com.bytedance.android.live.liveinteract.digitavatar.videoavatar.b r6, String r7) {
        if (jc0.a.c() == false) goto L6;
        ALogger.i("KtvDigitAvatar", "video chorus can not switch mode");
        return;
    L6:
        cg6.a r0 = this.p.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L16;
        jg6.a r1 = r0.e5();
        if (r1 == null) goto L17;
        lh6.b r2 = r1.a();
        if (r2 == null) goto L18;
        if (r7 != null) goto L14;
        r7 = "startUseNonDigitAvatarMode";
    L14:
        r2.h(r3, r7, r5, new c(this, r3, r6, r4));
        return;
    L18:
        return;
    L17:
        return;
    }

    public o(boolean r2, VideoShowMode r3, boolean r4, DigitAvatarMsgController r5, com.bytedance.android.live.effect.api.o r6, j1 r7) {
        Intrinsics.checkNotNullParameter(r3, "showMode");
        Intrinsics.checkNotNullParameter(r5, "avatarMsgController");
        Intrinsics.checkNotNullParameter(r6, "stickerComposerManager");
        Intrinsics.checkNotNullParameter(r7, "scopeProvider");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.o = r6;
        this.p = r7;
        this.a = new CompositeDisposable();
        this.c = this.l;
        this.d = new e(r5, r2, true);
        this.e = new com.bytedance.android.live.liveinteract.digitavatar.h(r5, r2);
        AvatarGender r8 = AvatarGender.Male;
        this.g = r8;
        this.h = r8;
        this.i = new a(this);
    }

    public final void d(AvatarGender r10, Sticker r11, VideoShowMode r12, boolean r13, com.bytedance.android.live.liveinteract.digitavatar.videoavatar.b r14, String r15) {
        ALogger.i("KtvDigitAvatar", "开始使用avatar进行演唱");
        cg6.a r0 = this.p.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L13;
        jg6.a r1 = r0.e5();
        if (r1 == null) goto L14;
        lh6.b r2 = r1.a();
        if (r2 == null) goto L15;
        VideoShowMode r3 = VideoShowMode.DIGIT_AVATAR;
        if (r15 != null) goto L11;
        r15 = "startAvatarModeInner";
    L11:
        r2.h(r3, r15, r13, new b(this, r11, r10, r14, r12));
        return;
    L15:
        return;
    L14:
        return;
    }
}
