package com.obric.widget.host.runtime;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016J\u0015\u0010\u0017\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\tJ\u001b\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016J\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u0016J\u0006\u0010\u001f\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\u0019J\b\u0010!\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetHostViewRegistry;", ExifInterface.GPS_DIRECTION_TRUE, "", "hostId", "", "<init>", "(Ljava/lang/String;)V", "viewsByInstanceId", "Ljava/util/LinkedHashMap;", "", "register", "", "instanceId", "view", "(ILjava/lang/Object;)V", "replace", "oldInstanceId", "newInstanceId", "(IILjava/lang/Object;)V", "remove", "(I)Ljava/lang/Object;", "clear", "", "find", "contains", "", "isCurrent", "(ILjava/lang/Object;)Z", "views", "entries", "Lcom/obric/widget/host/runtime/WidgetHostViewRegistry$Entry;", "size", "hasHosts", "toString", "Entry", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetHostViewRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetHostViewRegistry.kt\ncom/obric/widget/host/runtime/WidgetHostViewRegistry\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,91:1\n126#2:92\n153#2,3:93\n*S KotlinDebug\n*F\n+ 1 WidgetHostViewRegistry.kt\ncom/obric/widget/host/runtime/WidgetHostViewRegistry\n*L\n75#1:92\n75#1:93,3\n*E\n"})
public final class WidgetHostViewRegistry<T> {
    private final String hostId;
    private final LinkedHashMap<Integer, T> viewsByInstanceId;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\u000e\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u000bJ(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetHostViewRegistry$Entry;", ExifInterface.GPS_DIRECTION_TRUE, "", "instanceId", "", "view", "<init>", "(ILjava/lang/Object;)V", "getInstanceId", "()I", "getView", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(ILjava/lang/Object;)Lcom/obric/widget/host/runtime/WidgetHostViewRegistry$Entry;", "equals", "", "other", "hashCode", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Entry<T> {
        private final int instanceId;
        private final T view;

        public Entry(int r5, T r10) {
            Intrinsics.checkNotNullParameter(r10, "view");
            this.instanceId = r5;
            this.view = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Entry copy$default(Entry r5, int r10, Object r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.instanceId;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.view;
        L9:
            return r5.copy(r10, r11);
        }

        public final int component1() {
            return this.instanceId;
        }

        public final T component2() {
            return this.view;
        }

        public final Entry<T> copy(int r5, T r10) {
            Intrinsics.checkNotNullParameter(r10, "view");
            return new Entry(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Entry) == true) goto L8;
            return false;
        L8:
            Entry r10 = (Entry) r5;
            if (this.instanceId == r10.instanceId) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.view, r10.view) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int getInstanceId() {
            return this.instanceId;
        }

        public final T getView() {
            return this.view;
        }

        public int hashCode() {
            int r5 = Integer.hashCode(this.instanceId) * 31;
            return this.view.hashCode() + r5;
        }

        public String toString() {
            return "Entry(instanceId=" + this.instanceId + ", view=" + this.view + ")";
        }
    }

    public WidgetHostViewRegistry(String r5) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        this.hostId = r5;
        this.viewsByInstanceId = new LinkedHashMap();
    }

    public final List<T> clear() {
        LinkedHashMap<Integer, T> r5 = this.viewsByInstanceId;
        monitor-enter(r5);
        List<T> r10 = CollectionsKt.toList(this.viewsByInstanceId.values());     // Catch: Throwable -> L7
        this.viewsByInstanceId.clear();     // Catch: Throwable -> L7
        monitor-exit(r5);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean contains(int r5) {
        LinkedHashMap<Integer, T> r10 = this.viewsByInstanceId;
        monitor-enter(r10);
        boolean r11 = this.viewsByInstanceId.containsKey(Integer.valueOf(r5));     // Catch: Throwable -> L7
        monitor-exit(r10);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final List<Entry<T>> entries() {
        LinkedHashMap<Integer, T> r5 = this.viewsByInstanceId;
        monitor-enter(r5);
        LinkedHashMap<Integer, T> r10 = this.viewsByInstanceId;     // Catch: Throwable -> L9
        ArrayList r11 = new ArrayList(r10.size());     // Catch: Throwable -> L9
        Iterator<Map.Entry<Integer, T>> r12 = r10.entrySet().iterator();     // Catch: Throwable -> L9
    L6:
        if (r12.hasNext() == false) goto L11;
        Map.Entry<Integer, T> r13 = r12.next();     // Catch: Throwable -> L9
        r11.add(new Entry(r13.getKey().intValue(), r13.getValue()));     // Catch: Throwable -> L9
        goto L6
    L11:
        monitor-exit(r5);
        return r11;
    L9:
        th = move-exception;
        throw th;
    }

    public final T find(int r5) {
        LinkedHashMap<Integer, T> r10 = this.viewsByInstanceId;
        monitor-enter(r10);
        T r11 = this.viewsByInstanceId.get(Integer.valueOf(r5));     // Catch: Throwable -> L7
        monitor-exit(r10);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean hasHosts() {
        if (size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isCurrent(int r5, T r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        LinkedHashMap<Integer, T> r11 = this.viewsByInstanceId;
        monitor-enter(r11);
        if (this.viewsByInstanceId.get(Integer.valueOf(r5)) != r10) goto L7;
        boolean r12 = true;
    L8:
        monitor-exit(r11);
        return r12;
    L7:
        r12 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final void register(int r5, T r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        LinkedHashMap<Integer, T> r11 = this.viewsByInstanceId;
        monitor-enter(r11);
        Integer r12 = Integer.valueOf(r5);     // Catch: Throwable -> L7
        this.viewsByInstanceId.put(r12, r10);     // Catch: Throwable -> L7
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final T remove(int r5) {
        LinkedHashMap<Integer, T> r10 = this.viewsByInstanceId;
        monitor-enter(r10);
        T r11 = this.viewsByInstanceId.remove(Integer.valueOf(r5));     // Catch: Throwable -> L7
        monitor-exit(r10);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final void replace(int r5, int r10, T r11) {
        Intrinsics.checkNotNullParameter(r11, "view");
        LinkedHashMap<Integer, T> r12 = this.viewsByInstanceId;
        monitor-enter(r12);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.viewsByInstanceId.get(Integer.valueOf(r5)) != r11) goto L9;
        this.viewsByInstanceId.remove(Integer.valueOf(r5));     // Catch: Throwable -> L7
    L9:
        Integer r13 = Integer.valueOf(r10);     // Catch: Throwable -> L7
        this.viewsByInstanceId.put(r13, r11);     // Catch: Throwable -> L7
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r12);
    }

    public final int size() {
        LinkedHashMap<Integer, T> r5 = this.viewsByInstanceId;
        monitor-enter(r5);
        int r10 = this.viewsByInstanceId.size();     // Catch: Throwable -> L7
        monitor-exit(r5);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return "WidgetHostViewRegistry(hostId=" + this.hostId + ", size=" + size() + ")";
    }

    public final List<T> views() {
        LinkedHashMap<Integer, T> r5 = this.viewsByInstanceId;
        monitor-enter(r5);
        List<T> r10 = CollectionsKt.toList(this.viewsByInstanceId.values());     // Catch: Throwable -> L7
        monitor-exit(r5);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }
}
