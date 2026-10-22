package com.bytedance.android.ad.client.components.settings;

import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.ies.android.base.runtime.network.RequestMethod;
import g37.c;
import g37.d;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class AbsAdSettingsManager implements h37.b {
    public static final /* synthetic */ KProperty[] e = null;
    public final String a;
    public final AtomicBoolean b;
    public final Lazy c;
    public final Lazy d;

    public static final class a implements MessageQueue.IdleHandler {
        public final /* synthetic */ AbsAdSettingsManager a;

        public a(AbsAdSettingsManager r1) {
            this.a = r1;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            AbsAdSettingsManager.d(this.a);
            return false;
        }
    }

    public static final class b implements c {
        public final /* synthetic */ AbsAdSettingsManager a;

        public b(AbsAdSettingsManager r1) {
            this.a = r1;
        }

        public final d create() {
            d.a r0 = new d.a();
            this.a.getClass();
            r0.a = null;
            int r10 = p06.a.a;
            r0.d = null;
            r0.c = this.a;
            return r0.a();
        }
    }

    static {
        e = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AbsAdSettingsManager.class), "mSettingsManager", "getMSettingsManager()Lcom/bytedance/news/common/settings/IndividualManager;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AbsAdSettingsManager.class), "mUrlBuilder", "getMUrlBuilder()Landroid/net/Uri$Builder;"))};
    }

    public String b() {
        return "";
    }

    public abstract void c();

    public final void a() {
        if (this.b.get() == true) goto L20;
        Lazy r0 = this.c;
        KProperty r1 = e[0];
        ((g37.a) r0.getValue()).a = new b(this);
        this.b.set(true);
        Looper r10 = Looper.getMainLooper();
        if (Build.VERSION.SDK_INT < 23) goto L18;
        MessageQueue r11 = r10.getQueue();
    L14:
        if (r11 == null) goto L16;
        r11.addIdleHandler(new a(this));
        return;
    L16:
        d(this);
        return;
    L18:
        Field r12 = r10.getClass().getDeclaredField("mQueue");     // Catch: Throwable -> L13
        r12.setAccessible(true);     // Catch: Throwable -> L13
        Object r13 = r12.get(r10);     // Catch: Throwable -> L13
        if ((r13 instanceof MessageQueue) == true) goto L11;
        r13 = null;
    L11:
        r11 = (MessageQueue) r13;     // Catch: Throwable -> L13
    L13:
        r11 = null;
        goto L14
    }

    public final h37.c request() {
        h37.c r0 = new h37.c();
        Lazy r1 = this.d;
        KProperty r10 = e[1];
        ((Uri.Builder) r1.getValue()).build().toString();
        RequestMethod r11 = RequestMethod.GET;
        return r0;
    }

    public AbsAdSettingsManager() {
        this.a = "https://is.snssdk.com/service/settings/v3/";
        this.b = new AtomicBoolean(false);
        this.c = LazyKt.lazy(new AbsAdSettingsManager$mSettingsManager$2(this));
        this.d = LazyKt.lazy(new AbsAdSettingsManager$mUrlBuilder$2(this));
    }

    public static void d(AbsAdSettingsManager r10) {
        r10.a();
        if (r10.b.get() == false) goto L6;
        Lazy r11 = r10.c;
        KProperty r0 = e[0];
        ((g37.a) r11.getValue()).e(true);
        return;
    }
}
