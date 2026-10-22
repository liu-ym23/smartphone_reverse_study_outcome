package com.bytedance.android.live.platformplayer.effect;

import com.bytedance.android.livesdkapi.roomplayer.ComposerResult;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "effect", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class VrEffectDownloader$doDownloadEffect$1 extends Lambda implements Function1<Effect, Unit> {
    final /* synthetic */ ILivePlayerClient $playerClient;
    final /* synthetic */ VrEffectDownloader this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.platformplayer.effect.VrEffectDownloader$doDownloadEffect$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ComposerResult {
        public final /* synthetic */ VrEffectDownloader$doDownloadEffect$1 a;
        public final /* synthetic */ Effect b;

        public final void onResult(int r8) {
            com.bytedance.android.live.player.utils.b.g("LiveVrEffect_VrEffectDownloader", "success removeEffect=" + r8);
            BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new VrEffectDownloader$doDownloadEffect$1$1$onResult$1(this, null), 3, null);
        }

        public AnonymousClass1(VrEffectDownloader$doDownloadEffect$1 r1, Effect r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public VrEffectDownloader$doDownloadEffect$1(VrEffectDownloader r1, ILivePlayerClient r2) {
        this.this$0 = r1;
        this.$playerClient = r2;
        super(1);
    }

    public final void invoke(Effect r13) {
        if (r13 != null) goto L4;
        return;
    L4:
        VrEffectDownloader r0 = this.this$0;
        if (r0.b >= 0) goto L7;
        r0.b = System.currentTimeMillis();
    L7:
        String[] r1 = this.$playerClient.getComposerNodePaths();
        if (r1 != null) goto L10;
        r1 = new String[0];
    L10:
        ArrayList r11 = new ArrayList();
        int r2 = r1.length;
        int r3 = 0;
    L11:
        boolean r4 = true;
        if (r3 >= r2) goto L23;
        String r5 = r1[r3];
        Set<String> r6 = VrEffectDownloader.g;
        if (VrEffectDownloader.g.contains(r5) == true) goto L16;
    L18:
        r4 = false;
    L19:
        if (r4 == false) goto L21;
        r11.add(r5);
    L21:
        r3 = r3 + 1;
        goto L11
    L16:
        if ((!Intrinsics.areEqual(r5, r13.getUnzipPath())) == false) goto L18;
    L23:
        if ((!r11.isEmpty()) == false) goto L29;
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "remove,path=" + CollectionsKt.joinToString$default(r11, ";", null, null, 0, null, null, 62, null));
        ILivePlayerClient r7 = this.$playerClient;
        Object[] r8 = r11.toArray(new String[0]);
        if (r8 == null) goto L28;
        r7.removeComposerNodes((String[]) r8, new AnonymousClass1(this, r13));
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L29:
        VrEffectDownloader.a(this.this$0, this.$playerClient, r13.getUnzipPath(), r13.getTags());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Effect) r1);
        return Unit.INSTANCE;
    }
}
