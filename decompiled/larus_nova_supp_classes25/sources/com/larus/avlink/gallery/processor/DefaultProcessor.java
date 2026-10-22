package com.larus.avlink.gallery.processor;

import com.larus.avlink.gallery.model.MediaMetadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DefaultProcessor implements i {
    public DefaultProcessor() {
    }

    @Override // com.larus.avlink.gallery.processor.i
    public final Object a(String r3, MediaMetadata r4, Continuation<? super k> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new DefaultProcessor$processSync$2(r3, null), r5);
    }
}
