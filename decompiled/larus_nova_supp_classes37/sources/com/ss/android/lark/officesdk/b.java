package com.ss.android.lark.officesdk;

import android.app.Application;
import com.bytedance.lark.rustclient.UserRustClientModule_ProvideClientFactory;
import com.bytedance.lark.rustclient.UserRustClientModule_ProvideDispatcherFactory;
import com.bytedance.lark.sdk.refactor.RustSdkModule_ProvideBarrierFactory;
import com.ss.android.lark.framework.assembly.rust.component.task.MakeRustBackgroundOnlineTask_Factory;
import com.ss.android.lark.officesdk.demo.dependency.BaseUserMocksModule_ProvideINotificationControllerApiFactory;
import com.ss.android.lark.officesdk.demo.dependency.BaseUserMocksModule_ProvideINotificationSettingApiFactory;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.ffi.KmpOfflineTask;
import com.ss.android.lark.passportc.ffi.KmpOnlineTask;
import com.ss.android.lark.passportc.internal.UserPassportServiceImpl;
import com.ss.android.lark.passportc.task.InitStaticUserConventionTask_Factory;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories_DwarfInternalFactoryFactory_Factory;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory;
import dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware;
import dagger.hilt.dwarf.spi.DwarfSPI;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends e0 {
    public final com.ss.android.lark.passportc.internal.f0 a;
    public final w0 b;
    public final String c;
    public final UserSession d;
    public Provider<com.ss.android.lark.active.user.bridge.h> e;
    public Provider<com.ss.android.lark.active.user.bridge.d> f;
    public Provider<ysb.a> g;
    public Provider<ysb.b> h;
    public Provider<UserPassportServiceImpl> i;
    public Provider<com.bytedance.lark.rustclient.api.l> j;
    public Provider<com.ss.android.lark.flow.notification.online.process.d> k;
    public Provider<com.ss.android.lark.flow.notification.online.process.e> l;
    public Provider<x5c.b> m;
    public a n;
    public Provider<h0> o;
    public a p;
    public a q;
    public Provider<ova.r> r;
    public Provider<skc.a> s;
    public Provider<a0c.b> t;

    public static final class a<T> implements Provider<T> {
        public final b a;
        public final int b;

        /* JADX WARN: Type inference failed for: r1v0, types: [T, com.ss.android.lark.officesdk.h0] */
        public final T get() {
            switch(this.b) {
                case 0: goto L37;
                case 1: goto L35;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L29;
                case 5: goto L27;
                case 6: goto L25;
                case 7: goto L22;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L17;
                case 11: goto L15;
                case 12: goto L12;
                case 13: goto L11;
                case 14: goto L9;
                case 15: goto L6;
                default: goto L5;
            };
        L6:
            b r1 = this.a;
            return (T) new a0c.b(r1.c, (yzb.b) Preconditions.checkNotNullFromComponent((yzb.b) ((o) r1.b).j0.get()), (kzb.b) Preconditions.checkNotNullFromComponent((kzb.b) ((o) this.a.b).a1.get()), (izb.a) Preconditions.checkNotNullFromComponent((izb.a) ((o) this.a.b).Z0.get()));
        L12:
            Application r2 = (Application) Preconditions.checkNotNullFromComponent(((o) this.a.b).G4());
            com.ss.android.lark.passportc.api.j r3 = (com.ss.android.lark.passportc.api.j) Preconditions.checkNotNullFromComponent((com.ss.android.lark.passportc.api.j) ((o) this.a.b).v0.get());
            com.ss.android.lark.passportc.api.m r4 = (com.ss.android.lark.passportc.api.m) this.a.i.get();
            b r5 = this.a;
            return (T) new ova.r(r2, r3, r4, r5.d, DoubleCheck.lazy(r5.q), DoubleCheck.lazy(SetFactory.empty()));
        L20:
            com.bytedance.lark.sdk.refactor.l r6 = (com.bytedance.lark.sdk.refactor.l) Preconditions.checkNotNullFromComponent((com.bytedance.lark.sdk.refactor.l) ((o) this.a.b).b0.get());
            com.bytedance.lark.sdk.refactor.state.c r7 = (com.bytedance.lark.sdk.refactor.state.c) Preconditions.checkNotNullFromComponent(((o) this.a.b).H4());
            com.bytedance.lark.rustclient.internal.k r8 = (com.bytedance.lark.rustclient.internal.k) Preconditions.checkNotNullFromComponent((com.bytedance.lark.rustclient.internal.k) ((o) this.a.b).Y.get());
            com.bytedance.lark.rustclient.internal.m r9 = (com.bytedance.lark.rustclient.internal.m) Preconditions.checkNotNullFromComponent(((o) this.a.b).I4());
            ((o) this.a.b).getClass();
            return (T) UserRustClientModule_ProvideClientFactory.provideClient(r6, r7, r8, r9, (Set) Preconditions.checkNotNullFromComponent(Collections.singleton(new com.ss.android.lark.framework.assembly.rust.e0())), (com.bytedance.lark.sdk.refactor.e) Preconditions.checkNotNullFromComponent(RustSdkModule_ProvideBarrierFactory.provideBarrier((com.bytedance.lark.sdk.refactor.n) ((o) this.a.b).z0.get())), (com.ss.android.lark.passportc.api.m) this.a.i.get());
        L22:
            b r10 = this.a;
            return (T) new UserPassportServiceImpl(r10.a, (com.ss.android.lark.log.c) Preconditions.checkNotNullFromComponent((com.ss.android.lark.log.c) ((o) r10.b).e0.get()), new com.ss.android.lark.passportc.internal.i(), (l0c.c) Preconditions.checkNotNullFromComponent((l0c.c) ((o) this.a.b).U.get()));
        L32:
            b r0 = this.a;
            ?? r11 = (T) HiltRoot_HiltComponents_BackgroundUserCServiceProvider_Factory.newInstance();
            r11.a = DoubleCheck.lazy(r0.n);
            return r11;
        L5:
            throw new AssertionError(this.b);
        L9:
            return (T) new skc.a(this.a.d);
        L11:
            return (T) Preconditions.checkNotNullFromComponent(((o) this.a.b).b());
        L15:
            return (T) DwarfViewModelFactories_DwarfInternalFactoryFactory_Factory.newInstance((Application) Preconditions.checkNotNullFromComponent(((o) this.a.b).G4()), Collections.emptySet(), Collections.emptySet());
        L17:
            return (T) new x5c.b(this.a.c);
        L19:
            return (T) new com.ss.android.lark.flow.notification.online.process.e((com.ss.android.lark.passportc.api.m) this.a.i.get());
        L25:
            return (T) new com.ss.android.lark.flow.notification.online.process.d((com.ss.android.lark.passportc.api.m) this.a.i.get(), (com.bytedance.lark.rustclient.api.l) this.a.j.get());
        L27:
            return (T) BaseUserMocksModule_ProvideINotificationSettingApiFactory.provideINotificationSettingApi();
        L29:
            return (T) BaseUserMocksModule_ProvideINotificationControllerApiFactory.provideINotificationControllerApi();
        L31:
            return (T) MapBuilder.newMapBuilder(6).put(ysb.a.class, this.a.g).put(ysb.b.class, this.a.h).put(zsb.a.class, this.a.k).put(zsb.c.class, this.a.l).put(com.ss.android.lark.passportc.api.m.class, this.a.i).put(o5c.b.class, this.a.m).build();
        L35:
            return (T) new com.ss.android.lark.active.user.bridge.d();
        L37:
            return (T) new com.ss.android.lark.active.user.bridge.h();
        }

        public a(b r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.ss.android.lark.passportc.task.j
    public final Set<com.ss.android.lark.passportc.task.d> R() {
        SetBuilder r0 = SetBuilder.newSetBuilder(3);
        com.ss.android.lark.passportc.task.h r1 = InitStaticUserConventionTask_Factory.newInstance();
        r1.a = (com.ss.android.lark.passportc.api.m) this.i.get();
        r1.b = Collections.singleton(new com.ss.android.lark.passportc.api.v());
        SetBuilder r2 = r0.add(r1).add(new KmpOnlineTask());
        jjb.c r3 = MakeRustBackgroundOnlineTask_Factory.newInstance((com.bytedance.lark.rustclient.api.l) this.j.get(), UserRustClientModule_ProvideDispatcherFactory.provideDispatcher((com.bytedance.lark.rustclient.api.l) this.j.get()), (com.bytedance.lark.rustclient.internal.m) Preconditions.checkNotNullFromComponent(((o) this.b).I4()), (yzb.a) this.t.get(), (jzb.a) Preconditions.checkNotNullFromComponent((jzb.a) ((o) this.b).w5.get()), (com.bytedance.lark.sdk.refactor.n) Preconditions.checkNotNullFromComponent(((o) this.b).J4()));
        r3.g = new com.ss.android.lark.framework.assembly.rust.p((jdb.e) Preconditions.checkNotNullFromComponent((jdb.e) ((o) this.b).G0.get()), (apb.a) Preconditions.checkNotNullFromComponent((apb.a) ((o) this.b).Y0.get()));
        return r2.add(r3).build();
    }

    @Override // com.ss.android.lark.passportc.task.j
    public final Set<com.ss.android.lark.passportc.task.c> g() {
        return SetBuilder.newSetBuilder(2).add(new KmpOfflineTask()).add(new jjb.a((com.bytedance.lark.rustclient.internal.m) Preconditions.checkNotNullFromComponent(((o) this.b).I4()), UserRustClientModule_ProvideDispatcherFactory.provideDispatcher((com.bytedance.lark.rustclient.api.l) this.j.get()))).build();
    }

    public final Set<ComponentLifecycleAware> getLifecycleAwares() {
        return SetBuilder.newSetBuilder(3).add((ComponentLifecycleAware) this.i.get()).add((ComponentLifecycleAware) this.r.get()).add((ComponentLifecycleAware) this.s.get()).build();
    }

    public final Map<Class<?>, javax.inject.Provider<com.ss.android.lark.active.user.bridge.e<?, ?>>> b() {
        return Collections.singletonMap(com.ss.android.lark.active.user.bridge.h.class, this.e);
    }

    public final DwarfSPI dwarfSPI() {
        return (h0) this.o.get();
    }

    public final DwarfViewModelFactory.DwarfViewModelCollector dwarfViewModelCollector() {
        return new e0c.c(Collections.emptyMap(), Collections.emptyMap());
    }

    public final DwarfViewModelFactories.FactoryFactoryCollector factoryFactoryCollector() {
        return new e0c.d(this.p);
    }

    public final com.ss.android.lark.active.user.bridge.f u() {
        return (com.ss.android.lark.active.user.bridge.f) this.f.get();
    }

    public b(w0 r1, com.ss.android.lark.passportc.internal.f0 r2, String r3, UserSession r4) {
        this.a = r2;
        this.b = r1;
        this.c = r3;
        this.d = r4;
        this.e = DoubleCheck.provider(new a(this, 0));
        this.f = DoubleCheck.provider(new a(this, 1));
        this.g = DoubleCheck.provider(new a(this, 4));
        this.h = DoubleCheck.provider(new a(this, 5));
        this.i = DoubleCheck.provider(new a(this, 7));
        this.j = DoubleCheck.provider(new a(this, 8));
        this.k = DoubleCheck.provider(new a(this, 6));
        this.l = DoubleCheck.provider(new a(this, 9));
        this.m = DoubleCheck.provider(new a(this, 10));
        this.n = new a(this, 3);
        this.o = DoubleCheck.provider(new a(this, 2));
        this.p = new a(this, 11);
        this.q = new a(this, 13);
        this.r = DoubleCheck.provider(new a(this, 12));
        this.s = DoubleCheck.provider(new a(this, 14));
        this.t = DoubleCheck.provider(new a(this, 15));
    }
}
