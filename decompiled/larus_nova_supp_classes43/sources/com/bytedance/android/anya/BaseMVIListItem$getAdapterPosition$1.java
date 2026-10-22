package com.bytedance.android.anya;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/anya/MVIState;", "STATE", "Lcom/bytedance/android/anya/p;", "ACTION", "", "invoke", "()I", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final /* synthetic */ class BaseMVIListItem$getAdapterPosition$1 extends FunctionReference implements Function0<Integer> {
    public BaseMVIListItem$getAdapterPosition$1(BaseMVIListItem r10) {
        super(0, r10);
    }

    public final String getName() {
        return "defaultPosition";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BaseMVIListItem.class);
    }

    public final String getSignature() {
        return "defaultPosition()I";
    }

    public final int invoke() {
        ((BaseMVIListItem) ((CallableReference) this).receiver).getClass();
        return -1;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m442invoke() {
        return Integer.valueOf(invoke());
    }
}
