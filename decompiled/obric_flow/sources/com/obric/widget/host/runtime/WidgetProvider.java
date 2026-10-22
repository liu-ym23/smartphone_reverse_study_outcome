package com.obric.widget.host.runtime;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001)B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J#\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0015\u0010\u0019\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0016J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000eJ\u001b\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 0\u0018J\u0006\u0010!\u001a\u00020\u000eJ\u0006\u0010\"\u001a\u00020\u001bJ(\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\f0(R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetProvider;", ExifInterface.GPS_DIRECTION_TRUE, "", "hostId", "", "<init>", "(Ljava/lang/String;)V", "hostViewRegistry", "Lcom/obric/widget/host/runtime/WidgetHostViewRegistry;", "messengerRegistry", "Lcom/obric/widget/host/runtime/WidgetMessengerRegistry;", "registerHost", "", "instanceId", "", "host", "(ILjava/lang/Object;)V", "replaceHostInstanceId", "oldInstanceId", "newInstanceId", "(IILjava/lang/Object;)V", "removeHost", "(I)Ljava/lang/Object;", "clearHosts", "", "findHost", "containsHost", "", "isCurrentHost", "(ILjava/lang/Object;)Z", "activeHosts", "entries", "Lcom/obric/widget/host/runtime/WidgetHostViewRegistry$Entry;", "activeHostCount", "hasHosts", "dispatchDataChanged", "Lcom/obric/widget/host/runtime/WidgetProvider$DataChangedDispatchResult;", "event", "Lcom/obric/widget/host/runtime/WidgetDataChangedEvent;", "deliver", "Lkotlin/Function2;", "DataChangedDispatchResult", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetProvider<T> {
    private final WidgetHostViewRegistry<T> hostViewRegistry;
    private final WidgetMessengerRegistry<T> messengerRegistry;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetProvider$DataChangedDispatchResult;", "", "dispatchCount", "", "visitedHostCount", "deduped", "", "<init>", "(IIZ)V", "getDispatchCount", "()I", "getVisitedHostCount", "getDeduped", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DataChangedDispatchResult {
        private final boolean deduped;
        private final int dispatchCount;
        private final int visitedHostCount;

        public DataChangedDispatchResult(int r5, int r10, boolean r11) {
            this.dispatchCount = r5;
            this.visitedHostCount = r10;
            this.deduped = r11;
        }

        public static /* synthetic */ DataChangedDispatchResult copy$default(DataChangedDispatchResult r5, int r10, int r11, boolean r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = r5.dispatchCount;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = r5.visitedHostCount;
        L9:
            if ((r13 & 4) == 0) goto L12;
            r12 = r5.deduped;
        L12:
            return r5.copy(r10, r11, r12);
        }

        public final int component1() {
            return this.dispatchCount;
        }

        public final int component2() {
            return this.visitedHostCount;
        }

        public final boolean component3() {
            return this.deduped;
        }

        public final DataChangedDispatchResult copy(int r5, int r10, boolean r11) {
            return new DataChangedDispatchResult(r5, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof DataChangedDispatchResult) == true) goto L8;
            return false;
        L8:
            DataChangedDispatchResult r10 = (DataChangedDispatchResult) r5;
            if (this.dispatchCount == r10.dispatchCount) goto L12;
            return false;
        L12:
            if (this.visitedHostCount == r10.visitedHostCount) goto L15;
            return false;
        L15:
            if (this.deduped == r10.deduped) goto L17;
            return false;
        L17:
            return true;
        }

        public final boolean getDeduped() {
            return this.deduped;
        }

        public final int getDispatchCount() {
            return this.dispatchCount;
        }

        public final int getVisitedHostCount() {
            return this.visitedHostCount;
        }

        public int hashCode() {
            int r5 = Integer.hashCode(this.dispatchCount) * 31;
            int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.visitedHostCount, r5, 31);
            return Boolean.hashCode(this.deduped) + r10;
        }

        public String toString() {
            int r5 = this.dispatchCount;
            int r10 = this.visitedHostCount;
            boolean r11 = this.deduped;
            return j0.r(j0.v("DataChangedDispatchResult(dispatchCount=", r5, r10, ", visitedHostCount=", ", deduped="), r11, ")");
        }
    }

    public WidgetProvider(String r5) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        WidgetHostViewRegistry<T> r10 = new WidgetHostViewRegistry(r5);
        this.hostViewRegistry = r10;
        this.messengerRegistry = new WidgetMessengerRegistry(r5, r10);
    }

    public static /* synthetic */ Unit a(Ref.IntRef r5, Function2 r10, Object r11, WidgetDataChangedEvent r12) {
        return dispatchDataChanged$lambda$0(r5, r10, r11, r12);
    }

    private static final Unit dispatchDataChanged$lambda$0(Ref.IntRef r5, Function2 r10, Object r11, WidgetDataChangedEvent r12) {
        Intrinsics.checkNotNullParameter(r5, "$visitedHostCount");
        Intrinsics.checkNotNullParameter(r10, "$deliver");
        Intrinsics.checkNotNullParameter(r11, "host");
        Intrinsics.checkNotNullParameter(r12, "changedEvent");
        r5.element++;
        r10.mo2invoke(r11, r12);
        return Unit.INSTANCE;
    }

    public final int activeHostCount() {
        return this.hostViewRegistry.size();
    }

    public final List<T> activeHosts() {
        return this.hostViewRegistry.views();
    }

    public final List<T> clearHosts() {
        return this.hostViewRegistry.clear();
    }

    public final boolean containsHost(int r5) {
        return this.hostViewRegistry.contains(r5);
    }

    public final DataChangedDispatchResult dispatchDataChanged(WidgetDataChangedEvent r5, final Function2<? super T, ? super WidgetDataChangedEvent, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r10, "deliver");
        final Ref.IntRef r11 = new Ref.IntRef();
        int r12 = this.messengerRegistry.dispatchDataChanged(r5, new c(r11, r10));
        int r13 = r11.element;
        if (r12 != (-1)) goto L5;
        boolean r14 = true;
    L7:
        return new DataChangedDispatchResult(r12, r13, r14);
    L5:
        r14 = false;
        goto L7
    }

    public final List<WidgetHostViewRegistry.Entry<T>> entries() {
        return this.hostViewRegistry.entries();
    }

    public final T findHost(int r5) {
        return this.hostViewRegistry.find(r5);
    }

    public final boolean hasHosts() {
        return this.hostViewRegistry.hasHosts();
    }

    public final boolean isCurrentHost(int r5, T r10) {
        Intrinsics.checkNotNullParameter(r10, "host");
        return this.hostViewRegistry.isCurrent(r5, r10);
    }

    public final void registerHost(int r5, T r10) {
        Intrinsics.checkNotNullParameter(r10, "host");
        this.hostViewRegistry.register(r5, r10);
    }

    public final T removeHost(int r5) {
        return this.hostViewRegistry.remove(r5);
    }

    public final void replaceHostInstanceId(int r5, int r10, T r11) {
        Intrinsics.checkNotNullParameter(r11, "host");
        this.hostViewRegistry.replace(r5, r10, r11);
    }
}
