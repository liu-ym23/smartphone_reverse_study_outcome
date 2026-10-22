package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.m6;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.referenceicon.ImageViewBitmapLoader;
import com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore;
import com.larus.bmhome.input.api.officemention.OfficeMentionService;
import com.larus.bmhome.utils.x1;
import com.larus.bmhome.view.g4;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatInputWithMentionDelegate extends f {
    public static final /* synthetic */ int m = 0;
    public final EditText e;
    public final CoroutineScope f;
    public final qp8.a g;
    public final boolean h;
    public boolean i;
    public List<l0> j;
    public List<d0> k;
    public final g4<l0> l;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[InputReferenceType.values().length];
            r0[InputReferenceType.CONVERSATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[InputReferenceType.ATTACHMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[InputReferenceType.CONTACT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[InputReferenceType.GROUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[InputReferenceType.DRIVE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate$setText$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate$setText$1", f = "ChatInputWithMentionDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CharSequence $text;
        int label;
        final /* synthetic */ ChatInputWithMentionDelegate this$0;

        public AnonymousClass1(CharSequence r1, ChatInputWithMentionDelegate r2, Continuation<? super AnonymousClass1> r3) {
            this.$text = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$text, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r4);
            CharSequence r5 = this.$text;
            if ((r5 instanceof Spanned) == false) goto L9;
            ChatInputWithMentionDelegate r6 = this.this$0;
            SpannableStringBuilder r0 = new SpannableStringBuilder(this.$text);
            int r1 = ChatInputWithMentionDelegate.m;
            r5 = r6.i(r0);
            if (r5 != null) goto L9;
            r5 = this.$text.toString();
        L9:
            final ChatInputWithMentionDelegate r2 = this.this$0;
            Function1<? super String, Unit> r3 = new y(r2);
            int r7 = ChatInputWithMentionDelegate.m;
            Editable r8 = r2.l(r5, r3);
            if (r8 == null) goto L12;
            this.this$0.e.setSelection(r8.length());
            return Unit.INSTANCE;
        L12:
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.f, com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final boolean c1() {
        return true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final Object b1() {
        Editable r0 = this.e.getText();
        if (r0 != null) goto L5;
        return null;
    L5:
        String r2 = i(r0);
        if (r2 != null) goto L8;
        return null;
    L8:
        FLogger.a.i("ChatInputWithMentionDelegate", "[prepareContent] contentLength: " + r0.length() + ", transformedLength: " + r2.length());
        return r2;
    }

    public static String f(d0 r3) {
        if (r3.getType() == InputReferenceType.ATTACHMENT) goto L5;
        return null;
    L5:
        String r4 = r3.d;
        if (r4 != null) goto L8;
        return null;
    L8:
        Regex r0 = com.larus.bmhome.chat.markdown.richtext.n.a;
        com.larus.bmhome.chat.markdown.richtext.r r5 = com.larus.bmhome.chat.markdown.richtext.n.o(r4);
        if ((r5 instanceof com.larus.bmhome.chat.markdown.richtext.r.a) == false) goto L11;
        com.larus.bmhome.chat.markdown.richtext.r.a r6 = (com.larus.bmhome.chat.markdown.richtext.r.a) r5;
    L12:
        if (r6 != null) goto L14;
        return null;
    L14:
        return r6.a;
    L11:
        r6 = null;
        goto L12
    }

    public static String g(d0 r3) {
        if (r3.getType() == InputReferenceType.DRIVE) goto L5;
        return null;
    L5:
        String r0 = r3.d;
        if (r0 != null) goto L8;
    L12:
        i0 r1 = r3.f;
        if (r1 == null) goto L19;
        r0 = r1.d;
        if (r0 == null) goto L19;
        if ((!StringsKt.isBlank(r0)) == false) goto L19;
    L20:
        if (r0 != null) goto L25;
        String r4 = r3.a;
        if ((!StringsKt.isBlank(r4)) == true) goto L27;
        return null;
    L27:
        return r4;
    L25:
        return r0;
    L19:
        r0 = null;
        goto L20
    L8:
        if ((!StringsKt.isBlank(r0)) == true) goto L11;
        r0 = null;
    L11:
        if (r0 != null) goto L25;
        goto L12
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void T0(m6 r2) {
        this.g.T0(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void a(boolean r2) {
        this.g.a(r2);
    }

    public final void h(Editable r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getSpanStart(this.l) == 0) goto L7;
    L9:
        r5.setSpan(this.l, 0, r5.length(), 18);
        return;
    L7:
        if (r5.getSpanEnd(this.l) != r5.length()) goto L9;
    }

    public final String i(Editable r10) {
        Regex r0 = f0.a;
        Intrinsics.checkNotNullParameter(r10, "editable");
        SpannableStringBuilder r1 = new SpannableStringBuilder(r10);
        int r3 = 0;
        Object[] r2 = r10.getSpans(0, r10.length(), l0.class);
        ArrayList r4 = new ArrayList();
        int r5 = r2.length;
    L3:
        if (r3 >= r5) goto L12;
        l0 r6 = (l0) r2[r3];
        int r7 = r10.getSpanStart(r6);
        int r8 = r10.getSpanEnd(r6);
        if (r7 < 0) goto L8;
        if (r8 <= r7) goto L8;
        Triple r9 = new Triple(Integer.valueOf(r7), Integer.valueOf(r8), r6.a);
    L9:
        if (r9 == null) goto L11;
        r4.add(r9);
    L11:
        r3 = r3 + 1;
    L8:
        r9 = null;
        goto L9
    L12:
        Iterator r11 = CollectionsKt.sortedWith(r4, new h0()).iterator();
    L14:
        if (r11.hasNext() == false) goto L17;
        Triple r12 = (Triple) r11.next();
        r1.replace(((Number) r12.component1()).intValue(), ((Number) r12.component2()).intValue(), f0.h((d0) r12.component3()));
        goto L14
    L17:
        return this.g.b(r1);
    }

    public final d0 m(d0 r4) {
        if (r4.getType() == InputReferenceType.ATTACHMENT) goto L5;
        return r4;
    L5:
        Iterator<T> r0 = this.k.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (k(r4, (d0) r1) == false) goto L7;
    L12:
        d0 r2 = (d0) r1;
        if (r2 != null) goto L15;
        return r4;
    L15:
        String r3 = r4.b;
        String r5 = r2.d;
        if (r5 != null) goto L19;
        r5 = r4.d;
    L19:
        return d0.a(r2, r3, r5, 1013);
    L11:
        r1 = null;
        goto L12
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.f, com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void r1(x1 r2) {
        if (r2 == null) goto L4;
        x1.d(r2, 1);
        return;
    L4:
        super.r1(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setText(CharSequence r8) {
        Intrinsics.checkNotNullParameter(r8, ChatDraftItem.TYPE_TEXT);
        BuildersKt.launch$default(this.f, Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(r8, this, null), 2, null);
    }

    public static boolean k(d0 r4, d0 r5) {
        InputReferenceType r0 = r4.getType();
        InputReferenceType r1 = InputReferenceType.ATTACHMENT;
        if (r0 == r1) goto L5;
    L17:
        return false;
    L5:
        if (r5.getType() != r1) goto L17;
        if ((!StringsKt.isBlank(r4.a)) == true) goto L10;
    L12:
        String r6 = f(r4);
        if (r6 != null) goto L16;
        return false;
    L16:
        return Intrinsics.areEqual(r6, f(r5));
    L10:
        if (Intrinsics.areEqual(r4.a, r5.a) == false) goto L12;
        return true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.f, com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final boolean g1(boolean r2, boolean r3) {
        if (r2 == false) goto L7;
        if (r3 == false) goto L7;
        return false;
    L7:
        if (this.e.isFocusable() != r2) goto L10;
        return true;
    L10:
        return false;
    }

    public final Editable l(CharSequence r29, Function1<? super String, Unit> r30) {
        Regex r1 = f0.a;
        Intrinsics.checkNotNullParameter(r29, "content");
        String r2 = r29.toString();
        StringBuilder r3 = new StringBuilder(r2.length());
        ArrayList r4 = new ArrayList();
        List r5 = CollectionsKt.createListBuilder();
        int r7 = 0;
        int r8 = 2;
        Iterator r6 = Regex.findAll$default(f0.a, r2, 0, 2, null).iterator();
    L4:
        if (r6.hasNext() == false) goto L25;
        MatchResult r10 = (MatchResult) r6.next();
        Regex r12 = com.larus.bmhome.chat.markdown.richtext.n.a;
        com.larus.bmhome.chat.markdown.richtext.i r13 = com.larus.bmhome.chat.markdown.richtext.n.m(r10.getValue(), false, r8);
        IntRange r11 = r10.getRange();
        com.larus.bmhome.chat.markdown.richtext.h r14 = (com.larus.bmhome.chat.markdown.richtext.h) CollectionsKt.singleOrNull(r13.c);
        if (r14 == null) goto L18;
        String r15 = r14.c;
        if (r15 != null) goto L13;
        r15 = r14.e;
        if (r15 == null) goto L18;
    L13:
        String r17 = r15;
        String r9 = StringsKt.trimStart(r13.a, new char[]{'@'});
        if ((true ^ StringsKt.isBlank(r9)) == false) goto L16;
        String r18 = r9;
    L17:
        if (r18 == null) goto L18;
        if (r14.e == null) goto L22;
        InputReferenceType r16 = InputReferenceType.GROUP;
    L23:
        d0 r19 = new d0(r17, r18, r16, null, null, null, r14.d, null, r14.f, r14.g, DoraCallStateCode.ENV_OBSERVE_USER_TIMER_END);
    L24:
        r5.add(new f0.a(r11, r19, r13.a));
        r8 = 2;
        goto L4
    L22:
        r16 = InputReferenceType.CONTACT;
        goto L23
    L16:
        r18 = null;
    L18:
        r19 = null;
        goto L24
    L25:
        Iterator r20 = Regex.findAll$default(f0.b, r2, 0, 2, null).iterator();
    L27:
        if (r20.hasNext() == false) goto L50;
        MatchResult r21 = (MatchResult) r20.next();
        Regex r110 = com.larus.bmhome.chat.markdown.richtext.n.a;
        MatchGroup r111 = r21.getGroups().get(1);
        if (r111 == null) goto L31;
        String r112 = r111.getValue();
    L33:
        if (r112 != null) goto L35;
        r112 = "";
    L35:
        String r113 = com.larus.bmhome.chat.markdown.richtext.n.s(r112);
        MatchGroup r114 = r21.getGroups().get(2);
        if (r114 == null) goto L38;
        String r115 = r114.getValue();
    L39:
        if (r115 != null) goto L41;
        r115 = "";
    L41:
        String r116 = com.larus.bmhome.chat.markdown.richtext.n.r(r115);
        d0 r117 = f0.g(r113, r116);
        if (r117 != null) goto L48;
        if (com.larus.bmhome.chat.markdown.richtext.n.h(r116) == true) goto L46;
        r117 = null;
        goto L48
    L46:
        r117 = new d0(r116, r113, InputReferenceType.DRIVE, r116, null, null, null, null, null, null, 1008);
    L48:
        if (r117 == null) goto L27;
        r5.add(new f0.a(r21.getRange(), r117, ""));
        goto L27
    L38:
        r115 = null;
        goto L39
    L31:
        r112 = null;
        goto L33
    L50:
        Iterator r22 = CollectionsKt.sortedWith(CollectionsKt.build(r5), new g0()).iterator();
    L52:
        if (r22.hasNext() == false) goto L60;
        f0.a r23 = (f0.a) r22.next();
        if (r23.a.getFirst() < r7) goto L52;
        r3.append(r2, r7, r23.a.getFirst());
        d0 r24 = r23.b;
        if (r24 != null) goto L58;
        r3.append(r23.c);
    L59:
        r7 = r23.a.getLast() + 1;
        goto L52
    L58:
        String r25 = "\ufff9input_ref_" + UUID.randomUUID() + 65531;
        r3.append(r25);
        r4.add(new m0(r25, r24));
        goto L59
    L60:
        r3.append(r2, r7, r2.length());
        String r26 = r3.toString();
        Intrinsics.checkNotNullParameter(r26, "content");
        Intrinsics.checkNotNullParameter(r4, "placeholders");
        r30.invoke(r26);
        Editable r27 = this.e.getEditableText();
        if (r27 != null) goto L63;
        return null;
    L63:
        Iterator r28 = r4.iterator();
    L65:
        if (r28.hasNext() == false) goto L69;
        m0 r31 = (m0) r28.next();
        int r32 = StringsKt.indexOf$default(r27, r31.a, 0, false, 6, null);
        if (r32 < 0) goto L65;
        int r33 = r31.a.length() + r32;
        d0 r34 = m(r31.b);
        Regex r35 = com.larus.bmhome.chat.markdown.richtext.n.a;
        r27.replace(r32, r33, com.larus.bmhome.chat.markdown.richtext.n.b(k0.a(r34)));
        e(r27, r34, r32, com.larus.bmhome.chat.markdown.richtext.n.b(k0.a(r34)).length() + r32);
        goto L65
    L69:
        return r27;
    }

    public static final Object c(ChatInputWithMentionDelegate r5, com.larus.bmhome.chat.referenceicon.b r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof ChatInputWithMentionDelegate$loadAttachmentIcon$1) == false) goto L7;
        ChatInputWithMentionDelegate$loadAttachmentIcon$1 r0 = (ChatInputWithMentionDelegate$loadAttachmentIcon$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Iterator r10 = (Iterator) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L31:
        Bitmap r11 = (Bitmap) r8;
        if (r11 != null) goto L37;
    L15:
        Bitmap r3 = null;
        if (r10.hasNext() == false) goto L35;
        String r12 = (String) r10.next();
        r0.L$0 = r10;
        r0.label = 1;
        if (r12 != null) goto L20;
    L28:
        r8 = r3;
    L29:
        if (r8 != r9) goto L31;
        return r9;
    L20:
        if ((!StringsKt.isBlank(r12)) == true) goto L23;
        r12 = null;
    L23:
        if (r12 == null) goto L28;
        r8 = BuildersKt.withContext(Dispatchers.getIO(), new ChatInputWithMentionDelegate$loadDirectIcon$3$1(r12, null), r0);
        if (r8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        r3 = (Bitmap) r8;
        goto L28
    L36:
        if (r8 != r9) goto L31;
        goto L31
    L35:
        return null;
    L37:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r10 = r6.a.iterator();
    L7:
        r0 = new ChatInputWithMentionDelegate$loadAttachmentIcon$1(r5, r7);
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.f, com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void h1(boolean r8, Function0<Boolean> r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "needPasteAndSend");
        n0.a(this.e, r8, r9, r10, new ChatInputWithMentionDelegate$configCustomCopyAndSendActionMode$1(this), new ChatInputWithMentionDelegate$configCustomCopyAndSendActionMode$2(this));
    }

    public ChatInputWithMentionDelegate(EditText r2, LifecycleCoroutineScope r3, qp8.a r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "inputText");
        Intrinsics.checkNotNullParameter(r3, "coroutineScope");
        Intrinsics.checkNotNullParameter(r4, "mentionEditor");
        super(r2);
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.j = CollectionsKt.emptyList();
        this.k = CollectionsKt.emptyList();
        this.l = new g4(Reflection.getOrCreateKotlinClass(l0.class));
        x r6 = new x(this);
        h(r2.getEditableText());
        r2.addTextChangedListener(r6);
    }

    public final void e(Editable r22, d0 r23, int r24, int r25) {
        d0 r9 = m(r23);
        r22.setSpan(new l0(r9), r24, r25, 33);
        if (this.h == true) goto L5;
        return;
    L5:
        int r12 = ContextCompat.getColor(this.e.getContext(), v19.c.b(2130972123, this.e.getContext(), 2131103203));
        com.larus.bmhome.chat.referenceicon.b r1 = r9.h;
        InputReferenceType r4 = r9.getType();
        int[] r5 = b.a;
        int r6 = r5[r4.ordinal()];
        if (r6 == 1) goto L18;
        if (r6 == 2) goto L9;
        Integer r7 = k0.c(r9.getType());
    L19:
        int r10 = r5[r9.getType().ordinal()];
        if (r10 == 2) goto L31;
        if (r10 == 3) goto L28;
        if (r10 == 4) goto L28;
        if (r10 != 5) goto L35;
        String r11 = g(r9);
        if (r11 == null) goto L35;
        MessageReferenceIconStore r16 = MessageReferenceIconStore.a;
        Intrinsics.checkNotNullParameter(r11, "documentUrl");
        Bitmap r13 = MessageReferenceIconStore.e(MessageReferenceIconStore.b(r11));
    L36:
        if (r13 != null) goto L38;
        RoundedBitmapDrawable r14 = null;
    L49:
        if (r14 == null) goto L51;
    L89:
        RoundedBitmapDrawable r2 = r14;
    L90:
        int r8 = c7.b(18);
        int r18 = c7.b(4);
        if (r9.getType() != InputReferenceType.CONTACT) goto L93;
    L96:
        boolean r19 = true;
    L97:
        if (r13 == null) goto L99;
        boolean r20 = true;
    L100:
        j0 r15 = new j0(r2, r12, r8, r18, r19, r20);
        r22.setSpan(r15, r24, r25, 33);
        if (r2 == null) goto L152;
        MessageReferenceIconStore r0 = MessageReferenceIconStore.a;
        String r17 = MessageReferenceIconStore.a(r9.getType().name(), r9.i, r9.j);
        int r3 = r5[r9.getType().ordinal()];
        if (r3 == 2) goto L143;
        if (r3 == 3) goto L140;
        if (r3 == 4) goto L140;
        if (r3 != 5) goto L153;
        i0 r21 = r9.f;
        String r26 = g(r9);
        if (r26 == null) goto L154;
        if (r21 == null) goto L124;
        Integer r110 = Integer.valueOf(r21.b);
        if (r110.intValue() == 0) goto L117;
        boolean r111 = true;
    L118:
        if (r111 == true) goto L121;
        r110 = null;
    L121:
        if (r110 == null) goto L124;
        Integer r27 = r110;
    L128:
        if (r27 != null) goto L130;
    L138:
        Function1 r28 = new ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$4(r21, this, r9, r26, r27, null);
    L150:
        BuildersKt.launch$default(this.f, null, null, new ChatInputWithMentionDelegate$loadReferenceIcon$1(r28, r9, this, r22, r17, r15, null), 3, null);
        return;
    L130:
        if (r27.intValue() == 0) goto L132;
        boolean r112 = true;
    L133:
        if (r112 == false) goto L135;
        Integer r113 = r27;
    L136:
        if (r113 == null) goto L138;
        MessageReferenceIconStore.j(r26, r113.intValue());
        goto L138
    L135:
        r113 = null;
        goto L136
    L132:
        r112 = false;
        goto L133
    L117:
        r111 = false;
    L124:
        Integer r29 = MessageReferenceIconStore.g(r26);
        if (r29 != null) goto L127;
        r29 = OfficeMentionService.b.m(r26);
    L127:
        r27 = r29;
        goto L128
    L154:
        return;
    L153:
        return;
    L140:
        if (r17 == null) goto L155;
        r28 = new ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$1(this, r9, null);
        goto L150
    L155:
        return;
    L143:
        com.larus.bmhome.chat.referenceicon.b r30 = r9.h;
        if (r30 == null) goto L156;
        String r31 = (String) CollectionsKt.firstOrNull(r30.a);
        if (r31 == null) goto L157;
        r28 = new ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$5(r31, this, r30, null);
        goto L150
    L157:
        return;
    L156:
        return;
    L152:
        return;
    L99:
        r20 = false;
        goto L100
    L93:
        if (r9.getType() == InputReferenceType.GROUP) goto L96;
        r19 = false;
        goto L97
    L51:
        if (r9.getType() != InputReferenceType.CONTACT) goto L53;
    L54:
        String r32 = r9.i;
        if (r32 != null) goto L57;
    L60:
        boolean r33 = true;
    L61:
        if (r33 == true) goto L71;
        String r34 = r9.j;
        if (r34 != null) goto L65;
    L68:
        boolean r35 = true;
    L69:
        if (r35 == true) goto L71;
        r14 = new ColorDrawable(0);
        goto L89
    L65:
        if (StringsKt.isBlank(r34) == true) goto L68;
        r35 = false;
    L71:
        InputReferenceType r36 = r9.getType();
        InputReferenceType r114 = InputReferenceType.ATTACHMENT;
        if (r36 != r114) goto L75;
        if (r7 != null) goto L75;
        r14 = new ColorDrawable(0);
    L75:
        if (r7 == null) goto L88;
        Drawable r37 = ContextCompat.getDrawable(this.e.getContext(), r7.intValue());
        if (r37 == null) goto L88;
        RoundedBitmapDrawable r38 = r37.mutate();
        if (r38 == null) goto L88;
        if (r9.getType() != r114) goto L86;
        if (r1 == null) goto L84;
        Integer r39 = r1.b;
    L85:
        if (r39 == null) goto L86;
    L87:
        r14 = r38;
        goto L89
    L84:
        r39 = null;
    L86:
        r38.setTint(r12);
    L88:
        r2 = null;
        goto L90
    L57:
        if (StringsKt.isBlank(r32) == true) goto L60;
        r33 = false;
        goto L61
    L53:
        if (r9.getType() != InputReferenceType.GROUP) goto L71;
    L38:
        if (r9.getType() != InputReferenceType.ATTACHMENT) goto L41;
        r14 = new com.larus.bmhome.chat.referenceicon.a(r13);
        goto L49
    L41:
        if (r9.getType() != InputReferenceType.CONTACT) goto L43;
    L46:
        r14 = RoundedBitmapDrawableFactory.create(this.e.getResources(), r13);
        r14.setCircular(true);
        Intrinsics.checkNotNull(r14);
        goto L49
    L43:
        if (r9.getType() == InputReferenceType.GROUP) goto L46;
        r14 = new BitmapDrawable(this.e.getResources(), r13);
    L35:
        r13 = null;
    L28:
        MessageReferenceIconStore r115 = MessageReferenceIconStore.a;
        String r116 = MessageReferenceIconStore.a(r9.getType().name(), r9.i, r9.j);
        if (r116 == null) goto L35;
        Intrinsics.checkNotNullParameter(r116, "cacheKey");
        r13 = MessageReferenceIconStore.e(r116);
        goto L36
    L31:
        if (r1 == null) goto L35;
        String r117 = (String) CollectionsKt.firstOrNull(r1.a);
        if (r117 == null) goto L35;
        MessageReferenceIconStore r118 = MessageReferenceIconStore.a;
        Intrinsics.checkNotNullParameter(r117, "source");
        r13 = MessageReferenceIconStore.e("attachment:".concat(r117));
        goto L36
    L9:
        if (r1 == null) goto L12;
        r7 = r1.b;
        if (r7 != null) goto L19;
    L12:
        if (r1 == null) goto L14;
        String r40 = (String) CollectionsKt.firstOrNull(r1.a);
    L15:
        if (r40 != null) goto L17;
        r7 = k0.c(r9.getType());
        goto L19
    L17:
        r7 = null;
        goto L19
    L14:
        r40 = null;
        goto L15
    L18:
        r7 = 2131240273;
        goto L19
    }

    public final boolean j(int r17, int r18, List<d0> r19, boolean r20) {
        int r1 = r17;
        int r2 = r18;
        Intrinsics.checkNotNullParameter(r19, "references");
        if (r19.isEmpty() == true) goto L86;
        List<d0> r3 = r19;
        if ((r3 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L34;
        d0 r6 = (d0) r4.next();
        String r7 = r6.g;
        if (r7 != null) goto L15;
    L18:
        boolean r8 = true;
    L19:
        if (r8 == false) goto L30;
        String r9 = r6.d;
        if (r9 != null) goto L23;
    L26:
        boolean r10 = true;
    L27:
        if (r10 == false) goto L30;
        boolean r11 = false;
    L32:
        if ((!r11) == false) goto L11;
        boolean r5 = true;
    L35:
        if (r5 == true) goto L86;
        Editable r12 = this.e.getEditableText();
        if (r12 != null) goto L40;
        return false;
    L40:
        if (r1 < 0) goto L43;
        if (r1 > r2) goto L43;
        boolean r13 = true;
    L44:
        if (r13 == true) goto L46;
    L48:
        String r14 = "";
    L49:
        if (r20 == false) goto L51;
    L56:
        boolean r15 = true;
    L57:
        if (r15 == true) goto L60;
        r1 = RangesKt.coerceAtLeast(this.e.getSelectionStart(), 0);
    L60:
        if (r15 == true) goto L63;
        r2 = RangesKt.coerceAtLeast(this.e.getSelectionEnd(), r1);
    L63:
        String r16 = CollectionsKt.joinToString$default(r3, " ", null, " ", 0, null, new t(), 26, null);
        r12.replace(r1, r2, r16);
        int r21 = r16.length() + r1;
        if (this.e.getEditableText() != r12) goto L86;
        if (r1 >= 0) goto L67;
    L69:
        boolean r22 = false;
    L70:
        if (r22 == false) goto L86;
        if (r1 <= r21) goto L73;
    L75:
        boolean r23 = false;
    L76:
        if (r23 == false) goto L86;
        if (Intrinsics.areEqual(r12.subSequence(r1, r21).toString(), r16) == false) goto L86;
        Iterator<T> r24 = r3.iterator();
        int r25 = r1;
    L82:
        if (r24.hasNext() == false) goto L84;
        d0 r26 = (d0) r24.next();
        r26.getClass();
        Regex r27 = com.larus.bmhome.chat.markdown.richtext.n.a;
        int r28 = com.larus.bmhome.chat.markdown.richtext.n.b(k0.a(r26)).length() + r25;
        e(r12, r26, r25, r28);
        r25 = r28 + 1;
        goto L82
    L84:
        this.e.setSelection(RangesKt.coerceAtMost(r1 + r16.length(), r12.length()));
        return true;
    L73:
        if (r21 > r12.length()) goto L75;
        r23 = true;
        goto L76
    L67:
        if (r1 > r12.length()) goto L69;
        r22 = true;
        goto L70
    L51:
        if (StringsKt.startsWith$default(r14, "@", false, 2, null) == true) goto L56;
        if (StringsKt.startsWith$default(r14, "/", false, 2, null) == true) goto L56;
        r15 = false;
        goto L57
    L46:
        if (r2 > r12.length()) goto L48;
        r14 = r12.subSequence(r1, r2).toString();
    L43:
        r13 = false;
        goto L44
    L23:
        if (StringsKt.isBlank(r9) == true) goto L26;
        r10 = false;
    L30:
        r11 = true;
        goto L32
    L15:
        if (StringsKt.isBlank(r7) == true) goto L18;
        r8 = false;
    L34:
        r5 = false;
        goto L35
    L7:
        if (r3.isEmpty() == false) goto L9;
    L86:
        return false;
    }

    public static final Object d(ChatInputWithMentionDelegate r1, d0 r2, final String r3, final Integer r4, Continuation r5) {
        r1.getClass();
        if (OfficeMentionService.b.isSupported() == true) goto L5;
        return null;
    L5:
        final i0 r6 = r2.f;
        int r0 = ImageViewBitmapLoader.a;
        return ImageViewBitmapLoader.a(r1.e.getContext(), false, new v(r4, r6, r3), r5);
    }
}
