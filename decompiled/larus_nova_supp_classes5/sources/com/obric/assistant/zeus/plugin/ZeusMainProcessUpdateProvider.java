package com.obric.assistant.zeus.plugin;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\tH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0002JO\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010 \u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J1\u0010#\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010%J;\u0010&\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/assistant/zeus/plugin/ZeusMainProcessUpdateProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "mainHandler", "Landroid/os/Handler;", "pendingFetchReason", "", "fetchScheduled", "", "triggerFetchRunnable", "Ljava/lang/Runnable;", "onCreate", "call", "Landroid/os/Bundle;", "method", "arg", "extras", "schedulePluginFetch", "", "reason", DownloadConstants.QUERY_KEY, "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZeusMainProcessUpdateProvider extends ContentProvider {
    public final Handler a;
    public String b;
    public boolean c;
    public final l d;

    public static final class a {
    }

    static {
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
        return true;
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

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.zeus.plugin.l] */
    public ZeusMainProcessUpdateProvider() {
        this.a = new Handler(Looper.getMainLooper());
        this.b = "";
        this.d = new l(this);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r4, String r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "method");
        if (Intrinsics.areEqual(r4, "request_fetch_plugin") == false) goto L20;
        if (r6 == null) goto L6;
        String r7 = r6.getString("reason");
    L7:
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r8 = ISecPrivacyService.a.a();
        if (r8 != null) goto L12;
    L14:
        boolean r9 = false;
    L16:
        if (r9 == true) goto L18;
        FLogger.a.i("ZeusMainProcessUpdateProvider", "request fetch plugin skipped: privacy not agreed, reason=".concat(r7));
        Bundle r10 = new Bundle();
        r10.putBoolean("result", false);
        return r10;
    L18:
        FLogger.a.i("ZeusMainProcessUpdateProvider", "request fetch plugin from sub process, reason=".concat(r7));
        this.a.post(new k(this, r7));
        Bundle r11 = new Bundle();
        r11.putBoolean("result", true);
        return r11;
    L12:
        if (r8.h() != true) goto L14;
        r9 = true;
        goto L16
    L6:
        r7 = null;
        goto L7
    L20:
        return super.call(r4, r5, r6);
    }
}
