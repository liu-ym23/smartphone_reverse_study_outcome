package com.larus.bmhome.chat.model.strategy;

import com.larus.platform.model.upload.UploadDataType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public /* synthetic */ class ChatRetryStrategy$b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[UploadDataType.values().length];
        r0[UploadDataType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r0[UploadDataType.FILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r0[UploadDataType.UNCLEAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r0[UploadDataType.VIDEO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        a = r0;
    }
}
