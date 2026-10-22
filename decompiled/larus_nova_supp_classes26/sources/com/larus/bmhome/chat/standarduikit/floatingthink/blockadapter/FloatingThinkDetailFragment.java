package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.deepresearch.view.a0;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderV2Binding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.m0;
import com.larus.utils.t0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kc8.v0;
import kc8.w0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0002@AB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0017J\b\u0010)\u001a\u00020'H\u0016J\u000e\u0010*\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u001fH\u0016J\u0010\u0010-\u001a\u00020'2\u0006\u0010,\u001a\u00020\u001fH\u0002J\u0010\u0010.\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001fH\u0002J\b\u0010/\u001a\u00020'H\u0003J\b\u00100\u001a\u00020'H\u0002J\u0012\u00101\u001a\b\u0012\u0004\u0012\u00020302*\u00020\u0006H\u0002J\u001a\u00104\u001a\u00020'*\b\u0012\u0004\u0012\u000203052\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020\u0017H\u0002J\b\u00109\u001a\u00020:H\u0002J\u0015\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0006H\u0000¢\u0006\u0002\b=J\b\u0010>\u001a\u00020'H\u0016J\b\u0010?\u001a\u00020'H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkDetailFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkBottomSheetAware;", "<init>", "()V", "blockModel", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkBlockBizModel;", "globalConfig", "Lcom/larus/bmhome/chat/block/base/config/GlobalConfig;", "containerView", "Lcom/larus/mainbot/api/block/ui/AbsBlockContainerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "markdownClickProcessor", "Lcom/larus/bmhome/chat/deepresearch/view/MarkdownClickProcessor;", "headerController", "Lcom/larus/common_ui/dialog/BottomSheetHeaderControllerV2;", "isUserTouch", "", "isFingerDown", "baseRecyclerBottomPadding", "", "getBaseRecyclerBottomPadding", "()I", "baseRecyclerBottomPadding$delegate", "Lkotlin/Lazy;", "scrollToBottomLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "updateData", "onBottomSheetChanged", "bottomSheet", "updateBottomPadding", "setupViews", "setupScrollBehavior", "bindBlockData", "toRenderBlockList", "", "Lcom/larus/im/bean/message/block/Block;", "addBlockTree", "", "model", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "getNavBarHeight", "resolveTitle", "", "matches", "other", "matches$impl_mainlandRelease", "onDestroyView", "onDestroy", "Companion", "SingleBlockContainerAdapter", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatingThinkDetailFragment extends Fragment implements m {
    public static final /* synthetic */ int n = 0;
    public g d;
    public kc8.y e;
    public hk9.a f;
    public RecyclerView g;
    public a0 h;
    public com.larus.common_ui.dialog.t i;
    public boolean j;
    public boolean k;
    public final Lazy l;
    public final s m;

    public final class SingleBlockContainerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public final /* synthetic */ FloatingThinkDetailFragment a;

        public final void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "holder");
        }

        public final int getItemCount() {
            if (this.a.f == null) goto L5;
            return 1;
        L5:
            return 0;
        }

        public SingleBlockContainerAdapter(FloatingThinkDetailFragment r1) {
            this.a = r1;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parent");
            final View r3 = this.a.f;
            if (r3 != null) goto L7;
            r3 = new View(r1.getContext());
        L7:
            return new FloatingThinkDetailFragment$SingleBlockContainerAdapter$onCreateViewHolder$1(r3);
        }
    }

    public static final class a {
    }

    public static final class b implements fh8.d {
        public b() {
        }

        public final boolean b() {
            return false;
        }

        public final DeepThinkFoldStatus a() {
            return DeepThinkFoldStatus.CompleteExpand;
        }
    }

    static {
    }

    public final void T90() {
        g r1 = this.d;
        if (r1 != null) goto L5;
        return;
    L5:
        Context r2 = getContext();
        if (r2 != null) goto L8;
        return;
    L8:
        com.larus.common_ui.dialog.t r3 = this.i;
        if (r3 == null) goto L11;
        r3.a(getString(2131906598));
    L11:
        kc8.f r4 = new kc8.f(r1.j(), null, true, false, null, "moa_cot_container", 474);
        if (h.a(r1) == true) goto L15;
        return;
    L15:
        if (this.h != null) goto L33;
        Message r7 = r1.j();
        kc8.y r6 = this.e;
        if (r6 == null) goto L24;
        Function0 r8 = r6.l;
        if (r8 == null) goto L24;
        BotModel r9 = (BotModel) r8.invoke();
        if (r9 == null) goto L24;
        BotModel r10 = r9;
    L28:
        String r11 = r1.j().getConversationId();
        if (r11 == null) goto L31;
        Long r12 = StringsKt.toLongOrNull(r11);
    L32:
        this.h = new a0(r7, r10, r12, this.g, "cot_detail", null, null, null, null, null, 896);
        goto L33
    L31:
        r12 = null;
    L24:
        String r13 = r1.j().getSenderId();
        if (r13 != null) goto L27;
        r13 = "";
    L27:
        r10 = new BotModel(r13, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    L33:
        int r5 = kc8.b.y;
        kc8.b.a r14 = new kc8.b.a();
        r14.h = new kc8.w(Integer.valueOf(v19.c.b(2130970662, requireActivity(), 2131239046)));
        Boolean r15 = Boolean.TRUE;
        r14.k = new kc8.s(r15);
        DeepThinkFoldStatus r16 = DeepThinkFoldStatus.CompleteExpand;
        int r17 = v19.c.b(2130970967, r2, 2131240188);
        r14.i = new kc8.r(r16, Integer.valueOf(ContextCompat.getColor(r2, v19.c.b(2130972085, r2, 2131103156))), Integer.valueOf(r17), Integer.valueOf(c7.b(320)), 32);
        r14.m = new kc8.u(Integer.valueOf(v19.c.b(2130970662, requireActivity(), 2131239046)), Integer.valueOf(v19.c.b(2130970920, requireActivity(), 2131239998)));
        r14.p = new kc8.k(v19.c.b(2130970662, requireActivity(), 2131239046));
        r14.j = new kc8.p(r15);
        r14.g = new kc8.x(Integer.valueOf(R.color.transparent));
        RectF r18 = new RectF(c7.b(16), c7.b(12), c7.b(16), c7.b(12));
        int r19 = m0.b(r2) - c7.b(20);
        r14.a = new v0(null, Integer.valueOf(r19), false, false, null, r15, r18, null, null, new o(this), new p(), new jh8.b(Integer.valueOf(ContextCompat.getColor(r2, v19.c.b(2130972086, r2, 2131103159))), Integer.valueOf(v19.c.b(2130970920, requireActivity(), 2131239998)), 1), null, null, null, 127389);
        r14.g = new kc8.x(Integer.valueOf(R.color.transparent));
        if ((getParentFragment() instanceof u) == false) goto L36;
        kc8.y r20 = this.e;
    L48:
        r14.b = r20;
        r14.v = new w0(ToolBlockInteractType.OpenFloatingPage, ToolBlockInitStatus.Fold, new com.larus.bmhome.block.presentation.a(getParentFragment(), new q(this)));
        r14.l = new kc8.q(null, r15, null, null, null, null, null, null, null, null, null, null, 8189);
        kc8.b r21 = r14.a();
        g r22 = this.d;
        if (r22 != null) goto L51;
    L53:
        boolean r110 = false;
    L54:
        tb8.a r23 = new tb8.a(null, null, null, null, r110, new b(), 15);
        RecyclerView r24 = this.g;
        if (r24 == null) goto L65;
        Integer r25 = Integer.valueOf(r24.getWidth());
        if (r25.intValue() <= 0) goto L59;
        boolean r111 = true;
    L60:
        if (r111 == true) goto L63;
        r25 = null;
    L63:
        if (r25 == null) goto L65;
        int r26 = r25.intValue();
    L66:
        int r27 = r26 - c7.b(20);
        hk9.a r28 = this.f;
        if (r28 == null) goto L86;
        r28.b(kc8.b.class, r21);
        r28.b(tb8.a.class, r23);
        r28.b(cd8.a.class, new cd8.a(r27, -1));
        int r29 = ra8.a.a;
        List r30 = CollectionsKt.createListBuilder();
        r30.add(Block.copy$default(((jc8.a) r1).a, 0, null, null, null, false, null, null, null, 251, null));
        Intrinsics.checkNotNullParameter(r1, "<this>");
        List r31 = r1.i();
        ArrayList r32 = new ArrayList();
        Iterator r33 = r31.iterator();
    L70:
        if (r33.hasNext() == false) goto L74;
        Object r34 = r33.next();
        if (h.b((jc8.a) r34) == true) goto L70;
        r32.add(r34);
        goto L70
    L74:
        Iterator r35 = r32.iterator();
    L76:
        if (r35.hasNext() == false) goto L78;
        S90(r30, (jc8.a) r35.next());
        goto L76
    L78:
        ra8.a.d(r28, CollectionsKt.build(r30), r4, false);
        return;
    L86:
        return;
    L59:
        r111 = false;
    L65:
        r26 = m0.b(r2);
        goto L66
    L51:
        if (r22.b(true) != true) goto L53;
        r110 = true;
        goto L54
    L36:
        kc8.y r36 = this.e;
        if (r36 == null) goto L43;
        kc8.y.a r37 = r36.b();
        FloatingThinkDetailRootFragment r38 = getParentFragment();
        if ((r38 instanceof FloatingThinkDetailRootFragment) == false) goto L41;
        FloatingThinkDetailRootFragment r39 = r38;
    L42:
        r37.C = r39;
        r20 = r37.a();
        goto L48
    L41:
        r39 = null;
        goto L42
    L43:
        int r40 = kc8.y.J;
        kc8.y.a r41 = new kc8.y.a();
        FloatingThinkDetailRootFragment r42 = getParentFragment();
        if ((r42 instanceof FloatingThinkDetailRootFragment) == false) goto L46;
        FloatingThinkDetailRootFragment r43 = r42;
    L47:
        r41.C = r43;
        r20 = r41.a();
        goto L48
    L46:
        r43 = null;
        goto L47
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.s] */
    public FloatingThinkDetailFragment() {
        this.l = LazyKt.lazy(new r());
        this.m = new s(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.d = null;
        this.e = null;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        RecyclerView r0 = this.g;
        if (r0 == null) goto L7;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1 == null) goto L7;
        r1.removeOnGlobalLayoutListener(this.m);
    L7:
        RecyclerView r2 = this.g;
        if (r2 == null) goto L10;
        r2.setAdapter(null);
    L10:
        hk9.a r3 = this.f;
        if (r3 == null) goto L13;
        int r4 = ra8.a.a;
        ra8.a.c(r3);
    L13:
        a0 r5 = this.h;
        if (r5 == null) goto L16;
        Runnable r6 = r5.o;
        ((com.larus.bmhome.chat.deepresearch.view.y) r6).a = 0;
        t0.a.removeCallbacks(r6);
    L16:
        this.h = null;
        this.i = null;
        this.f = null;
        this.g = null;
    }

    public final void onStart() {
        super.onStart();
        DialogFragment r0 = getParentFragment();
        if ((r0 instanceof DialogFragment) == false) goto L5;
        DialogFragment r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        Dialog r2 = r1.getDialog();
        if (r2 == null) goto L14;
        final View r3 = r2.findViewById(2131368870);
        if (r3 == null) goto L15;
        r3.post(new t(this, r3));
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.m
    public final void BG(View r2) {
        Intrinsics.checkNotNullParameter(r2, "bottomSheet");
        U90(r2);
    }

    public final void U90(View r6) {
        RecyclerView r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        Object r1 = r6.getParent();
        if ((r1 instanceof View) == false) goto L8;
        View r2 = (View) r1;
    L9:
        if (r2 == null) goto L25;
        int r3 = r2.getHeight();
        if (r3 > 0) goto L13;
        return;
    L13:
        int r4 = (r6.getTop() + r6.getHeight()) - r3;
        int r7 = 0;
        int r5 = RangesKt.coerceAtLeast(r4, 0);
        int r8 = ((Number) this.l.getValue()).intValue();
        RecyclerView r9 = this.g;
        if (r9 == null) goto L21;
        WindowInsetsCompat r10 = ViewCompat.getRootWindowInsets(r9);
        if (r10 == null) goto L21;
        Insets r11 = r10.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r11 == null) goto L21;
        r7 = r11.bottom;
    L21:
        int r12 = (r8 + r7) + r5;
        if (r0.getPaddingBottom() == r12) goto L26;
        r0.setPadding(r0.getPaddingLeft(), r0.getPaddingTop(), r0.getPaddingRight(), r12);
        return;
    L26:
        return;
    L25:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public static void S90(List r1, jc8.a r2) {
        if (h.b(r2) == false) goto L5;
        return;
    L5:
        r1.add(r2.a);
        Iterator r3 = r2.i().iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        S90(r1, (jc8.a) r3.next());
        goto L7
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        FragmentActivity r7 = requireActivity();
        com.larus.common_ui.dialog.t r0 = new com.larus.common_ui.dialog.t(LarusLayoutBottomSheetHeaderV2Binding.a(r5.findViewById(2131364521)));
        this.i = r0;
        r0.a(getString(2131906598));
        if ((getParentFragment() instanceof u) == false) goto L7;
        com.larus.common_ui.dialog.t r1 = this.i;
        if (r1 == null) goto L7;
        int r2 = v19.c.b(2130971965, r5.getContext(), 2131242608);
        r1.a.b.setImageResource(r2);
    L7:
        com.larus.common_ui.dialog.t r3 = this.i;
        if (r3 == null) goto L10;
        View.OnClickListener r4 = new n(this);
        r3.a.b.setOnClickListener(r4);
    L10:
        this.g = r5.findViewById(2131384071);
        int r8 = ra8.a.a;
        hk9.a r9 = ra8.a.a(r7);
        r9.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f = r9;
        LinearLayoutManager r10 = new LinearLayoutManager(r7);
        RecyclerView r11 = this.g;
        if (r11 == null) goto L13;
        r11.setLayoutManager(r10);
    L13:
        RecyclerView r12 = this.g;
        if (r12 == null) goto L16;
        r12.setItemAnimator(null);
    L16:
        RecyclerView r13 = this.g;
        if (r13 == null) goto L19;
        r13.setNestedScrollingEnabled(false);
    L19:
        RecyclerView r14 = this.g;
        if (r14 == null) goto L22;
        r14.setAdapter(new SingleBlockContainerAdapter(this));
    L22:
        RecyclerView r15 = this.g;
        if (r15 == null) goto L27;
        ViewTreeObserver r16 = r15.getViewTreeObserver();
        if (r16 == null) goto L27;
        r16.addOnGlobalLayoutListener(this.m);
    L27:
        RecyclerView r17 = this.g;
        if (r17 == null) goto L30;
        r17.addOnItemTouchListener(new FloatingThinkDetailFragment$setupScrollBehavior$1(this));
    L30:
        RecyclerView r18 = this.g;
        if (r18 == null) goto L33;
        r18.addOnScrollListener(new FloatingThinkDetailFragment$setupScrollBehavior$2(this));
    L33:
        T90();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131562366, r3, false);
    }
}
