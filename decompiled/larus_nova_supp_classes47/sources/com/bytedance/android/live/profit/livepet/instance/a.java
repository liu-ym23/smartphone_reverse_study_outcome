package com.bytedance.android.live.profit.livepet.instance;

import com.bytedance.android.live.profit.livepet.LivePetMessageDispatcher;
import com.bytedance.android.live.revenue.common.p;
import com.bytedance.android.livesdk.message.model.cb;
import com.bytedance.android.livesdk.message.model.db;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o {
    public final CompositeDisposable a;
    public final LivePetMessageDispatcher b;
    public final com.bytedance.android.live.profit.livepet.instance.b c;

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.livepet.instance.a$a, reason: collision with other inner class name */
    public static final class C0026a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            cb r4 = (cb) r3;
            a.a(this.a, r4);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            jy0.b.b("LivePet/InstanceLoader", "failed to parse pet effect info", th);
        }
    }

    static {
    }

    public final void onStart() {
        f.a(this.b.b.a(false).subscribe(new b(this)), this.a);
    }

    public final void onStop() {
        this.a.dispose();
    }

    public a(LivePetMessageDispatcher r2, com.bytedance.android.live.profit.livepet.instance.b r3) {
        Intrinsics.checkNotNullParameter(r2, "messageDispatcher");
        Intrinsics.checkNotNullParameter(r3, "instanceManager");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(a r19, cb r20) {
        r19.getClass();
        db r1 = (db) GsonProtectorUtils.fromJson(l97.a.a, r20.getPetMeta(), TypesJVMKt.getJavaType(Reflection.typeOf(db.class)));
        long r2 = r1.H6();
        jy0.b.a("LivePet/InstanceLoader", "process effect, petType = " + r2);
        qu0.a.c r4 = qu0.b.c.b(r2);
        String r8 = null;
        if (r4 != null) goto L5;
        jy0.b.f("LivePet/InstanceLoader", "pet config for <type: " + r2 + "> not found", null, 4);
        return;
    L5:
        jy0.b.a("LivePet/InstanceLoader", "pet config for <type: " + r2 + ">:\n" + CollectionsKt.joinToString$default(CollectionsKt.toList(r4.a.entrySet()), "\n", null, null, 0, null, LivePetInstanceLoader$processMessage$1.INSTANCE, 30, null));
        p.a r7 = r4.b;
        KProperty<?>[] r9 = qu0.a.c.c;
        boolean r10 = false;
        String r12 = (String) r7.a(r4, r9[0]);
        boolean r13 = true;
        if (r12 != null) goto L8;
    L11:
        boolean r14 = true;
    L12:
        if (r14 == false) goto L14;
        jy0.b.f("LivePet/InstanceLoader", "pet scheme is empty", null, 4);
    L14:
        String r3 = r1.G7();
        if (r3 != null) goto L17;
    L22:
        if (r8 != null) goto L24;
        String r5 = (String) r4.b.a(r4, r9[0]);
    L25:
        if (r5 != null) goto L28;
        return;
    L28:
        if (r8 == null) goto L30;
        r10 = true;
    L30:
        c r6 = new c(r2, r5, r10);
        LivePetInstance r15 = (LivePetInstance) r19.c.a.b;
        if (r15 == null) goto L39;
        Intrinsics.checkNotNullParameter(r6, "nextLoadParams");
        c r16 = r15.d;
        if (r16.c == true) goto L36;
        r13 = Intrinsics.areEqual(r16.b, r5);
    L36:
        if (r13 == false) goto L38;
        jy0.b.a("LivePet/InstanceLoader", "current instance is compatible and will be reused");
        return;
    L38:
        jy0.b.a("LivePet/InstanceLoader", "current instance is not compatible, unloading");
        r19.c.c();
    L39:
        r19.c.a(r6);
        return;
    L24:
        r5 = r8;
        goto L25
    L17:
        if (r3.length() <= 0) goto L19;
        boolean r17 = true;
    L20:
        if (r17 == false) goto L22;
        r8 = r3;
        goto L22
    L19:
        r17 = false;
        goto L20
    L8:
        if (r12.length() == 0) goto L11;
        r14 = false;
        goto L12
    }
}
