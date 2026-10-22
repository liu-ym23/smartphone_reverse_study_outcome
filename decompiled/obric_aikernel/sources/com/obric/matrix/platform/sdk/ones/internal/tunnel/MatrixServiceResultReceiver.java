package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.obric.matrix.proto.Response;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MatrixServiceResultReceiver extends ResultReceiver {
    public static final a Companion = null;
    private static final String KEY_EXTRA_DATA = "EXTRA_DATA";
    private static final String TAG = "MatrixServiceResultReceiver";
    private final f mResultCallback;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public MatrixServiceResultReceiver(Handler r10, f r11) {
        Intrinsics.checkNotNullParameter(r11, "resultCallback");
        super(r10);
        this.mResultCallback = r11;
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int r10, Bundle r11) {
        super.onReceiveResult(r10, r11);
        if (r11 == null) goto L12;
        byte[] r12 = r11.getByteArray("RESPONSE_BYTE_ARRAY");     // Catch: Exception -> L13
        if (r12 == null) goto L12;
        Response r13 = Response.ADAPTER.decode(r12);     // Catch: Exception -> L13
        this.mResultCallback.a(r13, e9.a.f8754a.a(r11.getString(KEY_EXTRA_DATA)));     // Catch: Exception -> L9
        return;
    L9:
        e = e;
    L15:
        e9.b.b(TAG, "onReceiveResult exception " + e.getMessage(), null, 4, null);
        if (r13 == null) goto L18;
        this.mResultCallback.a(r13, new JSONObject());
        return;
    L18:
        if (r10 != 0) goto L21;
        r10 = -20004;
    L21:
        f r14 = this.mResultCallback;
        Response r15 = new Response.a().i(Integer.valueOf(r10)).e("receive result exception").c();
        Intrinsics.checkNotNullExpressionValue(r15, "Builder().statusCode(err…RESULT_EXCEPTION).build()");
        r14.a(r15, new JSONObject());
        return;
    L13:
        e = e;
        r13 = null;
    L12:
        throw new IllegalStateException("RESPONSE_BYTE_ARRAY not found");     // Catch: Exception -> L13
    }
}
