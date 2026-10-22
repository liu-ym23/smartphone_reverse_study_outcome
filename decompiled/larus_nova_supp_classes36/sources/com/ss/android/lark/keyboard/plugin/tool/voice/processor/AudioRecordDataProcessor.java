package com.ss.android.lark.keyboard.plugin.tool.voice.processor;

import android.os.Handler;
import android.os.Looper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.audio.voiceinput.service.l;
import com.ss.android.lark.audio.voiceinput.utils.VoiceUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.utils.y0;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AudioRecordDataProcessor implements com.ss.android.lark.audio.voiceinput.processor.c {
    public final l a;
    public final IAudioService b;
    public final qob.a c;
    public final boolean d;
    public final boolean e;
    public final Lazy f;
    public final ExecutorService g;
    public final com.larksuite.framework.callback.c h;
    public final com.ss.android.lark.audio.voiceinput.processor.a i;
    public final UploadAudioDataConsumer j;
    public final RecognizeWithUploadAudioDataConsumer k;
    public final b l;
    public com.ss.android.lark.audio.voiceinput.e m;

    public final class RecognizeWithUploadAudioDataConsumer extends com.ss.android.lark.keyboard.plugin.tool.voice.processor.a {
        public final UploadAudioDataConsumer d;
        public final l e;
        public final IAudioService f;
        public boolean g;
        public final boolean h;
        public final RecognizeAudioData i;
        public final /* synthetic */ AudioRecordDataProcessor j;

        public static final class a implements f {
            public final /* synthetic */ RecognizeWithUploadAudioDataConsumer a;

            public a(RecognizeWithUploadAudioDataConsumer r1) {
                this.a = r1;
            }

            @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.f
            public final void a(com.ss.android.lark.audio.voiceinput.c r4) {
                Intrinsics.checkNotNullParameter(r4, "result");
                AudioRecordDataProcessor r0 = this.a.j;
                StringBuilder r1 = new StringBuilder("updateAudioText sourceId:");
                r1.append(r4.a);
                r1.append(" sequenceId:");
                r1.append(r4.b);
                r1.append("/ result length:");
                String r2 = r4.c;
                if (r2 == null) goto L5;
                Integer r3 = Integer.valueOf(r2.length());
            L6:
                r1.append(r3);
                r1.append("/isFinish:");
                r1.append(r4.d);
                Log.i("AudioRecordDataRecognize", r1.toString());
                r0.h.a(new d(r0, r4));
                return;
            L5:
                r3 = null;
                goto L6
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ Function0<Unit> a;

            public b(Function0<Unit> r1) {
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

        public static final class c implements Runnable {
            public final /* synthetic */ RecognizeWithUploadAudioDataConsumer a;
            public final /* synthetic */ ByteBuffer b;
            public final /* synthetic */ int c;
            public final /* synthetic */ double d;

            public c(RecognizeWithUploadAudioDataConsumer r1, ByteBuffer r2, int r3, double r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final void a() {
                RecognizeWithUploadAudioDataConsumer r1 = this.a;
                if (r1.g == true) goto L7;
                com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r2 = r1.b;
                if (r2 == null) goto L7;
                r1.d(r2.c, r2.d, true);
            L7:
                final RecognizeWithUploadAudioDataConsumer r3 = this.a;
                if ((!r3.j.i.a.isEmpty()) == false) goto L11;
                final AudioRecordDataProcessor r4 = r3.j;
                r4.i.a(new AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$handleCacheDataIfNeed$1(r3, r4));
            L11:
                RecognizeWithUploadAudioDataConsumer r5 = this.a;
                ByteBuffer r10 = this.b;
                int r11 = this.c;
                double r12 = this.d;
                r5.getClass();
                if (r10 != null) goto L14;
                Log.i("AudioRecordDataRecognize", "[handleAudioData]buffer is null");
                return;
            L14:
                IGetDataCallback<String> r14 = new AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$handleOnUpdateAudio$callback$1();
                RecognizeAudioData r15 = r5.i;
                com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r6 = r5.b;
                if (r6 == null) goto L17;
                Message r7 = r6.a;
            L18:
                r15.a(new com.ss.android.lark.keyboard.plugin.tool.voice.processor.c(r7, r5.a(), r5.c, r10, false, r5.h, r5.j.e), r14);
                if (r5.j.e == false) goto L25;
                UploadAudioDataConsumer r0 = r5.d;
                if (r0 == null) goto L26;
                r0.i(r10, r11, r12);
                return;
            L26:
                return;
            L25:
                return;
            L17:
                r7 = null;
                goto L18
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

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.a
        public final synchronized void e() {
            monitor-enter(this);
            super.e();     // Catch: Throwable -> L6
            this.g = false;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final void f() {
            e();
            if (b() == false) goto L6;
            Log.e("AudioRecordDataRecognize", "[onPrepareRecord] invalid context");
            return;
        L6:
            String r0 = UUID.randomUUID().toString();
            this.c = r0;
            RecognizeAudioData r1 = this.i;
            r1.h = r0;
            r1.i = 0;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.a
        public final boolean c(String r2, String r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "strFileName");
            Intrinsics.checkNotNullParameter(r3, "cid");
            if (super.c(r2, r3, r4) == true) goto L6;
            return false;
        L6:
            final int r5 = a();
            final String r6 = this.c;
            final AudioRecordDataProcessor r7 = this.j;
            AudioRecordDataProcessor.a(r7, new AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$onAudioRecorded$1(this, r5, r6, r7));
            if (this.j.e == false) goto L13;
            UploadAudioDataConsumer r8 = this.d;
            if (r8 == null) goto L14;
            r8.g(AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$onAudioRecorded$2.INSTANCE, AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$onAudioRecorded$3.INSTANCE);
            return true;
        L14:
            return true;
        L13:
            return true;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.a
        public final void d(String r4, String r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r4, "strFileName");
            Intrinsics.checkNotNullParameter(r5, "cid");
            Log.d("AudioRecordDataRecognize", "[onStartRecord]:" + r4 + '/' + r5);
            final com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r7 = this.b;
            if (r7 != null) goto L6;
            Log.e("AudioRecordDataRecognize", "mAudioMsgInfo is null");
            return;
        L6:
            String r8 = this.c;
            if (r8 != null) goto L9;
        L12:
            boolean r9 = true;
        L13:
            if (r9 == true) goto L23;
            String r10 = fwa.a.a;
            String r11 = this.c;
            fwa.a.m = r11;
            AudioContent r2 = r7.b;
            if (r2 == null) goto L17;
            r2.setUploadId(r11);
            r2.setSequenceId(0);
        L17:
            final int r12 = a();
            final AudioRecordDataProcessor r3 = this.j;
            Function0<Unit> r1 = new AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$onStartRecord$codeBlock$1(this, r7, r12, r3);
            if (r6 == false) goto L20;
            AudioRecordDataProcessor.a(this.j, new b(r1));
        L21:
            this.g = true;
            return;
        L20:
            r1.invoke();
            goto L21
        L23:
            return;
        L9:
            if (r8.length() == 0) goto L12;
            r9 = false;
            goto L13
        }

        public final boolean g(ByteBuffer r10, int r11, double r12) {
            if (b() == true) goto L10;
            if (r10 == null) goto L10;
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r0 = this.b;
            if (r0 == null) goto L9;
            r0.e = r11;
        L9:
            boolean r1 = true;
        L11:
            if (r1 == true) goto L13;
            return false;
        L13:
            if (r10 != null) goto L15;
            return false;
        L15:
            AudioRecordDataProcessor.a(this.j, new c(this, r10, r11, r12));
            return true;
        L10:
            Log.e("AudioRecordDataProcessor", "[onUpdateAudio]mAudioMessage or buffer is null");
            r1 = false;
            goto L11
        }

        public RecognizeWithUploadAudioDataConsumer(AudioRecordDataProcessor r7, UploadAudioDataConsumer r8, l r9, IAudioService r10, String r11, String r12, String r13) {
            Intrinsics.checkNotNullParameter(r9, "newAudio2TextPush");
            Intrinsics.checkNotNullParameter(r10, "audioService");
            Intrinsics.checkNotNullParameter(r11, "mChatId");
            Intrinsics.checkNotNullParameter(r12, "mDeviceLocale");
            Intrinsics.checkNotNullParameter(r13, "mUserLocale");
            this.j = r7;
            this.d = r8;
            this.e = r9;
            this.f = r10;
            this.h = true;
            RecognizeAudioData r14 = new RecognizeAudioData(r9, r10, r11, r12, r13);
            a r15 = new a(this);
            Intrinsics.checkNotNullParameter(r15, "callback");
            r14.f = r15;
            r14.a.H2(r14.j);
            this.i = r14;
        }
    }

    public final class UploadAudioDataConsumer extends com.ss.android.lark.keyboard.plugin.tool.voice.processor.a {
        public final qob.a d;
        public final PartialUploadAudioData e;
        public final /* synthetic */ AudioRecordDataProcessor f;

        public static final class a implements RxScheduledExecutor.Producer<Message> {
            public final /* synthetic */ CountDownLatch a;
            public final /* synthetic */ UploadAudioDataConsumer b;

            public final Object produce() {
                this.a.await(1, TimeUnit.SECONDS);     // Catch: InterruptedException -> L5
            L7:
                com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r1 = this.b.b;
                if (r1 != null) goto L10;
                Log.e("AudioRecordDataUpload", "mAudioMsgInfo is null");
                return null;
            L10:
                Message r3 = r1.a;
                if (r3 != null) goto L14;
                Log.e("AudioRecordDataUpload", "audioMessage is null, mAudioMsgInfo: cid = " + r1.d + ", fileName = " + r1.c);
                return null;
            L14:
                return r3;
            L5:
                e = move-exception;
                Log.e("AudioRecordDataUpload", "[onAudioRecorded] await occurs timeout:" + e);
                goto L7
            }

            public a(CountDownLatch r1, UploadAudioDataConsumer r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public static final class b<T> implements RxScheduledExecutor.Consumer {
            public final /* synthetic */ AudioRecordDataProcessor a;
            public final /* synthetic */ String b;
            public final /* synthetic */ UploadAudioDataConsumer c;

            public b(AudioRecordDataProcessor r1, String r2, String r3, int r4, MonitorMessageSendCallback r5, UploadAudioDataConsumer r6) {
                this.a = r1;
                this.b = r2;
                this.c = r6;
            }

            public final void consume(Object r5) {
                Message r6 = (Message) r5;
                if (r6 == null) goto L10;
                AudioRecordDataProcessor r0 = this.a;
                String r1 = this.b;
                UploadAudioDataConsumer r2 = this.c;
                qob.a r3 = r0.c;
                r3.f();
                r3.p(r6, r1);
                com.ss.android.lark.keyboard.b r7 = r0.i();
                if (r7 == null) goto L9;
                k r8 = r7.e();
                if (r8 == null) goto L9;
                r8.a(q.a.a, r8.b());
            L9:
                r2.b = null;
                return;
            L10:
                Log.e("AudioRecordDataProcessor", "[onAudioRecorded] audioMsg is null,then ignore send audio msg.");
            }
        }

        public final void f() {
            if (y0.d(this.c) == true) goto L6;
            int r0 = VoiceUtils.a;
            VoiceUtils.a(this.f.b, this.c);
            return;
        }

        public final void h() {
            e();
            if (b() == false) goto L6;
            Log.e("AudioRecordDataUpload", "[onPrepareRecord] invalid context");
            return;
        L6:
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r0 = this.b;
            if (r0 == null) goto L17;
            IAudioService r2 = this.f.b;
            Message r3 = r0.a;
            if (r3 == null) goto L11;
            String r4 = r3.getChatId();
        L12:
            String r5 = r2.ec(r4, r0.c, com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.a());
            if (r5 != null) goto L15;
            r5 = "";
        L15:
            this.c = r5;
            Log.i("AudioRecordDataUpload", "[onPrepareRecord]strFileName:" + r0.c + " cid:" + r0.d + " mUploadId:" + this.c);
            return;
        L11:
            r4 = null;
            goto L12
        }

        public UploadAudioDataConsumer(AudioRecordDataProcessor r2, qob.a r3) {
            Intrinsics.checkNotNullParameter(r3, "mAudioDataDependency");
            this.f = r2;
            this.d = r3;
            this.e = new PartialUploadAudioData(r2.b);
        }

        public final void g(final Function1<? super String, Unit> r10, final Function1<? super ErrorResult, Unit> r11) {
            Intrinsics.checkNotNullParameter(r10, "onSuccess");
            Intrinsics.checkNotNullParameter(r11, "onError");
            final int r3 = a();
            final String r4 = this.c;
            final AudioRecordDataProcessor r0 = this.f;
            AudioRecordDataProcessor.a(r0, new AudioRecordDataProcessor$UploadAudioDataConsumer$finishAudioUpload$1(this, r3, r4, r0, r10, r11));
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.a
        public final boolean c(String r11, String r12, int r13) {
            Intrinsics.checkNotNullParameter(r11, "strFileName");
            Intrinsics.checkNotNullParameter(r12, "cid");
            if (super.c(r11, r12, r13) == true) goto L6;
            return false;
        L6:
            MonitorMessageSendCallback r6 = this.d.l(r11, r12, r13);
            if (r6 == null) goto L9;
            r6.v(null, null, Message.Type.AUDIO);
        L9:
            final CountDownLatch r0 = new CountDownLatch(1);
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r1 = this.b;
            if (r1 == null) goto L16;
            Log.i("AudioRecordDataUpload", "[onAudioRecorded]strFileName:" + r1.c + " cid:" + r1.d + " mUploadId:" + this.c + '}');
            Message r2 = r1.a;
            if (r2 == null) goto L16;
            AudioContent r3 = r2.getContent();
            if (r3 == null) goto L16;
            r3.setUploadId(this.c);
        L16:
            g(new AudioRecordDataProcessor$UploadAudioDataConsumer$onAudioRecorded$2(r0), new AudioRecordDataProcessor$UploadAudioDataConsumer$onAudioRecorded$3(r0));
            RxScheduledExecutor.execInIO(new a(r0, this), new b(this.f, r11, r12, r13, r6, this));
            return true;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.a
        public final void d(String r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "strFileName");
            Intrinsics.checkNotNullParameter(r3, "cid");
            Log.d("AudioRecordDataUpload", "[onStartRecord]:" + r2 + '/' + r3);
            String r5 = fwa.a.a;
            String r6 = this.c;
            fwa.a.e = r6;
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r7 = this.b;
            if (r7 == null) goto L8;
            AudioContent r8 = r7.b;
            if (r8 == null) goto L9;
            r8.setUploadId(r6);
            r8.setSequenceId(0);
            return;
        L9:
            return;
        }

        public final boolean i(ByteBuffer r9, int r10, double r11) {
            Log.d("AudioRecordDataUpload", "[onUpdateAudio duration]:" + r10 + " volume:" + r11);
            if (b() == true) goto L10;
            if (r9 == null) goto L10;
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r12 = this.b;
            if (r12 == null) goto L9;
            r12.e = r10;
        L9:
            boolean r13 = true;
        L11:
            if (r13 == true) goto L13;
            return false;
        L13:
            if (r9 != null) goto L15;
            return false;
        L15:
            boolean r14 = b();
            String r15 = this.c;
            if (r15 != null) goto L18;
        L21:
            boolean r16 = true;
        L23:
            if ((r14 | r16) == false) goto L25;
            h();
        L25:
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r17 = this.b;
            if (r17 != null) goto L29;
            Log.e("AudioRecordDataUpload", "mAudioMsgInfo is null");
            return false;
        L29:
            this.e.a(new c(r17.a, a(), this.c, r9, false, this.f.e), new AudioRecordDataProcessor$UploadAudioDataConsumer$onUpdateAudio$1());
            return true;
        L18:
            if (r15.length() == 0) goto L21;
            r16 = false;
        L10:
            Log.e("AudioRecordDataProcessor", "[onUpdateAudio]mAudioMessage or buffer is null");
            r13 = false;
            goto L11
        }
    }

    public static final class a {
    }

    public final class b extends com.ss.android.lark.keyboard.plugin.tool.voice.processor.a {
        public final /* synthetic */ AudioRecordDataProcessor d;

        public b(AudioRecordDataProcessor r2, qob.a r3) {
            Intrinsics.checkNotNullParameter(r3, "mAudioDataDependency");
            this.d = r2;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.a
        public final boolean c(String r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "strFileName");
            Intrinsics.checkNotNullParameter(r4, "cid");
            if (super.c(r3, r4, r5) == true) goto L6;
            return false;
        L6:
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r6 = this.b;
            if (r6 == null) goto L21;
            AudioRecordDataProcessor r7 = this.d;
            Message r0 = r6.a;
            if (r0 == null) goto L22;
            AudioContent r8 = r6.b;
            if (r8 == null) goto L13;
            r8.setUploadId("");
        L13:
            r7.c.p(r0, r3);
            com.ss.android.lark.keyboard.b r9 = r7.i();
            if (r9 == null) goto L18;
            k r10 = r9.e();
            if (r10 == null) goto L18;
            r10.a(q.a.a, r10.b());
        L18:
            this.b = null;
            return true;
        L22:
            return true;
        L21:
            return true;
        }
    }

    static {
    }

    public final void b() {
    }

    public final void e() {
        UploadAudioDataConsumer r0 = this.j;
        if (r0 == null) goto L9;
        r0.f();
        com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r1 = r0.b;
        if (r1 == null) goto L9;
        Message r2 = r1.a;
        if (r2 == null) goto L9;
        r0.d.m(r2.getId());
    L9:
        j();
    }

    public final com.ss.android.lark.keyboard.b i() {
        return (com.ss.android.lark.keyboard.b) this.f.getValue();
    }

    public final void j() {
        this.h.d();
        com.ss.android.lark.audio.voiceinput.processor.a r0 = this.i;
        r0.a.clear();
        r0.b = 0;
        UploadAudioDataConsumer r1 = this.j;
        if (r1 == null) goto L5;
        r1.e();
    L5:
        RecognizeWithUploadAudioDataConsumer r2 = this.k;
        if (r2 == null) goto L9;
        r2.e();
        return;
    }

    public final void onDestroy() {
        this.g.shutdown();
        RecognizeWithUploadAudioDataConsumer r0 = this.k;
        if (r0 == null) goto L6;
        RecognizeAudioData r1 = r0.i;
        r1.a.Ed(r1.j);
        return;
    }

    public final void d(com.ss.android.lark.audio.voiceinput.d.b r1) {
        this.m = r1;
    }

    public static final void a(AudioRecordDataProcessor r1, Runnable r2) {
        if (r1.g.isShutdown() == true) goto L6;
        r1.g.execute(r2);
        return;
    }

    public final void c(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "strFileName");
        Intrinsics.checkNotNullParameter(r3, "cid");
        if (r4 == false) goto L8;
        RecognizeWithUploadAudioDataConsumer r5 = this.k;
        if (r5 == null) goto L16;
        r5.d(r2, r3, true);
        return;
    L16:
        return;
    L8:
        if (this.d == false) goto L12;
        UploadAudioDataConsumer r6 = this.j;
        if (r6 == null) goto L18;
        r6.d(r2, r3, true);
        return;
    L18:
        return;
    L12:
        b r7 = this.l;
        if (r7 == null) goto L20;
        r7.d(r2, r3, true);
        return;
    }

    public final void g(String r2, String r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "strFileName");
        Intrinsics.checkNotNullParameter(r3, "cid");
        if (r5 == false) goto L8;
        RecognizeWithUploadAudioDataConsumer r6 = this.k;
        if (r6 == null) goto L15;
        r6.c(r2, r3, r4);
    L15:
        j();
        return;
    L8:
        if (this.d == false) goto L12;
        UploadAudioDataConsumer r7 = this.j;
        if (r7 == null) goto L15;
        r7.c(r2, r3, r4);
        goto L15
    L12:
        b r8 = this.l;
        if (r8 == null) goto L15;
        r8.c(r2, r3, r4);
        goto L15
    }

    public final void h(ByteBuffer r3, int r4, double r5, boolean r7) {
        if (r7 == false) goto L7;
        RecognizeWithUploadAudioDataConsumer r8 = this.k;
        if (r8 == null) goto L17;
        r8.g(r3, r4, r5);
        return;
    L17:
        return;
    L7:
        if (this.d == false) goto L19;
        com.ss.android.lark.audio.voiceinput.processor.a r9 = this.i;
        r9.getClass();
        if (r3 != null) goto L11;
    L13:
        UploadAudioDataConsumer r10 = this.j;
        if (r10 == null) goto L20;
        r10.i(r3, r4, r5);
        return;
    L20:
        return;
    L11:
        if (r3.hasArray() == false) goto L13;
        r9.a.offer(r3);
        r9.b += r3.array().length;
        goto L13
    }

    public AudioRecordDataProcessor(l r10, IAudioService r11, qob.a r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "newAudio2TextPush");
        Intrinsics.checkNotNullParameter(r11, "audioService");
        Intrinsics.checkNotNullParameter(r12, "processorDependency");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = LazyKt.lazy(new AudioRecordDataProcessor$keyboard$2(this));
        this.g = CoreThreadPool.getDefault().newSerialIODensityThreadPool("audio-send");
        this.h = new com.larksuite.framework.callback.c(new Handler(Looper.getMainLooper()));
        this.i = new com.ss.android.lark.audio.voiceinput.processor.a();
        String r15 = r12.getChatId();
        String r8 = r12.k();
        r12.i();
        UploadAudioDataConsumer r2 = new UploadAudioDataConsumer(this, r12);
        this.j = r2;
        this.l = new b(this, r12);
        this.k = new RecognizeWithUploadAudioDataConsumer(this, r2, r10, r11, r15, r8, "");
        Log.i("AudioRecordDataProcessor", "init deviceLocale:" + r8 + " supportPartialUpload:" + r13 + " chatId:" + r15);
    }

    public final void f(String r8, String r9, boolean r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "strFileName");
        Intrinsics.checkNotNullParameter(r9, "cid");
        String r2 = this.c.h();
        String r3 = this.c.d();
        com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r6 = this.c.f();
        Message r0 = this.c.e(r2, r3, r8, r9, r6);
        if (r0 == null) goto L5;
        AudioContent r1 = (AudioContent) r0.getContent();
    L6:
        com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r4 = new com.ss.android.lark.keyboard.plugin.tool.voice.processor.b(r0, r1, r8, r9);
        StringBuilder r13 = new StringBuilder("[onPrepareForRecord] audioMessage is not null ");
        if (r0 == null) goto L9;
        boolean r5 = true;
    L10:
        r13.append(r5);
        r13.append(" cid:");
        r13.append(r9);
        r13.append(" needRecognized:");
        r13.append(r10);
        r13.append(" onlyText:");
        r13.append(r11);
        Log.i("AudioRecordDataProcessor", r13.toString());
        UploadAudioDataConsumer r14 = this.j;
        if (r14 == null) goto L13;
        Intrinsics.checkNotNullParameter(r4, "audioMsgInfo");
        r14.b = r4;
        r14.h();
    L13:
        RecognizeWithUploadAudioDataConsumer r15 = this.k;
        if (r15 == null) goto L19;
        Intrinsics.checkNotNullParameter(r4, "audioMsgInfo");
        r15.b = r4;
        r15.f();
        RecognizeAudioData r16 = r15.i;
        r16.getClass();
        if (r12 != null) goto L18;
        r12 = "un_auto";
    L18:
        r16.e = r12;
    L19:
        b r17 = this.l;
        if (r17 == null) goto L23;
        Intrinsics.checkNotNullParameter(r4, "audioMsgInfo");
        r17.b = r4;
        return;
    L23:
        return;
    L9:
        r5 = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
