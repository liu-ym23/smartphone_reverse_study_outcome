package com.larus.bmhome.chat.bubble.floating.event;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerSourceListener;", "", "bannerSource", "", "getBannerSource", "()Ljava/lang/String;", "popupType", "event", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerEvent;", "onReceive", "", "onShow", "onDismiss", "reason", "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerDismissReason;", "onClick", "onActionResult", "result", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerActionResult;", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface BubbleBannerSourceListener {

    public static final class a {
        public static void a(b r1, sc8.a r2) {
            Intrinsics.checkNotNullParameter(r1, "event");
            Intrinsics.checkNotNullParameter(r2, "result");
        }

        public static void b(b r1, BubbleBannerDismissReason r2) {
            Intrinsics.checkNotNullParameter(r1, "event");
            Intrinsics.checkNotNullParameter(r2, "reason");
        }
    }

    String b(b r1);

    String c();

    void d(b r1, BubbleBannerDismissReason r2);

    void e(b r1);

    void g(b r1);

    void h(b r1, sc8.a r2);

    void i(b r1);
}
