package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxGroup {
    public static String SINGNLE_GROUP = "-1";
    private static int sNextID;
    private Map<String, Object> mConfig;
    private boolean mEnableCanvas;
    private boolean mEnableJSGroupThread;
    private boolean mEnableV8;
    private String mGroupName;
    private String mID;
    private String mJSGroupThreadName;
    private String[] mPreloadJSPaths;
    private LynxWhiteBoard mWhiteBoard;

    public static class a {
        public String a;
        public String b;
        public String[] c;
        public boolean d;
        public boolean e;
        public Boolean f;

        public a() {
        }

        public LynxGroup a() {
            return new LynxGroup(this);
        }
    }

    public static String generateID() {
        String r1 = String.format("%d", new Object[]{Integer.valueOf(sNextID)});
        sNextID++;
        return r1;
    }

    public boolean useProviderJsEnv() {
        return false;
    }

    public void destroy() {
        LynxWhiteBoard r0 = this.mWhiteBoard;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public String getJSGroupThreadNameOrDefault() {
        String r0 = this.mJSGroupThreadName;
        if (r0 == null) goto L8;
        if (r0.isEmpty() == true) goto L8;
        return this.mJSGroupThreadName;
    L8:
        return this.mID;
    }

    public long getWhiteBoardPtr() {
        LynxWhiteBoard r0 = this.mWhiteBoard;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.a;
    }

    public boolean enableCanvas() {
        return this.mEnableCanvas;
    }

    public boolean enableDynamicV8() {
        return this.mEnableV8;
    }

    public boolean enableJSGroupThread() {
        return this.mEnableJSGroupThread;
    }

    public boolean enableV8() {
        return this.mEnableV8;
    }

    public String getID() {
        return this.mID;
    }

    public String getJSGroupThreadName() {
        return this.mJSGroupThreadName;
    }

    public String[] getPreloadJSPaths() {
        return this.mPreloadJSPaths;
    }

    public LynxGroup(a r3) {
        this.mGroupName = r3.a;
        String r0 = r3.b;
        if (r0 != null) goto L6;
        r0 = generateID();
    L6:
        this.mID = r0;
        this.mPreloadJSPaths = r3.c;
        Boolean r1 = r3.f;
        if (r1 != null) goto L9;
        this.mEnableJSGroupThread = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_MULTI_JS_THREAD_BY_DEFAULT, false);
    L10:
        this.mJSGroupThreadName = null;
        this.mEnableV8 = r3.e;
        this.mConfig = null;
        this.mEnableCanvas = r3.d;
        LLog.i("LynxGroup", "LynxGroup init with name " + this.mGroupName + ", id: " + this.mID + ", enableV8: " + this.mEnableV8 + ", canvas:" + this.mEnableCanvas);
        return;
    L9:
        this.mEnableJSGroupThread = r1.booleanValue();
        goto L10
    }

    public static LynxGroup Create(String r1) {
        return Create(r1, null);
    }

    public boolean getBoolConfig(String r3) {
        Map<String, Object> r0 = this.mConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        Object r4 = r0.get(r3);
        if (r4 != null) goto L8;
    L11:
        return false;
    L8:
        if ((r4 instanceof Boolean) == false) goto L11;
        return ((Boolean) r4).booleanValue();
    }

    public String getStringConfig(String r3) {
        Map<String, Object> r0 = this.mConfig;
        if (r0 != null) goto L5;
        return null;
    L5:
        Object r4 = r0.get(r3);
        if (r4 != null) goto L8;
    L11:
        return null;
    L8:
        if ((r4 instanceof String) == false) goto L11;
        return (String) r4;
    }

    public void setEnableJSGroupThread(boolean r1) {
        this.mEnableJSGroupThread = r1;
    }

    public void setJSGroupThreadName(String r1) {
        this.mJSGroupThreadName = r1;
    }

    public static LynxGroup Create(a r0) {
        return r0.a();
    }

    public static LynxGroup Create(String r1, String[] r2) {
        return Create(r1, r2, false, false);
    }

    public static LynxGroup Create(String r1, String[] r2, boolean r3, boolean r4) {
        return Create(r1, r2, r3, r4, false);
    }

    public static LynxGroup Create(String r6, String[] r7, boolean r8, boolean r9, boolean r10) {
        return Create(r6, generateID(), r7, r8, r9, r10);
    }

    public static LynxGroup Create(String r6, String r7, String[] r8, boolean r9, boolean r10) {
        return Create(r6, r7, r8, r9, r10, false);
    }

    public static LynxGroup Create(String r6, String[] r7, boolean r8, boolean r9, boolean r10, boolean r11) {
        String r1 = generateID();
        if (r9 == true) goto L7;
        if (r11 == true) goto L7;
        boolean r4 = false;
    L9:
        return Create(r6, r1, r7, r8, r4, r10);
    L7:
        r4 = true;
        goto L9
    }

    public static LynxGroup Create(String r10, String r11, String[] r12, boolean r13, boolean r14, boolean r15) {
        return new LynxGroup(r10, r11, r12, r13, r14, r15, Boolean.FALSE, false);
    }

    public static LynxGroup Create(String r6, String r7, String[] r8, boolean r9, boolean r10, boolean r11, boolean r12) {
        if (r10 == true) goto L6;
        if (r12 == true) goto L6;
        boolean r4 = false;
    L8:
        return Create(r6, r7, r8, r9, r4, r11);
    L6:
        r4 = true;
        goto L8
    }

    public LynxGroup(String r1, String r2, String[] r3, boolean r4, boolean r5, boolean r6, Boolean r7, boolean r8) {
        this.mGroupName = r1;
        this.mID = r2;
        this.mPreloadJSPaths = r3;
        if (r7 != null) goto L5;
        this.mEnableJSGroupThread = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_MULTI_JS_THREAD_BY_DEFAULT, false);
    L6:
        if (r8 == false) goto L8;
        this.mWhiteBoard = new LynxWhiteBoard();
    L8:
        this.mEnableV8 = r6;
        this.mEnableCanvas = r5;
        LLog.i("LynxGroup", "LynxGroup init with name " + r1 + ", id: " + r2 + ", enableV8: " + r6 + ", canvas:" + this.mEnableCanvas);
        return;
    L5:
        this.mEnableJSGroupThread = r7.booleanValue();
        goto L6
    }
}
