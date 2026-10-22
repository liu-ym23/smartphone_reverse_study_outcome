package com.larus.bmhome.chat.bubble.floating.source;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.IFlowMessageService;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sc8.b;
import xe8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/source/ResendBubbleBannerSourceListener;", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerSourceListener;", "<init>", "()V", "bannerSource", "", "getBannerSource", "()Ljava/lang/String;", "onClick", "", "event", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ResendBubbleBannerSourceListener implements BubbleBannerSourceListener {
    public final String a;

    public ResendBubbleBannerSourceListener() {
        this.a = "auto_route";
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String c() {
        return this.a;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String b(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return null;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void e(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void g(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void i(b r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        Map<String, String> r0 = r7.m;
        a r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.get("resend_msg_type");
    L7:
        if (Intrinsics.areEqual(r2, "edit") == true) goto L9;
        return;
    L9:
        String r3 = r7.d;
        if ((!StringsKt.isBlank(r3)) == true) goto L13;
        r3 = null;
    L13:
        if (r3 != null) goto L15;
        return;
    L15:
        String r4 = r7.c;
        if ((!StringsKt.isBlank(r4)) == true) goto L19;
        r4 = null;
    L19:
        if (r4 == null) goto L23;
        IChatRepoService r5 = (IChatRepoService) ServiceManager.get().getService(IChatRepoService.class);
        if (r5 == null) goto L23;
        r5.n1(r4, OmniBreakReason.OmniBreakReason_REGENERATE_OR_SWITCH_MODE);
    L23:
        Map<String, String> r8 = r7.m;
        if (r8 == null) goto L33;
        String r9 = r8.get("resend_ext");
        if (r9 == null) goto L33;
        if ((!StringsKt.isBlank(r9)) == true) goto L31;
        r9 = null;
    L31:
        if (r9 == null) goto L33;
        Map r10 = MapsKt.mapOf(TuplesKt.to("bubble_resend_local_temp_upgrade_ext", r9));
    L34:
        IFlowMessageService r6 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
        if (r6 == null) goto L37;
        r6.g(r3, true, r10, "resend");
    L37:
        IFlowSdkDepend r11 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r11 == null) goto L40;
        r11.P();
        Fragment r12 = ChatServiceImpl.a.f();
    L42:
        if ((r12 instanceof a) == false) goto L44;
        r1 = (a) r12;
    L44:
        if (r1 == null) goto L51;
        t1a.b r13 = r1.WF();
        if (r13 == null) goto L52;
        u7 r14 = r13.getAbility(u7.class);
        if (r14 == null) goto L53;
        r14.O5(true);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L40:
        r12 = null;
    L33:
        r10 = null;
        goto L34
    L5:
        r2 = null;
        goto L7
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
