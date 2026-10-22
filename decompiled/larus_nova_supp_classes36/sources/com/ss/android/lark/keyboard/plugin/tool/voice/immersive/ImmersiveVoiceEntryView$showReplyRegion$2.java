package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/widget/EllipsizedEmojiconTextView;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ImmersiveVoiceEntryView$showReplyRegion$2 extends Lambda implements Function1<EllipsizedEmojiconTextView, Unit> {
    final /* synthetic */ CharSequence $msgDigest;

    public ImmersiveVoiceEntryView$showReplyRegion$2(CharSequence r1) {
        this.$msgDigest = r1;
        super(1);
    }

    public final void invoke(EllipsizedEmojiconTextView r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r2.setText(this.$msgDigest);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((EllipsizedEmojiconTextView) r1);
        return Unit.INSTANCE;
    }
}
