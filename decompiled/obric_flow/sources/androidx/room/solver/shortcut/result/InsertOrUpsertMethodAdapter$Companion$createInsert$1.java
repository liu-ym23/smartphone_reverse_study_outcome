package androidx.room.solver.shortcut.result;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class InsertOrUpsertMethodAdapter$Companion$createInsert$1 extends FunctionReferenceImpl implements Function1<InsertOrUpsertMethodAdapter.ReturnType, InsertOrUpsertMethodAdapter.InsertMethodType> {
    public static final InsertOrUpsertMethodAdapter$Companion$createInsert$1 INSTANCE = null;

    static {
        INSTANCE = new InsertOrUpsertMethodAdapter$Companion$createInsert$1();
    }

    public InsertOrUpsertMethodAdapter$Companion$createInsert$1() {
        super(1, InsertOrUpsertMethodAdapter.InsertMethodType.class, "<init>", "<init>(Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter$ReturnType;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final InsertOrUpsertMethodAdapter.InsertMethodType invoke2(InsertOrUpsertMethodAdapter.ReturnType r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        return new InsertOrUpsertMethodAdapter.InsertMethodType(r5);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ InsertOrUpsertMethodAdapter.InsertMethodType invoke(InsertOrUpsertMethodAdapter.ReturnType r5) {
        return invoke2(r5);
    }
}
