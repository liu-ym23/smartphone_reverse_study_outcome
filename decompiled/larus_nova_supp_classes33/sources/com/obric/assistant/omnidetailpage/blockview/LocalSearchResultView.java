package com.obric.assistant.omnidetailpage.blockview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.auth.DeepThinkingConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.layout.widget.MessageLoading;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OSearchQueryResultBlock;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.block.search.local.adapter.SearchLocalItemAdapter;
import com.obric.assistant.card.databinding.ObricOmniBlockLocalSearchBinding;
import com.obric.assistant.omnidetailpage.blockview.base.OmniDetailVerticalLineFrameLayout;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u0001:\u0001?B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001cJ\u0006\u0010\u001e\u001a\u00020\u0018J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010 \u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0002J \u0010#\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0016H\u0002J \u0010'\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010(\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010)\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0016H\u0002J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010+\u001a\u00020\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010,\u001a\u00020\u0016H\u0002J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020\u0018H\u0002J\u001a\u00100\u001a\u00020\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u00101\u001a\u00020\u0016H\u0002J\u001e\u00102\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d04H\u0002J\u0010\u00105\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d042\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u00107\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u001dH\u0002J\u0012\u00109\u001a\u00020\u00182\b\b\u0001\u0010:\u001a\u00020\u0007H\u0002J,\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020>2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u001cH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/LocalSearchResultView;", "Lcom/obric/assistant/omnidetailpage/blockview/base/OmniDetailVerticalLineFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniBlockLocalSearchBinding;", "swipeTextViewList", "", "Lcom/larus/bmhome/chat/layout/widget/ShimmerTextView;", "switcherAdapter", "Lcom/obric/assistant/block/search/common/ObricSearchSwitcherAdapter;", "angleAnimator", "Landroid/animation/ValueAnimator;", "shineAnimator", "Landroid/animation/ObjectAnimator;", "isFold", "", "bind", "", "item", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$LocalResult;", "onItemClick", "Lkotlin/Function1;", "", "onRecycled", "initBlockView", "setDropdownExpandState", "expand", "withArrowAnimation", "setDropdownData", "searchQueryResultBlock", "Lcom/larus/im/bean/message/block/OSearchQueryResultBlock;", "isSubBlock", "setArrow", "setArrowRotation", "refreshSearchViewSearchIng", "refreshSearchViewSearchEnd", "cancelSwipeLight", "hideSwitch", "cancelMessageLoading", "startSwipeLight", "stopSwipeLight", "updateSwitcherVisible", "visible", "tryInitSwitchAdapter", "switcherList", "", "setUpTextSwitcher", "getSwitcherList", "jumpToUrl", MemorySourceLinkType.URL, "showToast", "toastTextResId", "setAskUserState", "show", "block", "Lcom/larus/im/bean/message/block/Block;", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalSearchResultView extends OmniDetailVerticalLineFrameLayout {
    public static final /* synthetic */ int h = 0;
    public final ObricOmniBlockLocalSearchBinding c;
    public final List<ShimmerTextView> d;
    public eca.c e;
    public ValueAnimator f;
    public boolean g;

    public static final class a {
    }

    static {
    }

    public LocalSearchResultView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LocalSearchResultView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void f() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ShimmerTextView) r0.next()).x();
        goto L4
    L6:
        ((ArrayList) this.d).clear();
    }

    private final void setUpTextSwitcher(final Context r3) {
        f();
        ObricOmniBlockLocalSearchBinding r0 = this.c;
        if (r0 == null) goto L7;
        TextSwitcher r1 = r0.j;
        if (r1 == null) goto L7;
        r1.removeAllViews();
    L7:
        ObricOmniBlockLocalSearchBinding r2 = this.c;
        if (r2 == null) goto L13;
        TextSwitcher r4 = r2.j;
        if (r4 == null) goto L14;
        r4.setFactory(new m(r3, this));
        return;
    L14:
        return;
    }

    public static void c(ObricOmniBlockLocalSearchBinding r0, boolean r1) {
        View r2 = r0.b;
        if (r1 == false) goto L5;
        float r3 = 0.0f;
    L6:
        r2.setRotation(r3);
        return;
    L5:
        r3 = 90.0f;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v18, types: [java.util.ArrayList] */
    public final void a(ifa.f.C0060f r29, final Function1<? super String, Unit> r30) {
        Intrinsics.checkNotNullParameter(r29, "item");
        Intrinsics.checkNotNullParameter(r30, "onItemClick");
        FLogger r3 = FLogger.a;
        r3.d("LocalResultView", "bind");
        final ObricOmniBlockLocalSearchBinding r5 = this.c;
        if (r5 != null) goto L5;
        return;
    L5:
        BlockContent r6 = r29.b.getContent();
        if (r6 == null) goto L8;
        OSearchQueryResultBlock r7 = r6.getOSearchQueryResultBlock();
    L9:
        if (r7 != null) goto L12;
        r3.w("LocalResultView", "searchQueryResultBlock == null");
        e1.o(r5.a);
        return;
    L12:
        String r8 = r7.oShownState;
        boolean r9 = true;
        if (r8 != null) goto L15;
    L18:
        boolean r10 = true;
    L19:
        if (r10 == false) goto L22;
        r3.w("LocalResultView", "no oShownState, is invalid data");
        e1.o(r5.a);
        return;
    L22:
        e1.x(r5.a);
        setShowLine(r29.c);
        boolean r11 = r29.b.isFinish();
        Boolean r12 = r7.oIsSubBlock;
        if (r12 == null) goto L25;
        boolean r13 = r12.booleanValue();
    L26:
        String r14 = r7.iconUrl;
        boolean r15 = v19.h.a;
        if (v19.h.a(null) == false) goto L39;
        String r16 = r7.iconUrlDark;
        if (r16 != null) goto L31;
    L34:
        boolean r17 = true;
    L35:
        if (r17 == true) goto L39;
        r14 = r7.iconUrlDark;
        if (r14 != null) goto L42;
    L40:
        r14 = "";
    L42:
        if (r14.length() != 0) goto L44;
        boolean r18 = true;
    L45:
        if (r18 == false) goto L47;
        r5.g.setImageResource(2131244504);
    L49:
        if (r11 == false) goto L54;
        b(r5, true);
        MessageLoading r4 = r5.i;
        r4.e.cancel();
        r4.c = false;
        e1.o(r5.i);
        e1.x(r5.n);
        TextView r19 = r5.n;
        String r110 = r7.summary;
        if (r110 != null) goto L53;
        r110 = "";
    L53:
        r19.setText(r110);
        d(false, r29.b, r30);
        String r111 = "";
    L140:
        if (Intrinsics.areEqual(r7.oShownState, "2") == false) goto L142;
        TextView r1 = r5.n;
        r1.setMaxLines(1);
        r1.setEllipsize(TextUtils.TruncateAt.END);
    L143:
        List r2 = r7.results;
        if (r2 != null) goto L146;
    L149:
        boolean r20 = true;
    L150:
        if (r20 == false) goto L152;
    L163:
        boolean r21 = false;
    L164:
        FLogger r22 = FLogger.a;
        StringBuilder r23 = new StringBuilder("item count = ");
        List r112 = r7.results;
        if (r112 == null) goto L167;
        int r113 = r112.size();
    L168:
        r23.append(r113);
        r23.append(", shownState = ");
        r23.append(r7.oShownState);
        r23.append(", isFinish = ");
        r23.append(r11);
        r23.append(", isSubBlock = ");
        r23.append(r13);
        r22.d("LocalResultView", r23.toString());
        if (r21 == false) goto L208;
        e1.x(r5.b);
        e(r5, !this.g, false);
        Context r24 = r5.a.getContext();
        String r25 = r24.getString(2131912082);
        String r26 = r24.getString(2131912105);
        List r27 = r7.queries;
        if (r27 == null) goto L185;
        ArrayList r28 = new ArrayList();
        Iterator r31 = r27.iterator();
    L174:
        if (r31.hasNext() == false) goto L181;
        String r32 = (String) r31.next();
        if (r32 == null) goto L178;
        StringCompanionObject r33 = StringCompanionObject.INSTANCE;
        String r34 = String.format(r25, Arrays.copyOf(new Object[]{r32}, 1));
    L179:
        if (r34 == null) goto L174;
        r28.add(r34);
        goto L174
    L178:
        r34 = null;
        goto L179
    L181:
        String r35 = CollectionsKt.joinToString$default(r28, r26, null, null, 0, null, null, 62, null);
        if (r35 == null) goto L185;
        String r114 = r35;
    L186:
        r5.m.setText(r114);
        if (r114.length() == 0) goto L190;
        r9 = false;
    L190:
        if (r9 == false) goto L192;
        e1.o(r5.m);
    L193:
        SearchLocalItemAdapter r36 = r5.h.getAdapter();
        if ((r36 instanceof SearchLocalItemAdapter) == false) goto L196;
        SearchLocalItemAdapter r37 = r36;
    L197:
        if (r37 == null) goto L203;
        List r38 = r7.results;
        if (r38 == null) goto L201;
        List r39 = CollectionsKt.filterNotNull(r38);
    L202:
        r37.y2(r39, r13);
        goto L203
    L201:
        r39 = null;
    L203:
        e1.d(r5.k, new n(this, r5, r30));
        View r40 = r5.e;
        if (r13 == false) goto L206;
        int r41 = 0;
    L207:
        r40.setVisibility(r41);
    L222:
        if (r13 == false) goto L228;
        e1.x(r5.g);
        r5.d.getDelegate().a(ContextCompat.getColor(r5.a.getContext(), 2131100494));
        RelativeLayout r42 = r5.a;
        ViewGroup.LayoutParams r43 = r42.getLayoutParams();
        if (r43 == null) goto L227;
        ViewGroup.MarginLayoutParams r44 = (ViewGroup.MarginLayoutParams) r43;
        r44.leftMargin = i5.q();
        r44.rightMargin = i5.q();
        r42.setLayoutParams(r44);
        LinearLayout r45 = r5.k;
        r45.setPadding(0, r45.getPaddingTop(), i5.c(), r45.getPaddingBottom());
        we8.a.b(r5.n, i5.m(), false, null, null, 12);
        TextView r46 = r5.m;
        r46.setPadding(i5.h(), r46.getPaddingTop(), i5.h(), r46.getPaddingBottom());
        RelativeLayout r47 = r5.f;
        r47.setPadding(r47.getPaddingLeft(), r47.getPaddingTop(), r47.getPaddingRight(), i5.v0());
    L231:
        we8.a.b(r5.m, i5.o(), false, null, null, 12);
        return;
    L227:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L228:
        e1.o(r5.g);
        r5.d.getDelegate().a(0);
        RelativeLayout r48 = r5.a;
        ViewGroup.LayoutParams r49 = r48.getLayoutParams();
        if (r49 == null) goto L234;
        ViewGroup.MarginLayoutParams r50 = (ViewGroup.MarginLayoutParams) r49;
        r50.leftMargin = 0;
        r50.rightMargin = 0;
        r50.topMargin = i5.r0();
        r50.bottomMargin = i5.r0();
        r48.setLayoutParams(r50);
        LinearLayout r51 = r5.k;
        r51.setPadding(i5.q(), r51.getPaddingTop(), i5.q(), r51.getPaddingBottom());
        we8.a.b(r5.n, i5.t(), false, null, null, 12);
        TextView r52 = r5.m;
        r52.setPadding(i5.q(), r52.getPaddingTop(), i5.q(), r52.getPaddingBottom());
        RelativeLayout r53 = r5.f;
        r53.setPadding(r53.getPaddingLeft(), r53.getPaddingTop(), r53.getPaddingRight(), 0);
        goto L231
    L234:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L206:
        r41 = 4;
        goto L207
    L196:
        r37 = null;
        goto L197
    L192:
        e1.x(r5.m);
    L185:
        r114 = r111;
        goto L186
    L208:
        ValueAnimator r54 = this.f;
        if (r54 == null) goto L211;
        r54.cancel();
    L211:
        this.f = null;
        c(r5, true);
        e1.o(r5.b);
        e1.o(r5.f);
        r5.k.setOnClickListener(null);
        String r55 = r7.oJumpUrl;
        if (r55 != null) goto L214;
        final String r115 = r111;
    L216:
        if (Intrinsics.areEqual(r7.oShownState, "1") == true) goto L218;
    L220:
        e1.o(r5.b);
        r5.k.setOnClickListener(null);
        goto L222
    L218:
        if (com.larus.utils.o0.d(r115) == false) goto L220;
        e1.x(r5.b);
        e1.d(r5.k, new o(r30, this, r5, r115));
        goto L222
    L214:
        r115 = r55;
        goto L216
    L167:
        r113 = 0;
        goto L168
    L152:
        if (Intrinsics.areEqual(r7.oShownState, "2") == true) goto L161;
        String r56 = r7.oShownState;
        if (r56 != null) goto L156;
    L159:
        boolean r57 = true;
    L160:
        if (r57 == false) goto L163;
    L156:
        if (r56.length() == 0) goto L159;
        r57 = false;
    L161:
        if (r11 == false) goto L163;
        r21 = true;
        goto L164
    L146:
        if (r2.isEmpty() == true) goto L149;
        r20 = false;
        goto L150
    L142:
        TextView r58 = r5.n;
        r58.setMaxLines(2);
        r58.setEllipsize(TextUtils.TruncateAt.END);
        goto L143
    L54:
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r116 = r7.oClickAction;
        r111 = "";
        if (r116 != null) goto L57;
    L59:
        boolean r117 = false;
    L60:
        if (r117 == true) goto L62;
    L64:
        boolean r118 = false;
    L65:
        if (r118 == false) goto L67;
        b(r5, true);
        MessageLoading r59 = r5.i;
        r59.e.cancel();
        r59.c = false;
        e1.o(r5.i);
        e1.o(r5.n);
        d(true, r29.b, r30);
        goto L140
    L67:
        Boolean r119 = r7.oHasNotAnimation;
        if (r119 == null) goto L70;
        boolean r120 = r119.booleanValue();
    L71:
        if (r120 == false) goto L73;
    L135:
        r3.i("LocalResultView", "oHasNotAnimation = true");
        b(r5, true);
        MessageLoading r60 = r5.i;
        r60.e.cancel();
        r60.c = false;
        e1.o(r5.i);
        e1.x(r5.n);
        TextView r61 = r5.n;
        String r62 = r7.summary;
        if (r62 != null) goto L138;
        r62 = r111;
    L138:
        r61.setText(r62);
        d(false, r29.b, r30);
        goto L140
    L73:
        if (r29.d == false) goto L135;
        List r63 = r7.queries;
        if (r63 == null) goto L88;
        List r64 = CollectionsKt.filterNotNull(r63);
        if (r64 == null) goto L88;
        List r121 = new ArrayList();
        Iterator r65 = r64.iterator();
    L81:
        if (r65.hasNext() == false) goto L89;
        String r210 = (String) r65.next();
        String r122 = r7.summary;
        if (r122 == null) goto L85;
        String r123 = StringsKt.replace$default(r122, "%s", r210, false, 4, null);
    L86:
        if (r123 == null) goto L81;
        r121.add(r123);
        goto L81
    L85:
        r123 = null;
    L89:
        if (r121 != 0) goto L91;
    L94:
        boolean r66 = true;
    L95:
        if (r66 == false) goto L103;
        String r67 = r7.summary;
        if (r67 == null) goto L99;
        String r68 = StringsKt.replace$default(r67, "\n", "", false, 4, null);
    L100:
        if (r68 != null) goto L102;
        r68 = r111;
    L102:
        r121 = CollectionsKt.listOf(r68);
        goto L103
    L99:
        r68 = null;
    L103:
        if (r13 == false) goto L130;
        MessageLoading r69 = r5.i;
        r69.e.cancel();
        r69.c = false;
        e1.o(r5.i);
        eca.c r70 = this.e;
        if (r70 == null) goto L107;
        List r124 = r70.b;
    L108:
        if (r124 == null) goto L116;
        if (r70 == null) goto L111;
        List r71 = r70.b;
    L113:
        if (Intrinsics.areEqual(r121, r71) == true) goto L116;
        b(r5, false);
        FLogger.a.i("LocalResultView", "is change to " + r121);
        goto L116
    L111:
        r71 = null;
    L116:
        if (this.e != null) goto L121;
        setUpTextSwitcher(r5.a.getContext());
        eca.c r72 = new eca.c(r5.j, r121);
        this.e = r72;
        r72.a(r5.a.getContext());
        eca.c r73 = this.e;
        if (r73 == null) goto L120;
        r73.c();
    L120:
        boolean r74 = true;
    L122:
        if (r74 == false) goto L127;
        Iterator r75 = ((ArrayList) this.d).iterator();
    L125:
        if (r75.hasNext() == false) goto L127;
        ShimmerTextView r76 = (ShimmerTextView) r75.next();
        int r125 = ShimmerTextView.h;
        r76.z(false);
    L127:
        TextSwitcher r77 = r5.j;
        if (r77 == null) goto L131;
        r77.setVisibility(0);
    L131:
        e1.o(r5.n);
        TextView r78 = r5.n;
        String r79 = r7.summary;
        if (r79 != null) goto L134;
        r79 = r111;
    L134:
        r78.setText(r79);
        d(false, r29.b, r30);
        goto L140
    L121:
        r74 = false;
        goto L122
    L107:
        r124 = null;
        goto L108
    L130:
        b(r5, true);
        e1.x(r5.i);
        r5.i.setLoadingText(CollectionsKt.joinToString$default(r121, String.valueOf(r5.a.getContext().getString(2131912105)), null, null, 0, null, null, 62, null));
        r5.i.c();
        goto L131
    L91:
        if (r121.isEmpty() == true) goto L94;
        r66 = false;
    L88:
        r121 = 0;
        goto L89
    L70:
        r120 = false;
        goto L71
    L62:
        if (Intrinsics.areEqual(r7.oShownState, "1") == false) goto L64;
        r118 = true;
        goto L65
    L57:
        if (StringsKt.contains$default(r116, "finish_current_page", false, 2, null) != true) goto L59;
        r117 = true;
        goto L60
    L47:
        com.obric.assistant.card.utils.h.a(r5.g, r14, "obric_chat.cards");
        goto L49
    L44:
        r18 = false;
        goto L45
    L31:
        if (r16.length() == 0) goto L34;
        r17 = false;
    L39:
        if (r14 != null) goto L42;
    L25:
        r13 = false;
        goto L26
    L15:
        if (r8.length() == 0) goto L18;
        r10 = false;
        goto L19
    L8:
        r7 = null;
        goto L9
    }

    public final void b(ObricOmniBlockLocalSearchBinding r2, boolean r3) {
        eca.c r0 = this.e;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.e = null;
        f();
        if (r3 == false) goto L12;
        if (r2 == null) goto L13;
        TextSwitcher r4 = r2.j;
        if (r4 == null) goto L14;
        r4.setVisibility(8);
        return;
    L14:
        return;
    L13:
        return;
    }

    public LocalSearchResultView(Context r24, AttributeSet r25, int r26) {
        Intrinsics.checkNotNullParameter(r24, "context");
        super(r24, r25, r26);
        ArrayList r1 = new ArrayList();
        this.d = r1;
        com.larus.bmhome.chat.api.e0 r3 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r3 == null) goto L9;
        LaunchInfo r4 = r3.a;
        if (r4 == null) goto L9;
        DeepThinkingConfig r5 = r4.S();
        if (r5 == null) goto L9;
        boolean r6 = r5.b();
    L10:
        this.g = r6;
        View r2 = LayoutInflater.from(r24).inflate(2131564039, this, false);
        addView(r2);
        int r7 = 2131363236;
        View r8 = ViewBindings.findChildViewById(r2, 2131363236);
        if (r8 == null) goto L41;
        r7 = 2131363252;
        ShimmerLinearLayout r9 = ViewBindings.findChildViewById(r2, 2131363252);
        if (r9 == null) goto L41;
        r7 = 2131367728;
        RoundRelativeLayout r10 = ViewBindings.findChildViewById(r2, 2131367728);
        if (r10 == null) goto L41;
        r7 = 2131369197;
        View r11 = ViewBindings.findChildViewById(r2, 2131369197);
        if (r11 == null) goto L41;
        r7 = 2131370361;
        RelativeLayout r12 = (RelativeLayout) ViewBindings.findChildViewById(r2, 2131370361);
        if (r12 == null) goto L41;
        r7 = 2131374718;
        SimpleDraweeView r13 = ViewBindings.findChildViewById(r2, 2131374718);
        if (r13 == null) goto L41;
        r7 = 2131375799;
        RecyclerView r15 = ViewBindings.findChildViewById(r2, 2131375799);
        if (r15 == null) goto L41;
        r7 = 2131379999;
        MessageLoading r16 = ViewBindings.findChildViewById(r2, 2131379999);
        if (r16 == null) goto L41;
        r7 = 2131384507;
        if (ViewBindings.findChildViewById(r2, 2131384507) == null) goto L41;
        r7 = 2131385562;
        TextSwitcher r17 = (TextSwitcher) ViewBindings.findChildViewById(r2, 2131385562);
        if (r17 == null) goto L41;
        r7 = 2131388881;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r2, 2131388881);
        if (r18 == null) goto L41;
        r7 = 2131389999;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r2, 2131389999);
        if (r19 == null) goto L41;
        r7 = 2131391234;
        TextView r20 = (TextView) ViewBindings.findChildViewById(r2, 2131391234);
        if (r20 == null) goto L41;
        r7 = 2131391606;
        TextView r21 = (TextView) ViewBindings.findChildViewById(r2, 2131391606);
        if (r21 == null) goto L41;
        RelativeLayout r14 = (RelativeLayout) r2;
        this.c = new ObricOmniBlockLocalSearchBinding(r14, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        r15.setLayoutManager(new LinearLayoutManager(r14.getContext(), 1, false));
        r15.setAdapter(new SearchLocalItemAdapter());
        r1.clear();
        this.e = null;
        int r22 = com.larus.utils.j0.a;
        setPadding(com.larus.utils.j0.b(2131166112), 0, 0, com.larus.utils.j0.b(2131166264));
        return;
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r7)));
    L9:
        r6 = true;
        goto L10
    }

    public final void d(boolean r4, final Block r5, final Function1<? super String, Unit> r6) {
        if (r4 == false) goto L44;
        BlockContent r7 = r5.getContent();
        if (r7 == null) goto L6;
        final OSearchQueryResultBlock r8 = r7.getOSearchQueryResultBlock();
    L7:
        ObricOmniBlockLocalSearchBinding r1 = this.c;
        if (r1 == null) goto L12;
        ShimmerLinearLayout r2 = r1.c;
        if (r2 == null) goto L12;
        e1.x(r2);
    L12:
        ObricOmniBlockLocalSearchBinding r3 = this.c;
        if (r3 == null) goto L22;
        TextView r9 = r3.l;
        if (r9 == null) goto L22;
        if (r8 == null) goto L18;
        String r10 = r8.summary;
    L19:
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        r9.setText(r10);
        goto L22
    L18:
        r10 = null;
    L22:
        ObricOmniBlockLocalSearchBinding r11 = this.c;
        if (r11 == null) goto L27;
        ShimmerLinearLayout r12 = r11.c;
        if (r12 == null) goto L27;
        e1.d(r12, new p(r6, this, r8, r5));
    L27:
        ObricOmniBlockLocalSearchBinding r13 = this.c;
        if (r13 == null) goto L32;
        ShimmerLinearLayout r14 = r13.c;
        if (r14 == null) goto L32;
        r14.b();
    L32:
        boolean r15 = v19.h.a;
        if (v19.h.a(null) == false) goto L39;
        ObricOmniBlockLocalSearchBinding r16 = this.c;
        if (r16 == null) goto L55;
        ShimmerLinearLayout r17 = r16.c;
        if (r17 == null) goto L56;
        r17.setShimmerColor(ContextCompat.getColor(getContext(), 2131100494));
        return;
    L56:
        return;
    L55:
        return;
    L39:
        ObricOmniBlockLocalSearchBinding r18 = this.c;
        if (r18 == null) goto L58;
        ShimmerLinearLayout r19 = r18.c;
        if (r19 == null) goto L59;
        r19.setShimmerColor(ContextCompat.getColor(getContext(), 2131100492));
        return;
    L59:
        return;
    L58:
        return;
    L6:
        r8 = null;
        goto L7
    L44:
        ObricOmniBlockLocalSearchBinding r20 = this.c;
        if (r20 == null) goto L49;
        ShimmerLinearLayout r21 = r20.c;
        if (r21 == null) goto L49;
        r21.a();
    L49:
        ObricOmniBlockLocalSearchBinding r22 = this.c;
        if (r22 == null) goto L61;
        ShimmerLinearLayout r23 = r22.c;
        if (r23 == null) goto L62;
        e1.o(r23);
        return;
    L62:
        return;
    }

    public final void e(final ObricOmniBlockLocalSearchBinding r5, boolean r6, boolean r7) {
        FLogger.a.d("LocalResultView", "setDropdownExpandState: expand = " + r6 + ", withArrowAnimation = " + r7);
        if (r6 == false) goto L5;
        e1.x(r5.f);
    L6:
        boolean r8 = !r6;
        ValueAnimator r1 = this.f;
        if (r1 == null) goto L9;
        r1.cancel();
        this.f = null;
    L9:
        if (r7 == false) goto L15;
        float r9 = 90.0f;
        float r2 = 0.0f;
        if (r8 == true) goto L14;
        r9 = 0.0f;
        r2 = 90.0f;
    L14:
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{r9, r2});
        this.f = r10;
        r10.setDuration(150);
        r10.addUpdateListener(new q(r5));
        r10.addListener(new s(this, r5, r8));
        r10.start();
        return;
    L15:
        c(r5, r8);
        return;
    L5:
        e1.o(r5.f);
        goto L6
    }

    public /* synthetic */ LocalSearchResultView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
