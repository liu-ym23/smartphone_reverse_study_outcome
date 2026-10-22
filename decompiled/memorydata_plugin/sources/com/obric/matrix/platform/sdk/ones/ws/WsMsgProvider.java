package com.obric.matrix.platform.sdk.ones.ws;

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
import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J=\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0002\u0010\"JO\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u00102\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010$J;\u0010%\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010&R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006("}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgProvider;", "Landroid/content/ContentProvider;", "()V", "mMatcher", "Landroid/content/UriMatcher;", "getMMatcher", "()Landroid/content/UriMatcher;", "setMMatcher", "(Landroid/content/UriMatcher;)V", "delete", "", "uri", "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "logProxy", "", NotificationCompat.CATEGORY_MESSAGE, "onCreate", "", ChatMessage.TYPE_QUERY, "Landroid/database/Cursor;", "projection", "queryArgs", "Landroid/os/Bundle;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", BuildConfig.CHANNEL, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WsMsgProvider extends PluginContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8146a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private UriMatcher f8147b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgProvider$Companion;", "", "()V", "AUTHORITY_PRE", "", "DOT", "TAG", "WS_MSG", "WS_MSG_KEY_CHANNEL_ID", "WS_MSG_KEY_HEADERS", "WS_MSG_KEY_LOG_ID", "WS_MSG_KEY_METHOD", "WS_MSG_KEY_PAYLOAD", "WS_MSG_KEY_PAYLOAD_ENCODING", "WS_MSG_KEY_PAYLOAD_TYPE", "WS_MSG_KEY_SEQ_ID", "WS_MSG_KEY_SERVICE", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8146a = new a(null);
    }

    public WsMsgProvider() {
        this.f8147b = new UriMatcher(-1);
    }

    private final void a(String r3) {
        if (com.obric.matrix.platform.sdk.ones.b.f8082a.b() == null) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("WsMsgProvider", r3, null, 4, null);
        return;
    L9:
        Log.d("WsMsgProvider", r3);
        return;
    L5:
        r2 = false;
        goto L7
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
        a("onCreate() called");
        UriMatcher r0 = this.f8147b;
        StringBuilder r1 = new StringBuilder().append("com.obric.matrix.platform.sdk.ones.provider.");
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        String r5 = r4.getPackageName();
    L6:
        r0.addURI(r1.append(r5).toString(), "ws_msg", 1);
        return true;
    L5:
        r5 = null;
        goto L6
    }

    public Cursor query(Uri r22, String[] r23, Bundle r24, CancellationSignal r25) {
        Intrinsics.checkNotNullParameter(r22, "uri");
        a("query() called with:  queryArgs = " + r24 + ", uri = " + r22 + ", projection = " + r23 + ", cancellationSignal = " + r25 + ", callingPackage = " + getCallingPackage());
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(getCallingPackage(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        byte[] r7 = null;
        if (r4 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(getCallingPackage(), "com.obric.matrix") == true) goto L15;
        return null;
    L15:
        if (this.f8147b.match(r22) != 1) goto L54;
        if (r24 == null) goto L18;
        Integer r0 = Integer.valueOf(r24.getInt(WsConstants.KEY_CHANNEL_ID, 0));
    L20:
        if (r24 == null) goto L22;
        Long r1 = Long.valueOf(r24.getLong("seq_id", 0));
    L23:
        if (r24 == null) goto L25;
        Long r5 = Long.valueOf(r24.getLong("log_id", 0));
    L26:
        if (r24 == null) goto L28;
        Integer r6 = Integer.valueOf(r24.getInt("service", 0));
    L29:
        if (r24 == null) goto L31;
        Integer r8 = Integer.valueOf(r24.getInt("method", 0));
    L33:
        if (r24 == null) goto L35;
        Serializable r9 = r24.getSerializable("ws_headers");
    L36:
        if (r9 == null) goto L41;
        if (r24 == null) goto L39;
        Serializable r10 = r24.getSerializable("ws_headers");
    L40:
        Objects.requireNonNull(r10, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
        Object r11 = ZeusTransformUtils.preCheckCast(r10, HashMap.class, "com.obric.memorydata.plugin");
    L42:
        HashMap<String, String> r12 = (HashMap) r11;
        if (r24 == null) goto L45;
        String r18 = r24.getString("payload_type");
    L46:
        if (r24 == null) goto L48;
        String r17 = r24.getString("payload_encoding");
    L49:
        if (r24 == null) goto L51;
        r7 = r24.getByteArray("payload");
    L51:
        b r13 = b.f8148a;
        Intrinsics.checkNotNull(r0);
        int r14 = r0.intValue();
        Intrinsics.checkNotNull(r1);
        long r15 = r1.longValue();
        Intrinsics.checkNotNull(r5);
        long r16 = r5.longValue();
        Intrinsics.checkNotNull(r6);
        int r19 = r6.intValue();
        Intrinsics.checkNotNull(r8);
        r13.a(r14, r15, r16, r19, r8.intValue(), r17, r18, r7, r12);
        Cursor r20 = (Cursor) ZeusTransformUtils.preCheckCast(new MatrixCursor(new String[]{"received"}), Cursor.class, "com.obric.memorydata.plugin");
        ((MatrixCursor) ZeusTransformUtils.preCheckCast(r20, MatrixCursor.class, "com.obric.memorydata.plugin")).addRow(new String[]{"true"});
        return r20;
    L48:
        r17 = null;
        goto L49
    L45:
        r18 = null;
        goto L46
    L39:
        r10 = null;
        goto L40
    L41:
        r11 = ZeusTransformUtils.preCheckCast(null, HashMap.class, "com.obric.memorydata.plugin");
        goto L42
    L35:
        r9 = null;
        goto L36
    L31:
        r8 = null;
        goto L33
    L28:
        r6 = null;
        goto L29
    L25:
        r5 = null;
        goto L26
    L22:
        r1 = null;
        goto L23
    L18:
        r0 = null;
        goto L20
    L54:
        return null;
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public Cursor query(Uri r3, String[] r4, String r5, String[] r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        a("query() called with: uri = " + r3 + ", projection = " + r4 + ", selection = " + r5 + ", selectionArgs = " + r6 + ", sortOrder = " + r7);
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }
}
