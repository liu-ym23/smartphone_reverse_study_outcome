package androidx.room.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* synthetic */ class LimitOffsetPagingSource$observer$1 extends FunctionReferenceImpl implements Function0<Unit> {
    LimitOffsetPagingSource$observer$1(Object r8) {
        super(0, r8, LimitOffsetPagingSource.class, "invalidate", "invalidate()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((LimitOffsetPagingSource) ZeusTransformUtils.preCheckCast(this.receiver, LimitOffsetPagingSource.class, "com.obric.memorydata.plugin")).invalidate();
    }
}
