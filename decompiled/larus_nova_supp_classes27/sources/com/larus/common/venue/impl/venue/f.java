package com.larus.common.venue.impl.venue;

import com.larus.common.venue.impl.venue.component.FlowCommonVenueLynxExplorerInput;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    public static final CopyOnWriteArrayList<h> a = null;
    public static final b b = null;
    public static final a c = null;

    public static final class a extends com.lynx.tasm.behavior.a {
        public a() {
            super("flow-common-venue-input");
        }
    }

    public static final class b extends com.lynx.tasm.behavior.a {
        public b() {
            super("flow-common-venue-input");
        }

        public final LynxUI createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            FlowCommonVenueLynxExplorerInput r0 = new FlowCommonVenueLynxExplorerInput(r2);
            r0.a = new g();
            return r0;
        }
    }

    static {
        a = new CopyOnWriteArrayList();
        b = new b();
        c = new a();
    }
}
