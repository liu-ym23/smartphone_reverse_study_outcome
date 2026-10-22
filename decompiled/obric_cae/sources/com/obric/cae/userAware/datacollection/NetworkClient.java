package com.obric.cae.userAware.datacollection;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import com.obric.cae.log.CaeLog;
import defpackage.b;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import jf.d;
import jf.e;
import jf.h;
import jf.p;
import jf.q;
import we.a0;
import we.c0;
import we.t;
import we.u;
import we.v;
import we.x;
import we.y;
import we.z;
import xe.c;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkClient {
    private static final int MAX_CLIENT_WAIT_TIME = 30;
    private static final String TAG = "NetworkClient";
    public static final String UPLOAD_FILE_TYPE_AAC = "audio/aac";
    public static final String UPLOAD_FILE_TYPE_JSON = "application/json";
    public static final String UPLOAD_FILE_TYPE_TEXT = "text/plain";
    public static final String UPLOAD_FILE_TYPE_ZIP = "application/zip";
    private final v client;
    private final String uploadUrl;

    public static class CountingRequestBody extends z {
        private final z delegate;
        private final String fileName;
        private final UploadProgressListener listener;
        private final long totalBytes;

        public final class CountingSink extends h {
            private long bytesWritten;
            final /* synthetic */ CountingRequestBody this$0;

            public CountingSink(CountingRequestBody r8, jf.v r10) {
                this.this$0 = r8;
                super(r10);
                this.bytesWritten = 0;
            }

            @Override // jf.h, jf.v
            public void write(d r8, long r10) {
                super.write(r8, r10);
                this.bytesWritten += r10;
                if (CountingRequestBody.access$300(this.this$0) == null) goto L6;
                CountingRequestBody.access$300(this.this$0).onProgress(CountingRequestBody.access$100(this.this$0), this.bytesWritten, CountingRequestBody.access$400(this.this$0));
                return;
            }
        }

        public CountingRequestBody(z r8, String r10, UploadProgressListener r11) {
            this.delegate = r8;
            this.listener = r11;
            this.fileName = r10;
            long r12 = r8.contentLength();     // Catch: IOException -> L5
        L7:
            this.totalBytes = r12;
            return;
        L5:
            e = move-exception;
            CaeLog.e(NetworkClient.access$200(), "Could not get content length from delegate RequestBody", e);
            r12 = 0;
            goto L7
        }

        public static /* synthetic */ z access$000(CountingRequestBody r8) {
            return r8.delegate;
        }

        public static /* synthetic */ String access$100(CountingRequestBody r8) {
            return r8.fileName;
        }

        public static /* synthetic */ UploadProgressListener access$300(CountingRequestBody r8) {
            return r8.listener;
        }

        public static /* synthetic */ long access$400(CountingRequestBody r8) {
            return r8.totalBytes;
        }

        @Override // we.z
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // we.z
        public t contentType() {
            return this.delegate.contentType();
        }

        @Override // we.z
        public void writeTo(e r8) {
            CountingSink r10 = new CountingSink(this, r8);
            Logger r11 = p.f8861a;
            q r12 = new q(r10);
            this.delegate.writeTo(r12);
            r12.flush();
        }
    }

    public interface UploadProgressListener {
        void onProgress(String r8, long r10, long r11);
    }

    public NetworkClient(String r8) {
        if (r8 == null) goto L9;
        if (r8.isEmpty() == true) goto L9;
        CaeLog.d(TAG, "uploadUrl: ".concat(r8));
        this.uploadUrl = r8;
        v.b r10 = new v.b();
        TimeUnit r11 = TimeUnit.SECONDS;
        r10.f13315w = c.d(30, r11);
        r10.f13316x = c.d(30, r11);
        r10.f13317y = c.d(30, r11);
        this.client = new v(r10);
        return;
    L9:
        throw new IllegalArgumentException("Upload URL cannot be null or empty");
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    private void handleUploadError(a0 r8) {
        c0 r10 = r8.f13120q;     // Catch: IOException -> L11
        if (r10 == null) goto L6;
        String r11 = r10.n();     // Catch: IOException -> L11
    L7:
        CaeLog.e(TAG, "Upload failed with code: " + r8.f13116m + ", message: " + r11);     // Catch: IOException -> L11
        c0 r12 = r8.f13120q;     // Catch: IOException -> L11
        if (r12 == null) goto L16;
        r12.close();     // Catch: IOException -> L11
        return;
    L16:
        return;
    L6:
        r11 = null;
    L11:
        e = move-exception;
        CaeLog.e(TAG, "Failed to read response body: " + e.getMessage());
    }

    private void logRequestBody(z r8) {
        if ((r8 instanceof u) == false) goto L14;
        u r10 = (u) r8;
        String r11 = TAG;
        CaeLog.d(r11, "Request Body Type: Multipart");
        CaeLog.d(r11, "Boundary: " + r10.f13268a.p());
        StringBuilder r12 = new StringBuilder("Parts count: ");
        List<u.b> r13 = r10.f13270c;
        r12.append(r13.size());
        CaeLog.d(r11, r12.toString());
        Iterator<u.b> r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L31;
        u.b r15 = r14.next();
        String r16 = TAG;
        CaeLog.d(r16, "Part Headers: " + r15.f13275a);
        StringBuilder r17 = new StringBuilder("Part Body ContentType: ");
        z r18 = r15.f13276b;
        r17.append(r18.contentType());
        CaeLog.d(r16, r17.toString());
        CaeLog.d(r16, "Part Body ContentLength: " + r18.contentLength());     // Catch: IOException -> L12
        if ((r18 instanceof CountingRequestBody) == false) goto L6;
        CountingRequestBody r19 = (CountingRequestBody) r18;     // Catch: IOException -> L12
        CaeLog.d(r16, "CountingRequestBody delegate ContentType: " + CountingRequestBody.access$000(r19).contentType());     // Catch: IOException -> L12
        CaeLog.d(r16, "CountingRequestBody delegate ContentLength: " + CountingRequestBody.access$000(r19).contentLength());     // Catch: IOException -> L12
        CaeLog.d(r16, "CountingRequestBody fileName: " + CountingRequestBody.access$100(r19));     // Catch: IOException -> L12
    L12:
        e = move-exception;
        CaeLog.e(TAG, "Error getting part body info: " + e.getMessage());
        goto L6
    L31:
        return;
    L14:
        String r20 = TAG;
        CaeLog.d(r20, "Request Body ContentType: " + r8.contentType());
        CaeLog.d(r20, "Request Body ContentLength: " + r8.contentLength());     // Catch: IOException -> L17
        d r21 = new d();     // Catch: IOException -> L17
        r8.writeTo(r21);     // Catch: IOException -> L17
        CaeLog.d(r20, "Request Body Content (first N bytes): ".concat(r21.P(Math.min(r21.f8830b, 1024))));     // Catch: IOException -> L17
        return;
    L17:
        e = move-exception;
        CaeLog.e(TAG, "Error reading request body: " + e.getMessage());
    }

    public boolean uploadFile(File r12, String r13, UploadProgressListener r14) {
        if (r12 != null) goto L5;
    L36:
        CaeLog.e(TAG, "File does not exist or is null");
        return false;
    L5:
        if (r12.exists() == false) goto L36;
        String r8 = TAG;
        CaeLog.d(r8, "Starting upload for file: " + r12.getAbsolutePath());
        CountingRequestBody r10 = new CountingRequestBody(z.create(t.b(r13), r12), r12.getName(), r14);
        u.a r15 = new u.a();
        r15.c(u.f13264f);
        String r11 = r12.getName();
        StringBuilder r16 = new StringBuilder("form-data; name=");
        u.a(BwdlDropConstant.FILE, r16);
        if (r11 == null) goto L10;
        r16.append("; filename=");
        u.a(r11, r16);
    L10:
        we.q.a r17 = new we.q.a();
        String r18 = r16.toString();
        we.q.b("Content-Disposition");
        r17.b("Content-Disposition", r18);
        r15.a(u.b.a(new we.q(r17), r10));
        u r19 = r15.b();
        y.a r20 = new y.a();
        r20.e(this.uploadUrl);
        r20.f13347d.a("x-tt-env", "ppe_iot_admin");
        r20.c(r19, HttpMethodContrants.POST);
        y r21 = r20.a();
        logRequestBody(r19);
        v r110 = this.client;     // Catch: Exception -> L33
        r110.getClass();     // Catch: Exception -> L33
        a0 r111 = x.f(r110, r21, false).d();     // Catch: Exception -> L33
    L27:
        th = move-exception;
        r111.close();     // Catch: Throwable -> L30
    L32:
        throw th;     // Catch: Exception -> L33
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L33
        goto L32
    L13:
        if (r111.r() == false) goto L24;
        c0 r22 = r111.f13120q;
        if (r22 == null) goto L24;
        long r23 = r10.contentLength();     // Catch: Throwable -> L27
        if (r23 <= 0) goto L19;
        CaeLog.d(r8, "Upload successful, reps once: " + r22.n());     // Catch: Throwable -> L27
    L19:
        if (r14 == null) goto L21;
        r14.onProgress(r12.getName(), r23, r23);     // Catch: Throwable -> L27
    L21:
        r111.close();     // Catch: Exception -> L33
        return true;
    L24:
        handleUploadError(r111);     // Catch: Throwable -> L27
        r111.close();     // Catch: Exception -> L33
    L35:
        return false;
    L33:
        e = move-exception;
        b.k(e, new StringBuilder("Unexpected error during upload: "), TAG);
        goto L35
    }
}
