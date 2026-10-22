package com.obric.memorydata.sdk.awareness;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0014J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002JO\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0010\u0010 \u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\t2\u0010\u0010#\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001c\u0010'\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J1\u0010*\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\t2\u0010\u0010#\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010!H\u0016¢\u0006\u0002\u0010,J;\u0010-\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010\t2\u0010\u0010#\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010!H\u0016¢\u0006\u0002\u0010.¨\u00060"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/BaseAwarenessCallbackProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "onCreate", "", "call", "Landroid/os/Bundle;", "method", "", "arg", "extras", "validateAwarenessProviderCaller", "onFeatureEvent", "", "subscriptionId", "featureName", "oldValue", "", "newValue", "onContextEvent", "eventName", "dispatchCallback", "callback", "Lcom/obric/memorydata/sdk/awareness/PersistentAwarenessCallback;", "hasSameSignature", "packageName", "trustedPackage", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public abstract class BaseAwarenessCallbackProvider extends ContentProvider {

    public static final class a {
    }

    static {
    }

    public abstract void c();

    public abstract void d();

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
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        tka.c.c("AwarenessCallbackProvider", "callback provider onCreate");
        return true;
    }

    public BaseAwarenessCallbackProvider() {
    }

    public final Bundle a(PersistentAwarenessCallback r6) {
        r6.c.setClassLoader(getClass().getClassLoader());
        String r0 = r6.b.a;
        if (Intrinsics.areEqual(r0, "feature") == false) goto L9;
        Bundle r1 = r6.c.getBundle("extras");
        if (r1 == null) goto L7;
        r1.setClassLoader(r1.getClass().getClassLoader());
        r1.keySet();
    L7:
        String r2 = r6.b.b;
        r6.c.get("old_value");
        r6.c.get("new_value");
        d();
        return l.a(0, "success");
    L9:
        if (Intrinsics.areEqual(r0, EventVerify.TYPE_EVENT_V1) == false) goto L14;
        Bundle r3 = r6.c.getBundle("extras");
        if (r3 == null) goto L13;
        r3.setClassLoader(r3.getClass().getClassLoader());
        r3.keySet();
    L13:
        String r7 = r6.b.b;
        c();
        return l.a(0, "success");
    L14:
        tka.b r4 = tka.c.a;
        tka.c.d("AwarenessCallbackProvider", "unknown callback targetType=" + r6.b.a);
        int r5 = l.a;
        return l.a(405, "unknown targetType=" + r6.b.a);
    }

    public final boolean b(String r4, String r5) {
        Context r0 = getContext();
        boolean r1 = false;
        if (r0 != null) goto L17;
        return false;
    L17:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        if (r0.getPackageManager().checkSignatures(r4, r5) != 0) goto L8;
        r1 = true;
    L8:
        Object r6 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L10
    L12:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L16;
        r6 = r7;
    L16:
        return ((Boolean) r6).booleanValue();
    L10:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r18, String r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "method");
        tka.b r3 = tka.c.a;
        tka.c.c("AwarenessCallbackProvider", "callback provider call method=" + r18);
        if (Intrinsics.areEqual(r18, "persistent_awareness_callback") == true) goto L6;
        tka.c.d("AwarenessCallbackProvider", "callback provider unknown method=" + r18);
        int r2 = l.a;
        return l.a(405, "unknown method=" + r18);
    L6:
        Context r0 = getContext();
        boolean r4 = false;
        if (r0 == null) goto L29;
        int r6 = Binder.getCallingUid();
        String[] r7 = r0.getPackageManager().getPackagesForUid(r6);
        if (r7 != null) goto L12;
        r7 = new String[0];
    L12:
        String[] r8 = r7;
        int r9 = r8.length;
        int r10 = 0;
    L13:
        if (r10 >= r9) goto L28;
        String r11 = r8[r10];
        if (Intrinsics.areEqual(r11, r0.getPackageName()) == false) goto L17;
    L24:
        boolean r12 = true;
    L25:
        if (r12 == true) goto L26;
        r10 = r10 + 1;
        goto L13
    L26:
        r4 = true;
        goto L28
    L17:
        if (Intrinsics.areEqual(r11, PackageUtils.NOVA_PKG_NAME) == true) goto L24;
        Intrinsics.checkNotNull(r11);
        if (b(r11, PackageUtils.NOVA_PKG_NAME) == true) goto L24;
        if (b(r11, r0.getPackageName()) == true) goto L24;
        r12 = false;
    L28:
        tka.b r1 = tka.c.a;
        tka.c.c("AwarenessCallbackProvider", "validate callback caller uid=" + r6 + " allowed=" + r4 + " packages=" + ArraysKt.joinToString$default(r8, null, null, null, 0, null, null, 63, null));
    L29:
        if (r4 == true) goto L32;
        tka.c.d("AwarenessCallbackProvider", "callback provider caller is not allowed");
        return l.a(EntityType.ICALENDAR_PROTOCOL, "caller is not allowed");
    L32:
        int r5 = l.a;
        PersistentAwarenessCallback r13 = null;
        Parcelable r14 = null;
        r14 = null;
        if (r20 == null) goto L43;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        Intrinsics.checkNotNullParameter("callback", "key");
        Intrinsics.checkNotNullParameter(PersistentAwarenessCallback.class, "clazz");
        r20.setClassLoader(PersistentAwarenessCallback.class.getClassLoader());
        if (Build.VERSION.SDK_INT < 33) goto L39;
        Parcelable r15 = (Parcelable) r20.getParcelable("callback", PersistentAwarenessCallback.class);     // Catch: RuntimeException -> L56
    L38:
        r14 = r15;
        goto L42
    L39:
        r15 = r20.getParcelable("callback");     // Catch: RuntimeException -> L56
        if ((r15 instanceof Parcelable) == true) goto L38;
    L42:
        r13 = (PersistentAwarenessCallback) r14;
    L43:
        if (r13 != null) goto L57;
        tka.c.d("AwarenessCallbackProvider", "callback provider callback is missing");
        return l.a(405, "callback is missing");
    L57:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L48
        tka.b r17 = tka.c.a;     // Catch: Throwable -> L48
        tka.c.c("AwarenessCallbackProvider", "dispatch callback subscriptionId=" + r13.a + " target=" + r13.b.a + '/' + r13.b.b);     // Catch: Throwable -> L48
        Object r21 = Result.constructor-impl(a(r13));     // Catch: Throwable -> L48
    L50:
        Throwable r22 = Result.exceptionOrNull-impl(r21);
        if (r22 == null) goto L55;
        tka.c.b("AwarenessCallbackProvider", "callback provider dispatch failed", r22);
        int r23 = l.a;
        r21 = l.a(400, r22.getMessage());
    L55:
        return (Bundle) r21;
    L48:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    }
}
