package com.bytedance.android.live.saas.middleware.di;

import com.bytedance.android.live.saas.middleware.BDLiveSdkHelper;
import com.bytedance.android.live.saas.middleware.BDLiveSdkHelper_MembersInjector;
import com.bytedance.android.live.saas.middleware.IBDLiveSdkInit;
import com.bytedance.android.live.saas.middleware.applog.AppLogConfig;
import com.bytedance.android.live.saas.middleware.applog.AppLogProxy;
import com.bytedance.android.live.saas.middleware.applog.AppLogProxy_MembersInjector;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.bytedance.android.live.saas.middleware.applog.di.AppLogModule;
import com.bytedance.android.live.saas.middleware.applog.di.AppLogModule_ProvideFunctionFactory;
import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.baselib.BaseLibConfig;
import com.bytedance.android.live.saas.middleware.baselib.BaseLibProxy;
import com.bytedance.android.live.saas.middleware.baselib.BaseLibProxy_MembersInjector;
import com.bytedance.android.live.saas.middleware.baselib.di.BaseLibModule;
import com.bytedance.android.live.saas.middleware.baselib.di.BaseLibModule_ProvideFunctionFactory;
import com.bytedance.android.live.saas.middleware.fresco.FrescoConfig;
import com.bytedance.android.live.saas.middleware.fresco.FrescoProxy;
import com.bytedance.android.live.saas.middleware.fresco.FrescoProxy_MembersInjector;
import com.bytedance.android.live.saas.middleware.fresco.di.FrescoModule;
import com.bytedance.android.live.saas.middleware.fresco.di.FrescoModule_ProvideFunctionFactory;
import com.bytedance.android.live.saas.middleware.monitor.IMonitorReport;
import com.bytedance.android.live.saas.middleware.monitor.MonitorConfig;
import com.bytedance.android.live.saas.middleware.monitor.MonitorProxy;
import com.bytedance.android.live.saas.middleware.monitor.MonitorProxy_MembersInjector;
import com.bytedance.android.live.saas.middleware.monitor.di.MonitorModule;
import com.bytedance.android.live.saas.middleware.monitor.di.MonitorModule_ProvideFunctionFactory;
import com.bytedance.android.live.saas.middleware.network.NetworkConfig;
import com.bytedance.android.live.saas.middleware.network.NetworkProxy;
import com.bytedance.android.live.saas.middleware.network.NetworkProxy_MembersInjector;
import com.bytedance.android.live.saas.middleware.network.di.CornetModule;
import com.bytedance.android.live.saas.middleware.network.di.CornetModule_ProvideFunctionFactory;
import com.bytedance.android.live.saas.middleware.npth.NpthConfig;
import com.bytedance.android.live.saas.middleware.npth.NpthProxy;
import com.bytedance.android.live.saas.middleware.npth.NpthProxy_MembersInjector;
import com.bytedance.android.live.saas.middleware.npth.di.NpthModule;
import com.bytedance.android.live.saas.middleware.npth.di.NpthModule_ProvideFunctionFactory;
import com.bytedance.android.live.saas.middleware.sec.ISecSdk;
import com.bytedance.android.live.saas.middleware.sec.SecConfig;
import com.bytedance.android.live.saas.middleware.sec.SecProxy;
import com.bytedance.android.live.saas.middleware.sec.SecProxy_MembersInjector;
import com.bytedance.android.live.saas.middleware.sec.di.SecModule;
import com.bytedance.android.live.saas.middleware.sec.di.SecModule_ProvideFunctionFactory;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class Dagger_BDComponent {

    /* JADX INFO: renamed from: com.bytedance.android.live.saas.middleware.di.Dagger_BDComponent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private AppLogModule appLogModule;
        private BDLiveSdkModule bDLiveSdkModule;
        private BaseLibModule baseLibModule;
        private CornetModule cornetModule;
        private FrescoModule frescoModule;
        private MonitorModule monitorModule;
        private NpthModule npthModule;
        private SecModule secModule;

        public _BDComponent build() {
            if (this.npthModule != null) goto L6;
            this.npthModule = new NpthModule();
        L6:
            if (this.baseLibModule != null) goto L9;
            this.baseLibModule = new BaseLibModule();
        L9:
            if (this.appLogModule != null) goto L12;
            this.appLogModule = new AppLogModule();
        L12:
            if (this.bDLiveSdkModule != null) goto L15;
            this.bDLiveSdkModule = new BDLiveSdkModule();
        L15:
            if (this.cornetModule != null) goto L18;
            this.cornetModule = new CornetModule();
        L18:
            if (this.secModule != null) goto L21;
            this.secModule = new SecModule();
        L21:
            if (this.monitorModule != null) goto L24;
            this.monitorModule = new MonitorModule();
        L24:
            if (this.frescoModule != null) goto L27;
            this.frescoModule = new FrescoModule();
        L27:
            return new _BDComponentImpl(this.npthModule, this.baseLibModule, this.appLogModule, this.bDLiveSdkModule, this.cornetModule, this.secModule, this.monitorModule, this.frescoModule, null);
        }

        private Builder() {
        }

        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder appLogModule(AppLogModule r1) {
            this.appLogModule = (AppLogModule) Preconditions.checkNotNull(r1);
            return this;
        }

        public Builder bDLiveSdkModule(BDLiveSdkModule r1) {
            this.bDLiveSdkModule = (BDLiveSdkModule) Preconditions.checkNotNull(r1);
            return this;
        }

        public Builder baseLibModule(BaseLibModule r1) {
            this.baseLibModule = (BaseLibModule) Preconditions.checkNotNull(r1);
            return this;
        }

        public Builder cornetModule(CornetModule r1) {
            this.cornetModule = (CornetModule) Preconditions.checkNotNull(r1);
            return this;
        }

        public Builder frescoModule(FrescoModule r1) {
            this.frescoModule = (FrescoModule) Preconditions.checkNotNull(r1);
            return this;
        }

        public Builder monitorModule(MonitorModule r1) {
            this.monitorModule = (MonitorModule) Preconditions.checkNotNull(r1);
            return this;
        }

        public Builder npthModule(NpthModule r1) {
            this.npthModule = (NpthModule) Preconditions.checkNotNull(r1);
            return this;
        }

        public Builder secModule(SecModule r1) {
            this.secModule = (SecModule) Preconditions.checkNotNull(r1);
            return this;
        }
    }

    public static final class _BDComponentImpl implements _BDComponent {
        private final _BDComponentImpl __BDComponentImpl;
        private final AppLogModule appLogModule;
        private final BDLiveSdkModule bDLiveSdkModule;
        private final BaseLibModule baseLibModule;
        private final CornetModule cornetModule;
        private final FrescoModule frescoModule;
        private final MonitorModule monitorModule;
        private final NpthModule npthModule;
        private final SecModule secModule;

        private Map<FuncType, BaseFunction<IAppLog, AppLogConfig>> namedMapOfFuncTypeAndBaseFunctionOfIAppLogAndAppLogConfig() {
            return Collections.singletonMap(FuncType.TYPE_INHOUSE, AppLogModule_ProvideFunctionFactory.provideFunction(this.appLogModule));
        }

        private Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>> namedMapOfFuncTypeAndBaseFunctionOfIMonitorReportAndMonitorConfig() {
            return Collections.singletonMap(FuncType.TYPE_INHOUSE, MonitorModule_ProvideFunctionFactory.provideFunction(this.monitorModule));
        }

        private Map<FuncType, BaseFunction<ISecSdk, SecConfig>> namedMapOfFuncTypeAndBaseFunctionOfISecSdkAndSecConfig() {
            return Collections.singletonMap(FuncType.TYPE_INHOUSE, SecModule_ProvideFunctionFactory.provideFunction(this.secModule));
        }

        private Map<FuncType, BaseFunction<Object, BaseLibConfig>> namedMapOfFuncTypeAndBaseFunctionOfObjectAndBaseLibConfig() {
            return Collections.singletonMap(FuncType.TYPE_INHOUSE, BaseLibModule_ProvideFunctionFactory.provideFunction(this.baseLibModule));
        }

        private Map<FuncType, BaseFunction<Object, FrescoConfig>> namedMapOfFuncTypeAndBaseFunctionOfObjectAndFrescoConfig() {
            return Collections.singletonMap(FuncType.TYPE_INHOUSE, FrescoModule_ProvideFunctionFactory.provideFunction(this.frescoModule));
        }

        private Map<FuncType, BaseFunction<Object, NetworkConfig>> namedMapOfFuncTypeAndBaseFunctionOfObjectAndNetworkConfig() {
            return Collections.singletonMap(FuncType.TYPE_INHOUSE, CornetModule_ProvideFunctionFactory.provideFunction(this.cornetModule));
        }

        private Map<FuncType, BaseFunction<Object, NpthConfig>> namedMapOfFuncTypeAndBaseFunctionOfObjectAndNpthConfig() {
            return Collections.singletonMap(FuncType.TYPE_INHOUSE, NpthModule_ProvideFunctionFactory.provideFunction(this.npthModule));
        }

        private Set<IBDLiveSdkInit> setOfIBDLiveSdkInit() {
            return Collections.singleton(BDLiveSdkModule_ProvideFunctionFactory.provideFunction(this.bDLiveSdkModule));
        }

        private AppLogProxy injectAppLogProxy(AppLogProxy r2) {
            AppLogProxy_MembersInjector.injectMFunctionMap(r2, namedMapOfFuncTypeAndBaseFunctionOfIAppLogAndAppLogConfig());
            return r2;
        }

        private BDLiveSdkHelper injectBDLiveSdkHelper(BDLiveSdkHelper r2) {
            BDLiveSdkHelper_MembersInjector.injectProviders(r2, setOfIBDLiveSdkInit());
            return r2;
        }

        private BaseLibProxy injectBaseLibProxy(BaseLibProxy r2) {
            BaseLibProxy_MembersInjector.injectMFunctionMap(r2, namedMapOfFuncTypeAndBaseFunctionOfObjectAndBaseLibConfig());
            return r2;
        }

        private FrescoProxy injectFrescoProxy(FrescoProxy r2) {
            FrescoProxy_MembersInjector.injectMFunctionMap(r2, namedMapOfFuncTypeAndBaseFunctionOfObjectAndFrescoConfig());
            return r2;
        }

        private MonitorProxy injectMonitorProxy(MonitorProxy r2) {
            MonitorProxy_MembersInjector.injectMFunctionMap(r2, namedMapOfFuncTypeAndBaseFunctionOfIMonitorReportAndMonitorConfig());
            return r2;
        }

        private NetworkProxy injectNetworkProxy(NetworkProxy r2) {
            NetworkProxy_MembersInjector.injectCornetFunction(r2, namedMapOfFuncTypeAndBaseFunctionOfObjectAndNetworkConfig());
            return r2;
        }

        private NpthProxy injectNpthProxy(NpthProxy r2) {
            NpthProxy_MembersInjector.injectMFunctionMap(r2, namedMapOfFuncTypeAndBaseFunctionOfObjectAndNpthConfig());
            return r2;
        }

        private SecProxy injectSecProxy(SecProxy r2) {
            SecProxy_MembersInjector.injectTaskMap(r2, namedMapOfFuncTypeAndBaseFunctionOfISecSdkAndSecConfig());
            return r2;
        }

        @Override // com.bytedance.android.live.saas.middleware.di._BDComponent
        public void inject(BDLiveSdkHelper r1) {
            injectBDLiveSdkHelper(r1);
        }

        @Override // com.bytedance.android.live.saas.middleware.di._BDComponent
        public void inject(AppLogProxy r1) {
            injectAppLogProxy(r1);
        }

        @Override // com.bytedance.android.live.saas.middleware.di._BDComponent
        public void inject(BaseLibProxy r1) {
            injectBaseLibProxy(r1);
        }

        @Override // com.bytedance.android.live.saas.middleware.di._BDComponent
        public void inject(FrescoProxy r1) {
            injectFrescoProxy(r1);
        }

        @Override // com.bytedance.android.live.saas.middleware.di._BDComponent
        public void inject(MonitorProxy r1) {
            injectMonitorProxy(r1);
        }

        @Override // com.bytedance.android.live.saas.middleware.di._BDComponent
        public void inject(NetworkProxy r1) {
            injectNetworkProxy(r1);
        }

        @Override // com.bytedance.android.live.saas.middleware.di._BDComponent
        public void inject(NpthProxy r1) {
            injectNpthProxy(r1);
        }

        @Override // com.bytedance.android.live.saas.middleware.di._BDComponent
        public void inject(SecProxy r1) {
            injectSecProxy(r1);
        }

        private _BDComponentImpl(NpthModule r1, BaseLibModule r2, AppLogModule r3, BDLiveSdkModule r4, CornetModule r5, SecModule r6, MonitorModule r7, FrescoModule r8) {
            this.__BDComponentImpl = this;
            this.npthModule = r1;
            this.appLogModule = r3;
            this.secModule = r6;
            this.frescoModule = r8;
            this.cornetModule = r5;
            this.monitorModule = r7;
            this.bDLiveSdkModule = r4;
            this.baseLibModule = r2;
        }

        public /* synthetic */ _BDComponentImpl(NpthModule r1, BaseLibModule r2, AppLogModule r3, BDLiveSdkModule r4, CornetModule r5, SecModule r6, MonitorModule r7, FrescoModule r8, AnonymousClass1 r9) {
            this(r1, r2, r3, r4, r5, r6, r7, r8);
        }
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static _BDComponent create() {
        return new Builder(null).build();
    }

    private Dagger_BDComponent() {
    }
}
