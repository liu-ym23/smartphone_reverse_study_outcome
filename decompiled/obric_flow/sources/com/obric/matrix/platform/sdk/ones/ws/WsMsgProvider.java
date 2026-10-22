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
import androidx.core.app.NotificationCompat;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.common.wschannel.WsConstants;
import com.lynx.jsbridge.LynxResourceModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WsMsgProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UriMatcher f11904a;

    public WsMsgProvider() {
        this.f11904a = new UriMatcher(-1);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r5, String r10, String[] r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r5, ContentValues r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Log.d("WsMsgProvider", "onCreate() called");
        UriMatcher r5 = this.f11904a;
        StringBuilder r10 = new StringBuilder("com.obric.matrix.platform.sdk.ones.provider.");
        Context r11 = getContext();
        if (r11 == null) goto L5;
        String r12 = r11.getPackageName();
    L6:
        r10.append(r12);
        r5.addURI(r10.toString(), "ws_msg", 1);
        return true;
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r10, String[] r11, Bundle r12, CancellationSignal r13) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Log.d("WsMsgProvider", "query() called with:  queryArgs = " + r12 + ", uri = " + r10 + ", projection = " + r11 + ", cancellationSignal = " + r13 + ", callingPackage = " + getCallingPackage());
        String r14 = getCallingPackage();
        byte[] r15 = null;
        if (r14 != null) goto L5;
        return null;
    L5:
        if (r14.length() != 0) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(getCallingPackage(), "com.obric.matrix") == true) goto L11;
        return null;
    L11:
        if (this.f11904a.match(r10) == 1) goto L13;
        return null;
    L13:
        if (r12 == null) goto L15;
        Integer r16 = Integer.valueOf(r12.getInt(WsConstants.KEY_CHANNEL_ID, 0));
    L17:
        if (r12 == null) goto L19;
        Long r17 = Long.valueOf(r12.getLong("seq_id", 0));
    L20:
        if (r12 == null) goto L22;
        Long r5 = Long.valueOf(r12.getLong("log_id", 0));
    L23:
        if (r12 == null) goto L25;
        Integer r18 = Integer.valueOf(r12.getInt(NotificationCompat.CATEGORY_SERVICE, 0));
    L26:
        if (r12 == null) goto L28;
        Integer r19 = Integer.valueOf(r12.getInt("method", 0));
    L30:
        if (r12 == null) goto L32;
        Serializable r20 = r12.getSerializable("ws_headers");
    L33:
        if (r20 == null) goto L41;
        if (r12 == null) goto L36;
        Serializable r21 = r12.getSerializable("ws_headers");
    L37:
        if (r21 == null) goto L40;
        HashMap r22 = (HashMap) r21;
    L42:
        if (r12 == null) goto L44;
        String r23 = r12.getString("payload_type");
    L45:
        if (r12 == null) goto L47;
        String r24 = r12.getString("payload_encoding");
    L48:
        if (r12 == null) goto L50;
        r15 = r12.getByteArray("payload");
    L50:
        ArrayList r110 = a.f11906a;
        Intrinsics.checkNotNull(r16);
        int r25 = r16.intValue();
        Intrinsics.checkNotNull(r17);
        long r111 = r17.longValue();
        Intrinsics.checkNotNull(r5);
        long r26 = r5.longValue();
        Intrinsics.checkNotNull(r18);
        int r27 = r18.intValue();
        Intrinsics.checkNotNull(r19);
        int r28 = r19.intValue();
        StringBuilder r29 = new StringBuilder("onWsMsgReceivedByProvider() called with: channelId = ");
        r29.append(r25);
        r29.append(", seqId = ");
        r29.append(r111);
        kotlin.collections.a.o(r29, ", logId = ", r26, ", service = ");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r29, r27, ", method = ", r28, ", encoding = ");
        androidx.constraintlayout.motion.widget.a.C(r29, r24, ", type = ", r23, ", payload = ");
        r29.append(r15);
        r29.append(", headers = ");
        r29.append(r22);
        r29.append(", wsBridge is null");
        com.lynx.jsbridge.a.q("MatrixWsHelper", r29.toString());
        MatrixCursor r112 = new MatrixCursor(new String[]{MessageIndication.STATUS_RECEIVED});
        r112.addRow(new String[]{"true"});
        return r112;
    L47:
        r24 = null;
        goto L48
    L44:
        r23 = null;
        goto L45
    L40:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    L36:
        r21 = null;
        goto L37
    L41:
        r22 = null;
        goto L42
    L32:
        r20 = null;
        goto L33
    L28:
        r19 = null;
        goto L30
    L25:
        r18 = null;
        goto L26
    L22:
        r5 = null;
        goto L23
    L19:
        r17 = null;
        goto L20
    L15:
        r16 = null;
        goto L17
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r5, ContentValues r10, String r11, String[] r12) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        return 0;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r5, String[] r10, String r11, String[] r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Log.d("WsMsgProvider", "query() called with: uri = " + r5 + ", projection = " + r10 + ", selection = " + r11 + ", selectionArgs = " + r12 + ", sortOrder = " + r13);
        return null;
    }
}
