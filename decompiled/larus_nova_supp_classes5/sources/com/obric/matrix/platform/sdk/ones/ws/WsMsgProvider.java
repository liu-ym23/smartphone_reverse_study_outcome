package com.obric.matrix.platform.sdk.ones.ws;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import gka.b;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ?\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJQ\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J3\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J=\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgProvider;", "Landroid/content/ContentProvider;", "Landroid/net/Uri;", "uri", "", "", "projection", "Landroid/os/Bundle;", "queryArgs", "Landroid/os/CancellationSignal;", "cancellationSignal", "Landroid/database/Cursor;", DownloadConstants.QUERY_KEY, "(Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "Landroid/content/ContentValues;", "values", "insert", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "<init>", "()V", "a", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final class WsMsgProvider extends ContentProvider {
    public final UriMatcher a;

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
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        bka.a r0 = bka.a.a;
        UriMatcher r1 = this.a;
        StringBuilder r2 = new StringBuilder("com.obric.matrix.platform.sdk.ones.provider.");
        Context r3 = getContext();
        if (r3 == null) goto L5;
        String r4 = r3.getPackageName();
    L6:
        r2.append(r4);
        r1.addURI(r2.toString(), "ws_msg", 1);
        return true;
    L5:
        r4 = null;
        goto L6
    }

    public WsMsgProvider() {
        this.a = new UriMatcher(-1);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, Bundle r12, CancellationSignal r13) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        Objects.toString(r12);
        Objects.toString(r10);
        Objects.toString(r13);
        getCallingPackage();
        bka.a r14 = bka.a.a;
        String r15 = getCallingPackage();
        if (r15 != null) goto L5;
    L8:
        boolean r16 = true;
    L9:
        byte[] r1 = null;
        if (r16 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(getCallingPackage(), "com.obric.matrix") == true) goto L15;
        return null;
    L15:
        if (this.a.match(r10) != 1) goto L56;
        if (r12 == null) goto L18;
        Integer r17 = Integer.valueOf(r12.getInt("channel_id", 0));
    L20:
        if (r12 == null) goto L22;
        Long r18 = Long.valueOf(r12.getLong("seq_id", 0));
    L23:
        if (r12 == null) goto L25;
        Long r19 = Long.valueOf(r12.getLong("log_id", 0));
    L26:
        if (r12 == null) goto L28;
        Integer r2 = Integer.valueOf(r12.getInt("service", 0));
    L29:
        if (r12 == null) goto L31;
        Integer r0 = Integer.valueOf(r12.getInt("method", 0));
    L33:
        if (r12 == null) goto L35;
        Serializable r4 = r12.getSerializable("ws_headers");
    L36:
        if (r4 == null) goto L44;
        if (r12 == null) goto L39;
        Serializable r3 = r12.getSerializable("ws_headers");
    L40:
        if (r3 == null) goto L43;
        HashMap r5 = (HashMap) r3;
    L45:
        if (r12 == null) goto L47;
        String r6 = r12.getString("payload_type");
    L48:
        if (r12 == null) goto L50;
        String r7 = r12.getString("payload_encoding");
    L51:
        if (r12 == null) goto L53;
        r1 = r12.getByteArray("payload");
    L53:
        List r110 = MatrixWsHelper.a;
        Intrinsics.checkNotNull(r17);
        int r111 = r17.intValue();
        Intrinsics.checkNotNull(r18);
        long r112 = r18.longValue();
        Intrinsics.checkNotNull(r19);
        long r8 = r19.longValue();
        Intrinsics.checkNotNull(r2);
        int r113 = r2.intValue();
        Intrinsics.checkNotNull(r0);
        b.a("MatrixWsHelper", "onWsMsgReceivedByProvider() called with: channelId = " + r111 + ", seqId = " + r112 + ", logId = " + r8 + ", service = " + r113 + ", method = " + r0.intValue() + ", encoding = " + r7 + ", type = " + r6 + ", payload = " + r1 + ", headers = " + r5 + ", wsBridge is null");
        MatrixCursor r9 = new MatrixCursor(new String[]{"received"});
        r9.addRow(new String[]{"true"});
        return r9;
    L50:
        r7 = null;
        goto L51
    L47:
        r6 = null;
        goto L48
    L43:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    L39:
        r3 = null;
        goto L40
    L44:
        r5 = null;
        goto L45
    L35:
        r4 = null;
        goto L36
    L31:
        r0 = null;
        goto L33
    L28:
        r2 = null;
        goto L29
    L25:
        r19 = null;
        goto L26
    L22:
        r18 = null;
        goto L23
    L18:
        r17 = null;
        goto L20
    L56:
        return null;
    L5:
        if (r15.length() == 0) goto L8;
        r16 = false;
        goto L9
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        Objects.toString(r1);
        bka.a r6 = bka.a.a;
        return null;
    }
}
