package com.ss.android.lark.keyboard.edittext;

import android.text.Editable;
import android.text.Html;
import com.bytedance.lark.pb.im.v1.ResourceExtraInfo;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.i;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext.FunctionEditTextCopyCoordinator$handleClipDataIfNeed$1", f = "FunctionEditTextCopyCoordinator.kt", i = {}, l = {111, 128}, m = "invokeSuspend", n = {}, s = {})
final class FunctionEditTextCopyCoordinator$handleClipDataIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $html;
    final /* synthetic */ FlowKeyboardFunctionEditText.b $onPasteImageListener;
    final /* synthetic */ CharSequence $plainText;
    int label;
    final /* synthetic */ b this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext.FunctionEditTextCopyCoordinator$handleClipDataIfNeed$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.edittext.FunctionEditTextCopyCoordinator$handleClipDataIfNeed$1$1", f = "FunctionEditTextCopyCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ResourceExtraInfo> $extra;
        final /* synthetic */ FlowKeyboardFunctionEditText.b $onPasteImageListener;
        final /* synthetic */ Ref.ObjectRef<RichText> $richText;
        int label;
        final /* synthetic */ b this$0;

        public AnonymousClass1(List<ResourceExtraInfo> r1, FlowKeyboardFunctionEditText.b r2, Ref.ObjectRef<RichText> r3, b r4, Continuation<? super AnonymousClass1> r5) {
            this.$extra = r1;
            this.$richText = r3;
            this.this$0 = r4;
            super(1, r5);
        }

        public final Continuation<Unit> create(Continuation<?> r8) {
            return new AnonymousClass1(this.$extra, null, this.$richText, this.this$0, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L19;
            ResultKt.throwOnFailure(r5);
            if (this.$extra.isEmpty() == true) goto L7;
            Log.i("FunctionEditTextCopyCoordinator", "resourcesExtraInfo is not empty, try to hard link and insert");
        L7:
            RichTextElement.TextProperty r6 = new RichTextElement.TextProperty();
            r6.setContent("");
            List r0 = ((RichText) this.$richText.element).getImageIds();
            Ref.ObjectRef<RichText> r1 = this.$richText;
            Iterator r2 = r0.iterator();
        L9:
            if (r2.hasNext() == false) goto L16;
            String r3 = (String) r2.next();
            RichTextElement r4 = (RichTextElement) ((RichText) r1.element).getElements().getDictionary().get(r3);
            if (r4 == null) goto L13;
            r4.setProperty(r6);
        L13:
            RichTextElement r7 = (RichTextElement) ((RichText) r1.element).getElements().getDictionary().get(r3);
            if (r7 == null) goto L9;
            r7.setTag(RichTextElement.RichTextTag.TEXT);
            goto L9
        L16:
            ((RichText) this.$richText.element).getImageIds().clear();
            b r8 = this.this$0;
            RichText r9 = (RichText) this.$richText.element;
            ((RichTextEditor) r8.a.q(RichTextEditor.t)).insert(r9);
            return Unit.INSTANCE;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public FunctionEditTextCopyCoordinator$handleClipDataIfNeed$1(b r1, String r2, CharSequence r3, FlowKeyboardFunctionEditText.b r4, Continuation<? super FunctionEditTextCopyCoordinator$handleClipDataIfNeed$1> r5) {
        this.this$0 = r1;
        this.$html = r2;
        this.$plainText = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new FunctionEditTextCopyCoordinator$handleClipDataIfNeed$1(this.this$0, this.$html, this.$plainText, null, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L30:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
        Object r12 = ((Result) r11).unbox-impl();
    L14:
        if (Result.isFailure-impl(r12) == false) goto L16;
        r12 = null;
    L16:
        com.ss.android.lark.keyboard.edittext2.copy.a.C0136a r13 = (com.ss.android.lark.keyboard.edittext2.copy.a.C0136a) r12;
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        if (r13 == null) goto L20;
        RichText r2 = r13.a;
        if (r2 == null) goto L20;
    L21:
        r7.element = r2;
        if (r13 != null) goto L24;
    L31:
        Log.i("FunctionEditTextCopyCoordinator", "html parse failed, html is null, insert plain text");
        CharSequence r14 = this.$plainText;
        Intrinsics.checkNotNull(r14);
        if (r14.length() == 0) goto L35;
        r3 = false;
    L35:
        if (r3 == false) goto L37;
        r14 = Html.fromHtml(this.$html).toString();
    L37:
        b r4 = this.this$0;
        Intrinsics.checkNotNull(r14);
        Editable r5 = r4.a.getEditableText();
        int r6 = r4.a.getSelectionEnd();
        int r8 = r4.a.getSelectionStart();
        if ((r6 - r8) <= 0) goto L40;
        r5.delete(r8, r6);
    L40:
        if (r8 >= 0) goto L42;
        r8 = r5.length();
    L42:
        r4.a.setSelection(r8);
        r5.insert(r8, r14);
        return Unit.INSTANCE;
    L24:
        if (i.l(r2) == true) goto L31;
        lec.c.c(this.this$0.a.getContext(), (RichText) r7.element, new lec.b(new lec.b.a()));
        List<ResourceExtraInfo> r9 = r13.b;
        b r15 = this.this$0;
        AnonymousClass1 r10 = new AnonymousClass1(r9, null, r7, r15, null);
        this.label = 2;
        if (b.a(r15, r10, this) != r0) goto L30;
        return r0;
    L20:
        r2 = com.ss.android.lark.widget.richtext.c.a();
        goto L21
    L10:
        ResultKt.throwOnFailure(r11);
        com.ss.android.lark.keyboard.edittext2.copy.a.b r16 = this.this$0.b;
        String r17 = this.$html;
        this.label = 1;
        r12 = r16.b.a(r17, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (r12 != r0) goto L14;
        return r0;
    }
}
