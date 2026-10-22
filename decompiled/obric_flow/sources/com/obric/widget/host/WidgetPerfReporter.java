package com.obric.widget.host;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/obric/widget/host/WidgetPerfReporter;", "", "isEnabled", "", "report", "", "event", "Lcom/obric/widget/host/WidgetPerfEvent;", "Companion", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface WidgetPerfReporter {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/widget/host/WidgetPerfReporter$Companion;", "", "<init>", "()V", "NO_OP", "Lcom/obric/widget/host/WidgetPerfReporter;", "getNO_OP", "()Lcom/obric/widget/host/WidgetPerfReporter;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final WidgetPerfReporter NO_OP = null;

        static {
            $$INSTANCE = new Companion();
            NO_OP = new WidgetPerfReporter$Companion$NO_OP$1();
        }

        private Companion() {
        }

        public final WidgetPerfReporter getNO_OP() {
            return NO_OP;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isEnabled(WidgetPerfReporter r5) {
            return false;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean isEnabled();

    void report(WidgetPerfEvent r5);
}
