package com.obric.memorydata.ability;

import androidx.core.app.NotificationCompat;
import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0014J%\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0014J%\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0014J/\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u0019J/\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u0019J/\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/ability/AbilityManagerProcessor;", "", "<init>", "()V", "TAG", "", "abilityWrapperContainer", "Ljava/util/HashMap;", "", "Lcom/obric/memorydata/ability/AbilityWrapper;", "Lkotlin/collections/HashMap;", "abilityWrapperLock", "Ljava/util/concurrent/locks/ReentrantLock;", AwarenessManagerImpl.ACTION_SUBSCRIBE, "", "abilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "dataReceiver", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "receiverDataId", "(Lcom/obric/memorydata/ability/AbilityParams;Lcom/obric/memorydata/ability/IAbilityDataReceiver;Ljava/lang/Integer;)Z", "unsubscribe", ChatMessage.TYPE_QUERY, "executeSubscribe", "abilityWrapper", "(Lcom/obric/memorydata/ability/AbilityWrapper;Lcom/obric/memorydata/ability/AbilityParams;Lcom/obric/memorydata/ability/IAbilityDataReceiver;Ljava/lang/Integer;)Z", "executeUnsubscribe", "executeQuery", "getAbilityWrapper", "abilityId", "tryDestroy", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f8354a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<Integer, i> f8355b = null;
    private static final ReentrantLock c = null;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"com/obric/memorydata/ability/AbilityManagerProcessor$tryDestroy$1", "Ljava/util/concurrent/Callable;", "", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f8356a;

        a(i r1) {
            this.f8356a = r1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            if (this.f8356a.d() == true) goto L5;
            return true;
        L5:
            this.f8356a.c();
            return true;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() {
            return call();
        }
    }

    static {
        f8354a = new e();
        f8355b = new HashMap();
        c = new ReentrantLock(true);
    }

    private e() {
    }

    private final void a(i r3) {
        r3.a((Callable) ZeusTransformUtils.preCheckCast(new a(r3), Callable.class, "com.obric.memorydata.plugin"), false);
    }

    private final boolean a(i r8, f r9, k r10, Integer r11) {
        k r3 = (k) ZeusTransformUtils.wrapperContextForParams(r10, k.class, "com.obric.memorydata.plugin");
        if (r8.a() == true) goto L10;
        if (r8.b() == true) goto L10;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        String r12 = "executeSubscribe onCreate failed: ";
    L7:
        IRunLog.a.b(r0, "AbilityManagerProcessor", r7.append(r12).append(r9.a()).toString(), null, 4, null);
        return false;
    L10:
        if (r8.a(r9) == true) goto L12;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = new StringBuilder();
        r12 = "executeSubscribe onVerify failed: ";
        goto L7
    L12:
        o r13 = new o(r9, r3, r11, r9.a(), AbilityRequestType.SUBSCRIBE);
        n r14 = h.f8361a.a(r13, r8);
        if (r14 != null) goto L15;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = new StringBuilder();
        r12 = "executeSubscribe subscribeInfo failed: ";
        goto L7
    L15:
        boolean r15 = r8.a(r14.e(), r9);
        if (r15 == true) goto L18;
        h.f8361a.b(r13, r8);
    L18:
        return r15;
    }

    private final boolean b(i r7, f r8, k r9, Integer r10) {
        o r6 = new o(r8, (k) ZeusTransformUtils.wrapperContextForParams(r9, k.class, "com.obric.memorydata.plugin"), r10, r8.a(), AbilityRequestType.SUBSCRIBE);
        n r11 = h.f8361a.b(r6, r7);
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r7.a() == true) goto L9;
        return false;
    L9:
        return r7.b(r11.e(), r8);
    }

    private final boolean c(i r8, f r9, k r10, Integer r11) {
        k r3 = (k) ZeusTransformUtils.wrapperContextForParams(r10, k.class, "com.obric.memorydata.plugin");
        if (r8.a() == true) goto L10;
        if (r8.b() == true) goto L10;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        String r12 = "executeSubscribe onCreate failed: ";
    L7:
        IRunLog.a.b(r0, "AbilityManagerProcessor", r7.append(r12).append(r9.a()).toString(), null, 4, null);
        return false;
    L10:
        if (r8.a(r9) == true) goto L12;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = new StringBuilder();
        r12 = "executeSubscribe onVerify failed: ";
        goto L7
    L12:
        o r13 = new o(r9, r3, r11, r9.a(), AbilityRequestType.QUERY);
        n r14 = h.f8361a.a(r13, r8);
        if (r14 != null) goto L15;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = new StringBuilder();
        r12 = "executeSubscribe subscribeInfo failed: ";
        goto L7
    L15:
        boolean r15 = r8.c(r14.e(), r9);
        h.f8361a.b(r13, r8);
        return r15;
    }

    private static final Boolean d(i r2, f r3, k r4, Integer r5) {
        k r6 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
        return Boolean.valueOf(f8354a.a(r2, r3, r6, r5));
    }

    private static final Boolean e(i r2, f r3, k r4, Integer r5) {
        k r6 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
        return Boolean.valueOf(f8354a.b(r2, r3, r6, r5));
    }

    private static final Boolean f(i r2, f r3, k r4, Integer r5) {
        k r6 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
        return Boolean.valueOf(f8354a.c(r2, r3, r6, r5));
    }

    /* JADX INFO: renamed from: lambda$4zCx95v5N-Dxx23ynDNA4QolI38, reason: not valid java name */
    public static /* synthetic */ Boolean m433lambda$4zCx95v5NDxx23ynDNA4QolI38(i r0, f r1, k r2, Integer r3) {
        return f(r0, r1, r2, r3);
    }

    public static /* synthetic */ Boolean lambda$TxpTnUpITmGQfzAL4EqtWjbfORA(i r0, f r1, k r2, Integer r3) {
        return e(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$X4SYURi3PgWDVvnNYVgops-udLQ, reason: not valid java name */
    public static /* synthetic */ Boolean m434lambda$X4SYURi3PgWDVvnNYVgopsudLQ(i r0, f r1, k r2, Integer r3) {
        return d(r0, r1, r2, r3);
    }

    public final i a(int r5) {
        ReentrantLock r4 = c;
        if (r4.tryLock(10, TimeUnit.SECONDS) == true) goto L6;
        return null;
    L6:
        HashMap<Integer, i> r0 = f8355b;
        i r1 = (i) ZeusTransformUtils.preCheckCast(r0.get(Integer.valueOf(r5)), i.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L10;
        r4.unlock();
        return r1;
    L10:
        i r2 = new i(r5);
        Integer r6 = Integer.valueOf(r5);
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r6, r2);
        r4.unlock();
        return r2;
    }

    public final boolean a(final f r10, k r11, final Integer r12) {
        final k r13 = (k) ZeusTransformUtils.wrapperContextForParams(r11, k.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "abilityParams");
        Intrinsics.checkNotNullParameter(r13, "dataReceiver");
        if (r10.c() == true) goto L5;
        return false;
    L5:
        final i r0 = a(r10.a());
        if (r0 != null) goto L9;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilityManagerProcessor", "subscribe abilityWrapper is null", null, 4, null);
        return false;
    L9:
        Boolean r14 = (Boolean) ZeusTransformUtils.preCheckCast(r0.a(new $$Lambda$e$X4SYURi3PgWDVvnNYVgopsudLQ(r0, r10, r13, r12), false), Boolean.class, "com.obric.memorydata.plugin");
        if (r14.booleanValue() == true) goto L12;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilityManagerProcessor", "subscribe failed, to release", null, 4, null);
        a(r0);
    L12:
        Intrinsics.checkNotNull(r14);
        return r14.booleanValue();
    }

    public final boolean b(final f r10, k r11, final Integer r12) {
        final k r13 = (k) ZeusTransformUtils.wrapperContextForParams(r11, k.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "abilityParams");
        Intrinsics.checkNotNullParameter(r13, "dataReceiver");
        if (r10.c() == true) goto L5;
        return false;
    L5:
        final i r0 = a(r10.a());
        if (r0 != null) goto L9;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilityManagerProcessor", "unsubscribe abilityWrapper is null", null, 4, null);
        return false;
    L9:
        Boolean r14 = (Boolean) ZeusTransformUtils.preCheckCast(r0.a(new $$Lambda$e$TxpTnUpITmGQfzAL4EqtWjbfORA(r0, r10, r13, r12), false), Boolean.class, "com.obric.memorydata.plugin");
        if (r14.booleanValue() == false) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilityManagerProcessor", "unsubscribe success, to release", false, 4, null);
        a(r0);
    L12:
        Intrinsics.checkNotNull(r14);
        return r14.booleanValue();
    }

    public final boolean query(final f r10, k r11, final Integer r12) {
        final k r13 = (k) ZeusTransformUtils.wrapperContextForParams(r11, k.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "abilityParams");
        Intrinsics.checkNotNullParameter(r13, "dataReceiver");
        if (r10.c() == true) goto L5;
        return false;
    L5:
        final i r0 = a(r10.a());
        if (r0 != null) goto L9;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilityManagerProcessor", "query abilityWrapper is null", null, 4, null);
        return false;
    L9:
        Boolean r14 = (Boolean) ZeusTransformUtils.preCheckCast(r0.a(new $$Lambda$e$4zCx95v5NDxx23ynDNA4QolI38(r0, r10, r13, r12), false), Boolean.class, "com.obric.memorydata.plugin");
        if (r14.booleanValue() == true) goto L12;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilityManagerProcessor", "query failed " + r10.a() + ", to release", null, 4, null);
    L12:
        a(r0);
        Intrinsics.checkNotNull(r14);
        return r14.booleanValue();
    }
}
