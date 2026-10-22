package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.contact.v1.SetChannelNicknameResponse;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/lark/pb/contact/v1/SetChannelNicknameResponse;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/bytedance/lark/pb/contact/v1/SetChannelNicknameResponse;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ImSdkChatterServiceImplV2$setChannelNickname$1 extends Lambda implements Function1<SetChannelNicknameResponse, Boolean> {
    public static final ImSdkChatterServiceImplV2$setChannelNickname$1 INSTANCE = null;

    static {
        INSTANCE = new ImSdkChatterServiceImplV2$setChannelNickname$1();
    }

    public ImSdkChatterServiceImplV2$setChannelNickname$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((SetChannelNicknameResponse) r1);
    }

    public final Boolean invoke(SetChannelNicknameResponse r1) {
        return Boolean.TRUE;
    }
}
