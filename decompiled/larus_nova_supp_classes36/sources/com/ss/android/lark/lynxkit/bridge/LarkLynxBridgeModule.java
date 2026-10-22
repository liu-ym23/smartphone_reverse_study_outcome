package com.ss.android.lark.lynxkit.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.lynx.jsbridge.LynxContextModule;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.c;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.lynxkit.initializer.LarkLynxKitInitializer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0017R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeModule;", "Lcom/lynx/jsbridge/LynxContextModule;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "param", "", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "larkBridgeModuleEntity", "Lcom/ss/android/lark/lynxkit/bridge/LarkBridgeModuleEntity;", "invoke", "", "methodName", "", "params", "Lcom/lynx/react/bridge/ReadableMap;", "callback", "Lcom/lynx/react/bridge/Callback;", "Companion", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkLynxBridgeModule extends LynxContextModule {
    public static final a Companion = null;
    public static final String LYNX_MODULE_NAME = "BDLynxModule";
    private static final String TAG = "LarkLynxBridgeModule";
    private LarkBridgeModuleEntity larkBridgeModuleEntity;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ILynxBridgeContext {
        public final /* synthetic */ LarkLynxBridgeModule a;

        @Override // com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext
        public final ILynxContainerContext getContainerContext() {
            LarkBridgeModuleEntity r0 = LarkLynxBridgeModule.access$getLarkBridgeModuleEntity$p(this.a);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getLynxContainerContext();
        }

        @Override // com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext
        public Context getContext() {
            LarkBridgeModuleEntity r0 = LarkLynxBridgeModule.access$getLarkBridgeModuleEntity$p(this.a);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getContext();
        }

        @Override // com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext
        public final LynxContext getLynxContext() {
            return LarkLynxBridgeModule.m1412access$getMLynxContext$p$s689311814(this.a);
        }

        public b(LarkLynxBridgeModule r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext
        public final void sendDataToJSByModule(List<? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r4, "data");
            JavaOnlyArray r5 = JavaOnlyArray.from(r4);
            LarkBridgeModuleEntity r0 = LarkLynxBridgeModule.access$getLarkBridgeModuleEntity$p(this.a);
            if (r0 == null) goto L13;
            String r1 = r0.getJsModuleTag();
            if (r1 == null) goto L13;
            LarkLynxBridgeModule r2 = this.a;
            LarkLynxKitInitializer.Companion.getClass();
            if (LarkLynxKitInitializer.b.a().getJSModuleEntity$lark_lynx_kit_release(r1) == null) goto L12;
            Unit r3 = null;
            c r6 = LarkLynxBridgeModule.m1412access$getMLynxContext$p$s689311814(r2).getJSModule(null);
            if (r6 == null) goto L11;
            r6.a(null, r5);
            r3 = Unit.INSTANCE;
        L11:
            if (r3 == null) goto L12;
            return;
        L12:
            Log.e(LarkLynxBridgeModule.TAG, "jsModule tag " + r1 + " not exist");
            return;
        L13:
            c r7 = LarkLynxBridgeModule.m1412access$getMLynxContext$p$s689311814(this.a).getJSModule("BDLynxAPIModule");
            if (r7 == null) goto L19;
            r7.a("trigger", r5);
            return;
        }

        @Override // com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext
        public final void sendGlobalEventToJS(String r4, Map<String, ? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r4, "eventName");
            Intrinsics.checkNotNullParameter(r5, "dataMap");
            if (TextUtils.isEmpty(r4) == false) goto L6;
            Log.e(LarkLynxBridgeModule.TAG, "lynx callJS<<< call js error : no event name");
            return;
        L6:
            JavaOnlyArray r0 = new JavaOnlyArray();
            r0.add(rqb.a.b(r5));
            Log.i(LarkLynxBridgeModule.TAG, "lynx callJS<<<callJS " + r4);
            LarkLynxBridgeModule.m1412access$getMLynxContext$p$s689311814(this.a).sendGlobalEvent(r4, r0);
        }
    }

    static {
        Companion = new a();
    }

    public static final /* synthetic */ LarkBridgeModuleEntity access$getLarkBridgeModuleEntity$p(LarkLynxBridgeModule r0) {
        return r0.larkBridgeModuleEntity;
    }

    /* JADX INFO: renamed from: access$getMLynxContext$p$s-689311814, reason: not valid java name */
    public static final /* synthetic */ LynxContext m1412access$getMLynxContext$p$s689311814(LarkLynxBridgeModule r0) {
        return ((LynxContextModule) r0).mLynxContext;
    }

    public LarkLynxBridgeModule(LynxContext r1, Object r2) {
        super(r1, r2);
        if ((r2 instanceof LarkBridgeModuleEntity) == false) goto L6;
        this.larkBridgeModuleEntity = (LarkBridgeModuleEntity) r2;
        return;
    }

    @LynxMethod
    public void invoke(String r8, ReadableMap r9, Callback r10) {
        if (r8 == null) goto L60;
        boolean r2 = false;
        if (r8.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L60;
        int r3 = rqb.a.a;
        if (r9 != null) goto L13;
        JSONObject r11 = new JSONObject();
    L17:
        b r4 = new b(this);
        LarkBridgeModuleEntity r5 = this.larkBridgeModuleEntity;
        String r6 = null;
        if (r5 == null) goto L30;
        String r7 = r5.getBridgeDispatcherTag();
        if (r7 == null) goto L30;
        if (r7.length() <= 0) goto L24;
        boolean r12 = true;
    L25:
        if (r12 == true) goto L28;
        r7 = null;
    L28:
        if (r7 == null) goto L30;
        LarkLynxKitInitializer.Companion.getClass();
        ILynxBridgeMethodDispatcher r13 = LarkLynxKitInitializer.b.a().getBridgeMethodDispatcherByTag$lark_lynx_kit_release(r7);
    L31:
        if (r13 == null) goto L36;
        StringBuilder r14 = new StringBuilder("custom bridgeMethodDispatcher exist, tag is: ");
        LarkBridgeModuleEntity r15 = this.larkBridgeModuleEntity;
        if (r15 == null) goto L35;
        r6 = r15.getBridgeDispatcherTag();
    L35:
        r14.append(r6);
        Log.i(TAG, r14.toString());
        r13.handleMethodInvoke(r4, r8, r11, r10);
        return;
    L36:
        LarkBridgeModuleEntity r16 = this.larkBridgeModuleEntity;
        if (r16 == null) goto L48;
        String r17 = r16.getBridgeMethodGroupTag();
        if (r17 == null) goto L48;
        if (r17.length() <= 0) goto L43;
        r2 = true;
    L43:
        if (r2 == true) goto L46;
        r17 = null;
    L46:
        if (r17 == null) goto L48;
        LarkLynxKitInitializer.Companion.getClass();
        List<ILarkLynxMethod> r18 = LarkLynxKitInitializer.b.a().getBridgeMethodGroupByTag$lark_lynx_kit_release(r17);
    L49:
        if (r18 == null) goto L66;
        Iterator<ILarkLynxMethod> r19 = r18.iterator();
    L52:
        if (r19.hasNext() == false) goto L67;
        ILarkLynxMethod r20 = r19.next();
        if (Intrinsics.areEqual(r20.getName(), r8) == false) goto L52;
        StringBuilder r21 = new StringBuilder("custom bridgeMethodGroup exist, tag is: ");
        LarkBridgeModuleEntity r22 = this.larkBridgeModuleEntity;
        if (r22 == null) goto L58;
        r6 = r22.getBridgeMethodGroupTag();
    L58:
        r21.append(r6);
        r21.append(", method is: ");
        r21.append(r8);
        Log.i(TAG, r21.toString());
        r20.invoke(r4, r11, r10);
        return;
    L67:
        return;
    L66:
        return;
    L48:
        r18 = null;
        goto L49
    L24:
        r12 = false;
    L30:
        r13 = null;
        goto L31
    L13:
        Object r23 = rqb.a.a(r9);
        if ((r23 instanceof JSONObject) == false) goto L16;
        r11 = (JSONObject) r23;
        goto L17
    L16:
        r11 = new JSONObject();
        goto L17
    L7:
        r1 = false;
    L60:
        Log.e(TAG, "invoke method, methodName is empty");
    }
}
