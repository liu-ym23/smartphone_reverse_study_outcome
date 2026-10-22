package com.larus.search.impl.global.view;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleObserver;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.account.base.api.ILoginService;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.bean.BotOnBoarding;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.business.search.impl.databinding.LarusItemSearchResultBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.AvatarTagView;
import com.larus.common_ui.widget.TagTextView;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.im.bean.bot.ShowTagInfo;
import com.larus.im.bean.bot.TagIconInfo;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.trace.RealtimeCallEntry;
import com.larus.utils.e1;
import com.larus.utils.i;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.c3;
import v19.c;
import v19.h;
import v19.i5;
import ws9.d;
import ws9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u000223B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J \u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00152\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010&H\u0002J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0015H\u0002J\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u001c\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010*\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J$\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\u001e2\b\u00100\u001a\u0004\u0018\u00010\u001e2\u0006\u00101\u001a\u00020\u001cH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/search/impl/global/view/SearchResultItemView;", "Landroid/widget/RelativeLayout;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/business/search/impl/databinding/LarusItemSearchResultBinding;", "bindData", "", "item", "Lcom/larus/search/impl/global/model/GlobalSearchResultItem;", "position", "", "eventHelper", "Lcom/larus/search/impl/global/view/SearchResultItemView$EventHelper;", "bindBotStatus", "data", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "bindPrivateData", "privateStatus", "bindHeatData", "botStatus", "Lcom/larus/im/bean/bot/BotStatistic;", "isCreator", "", "creatorId", "", "generateTagView", "Landroid/view/View;", "showTagInfo", "Lcom/larus/im/bean/bot/ShowTagInfo;", "setupAvatarTag", "bot", "tagInfoList", "", "getSubtitle", "getTitleSpan", "Landroid/text/Spannable;", "name", "highlight", "Lcom/larus/search/impl/global/model/SearchHighlightInfo;", "processSearchHighlightInfo", "setAvatar", "url", "bizTag", "needResize", "Companion", "EventHelper", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SearchResultItemView extends RelativeLayout implements LifecycleObserver {
    public static final int b = 0;
    public final LarusItemSearchResultBinding a;

    public static final class a {
    }

    public interface b {
        void a(RecommendBot r1, int r2);

        void b(RecommendBot r1, int r2);

        void c(RecommendBot r1, int r2);

        void d(RecommendBot r1, int r2);
    }

    static {
        b = AppHost.a.getApplication().getResources().getDimensionPixelSize(c.b(2130970962, null, 2131166639));
    }

    public SearchResultItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void b(BotStatistic r4) {
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.getDisplayHeatScore();
    L7:
        if (o0.d(r1) == false) goto L12;
        this.a.h.setVisibility(0);
        this.a.i.setImageResource(2131242834);
        TextView r2 = this.a.g;
        if (r4 == null) goto L11;
        r0 = r4.getDisplayHeatScore();
    L11:
        r2.setText(r0);
        return;
    L12:
        this.a.h.setVisibility(8);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public SearchResultItemView(Context r17, AttributeSet r18) {
        Intrinsics.checkNotNullParameter(r17, "context");
        super(r17, r18);
        LayoutInflater.from(r17).inflate(2131562655, this);
        int r0 = 2131362230;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(this, 2131362230);
        if (r2 == null) goto L39;
        r0 = 2131362231;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(this, 2131362231);
        if (r3 == null) goto L39;
        r0 = 2131363623;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(this, 2131363623);
        if (r4 == null) goto L39;
        r0 = 2131363723;
        if (ViewBindings.findChildViewById(this, 2131363723) == null) goto L39;
        r0 = 2131363736;
        AvatarTagView r5 = ViewBindings.findChildViewById(this, 2131363736);
        if (r5 == null) goto L39;
        r0 = 2131364360;
        TextView r6 = (TextView) ViewBindings.findChildViewById(this, 2131364360);
        if (r6 == null) goto L39;
        r0 = 2131364368;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131364368);
        if (r7 == null) goto L39;
        r0 = 2131364369;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(this, 2131364369);
        if (r8 == null) goto L39;
        r0 = 2131364371;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(this, 2131364371);
        if (r9 == null) goto L39;
        r0 = 2131364379;
        if (ViewBindings.findChildViewById(this, 2131364379) == null) goto L39;
        r0 = 2131368849;
        TextView r10 = (TextView) ViewBindings.findChildViewById(this, 2131368849);
        if (r10 == null) goto L39;
        r0 = 2131369222;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(this, 2131369222);
        if (r11 == null) goto L39;
        r0 = 2131380593;
        TextView r12 = (TextView) ViewBindings.findChildViewById(this, 2131380593);
        if (r12 == null) goto L39;
        r0 = 2131388092;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(this, 2131388092);
        if (r13 == null) goto L39;
        r0 = 2131388462;
        if (((LinearLayout) ViewBindings.findChildViewById(this, 2131388462)) == null) goto L39;
        this.a = new LarusItemSearchResultBinding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        if (i.h(r17) == false) goto L35;
        setPadding(0, i5.r0(), i5.q(), i5.r0());
    L36:
        setBackgroundResource(2131243639);
        return;
    L35:
        setPadding(i5.q(), i5.r0(), 0, i5.r0());
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    public final void a(ws9.b r25, final int r26, final b r27) {
        if (r25 == null) goto L322;
        final RecommendBot r4 = r25.a();
        if (r4 == null) goto L324;
        BotIconImage r5 = r4.O();
        if (r5 == null) goto L10;
        String r6 = r5.getTinyUrl();
    L11:
        boolean r7 = true;
        if (o0.d(r6) == false) goto L18;
        BotIconImage r8 = r4.O();
        if (r8 == null) goto L16;
        String r9 = r8.getTinyUrl();
    L17:
        c(r9, "itg_search.avatar", false);
    L30:
        TextView r10 = this.a.l;
        CharSequence r11 = r25.a;
        if (r11 != null) goto L112;
        String r12 = r4.getName();
        if (r12 != null) goto L35;
        r12 = "";
    L35:
        List<e> r0 = r25.b();
        if (r0 == null) goto L49;
        Iterator<T> r1 = r0.iterator();
    L39:
        if (r1.hasNext() == false) goto L47;
        Object r13 = r1.next();
        e r14 = (e) r13;
        if (r14 == null) goto L43;
        String r15 = r14.a();
    L45:
        if (Intrinsics.areEqual(r15, "bot_name") == false) goto L39;
    L48:
        e r16 = (e) r13;
    L51:
        if (r12.length() != 0) goto L53;
        boolean r2 = true;
    L54:
        if (r2 == false) goto L56;
        e r3 = null;
    L93:
        SpannableStringBuilder r17 = new SpannableStringBuilder(r12);
        if (r3 == null) goto L111;
        List<d> r18 = r3.b();
        if (r18 == null) goto L111;
        List r19 = CollectionsKt.filterNotNull(r18);
        if (r19 == null) goto L111;
        Iterator r20 = r19.iterator();
    L101:
        if (r20.hasNext() == false) goto L111;
        d r21 = (d) r20.next();
        Integer r22 = r21.b();     // Catch: Exception -> L109
        if (r22 == null) goto L101;
        int r23 = r22.intValue();     // Catch: Exception -> L109
        Integer r24 = r21.a();     // Catch: Exception -> L109
        if (r24 == null) goto L101;
        r17.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), 2131103203)), r23, r24.intValue(), 17);     // Catch: Exception -> L109
    L109:
        e = move-exception;
        e.printStackTrace();
    L111:
        r11 = SpannableString.valueOf(r17);
        goto L112
    L56:
        ArrayList r28 = new ArrayList();
        int r110 = r12.codePointCount(0, r12.length());
        int r111 = r12.length();
        ListProtector.add(r28, 0, Integer.valueOf(r111));
    L57:
        if (r111 <= 0) goto L59;
        r111 = r111 - Character.charCount(r12.codePointBefore(r111));
        ListProtector.add(r28, 0, Integer.valueOf(r111));
        goto L57
    L59:
        int[] r112 = new int[r110];
        int[] r113 = new int[r110];
        int r114 = r28.size() - 1;
        int r115 = 0;
    L60:
        if (r115 >= r114) goto L70;
        Integer r116 = (Integer) CollectionsKt.getOrNull(r28, r115);
        if (r116 == null) goto L64;
        int r117 = r116.intValue();
    L65:
        r112[r115] = r117;
        int r29 = r115 + 1;
        Integer r118 = (Integer) CollectionsKt.getOrNull(r28, r29);
        if (r118 == null) goto L68;
        int r119 = r118.intValue();
    L69:
        r113[r115] = r119;
        r115 = r29;
        goto L60
    L68:
        r119 = 0;
        goto L69
    L64:
        r117 = 0;
        goto L65
    L70:
        if (r16 == null) goto L87;
        List<d> r30 = r16.b();
        if (r30 == null) goto L87;
        List r31 = CollectionsKt.filterNotNull(r30);
        if (r31 == null) goto L87;
        List r32 = r31;
        ArrayList r33 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r32, 10));
        Iterator r34 = r32.iterator();
    L77:
        if (r34.hasNext() == false) goto L89;
        d r120 = (d) r34.next();
        Integer r121 = r120.b();
        if (r121 == null) goto L81;
        int r122 = r121.intValue();
    L82:
        Integer r123 = r120.a();
        if (r123 == null) goto L85;
        int r124 = r123.intValue();
    L86:
        r33.add(new d(ArraysKt.getOrNull(r112, r122), ArraysKt.getOrNull(r113, r124)));
        goto L77
    L85:
        r124 = -1;
        goto L86
    L81:
        r122 = -1;
    L89:
        if (r16 == null) goto L91;
        String r35 = r16.a();
    L92:
        r3 = new e(r35, r33);
        goto L93
    L91:
        r35 = null;
    L87:
        r33 = null;
        goto L89
    L53:
        r2 = false;
        goto L54
    L43:
        r15 = null;
        goto L45
    L47:
        r13 = null;
        goto L48
    L49:
        r16 = null;
    L112:
        r10.setText(r11);
        TextView r36 = this.a.j;
        String r125 = r4.h();
        if (r125 == null) goto L116;
        String r37 = StringsKt.replace$default(r125, "\n", "", false, 4, null);
        if (r37 == null) goto L116;
    L117:
        BotOnBoarding r38 = r4.Y();
        if (r38 == null) goto L120;
        String r39 = r38.d();
    L122:
        if (FeatureKitDelegate.b.R().b() == true) goto L124;
    L126:
        if (r39 != null) goto L128;
    L130:
        boolean r40 = false;
    L131:
        if (r40 == false) goto L133;
        r37 = r39;
    L134:
        r36.setText(r37);
        ImageView r41 = this.a.b;
        if (r4.j0() == true) goto L137;
    L139:
        int r42 = 2131235809;
    L140:
        r41.setImageResource(r42);
        BotCreatorInfo r43 = r4.j();
        if (r43 == null) goto L143;
        String r44 = r43.getName();
    L144:
        int r45 = 8;
        if (o0.d(r44) == false) goto L151;
        this.a.f.setVisibility(0);
        TextView r46 = this.a.f;
        StringBuilder r47 = new StringBuilder("@");
        BotCreatorInfo r48 = r4.j();
        if (r48 == null) goto L149;
        String r49 = r48.getName();
    L150:
        r47.append(r49);
        r46.setText(r47.toString());
    L152:
        BotCreatorInfo r50 = r4.j();
        if (r50 == null) goto L155;
        String r51 = r50.getId();
    L156:
        if (r51 != null) goto L159;
        r51 = "";
    L159:
        if (Intrinsics.areEqual(r51, ILoginService.a.getAccountInfo().c) == false) goto L177;
        Integer r52 = r4.Z();
        if (r52 != null) goto L164;
    L165:
        if (r52 != null) goto L168;
    L170:
        b(r4.q());
    L178:
        LarusItemSearchResultBinding r53 = this.a;
        ImageView r54 = r53.k;
        if (r53.f.getVisibility() != 0) goto L181;
        boolean r55 = true;
    L182:
        if (r55 == true) goto L184;
    L189:
        boolean r56 = false;
    L190:
        if (r56 == false) goto L192;
        r45 = 0;
    L192:
        r54.setVisibility(r45);
        e1.d(this.a.b, new xs9.a(r4, r27, r26));
        e1.d(this.a.a, new xs9.b(r27, r4, r26));
        List r57 = r4.c0();
        LinearLayout r58 = this.a.m;
        List r59 = r57;
        if (r59 != null) goto L195;
    L198:
        if (r7 == false) goto L201;
        e1.o(r58);
    L277:
        ShowTagInfo r60 = AudioServiceDelegate.a.B(r4.o(), r4.r(), r57);
        if (r60 != null) goto L280;
        e1.o(this.a.e);
        return;
    L280:
        e1.x(this.a.e);
        AvatarTagView r61 = this.a.e;
        TagIconInfo r62 = r60.getIconInfo();
        if (r62 == null) goto L283;
        String r63 = r62.getLightUrl();
    L284:
        TagIconInfo r64 = r60.getIconInfo();
        if (r64 == null) goto L287;
        String r65 = r64.getDarkUrl();
    L288:
        AvatarTagView.a(r61, r63, r65);
        c3.c(RealtimeCallEntry.DISCOVER_UGC_BOTS_ICON);
        return;
    L287:
        r65 = null;
        goto L288
    L283:
        r63 = null;
        goto L284
    L201:
        e1.x(r58);
        r58.removeAllViews();
        Iterator r66 = r57.iterator();
    L203:
        if (r66.hasNext() == false) goto L277;
        ShowTagInfo r67 = (ShowTagInfo) r66.next();
        if (o0.d(r67.getNameToShow()) == false) goto L203;
        Context r68 = getContext();
        com.larus.im.bean.bot.a r69 = r67.getTagUiKit();
        if (r69 == null) goto L262;
        boolean r70 = h.a;
        boolean r210 = h.b(getContext());
        TagTextView r71 = new TagTextView(r68, null, 6, 0);
        String r72 = r67.getName();
        if (r72 != null) goto L211;
        String r73 = "";
    L212:
        Intrinsics.checkNotNullParameter(r71, "<this>");
        Intrinsics.checkNotNullParameter(r73, "tagName");
        Intrinsics.checkNotNullParameter(r69, "tagUiKit");
        Intrinsics.checkNotNullParameter(r69, "<this>");
        Result.Companion r74 = Result.Companion;     // Catch: Throwable -> L224
        if (r210 == false) goto L219;
        String r75 = r69.d;     // Catch: Throwable -> L224
        if (r75 != null) goto L218;
        r75 = "";
    L218:
        Integer r126 = Integer.valueOf(Color.parseColor(r75));     // Catch: Throwable -> L224
    L226:
        if (r126 == null) goto L228;
        int r211 = r126.intValue();
    L229:
        Intrinsics.checkNotNullParameter(r69, "<this>");
        if (r210 == true) goto L294;
        String r76 = r69.b;     // Catch: Throwable -> L240
        if (r76 != null) goto L238;
        r76 = "";
    L238:
        Integer r127 = Integer.valueOf(Color.parseColor(r76));     // Catch: Throwable -> L240
    L242:
        if (r127 == null) goto L244;
        int r212 = r127.intValue();
    L245:
        Intrinsics.checkNotNullParameter(r69, "<this>");
        if (r210 == true) goto L290;
        String r77 = r69.c;     // Catch: Throwable -> L256
        if (r77 != null) goto L254;
        r77 = "";
    L254:
        Integer r128 = Integer.valueOf(Color.parseColor(r77));     // Catch: Throwable -> L256
    L258:
        if (r128 == null) goto L260;
        int r213 = r128.intValue();
    L261:
        r71.y(r73, r210, r211, r212, r213);
        ViewGroup.MarginLayoutParams r129 = null;
    L266:
        r58.addView(r71, new ViewGroup.LayoutParams(-2, i5.A()));
        ViewGroup.LayoutParams r78 = r71.getLayoutParams();
        if (r78 == null) goto L276;
        if ((r78 instanceof ViewGroup.MarginLayoutParams) == false) goto L271;
        ViewGroup.MarginLayoutParams r79 = (ViewGroup.MarginLayoutParams) r78;
    L272:
        if (r79 == null) goto L274;
        r79.setMarginStart(i5.j0());
    L274:
        r71.setLayoutParams(r78);
        goto L203
    L271:
        r79 = r129;
        goto L272
    L276:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L260:
        r213 = 0;
        goto L261
    L290:
        String r80 = r69.f;     // Catch: Throwable -> L256
        if (r80 != null) goto L250;
        r80 = "";
    L250:
        r128 = Integer.valueOf(Color.parseColor(r80));     // Catch: Throwable -> L256
    L256:
        th = move-exception;
        Result.Companion r81 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r128 = null;
        goto L258
    L244:
        r212 = 0;
        goto L245
    L294:
        String r82 = r69.e;     // Catch: Throwable -> L240
        if (r82 != null) goto L234;
        r82 = "";
    L234:
        r127 = Integer.valueOf(Color.parseColor(r82));     // Catch: Throwable -> L240
    L240:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r127 = null;
        goto L242
    L228:
        r211 = 0;
        goto L229
    L219:
        String r83 = r69.a;     // Catch: Throwable -> L224
        if (r83 != null) goto L222;
        r83 = "";
    L222:
        r126 = Integer.valueOf(Color.parseColor(r83));     // Catch: Throwable -> L224
    L224:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r126 = null;
        goto L226
    L211:
        r73 = r72;
        goto L212
    L262:
        r129 = null;
        r71 = new TagTextView(r68, null, 6, 0);
        String r84 = r67.getName();
        if (r84 != null) goto L265;
        r84 = "";
    L265:
        r71.x(r84, vb8.a.d(Integer.valueOf(r67.getType())));
        goto L266
    L195:
        if (r59.isEmpty() == true) goto L198;
        r7 = false;
        goto L198
    L184:
        if (this.a.h.getVisibility() != 0) goto L186;
        boolean r85 = true;
    L187:
        if (r85 == false) goto L189;
        r56 = true;
        goto L190
    L186:
        r85 = false;
        goto L187
    L181:
        r55 = false;
        goto L182
    L168:
        if (r52.intValue() != 3) goto L170;
    L171:
        int r86 = r52.intValue();
        LarusItemSearchResultBinding r87 = this.a;
        if (r86 == 2) goto L176;
        if (r86 != 3) goto L178;
        r87.i.setImageResource(2131242165);
        this.a.g.setText(getContext().getString(2131897492));
        goto L178
    L176:
        r87.i.setImageResource(2131242840);
        this.a.g.setText(getContext().getString(2131911008));
        goto L178
    L164:
        if (r52.intValue() == 2) goto L171;
    L177:
        b(r4.q());
        goto L178
    L155:
        r51 = null;
        goto L156
    L149:
        r49 = null;
        goto L150
    L151:
        this.a.f.setVisibility(8);
        goto L152
    L143:
        r44 = null;
        goto L144
    L137:
        if (r4.o0() == true) goto L139;
        r42 = 2131235815;
        goto L140
    L133:
        r37 = getContext().getString(2131906312);
        Intrinsics.checkNotNull(r37);
        goto L134
    L128:
        if (o0.d(r39) != true) goto L130;
        r40 = true;
        goto L131
    L124:
        if (o0.d(r37) == false) goto L126;
    L120:
        r39 = null;
    L116:
        r37 = "";
        goto L117
    L16:
        r9 = null;
        goto L17
    L18:
        BotIconImage r88 = r4.O();
        if (r88 == null) goto L21;
        String r89 = r88.getOriginUrl();
    L23:
        if (o0.d(r89) == false) goto L29;
        BotIconImage r90 = r4.O();
        if (r90 == null) goto L27;
        String r91 = r90.getOriginUrl();
    L28:
        c(r91, "itg_search.avatar", true);
        goto L30
    L27:
        r91 = null;
        goto L28
    L29:
        c(y0.k(new Uri.Builder().scheme("res").path(String.valueOf(2131240119)).build()), null, false);
        goto L30
    L21:
        r89 = null;
        goto L23
    L10:
        r6 = null;
        goto L11
    L324:
        return;
    }

    public final void c(String r3, String r4, final boolean r5) {
        ImageLoaderKt.y(this.a.d, r3, r4, new xs9.c(r5), 4);
    }
}
