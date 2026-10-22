package com.larus.bmhome.chat.cotdetail.component;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.CoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.speaker.l$a;
import com.larus.bmhome.chat.standarduikit.taskcard.view.GeneralTaskSource;
import com.larus.bmhome.chat.standarduikit.taskcard.view.TaskCardBtnAction;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.thread.ThreadData;
import com.larus.mainbot.impl.databinding.LarusPageCotDetailBinding;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004*\u00018\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020-H\u0017J\u001c\u0010>\u001a\u00020;2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020A0@H\u0016J\b\u0010B\u001a\u00020;H\u0002J\b\u0010C\u001a\u00020;H\u0002J\b\u0010D\u001a\u00020;H\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\n\u001a\u0004\b%\u0010&R\u0016\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u0002018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109¨\u0006E"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/component/CotDetailInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailInputAbility;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "cotDetailFragmentAbility", "Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailFragmentAbility;", "getCotDetailFragmentAbility", "()Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailFragmentAbility;", "cotDetailFragmentAbility$delegate", "cotDetailMessageListAbility", "Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailMessageListAbility;", "getCotDetailMessageListAbility", "()Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailMessageListAbility;", "cotDetailMessageListAbility$delegate", "cotDetailTitleAbility", "Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailTitleAbility;", "getCotDetailTitleAbility", "()Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailTitleAbility;", "cotDetailTitleAbility$delegate", "clarificationAbility", "Lcom/larus/bmhome/clarification/IClarificationAbility;", "getClarificationAbility", "()Lcom/larus/bmhome/clarification/IClarificationAbility;", "clarificationAbility$delegate", "uiBlockAbility", "Lcom/larus/bmhome/view/actionbar/api/IChatUIBlockAbility;", "getUiBlockAbility", "()Lcom/larus/bmhome/view/actionbar/api/IChatUIBlockAbility;", "rootView", "Landroid/view/View;", "threadData", "Lcom/larus/im/bean/thread/ThreadData;", "latestImeShow", "", "inputHiddenByPage", "inputBarReplacementView", "supportsInteractionPanels", "getSupportsInteractionPanels", "()Z", "uiBlockChangeListener", "com/larus/bmhome/chat/cotdetail/component/CotDetailInputComponent$uiBlockChangeListener$1", "Lcom/larus/bmhome/chat/cotdetail/component/CotDetailInputComponent$uiBlockChangeListener$1;", "onAttach", "", "onViewCreated", "view", "appendMessageExt", "map", "", "", "refreshInputBarReplacementView", "clearInputBarReplacementView", "onFragmentViewDestroyed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CotDetailInputComponent extends BaseContentWidget implements fe8.b {
    public static final /* synthetic */ int y = 0;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public View s;
    public ThreadData t;
    public boolean u;
    public boolean v;
    public hk9.a w;
    public final d x;

    public static final class a implements com.larus.bmhome.chat.component.fastsend.f0 {
        public a() {
        }

        @Override // com.larus.bmhome.chat.component.fastsend.f0
        public final boolean WL() {
            return true;
        }

        @Override // com.larus.bmhome.chat.component.fastsend.f0
        public final boolean eT() {
            return true;
        }

        @Override // com.larus.bmhome.chat.component.fastsend.f0
        public final boolean ox() {
            return false;
        }
    }

    public static final class b implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class c implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.l.class));
        }
    }

    public static final class d implements ss8.g.b {
        public final /* synthetic */ CotDetailInputComponent a;

        public final void b() {
            CotDetailInputComponent r0 = this.a;
            int r1 = CotDetailInputComponent.y;
            r0.h3();
        }

        public d(CotDetailInputComponent r1) {
            this.a = r1;
        }

        public final void a(ChatUIBlockConfig r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "config");
            if (r1 != ChatUIBlockConfig.HIDE_INPUT_BAR) goto L6;
            CotDetailInputComponent r3 = this.a;
            int r4 = CotDetailInputComponent.y;
            r3.h3();
            return;
        }
    }

    public final fe8.a Y2() {
        return (fe8.a) this.o.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, fe8.b.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), new a(), com.larus.bmhome.chat.component.fastsend.f0.class);
    }

    public CotDetailInputComponent() {
        this.m = LazyKt.lazy(new b(this));
        this.n = LazyKt.lazy(new c(this));
        this.o = LazyKt.lazy(new com.larus.bmhome.chat.cotdetail.component.a(this));
        this.p = LazyKt.lazy(new com.larus.bmhome.chat.cotdetail.component.b(this));
        this.q = LazyKt.lazy(new com.larus.bmhome.chat.cotdetail.component.c(this));
        this.r = LazyKt.lazy(new com.larus.bmhome.chat.cotdetail.component.d(this));
        this.x = new d(this);
    }

    public final void A2() {
        ss8.g r0 = s1a.d.a(this).getAbility(ss8.g.class);
        if (r0 == null) goto L5;
        r0.aZ(this.x);
    L5:
        View r1 = this.w;
        if (r1 == null) goto L13;
        ViewParent r2 = r1.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L10;
        ViewGroup r3 = (ViewGroup) r2;
    L11:
        if (r3 == null) goto L13;
        r3.removeView(r1);
        goto L13
    L10:
        r3 = null;
    L13:
        this.w = null;
        this.s = null;
    }

    public final void h3() {
        fe8.a r0 = Y2();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if ((!r1) == true) goto L11;
        return;
    L11:
        View r2 = this.s;
        if (r2 == null) goto L14;
        ViewParent r3 = r2.getParent();
    L16:
        if ((r3 instanceof ViewGroup) == false) goto L18;
        ViewGroup r4 = (ViewGroup) r3;
    L19:
        if (r4 != null) goto L21;
        return;
    L21:
        ss8.g r5 = s1a.d.a(this).getAbility(ss8.g.class);
        if (r5 == null) goto L24;
        ss8.g.a r6 = r5.TI();
    L25:
        View r7 = this.w;
        if (r7 == null) goto L33;
        ViewParent r8 = r7.getParent();
        if ((r8 instanceof ViewGroup) == false) goto L30;
        ViewGroup r9 = (ViewGroup) r8;
    L31:
        if (r9 == null) goto L33;
        r9.removeView(r7);
        goto L33
    L30:
        r9 = null;
    L33:
        this.w = null;
        if (r6 == null) goto L40;
        View r10 = this.s;
        if (r10 == null) goto L38;
        e1.x(r10);
    L38:
        r4.setVisibility(0);
        hk9.a r11 = ((tp8.d) r6).a(r4);
        r4.addView(r11);
        this.w = r11;
        return;
    L40:
        if (this.v == false) goto L46;
        View r12 = this.s;
        if (r12 == null) goto L47;
        e1.o(r12);
        return;
    L47:
        return;
    L46:
        return;
    L24:
        r6 = null;
        goto L25
    L18:
        r4 = null;
        goto L19
    L14:
        r3 = null;
        goto L16
    L5:
        if (r0.Ny() != true) goto L7;
        r1 = true;
        goto L9
    }

    @Override // fe8.b
    public final void fA(Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "map");
        if (r6.get("general_task_param") != null) goto L16;
        fe8.a r1 = Y2();
        if (r1 == null) goto L9;
        Integer r2 = r1.Jo();
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
    L10:
        JSONObject r4 = new JSONObject();
        r4.put("action", TaskCardBtnAction.APPEND_MESSAGE.getValue());
        ThreadData r5 = this.t;
        if (r5 == null) goto L13;
        String r7 = r5.getThreadId();
    L14:
        r4.put("thread_id", r7);
        r4.put("source_type", r3);
        r6.put("general_task_param", r4.toString());
        return;
    L13:
        r7 = null;
    L9:
        r3 = GeneralTaskSource.THREAD_CONVERSATION_V2.getValue();
        goto L10
    }

    public final void onViewCreated(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        this.s = r4;
        View r0 = r4.findViewById(2131375324);
        boolean r1 = false;
        if (r0 == null) goto L5;
        r0.setBackgroundColor(0);
    L5:
        View r2 = r4.findViewById(2131375364);
        if (r2 == null) goto L8;
        r2.setBackgroundColor(0);
    L8:
        View r3 = r4.findViewById(2131362044);
        if (r3 == null) goto L15;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if (r5 == null) goto L14;
        r5.height = 0;
        r3.setLayoutParams(r5);
        goto L15
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L15:
        fe8.a r6 = Y2();
        if (r6 != null) goto L18;
    L20:
        boolean r7 = false;
    L21:
        if (r7 == false) goto L26;
        View r8 = this.s;
        if (r8 == null) goto L25;
        e1.o(r8);
    L25:
        this.v = true;
    L26:
        z2.a.w3();
        fe8.a r9 = Y2();
        if (r9 == null) goto L32;
        if (r9.Ny() != true) goto L32;
        r1 = true;
    L32:
        if ((!r1) == false) goto L37;
        ss8.g r10 = s1a.d.a(this).getAbility(ss8.g.class);
        if (r10 == null) goto L36;
        r10.ds(this.x);
    L36:
        h3();
    L37:
        ICoreInputAbility r11 = (ICoreInputAbility) this.m.getValue();
        if (r11 == null) goto L40;
        r11.Q8("cot_detail");
    L40:
        ICoreInputAbility r12 = (ICoreInputAbility) this.m.getValue();
        if (r12 == null) goto L45;
        CoreInputAbility r13 = r12.JO();
        if (r13 == null) goto L45;
        r13.R8();
    L45:
        ICoreInputAbility r14 = (ICoreInputAbility) this.m.getValue();
        if (r14 == null) goto L48;
        r14.tr(new e(this));
    L48:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r15 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.n.getValue();
        if (r15 == null) goto L51;
        l$a.b(r15, new f(this));
    L51:
        e1.d(r4, new g(this));
        ViewExtKt.n(r4, new h(this), null, null, 6);
        f1 r16 = (f1) s1a.d.a(this).getAbility(f1.class);
        if (r16 == null) goto L54;
        r16.HN();
    L54:
        fe8.a r17 = Y2();
        if (r17 == null) goto L61;
        LarusPageCotDetailBinding r18 = r17.e();
        if (r18 == null) goto L61;
        ChatConstraintLayout r19 = r18.d;
        if (r19 == null) goto L61;
        r19.setOnImePaddingUpdate(new i(this));
    L61:
        fe8.a r20 = Y2();
        if (r20 == null) goto L65;
        r20.RG(new j(this));
        return;
    L65:
        return;
    L18:
        if (r6.Ny() != true) goto L20;
        r7 = true;
        goto L21
    }
}
