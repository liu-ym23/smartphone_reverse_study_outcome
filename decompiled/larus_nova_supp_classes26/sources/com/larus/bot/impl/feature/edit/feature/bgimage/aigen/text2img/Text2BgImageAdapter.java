package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img;

import android.animation.ObjectAnimator;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.databinding.LarusLayoutBotBgChooseRowBinding;
import com.larus.bot.impl.databinding.LarusLayoutBotEditBgChoosePageBinding;
import com.larus.bot.impl.databinding.LarusLayoutBotEditErrorLayBinding;
import com.larus.network.http.y;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\nH\u0016J\u0014\u0010\"\u001a\u00020\u000e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012RL\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/Text2BgImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/Text2BgImageBindingViewHolder;", "<init>", "()V", "dataList", "", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/Text2BgImageBindingViewHolder$AIGenBgImageData;", "onClickRetry", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pageIndex", "", "getOnClickRetry", "()Lkotlin/jvm/functions/Function1;", "setOnClickRetry", "(Lkotlin/jvm/functions/Function1;)V", "onImageChoose", "Lkotlin/Function2;", "index", "getOnImageChoose", "()Lkotlin/jvm/functions/Function2;", "setOnImageChoose", "(Lkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "refreshData", "data", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Text2BgImageAdapter extends RecyclerView.Adapter<Text2BgImageBindingViewHolder> {
    public List<Text2BgImageBindingViewHolder.a> a;
    public Function1<? super Integer, Unit> b;
    public Function2<? super Integer, ? super Integer, Unit> c;

    public final int getItemCount() {
        return this.a.size();
    }

    public Text2BgImageAdapter() {
        this.a = CollectionsKt.emptyList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r30, int r31) {
        final Text2BgImageBindingViewHolder r0 = (Text2BgImageBindingViewHolder) r30;
        Intrinsics.checkNotNullParameter(r0, "holder");
        Text2BgImageBindingViewHolder.a r2 = (Text2BgImageBindingViewHolder.a) ListProtector.get(this.a, r31);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "itemData");
        r0.d = r2.c;
        y r3 = r2.a;
        String r5 = null;
        int r6 = 8;
        if ((r3 instanceof com.larus.network.http.f) == false) goto L8;
        ObjectAnimator r4 = r0.e;
        if (r4 == null) goto L7;
        r4.cancel();
    L7:
        r0.e = null;
        r0.a.e.setVisibility(8);
        e1.q(r0.a.f.a);
        e1.q(r0.a.c.a);
        e1.x(r0.a.d.a);
        e1.d(r0.a.d.a, new g(r0));
        return;
    L8:
        boolean r7 = true;
        if ((r3 instanceof y) == false) goto L177;
        boolean r8 = r2.b;
        List r9 = (List) ((com.larus.network.http.a) r3).b;
        if (r9 == null) goto L22;
        List r10 = r9;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L14:
        if (r12.hasNext() == false) goto L23;
        BotAvatarIconData r13 = (BotAvatarIconData) r12.next();
        if (r13 == null) goto L20;
        String r14 = r13.getIconUrl();
        if (r14 == null) goto L20;
        Uri r15 = UriProtector.parse(r14);
    L21:
        r11.add(r15);
    L20:
        r15 = null;
    L23:
        List r16 = (List) ((com.larus.network.http.a) r2.a).b;
        if (r16 == null) goto L33;
        List r17 = r16;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L27:
        if (r19.hasNext() == false) goto L34;
        BotAvatarIconData r110 = (BotAvatarIconData) r19.next();
        if (r110 == null) goto L31;
        String r111 = r110.getIconUri();
    L32:
        r18.add(r111);
        goto L27
    L31:
        r111 = null;
    L34:
        Integer r20 = r2.d;
        ObjectAnimator r21 = r0.e;
        if (r21 == null) goto L37;
        r21.cancel();
    L37:
        r0.e = null;
        r0.a.e.setVisibility(8);
        if (r11 == null) goto L202;
        e1.x(r0.a.f.a);
        LinearLayout r22 = r0.a.c.a;
        if (r8 == false) goto L43;
        int r112 = 0;
    L44:
        r22.setVisibility(r112);
        e1.o(r0.a.d.a);
        Uri r113 = (Uri) CollectionsKt.getOrNull(r11, 0);
        if (r113 == null) goto L55;
        com.larus.bot.impl.common.util.h.b(r0.a.f.d, r113, "text_bg_image_binding_0", false, null, null, null, 124);
        if (r18 == null) goto L49;
        String r23 = (String) CollectionsKt.getOrNull(r18, 0);
    L50:
        boolean r24 = o0.d(r23);
        r0.a.f.d.setEnabled(r24);
        FrameLayout r114 = r0.a.f.e.a;
        if (r24 == false) goto L53;
        int r25 = 0;
    L54:
        r114.setVisibility(r25);
    L56:
        Uri r115 = (Uri) CollectionsKt.getOrNull(r11, 1);
        if (r115 == null) goto L67;
        com.larus.bot.impl.common.util.h.b(r0.a.f.b, r115, "text_bg_image_binding_1", false, null, null, null, 124);
        if (r18 == null) goto L61;
        String r26 = (String) CollectionsKt.getOrNull(r18, 1);
    L62:
        boolean r27 = o0.d(r26);
        r0.a.f.b.setEnabled(r27);
        FrameLayout r116 = r0.a.f.c.a;
        if (r27 == false) goto L65;
        int r28 = 0;
    L66:
        r116.setVisibility(r28);
    L68:
        Uri r117 = (Uri) CollectionsKt.getOrNull(r11, 2);
        if (r117 == null) goto L79;
        com.larus.bot.impl.common.util.h.b(r0.a.f.f, r117, "text_bg_image_binding_2", false, null, null, null, 124);
        if (r18 == null) goto L73;
        String r29 = (String) CollectionsKt.getOrNull(r18, 2);
    L74:
        boolean r32 = o0.d(r29);
        r0.a.f.f.setEnabled(r32);
        FrameLayout r118 = r0.a.f.g.a;
        if (r32 == false) goto L77;
        int r33 = 0;
    L78:
        r118.setVisibility(r33);
    L81:
        if (r8 == false) goto L117;
        Uri r119 = (Uri) CollectionsKt.getOrNull(r11, 3);
        if (r119 == null) goto L93;
        com.larus.bot.impl.common.util.h.b(r0.a.c.d, r119, "text_bg_image_binding_3", false, null, null, null, 124);
        if (r18 == null) goto L87;
        String r34 = (String) CollectionsKt.getOrNull(r18, 3);
    L88:
        boolean r35 = o0.d(r34);
        r0.a.c.d.setEnabled(r35);
        FrameLayout r120 = r0.a.c.e.a;
        if (r35 == false) goto L91;
        int r36 = 0;
    L92:
        r120.setVisibility(r36);
    L94:
        Uri r121 = (Uri) CollectionsKt.getOrNull(r11, 4);
        if (r121 == null) goto L105;
        com.larus.bot.impl.common.util.h.b(r0.a.c.b, r121, "text_bg_image_binding_4", false, null, null, null, 124);
        if (r18 == null) goto L99;
        String r37 = (String) CollectionsKt.getOrNull(r18, 4);
    L100:
        boolean r38 = o0.d(r37);
        r0.a.c.b.setEnabled(r38);
        FrameLayout r122 = r0.a.c.c.a;
        if (r38 == false) goto L103;
        int r39 = 0;
    L104:
        r122.setVisibility(r39);
    L106:
        Uri r123 = (Uri) CollectionsKt.getOrNull(r11, 5);
        if (r123 == null) goto L116;
        com.larus.bot.impl.common.util.h.b(r0.a.c.f, r123, "text_bg_image_binding_5", false, null, null, null, 124);
        if (r18 == null) goto L111;
        r5 = (String) CollectionsKt.getOrNull(r18, 5);
    L111:
        boolean r40 = o0.d(r5);
        r0.a.c.f.setEnabled(r40);
        FrameLayout r41 = r0.a.c.g.a;
        if (r40 == false) goto L114;
        int r42 = 0;
    L115:
        r41.setVisibility(r42);
        goto L117
    L114:
        r42 = 8;
        goto L115
    L116:
        r0.a.c.f.setEnabled(false);
        r0.a.c.g.a.setVisibility(8);
        goto L117
    L103:
        r39 = 8;
        goto L104
    L99:
        r37 = null;
        goto L100
    L105:
        r0.a.c.b.setEnabled(false);
        r0.a.c.c.a.setVisibility(8);
        goto L106
    L91:
        r36 = 8;
        goto L92
    L87:
        r34 = null;
        goto L88
    L93:
        r0.a.c.d.setEnabled(false);
        r0.a.c.e.a.setVisibility(8);
    L117:
        ImageView r43 = r0.a.f.e.b;
        if (r20 != null) goto L121;
    L123:
        boolean r44 = false;
    L124:
        if (r44 == false) goto L126;
        int r45 = 0;
    L127:
        r43.setVisibility(r45);
        ImageView r46 = r0.a.f.c.b;
        if (r20 != null) goto L131;
    L133:
        boolean r47 = false;
    L134:
        if (r47 == false) goto L136;
        int r48 = 0;
    L137:
        r46.setVisibility(r48);
        ImageView r49 = r0.a.f.g.b;
        if (r20 != null) goto L141;
    L143:
        boolean r50 = false;
    L144:
        if (r50 == false) goto L146;
        int r51 = 0;
    L147:
        r49.setVisibility(r51);
        ImageView r52 = r0.a.c.e.b;
        if (r20 != null) goto L151;
    L153:
        boolean r53 = false;
    L154:
        if (r53 == false) goto L156;
        int r54 = 0;
    L157:
        r52.setVisibility(r54);
        ImageView r55 = r0.a.c.c.b;
        if (r20 != null) goto L161;
    L163:
        boolean r56 = false;
    L164:
        if (r56 == false) goto L166;
        int r57 = 0;
    L167:
        r55.setVisibility(r57);
        ImageView r1 = r0.a.c.g.b;
        if (r20 != null) goto L171;
    L173:
        r7 = false;
    L174:
        if (r7 == false) goto L176;
        r6 = 0;
    L176:
        r1.setVisibility(r6);
        return;
    L171:
        if (r20.intValue() != 5) goto L173;
    L166:
        r57 = 8;
        goto L167
    L161:
        if (r20.intValue() != 4) goto L163;
        r56 = true;
        goto L164
    L156:
        r54 = 8;
        goto L157
    L151:
        if (r20.intValue() != 3) goto L153;
        r53 = true;
        goto L154
    L146:
        r51 = 8;
        goto L147
    L141:
        if (r20.intValue() != 2) goto L143;
        r50 = true;
        goto L144
    L136:
        r48 = 8;
        goto L137
    L131:
        if (r20.intValue() != 1) goto L133;
        r47 = true;
        goto L134
    L126:
        r45 = 8;
        goto L127
    L121:
        if (r20.intValue() != 0) goto L123;
        r44 = true;
        goto L124
    L77:
        r33 = 8;
        goto L78
    L73:
        r29 = null;
        goto L74
    L79:
        r0.a.f.f.setEnabled(false);
        r0.a.f.g.a.setVisibility(8);
        goto L81
    L65:
        r28 = 8;
        goto L66
    L61:
        r26 = null;
        goto L62
    L67:
        r0.a.f.b.setEnabled(false);
        r0.a.f.c.a.setVisibility(8);
        goto L68
    L53:
        r25 = 8;
        goto L54
    L49:
        r23 = null;
        goto L50
    L55:
        r0.a.f.d.setEnabled(false);
        r0.a.f.e.a.setVisibility(8);
        goto L56
    L43:
        r112 = 8;
        goto L44
    L202:
        return;
    L33:
        r18 = null;
        goto L34
    L22:
        r11 = null;
        goto L23
    L177:
        boolean r58 = r2.b;
        e1.x(r0.a.f.a);
        LinearLayout r59 = r0.a.c.a;
        if (r58 == false) goto L180;
        r6 = 0;
    L180:
        r59.setVisibility(r6);
        e1.o(r0.a.d.a);
        com.larus.bot.impl.common.util.h.b(r0.a.f.d, null, null, false, null, null, null, 124);
        com.larus.bot.impl.common.util.h.b(r0.a.f.b, null, null, false, null, null, null, 124);
        com.larus.bot.impl.common.util.h.b(r0.a.f.f, null, null, false, null, null, null, 124);
        if (r58 == false) goto L183;
        com.larus.bot.impl.common.util.h.b(r0.a.c.d, null, null, false, null, null, null, 124);
        com.larus.bot.impl.common.util.h.b(r0.a.c.b, null, null, false, null, null, null, 124);
        com.larus.bot.impl.common.util.h.b(r0.a.c.f, null, null, false, null, null, null, 124);
    L183:
        r0.T3();
        e1.x(r0.a.e);
        LarusLayoutBotEditBgChoosePageBinding r60 = r0.a;
        ObjectAnimator r61 = ObjectAnimator.ofFloat(r60.e, "translationX", new float[]{0.0f, com.larus.utils.i.d(r60.a.getContext()) - c7.b(32)});
        r0.e = r61;
        if (r61 == null) goto L186;
        r61.setRepeatCount(-1);
    L186:
        ObjectAnimator r62 = r0.e;
        if (r62 == null) goto L189;
        r62.setDuration(700);
    L189:
        ObjectAnimator r63 = r0.e;
        if (r63 == null) goto L201;
        r63.start();
        return;
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.e] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.f] */
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        ConstraintLayout r12 = LayoutInflater.from(r10.getContext()).inflate(2131562753, r10, false);
        int r0 = 2131363708;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131363708);
        if (r4 == null) goto L17;
        r0 = 2131364506;
        View r1 = ViewBindings.findChildViewById(r12, 2131364506);
        if (r1 == null) goto L17;
        LarusLayoutBotBgChooseRowBinding r5 = LarusLayoutBotBgChooseRowBinding.a(r1);
        r0 = 2131371759;
        View r2 = ViewBindings.findChildViewById(r12, 2131371759);
        if (r2 == null) goto L17;
        LarusLayoutBotEditErrorLayBinding r6 = LarusLayoutBotEditErrorLayBinding.a(r2);
        r0 = 2131374968;
        if (((LinearLayout) ViewBindings.findChildViewById(r12, 2131374968)) == null) goto L17;
        r0 = 2131377861;
        View r7 = ViewBindings.findChildViewById(r12, 2131377861);
        if (r7 == null) goto L17;
        r0 = 2131389220;
        View r3 = ViewBindings.findChildViewById(r12, 2131389220);
        if (r3 == null) goto L17;
        ConstraintLayout r8 = r12;
        return new Text2BgImageBindingViewHolder(new LarusLayoutBotEditBgChoosePageBinding(r8, r4, r5, r6, r7, LarusLayoutBotBgChooseRowBinding.a(r3)), new e(this), new f(this));
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
