package com.obric.memorydata.awareness.audio;

import android.content.Context;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0015\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001dH\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH\u0002R\u000e\u0010\"\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryDebugEvidenceStore;", "", "<init>", "()V", "isRetentionEnabled", "", "setRetentionEnabled", "", "enabled", "canRetainNewAudio", "taskEvidenceDirectory", "Ljava/io/File;", "accountScope", "", "taskId", "writeL0Result", "resultJson", "deleteTaskEvidence", "evidenceRootDirectory", "exportRootDirectory", "retainedAudioBytes", "", "directorySize", "root", "writeAtomically", "destination", "bytes", "", "preferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "()Landroid/content/SharedPreferences;", "sha256", EventBody.KEY_VALUE, "PREFERENCES_NAME", "KEY_ENABLED", "EVIDENCE_DIRECTORY", "EXPORT_DIRECTORY", "UPLOAD_DIRECTORY", "PRIVATE_SOURCE_DIRECTORY", "L0_RESULT_FILE", "MIN_FREE_BYTES", "MAX_RETAINED_BYTES", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8523a = null;

    static {
        f8523a = new c();
    }

    private c() {
    }

    private final long a(File r6) {
        long r0 = 0;
        if (r6.exists() == true) goto L5;
        return 0;
    L5:
        Iterator r5 = SequencesKt.filter((Sequence) ZeusTransformUtils.preCheckCast(FilesKt.walkTopDown(r6), Sequence.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(AuditoryDebugEvidenceStore$directorySize$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r0 = r0 + ((File) ZeusTransformUtils.preCheckCast(r5.next(), File.class, "com.obric.memorydata.plugin")).length();
        goto L7
    L9:
        return r0;
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String a(String r11) {
        MessageDigest r10 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        byte[] r12 = r11.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r12, "getBytes(...)");
        byte[] r1 = r10.digest(r12);
        Intrinsics.checkNotNullExpressionValue(r1, "digest(...)");
        return ArraysKt.joinToString$default(r1, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$c$chfsbdmw1DT0082eTulNeKFqRI.INSTANCE, 30, null);
    }

    private final boolean a(File r8, byte[] r9) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L42
        c r7 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        File r10 = r8.getParentFile();     // Catch: Throwable -> L42
        if (r10 == null) goto L41;
        if (r10.exists() == false) goto L8;
    L11:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L39;
        File r4 = new File(r10, r8.getName() + ".tmp");     // Catch: Throwable -> L42
        if (r4.exists() == true) goto L17;
    L20:
        boolean r11 = true;
    L21:
        if (r11 == false) goto L37;
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r4), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        FileOutputStream r5 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r12, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        r5.write(r9);     // Catch: Throwable -> L28
        r5.getFD().sync();     // Catch: Throwable -> L28
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L33
        Files.move(r4.toPath(), r8.toPath(), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING});     // Catch: Throwable -> L33
        r4.delete();     // Catch: Throwable -> L42
        Object r14 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L42
    L45:
        if (Result.m1427isFailureimpl(r14) == false) goto L48;
        r14 = false;
    L48:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r4.delete();     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L37:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L42
    L17:
        if (r4.delete() == true) goto L20;
        r11 = false;
        goto L21
    L39:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L42
    L8:
        if (r10.mkdirs() == true) goto L11;
        r3 = false;
        goto L13
    L41:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L45
    }

    private final long d() {
        File r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir();
        return a(new File(r0, "auditory_memory")) + a(new File(r0, "auditory_memory_source"));
    }

    /* JADX INFO: renamed from: lambda$chfsbdmw1DT0082e-TulNeKFqRI, reason: not valid java name */
    public static /* synthetic */ CharSequence m481lambda$chfsbdmw1DT0082eTulNeKFqRI(byte r0) {
        return a(r0);
    }

    public final File a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "accountScope");
        Intrinsics.checkNotNullParameter(r5, "taskId");
        return new File(new File(c(), a(r4)), r5);
    }

    public final boolean a() {
        return false;
    }

    public final boolean a(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "accountScope");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "resultJson");
        if (a() == true) goto L6;
        return false;
    L6:
        File r0 = new File(a(r2, r3), "l0_result.json");
        byte[] r5 = r4.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r5, "getBytes(...)");
        return a(r0, r5);
    }

    public final boolean b() {
        if (a() == true) goto L20;
        return false;
    L20:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        c r7 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir().getUsableSpace() >= 2147483648L) goto L8;
    L10:
        boolean r8 = false;
    L11:
        Object r9 = Result.m1421constructorimpl(Boolean.valueOf(r8));     // Catch: Throwable -> L13
    L16:
        if (Result.m1427isFailureimpl(r9) == false) goto L19;
        r9 = false;
    L19:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        if (r7.d() >= 5368709120L) goto L10;
        r8 = true;
    L13:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final boolean b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "accountScope");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        File r1 = a(r2, r3);
        if (r1.exists() == true) goto L5;
    L8:
        return true;
    L5:
        if (FilesKt.deleteRecursively(r1) == true) goto L8;
        return false;
    }

    public final File c() {
        return new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "auditory_debug_evidence");
    }
}
