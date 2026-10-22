package com.larus.bmhome.chat.layout.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.bean.CardCandidateConf;
import com.larus.bmhome.chat.bean.NexPulseCandidate;
import com.larus.bmhome.chat.bean.NexPulseMedia;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0003-./B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u000bJ,\u0010!\u001a\u00020\u00182$\u0010\"\u001a \u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0015J&\u0010#\u001a\u00020\u00182\u001e\u0010\"\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u001aJ\b\u0010$\u001a\u00020\u0018H\u0002J\u0014\u0010%\u001a\u00020\u00182\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160'J\b\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\u0012\u0010*\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010,H\u0014R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\n\u0010\fR\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u0013R.\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u001c\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00060\u001cR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/WelcomeBackSpan;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Ljava/lang/Integer;)V", "isDarkMode", "", "()Z", "isDarkMode$delegate", "Lkotlin/Lazy;", "cinitIsLoad", "needRefresh", "getNeedRefresh", "setNeedRefresh", "(Z)V", "cardItemClickListener", "Lkotlin/Function4;", "Lcom/larus/bmhome/chat/bean/NexPulseCandidate;", "Lcom/larus/bmhome/chat/bean/CardCandidateConf;", "", "cardItemExposeListener", "Lkotlin/Function3;", "adapter", "Lcom/larus/bmhome/chat/layout/item/WelcomeBackSpan$WelcomeAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "cinit", "forceLoad", "setCardItemClickListener", "listener", "setCardItemExposeListener", "initRecyclerView", "setContent", "candidateList", "", "getCardSpanMaxWidth", "getLeftPadding", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "WelcomeAdapter", "WelcomeViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class WelcomeBackSpan extends LinearLayout {
    public static final int g = 0;
    public final Lazy a;
    public volatile boolean b;
    public boolean c;
    public Function4<? super NexPulseCandidate, ? super CardCandidateConf, ? super Integer, ? super Integer, Unit> d;
    public Function3<? super NexPulseCandidate, ? super CardCandidateConf, ? super Integer, Unit> e;
    public final b f;

    public static final class a {
    }

    public final class b extends RecyclerView.Adapter<c> {
        public final List<NexPulseCandidate> a;
        public final /* synthetic */ WelcomeBackSpan b;

        public final int getItemCount() {
            return ((ArrayList) this.a).size();
        }

        public b(WelcomeBackSpan r1) {
            this.b = r1;
            this.a = new ArrayList();
        }

        /* JADX WARN: Type inference failed for: r4v23, types: [com.larus.bmhome.chat.layout.item.u4] */
        public final void onBindViewHolder(RecyclerView.ViewHolder r12, final int r13) {
            final c r14 = (c) r12;
            Intrinsics.checkNotNullParameter(r14, "holder");
            final NexPulseCandidate r0 = (NexPulseCandidate) ListProtector.get(this.a, r13);
            final CardCandidateConf r1 = r0.getCardConf();
            if (r1 == null) goto L80;
            Map<String, String> r2 = r0.getCandidateExt();
            r14.getClass();
            Intrinsics.checkNotNullParameter(r1, "conf");
            View r3 = ((RecyclerView.ViewHolder) r14).itemView;
            Integer r4 = r1.getCardSize();
            boolean r5 = true;
            String r7 = null;
            if (r4 != null) goto L9;
        L11:
            if (r4 != null) goto L14;
        L16:
            if (r4 != null) goto L19;
        L33:
            RecyclerView.LayoutParams r6 = new RecyclerView.LayoutParams(((Number) i5.y0.getValue()).intValue(), i5.l());
        L34:
            r3.setLayoutParams(r6);
            if (((Boolean) r14.c.a.getValue()).booleanValue() == false) goto L45;
            NexPulseMedia r8 = r1.getCardMedia();
            if (r8 == null) goto L39;
            String r9 = r8.getMediaDarkUrl();
        L41:
            if (com.larus.utils.o0.d(r9) == false) goto L45;
            NexPulseMedia r10 = r1.getCardMedia();
            if (r10 == null) goto L48;
            final String r11 = r10.getMediaDarkUrl();
        L49:
            if (r2 == null) goto L51;
            String r15 = r2.get("use_gecko_load");
        L52:
            boolean r16 = Intrinsics.areEqual(r15, "1");
            if (r2 == null) goto L55;
            r7 = r2.get("gecko_channel");
        L55:
            if (r16 == true) goto L57;
        L65:
            r14.T3(r11);
        L66:
            String r17 = r1.getCardLabel();
            if (r17 != null) goto L69;
        L72:
            if (r5 == false) goto L74;
            r14.b.setVisibility(8);
        L75:
            View r18 = ((RecyclerView.ViewHolder) r14).itemView;
            final WelcomeBackSpan r19 = this.b;
            com.larus.utils.e1.d(r18, new p4(r19, r0, r1, r13));
            if (r1.getLabelSugItemType() == null) goto L78;
            TextView r20 = r14.b;
            final WelcomeBackSpan r21 = this.b;
            com.larus.utils.e1.d(r20, new q4(r21, r0, r1, r13));
        L78:
            View r110 = ((RecyclerView.ViewHolder) r14).itemView;
            final WelcomeBackSpan r22 = this.b;
            ExposeXTrackerExtKt.b(r110, new r4(r0, r22, r1, r13));
            return;
        L74:
            r14.b.setVisibility(0);
            r14.b.setText(r1.getCardLabel());
            goto L75
        L69:
            if (r17.length() == 0) goto L72;
            r5 = false;
            goto L72
        L57:
            if (com.larus.utils.o0.d(r7) == false) goto L65;
            FLogger.a.i("WcbSpan", "geckoChannel: " + r7 + ", imageUrl: " + r11);
            com.larus.platform.service.c1 r23 = com.larus.platform.service.c1.a;
            if (r11 != null) goto L61;
            String r24 = "";
        L62:
            if (r7 != null) goto L64;
            r7 = "";
        L64:
            r23.e(r24, r7, new u4(r14, r11));
            goto L66
        L61:
            r24 = r11;
            goto L62
        L51:
            r15 = null;
        L48:
            r11 = null;
            goto L49
        L39:
            r9 = null;
        L45:
            NexPulseMedia r25 = r1.getCardMedia();
            if (r25 == null) goto L48;
            r11 = r25.getMediaLightUrl();
            goto L49
        L19:
            if (r4.intValue() != 3) goto L33;
            Float r26 = r1.getRatio();
            if (r26 != null) goto L23;
        L25:
            boolean r27 = false;
        L26:
            if (r27 == true) goto L29;
            r26 = null;
        L29:
            if (r26 == null) goto L31;
            float r28 = r26.floatValue();
        L32:
            int r29 = WelcomeBackSpan.a(r14.c);
            r6 = new RecyclerView.LayoutParams(r29, (int) (r29 * r28));
            goto L34
        L31:
            r28 = i5.l() / ((Number) i5.N1.getValue()).intValue();
            goto L32
        L23:
            if (r26.floatValue() <= 0.0f) goto L25;
            r27 = true;
            goto L26
        L14:
            if (r4.intValue() != 2) goto L16;
            r6 = new RecyclerView.LayoutParams(((Number) i5.m1.getValue()).intValue(), i5.l());
            goto L34
        L9:
            if (r4.intValue() != 1) goto L11;
            r6 = new RecyclerView.LayoutParams(((Number) i5.y0.getValue()).intValue(), i5.l());
            goto L34
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562703, r3, false);
            WelcomeBackSpan r0 = this.b;
            Intrinsics.checkNotNull(r5);
            return new c(r0, r5);
        }
    }

    public final class c extends RecyclerView.ViewHolder {
        public final SimpleDraweeView a;
        public final TextView b;
        public final /* synthetic */ WelcomeBackSpan c;

        public final void T3(String r5) {
            ImageLoaderKt.y(this.a, r5, "prompt_span_background", new v4(this), 4);
        }

        public c(WelcomeBackSpan r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.c = r2;
            super(r3);
            this.a = r3.findViewById(2131393032);
            this.b = (TextView) r3.findViewById(2131393033);
        }
    }

    public WelcomeBackSpan(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, 0);
    }

    public WelcomeBackSpan(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, 0);
    }

    private final int getCardSpanMaxWidth() {
        return com.larus.bmhome.utils.z1.h(0, null, false, false, 28);
    }

    static {
        g = i5.y0(v19.c.b(2130971546, null, 2131167462));
    }

    private final int getLeftPadding() {
        if (com.larus.platform.service.e2.a.isPad() == false) goto L6;
        return 0;
    L6:
        return getResources().getDimensionPixelSize(2131167568);
    }

    public final boolean getNeedRefresh() {
        return this.c;
    }

    public static final /* synthetic */ int a(WelcomeBackSpan r0) {
        return r0.getCardSpanMaxWidth();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        com.larus.platform.service.e2 r0 = com.larus.platform.service.e2.a;
        Context r1 = getContext();
        if ((r1 instanceof Activity) == false) goto L5;
        Activity r2 = (Activity) r1;
    L7:
        if (r0.a(r2, r4) == false) goto L10;
        boolean r5 = this.b;
        this.b = true;
        setOrientation(1);
        setGravity(8388611);
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        this.c = true;
        return;
    L10:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void setCardItemClickListener(Function4<? super NexPulseCandidate, ? super CardCandidateConf, ? super Integer, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d = r2;
    }

    public final void setCardItemExposeListener(Function3<? super NexPulseCandidate, ? super CardCandidateConf, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e = r2;
    }

    public final void setContent(List<NexPulseCandidate> r8) {
        Intrinsics.checkNotNullParameter(r8, "candidateList");
        removeAllViews();
        setPadding(getLeftPadding(), 0, 0, g);
        RecyclerView r0 = new RecyclerView(getContext());
        r0.setLayoutManager(new LinearLayoutManager(r0.getContext(), 0, false));
        r0.setAdapter(this.f);
        r0.addItemDecoration(new WelcomeBackSpan$initRecyclerView$1$1());
        r0.addOnItemTouchListener(new WelcomeBackSpan$initRecyclerView$1$2());
        ExposeXTrackerExtKt.c(r0);
        addView(r0, new ViewGroup.LayoutParams(-1, -2));
        if ((!r8.isEmpty()) == false) goto L14;
        b r1 = this.f;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "newData");
        ((ArrayList) r1.a).clear();
        List<NexPulseCandidate> r3 = r1.a;
        ArrayList r4 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L13;
        Object r5 = r9.next();
        if (((NexPulseCandidate) r5).getCardConf() == null) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L6;
        r4.add(r5);
        goto L6
    L10:
        r6 = false;
        goto L11
    L13:
        ((ArrayList) r3).addAll(r4);
        r1.notifyDataSetChanged();
    L14:
        this.c = false;
    }

    public final void setNeedRefresh(boolean r1) {
        this.c = r1;
    }

    public WelcomeBackSpan(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1);
        this.a = LazyKt.lazy(new o4(this));
        this.c = true;
        this.f = new b(this);
    }
}
