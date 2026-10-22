package com.ss.android.lark.officesdk;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.lark.lark_biz_feed_android_wrapper.FeedRepositoryServiceDaggerModule_ProvidesFeedBadgeServiceFactory;
import com.bytedance.lark.lark_biz_feed_android_wrapper.FeedRepositoryServiceDaggerModule_ProvidesFeedRepositoryServiceExportedModuleFactory;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.chameleon.AbsChameleonJsRuntime;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import com.ss.android.lark.feed.molten.FeedMoltenModuleIncluded_ProvidesSuspendStrategyFactory;
import com.ss.android.lark.feed.molten.FeedMoltenModuleIncluded_ProvidesUserForegroundScopeFactory;
import com.ss.android.lark.flow.chat.setting.FlowHumansChatSettingsServiceImpl;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.integrator.im.impl.IIMUserServiceImpl;
import com.ss.android.lark.integrator.im.impl.IIMUserServiceImpl_Factory;
import com.ss.android.lark.integrator.security.compliance.export.SecurityFileCryptoService;
import com.ss.android.lark.integrator.security.compliance.export.WatermarkService;
import com.ss.android.lark.myai.export.MyAIService;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.applink.OfficeSDKAppLinkServiceImpl;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponentManager;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent_DwarfViewModelCollector;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent_FactoryFactoryCollector;
import com.ss.android.lark.officesdk.feed.impl.FeedOfficeSdkServiceImpl;
import com.ss.android.lark.officesdk.minutes.assembly.fileupload.MmMinutesFileUploadCapacityImpl;
import com.ss.android.lark.officesdk.minutes.assembly.fileupload.MmMinutesFileUploadCapacityImpl_Factory;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl_Factory;
import com.ss.android.lark.passport.flow.mfa.FlowMfaEngine;
import com.ss.android.lark.picker.doubao.api.IDoubaoPicker;
import com.ss.android.lark.picker.doubao.assembly.DoubaoPickerImpl;
import com.ss.android.lark.tab.service.IChatTabService;
import com.ss.android.lark.watermark.userscope.WatermarkImplFactoryV3;
import com.suite.lark.platform.feature.forward.doubao.assembly.ForwardDoubaoApiImpl;
import dagger.hilt.dwarf.spi.DwarfSPI;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class x extends p0 {
    public Provider<q3c.b> A;
    public Provider<ForwardDoubaoApiImpl> B;
    public a C;
    public Provider<t0> D;
    public Provider<com.ss.android.lark.officesdk.internal.h> E;
    public final y a;
    public Provider<mk5.a> b;
    public Provider<com.bytedance.ee.bear.n> c;
    public Provider<FlowHumansChatSettingsServiceImpl> d;
    public Provider<com.ss.android.lark.flow.chat.mediapreview.c> e;
    public Provider<com.ss.android.lark.integrator.im.impl.h> f;
    public Provider<rmb.a> g;
    public Provider<xmb.a> h;
    public Provider<smb.e> i;
    public Provider<com.ss.android.lark.integrator.im.impl.feed.a> j;
    public Provider<IIMUserServiceImpl> k;
    public Provider<vmb.b> l;
    public Provider<com.ss.android.lark.integrator.security.compliance.export.a> m;
    public Provider<SecurityFileCryptoService> n;
    public Provider<WatermarkService> o;
    public Provider<OfficeSDKAppLinkServiceImpl> p;
    public Provider<com.ss.android.lark.officesdk.contact.impl.b> q;
    public Provider<FeedOfficeSdkServiceImpl> r;
    public Provider<com.ss.android.lark.officesdk.miaoda.impl.a> s;
    public Provider<MmMinutesFileUploadCapacityImpl> t;
    public Provider<vub.b> u;
    public Provider<MmRecordingCapacityImpl> v;
    public Provider<pwb.a> w;
    public Provider<pyb.a> x;
    public Provider<DoubaoPickerImpl> y;
    public Provider<q3c.a> z;

    public static final class a<T> implements Provider<T> {
        public final y a;
        public final x b;
        public final int c;

        /* JADX WARN: Type inference failed for: r1v0, types: [T, com.ss.android.lark.officesdk.t0] */
        /* JADX WARN: Type inference failed for: r1v215, types: [T, com.ss.android.lark.integrator.im.impl.IIMUserServiceImpl] */
        /* JADX WARN: Type inference failed for: r1v250, types: [T, com.ss.android.lark.officesdk.minutes.assembly.fileupload.MmMinutesFileUploadCapacityImpl] */
        /* JADX WARN: Type inference failed for: r1v251, types: [T, com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl] */
        public final T get() {
            switch(this.c) {
                case 0: goto L64;
                case 1: goto L63;
                case 2: goto L61;
                case 3: goto L59;
                case 4: goto L56;
                case 5: goto L55;
                case 6: goto L53;
                case 7: goto L51;
                case 8: goto L49;
                case 9: goto L47;
                case 10: goto L45;
                case 11: goto L43;
                case 12: goto L41;
                case 13: goto L39;
                case 14: goto L36;
                case 15: goto L35;
                case 16: goto L33;
                case 17: goto L31;
                case 18: goto L28;
                case 19: goto L27;
                case 20: goto L24;
                case 21: goto L23;
                case 22: goto L20;
                case 23: goto L19;
                case 24: goto L17;
                case 25: goto L15;
                case 26: goto L13;
                case 27: goto L11;
                case 28: goto L9;
                case 29: goto L6;
                default: goto L5;
            };
        L6:
            y r1 = this.a;
            return (T) new com.ss.android.lark.officesdk.internal.h(r1.b, (OfficeSDKUserComponentManager) r1.a4.get(), (com.bytedance.lark.sdk.refactor.n) Preconditions.checkNotNullFromComponent(((o) this.a.a).J4()));
        L20:
            x r0 = this.b;
            ?? r2 = (T) MmRecordingCapacityImpl_Factory.newInstance();
            r2.a = (com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a) r0.a.b4.get();
            r2.g();
            return r2;
        L24:
            x r3 = this.b;
            ?? r4 = (T) MmMinutesFileUploadCapacityImpl_Factory.newInstance();
            r4.a = (com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a) r3.a.b4.get();
            return r4;
        L28:
            y r5 = this.a;
            return (T) new FeedOfficeSdkServiceImpl(r5.b, (com.bytedance.lark.sdk.refactor.n) Preconditions.checkNotNullFromComponent(((o) r5.a).J4()), (com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L36:
            y r6 = this.a;
            return (T) new SecurityFileCryptoService(r6.b, (jkc.c) r6.R3.get());
        L56:
            x r7 = this.b;
            y r8 = this.a;
            com.bytedance.lark.lark_biz_feed_android_wrapper.a r9 = r8.p;
            ?? r10 = (T) IIMUserServiceImpl_Factory.newInstance(FeedRepositoryServiceDaggerModule_ProvidesFeedBadgeServiceFactory.providesFeedBadgeService(r9, FeedRepositoryServiceDaggerModule_ProvidesFeedRepositoryServiceExportedModuleFactory.providesFeedRepositoryServiceExportedModule(r9, FeedMoltenModuleIncluded_ProvidesUserForegroundScopeFactory.providesUserForegroundScope(r8.q, r8.k), FeedMoltenModuleIncluded_ProvidesSuspendStrategyFactory.providesSuspendStrategy(r8.q, (com.ss.android.lark.passportc.api.m) r8.v.get()))), (com.ss.android.lark.flow.feed.data.a) this.a.c3.get(), (com.ss.android.lark.passportc.api.m) this.a.v.get());
            ((IIMUserServiceImpl) r10).d = (com.ss.android.lark.chatwindow.launcher.c) r7.a.H2.get();
            ((IIMUserServiceImpl) r10).e = (aza.b) r7.d.get();
            ((IIMUserServiceImpl) r10).f = (kza.h) r7.e.get();
            ((IIMUserServiceImpl) r10).g = (bza.a) r7.f.get();
            ((IIMUserServiceImpl) r10).h = (cza.a) r7.g.get();
            ((IIMUserServiceImpl) r10).i = (nza.b) r7.h.get();
            ((IIMUserServiceImpl) r10).j = (dza.b) r7.i.get();
            ((IIMUserServiceImpl) r10).k = (fza.a) r7.j.get();
            return r10;
        L64:
            x r11 = this.b;
            ?? r12 = (T) HiltRoot_HiltComponents_OfficeSDKUserCServiceProvider_Factory.newInstance();
            r12.a = DoubleCheck.lazy(r11.C);
            return r12;
        L5:
            throw new AssertionError(this.c);
        L9:
            return (T) new ForwardDoubaoApiImpl();
        L11:
            return (T) new q3c.b();
        L13:
            return (T) new q3c.a();
        L15:
            return (T) new DoubaoPickerImpl();
        L17:
            return (T) new pyb.a((FlowMfaEngine) this.a.q3.get());
        L19:
            return (T) new pwb.a();
        L23:
            return (T) new vub.b();
        L27:
            return (T) new com.ss.android.lark.officesdk.miaoda.impl.a((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L31:
            return (T) new com.ss.android.lark.officesdk.contact.impl.b();
        L33:
            return (T) new OfficeSDKAppLinkServiceImpl();
        L35:
            return (T) new WatermarkService((WatermarkImplFactoryV3) this.a.M3.get(), (com.ss.android.lark.watermark.userscope.c) this.a.N3.get());
        L39:
            return (T) new com.ss.android.lark.integrator.security.compliance.export.a();
        L41:
            return (T) new vmb.b((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.bytedance.lark.rustclient.api.l) this.a.T.get(), (com.ss.android.lark.feed.shared.page.t) this.a.q1.get(), (com.ss.android.lark.feed.shared.page.u) this.a.p4.get(), (com.ss.android.lark.flow.feed.data.a) this.a.c3.get());
        L43:
            return (T) new com.ss.android.lark.integrator.im.impl.feed.a();
        L45:
            return (T) new smb.e();
        L47:
            return (T) new xmb.a();
        L49:
            return (T) new rmb.a();
        L51:
            return (T) new com.ss.android.lark.integrator.im.impl.h();
        L53:
            return (T) new com.ss.android.lark.flow.chat.mediapreview.c();
        L55:
            return (T) new FlowHumansChatSettingsServiceImpl();
        L59:
            return (T) new com.bytedance.ee.bear.n((ik5.a) this.a.L.get(), (com.bytedance.ee.bear.office.export.space.a) this.a.M.get(), (com.bytedance.ee.bear.init.a) Preconditions.checkNotNullFromComponent((com.bytedance.ee.bear.init.a) ((o) this.a.a).R.get()), (com.bytedance.ee.bear.init.b) this.a.J.get(), (t45.c) this.a.F.get());
        L61:
            return (T) new mk5.a();
        L63:
            return (T) MapBuilder.newMapBuilder(188).put(com.bytedance.ee.bear.h.class, this.a.A1).put(an4.a.class, this.a.B1).put(dn4.a.class, this.a.C1).put(com.bytedance.ee.bear.bitable.core.usercomponent.a.class, this.a.D1).put(ks4.k.class, this.a.t).put(com.bytedance.ee.bear.bitable.homepage.chart.datasource.e.class, this.a.s).put(ew4.w.class, this.a.E1).put(ew4.x.class, this.a.F1).put(ew4.y.class, this.a.G1).put(ew4.z.class, this.a.H1).put(ew4.a0.class, this.a.I1).put(ew4.b0.class, this.a.J1).put(ew4.c0.class, this.a.K1).put(ew4.e0.class, this.a.L1).put(ew4.f0.class, this.a.M1).put(ew4.g0.class, this.a.N1).put(com.bytedance.ee.bear.contract.a0.class, this.a.H).put(com.bytedance.ee.bear.contract.h0.class, this.a.O).put(NetService.class, this.a.z).put(by4.c.class, this.a.O1).put(by4.d.class, this.a.B).put(yz4.a.class, this.a.P1).put(x05.a.class, this.a.K).put(com.bytedance.ee.bear.document.knowledgeai.a.class, this.a.Q1).put(com.bytedance.ee.bear.document.template.a.class, this.a.G).put(s45.c.class, this.a.C).put(t45.c.class, this.a.F).put(com.bytedance.ee.bear.drive.cache.w.class, this.a.R1).put(o75.a.class, this.a.S1).put(t75.a.class, this.a.T1).put(com.bytedance.ee.bear.drive.sdk.service.f.class, this.a.U1).put(com.bytedance.ee.bear.drive.services.c.class, this.a.V1).put(com.bytedance.ee.bear.drive.services.w.class, this.a.W1).put(com.bytedance.ee.bear.init.b.class, this.a.J).put(hb5.a.class, this.a.X1).put(com.bytedance.ee.bear.lark.dependency.t.class, this.a.Y1).put(com.bytedance.ee.bear.lark.dependency.a0.class, this.a.Z1).put(com.bytedance.ee.bear.lark.dependency.c0.class, this.a.a2).put(mc5.j.class, this.a.R).put(com.bytedance.ee.bear.middleground.permission.apply.c0.class, this.a.b2).put(ii5.b.class, this.a.c2).put(cj5.c.class, this.a.d2).put(ik5.a.class, this.a.L).put(com.bytedance.ee.bear.office.export.space.a.class, this.a.M).put(com.bytedance.ee.bear.route.h.class, this.a.Q).put(gm5.a.class, this.a.e2).put(hm5.a.class, this.a.f2).put(mo5.e.class, this.a.g2).put(BenefitManagerAPI.class, this.a.S).put(com.bytedance.ee.drive.preview.f.class, this.a.h2).put(zt5.a.class, this.a.i2).put(com.bytedance.ee.space.sync.b.class, this.a.j2).put(com.bytedance.ee.util.db.a.class, this.a.N).put(yra.e.class, this.a.k2).put(com.ss.android.lark.audio.voiceinput.service.k.class, this.a.d0).put(IAudioService.class, this.a.e0).put(com.ss.android.lark.audio.voiceinput.service.l.class, this.a.R0).put(com.ss.android.lark.audio.voiceinput.service.m.class, this.a.Q0).put(com.ss.android.lark.audio.voiceinput.service.o.class, this.a.N0).put(com.ss.android.lark.audio.voiceinput.service.p.class, this.a.M0).put(com.ss.android.lark.audit.userscope.audit.l.class, this.a.o2).put(com.ss.android.lark.auditsdk.v2.receivecheck.cache.a.class, this.a.p2).put(com.ss.android.lark.biz.im.api.o0.class, this.a.g0).put(com.ss.android.lark.biz.im.api.message.audit.f.class, this.a.q2).put(AbsChameleonJsRuntime.class, this.a.r2).put(q1b.a.class, this.a.s2).put(v1b.a.class, this.a.X).put(IChatService.class, this.a.c0).put(a2b.c.class, this.a.L0).put(a2b.d.class, this.a.K0).put(a2b.e.class, this.a.m0).put(a2b.f.class, this.a.n0).put(a2b.g.class, this.a.s0).put(a2b.h.class, this.a.t0).put(a2b.i.class, this.a.i1).put(a2b.j.class, this.a.E0).put(a2b.k.class, this.a.u0).put(a2b.l.class, this.a.j1).put(ITranslateService.class, this.a.p0).put(a2b.n.class, this.a.X0).put(a2b.o.class, this.a.D0).put(com.ss.android.lark.chat.api.service.impl.t0.class, this.a.o0).put(com.ss.android.lark.chat.api.service.impl.usergroup.b.class, this.a.W0).put(com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d.class, this.a.h1).put(com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b.class, this.a.b1).put(com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a.class, this.a.q0).put(com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b.class, this.a.r0).put(com.ss.android.lark.chat.chatwindow.chat.v2.push.v.class, this.a.n1).put(com.ss.android.lark.chat.chatwindow.chat.v2.push.z.class, this.a.k1).put(com.ss.android.lark.chat.core.api.d.class, this.a.l1).put(w4b.c.o.class, this.a.a0).put(com.ss.android.lark.chat.export.offlineCacheClean.a.class, this.a.o1).put(com.ss.android.lark.chat.name.f.class, this.a.t2).put(l6b.a.class, this.a.j0).put(m6b.a.class, this.a.P0).put(m6b.d.class, this.a.y0).put(m6b.g.class, this.a.k0).put(m6b.j.class, this.a.v0).put(m6b.m.class, this.a.i0).put(m6b.n.class, this.a.w0).put(m6b.q.class, this.a.J0).put(m6b.s.class, this.a.u2).put(m6b.t.class, this.a.F0).put(m6b.u.class, this.a.v2).put(x6b.a.class, this.a.w2).put(com.ss.android.lark.chatwindow.launcher.c.class, this.a.H2).put(k8b.c.class, this.a.I2).put(com.ss.android.lark.conditional.access.display.g.class, this.a.L2).put(ConditionalAccessNetDependency.class, this.a.N2).put(com.ss.android.lark.conditional.access.traffic.handler.policy.center.a.class, this.a.O2).put(com.ss.android.lark.create.groupchat.impl.service.h.class, this.a.X2).put(qbb.a.class, this.a.Y2).put(scb.b.class, this.a.Z2).put(jeb.d.class, this.a.a3).put(neb.a.class, this.a.b3).put(oeb.d.class, this.a.p1).put(com.ss.android.lark.flow.feed.data.a.class, this.a.c3).put(com.ss.android.lark.forwardv3.forward.mediaforward.f.class, this.a.d3).put(com.ss.android.lark.framework.assembly.rust.d.class, this.a.e3).put(com.ss.android.lark.im.sdk.service.e.class, this.a.f3).put(ImSdkChatService.class, this.a.Y0).put(com.ss.android.lark.im.sdk.service.h.class, this.a.Z0).put(com.ss.android.lark.im.sdk.service.p.class, this.a.x0).put(com.ss.android.lark.im.sdk.service.x.class, this.a.a1).put(yqb.a.class, this.a.P).put(com.ss.android.lark.message.lynxcard.monitor.a.class, this.a.g3).put(MyAIService.class, this.a.h3).put(rsb.a.class, this.a.i3).put(rsb.b.class, this.a.j3).put(ysb.a.class, this.a.k3).put(ysb.b.class, this.a.l3).put(zsb.a.class, this.a.m3).put(zsb.c.class, this.a.n3).put(INotificationHitPoint.class, this.a.o3).put(com.ss.android.lark.passport.b.class, this.a.p3).put(yyb.b.class, this.a.r3).put(com.ss.android.lark.passportc.api.m.class, this.a.v).put(com.ss.android.lark.profile.core.di.a.class, this.a.s3).put(m2c.a.class, this.a.u3).put(m2c.b.class, this.a.t3).put(g3c.a.class, this.a.v3).put(k3c.a.class, this.a.w3).put(a4c.a.class, this.a.x3).put(a4c.b.class, this.a.x3).put(b4c.a.class, this.a.x3).put(b4c.b.class, this.a.x3).put(b4c.c.class, this.a.x3).put(b4c.d.class, this.a.y3).put(y4c.a.class, this.a.z3).put(z4c.b.class, this.a.A3).put(o5c.b.class, this.a.B3).put(e6c.a.class, this.a.C3).put(e6c.b.class, this.a.D3).put(e6c.c.class, this.a.E3).put(com.ss.android.lark.tab.service.i.class, this.a.V0).put(com.ss.android.lark.tab.service.l.class, this.a.C0).put(com.ss.android.lark.tab.service.m.class, this.a.T0).put(IChatTabService.class, this.a.A0).put(com.ss.android.lark.translate.service.impl.a.class, this.a.H0).put(com.ss.android.lark.watermark.userscope.c.class, this.a.N3).put(com.ss.android.lark.watermark.v2.p.class, this.a.L3).put(ucc.a.class, this.a.O3).put(com.ss.android.lark.widget.photo.preview.video.pip.b.class, this.a.P3).put(jkc.c.class, this.a.R3).put(doc.e.class, this.a.U3).put(soc.a.class, this.a.W3).put(yoc.h.class, this.a.X3).put(gk5.d.class, this.b.b).put(gk5.e.class, this.b.c).put(aza.d.class, this.b.k).put(vmb.a.class, this.b.l).put(com.ss.android.lark.integrator.security.compliance.export.b.class, this.b.m).put(com.ss.android.lark.integrator.security.compliance.export.c.class, this.b.n).put(com.ss.android.lark.integrator.security.compliance.export.d.class, this.b.o).put(com.ss.android.lark.officesdk.applink.a.class, this.b.p).put(ktb.a.class, this.b.q).put(qtb.a.class, this.b.r).put(dub.a.class, this.b.s).put(eub.a.class, this.b.t).put(com.ss.android.lark.officesdk.minutes.api.hardware.a.class, this.b.u).put(hub.a.class, this.b.v).put(tub.a.class, this.b.v).put(owb.a.class, this.b.w).put(azb.a.class, this.b.x).put(IDoubaoPicker.class, this.b.y).put(p3c.a.class, this.b.z).put(p3c.b.class, this.b.A).put(mpc.f.class, this.b.B).build();
        }

        public a(y r1, x r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final DwarfSPI dwarfSPI() {
        return (t0) this.D.get();
    }

    @Override // com.ss.android.lark.officesdk.p0, com.ss.android.lark.officesdk.container.OfficeSDKUserComponent_DwarfViewModelCollectorEntryPoint
    /* JADX INFO: renamed from: dwarfViewModelCollector */
    public final OfficeSDKUserComponent_DwarfViewModelCollector mo43dwarfViewModelCollector() {
        return new OfficeSDKUserComponent_DwarfViewModelCollector(this.a.z1(), Collections.emptyMap());
    }

    @Override // com.ss.android.lark.officesdk.p0, com.ss.android.lark.officesdk.container.OfficeSDKUserComponent_FactoryFactoryEntryPoint
    /* JADX INFO: renamed from: factoryFactoryCollector */
    public final OfficeSDKUserComponent_FactoryFactoryCollector mo46factoryFactoryCollector() {
        return new OfficeSDKUserComponent_FactoryFactoryCollector(this.a.m4);
    }

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKUserEntryPoint
    public final OfficeSDKUserApi getOfficeSDKUserApi() {
        return (OfficeSDKUserApi) this.E.get();
    }

    public x(y r3) {
        this.a = r3;
        this.b = DoubleCheck.provider(new a(r3, this, 2));
        this.c = DoubleCheck.provider(new a(r3, this, 3));
        this.d = DoubleCheck.provider(new a(r3, this, 5));
        this.e = DoubleCheck.provider(new a(r3, this, 6));
        this.f = DoubleCheck.provider(new a(r3, this, 7));
        this.g = DoubleCheck.provider(new a(r3, this, 8));
        this.h = DoubleCheck.provider(new a(r3, this, 9));
        this.i = DoubleCheck.provider(new a(r3, this, 10));
        this.j = DoubleCheck.provider(new a(r3, this, 11));
        this.k = DoubleCheck.provider(new a(r3, this, 4));
        this.l = DoubleCheck.provider(new a(r3, this, 12));
        this.m = DoubleCheck.provider(new a(r3, this, 13));
        this.n = DoubleCheck.provider(new a(r3, this, 14));
        this.o = DoubleCheck.provider(new a(r3, this, 15));
        this.p = DoubleCheck.provider(new a(r3, this, 16));
        this.q = DoubleCheck.provider(new a(r3, this, 17));
        this.r = DoubleCheck.provider(new a(r3, this, 18));
        this.s = DoubleCheck.provider(new a(r3, this, 19));
        this.t = DoubleCheck.provider(new a(r3, this, 20));
        this.u = DoubleCheck.provider(new a(r3, this, 21));
        this.v = DoubleCheck.provider(new a(r3, this, 22));
        this.w = DoubleCheck.provider(new a(r3, this, 23));
        this.x = DoubleCheck.provider(new a(r3, this, 24));
        this.y = DoubleCheck.provider(new a(r3, this, 25));
        this.z = DoubleCheck.provider(new a(r3, this, 26));
        this.A = DoubleCheck.provider(new a(r3, this, 27));
        this.B = DoubleCheck.provider(new a(r3, this, 28));
        this.C = new a(r3, this, 1);
        this.D = DoubleCheck.provider(new a(r3, this, 0));
        this.E = DoubleCheck.provider(new a(r3, this, 29));
    }
}
