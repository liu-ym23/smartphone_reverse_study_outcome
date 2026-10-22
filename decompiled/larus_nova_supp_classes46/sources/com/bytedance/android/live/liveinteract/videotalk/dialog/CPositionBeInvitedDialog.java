package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/dialog/CPositionBeInvitedDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "RoomType", "ShowType", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CPositionBeInvitedDialog extends LiveDialogFragment {
    public static final /* synthetic */ int o = 0;
    public Map<Integer, View> d;
    public final CompositeDisposable e;
    public long f;
    public boolean g;
    public String h;
    public h1 i;
    public final int j;
    public ShowType k;
    public boolean l;
    public RoomType m;
    public DataCenter n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/dialog/CPositionBeInvitedDialog$RoomType;", "", "Video", "Audio", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum RoomType extends Enum<RoomType> {
        public static final RoomType Audio = null;
        public static final RoomType Video = null;
        public static final /* synthetic */ RoomType[] a = null;

        static {
            RoomType r1 = new RoomType("Video", 0);
            Video = r1;
            RoomType r2 = new RoomType("Audio", 1);
            Audio = r2;
            a = new RoomType[]{r1, r2};
        }

        public static RoomType valueOf(String r1) {
            return (RoomType) r27.a.a(RoomType.class, r1);
        }

        public static RoomType[] values() {
            return (RoomType[]) a.clone();
        }

        public RoomType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/dialog/CPositionBeInvitedDialog$ShowType;", "", "Invite", "Apply", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ShowType extends Enum<ShowType> {
        public static final ShowType Apply = null;
        public static final ShowType Invite = null;
        public static final /* synthetic */ ShowType[] a = null;

        static {
            ShowType r1 = new ShowType("Invite", 0);
            Invite = r1;
            ShowType r2 = new ShowType("Apply", 1);
            Apply = r2;
            a = new ShowType[]{r1, r2};
        }

        public static ShowType valueOf(String r1) {
            return (ShowType) r27.a.a(ShowType.class, r1);
        }

        public static ShowType[] values() {
            return (ShowType[]) a.clone();
        }

        public ShowType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static CPositionBeInvitedDialog a(ShowType r1, long r2, RoomType r4, boolean r5, String r6, h1 r7, DataCenter r8) {
            Intrinsics.checkNotNullParameter(r1, "showType");
            Intrinsics.checkNotNullParameter(r4, "roomType");
            Intrinsics.checkNotNullParameter(r6, "replyToUid");
            Intrinsics.checkNotNullParameter(r7, "msg");
            CPositionBeInvitedDialog r0 = new CPositionBeInvitedDialog();
            r0.k = r1;
            r0.f = r2;
            r0.m = r4;
            r0.g = r5;
            r0.h = r6;
            r0.i = r7;
            r0.n = r8;
            return r0;
        }
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ CPositionBeInvitedDialog a;

        public b(CPositionBeInvitedDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            CPositionBeInvitedDialog r4 = this.a;
            int r0 = CPositionBeInvitedDialog.o;
            Dialog r1 = r4.getDialog();
            Context r2 = r4.getContext();
            if (r1 == null) goto L17;
            if (r2 == null) goto L21;
            Dialog r5 = r4.getDialog();
            if (r5 == null) goto L18;
            View r6 = r5.getCurrentFocus();
            if (r6 == null) goto L22;
            InputMethodManager r7 = (InputMethodManager) r2.getSystemService("input_method");
            if (r7 != null) goto L14;
            return;
        L14:
            if (r7.isActive() == false) goto L20;
            r7.hideSoftInputFromWindow(r6.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L18:
            return;
        L21:
            return;
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ CPositionBeInvitedDialog a;

        public c(CPositionBeInvitedDialog r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Long r6 = (Long) r5;
            Intrinsics.checkNotNullParameter(r6, "sec");
            return Long.valueOf(((long) this.a.j) - r6.longValue());
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ CPositionBeInvitedDialog a;

        public d(CPositionBeInvitedDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            Long r9 = (Long) r8;
            ((TextView) this.a.S90(2131384151)).setText(s1.C(2131917997, new Object[]{Integer.valueOf((int) r9.longValue())}));
            if (r9.longValue() != 0) goto L14;
            this.a.U90(false, true);
            this.a.dismiss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r10 = DialogFragmentLancet.sLastShowStack;
            if (r10 == null) goto L15;
            com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L15:
            return;
        }
    }

    static {
    }

    public CPositionBeInvitedDialog() {
        this.d = new LinkedHashMap();
        this.e = new CompositeDisposable();
        this.h = "";
        this.j = 9;
        this.k = ShowType.Invite;
        this.m = RoomType.Video;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.e.dispose();
        if (this.l == true) goto L5;
        U90(false, false);
    L5:
        ((LinkedHashMap) this.d).clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.width = -1;
        r0.height = -1;
        r5.setAttributes(r0);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.setGravity(80);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new b(this));
        r3.setCanceledOnTouchOutside(false);
        return r3;
    }

    public final void U90(boolean r9, boolean r10) {
        this.l = true;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = null;
        if (this.g == false) goto L15;
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 == null) goto L7;
        r1 = r0.getLinkUserInfoCenter();
    L7:
        T90(r9, r10, r1, this.h, this.k);
        if (this.m != RoomType.Video) goto L12;
        rj0.k r11 = rj0.k.a.a();
        if (r11 == null) goto L27;
        r11.replyCPosition(this.f, this.h, r9);
        return;
    L27:
        return;
    L12:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r12 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r12 == null) goto L29;
        r12.replyCPosition(this.f, this.h, r9);
        return;
    L29:
        return;
    L15:
        rj0.l.n2.getClass();
        rj0.l r2 = rj0.l.a.a();
        if (r2 == null) goto L18;
        r1 = r2.getLinkUserInfoCenter();
    L18:
        T90(r9, r10, r1, this.h, this.k);
        if (this.m != RoomType.Video) goto L23;
        rj0.l r13 = rj0.l.a.a();
        if (r13 == null) goto L31;
        r13.replyCPosition(this.f, this.h, r9);
        return;
    L31:
        return;
    L23:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r14 = IVoiceChatGuestService.a.a();
        if (r14 == null) goto L33;
        r14.replyCPosition(this.f, this.h, r9);
        return;
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        h1 r13 = this.i;
        py.k r1 = null;
        if (r13 == null) goto L73;
        if (this.k != ShowType.Invite) goto L20;
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L11;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L11;
        String r4 = r3.getOwnerUserIdString();
    L12:
        com.bytedance.android.livesdk.message.linker.k r14 = r13.getLinkerEnlargeGuestInviteContent();
        if (r14 == null) goto L15;
        String r15 = com.bytedance.android.livesdk.message.linker.l.a(r14);
    L17:
        if ((!Intrinsics.areEqual(r4, r15)) == false) goto L19;
        ((TextView) S90(2131375600)).setText(2131922707);
        goto L73
    L19:
        ((TextView) S90(2131375600)).setText(2131922708);
        goto L73
    L15:
        r15 = null;
    L11:
        r4 = null;
        goto L12
    L20:
        com.bytedance.android.livesdk.message.linker.f r5 = r13.getLinkerEnlargeGuestApplyContent();
        if (r5 == null) goto L23;
        String r6 = r5.getApplyPrompts();
    L24:
        if (r6 != null) goto L26;
    L29:
        boolean r7 = true;
    L30:
        if (r7 == true) goto L32;
        ((TextView) S90(2131375600)).setText(r6);
        goto L73
    L32:
        com.bytedance.android.livesdk.message.linker.f r16 = r13.getLinkerEnlargeGuestApplyContent();
        if (r16 == null) goto L36;
        String r17 = r16.getFromUidStr();
        if (r17 == null) goto L36;
    L38:
        if (r17.length() != 0) goto L40;
        boolean r8 = true;
    L41:
        if (r8 == false) goto L44;
    L68:
        String r18 = null;
    L69:
        if (r18 != null) goto L71;
        r18 = "用户";
    L71:
        ((TextView) S90(2131375600)).setText(s1.C(2131922717, new Object[]{r18}));
        goto L73
    L44:
        if (this.g == false) goto L54;
        if (this.m != RoomType.Video) goto L50;
        rj0.k.m2.getClass();
        rj0.k r9 = rj0.k.a.a();
        if (r9 == null) goto L61;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r10 = r9.getLinkUserInfoCenter();
    L62:
        if (r10 == null) goto L68;
        ILinkPlayerInfoBridge r19 = (ILinkPlayerInfoBridge) r10.a5(r17, null);
        if (r19 == null) goto L68;
        IBaseUser r110 = r19.getUser();
        if (r110 == null) goto L68;
        r18 = r110.getNickName();
    L61:
        r10 = null;
        goto L62
    L50:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r20 = IVoiceChatGuestService.a.a();
        if (r20 == null) goto L61;
        r10 = r20.getLinkUserInfoCenter();
        goto L62
    L54:
        if (this.m != RoomType.Video) goto L58;
        rj0.l.n2.getClass();
        rj0.l r21 = rj0.l.a.a();
        if (r21 == null) goto L61;
        r10 = r21.getLinkUserInfoCenter();
        goto L62
    L58:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r22 = IVoiceChatGuestService.a.a();
        if (r22 == null) goto L61;
        r10 = r22.getLinkUserInfoCenter();
        goto L62
    L40:
        r8 = false;
    L36:
        r17 = "";
        goto L38
    L26:
        if (r6.length() == 0) goto L29;
        r7 = false;
        goto L30
    L23:
        r6 = null;
    L73:
        if (this.m != RoomType.Video) goto L102;
        S90(2131375609).setVisibility(0);
        h1 r23 = this.i;
        if (r23 == null) goto L79;
        com.bytedance.android.livesdk.message.linker.k r24 = r23.getLinkerEnlargeGuestInviteContent();
        if (r24 == null) goto L79;
        py.k r25 = r24.getUiImage();
    L81:
        if (r25 == null) goto L88;
        ViewGroup.LayoutParams r26 = S90(2131375609).getLayoutParams();
        r26.width = -1;
        r26.height = UtilityKotlinExtentionsKt.i(188);
        ImageView r27 = (ImageView) S90(2131375609);
        h1 r111 = this.i;
        if (r111 == null) goto L87;
        com.bytedance.android.livesdk.message.linker.k r112 = r111.getLinkerEnlargeGuestInviteContent();
        if (r112 == null) goto L87;
        r1 = r112.getUiImage();
    L87:
        ImageUtil.loadImage(r27, r1, -1, -1, false, 0, ImageView.ScaleType.FIT_CENTER, null);
    L129:
        ((TextView) S90(2131384151)).setOnClickListener(x0.a(new AnonymousClass5(this)));
        ((TextView) S90(2131361963)).setOnClickListener(x0.a(new AnonymousClass6(this)));
        ((TextView) S90(2131384151)).setText(s1.C(2131917997, new Object[]{Integer.valueOf(this.j)}));
        this.e.add(du2.a.d(1, TimeUnit.SECONDS).take(this.j + 1).map(new c(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)));
        return;
    L88:
        h1 r28 = this.i;
        if (r28 == null) goto L93;
        com.bytedance.android.livesdk.message.linker.f r29 = r28.getLinkerEnlargeGuestApplyContent();
        if (r29 == null) goto L93;
        py.k r30 = r29.getUiImage();
    L94:
        if (r30 == null) goto L101;
        ViewGroup.LayoutParams r31 = S90(2131375609).getLayoutParams();
        r31.width = -1;
        r31.height = UtilityKotlinExtentionsKt.i(188);
        ImageView r32 = (ImageView) S90(2131375609);
        h1 r113 = this.i;
        if (r113 == null) goto L100;
        com.bytedance.android.livesdk.message.linker.f r114 = r113.getLinkerEnlargeGuestApplyContent();
        if (r114 == null) goto L100;
        r1 = r114.getUiImage();
    L100:
        ImageUtil.loadImage(r32, r1, -1, -1, false, 0, ImageView.ScaleType.FIT_CENTER, null);
        goto L129
    L101:
        S90(2131375609).setImageURI("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ic_c_position_be_invite.png");
        ViewGroup.LayoutParams r115 = S90(2131375609).getLayoutParams();
        r115.width = UtilityKotlinExtentionsKt.i(158);
        r115.height = UtilityKotlinExtentionsKt.i(134);
    L93:
        r30 = null;
    L79:
        r25 = null;
        goto L81
    L102:
        S90(2131375608).setVisibility(0);
        h1 r33 = this.i;
        if (r33 == null) goto L107;
        com.bytedance.android.livesdk.message.linker.k r34 = r33.getLinkerEnlargeGuestInviteContent();
        if (r34 == null) goto L107;
        py.k r35 = r34.getUiImage();
    L108:
        if (r35 == null) goto L115;
        ImageView r36 = (ImageView) S90(2131375608);
        h1 r116 = this.i;
        if (r116 == null) goto L114;
        com.bytedance.android.livesdk.message.linker.k r117 = r116.getLinkerEnlargeGuestInviteContent();
        if (r117 == null) goto L114;
        r1 = r117.getUiImage();
    L114:
        ImageUtil.loadImage(r36, r1, -1, -1, false, 0, ImageView.ScaleType.FIT_CENTER, null);
        goto L129
    L115:
        h1 r37 = this.i;
        if (r37 == null) goto L120;
        com.bytedance.android.livesdk.message.linker.f r38 = r37.getLinkerEnlargeGuestApplyContent();
        if (r38 == null) goto L120;
        py.k r39 = r38.getUiImage();
    L121:
        if (r39 == null) goto L128;
        ImageView r40 = (ImageView) S90(2131375608);
        h1 r118 = this.i;
        if (r118 == null) goto L127;
        com.bytedance.android.livesdk.message.linker.f r119 = r118.getLinkerEnlargeGuestApplyContent();
        if (r119 == null) goto L127;
        r1 = r119.getUiImage();
    L127:
        ImageUtil.loadImage(r40, r1, -1, -1, false, 0, ImageView.ScaleType.FIT_CENTER, null);
        goto L129
    L128:
        S90(2131375608).setImageURI("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ic_c_position_audio_be_invite.png");
    L120:
        r39 = null;
    L107:
        r35 = null;
        goto L108
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131565795, r2);
    }

    public final void T90(boolean r11, boolean r12, com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r13, String r14, ShowType r15) {
        i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.E();
        Integer r2 = null;
        if (r13 == null) goto L33;
        Iterable r3 = r13.getOnlineUserList();
        if (r3 == null) goto L33;
        Iterable r4 = r3;
        if ((r4 instanceof Collection) == true) goto L9;
    L11:
        Iterator r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L33;
        ILinkPlayerInfoBridge r6 = (ILinkPlayerInfoBridge) r5.next();
        if (r6.isEnlarged() == false) goto L31;
        IBaseUser r7 = r6.getUser();
        if (r7 == null) goto L19;
        String r8 = r7.getIdString();
    L20:
        o r9 = com.bytedance.android.live.liveinteract.api.utils.m.n(null, Long.valueOf(this.f), 1);
        if (r9 == null) goto L27;
        com.bytedance.live.datacontext.m r10 = r9.getRoom();
        if (r10 == null) goto L27;
        IRoom r16 = (IRoom) r10.getValue();
        if (r16 == null) goto L27;
        String r17 = r16.getOwnerUserIdString();
    L29:
        if (Intrinsics.areEqual(r8, r17) == false) goto L31;
        boolean r18 = true;
    L32:
        if (r18 == false) goto L13;
    L27:
        r17 = null;
        goto L29
    L19:
        r8 = null;
    L31:
        r18 = false;
        goto L32
    L9:
        if (((Collection) r4).isEmpty() == false) goto L11;
    L33:
        if (r13 == null) goto L36;
        je0.d.j(r13);
    L36:
        if (r15 != ShowType.Invite) goto L42;
        h1 r19 = this.i;
        if (r19 == null) goto L47;
        com.bytedance.android.livesdk.message.linker.k r110 = r19.getLinkerEnlargeGuestInviteContent();
        if (r110 == null) goto L47;
        r2 = Integer.valueOf(r110.getTargetEnlargeGuestType());
    L47:
        if (r2 == null) goto L49;
        int r111 = r2.intValue();
    L51:
        if (r111 != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal()) goto L53;
        boolean r20 = true;
    L54:
        TalkRoomLogUtils.B.d0(r11, r12, r14, r15, r20, this.n);
        return;
    L53:
        r20 = false;
        goto L54
    L49:
        r111 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown.ordinal();
        goto L51
    L42:
        h1 r112 = this.i;
        if (r112 == null) goto L47;
        com.bytedance.android.livesdk.message.linker.f r113 = r112.getLinkerEnlargeGuestApplyContent();
        if (r113 == null) goto L47;
        r2 = Integer.valueOf(r113.getTargetEnlargeGuestType());
        goto L47
    }
}
