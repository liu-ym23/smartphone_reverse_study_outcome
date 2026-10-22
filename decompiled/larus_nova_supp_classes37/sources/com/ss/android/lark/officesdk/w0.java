package com.ss.android.lark.officesdk;

import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.im.base.ImBaseBizModule;
import com.ss.android.lark.officesdk.api.OnlineOfflineInterface;
import com.ss.android.lark.officesdk.container.HiltWrapper_S2OGEntryPoint;
import com.ss.android.lark.officesdk.container.OfficeSDKConfigProviderModule;
import com.ss.android.lark.officesdk.launcher.OfficeSDKAppLauncher;
import com.ss.android.lark.officesdk.launcher.feed.OfficeSDKFeedAppLauncher;
import com.ss.android.lark.officesdk.launcher.load.OfficeLoadCoordinator;
import com.ss.android.lark.vote.VoteModule;
import dagger.Component;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory;
import dagger.hilt.android.dwarf.internal.lifecycle.HiltWrapper_DwarfViewModelFactories_SingletonModule;
import dagger.hilt.android.dwarf.internal.lifecycle.HiltWrapper_DwarfViewModelFactory_SingletonModule;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.dwarf.spi.DwarfSPI;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import dagger.hilt.internal.GeneratedComponent;
import javax.inject.Singleton;
import mc5.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Component(modules = {yra.c.class, com.bytedance.lark.sdk.refactor.a.class, ym4.a.class, com.ss.android.lark.officesdk.applog.impl.a.class, ApplicationContextModule.class, com.ss.android.lark.audit.userscope.audit.f.class, o0b.b.class, com.ss.android.lark.biz.im.api.message.audit.c.class, twa.a.class, com.ss.android.lark.audit.userscope.auth.i.class, com.ss.android.lark.officesdk.demo.dependency.a.class, bj5.a.class, com.bytedance.ee.bear.bitable.core.usercomponent.e.class, com.ss.android.lark.flow.bottomsheet.a.class, com.bytedance.ee.bear.basesdk.services.container.a.class, com.ss.android.lark.chat.chatwindow.chat.v2.push.a.class, com.ss.android.lark.chatwindow.launcher.a.class, com.ss.android.lark.chat.name.d.class, m0b.b.class, com.ss.android.lark.integrator.security.compliance.a.class, com.ss.android.lark.core.storage.c.class, com.ss.android.lark.create.groupchat.impl.service.e.class, com.ss.android.lark.chat.chatwindow.chat.preloaderv2.a.class, um4.c.class, com.ss.android.lark.officesdk.demo.dependency.c.class, com.ss.android.lark.conditional.access.display.f.class, tz4.c.class, com.suite.lark.platform.feature.forward.doubao.assembly.b.class, cnb.b.class, smb.b.class, com.bytedance.ee.bear.drive.services.b.class, o85.c.class, o85.e.class, vsb.a.class, com.ss.android.lark.officesdk.feed.impl.b.class, heb.b.class, oeb.b.class, sm4.c.class, vm4.c.class, zoc.c.class, ohb.b.class, smb.d.class, com.ss.android.lark.forwardv3.forward.mediaforward.e.class, com.ss.android.lark.passportc.task.b.class, com.bytedance.lark.rustclient.a.class, com.bytedance.lark.rustclient.b.class, woc.a.class, d0.class, m0.class, v0.class, x0.class, y0.class, HiltWrapper_DwarfViewModelFactories_SingletonModule.class, HiltWrapper_DwarfViewModelFactory_SingletonModule.class, com.ss.android.lark.framework.assembly.rust.b.class, com.ss.android.lark.passportc.internal.q.class, com.ss.android.lark.im.base.e.class, k1.class, com.ss.android.lark.im.sdk.b.class, q1b.b.class, com.larksuite.framework.http.v2.internal.main.c.class, w1.class, com.ss.android.lark.message.lynxcard.monitor.c.class, wmb.b.class, com.ss.android.lark.integrator.ccm.dependency.di.h0.class, com.ss.android.lark.officesdk.minutes.assembly.recording.common.d.class, nb5.a.class, g3c.b.class, tmb.b.class, sb5.a.class, com.ss.android.lark.officesdk.launcher.load.b.class, ftb.a.class, t1c.a.class, ftb.c.class, jtb.e.class, OfficeSDKConfigProviderModule.class, com.ss.android.lark.officesdk.internal.d.class, ymb.c.class, anb.b.class, bnb.b.class, cnb.d.class, ftb.e.class, com.ss.android.lark.chat.export.offlineCacheClean.d.class, k25.k0.class, com.bytedance.ee.bear.lark.dependency.m0.class, zt5.b.class, com.ss.android.lark.officesdk.permission.impl.a.class, gi5.c.class, com.ss.android.lark.conditional.access.traffic.handler.policy.center.b.class, com.ss.android.lark.integrator.security.compliance.l.class, com.ss.android.lark.profile.core.di.b.class, com.ss.android.lark.integrator.ccm.dependency.di.k1.class, soc.b.class, pwb.c.class, com.ss.android.lark.reaction.userscope.a.class, zn4.a.class, nwb.g.class, com.ss.android.lark.framework.assembly.rust.t.class, com.bytedance.lark.sdk.refactor.h0.class, com.ss.lark.android.encryption.userscope.a.class, doc.g.class, com.ss.android.lark.screenprotect.userscope.f.class, inb.c.class, y4c.b.class, com.ss.android.lark.search.doubao.env.c.class, com.ss.android.lark.chat.api.service.impl.secret.a.class, com.bytedance.ee.space.services.a.class, x5c.d.class, com.ss.android.lark.sticker.core.di.b.class, com.ss.android.lark.officesdk.integrator.im.impl.s.class, com.bytedance.ee.bear.tts.service.a.class, com.ss.android.lark.chat.chatwindow.chat.v2.push.o0.class, v1b.d.class, com.bytedance.ee.util.db.container.b.class, vmb.d.class, com.ss.android.lark.passport.c.class, rtb.b.class, qbb.d.class, j3c.a.class, ucc.b.class, com.ss.android.lark.watermark.userscope.l.class, com.ss.android.lark.watermark.userscope.t.class})
@Singleton
public abstract class w0 implements ova.c, bwa.q, iab.b, lcb.e, ldb.f, FlowChatModule.b, dgb.b, com.ss.android.lark.framework.assembly.featuregating.b, ImBaseBizModule.b, umb.a, hpb.a, z, DwarfSPIEntryPoint, OnlineOfflineInterface, HiltWrapper_S2OGEntryPoint, OfficeSDKAppLauncher.b, OfficeSDKFeedAppLauncher.a, OfficeLoadCoordinator.b, c3c.e, com.ss.android.lark.scs.policy.engine.manage.d.b, VoteModule.b, com.suite.lark.emm.impl.a.b, DwarfViewModelFactories.SingletonEntryPoint, DwarfViewModelFactory.SingletonDwarfViewModelCollectorEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint, ServiceComponentManager.ServiceComponentBuilderEntryPoint, SingletonComponent, GeneratedComponent {
    public w0() {
    }

    public DwarfSPI dwarfSPI() {
        return (z0) ((o) this).u5.get();
    }

    public /* bridge */ /* synthetic */ DwarfViewModelFactory.DwarfViewModelCollector dwarfViewModelCollector() {
        return DwarfViewModelFactory.SingletonDwarfViewModelCollectorEntryPoint.-CC.$default$dwarfViewModelCollector(this);
    }

    public /* bridge */ /* synthetic */ DwarfViewModelFactories.FactoryFactoryCollector factoryFactoryCollector() {
        return DwarfViewModelFactories.SingletonEntryPoint.-CC.$default$factoryFactoryCollector(this);
    }
}
