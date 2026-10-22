package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class AdvanceVoiceInputComponent$setEditTextWithText$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FunctionEditText $it;
    final /* synthetic */ Ref.ObjectRef<SpannableStringBuilder> $resultSpan;
    final /* synthetic */ b this$0;

    public AdvanceVoiceInputComponent$setEditTextWithText$1$1(FunctionEditText r1, Ref.ObjectRef<SpannableStringBuilder> r2, b r3) {
        this.$it = r1;
        this.$resultSpan = r2;
        this.this$0 = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1155invoke() {
        this.$it.setText((CharSequence) this.$resultSpan.element);
        this.this$0.getClass();
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1155invoke();
        return Unit.INSTANCE;
    }
}
