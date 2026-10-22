package com.larus.business.floatchat.impl.component;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.im.bean.message.Message;
import com.larus.list.arch.FlowListAdapter;
import com.larus.list.arch.FlowListViewHolder;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/larus/business/floatchat/impl/component/AIFloatChatPreviewMeasureComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/business/floatchat/api/ability/IFloatChatPreviewMeasureAbility;", "Lcom/larus/bmhome/ability/FloatChatPreviewHeightProvider;", "<init>", "()V", "chatListCoreAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListCoreAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListCoreAbility$delegate", "Lkotlin/Lazy;", "foldCoreAbility", "Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "getFoldCoreAbility", "()Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "foldCoreAbility$delegate", "messageLogicAbility", "Lcom/larus/business/floatchat/api/ability/IAIChatMessageLogicAbility;", "getMessageLogicAbility", "()Lcom/larus/business/floatchat/api/ability/IAIChatMessageLogicAbility;", "messageLogicAbility$delegate", "onParentViewCreated", "", "onFragmentViewDestroyed", "getPreviewHeight", "", "anchorMessage", "Lcom/larus/im/bean/message/Message;", "measurePreviewContentHeight", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIFloatChatPreviewMeasureComponent extends Component implements ew8.d, va8.e {
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;

    public static final class a implements Function0<va8.p> {
        public final /* synthetic */ AttachReceiver a;

        public a(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.p.class));
        }
    }

    public static final class b implements Function0<va8.k> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.k.class));
        }
    }

    public static final class c implements Function0<ew8.b> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ew8.b.class));
        }
    }

    public final void A2() {
        va8.k r0 = (va8.k) this.m.getValue();
        if (r0 == null) goto L6;
        r0.I20(null);
        return;
    }

    public final void B2() {
        va8.k r0 = (va8.k) this.m.getValue();
        if (r0 == null) goto L6;
        r0.I20(this);
        return;
    }

    public AIFloatChatPreviewMeasureComponent() {
        this.l = LazyKt.lazy(new a(this));
        this.m = LazyKt.lazy(new b(this));
        this.n = LazyKt.lazy(new c(this));
    }

    public final int H(Message r23) {
        ew8.b r0 = (ew8.b) this.n.getValue();
        if (r0 == null) goto L5;
        List<Message> r1 = r0.NJ();
    L6:
        if (r1 != null) goto L9;
        r1 = CollectionsKt.emptyList();
    L9:
        if ((!r1.isEmpty()) == true) goto L12;
        r1 = null;
    L12:
        if (r1 != null) goto L14;
        r1 = CollectionsKt.listOfNotNull(r23);
    L14:
        d1 r3 = d1.a;
        va8.p r5 = (va8.p) this.l.getValue();
        if (r5 == null) goto L17;
        List r6 = r5.getCurrentList();
    L18:
        if (r6 != null) goto L20;
        r6 = CollectionsKt.emptyList();
    L20:
        va8.p r7 = (va8.p) this.l.getValue();
        if (r7 == null) goto L23;
        RecyclerView r8 = r7.Ly();
    L24:
        va8.p r9 = (va8.p) this.l.getValue();
        if (r9 == null) goto L29;
        RecyclerView r10 = r9.Ly();
        if (r10 == null) goto L29;
        RecyclerView.Adapter r11 = r10.getAdapter();
    L30:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "anchorMessages");
        Intrinsics.checkNotNullParameter(r6, "messages");
        if (r1.isEmpty() == true) goto L306;
        List<Message> r2 = r1;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r12 = r2.iterator();
    L35:
        if (r12.hasNext() == false) goto L74;
        Message r13 = (Message) r12.next();
        d1.a.getClass();
        if (r13 == null) goto L62;
        List r14 = r6;
        Iterator r15 = r14.iterator();
    L40:
        if (r15.hasNext() == false) goto L44;
        Object r16 = r15.next();
        d1.a.getClass();
        if (d1.b((Message) r16, r13) == false) goto L40;
    L45:
        Message r17 = (Message) r16;
        if (r17 != null) goto L55;
        Iterator r18 = r14.iterator();
    L49:
        if (r18.hasNext() == false) goto L53;
        Object r19 = r18.next();
        d1.a.getClass();
        if (d1.c((Message) r19, r13) == false) goto L49;
    L54:
        r17 = (Message) r19;
        goto L55
    L53:
        r19 = null;
    L55:
        if (r17 == null) goto L61;
        d1.a.getClass();
        if (d1.a(r13, r17) == false) goto L60;
        r17 = null;
    L60:
        if (r17 == null) goto L61;
    L70:
        if (r17 == null) goto L73;
        r13 = r17;
    L73:
        r4.add(r13);
    L61:
        r17 = r13;
        goto L70
    L44:
        r16 = null;
        goto L45
    L62:
        Iterator r110 = r6.iterator();
    L64:
        if (r110.hasNext() == false) goto L68;
        Object r111 = r110.next();
        if (com.larus.bmhome.chat.bean.d.G0((Message) r111) == false) goto L64;
    L69:
        r17 = (Message) r111;
        goto L70
    L68:
        r111 = null;
        goto L69
    L74:
        FLogger r20 = FLogger.a;
        StringBuilder r112 = new StringBuilder("measure, anchorMessages=");
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r21 = r2.iterator();
    L76:
        if (r21.hasNext() == false) goto L78;
        Message r114 = (Message) r21.next();
        d1.a.getClass();
        r113.add(d1.e(r114));
        goto L76
    L78:
        r112.append(r113);
        r112.append(", resolvedAnchorMessages=");
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r115 = r4.iterator();
    L80:
        if (r115.hasNext() == false) goto L82;
        Message r116 = (Message) r115.next();
        d1.a.getClass();
        r22.add(d1.e(r116));
        goto L80
    L82:
        r112.append(r22);
        r20.i("FloatChatPreviewMeasure", r112.toString());
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r117 = r4.iterator();
    L84:
        if (r117.hasNext() == false) goto L251;
        Message r118 = (Message) r117.next();
        d1.a.getClass();
        Iterator r25 = r6.iterator();
        int r119 = 0;
    L87:
        if (r25.hasNext() == false) goto L92;
        Message r120 = (Message) r25.next();
        d1.a.getClass();
        if (d1.b(r120, r118) == true) goto L94;
        r119 = r119 + 1;
    L94:
        if (r119 < 0) goto L101;
        Message r121 = (Message) CollectionsKt.getOrNull(r6, r119);
        if (r121 != null) goto L99;
    L102:
        if (r8 == null) goto L106;
        RecyclerView.LayoutManager r26 = r8.getLayoutManager();
        if (r26 == null) goto L106;
        View r27 = r26.findViewByPosition(r119);
    L107:
        if (r27 == null) goto L116;
        int r28 = r27.getHeight();
        d1.a.getClass();
        ViewGroup.LayoutParams r29 = r27.getLayoutParams();
        if ((r29 instanceof ViewGroup.MarginLayoutParams) == false) goto L111;
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) r29;
    L112:
        if (r30 == null) goto L114;
        int r122 = r30.topMargin + r30.bottomMargin;
    L115:
        int r31 = r28 + r122;
    L117:
        FLogger.a.i("FloatChatPreviewMeasure", "measureVisibleMessageHeight, position=" + r119 + ", height=" + r31);
    L118:
        Integer r32 = Integer.valueOf(r31);
        if (r32.intValue() <= 0) goto L121;
        boolean r33 = true;
    L122:
        if (r33 == true) goto L125;
        r32 = null;
    L125:
        if (r32 == null) goto L127;
        int r34 = r32.intValue();
        List r123 = r6;
        RecyclerView r124 = r8;
        RecyclerView.Adapter r210 = r11;
        Iterator r211 = r117;
    L250:
        r24.add(Integer.valueOf(r34));
        r6 = r123;
        r8 = r124;
        r11 = r210;
        r117 = r211;
        goto L84
    L127:
        d1.a.getClass();
        if (r8 != null) goto L131;
        FLogger.a.i("FloatChatPreviewMeasure", "measureOffscreenMessageHeight aborted, reason=recyclerView_null");
    L140:
        r123 = r6;
        r124 = r8;
        r210 = r11;
        r211 = r117;
        int r35 = 0;
    L240:
        Integer r36 = Integer.valueOf(r35);
        if (r36.intValue() <= 0) goto L243;
        boolean r125 = true;
    L244:
        if (r125 == true) goto L247;
        r36 = null;
    L247:
        if (r36 == null) goto L249;
        r34 = r36.intValue();
        goto L250
    L249:
        r34 = d1.b;
        goto L250
    L243:
        r125 = false;
        goto L244
    L131:
        if ((r11 instanceof FlowListAdapter) == false) goto L133;
        FlowListAdapter r37 = (FlowListAdapter) r11;
    L134:
        if (r37 != null) goto L268;
        FLogger r38 = FLogger.a;
        StringBuilder r39 = new StringBuilder("measureOffscreenMessageHeight aborted, reason=unsupported_adapter, adapter=");
        if (r11 == null) goto L138;
        String r40 = r11.getClass().getSimpleName();
    L139:
        r39.append(r40);
        r38.i("FloatChatPreviewMeasure", r39.toString());
        goto L140
    L138:
        r40 = null;
        goto L139
    L268:
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L230
        List r42 = r37.z2();     // Catch: Throwable -> L230
        Iterator r126 = r42.iterator();     // Catch: Throwable -> L230
        int r127 = 0;
    L143:
        if (r126.hasNext() == false) goto L158;
        xc8.b r128 = (ei9.f) r126.next();     // Catch: Throwable -> L230
        if ((r128 instanceof xc8.b) == false) goto L147;
        xc8.b r129 = r128;     // Catch: Throwable -> L230
    L148:
        if (r129 == null) goto L154;
        Message r43 = r129.getMessage();     // Catch: Throwable -> L230
        if (r43 == null) goto L154;
        if (d1.b(r43, r118) != true) goto L154;
        boolean r130 = true;
    L155:
        if (r130 == true) goto L159;
        r127 = r127 + 1;     // Catch: Throwable -> L230
    L159:
        Object r44 = CollectionsKt.getOrNull(r42, r127);     // Catch: Throwable -> L230
        if ((r44 instanceof xc8.b) == false) goto L162;
        xc8.b r45 = (xc8.b) r44;     // Catch: Throwable -> L230
    L163:
        if (r45 != null) goto L165;
    L167:
        boolean r131 = false;
    L168:
        if (r131 == true) goto L171;
        r45 = null;
    L171:
        if (r45 != null) goto L173;
        r45 = xc8.f.f(r118);     // Catch: Throwable -> L230
    L173:
        Integer r46 = Integer.valueOf(r127);     // Catch: Throwable -> L230
        if (r46.intValue() < 0) goto L176;
        boolean r132 = true;
    L177:
        if (r132 == true) goto L180;
        r46 = null;
    L180:
        if (r46 == null) goto L182;
        int r47 = r46.intValue();     // Catch: Throwable -> L230
    L183:
        if (r131 == false) goto L187;
        if (r127 < 0) goto L187;
        int r133 = r37.getItemViewType(r127);     // Catch: Throwable -> L230
    L193:
        if (r133 < 0) goto L280;
        FlowListViewHolder r48 = r37.C2(r8, r133);     // Catch: Throwable -> L228
        r123 = r6;
    L226:
        th = th;
    L227:
        r124 = r8;
        r210 = r11;
        r211 = r117;
    L232:
        Result.Companion r49 = Result.Companion;
        Object r50 = Result.constructor-impl(ResultKt.createFailure(th));
    L233:
        Throwable r51 = Result.exceptionOrNull-impl(r50);
        if (r51 == null) goto L237;
        FLogger r52 = FLogger.a;
        StringBuilder r53 = new StringBuilder("measureOffscreenMessageHeight failed, anchor=");
        d1.a.getClass();
        r53.append(d1.e(r118));
        r52.e("FloatChatPreviewMeasure", r53.toString(), r51);
    L237:
        if (Result.isFailure-impl(r50) == false) goto L239;
        r50 = 0;
    L239:
        r35 = ((Number) r50).intValue();
        goto L240
    L198:
        if ((r48 instanceof FlowListViewHolder) == true) goto L201;
        r48 = null;
    L201:
        if (r48 != null) goto L278;
        FLogger.a.i("FloatChatPreviewMeasure", "measureOffscreenMessageHeight aborted, reason=unsupported_holder");     // Catch: Throwable -> L226
    L203:
        r124 = r8;
        r210 = r11;
        r211 = r117;
        int r54 = 0;
    L272:
        r50 = Result.constructor-impl(Integer.valueOf(r54));     // Catch: Throwable -> L224
    L224:
        th = th;
        goto L232
    L278:
        r48.T3(r45, r47);     // Catch: Throwable -> L219
        r54 = d1.d(((RecyclerView.ViewHolder) r48).itemView, r8);     // Catch: Throwable -> L219
        r124 = r8;
        FLogger r55 = FLogger.a;     // Catch: Throwable -> L217
        r210 = r11;
        StringBuilder r56 = new StringBuilder();     // Catch: Throwable -> L215
        r211 = r117;
        r56.append("measureOffscreenMessageHeight, position=");     // Catch: Throwable -> L213
        r56.append(r127);     // Catch: Throwable -> L213
        r56.append(", bindPosition=");     // Catch: Throwable -> L213
        r56.append(r47);     // Catch: Throwable -> L213
        r56.append(", useAdapterState=");     // Catch: Throwable -> L213
        r56.append(r131);     // Catch: Throwable -> L213
        r56.append(", state=");     // Catch: Throwable -> L213
        r56.append(r45.getClass().getSimpleName());     // Catch: Throwable -> L213
        r56.append(", viewType=");     // Catch: Throwable -> L213
        r56.append(r133);     // Catch: Throwable -> L213
        r56.append(", height=");     // Catch: Throwable -> L213
        r56.append(r54);     // Catch: Throwable -> L213
        r55.i("FloatChatPreviewMeasure", r56.toString());     // Catch: Throwable -> L213
        r48.onViewRecycled();     // Catch: Throwable -> L224
    L213:
        th = th;
    L222:
        r48.onViewRecycled();     // Catch: Throwable -> L224
        throw th;     // Catch: Throwable -> L224
    L215:
        th = th;
    L216:
        r211 = r117;
    L217:
        th = th;
    L221:
        r210 = r11;
    L219:
        th = th;
        r124 = r8;
        goto L221
    L280:
        FLogger.a.i("FloatChatPreviewMeasure", "measureOffscreenMessageHeight aborted, reason=invalid_view_type, position=" + r127 + ", state=" + r45.getClass().getSimpleName());     // Catch: Throwable -> L228
        r123 = r6;
    L228:
        th = th;
        r123 = r6;
    L187:
        Intrinsics.checkNotNullParameter(r45, "data");     // Catch: Throwable -> L230
        r133 = ((fi9.a) r37.e.getValue()).a(r45);     // Catch: Throwable -> L230
        if (r133 < 0) goto L193;
        r133 = (r133 + r45.e()) + 1;
        goto L193
    L182:
        r47 = 0;
        goto L183
    L176:
        r132 = false;
        goto L177
    L165:
        if (d1.a(r118, r45.getMessage()) == true) goto L167;
        r131 = true;
        goto L168
    L162:
        r45 = null;
    L154:
        r130 = false;
        goto L155
    L147:
        r129 = null;
        goto L148
    L158:
        r127 = -1;
    L230:
        th = th;
        r123 = r6;
        r124 = r8;
        r210 = r11;
        r211 = r117;
        goto L232
    L133:
        r37 = null;
        goto L134
    L121:
        r33 = false;
        goto L122
    L114:
        r122 = 0;
        goto L115
    L111:
        r30 = null;
        goto L112
    L116:
        r31 = 0;
    L106:
        r27 = null;
        goto L107
    L99:
        if (d1.a(r118, r121) == false) goto L102;
        FLogger.a.i("FloatChatPreviewMeasure", "measureVisibleMessageHeight ignored stale ASR message, position=" + r119);
    L101:
        r31 = 0;
        goto L118
    L92:
        r119 = -1;
        goto L94
    L251:
        int r57 = CollectionsKt.sumOfInt(r24);
        int r58 = ((((d1.d * r24.size()) + r57) + d1.c) + d1.e) + d1.f;
        FLogger r59 = FLogger.a;
        StringBuilder r60 = new StringBuilder("measure result, anchors=");
        ArrayList r61 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r62 = r4.iterator();
    L253:
        if (r62.hasNext() == false) goto L255;
        Message r63 = (Message) r62.next();
        d1.a.getClass();
        r61.add(d1.e(r63));
        goto L253
    L255:
        r60.append(r61);
        r60.append(", queryHeights=");
        r60.append(r24);
        r60.append(", queryTotal=");
        r60.append(r57);
        r60.append(", reply=");
        r60.append(d1.c);
        r60.append(", gap=");
        r60.append(d1.d);
        r60.append(", top=");
        r60.append(d1.e);
        r60.append(", bottom=");
        r60.append(d1.f);
        r60.append(", result=");
        r60.append(r58);
        r59.i("FloatChatPreviewMeasure", r60.toString());
        Integer r64 = Integer.valueOf(r58);
        if (r64.intValue() <= 0) goto L258;
        boolean r65 = true;
    L259:
        if (r65 == false) goto L261;
        Integer r66 = r64;
    L262:
        if (r66 == null) goto L265;
        return r66.intValue();
    L265:
        return d1.g;
    L261:
        r66 = null;
        goto L262
    L258:
        r65 = false;
        goto L259
    L306:
        return d1.g;
    L29:
        r11 = null;
        goto L30
    L23:
        r8 = null;
        goto L24
    L17:
        r6 = null;
        goto L18
    L5:
        r1 = null;
        goto L6
    }
}
