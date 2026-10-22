package com.bytedance.ai.widget.contianer;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.contianer.AppletWidgetContainer", f = "AppletWidgetContainer.kt", i = {0}, l = {681}, m = "bindDataByType", n = {"this"}, s = {"L$0"})
final class AppletWidgetContainer$bindDataByType$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppletWidgetContainer f3004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppletWidgetContainer f3006c;
    public int d;

    public AppletWidgetContainer$bindDataByType$1(AppletWidgetContainer r5, ContinuationImpl r10) {
        this.f3006c = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f3005b = r5;
        this.d |= Integer.MIN_VALUE;
        return this.f3006c.q(null, null, this);
    }
}
