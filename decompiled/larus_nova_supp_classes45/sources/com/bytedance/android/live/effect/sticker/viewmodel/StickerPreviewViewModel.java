package com.bytedance.android.live.effect.sticker.viewmodel;

import android.content.Context;
import android.content.DialogInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.composer.m;
import com.bytedance.android.live.effect.composer.n;
import com.bytedance.android.live.effect.composer.p;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdk.config.et0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.k;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020\r¢\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J.\u0010\u000f\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002J$\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\f\u0010\u0015\u001a\u00020\u0014*\u00020\tH\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J:\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001c\u001a\u00020\u0002R\"\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\t0\t0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010$R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u0004\u0018\u00010.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0004\u0018\u0001028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\t068F¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerPreviewViewModel;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "", "applyPreviewSticker", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "onConfirm", "showRepelDialog", "Lcom/bytedance/android/live/effect/sticker/viewmodel/f;", "oldStatusInfo", "newStatusInfo", "", "", "extraInfo", "onPreviewStatusChange", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "startPreview", "stopPreview", "", "isPreviewing", "tryApplySticker", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerPreviewStatus;", "status", "Lcom/bytedance/android/live/effect/base/e;", "traceInfo", "updatePreviewStatus", "releasePreview", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "_previewStatusData", "Landroidx/lifecycle/MutableLiveData;", "", "previewExtraInfo", "Ljava/util/Map;", "Lcom/bytedance/android/live/effect/base/e;", "Landroid/content/Context;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "panel", "Ljava/lang/String;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDialogUIViewModel;", "getStickerDialogUIViewModel", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDialogUIViewModel;", "stickerDialogUIViewModel", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerRenderViewModel;", "getStickerRenderViewModel", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerRenderViewModel;", "stickerRenderViewModel", "Landroidx/lifecycle/LiveData;", "getPreviewStatusData", "()Landroidx/lifecycle/LiveData;", "previewStatusData", "<init>", "(Landroid/content/Context;Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerPreviewViewModel extends StickerBaseViewModel {
    private final MutableLiveData<f> _previewStatusData;
    private final Context context;
    private final String panel;
    private final Map<String, String> previewExtraInfo;
    private final LiveEffectScene scene;
    private com.bytedance.android.live.effect.base.e traceInfo;
    private final LiveEffectContextFactoryDelegate$Type type;

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.invoke();
            r1.dismiss();
        }
    }

    private final void applyPreviewSticker() {
        f r0 = (f) this._previewStatusData.getValue();
        if (r0 == null) goto L24;
        Sticker r1 = r0.b;
        if (r1 == null) goto L25;
        StickerDialogUIViewModel r2 = getStickerDialogUIViewModel();
        if (r2 == null) goto L9;
        r2.updateCurrentSelectStickerExtra(this.previewExtraInfo);
    L9:
        LiveEffectScene r3 = this.scene;
        if (r3 != LiveEffectScene.GiftMenuPreview) goto L12;
    L17:
        StickerDialogUIViewModel r4 = getStickerDialogUIViewModel();
        if (r4 == null) goto L22;
        k<Unit> r5 = r4.getHideDialogEvent();
        if (r5 == null) goto L22;
        r5.post(Unit.INSTANCE);
    L22:
        this.previewExtraInfo.clear();
        return;
    L12:
        if (r3 == LiveEffectScene.GiftMenuLive) goto L17;
        com.bytedance.android.live.effect.base.e r6 = new com.bytedance.android.live.effect.base.e(this.traceInfo);
        HashMap r7 = new HashMap(this.previewExtraInfo);
        updatePreviewStatus$default(this, StickerPreviewStatus.None, null, null, null, 12, null);
        StickerRenderViewModel r8 = getStickerRenderViewModel();
        if (r8 == null) goto L22;
        r8.renderSticker(r1, true, r6, r7);
        goto L22
    L25:
        return;
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

    private final void stopPreview() {
        this.previewExtraInfo.clear();
        if (this.scene != LiveEffectScene.GiftMenuPreview) goto L5;
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.type).a().b(this.panel, "stopPreview");
        return;
    L5:
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.type).a().z(new String[0], new int[0], "");
        LiveEffectContext.a.a(this.type).a().D();
    }

    public final void releasePreview() {
        updatePreviewStatus$default(this, StickerPreviewStatus.None, null, null, null, 12, null);
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.type).a().u();
    }

    public final void tryApplySticker() {
        List<String> r0 = LiveEffectContext.h;
        final Sticker r1 = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(this.type).a().o(d0.d));
        if (((Boolean) et0.a.getValue()).booleanValue() == true) goto L5;
    L10:
        applyPreviewSticker();
        return;
    L5:
        if (this.scene != LiveEffectScene.Live) goto L10;
        if (r1 == null) goto L10;
        Context r2 = this.context;
        if (r2 == null) goto L10;
        showRepelDialog(r2, new AnonymousClass1(this, r1));
    }

    public final LiveData<f> getPreviewStatusData() {
        return this._previewStatusData;
    }

    public static final /* synthetic */ void access$applyPreviewSticker(StickerPreviewViewModel r0) {
        r0.applyPreviewSticker();
    }

    public static final /* synthetic */ LiveEffectContextFactoryDelegate$Type access$getType$p(StickerPreviewViewModel r0) {
        return r0.type;
    }

    private final boolean isPreviewing(f r2) {
        if (r2.a != StickerPreviewStatus.Preview) goto L5;
        return true;
    L5:
        return false;
    }

    private final void showRepelDialog(Context r7, Function0<Unit> r8) {
        u.l().sendLog("livesdk_anchor_interactive_extension_conflict_popup", MapsKt.mapOf(TuplesKt.to("action_type", "show")), new Object[]{IRoom.class});
        z0.a().getClass();
        x0.b r0 = new x0.b(r7, 4);
        x0.d r9 = r0.a;
        r9.l = false;
        r9.d = "当前已佩戴其他特效，是否替换为当前特效？";
        r0.j(1, "稍后再说", a.a);
        r0.j(0, "确认", new b(r8));
        r0.k(1, false);
        r0.k(0, true);
        r0.n();
    }

    private final void startPreview(Sticker r22, Map<String, String> r23) {
        this.previewExtraInfo.clear();
        this.previewExtraInfo.putAll(r23);
        if (this.scene != LiveEffectScene.GiftMenuPreview) goto L5;
        List<String> r2 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.type).a().b(this.panel, "startPreview");
        LiveEffectContext.a.a(this.type).a().a(this.panel, r22, "startPreview");
        return;
    L5:
        new HashMap();
        m r3 = new m();
        Intrinsics.checkNotNullParameter(r22, "sticker");
        List<String> r4 = LiveEffectContext.h;
        ILiveEffectComposerManager r5 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a();
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        ArrayList r8 = new ArrayList();
        JsonObject r9 = new JsonObject();
        List<n> r11 = r5.R();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L6:
        boolean r14 = true;
        if (r13.hasNext() == false) goto L16;
        Object r15 = r13.next();
        n r16 = (n) r15;
        if (LiveEffectSettings.LIVE_ANCHOR_EFFECT_PREVIEW_SCENE_BLACKLIST.getValue().contains(r16.a) == false) goto L11;
    L13:
        r14 = false;
    L14:
        if (r14 == false) goto L6;
        r12.add(r15);
        goto L6
    L11:
        if (r3.a.contains(r16.a) == false) goto L13;
    L16:
        r6.addAll(r12);
        n r17 = new n(d0.c, r22.getEffectId(), r22.getResourceId(), r22.getUnzipPath(), false, false, System.currentTimeMillis());
        Effect r18 = r22.getEffect();
        if (r18 == null) goto L19;
        r18.getEffect_type();
    L19:
        Unit r19 = Unit.INSTANCE;
        r6.add(r17);
        ArrayList r21 = new ArrayList();
        Iterator r24 = r6.iterator();
    L21:
        if (r24.hasNext() == false) goto L61;
        Object r25 = r24.next();
        n r26 = (n) r25;
        int r27 = r22.getStickerFeature();
        String r110 = r26.a;
        if (Intrinsics.areEqual(r110, d0.i) == false) goto L25;
    L40:
        int r111 = 4;
    L42:
        if ((r27 & r111) == 0) goto L44;
    L58:
        boolean r28 = false;
    L59:
        if (r28 == false) goto L21;
        r21.add(r25);
        goto L21
    L44:
        if (r26.j == true) goto L48;
        if (Intrinsics.areEqual(r26.b, r22.getEffectId()) == false) goto L58;
    L48:
        if (Intrinsics.areEqual(r26.a, FileUtils.BEAUTY) == false) goto L52;
        if (m90.b.a.c(LiveEffectContextFactoryDelegate$Type.DEFAULT).booleanValue() == true) goto L58;
    L52:
        if (Intrinsics.areEqual(r26.a, "livebody") == false) goto L56;
        if (m90.b.j.c(LiveEffectContextFactoryDelegate$Type.DEFAULT).booleanValue() == true) goto L58;
    L56:
        if (r26.l != ILiveEffectComposerManager.EffectInstanceType.DEFAULT) goto L58;
        r28 = true;
        goto L59
    L25:
        if (Intrinsics.areEqual(r110, d0.j) == true) goto L40;
        if (Intrinsics.areEqual(r110, d0.a) == false) goto L31;
        r111 = 1;
        goto L42
    L31:
        if (Intrinsics.areEqual(r110, d0.k) == false) goto L34;
        r111 = 2;
        goto L42
    L34:
        if (Intrinsics.areEqual(r110, "livebody") == false) goto L37;
        r111 = 16;
        goto L42
    L37:
        if (Intrinsics.areEqual(r110, "live_camera_move") == false) goto L39;
        r111 = 128;
        goto L42
    L39:
        r111 = 0;
        goto L42
    L61:
        Iterator r1 = r21.iterator();
    L63:
        if (r1.hasNext() == false) goto L89;
        n r29 = (n) r1.next();
        r7.add(r29.d);
        Integer r31 = StringsKt.toIntOrNull(r29.b);
        if (r31 == null) goto L67;
        int r32 = r31.intValue();
    L68:
        r8.add(Integer.valueOf(r32));
        if (r9.has(r29.d) == false) goto L75;
        JsonElement r33 = r9.get(r29.d);
        if (r33 == null) goto L74;
        JsonObject r34 = (JsonObject) r33;
    L77:
        if (r34.has("intensity_configs") == false) goto L83;
        JsonArray r35 = r34.get("intensity_configs");
        if (r35 == null) goto L82;
        JsonArray r36 = r35;
    L84:
        Iterator r37 = ((ArrayList) r29.i).iterator();
    L86:
        if (r37.hasNext() == false) goto L88;
        p r112 = (p) r37.next();
        JsonObject r113 = new JsonObject();
        r113.addProperty("tag", r112.b);
        r113.addProperty("value", r112.a);
        r36.add(r113);
        goto L86
    L88:
        r34.remove("intensity_configs");
        r34.add("intensity_configs", r36);
        r34.remove("tag_configs");
        r34.addProperty("tag_configs", r29.k);
        r9.remove(r29.d);
        r9.add(r29.d, r34);
        goto L63
    L82:
        throw new NullPointerException("null cannot be cast to non-null type com.google.gson.JsonArray");
    L83:
        r36 = new JsonArray();
        goto L84
    L74:
        throw new NullPointerException("null cannot be cast to non-null type com.google.gson.JsonObject");
    L75:
        r34 = new JsonObject();
        goto L77
    L67:
        r32 = 0;
        goto L68
    L89:
        String r38 = r9.toString();
        PthreadHandlerThreadV2 r39 = LiveEffectMonitor.a;
        Intrinsics.checkNotNullParameter(r7, "pathList");
        Intrinsics.checkNotNullParameter(r8, "idList");
        Intrinsics.checkNotNullParameter(r38, "params");
        StringBuilder r41 = new StringBuilder();
        Iterator r42 = r7.iterator();
    L91:
        if (r42.hasNext() == false) goto L93;
        r41.append(((String) r42.next()) + ',');
        goto L91
    L93:
        StringBuilder r43 = new StringBuilder();
        Iterator r44 = r8.iterator();
    L95:
        if (r44.hasNext() == false) goto L97;
        int r114 = ((Number) r44.next()).intValue();
        StringBuilder r115 = new StringBuilder();
        r115.append(r114);
        r115.append(',');
        r43.append(r115.toString());
        goto L95
    L97:
        NewBroadcastMonitor.a r45 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_STICKER_TRY_OUT_PARAMS, null, null, 14);
        r45.l(0);
        r45.i("pathList", r41.toString());
        r45.i("idList", r43.toString());
        r45.i("stickerConfig", r38);
        r45.a().report();
        Intrinsics.checkNotNullParameter(r7, "paths");
        Intrinsics.checkNotNullParameter(r8, "ids");
        Intrinsics.checkNotNullParameter(r38, "stickerConfig");
        List<String> r46 = LiveEffectContext.h;
        ILiveEffectComposerManager r47 = LiveEffectContext.a.a(this.type).a();
        Object[] r48 = r7.toArray(new String[0]);
        if (r48 == null) goto L102;
        r47.z((String[]) r48, CollectionsKt.toIntArray(r8), r38);
        LiveEffectContext.a.a(this.type).a().M();
        return;
    L102:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final void onPreviewStatusChange(f r3, f r4, Map<String, String> r5) {
        if (this.scene != LiveEffectScene.GiftMenuPreview) goto L21;
        if (r3 == null) goto L17;
        StickerPreviewStatus r6 = r3.a;
        if (r6 == StickerPreviewStatus.None) goto L17;
        StickerPreviewStatus r0 = StickerPreviewStatus.Downgrade;
        if (r6 == r0) goto L11;
        return;
    L11:
        if (r4.a != r0) goto L15;
        Sticker r7 = r4.b;
        if (r7 == null) goto L15;
        startPreview(r7, r5);
        return;
    L15:
        stopPreview();
        return;
    L17:
        if (r4.a != StickerPreviewStatus.Downgrade) goto L45;
        Sticker r8 = r4.b;
        if (r8 == null) goto L46;
        startPreview(r8, r5);
        return;
    L46:
        return;
    L45:
        return;
    L21:
        if (r3 == null) goto L34;
        if (isPreviewing(r3) == false) goto L34;
        if (isPreviewing(r3) == true) goto L28;
        return;
    L28:
        if (isPreviewing(r4) == false) goto L32;
        Sticker r9 = r4.b;
        if (r9 == null) goto L32;
        startPreview(r9, r5);
        return;
    L32:
        stopPreview();
        return;
    L34:
        if (isPreviewing(r4) == false) goto L39;
        Sticker r11 = r4.b;
        if (r11 == null) goto L39;
        startPreview(r11, r5);
        return;
    L39:
        if (LiveEffectSettings.LIVE_EFFECT_PREVIEW_DOWNGRADE_TEA_FIX.getValue().booleanValue() == false) goto L52;
        this.previewExtraInfo.clear();
        this.previewExtraInfo.putAll(r5);
        return;
    }

    public StickerPreviewViewModel(Context r2, LiveEffectContextFactoryDelegate$Type r3, LiveEffectScene r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "panel");
        this.context = r2;
        this.type = r3;
        this.scene = r4;
        this.panel = r5;
        this._previewStatusData = new MutableLiveData(new f(StickerPreviewStatus.None, null));
        this.previewExtraInfo = new LinkedHashMap();
    }

    public final void updatePreviewStatus(StickerPreviewStatus r2, Sticker r3, Map<String, String> r4, com.bytedance.android.live.effect.base.e r5) {
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r4, "extraInfo");
        this.traceInfo = r5;
        f r6 = (f) this._previewStatusData.getValue();
        f r0 = new f(r2, r3);
        this._previewStatusData.setValue(r0);
        onPreviewStatusChange(r6, r0, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updatePreviewStatus$default(StickerPreviewViewModel r0, StickerPreviewStatus r1, Sticker r2, Map r3, com.bytedance.android.live.effect.base.e r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = MapsKt.emptyMap();
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        r0.updatePreviewStatus(r1, r2, r3, r4);
    }
}
