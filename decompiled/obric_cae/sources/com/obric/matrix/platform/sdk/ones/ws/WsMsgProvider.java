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
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import defpackage.b;
import he.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import qb.a;

/* JADX INFO: loaded from: classes2.dex */
public final class WsMsgProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UriMatcher f6152a;

    public WsMsgProvider() {
        this.f6152a = new UriMatcher(-1);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r8, String r10, String[] r11) {
        i.f(r8, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r8) {
        i.f(r8, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r8, ContentValues r10) {
        i.f(r8, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Log.d("WsMsgProvider", "onCreate() called");
        UriMatcher r8 = this.f6152a;
        StringBuilder r10 = new StringBuilder("com.obric.matrix.platform.sdk.ones.provider.");
        Context r11 = getContext();
        if (r11 == null) goto L5;
        String r12 = r11.getPackageName();
    L6:
        r10.append(r12);
        r8.addURI(r10.toString(), "ws_msg", 1);
        return true;
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r10, String[] r11, Bundle r12, CancellationSignal r13) {
        i.f(r10, "uri");
        Log.d("WsMsgProvider", "query() called with:  queryArgs = " + r12 + ", uri = " + r10 + ", projection = " + r11 + ", cancellationSignal = " + r13 + ", callingPackage = " + getCallingPackage());
        String r14 = getCallingPackage();
        if (r14 != null) goto L5;
    L8:
        boolean r15 = true;
    L9:
        byte[] r8 = null;
        if (r15 == false) goto L12;
        return null;
    L12:
        if (i.a(getCallingPackage(), "com.obric.matrix") == true) goto L15;
        return null;
    L15:
        if (this.f6152a.match(r10) != 1) goto L56;
        if (r12 == null) goto L18;
        Integer r16 = Integer.valueOf(r12.getInt(WsConstants.KEY_CHANNEL_ID, 0));
    L20:
        if (r12 == null) goto L22;
        Long r17 = Long.valueOf(r12.getLong("seq_id", 0));
    L23:
        if (r12 == null) goto L25;
        Long r18 = Long.valueOf(r12.getLong("log_id", 0));
    L26:
        if (r12 == null) goto L28;
        Integer r19 = Integer.valueOf(r12.getInt("service", 0));
    L29:
        if (r12 == null) goto L31;
        Integer r20 = Integer.valueOf(r12.getInt(BdimCategoryConstants.INTENT_KEY_METHOD, 0));
    L33:
        if (r12 == null) goto L35;
        Serializable r21 = r12.getSerializable("ws_headers");
    L36:
        if (r21 == null) goto L44;
        if (r12 == null) goto L39;
        Serializable r22 = r12.getSerializable("ws_headers");
    L40:
        if (r22 == null) goto L43;
        HashMap r23 = (HashMap) r22;
    L45:
        if (r12 == null) goto L47;
        String r24 = r12.getString("payload_type");
    L48:
        if (r12 == null) goto L50;
        String r25 = r12.getString("payload_encoding");
    L51:
        if (r12 == null) goto L53;
        r8 = r12.getByteArray(WsConstants.KEY_PAYLOAD);
    L53:
        ArrayList r110 = a.f11288a;
        i.c(r16);
        int r26 = r16.intValue();
        i.c(r17);
        long r111 = r17.longValue();
        i.c(r18);
        long r27 = r18.longValue();
        i.c(r19);
        int r28 = r19.intValue();
        i.c(r20);
        int r112 = r20.intValue();
        StringBuilder r29 = new StringBuilder("onWsMsgReceivedByProvider() called with: channelId = ");
        r29.append(r26);
        r29.append(", seqId = ");
        r29.append(r111);
        r29.append(", logId = ");
        r29.append(r27);
        r29.append(", service = ");
        b.q(r29, r28, ", method = ", r112, ", encoding = ");
        r29.append(r25);
        r29.append(", type = ");
        r29.append(r24);
        r29.append(", payload = ");
        r29.append(r8);
        r29.append(", headers = ");
        r29.append(r23);
        r29.append(", wsBridge is null");
        i.f(r29.toString(), "msg");
        MatrixCursor r30 = new MatrixCursor(new String[]{"received"});
        r30.addRow(new String[]{"true"});
        return r30;
    L50:
        r25 = null;
        goto L51
    L47:
        r24 = null;
        goto L48
    L43:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    L39:
        r22 = null;
        goto L40
    L44:
        r23 = null;
        goto L45
    L35:
        r21 = null;
        goto L36
    L31:
        r20 = null;
        goto L33
    L28:
        r19 = null;
        goto L29
    L25:
        r18 = null;
        goto L26
    L22:
        r17 = null;
        goto L23
    L18:
        r16 = null;
        goto L20
    L56:
        return null;
    L5:
        if (r14.length() == 0) goto L8;
        r15 = false;
        goto L9
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r8, ContentValues r10, String r11, String[] r12) {
        i.f(r8, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r8, String[] r10, String r11, String[] r12, String r13) {
        i.f(r8, "uri");
        Log.d("WsMsgProvider", "query() called with: uri = " + r8 + ", projection = " + r10 + ", selection = " + r11 + ", selectionArgs = " + r12 + ", sortOrder = " + r13);
        return null;
    }
}
