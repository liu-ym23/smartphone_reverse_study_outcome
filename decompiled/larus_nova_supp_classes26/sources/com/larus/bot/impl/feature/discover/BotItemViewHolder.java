package com.larus.bot.impl.feature.discover;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.bean.BotOnBoarding;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.resp.ContentDistType;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.utils.FirstFeedSceneEnum;
import com.larus.bmhome.utils.f2;
import com.larus.bot.impl.databinding.LarusItemBotDiscoveryBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.common_ui.widget.AvatarTagView;
import com.larus.common_ui.widget.TagTextView;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.im.bean.bot.ShowTagInfo;
import com.larus.im.bean.bot.TagIconInfo;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.y0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J \u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\nH\u0002J$\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010!2\u0006\u0010%\u001a\u00020\u0013H\u0002J\u0018\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/bot/impl/feature/discover/BotItemViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "Lcom/larus/bot/impl/feature/discover/IBotItemViewHolder;", "binding", "Lcom/larus/bot/impl/databinding/LarusItemBotDiscoveryBinding;", "<init>", "(Lcom/larus/bot/impl/databinding/LarusItemBotDiscoveryBinding;)V", "getBinding", "()Lcom/larus/bot/impl/databinding/LarusItemBotDiscoveryBinding;", "data", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "hideHotArea", "", "hideBioArea", "hideAddButton", "bindData", "", "bot", "getRootView", "Landroid/view/View;", "getAddExtView", "setupAvatarTag", "tagInfoList", "", "Lcom/larus/im/bean/bot/ShowTagInfo;", "getSubtitle", "", "setAvatar", ShareType.URL, "bizTag", "needResize", "generateTagView", "showTagInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotItemViewHolder extends ViewBindingHolder implements w0 {
    public final LarusItemBotDiscoveryBinding a;
    public RecommendBot b;
    public final Lazy c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    public static final class a {
    }

    static {
    }

    private final Context getContext() {
        return (Context) this.c.getValue();
    }

    @Override // com.larus.bot.impl.feature.discover.w0
    public final View T1() {
        return this.a.b;
    }

    @Override // com.larus.bot.impl.feature.discover.w0
    public final View getRootView() {
        return this.a.a;
    }

    public BotItemViewHolder(LarusItemBotDiscoveryBinding r5) {
        Intrinsics.checkNotNullParameter(r5, "binding");
        super(r5);
        this.a = r5;
        this.c = LazyKt.lazy(new u0(this));
        z2 r6 = z2.a;
        boolean r2 = false;
        if (r6.d0() != 2) goto L5;
        boolean r0 = true;
    L6:
        this.d = r0;
        if (r6.d0() != 3) goto L9;
        boolean r1 = true;
    L10:
        this.e = r1;
        if (r6.d0() != 1) goto L13;
        r2 = true;
    L13:
        this.f = r2;
        return;
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bot.impl.feature.discover.w0
    public final void X2(RecommendBot r21) {
        Intrinsics.checkNotNullParameter(r21, "bot");
        if (f2.a != FirstFeedSceneEnum.BOT_DISCOVERY) goto L5;
        f2.a(((RecyclerView.ViewHolder) this).itemView, "BotItemViewHolder");
    L5:
        this.b = r21;
        String r3 = null;
        boolean r4 = true;
        if (com.larus.bot.impl.common.util.d.a == true) goto L30;
        BotIconImage r2 = r21.O();
        if (r2 == null) goto L10;
        String r5 = r2.getTinyUrl();
    L12:
        if (com.larus.utils.o0.d(r5) == false) goto L18;
        BotIconImage r6 = r21.O();
        if (r6 == null) goto L16;
        String r7 = r6.getTinyUrl();
    L17:
        U3(r7, "itg_list.avatar", false);
        goto L30
    L16:
        r7 = null;
        goto L17
    L18:
        BotIconImage r8 = r21.O();
        if (r8 == null) goto L21;
        String r9 = r8.getOriginUrl();
    L23:
        if (com.larus.utils.o0.d(r9) == false) goto L29;
        BotIconImage r10 = r21.O();
        if (r10 == null) goto L27;
        String r11 = r10.getOriginUrl();
    L28:
        U3(r11, "itg_list.avatar", true);
        goto L30
    L27:
        r11 = null;
        goto L28
    L29:
        U3(y0.k(new Uri.Builder().scheme("res").path(String.valueOf(2131240119)).build()), null, false);
        goto L30
    L21:
        r9 = null;
        goto L23
    L10:
        r5 = null;
    L30:
        this.a.k.setText(r21.getName());
        TextView r12 = this.a.i;
        Integer r13 = r21.D();
        int r14 = ContentDistType.Aweme.getValue();
        if (r13 != null) goto L34;
    L36:
        String r15 = getContext().getString(2131906312);
    L37:
        Intrinsics.checkNotNull(r15);
        String r16 = r21.h();
        if (r16 == null) goto L41;
        String r17 = StringsKt.replace$default(r16, "\n", "", false, 4, null);
        if (r17 == null) goto L41;
    L42:
        BotOnBoarding r18 = r21.Y();
        if (r18 == null) goto L45;
        String r19 = r18.d();
    L46:
        FeatureKitDelegate r20 = FeatureKitDelegate.b;
        if (r20.R().b() == true) goto L49;
    L51:
        if (r19 != null) goto L53;
    L55:
        boolean r22 = false;
    L56:
        if (r22 == false) goto L58;
        r15 = r19;
    L58:
        r12.setText(r15);
        TextView r23 = this.a.i;
        int r24 = 8;
        if ((!this.e) == false) goto L61;
        int r25 = 0;
    L62:
        r23.setVisibility(r25);
        ImageView r26 = this.a.b;
        if (r21.j0() == true) goto L65;
    L67:
        int r27 = 2131235809;
    L68:
        r26.setImageResource(r27);
        ImageView r28 = this.a.b;
        int r29 = com.larus.utils.j0.a;
        if (r21.j0() == true) goto L71;
    L73:
        int r30 = 2131898769;
    L74:
        r28.setContentDescription(com.larus.utils.j0.d(r30));
        ImageView r31 = this.a.b;
        if ((!this.f) == false) goto L77;
        int r32 = 0;
    L78:
        r31.setVisibility(r32);
        BotCreatorInfo r33 = r21.j();
        if (r33 == null) goto L81;
        String r34 = r33.getName();
    L83:
        if (com.larus.utils.o0.d(r34) == false) goto L89;
        this.a.f.setVisibility(0);
        TextView r35 = this.a.f;
        StringBuilder r36 = new StringBuilder("@");
        BotCreatorInfo r37 = r21.j();
        if (r37 == null) goto L87;
        String r38 = r37.getName();
    L88:
        r36.append(r38);
        r35.setText(r36.toString());
    L91:
        if (r20.b().b() == false) goto L105;
        BotStatistic r39 = r21.q();
        if (r39 == null) goto L95;
        String r40 = r39.getDisplayHeatScore();
    L97:
        if (com.larus.utils.o0.d(r40) == false) goto L105;
        if (this.d == true) goto L105;
        this.a.h.setVisibility(0);
        TextView r41 = this.a.g;
        BotStatistic r42 = r21.q();
        if (r42 == null) goto L103;
        String r43 = r42.getDisplayHeatScore();
    L104:
        r41.setText(r43);
    L106:
        LarusItemBotDiscoveryBinding r44 = this.a;
        ImageView r45 = r44.j;
        if (r44.f.getVisibility() != 0) goto L109;
        boolean r46 = true;
    L110:
        if (r46 == true) goto L112;
    L117:
        boolean r47 = false;
    L118:
        if (r47 == false) goto L120;
        r24 = 0;
    L120:
        r45.setVisibility(r24);
        this.a.k.setCompoundDrawables(null, null, null, null);
        List r48 = r21.c0();
        LinearLayout r49 = this.a.l;
        List r0 = r48;
        if (r0 != null) goto L123;
    L126:
        if (r4 == false) goto L128;
        e1.o(r49);
    L204:
        AudioServiceDelegate r1 = AudioServiceDelegate.a;
        RecommendBot r50 = this.b;
        if (r50 != null) goto L207;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r50 = null;
    L207:
        String r51 = r50.o();
        RecommendBot r52 = this.b;
        if (r52 != null) goto L210;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r52 = null;
    L210:
        ShowTagInfo r53 = r1.B(r51, r52.r(), r48);
        if (r53 != null) goto L213;
        e1.o(this.a.e);
        return;
    L213:
        e1.x(this.a.e);
        AvatarTagView r54 = this.a.e;
        int r55 = AvatarTagView.b;
        e1.u(r54.a.c, 0.0f, 2131102529, 2131103188);
        AvatarTagView r56 = this.a.e;
        TagIconInfo r57 = r53.getIconInfo();
        if (r57 == null) goto L216;
        String r58 = r57.getLightUrl();
    L217:
        TagIconInfo r59 = r53.getIconInfo();
        if (r59 == null) goto L220;
        r3 = r59.getDarkUrl();
    L220:
        AvatarTagView.a(r56, r58, r3);
        return;
    L216:
        r58 = null;
        goto L217
    L128:
        e1.x(r49);
        r49.removeAllViews();
        Iterator r60 = r48.iterator();
    L130:
        if (r60.hasNext() == false) goto L204;
        ShowTagInfo r61 = (ShowTagInfo) r60.next();
        if (com.larus.utils.o0.d(r61.getNameToShow()) == false) goto L130;
        Context r62 = getContext();
        com.larus.im.bean.bot.a r63 = r61.getTagUiKit();
        if (r63 == null) goto L189;
        boolean r110 = v19.h.a;
        boolean r111 = v19.h.b(getContext());
        TagTextView r112 = new TagTextView(r62, null, 6, 0);
        String r64 = r61.getName();
        if (r64 != null) goto L138;
        String r113 = "";
    L139:
        Intrinsics.checkNotNullParameter(r112, "<this>");
        Intrinsics.checkNotNullParameter(r113, "tagName");
        Intrinsics.checkNotNullParameter(r63, "tagUiKit");
        Intrinsics.checkNotNullParameter(r63, "<this>");
        Result.Companion r65 = Result.Companion;     // Catch: Throwable -> L151
        if (r111 == false) goto L146;
        String r66 = r63.d;     // Catch: Throwable -> L151
        if (r66 != null) goto L145;
        r66 = "";
    L145:
        Integer r67 = Integer.valueOf(Color.parseColor(r66));     // Catch: Throwable -> L151
    L153:
        if (r67 == null) goto L155;
        int r114 = r67.intValue();
    L156:
        Intrinsics.checkNotNullParameter(r63, "<this>");
        if (r111 == true) goto L222;
        String r68 = r63.b;     // Catch: Throwable -> L167
        if (r68 != null) goto L165;
        r68 = "";
    L165:
        Integer r69 = Integer.valueOf(Color.parseColor(r68));     // Catch: Throwable -> L167
    L169:
        if (r69 == null) goto L171;
        int r115 = r69.intValue();
    L172:
        Intrinsics.checkNotNullParameter(r63, "<this>");
        if (r111 == true) goto L224;
        String r70 = r63.c;     // Catch: Throwable -> L183
        if (r70 != null) goto L181;
        r70 = "";
    L181:
        Integer r71 = Integer.valueOf(Color.parseColor(r70));     // Catch: Throwable -> L183
    L185:
        if (r71 == null) goto L187;
        int r116 = r71.intValue();
    L188:
        r112.y(r113, r111, r114, r115, r116);
    L193:
        r49.addView(r112, new ViewGroup.LayoutParams(-2, i5.A()));
        ViewGroup.LayoutParams r72 = r112.getLayoutParams();
        if (r72 == null) goto L203;
        if ((r72 instanceof ViewGroup.MarginLayoutParams) == false) goto L198;
        ViewGroup.MarginLayoutParams r73 = (ViewGroup.MarginLayoutParams) r72;
    L199:
        if (r73 == null) goto L201;
        r73.setMarginStart(i5.j0());
    L201:
        r112.setLayoutParams(r72);
        goto L130
    L198:
        r73 = null;
        goto L199
    L203:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L187:
        r116 = 0;
        goto L188
    L224:
        String r74 = r63.f;     // Catch: Throwable -> L183
        if (r74 != null) goto L177;
        r74 = "";
    L177:
        r71 = Integer.valueOf(Color.parseColor(r74));     // Catch: Throwable -> L183
    L183:
        th = move-exception;
        Result.Companion r75 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r71 = null;
        goto L185
    L171:
        r115 = 0;
        goto L172
    L222:
        String r76 = r63.e;     // Catch: Throwable -> L167
        if (r76 != null) goto L161;
        r76 = "";
    L161:
        r69 = Integer.valueOf(Color.parseColor(r76));     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        Result.Companion r77 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r69 = null;
        goto L169
    L155:
        r114 = 0;
        goto L156
    L146:
        String r78 = r63.a;     // Catch: Throwable -> L151
        if (r78 != null) goto L149;
        r78 = "";
    L149:
        r67 = Integer.valueOf(Color.parseColor(r78));     // Catch: Throwable -> L151
    L151:
        th = move-exception;
        Result.Companion r79 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r67 = null;
        goto L153
    L138:
        r113 = r64;
        goto L139
    L189:
        r112 = new TagTextView(r62, null, 6, 0);
        String r80 = r61.getName();
        if (r80 != null) goto L192;
        r80 = "";
    L192:
        r112.x(r80, vb8.a.d(Integer.valueOf(r61.getType())));
        goto L193
    L123:
        if (r0.isEmpty() == true) goto L126;
        r4 = false;
        goto L126
    L112:
        if (this.a.h.getVisibility() != 0) goto L114;
        boolean r81 = true;
    L115:
        if (r81 == false) goto L117;
        r47 = true;
        goto L118
    L114:
        r81 = false;
        goto L115
    L109:
        r46 = false;
        goto L110
    L103:
        r43 = null;
        goto L104
    L95:
        r40 = null;
    L105:
        this.a.h.setVisibility(8);
        goto L106
    L87:
        r38 = null;
        goto L88
    L89:
        this.a.f.setVisibility(8);
        goto L91
    L81:
        r34 = null;
        goto L83
    L77:
        r32 = 8;
        goto L78
    L71:
        if (r21.o0() == true) goto L73;
        r30 = 2131898770;
        goto L74
    L65:
        if (r21.o0() == true) goto L67;
        r27 = 2131235815;
        goto L68
    L61:
        r25 = 8;
        goto L62
    L53:
        if (com.larus.utils.o0.d(r19) != true) goto L55;
        r22 = true;
        goto L56
    L49:
        if (com.larus.utils.o0.d(r17) == false) goto L51;
        r15 = r17;
        goto L58
    L45:
        r19 = null;
    L41:
        r17 = "";
        goto L42
    L34:
        if (r13.intValue() != r14) goto L36;
        r15 = getContext().getString(2131905437);
        goto L37
    }

    public final void U3(String r3, String r4, final boolean r5) {
        ImageLoaderKt.y(this.a.d, r3, r4, new v0(r5, this), 4);
    }

    public static Unit T3(boolean r2, BotItemViewHolder r3, PipelineDraweeControllerBuilder r4, Uri r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r5, "it");
        ImageRequestBuilder r6 = ImageRequestBuilder.newBuilderWithSource(r5);
        if (r2 == false) goto L5;
        int r7 = r3.getContext().getResources().getDimensionPixelSize(v19.c.b(2130971518, r3.getContext(), 2131167405));
        r6.setResizeOptions(new ResizeOptions(r7, r7));
    L5:
        r4.setImageRequest(r6.build());
        r4.setAutoPlayAnimations(true);
        return Unit.INSTANCE;
    }
}
