package e42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdkapi.depend.model.live.CommentPinContent;
import g42.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends h<CommentPinContent> {
    public a(CommentPinContent r4) {
        Intrinsics.checkNotNullParameter(r4, "commentPinContent");
        super(PinType.Comment, r4, r4.getCommentMsgId());
    }
}
