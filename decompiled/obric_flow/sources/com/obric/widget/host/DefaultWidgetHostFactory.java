package com.obric.widget.host;

import android.content.Context;
import com.obric.widget.host.internal.DefaultWidgetHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/widget/host/DefaultWidgetHostFactory;", "Lcom/obric/widget/host/WidgetHostFactory;", "<init>", "()V", "create", "Lcom/obric/widget/host/WidgetHost;", "hostId", "", "context", "Landroid/content/Context;", "contract", "Lcom/obric/widget/host/WidgetHostContract;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultWidgetHostFactory implements WidgetHostFactory {
    public static final DefaultWidgetHostFactory INSTANCE = null;

    static {
        INSTANCE = new DefaultWidgetHostFactory();
    }

    private DefaultWidgetHostFactory() {
    }

    @Override // com.obric.widget.host.WidgetHostFactory
    public WidgetHost create(String r5, Context r10, WidgetHostContract r11) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "contract");
        return new DefaultWidgetHost(r5, r10.getApplicationContext(), r11);
    }
}
