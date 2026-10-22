package com.bytedance.ai.uiu;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager", f = "UIUContextManager.kt", i = {}, l = {231}, m = "getPageUIContext", n = {}, s = {})
final class UIUContextManager$getPageUIContext$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2795b;

    public UIUContextManager$getPageUIContext$1(ContinuationImpl r5) {
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2794a = r5;
        this.f2795b |= Integer.MIN_VALUE;
        return c.c(null, this);
    }
}
