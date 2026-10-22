package com.obric.memorydata.database.util.file_utils;

import android.content.res.AssetFileDescriptor;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/TextFileProcessor;", "Lcom/obric/memorydata/database/util/file_utils/IFileProcessor;", "<init>", "()V", "supportedFileType", "Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "getSupportedFileType", "()Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "process", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aa implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9629a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileExtension f9630b;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/TextFileProcessor$Companion;", "", "<init>", "()V", "TAG", "", "MAX_PARAGRAPH_LENGTH", "", "MAX_LINE_LENGTH", "MAX_FILE_SIZE_BYTES", "SIZE_CHECK_INTERVAL", "fromStream", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "fis", "Ljava/io/FileInputStream;", "flushBufferAsParagraph", "", "tree", "buffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "splitAndAddHugeLine", "line", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private static final Unit a(Ref.BooleanRef r7, Ref.LongRef r8, Ref.LongRef r9, FileInputStream r10, Ref.IntRef r11, j r12, StringBuilder r13, String r14) {
            Intrinsics.checkNotNullParameter(r14, "rawLine");
            if (r7.element == true) goto L5;
            r8.element += (long) r14.length();
            boolean r2 = true;
            if ((r8.element - r9.element) > 1048576) goto L9;
        L13:
            r11.element++;
            String r15 = StringsKt.take(r14, 10000);
            if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L17;
            aa.f9629a.a(r12, r13);
        L28:
            return Unit.INSTANCE;
        L17:
            if ((r13.length() + r15.length()) > 65536) goto L19;
        L26:
            r13.append(r15).append("\n");
            goto L28
        L19:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L22;
            r2 = false;
        L22:
            a r16 = aa.f9629a;
            if (r2 == false) goto L25;
            r16.a(r12, r15);
            goto L28
        L25:
            r16.a(r12, r13);
            goto L26
        L9:
            if (r10.getChannel().position() <= 31457280) goto L12;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TextFileProcessor", "Aborting processing - file size exceeded", null, 4, null);
            r7.element = true;
            return Unit.INSTANCE;
        L12:
            r9.element = r8.element;
            goto L13
        L5:
            return Unit.INSTANCE;
        }

        private final void a(j r9, String r10) {
            Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(StringsKt.chunked((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), 65536), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
            j.a(r9, NodeType.TEXT, r3, -1, null, 8, null);
            goto L4
        }

        private final void a(j r8, StringBuilder r9) {
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
            boolean r7 = true;
        L6:
            if (r7 == false) goto L8;
            return;
        L8:
            String r10 = r9.toString();
            Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
            String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            StringsKt.clear(r9);
            j.a(r8, NodeType.PARAGRAPH, r2, 0, null, 8, null);
            return;
        L5:
            r7 = false;
            goto L6
        }

        public static /* synthetic */ Unit lambda$s1pzaASJzkPDttx2cX9cmtt6XQw(Ref.BooleanRef r0, Ref.LongRef r1, Ref.LongRef r2, FileInputStream r3, Ref.IntRef r4, j r5, StringBuilder r6, String r7) {
            return a(r0, r1, r2, r3, r4, r5, r6, r7);
        }

        public final j a(final FileInputStream r15) {
            Intrinsics.checkNotNullParameter(r15, "fis");
            final j r14 = new j();
            final Ref.LongRef r2 = new Ref.LongRef();
            final Ref.LongRef r3 = new Ref.LongRef();
            final Ref.IntRef r8 = new Ref.IntRef();
            final Ref.BooleanRef r9 = new Ref.BooleanRef();
            Reader r0 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(r15, InputStream.class, "com.obric.memorydata.plugin"), Charsets.UTF_8), Reader.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r0, BufferedReader.class) == false) goto L5;
            BufferedReader r1 = (BufferedReader) ZeusTransformUtils.preCheckCast(r0, BufferedReader.class, "com.obric.memorydata.plugin");
        L6:
            Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r1, Closeable.class, "com.obric.memorydata.plugin");
            BufferedReader r4 = (BufferedReader) ZeusTransformUtils.preCheckCast(r10, BufferedReader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            final StringBuilder r11 = new StringBuilder(65536);     // Catch: Throwable -> L15
            TextStreamsKt.forEachLine((Reader) ZeusTransformUtils.preCheckCast(r4, Reader.class, "com.obric.memorydata.plugin"), new $$Lambda$aa$a$s1pzaASJzkPDttx2cX9cmtt6XQw(r9, r2, r3, r15, r8, r14, r11));     // Catch: Throwable -> L15
            if (r9.element == true) goto L10;
            aa.f9629a.a(r14, r11);     // Catch: Throwable -> L15
            RunLog.INSTANCE.debug("TextFileProcessor", "Processed " + r8.element + " lines");     // Catch: Throwable -> L15
        L10:
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L15
            CloseableKt.closeFinally(r10, null);
            if (r9.element == true) goto L14;
            return r14;
        L14:
            return null;
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            CloseableKt.closeFinally(r10, th);
            throw th;
        L5:
            r1 = new BufferedReader(r0, 8192);
            goto L6
        }
    }

    static {
        f9629a = new a(null);
    }

    public aa() {
        this.f9630b = FileExtension.TXT;
    }

    @Override // com.obric.memorydata.database.util.file_utils.o
    public Object a(FileEntity r13, Continuation<? super j> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, TextFileProcessor$process$1.class) == false) goto L7;
        TextFileProcessor$process$1 r0 = (TextFileProcessor$process$1) ZeusTransformUtils.preCheckCast(r15, TextFileProcessor$process$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L35
    L19:
        UriFileAccessSession r12 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r16, UriFileAccessSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        if (r12 == null) goto L32;
        AssetFileDescriptor r17 = r12.getFd();     // Catch: Throwable -> L35
        if (r17 == null) goto L32;
        Closeable r18 = (Closeable) ZeusTransformUtils.preCheckCast(r17, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        FileInputStream r19 = ((AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r18, AssetFileDescriptor.class, "com.obric.memorydata.plugin")).createInputStream();     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type java.io.FileInputStream");     // Catch: Throwable -> L27
        j r110 = f9629a.a(r19);     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r18, null);     // Catch: Throwable -> L35
    L33:
        Object r111 = Result.m1421constructorimpl(r110);     // Catch: Throwable -> L35
    L37:
        Throwable r112 = Result.m1424exceptionOrNullimpl(r111);
        if (r112 == null) goto L48;
        if (ZeusTransformUtils.instanceOf(r112, IllegalArgumentException.class) == false) goto L42;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TextFileProcessor", "Doubao Assistant is not started, unable to obtain permission: " + r112.getMessage(), null, 4, null);
    L44:
        if (AppContext.INSTANCE.isDebug() == false) goto L48;
        throw r112;
    L42:
        RunLog.INSTANCE.error("TextFileProcessor", "File access failed", r112);
    L48:
        if (Result.m1427isFailureimpl(r111) == false) goto L51;
        return null;
    L51:
        return r111;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L32:
        r110 = null;
        goto L33
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L35
        aa r114 = (aa) ZeusTransformUtils.preCheckCast(this, aa.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        m r115 = m.f9660a;     // Catch: Throwable -> L35
        r0.label = 1;     // Catch: Throwable -> L35
        r16 = r115.a(r13, r0);     // Catch: Throwable -> L35
        if (r16 != r2) goto L19;
        return r2;
    L35:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r111 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r0 = new TextFileProcessor$process$1(this, r15);
        goto L8
    }

    @Override // com.obric.memorydata.database.util.file_utils.o
    public FileExtension j() {
        return this.f9630b;
    }
}
