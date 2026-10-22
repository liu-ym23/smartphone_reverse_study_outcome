package com.bytedance.android.accessibilityLib_Core.config.bean;

import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.ClassType;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.ConfigType;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.LabelMode;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.SelectMode;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.d;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ViewVirtualNode {
    public Integer a;
    public Integer b;
    public final int c;
    public final Lazy d;
    public boolean e;
    public d f;
    public List<com.bytedance.android.accessibilityLib_Core.config.remote.dsl.b> g;
    public h[] h;
    public boolean i;
    public boolean j;
    public SelectMode k;
    public LabelMode l;
    public boolean m;
    public boolean n;
    public ConfigType o;
    public String p;
    public boolean q;
    public String r;
    public ClassType s;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "viewid = " + this.b + " ,layoutId = " + this.a + ", nextviewid = null,viewidentify = null, sAppModeStr = " + this.r + ",sClassType = " + this.s.getValue();
    }

    public ViewVirtualNode() {
        this.c = -1;
        this.d = LazyKt.lazy(ViewVirtualNode$accessibilityNodeInfo$2.INSTANCE);
        this.k = SelectMode.Default;
        this.l = LabelMode.Append;
        this.o = ConfigType.Normal;
        this.p = "";
        this.r = "";
        this.s = ClassType.Default;
    }
}
