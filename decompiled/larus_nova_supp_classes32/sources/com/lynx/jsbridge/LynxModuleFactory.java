package com.lynx.jsbridge;

import android.content.Context;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxModuleFactory {
    public final ConcurrentHashMap<String, f> a;
    public long b;
    public IModuleCreator c;
    public Object d;
    public boolean e;
    public LynxModule.a f;
    public a g;

    public static abstract class a {
        public a() {
        }
    }

    private native boolean nativeRetainJniObject(long r1);

    public final void d() {
        if (nativeRetainJniObject(this.b) == true) goto L6;
        LLog.e("LynxModuleFactory", "LynxModuleFactory try to retainJniObject failed");
        destroy();
        return;
    }

    public void destroy() {
        if (this.e == false) goto L5;
        return;
    L5:
        a r0 = this.g;
        if (r0 == null) goto L8;
        UIThreadUtils.runOnUiThread(((LynxTemplateRender.f) r0).a);
    L8:
        IModuleCreator r1 = this.c;
        if (r1 == null) goto L17;
        com.lynx.jsbridge.a r2 = (com.lynx.jsbridge.a) r1;
        Iterator<LynxModuleWrapper> r3 = r2.a.values().iterator();
    L12:
        if (r3.hasNext() == false) goto L16;
        LynxModule r4 = r3.next().a;
        if (r4 == null) goto L12;
        r4.destroy();
        goto L12
    L16:
        r2.a.clear();
    L17:
        this.a.clear();
        this.b = 0;
        this.e = true;
    }

    public LynxModuleFactory() {
        this.b = 0;
        this.e = false;
        this.a = new ConcurrentHashMap();
    }

    public long getNativePtr() {
        return this.b;
    }

    private LynxModuleWrapper moduleWrapperForName(String r1) {
        return b(r1);
    }

    private void setNativePtr(long r1) {
        this.b = r1;
    }

    public final void a(List<f> r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.isEmpty() == true) goto L17;
        Iterator<f> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L18;
        f r0 = r8.next();
        String r1 = r0.b();
        f r2 = this.a.get(r1);
        if (r2 == null) goto L12;
        LLog.e("LynxModuleFactory", "Duplicated LynxModule For Name: " + r1 + ", " + r2 + " will be override");
    L12:
        this.a.put(r1, r0);
        LLog.v("LynxModuleFactory", "method addModuleParamWrapper ,  registered module with name: " + r1 + " class" + r0);
        goto L8
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.lynx.jsbridge.LynxModule] */
    public final LynxModuleWrapper b(String r17) {
        IModuleCreator r0 = this.c;
        LynxModuleWrapper r3 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        ConcurrentHashMap<String, f> r4 = this.a;
        com.lynx.jsbridge.a r5 = (com.lynx.jsbridge.a) r0;
        if (r17 != null) goto L8;
        LLog.e("LynxModuleFactory:CommonModuleCreator", "getModule failed, name is null");
    L119:
        if (r3 == null) goto L121;
        r3.getModule().setExtraData(this.d);
        r3.e = this.f;
    L121:
        return r3;
    L8:
        LynxModuleWrapper r1 = r5.a.get(r17);
        if (r1 == null) goto L11;
        r3 = r1;
        goto L119
    L11:
        f r2 = r4.get(r17);
        if (r2 != null) goto L16;
        r2 = LynxEnv.inst().getModuleFactory().a.get(r17);
        if (r2 != null) goto L16;
    L23:
        LynxModuleWrapper r13 = null;
    L114:
        r3 = r13;
    L116:
        if (r3 != null) goto L118;
        r3 = r13;
        goto L119
    L118:
        r5.a.put(r17, r3);
    L16:
        WeakReference r6 = r5.b.a();
        if (r6.get() != null) goto L19;
        LLog.e("LynxModuleFactory:CommonModuleCreator", "getModule failed, context is null");
        goto L23
    L19:
        Class<? extends LynxModule> r8 = r2.a();
        boolean r9 = LynxContextModule.class.isAssignableFrom(r8);     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        Context r7 = (Context) r6.get();     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        if (r7 != null) goto L122;
        LLog.e("LynxModuleFactory:CommonModuleCreator", r8.getCanonicalName() + " called with Null context");     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        goto L23
    L122:
        if (r9 == false) goto L123;
        if ((r7 instanceof LynxContext) == false) goto L52;
        if (r2.c() != null) goto L50;
        Constructor<?>[] r10 = r8.getConstructors();     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        int r11 = r10.length;     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        int r12 = 0;
    L31:
        if (r12 >= r11) goto L49;
        Constructor<?> r14 = r10[r12];     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        Class<?>[] r15 = r14.getParameterTypes();     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        if (r15.length != 1) goto L39;
        if (LynxContext.class.equals(r15[0]) == false) goto L39;
        LynxModule r16 = (LynxModule) r14.newInstance(new Object[]{(LynxContext) r7});     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
    L62:
        ?? r18 = r16;
        r13 = null;
    L112:
        if (r18 != 0) goto L115;
        LLog.e("LynxModuleFactory:CommonModuleCreator", "getModule" + r17 + "failed");
        goto L114
    L115:
        LynxModuleWrapper r19 = new LynxModuleWrapper(r17, r18);
        r19.f = r5.b;
        r3 = r19;
    L39:
        if (r15.length != 2) goto L48;
        if (LynxContext.class.equals(r15[0]) == false) goto L48;
        if (Object.class.equals(r15[1]) == false) goto L48;
        Object[] r20 = new Object[2];     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        r20[0] = (LynxContext) r7;     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        r20[1] = null;     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        r16 = (LynxModule) r14.newInstance(r20);     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
    L48:
        r12 = r12 + 1;     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        r3 = null;
        goto L31
    L49:
        r13 = r3;
    L111:
        r18 = r13;
        goto L112
    L50:
        r16 = r8.getConstructor(new Class[]{LynxContext.class, Object.class}).newInstance(new Object[]{(LynxContext) r7, r2.c()});     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        goto L62
    L52:
        throw new Exception(r8.getCanonicalName() + " must be created with LynxContext");     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
    L123:
        if (r2.c() != null) goto L74;
        Constructor<?>[] r21 = r8.getConstructors();     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        int r22 = r21.length;     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        int r23 = 0;
    L56:
        if (r23 >= r22) goto L73;
        Constructor<?> r24 = r21[r23];     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        Class<?>[] r110 = r24.getParameterTypes();     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        if (r110.length != 1) goto L64;
        if (Context.class.equals(r110[0]) == false) goto L64;
        r16 = (LynxModule) r24.newInstance(new Object[]{r7});     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
    L64:
        if (r110.length != 2) goto L72;
        if (Context.class.equals(r110[0]) == false) goto L72;
        if (Object.class.equals(r110[1]) == false) goto L72;
        Object[] r25 = new Object[2];     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        r25[0] = r7;     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        r13 = null;
        r25[1] = null;     // Catch: Exception -> L76 InvocationTargetException -> L78 NoSuchMethodException -> L80 IllegalAccessException -> L82 InstantiationException -> L84
        r18 = (LynxModule) r24.newInstance(r25);     // Catch: Exception -> L76 InvocationTargetException -> L78 NoSuchMethodException -> L80 IllegalAccessException -> L82 InstantiationException -> L84
    L72:
        r23 = r23 + 1;     // Catch: Exception -> L76 InvocationTargetException -> L78 NoSuchMethodException -> L80 IllegalAccessException -> L82 InstantiationException -> L84
        goto L56
    L73:
        r13 = null;
        goto L111
    L74:
        r13 = null;
        r18 = r8.getConstructor(new Class[]{Context.class, Object.class}).newInstance(new Object[]{r7, r2.c()});     // Catch: Exception -> L76 InvocationTargetException -> L78 NoSuchMethodException -> L80 IllegalAccessException -> L82 InstantiationException -> L84
    L82:
        e = e;
    L107:
        LLog.e("LynxModuleFactory:CommonModuleCreator", "get Module failed" + e);
    L84:
        e = e;
    L110:
        LLog.e("LynxModuleFactory:CommonModuleCreator", "get Module failed" + e);
    L80:
        e = e;
    L104:
        LLog.e("LynxModuleFactory:CommonModuleCreator", "get Module failed" + e);
    L78:
        e = e;
    L101:
        LLog.e("LynxModuleFactory:CommonModuleCreator", "get TargetException " + e.getTargetException());
    L76:
        e = e;
    L98:
        LLog.e("LynxModuleFactory:CommonModuleCreator", "get Module failed" + e);
    L92:
        e = e;
        r13 = null;
    L94:
        e = e;
        r13 = null;
    L90:
        e = e;
        r13 = null;
    L88:
        e = e;
        r13 = null;
    L86:
        e = e;
        r13 = null;
    L105:
        e = e;
        r13 = null;
    L108:
        e = e;
        r13 = null;
    L102:
        e = e;
        r13 = null;
    L99:
        e = e;
        r13 = null;
    L96:
        e = e;
        r13 = null;
        goto L98
    }

    public final void c(String r5, Class<? extends LynxModule> r6, Object r7) {
        f r0 = new f();
        r0.a = r5;
        r0.b = r6;
        r0.c = r7;
        f r8 = this.a.get(r5);
        if (r8 == null) goto L5;
        LLog.e("LynxModuleFactory", "Duplicated LynxModule For Name: " + r5 + ", " + r8 + " will be override");
    L5:
        this.a.put(r5, r0);
        LLog.v("LynxModuleFactory", "method registerModule , registered module with name: " + r5 + " class" + r6);
    }
}
