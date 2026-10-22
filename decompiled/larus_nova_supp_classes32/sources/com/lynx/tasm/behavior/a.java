package com.lynx.tasm.behavior;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class a {
    private final boolean mCreateAsync;
    private final boolean mFlatten;
    private String mName;
    private final boolean mNeedProcessDirection;
    private final boolean mSupportFragmentLayerRender;

    public com.lynx.tasm.a createClassWarmer() {
        return null;
    }

    public LynxFlattenUI createFlattenUI(LynxContext r1) {
        return null;
    }

    public LynxFlattenUI createFlattenUIFiber(LynxContext r1) {
        return null;
    }

    public x6a.e createPlatformRendererHost(LynxContext r1) {
        return null;
    }

    public ShadowNode createShadowNode() {
        return null;
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + " - " + this.mName + "]";
    }

    public String getName() {
        return this.mName;
    }

    public boolean needProcessDirection() {
        return this.mNeedProcessDirection;
    }

    public boolean supportCreateAsync() {
        return this.mCreateAsync;
    }

    public boolean supportFragmentLayerRenderer() {
        return this.mSupportFragmentLayerRender;
    }

    public final boolean supportUIFlatten() {
        return this.mFlatten;
    }

    public a(String r2) {
        this(r2, false, false, false);
    }

    public LynxUI createUI(LynxContext r3) {
        throw new RuntimeException(this.mName + " is a virtual node, do not have real ui!");
    }

    public LynxUI createUIFiber(LynxContext r3) {
        throw new RuntimeException(this.mName + " is a virtual node, do not have real ui!");
    }

    public a(String r2, boolean r3) {
        this(r2, r3, false, false);
    }

    public LynxFlattenUI createFlattenUIWithParams(LynxContext r1, Object r2) {
        return createFlattenUI(r1);
    }

    public LynxUI createUIWithParams(LynxContext r1, Object r2) {
        return createUI(r1);
    }

    public a(String r2, boolean r3, boolean r4) {
        this(r2, r3, r4, false);
    }

    public a(String r7, boolean r8, boolean r9, boolean r10) {
        this(r7, r8, r9, r10, false);
    }

    public a(String r1, boolean r2, boolean r3, boolean r4, boolean r5) {
        this.mName = r1;
        this.mFlatten = r2;
        this.mCreateAsync = r3;
        this.mNeedProcessDirection = r4;
        this.mSupportFragmentLayerRender = r5;
    }
}
