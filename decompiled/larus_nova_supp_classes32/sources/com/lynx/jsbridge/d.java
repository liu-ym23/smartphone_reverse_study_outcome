package com.lynx.jsbridge;

import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class d {
    protected LynxContext mContext;
    protected LynxGroup mGroup;

    public abstract void destroy();

    public abstract long getExtensionDelegatePtr();

    public abstract void onTemplateLoad(String r1);

    public abstract void setUp();

    public d(LynxContext r1, LynxGroup r2, com.lynx.tasm.behavior.c r3) {
        this.mContext = r1;
        this.mGroup = r2;
    }
}
