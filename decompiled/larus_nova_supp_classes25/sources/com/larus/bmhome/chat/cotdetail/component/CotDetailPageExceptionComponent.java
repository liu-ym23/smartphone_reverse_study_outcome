package com.larus.bmhome.chat.cotdetail.component;

import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.cotdetail.ability.CotDetailPageState;
import com.larus.mainbot.impl.databinding.LarusPageCotDetailBinding;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchErrorBinding;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchLoadingBinding;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/component/CotDetailPageExceptionComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailPageExceptionAbility;", "<init>", "()V", "cotDetailFragmentAbility", "Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailFragmentAbility;", "getCotDetailFragmentAbility", "()Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailFragmentAbility;", "cotDetailFragmentAbility$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusPageCotDetailBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusPageCotDetailBinding;", "binding$delegate", "cotDetailComponent", "Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailMessageListAbility;", "getCotDetailComponent", "()Lcom/larus/bmhome/chat/cotdetail/ability/ICotDetailMessageListAbility;", "cotDetailComponent$delegate", "onAttach", "", "onParentViewCreated", "updatePageState", "state", "Lcom/larus/bmhome/chat/cotdetail/ability/CotDetailPageState;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CotDetailPageExceptionComponent extends Component implements fe8.d {
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CotDetailPageState.values().length];
            r0[CotDetailPageState.Loading.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CotDetailPageState.Failed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CotDetailPageState.Success.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final LarusPageCotDetailBinding F2() {
        return (LarusPageCotDetailBinding) this.m.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, fe8.d.class);
    }

    public CotDetailPageExceptionComponent() {
        this.l = LazyKt.lazy(new f0(this));
        this.m = LazyKt.lazy(new g0(this));
        this.n = LazyKt.lazy(new h0(this));
    }

    public final void B2() {
        LarusPageCotDetailBinding r0 = F2();
        if (r0 == null) goto L10;
        LarusPageDeepResearchErrorBinding r1 = r0.k;
        if (r1 == null) goto L11;
        ConstraintLayout r2 = r1.a;
        if (r2 == null) goto L12;
        e1.d(r2, new i0(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // fe8.d
    public final void OT(CotDetailPageState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        int r3 = a.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        LarusPageCotDetailBinding r4 = F2();
        if (r4 == null) goto L45;
        LarusPageDeepResearchLoadingBinding r5 = r4.l;
        if (r5 == null) goto L45;
        LinearLayout r6 = r5.a;
        if (r6 == null) goto L45;
        e1.x(r6);
    L45:
        LarusPageCotDetailBinding r7 = F2();
        if (r7 == null) goto L61;
        LarusPageDeepResearchErrorBinding r8 = r7.k;
        if (r8 == null) goto L62;
        ConstraintLayout r9 = r8.a;
        if (r9 == null) goto L63;
        e1.o(r9);
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L5:
        if (r3 != 2) goto L7;
        LarusPageCotDetailBinding r10 = F2();
        if (r10 == null) goto L31;
        LarusPageDeepResearchLoadingBinding r11 = r10.l;
        if (r11 == null) goto L31;
        LinearLayout r12 = r11.a;
        if (r12 == null) goto L31;
        e1.o(r12);
    L31:
        LarusPageCotDetailBinding r13 = F2();
        if (r13 == null) goto L57;
        LarusPageDeepResearchErrorBinding r14 = r13.k;
        if (r14 == null) goto L58;
        ConstraintLayout r15 = r14.a;
        if (r15 == null) goto L59;
        e1.x(r15);
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L7:
        if (r3 != 3) goto L23;
        LarusPageCotDetailBinding r16 = F2();
        if (r16 == null) goto L15;
        LarusPageDeepResearchLoadingBinding r17 = r16.l;
        if (r17 == null) goto L15;
        LinearLayout r18 = r17.a;
        if (r18 == null) goto L15;
        e1.o(r18);
    L15:
        LarusPageCotDetailBinding r19 = F2();
        if (r19 == null) goto L53;
        LarusPageDeepResearchErrorBinding r20 = r19.k;
        if (r20 == null) goto L54;
        ConstraintLayout r21 = r20.a;
        if (r21 == null) goto L55;
        e1.o(r21);
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L23:
        throw new NoWhenBranchMatchedException();
    }
}
