package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.MarkHighlightController;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.HighlightPreviewDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends com.bytedance.android.livesdk.interactivity.comment.record.guide.a {
    public HighlightPreviewDialog b;
    public final a c;

    public static final class a implements MarkHighlightController.a {
        public final /* synthetic */ e a;

        @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.provider.MarkHighlightController.a
        public final void onDismiss() {
            e.c(this.a, false);
            this.a.b = null;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.provider.MarkHighlightController.a
        public final void onShow() {
            e.c(this.a, true);
        }

        public a(e r1) {
            this.a = r1;
        }
    }

    public e() {
        this.c = new a(this);
    }

    public static final void c(e r4, boolean r5) {
        r4.getClass();
        if (r5 == false) goto L7;
        IInteractivityInjectService r6 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r6 == null) goto L11;
        r6.muteLivePlayerClient();
    L11:
        if (v22.a.b.booleanValue() == true) goto L13;
        return;
    L13:
        if (hd0.c.f().h() == true) goto L15;
        return;
    L15:
        if (r5 == false) goto L21;
        IPushStreamService r7 = jc1.k.f(IPushStreamService.class);
        if (r7 == null) goto L29;
        com.bytedance.android.live.pushstream.d r8 = r7.getPushLiveStream();
        if (r8 == null) goto L30;
        r8.J0("live highlight record preview", new uv0.a(LiveRequestSourceRole.Business, "PreviewVideoHandler.mutePlayerClient", null));
        return;
    L30:
        return;
    L29:
        return;
    L21:
        IPushStreamService r9 = jc1.k.f(IPushStreamService.class);
        if (r9 == null) goto L32;
        com.bytedance.android.live.pushstream.d r10 = r9.getPushLiveStream();
        if (r10 == null) goto L33;
        r10.q1("live highlight record preview", new uv0.a(LiveRequestSourceRole.Business, "PreviewVideoHandler.mutePlayerClient", null));
        return;
    L33:
        return;
    L32:
        return;
    L7:
        IInteractivityInjectService r11 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r11 == null) goto L11;
        r11.unmuteLivePlayerClient();
        goto L11
    }
}
