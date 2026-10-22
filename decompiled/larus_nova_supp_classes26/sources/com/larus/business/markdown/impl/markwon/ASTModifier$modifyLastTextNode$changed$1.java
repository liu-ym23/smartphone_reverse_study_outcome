package com.larus.business.markdown.impl.markwon;

import com.larus.business.markdown.api.model.MarkdownNodeModifyType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ASTModifier$modifyLastTextNode$changed$1 extends Lambda implements Function1<Character, Unit> {
    final /* synthetic */ Ref.ObjectRef<Set<MarkdownNodeModifyType>> $modifyTypes;
    final /* synthetic */ a this$0;

    public ASTModifier$modifyLastTextNode$changed$1(Ref.ObjectRef<Set<MarkdownNodeModifyType>> r1, a r2) {
        this.$modifyTypes = r1;
        this.this$0 = r2;
        super(1);
    }

    public final void invoke(char r5) {
        Ref.ObjectRef<Set<MarkdownNodeModifyType>> r0 = this.$modifyTypes;
        a r1 = this.this$0;
        Set r2 = (Set) r0.element;
        if (CharsKt.isWhitespace(r5) == false) goto L6;
        MarkdownNodeModifyType r6 = MarkdownNodeModifyType.TRAILING_WHITESPACE_REMOVED;
    L9:
        int r3 = a.c;
        r1.getClass();
        r0.element = a.a(r2, r6);
        return;
    L6:
        if (r5 != 65532) goto L8;
        r6 = MarkdownNodeModifyType.TRAILING_PLACEHOLDER_REMOVED;
        goto L9
    L8:
        r6 = MarkdownNodeModifyType.TRAILING_EMOJI_REMOVED;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Character) r1).charValue());
        return Unit.INSTANCE;
    }
}
