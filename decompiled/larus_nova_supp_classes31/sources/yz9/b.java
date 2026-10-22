package yz9;

import com.larus.uaigc.spring.component.SpringLynxExplorerInput;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final CopyOnWriteArrayList<yz9.a> a = null;
    public static final C0087b b = null;
    public static final a c = null;

    public static final class a extends com.lynx.tasm.behavior.a {
        public a() {
            super("flow-z-input");
        }
    }

    /* JADX INFO: renamed from: yz9.b$b, reason: collision with other inner class name */
    public static final class C0087b extends com.lynx.tasm.behavior.a {
        public C0087b() {
            super("flow-z-input");
        }

        public final LynxUI createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            SpringLynxExplorerInput r0 = new SpringLynxExplorerInput(r2);
            r0.a = new c();
            return r0;
        }
    }

    static {
        a = new CopyOnWriteArrayList();
        b = new C0087b();
        c = new a();
    }
}
