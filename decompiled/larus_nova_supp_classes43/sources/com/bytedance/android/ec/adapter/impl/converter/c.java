package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.ec.adapter.api.handler.viewinterface.ECExternalViewGroupAction;
import com.bytedance.android.ec.adapter.impl.adapters.views.IconModelAdapter;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.ExternalViewGroupAction;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconModel;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final LinkedHashSet<com.bytedance.android.ec.adapter.impl.converter.i<?, ?>> a = null;

    public static final class a extends com.bytedance.android.ec.adapter.impl.converter.a<wd.d, IExternalButton> {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final IExternalButton c(wd.d r10) {
            wd.d r11 = r10;
            Intrinsics.checkNotNullParameter(r11, "source");
            return new com.bytedance.android.ec.adapter.impl.adapters.views.a(r11);
        }
    }

    public static final class b extends com.bytedance.android.ec.adapter.impl.converter.a<rd.a, ILiveRoomController> {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final ILiveRoomController c(rd.a r10) {
            rd.a r11 = r10;
            Intrinsics.checkNotNullParameter(r11, "source");
            return new com.bytedance.android.ec.adapter.impl.adapters.d(r11);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.adapter.impl.converter.c$c, reason: collision with other inner class name */
    public static final class C0114c extends com.bytedance.android.ec.adapter.impl.converter.a<wd.e, IExternalView> {
        public static final C0114c b = null;

        static {
            b = new C0114c();
        }

        public C0114c() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final IExternalView c(wd.e r10) {
            wd.e r11 = r10;
            Intrinsics.checkNotNullParameter(r11, "source");
            return new com.bytedance.android.ec.adapter.impl.adapters.views.c(r11);
        }
    }

    public static final class d extends com.bytedance.android.ec.adapter.impl.converter.a<Function3<? super wd.f, ? super wd.e, ? super ECExternalViewGroupAction, ? extends Unit>, Function3<? super IExternalViewGroup, ? super IExternalView, ? super ExternalViewGroupAction, ? extends Unit>> {
        public static final d b = null;

        static {
            b = new d();
        }

        public d() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final Function3<? super IExternalViewGroup, ? super IExternalView, ? super ExternalViewGroupAction, ? extends Unit> c(Function3<? super wd.f, ? super wd.e, ? super ECExternalViewGroupAction, ? extends Unit> r10) {
            Function3<? super wd.f, ? super wd.e, ? super ECExternalViewGroupAction, ? extends Unit> r11 = r10;
            Intrinsics.checkNotNullParameter(r11, "source");
            return new com.bytedance.android.ec.adapter.impl.converter.e(r11);
        }
    }

    public static final class e<STATE> extends com.bytedance.android.ec.adapter.impl.converter.a<yd.b<STATE>, IExternalIconModel<STATE>> {
        public e() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final Object c(Object r10) {
            yd.b r11 = (yd.b) r10;
            Intrinsics.checkNotNullParameter(r11, "source");
            return new IconModelAdapter(r11);
        }
    }

    public static final class f extends com.bytedance.android.ec.adapter.impl.converter.a<td.a, IExternalMessageListener> {
        public static final f b = null;

        static {
            b = new f();
        }

        public f() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final IExternalMessageListener c(td.a r10) {
            td.a r11 = r10;
            Intrinsics.checkNotNullParameter(r11, "source");
            return new com.bytedance.android.ec.adapter.impl.converter.f(r11);
        }
    }

    public static final class g extends o<rd.b, ISaasLiveRoomControllerProvider> {
        public static final g c = null;

        static {
            c = new g();
        }

        public g() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final Object c(Object r10) {
            rd.b r11 = (rd.b) r10;
            Intrinsics.checkNotNullParameter(r11, "source");
            return new com.bytedance.android.ec.adapter.impl.converter.g(r11);
        }
    }

    public static final class h extends com.bytedance.android.ec.adapter.impl.converter.a<rd.c, IStartLivePreviewController> {
        public static final h b = null;

        static {
            b = new h();
        }

        public h() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final IStartLivePreviewController c(rd.c r10) {
            rd.c r11 = r10;
            Intrinsics.checkNotNullParameter(r11, "source");
            return new com.bytedance.android.ec.adapter.impl.adapters.e(r11);
        }
    }

    public static final class i extends com.bytedance.android.ec.adapter.impl.converter.a<yd.c, IExternalIconTemplate> {
        public static final i b = null;

        static {
            b = new i();
        }

        public i() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final IExternalIconTemplate c(yd.c r10) {
            yd.c r11 = r10;
            Intrinsics.checkNotNullParameter(r11, "source");
            return new com.bytedance.android.ec.adapter.impl.adapters.views.b(r11);
        }
    }

    public static final class j extends com.bytedance.android.ec.adapter.impl.converter.a<vd.a, ToolbarComponentCheckInterface> {
        public static final j b = null;

        static {
            b = new j();
        }

        public j() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final ToolbarComponentCheckInterface c(vd.a r10) {
            vd.a r11 = r10;
            Intrinsics.checkNotNullParameter(r11, "source");
            return new com.bytedance.android.ec.adapter.impl.converter.h(r11);
        }
    }

    public static final class k extends com.bytedance.android.ec.adapter.impl.converter.a<wd.g, IExternalWidget> {
        public static final k b = null;

        static {
            b = new k();
        }

        public k() {
        }

        @Override // com.bytedance.android.ec.adapter.impl.converter.a
        public final IExternalWidget c(wd.g r10) {
            wd.g r11 = r10;
            Intrinsics.checkNotNullParameter(r11, "source");
            return new com.bytedance.android.ec.adapter.impl.adapters.views.d(r11);
        }
    }

    static {
        a = new LinkedHashSet();
    }
}
