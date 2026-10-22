package com.bytedance.android.live.effect.sticker.chain;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.presenter.o;
import com.bytedance.android.live.effect.sticker.presenter.p;
import com.bytedance.android.live.effect.sticker.presenter.q0;
import com.bytedance.android.live.effect.sticker.presenter.s;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements m {

    public static final class a implements p {
        public final /* synthetic */ b a;
        public final /* synthetic */ l b;

        @Override // com.bytedance.android.live.effect.sticker.presenter.p
        public final void onFail() {
            b.b(this.a, this.b, "aigc特效初始化失败");
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.p
        public final void onSuccess() {
            b r0 = this.a;
            l r1 = this.b;
            r0.getClass();
            b.c(r1, true);
        }

        public a(b r1, l r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.chain.b$b, reason: collision with other inner class name */
    public static final class C0190b extends q0 {
        public final /* synthetic */ b a;
        public final /* synthetic */ Sticker b;
        public final /* synthetic */ s c;
        public final /* synthetic */ l d;
        public final /* synthetic */ StickerDialogUIViewModel e;

        /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.chain.b$b$a */
        public static final class a implements p {
            public final /* synthetic */ C0190b a;
            public final /* synthetic */ Sticker b;

            @Override // com.bytedance.android.live.effect.sticker.presenter.p
            public final void onFail() {
                C0190b r0 = this.a;
                b.b(r0.a, r0.d, "aigc特效初始化失败");
            }

            @Override // com.bytedance.android.live.effect.sticker.presenter.p
            public final void onSuccess() {
                l r0 = this.a.d;
                Sticker r1 = this.b;
                r0.getClass();
                Intrinsics.checkNotNullParameter(r1, "<set-?>");
                r0.g = r1;
                StickerDialogUIViewModel r2 = this.a.e;
                if (r2 == null) goto L7;
                com.bytedance.live.datacontext.k<Sticker> r3 = r2.getStickerDownloadCompleteEvent();
                if (r3 == null) goto L7;
                r3.post(this.b);
            L7:
                C0190b r4 = this.a;
                b r5 = r4.a;
                l r6 = r4.d;
                r5.getClass();
                b.c(r6, false);
            }

            public a(C0190b r1, Sticker r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.o.c
        public final void b() {
            this.b.setDownloading(false);
            this.b.setDownloaded(false);
            b.b(this.a, this.d, "下载失败");
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.o.c
        public final void a(Sticker r5) {
            Intrinsics.checkNotNullParameter(r5, "sticker");
            r5.setDownloading(false);
            r5.setDownloaded(true);
            if (this.b.isAigcSticker() == false) goto L13;
            s r1 = this.c;
            if (r1.k == false) goto L12;
            l r2 = this.d;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r2.g = r5;
            StickerDialogUIViewModel r3 = this.e;
            if (r3 == null) goto L11;
            com.bytedance.live.datacontext.k<Sticker> r4 = r3.getStickerDownloadCompleteEvent();
            if (r4 == null) goto L11;
            r4.post(r5);
        L11:
            b r6 = this.a;
            l r7 = this.d;
            r6.getClass();
            b.c(r7, false);
            return;
        L12:
            r1.j(new a(this, r5));
            return;
        L13:
            l r8 = this.d;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r8.g = r5;
            StickerDialogUIViewModel r9 = this.e;
            if (r9 == null) goto L18;
            com.bytedance.live.datacontext.k<Sticker> r11 = r9.getStickerDownloadCompleteEvent();
            if (r11 == null) goto L18;
            r11.post(r5);
        L18:
            b r12 = this.a;
            l r13 = this.d;
            r12.getClass();
            b.c(r13, false);
        }

        public C0190b(b r1, Sticker r2, s r3, l r4, StickerDialogUIViewModel r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public b() {
    }

    @Override // com.bytedance.android.live.effect.sticker.chain.m
    public final void a(l r11) {
        Intrinsics.checkNotNullParameter(r11, "chain");
        List<String> r0 = LiveEffectContext.h;
        com.bytedance.android.live.effect.api.k r1 = LiveEffectContext.a.a(r11.getType()).b().r();
        o r2 = LiveEffectContext.a.a(r11.getType()).b().d();
        s r6 = LiveEffectContext.a.a(r11.getType()).b().i();
        StickerBaseViewModel.a r3 = StickerBaseViewModel.Companion;
        LiveEffectScene r4 = r11.e;
        r3.getClass();
        StickerDialogUIViewModel r8 = (StickerDialogUIViewModel) StickerBaseViewModel.a.a(r4, StickerDialogUIViewModel.class);
        Sticker r5 = r11.g;
        if (r1.q(r5) == true) goto L5;
        r5.setDownloading(true);
        if (r8 == null) goto L16;
        com.bytedance.live.datacontext.k<Sticker> r7 = r8.getStickerDownloadStartEvent();
        if (r7 == null) goto L16;
        r7.post(r5);
    L16:
        r2.h(r11.f, r5, new C0190b(this, r5, r6, r11, r8));
        return;
    L5:
        if (r5.isAigcSticker() == true) goto L7;
        c(r11, true);
        return;
    L7:
        if (r6.k == false) goto L9;
        c(r11, true);
        return;
    L9:
        r6.j(new a(this, r11));
    }

    public static void c(l r3, boolean r4) {
        com.bytedance.android.live.effect.base.e r0 = r3.a;
        r0.e = r4;
        r0.b = r3.g;
        r0.g = System.currentTimeMillis();
        r3.a();
    }

    public static final void b(b r2, l r3, String r4) {
        r2.getClass();
        List<String> r5 = LiveEffectContext.h;
        ((com.bytedance.android.live.effect.api.f) LiveEffectContext.a.a(r3.getType()).f.getValue()).a(r3.a, r3.e.getPage());
        Intrinsics.checkNotNullParameter(r4, "reason");
        r3.b = false;
    }
}
