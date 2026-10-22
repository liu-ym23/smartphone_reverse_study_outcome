package com.ss.android.lark.diskmanage.monitor;

import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.larkconfig.export.plugin.AppSettingPlugin;
import java.util.Collection;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DiskMonitorSettingHandler extends AbstractBaseSettingHandler {
    public static final /* synthetic */ int i = 0;

    public static final class a {
    }

    @AppSettingPlugin
    public static final class b implements npb.a {
        public b() {
        }

        public final void a() {
        }

        public final Collection<AbstractBaseSettingHandler> b() {
            int r1 = DiskMonitorSettingHandler.i;
            return SetsKt.mutableSetOf(new DiskMonitorSettingHandler[]{c.a});
        }

        public final String getTag() {
            return "DiskMonitorSettingHandler";
        }
    }

    public static final class c {
        public static final DiskMonitorSettingHandler a = null;

        static {
            a = new DiskMonitorSettingHandler();
        }
    }

    static {
    }

    public final String a() {
        return "storage_monitor_config";
    }

    public final String f() {
        return "DiskMonitorSettingHandler";
    }

    public DiskMonitorSettingHandler() {
        AbstractBaseSettingHandler.a r0 = ((AbstractBaseSettingHandler) this).d;
        r0.c(AnonymousClass1.INSTANCE);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        ((AbstractBaseSettingHandler) this).f = r0;
    }
}
