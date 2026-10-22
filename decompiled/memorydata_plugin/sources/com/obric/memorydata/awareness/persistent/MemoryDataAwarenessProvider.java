package com.obric.memorydata.awareness.persistent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016JO\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J1\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u001cJ;\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u001e¨\u0006 "}, d2 = {"Lcom/obric/memorydata/awareness/persistent/MemoryDataAwarenessProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "onCreate", "", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "", "arg", "extras", ChatMessage.TYPE_QUERY, "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", BuildConfig.CHANNEL, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryDataAwarenessProvider extends PluginContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8760a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/persistent/MemoryDataAwarenessProvider$Companion;", "", "<init>", "()V", "TAG", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8760a = new a(null);
    }

    public MemoryDataAwarenessProvider() {
    }

    public Bundle call(String r9, String r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "method");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDataAwarenessProvider", "call method=" + r9, false, 4, null);
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L18;
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L18;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        MemoryDataAwarenessProvider r8 = (MemoryDataAwarenessProvider) ZeusTransformUtils.preCheckCast(this, MemoryDataAwarenessProvider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Object r14 = Result.m1421constructorimpl(d.f8768a.a(r13, r9, r11));     // Catch: Throwable -> L9
    L11:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r14);
        if (r15 == null) goto L16;
        RunLog.INSTANCE.warn("MemoryDataAwarenessProvider", "call failed method=" + r9, r15);
        r14 = com.obric.memorydata.sdk.awareness.g.f12826a.a(400, r15.getMessage());
    L16:
        return (Bundle) ZeusTransformUtils.preCheckCast(r14, Bundle.class, "com.obric.memorydata.plugin");
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L18:
        return com.obric.memorydata.sdk.awareness.g.f12826a.a(404, "context is null");
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

    public boolean onCreate() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDataAwarenessProvider", "onCreate", false, 4, null);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L7;
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L7;
        g.f8772a.b(r10);
        return true;
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDataAwarenessProvider", "onCreate context is null", null, 4, null);
        return true;
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
