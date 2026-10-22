package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class MVIState<STATE extends MVIState<STATE>> {
    public final l<STATE> dynamicStates;
    public volatile int maxVersion;
    public final Set<com.bytedance.android.anya.internal.c<?, ?>> modifiedProperties;
    public volatile Function0<Unit> notifyParentNodeChange;
    public final LinkedHashMap<String, com.bytedance.android.anya.internal.c<?, ?>> properties;
    public final Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> propertyAddedCallback;
    public final Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> propertyChangeCallback;

    public final class a implements l<STATE> {
        public a() {
            new LinkedHashMap();
        }
    }

    public static /* synthetic */ void maxVersion$annotations() {
    }

    public static /* synthetic */ void modifiedProperties$annotations() {
    }

    public static /* synthetic */ void notifyParentNodeChange$annotations() {
    }

    public static /* synthetic */ void properties$annotations() {
    }

    public static /* synthetic */ void propertyAddedCallback$annotations() {
    }

    public static /* synthetic */ void propertyChangeCallback$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void clearModifyState$runtime_release() {
        Iterator<T> r0 = this.modifiedProperties.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.bytedance.android.anya.internal.c r1 = (com.bytedance.android.anya.internal.c) r0.next();
        r1.c = 0;
        if ((r1 instanceof SubStatePropertyImpl) == false) goto L4;
        ((MVIState) ((SubStatePropertyImpl) r1).c()).clearModifyState$runtime_release();
        goto L4
    L8:
        this.modifiedProperties.clear();
        this.maxVersion = 0;
    }

    public String toString() {
        return StringsKt.trimMargin$default("{\n            |\"type\": \"" + Reflection.getOrCreateKotlinClass(getClass()).getQualifiedName() + "\", \n            |\"properties\": [" + CollectionsKt.joinToString$default(this.properties.values(), ",", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null) + "], \n            |\"modified\": [" + CollectionsKt.joinToString$default(this.modifiedProperties, ",", null, null, 0, null, AnonymousClass2.INSTANCE, 30, null) + "]\n            | } ", null, 1, null);
    }

    public MVIState() {
        this.dynamicStates = new a();
        this.properties = new LinkedHashMap();
        this.modifiedProperties = new LinkedHashSet();
        this.maxVersion = -1;
        this.propertyAddedCallback = (Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit>) new MVIState$propertyAddedCallback$1(this);
        this.propertyChangeCallback = (Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit>) new MVIState$propertyChangeCallback$1(this);
    }

    public final <T> v.a<STATE, T, r0<STATE, T>> property(T r10) {
        return new com.bytedance.android.anya.internal.o(new com.bytedance.android.anya.internal.r(r10, this.propertyChangeCallback, this.propertyAddedCallback));
    }

    public final /* synthetic */ <T extends x<T>> v.a<STATE, T, o0<STATE, T>> reflexState(T r10) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return new com.bytedance.android.anya.internal.o(new com.bytedance.android.anya.internal.q(x.class, r10, this.propertyChangeCallback, this.propertyAddedCallback));
    }

    public final <T> com.bytedance.android.anya.internal.r<STATE, T> simplePropertyImpl(T r10) {
        return new com.bytedance.android.anya.internal.r(r10, this.propertyChangeCallback, this.propertyAddedCallback);
    }

    public final /* synthetic */ <T extends MVIState<T>> v.a<STATE, s0<T>, t0<STATE, T>> stateList(List<? extends T> r10) {
        return new com.bytedance.android.anya.internal.o(new com.bytedance.android.anya.internal.u(r10, this.propertyChangeCallback, this.propertyAddedCallback));
    }

    public final <T extends MVIState<T>> com.bytedance.android.anya.internal.u<STATE, T> stateListImpl(List<? extends T> r10) {
        return new com.bytedance.android.anya.internal.u(r10, this.propertyChangeCallback, this.propertyAddedCallback);
    }

    public final /* synthetic */ <T extends MVIState<T>> v.a<STATE, T, u0<STATE, T>> subState(T r10) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return new com.bytedance.android.anya.internal.o(new SubStatePropertyImpl(MVIState.class, r10, this.propertyChangeCallback, this.propertyAddedCallback));
    }

    @Deprecated(message = "try data layer instead.")
    public r toBusinessState(k0<STATE, ?> r10) {
        throw new IllegalStateException("Not implemented!".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final r toBusinessStateImpl(k0<?, ?> r1) {
        return toBusinessState(r1);
    }

    public final <T extends x<T>> com.bytedance.android.anya.internal.q<STATE, T> reflexStateImpl(Class<T> r10, T r11) {
        return new com.bytedance.android.anya.internal.q(r10, r11, this.propertyChangeCallback, this.propertyAddedCallback);
    }

    public final <T extends MVIState<?>> SubStatePropertyImpl<STATE, T> subStateImpl(Class<T> r10, T r11) {
        return new SubStatePropertyImpl(r10, r11, this.propertyChangeCallback, this.propertyAddedCallback);
    }

    public static /* synthetic */ v.a subState$default(MVIState r1, MVIState r10, int r11, Object r12) {
        if (r12 != null) goto L13;
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        Intrinsics.reifiedOperationMarker(4, "T");
        if (r1 == null) goto L11;
        return new com.bytedance.android.anya.internal.o(new SubStatePropertyImpl(MVIState.class, r10, r1.propertyChangeCallback, r1.propertyAddedCallback));
    L11:
        throw new TypeCastException("null cannot be cast to non-null type STATE");
    L13:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subState");
    }

    public static /* synthetic */ SubStatePropertyImpl subStateImpl$default(MVIState r0, Class r1, MVIState r10, int r11, Object r12) {
        if (r12 != null) goto L13;
        if ((r11 & 2) == 0) goto L7;
        r10 = null;
    L7:
        if (r0 == null) goto L11;
        return new SubStatePropertyImpl(r1, r10, r0.propertyChangeCallback, r0.propertyAddedCallback);
    L11:
        throw new TypeCastException("null cannot be cast to non-null type STATE");
    L13:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subStateImpl");
    }
}
