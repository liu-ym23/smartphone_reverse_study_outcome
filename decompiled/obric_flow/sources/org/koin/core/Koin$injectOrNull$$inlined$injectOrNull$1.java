package org.koin.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()Ljava/lang/Object;", "org/koin/core/scope/Scope$injectOrNull$1"}, k = 3, mv = {1, 9, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Scope.kt\norg/koin/core/scope/Scope$injectOrNull$1\n+ 2 Scope.kt\norg/koin/core/scope/Scope\n*L\n1#1,406:1\n160#2:407\n*S KotlinDebug\n*F\n+ 1 Scope.kt\norg/koin/core/scope/Scope$injectOrNull$1\n*L\n124#1:407\n*E\n"})
public final class Koin$injectOrNull$$inlined$injectOrNull$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ Function0 $parameters;
    final /* synthetic */ wu.a $qualifier;
    final /* synthetic */ org.koin.core.scope.a this$0;

    public Koin$injectOrNull$$inlined$injectOrNull$1(org.koin.core.scope.a r5, wu.a r10, Function0 r11) {
        this.this$0 = r5;
        this.$qualifier = r10;
        this.$parameters = r11;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        org.koin.core.scope.a r5 = this.this$0;
        wu.a r10 = this.$qualifier;
        Function0 r11 = this.$parameters;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return r5.c(r11, Reflection.getOrCreateKotlinClass(Object.class), r10);
    }
}
