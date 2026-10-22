package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.os.Bundle;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.entity.RecommendComplexQuery;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class CocreationTaskRepository {
    public final Function2<Context, Integer, MemoryResponse<List<RecommendComplexQuery>>> a;
    public final Context b;

    /* JADX INFO: renamed from: com.obric.assistant.cocreationreview.CocreationTaskRepository$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Context, Integer, MemoryResponse<List<? extends RecommendComplexQuery>>> {
        public AnonymousClass1(Object r8) {
            super(2, r8, pka.a.class, "getMemorySynthesisRecommendQuery", "getMemorySynthesisRecommendQuery(Landroid/content/Context;I)Lcom/obric/memorydata/sdk/MemoryResponse;", 0);
        }

        public final MemoryResponse<List<RecommendComplexQuery>> invoke(Context r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "p0");
            ((pka.a) ((CallableReference) this).receiver).getClass();
            Intrinsics.checkNotNullParameter(r3, "context");
            boolean r0 = true;
            if (1 <= r4) goto L5;
        L7:
            r0 = false;
        L8:
            if (r0 == false) goto L12;
            Bundle r1 = new Bundle();
            r1.putInt("limit", r4);
            return pka.a.c(r3, "getMemorySynthesisRecommendQuery", r1);
        L12:
            return new MemoryResponse(405, "INVALID_LIMIT", 4);
        L5:
            if (r4 >= 101) goto L7;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Context) r1, ((Number) r2).intValue());
        }
    }

    public CocreationTaskRepository() {
        throw null;
    }

    public CocreationTaskRepository(Context r3) {
        AnonymousClass1 r0 = new AnonymousClass1(pka.a.a);
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r0, "query");
        this.a = r0;
        this.b = r3.getApplicationContext();
    }

    public final Object a(Continuation<? super List<e4>> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CocreationTaskRepository$loadTasks$2(this, null), r4);
    }
}
