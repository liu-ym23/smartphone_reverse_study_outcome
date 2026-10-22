package com.larus.uaigc.chat.block.create;

import android.graphics.Bitmap;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.platform.api.IVideoController;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.w0;
import fn8.s;
import kc8.a0;
import kc8.d0;
import kc8.s0;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import tx9.a4;
import tx9.c2;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class RichMediaCreationVideoPlaybackController implements d0 {
    public VideoPlayView a;
    public Message b;
    public CreationItem c;
    public int d;
    public kc8.q e;
    public CoroutineScope f;
    public JSONObject g;
    public String h;
    public String i;
    public Job j;
    public Job k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final RichMediaCreationVideoPlaybackController$appBackgroundListener$1 o;

    public final s0 a() {
        VideoPlayView r0 = this.a;
        if (r0 != null) goto L6;
        return null;
    L6:
        VideoPlayView.z(r0, 0, 2);
        return new s0(r0.getCurrentPlaybackTime(), r0.getMVideoView().getBitmap());
    }

    public final kh8.a c() {
        kc8.q r0 = this.e;
        if (r0 == null) goto L7;
        rd8.b r1 = r0.g;
        if (r1 == null) goto L7;
        return r1.q3();
    L7:
        return null;
    }

    public final void recycle() {
        Job r0 = this.j;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.j = null;
        Job r1 = this.k;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.k = null;
        String r2 = this.h;
        if (r2 == null) goto L13;
        kh8.a r3 = c();
        if (r3 == null) goto L13;
        r3.c(r2);
    L13:
        this.h = null;
        VideoPlayView r4 = this.a;
        if (r4 == null) goto L16;
        r4.d = null;
        VideoPlayView.z(r4, 0, 2);
    L16:
        String r5 = this.i;
        if (r5 == null) goto L19;
        IAIChatUgcAIGCService.a.L().b(r5);
    L19:
        this.i = null;
        if (this.n == false) goto L22;
        AppHost.a.a().c(this.o);
        this.n = false;
    L22:
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.l = false;
        this.m = false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.uaigc.chat.block.create.RichMediaCreationVideoPlaybackController$appBackgroundListener$1] */
    public RichMediaCreationVideoPlaybackController() {
        this.o = new RichMediaCreationVideoPlaybackController$appBackgroundListener$1(this);
    }

    public final void d(String r19, boolean r20) {
        Message r1 = this.b;
        if (r1 != null) goto L5;
        return;
    L5:
        CreationItem r2 = this.c;
        if (r2 != null) goto L8;
        return;
    L8:
        VideoPlayView r3 = this.a;
        if (r3 != null) goto L11;
        return;
    L11:
        String r4 = this.h;
        String r5 = r1.getMessageId();
        kc8.q r6 = this.e;
        if (r6 == null) goto L16;
        a0 r7 = r6.d;
        if (r7 == null) goto L16;
        String r8 = r7.getBotId();
    L17:
        String r9 = r8;
        IAIChatControlTraceService.Companion r10 = IAIChatControlTraceService.a;
        String r11 = r10.bb(r10.gb());
        long r12 = x19.a.b(r3, r20);
        String r13 = r2.id;
        boolean r14 = a4.a(r19);
        boolean r15 = a4.b(AppHost.a.getApplication(), Boolean.valueOf(r3.s));
        JSONObject r16 = new JSONObject();
        c2.a(r16, this.g);
        a4.m(r4, r5, r9, Boolean.TRUE, r11, Long.valueOf(r12), Boolean.valueOf(r20), "0", "chat", r13, r16, Boolean.valueOf(r14), Boolean.valueOf(r15), 16762880);
        return;
    L16:
        r8 = null;
        goto L17
    }

    public final void b(VideoPlayView r23, Message r24, CreationItem r25, int r26, kc8.q r27, CoroutineScope r28, JSONObject r29, fn8.r r30, final s r31) {
        Intrinsics.checkNotNullParameter(r23, "playbackView");
        Intrinsics.checkNotNullParameter(r24, "message");
        Intrinsics.checkNotNullParameter(r25, "clickItem");
        Intrinsics.checkNotNullParameter(r28, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r30, "onPlaybackReadyChanged");
        Intrinsics.checkNotNullParameter(r31, "onPlayingChanged");
        recycle();
        VideoData r3 = r25.video;
        if (r3 != null) goto L6;
        r30.invoke(Boolean.FALSE);
        return;
    L6:
        String r4 = r3.vid;
        if (r4 != null) goto L9;
    L59:
        r30.invoke(Boolean.FALSE);
        return;
    L9:
        if ((!StringsKt.isBlank(r4)) == false) goto L11;
        String r9 = r4;
    L12:
        if (r9 == null) goto L59;
        CreationNoWatermarkManager r5 = CreationNoWatermarkManager.a;
        String r6 = r3.vid;
        nr9.g r7 = bz9.a.l(r3);
        Cover r8 = r3.cover;
        if (r8 == null) goto L17;
        String r10 = r8.key;
    L18:
        nr9.g r11 = r5.c0(r6, r7, r10);
        if (r11 != null) goto L21;
        r11 = bz9.a.l(r3);
    L21:
        final nr9.g r12 = r11;
        this.a = r23;
        this.b = r24;
        this.c = r25;
        this.d = r26;
        this.e = r27;
        this.f = r28;
        this.g = r29;
        this.h = r9;
        int r13 = hz9.a.a;
        this.i = hz9.a.a(r24, r25.id, false, String.valueOf(r26));
        this.l = false;
        this.m = false;
        r23.K();
        r23.setIsMuted(true);
        w0.e(r23, i5.r0());
        r23.setAlpha(1.0f);
        r23.setForceRefreshSurface(true);
        r23.setShowCoverWhenPause(true);
        r23.setBanInnerDismiss(true);
        r23.setIgnoreClick(true);
        r23.setEnableCreationPreviewCoverLoadOpt(true);
        r23.E();
        nr9.f r2 = r12.g;
        if (r2 == null) goto L24;
        String r14 = r2.a;
    L25:
        if (r2 == null) goto L27;
        String r15 = r2.b;
    L28:
        if (r2 == null) goto L30;
        String r16 = r2.c;
    L31:
        if (r2 == null) goto L33;
        Integer r17 = r2.d;
    L34:
        if (r2 == null) goto L36;
        Integer r18 = r2.e;
    L37:
        if (r2 == null) goto L39;
        Bitmap r19 = r2.f;
    L40:
        String r21 = r9;
        VideoPlayView.p(r23, r14, r15, r16, r17, r18, r19, null, r24.getMessageId(), 64);
        r23.i(false);
        String r1 = this.i;
        if (r1 != null) goto L43;
        IVideoController r110 = null;
    L44:
        if (r110 == null) goto L46;
        r110.C(true);
        IVideoController r20 = r110;
    L47:
        VideoPlayView.e(r23, r20, r20.b, r20.h, r20.c, null, null, 48);
        r23.d = new r(this, r31, r12);
        kh8.a r22 = c();
        if (r22 == null) goto L50;
        r22.d(r21, r23);
    L50:
        CoroutineScope r32 = this.f;
        if (r32 != null) goto L53;
        Continuation r111 = null;
    L55:
        if (this.n == true) goto L57;
        AppHost.a.a().j(this.o);
        this.n = true;
    L57:
        r30.invoke(Boolean.TRUE);
        BuildersKt.launch$default(r28, null, null, new RichMediaCreationVideoPlaybackController$bind$2(this, r111), 3, null);
        return;
    L53:
        r111 = null;
        this.j = BuildersKt.launch$default(r32, null, null, new RichMediaCreationVideoPlaybackController$bindPlayObservers$1(this, r21, null), 3, null);
        this.k = BuildersKt.launch$default(r32, null, null, new RichMediaCreationVideoPlaybackController$bindPlayObservers$2(this, r21, null), 3, null);
        goto L55
    L46:
        r20 = null;
        goto L47
    L43:
        r110 = IAIChatUgcAIGCService.a.L().a(r1, "ugc_video", "message_card");
        goto L44
    L39:
        r19 = null;
        goto L40
    L36:
        r18 = null;
        goto L37
    L33:
        r17 = null;
        goto L34
    L30:
        r16 = null;
        goto L31
    L27:
        r15 = null;
        goto L28
    L24:
        r14 = null;
        goto L25
    L17:
        r10 = null;
        goto L18
    L11:
        r9 = null;
        goto L12
    }
}
