package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.Audio2TextBtnView;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioComposePageViewPager;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class Audio2TextSectionController extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j implements com.bytedance.android.livesdk.interactivity.comment.audio.c.b {
    public static final /* synthetic */ int j = 0;
    public Audio2TextBtnView c;
    public TextView d;
    public final Integer e;
    public com.bytedance.android.livesdk.interactivity.comment.audio.c f;
    public final Lazy g;
    public final Lazy h;
    public final AudioComposePageViewPager i;

    public static final class a {
    }

    public static final class b implements Audio2TextBtnView.c {
        public final /* synthetic */ Audio2TextSectionController a;

        public static final class a implements js0.b {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            public final void onSuccess(String r3) {
                Intrinsics.checkNotNullParameter(r3, "track");
                if (m60.c.b(this.a.a.b.getContext(), b72.a.a) == true) goto L6;
                this.a.a.b.r0(b72.a.b);
                return;
            L6:
                DataCenter r4 = this.a.a.b.R();
                if (r4 != null) goto L9;
            L11:
                AudioComposePageViewPager r5 = this.a.a.i;
                if (r5 == null) goto L14;
                r5.setCanScroll(false);
            L14:
                TextView r6 = this.a.a.d;
                if (r6 == null) goto L17;
                UtilityKotlinExtentionsKt.t(r6);
            L17:
                this.a.a.b.N(true);
                this.a.a.b.I();
                int r7 = this.a.a.b.D()[0];
                int r8 = this.a.a.b.D()[1];
                xs2.b.a().post(new u22.e());
                MainThreadPostUtils.c((Runnable) this.a.a.g.getValue(), 100);
                return;
            L9:
                if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r4).F0(PaidInteractEntry.CONTROL_ENTRY_COMMENT) == true) goto L11;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.newinput.provider.Audio2TextSectionController$b$b, reason: collision with other inner class name */
        public static final class C0119b implements js0.a {
            public C0119b() {
            }

            public final void onFail(String r2) {
                Intrinsics.checkNotNullParameter(r2, "track");
                com.bytedance.android.live.core.utils.f2.c("插件加载失败", 0);
            }
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.view.Audio2TextBtnView.c
        public final void a() {
            this.a.h();
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.view.Audio2TextBtnView.c
        public final void c() {
            LivePluginSPIManager.e.getClass();
            com.bytedance.android.live.plugin_api.a r0 = LivePluginSPIManager.a().addOnSuccess(new a(this)).addOnFail(new C0119b()).syncCallbackIfReady(true).callbackOnMainThread();
            int r1 = Audio2TextSectionController.j;
            r0.requireByUser("Audio2TextSectionController");
        }

        public b(Audio2TextSectionController r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.view.Audio2TextBtnView.c
        public final void b(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.a.h();
        }
    }

    public static final class c implements js0.b {
        public final /* synthetic */ Audio2TextSectionController a;

        public c(Audio2TextSectionController r1) {
            this.a = r1;
        }

        public final void onSuccess(String r7) {
            Intrinsics.checkNotNullParameter(r7, "track");
            TextView r8 = this.a.d;
            if (r8 == null) goto L5;
            UtilityKotlinExtentionsKt.w(r8);
        L5:
            this.a.getClass();
            AudioComposePageViewPager r9 = this.a.i;
            if (r9 == null) goto L8;
            r9.setCanScroll(true);
        L8:
            this.a.b.N(false);
            this.a.b.L();
            MainThreadPostUtils.d((Runnable) this.a.g.getValue());
            MainThreadPostUtils.d((Runnable) this.a.h.getValue());
            com.bytedance.android.livesdk.interactivity.comment.audio.c r10 = this.a.f;
            if (r10 == null) goto L11;
            r10.stopAsrAudio();
        L11:
            q60.a r0 = q60.a.d;
            Map r3 = MapsKt.mapOf(new Pair("type", "move_up"));
            com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
            com.bytedance.android.live.core.privacy.av.api.b.a.a r4 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
            com.bytedance.android.live.core.privacy.av.api.a r5 = new com.bytedance.android.live.core.privacy.av.api.a();
            r5.d();
            Unit r11 = Unit.INSTANCE;
            r0.c("community", "audio_comment", r3, r4, r5);
        }
    }

    public static final class d implements js0.a {
        public d() {
        }

        public final void onFail(String r2) {
            Intrinsics.checkNotNullParameter(r2, "track");
            com.bytedance.android.live.core.utils.f2.c("插件加载失败", 0);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.audio.c.b
    public final void c(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.audio.c.b
    public final void f(String r1, long r2) {
    }

    public final void g() {
        com.bytedance.android.livesdk.interactivity.comment.audio.c r0 = this.b.c;
        if (r0 != null) goto L5;
        com.bytedance.android.livesdk.interactivity.comment.audio.c r1 = new com.bytedance.android.livesdk.interactivity.comment.audio.c(this.b.R());
        this.f = r1;
        this.b.c = r1;
    L6:
        this.c = (Audio2TextBtnView) this.a.findViewById(2131364994);
        this.d = (TextView) this.a.findViewById(2131388399);
        Audio2TextBtnView r2 = this.c;
        if (r2 == null) goto L9;
        r2.setListener(new b(this));
    L9:
        Audio2TextBtnView r3 = this.c;
        if (r3 == null) goto L12;
        r3.setFocusable(true);
    L12:
        Audio2TextBtnView r4 = this.c;
        if (r4 == null) goto L15;
        r4.setClickable(true);
    L15:
        Audio2TextBtnView r5 = this.c;
        if (r5 == null) goto L18;
        r5.setLongClickable(true);
    L18:
        r3.c(this.c, com.bytedance.android.live.core.utils.s1.B(2131914436), true);
        return;
    L5:
        this.f = r0;
        goto L6
    }

    public final void h() {
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new c(this)).addOnFail(new d()).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("Audio2TextSectionController");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.audio.c.b
    public final void b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "result");
        AudioComposePageViewPager r0 = this.i;
        if (r0 == null) goto L6;
        r0.setCanScroll(true);
    L6:
        if (r6.length() != 0) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == false) goto L11;
        String r8 = "1";
    L12:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_voice_pannel_transfer", MapsKt.mapOf(TuplesKt.to(r8, "result_empty")), new Object[]{IRoom.class, am2.x.class});
        return;
    L11:
        r8 = "0";
        goto L12
    L8:
        r7 = false;
        goto L9
    }

    public Audio2TextSectionController(View r2, final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3, AudioComposePageViewPager r4) {
        Intrinsics.checkNotNullParameter(r2, "audioPanelView");
        Intrinsics.checkNotNullParameter(r3, "bridges");
        super(r2, r3);
        this.i = r4;
        this.e = (Integer) ec2.a0.a.getValue();
        ((fc2.e) ec2.f0.a.getValue()).getClass();
        this.g = LazyKt.lazy(new Audio2TextSectionController$transferStartRunnable$2(this, r3));
        this.h = LazyKt.lazy(new Audio2TextSectionController$forceStopRunnable$2(this));
    }
}
