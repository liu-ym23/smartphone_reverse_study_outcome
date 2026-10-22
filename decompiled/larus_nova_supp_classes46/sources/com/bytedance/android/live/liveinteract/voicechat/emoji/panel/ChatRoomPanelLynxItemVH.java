package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelLynxItemVH;", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelItemBaseVH;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatRoomPanelLynxItemVH extends ChatRoomPanelItemBaseVH {
    public static final /* synthetic */ int d = 0;
    public final FrameLayout a;
    public HybridCard b;
    public final View c;

    public static final class a implements Runnable {
        public final /* synthetic */ ChatRoomPanelLynxItemVH a;
        public final /* synthetic */ g b;

        public a(ChatRoomPanelLynxItemVH r1, g r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            ChatRoomPanelLynxItemVH r0 = this.a;
            String r1 = this.b.e();
            int r2 = ChatRoomPanelLynxItemVH.d;
            r0.getClass();
            if (r1.length() != 0) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L9;
            return;
        L9:
            if (r0.b != null) goto L19;
            HybridCard r4 = jc1.k.n(IBaseBrowserService.class).getHybridCard(r0.c.getContext(), x6.a.d(r1 + "&width=" + r0.c.getMeasuredWidth() + "&height=" + r0.c.getMeasuredHeight()), new h(r0));
            r0.b = r4;
            if (r4 == null) goto L15;
            a7.a.a(r4, null, null, 3);
            FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(s1.f(48.0f), s1.f(72.0f));
            r5.gravity = 17;
            r4.setLayoutParams(r5);
            FrameLayout r6 = r0.a;
            if (r6 == null) goto L15;
            r6.addView(r4);
        L15:
            FrameLayout r7 = r0.a;
            if (r7 == null) goto L20;
            UtilityKotlinExtentionsKt.w(r7);
            return;
        L20:
            return;
        L19:
            return;
        L5:
            r3 = false;
            goto L6
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

    public ChatRoomPanelLynxItemVH(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.c = r2;
        this.a = (FrameLayout) r2.findViewById(2131379281);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemBaseVH
    public final void T3(g r3) {
        Intrinsics.checkNotNullParameter(r3, "panelItem");
        this.c.post(new a(this, r3));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemBaseVH
    public final void U3(ChatRoomPanelItemBaseVH r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        HybridCard r3 = this.b;
        if (r3 == null) goto L5;
        r3.release();
    L5:
        this.b = null;
    }
}
