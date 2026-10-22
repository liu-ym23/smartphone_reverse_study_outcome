package qpb;

import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends AbstractBaseSettingHandler {

    /* JADX INFO: renamed from: qpb.a$a, reason: collision with other inner class name */
    public static class C0318a {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.a
    public final String a() {
        return "log_config";
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
    public final String f() {
        return "LogSettingHandler";
    }

    public a() {
        AbstractBaseSettingHandler.a r0 = new AbstractBaseSettingHandler.a();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.f = r0;
    }
}
