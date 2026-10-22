package com.obric.memorydata.database.util.file_utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0086@¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0014J \u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/FileUtils;", "", "<init>", "()V", "TAG", "", "getFileContentFromUri", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "fileExtension", "ignoreExtensionList", "", "(Lcom/obric/capabilitykit/entity/app/FileEntity;Ljava/lang/String;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileNameFromUri", "uri", "Landroid/net/Uri;", "getFileExtension", "openFileDescriptorPrivilegedWithFallback", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "(Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ObricMemoryConstants.KEY_PACKAGE_NAME, "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f9660a = null;

    static {
        f9660a = new m();
    }

    private m() {
    }

    private static final UriFileAccessSession a(Uri r7, Exception r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FileUtils", "ContentResolver fallback failed for " + r7 + ": " + r8.getMessage(), null, 4, null);
        return new UriFileAccessSession(3, "ContentResolver fallback failed", null);
    }

    private static final String a(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (ZeusTransformUtils.instanceOf(r3, SecurityException.class) == false) goto L7;
        RunLog.INSTANCE.error("FileUtils", "获取文件名失败，未获得授权", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L7:
        return null;
    }

    private static final String b(Uri r9) {
        Cursor r10 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r9, new String[]{"_display_name"}, null, null, null, "com.obric.memorydata.plugin");
        if (r10 == null) goto L16;
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(r10, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r2 = (Cursor) ZeusTransformUtils.preCheckCast(r11, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r2.moveToFirst() == false) goto L9;
        String r0 = r2.getString(r2.getColumnIndexOrThrow("_display_name"));     // Catch: Throwable -> L11
    L10:
        CloseableKt.closeFinally(r11, null);
        return r0;
    L9:
        r0 = null;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L16:
        return null;
    }

    private static final UriFileAccessSession c(Uri r10) {
        ParcelFileDescriptor r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver().openFileDescriptor(r10, "r");
        if (r3 == null) goto L5;
        UriFileAccessSession r11 = new UriFileAccessSession(0, "success fallback to ContentResolver", new AssetFileDescriptor(r3, 0, -1), 1, null);
    L6:
        return r11;
    L5:
        r11 = new UriFileAccessSession(3, "ContentResolver fallback failed", null);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$1ZeoZq-dcOgNa0gQD3QocAVNp_U, reason: not valid java name */
    public static /* synthetic */ String m585lambda$1ZeoZqdcOgNa0gQD3QocAVNp_U(Exception r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$CkHcENdJVVX7-nOJmJh3UEE0wto, reason: not valid java name */
    public static /* synthetic */ String m586lambda$CkHcENdJVVX7nOJmJh3UEE0wto(Uri r0) {
        return b(r0);
    }

    public static /* synthetic */ UriFileAccessSession lambda$PcEqOdtDxGtOIKKSaTNid4glJwI(Uri r0) {
        return c(r0);
    }

    public static /* synthetic */ UriFileAccessSession lambda$p9DUhwaVUNvxvB6NFwLagpHb0Dk(Uri r0, Exception r1) {
        return a(r0, r1);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object a(FileEntity r11, String r12, String[] r13, Continuation<? super j> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, FileUtils$getFileContentFromUri$1.class) == false) goto L7;
        FileUtils$getFileContentFromUri$1 r1 = (FileUtils$getFileContentFromUri$1) ZeusTransformUtils.preCheckCast(r15, FileUtils$getFileContentFromUri$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L17;
        if (r4 != 1) goto L16;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L13
    L50:
        return (j) ZeusTransformUtils.preCheckCast(r16, j.class, "com.obric.memorydata.plugin");
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r16);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L21;
        r12 = null;
    L21:
        if (r12 == null) goto L24;
        FileExtension r17 = FileExtension.Companion.a(r12);
        FileExtension r18 = r17;
        if (r17 == null) goto L24;
    L30:
        if (r18 == null) goto L39;
        int r19 = r13.length;
        boolean r5 = false;
        int r7 = 0;
    L32:
        if (r7 >= r19) goto L37;
        if (StringsKt.equals(r13[r7], r18.getValue(), true) == true) goto L35;
        r7 = r7 + 1;
        goto L32
    L35:
        r5 = true;
    L37:
        if (r5 == false) goto L39;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder().append("Skip processing this file type: ").append(r18.getValue());
    L27:
        IRunLog.a.a(r0, "FileUtils", r10.toString(), null, 4, null);
        return null;
    L39:
        if (r18 == null) goto L41;
        o r110 = l.f9658a.a(r11, r18);
    L42:
        if (r110 != null) goto L47;
        m r111 = (m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.memorydata.plugin");
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r112 = new StringBuilder().append("The file is too large or the file type is not supported: ");
        Object r113 = r18;
        if (r18 != null) goto L46;
        r113 = "unknown";
    L46:
        r10 = r112.append(r113);
        goto L27
    L47:
        r1.label = 1;     // Catch: Exception -> L13
        r16 = r110.a(r11, r1);     // Catch: Exception -> L13
        if (r16 != r3) goto L50;
        return r3;
    L41:
        r110 = null;
    L24:
        String r114 = ((m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.memorydata.plugin")).a(r11.getContentUrl());
        if (r114 != null) goto L29;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r10 = new StringBuilder().append("File and file name not obtained: ").append(r11.getContentUrl());
        goto L27
    L29:
        FileExtension.a r115 = FileExtension.Companion;
        String r116 = StringsKt.substringAfterLast$default(r114, '.', null, 2, null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r116, "toLowerCase(...)");
        r18 = r115.a(r116);
    L13:
        e = move-exception;
        RunLog.INSTANCE.error("FileUtils", "File processing failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L7:
        r1 = new FileUtils$getFileContentFromUri$1(this, r15);
        goto L8
    }

    public final Object a(FileEntity r3, Continuation<? super UriFileAccessSession> r4) {
        Continuation<? super UriFileAccessSession> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return a(r3.getPackageName(), r3.getContentUrl(), r5);
    }

    public final Object a(String r7, final Uri r8, Continuation<? super UriFileAccessSession> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, FileUtils$openFileDescriptorPrivilegedWithFallback$2.class) == false) goto L7;
        FileUtils$openFileDescriptorPrivilegedWithFallback$2 r0 = (FileUtils$openFileDescriptorPrivilegedWithFallback$2) ZeusTransformUtils.preCheckCast(r10, FileUtils$openFileDescriptorPrivilegedWithFallback$2.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r8 = (Uri) ZeusTransformUtils.preCheckCast(r0.L$1, Uri.class, "com.obric.memorydata.plugin");
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
    L17:
        UriFileAccessSession r12 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r6, UriFileAccessSession.class, "com.obric.memorydata.plugin");
        if (r12.getFd() == null) goto L20;
        return r12;
    L20:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FileUtils", "Privileged open failed for " + r7 + ", fallback to ContentResolver: " + r8, null, 4, null);
        return com.obric.memorydata.utils.y.a(new $$Lambda$m$p9DUhwaVUNvxvB6NFwLagpHb0Dk(r8), new $$Lambda$m$PcEqOdtDxGtOIKKSaTNid4glJwI(r8));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        AtomicCapabilitySdk r13 = AtomicCapabilitySdk.INSTANCE;
        r0.L$0 = r7;
        r0.L$1 = r8;
        r0.label = 1;
        r6 = r13.openFileDescriptorPrivileged(r7, r8, r0);
        if (r6 != r11) goto L17;
        return r11;
    L7:
        r0 = new FileUtils$openFileDescriptorPrivilegedWithFallback$2(this, r10);
        goto L8
    }

    public final String a(final Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.y.a($$Lambda$m$1ZeoZqdcOgNa0gQD3QocAVNp_U.INSTANCE, new $$Lambda$m$CkHcENdJVVX7nOJmJh3UEE0wto(r2)), String.class, "com.obric.memorydata.plugin");
    }
}
