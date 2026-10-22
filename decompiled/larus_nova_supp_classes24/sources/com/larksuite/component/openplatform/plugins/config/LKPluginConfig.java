package com.larksuite.component.openplatform.plugins.config;

import android.text.TextUtils;
import com.bytedance.ee.lark.plugin_annotation.bean.LKOpenApiBizDomain;
import com.bytedance.ee.lark.plugin_annotation.bean.PluginEnv;
import com.bytedance.ee.lark.plugin_annotation.bean.Scope;
import i18.d;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKPluginConfig implements Serializable {
    private List<String> mEventList;
    public d mLkPlugin;
    public List<LKOpenApiAccessConfig> mOpenConditions;
    public LKOpenApiBizDomain mOwner;
    public String mPluginClassName;
    public PluginEnv mPluginEnv;
    public Scope mScope;

    public static /* synthetic */ class a {
    }

    public static class b {
    }

    public boolean configInvalid() {
        if (TextUtils.isEmpty(this.mPluginClassName) == true) goto L5;
    L6:
        List<String> r0 = this.mEventList;
        if (r0 != null) goto L9;
    L12:
        return true;
    L9:
        if (r0.isEmpty() == true) goto L12;
        return false;
    L5:
        if (this.mLkPlugin == null) goto L12;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("LKPluginConfig{mLkPlugin=");
        d r1 = this.mLkPlugin;
        if (r1 == null) goto L5;
        String r2 = r1.getClass().getName();
    L6:
        r0.append(r2);
        r0.append(", mPluginClassName='");
        r0.append(this.mPluginClassName);
        r0.append("', mOwner=");
        r0.append(this.mOwner);
        r0.append(", mOpenConditions=");
        r0.append(this.mOpenConditions);
        r0.append(", mScope=");
        r0.append(this.mScope);
        r0.append(", mEventList=");
        r0.append(this.mEventList);
        r0.append(", mPluginEnv=");
        r0.append(this.mPluginEnv);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = "";
        goto L6
    }

    public List<String> getEventList() {
        return this.mEventList;
    }

    public LKPluginConfig(b r1, a r2) {
        this.mOwner = LKOpenApiBizDomain.OPEN_PLATFORM;
        throw null;
    }
}
