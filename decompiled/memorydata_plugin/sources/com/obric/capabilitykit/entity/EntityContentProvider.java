package com.obric.capabilitykit.entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.version.EntityUpdateVersionParams;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002J1\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016JO\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\r2\u0010\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u001cJ;\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u001e¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/entity/EntityContentProvider;", "Landroid/content/ContentProvider;", "()V", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "", "arg", "extras", "callingPackageSafely", "delete", "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", ChatMessage.TYPE_QUERY, "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", BuildConfig.CHANNEL, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityContentProvider extends PluginContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7535a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7536b = "EntityContentProvider";
    public static final String c = "data_check";
    public static final String d = "reindex_all_data";
    public static final String e = "update_entity_version";
    public static final String f = "sync_data_indexed_types";
    public static final long g = 2500;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityContentProvider$Companion;", "", "()V", "DATA_CHECK", "", "ON_ENTITY_VERSION_UPDATE", "REINDEX_ALL_DATA", "SYNC_DATA_INDEXED_TYPES", "TAG", "WAIT_ENTITY_PROVIDER_INIT_TIME_MS", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f7535a = new a(null);
    }

    public EntityContentProvider() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String a() {
        return getCallingPackage();
    L4:
        e = move-exception;
        Logger r1 = Logger.INSTANCE;
        StringBuilder r2 = new StringBuilder();
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L8;
        String r6 = r5.getPackageName();
    L9:
        r1.w(f7536b, r2.append(r6).append(" run method, callingPackage failed").toString(), e);
        return null;
    L8:
        r6 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Bundle call(String r17, String r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r17, "method");
        Bundle r2 = new Bundle();
        String r3 = a();
        Logger r4 = Logger.INSTANCE;
        StringBuilder r5 = new StringBuilder();
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        String r8 = null;
        if (r6 == null) goto L5;
        String r7 = r6.getPackageName();
    L6:
        r4.d(f7536b, r5.append(r7).append(" run method: ").append(r17).append(" from pkg: ").append(r3).append(", call:").toString());
        if (PackageUtils.INSTANCE.checkSignature(r3) == true) goto L10;
        r4.i(f7536b, "signatures not match");
        r2.putBoolean(EntityUpdateVersionParams.RESULT_KEY, false);
        return r2;
    L10:
        long r11 = Binder.clearCallingIdentity();
        EntityProvider r9 = EntityProvider.INSTANCE;     // Catch: Throwable -> L56
        r9.waitEntityProviderInit(2500);     // Catch: Throwable -> L56
        if (r9.isInitialized() == false) goto L50;
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L56
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        if (r14 == null) goto L16;
        String r15 = r14.getPackageName();     // Catch: Throwable -> L56
    L17:
        r4.d(f7536b, r13.append(r15).append(" run method: ").append(r17).append(", start:").toString());     // Catch: Throwable -> L56
        int r16 = r17.hashCode();     // Catch: Throwable -> L56
        if (r16 == (-1184655032)) goto L42;
        if (r16 == 1555726002) goto L36;
        if (r16 == 1604538419) goto L25;
    L58:
        Binder.restoreCallingIdentity(r11);
        Logger r0 = Logger.INSTANCE;
        StringBuilder r10 = new StringBuilder();
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L61;
        r8 = r12.getPackageName();
    L61:
        r0.d(f7536b, r10.append(r8).append(" run method: ").append(r17).append(" pkg: ").append(a()).append(" END.").toString());
        return r2;
    L25:
        if (r17.equals("data_check") == false) goto L58;
        if (r19 == null) goto L33;
        ArrayList<Integer> r1 = r19.getIntegerArrayList("sync_data_indexed_types");     // Catch: Throwable -> L56
        if (r1 == null) goto L33;
        List<Integer> r20 = CollectionsKt.toList(r1);     // Catch: Throwable -> L56
        if (r20 == null) goto L33;
    L34:
        r9.syncData(r20);     // Catch: Throwable -> L56
    L33:
        r20 = CollectionsKt.emptyList();     // Catch: Throwable -> L56
        goto L34
    L36:
        if (r17.equals(e) == false) goto L58;
        if (r9.reDonateCheck$capabilitykit_release(r18) == false) goto L58;
        r2.putBoolean(EntityUpdateVersionParams.RESULT_KEY, true);     // Catch: Throwable -> L56
        goto L58
    L42:
        if (r17.equals(d) == false) goto L58;
        PackageUtils r21 = PackageUtils.INSTANCE;     // Catch: Throwable -> L56
        if (r3 != null) goto L48;
        r3 = "";
    L48:
        if (r21.isMemoryPackageName(r3) == false) goto L58;
        r4.i(f7536b, "run reindex_all_data method start");     // Catch: Throwable -> L56
        r9.reindexEntityData$capabilitykit_release();     // Catch: Throwable -> L56
        r4.i(f7536b, "run reindex_all_data method end");     // Catch: Throwable -> L56
        goto L58
    L16:
        r15 = null;
        goto L17
    L50:
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L56
        Context r23 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        if (r23 == null) goto L53;
        String r24 = r23.getPackageName();     // Catch: Throwable -> L56
    L54:
        r4.w(f7536b, r22.append(r24).append(" run method: ").append(r17).append(", not initialized").toString());     // Catch: Throwable -> L56
        goto L58
    L53:
        r24 = null;
    L56:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L63
        Logger.INSTANCE.e(f7536b, "error: " + th.getMessage());     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        Binder.restoreCallingIdentity(r11);
        throw th;
    L5:
        r7 = null;
        goto L6
    }

    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onCreate() {
        EntityProvider r0 = EntityProvider.INSTANCE;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L5;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L6:
        Intrinsics.checkNotNull(r4);
        r0.setSContext(r4);
        EntityContextHolder.INSTANCE.init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getSContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        return true;
    L5:
        r4 = null;
        goto L6
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }
}
