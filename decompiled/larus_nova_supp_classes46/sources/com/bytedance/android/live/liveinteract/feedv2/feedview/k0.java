package com.bytedance.android.live.liveinteract.feedv2.feedview;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k0 implements Runnable {
    public final /* synthetic */ MultiLinkRadioFeedView a;

    public k0(MultiLinkRadioFeedView r1) {
        this.a = r1;
    }

    public final void a() {
        if (this.a.getFeedDataCenter() != null) goto L5;
        return;
    L5:
        FragmentActivity r0 = ContextUtil.contextToFragmentActivity(this.a.getContext());
        if (r0 == null) goto L10;
        MultiLinkRadioFeedView r1 = this.a;
        r1.t = WidgetManager.of(r0, r1);
        MultiLinkRadioFeedView r2 = this.a;
        WidgetManager r3 = r2.t;
        if (r3 == null) goto L10;
        r3.setDataCenter(r2.getFeedDataCenter());
    L10:
        MultiLinkRadioFeedView r4 = this.a;
        r4.getClass();
        IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
        Widget r6 = null;
        if (r5 == null) goto L13;
        MiddlewareRoomWidget r7 = r5.createMultiLinkBgManager();
    L14:
        WidgetManager r8 = r4.t;
        if (r8 == null) goto L17;
        r8.load(r7, false);
    L17:
        IInteractService r9 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r9 == null) goto L29;
        IPreviewMultiLinkOuterConfigProvider r10 = r4.b;
        if (r10 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L22:
        String r11 = r10.getEnterFromMerge();
        IPreviewMultiLinkOuterConfigProvider r12 = r4.b;
        if (r12 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L25:
        IRoom r13 = r12.getRoom();
        te0.a r14 = r4.c;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L28:
        r6 = r9.createLiveThemeBgUIWidget(true, r11, r13, null, 0, 0, r14.g());
    L29:
        WidgetManager r15 = r4.t;
        if (r15 == null) goto L33;
        r15.load(2131388549, r6, false);
        return;
    L33:
        return;
    L13:
        r7 = null;
        goto L14
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
