package com.ss.android.lark.framework.assembly.diskmanage;

import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.larkconfig.export.plugin.AppSettingPlugin;
import java.util.Collection;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DiskManageSettingHandler extends AbstractBaseSettingHandler {
    public static final /* synthetic */ int i = 0;

    public static final class a {
    }

    @AppSettingPlugin
    public static final class b implements npb.a {
        public b() {
        }

        @Override // npb.a
        public final void a() {
        }

        @Override // npb.a
        public final Collection<AbstractBaseSettingHandler> b() {
            int r1 = DiskManageSettingHandler.i;
            return SetsKt.mutableSetOf(new DiskManageSettingHandler[]{c.a});
        }

        @Override // npb.a
        public final String getTag() {
            return "DiskManageSettingHandler";
        }
    }

    public static final class c {
        public static final DiskManageSettingHandler a = null;

        static {
            a = new DiskManageSettingHandler();
        }
    }

    static {
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.a
    public final String a() {
        return "global_clean_config";
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
    public final String f() {
        return "DiskManageSettingHandler";
    }

    public DiskManageSettingHandler() {
        AbstractBaseSettingHandler.a r0 = this.d;
        r0.c(new AnonymousClass1(this));
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.f = r0;
    }
}
