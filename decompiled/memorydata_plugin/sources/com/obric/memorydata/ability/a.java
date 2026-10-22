package com.obric.memorydata.ability;

import android.content.Context;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\u0006H\u0016J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u001cR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/ability/AbilityContext;", "Lcom/obric/memorydata/ability/AbilityManager;", "Lcom/obric/memorydata/ability/IAbilityContext;", "dataId", "", "context", "Landroid/content/Context;", "<init>", "(ILandroid/content/Context;)V", "Ljava/lang/Integer;", "getAndroidContext", "getReceiverDataId", "()Ljava/lang/Integer;", "publish", "", "standardData", "Lcom/obric/memorydata/ability/data/IStandardData;", "publishToReceiver", "key", "", "publishToAllReceivers", "abilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "publishToSubscribe", "subscribeInfo", "Lcom/obric/memorydata/ability/SubscribeInfo;", "getAbilityWrapper", "Lcom/obric/memorydata/ability/AbilityWrapper;", "(Ljava/lang/Integer;)Lcom/obric/memorydata/ability/AbilityWrapper;", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0415a f8296a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f8297b;
    private Context c;

    /* JADX INFO: renamed from: com.obric.memorydata.ability.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ability/AbilityContext$Companion;", "", "<init>", "()V", "TAG", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0415a {
        private C0415a() {
        }

        public /* synthetic */ C0415a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8296a = new C0415a(null);
    }

    public a(int r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f8297b = Integer.valueOf(r3);
        this.c = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
    }

    private final i a(Integer r1) {
        if (r1 != null) goto L4;
    L7:
        return null;
    L4:
        if (r1.intValue() <= 0) goto L7;
        return e.f8354a.a(r1.intValue());
    }

    private static final Unit a(k r2, com.obric.memorydata.ability.data.h r3) {
        ((k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin")).a((com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final void a(k r2, a r3, n r4, com.obric.memorydata.ability.data.h r5) {
        final k r6 = (k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin");
        final com.obric.memorydata.ability.data.h r7 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.ability.impl.i.class) == false) goto L9;
        i r8 = r3.a(r4.c());
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.a() == false) goto L19;
        r8.a(new $$Lambda$a$r1a1Un6yPHjCP8azYOjyuFUQ1PE(r6, r7), false);
        return;
    L19:
        return;
    L9:
        monitor-enter(r6);
        r6.a(r7);     // Catch: Throwable -> L13
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r6);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private final boolean a(com.obric.memorydata.ability.data.h r6, f r7) {
        com.obric.memorydata.ability.data.h r8 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
        List<n> r9 = h.f8361a.a(r7);
        if (r9.isEmpty() == false) goto L5;
        return false;
    L5:
        boolean r0 = true;
        Iterator<n> r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        if (a(r8, (n) ZeusTransformUtils.preCheckCast(r10.next(), n.class, "com.obric.memorydata.plugin")) == true) goto L7;
        r0 = false;
        goto L7
    L11:
        return r0;
    }

    private final boolean a(com.obric.memorydata.ability.data.h r3, final n r4) {
        final com.obric.memorydata.ability.data.h r5 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
        final k r0 = r4.b();
        Runnable r1 = new $$Lambda$a$Z22A_1eQ83uOei1cGiIRqXBSzDw(r0, this, r4, r5);
        if (r4.f() == AbilityRequestType.QUERY) goto L7;
        ThreadPoolContainer.Companion.getInstance().execute(r1);
        return true;
    L7:
        return g.f8359a.a(r4.d(), r0, r1);
    }

    public static /* synthetic */ void lambda$Z22A_1eQ83uOei1cGiIRqXBSzDw(k r0, a r1, n r2, com.obric.memorydata.ability.data.h r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$r1a1Un6yPHjCP8azYOjyuFUQ1PE(k r0, com.obric.memorydata.ability.data.h r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.ability.j
    public Context a() {
        Context r0 = this.c;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.obric.memorydata.ability.j
    public boolean a(com.obric.memorydata.ability.data.h r6) {
        com.obric.memorydata.ability.data.h r7 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "standardData");
        f r0 = new f(r7.getDataId(), (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin"));
        if (r0.c() == true) goto L5;
        return false;
    L5:
        if (c.f8307a.a(r7.getDataId()) != null) goto L8;
        return false;
    L8:
        return a(r7, r0);
    }

    @Override // com.obric.memorydata.ability.j
    public boolean a(String r7, com.obric.memorydata.ability.data.h r8) {
        com.obric.memorydata.ability.data.h r9 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r9, "standardData");
        f r0 = new f(r9.getDataId(), (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin"));
        if (r0.c() == true) goto L5;
    L20:
        return false;
    L5:
        if (c.f8307a.a(r9.getDataId()) == null) goto L20;
        List<n> r1 = h.f8361a.a(r0);
        if (r1.isEmpty() == false) goto L10;
        return false;
    L10:
        n r2 = null;
        Iterator<n> r3 = r1.iterator();
    L12:
        if (r3.hasNext() == false) goto L16;
        n r4 = (n) ZeusTransformUtils.preCheckCast(r3.next(), n.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4.e(), r7) == false) goto L12;
        r2 = r4;
    L16:
        if (r2 != null) goto L19;
        return false;
    L19:
        return a(r9, r2);
    }

    @Override // com.obric.memorydata.ability.d
    public Integer b() {
        return this.f8297b;
    }
}
