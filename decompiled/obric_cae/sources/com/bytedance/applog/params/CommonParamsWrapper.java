package com.bytedance.applog.params;

import c4.b;
import c4.m;
import com.bytedance.applog.log.NativeLogWrapper;
import com.bytedance.applog.priority.PriorityWrapper;
import he.i;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class CommonParamsWrapper implements k4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f3774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f3775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f3776d;

    public static final class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommonParamsWrapper f3777c;

        public a(CommonParamsWrapper r8) {
            this.f3777c = r8;
            super(0);
        }

        @Override // c4.b
        public final Object a(Object[] r8) {
            PriorityWrapper.f3781b.b(new Object[0]);
            CommonParamsWrapper r10 = this.f3777c;
            CommonParamsWrapper.c(r10, r10.f3773a);
            return Boolean.TRUE;
        }
    }

    public CommonParamsWrapper(String r8) {
        i.f(r8, "applogHashCode");
        this.f3773a = r8;
        this.f3774b = l6.a.k0("CommonParamsWrapper");
        this.f3775c = new AtomicBoolean(true);
        new HashMap();
        new ConcurrentHashMap();
        this.f3776d = new a(this);
    }

    public static final /* synthetic */ void c(CommonParamsWrapper r8, String r10) {
        r8.nativeInit(r10);
    }

    private final native void nativeBizClear(String r8, String r10);

    private final native String nativeBizGet(String r8, String r10, String r11);

    private final native int nativeBizRemove(String r8, String r10, String r11);

    private final native void nativeBizSet(String r8, String r10, String r11, String r12);

    private final native void nativeBizSetCacheCapability(String r8, String r10, int r11);

    private final native String nativeHandleEvent(String r8, String r10, String r11);

    private final native int nativeInit(String r8);

    private final native int nativeSetRuleConfig(String r8, String r10, String r11);

    @Override // k4.a
    public final void a() {
        a r8 = this.f3776d;
        r8.b(new Object[0]);
        NativeLogWrapper.a();
    }

    @Override // k4.a
    public final String b(String r8, String r10) {
        i.f(r8, "event");
        if (this.f3775c.get() == false) goto L5;
        return "";
    L5:
        if (r10 != null) goto L7;
        r10 = "";
    L7:
        String r11 = nativeHandleEvent(this.f3773a, r8, r10);
        if (r11.length() <= 0) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == false) goto L13;
        List<String> r13 = this.f3774b;
        m.u().h(r13, "event:{} had append some params!!", new Object[]{r8});
    L13:
        return r11;
    L10:
        r12 = false;
        goto L11
    }
}
