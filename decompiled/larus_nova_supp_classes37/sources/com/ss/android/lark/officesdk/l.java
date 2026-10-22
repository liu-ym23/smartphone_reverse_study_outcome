package com.ss.android.lark.officesdk;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.larksuite.component.card.cardcontainer.IUniversalCardJsService;
import com.ss.android.lark.active.user.api.IGlobalActiveUserManager;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.chameleon.AbsChameleonJsRuntime;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;
import com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.integrator.im.impl.IIMGlobalServiceImpl;
import com.ss.android.lark.integrator.im.impl.IIMGlobalServiceImpl_Factory;
import com.ss.android.lark.myai.export.MyAIService;
import com.ss.android.lark.officesdk.api.IOnlineOfflineService;
import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_DwarfViewModelCollector;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_FactoryFactoryCollector;
import com.ss.android.lark.officesdk.injectheader.impl.OfficeSDKHostAppHeaderUpdateImpl;
import com.ss.android.lark.officesdk.internal.UserManagerImpl;
import com.ss.android.lark.officesdk.permission.api.IPermissionRequester;
import com.ss.android.lark.passport_user.api.IUserListService;
import com.ss.android.lark.preload.v2.api.IPrimaryTabService;
import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import com.ss.android.lark.security.compliance.api.ISecurityComplianceApi;
import com.ss.android.lark.tab.service.IChatTabService;
import com.ss.android.lark.todo_api.ITodoApi;
import com.suite.lark.platform.component.widget_biz_billingtips.IBillingTipsDependency;
import dagger.hilt.dwarf.spi.DwarfSPI;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Provider;
import java.util.Collections;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l extends k0 {
    public final o a;
    public Provider<com.ss.android.lark.integrator.im.impl.preview.b> b;
    public Provider<IIMGlobalServiceImpl> c;
    public Provider<OfficeSDKHostAppHeaderUpdateImpl> d;
    public Provider<com.ss.android.lark.passport.assemble.e> e;
    public a f;
    public Provider<o0> g;
    public Provider<UserManagerImpl> h;
    public Provider<com.ss.android.lark.officesdk.internal.e> i;

    public static final class a<T> implements Provider<T> {
        public final o a;
        public final l b;
        public final int c;

        /* JADX WARN: Type inference failed for: r1v0, types: [T, com.ss.android.lark.officesdk.o0] */
        /* JADX WARN: Type inference failed for: r1v244, types: [T, com.ss.android.lark.integrator.im.impl.IIMGlobalServiceImpl] */
        public final T get() {
            switch(this.c) {
                case 0: goto L20;
                case 1: goto L19;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L11;
                case 6: goto L9;
                case 7: goto L7;
                default: goto L5;
            };
        L16:
            l r0 = this.b;
            ?? r1 = (T) IIMGlobalServiceImpl_Factory.newInstance((com.ss.android.lark.passportc.api.j) this.a.v0.get(), (vmb.c) this.a.i6.get());
            ((IIMGlobalServiceImpl) r1).c = (sza.c) r0.b.get();
            return r1;
        L20:
            l r2 = this.b;
            ?? r3 = (T) HiltRoot_HiltComponents_OfficeSDKGlobalCServiceProvider_Factory.newInstance();
            r3.a = DoubleCheck.lazy(r2.f);
            return r3;
        L5:
            throw new AssertionError(this.c);
        L7:
            return (T) new com.ss.android.lark.officesdk.internal.e();
        L9:
            return (T) new UserManagerImpl((IOnlineOfflineService) this.a.g4.get(), (IOfficeSDKTokenProvider) this.a.d4.get(), (IOfficeSDKLifeCycle) this.a.j6.get());
        L11:
            return (T) new com.ss.android.lark.passport.assemble.e();
        L13:
            return (T) new OfficeSDKHostAppHeaderUpdateImpl();
        L15:
            return (T) new com.ss.android.lark.integrator.im.impl.preview.b(DoubleCheck.lazy(this.a.Z2), DoubleCheck.lazy(this.a.a3));
        L19:
            return (T) MapBuilder.newMapBuilder(239).put(com.bytedance.ee.bear.h.class, this.a.b1).put(com.bytedance.ee.bear.bitable.core.usercomponent.a.class, this.a.c1).put(com.bytedance.ee.bear.contract.a0.class, this.a.d1).put(com.bytedance.ee.bear.contract.h0.class, this.a.e1).put(NetService.class, this.a.f1).put(nw4.b.class, this.a.g1).put(rw4.d.class, this.a.h1).put(com.bytedance.ee.bear.doc.resupdate.g.class, this.a.i1).put(w05.d.class, this.a.j1).put(com.bytedance.ee.bear.document.knowledgeai.a.class, this.a.k1).put(z15.d.class, this.a.l1).put(k25.a.class, this.a.m1).put(s45.c.class, this.a.n1).put(t45.c.class, this.a.o1).put(com.bytedance.ee.bear.drive.cache.w.class, this.a.p1).put(o75.a.class, this.a.q1).put(com.bytedance.ee.bear.drive.sdk.service.f.class, this.a.r1).put(com.bytedance.ee.bear.drive.services.c.class, this.a.s1).put(com.bytedance.ee.bear.drive.services.w.class, this.a.t1).put(fa5.a.class, this.a.u1).put(com.bytedance.ee.bear.init.a.class, this.a.R).put(hb5.a.class, this.a.v1).put(com.bytedance.ee.bear.lark.dependency.g.class, this.a.w1).put(com.bytedance.ee.bear.lark.dependency.i.class, this.a.x1).put(com.bytedance.ee.bear.lark.dependency.n.class, this.a.y1).put(com.bytedance.ee.bear.lark.dependency.q.class, this.a.z1).put(com.bytedance.ee.bear.lark.dependency.r.class, this.a.A1).put(com.bytedance.ee.bear.lark.dependency.t.class, this.a.B1).put(com.bytedance.ee.bear.lark.dependency.u.class, this.a.C1).put(com.bytedance.ee.bear.lark.dependency.y.class, this.a.D1).put(com.bytedance.ee.bear.lark.dependency.z.class, this.a.E1).put(com.bytedance.ee.bear.lark.dependency.a0.class, this.a.F1).put(com.bytedance.ee.bear.lark.dependency.c0.class, this.a.G1).put(com.bytedance.ee.bear.lark.dependency.e0.class, this.a.H1).put(com.bytedance.ee.bear.lark.dependency.l0.class, this.a.I1).put(mc5.j.class, this.a.J1).put(cj5.c.class, this.a.K1).put(ik5.a.class, this.a.L1).put(sk5.b.class, this.a.M1).put(com.bytedance.ee.bear.rn.j.class, this.a.N1).put(com.bytedance.ee.bear.route.h.class, this.a.O1).put(hm5.a.class, this.a.P1).put(mo5.e.class, this.a.Q1).put(BenefitManagerAPI.class, this.a.R1).put(com.bytedance.ee.drive.preview.f.class, this.a.S1).put(zt5.a.class, this.a.T1).put(com.bytedance.ee.space.sync.b.class, this.a.U1).put(com.bytedance.ee.util.db.a.class, this.a.V1).put(com.bytedance.lark.sdk.refactor.i.class, this.a.W1).put(com.bytedance.lark.sdk.refactor.j.class, this.a.X1).put(com.bytedance.lark.sdk.refactor.n.class, this.a.z0).put(IUniversalCardJsService.class, this.a.Y1).put(com.larksuite.framework.http.v2.b.class, this.a.Z1).put(yra.e.class, this.a.a2).put(mua.a.class, this.a.d2).put(IGlobalActiveUserManager.class, this.a.c2).put(nua.a.class, this.a.b2).put(nua.c.a.class, this.a.e2).put(com.ss.android.lark.active.user.bridge.g.class, this.a.f2).put(awa.a.class, this.a.g2).put(awa.c.class, this.a.D0).put(IAudioService.class, this.a.h2).put(com.ss.android.lark.audio.voiceinput.service.l.class, this.a.i2).put(com.ss.android.lark.audio.voiceinput.service.o.class, this.a.j2).put(com.ss.android.lark.audit.userscope.audit.k.class, this.a.l2).put(com.ss.android.lark.audit.userscope.audit.l.class, this.a.m2).put(com.ss.android.lark.audit.userscope.auth.j.class, this.a.I0).put(com.ss.android.lark.audit.userscope.auth.k.class, this.a.I0).put(com.ss.android.lark.auditsdk.v2.receivecheck.cache.a.class, this.a.n2).put(xwa.b.class, this.a.p2).put(com.ss.android.lark.biz.im.api.r.class, this.a.q2).put(com.ss.android.lark.biz.im.api.t.class, this.a.r2).put(com.ss.android.lark.biz.im.api.o0.class, this.a.s2).put(com.ss.android.lark.biz.im.api.message.audit.f.class, this.a.t2).put(dza.a.class, this.a.u2).put(eza.a.class, this.a.v2).put(jza.c.class, this.a.w2).put(jza.d.class, this.a.x2).put(kza.a.class, this.a.y2).put(kza.d.class, this.a.z2).put(qza.a.class, this.a.A2).put(qza.b.class, this.a.B2).put(rza.a.class, this.a.C2).put(tza.a.class, this.a.D2).put(uza.a.class, this.a.R0).put(AbsChameleonJsRuntime.class, this.a.E2).put(o0b.c.class, this.a.F2).put(q1b.a.class, this.a.G2).put(v1b.a.class, this.a.H2).put(IChatService.class, this.a.I2).put(a2b.c.class, this.a.J2).put(a2b.f.class, this.a.K2).put(a2b.h.class, this.a.L2).put(a2b.i.class, this.a.M2).put(a2b.j.class, this.a.N2).put(a2b.k.class, this.a.O2).put(a2b.l.class, this.a.P2).put(ITranslateService.class, this.a.Q2).put(a2b.n.class, this.a.R2).put(a2b.o.class, this.a.S2).put(com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d.class, this.a.T2).put(com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b.class, this.a.U2).put(com.ss.android.lark.chat.chatwindow.chat.v2.push.z.class, this.a.V2).put(com.ss.android.lark.chat.core.api.d.class, this.a.W2).put(w4b.c.o.class, this.a.X2).put(w4b.e.class, this.a.Y2).put(w4b.f.class, this.a.b3).put(com.ss.android.lark.chat.export.offlineCacheClean.a.class, this.a.c3).put(com.ss.android.lark.chat.name.f.class, this.a.d3).put(m6b.a.class, this.a.e3).put(m6b.d.class, this.a.f3).put(m6b.g.class, this.a.g3).put(m6b.j.class, this.a.h3).put(m6b.m.class, this.a.i3).put(m6b.n.class, this.a.j3).put(m6b.q.class, this.a.k3).put(m6b.s.class, this.a.l3).put(m6b.t.class, this.a.m3).put(m6b.u.class, this.a.n3).put(x6b.a.class, this.a.o3).put(com.ss.android.lark.chatwindow.launcher.c.class, this.a.Q0).put(g8b.c.class, this.a.q3).put(com.ss.android.lark.conditional.access.display.g.class, this.a.r3).put(com.ss.android.lark.conditional.access.traffic.handler.policy.center.a.class, this.a.s3).put(s9b.a.class, this.a.t3).put(com.ss.android.lark.create.groupchat.impl.service.h.class, this.a.S0).put(IDomainConfigService.class, this.a.O0).put(IGlobalDomainConfigService.class, this.a.P0).put(com.ss.android.lark.endpoint.security.detection.location.a.class, this.a.u3).put(jdb.e.class, this.a.G0).put(jdb.f.class, this.a.F0).put(jeb.d.class, this.a.v3).put(neb.a.class, this.a.w3).put(oeb.d.class, this.a.x3).put(com.ss.android.lark.forwardv3.forward.mediaforward.f.class, this.a.y3).put(com.ss.android.lark.framework.assembly.diskmanage.d.class, this.a.I3).put(com.ss.android.lark.framework.assembly.rust.c.class, this.a.K3).put(IImBrowserService.class, this.a.L3).put(ImSdkChatService.class, this.a.M3).put(com.ss.android.lark.im.sdk.service.h.class, this.a.N3).put(com.ss.android.lark.im.sdk.service.p.class, this.a.O3).put(com.ss.android.lark.im.sdk.service.x.class, this.a.P3).put(apb.a.class, this.a.Y0).put(epb.a.class, this.a.U0).put(epb.b.class, this.a.Q3).put(yqb.a.class, this.a.R3).put(com.ss.android.lark.message.lynxcard.monitor.a.class, this.a.S3).put(MyAIService.class, this.a.T3).put(rsb.a.class, this.a.U3).put(rsb.b.class, this.a.V3).put(ysb.a.class, this.a.W3).put(ysb.b.class, this.a.X3).put(zsb.a.class, this.a.Y3).put(zsb.c.class, this.a.Z3).put(etb.a.class, this.a.a4).put(etb.b.class, this.a.b4).put(etb.d.class, this.a.c4).put(IOnlineOfflineService.class, this.a.g4).put(IOfficeAppBaseInfo.class, this.a.h4).put(gtb.a.class, this.a.i4).put(itb.a.class, this.a.j4).put(itb.c.class, this.a.k4).put(itb.d.class, this.a.l4).put(itb.e.class, this.a.m4).put(qtb.b.class, this.a.n4).put(stb.a.class, this.a.o4).put(com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.a.class, this.a.p4).put(com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b.class, this.a.q4).put(IPermissionRequester.class, this.a.r4).put(owb.b.class, this.a.s4).put(com.ss.android.lark.passport.auth.e.class, this.a.t4).put(com.ss.android.lark.passport.auth.f.class, this.a.u4).put(com.ss.android.lark.passport.auth.g.class, this.a.v4).put(ryb.a.class, this.a.w4).put(com.ss.android.lark.passport.dpop.a.class, this.a.x4).put(com.ss.android.lark.passport.dpop.b.class, this.a.e4).put(zyb.c.class, this.a.T).put(zyb.d.class, this.a.y4).put(zyb.e.class, this.a.z4).put(szb.d.class, this.a.A4).put(IUserListService.class, this.a.i0).put(yzb.b.class, this.a.j0).put(zzb.a.class, this.a.B4).put(com.ss.android.lark.passportc.api.i.class, this.a.c0).put(com.ss.android.lark.passportc.api.j.class, this.a.v0).put(com.ss.android.lark.passportc.convention.a.class, this.a.C4).put(com.ss.android.lark.passportc.internal.b.class, this.a.f0).put(com.ss.android.lark.passportc.internal.k.class, this.a.f0).put(com.ss.android.lark.passportc.internal.v.class, this.a.f0).put(l0c.c.class, this.a.U).put(IPrimaryTabService.class, this.a.D4).put(com.ss.android.lark.profile.core.di.a.class, this.a.E4).put(x1c.d.class, this.a.F4).put(m2c.a.class, this.a.G4).put(m2c.b.class, this.a.H4).put(IAppStateSyncService.class, this.a.o2).put(g3c.a.class, this.a.I4).put(com.ss.android.lark.rustinfrabridge.netstate.api.a.class, this.a.J4).put(k3c.a.class, this.a.K4).put(com.ss.android.lark.screenprotect.userscope.a.class, this.a.M4).put(com.ss.android.lark.screenprotect.userscope.b.class, this.a.N4).put(a4c.a.class, this.a.O4).put(a4c.b.class, this.a.O4).put(b4c.a.class, this.a.O4).put(b4c.b.class, this.a.O4).put(b4c.c.class, this.a.O4).put(b4c.d.class, this.a.P4).put(ISecurityComplianceApi.class, this.a.Q4).put(p4c.b.class, this.a.q3).put(y4c.a.class, this.a.R4).put(z4c.b.class, this.a.S4).put(o5c.b.class, this.a.T4).put(e6c.a.class, this.a.U4).put(e6c.b.class, this.a.V4).put(e6c.c.class, this.a.W4).put(com.ss.android.lark.tab.service.i.class, this.a.X4).put(com.ss.android.lark.tab.service.l.class, this.a.Y4).put(com.ss.android.lark.tab.service.m.class, this.a.Z4).put(IChatTabService.class, this.a.a5).put(ITodoApi.class, this.a.b5).put(com.ss.android.lark.translate.service.impl.a.class, this.a.c5).put(com.ss.android.lark.utils.g0.class, this.a.d5).put(com.ss.android.lark.watermark.userscope.c.class, this.a.e5).put(com.ss.android.lark.watermark.v2.p.class, this.a.f5).put(ucc.a.class, this.a.g5).put(com.ss.android.lark.widget.photo.preview.video.pip.b.class, this.a.h5).put(jkc.c.class, this.a.i5).put(doc.c.class, this.a.j5).put(doc.d.class, this.a.k5).put(doc.e.class, this.a.l5).put(com.suite.lark.emm.impl.clipboard.userscope.export.a.class, this.a.m5).put(soc.a.class, this.a.n5).put(com.suite.lark.platform.component.storage.clean.k.class, this.a.p5).put(yoc.h.class, this.a.q5).put(IBillingTipsDependency.class, this.a.r5).put(mpc.e.class, this.a.s5).put(aza.c.class, this.b.c).put(utb.a.class, this.b.d).put(com.ss.android.lark.passport.assemble.c.class, this.b.e).build();
        }

        public a(o r1, l r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final DwarfSPI dwarfSPI() {
        return (o0) this.g.get();
    }

    @Override // com.ss.android.lark.officesdk.k0, com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_DwarfViewModelCollectorEntryPoint
    /* JADX INFO: renamed from: dwarfViewModelCollector */
    public final OfficeSDKGlobalComponent_DwarfViewModelCollector mo38dwarfViewModelCollector() {
        return new OfficeSDKGlobalComponent_DwarfViewModelCollector(Collections.emptyMap(), Collections.emptyMap());
    }

    @Override // com.ss.android.lark.officesdk.k0, com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_FactoryFactoryEntryPoint
    /* JADX INFO: renamed from: factoryFactoryCollector */
    public final OfficeSDKGlobalComponent_FactoryFactoryCollector mo41factoryFactoryCollector() {
        return new OfficeSDKGlobalComponent_FactoryFactoryCollector(this.a.h6);
    }

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKGlobalEntryPoint
    public final OfficeSDKGlobalApi getOfficeSDKGlobalApi() {
        return (OfficeSDKGlobalApi) this.i.get();
    }

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKGlobalEntryPoint
    public final IOfficeSDKLifeCycle getOfficeSDKLifeCycle() {
        return (IOfficeSDKLifeCycle) this.a.j6.get();
    }

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKGlobalEntryPoint
    public final IUserManager getUserManager() {
        return (IUserManager) this.h.get();
    }

    public l(o r3) {
        this.a = r3;
        this.b = DoubleCheck.provider(new a(r3, this, 3));
        this.c = DoubleCheck.provider(new a(r3, this, 2));
        this.d = DoubleCheck.provider(new a(r3, this, 4));
        this.e = DoubleCheck.provider(new a(r3, this, 5));
        this.f = new a(r3, this, 1);
        this.g = DoubleCheck.provider(new a(r3, this, 0));
        this.h = DoubleCheck.provider(new a(r3, this, 6));
        this.i = DoubleCheck.provider(new a(r3, this, 7));
    }
}
