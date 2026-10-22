package com.bytedance.android.live.revlink.link.biz.component.switchscenecompact;

import com.bytedance.android.live.revlink.link.biz.component.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "p1", "", "p2", "", "p3", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DoubleSceneCompactComponent$doubleEventTrackComponent$1 extends FunctionReferenceImpl implements Function3<Integer, Boolean, Long, Unit> {
    public DoubleSceneCompactComponent$doubleEventTrackComponent$1(g r8) {
        super(3, r8, g.class, "logChorusOver", "logChorusOver(IZJ)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
        invoke(((Number) r3).intValue(), ((Boolean) r4).booleanValue(), ((Number) r5).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r2, boolean r3, long r4) {
        ((g) ((CallableReference) this).receiver).a(r2, r3, r4);
    }
}
