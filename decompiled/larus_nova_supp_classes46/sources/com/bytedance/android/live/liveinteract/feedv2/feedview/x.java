package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x implements com.bytedance.android.live.ui.j {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;
    public final /* synthetic */ IRoom b;

    public final void c() {
    }

    public x(MultiLinkCommonVoiceFeedPreview r1, IRoom r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean a(IVoiceLiveTheme r3, com.bytedance.android.live.ui.l r4) {
        return MultiLinkCommonVoiceFeedPreview.u(this.a, r3, r4, this.b);
    }

    public final boolean b(IVoiceLiveTheme r3, com.bytedance.android.live.ui.l r4) {
        return MultiLinkCommonVoiceFeedPreview.u(this.a, r3, r4, this.b);
    }
}
