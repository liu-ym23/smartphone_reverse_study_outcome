package noc;

import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends AbstractBaseSettingHandler {
    public final List<InterfaceC0303c> i;

    public static class a implements npb.a {
        public a() {
        }

        @Override // npb.a
        public final void a() {
        }

        @Override // npb.a
        public final String getTag() {
            return "ByteBenchHandler";
        }

        @Override // npb.a
        public final Collection<AbstractBaseSettingHandler> b() {
            return new HashSet(Collections.singletonList(b.a));
        }
    }

    public static class b {
        public static final c a = null;

        static {
            a = new c();
        }
    }

    /* JADX INFO: renamed from: noc.c$c, reason: collision with other inner class name */
    public interface InterfaceC0303c {
        void a();
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.a
    public final String a() {
        return "bytebench";
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
    public final String f() {
        return "ByteBenchHandler";
    }

    public c() {
        this.i = new CopyOnWriteArrayList();
        AbstractBaseSettingHandler.a r0 = this.d;
        r0.c(new noc.a(this));
        r0.b(new noc.b());
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.f = r0;
    }
}
