package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.bytedance.lark.oggopus_rust_android.OggOpusEncoder;
import com.bytedance.lark.oggopus_rust_android.OggOpusEncoderInputInfo;
import com.bytedance.lark.oggopus_rust_android.Oggopus_rustKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmRecordingRemoteAudioSetting;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingAudioPersistent {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final f b;
    public final String c;
    public final ExecutorCoroutineDispatcher d;
    public File e;
    public VFSFile f;
    public b g;
    public OggOpusEncoder h;

    public static final class a {
    }

    static {
    }

    public MmRecordingAudioPersistent(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r4) {
        int r0 = f.c;
        Intrinsics.checkNotNullParameter(r4, "userComponentContext");
        MmRecordingRemoteAudioSetting r1 = r4.getSettingsService().b;
        this(r4, new f(r1.getMmAudioSampleRate(), r1.getMmAudioChannel()));
    }

    public MmRecordingAudioPersistent(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "uccApi");
        Intrinsics.checkNotNullParameter(r3, "audioFormat");
        this.a = r2;
        this.b = r3;
        this.c = "MmRecordingAudioPersistent";
        this.d = ExecutorsKt.from(CoreThreadPool.getDefault().getSingleScheduledThreadPool("MmAudioPersistent"));
    }

    public static final byte[] a(MmRecordingAudioPersistent r8, byte[] r9) {
        r8.getClass();
        if (r9.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L26;
        f r1 = r8.b;
        long r2 = r1.a;
        long r4 = r1.b;
        if (r4 != 1) goto L11;
        String r3 = null;
    L24:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L14
        Object r5 = Result.constructor-impl(Oggopus_rustKt.encodeDataToOpus(r9, new OggOpusEncoderInputInfo(r2, r4), r3));     // Catch: Throwable -> L14
    L16:
        Throwable r7 = Result.exceptionOrNull-impl(r5);
        if (r7 == null) goto L19;
        lvb.a.b(r8.c, "[encodePcmPartToOgg] failed, pcmSize=" + r9.length + ", error=" + r7);
    L19:
        byte[] r10 = new byte[0];
        if (Result.isFailure-impl(r5) == false) goto L23;
        r5 = r10;
    L23:
        return (byte[]) r5;
    L14:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        r3 = "minutes_stereo";
        goto L24
    L26:
        return new byte[0];
    L5:
        r0 = false;
        goto L6
    }

    public static File e(String r2, String r3) {
        pub.a r0 = (pub.a) OfficeSDKManager.getHostGlobalService(pub.a.class);
        if (r0 == null) goto L5;
        PolarisFileWrapper r1 = r0.r0(r2, r3);
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        MmRecordFileHelper.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "meetingId");
        Intrinsics.checkNotNullParameter(r2, "userId");
        h r4 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a;
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter("MinutesRecordings", "directoryName");
        return com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a(r2, "MinutesRecordings"), r3);
    L5:
        r1 = null;
        goto L6
    }

    public static void f(String r2, String r3, String r4) {
        qvb.a r0 = qvb.a.a;
        if (StringsKt.isBlank(r4) == true) goto L6;
        r2 = r2 + ':' + r4;
    L6:
        qvb.a.b(null, r2, r3, "warn", 1);
    }

    public final Object b(String r9, String r10, String r11, ContinuationImpl r12) {
        if (StringsKt.isBlank(r11) == false) goto L6;
        lvb.a.h(this.c, "[assembleFullAudioFileFromParts] skip, audioFilePath is blank, recordingId=" + r10);
        return Boxing.boxBoolean(false);
    L6:
        MmRecordingRemoteAudioSetting r0 = this.a.getSettingsService().b;
        lvb.a.e(this.c, "[audioFormat][assembleFullAudio] recordingId=" + r10 + ", formatId=" + System.identityHashCode(this.b) + ", sampleRate=" + this.b.a + ", channelCount=" + this.b.b + ", currentSampleRate=" + r0.getMmAudioSampleRate() + ", currentChannelCount=" + r0.getMmAudioChannel());
        return BuildersKt.withContext(this.d, new MmRecordingAudioPersistent$assembleFullAudioFileFromParts$2(r9, r10, this, r11, null), r12);
    }

    public final String c(String r7, String r8, MmRecordingSource r9, boolean r10) {
        String r0 = "";
        Intrinsics.checkNotNullParameter(r7, "userId");
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        if (r10 == false) goto L5;
        boolean r11 = true;
    L9:
        Object r3 = null;
        if (r11 == true) goto L39;
        lvb.a.e(this.c, "[createFullAudioFilePath] skip, full audio disabled, recordingId=" + r8 + ", source=" + r9);
        return null;
    L39:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L24
        File r13 = e(r7, r8);     // Catch: Throwable -> L24
        if (r13.mkdirs() == false) goto L16;
    L19:
        h r14 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a;     // Catch: Throwable -> L24
        VFSFile r15 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r13, System.currentTimeMillis() + ".ogg");     // Catch: Throwable -> L24
        if (r15.exists() == true) goto L22;
        r15.createNewFile();     // Catch: Throwable -> L24
    L22:
        Object r16 = Result.constructor-impl(r15.getAbsolutePath());     // Catch: Throwable -> L24
    L26:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L34;
        lvb.a.c(this.c, "[createFullAudioFilePath] failed, recordingId=" + r8 + ", error=" + r17);
        String r18 = r17.getClass().getSimpleName();
        String r19 = r17.getMessage();
        if (r19 == null) goto L32;
        r0 = r19;
    L32:
        f("full_audio_file_create_failed", r18, r0);
    L34:
        if (Result.isFailure-impl(r16) == true) goto L38;
        r3 = r16;
    L38:
        return (String) r3;
    L16:
        if (r13.exists() == true) goto L19;
        lvb.a.b(this.c, "[createFullAudioFilePath] make fullDir failed, dir=" + r13.getAbsolutePath());     // Catch: Throwable -> L24
        f("full_audio_file_create_failed", "make_full_dir_failed", "");     // Catch: Throwable -> L24
        return null;
    L24:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L5:
        pub.a r110 = (pub.a) OfficeSDKManager.getHostGlobalService(pub.a.class);
        if (r110 == null) goto L8;
        r11 = r110.F(r9);
        goto L9
    L8:
        r11 = false;
        goto L9
    }

    public final Object d(byte[] r11, int r12, int r13, Continuation<? super Result<ovb.a>> r14) {
        if ((r14 instanceof MmRecordingAudioPersistent$persistentAudioToFile$1) == false) goto L7;
        MmRecordingAudioPersistent$persistentAudioToFile$1 r0 = (MmRecordingAudioPersistent$persistentAudioToFile$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L18:
        return ((Result) r15).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        ExecutorCoroutineDispatcher r16 = this.d;
        MmRecordingAudioPersistent$persistentAudioToFile$2 r4 = new MmRecordingAudioPersistent$persistentAudioToFile$2(this, r12, r13, r11, null);
        r0.label = 1;
        r15 = BuildersKt.withContext(r16, r4, r0);
        if (r15 != r2) goto L18;
        return r2;
    L7:
        r0 = new MmRecordingAudioPersistent$persistentAudioToFile$1(this, r14);
        goto L8
    }
}
