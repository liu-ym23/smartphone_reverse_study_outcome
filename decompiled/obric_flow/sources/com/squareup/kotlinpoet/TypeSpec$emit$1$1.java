package com.squareup.kotlinpoet;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/squareup/kotlinpoet/s;", "param", "", "invoke", "(Lcom/squareup/kotlinpoet/s;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class TypeSpec$emit$1$1 extends Lambda implements Function1<s, Unit> {
    final /* synthetic */ f $codeWriter;
    final /* synthetic */ Map<String, w> $constructorProperties;

    public TypeSpec$emit$1$1(Map<String, w> r5, f r10) {
        this.$constructorProperties = r5;
        this.$codeWriter = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(s r5) {
        invoke2(r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(s r5) {
        Intrinsics.checkNotNullParameter(r5, "param");
        w r10 = this.$constructorProperties.get(r5.f15192a);
        if (r10 == null) goto L5;
        w.b(r10, this.$codeWriter, SetsKt.setOf(KModifier.PUBLIC), true, 8);
        Intrinsics.checkNotNullParameter(this.$codeWriter, "codeWriter");
        return;
    L5:
        s.a(r5, this.$codeWriter, false, true, 2);
    }
}
