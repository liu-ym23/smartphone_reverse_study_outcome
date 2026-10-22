package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/layer/interactivesong/RequestSongAvatarMicSeatView;", "Landroid/widget/FrameLayout;", "", "getCurGoldMicrophoneNum", "Lpf0/a;", "getCurrentMicInfo", "", "getCurrentUserId", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "f", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "getMCurPositionInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "setMCurPositionInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;)V", "mCurPositionInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RequestSongAvatarMicSeatView extends FrameLayout {
    public View a;
    public TextView b;
    public LinkMicQuickInteractView c;
    public c d;
    public int e;
    public ILinkPlayerInfoBridge f;
    public Boolean g;
    public boolean h;

    public RequestSongAvatarMicSeatView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RequestSongAvatarMicSeatView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final pf0.a getCurrentMicInfo() {
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L5;
        ConcurrentHashMap<String, pf0.a> r1 = r0.getGuestListInteractiveSongInfo();
    L6:
        String r2 = getCurrentUserId();
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.get(r2);
    L5:
        r1 = null;
        goto L6
    }

    private final String getCurrentUserId() {
        ILinkPlayerInfoBridge r0 = this.f;
        if (r0 == null) goto L8;
        IBaseUser r1 = r0.getUser();
        if (r1 == null) goto L8;
        String r2 = r1.getIdString();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    private final int getCurGoldMicrophoneNum() {
        pf0.a r0 = getCurrentMicInfo();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b;
    }

    public final void d() {
        int r0 = getCurGoldMicrophoneNum();
        if (r0 != this.e) goto L5;
        return;
    L5:
        if (r0 <= 999) goto L7;
        r0 = 999;
    L7:
        a(r0);
    }

    public final ILinkPlayerInfoBridge getMCurPositionInfo() {
        return this.f;
    }

    public final void a(int r7) {
        this.e = r7;
        e(r7);
        c r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.c != 0) goto L24;
        Function1<Integer, Unit> r1 = new RequestSongAvatarMicSeatView$doUpdateGoldMicrophoneNum$1(this);
        Intrinsics.checkNotNullParameter(r1, "onNormalScoreUpdated");
        AnimatorSet r2 = r0.b;
        if (r2 != null) goto L9;
    L13:
        r0.b = null;
        r0.c = 1;
        r0.b = new AnimatorSet();
        p r3 = r0.a;
        r3.getClass();
        ValueAnimator r4 = ValueAnimator.ofInt(new int[]{0, 1});
        r4.setDuration(350);
        r4.setStartDelay(0);
        r4.addListener(new o(r3, r7));
        AnimatorSet r5 = new AnimatorSet();
        r5.play(r4);
        AnimatorSet r6 = r0.b;
        if (r6 == null) goto L16;
        r6.play(r5);
    L16:
        AnimatorSet r8 = r0.b;
        if (r8 == null) goto L19;
        r8.addListener(new d(r0, r1, r7));
    L19:
        AnimatorSet r9 = r0.b;
        if (r9 == null) goto L25;
        r9.start();
        return;
    L25:
        return;
    L9:
        if (r2.isStarted() != true) goto L13;
        AnimatorSet r10 = r0.b;
        if (r10 == null) goto L13;
        r10.end();
        goto L13
    }

    public final void b(ILinkPlayerInfoBridge r6) {
        Intrinsics.checkNotNullParameter(r6, "positionInfo");
        this.f = r6;
        int r7 = getCurGoldMicrophoneNum();
        e(r7);
        c r0 = this.d;
        if (r0 == null) goto L19;
        AnimatorSet r1 = r0.b;
        if (r1 != null) goto L7;
    L11:
        View r2 = null;
        r0.b = null;
        p r3 = r0.a;
        r3.a.setCurrentText("0");
        View r4 = r3.a.getNextView();
        if ((r4 instanceof TextView) == false) goto L15;
        r2 = r4;
    L15:
        TextView r5 = (TextView) r2;
        if (r5 == null) goto L18;
        r5.setText("0");
    L18:
        r0.a.a.setCurrentText(String.valueOf(r7));
        goto L19
    L7:
        if (r1.isStarted() != true) goto L11;
        AnimatorSet r8 = r0.b;
        if (r8 == null) goto L11;
        r8.end();
    L19:
        d();
    }

    public final void e(int r3) {
        if (this.h == false) goto L5;
        return;
    L5:
        if (r3 <= 0) goto L15;
        LinkMicQuickInteractView r4 = this.c;
        if (r4 == null) goto L9;
        r4.getMainContainer().setBackground(s1.m(2131249857));
        r4.getExtraContainer().setBackground(s1.m(2131249858));
        r4.setTextColor("#673405");
    L9:
        View r5 = this.a;
        if (r5 == null) goto L12;
        r5.setBackground(s1.m(2131251773));
    L12:
        TextView r6 = this.b;
        if (r6 == null) goto L24;
        r6.setTextColor(s1.h(2131108198));
    L24:
        LinkMicQuickInteractView r7 = this.c;
        if (r7 == null) goto L30;
        ImageView r8 = r7.getStaticBg();
        if (r8 == null) goto L31;
        r8.setVisibility(8);
        return;
    L31:
        return;
    L30:
        return;
    L15:
        LinkMicQuickInteractView r9 = this.c;
        if (r9 == null) goto L18;
        r9.getMainContainer().setBackground(s1.m(2131249860));
        r9.getExtraContainer().setBackground(s1.m(2131249861));
        r9.setTextColor("#494949");
    L18:
        View r10 = this.a;
        if (r10 == null) goto L21;
        r10.setBackground(s1.m(2131251774));
    L21:
        TextView r11 = this.b;
        if (r11 == null) goto L24;
        r11.setTextColor(s1.h(2131108199));
        goto L24
    }

    public final void setMCurPositionInfo(ILinkPlayerInfoBridge r1) {
        this.f = r1;
    }

    public final void c(Context r3, final LinkMicQuickInteractView r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Boolean r0 = this.g;
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L5;
        return;
    L5:
        this.g = r1;
        LayoutInflater.from(r3).inflate(2131567380, this, true);
        this.a = findViewById(2131384388);
        this.b = (TextView) findViewById(2131368348);
        this.d = new c(this);
        this.c = r4;
        View r5 = this.a;
        if (r5 == null) goto L8;
        r5.setScaleX(0.8f);
    L8:
        View r6 = this.a;
        if (r6 == null) goto L11;
        r6.setScaleY(0.8f);
    L11:
        if (r4 == null) goto L14;
        Function0<Unit> r7 = new RequestSongAvatarMicSeatView$onCreate$1(this, r4);
        Function0<Unit> r2 = new RequestSongAvatarMicSeatView$onCreate$2(this, r4);
        r4.y = r7;
        r4.z = r2;
        return;
    }

    public RequestSongAvatarMicSeatView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = -1;
    }

    public /* synthetic */ RequestSongAvatarMicSeatView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
