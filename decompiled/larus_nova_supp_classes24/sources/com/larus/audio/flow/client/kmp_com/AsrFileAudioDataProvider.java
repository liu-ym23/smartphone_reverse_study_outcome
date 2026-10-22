package com.larus.audio.flow.client.kmp_com;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.bytedance.flow_audio.api.business.asr.source.FlowAsrFileAudioDataProvider;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.BufferedInputStream;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kw5.c;
import kw5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/audio/flow/client/kmp_com/AsrFileAudioDataProvider;", "Lcom/bytedance/flow_audio/api/business/asr/source/FlowAsrFileAudioDataProvider;", "<init>", "()V", "openFileAudioData", "Lcom/bytedance/flow_audio/api/business/asr/source/FlowAsrFileAudioDataOpenResult;", "filePath", "", "AndroidFileAudioDataStream", "Companion", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AsrFileAudioDataProvider implements FlowAsrFileAudioDataProvider {
    public static final /* synthetic */ int b = 0;

    public static final class a implements d {
        public final BufferedInputStream b;
        public final byte[] c;
        public boolean d;

        public final c Y() {
            if (this.d == true) goto L5;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
            int r1 = this.b.read(this.c);     // Catch: Throwable -> L12
            if (r1 != (-1)) goto L9;
            c.a r2 = c.a.a;     // Catch: Throwable -> L12
        L10:
            Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L12
        L14:
            Throwable r4 = Result.exceptionOrNull-impl(r3);
            if (r4 == null) goto L19;
            c68.b.c("AsrFileAudioDataProvider", "read file audio data failed", r4);
            int r5 = AsrFileAudioDataProvider.b;
            r3 = new c.b(b.a(FlowAsrErrorType.CLIENT_ERROR, -1004, r4.getMessage(), r4.toString()));
        L19:
            return (c) r3;
        L9:
            r2 = new c.c(new kw5.a(Arrays.copyOf(this.c, r1), r1));     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r3 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L14
        L5:
            return c.a.a;
        }

        public final void close() {
            if (this.d == false) goto L5;
            return;
        L5:
            this.d = true;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
            this.b.close();     // Catch: Throwable -> L8
            Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r2 = Result.exceptionOrNull-impl(r1);
            if (r2 == null) goto L16;
            c68.b.c("AsrFileAudioDataProvider", "close file audio data failed", r2);
            return;
        L16:
            return;
        L8:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        }

        public a(BufferedInputStream r2) {
            Intrinsics.checkNotNullParameter(r2, "inputStream");
            this.b = r2;
            this.c = new byte[6400];
        }
    }

    public static final class b {
        public b() {
        }

        public static final hw5.a a(FlowAsrErrorType r1, int r2, String r3, String r4) {
            int r0 = AsrFileAudioDataProvider.b;
            if (r3 != null) goto L5;
        L9:
            r3 = "ASR file data error, code=" + r2;
        L11:
            if (StringsKt.isBlank(r4) == false) goto L14;
            r4 = "code=" + r2 + ",message=" + r3;
        L14:
            return new hw5.a(r1, r3, r2, r4);
        L5:
            if ((!StringsKt.isBlank(r3)) == true) goto L8;
            r3 = null;
        L8:
            if (r3 != null) goto L11;
            goto L9
        }
    }

    static {
        new b();
    }

    public AsrFileAudioDataProvider() {
    }

    public final kw5.b D2(String r7) {
        Intrinsics.checkNotNullParameter(r7, "filePath");
        PolarisFileWrapper r0 = new PolarisFileWrapper(r7);
        if (r0.exists() == false) goto L5;
        long r1 = r0.length();
        if (r1 <= 0) goto L9;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        Object r3 = Result.constructor-impl(new kw5.b.b(new a(new BufferedInputStream(new PolarisFileInputStreamWrapper(r0)))));     // Catch: Throwable -> L12
    L14:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L19;
        int r5 = c68.b.a;
        c68.b.c("AsrFileAudioDataProvider", "open file audio data failed path=" + r7, r4);
        r3 = new kw5.b.a(b.a(FlowAsrErrorType.CLIENT_ERROR, -1002, r4.getMessage(), r4.toString()));
    L19:
        return (kw5.b) r3;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L9:
        return new kw5.b.a(b.a(FlowAsrErrorType.CLIENT_ERROR, -1004, "ASR retry file is empty", "fileLength=" + r1));
    L5:
        return new kw5.b.a(b.a(FlowAsrErrorType.SOURCE_PREPARE_FAILED, -1001, "ASR retry file not found", "fileExists=false"));
    }
}
