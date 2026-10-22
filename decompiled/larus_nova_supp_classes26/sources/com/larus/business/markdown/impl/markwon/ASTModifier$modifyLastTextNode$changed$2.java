package com.larus.business.markdown.impl.markwon;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(C)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ASTModifier$modifyLastTextNode$changed$2 extends Lambda implements Function1<Character, Boolean> {
    final /* synthetic */ a this$0;

    public ASTModifier$modifyLastTextNode$changed$2(a r1) {
        this.this$0 = r1;
        super(1);
    }

    public final Boolean invoke(char r5) {
        boolean r1 = true;
        if (CharsKt.isWhitespace(r5) == true) goto L52;
        if (r5 == 65532) goto L52;
        a r0 = this.this$0;
        int r2 = a.c;
        r0.getClass();
        if (9728 <= r5) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
    L47:
        boolean r6 = true;
    L48:
        if (r6 == true) goto L52;
        r1 = false;
        goto L52
    L14:
        if (62208 > r5) goto L17;
        if (r5 >= 62976) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == true) goto L47;
        if (62976 <= r5) goto L21;
    L23:
        boolean r7 = false;
    L24:
        if (r7 == true) goto L47;
        if (63104 <= r5) goto L28;
    L30:
        boolean r8 = false;
    L31:
        if (r8 == true) goto L47;
        if (63744 <= r5) goto L35;
    L37:
        boolean r9 = false;
    L38:
        if (r9 == true) goto L47;
        if (Character.isHighSurrogate(r5) == true) goto L47;
        if (Character.isLowSurrogate(r5) == true) goto L47;
        if (r5 == 8205) goto L47;
        r6 = false;
        goto L48
    L35:
        if (r5 >= 64000) goto L37;
        r9 = true;
        goto L38
    L28:
        if (r5 >= 63232) goto L30;
        r8 = true;
        goto L31
    L21:
        if (r5 >= 63056) goto L23;
        r7 = true;
    L17:
        r4 = false;
        goto L18
    L9:
        if (r5 >= 9984) goto L11;
        r3 = true;
    L52:
        return Boolean.valueOf(r1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Character) r1).charValue());
    }
}
