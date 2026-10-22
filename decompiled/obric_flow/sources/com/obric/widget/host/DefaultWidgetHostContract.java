package com.obric.widget.host;

import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/widget/host/DefaultWidgetHostContract;", "Lcom/obric/widget/host/WidgetHostContract;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultWidgetHostContract implements WidgetHostContract {
    private final Context context;

    public DefaultWidgetHostContract(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
    }

    @Override // com.obric.widget.host.WidgetHostContract
    public Context getContext() {
        return this.context;
    }

    @Override // com.obric.widget.host.WidgetHostContract
    public CoroutineScope getCoroutineScope() {
        return WidgetHostContract.DefaultImpls.getCoroutineScope(this);
    }

    @Override // com.obric.widget.host.WidgetHostContract
    public WidgetPerfReporter getPerfReporter() {
        return WidgetHostContract.DefaultImpls.getPerfReporter(this);
    }

    @Override // com.obric.widget.host.WidgetHostContract
    public boolean openPage(Bundle r5) {
        return WidgetHostContract.DefaultImpls.openPage(this, r5);
    }
}
