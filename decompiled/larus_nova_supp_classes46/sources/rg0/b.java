package rg0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongAvatarMicSeatView;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends jg0.a<MultiLinkGuestViewBinder.a> {
    public final CompositeDisposable e;
    public MultiLinkGuestViewBinder.a f;
    public LinkMicQuickInteractView g;
    public RequestSongAvatarMicSeatView h;
    public Context i;
    public final g j;

    public static final class a {
    }

    /* JADX INFO: renamed from: rg0.b$b, reason: collision with other inner class name */
    public static final class RunnableC0266b implements Runnable {
        public final /* synthetic */ b a;

        public RunnableC0266b(b r1) {
            this.a = r1;
        }

        public final void a() {
            LinkMicQuickInteractView r0 = this.a.g;
            if (r0 == null) goto L41;
            InteractiveSongContext r1 = InteractiveSongContext.Companion.getContext();
            ViewParent r3 = null;
            if (r1 == null) goto L39;
            m<Boolean> r2 = r1.m130isOpenInteractiveSong();
            if (r2 == null) goto L39;
            if (((Boolean) r2.getValue()).booleanValue() != true) goto L39;
            r0.l(4, null);
            r0.getExtraContainer().setVisibility(0);
            RequestSongAvatarMicSeatView r4 = this.a.h;
            if (r4 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("requestSongAvatarMicSeatView");
        L13:
            r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            RequestSongAvatarMicSeatView r5 = this.a.h;
            if (r5 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("requestSongAvatarMicSeatView");
        L16:
            ViewParent r6 = r5.getParent();
            if ((r6 instanceof ViewGroup) == false) goto L20;
            r3 = r6;
        L20:
            ViewGroup r7 = (ViewGroup) r3;
            if (r7 == null) goto L26;
            RequestSongAvatarMicSeatView r8 = this.a.h;
            if (r8 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("requestSongAvatarMicSeatView");
        L25:
            r7.removeView(r8);
        L26:
            r0.getExtraContainer().removeAllViews();
            ViewGroup r9 = r0.getExtraContainer();
            RequestSongAvatarMicSeatView r10 = this.a.h;
            if (r10 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("requestSongAvatarMicSeatView");
        L29:
            r9.addView(r10);
            r0.getStaticBg().setVisibility(8);
            b r11 = this.a;
            MultiLinkGuestViewBinder.a r12 = r11.f;
            if (r12 == null) goto L42;
            e r13 = r12.k;
            if (r13 == null) goto L43;
            ILinkPlayerInfoBridge r14 = r13.a;
            if (r14 == null) goto L44;
            RequestSongAvatarMicSeatView r15 = r11.h;
            if (r15 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("requestSongAvatarMicSeatView");
        L38:
            r15.b(r14);
            return;
        L44:
            return;
        L43:
            return;
        L42:
            return;
        L39:
            r0.l(0, null);
            r0.setTextColor("#FFFFFF");
            r0.getExtraContainer().removeAllViews();
            r0.getMainContainer().setBackground(null);
            r0.getExtraContainer().setBackground(null);
            r0.getStaticBg().setVisibility(0);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // jg0.c
    public final int o() {
        return 2131565189;
    }

    @Override // jg0.c, jg0.f
    public final void onDetach() {
        RequestSongAvatarMicSeatView r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("requestSongAvatarMicSeatView");
    L5:
        r0.e(0);
        r0.d();
        LinkMicQuickInteractView r1 = this.g;
        if (r1 == null) goto L11;
        r1.l(0, null);
        ViewGroup r2 = r1.getExtraContainer();
        RequestSongAvatarMicSeatView r3 = this.h;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("requestSongAvatarMicSeatView");
    L10:
        r2.removeView(r3);
    L11:
        this.e.dispose();
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkRequestSongAvatarMicSeatLayer.name();
    }

    public final void r() {
        if (this.i != null) goto L5;
        return;
    L5:
        RequestSongAvatarMicSeatView r0 = this.h;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("requestSongAvatarMicSeatView");
    L8:
        Context r1 = this.i;
        Intrinsics.checkNotNull(r1);
        r0.c(r1, this.g);
        LinkMicQuickInteractView r2 = this.g;
        if (r2 == null) goto L12;
        r2.post(new RunnableC0266b(this));
        return;
    }

    public final Context getContext() {
        return this.i;
    }

    @Override // jg0.c, jg0.f
    public final void a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super.a(r5);
        View r3 = null;
        this.h = new RequestSongAvatarMicSeatView(r5, null, 6, 0);
        View r0 = this.j.m(2131389576);
        if ((r0 instanceof LinkMicQuickInteractView) == true) goto L5;
        r0 = null;
    L5:
        this.g = (LinkMicQuickInteractView) r0;
        this.i = r5;
        MicSeatScene r6 = this.b;
        MicSeatScene r1 = MicSeatScene.AUDIO_LINK_STAGE_ENLARGE_MAIN;
        if (r6 != r1) goto L8;
        float r7 = 13.0f;
    L9:
        View r2 = this.j.m(2131389585);
        if ((r2 instanceof TextView) == false) goto L13;
        r3 = r2;
    L13:
        TextView r4 = (TextView) r3;
        if (r4 == null) goto L16;
        r4.setTextSize(2, r7);
    L16:
        MicSeatScene r8 = this.b;
        if (r8 == MicSeatScene.AUDIO_LINK_STAGE_ENLARGE) goto L21;
        if (r8 == r1) goto L21;
        float r9 = 8.0f;
    L22:
        View r10 = this.j.m(2131389580);
        if (r10 == null) goto L27;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L27;
        r11.width = s1.f(r9);
        r11.height = s1.f(r9);
    L27:
        LinkFeedTypeConstant.Companion r12 = LinkFeedTypeConstant.Companion;
        if (r12.isFeedType(n()) == true) goto L30;
    L34:
        View r13 = this.j.m(2131389587);
        if (r13 == null) goto L40;
        a1.o(r13, s1.f(3.0f));
        return;
    L40:
        return;
    L30:
        if (r12.isDouyinFullScreen(n()) == true) goto L34;
        View r14 = this.j.m(2131389587);
        if (r14 == null) goto L38;
        a1.o(r14, s1.f(1.0f));
        return;
    L38:
        return;
    L21:
        r9 = 12.0f;
        goto L22
    L8:
        r7 = 10.0f;
        goto L9
    }

    @Override // jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        s((MultiLinkGuestViewBinder.a) r1, r2);
    }

    public final void s(MultiLinkGuestViewBinder.a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        InteractiveSongContext r4 = InteractiveSongContext.Companion.getContext();
        if (r4 == null) goto L9;
        m<Boolean> r5 = r4.m130isOpenInteractiveSong();
        if (r5 == null) goto L9;
        if (((Boolean) r5.getValue()).booleanValue() != true) goto L9;
        r();
    L9:
        this.f = r2;
        RequestSongAvatarMicSeatView r6 = this.h;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("requestSongAvatarMicSeatView");
    L12:
        r6.b(r2.k.a);
    }

    public b(MicSeatScene r2, MultiLinkAudioCommonGuestMicSeatBasicLayer r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "basicLayer");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r4);
        this.j = r3;
        this.e = new CompositeDisposable();
    }

    @Override // jg0.f
    public final void k(Object r5, int r6, Bundle r7) {
        MultiLinkGuestViewBinder.a r8 = (MultiLinkGuestViewBinder.a) r5;
        Intrinsics.checkNotNullParameter(r8, "itemData");
        Intrinsics.checkNotNullParameter(r7, "payload");
        this.f = r8;
        Iterator<String> r9 = r7.keySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L48;
        String r0 = r9.next();
        if (r0 == null) goto L4;
        int r1 = r0.hashCode();
        Object r3 = null;
        if (r1 != (-2054590407)) goto L11;
        if (r0.equals("payload_key_play_mode_state_update") == false) goto L4;
        IBaseUser r2 = r8.k.a.getUser();
        if (r2 == null) goto L41;
        String r4 = r2.getIdString();
    L42:
        IRoom r10 = r8.h;
        if (r10 == null) goto L46;
        r3 = r10.getAnchorId();
    L46:
        if (Intrinsics.areEqual(r4, r3) == false) goto L4;
        s(r8, r6);
        goto L4
    L41:
        r4 = null;
        goto L42
    L11:
        if (r1 != (-1236292194)) goto L13;
        if (r0.equals("payload_key_interact_song_golden_mic_info_update") == false) goto L4;
        Object r11 = r8.k.d.get("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO");
        if ((r11 instanceof pf0.a) == false) goto L30;
        r3 = r11;
    L30:
        pf0.a r12 = (pf0.a) r3;
        if (r12 == null) goto L4;
        Intrinsics.checkNotNullParameter(r12, "info");
        RequestSongAvatarMicSeatView r13 = this.h;
        if (r13 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("requestSongAvatarMicSeatView");
    L35:
        r13.d();
        goto L4
    L13:
        if (r1 != 618131157) goto L4;
        if (r0.equals("payload_key_request_song_open_update") == false) goto L4;
        Object r14 = r8.k.d.get("EXT_KEY_UPDATE_REQUEST_SONG_OPEN");
        if ((r14 instanceof Boolean) == false) goto L21;
        r3 = r14;
    L21:
        Boolean r15 = (Boolean) r3;
        if (r15 == null) goto L4;
        r15.booleanValue();
        r();
        goto L4
    }
}
