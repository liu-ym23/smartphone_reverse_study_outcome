package androidx.room.paging;

import android.database.Cursor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [Value] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* synthetic */ class LimitOffsetPagingSource$nonInitialLoad$loadResult$1<Value> extends FunctionReferenceImpl implements Function1<Cursor, List<? extends Value>> {
    LimitOffsetPagingSource$nonInitialLoad$loadResult$1(Object r8) {
        super(1, r8, LimitOffsetPagingSource.class, "convertRows", "convertRows(Landroid/database/Cursor;)Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Cursor r3) {
        return invoke2((Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<Value> invoke2(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "p0");
        return ((LimitOffsetPagingSource) ZeusTransformUtils.preCheckCast(this.receiver, LimitOffsetPagingSource.class, "com.obric.memorydata.plugin")).convertRows(r4);
    }
}
