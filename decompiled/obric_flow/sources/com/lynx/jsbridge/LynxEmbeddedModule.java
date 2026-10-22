package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class LynxEmbeddedModule extends LynxContextModule {
    public static final String NAME = "LynxEmbeddedModule";
    private WeakReference<Object> mLynxViewGroupRef;

    public LynxEmbeddedModule(LynxContext r5, Object r10) {
        super(r5);
    }

    private LynxView getLynxViewById(int r5) {
        WeakReference<Object> r10 = this.mLynxViewGroupRef;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.get() != null) goto L8;
        return null;
    L8:
        throw new ClassCastException();
    }

    @n
    public void getData(int r5, Callback r10, Callback r11) {
        LynxView r12 = getLynxViewById(r5);
        if (r12 != null) goto L6;
        JavaOnlyMap r13 = new JavaOnlyMap();
        r13.put("message", "Cannot get related lynxView (ID: " + r5 + ")");
        r11.invoke(new Object[]{r13});
        return;
    L6:
        com.lynx.tasm.utils.j.a().post(new f(r12, r10, 0));
    }

    @n
    public void getDataV2(Callback r5, Callback r10) {
        LynxView r11 = this.mLynxContext.k();
        if (r11 != null) goto L6;
        JavaOnlyMap r12 = new JavaOnlyMap();
        r12.put("message", "Cannot get related lynxView.");
        r10.invoke(new Object[]{r12});
        return;
    L6:
        com.lynx.tasm.utils.j.f(new f(r11, r5, 1));
    }

    @n
    public void setDataV2(ReadableMap r5, Callback r10, Callback r11) {
        LynxView r12 = this.mLynxContext.k();
        if (r12 != null) goto L6;
        JavaOnlyMap r13 = new JavaOnlyMap();
        r13.put("message", "Cannot get related lynxView.");
        r11.invoke(new Object[]{r13});
        return;
    L6:
        com.lynx.tasm.utils.j.f(new e(r5, r12, r10, 1));
    }

    @n
    public void updateData(int r5, ReadableMap r10, Callback r11, Callback r12) {
        LynxView r13 = getLynxViewById(r5);
        if (r13 != null) goto L6;
        JavaOnlyMap r14 = new JavaOnlyMap();
        r14.put("message", "Cannot get related lynxView (ID: " + r5 + ")");
        r12.invoke(new Object[]{r14});
        return;
    L6:
        com.lynx.tasm.utils.j.a().post(new e(r10, r13, r11, 0));
    }
}
