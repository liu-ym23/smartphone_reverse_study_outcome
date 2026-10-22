package com.lynx.devtool.module;

import com.lynx.jsbridge.LynxContextModule;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.service.ILynxTrailService;
import i8a.n;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxTrailModule extends LynxContextModule {
    private static final String GET_LATEST_SETTINGS_METHOD = "getLatestSettings";
    public static final String NAME = "LynxTrailModule";

    @LynxMethod
    public WritableMap getSettings() {
        ILynxTrailService r0 = (ILynxTrailService) n.c().a(ILynxTrailService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return (WritableMap) convertToJavaOnlyType(r0.getAllValues());
    }

    public LynxTrailModule(LynxContext r1) {
        super(r1);
    }

    private Object convertToJavaOnlyType(Object r4) {
        if ((r4 instanceof Map) == false) goto L11;
        Map r5 = (Map) r4;
        Iterator r0 = r5.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) r0.next();
        r1.setValue(convertToJavaOnlyType(r1.getValue()));
        goto L6
    L9:
        return JavaOnlyMap.from(r5);
    L11:
        if ((r4 instanceof List) == false) goto L20;
        List r6 = (List) r4;
        ListIterator r2 = r6.listIterator();
    L14:
        if (r2.hasNext() == false) goto L17;
        r2.set(convertToJavaOnlyType(r2.next()));
        goto L14
    L17:
        return JavaOnlyArray.from(r6);
    L20:
        return r4;
    }

    public static /* synthetic */ Object access$000(LynxTrailModule r0, Object r1) {
        return r0.convertToJavaOnlyType(r1);
    }

    private void reject(Callback r3, String r4) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        if (r4 != null) goto L6;
        r4 = "Fetch latest settings failed";
    L6:
        r0.putString("message", r4);
        resolve(r3, r0);
    }

    private void resolve(final Callback r3, final Object r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        LynxContext r0 = this.mLynxContext;
        if (r0 != null) goto L8;
        r3.invoke(new Object[]{r4});
        return;
    L8:
        r0.runOnJSThread(new AnonymousClass3(this, r3, r4));
    }

    @LynxMethod
    public void getLatestSettings(final Callback r9, final Callback r10) {
        ILynxTrailService r0 = (ILynxTrailService) n.c().a(ILynxTrailService.class);
        if (r0 != null) goto L22;
        reject(r10, "Lynx Trail Service not registered");
        return;
    L22:
        r0.getClass().getMethod(GET_LATEST_SETTINGS_METHOD, new Class[]{Callback.class, Callback.class}).invoke(r0, new Object[]{new AnonymousClass1(this, r9), new AnonymousClass2(this, r10)});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L20
    L25:
        return;
    L10:
        e = e;
    L12:
        if ((e instanceof InvocationTargetException) == false) goto L14;
        e = ((InvocationTargetException) e).getCause();
    L14:
        if (e != null) goto L16;
    L18:
        String r11 = "Fetch latest settings failed";
    L19:
        reject(r10, r11);
        return;
    L16:
        if (e.getMessage() == null) goto L18;
        r11 = e.getMessage();
    L20:
        reject(r10, "Lynx Trail Service does not support latest settings fetch");
        return;
    L8:
        e = e;
        goto L12
    }

    public static /* synthetic */ void access$100(LynxTrailModule r0, Callback r1, Object r2) {
        r0.resolve(r1, r2);
    }

    public static /* synthetic */ void access$200(LynxTrailModule r0, Callback r1, String r2) {
        r0.reject(r1, r2);
    }
}
