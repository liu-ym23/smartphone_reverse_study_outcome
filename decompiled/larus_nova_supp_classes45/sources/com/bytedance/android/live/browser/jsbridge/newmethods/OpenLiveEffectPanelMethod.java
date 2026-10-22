package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.browser.jsbridge.base.OpenLiveEffectPanelResultModel;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.InsertEffectType;
import com.bytedance.android.livesdkapi.depend.model.InsertStickerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListByIdsListener;
import com.ss.android.ugc.effectmanager.effect.model.net.EffectListResponse;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openLiveEffectPanel")
public final class OpenLiveEffectPanelMethod extends w20.l4<w20.kc, OpenLiveEffectPanelResultModel> {
    public final Lazy a;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.newmethods.OpenLiveEffectPanelMethod$invoke$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"openStickerDialog", "", "isCampaign", "", "invoke"}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ String $effectID;
        final /* synthetic */ boolean $shouldSelectEffect;
        final /* synthetic */ String $subCategoryTabKey;
        final /* synthetic */ String $tabKey;
        final /* synthetic */ OpenLiveEffectPanelMethod this$0;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.newmethods.OpenLiveEffectPanelMethod$invoke$1$a */
        public static final class a implements IFetchEffectListByIdsListener {
            public final /* synthetic */ AnonymousClass1 a;

            public a(AnonymousClass1 r1) {
                this.a = r1;
            }

            public final void onFail(ExceptionResult r3) {
                OpenLiveEffectPanelMethod r0 = this.a.this$0;
                if (r3 == null) goto L5;
                String r4 = r3.getMsg();
            L6:
                r0.finishWithFailure(new Throwable(r4));
                return;
            L5:
                r4 = null;
                goto L6
            }

            public final void onSuccess(Object r8) {
                EffectListResponse r9 = (EffectListResponse) r8;
                OpenLiveEffectPanelMethod r1 = this.a.this$0;
                if (r9 == null) goto L9;
                List r11 = r9.getEffect_list();
                if (r11 == null) goto L9;
                Effect r12 = (Effect) CollectionsKt.firstOrNull(r11);
                if (r12 == null) goto L9;
                com.ss.android.ugc.effectmanager.effect.model.Effect r2 = new com.ss.android.ugc.effectmanager.effect.model.Effect(r12);
            L10:
                AnonymousClass1 r13 = this.a;
                r1.j(r2, r13.$effectID, r13.$shouldSelectEffect, r13.$tabKey, r13.$subCategoryTabKey);
                return;
            L9:
                r2 = null;
                goto L10
            }
        }

        public AnonymousClass1(OpenLiveEffectPanelMethod r1, String r2, String r3, String r4, boolean r5) {
            this.this$0 = r1;
            this.$effectID = r2;
            this.$tabKey = r3;
            this.$subCategoryTabKey = r4;
            this.$shouldSelectEffect = r5;
            super(1);
        }

        public final void invoke(boolean r14) {
            if (r14 == false) goto L4;
            InsertEffectType r0 = InsertEffectType.Campaign;
        L5:
            InsertEffectType r2 = r0;
            if (this.$effectID.length() != 0) goto L8;
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            xs2.b.a().post(new zg1.c2(new InsertStickerInfo(r2, null, null, this.$tabKey, false, true, false, this.$subCategoryTabKey, false, 320, null)));
            this.this$0.finishWithFailure(new Throwable("effectID is Empty"));
            return;
        L12:
            com.ss.android.ugc.effectmanager.effect.model.Effect r3 = null;
            if (r14 == false) goto L25;
            List<String> r15 = LiveEffectContext.h;
            Iterator<T> r16 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().d().c(com.bytedance.android.live.effect.api.d0.c).iterator();
        L16:
            if (r16.hasNext() == false) goto L20;
            Object r4 = r16.next();
            if (Intrinsics.areEqual(((com.ss.android.ugc.effectmanager.effect.model.Effect) r4).getEffect_id(), this.$effectID) == false) goto L16;
        L21:
            com.ss.android.ugc.effectmanager.effect.model.Effect r5 = (com.ss.android.ugc.effectmanager.effect.model.Effect) r4;
            if (r5 == null) goto L24;
            r3 = new com.ss.android.ugc.effectmanager.effect.model.Effect(r5);
        L24:
            this.this$0.j(r3, this.$effectID, this.$shouldSelectEffect, this.$tabKey, this.$subCategoryTabKey);
            return;
        L20:
            r4 = null;
            goto L21
        L25:
            List<String> r17 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d().fetchEffectList2(CollectionsKt.mutableListOf(new String[]{this.$effectID}), null, new a(this));
            return;
        L8:
            r1 = false;
            goto L9
        L4:
            r0 = InsertEffectType.Other;
            goto L5
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }
    }

    public OpenLiveEffectPanelMethod() {
        this.a = LazyKt.lazy(OpenLiveEffectPanelMethod$stickerDataManager$2.INSTANCE);
    }

    public final void invoke(Object r14, CallContext r15) {
        w20.kc r16 = (w20.kc) r14;
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "context");
        RoomContext.a r17 = RoomContext.Companion;
        LiveMode r0 = null;
        if (RoomContext.a.c(r17, null, 0, 3) == null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L10;
    L44:
        com.bytedance.android.live.core.utils.f2.c("请在视频开播时使用特效", 0);
        return;
    L10:
        if (RoomContext.a.c(r17, null, 0, 3) == null) goto L19;
        RoomContext r18 = RoomContext.a.c(r17, null, 0, 3);
        if (r18 == null) goto L17;
        com.bytedance.live.datacontext.i r19 = r18.getLiveMode();
        if (r19 == null) goto L17;
        r0 = (LiveMode) r19.getValue();
    L17:
        if (r0 != LiveMode.VIDEO) goto L44;
    L19:
        String r110 = r16.a();
        if (r110 != null) goto L22;
        r110 = "";
    L22:
        String r1 = r16.e();
        if (r1 != null) goto L25;
        String r11 = "";
    L26:
        String r2 = r16.b();
        if (r2 != null) goto L29;
        String r9 = "";
    L30:
        Boolean r3 = r16.c();
        if (r3 == null) goto L33;
        r3.booleanValue();
    L33:
        Boolean r111 = r16.d();
        if (r111 == null) goto L36;
        boolean r12 = r111.booleanValue();
    L37:
        AnonymousClass1 r112 = new AnonymousClass1(this, r9, r110, r11, r12);
        if (Intrinsics.areEqual(r110, "campaign") == false) goto L43;
        com.bytedance.android.live.effect.sticker.presenter.o r5 = (com.bytedance.android.live.effect.sticker.presenter.o) this.a.getValue();
        String r6 = com.bytedance.android.live.effect.api.d0.c;
        if (r5.b(r6) == true) goto L42;
        com.bytedance.android.live.effect.sticker.presenter.o.a.b((com.bytedance.android.live.effect.sticker.presenter.o) this.a.getValue(), r6, r110, new u8(r112));
        return;
    L42:
        r112.invoke(true);
        return;
    L43:
        r112.invoke(false);
        return;
    L36:
        r12 = false;
        goto L37
    L29:
        r9 = r2;
        goto L30
    L25:
        r11 = r1;
        goto L26
    L5:
        if (((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).getPreviewLiveMode() == LiveMode.VIDEO) goto L7;
        r4 = true;
        goto L8
    }

    public final void j(com.ss.android.ugc.effectmanager.effect.model.Effect r18, String r19, boolean r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r19, "effectID");
        Intrinsics.checkNotNullParameter(r22, "tabKey");
        Intrinsics.checkNotNullParameter(r23, "subCategoryTabKey");
        if (r21 == false) goto L6;
        if (r18 == null) goto L6;
        InsertStickerInfo r2 = new InsertStickerInfo(InsertEffectType.Other, com.bytedance.android.live.effect.sticker.d.b(r18), new com.ss.android.ugc.effectmanager.effect.model.Effect(r18), r22, false, true, true, r23, false, 256, null);
    L7:
        NewBroadcastMonitor.a r3 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_OPEN_STICKER_DIALOG_JSB, null, null, 14);
        r3.l(0);
        r3.c(r22);
        if (r18 == null) goto L10;
        String r0 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L11:
        r3.d(r0);
        r3.i("effectID", r19);
        r3.a().report();
        xs2.b.a().post(new zg1.c2(r2));
        finishWithSuccess();
        return;
    L10:
        r0 = "0";
    L6:
        r2 = new InsertStickerInfo(InsertEffectType.Other, null, null, r22, false, true, false, r23, false, 320, null);
        goto L7
    }
}
