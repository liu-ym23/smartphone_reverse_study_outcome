package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import android.text.Editable;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import v7b.n;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.PossibleLinkMatcher$matchUrl$1", f = "PossibleLinkMatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PossibleLinkMatcher$matchUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Editable $editable;
    int label;
    final /* synthetic */ PossibleLinkMatcher this$0;

    public PossibleLinkMatcher$matchUrl$1(PossibleLinkMatcher r1, Editable r2, Continuation<? super PossibleLinkMatcher$matchUrl$1> r3) {
        this.this$0 = r1;
        this.$editable = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PossibleLinkMatcher$matchUrl$1(this.this$0, this.$editable, r4);
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
    public final Object invokeSuspend(Object r21) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L119;
        ResultKt.throwOnFailure(r21);
        PossibleLinkMatcher r1 = this.this$0;
        Editable r2 = this.$editable;
        int r3 = PossibleLinkMatcher.f;
        r1.getClass();
        char r4 = 1;
        int r5 = 0;
        if (r2 != null) goto L7;
        List r6 = CollectionsKt.emptyList();
    L25:
        Editable r7 = this.$editable;
        f.a r8 = f.a;
        String r9 = r7.toString();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "text");
        r7.setSpan(new e(r9), 0, this.$editable.length(), 33);
        if (r6.isEmpty() == true) goto L28;
        PossibleLinkMatcher r10 = this.this$0;
        Editable r11 = this.$editable;
        Iterator r12 = r6.iterator();
    L31:
        if (r12.hasNext() == false) goto L117;
        int[] r13 = (int[]) r12.next();
        r10.getClass();
        if (r11 != null) goto L36;
        Iterator r17 = r12;
    L115:
        r12 = r17;
        r4 = 1;
        r5 = 0;
        goto L31
    L36:
        int r14 = r13[r5];
        int r15 = r13[r4];
        i[] r16 = (i[]) r11.getSpans(r14, r15, i.class);
        Intrinsics.checkNotNull(r16);
        if (r16.length != 0) goto L39;
        boolean r18 = true;
    L40:
        if (r18 == false) goto L42;
        r16 = (i[]) r11.getSpans(r5, r11.length(), i.class);
    L42:
        Intrinsics.checkNotNull(r16);
        int r19 = r16.length;
        int r110 = 0;
    L43:
        if (r110 >= r19) goto L75;
        i r111 = r16[r110];
        int r112 = r11.getSpanStart(r111);
        int r113 = r11.getSpanEnd(r111);
        if (r111.b == false) goto L47;
    L48:
        r11.removeSpan(r111);
        if (r111.b == true) goto L73;
        p[] r20 = (p[]) r11.getSpans(r112, r113, p.class);
        Intrinsics.checkNotNull(r20);
        int r114 = r20.length;
        int r115 = 0;
    L52:
        if (r115 >= r114) goto L64;
        p r0 = r20[r115];
        Iterator r116 = r12;
        Object r22 = r0.b;
        p[] r117 = r20;
        if ((r22 instanceof RichTextElement) == true) goto L56;
        int r118 = r19;
    L63:
        r115 = r115 + 1;
        r12 = r116;
        r20 = r117;
        r19 = r118;
        goto L52
    L56:
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type com.ss.android.lark.widget.richtext.RichTextElement");
        RichTextElement r23 = (RichTextElement) r22;
        r118 = r19;
        if (r23.getTag() != RichTextElement.RichTextTag.ANCHOR) goto L63;
        if (r23.getProperty().getScene() != RichTextElement.AnchorProperty.Scene.COPY_PASTE_TEXT) goto L63;
        r11.removeSpan(r0);
        Log.i("PossibleLinkMatcher", "remove anchor rich text element, is wide url");
        goto L63
    L64:
        Iterator r119 = r12;
        int r120 = r19;
        com.ss.android.lark.coremd.impl.buildnode.a[] r24 = (com.ss.android.lark.coremd.impl.buildnode.a[]) r11.getSpans(r112, r113, com.ss.android.lark.coremd.impl.buildnode.a.class);
        Intrinsics.checkNotNull(r24);
        int r25 = r24.length;
        int r26 = 0;
    L65:
        if (r26 >= r25) goto L74;
        com.ss.android.lark.coremd.impl.buildnode.a r121 = r24[r26];
        final s r122 = r121.a;
        if ((r122 instanceof n) == true) goto L69;
        com.ss.android.lark.coremd.impl.buildnode.a[] r123 = r24;
    L72:
        r26 = r26 + 1;
        r24 = r123;
        goto L65
    L69:
        r123 = r24;
        if (((LinkType) LarkLinkExtend.f.b(new PossibleLinkMatcher$removeAnchorRichTextHolder$2$linkType$1(r122))) != LinkType.PossibleLink) goto L72;
        r11.removeSpan(r121);
        Log.i("PossibleLinkMatcher", "remove anchor rich text element, is wide url");
    L74:
        r14 = Math.min(r14, r112);
        r15 = Math.max(r15, r113);
        r110 = r110 + 1;
        r12 = r119;
        r19 = r120;
    L73:
        r119 = r12;
        r120 = r19;
        goto L74
    L47:
        if (Intrinsics.areEqual(r111.c, r11.subSequence(r112, r113).toString()) == true) goto L73;
    L75:
        r17 = r12;
        Intrinsics.checkNotNull(r16);
        if (r16.length != 0) goto L78;
        boolean r27 = true;
    L79:
        if (r27 == false) goto L81;
        r15 = r11.length();
        r14 = 0;
    L81:
        Object[] r28 = r11.getSpans(r14, r15, Object.class);
        Intrinsics.checkNotNull(r28);
        ArrayList r29 = new ArrayList();
        int r30 = r28.length;
        int r31 = 0;
    L82:
        if (r31 >= r30) goto L93;
        Object r32 = r28[r31];
        if ((r32 instanceof com.ss.android.lark.widget.light.span.h) == false) goto L86;
    L89:
        boolean r33 = true;
    L90:
        if (r33 == false) goto L92;
        r29.add(r32);
    L92:
        r31 = r31 + 1;
        goto L82
    L86:
        if ((r32 instanceof com.ss.android.lark.coremd.impl.buildnode.a) == true) goto L89;
        r33 = false;
        goto L90
    L93:
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
        Iterator r35 = r29.iterator();
    L95:
        if (r35.hasNext() == false) goto L97;
        Object r36 = r35.next();
        r34.add(TuplesKt.to(Integer.valueOf(r11.getSpanStart(r36)), Integer.valueOf(r11.getSpanEnd(r36))));
        goto L95
    L97:
        List r37 = CollectionsKt.sortedWith(r34, new k());
        if (r37.isEmpty() == false) goto L100;
        r10.c(r14, r15, r11);
        goto L115
    L100:
        ArrayList r38 = new ArrayList();
        Iterator r39 = r37.iterator();
    L102:
        if (r39.hasNext() == false) goto L109;
        Pair r40 = (Pair) r39.next();
        int r41 = ((Number) r40.getFirst()).intValue();
        int r42 = ((Number) r40.getSecond()).intValue();
        if (r14 >= r41) goto L107;
        r38.add(new int[]{r14, r41});
    L107:
        r14 = r42;
        goto L102
    L109:
        if (r15 <= r14) goto L111;
        r38.add(new int[]{r14, r15});
    L111:
        Iterator r43 = r38.iterator();
    L113:
        if (r43.hasNext() == false) goto L115;
        int[] r44 = (int[]) r43.next();
        r10.c(r44[0], r44[1], r11);
        goto L113
    L78:
        r27 = false;
        goto L79
    L39:
        r18 = false;
        goto L40
    L117:
        return Unit.INSTANCE;
    L28:
        return Unit.INSTANCE;
    L7:
        Object[] r45 = r2.getSpans(0, r2.length(), h.class);
        ArrayList r46 = new ArrayList(r45.length);
        int r47 = r45.length;
        int r48 = 0;
    L8:
        if (r48 >= r47) goto L10;
        h r49 = (h) r45[r48];
        r46.add(new Triple(r49, Integer.valueOf(r2.getSpanStart(r49)), Integer.valueOf(r2.getSpanEnd(r49))));
        r48 = r48 + 1;
        goto L8
    L10:
        List r50 = CollectionsKt.sortedWith(r46, new j());
        if (r50.isEmpty() == false) goto L13;
        r6 = CollectionsKt.emptyList();
        goto L25
    L13:
        ArrayList r51 = new ArrayList();
        Iterator r52 = r50.iterator();
    L15:
        if (r52.hasNext() == false) goto L24;
        Triple r53 = (Triple) r52.next();
        h r54 = (h) r53.getFirst();
        int r55 = ((Number) r53.getSecond()).intValue();
        int r56 = ((Number) r53.getThird()).intValue();
        if (r51.isEmpty() == false) goto L19;
    L22:
        r51.add(new int[]{r55, r56});
    L23:
        r2.removeSpan(r54);
        goto L15
    L19:
        if ((r55 - ((int[]) CollectionsKt.last(r51))[1]) >= 20) goto L22;
        ((int[]) CollectionsKt.last(r51))[1] = Math.max(((int[]) CollectionsKt.last(r51))[1], r56);
        goto L23
    L24:
        r6 = r51;
        goto L25
    L119:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
