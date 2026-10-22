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
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.event.EnsureReportData;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class WsMsgProvider extends ContentProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private UriMatcher f5919c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public WsMsgProvider() {
        this.f5919c = new UriMatcher(-1);
    }

    private final void a(String r10) {
        if (z8.c.f13804a.d() == null) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L9;
        e9.b.b("WsMsgProvider", r10, null, 4, null);
        return;
    L9:
        Log.d("WsMsgProvider", r10);
        return;
    L5:
        r11 = false;
        goto L7
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        a("onCreate() called");
        UriMatcher r10 = this.f5919c;
        StringBuilder r11 = new StringBuilder();
        r11.append("com.obric.matrix.platform.sdk.ones.provider.");
        Context r12 = getContext();
        if (r12 == null) goto L5;
        String r13 = r12.getPackageName();
    L6:
        r11.append(r13);
        r10.addURI(r11.toString(), "ws_msg", 1);
        return true;
    L5:
        r13 = null;
        goto L6
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r21, String[] r22, Bundle r23, CancellationSignal r24) {
        Intrinsics.checkNotNullParameter(r21, "uri");
        a("query() called with:  queryArgs = " + r23 + ", uri = " + r21 + ", projection = " + r22 + ", cancellationSignal = " + r24 + ", callingPackage = " + getCallingPackage());
        String r10 = getCallingPackage();
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        byte[] r12 = null;
        if (r11 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(getCallingPackage(), "com.obric.matrix") == true) goto L15;
        return null;
    L15:
        if (this.f5919c.match(r21) != 1) goto L53;
        if (r23 == null) goto L18;
        Integer r13 = Integer.valueOf(r23.getInt(WsConstants.KEY_CHANNEL_ID, 0));
    L20:
        if (r23 == null) goto L22;
        Long r14 = Long.valueOf(r23.getLong("seq_id", 0));
    L23:
        if (r23 == null) goto L25;
        Long r15 = Long.valueOf(r23.getLong("log_id", 0));
    L26:
        if (r23 == null) goto L28;
        Integer r16 = Integer.valueOf(r23.getInt("service", 0));
    L29:
        if (r23 == null) goto L31;
        Integer r17 = Integer.valueOf(r23.getInt(EnsureReportData.METHOD, 0));
    L33:
        if (r23 == null) goto L35;
        Serializable r18 = r23.getSerializable("ws_headers");
    L36:
        if (r18 == null) goto L41;
        if (r23 == null) goto L39;
        Serializable r19 = r23.getSerializable("ws_headers");
    L40:
        Objects.requireNonNull(r19, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
        HashMap<String, String> r110 = (HashMap) r19;
    L42:
        if (r23 == null) goto L44;
        String r111 = r23.getString("payload_type");
    L45:
        if (r23 == null) goto L47;
        String r112 = r23.getString("payload_encoding");
    L48:
        if (r23 == null) goto L50;
        r12 = r23.getByteArray(WsConstants.KEY_PAYLOAD);
    L50:
        MatrixWsHelper r20 = MatrixWsHelper.f5914a;
        Intrinsics.checkNotNull(r13);
        int r25 = r13.intValue();
        Intrinsics.checkNotNull(r14);
        long r113 = r14.longValue();
        Intrinsics.checkNotNull(r15);
        long r114 = r15.longValue();
        Intrinsics.checkNotNull(r16);
        int r115 = r16.intValue();
        Intrinsics.checkNotNull(r17);
        r20.f(r25, r113, r114, r115, r17.intValue(), r112, r111, r12, r110);
        MatrixCursor r26 = new MatrixCursor(new String[]{"received"});
        r26.addRow(new String[]{"true"});
        return r26;
    L47:
        r112 = null;
        goto L48
    L44:
        r111 = null;
        goto L45
    L39:
        r19 = null;
        goto L40
    L41:
        r110 = null;
        goto L42
    L35:
        r18 = null;
        goto L36
    L31:
        r17 = null;
        goto L33
    L28:
        r16 = null;
        goto L29
    L25:
        r15 = null;
        goto L26
    L22:
        r14 = null;
        goto L23
    L18:
        r13 = null;
        goto L20
    L53:
        return null;
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L9
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        a("query() called with: uri = " + r10 + ", projection = " + r11 + ", selection = " + r12 + ", selectionArgs = " + r13 + ", sortOrder = " + r14);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return 0;
    }
}
