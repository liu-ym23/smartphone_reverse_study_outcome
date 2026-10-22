package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.platformplayer.model.VideoRenderViewParams;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class CameraTransitionViewHolder {
    public final View a;
    public final View b;
    public final LiveDoubleColorBallAnimationView c;
    public final DataCenter d;
    public boolean e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/CameraTransitionViewHolder$State;", "", "IDLE", "FADE_IN", "BLACK", "FADE_OUT", "platform-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State BLACK = null;
        public static final State FADE_IN = null;
        public static final State FADE_OUT = null;
        public static final State IDLE = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r1 = new State("IDLE", 0);
            IDLE = r1;
            State r2 = new State("FADE_IN", 1);
            FADE_IN = r2;
            State r3 = new State("BLACK", 2);
            BLACK = r3;
            State r4 = new State("FADE_OUT", 3);
            FADE_OUT = r4;
            a = new State[]{r1, r2, r3, r4};
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a<T> implements Observer {
        public final /* synthetic */ CameraTransitionViewHolder a;
        public final /* synthetic */ DataCenter b;

        public a(CameraTransitionViewHolder r1, DataCenter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r6) {
            VideoViewParams r7 = (VideoViewParams) r6;
            if (PadConfigUtils.c() == false) goto L15;
            RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.b, 0, 2);
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.n r1 = r0.getPadOrientation();
            if (r1 == null) goto L9;
            PadOrientation r2 = (PadOrientation) r1.getValue();
        L11:
            if (r2 != PadOrientation.LANDSCAPE) goto L13;
            return;
        L13:
            if (com.bytedance.android.livesdk.utils.e5.n() == false) goto L15;
            return;
        L9:
            r2 = null;
        L15:
            CameraTransitionViewHolder r3 = this.a;
            if (r3.e == false) goto L24;
            if (r7 == null) goto L22;
            r3.c(r7);
            return;
        L22:
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CameraTransitionViewHolder a;
        public final /* synthetic */ View b;
        public final /* synthetic */ Function0 c;

        public b(CameraTransitionViewHolder r1, View r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CameraTransitionViewHolder r0 = this.a;     // Catch: Throwable -> L10
            View r1 = r0.b;     // Catch: Throwable -> L10
            if (r1 == null) goto L5;
            UtilityKotlinExtentionsKt.w(r1);     // Catch: Throwable -> L10
        L5:
            LiveDoubleColorBallAnimationView r2 = r0.c;     // Catch: Throwable -> L10
            if (r2 == null) goto L8;
            UtilityKotlinExtentionsKt.w(r2);     // Catch: Throwable -> L10
        L8:
            this.b.setAlpha(0.0f);     // Catch: Throwable -> L10
            CameraTransitionViewHolder r3 = this.a;     // Catch: Throwable -> L10
            State r4 = State.IDLE;     // Catch: Throwable -> L10
            r3.getClass();     // Catch: Throwable -> L10
            this.c.invoke();     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ CameraTransitionViewHolder a;

        public c(CameraTransitionViewHolder r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CameraTransitionViewHolder r0 = this.a;     // Catch: Throwable -> L4
            State r1 = State.IDLE;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b() {
        View r0 = this.b;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r0);
    L5:
        LiveDoubleColorBallAnimationView r1 = this.c;
        if (r1 == null) goto L8;
        UtilityKotlinExtentionsKt.t(r1);
    L8:
        View r2 = this.a;
        if (r2 == null) goto L11;
        UtilityKotlinExtentionsKt.t(r2);
    L11:
        State r3 = State.IDLE;
    }

    public final void c(VideoViewParams r6) {
        View r0 = this.a;
        IRoom r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof FrameLayout.LayoutParams) == true) goto L9;
        r2 = null;
    L9:
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        if (r3 == null) goto L38;
        r3.width = r6.a;
        r3.height = r6.b;
        r3.topMargin = r6.c;
        DataCenter r7 = this.d;
        if (r7 == null) goto L14;
        boolean r8 = com.bytedance.android.live.core.utils.a0.l(r7, true);
    L15:
        if (r8 == true) goto L37;
        DataCenter r9 = this.d;
        if (r9 == null) goto L19;
        boolean r10 = com.bytedance.android.live.core.utils.a0.d(r9, false);
    L20:
        DataCenter r4 = this.d;
        if (r4 == null) goto L23;
        IRoom r5 = com.bytedance.android.live.core.utils.a0.n(r4);
    L25:
        if (com.bytedance.android.livesdk.utils.landscape.e.b(r10, r5) == false) goto L32;
        DataCenter r11 = this.d;
        if (r11 == null) goto L30;
        r1 = com.bytedance.android.live.core.utils.a0.n(r11);
    L30:
        if (com.bytedance.android.livesdk.utils.landscape.e.a(r1) == false) goto L32;
        boolean r12 = true;
    L33:
        if (r12 == false) goto L37;
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L37;
        r3.gravity = 8388629;
        r3.rightMargin = (int) UtilityKotlinExtentionsKt.h(200.0f);
    L32:
        r12 = false;
        goto L33
    L23:
        r5 = null;
        goto L25
    L19:
        r10 = false;
    L37:
        r3.gravity = 1;
        r3.rightMargin = 0;
        goto L38
    L14:
        r8 = false;
    L38:
        View r13 = this.a;
        if (r13 == null) goto L42;
        r13.setLayoutParams(r3);
        return;
    L42:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public CameraTransitionViewHolder(View r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "transitionView");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        State r0 = State.IDLE;
        this.a = r5;
        this.d = r6;
        View r1 = r5.findViewById(2131379011);
        this.b = r1;
        LiveDoubleColorBallAnimationView r2 = (LiveDoubleColorBallAnimationView) r5.findViewById(2131379091);
        this.c = r2;
        com.bytedance.android.livesdk.r3.a(r5, com.bytedance.android.live.core.utils.s1.B(2131920215));
        new VideoRenderViewParams(r6).a.observe(r6.lifecycleOwner, new a(this, r6));
        if (r1 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r1);
    L5:
        if (r2 == null) goto L8;
        UtilityKotlinExtentionsKt.t(r2);
        return;
    }

    public final void a(VideoViewParams r6, boolean r7, boolean r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r6, "transitionViewParams");
        Intrinsics.checkNotNullParameter(r9, "switchStream");
        View r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        this.e = r7;
        r0.animate().cancel();
        RoomContext r10 = RoomContext.a.c(RoomContext.Companion, this.d, 0, 2);
        if (r10 == null) goto L10;
        com.bytedance.live.datacontext.m r11 = r10.getStreamTransitionAnimating();
        if (r11 == null) goto L10;
        r11.setValue(Boolean.TRUE);
    L10:
        r0.animate().cancel();
        c(r6);
        UtilityKotlinExtentionsKt.w(r0);
        if (r8 == false) goto L13;
        r0.animate().alpha(1.0f).setDuration(150).withStartAction(new b(this, r0, r9)).withEndAction(new c(this)).start();
        return;
    L13:
        UtilityKotlinExtentionsKt.w(r0);
        View r12 = this.b;
        if (r12 == null) goto L16;
        UtilityKotlinExtentionsKt.w(r12);
    L16:
        LiveDoubleColorBallAnimationView r13 = this.c;
        if (r13 == null) goto L19;
        UtilityKotlinExtentionsKt.w(r13);
    L19:
        r0.setAlpha(1.0f);
        State r14 = State.IDLE;
        r0.post(new d(r9));
    }
}
