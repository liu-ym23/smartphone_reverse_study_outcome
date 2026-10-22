package com.larus.bmhome.chat.component.bottom.multimodal.sender;

import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.q;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n implements ye8.c {
    public static final n a = null;
    public static final Map<String, com.larus.bmhome.chat.component.bottom.multimodal.upload.m> b = null;
    public static final Map<String, UplinkFileEntity> c = null;

    public n() {
    }

    static {
        a = new n();
        b = new LinkedHashMap();
        c = new LinkedHashMap();
    }

    @Override // ye8.c
    public final void clear() {
        ((LinkedHashMap) b).clear();
        ((LinkedHashMap) c).clear();
    }

    @Override // ye8.c
    public final com.larus.bmhome.chat.component.bottom.multimodal.upload.m a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileIdentifier");
        return (com.larus.bmhome.chat.component.bottom.multimodal.upload.m) ((LinkedHashMap) b).get(r2);
    }

    @Override // ye8.c
    public final Object b(q r3, Continuation<? super Unit> r4) {
        Object r5 = FileUploader.g(r3, null, r4, 6);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }
}
