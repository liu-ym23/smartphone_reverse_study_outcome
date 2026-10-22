package com.obric.widget.host;

import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/widget/host/WidgetLogcatPerfReporter;", "Lcom/obric/widget/host/WidgetPerfReporter;", "tag", "", "<init>", "(Ljava/lang/String;)V", "isEnabled", "", "report", "", "event", "Lcom/obric/widget/host/WidgetPerfEvent;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetPerfReporter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetPerfReporter.kt\ncom/obric/widget/host/WidgetLogcatPerfReporter\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,57:1\n216#2,2:58\n*S KotlinDebug\n*F\n+ 1 WidgetPerfReporter.kt\ncom/obric/widget/host/WidgetLogcatPerfReporter\n*L\n47#1:58,2\n*E\n"})
public final class WidgetLogcatPerfReporter implements WidgetPerfReporter {
    private final String tag;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetLogcatPerfReporter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.obric.widget.host.WidgetPerfReporter
    public boolean isEnabled() {
        return true;
    }

    @Override // com.obric.widget.host.WidgetPerfReporter
    public void report(WidgetPerfEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        String r10 = this.tag;
        StringBuilder r11 = new StringBuilder("name=");
        r11.append(r5.getName());
        r11.append(", hostId=");
        r11.append(r5.getHostId());
        WidgetInstanceKey r12 = r5.getKey();
        if (r12 == null) goto L5;
        r11.append(", appletId=");
        r11.append(r12.getAppletId());
        r11.append(", widgetId=");
        r11.append(r12.getWidgetId());
        r11.append(", instanceId=");
        r11.append(r12.getInstanceId());
    L5:
        r11.append(", timestampMs=");
        r11.append(r5.getTimestampMs());
        Iterator<Map.Entry<String, Object>> r13 = r5.getValues().entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry<String, Object> r14 = r13.next();
        String r15 = r14.getKey();
        Object r16 = r14.getValue();
        r11.append(", ");
        r11.append(r15);
        r11.append('=');
        r11.append(r16);
        goto L7
    L9:
        Log.i(r10, r11.toString());
    }

    public WidgetLogcatPerfReporter(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        this.tag = r5;
    }

    public /* synthetic */ WidgetLogcatPerfReporter(String r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = "OWidgetPerf";
    L5:
        this(r5);
    }
}
