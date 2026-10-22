package com.bytedance.ai.resource;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0, 0, 0, 0}, l = {345, 347, 349}, m = "loadWidget", n = {"this", "packageName", "widgetId", "extraInfo"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class AIManager$loadWidget$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f2493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2495c;
    public Map d;
    public /* synthetic */ Object e;
    public final /* synthetic */ j f;
    public int g;

    public AIManager$loadWidget$1(j r5, ContinuationImpl r10) {
        this.f = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.e = r5;
        this.g |= Integer.MIN_VALUE;
        return this.f.d(null, null, null, this);
    }
}
