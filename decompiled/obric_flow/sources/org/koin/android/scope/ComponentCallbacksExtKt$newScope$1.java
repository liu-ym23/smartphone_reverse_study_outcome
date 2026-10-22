package org.koin.android.scope;

import android.content.ComponentCallbacks;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import wn.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/ComponentCallbacks;", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/koin/core/scope/a;", "invoke", "()Lorg/koin/core/scope/a;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
final class ComponentCallbacksExtKt$newScope$1 extends Lambda implements Function0<org.koin.core.scope.a> {
    final /* synthetic */ ComponentCallbacks $this_newScope;

    public ComponentCallbacksExtKt$newScope$1(ComponentCallbacks r5) {
        this.$this_newScope = r5;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ org.koin.core.scope.a invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final org.koin.core.scope.a invoke2() {
        ComponentCallbacks r5 = this.$this_newScope;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ug.a.g(r5).b(h.k(r5), h.l(r5), null);
    }
}
