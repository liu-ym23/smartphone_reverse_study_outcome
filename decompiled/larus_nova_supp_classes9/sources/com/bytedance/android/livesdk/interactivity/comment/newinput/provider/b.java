package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.MotionEvent;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioComposePageViewPager;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioRecordBtnView;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioRecordViewV3;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements AudioRecordBtnView.c {
    public final /* synthetic */ AudioSectionController a;

    public static final class a implements js0.b {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void onSuccess(String r4) {
            Intrinsics.checkNotNullParameter(r4, "track");
            if (m60.c.b(this.a.a.b.getContext(), b72.a.a) == true) goto L6;
            this.a.a.b.r0(b72.a.b);
            return;
        L6:
            DataCenter r5 = this.a.a.b.R();
            if (r5 != null) goto L9;
        L11:
            AudioComposePageViewPager r6 = this.a.a.n;
            if (r6 == null) goto L14;
            r6.setCanScroll(false);
        L14:
            TextView r7 = this.a.a.d;
            if (r7 == null) goto L17;
            UtilityKotlinExtentionsKt.t(r7);
        L17:
            this.a.a.b.M(true);
            this.a.a.b.N(true);
            this.a.a.b.I();
            MainThreadPostUtils.c((Runnable) this.a.a.k.getValue(), 200);
            AudioSectionController r8 = this.a.a;
            r8.g = false;
            r8.h = false;
            r8.f = false;
            xs2.b.a().post(new u22.e());
            return;
        L9:
            if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r5).F0(PaidInteractEntry.CONTROL_ENTRY_COMMENT) == true) goto L11;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.newinput.provider.b$b, reason: collision with other inner class name */
    public static final class C0126b implements js0.a {
        public C0126b() {
        }

        public final void onFail(String r2) {
            Intrinsics.checkNotNullParameter(r2, "track");
            com.bytedance.android.live.core.utils.f2.c("插件加载失败", 0);
        }
    }

    public static final class c implements js0.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ boolean b;

        public final void onSuccess(String r4) {
            Intrinsics.checkNotNullParameter(r4, "track");
            AudioSectionController r5 = this.a.a;
            if (r5.i == false) goto L5;
            return;
        L5:
            boolean r0 = r5.f;
            if (r0 == false) goto L8;
        L14:
            if (r0 == true) goto L16;
            return;
        L16:
            if (this.b == true) goto L30;
            r5.f = false;
            if (r5.h == false) goto L22;
            AudioRecordViewV3 r6 = r5.e;
            if (r6 == null) goto L31;
            r6.c(2, true);
            return;
        L31:
            return;
        L22:
            AudioRecordViewV3 r7 = r5.e;
            if (r7 == null) goto L33;
            r7.c(1, true);
            return;
        L33:
            return;
        L30:
            return;
        L8:
            if (this.b == false) goto L14;
            r5.f = true;
            if (r5.g == false) goto L26;
            AudioRecordViewV3 r8 = r5.e;
            if (r8 == null) goto L27;
            r8.c(3, true);
            return;
        L27:
            return;
        }

        public c(b r1, boolean r2) {
            this.a = r1;
            this.b = r2;
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

    public static final class e implements js0.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ MotionEvent b;

        public final void onSuccess(String r9) {
            Intrinsics.checkNotNullParameter(r9, "track");
            TextView r10 = this.a.a.d;
            if (r10 == null) goto L5;
            UtilityKotlinExtentionsKt.w(r10);
        L5:
            this.a.a.b.M(false);
            this.a.a.b.N(false);
            this.a.a.b.L();
            AudioSectionController r11 = this.a.a;
            if (r11.i == false) goto L9;
            r11.i = false;
            return;
        L9:
            q60.a r2 = q60.a.d;
            Map r5 = MapsKt.mapOf(new Pair("type", "move_up"));
            com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
            com.bytedance.android.live.core.privacy.av.api.b.a.a r6 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
            com.bytedance.android.live.core.privacy.av.api.a r7 = new com.bytedance.android.live.core.privacy.av.api.a();
            r7.d();
            Unit r13 = Unit.INSTANCE;
            r2.c("community", "audio_comment", r5, r6, r7);
            AudioRecordViewV3 r14 = this.a.a.e;
            if (r14 == null) goto L32;
            long r3 = 1600;
            if ((this.b.getEventTime() - this.b.getDownTime()) <= r3) goto L19;
            AudioSectionController r1 = this.a.a;
            if (r1.f == true) goto L19;
            com.bytedance.android.livesdk.interactivity.comment.audio.c r4 = r1.j;
            if (r4 == null) goto L18;
            r4.stopRecordAudio(true, false);
        L18:
            UIUtils.setViewVisibility(r14, 8);
        L29:
            MainThreadPostUtils.d((Runnable) this.a.a.k.getValue());
            MainThreadPostUtils.d(this.a.a.g());
            r14.b();
            AudioComposePageViewPager r15 = this.a.a.n;
            if (r15 == null) goto L32;
            r15.setCanScroll(true);
        L19:
            com.bytedance.android.livesdk.interactivity.comment.audio.c r8 = this.a.a.j;
            if (r8 == null) goto L22;
            r8.stopRecordAudio(false, true);
        L22:
            UIUtils.setViewVisibility(r14, 8);
            if ((this.b.getEventTime() - this.b.getDownTime()) >= r3) goto L25;
            com.bytedance.android.live.core.utils.f2.b(2131915116, 0);
        L25:
            LinkedHashMap r16 = new LinkedHashMap();
            r16.put("entrance", "voice_pannel");
            IInteractivityInjectService r17 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
            if (r17 == null) goto L28;
            r17.buildVsRoomLog(null, r16);
        L28:
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_voice_comment_cancel", r16, new Object[]{IRoom.class, am2.x.class});
        L32:
            AudioSectionController r18 = this.a.a;
            r18.g = false;
            r18.f = false;
        }

        public e(b r1, MotionEvent r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class f implements js0.a {
        public f() {
        }

        public final void onFail(String r2) {
            Intrinsics.checkNotNullParameter(r2, "track");
            com.bytedance.android.live.core.utils.f2.c("插件加载失败", 0);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioRecordBtnView.c
    public final void a() {
        AudioSectionController r0 = this.a;
        r0.getClass();
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new com.bytedance.android.livesdk.interactivity.comment.newinput.provider.c(r0)).addOnFail(new com.bytedance.android.livesdk.interactivity.comment.newinput.provider.d()).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("AudioSectionController");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioRecordBtnView.c
    public final void c() {
        LivePluginSPIManager.e.getClass();
        com.bytedance.android.live.plugin_api.a r0 = LivePluginSPIManager.a().addOnSuccess(new a(this)).addOnFail(new C0126b()).syncCallbackIfReady(true).callbackOnMainThread();
        int r1 = AudioSectionController.o;
        r0.requireByUser("AudioSectionController");
    }

    public b(AudioSectionController r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioRecordBtnView.c
    public final void b(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        LivePluginSPIManager.e.getClass();
        com.bytedance.android.live.plugin_api.a r4 = LivePluginSPIManager.a().addOnSuccess(new e(this, r3)).addOnFail(new f()).syncCallbackIfReady(true).callbackOnMainThread();
        int r0 = AudioSectionController.o;
        r4.requireByUser("AudioSectionController");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioRecordBtnView.c
    public final void d(boolean r3) {
        LivePluginSPIManager.e.getClass();
        com.bytedance.android.live.plugin_api.a r4 = LivePluginSPIManager.a().addOnSuccess(new c(this, r3)).addOnFail(new d()).syncCallbackIfReady(true).callbackOnMainThread();
        int r0 = AudioSectionController.o;
        r4.requireByUser("AudioSectionController");
    }
}
