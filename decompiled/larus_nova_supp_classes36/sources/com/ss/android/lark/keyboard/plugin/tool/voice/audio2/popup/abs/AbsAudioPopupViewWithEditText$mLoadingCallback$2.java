package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SpannableStringUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/SpannableStringUtils$DrawableCallback;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class AbsAudioPopupViewWithEditText$mLoadingCallback$2 extends Lambda implements Function0<SpannableStringUtils.a> {
    final /* synthetic */ AbsAudioPopupViewWithEditText this$0;

    public AbsAudioPopupViewWithEditText$mLoadingCallback$2(AbsAudioPopupViewWithEditText r1) {
        this.this$0 = r1;
        super(0);
    }

    public final SpannableStringUtils.a invoke() {
        return new SpannableStringUtils.a(this.this$0.getEditText());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1236invoke() {
        return invoke();
    }
}
