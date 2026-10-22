package com.squareup.kotlinpoet;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import javax.lang.model.type.TypeMirror;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, "Ljavax/lang/model/type/TypeMirror;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class FunSpec$Companion$overriding$throwsValueString$1 extends Lambda implements Function1<TypeMirror, CharSequence> {
    public static final FunSpec$Companion$overriding$throwsValueString$1 INSTANCE = null;

    static {
        INSTANCE = new FunSpec$Companion$overriding$throwsValueString$1();
    }

    public FunSpec$Companion$overriding$throwsValueString$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(TypeMirror r5) {
        return "%T::class";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(TypeMirror r5) {
        return invoke2(r5);
    }
}
