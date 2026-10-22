package com.obric.matrix.sdk.push.cross_process;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.obric.matrix.sdk.push.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kka.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J3\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016JQ\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\n\u001a\u00020\t2\u0010\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J=\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/obric/matrix/sdk/push/cross_process/MessageProvider;", "Landroid/content/ContentProvider;", "Lcom/obric/matrix/sdk/push/a;", "", "method", "arg", "Landroid/os/Bundle;", "extras", "call", "Landroid/net/Uri;", "uri", "selection", "", "selectionArgs", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "Landroid/content/ContentValues;", "values", "insert", "projection", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "<init>", "()V", "sdk_push_release"}, k = 1, mv = {1, 6, 0})
public abstract class MessageProvider extends ContentProvider implements a {
    public final String a;
    public final AtomicBoolean b;
    public final CountDownLatch c;

    public final void c() {
        AtomicBoolean r0 = this.b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.b.get() == true) goto L7;
        d();     // Catch: Throwable -> L10
        this.b.set(true);     // Catch: Throwable -> L10
    L7:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    public final void d() {
        long r2 = System.currentTimeMillis();
        this.c.await();     // Catch: Throwable -> L9 InterruptedException -> L11
        if (getContext() == null) goto L8;
        b.a(this.a, "wait for app init cost " + (System.currentTimeMillis() - r2) + " ms");
        return;
    L8:
        throw new IllegalArgumentException("context is null!".toString());     // Catch: Throwable -> L9 InterruptedException -> L11
    L11:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        b.a(this.a, "wait for app init cost " + (System.currentTimeMillis() - r2) + " ms");
        throw th;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        b.a(this.a, "onCreate");
        return true;
    }

    public MessageProvider() {
        this.a = "MessageProvider";
        this.b = new AtomicBoolean();
        this.c = new CountDownLatch(1);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        c();
        return null;
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r5, ProviderInfo r6) {
        String r0 = this.a;
        int r1 = b.a;
        Intrinsics.checkNotNullParameter(r0, "tag");
        Intrinsics.checkNotNullParameter("attachInfo", "msg");
        String r2 = b.c(r0, "attachInfo");
        Intrinsics.checkNotNullParameter("MATRIX_PUSH", "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        super.attachInfo(r5, r6);
        this.c.countDown();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        c();
        return null;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r4, String r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "method");
        b.a(this.a, "message provider call: " + r4 + ", " + r5 + ", " + r6);
        c();
        if (Intrinsics.areEqual(getCallingPackage(), "com.obric.matrix") == false) goto L20;
    L17:
        th = move-exception;
        b.b("message provider error: " + th);
        goto L20
    L5:
        if (Intrinsics.areEqual(r4, ".action.MESSAGE_EVENT") == false) goto L20;
        if (r6 == null) goto L20;
        Object r0 = r6.get("msg_id");     // Catch: Throwable -> L17
        if (r0 == null) goto L16;
        String r1 = (String) r0;     // Catch: Throwable -> L17
        Object r2 = r6.get("pass_though_data");     // Catch: Throwable -> L17
        if (r2 == null) goto L14;
        Intrinsics.checkNotNullParameter(r1, "msgId");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter((String) r2, "data");     // Catch: Throwable -> L17
        b();     // Catch: Throwable -> L17
        goto L20
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L17
    L20:
        return super.call(r4, r5, r6);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        c();
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        c();
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        c();
        return null;
    }
}
