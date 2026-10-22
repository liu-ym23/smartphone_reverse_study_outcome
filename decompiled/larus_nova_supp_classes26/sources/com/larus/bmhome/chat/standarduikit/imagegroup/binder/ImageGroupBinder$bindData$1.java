package com.larus.bmhome.chat.standarduikit.imagegroup.binder;

import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.ImageGroupLegacyView;
import com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.n;
import com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.o;
import com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.u;
import com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.w;
import com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.x;
import com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.y;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.ImageShowType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusMdImageGroupJoin6Binding;
import com.larus.mainbot.impl.databinding.LarusMdImageGroupLayerBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
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
import kotlinx.coroutines.CoroutineScope;
import pl8.i;
import pl8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.imagegroup.binder.ImageGroupBinder$bindData$1", f = "ImageGroupBinder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImageGroupBinder$bindData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.markdown.imagegroup.a $imageGroupData;
    final /* synthetic */ fh8.f $markdownCommonInputData;
    final /* synthetic */ com.larus.bmhome.chat.standarduikit.imagegroup.view.a $sizeData;
    final /* synthetic */ usc.e $span;
    final /* synthetic */ Spanned $text;
    final /* synthetic */ TextView $textView;
    int label;
    final /* synthetic */ ImageGroupBinder this$0;

    public ImageGroupBinder$bindData$1(com.larus.bmhome.chat.standarduikit.imagegroup.view.a r1, com.larus.bmhome.chat.markdown.imagegroup.a r2, fh8.f r3, ImageGroupBinder r4, Spanned r5, usc.e r6, TextView r7, Continuation<? super ImageGroupBinder$bindData$1> r8) {
        this.$sizeData = r1;
        this.$imageGroupData = r2;
        this.$markdownCommonInputData = r3;
        this.this$0 = r4;
        this.$text = r5;
        this.$span = r6;
        this.$textView = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ImageGroupBinder$bindData$1(this.$sizeData, this.$imageGroupData, this.$markdownCommonInputData, this.this$0, this.$text, this.$span, this.$textView, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r15v4, types: [com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.c] */
    /* JADX WARN: Type inference failed for: r5v38, types: [com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.n] */
    public final Object invokeSuspend(Object r31) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L158;
        ResultKt.throwOnFailure(r31);
        com.larus.bmhome.chat.standarduikit.imagegroup.view.a r3 = this.$sizeData;
        com.larus.bmhome.chat.markdown.imagegroup.a r4 = this.$imageGroupData;
        fh8.f r2 = this.$markdownCommonInputData;
        if (r2 == null) goto L9;
        Message r5 = r2.b;
        if (r5 == null) goto L9;
        String r6 = r5.getMessageId();
    L10:
        fh8.f r7 = this.$markdownCommonInputData;
        if (r7 == null) goto L15;
        Message r8 = r7.b;
        if (r8 == null) goto L15;
        String r9 = r8.getLocalMessageId();
    L16:
        fh8.f r10 = this.$markdownCommonInputData;
        if (r10 == null) goto L21;
        Message r11 = r10.b;
        if (r11 == null) goto L21;
        String r12 = r11.getReplyId();
    L22:
        fh8.f r13 = this.$markdownCommonInputData;
        if (r13 == null) goto L27;
        Message r14 = r13.b;
        if (r14 == null) goto L27;
        String r15 = com.larus.bmhome.chat.bean.d.x(r14).getReqId();
    L28:
        fh8.f r16 = this.$markdownCommonInputData;
        if (r16 == null) goto L31;
        Message r17 = r16.b;
    L32:
        ImageGroupBinder r18 = this.this$0;
        Spanned r19 = this.$text;
        usc.e r110 = this.$span;
        Integer r111 = r18.h;
        if (r111 == null) goto L35;
        Integer r112 = r111;
    L36:
        fh8.f r20 = this.$markdownCommonInputData;
        if (r20 == null) goto L39;
        Function0 r113 = r20.s;
    L40:
        if (r20 == null) goto L42;
        bc8.b r114 = r20.t;
    L43:
        if (r20 == null) goto L45;
        Boolean r115 = r20.u;
    L46:
        if (r20 == null) goto L48;
        Function1 r116 = r20.y;
    L49:
        ql8.a r1 = new ql8.a(r3, r4, r6, r9, r12, r15, r17, r112, r113, r114, r115, r116);
        i r21 = new i(this.$markdownCommonInputData, this.$textView);
        ol8.c r22 = (ol8.c) this.this$0.c.getValue();
        r22.getClass();
        Intrinsics.checkNotNullParameter(r1, "vmData");
        k r23 = (k) r22.b.getValue();
        r23.getClass();
        Intrinsics.checkNotNullParameter(r1, "vmData");
        r23.b = r1;
        r23.c = r21;
        k r24 = (k) r22.b.getValue();
        ql8.a r25 = r24.b;
        com.larus.bmhome.chat.markdown.imagegroup.a r26 = r25.b;
        com.larus.bmhome.chat.standarduikit.imagegroup.view.a r27 = r25.a;
        y r117 = new y(r27.a, r27.b, r27.c, r27.d, r27.e, r27.f);
        List r28 = r26.c();
        if (r28 != null) goto L52;
        r28 = CollectionsKt.emptyList();
    L52:
        Integer r29 = r26.b();
        Boolean r30 = r26.d();
        if (r30 == null) goto L55;
        boolean r32 = r30.booleanValue();
    L56:
        x r33 = new x(r28, r29, r32);
        ql8.a r34 = r24.b;
        String r35 = r34.c;
        String r36 = r34.d;
        pl8.a r37 = r24.c;
        if (r37 == null) goto L59;
        String r38 = r37.getConversationId();
    L60:
        pl8.a r39 = r24.c;
        if (r39 == null) goto L63;
        String r40 = r39.getChatType();
    L64:
        w r41 = new w(r35, r36, r38, r40);
        Boolean r42 = r26.d();
        Boolean r43 = Boolean.TRUE;
        if (Intrinsics.areEqual(r42, r43) == false) goto L67;
        float r44 = UIUtils.dip2Px(AppHost.a.getApplication(), 4.0f);
    L69:
        if (Intrinsics.areEqual(r26.d(), r43) == false) goto L71;
        int r118 = 3;
    L72:
        ql8.a r45 = r24.b;
        final com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.a r119 = new com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.a(r117, r33, r41, r44, r118, r45.i, r45.j);
        final k.b r46 = ((k) r22.b.getValue()).d;
        final ImageGroupLegacyView r47 = (ImageGroupLegacyView) r22.a.getValue();
        r47.getClass();
        Intrinsics.checkNotNullParameter(r119, "input");
        Intrinsics.checkNotNullParameter(r46, "output");
        y r48 = r119.a;
        Pair r49 = ImageGroupLegacyView.c(r48.b, r48.c);
        r47.setPaddingRelative(r47.getPaddingStart(), ((Number) r49.component1()).intValue(), r47.getPaddingEnd(), ((Number) r49.component2()).intValue());
        Integer r50 = r119.b.b;
        boolean r120 = true;
        if (r50 != null) goto L76;
    L80:
        boolean r51 = false;
    L81:
        if (r51 == true) goto L83;
        FLogger.a.e("ImageGroupView", "unknown type: " + r50);
        AppHost.Companion r0 = AppHost.a;
        if (r0.isDebug() == true) goto L156;
        if (r0.isDebugChannel() == true) goto L156;
    L154:
        return Unit.INSTANCE;
    L156:
        throw new IllegalArgumentException("unknown type: " + r50);
    L83:
        if (r119.b.a.size() != 1) goto L91;
        final View r52 = LayoutInflater.from(r47.getContext()).inflate(2131562951, r47, false);
        final LarusMdImageGroupLayerBinding r53 = LarusMdImageGroupLayerBinding.a(r52);
        float r54 = r119.d;
        if (r54 == (-1.0f)) goto L88;
        r120 = false;
    L88:
        if (r120 == true) goto L90;
        r53.e.setRadius(r54);
        r53.b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(r54));
    L90:
        final int r121 = r119.b.a.size();
        final List r55 = CollectionsKt.listOf(r53.b);
        final ?? r122 = new com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.c(r53, r47, r55, r119, r46, r121);
        final ?? r56 = new n(r53, r121, r47, r122);
        r122.invoke();
        r47.d(new o(r56, r47, r52));
        View r57 = r53.b;
        final SearchImageInfo r58 = (SearchImageInfo) CollectionsKt.getOrNull(r119.b.a, 0);
        final String r59 = "single_card";
        final int r60 = r47.b.getWidth();
        final int r123 = r47.b.getHeight();
        final int r124 = 0;
        ExposeXTrackerExtKt.b(r57, new u(r58, r46, r59, r60, r123, r124, r119));
        r47.d.add(r57);
        goto L154
    L91:
        r47.removeAllViews();
        CardView r61 = LayoutInflater.from(r47.getContext()).inflate(2131562950, r47, false);
        r47.addView(r61);
        int r62 = 2131374990;
        SimpleDraweeView r63 = ViewBindings.findChildViewById(r61, 2131374990);
        if (r63 == null) goto L148;
        r62 = 2131374991;
        SimpleDraweeView r64 = ViewBindings.findChildViewById(r61, 2131374991);
        if (r64 == null) goto L148;
        r62 = 2131374992;
        SimpleDraweeView r65 = ViewBindings.findChildViewById(r61, 2131374992);
        if (r65 == null) goto L148;
        r62 = 2131374993;
        SimpleDraweeView r125 = ViewBindings.findChildViewById(r61, 2131374993);
        if (r125 == null) goto L148;
        r62 = 2131374994;
        SimpleDraweeView r126 = ViewBindings.findChildViewById(r61, 2131374994);
        if (r126 == null) goto L148;
        r62 = 2131374995;
        SimpleDraweeView r210 = ViewBindings.findChildViewById(r61, 2131374995);
        if (r210 == null) goto L148;
        r62 = 2131375000;
        AppCompatTextView r211 = ViewBindings.findChildViewById(r61, 2131375000);
        if (r211 == null) goto L148;
        CardView r127 = r61;
        r62 = 2131387008;
        if (ViewBindings.findChildViewById(r61, 2131387008) == null) goto L148;
        LarusMdImageGroupJoin6Binding r66 = new LarusMdImageGroupJoin6Binding(r127, r63, r64, r65, r125, r126, r210, r211);
        Intrinsics.checkNotNull(r66);
        List<SearchImageInfo> r67 = r119.b.a;
        int r128 = r67.size();
        int r68 = r47.b.getHeight();
        if (r119.b.c == false) goto L112;
        List<? extends View> r69 = CollectionsKt.listOf(new SimpleDraweeView[]{r63, r64, r65});
    L110:
        List<? extends View> r70 = r69;
        Iterator<T> r129 = r70.iterator();
        final int r130 = 0;
    L117:
        if (r129.hasNext() == false) goto L122;
        int r212 = r130 + 1;
        View r131 = (SimpleDraweeView) r129.next();
        if (CollectionsKt.getOrNull(r67, r130) == null) goto L122;
        r47.b(r131, r70, r68, r68, r119, r46, r130, "multiple_card", null, null, null);
        e1.x(r131);
        final SearchImageInfo r71 = (SearchImageInfo) CollectionsKt.getOrNull(r67, r130);
        final String r72 = "multiple_card";
        final k.b r73 = r46;
        final int r74 = r68;
        final int r132 = r68;
        ExposeXTrackerExtKt.b(r131, new u(r71, r73, r72, r74, r132, r130, r119));
        r47.d.add(r131);
        r66 = r66;
        r67 = r67;
        r46 = r46;
        r68 = r68;
        r130 = r212;
    L122:
        LarusMdImageGroupJoin6Binding r133 = r66;
        x r75 = r119.b;
        List r76 = CollectionsKt.listOf(new SimpleDraweeView[]{r133.e, r133.f, r133.g});
        switch(r75.a.size()) {
            case 1: goto L138;
            case 2: goto L137;
            case 3: goto L136;
            case 4: goto L133;
            case 5: goto L129;
            case 6: goto L126;
            default: goto L139;
        };
    L136:
        ImageGroupLegacyView.a(r47, r133.d, r76, 6);
        goto L139
    L137:
        ImageGroupLegacyView.a(r47, r133.c, r76, 6);
        goto L139
    L138:
        ImageGroupLegacyView.a(r47, r133.b, r76, 6);
    L139:
        ViewGroup.LayoutParams r77 = r133.h.getLayoutParams();
        Intrinsics.checkNotNull(r77, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r78 = (ConstraintLayout.LayoutParams) r77;
        if (r119.b.c == false) goto L142;
        int r79 = r133.d.getId();
    L143:
        ((ConstraintLayout.LayoutParams) r78).bottomToBottom = r79;
        r133.h.setLayoutParams(r78);
        int r80 = r119.b.a.size() - r119.e;
        if (r80 <= 0) goto L146;
        r133.h.setVisibility(0);
        r133.h.setText(r47.getResources().getString(2131908394, new Object[]{Integer.valueOf(r80)}));
        goto L154
    L146:
        r133.h.setVisibility(8);
        goto L154
    L142:
        r79 = r133.g.getId();
        goto L143
    L126:
        if (r75.c == false) goto L139;
        ImageGroupLegacyView.a(r47, r133.d, r76, 6);
        goto L139
    L129:
        if (r75.c == false) goto L131;
        ImageGroupLegacyView.a(r47, r133.d, r76, 6);
        goto L139
    L131:
        ImageGroupLegacyView.a(r47, r133.d, null, 14);
        ImageGroupLegacyView.a(r47, r133.f, null, 12);
        goto L139
    L133:
        if (r75.c == false) goto L135;
        ImageGroupLegacyView.a(r47, r133.d, r76, 6);
        goto L139
    L135:
        ImageGroupLegacyView.a(r47, r133.c, null, 10);
        ImageGroupLegacyView.a(r47, r133.f, null, 12);
        goto L139
    L112:
        if (r128 != 4) goto L114;
        r69 = CollectionsKt.listOf(new SimpleDraweeView[]{r63, r64, r125, r126});
        goto L110
    L114:
        r69 = CollectionsKt.listOf(new SimpleDraweeView[]{r63, r64, r65, r125, r126, r210});
    L148:
        throw new NullPointerException("Missing required view with ID: ".concat(r61.getResources().getResourceName(r62)));
    L76:
        if (r50.intValue() < ImageShowType.JOIN.value) goto L80;
        if (r50.intValue() > ImageShowType.SIDE_SLIP.value) goto L80;
        r51 = true;
        goto L81
    L71:
        r118 = 6;
        goto L72
    L67:
        r44 = -1.0f;
        goto L69
    L63:
        r40 = null;
        goto L64
    L59:
        r38 = null;
        goto L60
    L55:
        r32 = false;
        goto L56
    L48:
        r116 = null;
        goto L49
    L45:
        r115 = null;
        goto L46
    L42:
        r114 = null;
        goto L43
    L39:
        r113 = null;
        goto L40
    L35:
        r112 = ri8.c.k(r19, r110);
        r18.h = r112;
        goto L36
    L31:
        r17 = null;
    L27:
        r15 = null;
    L21:
        r12 = null;
    L15:
        r9 = null;
    L9:
        r6 = null;
        goto L10
    L158:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
