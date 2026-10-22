package com.ss.android.lark.forseti.chain;

import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final /* synthetic */ class ForsetiChainHelper$saveForsetiNodeWidthIfNeed$3 extends FunctionReferenceImpl implements Function0<ForsetiWidth> {
    public ForsetiChainHelper$saveForsetiNodeWidthIfNeed$3(Object r8) {
        super(0, r8, com.ss.android.lark.forseti.util.dragging.d.class, "getLeftForsetiNodeWidth", "getLeftForsetiNodeWidth()Lcom/ss/android/lark/api/bean/ForsetiWidth;", 0);
    }

    public final ForsetiWidth invoke() {
        ((com.ss.android.lark.forseti.util.dragging.d) ((CallableReference) this).receiver).getClass();
        return com.ss.android.lark.forseti.util.dragging.d.b;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m550invoke() {
        return invoke();
    }
}
