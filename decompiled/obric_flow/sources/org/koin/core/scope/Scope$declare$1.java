package org.koin.core.scope;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.koin.core.definition.Kind;
import org.koin.core.instance.d;
import xq.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "invoke"}, k = 3, mv = {1, 9, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Scope.kt\norg/koin/core/scope/Scope$declare$1\n+ 2 InstanceRegistry.kt\norg/koin/core/registry/InstanceRegistry\n+ 3 BeanDefinition.kt\norg/koin/core/definition/BeanDefinitionKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,406:1\n121#2:407\n122#2,8:415\n130#2,3:424\n134#2:428\n112#3,7:408\n1855#4:423\n1856#4:427\n*S KotlinDebug\n*F\n+ 1 Scope.kt\norg/koin/core/scope/Scope$declare$1\n*L\n322#1:407\n322#1:415,8\n322#1:424,3\n322#1:428\n322#1:408,7\n322#1:423\n322#1:427\n*E\n"})
public final class Scope$declare$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $allowOverride;
    final /* synthetic */ Object $instance;
    final /* synthetic */ wu.a $qualifier;
    final /* synthetic */ List<KClass<?>> $secondaryTypes;
    final /* synthetic */ a this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public Scope$declare$1(a r5, Object r10, wu.a r11, List<? extends KClass<?>> r12, boolean r13) {
        this.this$0 = r5;
        this.$instance = r10;
        this.$qualifier = r11;
        this.$secondaryTypes = r12;
        this.$allowOverride = r13;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        a r5 = this.this$0;
        i4.a r10 = r5.d.f21000b;
        final Object r11 = this.$instance;
        wu.a r12 = this.$qualifier;
        List<KClass<?>> r13 = this.$secondaryTypes;
        boolean r14 = this.$allowOverride;
        Kind r15 = Kind.Scoped;
        Intrinsics.needClassReification();
        Function2<a, vu.a, Object> r16 = new Scope$declare$1$invoke$$inlined$declareScopedInstance$1(r11);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass r17 = Reflection.getOrCreateKotlinClass(Object.class);
        wu.a r18 = r5.f21023a;
        org.koin.core.definition.a r19 = new org.koin.core.definition.a(r18, r17, r12, r16, r15, r13);
        String r20 = b.r(r17, r12, r18);
        Object r21 = ((ConcurrentHashMap) r10.d).get(r20);
        if ((r21 instanceof d) == false) goto L5;
        d r22 = (d) r21;
    L6:
        if (r22 == null) goto L8;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Any");
        String r23 = r5.f21024b;
        Intrinsics.checkNotNullParameter(r23, "scopeID");
        Intrinsics.checkNotNullParameter(r11, "instance");
        r22.f21016b.put(r23, r11);
        return;
    L8:
        Intrinsics.checkNotNullParameter(r19, "beanDefinition");
        d r24 = new d(r19);
        r24.f21016b = new HashMap();
        i4.a.x(r10, r14, r20, r24);
        Iterator r25 = r19.f.iterator();
    L10:
        if (r25.hasNext() == false) goto L14;
        i4.a.x(r10, r14, b.r((KClass) r25.next(), r19.f21008c, r19.f21006a), r24);
        goto L10
    L14:
        return;
    L5:
        r22 = null;
        goto L6
    }
}
