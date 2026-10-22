package androidx.room.compiler.processing.ksp;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.squareup.javapoet.x;
import il.s;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lil/s;", ST.IMPLICIT_ARG_NAME, "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "invoke", "(Lil/s;)Lcom/squareup/javapoet/x;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class KspMethodType$typeVariableNames$2$1$typeParameterBounds$1 extends Lambda implements Function1<s, x> {
    final /* synthetic */ KspProcessingEnv $env;

    public KspMethodType$typeVariableNames$2$1$typeParameterBounds$1(KspProcessingEnv r5) {
        this.$env = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ x invoke(s r5) {
        return invoke2(r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final x invoke2(s r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        this.$env.getResolver();
        return KSTypeJavaPoetExtKt.asJTypeName(r5, null);
    }
}
