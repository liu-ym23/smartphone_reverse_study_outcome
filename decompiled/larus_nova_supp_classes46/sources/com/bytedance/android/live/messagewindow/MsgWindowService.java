package com.bytedance.android.live.messagewindow;

import android.content.Context;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.messagewindow.business.tetris.MsgWindowCardTetris;
import com.bytedance.android.live.messagewindow.business.tetris.desc.c;
import com.bytedance.android.live.messagewindow.business.tetris.desc.d;
import com.bytedance.android.live.messagewindow.framework.ability.CardAbilityImpl;
import com.bytedance.android.live.messagewindow.framework.context.CardContext;
import com.bytedance.android.live.messagewindow.framework.context.CommonCardContext;
import com.bytedance.android.live.messagewindow.framework.manager.f;
import com.bytedance.android.live.messagewindow.preview.widget.PreviewMsgWinBottomRightWidget;
import com.bytedance.android.live.messagewindow.preview.widget.PreviewMsgWinTopLeftWidget;
import com.bytedance.android.live.room.api.messagewindow.builder.card.CommonCardBuilder;
import com.bytedance.android.live.room.api.messagewindow.manager.IFloatingBannerManager;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.process.MsgWindowAdjustSource;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import j70.h;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m71.e;
import u61.a;
import u61.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bF\u0010GJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\f\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u000fH\u0016J\u0010\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u000fH\u0016J\u0010\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u001bH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\"H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u0012\u0010)\u001a\u00020(2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010+\u001a\u00020*H\u0016J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016J\b\u0010/\u001a\u00020.H\u0016J\u001c\u00101\u001a\u0004\u0018\u0001002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J$\u00104\u001a\u0002032\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u000100H\u0016J\u0018\u00109\u001a\u0002032\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u000207H\u0016J\u0010\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J\"\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010<\u001a\u00020;2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010?\u001a\u0004\u0018\u00010=2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016R&\u0010E\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010@*\u00020\u00028BX\u0082\u0004¢\u0006\f\u0012\u0004\bC\u0010D\u001a\u0004\bA\u0010B¨\u0006H"}, d2 = {"Lcom/bytedance/android/live/messagewindow/MsgWindowService;", "Lcom/bytedance/android/live/room/api/messagewindow/service/IMsgWindowService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/live/messagewindow/framework/context/c;", "cardContext", "Lcom/bytedance/live/datacontext/DataContext;", "roomContext", "initCardContext", "Lv61/a;", "cardWindow", "Lr61/a;", "cardAbilityImpl", "Ly61/b;", "middlewareCardCtx", "Ljava/lang/Class;", "getBackendModelClass", "Lj70/h;", "Lh70/b;", "getMsgWindowCardTetrisDesc", "getTopLeftMsgWindowCardTetrisDesc", "getTopRightMsgWindowCardTetrisDesc", "getVideoOrLinkShellCardTetrisDesc", "getCommonCardServiceTetrisDesc", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getPreviewMsgWinBottomRightWidget", "getPreviewMsgWinTopLeftWidget", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "getCommonCardServiceWidget", "", "cardType", "", "getSingleCommonCardSettingConfig", "getCardContainerOptConfig", "Le71/a;", "msgWindowManager", "Lu61/a;", "cardBuilder", "Ld71/c;", "cardRecorder", "Lq71/a;", "cardStateDispatcher", "Lk71/a;", "businessCards", "Lcom/bytedance/android/live/room/api/messagewindow/monitor/i;", "cardMonitor", "Lu61/b;", "commonCardBuilder", "Lcom/bytedance/android/live/room/api/messagewindow/builder/card/c;", "getCommonCardWrapper", "commonCardWrapper", "", "storeCommonCardWrapper", "Lcom/bytedance/android/live/room/api/messagewindow/process/MsgWindowAdjustSource;", "source", "Lh71/a;", "adjustConfig", "msgWindowPositionAdjust", "getTempDraggableComponentTetrisDesc", "Landroid/content/Context;", "context", "Lcom/bytedance/android/live/room/api/messagewindow/manager/IFloatingBannerManager;", "initFloatingBannerManager", "getFloatingBannerManager", "Lcom/bytedance/live/datacontext/j;", "getFloatingBannerManagerMember", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)Lcom/bytedance/live/datacontext/j;", "getFloatingBannerManagerMember$annotations", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "floatingBannerManagerMember", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MsgWindowService implements IMsgWindowService {
    private static /* synthetic */ void getFloatingBannerManagerMember$annotations(DataCenter r0) {
    }

    public a cardBuilder() {
        IPlatformCardService.Companion.getClass();
        IPlatformCardService r0 = IPlatformCardService.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.newCardBuilder();
    }

    public i cardMonitor() {
        IPlatformCardService.Companion.getClass();
        IPlatformCardService r0 = IPlatformCardService.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.cardMonitor();
    }

    public b commonCardBuilder() {
        return new CommonCardBuilder();
    }

    public h<? extends h70.b> getCommonCardServiceTetrisDesc() {
        return new bm0.a();
    }

    public Tetris<? extends h70.b> getCommonCardServiceWidget() {
        return new MsgWindowCardTetris();
    }

    public h<? extends h70.b> getMsgWindowCardTetrisDesc() {
        return new com.bytedance.android.live.messagewindow.business.tetris.desc.a();
    }

    public h<? extends h70.b> getTempDraggableComponentTetrisDesc() {
        return new nm0.a();
    }

    public h<? extends h70.b> getTopLeftMsgWindowCardTetrisDesc() {
        return new com.bytedance.android.live.messagewindow.business.tetris.desc.b();
    }

    public h<? extends h70.b> getTopRightMsgWindowCardTetrisDesc() {
        return new c();
    }

    public h<? extends h70.b> getVideoOrLinkShellCardTetrisDesc() {
        return new d();
    }

    public MsgWindowService() {
        k.l(IMsgWindowService.class, this);
    }

    public boolean getCardContainerOptConfig() {
        return e.a();
    }

    public k71.a businessCards() {
        return xl0.a.a;
    }

    public d71.c cardRecorder() {
        return em0.b.a;
    }

    public Class<?> getBackendModelClass() {
        return f71.c.a.class;
    }

    public Class<? extends LiveRecyclableWidget> getPreviewMsgWinBottomRightWidget() {
        return PreviewMsgWinBottomRightWidget.class;
    }

    public Class<? extends LiveRecyclableWidget> getPreviewMsgWinTopLeftWidget() {
        return PreviewMsgWinTopLeftWidget.class;
    }

    public e71.a msgWindowManager() {
        return f.a;
    }

    private final com.bytedance.android.live.messagewindow.framework.context.c cardContext(DataCenter r2) {
        CardContext.Companion.getClass();
        return CardContext.a.a(r2);
    }

    private final j<IFloatingBannerManager> getFloatingBannerManagerMember(DataCenter r3) {
        r r4 = z51.a.e(r3);
        if (r4 == null) goto L5;
        j<IFloatingBannerManager> r5 = r4.C();
    L7:
        if ((r5 instanceof j) == true) goto L10;
        return null;
    L10:
        return r5;
    L5:
        r5 = null;
        goto L7
    }

    public r61.a cardAbilityImpl(v61.a r2) {
        Intrinsics.checkNotNullParameter(r2, "cardWindow");
        return new CardAbilityImpl(r2);
    }

    public q71.a cardStateDispatcher(DataCenter r1) {
        com.bytedance.android.live.messagewindow.framework.context.c r2 = cardContext(r1);
        if (r2 == null) goto L7;
        q71.a r3 = r2.stateDispatcher();
        if (r3 == null) goto L7;
        return r3;
    L7:
        return jm0.b.f;
    }

    public IFloatingBannerManager getFloatingBannerManager(DataCenter r1) {
        if (r1 == null) goto L6;
        j<IFloatingBannerManager> r2 = getFloatingBannerManagerMember(r1);
        if (r2 == null) goto L6;
        return (IFloatingBannerManager) r2.getValue();
    L6:
        return null;
    }

    public boolean getSingleCommonCardSettingConfig(int r1) {
        return e.c(r1);
    }

    public y61.b middlewareCardCtx(DataCenter r2) {
        CardContext.Companion.getClass();
        return CardContext.a.a(r2);
    }

    /* JADX INFO: renamed from: cardStateDispatcher, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ q71.b m526cardStateDispatcher(DataCenter r1) {
        return cardStateDispatcher(r1);
    }

    public com.bytedance.android.live.room.api.messagewindow.builder.card.c getCommonCardWrapper(DataCenter r2, int r3) {
        CommonCardContext.Companion.getClass();
        y61.a r4 = CommonCardContext.b.b(r2);
        if (r4 == null) goto L7;
        Map r5 = r4.getCommonCardWrapperMap();
        if (r5 == null) goto L7;
        return (com.bytedance.android.live.room.api.messagewindow.builder.card.c) r5.get(Integer.valueOf(r3));
    L7:
        return null;
    }

    public DataContext initCardContext(DataCenter r2, DataContext r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        CardContext r0 = new CardContext(r3, r2);
        r0.initialize();
        return r0;
    }

    public void msgWindowPositionAdjust(MsgWindowAdjustSource r12, h71.a r13) {
        Intrinsics.checkNotNullParameter(r12, "source");
        Intrinsics.checkNotNullParameter(r13, "adjustConfig");
        xs2.b r2 = xs2.b.a();
        MsgWindowAdjustSource r6 = null;
        if ((63 & 16) == 0) goto L5;
        h71.a r5 = new h71.a();
    L7:
        if ((63 & 32) == 0) goto L9;
        r6 = MsgWindowAdjustSource.UNKNOWN;
    L9:
        Intrinsics.checkNotNullParameter(r5, "adjustConfig");
        Intrinsics.checkNotNullParameter(r6, "source");
        Intrinsics.checkNotNullParameter(r12, "source");
        Intrinsics.checkNotNullParameter(r13, "adjustConfig");
        Float r0 = r13.d;
        if (r0 == null) goto L12;
        r0.floatValue();
        boolean r7 = true;
    L13:
        Float r1 = r13.b;
        if (r1 == null) goto L16;
        r1.floatValue();
        boolean r8 = true;
    L17:
        Float r3 = r13.c;
        if (r3 == null) goto L20;
        r3.floatValue();
        boolean r9 = true;
    L21:
        Float r4 = r13.e;
        if (r4 == null) goto L24;
        r4.floatValue();
        boolean r10 = true;
    L25:
        Unit r11 = Unit.INSTANCE;
        r2.post(new z61.b(r8, r7, r9, r10, r13, r12));
        return;
    L24:
        r10 = false;
        goto L25
    L20:
        r9 = false;
        goto L21
    L16:
        r8 = false;
        goto L17
    L12:
        r7 = false;
        goto L13
    L5:
        r5 = null;
        goto L7
    }

    public IFloatingBannerManager initFloatingBannerManager(final Context r2, DataContext r3, final DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        j<IFloatingBannerManager> r5 = getFloatingBannerManagerMember(r4);
        if (r5 == null) goto L5;
        r5.e(new AnonymousClass1(r2, r4));
    L5:
        if (r5 != null) goto L9;
        return null;
    L9:
        return (IFloatingBannerManager) r5.getValue();
    }

    public void storeCommonCardWrapper(DataCenter r2, int r3, com.bytedance.android.live.room.api.messagewindow.builder.card.c r4) {
        CommonCardContext.Companion.getClass();
        y61.a r5 = CommonCardContext.b.b(r2);
        if (r5 == null) goto L8;
        Map r6 = r5.getCommonCardWrapperMap();
        if (r6 == null) goto L9;
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r7 = (com.bytedance.android.live.room.api.messagewindow.builder.card.c) r6.put(Integer.valueOf(r3), r4);
        return;
    L9:
        return;
    }
}
