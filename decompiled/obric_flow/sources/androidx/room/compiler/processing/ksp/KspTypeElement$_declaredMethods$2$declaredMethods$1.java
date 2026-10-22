package androidx.room.compiler.processing.ksp;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import il.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lil/g;", ST.IMPLICIT_ARG_NAME, "", "invoke", "(Lil/g;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class KspTypeElement$_declaredMethods$2$declaredMethods$1 extends Lambda implements Function1<g, Boolean> {
    final /* synthetic */ KspTypeElement this$0;

    public KspTypeElement$_declaredMethods$2$declaredMethods$1(KspTypeElement r5) {
        this.this$0 = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(g r5) {
        j0.A(r5);
        return invoke2(null);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(g r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        r5.getSimpleName();
        throw null;
    }
}
