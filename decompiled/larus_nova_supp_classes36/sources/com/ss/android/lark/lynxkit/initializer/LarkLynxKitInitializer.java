package com.ss.android.lark.lynxkit.initializer;

import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.z;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocol;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntimeFactory;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxMethod;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeMethodDispatcher;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeRuntimeProtocol;
import com.ss.android.lark.lynxkit.monitor.ILynxKitMonitorReporter;
import com.ss.android.lark.lynxkit.monitor.c;
import ee6.f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import rqb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001d\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u001fJ\u0016\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0017J\u0017\u0010\"\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001c\u001a\u00020\u0006H\u0000¢\u0006\u0002\b#J\"\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0007J#\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u0006H\u0000¢\u0006\u0002\b'J\u0016\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u000fJ\u000e\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u0006J\u0017\u0010+\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\u0006H\u0000¢\u0006\u0002\b,J\u0016\u0010-\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0011J\u0017\u0010/\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001c\u001a\u00020\u0006H\u0000¢\u0006\u0002\b0J\u001c\u00101\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00130\nJ\u001d\u00103\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u0006H\u0000¢\u0006\u0002\b4J\u0016\u00105\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0015J\u0016\u00107\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u00108\u001a\u000209J\u0017\u0010:\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001c\u001a\u00020\u0006H\u0000¢\u0006\u0002\b;J\u001c\u0010<\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00190\nJ\u0010\u0010>\u001a\u00020\u001b2\b\u0010?\u001a\u0004\u0018\u00010@J\u001d\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u0006H\u0000¢\u0006\u0002\bBRB\u0010\u0004\u001a6\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00070\u0005j\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\t\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n`\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r`\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f`\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011`\bX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n0\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n`\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0015`\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0017`\bX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0018\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\n0\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\n`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/ss/android/lark/lynxkit/initializer/LarkLynxKitInitializer;", "", "<init>", "()V", "globalPropsMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "behaviorMap", "", "Lcom/lynx/tasm/behavior/Behavior;", "lynxGroupMap", "Lcom/lynx/tasm/LynxGroup;", "mLynxGroupCreatorMap", "Lcom/ss/android/lark/lynxkit/initializer/ILynxGroupCreator;", "bridgeMethodDispatcherMap", "Lcom/ss/android/lark/lynxkit/bridge/ILynxBridgeMethodDispatcher;", "bridgeMethodGroupMap", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxMethod;", "bridgeProtocolMap", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocol;", "jsModuleMap", "Lcom/ss/android/lark/lynxkit/bridge/JSModuleEntity;", "templateLoaderMap", "Lcom/ss/android/lark/lynxkit/templateloader/ITemplateLoader;", "registerCustomComponents", "", "tag", "behaviors", "getCustomComponentsByTag", "getCustomComponentsByTag$lark_lynx_kit_release", "registerJSModule", "entity", "getJSModuleEntity", "getJSModuleEntity$lark_lynx_kit_release", "registerGlobalData", "globalProps", "getGlobalDataByTag", "getGlobalDataByTag$lark_lynx_kit_release", "registerLynxGroup", "groupName", "creator", "getLynxGroupByTag", "getLynxGroupByTag$lark_lynx_kit_release", "registerBridgeMethodDispatcher", "dispatcher", "getBridgeMethodDispatcherByTag", "getBridgeMethodDispatcherByTag$lark_lynx_kit_release", "registerBridgeMethodGroup", "methods", "getBridgeMethodGroupByTag", "getBridgeMethodGroupByTag$lark_lynx_kit_release", "registerBridgeProtocol", "protocol", "registerBridgeRuntimeFactory", "factory", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;", "getBridgeProtocolByTag", "getBridgeProtocolByTag$lark_lynx_kit_release", "registerTemplateLoaders", "loaders", "registerMonitorReporter", "reporter", "Lcom/ss/android/lark/lynxkit/monitor/ILynxKitMonitorReporter;", "getTemplateLoadersByTag", "getTemplateLoadersByTag$lark_lynx_kit_release", "Companion", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkLynxKitInitializer {
    public static final b Companion = null;
    private static final Lazy<LarkLynxKitInitializer> instance$delegate = null;
    private final HashMap<String, List<com.lynx.tasm.behavior.a>> behaviorMap;
    private final HashMap<String, ILynxBridgeMethodDispatcher> bridgeMethodDispatcherMap;
    private final HashMap<String, List<ILarkLynxMethod>> bridgeMethodGroupMap;
    private final HashMap<String, ILarkLynxBridgeProtocol> bridgeProtocolMap;
    private final HashMap<String, Map<String, Object>> globalPropsMap;
    private final HashMap<String, d> jsModuleMap;
    private final HashMap<String, LynxGroup> lynxGroupMap;
    private final HashMap<String, com.ss.android.lark.lynxkit.initializer.a> mLynxGroupCreatorMap;
    private final HashMap<String, List<uqb.b>> templateLoaderMap;

    public static final class a implements z.a {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void init() {
            f.a();
        }
    }

    public static final class b {
        public static LarkLynxKitInitializer a() {
            return (LarkLynxKitInitializer) LarkLynxKitInitializer.access$getInstance$delegate$cp().getValue();
        }

        public b() {
        }
    }

    static {
        Companion = new b();
        instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, LarkLynxKitInitializer$Companion$instance$2.INSTANCE);
    }

    @JvmStatic
    public static final LarkLynxKitInitializer ensureInitialized() {
        Companion.getClass();
        return b.a();
    }

    public LarkLynxKitInitializer() {
        this.globalPropsMap = new HashMap();
        this.behaviorMap = new HashMap();
        this.lynxGroupMap = new HashMap();
        this.mLynxGroupCreatorMap = new HashMap();
        this.bridgeMethodDispatcherMap = new HashMap();
        this.bridgeMethodGroupMap = new HashMap();
        this.bridgeProtocolMap = new HashMap();
        this.jsModuleMap = new HashMap();
        this.templateLoaderMap = new HashMap();
        z.a = a.a;
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    public final ILynxBridgeMethodDispatcher getBridgeMethodDispatcherByTag$lark_lynx_kit_release(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return this.bridgeMethodDispatcherMap.get(r2);
    }

    public final List<ILarkLynxMethod> getBridgeMethodGroupByTag$lark_lynx_kit_release(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return this.bridgeMethodGroupMap.get(r2);
    }

    public final ILarkLynxBridgeProtocol getBridgeProtocolByTag$lark_lynx_kit_release(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return this.bridgeProtocolMap.get(r2);
    }

    public final List<com.lynx.tasm.behavior.a> getCustomComponentsByTag$lark_lynx_kit_release(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return this.behaviorMap.get(r2);
    }

    public final Map<String, Object> getGlobalDataByTag$lark_lynx_kit_release(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return this.globalPropsMap.get(r2);
    }

    public final d getJSModuleEntity$lark_lynx_kit_release(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return this.jsModuleMap.get(r2);
    }

    public final LynxGroup getLynxGroupByTag$lark_lynx_kit_release(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        if (this.mLynxGroupCreatorMap.containsKey(r2) == false) goto L9;
        com.ss.android.lark.lynxkit.initializer.a r3 = this.mLynxGroupCreatorMap.get(r2);
        if (r3 != null) goto L10;
        return null;
    L10:
        return r3.a();
    L9:
        return this.lynxGroupMap.get(r2);
    }

    public final List<uqb.b> getTemplateLoadersByTag$lark_lynx_kit_release(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return this.templateLoaderMap.get(r2);
    }

    public final void registerLynxGroup(String r3) {
        Intrinsics.checkNotNullParameter(r3, "groupName");
        this.lynxGroupMap.put(r3, LynxGroup.Create(r3));
    }

    public final void registerMonitorReporter(ILynxKitMonitorReporter r2) {
        ILynxKitMonitorReporter r0 = c.a;
        if (r2 != null) goto L5;
        r2 = com.ss.android.lark.lynxkit.monitor.a.a;
    L5:
        c.a = r2;
    }

    public final void registerBridgeMethodDispatcher(String r2, ILynxBridgeMethodDispatcher r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "dispatcher");
        this.bridgeMethodDispatcherMap.put(r2, r3);
    }

    public final void registerBridgeMethodGroup(String r2, List<? extends ILarkLynxMethod> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "methods");
        this.bridgeMethodGroupMap.put(r2, r3);
    }

    public final void registerBridgeProtocol(String r2, ILarkLynxBridgeProtocol r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "protocol");
        this.bridgeProtocolMap.put(r2, r3);
    }

    public final void registerBridgeRuntimeFactory(String r2, ILarkLynxBridgeRuntimeFactory r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "factory");
        registerBridgeProtocol(r2, new LarkLynxBridgeRuntimeProtocol(r3));
    }

    public final void registerCustomComponents(String r2, List<? extends com.lynx.tasm.behavior.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "behaviors");
        this.behaviorMap.put(r2, r3);
    }

    public final void registerGlobalData(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "globalProps");
        this.globalPropsMap.put(r2, r3);
    }

    public final void registerJSModule(String r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "entity");
        this.jsModuleMap.put(r2, r3);
    }

    public final void registerLynxGroup(String r2, com.ss.android.lark.lynxkit.initializer.a r3) {
        Intrinsics.checkNotNullParameter(r2, "groupName");
        Intrinsics.checkNotNullParameter(r3, "creator");
        this.mLynxGroupCreatorMap.put(r2, r3);
    }

    public final void registerTemplateLoaders(String r2, List<? extends uqb.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "loaders");
        this.templateLoaderMap.put(r2, r3);
    }
}
