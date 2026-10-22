package com.bytedance.ai.resource;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0, 0, 0}, l = {211, 213, 215}, m = "loadApplet", n = {"this", "appletId", "extraInfo"}, s = {"L$0", "L$1", "L$2"})
final class AIManager$loadApplet$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f2488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f2490c;
    public /* synthetic */ Object d;
    public final /* synthetic */ j e;
    public int f;

    public AIManager$loadApplet$1(j r5, ContinuationImpl r10) {
        this.e = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.d = r5;
        this.f |= Integer.MIN_VALUE;
        return this.e.f(null, null, this);
    }
}
