package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            this.a.onFinish();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ IRoom a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ g c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CompositeDisposable e;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ b a;
            public final /* synthetic */ DialogInterface b;

            public a(b r1, DialogInterface r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r11) {
                com.bytedance.android.live.network.response.a r12 = (com.bytedance.android.live.network.response.a) r11;
                this.b.dismiss();
                this.a.c.onFinish();
                i0 r13 = TalkRoomLogUtils.a;
                b r14 = this.a;
                boolean r0 = r14.b;
                IRoom r1 = r14.a;
                String r15 = r14.d;
                if (r0 == false) goto L5;
                int r2 = 30;
            L6:
                je0.d.d();
                u0.g(Integer.valueOf(r2), Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getAnchorManualUiLayout()), null, null);
                Pair[] r3 = new Pair[8];
                r3[0] = TuplesKt.to("live_type", "voice_live");
                String r4 = "";
                if (r1 == null) goto L10;
                String r6 = r1.getOwnerUserIdString();
                if (r6 == null) goto L10;
            L11:
                r3[1] = TuplesKt.to("anchor_id", r6);
                if (r1 == null) goto L15;
                String r5 = String.valueOf(r1.getRoomId());
                if (r5 == null) goto L15;
            L16:
                r3[2] = TuplesKt.to("room_id", r5);
                r3[3] = TuplesKt.to("layout_type", "stage_enlarge");
                if (r15 == null) goto L20;
                r4 = r15;
            L20:
                r3[4] = TuplesKt.to("enlarge_user_id", r4);
                com.bytedance.live.datacontext.m r7 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
                if (r7 == null) goto L25;
                IRoom r8 = (IRoom) r7.getValue();
                if (r8 == null) goto L25;
                String r9 = r8.getOwnerUserIdString();
            L27:
                if (Intrinsics.areEqual(r9, r15) == false) goto L29;
                String r16 = "anchor";
            L30:
                r3[5] = TuplesKt.to("enlarge_user_type", r16);
                if (r0 == false) goto L33;
                String r17 = "begin_enlarge";
            L34:
                r3[6] = TuplesKt.to("action_type", r17);
                r3[7] = TuplesKt.to("play_mode", com.bytedance.android.live.liveinteract.utils.w.a());
                Map r18 = MapsKt.mutableMapOf(r3);
                TalkRoomLogUtils.B0(r18, null, null, 6);
                j0.l().sendLog("livesdk_anchor_stage_enlarge_setting_click", r18, new Object[]{IRoom.class, am2.x.class});
                return;
            L33:
                r17 = "end_enlarge";
                goto L34
            L29:
                r16 = "guest";
            L25:
                r9 = null;
            L15:
                r5 = "";
            L10:
                r6 = "";
                goto L11
            L5:
                r2 = 27;
                goto L6
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.utils.e$b$b, reason: collision with other inner class name */
        public static final class C0105b<T> implements Consumer {
            public final /* synthetic */ b a;
            public final /* synthetic */ DialogInterface b;

            public C0105b(b r1, DialogInterface r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r2) {
                ApiServerException r3 = (Throwable) r2;
                if ((r3 instanceof ApiServerException) == false) goto L7;
                String r4 = r3.getPrompt();
                if (r4 == null) goto L7;
                f2.c(r4, 0);
            L7:
                this.b.dismiss();
                this.a.c.onFinish();
            }
        }

        public b(IRoom r1, boolean r2, g r3, String r4, CompositeDisposable r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r5, int r6) {
            LinkApi r7 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
            IRoom r0 = this.a;
            if (r0 == null) goto L5;
            long r1 = r0.getId();
        L6:
            Disposable r8 = r7.updateEnlargeStageSettings(r1, this.b, true).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r5), new C0105b(this, r5));
            this.e.add(r8);
            return;
        L5:
            r1 = 0;
            goto L6
        }
    }

    static {
    }

    @JvmStatic
    public static final boolean a(IRoom r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        int r0 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.b(r4) == true) goto L5;
        return false;
    L5:
        if (r5 == true) goto L14;
        com.bytedance.android.livesdk.user.e r1 = jc1.k.n(IMiddlewareUserService.class).user();
        if (r4 == null) goto L9;
        Long r7 = Long.valueOf(r4.getRoomId());
    L11:
        if (r1.E(r7) == true) goto L14;
        return false;
    L9:
        r7 = null;
    L14:
        if (TextUtils.isEmpty(r6) == false) goto L16;
        return false;
    L16:
        if (r5 == false) goto L22;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r8 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r8 == null) goto L27;
        tf0.o r9 = r8.commonWindowManager();
        if (r9 == null) goto L27;
        int r10 = r9.k(r6);
    L28:
        if (r10 == 0) goto L31;
        return false;
    L31:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getAnchorManualUiLayout() == 27) goto L34;
        return false;
    L34:
        if (TeamFightContext.Companion.h() == true) goto L61;
        Integer r11 = je0.d.h();
        if (r11 == null) goto L41;
        if (r11.intValue() == 24) goto L61;
    L41:
        if (je0.d.s() == true) goto L61;
        Integer r12 = je0.d.h();
        if (r12 != null) goto L46;
    L48:
        Integer r13 = je0.d.h();
        if (r13 != null) goto L52;
    L53:
        Integer r14 = je0.d.h();
        if (r14 != null) goto L57;
    L58:
        return false;
    L57:
        if (r14.intValue() != 30) goto L58;
        return true;
    L52:
        if (r13.intValue() != 27) goto L53;
        return true;
    L46:
        if (r12.intValue() != 28) goto L48;
    L61:
        return false;
    L27:
        r10 = -1;
        goto L28
    L22:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r15 = IVoiceChatGuestService.a.a();
        if (r15 == null) goto L27;
        tf0.o r16 = r15.commonWindowManager();
        if (r16 == null) goto L27;
        r10 = r16.k(r6);
        goto L28
    }

    @JvmStatic
    public static final void b(Context r10, boolean r11, IRoom r12, String r13, CompositeDisposable r14, g r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r13, "userId");
        Intrinsics.checkNotNullParameter(r14, "dispose");
        Intrinsics.checkNotNullParameter(r15, "listener");
        if (r11 == false) goto L5;
        String r0 = s1.B(2131923225);
    L6:
        if (r11 == false) goto L8;
        String r1 = s1.B(2131923224);
    L9:
        x0.b r2 = new x0.b(r10, 5);
        x0.d r16 = r2.a;
        r16.k = false;
        r16.c = r0;
        r16.d = r1;
        r2.i(1, 2131915442, new a(r15));
        r2.i(0, 2131915913, new b(r12, r11, r15, r13, r14));
        r2.n();
        return;
    L8:
        r1 = s1.B(2131923221);
        goto L9
    L5:
        r0 = s1.B(2131923222);
        goto L6
    }
}
