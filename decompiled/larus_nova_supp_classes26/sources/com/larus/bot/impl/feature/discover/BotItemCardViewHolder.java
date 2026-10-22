package com.larus.bot.impl.feature.discover;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.bean.BotOnBoarding;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.resp.ContentDistType;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.utils.FirstFeedSceneEnum;
import com.larus.bmhome.utils.f2;
import com.larus.bot.impl.databinding.LarusItemBotDiscoveryCardBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.z2;
import com.larus.utils.y0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\nH\u0002J$\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020\u0013H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/bot/impl/feature/discover/BotItemCardViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "Lcom/larus/bot/impl/feature/discover/IBotItemViewHolder;", "binding", "Lcom/larus/bot/impl/databinding/LarusItemBotDiscoveryCardBinding;", "<init>", "(Lcom/larus/bot/impl/databinding/LarusItemBotDiscoveryCardBinding;)V", "getBinding", "()Lcom/larus/bot/impl/databinding/LarusItemBotDiscoveryCardBinding;", "data", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "hideHotArea", "", "hideBioArea", "hideAddButton", "bindData", "", "bot", "getRootView", "Landroid/view/View;", "getAddExtView", "getSubtitle", "", "setAvatar", ShareType.URL, "bizTag", "needResize", "updateBioMaxLine", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotItemCardViewHolder extends ViewBindingHolder implements w0 {
    public final LarusItemBotDiscoveryCardBinding a;
    public final Lazy b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public static final class a {
    }

    static {
    }

    private final Context getContext() {
        return (Context) this.b.getValue();
    }

    @Override // com.larus.bot.impl.feature.discover.w0
    public final View T1() {
        return this.a.b;
    }

    @Override // com.larus.bot.impl.feature.discover.w0
    public final View getRootView() {
        return this.a.a;
    }

    public BotItemCardViewHolder(LarusItemBotDiscoveryCardBinding r5) {
        Intrinsics.checkNotNullParameter(r5, "binding");
        super(r5);
        this.a = r5;
        this.b = LazyKt.lazy(new s0(this));
        z2 r6 = z2.a;
        boolean r2 = false;
        if (r6.d0() != 2) goto L5;
        boolean r0 = true;
    L6:
        this.c = r0;
        if (r6.d0() != 3) goto L9;
        boolean r1 = true;
    L10:
        this.d = r1;
        if (r6.d0() != 1) goto L13;
        r2 = true;
    L13:
        this.e = r2;
        return;
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bot.impl.feature.discover.w0
    public final void X2(RecommendBot r12) {
        Intrinsics.checkNotNullParameter(r12, "bot");
        if (f2.a != FirstFeedSceneEnum.BOT_DISCOVERY) goto L5;
        f2.a(((RecyclerView.ViewHolder) this).itemView, "BotItemCardViewHolder");
    L5:
        BotIconImage r0 = r12.O();
        String r1 = null;
        if (r0 == null) goto L8;
        String r2 = r0.getOriginUrl();
    L9:
        final boolean r3 = true;
        final boolean r4 = false;
        if (com.larus.utils.o0.d(r2) == false) goto L16;
        BotIconImage r5 = r12.O();
        if (r5 == null) goto L14;
        String r6 = r5.getOriginUrl();
    L15:
        ImageLoaderKt.y(this.a.c, r6, "itg_list.avatar", new t0(r3, this), 4);
    L17:
        this.a.i.setText(r12.getName());
        TextView r7 = this.a.g;
        Integer r8 = r12.D();
        int r9 = ContentDistType.Aweme.getValue();
        if (r8 != null) goto L21;
    L23:
        String r10 = getContext().getString(2131906312);
    L24:
        Intrinsics.checkNotNull(r10);
        String r11 = r12.h();
        if (r11 == null) goto L28;
        String r13 = StringsKt.replace$default(r11, "\n", "", false, 4, null);
        if (r13 == null) goto L28;
    L29:
        BotOnBoarding r14 = r12.Y();
        if (r14 == null) goto L32;
        String r15 = r14.d();
    L33:
        FeatureKitDelegate r16 = FeatureKitDelegate.b;
        if (r16.R().b() == true) goto L36;
    L38:
        if (r15 != null) goto L40;
    L42:
        boolean r17 = false;
    L43:
        if (r17 == false) goto L45;
        r10 = r15;
    L45:
        r7.setText(r10);
        TextView r18 = this.a.g;
        if ((!this.d) == false) goto L48;
        int r19 = 0;
    L49:
        r18.setVisibility(r19);
        ImageView r20 = this.a.b;
        if (r12.j0() == false) goto L52;
        int r21 = 2131243584;
    L53:
        r20.setImageResource(r21);
        ImageView r22 = this.a.b;
        if ((!this.e) == false) goto L56;
        int r23 = 0;
    L57:
        r22.setVisibility(r23);
        AppCompatImageView r24 = this.a.h;
        if (z2.a.chatImmerseEnable() == true) goto L60;
    L66:
        r3 = false;
    L67:
        if (r3 == false) goto L69;
        int r25 = 0;
    L70:
        r24.setVisibility(r25);
        BotCreatorInfo r26 = r12.j();
        if (r26 == null) goto L73;
        String r27 = r26.getName();
    L75:
        if (com.larus.utils.o0.d(r27) == false) goto L81;
        this.a.d.setVisibility(0);
        TextView r28 = this.a.d;
        StringBuilder r29 = new StringBuilder("@");
        BotCreatorInfo r30 = r12.j();
        if (r30 == null) goto L79;
        String r31 = r30.getName();
    L80:
        r29.append(r31);
        r28.setText(r29.toString());
    L83:
        if (r16.b().b() == false) goto L96;
        BotStatistic r32 = r12.q();
        if (r32 == null) goto L87;
        String r33 = r32.getDisplayHeatScore();
    L89:
        if (com.larus.utils.o0.d(r33) == false) goto L96;
        if (this.c == true) goto L96;
        this.a.f.setVisibility(0);
        TextView r34 = this.a.e;
        BotStatistic r110 = r12.q();
        if (r110 == null) goto L95;
        r1 = r110.getDisplayHeatScore();
    L95:
        r34.setText(r1);
    L98:
        if (Build.VERSION.SDK_INT < 23) goto L100;
        StaticLayout r111 = StaticLayout.Builder.obtain(this.a.i.getText(), 0, this.a.i.length(), this.a.i.getPaint(), getContext().getResources().getDimensionPixelSize(v19.c.b(2130971212, getContext(), 2131166793))).build();
    L101:
        Intrinsics.checkNotNull(r111);
        this.a.g.setMaxLines(3 - Math.min(r111.getLineCount(), 2));
        if (this.d == false) goto L104;
        this.a.j.setMinimumHeight(getContext().getResources().getDimensionPixelSize(v19.c.b(2130971490, getContext(), 2131167350)));
        return;
    L104:
        this.a.j.setMinimumHeight(getContext().getResources().getDimensionPixelSize(v19.c.b(2130971527, getContext(), 2131167423)));
        return;
    L100:
        r111 = new StaticLayout(this.a.i.getText(), this.a.i.getPaint(), getContext().getResources().getDimensionPixelSize(v19.c.b(2130971212, getContext(), 2131166793)), Layout.Alignment.ALIGN_NORMAL, this.a.i.getLineSpacingMultiplier(), this.a.i.getLineSpacingExtra(), this.a.i.getIncludeFontPadding());
        goto L101
    L87:
        r33 = null;
    L96:
        this.a.f.setVisibility(8);
        goto L98
    L79:
        r31 = null;
        goto L80
    L81:
        this.a.d.setVisibility(8);
        goto L83
    L73:
        r27 = null;
        goto L75
    L69:
        r25 = 8;
        goto L70
    L60:
        if (r12.c() == false) goto L66;
        if (com.larus.utils.o0.d(r12.e()) == false) goto L66;
        if (com.larus.utils.o0.d(r12.a()) == false) goto L66;
    L56:
        r23 = 8;
        goto L57
    L52:
        r21 = 2131243583;
        goto L53
    L48:
        r19 = 8;
        goto L49
    L40:
        if (com.larus.utils.o0.d(r15) != true) goto L42;
        r17 = true;
        goto L43
    L36:
        if (com.larus.utils.o0.d(r13) == false) goto L38;
        r10 = r13;
        goto L45
    L32:
        r15 = null;
    L28:
        r13 = "";
        goto L29
    L21:
        if (r8.intValue() != r9) goto L23;
        r10 = getContext().getString(2131905437);
        goto L24
    L14:
        r6 = null;
        goto L15
    L16:
        ImageLoaderKt.y(this.a.c, y0.k(new Uri.Builder().scheme("res").path(String.valueOf(2131240119)).build()), null, new t0(r4, this), 4);
        goto L17
    L8:
        r2 = null;
        goto L9
    }

    public static Unit T3(boolean r2, BotItemCardViewHolder r3, PipelineDraweeControllerBuilder r4, Uri r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$loadImage");
        Intrinsics.checkNotNullParameter(r5, "it");
        ImageRequestBuilder r6 = ImageRequestBuilder.newBuilderWithSource(r5);
        if (r2 == false) goto L5;
        int r7 = r3.getContext().getResources().getDimensionPixelSize(v19.c.b(2130971234, r3.getContext(), 2131166837));
        r6.setResizeOptions(new ResizeOptions(r7, r7));
    L5:
        r4.setImageRequest(r6.build());
        r4.setAutoPlayAnimations(true);
        return Unit.INSTANCE;
    }
}
