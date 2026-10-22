package com.ss.android.lark.framework.larkwidget;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0007J.\u0010\u0018\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00190\rH\u0007J&\u0010\u001d\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0015\u001a\u00020\u00062\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00190\rH\u0007J \u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00062\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\rH\u0007J\u0015\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u0010!J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020 J\u0010\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0015\u001a\u00020\u0006J\u0016\u0010#\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020$J\u0015\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u0010'J\u0016\u0010%\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020&J\u0015\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u0010*J\u0016\u0010(\u001a\u00020)2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020)J\u0015\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u0010-J\u0016\u0010+\u001a\u00020,2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020,J\u0015\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u00100J\u0016\u0010.\u001a\u00020/2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020/J\u0015\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u00103J\u0016\u00101\u001a\u0002022\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u000202J\u0015\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u00106J\u0016\u00104\u001a\u0002052\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\"\u001a\u000205J)\u00107\u001a\u0004\u0018\u0001H\u0019\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0015\u001a\u00020\u00062\f\u00108\u001a\b\u0012\u0004\u0012\u0002H\u001909¢\u0006\u0002\u0010:J \u00107\u001a\u0004\u0018\u0001H\u0019\"\u0006\b\u0000\u0010\u0019\u0018\u00012\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\b¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\u0012H\u0002R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/ss/android/lark/framework/larkwidget/WidgetSharedData;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "dataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getDataMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "liveDataMap", "", "Landroidx/lifecycle/MutableLiveData;", "rawObserverToTypeSafeObserver", "Landroidx/lifecycle/Observer;", "Lcom/ss/android/lark/framework/larkwidget/TypeSafeObserver;", "handler", "Landroid/os/Handler;", "putData", "", "bundle", "Landroid/os/Bundle;", TabAppInfo.IMAGE_JSON_KEY, "data", "postData", "observe", "T", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "observeForever", "removeObserver", "getBoolean", "", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "defaultValue", "getString", "", "getInt", "", "(Ljava/lang/Object;)Ljava/lang/Integer;", "getLong", "", "(Ljava/lang/Object;)Ljava/lang/Long;", "getFloat", "", "(Ljava/lang/Object;)Ljava/lang/Float;", "getDouble", "", "(Ljava/lang/Object;)Ljava/lang/Double;", "getShort", "", "(Ljava/lang/Object;)Ljava/lang/Short;", "getByte", "", "(Ljava/lang/Object;)Ljava/lang/Byte;", "getObject", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", "assertMainThread", "lark-widget_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class WidgetSharedData extends ViewModel {
    private final ConcurrentHashMap<Object, Object> dataMap;
    private final Handler handler;
    private final Map<Object, MutableLiveData<Object>> liveDataMap;
    private final ConcurrentHashMap<Observer<?>, TypeSafeObserver<?>> rawObserverToTypeSafeObserver;

    public static final class a implements Runnable {
        public final /* synthetic */ WidgetSharedData a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public a(WidgetSharedData r1, Object r2, Object r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.putData(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public WidgetSharedData() {
        this.dataMap = new ConcurrentHashMap();
        this.liveDataMap = new LinkedHashMap();
        this.rawObserverToTypeSafeObserver = new ConcurrentHashMap();
        this.handler = new Handler(Looper.getMainLooper());
    }

    private final void assertMainThread() {
        Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));
    }

    public final ConcurrentHashMap<Object, Object> getDataMap() {
        return this.dataMap;
    }

    public final Boolean getBoolean(Object r3) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((r4 instanceof Boolean) == true) goto L8;
        return null;
    L8:
        return (Boolean) r4;
    }

    public final Byte getByte(Object r3) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((r4 instanceof Byte) == true) goto L8;
        return null;
    L8:
        return (Byte) r4;
    }

    public final Double getDouble(Object r3) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((r4 instanceof Double) == true) goto L8;
        return null;
    L8:
        return (Double) r4;
    }

    public final Float getFloat(Object r3) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((r4 instanceof Float) == true) goto L8;
        return null;
    L8:
        return (Float) r4;
    }

    public final Integer getInt(Object r3) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((r4 instanceof Integer) == true) goto L8;
        return null;
    L8:
        return (Integer) r4;
    }

    public final Long getLong(Object r3) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((r4 instanceof Long) == true) goto L8;
        return null;
    L8:
        return (Long) r4;
    }

    public final /* synthetic */ <T> T getObject(Object r3) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        T r4 = (T) getDataMap().get(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        Intrinsics.reifiedOperationMarker(2, "T");
        return r4;
    }

    public final Short getShort(Object r3) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((r4 instanceof Short) == true) goto L8;
        return null;
    L8:
        return (Short) r4;
    }

    public final String getString(Object r3) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((r4 instanceof String) == true) goto L8;
        return null;
    L8:
        return (String) r4;
    }

    public final void putData(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "bundle");
        assertMainThread();
        Iterator<String> r0 = r4.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = r0.next();
        Intrinsics.checkNotNull(r1);
        putData(r1, r4.get(r1));
        goto L4
    }

    public final boolean getBoolean(Object r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r2);
        if (r4 != null) goto L6;
        return r3;
    L6:
        if ((r4 instanceof Boolean) == true) goto L8;
        return r3;
    L8:
        return ((Boolean) r4).booleanValue();
    }

    public final byte getByte(Object r2, byte r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r2);
        if (r4 != null) goto L6;
        return r3;
    L6:
        if ((r4 instanceof Byte) == true) goto L8;
        return r3;
    L8:
        return ((Number) r4).byteValue();
    }

    public final double getDouble(Object r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r2);
        if (r4 != null) goto L6;
        return r3;
    L6:
        if ((r4 instanceof Double) == true) goto L8;
        return r3;
    L8:
        return ((Number) r4).doubleValue();
    }

    public final float getFloat(Object r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r2);
        if (r4 != null) goto L6;
        return r3;
    L6:
        if ((r4 instanceof Float) == true) goto L8;
        return r3;
    L8:
        return ((Number) r4).floatValue();
    }

    public final int getInt(Object r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r2);
        if (r4 != null) goto L6;
        return r3;
    L6:
        if ((r4 instanceof Integer) == true) goto L8;
        return r3;
    L8:
        return ((Number) r4).intValue();
    }

    public final long getLong(Object r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r2);
        if (r4 != null) goto L6;
        return r3;
    L6:
        if ((r4 instanceof Long) == true) goto L8;
        return r3;
    L8:
        return ((Number) r4).longValue();
    }

    public final <T> T getObject(Object r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "clazz");
        T r4 = (T) this.dataMap.get(r2);
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r3.isInstance(r4) == false) goto L9;
        return r4;
    L9:
        return null;
    }

    public final short getShort(Object r2, short r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Object r4 = this.dataMap.get(r2);
        if (r4 != null) goto L6;
        return r3;
    L6:
        if ((r4 instanceof Short) == true) goto L8;
        return r3;
    L8:
        return ((Number) r4).shortValue();
    }

    public final String getString(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        Object r4 = this.dataMap.get(r2);
        if (r4 != null) goto L6;
        return r3;
    L6:
        if ((r4 instanceof String) == true) goto L8;
        return r3;
    L8:
        return (String) r4;
    }

    public final <T> void observeForever(Object r3, Observer<T> r4) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r4, "observer");
        assertMainThread();
        if (this.rawObserverToTypeSafeObserver.contains(r4) == false) goto L5;
        return;
    L5:
        TypeSafeObserver<?> r0 = new TypeSafeObserver(r4);
        this.rawObserverToTypeSafeObserver.put(r4, r0);
        MutableLiveData<Object> r5 = this.liveDataMap.get(r3);
        if (r5 != null) goto L8;
        r5 = new MutableLiveData();
        this.liveDataMap.put(r3, r5);
    L8:
        r5.observeForever(r0);
    }

    public final void postData(Object r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        this.handler.post(new a(this, r3, r4));
    }

    public final void putData(Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        assertMainThread();
        this.dataMap.put(r2, r3);
        MutableLiveData<Object> r4 = this.liveDataMap.get(r2);
        if (r4 == null) goto L6;
        r4.setValue(r3);
        return;
    }

    public final void removeObserver(Object r2, Observer<Object> r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "observer");
        assertMainThread();
        TypeSafeObserver<?> r4 = this.rawObserverToTypeSafeObserver.remove(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        MutableLiveData<Object> r5 = this.liveDataMap.get(r2);
        if (r5 == null) goto L9;
        r5.removeObserver(r4);
        return;
    }

    public final <T> void observe(Object r3, LifecycleOwner r4, Observer<T> r5) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "observer");
        assertMainThread();
        if (this.rawObserverToTypeSafeObserver.contains(r5) == false) goto L5;
        return;
    L5:
        TypeSafeObserver<?> r0 = new TypeSafeObserver(r5);
        this.rawObserverToTypeSafeObserver.put(r5, r0);
        MutableLiveData<Object> r6 = this.liveDataMap.get(r3);
        if (r6 != null) goto L8;
        r6 = new MutableLiveData();
        this.liveDataMap.put(r3, r6);
    L8:
        r6.observe(r4, r0);
    }
}
