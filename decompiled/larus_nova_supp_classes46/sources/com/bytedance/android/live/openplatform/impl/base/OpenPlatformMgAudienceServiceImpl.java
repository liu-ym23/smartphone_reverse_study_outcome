package com.bytedance.android.live.openplatform.impl.base;

import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AudienceMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameaudience.explaincard.AudienceExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar.CandyToolbarContextService;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.live.datacontext.m;
import j70.h;
import java.util.Map;
import javax.inject.Inject;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import po0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J\u001c\u0010\u0018\u001a\u00020\t2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0016H\u0016R.\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/OpenPlatformMgAudienceServiceImpl;", "Lcom/bytedance/android/live/openplatform/api/minigame/IOpenPlatformMgAudienceService;", "Lj70/h;", "Lh70/b;", "getAudienceMiniGameWidgetDescriptor", "Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniGameSource;", "source", "", "uri", "", "openMountedMiniGame", "reportMpClick", "", "isBackground", "notifyRoomOnBackground", "getMicroGameInfo", "reportMpShow", "status", "setMountStatus", "Lkotlin/Pair;", "Lcom/bytedance/android/livesdk/log/filter/v;", "provideMgParams2LogInjector", "", "params", "injectMgParams", "Lwo0/a;", "<set-?>", "miniGameAudienceService", "Lwo0/a;", "getMiniGameAudienceService", "()Lwo0/a;", "setMiniGameAudienceService", "(Lwo0/a;)V", "<init>", "()V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformMgAudienceServiceImpl implements IOpenPlatformMgAudienceService {
    public static final a Companion = null;
    private static final e diComponent = null;
    private wo0.a miniGameAudienceService;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements v {
        public b() {
        }

        public final void Rd() {
        }

        public final void onRemove() {
        }

        public final void L9(String r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r3, "eventName");
            Intrinsics.checkNotNullParameter(r4, "params");
            AudienceMiniGameDataContext.Companion.getClass();
            AudienceMiniGameDataContext r5 = AudienceMiniGameDataContext.a.a();
            if (r5 == null) goto L16;
            m<String> r6 = r5.getGameId();
            if (r6 == null) goto L17;
            String r7 = (String) r6.getValue();
            if (r7 != null) goto L10;
            return;
        L10:
            if (r4.containsKey("is_micro_game") == true) goto L13;
            r4.put("is_micro_game", "1");
        L13:
            if (r4.containsKey("mp_id") == true) goto L18;
            r4.put("mp_id", r7);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    static {
        Companion = new a();
        diComponent = po0.a.a();
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public h<? extends h70.b> getAudienceMiniGameWidgetDescriptor() {
        wo0.a r0 = this.miniGameAudienceService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAudienceMiniGameWidgetDescriptor();
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public String getMicroGameInfo() {
        wo0.a r0 = this.miniGameAudienceService;
        if (r0 == null) goto L11;
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L11;
        CandyToolbarContextService r2 = (CandyToolbarContextService) r1.getService(CandyToolbarContextService.class);
        if (r2 == null) goto L11;
        fr0.b.a r3 = r2.b;
        if (r3 == null) goto L11;
        return r3.a();
    L11:
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public Pair<String, v> provideMgParams2LogInjector() {
        return TuplesKt.to("OpenPlatformMgAudienceServiceImpl", new b());
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public void reportMpShow() {
        wo0.a r0 = this.miniGameAudienceService;
        if (r0 == null) goto L6;
        r0.reportMpShow();
        return;
    }

    public OpenPlatformMgAudienceServiceImpl() {
        setMiniGameAudienceService((wo0.a) ((po0.a.b) diComponent).f.get());
        k.l(IOpenPlatformMgAudienceService.class, this);
        com.bytedance.android.live.openplatform.impl.base.utils.v.a();
    }

    public static final /* synthetic */ e access$getDiComponent$cp() {
        return diComponent;
    }

    public final wo0.a getMiniGameAudienceService() {
        return this.miniGameAudienceService;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public void injectMgParams(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        AudienceMiniGameDataContext.Companion.getClass();
        AudienceMiniGameDataContext r0 = AudienceMiniGameDataContext.a.a();
        if (r0 == null) goto L16;
        m<String> r1 = r0.getGameId();
        if (r1 == null) goto L17;
        String r2 = (String) r1.getValue();
        if (r2 != null) goto L10;
        return;
    L10:
        if (r4.containsKey("is_micro_game") == true) goto L13;
        r4.put("is_micro_game", "1");
    L13:
        if (r4.containsKey("mp_id") == true) goto L18;
        r4.put("mp_id", r2);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public void notifyRoomOnBackground(boolean r2) {
        AudienceMiniGameDataContext.Companion.getClass();
        AudienceMiniGameDataContext r0 = AudienceMiniGameDataContext.a.a();
        if (r0 == null) goto L8;
        m<Boolean> r1 = r0.isRoomBackground();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public void reportMpClick(MountedMiniGameSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        wo0.a r0 = this.miniGameAudienceService;
        if (r0 == null) goto L6;
        r0.reportMpClick(r2);
        return;
    }

    @Inject
    public final void setMiniGameAudienceService(wo0.a r1) {
        this.miniGameAudienceService = r1;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public void setMountStatus(boolean r2) {
        if (r2 == true) goto L11;
        wo0.a r3 = this.miniGameAudienceService;
        if (r3 == null) goto L12;
        OpenPlatformContext r4 = r3.a();
        if (r4 == null) goto L13;
        AudienceExplainCardContextService r5 = (AudienceExplainCardContextService) r4.getService(AudienceExplainCardContextService.class);
        if (r5 == null) goto L14;
        r5.dispose();
        qo0.a.c("AudienceExplainCardContextService", "releaseExplainCard");
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public void openMountedMiniGame(MountedMiniGameSource r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        wo0.a r0 = this.miniGameAudienceService;
        if (r0 == null) goto L6;
        r0.openMountedMiniGame(r2, r3);
        return;
    }
}
