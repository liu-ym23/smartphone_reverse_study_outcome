package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f2092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f2093b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2094a = null;

        static {
            int[] r8 = new int[h.a.values().length];
            r8[h.a.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r8[h.a.ON_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r8[h.a.ON_RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r8[h.a.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r8[h.a.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r8[h.a.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r8[h.a.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f2094a = r8;
        }
    }

    public DefaultLifecycleObserverAdapter(c r8, k r10) {
        he.i.f(r8, "defaultLifecycleObserver");
        this.f2092a = r8;
        this.f2093b = r10;
    }

    @Override // androidx.lifecycle.k
    public final void onStateChanged(m r8, h.a r10) {
        int r11 = a.f2094a[r10.ordinal()];
        c r12 = this.f2092a;
        switch(r11) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L9;
        };
    L7:
        r12.a(r8);
        goto L9
    L8:
        r12.getClass();
    L9:
        k r13 = this.f2093b;
        if (r13 == null) goto L13;
        r13.onStateChanged(r8, r10);
        return;
    L13:
        return;
    L6:
        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    }
}
