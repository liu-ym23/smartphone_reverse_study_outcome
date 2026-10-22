package org.koin.core.component;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.koin.androidx.fragment.android.KoinFragmentFactory;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nKoinComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KoinComponent.kt\norg/koin/core/component/KoinComponentKt$inject$1\n+ 2 KoinComponent.kt\norg/koin/core/component/KoinComponentKt\n+ 3 Scope.kt\norg/koin/core/scope/Scope\n+ 4 Koin.kt\norg/koin/core/Koin\n*L\n1#1,64:1\n45#2,2:65\n48#2:68\n136#3:67\n108#4:69\n*S KotlinDebug\n*F\n+ 1 KoinComponent.kt\norg/koin/core/component/KoinComponentKt$inject$1\n*L\n63#1:65,2\n63#1:68\n63#1:67\n63#1:69\n*E\n"})
public final class KoinComponentKt$inject$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ Function0<vu.a> $parameters;
    final /* synthetic */ wu.a $qualifier;
    final /* synthetic */ a $this_inject;

    /* JADX WARN: Multi-variable type inference failed */
    public KoinComponentKt$inject$1(a r5, wu.a r10, Function0<? extends vu.a> r11) {
        this.$this_inject = r5;
        this.$qualifier = r10;
        this.$parameters = r11;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        a r5 = this.$this_inject;
        wu.a r10 = this.$qualifier;
        Function0<vu.a> r11 = this.$parameters;
        org.koin.core.scope.a r12 = ((KoinFragmentFactory) r5).a().f20999a.d;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return r12.b(r11, Reflection.getOrCreateKotlinClass(Object.class), r10);
    }
}
