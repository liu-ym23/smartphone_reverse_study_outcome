package com.obric.widget.host;

import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/obric/widget/host/WidgetHostContract;", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "perfReporter", "Lcom/obric/widget/host/WidgetPerfReporter;", "getPerfReporter", "()Lcom/obric/widget/host/WidgetPerfReporter;", "openPage", "", "args", "Landroid/os/Bundle;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface WidgetHostContract {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static CoroutineScope getCoroutineScope(WidgetHostContract r5) {
            return null;
        }

        public static WidgetPerfReporter getPerfReporter(WidgetHostContract r5) {
            return WidgetPerfReporter.Companion.getNO_OP();
        }

        public static boolean openPage(WidgetHostContract r5, Bundle r10) {
            Intrinsics.checkNotNullParameter(r10, "args");
            return false;
        }
    }

    Context getContext();

    CoroutineScope getCoroutineScope();

    WidgetPerfReporter getPerfReporter();

    boolean openPage(Bundle r5);
}
