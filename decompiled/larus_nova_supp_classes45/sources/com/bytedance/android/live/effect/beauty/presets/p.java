package com.bytedance.android.live.effect.beauty.presets;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p implements Runnable {
    public final /* synthetic */ LiveBeautyPresetsHelper a;
    public final /* synthetic */ q b;

    public static final class a implements Runnable {
        public final /* synthetic */ p a;

        public a(p r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p r0 = this.a;     // Catch: Throwable -> L6
            q r1 = r0.b;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.onSuccess(r0.a.a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ p a;
        public final /* synthetic */ Exception b;

        public b(p r1, Exception r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r0 = this.a.b;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.onError(this.b.getMessage());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public p(LiveBeautyPresetsHelper r1, LiveBeautyPresetsFragment.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ((ArrayList) this.a.a).clear();     // Catch: Exception -> L14
        LiveBeautyPresetsHelper r0 = this.a;     // Catch: Exception -> L14
        ((ArrayList) r0.a).addAll(r0.l());     // Catch: Exception -> L14
        LiveBeautyPresetsHelper r1 = this.a;     // Catch: Exception -> L14
        Iterator<T> r2 = r1.a.iterator();     // Catch: Exception -> L14
    L3:
        Map<String, List<PresetEffect>> r3 = null;
        if (r2.hasNext() == false) goto L8;
        Object r4 = r2.next();     // Catch: Exception -> L14
        if (Intrinsics.areEqual(((BeautifyPreset) r4).getPresetId(), this.a.j()) == false) goto L3;
    L9:
        BeautifyPreset r5 = (BeautifyPreset) r4;     // Catch: Exception -> L14
        if (r5 == null) goto L12;
        r3 = r5.getEffectsByPanel();     // Catch: Exception -> L14
    L12:
        r1.c = r3;     // Catch: Exception -> L14
        AndroidSchedulers.mainThread().scheduleDirect(new a(this));     // Catch: Exception -> L14
        return;
    L8:
        r4 = null;
    L14:
        e = move-exception;
        AndroidSchedulers.mainThread().scheduleDirect(new b(this, e));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
