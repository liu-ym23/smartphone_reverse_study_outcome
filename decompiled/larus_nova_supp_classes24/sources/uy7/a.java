package uy7;

import android.content.Context;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.tt.refer.common.base.AppType;
import j18.l;
import kotlin.jvm.internal.Intrinsics;
import l18.h;
import vxb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends b {
    public final Context w;
    public final l x;

    public final void c() {
    }

    public final AppType getAppType() {
        return AppType.DynamicComponent;
    }

    public final Context getContext() {
        return this.w;
    }

    public final LKBasePluginResult sendEvent(LKEvent r2) {
        return ((h) this.x).handleEvent(r2);
    }

    public a(Context r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pluginManager");
        super(r2);
        this.w = r2;
        this.x = r3;
    }
}
