package androidx.room.compiler.processing.ksp;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.google.devtools.ksp.symbol.ClassKind;
import il.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000b\u0010\u0002\u001a\u00070\u0000¢\u0006\u0002\b\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lil/c;", "Lkotlin/internal/NoInfer;", ST.IMPLICIT_ARG_NAME, "", "invoke", "(Lil/c;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class KspAnnotationValueKt$unwrap$unwrap$valueDeclaration$1 extends Lambda implements Function1<c, Boolean> {
    public static final KspAnnotationValueKt$unwrap$unwrap$valueDeclaration$1 INSTANCE = null;

    static {
        INSTANCE = new KspAnnotationValueKt$unwrap$unwrap$valueDeclaration$1();
    }

    public KspAnnotationValueKt$unwrap$unwrap$valueDeclaration$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(c r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        if (r5.b() != ClassKind.ENUM_ENTRY) goto L5;
        boolean r10 = true;
    L7:
        return Boolean.valueOf(r10);
    L5:
        r10 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(c r5) {
        j0.A(r5);
        return invoke2(null);
    }
}
