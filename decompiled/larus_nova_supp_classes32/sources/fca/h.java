package fca;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.auth.DeepThinkingConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.layout.widget.MessageLoading;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.OSearchQueryResultBlock;
import com.larus.im.bean.message.block.OSearchReference;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.RiskPreferenceSettings;
import com.obric.assistant.block.search.local.adapter.SearchLocalItemAdapter;
import com.obric.assistant.card.databinding.ObricBlockLocalSearchBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h extends uba.a<fca.a> {
    public ObricBlockLocalSearchBinding d;
    public final List<ShimmerTextView> e;
    public eca.c f;
    public ValueAnimator g;
    public ValueAnimator h;
    public int i;
    public float j;
    public boolean k;
    public final Lazy l;
    public boolean m;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ h a;
        public final /* synthetic */ ObricBlockLocalSearchBinding b;
        public final /* synthetic */ boolean c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationCancel(r2);
            this.a.g = null;
            h.m(this.b, this.c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            this.a.g = null;
            h.m(this.b, this.c);
        }

        public b(h r1, ObricBlockLocalSearchBinding r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ h b;
        public final /* synthetic */ ObricBlockLocalSearchBinding c;
        public final /* synthetic */ RoundRelativeLayout d;

        public c(RoundRelativeLayout r1, h r2, ObricBlockLocalSearchBinding r3, RoundRelativeLayout r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h r0 = this.b;     // Catch: Throwable -> L15
            Integer r1 = Integer.valueOf(this.c.j.getWidth());     // Catch: Throwable -> L15
            if (r1.intValue() <= 0) goto L5;
            boolean r2 = true;
        L7:
            if (Boolean.valueOf(r2).booleanValue() == true) goto L10;
            r1 = null;
        L10:
            if (r1 == null) goto L12;
            int r3 = r1.intValue();     // Catch: Throwable -> L15
        L13:
            r0.i = r3;     // Catch: Throwable -> L15
            this.d.invalidateOutline();     // Catch: Throwable -> L15
            return;
        L12:
            r3 = this.d.getWidth();     // Catch: Throwable -> L15
            goto L13
        L5:
            r2 = false;
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L19;
            return;
        L19:
            throw th;
        }
    }

    public static final class d implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ RoundRelativeLayout a;
        public final /* synthetic */ RelativeLayout b;
        public final /* synthetic */ RecyclerView c;
        public final /* synthetic */ ObricBlockLocalSearchBinding d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ h f;

        public static final class a extends AnimatorListenerAdapter {
            public final /* synthetic */ h a;
            public final /* synthetic */ RelativeLayout b;
            public final /* synthetic */ RecyclerView c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ RoundRelativeLayout e;
            public final /* synthetic */ int f;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r4) {
                Intrinsics.checkNotNullParameter(r4, "animation");
                this.a.h = null;
                RelativeLayout r5 = this.b;
                ViewGroup.LayoutParams r0 = r5.getLayoutParams();
                if (r0 == null) goto L14;
                r0.height = -2;
                r5.setLayoutParams(r0);
                RecyclerView r6 = this.c;
                ViewGroup.LayoutParams r1 = r6.getLayoutParams();
                if (r1 == null) goto L12;
                r1.height = -2;
                r6.setLayoutParams(r1);
                if (this.d == false) goto L9;
                this.e.setClipToOutline(false);
                this.a.i = 0;
                return;
            L9:
                e1.o(this.b);
                h r7 = this.a;
                r7.i = this.f;
                this.e.invalidateOutline();
                return;
            L12:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            L14:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }

            public a(h r1, RelativeLayout r2, RecyclerView r3, boolean r4, RoundRelativeLayout r5, int r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            int r1 = this.b.getHeight();
            int r2 = this.c.getHeight();
            Integer r3 = Integer.valueOf(this.d.j.getWidth());
            if (r3.intValue() <= 0) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == true) goto L9;
            r3 = null;
        L9:
            if (r3 == null) goto L11;
            int r5 = r3.intValue();
        L12:
            int r12 = r5;
            int r6 = this.a.getWidth();
            boolean r7 = this.e;
            if (r7 == false) goto L15;
            int r8 = r12;
        L16:
            if (r7 == false) goto L18;
            final int r17 = r6;
        L19:
            if (r7 == false) goto L21;
            int r9 = 0;
        L22:
            if (r7 == false) goto L24;
            final int r20 = r1;
        L26:
            if (r2 <= 0) goto L32;
            RecyclerView r10 = this.c;
            ViewGroup.LayoutParams r11 = r10.getLayoutParams();
            if (r11 == null) goto L31;
            r11.height = r2;
            r10.setLayoutParams(r11);
            goto L32
        L31:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L32:
            RelativeLayout r13 = this.b;
            ViewGroup.LayoutParams r14 = r13.getLayoutParams();
            if (r14 == null) goto L40;
            r14.height = r9;
            r13.setLayoutParams(r14);
            this.f.i = r8;
            this.a.invalidateOutline();
            ValueAnimator r15 = this.f.h;
            if (r15 == null) goto L37;
            r15.cancel();
        L37:
            h r16 = this.f;
            ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            final RelativeLayout r19 = this.b;
            final h r21 = this.f;
            final RoundRelativeLayout r110 = this.a;
            RecyclerView r22 = this.c;
            boolean r111 = this.e;
            r18.setDuration(150);
            final int r112 = r8;
            final int r113 = r9;
            r18.addUpdateListener(new j(r19, r21, r112, r17, r110, r113, r20));
            r18.addListener(new a(r21, r19, r22, r111, r110, r12));
            r18.start();
            r16.h = r18;
            return false;
        L40:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L24:
            r20 = 0;
            goto L26
        L21:
            r9 = r1;
            goto L22
        L18:
            r17 = r12;
            goto L19
        L15:
            r8 = r6;
            goto L16
        L11:
            r5 = this.a.getWidth();
            goto L12
        L5:
            r4 = false;
            goto L6
        }

        public d(RoundRelativeLayout r1, RelativeLayout r2, RecyclerView r3, ObricBlockLocalSearchBinding r4, boolean r5, h r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
    }

    public final void i() {
        FLogger.a.d("LocalSearchBlockHolder", "onViewRecycled");
        k(this.d, true);
    }

    public final void p() {
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ShimmerTextView) r0.next()).x();
        goto L4
    L6:
        ((ArrayList) this.e).clear();
    }

    public h() {
        this.e = new ArrayList();
        this.l = LazyKt.lazy(new fca.d());
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L9;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L9;
        DeepThinkingConfig r2 = r1.S();
        if (r2 == null) goto L9;
        boolean r3 = r2.b();
    L10:
        this.m = r3;
        return;
    L9:
        r3 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v39, types: [java.util.ArrayList] */
    public final void g(jc8.a r24) {
        fca.a r1 = (fca.a) r24;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        final ObricBlockLocalSearchBinding r2 = this.d;
        if (r2 == null) goto L363;
        Message r3 = r1.j();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Map r4 = r3.getExt();
        if (r4 == null) goto L8;
        String r5 = (String) r4.get("o_did");
    L9:
        final String r6 = NameKeys.UnloadStrategy_No_Strategy;
        if (r5 != null) goto L13;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        if (Intrinsics.areEqual(r5, (String) this.l.getValue()) == true) goto L15;
        e1.o(r2.a);
        FLogger.a.i("LocalSearchBlockHolder", "is not this device msg: did = " + ((String) this.l.getValue()) + ", msgDid = " + r5);
        return;
    L15:
        BlockContent r7 = ((jc8.a) r1).a.getContent();
        if (r7 == null) goto L18;
        OSearchQueryResultBlock r8 = r7.getOSearchQueryResultBlock();
    L19:
        if (r8 != null) goto L21;
        FLogger.a.w("LocalSearchBlockHolder", "searchQueryResultBlock == null");
        e1.o(r2.a);
        return;
    L21:
        String r9 = r8.oShownState;
        if (r9 != null) goto L24;
    L27:
        boolean r10 = true;
    L28:
        if (r10 == false) goto L30;
        FLogger.a.w("LocalSearchBlockHolder", "no oShownState, is invalid data");
        e1.o(r2.a);
        return;
    L30:
        e1.x(r2.a);
        boolean r11 = ((jc8.a) r1).a.isFinish();
        Boolean r12 = r8.oIsSubBlock;
        if (r12 == null) goto L33;
        final boolean r13 = r12.booleanValue();
    L34:
        FLogger r14 = FLogger.a;
        r14.d("LocalSearchBlockHolder", "onBindBlockView: isFinish = " + r11 + ", isSubBlock = " + r13 + ", messageStatusLocal = " + r1.j().getMessageStatusLocal());
        String r15 = r8.iconUrl;
        boolean r16 = v19.h.a;
        if (v19.h.a(null) == false) goto L47;
        String r17 = r8.iconUrlDark;
        if (r17 != null) goto L39;
    L42:
        boolean r18 = true;
    L43:
        if (r18 == true) goto L47;
        r15 = r8.iconUrlDark;
        if (r15 != null) goto L50;
    L48:
        r15 = NameKeys.UnloadStrategy_No_Strategy;
    L50:
        if (r15.length() != 0) goto L52;
        boolean r19 = true;
    L54:
        if (r19 == false) goto L56;
    L62:
        ViewGroup.LayoutParams r20 = r2.f.getLayoutParams();
        if (r20 == null) goto L65;
        r20.width = i5.v();
        r20.height = i5.v();
        Unit r21 = Unit.INSTANCE;
    L65:
        r2.f.setImageResource(2131244491);
    L66:
        boolean r22 = !Intrinsics.areEqual(r8.iconUrl, "https://decode/tool_icon/Search.png");
        this.k = r22;
        if (r22 == true) goto L71;
        Intrinsics.checkNotNull(r2.a.getContext().getString(2131912239));
    L71:
        if (r11 == false) goto L73;
    L151:
        k(r2, true);
        MessageLoading r110 = r2.h;
        r110.e.cancel();
        r110.c = false;
        e1.o(r2.h);
        e1.x(r2.l);
        TextView r111 = r2.l;
        String r112 = r8.summary;
        if (r112 != null) goto L154;
        r112 = NameKeys.UnloadStrategy_No_Strategy;
    L154:
        r111.setText(r112);
    L155:
        List r113 = r8.results;
        if (r113 != null) goto L158;
    L161:
        boolean r114 = true;
    L162:
        if (r114 == false) goto L164;
    L175:
        boolean r115 = false;
    L176:
        FLogger r116 = FLogger.a;
        StringBuilder r117 = new StringBuilder("item count = ");
        List r118 = r8.results;
        if (r118 == null) goto L179;
        int r119 = r118.size();
    L180:
        r117.append(r119);
        r117.append(", shownState = ");
        r117.append(r8.oShownState);
        r117.append(", isFinish = ");
        r117.append(r11);
        r117.append(", isSubBlock = ");
        r117.append(r13);
        r116.d("LocalSearchBlockHolder", r117.toString());
        if (r115 == false) goto L266;
        e1.x(r2.b);
        o(r2, !this.m, false);
        Context r23 = r2.a.getContext();
        if (this.k == false) goto L206;
        String r25 = r23.getString(2131912082);
        String r120 = r23.getString(2131912105);
        List r26 = r8.queries;
        if (r26 == null) goto L199;
        ArrayList r121 = new ArrayList();
        Iterator r27 = r26.iterator();
    L188:
        if (r27.hasNext() == false) goto L195;
        String r28 = (String) r27.next();
        if (r28 == null) goto L192;
        StringCompanionObject r122 = StringCompanionObject.INSTANCE;
        String r29 = String.format(r25, Arrays.copyOf(new Object[]{r28}, 1));
    L193:
        if (r29 == null) goto L188;
        r121.add(r29);
        goto L188
    L192:
        r29 = null;
        goto L193
    L195:
        String r30 = CollectionsKt.joinToString$default(r121, r120, null, null, 0, null, null, 62, null);
        if (r30 == null) goto L199;
        r6 = r30;
    L199:
        r2.k.setText(r6);
        if (r6.length() != 0) goto L202;
        boolean r31 = true;
    L203:
        if (r31 == false) goto L205;
        e1.o(r2.k);
        goto L206
    L205:
        e1.x(r2.k);
        goto L206
    L202:
        r31 = false;
    L206:
        RecyclerView.Adapter r32 = r2.g.getAdapter();
        if ((r32 instanceof SearchLocalItemAdapter) == false) goto L209;
        SearchLocalItemAdapter r33 = (SearchLocalItemAdapter) r32;
    L210:
        if (r33 == null) goto L216;
        List r34 = r8.results;
        if (r34 == null) goto L214;
        List<OSearchReference> r35 = CollectionsKt.filterNotNull(r34);
    L215:
        r33.y2(r35, r13);
        goto L216
    L214:
        r35 = null;
    L216:
        e1.d(r2.j, new fca.b(this, r2, r13));
        Lazy r36 = gca.c.a;
        RelativeLayout r37 = r2.a;
        Intrinsics.checkNotNullParameter(r37, "blockView");
        Intrinsics.checkNotNullParameter(r1, "baseBlockBizModel");
        boolean r38 = r1.m();
        boolean r39 = r1.n();
        ViewGroup.LayoutParams r40 = r37.getLayoutParams();
        if ((r40 instanceof ViewGroup.MarginLayoutParams) == false) goto L219;
        ViewGroup.MarginLayoutParams r41 = (ViewGroup.MarginLayoutParams) r40;
    L220:
        jc8.a r42 = r1.k();
        if (r42 == null) goto L225;
        Block r43 = r42.a;
        if (r43 == null) goto L225;
        Integer r44 = Integer.valueOf(r43.getBlockType());
    L226:
        int r45 = ((jc8.a) r1).a.getBlockType();
        int r123 = BlockType.BLOCK_TYPE_TEXT.getValue();
        if (r44 != null) goto L230;
    L231:
        boolean r124 = true;
    L233:
        if (r41 == null) goto L259;
        if (r38 == false) goto L236;
        int r46 = i5.h();
    L249:
        if (r39 == true) goto L251;
        int r47 = 0;
    L253:
        if (r41.bottomMargin == r47) goto L256;
        r41.bottomMargin = r47;
        r37.setLayoutParams(r41);
    L256:
        if (r41.topMargin == r46) goto L259;
        r41.topMargin = r46;
        r37.setLayoutParams(r41);
        goto L259
    L251:
        r47 = i5.q();
        goto L253
    L236:
        if (r124 == false) goto L248;
        Set<Integer> r48 = gca.c.c;
        if (CollectionsKt.contains(r48, r44) == true) goto L240;
    L242:
        Set<Integer> r49 = gca.c.d;
        if (CollectionsKt.contains(r49, r44) == true) goto L245;
    L247:
        r46 = i5.q();
        goto L249
    L245:
        if (r49.contains(Integer.valueOf(r45)) == false) goto L247;
        r46 = i5.h();
        goto L249
    L240:
        if (r48.contains(Integer.valueOf(r45)) == false) goto L242;
        r46 = i5.v0();
        goto L249
    L248:
        r46 = 0;
    L259:
        if (this.k == false) goto L265;
        View r50 = r2.d;
        if (r13 == false) goto L263;
        int r51 = 0;
    L264:
        r50.setVisibility(r51);
    L280:
        if (this.k == false) goto L311;
        RelativeLayout r52 = r2.e;
        ViewGroup.LayoutParams r53 = r52.getLayoutParams();
        if (r53 == null) goto L309;
        r53.width = -1;
        r52.setLayoutParams(r53);
        RecyclerView r54 = r2.g;
        ViewGroup.LayoutParams r55 = r54.getLayoutParams();
        if (r55 == null) goto L307;
        r55.width = -1;
        r54.setLayoutParams(r55);
        r2.c.getDelegate().e(i5.r0());
        TextView r56 = r2.l;
        ViewGroup.LayoutParams r57 = r56.getLayoutParams();
        if (r57 == null) goto L305;
        ViewGroup.MarginLayoutParams r58 = (ViewGroup.MarginLayoutParams) r57;
        r58.setMarginStart(0);
        r56.setLayoutParams(r58);
        SimpleDraweeView r59 = r2.f;
        ViewGroup.LayoutParams r60 = r59.getLayoutParams();
        if (r60 == null) goto L303;
        r60.width = i5.J();
        r60.height = i5.J();
        r59.setLayoutParams(r60);
        LinearLayout r61 = r2.j;
        ViewGroup.LayoutParams r62 = r61.getLayoutParams();
        if (r62 == null) goto L301;
        r62.width = -2;
        r62.height = r2.a.getResources().getDimensionPixelSize(2131166134);
        r61.setLayoutParams(r62);
        RoundRelativeLayout r63 = r2.c;
        ViewGroup.LayoutParams r64 = r63.getLayoutParams();
        if (r64 == null) goto L299;
        r64.width = -2;
        r63.setLayoutParams(r64);
        if (r13 == false) goto L296;
        e1.x(r2.f);
        r2.c.getDelegate().a(ContextCompat.getColor(r2.a.getContext(), 2131100493));
        LinearLayout r65 = r2.j;
        r65.setPadding(0, r65.getPaddingTop(), i5.c(), r65.getPaddingBottom());
        we8.a.b(r2.l, i5.o(), false, null, null, 12);
        r2.l.setTypeface(Typeface.DEFAULT, 1);
        TextView r66 = r2.k;
        r66.setPadding(i5.h(), r66.getPaddingTop(), i5.h(), r66.getPaddingBottom());
        RelativeLayout r67 = r2.e;
        r67.setPadding(r67.getPaddingLeft(), r67.getPaddingTop(), r67.getPaddingRight(), i5.v0());
    L297:
        we8.a.b(r2.k, i5.o(), false, null, null, 12);
        return;
    L296:
        e1.o(r2.f);
        r2.c.getDelegate().a(0);
        LinearLayout r68 = r2.j;
        r68.setPadding(0, r68.getPaddingTop(), 0, r68.getPaddingBottom());
        we8.a.b(r2.l, i5.t(), false, null, null, 12);
        r2.l.setTypeface(Typeface.DEFAULT, 0);
        TextView r69 = r2.k;
        r69.setPadding(0, r69.getPaddingTop(), 0, r69.getPaddingBottom());
        RelativeLayout r70 = r2.e;
        r70.setPadding(r70.getPaddingLeft(), r70.getPaddingTop(), r70.getPaddingRight(), 0);
        goto L297
    L299:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L301:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L303:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L305:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L307:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L309:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L311:
        if (r13 == false) goto L329;
        e1.o(r2.k);
        RelativeLayout r71 = r2.e;
        ViewGroup.LayoutParams r72 = r71.getLayoutParams();
        if (r72 == null) goto L328;
        r72.width = -1;
        r71.setLayoutParams(r72);
        RecyclerView r73 = r2.g;
        ViewGroup.LayoutParams r74 = r73.getLayoutParams();
        if (r74 == null) goto L326;
        r74.width = -1;
        r73.setLayoutParams(r74);
        e1.x(r2.f);
        SimpleDraweeView r75 = r2.f;
        ViewGroup.LayoutParams r76 = r75.getLayoutParams();
        if (r76 == null) goto L324;
        r76.width = i5.v();
        r76.height = i5.v();
        r75.setLayoutParams(r76);
        r2.c.getDelegate().a(ContextCompat.getColor(r2.a.getContext(), 2131100493));
        r2.c.getDelegate().e(i5.r0());
        LinearLayout r77 = r2.j;
        ViewGroup.LayoutParams r78 = r77.getLayoutParams();
        if (r78 == null) goto L322;
        r78.width = -2;
        r78.height = -2;
        r77.setLayoutParams(r78);
        r2.j.setPadding(i5.r0(), i5.r0(), i5.r0(), i5.r0());
        we8.a.b(r2.l, i5.m(), false, null, null, 12);
        r2.l.setTypeface(Typeface.create("sans-serif-medium", 0));
        RecyclerView r79 = r2.g;
        r79.setPadding(i5.r0(), r79.getPaddingTop(), i5.r0(), r79.getPaddingBottom());
        RelativeLayout r80 = r2.e;
        r80.setPadding(r80.getPaddingLeft(), r80.getPaddingTop(), r80.getPaddingRight(), i5.v0());
        return;
    L322:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L324:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L326:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L328:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L329:
        e1.o(r2.k);
        RelativeLayout r81 = r2.e;
        ViewGroup.LayoutParams r82 = r81.getLayoutParams();
        if (r82 == null) goto L346;
        r82.width = -1;
        r81.setLayoutParams(r82);
        RecyclerView r83 = r2.g;
        ViewGroup.LayoutParams r84 = r83.getLayoutParams();
        if (r84 == null) goto L344;
        r84.width = -1;
        r83.setLayoutParams(r84);
        e1.x(r2.f);
        SimpleDraweeView r85 = r2.f;
        ViewGroup.LayoutParams r86 = r85.getLayoutParams();
        if (r86 == null) goto L342;
        r86.width = i5.v();
        r86.height = i5.v();
        r85.setLayoutParams(r86);
        r2.c.getDelegate().a(v19.c.a(2130970529, r2.a.getContext(), 2131102529));
        r2.c.getDelegate().e(i5.r0());
        LinearLayout r87 = r2.j;
        ViewGroup.LayoutParams r88 = r87.getLayoutParams();
        if (r88 == null) goto L340;
        r88.width = -2;
        r88.height = -2;
        r87.setLayoutParams(r88);
        r2.j.setPadding(i5.r0(), i5.r0(), i5.r0(), i5.r0());
        we8.a.b(r2.l, i5.m(), false, null, null, 12);
        r2.l.setTypeface(Typeface.create("sans-serif-medium", 0));
        RecyclerView r89 = r2.g;
        r89.setPadding(i5.r0(), r89.getPaddingTop(), i5.r0(), r89.getPaddingBottom());
        RelativeLayout r90 = r2.e;
        r90.setPadding(r90.getPaddingLeft(), r90.getPaddingTop(), r90.getPaddingRight(), i5.r0());
        return;
    L340:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L342:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L344:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L346:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L263:
        r51 = 4;
        goto L264
    L265:
        e1.x(r2.d);
        goto L280
    L230:
        if (r44.intValue() != r123) goto L231;
        r124 = false;
    L225:
        r44 = null;
        goto L226
    L219:
        r41 = null;
        goto L220
    L209:
        r33 = null;
        goto L210
    L266:
        ValueAnimator r91 = this.g;
        if (r91 == null) goto L269;
        r91.cancel();
        Unit r92 = Unit.INSTANCE;
    L269:
        this.g = null;
        m(r2, true);
        e1.o(r2.b);
        e1.o(r2.e);
        r2.j.setOnClickListener(null);
        String r93 = r8.oJumpUrl;
        if (r93 == null) goto L274;
        r6 = r93;
    L274:
        if (Intrinsics.areEqual(r8.oShownState, "1") == true) goto L276;
    L278:
        e1.o(r2.b);
        r2.j.setOnClickListener(null);
        goto L280
    L276:
        if (o0.d(r6) == false) goto L278;
        e1.x(r2.b);
        e1.d(r2.j, new fca.c(this, r2, r6));
        goto L280
    L179:
        r119 = 0;
        goto L180
    L164:
        if (Intrinsics.areEqual(r8.oShownState, RiskPreferenceSettings.SMART_BALANCE) == true) goto L173;
        String r125 = r8.oShownState;
        if (r125 != null) goto L168;
    L171:
        boolean r126 = true;
    L172:
        if (r126 == false) goto L175;
    L168:
        if (r125.length() == 0) goto L171;
        r126 = false;
    L173:
        if (r11 == false) goto L175;
        r115 = true;
        goto L176
    L158:
        if (r113.isEmpty() == true) goto L161;
        r114 = false;
        goto L162
    L73:
        if (com.larus.im.bean.message.a.o0(r1.j()) == false) goto L151;
        Boolean r127 = r8.oHasNotAnimation;
        if (r127 == null) goto L78;
        boolean r128 = r127.booleanValue();
    L79:
        if (r128 == false) goto L84;
        r14.i("LocalSearchBlockHolder", "oHasNotAnimation = true");
        k(r2, true);
        MessageLoading r129 = r2.h;
        r129.e.cancel();
        r129.c = false;
        e1.o(r2.h);
        e1.x(r2.l);
        TextView r130 = r2.l;
        String r131 = r8.summary;
        if (r131 != null) goto L83;
        r131 = NameKeys.UnloadStrategy_No_Strategy;
    L83:
        r130.setText(r131);
        goto L155
    L84:
        List r132 = r8.queries;
        if (r132 == null) goto L97;
        List r133 = CollectionsKt.filterNotNull(r132);
        if (r133 == null) goto L97;
        List r134 = new ArrayList();
        Iterator r135 = r133.iterator();
    L90:
        if (r135.hasNext() == false) goto L98;
        String r136 = (String) r135.next();
        String r137 = r8.summary;
        if (r137 == null) goto L94;
        String r138 = StringsKt.replace$default(r137, "%s", r136, false, 4, null);
    L95:
        if (r138 == null) goto L90;
        r134.add(r138);
        goto L90
    L94:
        r138 = null;
    L98:
        if (r134 != 0) goto L100;
    L103:
        boolean r139 = true;
    L104:
        if (r139 == false) goto L109;
        String r140 = r8.summary;
        if (r140 != null) goto L108;
        r140 = NameKeys.UnloadStrategy_No_Strategy;
    L108:
        r134 = CollectionsKt.listOf(r140);
    L109:
        if (r13 == false) goto L146;
        MessageLoading r141 = r2.h;
        r141.e.cancel();
        r141.c = false;
        e1.o(r2.h);
        eca.c r142 = this.f;
        if (r142 == null) goto L113;
        List<String> r143 = r142.b;
    L114:
        if (r143 == null) goto L122;
        if (r142 == null) goto L117;
        List<String> r144 = r142.b;
    L119:
        if (Intrinsics.areEqual(r134, r144) == true) goto L122;
        k(r2, false);
        FLogger.a.i("LocalSearchBlockHolder", "is change to " + r134);
        goto L122
    L117:
        r144 = null;
    L122:
        if (this.f != null) goto L137;
        final Context r145 = r2.a.getContext();
        p();
        ObricBlockLocalSearchBinding r146 = this.d;
        if (r146 == null) goto L128;
        TextSwitcher r147 = r146.i;
        if (r147 == null) goto L128;
        r147.removeAllViews();
    L128:
        ObricBlockLocalSearchBinding r148 = this.d;
        if (r148 == null) goto L133;
        TextSwitcher r149 = r148.i;
        if (r149 == null) goto L133;
        r149.setFactory(new g(r145, this));
    L133:
        eca.c r150 = new eca.c(r2.i, r134);
        this.f = r150;
        r150.a(r2.a.getContext());
        eca.c r151 = this.f;
        if (r151 == null) goto L136;
        r151.c();
    L136:
        boolean r152 = true;
    L138:
        if (r152 == false) goto L143;
        Iterator r153 = ((ArrayList) this.e).iterator();
    L141:
        if (r153.hasNext() == false) goto L143;
        ShimmerTextView r154 = (ShimmerTextView) r153.next();
        int r155 = ShimmerTextView.h;
        r154.z(false);
    L143:
        TextSwitcher r156 = r2.i;
        if (r156 == null) goto L147;
        r156.setVisibility(0);
    L147:
        e1.o(r2.l);
        TextView r157 = r2.l;
        String r158 = r8.summary;
        if (r158 != null) goto L150;
        r158 = NameKeys.UnloadStrategy_No_Strategy;
    L150:
        r157.setText(r158);
        goto L155
    L137:
        r152 = false;
        goto L138
    L113:
        r143 = null;
        goto L114
    L146:
        k(r2, true);
        e1.x(r2.h);
        r2.h.setLoadingText(CollectionsKt.joinToString$default(r134, String.valueOf(r2.a.getContext().getString(2131912105)), null, null, 0, null, null, 62, null));
        r2.h.c();
        goto L147
    L100:
        if (r134.isEmpty() == true) goto L103;
        r139 = false;
    L97:
        r134 = 0;
        goto L98
    L78:
        r128 = false;
        goto L79
    L56:
        if (Intrinsics.areEqual(r15, "https://decode/tool_icon/Search.png") == true) goto L62;
        ViewGroup.LayoutParams r159 = r2.f.getLayoutParams();
        if (r159 == null) goto L61;
        r159.width = i5.J();
        r159.height = i5.J();
        Unit r94 = Unit.INSTANCE;
    L61:
        ImageLoaderKt.u(r2.f, r15, "obric_chat.cards");
        goto L66
    L52:
        r19 = false;
        goto L54
    L39:
        if (r17.length() == 0) goto L42;
        r18 = false;
    L47:
        if (r15 != null) goto L50;
    L33:
        r13 = false;
        goto L34
    L24:
        if (r9.length() == 0) goto L27;
        r10 = false;
        goto L28
    L18:
        r8 = null;
        goto L19
    L8:
        r5 = null;
        goto L9
    }

    public final View h(ViewGroup r21) {
        Intrinsics.checkNotNullParameter(r21, "viewGroup");
        View r1 = LayoutInflater.from(r21.getContext()).inflate(2131563939, r21, false);
        int r2 = 2131363236;
        View r7 = ViewBindings.findChildViewById(r1, 2131363236);
        if (r7 == null) goto L33;
        r2 = 2131367728;
        RoundRelativeLayout r3 = ViewBindings.findChildViewById(r1, 2131367728);
        if (r3 == null) goto L33;
        r2 = 2131369197;
        View r9 = ViewBindings.findChildViewById(r1, 2131369197);
        if (r9 == null) goto L33;
        r2 = 2131370361;
        RelativeLayout r10 = (RelativeLayout) ViewBindings.findChildViewById(r1, 2131370361);
        if (r10 == null) goto L33;
        r2 = 2131374718;
        SimpleDraweeView r11 = ViewBindings.findChildViewById(r1, 2131374718);
        if (r11 == null) goto L33;
        r2 = 2131375799;
        RecyclerView r15 = ViewBindings.findChildViewById(r1, 2131375799);
        if (r15 == null) goto L33;
        r2 = 2131379999;
        MessageLoading r14 = ViewBindings.findChildViewById(r1, 2131379999);
        if (r14 == null) goto L33;
        r2 = 2131385562;
        TextSwitcher r16 = (TextSwitcher) ViewBindings.findChildViewById(r1, 2131385562);
        if (r16 == null) goto L33;
        r2 = 2131388881;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131388881);
        if (r17 == null) goto L33;
        r2 = 2131391234;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r1, 2131391234);
        if (r18 == null) goto L33;
        r2 = 2131391606;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r1, 2131391606);
        if (r19 == null) goto L33;
        RelativeLayout r4 = (RelativeLayout) r1;
        ObricBlockLocalSearchBinding r5 = new ObricBlockLocalSearchBinding(r4, r7, r3, r9, r10, r11, r15, r14, r16, r17, r18, r19);
        this.d = r5;
        Intrinsics.checkNotNull(r5);
        TextView r6 = (TextView) r14.findViewById(2131390903);
        if (r6 == null) goto L27;
        we8.a.b(r6, i5.t(), false, null, null, 12);
    L27:
        TextView r8 = (TextView) r14.findViewById(2131383330);
        if (r8 == null) goto L30;
        we8.a.b(r8, i5.t(), false, null, null, 12);
    L30:
        r15.setLayoutManager(new LinearLayoutManager(r4.getContext(), 1, false));
        r15.setAdapter(new SearchLocalItemAdapter());
        r3.setOutlineProvider(new i(this));
        ((ArrayList) this.e).clear();
        this.f = null;
        return r4;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    public static void m(ObricBlockLocalSearchBinding r0, boolean r1) {
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

    public final void k(ObricBlockLocalSearchBinding r2, boolean r3) {
        eca.c r0 = this.f;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.f = null;
        p();
        if (r3 == false) goto L12;
        if (r2 == null) goto L13;
        TextSwitcher r4 = r2.i;
        if (r4 == null) goto L14;
        r4.setVisibility(8);
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void l(final ObricBlockLocalSearchBinding r4, boolean r5, boolean r6) {
        ValueAnimator r0 = this.g;
        if (r0 == null) goto L5;
        r0.cancel();
        this.g = null;
    L5:
        if (r5 == false) goto L10;
        float r7 = 0.0f;
        float r1 = 90.0f;
        if (r6 == false) goto L9;
        r7 = 90.0f;
        r1 = 0.0f;
    L9:
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{r7, r1});
        this.g = r8;
        r8.setDuration(150);
        r8.addUpdateListener(new e(r4));
        r8.addListener(new b(this, r4, r6));
        r8.start();
        return;
    L10:
        m(r4, r6);
    }

    public final void o(ObricBlockLocalSearchBinding r9, boolean r10, boolean r11) {
        FLogger.a.d("LocalSearchBlockHolder", "setDropdownExpandState: expand = " + r10 + ", withArrowAnimation = " + r11);
        ValueAnimator r0 = this.h;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.h = null;
        if (this.k == false) goto L12;
        if (r10 == false) goto L9;
        e1.x(r9.e);
    L10:
        l(r9, r11, !r10);
        return;
    L9:
        e1.o(r9.e);
        goto L10
    L12:
        RoundRelativeLayout r2 = r9.c;
        RelativeLayout r3 = r9.e;
        RecyclerView r4 = r9.g;
        this.j = i5.r0();
        ViewGroup.LayoutParams r1 = r2.getLayoutParams();
        if (r1 == null) goto L43;
        r1.width = -1;
        r2.setLayoutParams(r1);
        if (r11 == true) goto L32;
        if (r10 == false) goto L18;
        e1.x(r3);
    L19:
        ViewGroup.LayoutParams r12 = r3.getLayoutParams();
        if (r12 == null) goto L31;
        r12.height = -2;
        r3.setLayoutParams(r12);
        ViewGroup.LayoutParams r13 = r4.getLayoutParams();
        if (r13 == null) goto L29;
        r13.height = -2;
        r4.setLayoutParams(r13);
        l(r9, false, !r10);
        if (r10 == false) goto L26;
        r2.setClipToOutline(false);
        this.i = 0;
        return;
    L26:
        r2.setClipToOutline(true);
        OneShotPreDrawListener.add(r2, new c(r2, this, r9, r2));
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L18:
        e1.o(r3);
        goto L19
    L32:
        e1.x(r3);
        ViewGroup.LayoutParams r14 = r3.getLayoutParams();
        if (r14 == null) goto L41;
        r14.height = -2;
        r3.setLayoutParams(r14);
        ViewGroup.LayoutParams r15 = r4.getLayoutParams();
        if (r15 == null) goto L39;
        r15.height = -2;
        r4.setLayoutParams(r15);
        r2.setClipToOutline(true);
        l(r9, true, !r10);
        r2.getViewTreeObserver().addOnPreDrawListener(new d(r2, r3, r4, r9, r10, this));
        return;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
