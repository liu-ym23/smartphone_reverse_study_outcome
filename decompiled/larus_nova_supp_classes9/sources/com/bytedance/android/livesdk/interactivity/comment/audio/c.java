package com.bytedance.android.livesdk.interactivity.comment.audio;

import am2.x;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.interactivity.api.IAudioController;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.ILiveWrappedAudio;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICoreDataType;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICoreIdentify;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICorePropertyId;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mf2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements IAudioController, Handler.Callback {
    public com.bytedance.android.livesdk.interactivity.comment.audio.b a;
    public final AtomicReference<mf2.a> b;
    public final AtomicReference<mf2.a> c;
    public PthreadHandlerThreadV2 d;
    public Handler e;
    public float[] f;
    public String g;
    public String h;
    public volatile String i;
    public volatile String j;
    public long k;
    public volatile boolean l;
    public volatile boolean m;
    public final AtomicInteger n;
    public b o;
    public final d p;
    public final DataCenter q;

    public static final class a {
    }

    public interface b {
        void b(String r1);

        void c(byte[] r1);

        void f(String r1, long r2);
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.audio.c$c, reason: collision with other inner class name */
    public static final class C0113c {
        public C0113c() {
        }
    }

    public static final class d implements com.bytedance.android.livesdk.interactivity.comment.audio.b.InterfaceC0112b {
        public final /* synthetic */ c a;

        public d(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.audio.b.InterfaceC0112b
        public final void a(byte[] r6) {
            Intrinsics.checkNotNullParameter(r6, "pcmData");
            AndroidSchedulers.mainThread().scheduleDirect(new com.bytedance.android.livesdk.interactivity.comment.audio.d(this, r6));
            c r0 = this.a;
            if (r0.f != null) goto L6;
            r0.f = new float[r6.length / 2];
            Unit r7 = Unit.INSTANCE;
        L6:
            if (r0.m == true) goto L51;
            f r1 = null;
            if (this.a.l == false) goto L31;
            mf2.a r8 = this.a.c.get();
            if (r8 == null) goto L12;
            long r3 = r8.e();
        L14:
            if (r3 == 0) goto L31;
            ILiveWrappedAudio.Companion.getClass();
            ILiveWrappedAudio r9 = ILiveWrappedAudio.a.a();
            if (r9 == null) goto L18;
            r1 = r9.newSAMICoreBlock();
        L18:
            if (r1 == null) goto L20;
            LiveWrappedSAMICoreDataType r10 = LiveWrappedSAMICoreDataType.SAMICoreDataType_Float;
            r1.a();
        L20:
            if (r1 == null) goto L25;
            ILiveWrappedAudio r11 = ILiveWrappedAudio.a.a();
            if (r11 == null) goto L24;
            r11.newSAMICoreAudioBin();
        L24:
            r1.b();
        L25:
            if (r1 == null) goto L27;
            r1.c();
        L27:
            Handler r13 = this.a.e;
            if (r13 == null) goto L52;
            r13.sendMessage(r13.obtainMessage(104, r1));
            return;
        L52:
            return;
        L12:
            r3 = 0;
        L31:
            if (this.a.l == true) goto L54;
            mf2.a r14 = this.a.b.get();
            if (r14 == null) goto L35;
            long r4 = r14.e();
        L37:
            if (r4 == 0) goto L55;
            ILiveWrappedAudio.Companion.getClass();
            ILiveWrappedAudio r15 = ILiveWrappedAudio.a.a();
            if (r15 == null) goto L41;
            r1 = r15.newSAMICoreBlock();
        L41:
            if (r1 == null) goto L43;
            LiveWrappedSAMICoreDataType r16 = LiveWrappedSAMICoreDataType.SAMICoreDataType_Float;
            r1.a();
        L43:
            if (r1 == null) goto L45;
            float[] r17 = this.a.f;
            ILiveWrappedAudio.a.a().newSAMICoreAudioBuffer();
            r1.b();
        L45:
            if (r1 == null) goto L47;
            r1.c();
        L47:
            Handler r18 = this.a.e;
            if (r18 == null) goto L56;
            r18.sendMessage(r18.obtainMessage(101, r1));
            return;
        L56:
            return;
        L55:
            return;
        L35:
            r4 = 0;
            goto L37
        L54:
            return;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ long b;

        public e(c r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = this.a;     // Catch: Throwable -> L6
            b r1 = r0.o;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.f(r0.h, this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAudioController
    public final void clear() {
        this.l = false;
        PthreadHandlerThreadV2 r0 = this.d;
        if (r0 == null) goto L5;
        r0.quit();
    L5:
        this.d = null;
        this.e = null;
        com.bytedance.android.livesdk.interactivity.comment.audio.b r1 = this.a;
        if (r1 == null) goto L16;
        r1.d = null;
        TokenCert r2 = b72.a.e;
        Intrinsics.checkNotNullParameter(r2, "cert");
        AudioRecord r3 = r1.c;     // Catch: BPEAException -> L12 IllegalStateException -> L14
        if (r3 == null) goto L16;
        g80.a.c(r3, r2);     // Catch: BPEAException -> L12 IllegalStateException -> L14
    L12:
        e = move-exception;
        f72.a.b("Release Record BPEAException: " + e.getMessage());
    L14:
        e = move-exception;
        f72.a.b("Release Record Exception: " + e.getMessage());
    L16:
        this.a = null;
        mf2.a r4 = this.b.getAndSet(null);
        if (r4 == null) goto L19;
        b(r4);
    L19:
        mf2.a r5 = this.c.getAndSet(null);
        if (r5 == null) goto L25;
        r5.b();
        b(r5);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAudioController
    public final boolean startAsrAudio() {
        this.l = true;
        this.m = false;
        a();
        this.i = BuildConfig.FLAVOR;
        this.j = BuildConfig.FLAVOR;
        com.bytedance.android.livesdk.interactivity.comment.audio.b r2 = this.a;
        if (r2 == null) goto L5;
        r2.a(b72.a.c);
    L5:
        IInteractivityInjectService r3 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r3 == null) goto L8;
        r3.muteLivePlayerClient();
    L8:
        xs2.b.a().post(new u22.e());
        DataCenter r4 = this.q;
        if (r4 == null) goto L11;
        r4.put("data_room_comment_is_audio_recording", Boolean.TRUE);
    L11:
        Handler r5 = this.e;
        if (r5 == null) goto L14;
        r5.sendMessage(r5.obtainMessage(103));
    L14:
        HashMap r6 = new HashMap();
        r6.put("entrance", "asr_pannel");
        IInteractivityInjectService r7 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r7 == null) goto L17;
        r7.buildVsRoomLog(this.q, r6);
    L17:
        j0.l().sendLog("livesdk_voice_comment_click", r6, new Object[]{IRoom.class, x.class});
        f72.a.b("startAsrAudio");
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAudioController
    public final boolean startRecordAudio() {
        this.l = false;
        this.m = false;
        a();
        this.g = jc1.a.b().getFilesDir().getAbsolutePath() + "/audio/";
        File r1 = new PolarisFileWrapper(this.g);
        Integer r4 = null;
        if ((!r1.exists()) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L8;
        r1.mkdir();
    L8:
        this.h = this.g + DigestUtils.md5Hex(String.valueOf(System.currentTimeMillis())) + ".aac";
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r2 = ILiveWrappedAudio.a.a();
        if (r2 == null) goto L11;
        r2.newSAMICoreAudioEncodeContextParameter();
    L11:
        mf2.a r3 = this.b.get();
        if (r3 == null) goto L14;
        LiveWrappedSAMICoreIdentify r5 = LiveWrappedSAMICoreIdentify.SAMICoreIdentify_EngineExecutor_KWS;
        r4 = Integer.valueOf(r3.d());
    L14:
        this.k = SystemClock.elapsedRealtime();
        if (r4 != null) goto L18;
    L19:
        f72.a.b("create encoder handle failed, ret " + r4);
        if (r4 == null) goto L22;
        int r6 = r4.intValue();
    L23:
        f72.a.a(1, r6);
    L24:
        com.bytedance.android.livesdk.interactivity.comment.audio.b r7 = this.a;
        if (r7 == null) goto L27;
        r7.a(b72.a.c);
    L27:
        IInteractivityInjectService r8 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r8 == null) goto L30;
        r8.muteLivePlayerClient();
    L30:
        xs2.b.a().post(new u22.e());
        DataCenter r9 = this.q;
        if (r9 == null) goto L33;
        r9.put("data_room_comment_is_audio_recording", Boolean.TRUE);
    L33:
        HashMap r10 = new HashMap();
        r10.put("entrance", "voice_pannel");
        IInteractivityInjectService r11 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r11 == null) goto L36;
        r11.buildVsRoomLog(this.q, r10);
    L36:
        j0.l().sendLog("livesdk_voice_comment_click", r10, new Object[]{IRoom.class, x.class});
        f72.a.b("startRecordAudio");
        return true;
    L22:
        r6 = -10086;
        goto L23
    L18:
        if (r4.intValue() == 0) goto L24;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAudioController
    public final boolean stopAsrAudio() {
        this.m = true;
        DataCenter r1 = this.q;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L12;
        IInteractivityInjectService r4 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r4 == null) goto L12;
        r4.unmuteLivePlayerClient();
    L12:
        com.bytedance.android.livesdk.interactivity.comment.audio.b r5 = this.a;
        if (r5 == null) goto L15;
        r5.b(b72.a.d);
    L15:
        DataCenter r6 = this.q;
        if (r6 == null) goto L18;
        r6.put("data_room_comment_is_audio_recording", Boolean.FALSE);
    L18:
        String r7 = this.i + this.j;
        b r8 = this.o;
        if (r8 == null) goto L22;
        r8.b(r7);
    L22:
        if (r7.length() != 0) goto L24;
        r2 = true;
    L24:
        if (r2 == false) goto L30;
        InteractivityMonitor.Event r9 = InteractivityMonitor.Event.AudioTransferError;
        DataCenter r10 = this.q;
        if (r10 == null) goto L28;
        IRoom r11 = a0.n(r10);
    L29:
        InteractivityMonitor.c(r9, r11, 1, null, 24);
        goto L30
    L28:
        r11 = null;
    L30:
        Handler r13 = this.e;
        if (r13 == null) goto L33;
        r13.sendMessage(r13.obtainMessage(105));
    L33:
        f72.a.b("stopAsrAudio");
        return true;
    L5:
        if (((Boolean) r1.get("data_game_screen_cast_tv", Boolean.FALSE)).booleanValue() == false) goto L7;
        r3 = true;
        goto L8
    }

    public final void a() {
        if (this.d != null) goto L6;
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("Audio_Process");
        ThreadMethodProxy.start(r0);
        this.e = new Handler(r0.getLooper(), this);
        Unit r1 = Unit.INSTANCE;
        this.d = r0;
    L6:
        if (this.a != null) goto L8;
        com.bytedance.android.livesdk.interactivity.comment.audio.b r2 = new com.bytedance.android.livesdk.interactivity.comment.audio.b();
        r2.d = this.p;
        Unit r3 = Unit.INSTANCE;
        this.a = r2;
    L8:
        f72.a.b("createRecorderAndSamiCore: " + this.c.get());
        AtomicReference<mf2.a> r4 = this.b;
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r5 = ILiveWrappedAudio.a.a();
        if (r5 == null) goto L11;
        mf2.a r6 = r5.newSAMICore();
    L13:
        if (r4.compareAndSet(null, r6) == true) goto L17;
        if (r4.get() == null) goto L13;
    L17:
        AtomicReference<mf2.a> r7 = this.c;
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r8 = ILiveWrappedAudio.a.a();
        if (r8 == null) goto L22;
        mf2.a r9 = r8.newSAMICore();
        if (r9 == null) goto L22;
        r9.b();
        Unit r10 = Unit.INSTANCE;
    L24:
        if (r7.compareAndSet(null, r9) == true) goto L28;
        if (r7.get() == null) goto L24;
        return;
    L28:
        return;
    L22:
        r9 = null;
        goto L24
    L11:
        r6 = null;
        goto L13
    }

    public final void c() {
        if (this.d != null) goto L5;
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("Audio_Process");
        ThreadMethodProxy.start(r0);
        this.e = new Handler(r0.getLooper(), this);
        Unit r1 = Unit.INSTANCE;
        this.d = r0;
    L5:
        AtomicReference<mf2.a> r2 = this.c;
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r3 = ILiveWrappedAudio.a.a();
        if (r3 == null) goto L10;
        mf2.a r4 = r3.newSAMICore();
        if (r4 == null) goto L10;
        r4.b();
        Unit r5 = Unit.INSTANCE;
    L12:
        if (r2.compareAndSet(null, r4) == true) goto L16;
        if (r2.get() == null) goto L12;
    L16:
        Handler r6 = this.e;
        if (r6 == null) goto L24;
        r6.sendMessage(r6.obtainMessage(103));
        return;
    L24:
        return;
    L10:
        r4 = null;
        goto L12
    }

    public c(DataCenter r2) {
        this.q = r2;
        this.b = new AtomicReference();
        this.c = new AtomicReference();
        this.i = BuildConfig.FLAVOR;
        this.j = BuildConfig.FLAVOR;
        this.m = true;
        this.n = new AtomicInteger(0);
        this.p = new d(this);
        new C0113c();
    }

    public static void b(mf2.a r5) {
        if (r5.e() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r5 = null;
    L9:
        if (r5 == null) goto L12;
        r5.a();
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r9) {
        Intrinsics.checkNotNullParameter(r9, "msg");
        boolean r3 = true;
        Object r5 = null;
        mf2.a r6 = null;
        Object r7 = null;
        mf2.a r8 = null;
        switch(r9.what) {
            case 101: goto L51;
            case 102: goto L42;
            case 103: goto L24;
            case 104: goto L15;
            case 105: goto L5;
            default: goto L60;
        };
    L5:
        mf2.a r10 = this.c.get();
        if (r10 == null) goto L60;
        LiveWrappedSAMICorePropertyId r0 = LiveWrappedSAMICorePropertyId.SAMICorePropertyID_Base_NAME;
        if (r10.e() != 0) goto L11;
        r3 = false;
    L11:
        if (r3 == false) goto L13;
        r6 = r10;
    L13:
        if (r6 == null) goto L60;
        r6.c();
        goto L60
    L15:
        Object r11 = r9.obj;
        if ((r11 instanceof f) == false) goto L20;
        r7 = r11;
    L20:
        if (((f) r7) == null) goto L60;
        mf2.a r13 = this.c.get();
        if (r13 == null) goto L60;
        r13.f();
        goto L60
    L24:
        f72.a.b("initOnlineAsrSamiCore connectState: " + this.n.get());
        if (this.n.compareAndSet(0, 1) == false) goto L60;
        mf2.a r14 = this.c.get();
        if (r14 == null) goto L60;
        if (r14.e() == 0) goto L33;
        r3 = false;
    L33:
        if (r3 == false) goto L35;
        r8 = r14;
    L35:
        if (r8 == null) goto L60;
        ((IInteractivityInjectService) k.n(IInteractivityInjectService.class)).createSamiTokenParams();
        k.n(IMiddleWareHostContext.class).isBoe();
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r15 = ILiveWrappedAudio.a.a();
        if (r15 == null) goto L39;
        r15.newSAMICoreAsrContextCreateParameter();
    L39:
        LiveWrappedSAMICoreIdentify r16 = LiveWrappedSAMICoreIdentify.SAMICoreIdentify_EngineExecutor_KWS;
        int r17 = r8.d();
        if (r17 == 0) goto L60;
        f72.a.b("create asr handle failed, ret " + r17);
        f72.a.a(2, r17);
        goto L60
    L42:
        Handler r1 = this.e;
        if (r1 == null) goto L45;
        r1.removeMessages(101);
    L45:
        mf2.a r2 = this.b.getAndSet(null);
        if (r2 == null) goto L49;
        b(r2);
    L49:
        if (r9.arg1 != 1001) goto L60;
        AndroidSchedulers.mainThread().scheduleDirect(new e(this, r9.arg2));
        goto L60
    L51:
        Object r18 = r9.obj;
        if ((r18 instanceof f) == false) goto L56;
        r5 = r18;
    L56:
        if (((f) r5) == null) goto L60;
        mf2.a r19 = this.b.get();
        if (r19 == null) goto L60;
        r19.f();
    L60:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IAudioController
    public final boolean stopRecordAudio(boolean r7, boolean r8) {
        this.m = true;
        DataCenter r1 = this.q;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L12;
        IInteractivityInjectService r3 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r3 == null) goto L12;
        r3.unmuteLivePlayerClient();
    L12:
        com.bytedance.android.livesdk.interactivity.comment.audio.b r4 = this.a;
        if (r4 == null) goto L15;
        r4.b(b72.a.d);
    L15:
        DataCenter r5 = this.q;
        if (r5 == null) goto L19;
        r5.put("data_room_comment_is_audio_recording", Boolean.FALSE);
    L19:
        if (r8 == false) goto L24;
        Handler r9 = this.e;
        if (r9 == null) goto L23;
        r9.sendEmptyMessage(102);
    L23:
        return true;
    L24:
        if (r7 == false) goto L28;
        Handler r10 = this.e;
        if (r10 == null) goto L28;
        r10.sendMessage(r10.obtainMessage(102, 1001, (int) (SystemClock.elapsedRealtime() - this.k)));
    L28:
        f72.a.b("stopRecordAudio");
        return true;
    L5:
        if (((Boolean) r1.get("data_game_screen_cast_tv", Boolean.FALSE)).booleanValue() == false) goto L7;
        r2 = true;
        goto L8
    }
}
