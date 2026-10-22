package com.bytedance.android.live.effect.sticker.viewmodel;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.api.AigcBackgroundImageGenerateTask;
import com.bytedance.android.live.effect.sticker.api.LiveEffectApi;
import com.bytedance.android.live.effect.sticker.presenter.j;
import com.bytedance.android.live.effect.sticker.presenter.k;
import com.bytedance.android.live.effect.sticker.presenter.n0;
import com.bytedance.android.live.effect.sticker.presenter.s;
import com.bytedance.android.live.effect.sticker.presenter.t;
import com.bytedance.android.live.effect.sticker.presenter.u;
import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanelClickType;
import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanelStatus;
import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanelStatusBundleKey;
import com.bytedance.android.live.effect.utils.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020\u0003¢\u0006\u0004\b@\u0010AJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J&\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005R#\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR&\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001eR&\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u001f0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001eR\u001e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001eR\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u0004\u0018\u00010.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0004\u0018\u0001028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u001c068F¢\u0006\u0006\u001a\u0004\b7\u00108R#\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f068F¢\u0006\u0006\u001a\u0004\b:\u00108R#\u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u001f068F¢\u0006\u0006\u001a\u0004\b<\u00108R\u0019\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$068F¢\u0006\u0006\u001a\u0004\b>\u00108¨\u0006B"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerAigcViewModel;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "", "", "paths", "", "setImageListToAigcSticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "keyword", "imagePathList", "onCommitAigcTaskFinish", "updateAigcTaskPanelStatus", "clearAigcStickerRenderCache", "hideAigcHint", "Lcom/bytedance/android/live/effect/sticker/presenter/s;", "kotlin.jvm.PlatformType", "aigcTaskManager$delegate", "Lkotlin/Lazy;", "getAigcTaskManager", "()Lcom/bytedance/android/live/effect/sticker/presenter/s;", "aigcTaskManager", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager$delegate", "getComposerManager", "()Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager", "Landroidx/lifecycle/MutableLiveData;", "", "_aigcTaskPanelVisible", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Lcom/bytedance/android/live/effect/sticker/ui/aigc/AigcTaskPanelStatus;", "Landroid/os/Bundle;", "_aigcTaskPanelStatus", "_aigcHintStatus", "Lcom/bytedance/android/live/effect/sticker/ui/aigc/b;", "_aigcTaskPanelListener", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "panel", "Ljava/lang/String;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerRenderViewModel;", "getStickerRenderViewModel", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerRenderViewModel;", "stickerRenderViewModel", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDialogUIViewModel;", "getStickerDialogUIViewModel", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDialogUIViewModel;", "stickerDialogUIViewModel", "Landroidx/lifecycle/LiveData;", "getAigcTaskPanelVisible", "()Landroidx/lifecycle/LiveData;", "aigcTaskPanelVisible", "getAigcTaskPanelStatus", "aigcTaskPanelStatus", "getAigcHintStatus", "aigcHintStatus", "getAigcTaskPanelListener", "aigcTaskPanelListener", "<init>", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerAigcViewModel extends StickerBaseViewModel {
    private final MutableLiveData<Pair<Boolean, String>> _aigcHintStatus;
    private MutableLiveData<com.bytedance.android.live.effect.sticker.ui.aigc.b> _aigcTaskPanelListener;
    private final MutableLiveData<Pair<AigcTaskPanelStatus, Bundle>> _aigcTaskPanelStatus;
    private final MutableLiveData<Boolean> _aigcTaskPanelVisible;
    private final Lazy aigcTaskManager$delegate;
    private final Lazy composerManager$delegate;
    private final String panel;
    private final LiveEffectScene scene;
    private final LiveEffectContextFactoryDelegate$Type type;

    public static final class a implements k {
        public final /* synthetic */ StickerAigcViewModel a;
        public final /* synthetic */ Sticker b;
        public final /* synthetic */ Ref.ObjectRef c;

        @Override // com.bytedance.android.live.effect.sticker.presenter.k
        public final void a(List<String> r6) {
            Intrinsics.checkNotNullParameter(r6, "succeedPathList");
            StickerRenderViewModel r0 = StickerAigcViewModel.access$getStickerRenderViewModel$p(this.a);
            if (r0 == null) goto L15;
            LiveData<Sticker> r1 = r0.getRenderStickerData();
            if (r1 == null) goto L16;
            Sticker r2 = (Sticker) r1.getValue();
            if (r2 != null) goto L9;
            return;
        L9:
            if (r2.getId() == this.b.getId()) goto L11;
            return;
        L11:
            if (r6.isEmpty() == false) goto L13;
            MutableLiveData r7 = StickerAigcViewModel.access$get_aigcTaskPanelStatus$p(this.a);
            AigcTaskPanelStatus r3 = AigcTaskPanelStatus.Done;
            Bundle r4 = new Bundle();
            r4.putString(AigcTaskPanelStatusBundleKey.Keyword.getKeyName(), (String) this.c.element);
            Unit r5 = Unit.INSTANCE;
            r7.setValue(new Pair(r3, r4));
            StickerAigcViewModel.access$get_aigcHintStatus$p(this.a).setValue(new Pair(Boolean.TRUE, s1.B(2131916334)));
            return;
        L13:
            StickerAigcViewModel.access$setImageListToAigcSticker(this.a, r6);
            MutableLiveData r8 = StickerAigcViewModel.access$get_aigcTaskPanelStatus$p(this.a);
            AigcTaskPanelStatus r9 = AigcTaskPanelStatus.Ready;
            Bundle r11 = new Bundle();
            r11.putBoolean(AigcTaskPanelStatusBundleKey.CanApplyBackgroundImage.getKeyName(), true);
            Unit r12 = Unit.INSTANCE;
            r8.setValue(new Pair(r9, r11));
            StickerAigcViewModel.access$getAigcTaskManager$p(this.a).m(this.b, (String) this.c.element, StickerAigcViewModel.access$getScene$p(this.a).getPage());
            return;
        L16:
            return;
        }

        public a(StickerAigcViewModel r1, Sticker r2, Ref.ObjectRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b implements com.bytedance.android.live.effect.sticker.ui.aigc.b {
        public final /* synthetic */ StickerAigcViewModel a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Sticker c;

        public static final class a implements j {
            public final /* synthetic */ b a;
            public final /* synthetic */ String b;

            /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.viewmodel.StickerAigcViewModel$b$a$a, reason: collision with other inner class name */
            public static final class C0194a implements n0 {
                public final /* synthetic */ a a;

                /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.viewmodel.StickerAigcViewModel$b$a$a$a, reason: collision with other inner class name */
                public static final class C0195a implements k {
                    public final /* synthetic */ C0194a a;

                    public C0195a(C0194a r1) {
                        this.a = r1;
                    }

                    @Override // com.bytedance.android.live.effect.sticker.presenter.k
                    public final void a(List<String> r4) {
                        Intrinsics.checkNotNullParameter(r4, "succeedPathList");
                        a r0 = this.a.a;
                        b r1 = r0.a;
                        StickerAigcViewModel.access$onCommitAigcTaskFinish(r1.a, r1.c, r0.b, r4);
                    }
                }

                public C0194a(a r1) {
                    this.a = r1;
                }

                @Override // com.bytedance.android.live.effect.sticker.presenter.n0
                public final void a(AigcBackgroundImageGenerateTask r5) {
                    Intrinsics.checkNotNullParameter(r5, "task");
                    if (r5.getStatus() != LiveEffectApi.AigcTaskStatus.FINISH.getValue()) goto L24;
                    s r0 = StickerAigcViewModel.access$getAigcTaskManager$p(this.a.a.a);
                    long r1 = r5.getTaskID();
                    r0.getClass();
                    Intrinsics.checkNotNullParameter(this, "listener");
                    Map<Long, List<n0>> r2 = r0.c;
                    LinkedHashMap r3 = (LinkedHashMap) r2;
                    List r4 = (List) r3.get(Long.valueOf(r1));
                    if (r4 == null) goto L7;
                    r4.remove(this);
                L7:
                    ArrayList r6 = new ArrayList();
                    Iterator<ImageModel> r7 = r5.getImageList().iterator();
                L9:
                    if (r7.hasNext() == false) goto L15;
                    List<String> r8 = r7.next().getUrls();
                    if (r8 == null) goto L9;
                    String r9 = (String) CollectionsKt.firstOrNull(r8);
                    if (r9 == null) goto L9;
                    r6.add(r9);
                    goto L9
                L15:
                    StickerAigcViewModel.access$getAigcTaskManager$p(this.a.a.a).d(r6, new C0195a(this));
                    return;
                }
            }

            @Override // com.bytedance.android.live.effect.sticker.presenter.j
            public final void onFail() {
                b r0 = this.a;
                StickerAigcViewModel.access$onCommitAigcTaskFinish(r0.a, r0.c, this.b, CollectionsKt.emptyList());
            }

            @Override // com.bytedance.android.live.effect.sticker.presenter.j
            public final void a(AigcBackgroundImageGenerateTask r7) {
                Intrinsics.checkNotNullParameter(r7, "task");
                StickerRenderViewModel r0 = StickerAigcViewModel.access$getStickerRenderViewModel$p(this.a.a);
                if (r0 == null) goto L21;
                LiveData<Sticker> r1 = r0.getRenderStickerData();
                if (r1 == null) goto L22;
                Sticker r2 = (Sticker) r1.getValue();
                if (r2 != null) goto L9;
                return;
            L9:
                if (r2.getId() != this.a.c.getId()) goto L24;
                s r3 = StickerAigcViewModel.access$getAigcTaskManager$p(this.a.a);
                long r4 = r7.getTaskID();
                C0194a r8 = new C0194a(this);
                r3.getClass();
                Intrinsics.checkNotNullParameter(r8, "listener");
                Map<Long, List<n0>> r5 = r3.c;
                LinkedHashMap r6 = (LinkedHashMap) r5;
                if (r6.get(Long.valueOf(r4)) != null) goto L13;
                r3.c.put(Long.valueOf(r4), new ArrayList());
            L13:
                Map<Long, List<n0>> r9 = r3.c;
                LinkedHashMap r11 = (LinkedHashMap) r9;
                List r12 = (List) r11.get(Long.valueOf(r4));
                if (r12 != null) goto L16;
            L17:
                Map<Long, List<n0>> r13 = r3.c;
                LinkedHashMap r14 = (LinkedHashMap) r13;
                List r15 = (List) r14.get(Long.valueOf(r4));
                if (r15 == null) goto L26;
                r15.add(r8);
                return;
            L26:
                return;
            L16:
                if (r12.contains(r8) != true) goto L17;
                return;
            L24:
                return;
            L22:
                return;
            }

            public a(b r1, String r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        @Override // com.bytedance.android.live.effect.sticker.ui.aigc.b
        public final void b() {
            StickerDialogUIViewModel r0 = StickerAigcViewModel.access$getStickerDialogUIViewModel$p(this.a);
            if (r0 == null) goto L8;
            com.bytedance.live.datacontext.k<Unit> r1 = r0.getHideDialogEvent();
            if (r1 == null) goto L9;
            r1.post(Unit.INSTANCE);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.live.effect.sticker.ui.aigc.b
        public final void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "keyword");
            List<String> r0 = q.a;
            q.c(this.c, r4, AigcTaskPanelClickType.ReSelectKeyword, StickerAigcViewModel.access$getScene$p(this.a).getPage());
        }

        @Override // com.bytedance.android.live.effect.sticker.ui.aigc.b
        public final void d(AigcTaskPanelStatus r4) {
            Intrinsics.checkNotNullParameter(r4, "status");
            if (r4 == AigcTaskPanelStatus.Running) goto L11;
            MutableLiveData r5 = StickerAigcViewModel.access$get_aigcHintStatus$p(this.a);
            Boolean r1 = Boolean.FALSE;
            Pair r2 = (Pair) StickerAigcViewModel.access$get_aigcHintStatus$p(this.a).getValue();
            if (r2 == null) goto L8;
            String r3 = (String) r2.getSecond();
            if (r3 == null) goto L8;
        L9:
            r5.setValue(new Pair(r1, r3));
            return;
        L8:
            r3 = "";
            goto L9
        }

        @Override // com.bytedance.android.live.effect.sticker.ui.aigc.b
        public final void c(String r13, AigcTaskPanelClickType r14) {
            Intrinsics.checkNotNullParameter(r13, "keyword");
            Intrinsics.checkNotNullParameter(r14, "clickType");
            MutableLiveData r1 = StickerAigcViewModel.access$get_aigcTaskPanelStatus$p(this.a);
            AigcTaskPanelStatus r2 = AigcTaskPanelStatus.Running;
            Bundle r3 = new Bundle();
            r3.putString(AigcTaskPanelStatusBundleKey.Keyword.getKeyName(), r13);
            boolean r5 = true;
            r3.putBoolean(AigcTaskPanelStatusBundleKey.ShowAnimation.getKeyName(), true);
            Unit r4 = Unit.INSTANCE;
            r1.setValue(new Pair(r2, r3));
            s r6 = StickerAigcViewModel.access$getAigcTaskManager$p(this.a);
            long r7 = this.b;
            String r11 = this.c.getAigcEffectInfo().getModelPrompt(r13);
            String r12 = this.c.getAigcEffectInfo().getModelReqKey();
            a r8 = new a(this, r13);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r13, "keyword");
            Intrinsics.checkNotNullParameter(r11, "modelKeyword");
            Intrinsics.checkNotNullParameter(r12, "modelReqKey");
            com.bytedance.android.live.effect.sticker.presenter.g r0 = (com.bytedance.android.live.effect.sticker.presenter.g) ((LinkedHashMap) r6.b).get(Long.valueOf(r7));
            if (r0 == null) goto L5;
            List<Long> r9 = r0.b;
        L6:
            if (r9 != null) goto L8;
        L11:
            if (r5 == false) goto L13;
            RxUtilKt.c(((LiveEffectApi) com.bytedance.android.live.network.c.b().e(LiveEffectApi.class)).commitAigcBackgroundImageGenerateTask(r7, r13, r11, r12).compose(RxUtil.rxSchedulerHelper()).subscribe(new t(r6, r7, r8), new u(r8)), r6.a);
        L14:
            List<String> r15 = q.a;
            q.c(this.c, r13, r14, StickerAigcViewModel.access$getScene$p(this.a).getPage());
            return;
        L13:
            ALogger.e("ttlive_anchor_effect_LiveEffectAigcTaskManager", r7 + " has running tasks, fail to commit new task");
            goto L14
        L8:
            if (r9.isEmpty() == true) goto L11;
            r5 = false;
            goto L11
        L5:
            r9 = null;
            goto L6
        }

        public b(StickerAigcViewModel r1, long r2, Sticker r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }
    }

    private final s getAigcTaskManager() {
        return (s) this.aigcTaskManager$delegate.getValue();
    }

    private final ILiveEffectComposerManager getComposerManager() {
        return (ILiveEffectComposerManager) this.composerManager$delegate.getValue();
    }

    private final StickerDialogUIViewModel getStickerDialogUIViewModel() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.scene;
        r0.getClass();
        return (StickerDialogUIViewModel) StickerBaseViewModel.a.a(r1, StickerDialogUIViewModel.class);
    }

    private final StickerRenderViewModel getStickerRenderViewModel() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.scene;
        r0.getClass();
        return (StickerRenderViewModel) StickerBaseViewModel.a.a(r1, StickerRenderViewModel.class);
    }

    public final void clearAigcStickerRenderCache() {
        Iterator r0 = CollectionsKt.listOf(new String[]{"", "", "", ""}).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        String r2 = (String) r0.next();
        ILiveEffectComposerManager r3 = getComposerManager();
        StringBuilder r4 = new StringBuilder("amgOnly_live_bg_");
        r1 = r1 + 1;
        r4.append(r1);
        r3.n(r4.toString(), r2);
        goto L4
    }

    public final void hideAigcHint() {
        MutableLiveData<Pair<Boolean, String>> r0 = this._aigcHintStatus;
        Boolean r2 = Boolean.FALSE;
        Pair r3 = (Pair) r0.getValue();
        if (r3 == null) goto L6;
        String r4 = (String) r3.getSecond();
        if (r4 == null) goto L6;
    L7:
        r0.setValue(new Pair(r2, r4));
        return;
    L6:
        r4 = "";
        goto L7
    }

    public final LiveData<Pair<Boolean, String>> getAigcHintStatus() {
        return this._aigcHintStatus;
    }

    public final LiveData<com.bytedance.android.live.effect.sticker.ui.aigc.b> getAigcTaskPanelListener() {
        return this._aigcTaskPanelListener;
    }

    public final LiveData<Pair<AigcTaskPanelStatus, Bundle>> getAigcTaskPanelStatus() {
        return this._aigcTaskPanelStatus;
    }

    public final LiveData<Boolean> getAigcTaskPanelVisible() {
        return this._aigcTaskPanelVisible;
    }

    public static final /* synthetic */ s access$getAigcTaskManager$p(StickerAigcViewModel r0) {
        return r0.getAigcTaskManager();
    }

    public static final /* synthetic */ LiveEffectScene access$getScene$p(StickerAigcViewModel r0) {
        return r0.scene;
    }

    public static final /* synthetic */ StickerDialogUIViewModel access$getStickerDialogUIViewModel$p(StickerAigcViewModel r0) {
        return r0.getStickerDialogUIViewModel();
    }

    public static final /* synthetic */ StickerRenderViewModel access$getStickerRenderViewModel$p(StickerAigcViewModel r0) {
        return r0.getStickerRenderViewModel();
    }

    public static final /* synthetic */ LiveEffectContextFactoryDelegate$Type access$getType$p(StickerAigcViewModel r0) {
        return r0.type;
    }

    public static final /* synthetic */ MutableLiveData access$get_aigcHintStatus$p(StickerAigcViewModel r0) {
        return r0._aigcHintStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_aigcTaskPanelStatus$p(StickerAigcViewModel r0) {
        return r0._aigcTaskPanelStatus;
    }

    private final void setImageListToAigcSticker(List<String> r6) {
        Iterator<T> r7 = r6.iterator();
        int r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L6;
        String r1 = (String) r7.next();
        ILiveEffectComposerManager r2 = getComposerManager();
        StringBuilder r3 = new StringBuilder("amgOnly_live_bg_");
        r0 = r0 + 1;
        r3.append(r0);
        r2.n(r3.toString(), r1);
        goto L4
    }

    public final void updateAigcTaskPanelStatus(Sticker r14) {
        if (r14 != null) goto L4;
    L48:
        this._aigcTaskPanelVisible.setValue(Boolean.FALSE);
        return;
    L4:
        if (r14.isAigcSticker() == false) goto L48;
        long r0 = r14.getId();
        Map r2 = (Map) ((LinkedHashMap) getAigcTaskManager().f(CollectionsKt.listOf(Long.valueOf(r0)))).get(Long.valueOf(r0));
        if (r2 != null) goto L9;
        r2 = MapsKt.emptyMap();
    L9:
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        String r4 = "";
        r3.element = "";
        ArrayList r5 = new ArrayList();
        Iterator r6 = r2.values().iterator();
        boolean r7 = false;
        boolean r8 = false;
        boolean r9 = false;
    L11:
        if (r6.hasNext() == false) goto L27;
        AigcBackgroundImageGenerateTask r11 = (AigcBackgroundImageGenerateTask) r6.next();
        if (r11.getStatus() == LiveEffectApi.AigcTaskStatus.FINISH.getValue()) goto L14;
        if (r11.getStatus() != LiveEffectApi.AigcTaskStatus.RUNNING.getValue()) goto L11;
        r4 = r11.getKeyWord();
        r8 = true;
        goto L11
    L14:
        r3.element = r11.getKeyWord();
        r5.clear();
        Iterator<ImageModel> r12 = r11.getImageList().iterator();
    L16:
        if (r12.hasNext() == false) goto L22;
        List<String> r13 = r12.next().getUrls();
        if (r13 == null) goto L16;
        String r15 = (String) CollectionsKt.firstOrNull(r13);
        if (r15 == null) goto L16;
        r5.add(r15);
        goto L16
    L22:
        r9 = true;
        goto L11
    L27:
        if (this.scene != LiveEffectScene.Preview) goto L29;
        this._aigcTaskPanelVisible.setValue(Boolean.TRUE);
        if (r8 == false) goto L40;
        MutableLiveData<Pair<AigcTaskPanelStatus, Bundle>> r16 = this._aigcTaskPanelStatus;
        AigcTaskPanelStatus r1 = AigcTaskPanelStatus.Running;
        Bundle r17 = new Bundle();
        r17.putString(AigcTaskPanelStatusBundleKey.Keyword.getKeyName(), r4);
        r17.putBoolean(AigcTaskPanelStatusBundleKey.ShowAnimation.getKeyName(), false);
        Unit r18 = Unit.INSTANCE;
        r16.setValue(new Pair(r1, r17));
        return;
    L40:
        if (r9 == true) goto L42;
        MutableLiveData<Pair<AigcTaskPanelStatus, Bundle>> r19 = this._aigcTaskPanelStatus;
        AigcTaskPanelStatus r21 = AigcTaskPanelStatus.Ready;
        Bundle r22 = new Bundle();
        r22.putBoolean(AigcTaskPanelStatusBundleKey.CanApplyBackgroundImage.getKeyName(), false);
        Unit r23 = Unit.INSTANCE;
        r19.setValue(new Pair(r21, r22));
    L46:
        this._aigcTaskPanelListener.setValue(new b(this, r0, r14));
        return;
    L42:
        if (getAigcTaskManager().g(r14.getId()) == false) goto L44;
        setImageListToAigcSticker(getAigcTaskManager().e(r5));
        MutableLiveData<Pair<AigcTaskPanelStatus, Bundle>> r24 = this._aigcTaskPanelStatus;
        AigcTaskPanelStatus r25 = AigcTaskPanelStatus.Ready;
        Bundle r26 = new Bundle();
        r26.putBoolean(AigcTaskPanelStatusBundleKey.CanApplyBackgroundImage.getKeyName(), true);
        Unit r27 = Unit.INSTANCE;
        r24.setValue(new Pair(r25, r26));
        getAigcTaskManager().m(r14, (String) r3.element, this.scene.getPage());
        goto L46
    L44:
        MutableLiveData<Pair<AigcTaskPanelStatus, Bundle>> r28 = this._aigcTaskPanelStatus;
        AigcTaskPanelStatus r29 = AigcTaskPanelStatus.Running;
        Bundle r31 = new Bundle();
        r31.putString(AigcTaskPanelStatusBundleKey.Keyword.getKeyName(), (String) r3.element);
        r31.putBoolean(AigcTaskPanelStatusBundleKey.ShowAnimation.getKeyName(), true);
        Unit r32 = Unit.INSTANCE;
        r28.setValue(new Pair(r29, r31));
        getAigcTaskManager().d(r5, new a(this, r14, r3));
        goto L46
    L29:
        if ((!r5.isEmpty()) == true) goto L31;
        return;
    L31:
        if (((String) r3.element).length() <= 0) goto L33;
        r7 = true;
    L33:
        if (r7 == false) goto L66;
        setImageListToAigcSticker(getAigcTaskManager().e(r5));
        getAigcTaskManager().m(r14, (String) r3.element, this.scene.getPage());
        return;
    }

    public static final /* synthetic */ void access$setImageListToAigcSticker(StickerAigcViewModel r0, List r1) {
        r0.setImageListToAigcSticker(r1);
    }

    public StickerAigcViewModel(LiveEffectContextFactoryDelegate$Type r2, LiveEffectScene r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "panel");
        this.type = r2;
        this.scene = r3;
        this.panel = r4;
        this.aigcTaskManager$delegate = LazyKt.lazy(new StickerAigcViewModel$aigcTaskManager$2(this));
        this.composerManager$delegate = LazyKt.lazy(new StickerAigcViewModel$composerManager$2(this));
        this._aigcTaskPanelVisible = new MutableLiveData();
        this._aigcTaskPanelStatus = new MutableLiveData();
        this._aigcHintStatus = new MutableLiveData();
        this._aigcTaskPanelListener = new MutableLiveData();
    }

    private final void onCommitAigcTaskFinish(Sticker r6, String r7, List<String> r8) {
        StickerRenderViewModel r0 = getStickerRenderViewModel();
        if (r0 == null) goto L18;
        LiveData<Sticker> r1 = r0.getRenderStickerData();
        if (r1 == null) goto L19;
        Sticker r2 = (Sticker) r1.getValue();
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.getId() != r6.getId()) goto L21;
        setImageListToAigcSticker(r8);
        MutableLiveData<Pair<AigcTaskPanelStatus, Bundle>> r3 = this._aigcTaskPanelStatus;
        AigcTaskPanelStatus r4 = AigcTaskPanelStatus.Done;
        Bundle r5 = new Bundle();
        r5.putString(AigcTaskPanelStatusBundleKey.Keyword.getKeyName(), r7);
        Unit r9 = Unit.INSTANCE;
        r3.setValue(new Pair(r4, r5));
        MutableLiveData<Pair<Boolean, String>> r11 = this._aigcHintStatus;
        Boolean r12 = Boolean.TRUE;
        if (r8.isEmpty() == false) goto L13;
        String r13 = s1.B(2131916331);
    L14:
        r11.setValue(new Pair(r12, r13));
        if ((!r8.isEmpty()) == false) goto L22;
        List<String> r14 = q.a;
        String r15 = this.scene.getPage();
        Intrinsics.checkNotNullParameter(r6, "sticker");
        Intrinsics.checkNotNullParameter(r7, "keyword");
        Intrinsics.checkNotNullParameter(r15, "eventPage");
        HashMap r16 = new HashMap();
        r16.put("sticker_id", String.valueOf(r6.getId()));
        r16.put("key_word", r7);
        q.e("livesdk_live_ai_sticker_generate_success", r16, r15);
        return;
    L22:
        return;
    L13:
        r13 = s1.B(2131916332) + r8.size() + s1.B(2131916333);
        goto L14
    L21:
        return;
    L19:
        return;
    }

    public static final /* synthetic */ void access$onCommitAigcTaskFinish(StickerAigcViewModel r0, Sticker r1, String r2, List r3) {
        r0.onCommitAigcTaskFinish(r1, r2, r3);
    }
}
