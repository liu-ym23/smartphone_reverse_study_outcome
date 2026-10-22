package com.larus.camera.impl.utils.album;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.utils.album.AlbumThumbListManager", f = "AlbumThumbListManager.kt", i = {}, l = {20}, m = "hasAlbumImages", n = {}, s = {})
public final class AlbumThumbListManager$hasAlbumImages$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlbumThumbListManager this$0;

    public AlbumThumbListManager$hasAlbumImages$1(AlbumThumbListManager r1, Continuation<? super AlbumThumbListManager$hasAlbumImages$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
