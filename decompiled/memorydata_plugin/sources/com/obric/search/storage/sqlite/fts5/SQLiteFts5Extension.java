package com.obric.search.storage.sqlite.fts5;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.obric.search.common.log.RuntimeLogger;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0086 J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0082 J!\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0082 J*\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c0\u001cH\u0082 ¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J \u0010#\u001a\u00020\u00102\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/search/storage/sqlite/fts5/SQLiteFts5Extension;", "", "()V", "TAG", "", "isInitDone", "", "getOTokenizerResult", "", "Lkotlin/Triple;", "", "type", "input", "getSynonyms", "word", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "nativeGetSynonyms", "nativeSetSynonymFd", "fd", "Ljava/io/FileDescriptor;", CommonConsts.APM_INNER_EVENT_COST_START, "", XSDatatype.FACET_LENGTH, "nativeSetTokenizerSamePinyinExcludedMap", "keys", "", "values", "", "([I[[Ljava/lang/String;)V", "setSynonymAsset", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "setTokenizerSamePinyinConfig", "excludedMap", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SQLiteFts5Extension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SQLiteFts5Extension f14967a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f14968b;

    static {
        SQLiteFts5Extension r0 = new SQLiteFts5Extension();
        f14967a = r0;
        r0.a();
    }

    private SQLiteFts5Extension() {
    }

    private final native List<String> nativeGetSynonyms(String r1);

    private final native void nativeSetSynonymFd(FileDescriptor r1, long r2, long r4);

    private final native void nativeSetTokenizerSamePinyinExcludedMap(int[] r1, String[][] r2);

    public final List<String> a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "word");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return nativeGetSynonyms(r3);
    }

    public final synchronized void a() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (f14968b == true) goto L6;
        SQLiteGlobal.a();     // Catch: Throwable -> L8
        System.loadLibrary("SQLiteFts5Extension");     // Catch: Throwable -> L8
        f14968b = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final void a(Context r10, Uri r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r11, "uri");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L47
        SQLiteFts5Extension r2 = (SQLiteFts5Extension) ZeusTransformUtils.preCheckCast(this, SQLiteFts5Extension.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        String r9 = r11.getScheme();     // Catch: Throwable -> L47
        Unit r8 = null;
        if (r9 == null) goto L7;
        Intrinsics.checkNotNullExpressionValue(r9, "scheme");     // Catch: Throwable -> L47
        String r13 = r9.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L47
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toLowerCase(Locale.ROOT)");     // Catch: Throwable -> L47
    L10:
        if (Intrinsics.areEqual(r13, "file") == false) goto L32;
        String r14 = r11.getHost();     // Catch: Throwable -> L47
        if (r14 == null) goto L14;
        Intrinsics.checkNotNullExpressionValue(r14, "host");     // Catch: Throwable -> L47
        String r15 = r14.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L47
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).toLowerCase(Locale.ROOT)");     // Catch: Throwable -> L47
    L16:
        if (Intrinsics.areEqual(r15, "android_asset") == false) goto L32;
        String r16 = r11.getPath();     // Catch: Throwable -> L47
        if (r16 != null) goto L20;
        r16 = "";
    L20:
        Intrinsics.checkNotNullExpressionValue(r16, "uri.path ?: \"\"");     // Catch: Throwable -> L47
        if (StringsKt.startsWith$default(r16, "/", false, 2, null) == false) goto L23;
        r16 = r16.substring(1);     // Catch: Throwable -> L47
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).substring(startIndex)");     // Catch: Throwable -> L47
    L23:
        Closeable r17 = (Closeable) ZeusTransformUtils.preCheckCast(r12.getAssets().openFd(r16), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        AssetFileDescriptor r18 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r17, AssetFileDescriptor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        FileDescriptor r19 = r18.getFileDescriptor();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r19, "it.fileDescriptor");     // Catch: Throwable -> L27
        r2.nativeSetSynonymFd(r19, r18.getStartOffset(), r18.getLength());     // Catch: Throwable -> L27
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r17, null);     // Catch: Throwable -> L47
    L44:
        Object r20 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        Throwable r21 = Result.m1424exceptionOrNullimpl(r20);
        if (r21 == null) goto L63;
        RuntimeLogger.f14958a.d("SQLiteFts5Extension", "setSynonymAsset error! " + r21.getMessage());
        return;
    L63:
        return;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L14:
        r15 = null;
    L32:
        AssetFileDescriptor r22 = r12.getContentResolver().openAssetFileDescriptor(r11, "r");     // Catch: Throwable -> L47
        if (r22 == null) goto L43;
        Closeable r23 = (Closeable) ZeusTransformUtils.preCheckCast(r22, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        AssetFileDescriptor r111 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r23, AssetFileDescriptor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        FileDescriptor r1 = r111.getFileDescriptor();     // Catch: Throwable -> L38
        Intrinsics.checkNotNullExpressionValue(r1, "it.fileDescriptor");     // Catch: Throwable -> L38
        r2.nativeSetSynonymFd(r1, r111.getStartOffset(), r111.getLength());     // Catch: Throwable -> L38
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L38
        CloseableKt.closeFinally(r23, null);     // Catch: Throwable -> L47
        r8 = Unit.INSTANCE;     // Catch: Throwable -> L47
        goto L43
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        CloseableKt.closeFinally(r23, th);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L43:
        if (r8 != null) goto L44;
        throw new FileNotFoundException(r11 + " not found");     // Catch: Throwable -> L47
    L7:
        r13 = null;
    L47:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r20 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L49
    }

    public final void a(Map<Integer, ? extends List<String>> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "excludedMap");
        int[] r0 = CollectionsKt.toIntArray((Collection) ZeusTransformUtils.preCheckCast(r10.keySet(), Collection.class, "com.obric.memorydata.plugin"));
        int r2 = r0.length;
        String[][] r3 = new String[r2][];
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L5;
        r3[r5] = new String[0];
        r5 = r5 + 1;
        goto L3
    L5:
        int r4 = r0.length;
        int r6 = 0;
    L6:
        if (r6 >= r4) goto L12;
        List r7 = (List) ZeusTransformUtils.preCheckCast(r10.get(Integer.valueOf(r0[r6])), List.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L11;
        Object[] r8 = ((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r3[r6] = (String[]) ZeusTransformUtils.preCheckCast(r8, String[].class, "com.obric.memorydata.plugin");
    L11:
        r6 = r6 + 1;
        goto L6
    L12:
        nativeSetTokenizerSamePinyinExcludedMap(r0, r3);
    }

    public final native List<Triple<String, Integer, Integer>> getOTokenizerResult(int r1, String r2);
}
