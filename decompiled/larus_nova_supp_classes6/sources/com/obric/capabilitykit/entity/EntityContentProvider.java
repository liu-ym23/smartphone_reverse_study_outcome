package com.obric.capabilitykit.entity;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.version.EntityUpdateVersionParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJQ\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J3\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J=\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0002¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityContentProvider;", "Landroid/content/ContentProvider;", "Landroid/net/Uri;", "uri", "", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "Landroid/content/ContentValues;", "values", "insert", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "method", "arg", "Landroid/os/Bundle;", "extras", "call", "callingPackageSafely", "<init>", "()V", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1})
public final class EntityContentProvider extends ContentProvider {
    public EntityContentProvider() {
    }

    public final String a() {
        return getCallingPackage();
    L4:
        e = move-exception;
        Logger r1 = Logger.INSTANCE;
        StringBuilder r2 = new StringBuilder();
        Context r3 = getContext();
        if (r3 == null) goto L8;
        String r4 = r3.getPackageName();
    L9:
        r2.append(r4);
        r2.append(" run method, callingPackage failed");
        r1.w("EntityContentProvider", r2.toString(), e);
        return null;
    L8:
        r4 = null;
        goto L9
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r17, String r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r17, "method");
        Bundle r3 = new Bundle();
        String r4 = a();
        Logger r5 = Logger.INSTANCE;
        StringBuilder r6 = new StringBuilder();
        Context r7 = getContext();
        String r8 = null;
        if (r7 == null) goto L5;
        String r9 = r7.getPackageName();
    L6:
        r6.append(r9);
        r6.append(" run method: ");
        r6.append(r17);
        r6.append(" from pkg: ");
        r6.append(r4);
        r6.append(", call:");
        r5.d("EntityContentProvider", r6.toString());
        PackageUtils r10 = PackageUtils.INSTANCE;
        if (r10.checkSignature(r4) == true) goto L10;
        r5.i("EntityContentProvider", "signatures not match");
        r3.putBoolean(EntityUpdateVersionParams.RESULT_KEY, false);
        return r3;
    L10:
        long r12 = Binder.clearCallingIdentity();
        EntityProvider r11 = EntityProvider.INSTANCE;     // Catch: Throwable -> L55
        r11.waitEntityProviderInit(2500);     // Catch: Throwable -> L55
        if (r11.isInitialized() == false) goto L49;
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L55
        Context r15 = getContext();     // Catch: Throwable -> L55
        if (r15 == null) goto L16;
        String r16 = r15.getPackageName();     // Catch: Throwable -> L55
    L17:
        r14.append(r16);     // Catch: Throwable -> L55
        r14.append(" run method: ");     // Catch: Throwable -> L55
        r14.append(r17);     // Catch: Throwable -> L55
        r14.append(", start:");     // Catch: Throwable -> L55
        r5.d("EntityContentProvider", r14.toString());     // Catch: Throwable -> L55
        int r110 = r17.hashCode();     // Catch: Throwable -> L55
        if (r110 == (-1184655032)) goto L42;
        if (r110 == 1555726002) goto L36;
        if (r110 == 1604538419) goto L25;
    L57:
        Binder.restoreCallingIdentity(r12);
        Logger r0 = Logger.INSTANCE;
        StringBuilder r2 = new StringBuilder();
        Context r13 = getContext();
        if (r13 == null) goto L60;
        r8 = r13.getPackageName();
    L60:
        r2.append(r8);
        r2.append(" run method: ");
        r2.append(r17);
        r2.append(" pkg: ");
        r2.append(a());
        r2.append(" END.");
        r0.d("EntityContentProvider", r2.toString());
        return r3;
    L25:
        if (r17.equals("data_check") == false) goto L57;
        if (r19 == null) goto L33;
        ArrayList<Integer> r1 = r19.getIntegerArrayList("sync_data_indexed_types");     // Catch: Throwable -> L55
        if (r1 == null) goto L33;
        List r20 = CollectionsKt.toList(r1);     // Catch: Throwable -> L55
        if (r20 == null) goto L33;
    L34:
        r11.syncData(r20);     // Catch: Throwable -> L55
    L33:
        r20 = CollectionsKt.emptyList();     // Catch: Throwable -> L55
        goto L34
    L36:
        if (r17.equals("update_entity_version") == false) goto L57;
        if (r11.reDonateCheck$capabilitykit_release(r18) == false) goto L57;
        r3.putBoolean(EntityUpdateVersionParams.RESULT_KEY, true);     // Catch: Throwable -> L55
        goto L57
    L42:
        if (r17.equals("reindex_all_data") == false) goto L57;
        if (r4 != null) goto L47;
        r4 = "";
    L47:
        if (r10.isMemoryPackageName(r4) == false) goto L57;
        r5.i("EntityContentProvider", "run reindex_all_data method start");     // Catch: Throwable -> L55
        r11.reindexEntityData$capabilitykit_release();     // Catch: Throwable -> L55
        r5.i("EntityContentProvider", "run reindex_all_data method end");     // Catch: Throwable -> L55
        goto L57
    L16:
        r16 = null;
        goto L17
    L49:
        StringBuilder r21 = new StringBuilder();     // Catch: Throwable -> L55
        Context r22 = getContext();     // Catch: Throwable -> L55
        if (r22 == null) goto L52;
        String r23 = r22.getPackageName();     // Catch: Throwable -> L55
    L53:
        r21.append(r23);     // Catch: Throwable -> L55
        r21.append(" run method: ");     // Catch: Throwable -> L55
        r21.append(r17);     // Catch: Throwable -> L55
        r21.append(", not initialized");     // Catch: Throwable -> L55
        r5.w("EntityContentProvider", r21.toString());     // Catch: Throwable -> L55
        goto L57
    L52:
        r23 = null;
    L55:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L62
        Logger.INSTANCE.e("EntityContentProvider", "error: " + th.getMessage());     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        Binder.restoreCallingIdentity(r12);
        throw th;
    L5:
        r9 = null;
        goto L6
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        EntityProvider r0 = EntityProvider.INSTANCE;
        Context r1 = getContext();
        if (r1 == null) goto L5;
        Context r2 = r1.getApplicationContext();
    L6:
        Intrinsics.checkNotNull(r2);
        r0.setSContext(r2);
        EntityContextHolder.INSTANCE.init(r0.getSContext());
        return true;
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }
}
