package com.bytedance.android.live.effect.sticker.viewmodel;

import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\b\u0005\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "T", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "share", "(Lcom/bytedance/android/live/effect/api/LiveEffectScene;)Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "", "panel", "(Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;)Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "<init>", "()V", "Companion", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class StickerBaseViewModel extends DataContext {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }

        public static StickerBaseViewModel a(LiveEffectScene r1, Class r2) {
            Intrinsics.checkNotNullParameter(r1, "scene");
            Intrinsics.checkNotNullParameter(r2, "clazz");
            return (StickerBaseViewModel) com.bytedance.live.datacontext.d.e(r1.name() + r2.getName(), r2);
        }

        public static StickerBaseViewModel b(LiveEffectScene r1, String r2, Class r3) {
            Intrinsics.checkNotNullParameter(r1, "scene");
            Intrinsics.checkNotNullParameter(r2, "panel");
            Intrinsics.checkNotNullParameter(r3, "clazz");
            return (StickerBaseViewModel) com.bytedance.live.datacontext.d.e(r1.name() + r2 + r3.getName(), r3);
        }
    }

    static {
        Companion = new a();
    }

    public StickerBaseViewModel() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T extends StickerBaseViewModel> T share(LiveEffectScene r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        StringBuilder r0 = new StringBuilder();
        r0.append(r3.name());
        Intrinsics.reifiedOperationMarker(4, "T");
        r0.append(StickerBaseViewModel.class.getName());
        com.bytedance.live.datacontext.b.a(this, r0.toString());
        Intrinsics.reifiedOperationMarker(1, "T");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T extends StickerBaseViewModel> T share(LiveEffectScene r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "panel");
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.name());
        r0.append(r3);
        Intrinsics.reifiedOperationMarker(4, "T");
        r0.append(StickerBaseViewModel.class.getName());
        com.bytedance.live.datacontext.b.a(this, r0.toString());
        Intrinsics.reifiedOperationMarker(1, "T");
        return this;
    }
}
