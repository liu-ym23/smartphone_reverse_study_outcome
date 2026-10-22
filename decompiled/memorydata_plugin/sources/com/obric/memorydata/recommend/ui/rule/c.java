package com.obric.memorydata.recommend.ui.rule;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.database.entity.BlockMemoryContentEntity;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ay;
import com.obric.memorydata.utils.ba;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryContentMenuDialog;", "", "anchor", "Landroid/view/View;", "location", "", "contentEntity", "Lcom/obric/memorydata/database/entity/BlockMemoryContentEntity;", "onItemDelete", "Lkotlin/Function1;", "", "blockMemory", "<init>", "(Landroid/view/View;[ILcom/obric/memorydata/database/entity/BlockMemoryContentEntity;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "oPopover", "Lcom/obric/oui/popover/OPopover;", "show", "gravity", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f12740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f12741b;
    private final BlockMemoryContentEntity c;
    private final Function1<BlockMemoryContentEntity, Unit> d;
    private final Function1<BlockMemoryContentEntity, Unit> e;
    private com.obric.oui.popover.b f;

    public c(View r3, int[] r4, BlockMemoryContentEntity r5, Function1<? super BlockMemoryContentEntity, Unit> r6, Function1<? super BlockMemoryContentEntity, Unit> r7) {
        Function1<BlockMemoryContentEntity, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function1<BlockMemoryContentEntity, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "anchor");
        Intrinsics.checkNotNullParameter(r5, "contentEntity");
        Intrinsics.checkNotNullParameter(r8, "onItemDelete");
        this.f12740a = r3;
        this.f12741b = r4;
        this.c = r5;
        this.d = r8;
        this.e = r9;
    }

    private static final Unit a(c r0, View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        r0.e.invoke(r0.c);
        com.obric.oui.popover.b r3 = r0.f;
        if (r3 == null) goto L6;
        r3.dismiss();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit b(c r0, View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        r0.d.invoke(r0.c);
        com.obric.oui.popover.b r3 = r0.f;
        if (r3 == null) goto L6;
        r3.dismiss();
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$5sbx9_bTD-kTPnIMR1HF4kZAahA, reason: not valid java name */
    public static /* synthetic */ Unit m1161lambda$5sbx9_bTDkTPnIMR1HF4kZAahA(c r0, View r1, int r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$WDUjXTShOzs8b-N_LilVtuButbs, reason: not valid java name */
    public static /* synthetic */ Unit m1162lambda$WDUjXTShOzs8bN_LilVtuButbs(c r0, View r1, int r2) {
        return b(r0, r1, r2);
    }

    public final void a(int r20) {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f12740a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "getContext(...)");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r1), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        OPopoverEntranceMenuView.Builder r15 = new OPopoverEntranceMenuView.Builder((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"));
        if (this.e == null) goto L9;
        OPopoverEntranceMenuView.Builder.a(r15, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_block_memory_menu_edit, "drawable", "ic_block_memory_menu_edit")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r2.getString(ZeusTransformUtils.mapRes(R.string.screen_memory_block_menu_edit, TypedValues.Custom.S_STRING, "screen_memory_block_menu_edit")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$c$5sbx9_bTDkTPnIMR1HF4kZAahA(this), 246, null);
    L9:
        OPopoverEntranceMenuView.Builder.a(r15, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_block_memory_menu_delete, "drawable", "ic_block_memory_menu_delete")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r2.getString(ZeusTransformUtils.mapRes(R.string.screen_memory_block_menu_delete, TypedValues.Custom.S_STRING, "screen_memory_block_menu_delete")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, true, null, new $$Lambda$c$WDUjXTShOzs8bN_LilVtuButbs(this), 182, null);
        OPopoverEntranceMenuView r3 = r15.c();
        com.obric.oui.popover.b r4 = new com.obric.oui.popover.b.a(r2).a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")).R();
        if (this.f12741b == null) goto L12;
        com.obric.oui.popover.d r5 = com.obric.oui.popover.d.f14328a;
        int[] r6 = this.f12741b;
        r5.a(r2, r4, r6[0], r6[1]);
    L17:
        this.f = r4;
        return;
    L12:
        com.obric.oui.popover.c r7 = com.obric.oui.popover.c.f14327a;
        View r8 = this.f12740a;
        if (r20 != 80) goto L15;
        int r9 = 2;
    L16:
        com.obric.oui.popover.c.a(r7, r4, r8, r20, true, 0.0f, 0, ay.a((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r9), Number.class, "com.obric.memorydata.plugin")), false, 0, 0, false, 1920, null);
        goto L17
    L15:
        r9 = -2;
        goto L16
    }
}
