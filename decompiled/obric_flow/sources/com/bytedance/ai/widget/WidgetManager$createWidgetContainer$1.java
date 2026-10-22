package com.bytedance.ai.widget;

import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.WidgetManager", f = "WidgetManager.kt", i = {0}, l = {516}, m = "createWidgetContainer", n = {"widgetContainer"}, s = {"L$0"})
final class WidgetManager$createWidgetContainer$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppletWidgetContainer f2922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f2924c;
    public int d;

    public WidgetManager$createWidgetContainer$1(o r5, ContinuationImpl r10) {
        this.f2924c = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2923b = r5;
        this.d |= Integer.MIN_VALUE;
        o r10 = this.f2924c;
        l r11 = o.f3079j;
        return r10.f(null, this);
    }
}
