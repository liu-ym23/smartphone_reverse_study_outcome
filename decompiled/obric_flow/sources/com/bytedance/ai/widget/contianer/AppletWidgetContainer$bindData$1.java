package com.bytedance.ai.widget.contianer;

import com.bytedance.ai.model.objects.Widget;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.contianer.AppletWidgetContainer", f = "AppletWidgetContainer.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {535, 562, 565, 583}, m = "bindData", n = {"this", "widgetContainerData", "resourceLoader", "this", "widgetContainerData", "resourceLoader", "widgetInfo", "this", "widgetContainerData", "resourceLoader", "widgetInfo"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class AppletWidgetContainer$bindData$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppletWidgetContainer f2998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f2999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ai.widget.cache.b f3000c;
    public Widget d;
    public /* synthetic */ Object e;
    public final /* synthetic */ AppletWidgetContainer f;
    public int g;

    public AppletWidgetContainer$bindData$1(AppletWidgetContainer r5, ContinuationImpl r10) {
        this.f = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.e = r5;
        this.g |= Integer.MIN_VALUE;
        return this.f.r(null, this);
    }
}
