package com.bytedance.android.live.liveinteract.videotalk.dialog;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.utils.f0;
import com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService;
import com.bytedance.android.livehostapi.foundation.depend.NewPluginType;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.sj1;
import com.bytedance.android.livesdk.config.w60;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.live.datacontext.DataContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import hh1.v0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nz.t;
import uf2.d0;
import uf2.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/dialog/InteractBeautyPreviewDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractBeautyPreviewDialog extends LiveDialogFragment {
    public static final /* synthetic */ int A = 0;
    public Map<Integer, View> d;
    public String e;
    public final CompositeDisposable f;
    public v0 g;
    public rj0.a h;
    public ViewGroup.LayoutParams i;
    public ViewGroup j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public d0 o;
    public h0.e p;
    public Disposable q;
    public final e r;
    public Function1<? super Dialog, Unit> s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public boolean x;
    public final d0.b y;
    public ByteBuffer z;

    public static final class a {
        @JvmStatic
        public static InteractBeautyPreviewDialog a(rj0.a r1, String r2, Function1 r3) {
            Intrinsics.checkNotNullParameter(r2, "eventPage");
            InteractBeautyPreviewDialog r0 = new InteractBeautyPreviewDialog();
            r0.e = r2;
            r0.h = r1;
            r0.s = r3;
            return r0;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ InteractBeautyPreviewDialog a;

        public b(InteractBeautyPreviewDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.liveinteract.digitavatar.videoavatar.d r4 = (com.bytedance.android.live.liveinteract.digitavatar.videoavatar.d) r3;
            VideoShowMode r0 = r4.a;
            if (r0 == VideoShowMode.VIDEO) goto L7;
            if (r0 == VideoShowMode.DIGIT_AVATAR) goto L7;
            return;
        L7:
            if (r4.b != VideoShowMode.AUDIO) goto L22;
            Disposable r1 = this.a.q;
            if (r1 == null) goto L12;
            r1.dispose();
        L12:
            if (r4.c == false) goto L19;
            InteractBeautyPreviewDialog r5 = this.a;
            v0 r2 = r5.g;
            if ((r2 instanceof m00.g) == true) goto L16;
            r2 = null;
        L16:
            m00.g r6 = (m00.g) r2;
            if (r6 == null) goto L23;
            r5.Y90();
            int r7 = this.a.n;
            r6.openCamera();
            return;
        L23:
            return;
        L19:
            this.a.l = false;
            return;
        }
    }

    public static final class c implements h0.e.a {
        public c() {
        }
    }

    public static final class d implements d0.b.a {
        public d() {
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ InteractBeautyPreviewDialog a;

        public e(InteractBeautyPreviewDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            if (this.a.k == hd0.c.f().h()) goto L14;
            InteractBeautyPreviewDialog r4 = this.a;
            r4.k = hd0.c.f().h();
            this.a.dismiss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L15;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L15:
            return;
        }
    }

    public static final class f implements LiveBottomSheetDialog.k {
        public final /* synthetic */ InteractBeautyPreviewDialog a;

        public f(InteractBeautyPreviewDialog r1) {
            this.a = r1;
        }

        public final void a(boolean r2) {
            if (Intrinsics.areEqual("NewVideoLinkJSB", this.a.e) == false) goto L8;
            rj0.a r3 = this.a.h;
            if (r3 == null) goto L9;
            r3.onCancel();
            return;
        L9:
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ InteractBeautyPreviewDialog a;
        public final /* synthetic */ DataContext b;

        public g(InteractBeautyPreviewDialog r1, DataContext r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            InteractBeautyPreviewDialog r7 = this.a;
            int r0 = InteractBeautyPreviewDialog.A;
            r7.getClass();
            if (jc1.k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() != 1) goto L5;
            boolean r8 = true;
        L6:
            List r2 = null;
            if (r8 == false) goto L18;
            this.a.getClass();
            IMultiPkAudienceLinkOutService r9 = (IMultiPkAudienceLinkOutService) jc1.k.f(IMultiPkAudienceLinkOutService.class);
            if (r9 == null) goto L11;
            Object r10 = r9.getGuestLinkViewNew();
        L13:
            if ((r10 instanceof m00.g) == true) goto L15;
            r10 = null;
        L15:
            m00.g r11 = (m00.g) r10;
            if (r11 == null) goto L18;
            r11.f();
            goto L18
        L11:
            r10 = null;
        L18:
            InteractBeautyPreviewDialog r12 = this.a;
            r12.m = true;
            r12.V90();
            this.a.dismiss();     // Catch: Exception -> L21
        L25:
            InteractBeautyPreviewDialog r13 = this.a;
            if (r13.l == false) goto L33;
            v0 r14 = r13.g;
            if ((r14 instanceof m00.g) == true) goto L30;
            r14 = null;
        L30:
            m00.g r15 = (m00.g) r14;
            if (r15 == null) goto L33;
            r15.f();
        L33:
            rj0.a r16 = this.a.h;
            if (r16 == null) goto L36;
            r16.onCancel();
        L36:
            HashMap r17 = new HashMap();
            r17.put("live_type", "video_live");
            com.bytedance.live.datacontext.j r3 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.b).getVideoTalkRoomSubScene();
            if (r3 == null) goto L43;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r3.getValue();
            if (r4 == null) goto L43;
            com.bytedance.android.livesdk.chatroom.viewmodel.j r5 = r4.t();
            if (r5 == null) goto L43;
            TalkRoomLogUtils.B0(r17, Integer.valueOf(r5.a), null, 4);
        L43:
            com.bytedance.live.datacontext.j r18 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.b).getVideoTalkRoomSubScene();
            if (r18 == null) goto L57;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r19 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r18.getValue();
            if (r19 == null) goto L57;
            com.bytedance.android.livesdk.chatroom.viewmodel.j r20 = r19.t();
            if (r20 == null) goto L57;
            List r21 = r20.b;
            if (r21 == null) goto L57;
            if (r21.contains(1) == false) goto L54;
            r2 = r21;
        L54:
            if (r2 == null) goto L57;
            r17.put("play_type", "video_friend");
        L57:
            if (hd0.c.f().h() == false) goto L59;
            String r22 = "linking";
        L60:
            r17.put("show_scene", r22);
            r17.put("button_name", ((TextView) this.a.S90(2131390273)).getText().toString());
            f0.a(r17);
            j0.l().sendLog("livesdk_guest_connection_user_camera_end", r17, new Object[]{IRoom.class, x.class});
            return;
        L59:
            r22 = "before_link";
        L21:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r23 = DialogFragmentLancet.sLastShowStack;
            if (r23 == null) goto L25;
            com.bytedance.crash.d.d(r23, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L25
        L5:
            r8 = false;
            goto L6
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ InteractBeautyPreviewDialog a;
        public final /* synthetic */ DataContext b;

        public static final class a implements qh0.d<rh0.a> {
            public final /* synthetic */ h a;

            @Override // qh0.d
            public final void b(BaseCheckException r2) {
                Intrinsics.checkNotNullParameter(r2, "exception");
            }

            public a(h r1) {
                this.a = r1;
            }

            @Override // qh0.d
            public final void onResult(rh0.a r3) {
                InteractBeautyPreviewDialog r4 = this.a.a;
                if (r4 != null) goto L5;
                return;
            L5:
                if (r4.getView() == null) goto L16;
                TextView r5 = (TextView) this.a.a.S90(2131381501);
                if (r5 == null) goto L10;
                r5.setVisibility(8);
            L10:
                Button r6 = (Button) this.a.a.S90(2131381500);
                if (r6 == null) goto L13;
                r6.setVisibility(8);
            L13:
                this.a.a.X90();
                this.a.a.Z90();
                h r7 = this.a;
                InteractBeautyPreviewDialog.U90(r7.a, r7.b);
                return;
            }
        }

        public h(InteractBeautyPreviewDialog r1, DataContext r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Context r3 = this.a.getContext();
            if (r3 != null) goto L5;
            return;
        L5:
            if (m60.c.d(r3, new String[]{"android.permission.CAMERA"}) == false) goto L7;
            InteractBeautyPreviewDialog.U90(this.a, this.b);
            return;
        L7:
            InteractBeautyPreviewDialog.T90(this.a, new a(this));
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ InteractBeautyPreviewDialog a;

        public i(InteractBeautyPreviewDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.liveinteract.digitavatar.videoavatar.d r4 = (com.bytedance.android.live.liveinteract.digitavatar.videoavatar.d) r3;
            InteractBeautyPreviewDialog r0 = this.a;
            if (r0.l == false) goto L5;
            return;
        L5:
            if (r0.k == true) goto L7;
            return;
        L7:
            if (r4.b == VideoShowMode.VIDEO) goto L19;
            r0.dismissAllowingStateLoss();     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L20;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L20:
            return;
        }
    }

    static {
    }

    public final void V90() {
        m00.g r0 = this.g;
        if ((r0 instanceof m00.g) == false) goto L16;
        if (r0 == null) goto L15;
        m00.g r1 = r0;
        rj0.a r2 = this.h;
        if (r2 == null) goto L16;
        if (r2.a() != true) goto L16;
        if (this.t == false) goto L16;
        this.t = false;
        r1.getSurfaceView().setVisibility(this.v);
        if (this.u == true) goto L16;
        r1.closeCamera();
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.widget.IVideoTalkLinkView");
    L16:
        m00.d r3 = this.g;
        if ((r3 instanceof m00.d) == false) goto L30;
        if (r3 == null) goto L29;
        m00.d r4 = r3;
        rj0.a r5 = this.h;
        if (r5 != null) goto L22;
        return;
    L22:
        if (r5.a() == true) goto L24;
        return;
    L24:
        if (this.t == false) goto L33;
        this.t = false;
        r4.getSurfaceView().setVisibility(this.v);
        if (this.u == true) goto L34;
        r4.closeCamera();
        return;
    L34:
        return;
    L33:
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.widget.IInteractVideoView");
    }

    public final void Y90() {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        VideoShowMode r1 = null;
        if (r0 == null) goto L5;
        ei6.a r2 = r0.Z0();
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        if (((Boolean) vm2.d.W7.getValue(null, vm2.d.a[461(0x1cd, float:6.46E-43)])).booleanValue() == true) goto L10;
        return;
    L10:
        if (this.k == false) goto L48;
        xi6.c r3 = r2.t();
        if (r3 == null) goto L49;
        com.bytedance.live.livelink.kmp.impl.core.video.b r4 = r3.f();
        if (r4 != null) goto L16;
        return;
    L16:
        if (((com.bytedance.live.livelink.kmp.impl.core.video.f) r4).g == true) goto L51;
        DigitAvatarContext r5 = DigitAvatarContext.Companion.getContext();
        if (r5 == null) goto L21;
        r1 = r5.getCurrentVideoShowMode();
    L21:
        if (r1 != VideoShowMode.AUDIO) goto L52;
        Set<Long> r6 = InteractLinkFullLinkMonitor.a;
        int r7 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.LinkMedia, "startLinkPreviewBlackFrame", 0, null, null, 112);
        ByteBuffer r8 = ByteBuffer.allocateDirect(384);
        int r9 = 0;
        int r10 = 0;
    L24:
        if (r10 >= 256) goto L26;
        r8.put((byte) 0);
        r10 = r10 + 1;
        goto L24
    L26:
        int r11 = 0;
    L28:
        if (r11 >= 64) goto L30;
        r8.put((byte) 128);
        r11 = r11 + 1;
    L30:
        if (r9 >= 64) goto L32;
        r8.put((byte) 128);
        r9 = r9 + 1;
        goto L30
    L32:
        r8.rewind();
        this.z = r8;
        xi6.c r12 = r2.t();
        if (r12 == null) goto L37;
        com.bytedance.live.livelink.kmp.impl.core.video.b r13 = r12.f();
        if (r13 == null) goto L37;
        r13.a(this.y);
    L37:
        xi6.c r14 = r2.t();
        if (r14 == null) goto L53;
        com.bytedance.live.livelink.kmp.impl.core.video.b r15 = r14.f();
        if (r15 == null) goto L54;
        r15.g(true);
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L49:
        return;
    L48:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public InteractBeautyPreviewDialog() {
        this.d = new LinkedHashMap();
        this.e = "";
        this.f = new CompositeDisposable();
        this.r = new e(this);
        this.u = true;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r0 = ILiveWrappedLivePusher.a.b();
        if (r0 == null) goto L5;
        d0.b r1 = r0.newLiveCoreVideoFrameAvailableListener(new d());
    L6:
        this.y = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void W90() {
        if (getView() != null) goto L6;
        return;
    L6:
        if (((Boolean) vm2.d.G4.getValue(null, vm2.d.a[290(0x122, float:4.06E-43)])).booleanValue() == true) goto L8;
        return;
    L8:
        if (this.k == false) goto L49;
        DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.getCurrentVideoShowMode() != VideoShowMode.VIDEO) goto L14;
    L15:
        Disposable r1 = this.q;
        if (r1 == null) goto L18;
        r1.dispose();
    L18:
        this.q = r0.getSetVideoShowModeResult().onEvent().subscribe(new b(this));
        v0 r2 = this.g;
        if ((r2 instanceof m00.g) == true) goto L21;
        r2 = null;
    L21:
        m00.g r3 = (m00.g) r2;
        if (r3 == null) goto L24;
        r3.a();
    L24:
        IMultiPkAudienceLinkOutService r4 = (IMultiPkAudienceLinkOutService) jc1.k.f(IMultiPkAudienceLinkOutService.class);
        if (r4 == null) goto L27;
        Object r5 = r4.getGuestLinkViewNew();
    L29:
        if ((r5 instanceof m00.g) == true) goto L31;
        r5 = null;
    L31:
        m00.g r6 = (m00.g) r5;
        if (r6 == null) goto L34;
        r6.a();
    L34:
        v0 r7 = this.g;
        if ((r7 instanceof m00.d) == true) goto L37;
        r7 = null;
    L37:
        m00.d r8 = (m00.d) r7;
        if (r8 == null) goto L40;
        r8.a();
    L40:
        v0 r9 = this.g;
        if ((r9 instanceof m00.g) == true) goto L43;
        r9 = null;
    L43:
        m00.g r10 = (m00.g) r9;
        if (r10 == null) goto L46;
        this.n = r10.j();
    L46:
        this.l = true;
        r0.setSkipFrequencyCheck(true);
        r0.setUpdateShowModeSource("apply_from_avatar");
        DigitAvatarContext.setVideoShowMode$default(r0, VideoShowMode.AUDIO, null, 2, null);
        return;
    L27:
        r5 = null;
        goto L29
    L14:
        if (r0.getCurrentVideoShowMode() == VideoShowMode.DIGIT_AVATAR) goto L15;
        return;
    }

    public final void X90() {
        if (getView() != null) goto L5;
        return;
    L5:
        rj0.a r0 = this.h;
        h0.e r1 = null;
        if (r0 == null) goto L10;
        vc0.a r2 = r0.getSurfaceView();
        if (r2 == null) goto L10;
        Object r3 = r2.a;
    L12:
        if ((r3 instanceof v0) == true) goto L14;
        r3 = null;
    L14:
        v0 r4 = (v0) r3;
        this.g = r4;
        if ((r4 instanceof m00.g) == true) goto L17;
        r4 = null;
    L17:
        m00.g r5 = (m00.g) r4;
        if (r5 == null) goto L21;
        r5.o();
    L21:
        if (((Boolean) vm2.d.H4.getValue(null, vm2.d.a[291(0x123, float:4.08E-43)])).booleanValue() == false) goto L23;
    L66:
        SurfaceView r6 = new SurfaceView(getContext());
        FrameLayout r7 = (FrameLayout) S90(2131382912);
        if (r7 == null) goto L70;
        r7.addView(r6);
    L70:
        if (sj1.b(je0.d.f()) == false) goto L74;
        if (sj1.c() == false) goto L74;
    L76:
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r8 = ILiveWrappedLivePusher.a.b();
        if (r8 == null) goto L79;
        r8.newRenderView(r6);
    L79:
        v0 r9 = this.g;
        if (r9 == null) goto L82;
        d0 r10 = r9.getLiveCore();
    L83:
        this.o = r10;
        ALogger.d("InteractBeautyPreviewDialog", "use single view mode live core " + this.o);
        ILiveWrappedLivePusher r11 = ILiveWrappedLivePusher.a.b();
        if (r11 == null) goto L86;
        r1 = r11.newTextureFrameAvailableListener(new c());
    L86:
        this.p = r1;
        d0 r12 = this.o;
        if (r12 == null) goto L90;
        r12.g0();
    L90:
        if (je0.d.O() == true) goto L94;
        if (this.x == true) goto L94;
    L101:
        Y90();
        return;
    L94:
        if (((Boolean) w60.a.getValue()).booleanValue() == false) goto L101;
        View r13 = S90(2131387889);
        if (r13 == null) goto L98;
        r13.setVisibility(0);
    L98:
        View r14 = S90(2131387889);
        if (r14 == null) goto L101;
        r14.setOnClickListener(x0.a(new InteractBeautyPreviewDialog$initSwitchCameraBtn$1(this)));
        goto L101
    L82:
        r10 = null;
    L74:
        if (this.x == true) goto L76;
        r6.setZOrderOnTop(true);
        goto L76
    L23:
        if (je0.d.U() == true) goto L66;
        if ((this.g instanceof SurfaceView) == false) goto L90;
        StringBuilder r15 = new StringBuilder("parent when viewcreated: ");
        SurfaceView r16 = this.g;
        if (r16 == null) goto L65;
        r15.append(r16.getParent());
        ALogger.e("InteractBeautyPreviewDialog", r15.toString());
        if (getView() != null) goto L32;
        return;
    L32:
        FrameLayout r17 = (FrameLayout) S90(2131382912);
        if (r17 == null) goto L35;
        r17.setVisibility(0);
    L35:
        h0.e r18 = this.g;
        if ((r18 instanceof SurfaceView) == false) goto L39;
        r1 = r18;
    L39:
        SurfaceView r19 = (SurfaceView) r1;
        if (r19 == null) goto L47;
        ViewParent r20 = r19.getParent();
        if (r20 == null) goto L47;
        if ((r20 instanceof ViewGroup) == false) goto L47;
        ViewGroup r21 = (ViewGroup) r20;
        this.j = r21;
        this.i = r19.getLayoutParams();
        r21.removeView(r19);
    L47:
        if (sj1.b(je0.d.f()) == false) goto L51;
        if (sj1.c() == false) goto L51;
    L57:
        FrameLayout r22 = (FrameLayout) S90(2131382912);
        if (r22 == null) goto L90;
        SurfaceView r23 = this.g;
        if (r23 == null) goto L63;
        r22.addView(r23);
        goto L90
    L63:
        throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
    L51:
        if (this.x == true) goto L57;
        SurfaceView r24 = this.g;
        if (r24 == null) goto L56;
        r24.setZOrderOnTop(true);
        goto L57
    L56:
        throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
    L65:
        throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
    L10:
        r3 = null;
        goto L12
    }

    public final void Z90() {
        if (getView() != null) goto L5;
        return;
    L5:
        m00.g r0 = this.g;
        if ((r0 instanceof m00.g) == false) goto L15;
        if (r0 == null) goto L14;
        m00.g r1 = r0;
        rj0.a r2 = this.h;
        if (r2 == null) goto L15;
        if (r2.a() != true) goto L15;
        this.u = r1.isCameraOpen();
        this.v = r1.getSurfaceView().getVisibility();
        r1.openCamera();
        r1.getSurfaceView().setVisibility(0);
        this.t = true;
        goto L15
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.widget.IVideoTalkLinkView");
    L15:
        m00.d r3 = this.g;
        if ((r3 instanceof m00.d) == false) goto L25;
        if (r3 == null) goto L24;
        m00.d r4 = r3;
        rj0.a r5 = this.h;
        if (r5 != null) goto L21;
        return;
    L21:
        if (r5.a() != true) goto L27;
        this.u = r4.isCameraOpen();
        this.v = r4.getSurfaceView().getVisibility();
        r4.openCamera();
        r4.getSurfaceView().setVisibility(0);
        this.t = true;
        return;
    L27:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.widget.IInteractVideoView");
    }

    public final void onDestroyView() {
        super.onDestroyView();
        v0 r0 = this.g;
        VideoShowMode r2 = null;
        if ((r0 instanceof m00.g) == true) goto L5;
        r0 = null;
    L5:
        m00.g r1 = (m00.g) r0;
        if (r1 == null) goto L8;
        r1.o();
    L8:
        rj0.l.n2.getClass();
        rj0.l r3 = rj0.l.a.a();
        if (r3 == null) goto L11;
        ei6.a r4 = r3.Z0();
    L12:
        if (r4 == null) goto L23;
        xi6.c r5 = r4.t();
        if (r5 == null) goto L18;
        com.bytedance.live.livelink.kmp.impl.core.video.b r6 = r5.f();
        if (r6 == null) goto L18;
        r6.g(false);
    L18:
        xi6.c r7 = r4.t();
        if (r7 == null) goto L23;
        com.bytedance.live.livelink.kmp.impl.core.video.b r8 = r7.f();
        if (r8 == null) goto L23;
        r8.f(this.y);
    L23:
        ByteBuffer r9 = this.z;
        if (r9 == null) goto L26;
        r9.clear();
    L26:
        hd0.c.f().e(this.r);
        V90();
        if (((Boolean) vm2.d.H4.getValue(null, vm2.d.a[291(0x123, float:4.08E-43)])).booleanValue() == false) goto L29;
    L46:
        d0 r10 = this.o;
        if (r10 == null) goto L49;
        r10.H();
    L49:
        Disposable r11 = this.q;
        if (r11 == null) goto L53;
        r11.dispose();
    L53:
        if (this.l == false) goto L62;
        DigitAvatarContext r12 = DigitAvatarContext.Companion.getContext();
        if (r12 == null) goto L58;
        r2 = r12.getCurrentVideoShowMode();
    L58:
        if (r2 != VideoShowMode.AUDIO) goto L62;
        rj0.a r13 = this.h;
        if (r13 == null) goto L62;
        r13.onCancel();
    L62:
        IMultiLinkServiceExternal r14 = jc1.k.f(IMultiLinkServiceExternal.class);
        if (r14 == null) goto L73;
        yr0.f r15 = r14.getPkServiceExternal();
        if (r15 == null) goto L73;
        if (r15.getPkState() != 1) goto L73;
        if (this.m == true) goto L73;
        rj0.a r16 = this.h;
        if (r16 == null) goto L73;
        r16.onCancel();
    L73:
        this.f.clear();
        ((LinkedHashMap) this.d).clear();
        return;
    L29:
        if (je0.d.U() == true) goto L46;
        v0 r17 = this.g;
        if ((r17 instanceof SurfaceView) == true) goto L34;
        r17 = null;
    L34:
        SurfaceView r18 = (SurfaceView) r17;
        if (r18 == null) goto L49;
        FrameLayout r19 = (FrameLayout) S90(2131382912);
        if (r19 == null) goto L40;
        r19.removeView(r18);
    L40:
        ViewGroup r20 = this.j;
        if (r20 != null) goto L43;
    L45:
        this.j = null;
        goto L49
    L43:
        if (r18.getParent() != null) goto L45;
        r18.setLayoutParams(this.i);
        r20.addView(r18);
        goto L45
    L11:
        r4 = null;
        goto L12
    }

    public final void onDetach() {
        super/*androidx.fragment.app.DialogFragment*/.onDetach();
        rj0.a r0 = this.h;
        if (r0 != null) goto L5;
    L6:
        v0 r1 = this.g;
        if (r1 == null) goto L11;
        r1.release();
        return;
    L11:
        return;
    L5:
        if (r0.b() == true) goto L6;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment*/.onStart();
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEngineOn() == true) goto L13;
        m00.g r1 = this.g;
        if ((r1 instanceof m00.g) == false) goto L14;
        if (r1 == null) goto L11;
        r1.openCamera();
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.widget.IVideoTalkLinkView");
    L14:
        return;
    }

    public final void onStop() {
        super/*androidx.fragment.app.DialogFragment*/.onStop();
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEngineOn() == true) goto L13;
        m00.g r1 = this.g;
        if ((r1 instanceof m00.g) == false) goto L14;
        if (r1 == null) goto L11;
        r1.closeCamera();
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.widget.IVideoTalkLinkView");
    L14:
        return;
    }

    public final boolean onBackPressed() {
        return this.w;
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

    public final Dialog onCreateDialog(Bundle r3) {
        LiveBottomSheetDialog r4 = super.onCreateDialog(r3);
        if (r4 == null) goto L5;
        r4.setCanceledOnTouchOutside(true);
    L5:
        Function1<? super Dialog, Unit> r0 = this.s;
        if (r0 == null) goto L9;
        Unit r1 = (Unit) r0.invoke(r4);
    L9:
        if ((r4 instanceof LiveBottomSheetDialog) == true) goto L11;
        LiveBottomSheetDialog r2 = null;
    L12:
        LiveBottomSheetDialog r5 = r2;
        if (r5 == null) goto L15;
        r5.setLiveBottomSheetOutsideListener(new f(this));
    L15:
        return r4;
    L11:
        r2 = r4;
        goto L12
    }

    public static final void T90(InteractBeautyPreviewDialog r4, qh0.d r5) {
        Context r6 = r4.getContext();
        if (r6 == null) goto L6;
        OperateType r0 = OperateType.APPLY;
        ArrayList r1 = new ArrayList();
        r1.add(new qh0.f.b(r6, r0, 1));
        r1.add(new qh0.f.d(r6, r0, 1, true));
        r1.add(new qh0.f.C0257f(r6, r0, 1, true));
        qh0.f.a(r1).a(r5);
        return;
    }

    public static final void U90(InteractBeautyPreviewDialog r5, DataContext r6) {
        r5.m = true;
        r5.V90();
        r5.dismiss();     // Catch: Exception -> L5
    L9:
        rj0.a r1 = r5.h;
        if (r1 == null) goto L12;
        r1.onConfirm();
    L12:
        com.bytedance.android.livesdk.sharedpref.e r2 = b6.I;
        Boolean r3 = Boolean.TRUE;
        r2.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r3);
        HashMap r4 = new HashMap();
        r4.put("live_type", "video_live");
        com.bytedance.live.datacontext.j r7 = com.bytedance.android.live.liveinteract.api.utils.m.g(r6).getVideoTalkRoomSubScene();
        List r8 = null;
        if (r7 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r9 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r7.getValue();
        if (r9 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r10 = r9.t();
        if (r10 == null) goto L19;
        TalkRoomLogUtils.B0(r4, Integer.valueOf(r10.a), null, 4);
    L19:
        com.bytedance.live.datacontext.j r11 = com.bytedance.android.live.liveinteract.api.utils.m.g(r6).getVideoTalkRoomSubScene();
        if (r11 == null) goto L33;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r12 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r11.getValue();
        if (r12 == null) goto L33;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r13 = r12.t();
        if (r13 == null) goto L33;
        List r14 = r13.b;
        if (r14 == null) goto L33;
        if (r14.contains(1) == false) goto L30;
        r8 = r14;
    L30:
        if (r8 == null) goto L33;
        r4.put("play_type", "video_friend");
    L33:
        if (hd0.c.f().h() == false) goto L35;
        String r15 = "linking";
    L36:
        r4.put("show_scene", r15);
        r4.put("button_name", ((TextView) r5.S90(2131390381)).getText().toString());
        f0.a(r4);
        j0.l().sendLog("livesdk_guest_connection_user_camera_start", r4, new Object[]{IRoom.class, x.class});
        return;
    L35:
        r15 = "before_link";
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r16 = DialogFragmentLancet.sLastShowStack;
        if (r16 == null) goto L9;
        com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        DataContext r9 = com.bytedance.live.datacontext.d.d(o.class);
        this.k = hd0.c.f().h();
        hd0.c.f().c(this.r);
        if (getView() != null) goto L5;
        return;
    L5:
        FrameLayout r10 = (FrameLayout) S90(2131382912);
        if (r10 == null) goto L8;
        r10.setVisibility(0);
    L8:
        Context r11 = getContext();
        if (r11 == null) goto L35;
        boolean r12 = m60.c.d(r11, new String[]{"android.permission.CAMERA"});
        NewPluginType r3 = NewPluginType.LiveResource;
        if (r3.isInstalled() == true) goto L16;
        boolean r4 = tb1.d.a;
        if (r3.checkLoaded() == true) goto L16;
        boolean r5 = false;
    L17:
        r3.checkLoaded();
        if (r12 == false) goto L29;
        if (r5 == false) goto L29;
        com.bytedance.android.scope.m r13 = com.bytedance.android.scope.m.e;
        f00.a.a r6 = f00.a.b;
        t r14 = (t) r13.d(r6, t.class);
        if (r14 != null) goto L23;
    L27:
        ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).init();
    L28:
        X90();
        Z90();
        W90();
        goto L35
    L23:
        if (r14.isOpen() != true) goto L27;
        t r15 = (t) r13.d(r6, t.class);
        if (r15 == null) goto L28;
        r15.init();
    L29:
        TextView r16 = (TextView) S90(2131381501);
        if (r16 == null) goto L32;
        r16.setVisibility(0);
    L32:
        Button r17 = (Button) S90(2131381500);
        if (r17 == null) goto L35;
        r17.setVisibility(0);
    L16:
        r5 = true;
    L35:
        Button r18 = (Button) S90(2131381500);
        if (r18 == null) goto L38;
        r18.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L38:
        TextView r2 = (TextView) S90(2131390273);
        if (r2 == null) goto L41;
        r2.setOnClickListener(new g(this, r9));
    L41:
        TextView r19 = (TextView) S90(2131390381);
        if (r19 == null) goto L44;
        r19.setOnClickListener(new h(this, r9));
    L44:
        rj0.a r20 = this.h;
        if (r20 == null) goto L47;
        r20.c();
    L47:
        rj0.a r21 = this.h;
        if (r21 == null) goto L59;
        String r22 = r21.getConfirmText();
        if (r22 == null) goto L59;
        if (r22.length() <= 0) goto L54;
        boolean r23 = true;
    L55:
        if (r23 == false) goto L59;
        TextView r24 = (TextView) S90(2131390381);
        if (r24 == null) goto L59;
        r24.setText(r22);
        goto L59
    L54:
        r23 = false;
    L59:
        rj0.a r25 = this.h;
        if (r25 == null) goto L71;
        String r26 = r25.getCancelText();
        if (r26 == null) goto L71;
        if (r26.length() <= 0) goto L66;
        boolean r27 = true;
    L67:
        if (r27 == false) goto L71;
        TextView r28 = (TextView) S90(2131390273);
        if (r28 == null) goto L71;
        r28.setText(r26);
        goto L71
    L66:
        r27 = false;
    L71:
        DigitAvatarContext r29 = DigitAvatarContext.Companion.getContext();
        if (r29 == null) goto L80;
        com.bytedance.live.datacontext.k<com.bytedance.android.live.liveinteract.digitavatar.videoavatar.d> r30 = r29.getSetVideoShowModeResult();
        if (r30 == null) goto L80;
        PublishSubject r31 = r30.onEvent();
        if (r31 == null) goto L80;
        Disposable r32 = r31.subscribe(new i(this));
        if (r32 == null) goto L80;
        RxUtilKt.c(r32, this.f);
    L80:
        IMiddlewareBroadcastService r33 = (IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class);
        if (r33 == null) goto L83;
        r33.linkEffectHelper();
    L83:
        FrameLayout r34 = (FrameLayout) S90(2131364073);
        List r35 = null;
        if (r34 == null) goto L86;
        UtilityKotlinExtentionsKt.z(r34, !((Boolean) vm2.h.E0.getValue(null, vm2.h.a[81])).booleanValue());
    L86:
        HashMap r36 = new HashMap();
        r36.put("live_type", "video_live");
        com.bytedance.live.datacontext.j r37 = com.bytedance.android.live.liveinteract.api.utils.m.g(r9).getVideoTalkRoomSubScene();
        if (r37 == null) goto L93;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r38 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r37.getValue();
        if (r38 == null) goto L93;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r39 = r38.t();
        if (r39 == null) goto L93;
        TalkRoomLogUtils.B0(r36, Integer.valueOf(r39.a), null, 4);
    L93:
        com.bytedance.live.datacontext.j r40 = com.bytedance.android.live.liveinteract.api.utils.m.g(r9).getVideoTalkRoomSubScene();
        if (r40 == null) goto L107;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r41 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r40.getValue();
        if (r41 == null) goto L107;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r42 = r41.t();
        if (r42 == null) goto L107;
        List r43 = r42.b;
        if (r43 == null) goto L107;
        if (r43.contains(1) == false) goto L104;
        r35 = r43;
    L104:
        if (r35 == null) goto L107;
        r36.put("play_type", "video_friend");
    L107:
        if (hd0.c.f().h() == false) goto L109;
        String r44 = "linking";
    L110:
        r36.put("show_scene", r44);
        f0.a(r36);
        j0.l().sendLog("livesdk_guest_connection_user_beauty_show", r36, new Object[]{IRoom.class, x.class});
        return;
    L109:
        r44 = "before_link";
        goto L110
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565519, r3, false);
    }
}
