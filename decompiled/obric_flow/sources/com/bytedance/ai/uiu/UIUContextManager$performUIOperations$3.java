package com.bytedance.ai.uiu;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager", f = "UIUContextManager.kt", i = {}, l = {260}, m = "performUIOperations", n = {}, s = {})
final class UIUContextManager$performUIOperations$3 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2817b;

    public UIUContextManager$performUIOperations$3(ContinuationImpl r5) {
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2816a = r5;
        this.f2817b |= Integer.MIN_VALUE;
        return c.b(null, null, this);
    }
}
