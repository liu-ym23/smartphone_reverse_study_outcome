package com.bytedance.ai.ex.widget;

import com.bytedance.ai.api.model.view.WidgetEvent;
import kotlin.Metadata;
import w0.m;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/ex/widget/IWidgetLifeObserverDelegate;", "Lw0/m;", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IWidgetLifeObserverDelegate extends m {
    @Override // w0.m
    /* synthetic */ void onDestroy();

    @Override // w0.m
    /* synthetic */ void onEvent(WidgetEvent r5);

    @Override // w0.m
    /* synthetic */ void onPageError();

    @Override // w0.m
    /* synthetic */ void onPageFinish();

    @Override // w0.m
    /* synthetic */ void onPageStart();

    @Override // w0.m
    /* synthetic */ void onStart();
}
