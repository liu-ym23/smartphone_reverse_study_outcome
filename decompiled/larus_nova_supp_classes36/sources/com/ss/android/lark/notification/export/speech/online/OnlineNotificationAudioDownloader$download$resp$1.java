package com.ss.android.lark.notification.export.speech.online;

import com.bytedance.lark.pb.media.v1.GetResourcePathResponse;
import com.bytedance.lark.pb.media.v1.LocalResource;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "raw", "Lcom/bytedance/lark/pb/media/v1/GetResourcePathResponse;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class OnlineNotificationAudioDownloader$download$resp$1 extends Lambda implements Function1<GetResourcePathResponse, String> {
    public static final OnlineNotificationAudioDownloader$download$resp$1 INSTANCE = null;

    static {
        INSTANCE = new OnlineNotificationAudioDownloader$download$resp$1();
    }

    public OnlineNotificationAudioDownloader$download$resp$1() {
        super(1);
    }

    public final String invoke(GetResourcePathResponse r1) {
        if (r1 == null) goto L7;
        LocalResource r2 = r1.resource;
        if (r2 == null) goto L7;
        String r3 = r2.path;
        if (r3 == null) goto L7;
        return r3;
    L7:
        return "";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((GetResourcePathResponse) r1);
    }
}
