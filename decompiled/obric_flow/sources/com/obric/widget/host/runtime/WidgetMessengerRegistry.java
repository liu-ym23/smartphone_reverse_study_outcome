package com.obric.widget.host.runtime;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u0014*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0014B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000fJ\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\f\u0010\u0013\u001a\u00020\u0004*\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetMessengerRegistry;", ExifInterface.GPS_DIRECTION_TRUE, "", "hostId", "", "hostViews", "Lcom/obric/widget/host/runtime/WidgetHostViewRegistry;", "<init>", "(Ljava/lang/String;Lcom/obric/widget/host/runtime/WidgetHostViewRegistry;)V", "lastDataChangedKey", "dispatchDataChanged", "", "event", "Lcom/obric/widget/host/runtime/WidgetDataChangedEvent;", "deliver", "Lkotlin/Function2;", "", "clearDataChangedDedupe", "toString", "dedupeKey", "Companion", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetMessengerRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetMessengerRegistry.kt\ncom/obric/widget/host/runtime/WidgetMessengerRegistry\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n1863#2,2:66\n*S KotlinDebug\n*F\n+ 1 WidgetMessengerRegistry.kt\ncom/obric/widget/host/runtime/WidgetMessengerRegistry\n*L\n32#1:66,2\n*E\n"})
public final class WidgetMessengerRegistry<T> {
    public static final Companion Companion = null;
    public static final int DISPATCH_DEDUPED = -1;
    private final String hostId;
    private final WidgetHostViewRegistry<T> hostViews;
    private volatile String lastDataChangedKey;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetMessengerRegistry$Companion;", "", "<init>", "()V", "DISPATCH_DEDUPED", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WidgetMessengerRegistry(String r5, WidgetHostViewRegistry<T> r10) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        Intrinsics.checkNotNullParameter(r10, "hostViews");
        this.hostId = r5;
        this.hostViews = r10;
    }

    private final String dedupeKey(WidgetDataChangedEvent r10) {
        StringBuilder r11 = new StringBuilder();
        String r5 = r10.getAppletId();
        String r12 = "";
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r11.append(r5);
        r11.append('|');
        String r13 = r10.getWidgetId();
        if (r13 != null) goto L8;
        r13 = "";
    L8:
        r11.append(r13);
        r11.append('|');
        r11.append(r10.getInstanceId());
        r11.append('|');
        r11.append(r10.getHostId());
        r11.append('|');
        String r14 = r10.getReason();
        if (r14 == null) goto L12;
        r12 = r14;
    L12:
        r11.append(r12);
        r11.append('|');
        Long r15 = r10.getDataVersion();
        long r16 = -1;
        if (r15 == null) goto L15;
        long r17 = r15.longValue();
    L16:
        r11.append(r17);
        r11.append('|');
        Long r18 = r10.getUpdatedAt();
        if (r18 == null) goto L19;
        r16 = r18.longValue();
    L19:
        r11.append(r16);
        return r11.toString();
    L15:
        r17 = -1;
        goto L16
    }

    public final void clearDataChangedDedupe() {
        this.lastDataChangedKey = null;
    }

    public final int dispatchDataChanged(WidgetDataChangedEvent r5, Function2<? super T, ? super WidgetDataChangedEvent, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r10, "deliver");
        String r11 = dedupeKey(r5);
        if (Intrinsics.areEqual(this.lastDataChangedKey, r11) == false) goto L6;
        return -1;
    L6:
        this.lastDataChangedKey = r11;
        List<T> r12 = this.hostViews.views();
        Iterator<T> r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L11;
        r10.mo2invoke(r13.next(), r5);
        goto L8
    L11:
        return r12.size();
    }

    public String toString() {
        return "WidgetMessengerRegistry(hostId=" + this.hostId + ", activeHosts=" + this.hostViews.size() + ")";
    }
}
