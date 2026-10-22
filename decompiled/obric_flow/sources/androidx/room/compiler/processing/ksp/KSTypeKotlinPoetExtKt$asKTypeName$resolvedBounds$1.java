package androidx.room.compiler.processing.ksp;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.squareup.kotlinpoet.a0;
import hl.d;
import il.i;
import il.s;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lil/s;", ST.IMPLICIT_ARG_NAME, "Lcom/squareup/kotlinpoet/a0;", "Lcom/squareup/kotlinpoet/javapoet/KTypeName;", "invoke", "(Lil/s;)Lcom/squareup/kotlinpoet/a0;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class KSTypeKotlinPoetExtKt$asKTypeName$resolvedBounds$1 extends Lambda implements Function1<s, a0> {
    final /* synthetic */ d $resolver;
    final /* synthetic */ LinkedHashMap<i, a0> $typeArgumentTypeLookup;

    public KSTypeKotlinPoetExtKt$asKTypeName$resolvedBounds$1(d r5, LinkedHashMap<i, a0> r10) {
        this.$typeArgumentTypeLookup = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ a0 invoke(s r5) {
        return invoke2(r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final a0 invoke2(s r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        return KSTypeKotlinPoetExtKt.access$asKTypeName(r5, null, this.$typeArgumentTypeLookup);
    }
}
