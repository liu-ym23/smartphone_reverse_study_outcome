package com.bytedance.android.btm.impl.page;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class BufferQueue$addSourceBtmTokenBufferBtmMap$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $btm;
    final /* synthetic */ BufferBtm $bufferBtm;
    final /* synthetic */ PageInfo $pageInfo;

    public BufferQueue$addSourceBtmTokenBufferBtmMap$1(String r1, BufferBtm r10, PageInfo r11) {
        this.$btm = r1;
        this.$bufferBtm = r10;
        this.$pageInfo = r11;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m686invoke() {
        com.bytedance.android.btm.impl.thread.b r0 = com.bytedance.android.btm.impl.thread.b.e;
        Runnable r1 = new AnonymousClass1(this);
        r0.getClass();
        com.bytedance.android.btm.impl.thread.b.c().schedule(r1, 2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L7
    L4:
        Runnable r10 = new AnonymousClass2(this);
        com.bytedance.android.btm.impl.thread.b.c().schedule(r10, 10000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L8
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m686invoke();
        return Unit.INSTANCE;
    }
}
