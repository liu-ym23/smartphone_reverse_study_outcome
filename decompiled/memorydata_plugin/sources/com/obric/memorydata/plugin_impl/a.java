package com.obric.memorydata.plugin_impl;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.DatabaseKeyMigration;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/plugin_impl/DataMigrationUtils;", "", "<init>", "()V", "TAG", "", "OLD_PACKAGE_NAME", "OLD_AUTHORITY", "KEY_GET_PHRASE", "KEY_DELETE_PHRASE", "KEY_DELETE_APPDATA", "databaseNames", "", "enableOrDisableComponent", "", "context", "Landroid/content/Context;", ObricMemoryConstants.KEY_PACKAGE_NAME, "enabled", "", "isComponentEnabled", "invokeAfterMigration", "plugin-impl_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12423a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f12424b = null;

    static {
        f12423a = new a();
        f12424b = CollectionsKt.listOf(new String[]{MemoryDbEngine.ENCRYPT_DB_NAME, "memory_keyword_content_index.db", "memory_vector_db_encrypt"});
    }

    private a() {
    }

    private static final Unit a(ContentResolver r10, Bundle r11, Context r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(f12424b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        Log.i("DataTransferUtils", "delete old passPhrase for " + r7);     // Catch: Exception -> L8
        ZeusProviderTransform.call(r10, "com.obric.memorydata.transfer", "method_delete_pass_phrase", r7, r11, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.w("DataTransferUtils", "delete old passPhrase error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L4
    L16:
        Log.i("DataTransferUtils", "deleting old app data");     // Catch: Exception -> L12
        ZeusProviderTransform.call(r10, "com.obric.memorydata.transfer", "method_clear_app_data", null, r11, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
    L14:
        Log.d("DataTransferUtils", "wait for 5 seconds");
        Thread.sleep(5000);
        Log.i("DataTransferUtils", "disable old app");
        f12423a.a(r13, BuildConfig.LIBRARY_PACKAGE_NAME, false);
        return Unit.INSTANCE;
    L12:
        e = move-exception;
        Log.w("DataTransferUtils", "delete old app data error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L14
    }

    private final void a(Context r2, String r3, boolean r4) {
        PackageManager r1 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageManager();     // Catch: Exception -> L9
        Intrinsics.checkNotNullExpressionValue(r1, "getPackageManager(...)");     // Catch: Exception -> L9
        if (r4 == false) goto L6;
        int r5 = 1;
    L7:
        r1.setApplicationEnabledSetting(r3, r5, 0);     // Catch: Exception -> L9
        return;
    L6:
        r5 = 2;
    L9:
        e = move-exception;
        Log.e("DataTransferUtils", "Error enabling/disabling component", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final boolean a(Context r3, String r4) {
        PackageManager r2 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getPackageManager();     // Catch: Exception -> L9
        Intrinsics.checkNotNullExpressionValue(r2, "getPackageManager(...)");     // Catch: Exception -> L9
        int r5 = r2.getApplicationEnabledSetting(r4);     // Catch: Exception -> L9
        if (r5 == 1) goto L8;
        if (r5 == 0) goto L8;
        return false;
    L8:
        return true;
    L9:
        e = move-exception;
        Log.e("DataTransferUtils", "Error checking component enabled state", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    /* JADX INFO: renamed from: lambda$rLtUu7Qp7u-EaBN5KhUww5cyCVU, reason: not valid java name */
    public static /* synthetic */ Unit m1106lambda$rLtUu7Qp7uEaBN5KhUww5cyCVU(ContentResolver r0, Bundle r1, Context r2) {
        return a(r0, r1, r2);
    }

    public final void a(Context r23) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (a(r4, BuildConfig.LIBRARY_PACKAGE_NAME) == true) goto L7;
        String r0 = "not need to migrate, resume init";
    L5:
        Log.i("DataTransferUtils", r0);
        return;
    L7:
        final ContentResolver r12 = r4.getContentResolver();
        final Bundle r13 = new Bundle();
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(f12424b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r14.hasNext() == false) goto L45;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        Log.i("DataTransferUtils", "migrating passPhrase for " + r11);     // Catch: Exception -> L28
        String r15 = r11;
        Bundle r1 = ZeusProviderTransform.call(r12, "com.obric.memorydata.transfer", "method_get_pass_phrase", r11, r13, "com.obric.memorydata.plugin");     // Catch: Exception -> L26
        String r6 = null;
        if (r1 == null) goto L23;
        String r2 = r1.getString("passPhrase");     // Catch: Exception -> L26
        if (r2 == null) goto L23;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == false) goto L23;
        r6 = r2;
        goto L23
    L20:
        r7 = false;
    L23:
        if (r6 == null) goto L9;
        DatabaseKeyMigration.INSTANCE.writeDatabasePhrase(r15, r6);     // Catch: Exception -> L26
    L26:
        e = e;
    L30:
        Log.e("DataTransferUtils", "migrating passPhrase for " + r15 + " failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L28:
        e = e;
        r15 = r11;
        goto L30
    L45:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L39
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataTransferUtils", "fetch-old-ailab start", false, 4, null);     // Catch: Throwable -> L39
        Bundle r8 = ZeusProviderTransform.call(r12, "com.obric.memorydata.transfer", "method_fetch_setting_ailab_status", null, r13, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        List r9 = CollectionsKt.listOf(new String[]{"screen_memory", "voice_memory", "ai_lab_status"});     // Catch: Throwable -> L39
        SharedPreferences.Editor r10 = r4.getSharedPreferences("AILabStatusPrefs", 0).edit();     // Catch: Throwable -> L39
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L39
    L33:
        if (r16.hasNext() == false) goto L37;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        if (r8 == null) goto L33;
        int r18 = r8.getInt(r17);     // Catch: Throwable -> L39
        r10.putInt(r17, r18);     // Catch: Throwable -> L39
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataTransferUtils", "fetch-old-ailab key:" + r17 + ", value:" + r18, false, 4, null);     // Catch: Throwable -> L39
        goto L33
    L37:
        r10.apply();     // Catch: Throwable -> L39
        Object r19 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Throwable r20 = Result.m1424exceptionOrNullimpl(r19);
        if (r20 == null) goto L44;
        RunLog.INSTANCE.error("DataTransferUtils", "fetch setting data error", r20);
    L44:
        ThreadsKt.thread$default(false, false, null, "disable-old-app", 0, new $$Lambda$a$rLtUu7Qp7uEaBN5KhUww5cyCVU(r12, r13, r4), 23, null);
        r0 = "resume init";
    L39:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L41
    }
}
