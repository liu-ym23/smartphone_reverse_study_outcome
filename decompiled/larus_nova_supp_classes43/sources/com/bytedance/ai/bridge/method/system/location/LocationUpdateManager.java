package com.bytedance.ai.bridge.method.system.location;

import java.lang.ref.WeakReference;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r4.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LocationUpdateManager implements e3.b {
    public final WeakReference<e3.d> a;
    public final String b;
    public final Object c;
    public UpdateState d;
    public int e;
    public boolean f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/location/LocationUpdateManager$UpdateState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "STARTING", "STARTED", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UpdateState extends Enum<UpdateState> {
        public static final UpdateState IDLE = null;
        public static final UpdateState STARTED = null;
        public static final UpdateState STARTING = null;
        public static final /* synthetic */ UpdateState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<UpdateState> getEntries() {
            return b;
        }

        static {
            UpdateState r0 = new UpdateState("IDLE", 0);
            IDLE = r0;
            UpdateState r1 = new UpdateState("STARTING", 1);
            STARTING = r1;
            UpdateState r10 = new UpdateState("STARTED", 2);
            STARTED = r10;
            UpdateState[] r11 = {r0, r1, r10};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static UpdateState[] values() {
            return (UpdateState[]) a.clone();
        }

        public static UpdateState valueOf(String r1) {
            return (UpdateState) r27.a.a(UpdateState.class, r1);
        }

        public UpdateState(String r1, int r10) {
            super(r1, r10);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UpdateState.values().length];
            r0[UpdateState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[UpdateState.STARTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[UpdateState.STARTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Override // e3.b
    public final void a() {
        e3.d r0 = this.a.get();
        Object r1 = this.c;
        monitor-enter(r1);
        boolean r10 = true;
        this.f = true;     // Catch: Throwable -> L45
        if (this.d != UpdateState.STARTED) goto L9;
        boolean r11 = true;
    L10:
        monitor-exit(r1);
        if (r0 == null) goto L44;
        if (r11 == false) goto L54;
        Object r12 = null;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L20
        r4.e r14 = r4.a.h;     // Catch: Throwable -> L20
        if (r14 == null) goto L17;
        l r15 = r14.c(r0, "doubao.stopLocationUpdate", this.b);     // Catch: Throwable -> L20
    L18:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r16) == true) goto L26;
        r12 = r16;
    L26:
        l r17 = (l) r12;
        if (r17 != null) goto L29;
    L34:
        r10 = false;
    L35:
        if (r10 == false) goto L55;
        Object r18 = this.c;
        monitor-enter(r18);
        this.d = UpdateState.IDLE;     // Catch: Throwable -> L41
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r18);
        return;
    L41:
        th = move-exception;
        throw th;
    L55:
        return;
    L29:
        if (r17.a != null) goto L31;
        boolean r20 = true;
    L32:
        if (r20 != true) goto L34;
    L31:
        r20 = false;
        goto L32
    L17:
        r15 = null;
    L20:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L54:
        return;
    L44:
        return;
    L9:
        r11 = false;
    L45:
        th = move-exception;
        throw th;
    }

    public final boolean b() {
        Object r0 = this.c;
        monitor-enter(r0);
        boolean r1 = this.f;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public LocationUpdateManager(e3.d r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        this.a = new WeakReference(r10);
        this.b = UUID.randomUUID().toString();
        this.c = new Object();
        this.d = UpdateState.IDLE;
    }

    public final boolean c(int r10) {
        Object r0 = this.c;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.d == UpdateState.STARTING) goto L7;
    L11:
        boolean r11 = false;
    L12:
        monitor-exit(r0);
        return r11;
    L7:
        if (this.e != r10) goto L11;
        if (this.f == true) goto L11;
        r11 = true;
        goto L12
    }

    public final void d(int r10) {
        Object r0 = this.c;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.d == UpdateState.STARTING) goto L7;
    L9:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L7:
        if (this.e != r10) goto L9;
        this.d = UpdateState.IDLE;     // Catch: Throwable -> L12
        goto L9
    }
}
