package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

    public r(MultiLinkCommonVoiceFeedPreview r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        IVoiceLiveTheme r1 = null;
        if (((Boolean) r4).booleanValue() == true) goto L16;
        com.bytedance.android.live.liveinteract.feed.d0 r5 = this.a.t;
        if (r5 == null) goto L7;
        r5.a(null);
    L7:
        MultiLinkCommonVoiceFeedPreview r6 = this.a;
        com.bytedance.android.live.ui.q r2 = r6.s;
        if (r2 == null) goto L35;
        IPreviewMultiLinkOuterConfigProvider r7 = r6.b;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L12:
        IRoom r8 = r7.getRoom();
        if (r8 == null) goto L15;
        r1 = r8.getVoiceLiveTheme();
    L15:
        r2.c(r1);
        return;
    L35:
        return;
    L16:
        IRoom r9 = MultiLinkCommonVoiceFeedPreview.x(this.a).getRoom();
        if (r9 == null) goto L25;
        IVoiceLiveTheme r10 = r9.getVoiceLiveTheme();
        if (r10 == null) goto L25;
        if (r10.getImageType() != 3) goto L25;
        List r11 = com.bytedance.android.live.liveinteract.aimv.b.a();
        com.bytedance.android.live.liveinteract.feed.d0 r0 = this.a.t;
        if (r0 == null) goto L37;
        r0.a(r11);
        return;
    L37:
        return;
    L25:
        MultiLinkCommonVoiceFeedPreview r12 = this.a;
        com.bytedance.android.live.ui.q r3 = r12.s;
        if (r3 == null) goto L39;
        IPreviewMultiLinkOuterConfigProvider r13 = r12.b;
        if (r13 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L30:
        IRoom r14 = r13.getRoom();
        if (r14 == null) goto L33;
        r1 = r14.getVoiceLiveTheme();
    L33:
        r3.d(r1);
        return;
    }
}
