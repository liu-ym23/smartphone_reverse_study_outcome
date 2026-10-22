package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r {
    public final Map<Long, String> a;
    public final List<Object> b;
    public String c;

    public static final class a implements Runnable {
        public final /* synthetic */ r a;

        public a(r r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public r() {
        new CompositeDisposable();
        this.a = new LinkedHashMap();
        this.b = new ArrayList();
        Long r0 = LiveEffectSettings.LIVE_EFFECT_POLLING_INTERACT_INFO_INTERVAL.getValue();
        this.c = "";
        new a(this);
    }
}
