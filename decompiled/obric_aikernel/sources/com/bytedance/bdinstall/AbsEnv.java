package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.bytedance.bdinstall.util.MultiSingleton;
import com.bytedance.bdinstall.util.Singleton;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsEnv implements Cloneable {
    private InstallUrl config;
    private boolean isBoe;
    private boolean isChildMode;
    private boolean isI18n;
    private final Singleton<SharedPreferences> mSharedSp;
    private final MultiSingleton<SharedPreferences> mSharedSpSub;

    AbsEnv(InstallUrl r10, boolean r11, boolean r12, boolean r13) {
        this.mSharedSp = new AnonymousClass1(this);
        this.mSharedSpSub = new AnonymousClass2(this);
        this.config = r10;
        this.isI18n = r11;
        this.isBoe = r12;
        this.isChildMode = r13;
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(@Nullable Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof AbsEnv) == false) goto L18;
        AbsEnv r11 = (AbsEnv) r10;
        if (this.config.equals(r11.config) == false) goto L17;
        if (this.isBoe != r11.isBoe) goto L17;
        if (this.isI18n != r11.isI18n) goto L17;
        if (this.isChildMode != r11.isChildMode()) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public InstallUrl getConfig() {
        return this.config;
    }

    public SharedPreferences getEnvIsolateSp(Context r10) {
        return this.mSharedSp.get(new Object[]{r10});
    }

    public SharedPreferences getEnvIsolateSp(Context r10, String r11) {
        return this.mSharedSpSub.get(r11, new Object[]{r10});
    }

    public SharedPreferences getEnvIsolateSp(InstallOptions r10) {
        if (r10.isMainInstance() == false) goto L6;
        return getEnvIsolateSp(r10.getContext());
    L6:
        return getEnvIsolateSp(r10.getContext(), String.valueOf(r10.getAid()));
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
