package com.larus.dora.impl.feedback;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/feedback/ImageState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ON_COMPRESS", "COMPRESS_DONE", "ON_UPLOAD", "READY", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImageState extends Enum<ImageState> {
    public static final ImageState COMPRESS_DONE = null;
    public static final ImageState FAILED = null;
    public static final ImageState IDLE = null;
    public static final ImageState ON_COMPRESS = null;
    public static final ImageState ON_UPLOAD = null;
    public static final ImageState READY = null;
    public static final /* synthetic */ ImageState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ImageState> getEntries() {
        return b;
    }

    static {
        ImageState r0 = new ImageState("IDLE", 0);
        IDLE = r0;
        ImageState r1 = new ImageState("ON_COMPRESS", 1);
        ON_COMPRESS = r1;
        ImageState r3 = new ImageState("COMPRESS_DONE", 2);
        COMPRESS_DONE = r3;
        ImageState r5 = new ImageState("ON_UPLOAD", 3);
        ON_UPLOAD = r5;
        ImageState r7 = new ImageState("READY", 4);
        READY = r7;
        ImageState r9 = new ImageState("FAILED", 5);
        FAILED = r9;
        ImageState[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ImageState[] values() {
        return (ImageState[]) a.clone();
    }

    public static ImageState valueOf(String r1) {
        return (ImageState) r27.a.a(ImageState.class, r1);
    }

    public ImageState(String r1, int r2) {
        super(r1, r2);
    }
}
