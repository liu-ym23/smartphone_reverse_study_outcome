package com.larus.avlink.e.mock;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public final Lazy a;
    public final PolarisFileWrapper b;

    public static final class a {
    }

    static {
    }

    public c() {
        Lazy r0 = LazyKt.lazy(new b());
        this.a = r0;
        PolarisFileWrapper r1 = new PolarisFileWrapper((File) r0.getValue(), "Dora_Image");
        this.b = r1;
        a((File) r0.getValue());
        a(r1);
        FLogger r2 = FLogger.a;
        r2.i("CameraMockFileManager", "CameraMockFileManager initialized. BaseDir: " + ((File) r0.getValue()).getAbsolutePath());
        r2.i("CameraMockFileManager", "Dora_Image dir: " + r1.getAbsolutePath());
    }

    public static void a(File r1) {
        if (r1.exists() == true) goto L6;
        r1.mkdirs();
        return;
    }

    public final PolarisFileWrapper b(int r6, int r7, int r8) {
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.b, "mode_" + r6);
        PolarisFileWrapper r9 = new PolarisFileWrapper(r1, "dataSet_" + r7);
        PolarisFileWrapper r10 = new PolarisFileWrapper(r9, "pic_data");
        PolarisFileWrapper r3 = new PolarisFileWrapper(r9, "voice_data");
        a(r1);
        a(r9);
        a(r10);
        a(r3);
        PolarisFileWrapper r11 = new PolarisFileWrapper(new PolarisFileWrapper(r9, "pic_data"), "index_" + r8);
        a(r11);
        return r11;
    }

    public final void c(int r12, int r13, int r14, List r15) {
        Intrinsics.checkNotNullParameter(r15, "sequence");
        PolarisFileWrapper r3 = new PolarisFileWrapper(b(r12, r13, r14), "sequence.json");     // Catch: Exception -> L5
        FilesKt.writeText$default(r3, h.e(new SequenceMetadata(Integer.valueOf(r12), Integer.valueOf(r13), Integer.valueOf(r14), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US).format(new Date()), r15)), null, 2, null);     // Catch: Exception -> L5
        FLogger.a.i("CameraMockFileManager", "✅ Sequence saved for imageUuid=" + r14 + ": " + r3.getAbsolutePath() + " (" + r15.size() + " callbacks)");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e("CameraMockFileManager", "saveSequenceToImageUuidDir failed for imageUuid=" + r14, e);
    }
}
