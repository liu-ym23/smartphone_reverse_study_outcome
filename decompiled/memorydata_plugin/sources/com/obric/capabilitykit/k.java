package com.obric.capabilitykit;

import android.os.SystemClock;
import com.obric.livecard.api.utils.LiveCardConstant;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/apphost/AppClockImpl;", "Lcom/obric/capabilitykit/apphost/AppClock;", "()V", "globalTime", "Lkotlin/Pair;", "", "currentTimeMillis", LiveCardConstant.ISLAND_EXT_KEY_UPDATE_TIMESTAMP, "", "timestampMillis", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Pair<Long, Long> f7591a;

    public k() {
    }

    @Override // com.obric.capabilitykit.j
    public long a() {
        Pair<Long, Long> r5 = this.f7591a;
        if (r5 == null) goto L6;
        return (SystemClock.elapsedRealtime() - ((Number) ZeusTransformUtils.preCheckCast(r5.getFirst(), Number.class, "com.obric.memorydata.plugin")).longValue()) + ((Number) ZeusTransformUtils.preCheckCast(r5.getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue();
    L6:
        return System.currentTimeMillis();
    }

    @Override // com.obric.capabilitykit.j
    public void a(long r3) {
        if (this.f7591a != null) goto L6;
        this.f7591a = TuplesKt.to(Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(r3));
        return;
    }
}
