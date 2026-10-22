package com.larus.bmhome.chat.cotdetail.component;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.dialog.p0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.thread.ThreadData;
import com.larus.mainbot.impl.databinding.LarusPageCotDetailBinding;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \"2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020!H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/component/CotDetailTitleComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailTitleAbility;", "<init>", "()V", "threadData", "Lcom/larus/im/bean/thread/ThreadData;", "titleBarState", "Lcom/larus/bmhome/chat/cotdetail/component/TitleBarState;", "cotDetailFragmentAbility", "Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailFragmentAbility;", "getCotDetailFragmentAbility", "()Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailFragmentAbility;", "cotDetailFragmentAbility$delegate", "Lkotlin/Lazy;", "cotDetailMessageListAbility", "Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailMessageListAbility;", "getCotDetailMessageListAbility", "()Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailMessageListAbility;", "cotDetailMessageListAbility$delegate", "binding", "Lcom/larus/mainbot/impl/databinding/LarusPageCotDetailBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusPageCotDetailBinding;", "binding$delegate", "onAttach", "", "onParentViewCreated", "updateTitleBarStatus", "status", "dequeueAllThreadInteractionPanels", "isAnswering", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CotDetailTitleComponent extends BaseContentWidget implements fe8.e {
    public static final /* synthetic */ int r = 0;
    public ThreadData m;
    public TitleBarState n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;

    public static final class a {
    }

    public static final class b implements p0 {
        public final /* synthetic */ CotDetailTitleComponent a;
        public final /* synthetic */ AppCompatImageView b;

        public final void confirm() {
            fe8.c r0 = (fe8.c) this.a.p.getValue();
            if (r0 == null) goto L5;
            r0.ZF(true);
        L5:
            CotDetailTitleComponent r1 = this.a;
            ThreadData r2 = r1.m;
            String r3 = null;
            if (r2 == null) goto L8;
            String r4 = r2.getSourceConversationId();
        L9:
            boolean r5 = false;
            if (r4 != null) goto L12;
        L15:
            boolean r6 = true;
        L17:
            if ((!r6) == true) goto L20;
            r4 = null;
        L20:
            if (r4 != null) goto L25;
            fe8.a r7 = r1.h3();
            if (r7 == null) goto L24;
            r4 = r7.K();
            goto L25
        L24:
            r4 = null;
        L25:
            ThreadData r8 = r1.m;
            if (r8 == null) goto L28;
            String r9 = r8.getThreadId();
        L29:
            if (r9 != null) goto L31;
        L32:
            r5 = true;
        L34:
            if ((true ^ r5) == true) goto L37;
            r9 = null;
        L37:
            if (r9 != null) goto L42;
            fe8.a r10 = r1.h3();
            if (r10 == null) goto L41;
            r9 = r10.Kd();
            goto L42
        L41:
            r9 = null;
        L42:
            com.larus.bmhome.interactionpanel.g r11 = com.larus.bmhome.interactionpanel.s.a();
            if (r4 != null) goto L45;
            r4 = "";
        L45:
            if (r9 != null) goto L47;
            r9 = "";
        L47:
            r11.f(r4, r9);
            com.larus.bmhome.view.screenmenu.d r12 = com.larus.bmhome.view.screenmenu.d.a;
            com.larus.bmhome.view.screenmenu.d.b(this.b);
            fe8.a r13 = this.a.h3();
            if (r13 == null) goto L50;
            String r14 = r13.Om();
        L51:
            ThreadData r15 = this.a.m;
            if (r15 == null) goto L54;
            String r16 = r15.getSourceConversationId();
        L55:
            fe8.a r17 = this.a.h3();
            if (r17 == null) goto L64;
            kc8.y r18 = r17.ao();
            if (r18 == null) goto L64;
            Function0<BotModel> r19 = r18.l;
            if (r19 == null) goto L64;
            BotModel r20 = (BotModel) r19.invoke();
            if (r20 == null) goto L64;
            r3 = r20.getBotId();
        L64:
            ee8.e.c(r14, r16, r3, "inside_cot");
            fe8.a r21 = this.a.h3();
            if (r21 == null) goto L68;
            r21.finish();
            return;
        L68:
            return;
        L54:
            r16 = null;
            goto L55
        L50:
            r14 = null;
            goto L51
        L31:
            if (StringsKt.isBlank(r9) == false) goto L34;
        L28:
            r9 = null;
            goto L29
        L12:
            if (StringsKt.isBlank(r4) == true) goto L15;
            r6 = false;
            goto L17
        L8:
            r4 = null;
            goto L9
        }

        public b(CotDetailTitleComponent r1, AppCompatImageView r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.u {
        public final /* synthetic */ AppCompatImageView a;

        public final void cancel() {
            com.larus.bmhome.view.screenmenu.d r0 = com.larus.bmhome.view.screenmenu.d.a;
            com.larus.bmhome.view.screenmenu.d.b(this.a);
        }

        public c(AppCompatImageView r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void B2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragment();
        boolean r1 = false;
        if (r0 == null) goto L7;
        FragmentManager r2 = r0.getChildFragmentManager();
        if (r2 == null) goto L7;
        int r3 = r2.getBackStackEntryCount();
    L8:
        if (r3 <= 0) goto L10;
        r1 = true;
    L10:
        LarusPageCotDetailBinding r4 = Y2();
        if (r4 == null) goto L18;
        AppCompatImageView r5 = r4.j;
        if (r5 == null) goto L18;
        if (r1 == false) goto L16;
        int r6 = 2131240191;
    L17:
        r5.setImageResource(r6);
        goto L18
    L16:
        r6 = 2131240192;
    L18:
        LarusPageCotDetailBinding r7 = Y2();
        if (r7 == null) goto L23;
        AppCompatImageView r8 = r7.j;
        if (r8 == null) goto L23;
        e1.d(r8, new k0(this));
    L23:
        fe8.a r9 = h3();
        if (r9 == null) goto L27;
        r9.RG(new l0(this));
        return;
    L27:
        return;
    L7:
        r3 = 0;
        goto L8
    }

    public final LarusPageCotDetailBinding Y2() {
        return (LarusPageCotDetailBinding) this.q.getValue();
    }

    @Override // fe8.e
    public final boolean dF() {
        if (this.n != TitleBarState.STREAMING) goto L5;
        return true;
    L5:
        return false;
    }

    public final fe8.a h3() {
        return (fe8.a) this.o.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, fe8.e.class);
    }

    public CotDetailTitleComponent() {
        this.n = TitleBarState.SHARE;
        this.o = LazyKt.lazy(new m0(this));
        this.p = LazyKt.lazy(new n0(this));
        this.q = LazyKt.lazy(new o0(this));
    }

    @Override // fe8.e
    public final void QC(TitleBarState r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this.n = r2;
        if (r2 != TitleBarState.STREAMING) goto L19;
        LarusPageCotDetailBinding r3 = Y2();
        if (r3 == null) goto L9;
        AppCompatImageView r4 = r3.m;
        if (r4 == null) goto L9;
        e1.x(r4);
    L9:
        LarusPageCotDetailBinding r5 = Y2();
        if (r5 == null) goto L14;
        AppCompatImageView r6 = r5.m;
        if (r6 == null) goto L14;
        r6.setEnabled(true);
    L14:
        LarusPageCotDetailBinding r7 = Y2();
        if (r7 == null) goto L17;
        AppCompatImageView r8 = r7.m;
    L18:
        e1.d(r8, new j0(this));
        return;
    L17:
        r8 = null;
        goto L18
    L19:
        LarusPageCotDetailBinding r9 = Y2();
        if (r9 == null) goto L24;
        AppCompatImageView r10 = r9.m;
        if (r10 == null) goto L24;
        e1.q(r10);
    L24:
        LarusPageCotDetailBinding r11 = Y2();
        if (r11 == null) goto L31;
        AppCompatImageView r12 = r11.m;
        if (r12 == null) goto L32;
        r12.setEnabled(false);
        return;
    L32:
        return;
    }
}
