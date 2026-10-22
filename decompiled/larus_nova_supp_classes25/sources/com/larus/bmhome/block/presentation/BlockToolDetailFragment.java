package com.larus.bmhome.block.presentation;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.larus.bmhome.chat.block.base.config.BlockDetailRequest;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.view.a0;
import com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.m;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderV2Binding;
import com.larus.common_ui.dialog.t;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.m0;
import com.larus.utils.t0;
import kc8.b;
import kc8.c;
import kc8.f;
import kc8.p;
import kc8.q;
import kc8.r;
import kc8.s;
import kc8.u;
import kc8.v0;
import kc8.w;
import kc8.w0;
import kc8.x;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import rb8.h;
import rb8.i;
import rb8.j;
import rb8.k;
import rb8.l;
import rb8.n;
import rb8.o;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 42\u00020\u00012\u00020\u0002:\u000234B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010$\u001a\u00020\u001eH\u0003J\b\u0010%\u001a\u00020\u001eH\u0002J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010-\u001a\u00020\u0010H\u0002J\b\u0010.\u001a\u00020/H\u0002J\n\u00100\u001a\u0004\u0018\u00010+H\u0002J\b\u00101\u001a\u00020\u001eH\u0016J\b\u00102\u001a\u00020\u001eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u00065"}, d2 = {"Lcom/larus/bmhome/block/presentation/BlockToolDetailFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/bmhome/chat/standarduikit/floatingthink/blockadapter/FloatingThinkBottomSheetAware;", "<init>", "()V", "request", "Lcom/larus/bmhome/chat/block/base/config/BlockDetailRequest;", "containerView", "Lcom/larus/mainbot/api/block/ui/AbsBlockContainerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "headerController", "Lcom/larus/common_ui/dialog/BottomSheetHeaderControllerV2;", "markdownClickProcessor", "Lcom/larus/bmhome/chat/deepresearch/view/MarkdownClickProcessor;", "baseRecyclerBottomPadding", "", "getBaseRecyclerBottomPadding", "()I", "baseRecyclerBottomPadding$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onBottomSheetChanged", "bottomSheet", "setupViews", "setupScrollBehavior", "bindBlockData", "buildDetailDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "context", "Landroid/content/Context;", "globalConfig", "Lcom/larus/bmhome/chat/block/base/config/GlobalConfig;", "updateBottomPadding", "getNavBarHeight", "resolveTitle", "", "parentGlobalConfig", "onDestroyView", "onDestroy", "SingleBlockContainerAdapter", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BlockToolDetailFragment extends Fragment implements m {
    public static final /* synthetic */ int j = 0;
    public BlockDetailRequest d;
    public hk9.a e;
    public RecyclerView f;
    public t g;
    public a0 h;
    public final Lazy i;

    public final class SingleBlockContainerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public final /* synthetic */ BlockToolDetailFragment a;

        public final void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "holder");
        }

        public final int getItemCount() {
            if (this.a.e == null) goto L5;
            return 1;
        L5:
            return 0;
        }

        public SingleBlockContainerAdapter(BlockToolDetailFragment r1) {
            this.a = r1;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parent");
            final View r3 = this.a.e;
            if (r3 != null) goto L7;
            r3 = new View(r1.getContext());
        L7:
            return new BlockToolDetailFragment$SingleBlockContainerAdapter$onCreateViewHolder$1(r3);
        }
    }

    public static final class a {
    }

    static {
    }

    public BlockToolDetailFragment() {
        this.i = LazyKt.lazy(new k());
    }

    public final y S90() {
        c r0 = getParentFragment();
        if ((r0 instanceof c) == false) goto L5;
        c r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.XK();
    L5:
        r1 = null;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        this.d = null;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        RecyclerView r0 = this.f;
        if (r0 == null) goto L5;
        r0.setAdapter(null);
    L5:
        hk9.a r1 = this.e;
        if (r1 == null) goto L8;
        int r2 = ra8.a.a;
        ra8.a.c(r1);
    L8:
        a0 r3 = this.h;
        if (r3 == null) goto L11;
        com.larus.bmhome.chat.deepresearch.view.y r4 = r3.o;
        r4.a = 0;
        t0.a.removeCallbacks(r4);
    L11:
        this.h = null;
        this.g = null;
        this.e = null;
        this.f = null;
    }

    public final void onStart() {
        super.onStart();
        DialogFragment r0 = getParentFragment();
        if ((r0 instanceof DialogFragment) == false) goto L5;
        DialogFragment r1 = r0;
    L6:
        if (r1 == null) goto L13;
        Dialog r2 = r1.getDialog();
        if (r2 == null) goto L14;
        final View r3 = r2.findViewById(2131368870);
        if (r3 == null) goto L15;
        r3.post(new j(this, r3));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void BG(View r2) {
        Intrinsics.checkNotNullParameter(r2, "bottomSheet");
        T90(r2);
    }

    public final void T90(View r6) {
        RecyclerView r0 = this.f;
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
        int r8 = ((Number) this.i.getValue()).intValue();
        RecyclerView r9 = this.f;
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

    public final void onViewCreated(View r81, Bundle r82) {
        Intrinsics.checkNotNullParameter(r81, "view");
        super.onViewCreated(r81, r82);
        FragmentActivity r2 = requireActivity();
        t r3 = new t(LarusLayoutBottomSheetHeaderV2Binding.a(r81.findViewById(2131364521)));
        this.g = r3;
        BlockDetailRequest r4 = this.d;
        String r5 = "工具详情";
        if (r4 == null) goto L14;
        String r6 = r4.getTitle();
        if (r6 == null) goto L14;
        if (r6.length() <= 0) goto L9;
        boolean r9 = true;
    L10:
        if (r9 == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L14;
    L15:
        r3.a(r6);
        t r7 = this.g;
        if (r7 == null) goto L18;
        r7.a.b.setImageResource(v19.c.b(2130971965, r81.getContext(), 2131242608));
    L18:
        t r8 = this.g;
        if (r8 == null) goto L21;
        r8.a.b.setOnClickListener(new i(this));
    L21:
        this.f = r81.findViewById(2131384071);
        int r1 = ra8.a.a;
        hk9.a r10 = ra8.a.a(r2);
        r10.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.e = r10;
        RecyclerView r11 = this.f;
        if (r11 == null) goto L24;
        r11.setLayoutManager(new LinearLayoutManager(r2));
    L24:
        RecyclerView r12 = this.f;
        if (r12 == null) goto L27;
        r12.setItemAnimator(null);
    L27:
        RecyclerView r13 = this.f;
        if (r13 == null) goto L30;
        r13.setNestedScrollingEnabled(false);
    L30:
        RecyclerView r14 = this.f;
        if (r14 == null) goto L33;
        r14.setAdapter(new SingleBlockContainerAdapter(this));
    L33:
        RecyclerView r15 = this.f;
        if (r15 == null) goto L36;
        r15.addOnItemTouchListener(new BlockToolDetailFragment$setupScrollBehavior$1());
    L36:
        BlockDetailRequest r16 = this.d;
        if (r16 == null) goto L102;
        Context r17 = getContext();
        if (r17 == null) goto L103;
        t r18 = this.g;
        if (r18 == null) goto L60;
        BlockDetailRequest r19 = this.d;
        if (r19 == null) goto L58;
        String r20 = r19.getTitle();
        if (r20 == null) goto L58;
        if (r20.length() <= 0) goto L51;
        boolean r110 = true;
    L52:
        if (r110 == true) goto L55;
        r20 = null;
    L55:
        if (r20 == null) goto L58;
        r5 = r20;
        goto L58
    L51:
        r110 = false;
    L58:
        r18.a(r5);
    L60:
        if (this.h != null) goto L78;
        Message r111 = r16.getMessage();
        y r21 = S90();
        if (r21 == null) goto L69;
        Function0<BotModel> r22 = r21.l;
        if (r22 == null) goto L69;
        BotModel r23 = (BotModel) r22.invoke();
        if (r23 == null) goto L69;
        BotModel r112 = r23;
    L73:
        String r24 = r16.getMessage().getConversationId();
        if (r24 == null) goto L76;
        Long r113 = StringsKt.toLongOrNull(r24);
    L77:
        this.h = new a0(r111, r112, r113, this.f, "block_detail", null, null, null, null, null, 896);
        goto L78
    L76:
        r113 = null;
    L69:
        String r25 = r16.getMessage().getSenderId();
        if (r25 != null) goto L72;
        r25 = "";
    L72:
        r112 = new BotModel(r25, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    L78:
        y r26 = S90();
        if (r26 == null) goto L81;
        y.a r27 = r26.b();
        r27.C = getParentFragment();
        y r28 = r27.a();
    L82:
        int r29 = b.y;
        b.a r30 = new b.a();
        r30.h = new w(Integer.valueOf(v19.c.b(2130970662, requireActivity(), 2131239046)));
        Boolean r114 = Boolean.TRUE;
        r30.k = new s(r114);
        DeepThinkFoldStatus r115 = DeepThinkFoldStatus.CompleteExpand;
        int r31 = v19.c.b(2130970967, r17, 2131240188);
        r30.i = new r(r115, Integer.valueOf(ContextCompat.getColor(r17, v19.c.b(2130972085, r17, 2131103156))), Integer.valueOf(r31), Integer.valueOf(c7.b(320)), 32);
        r30.m = new u(Integer.valueOf(v19.c.b(2130970662, requireActivity(), 2131239046)), Integer.valueOf(v19.c.b(2130970920, requireActivity(), 2131239998)));
        r30.p = new kc8.k(v19.c.b(2130970662, requireActivity(), 2131239046));
        r30.j = new p(r114);
        r30.g = new x(Integer.valueOf(R.color.transparent));
        RectF r32 = new RectF(c7.b(16), c7.b(12), c7.b(16), c7.b(12));
        int r33 = m0.b(r17) - c7.b(20);
        r30.a = new v0(null, Integer.valueOf(r33), false, false, null, r114, r32, null, null, new l(this), new rb8.m(), new jh8.b(Integer.valueOf(ContextCompat.getColor(r17, v19.c.b(2130972086, r17, 2131103159))), Integer.valueOf(v19.c.b(2130970920, requireActivity(), 2131239998)), 1), null, null, null, 127389);
        r30.v = new w0(ToolBlockInteractType.DisableHeaderInteract, ToolBlockInitStatus.Expand, new com.larus.bmhome.block.presentation.a(getParentFragment(), new n(this)));
        r30.b = r28;
        r30.l = new q(null, r114, null, null, null, null, null, null, null, null, null, null, 8189);
        b r34 = r30.a();
        RecyclerView r35 = this.f;
        if (r35 == null) goto L93;
        Integer r36 = Integer.valueOf(r35.getWidth());
        if (r36.intValue() <= 0) goto L87;
        boolean r37 = true;
    L88:
        if (r37 == false) goto L90;
        Integer r38 = r36;
    L91:
        if (r38 == null) goto L93;
        int r39 = r38.intValue();
    L94:
        int r40 = r39 - c7.b(20);
        hk9.a r41 = this.e;
        if (r41 == null) goto L100;
        r41.b(b.class, r34);
        r41.b(tb8.a.class, new tb8.a(null, null, null, null, false, new o(), 15));
        r41.b(cd8.a.class, new cd8.a(r40, -1));
        ra8.a.d(r41, r16.getBlock(), new f(r16.getMessage(), null, true, true, null, "cot_tool_preview", 466), false);
        RecyclerView r42 = this.f;
        if (r42 == null) goto L101;
        r42.post(new h(this));
        return;
    L101:
        return;
    L100:
        return;
    L90:
        r38 = null;
        goto L91
    L87:
        r37 = false;
    L93:
        r39 = m0.b(r17);
        goto L94
    L81:
        int r43 = y.J;
        y.a r44 = new y.a();
        r44.C = getParentFragment();
        r28 = r44.a();
        goto L82
    L103:
        return;
    L102:
        return;
    L9:
        r9 = false;
    L14:
        r6 = "工具详情";
        goto L15
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131562366, r3, false);
    }
}
