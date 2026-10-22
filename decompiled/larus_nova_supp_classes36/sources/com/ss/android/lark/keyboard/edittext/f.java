package com.ss.android.lark.keyboard.edittext;

import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public final Function2<String, Continuation<? super RichText>, Object> a;
    public final Function2<RichText, Continuation<? super String>, Object> b;
    public final Function0<RichText> c;
    public final Function1<RichText, Unit> d;
    public final Function1<RichText, Unit> e;

    public final Object a(Continuation r5) {
        if ((r5 instanceof MarkdownInputContentDelegate$appendMarkdownContent$1) == false) goto L7;
        MarkdownInputContentDelegate$appendMarkdownContent$1 r0 = (MarkdownInputContentDelegate$appendMarkdownContent$1) r5;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        RichText r7 = (RichText) r6;
        if (r7 == null) goto L20;
        this.e.invoke(r7);
        return Boxing.boxBoolean(true);
    L20:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        Function2<String, Continuation<? super RichText>, Object> r8 = this.a;
        r0.label = 1;
        r6 = r8.invoke(null, r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new MarkdownInputContentDelegate$appendMarkdownContent$1(this, r5);
        goto L8
    }

    public final Object b(Continuation r5) {
        if ((r5 instanceof MarkdownInputContentDelegate$setMarkdownContent$1) == false) goto L7;
        MarkdownInputContentDelegate$setMarkdownContent$1 r0 = (MarkdownInputContentDelegate$setMarkdownContent$1) r5;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        RichText r7 = (RichText) r6;
        if (r7 == null) goto L20;
        this.d.invoke(r7);
        return Boxing.boxBoolean(true);
    L20:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        Function2<String, Continuation<? super RichText>, Object> r8 = this.a;
        r0.label = 1;
        r6 = r8.invoke(null, r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new MarkdownInputContentDelegate$setMarkdownContent$1(this, r5);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function2<? super String, ? super Continuation<? super RichText>, ? extends Object> r2, Function2<? super RichText, ? super Continuation<? super String>, ? extends Object> r3, Function0<? extends RichText> r4, Function1<? super RichText, Unit> r5, Function1<? super RichText, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "markdownToRichText");
        Intrinsics.checkNotNullParameter(r3, "richTextToMarkdown");
        Intrinsics.checkNotNullParameter(r4, "getCurrentRichText");
        Intrinsics.checkNotNullParameter(r5, "replaceRichText");
        Intrinsics.checkNotNullParameter(r6, "appendRichText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
