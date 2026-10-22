package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.util.MultiSingleton;
import com.bytedance.bdinstall.util.Singleton;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsEnv implements Cloneable {
    private InstallUrl config;
    private boolean isBoe;
    private boolean isChildMode;
    private boolean isI18n;
    private final Singleton<SharedPreferences> mSharedSp;
    private final MultiSingleton<SharedPreferences> mSharedSpSub;

    AbsEnv(InstallUrl r2, boolean r3, boolean r4, boolean r5) {
        this.mSharedSp = new AnonymousClass1(this);
        this.mSharedSpSub = new AnonymousClass2(this);
        this.config = r2;
        this.isI18n = r3;
        this.isBoe = r4;
        this.isChildMode = r5;
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object r7) {
        if (r7 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, AbsEnv.class) == true) goto L8;
        return false;
    L8:
        if (this.config.equals(((AbsEnv) ZeusTransformUtils.preCheckCast(r7, AbsEnv.class, "com.obric.memorydata.plugin")).config) == false) goto L17;
        if (this.isBoe != ((AbsEnv) ZeusTransformUtils.preCheckCast(r7, AbsEnv.class, "com.obric.memorydata.plugin")).isBoe) goto L17;
        if (this.isI18n != ((AbsEnv) ZeusTransformUtils.preCheckCast(r7, AbsEnv.class, "com.obric.memorydata.plugin")).isI18n) goto L17;
        if (this.isChildMode != ((AbsEnv) ZeusTransformUtils.preCheckCast(r7, AbsEnv.class, "com.obric.memorydata.plugin")).isChildMode()) goto L17;
        return true;
    L17:
        return false;
    }

    public InstallUrl getConfig() {
        return this.config;
    }

    public SharedPreferences getEnvIsolateSp(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return (SharedPreferences) ZeusTransformUtils.preCheckCast(this.mSharedSp.get(new Object[]{r5}), SharedPreferences.class, "com.obric.memorydata.plugin");
    }

    public SharedPreferences getEnvIsolateSp(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return (SharedPreferences) ZeusTransformUtils.preCheckCast(this.mSharedSpSub.get(r5, new Object[]{r6}), SharedPreferences.class, "com.obric.memorydata.plugin");
    }

    public SharedPreferences getEnvIsolateSp(InstallOptions r4) {
        if (r4.isMainInstance() == false) goto L6;
        return getEnvIsolateSp((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L6:
        return getEnvIsolateSp((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), String.valueOf(r4.getAid()));
    }

    public boolean isBoe() {
        return this.isBoe;
    }

    public boolean isChildMode() {
        return this.isChildMode;
    }

    public boolean isI18n() {
        return this.isI18n;
    }

    public String toString() {
        return "AbsEnv{isChildMode=" + this.isChildMode + ", config=" + this.config + ", isI18n=" + this.isI18n + ", isBoe=" + this.isBoe + '}';
    }
}
