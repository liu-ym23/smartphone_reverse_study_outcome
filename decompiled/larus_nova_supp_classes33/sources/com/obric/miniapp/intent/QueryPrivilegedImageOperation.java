package com.obric.miniapp.intent;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.util.Base64;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class QueryPrivilegedImageOperation {
    public static final QueryPrivilegedImageOperation a = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/miniapp/intent/QueryPrivilegedImageOperation$PrivilegedImageException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PrivilegedImageException extends RuntimeException {
        private final String code;

        public final String getCode() {
            return this.code;
        }

        public PrivilegedImageException(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            Intrinsics.checkNotNullParameter(r3, "message");
            super(r3);
            this.code = r2;
        }
    }

    public static final class a {
        public final boolean a;
        public final JSONObject b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "QueryResult(success=" + this.a + ", content=" + this.b + ", errorCode=" + this.c + ", errorMessage=" + this.d + ')';
        }

        public a(boolean r3, JSONObject r4, String r5, String r6, int r7) {
            if ((r7 & 2) == 0) goto L6;
            r4 = new JSONObject();
        L6:
            if ((r7 & 4) == 0) goto L9;
            r5 = "";
        L9:
            if ((r7 & 8) == 0) goto L11;
            r6 = "";
        L11:
            Intrinsics.checkNotNullParameter(r4, "content");
            Intrinsics.checkNotNullParameter(r5, "errorCode");
            Intrinsics.checkNotNullParameter(r6, "errorMessage");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    static {
        a = new QueryPrivilegedImageOperation();
    }

    public QueryPrivilegedImageOperation() {
    }

    public static String c(Bitmap r4, int r5) {
        if (r5 <= 0) goto L7;
        int r1 = Math.max(r4.getWidth(), r4.getHeight());
        if (r1 <= r5) goto L7;
        float r6 = r5 / r1;
        Bitmap r7 = Bitmap.createScaledBitmap(r4, RangesKt.coerceAtLeast((int) (r4.getWidth() * r6), 1), RangesKt.coerceAtLeast((int) (r4.getHeight() * r6), 1), true);
    L34:
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();     // Catch: Throwable -> L26
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L11:
        if (r7.compress(Bitmap.CompressFormat.JPEG, 86, r2) == false) goto L20;
        String r0 = "data:image/jpeg;base64," + Base64.encodeToString(r2.toByteArray(), 2);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L26
        if (r7 == r4) goto L17;
        r7.recycle();
    L17:
        r4.recycle();
        return r0;
    L20:
        throw new PrivilegedImageException("ENCODE_IMAGE_FAILED", "encode image failed");     // Catch: Throwable -> L21
    L26:
        th = move-exception;
        if (r7 == r4) goto L29;
        r7.recycle();
    L29:
        r4.recycle();
        throw th;
    L7:
        r7 = r4;
        goto L34
    }

    public static a e(String r7, String r8) {
        return new a(false, null, r7, r8, 2);
    }

    public static String g(JSONObject r2, String r3) {
        if (r2.has(r3) == true) goto L5;
        return "";
    L5:
        String r4 = r2.optString(r3);
        Intrinsics.checkNotNull(r4);
        if ((!StringsKt.isBlank(r4)) == true) goto L9;
        r4 = null;
    L9:
        if (r4 != null) goto L12;
        return "";
    L12:
        return r4;
    }

    public final Object d(JSONObject r12, Continuation<? super a> r13) {
        if ((r13 instanceof QueryPrivilegedImageOperation$execute$1) == false) goto L7;
        QueryPrivilegedImageOperation$execute$1 r0 = (QueryPrivilegedImageOperation$execute$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L25:
        a r15 = (a) r14;
        if (r15 == null) goto L28;
        return r15;
    L28:
        return e("READ_TIMEOUT", "query privileged image timeout");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        String r6 = g(r12, "package_name");
        if (StringsKt.isBlank(r6) == true) goto L17;
        String r7 = g(r12, "uri");
        if (StringsKt.isBlank(r7) == true) goto L21;
        boolean r5 = r12.optBoolean("is_video", false);
        int r8 = RangesKt.coerceAtLeast(r12.optInt("max_size", 0), 0);
        long r16 = TimeUnit.SECONDS.toMillis(10);
        QueryPrivilegedImageOperation$execute$2 r4 = new QueryPrivilegedImageOperation$execute$2(r5, r6, r7, r8, null);
        r0.label = 1;
        r14 = TimeoutKt.c(r16, r4, r0);
        if (r14 != r2) goto L25;
        return r2;
    L21:
        return e("MISSING_URI", "uri is required");
    L17:
        return e("MISSING_PACKAGE_NAME", "package_name is required");
    L7:
        r0 = new QueryPrivilegedImageOperation$execute$1(this, r13);
        goto L8
    }

    public final Object f(String r5, String r6, Continuation<? super AssetFileDescriptor> r7) {
        if ((r7 instanceof QueryPrivilegedImageOperation$openPrivilegedAssetFile$1) == false) goto L7;
        QueryPrivilegedImageOperation$openPrivilegedAssetFile$1 r0 = (QueryPrivilegedImageOperation$openPrivilegedAssetFile$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        UriFileAccessSession r9 = (UriFileAccessSession) r8;
        if (r9.a != 0) goto L25;
        AssetFileDescriptor r10 = r9.c;
        if (r10 == null) goto L23;
        return r10;
    L23:
        throw new PrivilegedImageException("OPEN_URI_FAILED", "open uri failed");
    L25:
        throw new PrivilegedImageException("OPEN_URI_FAILED", "open uri failed: status=" + r9.a + ", message=" + r9.b);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        AtomicCapabilitySdk r11 = AtomicCapabilitySdk.INSTANCE;
        Uri r12 = UriProtector.parse(r6);
        r0.label = 1;
        r8 = r11.openFileDescriptorPrivileged(r5, r12, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new QueryPrivilegedImageOperation$openPrivilegedAssetFile$1(this, r7);
        goto L8
    }

    public static final Object a(QueryPrivilegedImageOperation r10, String r11, String r12, int r13, Continuation r14) {
        r10.getClass();
        if ((r14 instanceof QueryPrivilegedImageOperation$encodeImage$1) == false) goto L7;
        QueryPrivilegedImageOperation$encodeImage$1 r0 = (QueryPrivilegedImageOperation$encodeImage$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        int r4 = 1;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        int r16 = r0.I$0;
        BitmapFactory.Options r17 = (BitmapFactory.Options) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L34:
        Closeable r18 = (Closeable) r15;
        Bitmap r19 = BitmapFactory.decodeStream(((AssetFileDescriptor) r18).createInputStream(), null, r17);     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r18, null);
        if (r19 == null) goto L41;
        return c(r19, r16);
    L41:
        throw new PrivilegedImageException("DECODE_IMAGE_FAILED", "decode image failed");
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = r0.I$0;
        BitmapFactory.Options r110 = (BitmapFactory.Options) r0.L$2;
        r12 = (String) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L20:
        Closeable r111 = (Closeable) r15;
        BitmapFactory.decodeStream(((AssetFileDescriptor) r111).createInputStream(), null, r110);     // Catch: Throwable -> L47
        CloseableKt.closeFinally(r111, null);
        BitmapFactory.Options r112 = new BitmapFactory.Options();
        int r6 = r110.outWidth;
        int r113 = r110.outHeight;
        if (r13 <= 0) goto L30;
        if (r6 <= 0) goto L30;
        if (r113 <= 0) goto L30;
    L28:
        if (Math.max(r6 / r4, r113 / r4) <= (r13 * 2)) goto L30;
        r4 = r4 * 2;
    L30:
        r112.inSampleSize = r4;
        r0.L$0 = r112;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.I$0 = r13;
        r0.label = 2;
        Object r114 = r10.f(r5, r12, r0);
        if (r114 == r2) goto L62;
        r17 = r112;
        r15 = r114;
        r16 = r13;
        goto L34
    L62:
        return r2;
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        CloseableKt.closeFinally(r111, th);
        throw th;
    L16:
        ResultKt.throwOnFailure(r15);
        BitmapFactory.Options r115 = new BitmapFactory.Options();
        r115.inJustDecodeBounds = true;
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.L$2 = r115;
        r0.I$0 = r13;
        r0.label = 1;
        Object r7 = r10.f(r11, r12, r0);
        if (r7 == r2) goto L61;
        r5 = r11;
        r110 = r115;
        r15 = r7;
        goto L20
    L61:
        return r2;
    L7:
        r0 = new QueryPrivilegedImageOperation$encodeImage$1(r10, r14);
        goto L8
    }

    public static final Object b(QueryPrivilegedImageOperation r8, String r9, String r10, int r11, Continuation r12) {
        r8.getClass();
        if ((r12 instanceof QueryPrivilegedImageOperation$encodeVideoFirstFrame$1) == false) goto L7;
        QueryPrivilegedImageOperation$encodeVideoFirstFrame$1 r0 = (QueryPrivilegedImageOperation$encodeVideoFirstFrame$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = r0.I$0;
        ResultKt.throwOnFailure(r13);
    L17:
        Closeable r14 = (Closeable) r13;
        AssetFileDescriptor r15 = (AssetFileDescriptor) r14;     // Catch: Throwable -> L34
        MediaMetadataRetriever r16 = new MediaMetadataRetriever();     // Catch: Throwable -> L34
    L31:
        th = move-exception;
        r16.release();     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L20:
        if (r15.getLength() < 0) goto L22;
        r16.setDataSource(r15.getFileDescriptor(), r15.getStartOffset(), r15.getLength());     // Catch: Throwable -> L31
    L23:
        Bitmap r17 = r16.getFrameAtTime(0, 2);     // Catch: Throwable -> L31
        r16.release();     // Catch: Throwable -> L34
        CloseableKt.closeFinally(r14, null);
        if (r17 == null) goto L30;
        return c(r17, r11);
    L30:
        throw new PrivilegedImageException("DECODE_VIDEO_FRAME_FAILED", "decode video frame failed");
    L22:
        r16.setDataSource(r15.getFileDescriptor());     // Catch: Throwable -> L31
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r0.I$0 = r11;
        r0.label = 1;
        r13 = r8.f(r9, r10, r0);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new QueryPrivilegedImageOperation$encodeVideoFirstFrame$1(r8, r12);
        goto L8
    }
}
