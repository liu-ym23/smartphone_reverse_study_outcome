package com.obric.memorydata.ability;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0016\u001a\u00020\u0017J'\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001b2\u0006\u0010\u001c\u001a\u0002H\u0019¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/ability/AbilityWrapper;", "Lcom/obric/memorydata/ability/data/ReferenceCount;", "dataId", "", "<init>", "(I)V", "Ljava/lang/Integer;", "iMetaAbility", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "isCreated", "", "onCreate", "onVerify", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onSubscribe", "key", "", "onUnsubscribe", "onQuery", "onDestroy", "", "doSync", ExifInterface.GPS_DIRECTION_TRUE, "callable", "Ljava/util/concurrent/Callable;", "t", "(Ljava/util/concurrent/Callable;Ljava/lang/Object;)Ljava/lang/Object;", "createAbilityInstance", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i extends com.obric.memorydata.ability.data.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8363a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f8364b;
    private com.obric.memorydata.ability.impl.i c;
    private final ReentrantLock d;
    private volatile boolean e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ability/AbilityWrapper$Companion;", "", "<init>", "()V", "TAG", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8363a = new a(null);
    }

    public i(int r3) {
        this.d = new ReentrantLock(true);
        this.f8364b = Integer.valueOf(r3);
    }

    private final com.obric.memorydata.ability.impl.i a(int r9) {
        String r8 = c.f8307a.a(r9);
        if (r8 != null) goto L15;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilityWrapper", "className is null of " + r9, null, 4, null);
        return null;
    L15:
        Class r10 = ZeusTransformUtils.forName(r8, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        if (com.obric.memorydata.ability.impl.i.class.isAssignableFrom(r10) == true) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilityWrapper", r10.getSimpleName() + " is not inherited from IMetaAbility", null, 4, null);     // Catch: Exception -> L12
        return null;
    L10:
        Object r11 = r10.newInstance();     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.obric.memorydata.ability.impl.IMetaAbility");     // Catch: Exception -> L12
        return (com.obric.memorydata.ability.impl.i) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.ability.impl.i.class, "com.obric.memorydata.plugin");
    L12:
        e = move-exception;
        RunLog.INSTANCE.error("AbilityWrapper", "createAbilityInstance exception", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    public final <T> T a(Callable<T> r9, T r10) {
        Callable r11 = (Callable) ZeusTransformUtils.wrapperContextForParams(r9, Callable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "callable");
    L17:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilityWrapper", "interrupted try lock", null, 4, null);
        return r10;
    L4:
        if (this.d.tryLock(10, TimeUnit.SECONDS) == true) goto L20;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilityWrapper", "try lock doSync exceed waiting time : " + this.f8364b, null, 4, null);     // Catch: InterruptedException -> L17
        return r10;
    L20:
        T r12 = (T) r11.call();
        this.d.unlock();     // Catch: InterruptedException -> L17
        return r12;
    L12:
        e = move-exception;
        RunLog.INSTANCE.error("AbilityWrapper", "doSync: failed to execute callable", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        this.d.unlock();     // Catch: InterruptedException -> L17
        return r10;
    L10:
        th = move-exception;
        this.d.unlock();     // Catch: InterruptedException -> L17
        throw th;     // Catch: InterruptedException -> L17
    }

    public final boolean a() {
        this.d.lock();
        boolean r0 = this.e;     // Catch: Throwable -> L6
        this.d.unlock();
        return r0;
    L6:
        th = move-exception;
        this.d.unlock();
        throw th;
    }

    public final boolean a(f r2) {
        Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
        this.d.lock();
    L9:
        th = move-exception;
        this.d.unlock();
        throw th;
    L4:
        if (this.e == true) goto L6;
        boolean r3 = false;
    L7:
        this.d.unlock();
        return r3;
    L6:
        com.obric.memorydata.ability.impl.i r0 = this.c;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L9
        r3 = r0.a(r2);     // Catch: Throwable -> L9
        goto L7
    }

    public final boolean a(String r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        this.d.lock();
    L9:
        th = move-exception;
        this.d.unlock();
        throw th;
    L4:
        if (this.e == true) goto L6;
        boolean r4 = false;
    L7:
        this.d.unlock();
        return r4;
    L6:
        com.obric.memorydata.ability.impl.i r0 = this.c;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L9
        r4 = r0.a(r2, r3);     // Catch: Throwable -> L9
        goto L7
    }

    public final boolean b() {
        this.d.lock();
        Integer r1 = this.f8364b;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L10
        com.obric.memorydata.ability.impl.i r2 = a(r1.intValue());     // Catch: Throwable -> L10
        if (r2 != null) goto L7;
        this.d.unlock();
        return false;
    L7:
        this.c = r2;     // Catch: Throwable -> L10
        Integer r3 = this.f8364b;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L10
        int r4 = r3.intValue();     // Catch: Throwable -> L10
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L10
        r2.a((j) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.ability.a(r4, r5), j.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        this.e = true;     // Catch: Throwable -> L10
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilityWrapper", this.f8364b + " ability onCreated", false, 4, null);     // Catch: Throwable -> L10
        this.d.unlock();
        return true;
    L10:
        th = move-exception;
        this.d.unlock();
        throw th;
    }

    public final boolean b(String r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        this.d.lock();
    L9:
        th = move-exception;
        this.d.unlock();
        throw th;
    L4:
        if (this.e == true) goto L6;
        boolean r4 = false;
    L7:
        this.d.unlock();
        return r4;
    L6:
        com.obric.memorydata.ability.impl.i r0 = this.c;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L9
        r4 = r0.b(r2, r3);     // Catch: Throwable -> L9
        goto L7
    }

    public final void c() {
        this.d.lock();
    L10:
        th = move-exception;
        this.d.unlock();
        throw th;
    L4:
        if (this.e == true) goto L7;
        this.d.unlock();
        return;
    L7:
        com.obric.memorydata.ability.impl.i r0 = this.c;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L10
        r0.a();     // Catch: Throwable -> L10
        this.c = null;     // Catch: Throwable -> L10
        this.e = false;     // Catch: Throwable -> L10
        this.d.unlock();
    }

    public final boolean c(String r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        this.d.lock();
    L9:
        th = move-exception;
        this.d.unlock();
        throw th;
    L4:
        if (this.e == true) goto L6;
        boolean r4 = false;
    L7:
        this.d.unlock();
        return r4;
    L6:
        com.obric.memorydata.ability.impl.i r0 = this.c;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L9
        r4 = r0.c(r2, r3);     // Catch: Throwable -> L9
        goto L7
    }
}
