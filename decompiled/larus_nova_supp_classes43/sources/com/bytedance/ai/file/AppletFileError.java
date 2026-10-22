package com.bytedance.ai.file;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00132\u00060\u0001j\u0002`\u0002:\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B%\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0007\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/file/AppletFileError;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "", com.bytedance.android.ec.core.event.a.KEY_MSG, "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()Ljava/lang/String;", "InvalidUri", "PathEscape", "NotExist", "IsDir", "NotDir", "QuotaExceeded", "IoError", "Companion", "Lcom/bytedance/ai/file/AppletFileError$InvalidUri;", "Lcom/bytedance/ai/file/AppletFileError$IoError;", "Lcom/bytedance/ai/file/AppletFileError$IsDir;", "Lcom/bytedance/ai/file/AppletFileError$NotDir;", "Lcom/bytedance/ai/file/AppletFileError$NotExist;", "Lcom/bytedance/ai/file/AppletFileError$PathEscape;", "Lcom/bytedance/ai/file/AppletFileError$QuotaExceeded;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AppletFileError extends RuntimeException {
    public static final String CODE_INVALID_URI = "INVALID_URI";
    public static final String CODE_IO_ERROR = "IO_ERROR";
    public static final String CODE_IS_DIR = "IS_DIR";
    public static final String CODE_NOT_DIR = "NOT_DIR";
    public static final String CODE_NOT_EXIST = "NOT_EXIST";
    public static final String CODE_PATH_ESCAPE = "PATH_ESCAPE";
    public static final String CODE_QUOTA_EXCEEDED = "QUOTA_EXCEEDED";
    public static final a Companion = null;
    private final String code;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ai/file/AppletFileError$InvalidUri;", "Lcom/bytedance/ai/file/AppletFileError;", "<init>", "()V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvalidUri extends AppletFileError {
        public static final InvalidUri INSTANCE = null;

        static {
            INSTANCE = new InvalidUri();
        }

        private InvalidUri() {
            super(AppletFileError.CODE_INVALID_URI, "invalid appletfile uri", null, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/file/AppletFileError$IoError;", "Lcom/bytedance/ai/file/AppletFileError;", "cause", "", "<init>", "(Ljava/lang/Throwable;)V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IoError extends AppletFileError {
        public IoError(Throwable r10) {
            if (r10 == null) goto L5;
            String r0 = r10.getMessage();
            if (r0 == null) goto L5;
        L6:
            super(AppletFileError.CODE_IO_ERROR, r0, r10, null);
            return;
        L5:
            r0 = "io error";
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ai/file/AppletFileError$IsDir;", "Lcom/bytedance/ai/file/AppletFileError;", "<init>", "()V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IsDir extends AppletFileError {
        public static final IsDir INSTANCE = null;

        static {
            INSTANCE = new IsDir();
        }

        private IsDir() {
            super(AppletFileError.CODE_IS_DIR, "target is a directory", null, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ai/file/AppletFileError$NotDir;", "Lcom/bytedance/ai/file/AppletFileError;", "<init>", "()V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NotDir extends AppletFileError {
        public static final NotDir INSTANCE = null;

        static {
            INSTANCE = new NotDir();
        }

        private NotDir() {
            super(AppletFileError.CODE_NOT_DIR, "target is not a directory", null, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ai/file/AppletFileError$NotExist;", "Lcom/bytedance/ai/file/AppletFileError;", "<init>", "()V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NotExist extends AppletFileError {
        public static final NotExist INSTANCE = null;

        static {
            INSTANCE = new NotExist();
        }

        private NotExist() {
            super(AppletFileError.CODE_NOT_EXIST, "file or dir not exist", null, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ai/file/AppletFileError$PathEscape;", "Lcom/bytedance/ai/file/AppletFileError;", "<init>", "()V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PathEscape extends AppletFileError {
        public static final PathEscape INSTANCE = null;

        static {
            INSTANCE = new PathEscape();
        }

        private PathEscape() {
            super(AppletFileError.CODE_PATH_ESCAPE, "path escape sandbox root", null, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ai/file/AppletFileError$QuotaExceeded;", "Lcom/bytedance/ai/file/AppletFileError;", "<init>", "()V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class QuotaExceeded extends AppletFileError {
        public static final QuotaExceeded INSTANCE = null;

        static {
            INSTANCE = new QuotaExceeded();
        }

        private QuotaExceeded() {
            super(AppletFileError.CODE_QUOTA_EXCEEDED, "quota exceeded", null, 4, null);
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getCode() {
        return this.code;
    }

    public AppletFileError(String r1, String r10, Throwable r11, DefaultConstructorMarker r12) {
        super(r10, r11);
        this.code = r1;
    }

    public /* synthetic */ AppletFileError(String r1, String r10, Throwable r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        this(r1, r10, r11, null);
    }
}
