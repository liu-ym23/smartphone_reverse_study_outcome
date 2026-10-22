package com.obric.common.oea.foundation.animation.a;

import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/obric/common/oea/foundation/animation/calculator/Motion;", "", "packedValue", "", "(J)V", "getPackedValue", "()J", EventBody.KEY_VALUE, "", "getValue", "()F", "velocity", "getVelocity", "copy", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f7669a;

    public d(long r1) {
        this.f7669a = r1;
    }

    public final float a() {
        return Float.intBitsToFloat((int) (this.f7669a >> 32));
    }

    public final float b() {
        return Float.intBitsToFloat((int) (this.f7669a & 4294967295L));
    }
}
