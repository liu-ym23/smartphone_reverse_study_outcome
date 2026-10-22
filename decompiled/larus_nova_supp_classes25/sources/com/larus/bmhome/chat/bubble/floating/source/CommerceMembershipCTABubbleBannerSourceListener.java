package com.larus.bmhome.chat.bubble.floating.source;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.commercemembership.api.ICommerceMembershipService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/source/CommerceMembershipCTABubbleBannerSourceListener;", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerSourceListener;", "<init>", "()V", "bannerSource", "", "getBannerSource", "()Ljava/lang/String;", "popupType", "event", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerEvent;", "onShow", "", "onClick", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CommerceMembershipCTABubbleBannerSourceListener implements BubbleBannerSourceListener {
    public final String a;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String b(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return "ug_free_subs_download_pc";
    }

    public CommerceMembershipCTABubbleBannerSourceListener() {
        this.a = "commerce_pc_new_user_campaign";
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String c() {
        return this.a;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void e(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r3 = ICommerceMembershipService.a.a();
        if (r3 == null) goto L6;
        r3.o();
        return;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void g(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void i(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r3 = ICommerceMembershipService.a.a();
        if (r3 == null) goto L6;
        r3.h();
        return;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void d(b r1, BubbleBannerDismissReason r2) {
        BubbleBannerSourceListener.a.b(r1, r2);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void h(b r1, sc8.a r2) {
        BubbleBannerSourceListener.a.a(r1, r2);
    }
}
