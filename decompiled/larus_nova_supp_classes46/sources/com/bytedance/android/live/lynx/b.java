package com.bytedance.android.live.lynx;

import com.bytedance.android.live.lynx.ui.replay.ReplayVideoLynxView;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.ies.xelement.LynxVideoManager;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.ies.xelement.alphavideo.LynxAlphaVideo;
import com.bytedance.ies.xelement.audiott.LynxAudioTTView;
import com.bytedance.ies.xelement.banner.LynxSwiperView;
import com.bytedance.ies.xelement.bytedlottie.LynxBytedLottieView;
import com.bytedance.ies.xelement.live.LynxLiveView;
import com.bytedance.ies.xelement.picker.LynxPickerView;
import com.bytedance.ies.xelement.video.pro.LynxVideoUI;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.XElementBehavior;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.canvas.LynxHeliumCanvas;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements com.bytedance.android.live.lynx.a {

    public static final class a implements com.bytedance.android.live.lynx.c.a<com.bytedance.android.live.lynx.a> {

        /* JADX INFO: renamed from: com.bytedance.android.live.lynx.b$a$a, reason: collision with other inner class name */
        public static final class C0121a {
            public static final b a = null;

            static {
                a = new b();
            }
        }

        public a() {
        }

        @Override // com.bytedance.android.live.lynx.c.a
        public final void provide() {
            b r0 = C0121a.a;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.lynx.b$b, reason: collision with other inner class name */
    public static final class C0122b extends com.lynx.tasm.behavior.a {
        public C0122b() {
            super("lottie-view");
        }

        public final LynxUI<?> createUI(LynxContext r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return new LynxBytedLottieView(r3, "");
        }
    }

    public static final class c extends com.lynx.tasm.behavior.a {
        public c() {
            super("x-live");
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            return new LynxLiveView(r2);
        }
    }

    public static final class d extends com.lynx.tasm.behavior.a {
        public d() {
            super("x-record-video");
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new ReplayVideoLynxView(r2);
        }
    }

    public static final class e extends com.lynx.tasm.behavior.a {
        public e() {
            super("x-audio-tt");
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new LynxAudioTTView(r2);
        }
    }

    public static final class f extends com.lynx.tasm.behavior.a {
        public f() {
            super("x-video-pro");
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            LynxVideoUI r0 = new LynxVideoUI(r2);
            r0.T(new sic.a());
            return r0;
        }
    }

    public static final class g extends com.lynx.tasm.behavior.a {
        public g() {
            super("canvas");
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            jc1.k.n(IHostAction.class).initLynxHelium();
            return new LynxHeliumCanvas(r2);
        }
    }

    public static final class h extends com.lynx.tasm.behavior.a {
        public h() {
            super("swiper", false, true);
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new LynxSwiperView(r2);
        }
    }

    public static final class i extends com.lynx.tasm.behavior.a {
        public i() {
            super("x-video");
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new LynxVideoManager(r2);
        }
    }

    public static final class j extends com.lynx.tasm.behavior.a {
        public j() {
            super("x-video-flower");
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new LynxVideoManagerLite(r2);
        }
    }

    public static final class k extends com.lynx.tasm.behavior.a {

        public static final class a implements y76.a {
            public final /* synthetic */ LynxContext a;

            public final Map<String, String> a() {
                return MapsKt.mapOf(new Pair[]{TuplesKt.to("confirm", this.a.getResources().getString(2131923502)), TuplesKt.to("cancel", this.a.getResources().getString(2131923501))});
            }

            public a(LynxContext r1) {
                this.a = r1;
            }
        }

        public k() {
            super("x-picker");
        }

        public final LynxUI<?> createUI(LynxContext r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return new LynxPickerView(r3, new a(r3));
        }
    }

    public static final class l extends com.lynx.tasm.behavior.a {
        public l() {
            super("x-alpha-video");
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new LynxAlphaVideo(r2);
        }
    }

    public b() {
    }

    @Override // com.bytedance.android.live.lynx.a
    public final List<com.lynx.tasm.behavior.a> c() {
        List<com.lynx.tasm.behavior.a> r0 = new XElementBehavior().create();
        r0.addAll(CollectionsKt.mutableListOf(new com.lynx.tasm.behavior.a[]{new g(), new h(), new i(), new j(), new k(), new l()}));
        kjc.c r1 = new kjc.c();
        if (2 != kjc.a.a()) goto L6;
        r1.a.a = Unit.INSTANCE;
        r1.b = true;
    L6:
        if (r1.b == true) goto L8;
        kjc.b r2 = r1.a;
        r0.addAll(CollectionsKt.mutableListOf(new com.lynx.tasm.behavior.a[]{new C0122b(), new c(), new d(), new e(), new f()}));
        r2.a = Unit.INSTANCE;
    L8:
        Object r3 = r1.a.a;
        return r0;
    }

    @Override // com.bytedance.android.live.lynx.a
    public final boolean isEnableDebug() {
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.lynx.a
    public final void b(boolean r2) {
        LynxEnv.inst().enableDevtool(r2);
        LynxEnv.inst().enableLynxDebug(r2);
    }

    @Override // com.bytedance.android.live.lynx.a
    public final void d(TemplateData r1) {
        if (r1 == null) goto L5;
        r1.markReadOnly();
        return;
    }

    @Override // com.bytedance.android.live.lynx.a
    public final void a(LynxViewBuilder r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        if (r4 != null) goto L5;
    L9:
        r3.setEnableUserCodeCache(true);
        r3.setCodeCacheSourceUrl(r4);
        return;
    L5:
        if (r4.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L9;
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.lynx.a
    public final void setEnableJSRuntime(LynxViewBuilder r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        r2.setEnableJSRuntime(r3);
    }

    @Override // com.bytedance.android.live.lynx.a
    public final LynxGroup e(String r8, String[] r9, boolean r10, boolean r11, boolean r12, int r13) {
        if (r13 == 1) goto L5;
        if (r13 != 0) goto L10;
        return LynxGroup.Create(r8, r9, r10, r11, r12, false);
    L10:
        return LynxGroup.Create(r8, r9, r10, r11, r12);
    L5:
        return LynxGroup.Create(r8, r9, r10, r11, r12, true);
    }
}
