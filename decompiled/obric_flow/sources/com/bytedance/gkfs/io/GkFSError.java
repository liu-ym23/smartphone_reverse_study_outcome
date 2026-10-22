package com.bytedance.gkfs.io;

import androidx.core.view.PointerIconCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSError;", "", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum GkFSError extends Enum<GkFSError> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final GkFSError f4839b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final GkFSError f4840c = null;
    public static final GkFSError d = null;
    public static final GkFSError e = null;
    public static final GkFSError f = null;
    public static final GkFSError g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final GkFSError f4841h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final GkFSError f4842i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final GkFSError f4843j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final GkFSError f4844k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final GkFSError f4845l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final GkFSError f4846m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final GkFSError f4847n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ GkFSError[] f4848o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4849a;

    static {
        GkFSError r5 = new GkFSError("NO_ERROR", 0, -1);
        f4839b = r5;
        GkFSError r10 = new GkFSError("TINY_FILE", 1, 0);
        f4840c = r10;
        GkFSError r11 = new GkFSError("CDC_ERROR", 2, 1);
        d = r11;
        GkFSError r12 = new GkFSError("CDC_NO_CHUNK", 3, 2);
        e = r12;
        GkFSError r13 = new GkFSError("HEADER_WRITE_ERROR", 4, 100);
        f = r13;
        GkFSError r14 = new GkFSError("CHUNK_WRITE_ERROR", 5, 101);
        g = r14;
        GkFSError r15 = new GkFSError("TAIL_WRITE_ERROR", 6, 102);
        f4841h = r15;
        GkFSError r16 = new GkFSError("SOURCE_FILE_NOT_EXISTS", 7, 103);
        f4842i = r16;
        GkFSError r17 = new GkFSError("MAJOR_FILE_ERROR", 8, 104);
        GkFSError r18 = new GkFSError("MAJOR_FILE_RENAME_FAILED", 9, 105);
        f4843j = r18;
        GkFSError r19 = new GkFSError("STORE_GENERIC_ERROR", 10, 106);
        f4844k = r19;
        GkFSError r110 = new GkFSError("HEADER_READ_ERROR", 11, 1001);
        f4845l = r110;
        GkFSError r111 = new GkFSError("CHUNK_CONTENT_READ_ERROR", 12, PointerIconCompat.TYPE_HAND);
        f4846m = r111;
        GkFSError r112 = new GkFSError("TAIL_READ_ERROR", 13, PointerIconCompat.TYPE_HELP);
        f4847n = r112;
        f4848o = new GkFSError[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112};
    }

    public GkFSError(String r5, int r10, int r11) {
        super(r5, r10);
        this.f4849a = r11;
    }

    public static GkFSError valueOf(String r5) {
        return (GkFSError) Enum.valueOf(GkFSError.class, r5);
    }

    public static GkFSError[] values() {
        return (GkFSError[]) f4848o.clone();
    }
}
