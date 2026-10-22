package com.ss.android.lark.keyboard.biz.voice.inject;

import android.content.Context;
import android.widget.EditText;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.audio.opus.OpusEncoder;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.audio.voiceinput.utils.VoiceUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.l;
import com.ss.android.lark.keyboard.plugin.tool.voice.processor.PartialUploadAudioData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.widget.richtext.RichText;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int r = 0;
    public final IAudioService a;
    public final qob.a b;
    public final Executor c;
    public final AtomicBoolean d;
    public final AtomicBoolean e;
    public volatile boolean f;
    public final String g;
    public final String h;
    public final OpusEncoder i;
    public final PartialUploadAudioData j;
    public volatile String k;
    public volatile Long l;
    public volatile Message m;
    public int n;
    public long o;
    public long p;
    public long q;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.biz.voice.inject.a$a, reason: collision with other inner class name */
    public static final class C0130a {
    }

    static {
    }

    public final void a() {
        if (this.d.get() == false) goto L33;
        boolean r1 = true;
        this.e.set(true);
        String r0 = this.k;
        if (r0 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
        int r4 = VoiceUtils.a;
        VoiceUtils.a(this.a, r0);
    L13:
        Message r2 = this.m;
        if (r2 == null) goto L34;
        String r5 = r2.getId();
        if (r5.length() != 0) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L21;
        r5 = r2.getcId();
    L21:
        Intrinsics.checkNotNull(r5);
        if (r5.length() > 0) goto L25;
        r1 = false;
    L25:
        if (r1 == false) goto L34;
        this.b.m(r5);
        goto L34
    L18:
        r6 = false;
    L34:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L29
        this.i.getClass();     // Catch: Throwable -> L29
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r3 = false;
        goto L11
    L33:
        throw new IllegalStateException("ExternalPcmVoiceSession not started".toString());
    }

    public final void d() {
        boolean r3 = true;
        if (this.d.compareAndSet(false, true) == false) goto L38;
        int r1 = this.i.d(this.h);
        if (r1 != 1) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L36;
        String r2 = this.b.h();
        String r5 = this.b.d();
        com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r6 = this.b.f();
        String r7 = this.h;
        String r8 = this.g;
        PartialReplyInfo r13 = this.b.c();
        Intrinsics.checkNotNullParameter(r2, "rootMsgId");
        Intrinsics.checkNotNullParameter(r5, "parentMsgId");
        Intrinsics.checkNotNullParameter(r7, "fileName");
        Intrinsics.checkNotNullParameter(r8, "cid");
        m5b.e r9 = new m5b.e(null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 536870911);
        r9.j = r2;
        r9.k = r5;
        r9.d = this.l;
        r9.b = this.f;
        r9.w = r7;
        r9.u = r8;
        r9.t = r6;
        com.ss.android.lark.keyboard.b r10 = this.b.n();
        if (r10 == null) goto L18;
        com.ss.android.lark.keyboard.keyboard2.b r11 = r10.L();
        if (r11 == null) goto L18;
        EditText r12 = r11.c();
        if (r12 == null) goto L18;
        RichText r14 = ExtensionEditTextCompatKt.e(r12, 0, r12.length());
        if (r14 == null) goto L18;
        m5b.d r15 = new m5b.d("", "", r14, r13, r9);
    L19:
        Message r16 = this.b.a(r15);
        if (r16 == null) goto L34;
        AudioContent r17 = r16.getContent();
        String r18 = this.a.ec(r16.getChatId(), this.h, com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.a());
        if (r18 != null) goto L25;
        r18 = "";
    L25:
        if (r18.length() == 0) goto L28;
        r3 = false;
    L28:
        if (r3 == true) goto L32;
        r17.setUploadId(r18);
        r17.setSequenceId(0);
        this.m = r16;
        this.k = r18;
        Log.i("ExternalPcmVoiceSession", "start ok, cid=" + this.g + ", uploadId=" + r18 + ", filePath=" + this.h);
        return;
    L32:
        throw new IllegalStateException("getAudioUploadId returns empty");
    L34:
        throw new IllegalStateException("startAudioRecord returns null");
    L18:
        r15 = null;
        goto L19
    L36:
        throw new IllegalStateException(("OpusEncoder.startEncoder failed: " + r1).toString());
    L7:
        r4 = false;
        goto L8
    L38:
        throw new IllegalStateException("ExternalPcmVoiceSession already started".toString());
    }

    public final void e(Context r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        if (this.d.get() == false) goto L41;
        if (this.e.compareAndSet(false, true) == true) goto L8;
        Log.e("ExternalPcmVoiceSession", "stopAndSend, session already stopped.");
        return;
    L8:
        Message r0 = this.m;
        String r11 = this.k;
        if (r0 == null) goto L38;
        if (r11 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L38;
        RangesKt.coerceAtLeast(this.p - this.q, 0);
        byte[] r5 = this.i.a(true);
        if (r5.length != 0) goto L21;
        boolean r6 = true;
    L22:
        if (r6 == true) goto L24;
        int r7 = this.n + 1;
        this.n = r7;
        this.j.a(new com.ss.android.lark.keyboard.plugin.tool.voice.processor.c(r0, r7, r11, ByteBuffer.wrap(r5), false, false), null);
    L24:
        final CountDownLatch r12 = new CountDownLatch(1);
        int r8 = this.n + 1;
        this.n = r8;
        this.j.a(new com.ss.android.lark.keyboard.plugin.tool.voice.processor.c(r0, r8, r11, ByteBuffer.wrap(new byte[0]), true, false), new ExternalPcmVoiceSession$stopAndSend$2(r12, this));
        r12.await(1, TimeUnit.SECONDS);     // Catch: InterruptedException -> L27
    L28:
        int r9 = (int) (((this.o / ((long) 2)) * 1000) / ((long) 16000));
        MonitorMessageSendCallback r10 = this.b.l(this.h, this.g, r9);
        if (r9 >= 1000) goto L36;
        UICallbackExecutor.execute(new b(this, r15));
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L33
        this.i.getClass();     // Catch: Throwable -> L33
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L36:
        this.c.execute(new c(this, r0, r9, r10, r11));
        return;
    L27:
        Log.e("ExternalPcmVoiceSession", "stopAndSend, finish upload latch await interrupted.");
        goto L28
    L21:
        r6 = false;
        goto L22
    L12:
        if (r11.length() == 0) goto L15;
        r4 = false;
    L38:
        Log.e("ExternalPcmVoiceSession", "stopAndSend, message or uploadId is null.");
        return;
    L41:
        throw new IllegalStateException("ExternalPcmVoiceSession not started".toString());
    }

    public a(IAudioService r5, VoiceInnerEndPlugin.a r6) {
        ExecutorService r0 = CoreThreadPool.getDefault().newSerialIODensityThreadPool("external-pcm-voice");
        Intrinsics.checkNotNullParameter(r5, "audioService");
        Intrinsics.checkNotNullParameter(r6, "dependency");
        Intrinsics.checkNotNullParameter(r0, "executor");
        this.a = r5;
        this.b = r6;
        this.c = r0;
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        boolean r1 = com.ss.android.lark.keyboard.biz.mention.inject.b.a;
        this.f = com.ss.android.lark.keyboard.biz.mention.inject.b.a;
        this.g = UUID.randomUUID().toString();
        PolarisFileWrapper r2 = new PolarisFileWrapper(com.ss.android.lark.a.a.getContext().getCacheDir(), "lark_external_voice");
        r2.mkdirs();
        this.h = new PolarisFileWrapper(r2, UUID.randomUUID() + ".ogg").getAbsolutePath();
        this.i = new OpusEncoder();
        this.j = new PartialUploadAudioData(r5);
        com.ss.android.lark.keyboard.b r7 = r6.n();
        if (r7 == null) goto L10;
        k r8 = r7.e();
        if (r8 == null) goto L11;
        l r9 = r8.of(this);
        if (r9 == null) goto L12;
        r9.c(com.ss.android.lark.keyboard.biz.mention.inject.a.class, new ExternalPcmVoiceSession$1(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void b(byte[] r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "pcm");
        if (this.d.get() == false) goto L40;
        if ((!this.e.get()) == false) goto L38;
        boolean r0 = false;
        if (r12 >= 0) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L36;
        Message r4 = this.m;
        if (r4 != null) goto L17;
        Log.e("ExternalPcmVoiceSession", "push pcm, message is null.");
        return;
    L17:
        String r6 = this.k;
        if (r6 != null) goto L22;
        Log.e("ExternalPcmVoiceSession", "push pcm, uploadId is null.");
        return;
    L22:
        if (r12 == r11.length) goto L25;
        r11 = ArraysKt.copyOfRange(r11, 0, 0 + r12);
    L25:
        ByteBuffer r13 = ByteBuffer.wrap(r11);
        OpusEncoder r3 = this.i;
        Intrinsics.checkNotNull(r13);
        long r5 = r3.b(r13, r12);
        this.o += (long) r12;
        this.p = r5;
        if (RangesKt.coerceAtLeast(r5 - this.q, 0) > 0) goto L28;
        return;
    L28:
        final byte[] r14 = this.i.a(false);
        if (r14.length != 0) goto L31;
        r0 = true;
    L31:
        if (r0 == false) goto L33;
        return;
    L33:
        this.q = r5;
        final int r15 = this.n + 1;
        this.n = r15;
        this.j.a(new com.ss.android.lark.keyboard.plugin.tool.voice.processor.c(r4, r15, r6, ByteBuffer.wrap(r14), false, false), new ExternalPcmVoiceSession$pushPcm$4(this, r15, r14));
        return;
    L36:
        throw new IllegalArgumentException("invalid offset/length".toString());
    L9:
        if ((0 + r12) > r11.length) goto L11;
        r2 = true;
        goto L12
    L38:
        throw new IllegalStateException("ExternalPcmVoiceSession already stopped".toString());
    L40:
        throw new IllegalStateException("ExternalPcmVoiceSession not started".toString());
    }

    public final void c(Message r25, int r26, MonitorMessageSendCallback r27, PartialReplyInfo r28) {
        Intrinsics.checkNotNullParameter(r25, INotificationHitPoint.NoticeType.MESSAGE);
        m5b.e r2 = new m5b.e(null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 536870911);
        r2.s = r25;
        r2.j = this.b.h();
        r2.k = this.b.d();
        r2.d = this.l;
        r2.b = this.f;
        r2.w = this.h;
        r2.v = Integer.valueOf(r26);
        r2.u = this.g;
        r2.t = this.b.f();
        r2.x = r27;
        com.ss.android.lark.keyboard.b r1 = this.b.n();
        if (r1 == null) goto L11;
        com.ss.android.lark.keyboard.keyboard2.b r3 = r1.L();
        if (r3 == null) goto L11;
        EditText r4 = r3.c();
        if (r4 == null) goto L11;
        RichText r6 = ExtensionEditTextCompatKt.e(r4, 0, r4.length());
        if (r6 == null) goto L11;
        m5b.d r5 = new m5b.d("", "", r6, r28, r2);
    L12:
        this.b.b(r5);
        return;
    L11:
        r5 = null;
        goto L12
    }
}
