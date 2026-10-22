package com.obric.memorydata.memory.ui.automemory.memorylist;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u001aX\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002\u001a,\u0010\u0010\u001a\u00020\f*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"EXTRA_COLLECTION_ID", "", "EXTRA_TITLE", "showItemOperationMenu", "Lcom/obric/oui/popover/v2/OPopover;", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionListActivity;", "anchor", "Landroid/view/View;", "rawPos", "", "onMultiSelect", "Lkotlin/Function0;", "", "onExport", "onFeedback", "onDelete", "showDeleteDialog", "title", "message", "onConfirm", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class e {
    public static final /* synthetic */ com.obric.oui.popover.v2.a a(AutoMemoryCollectionListActivity r9, View r10, int[] r11, Function0 r12, Function0 r13, Function0 r14, Function0 r15) {
        return b((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r9, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin"), r10, r11, (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit a(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        r3.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit a(Function0 r1, DialogInterface r2, int r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r1, Function0.class, "com.obric.memorydata.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "dialog");
        r4.invoke();
        r5.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit a(Ref.BooleanRef r1, Ref.ObjectRef r2, Function0 r3, View r4, int r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        r1.element = true;
        com.obric.oui.popover.v2.a r7 = (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r2.element, com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L5;
        r7.dismiss();
    L5:
        r6.invoke();
        return Unit.INSTANCE;
    }

    private static final Unit a(Ref.ObjectRef r1, Function0 r2, View r3, int r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        com.obric.oui.popover.v2.a r6 = (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r1.element, com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L5;
        r6.dismiss();
    L5:
        r5.invoke();
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(AutoMemoryCollectionListActivity r2, String r3, String r4, Function0 r5) {
        b((AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin"), r3, r4, (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(Ref.BooleanRef r1, View r2) {
        if (r1.element == false) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, OCardListItem.class) == false) goto L7;
        OCardListItem r3 = (OCardListItem) ZeusTransformUtils.preCheckCast(r2, OCardListItem.class, "com.obric.memorydata.plugin");
    L8:
        if (r3 == null) goto L12;
        r3.setSelected(false);
        return;
    L12:
        return;
    L7:
        r3 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r4v16, types: [T, com.obric.oui.popover.v2.a] */
    private static final com.obric.oui.popover.v2.a b(AutoMemoryCollectionListActivity r29, final View r30, int[] r31, Function0<Unit> r32, Function0<Unit> r33, Function0<Unit> r34, Function0<Unit> r35) {
        AutoMemoryCollectionListActivity r2 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r29, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        final Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r32, Function0.class, "com.obric.memorydata.plugin");
        final Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r33, Function0.class, "com.obric.memorydata.plugin");
        final Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r34, Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r35, Function0.class, "com.obric.memorydata.plugin");
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        final Ref.BooleanRef r9 = new Ref.BooleanRef();
        OPopoverEntranceMenuView.Builder r15 = new OPopoverEntranceMenuView.Builder((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"));
        OPopoverEntranceMenuView.Builder.a(r15, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_menu_multi_select, "drawable", "ic_memory_list_menu_multi_select")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r2.getString(ZeusTransformUtils.mapRes(R.string.memory_card_menu_multi_select_text, TypedValues.Custom.S_STRING, "memory_card_menu_multi_select_text")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$e$8v0mjJQ7Kn4ZqgpJPitcbzg6Svk(r9, r8, r4), 182, null);
        if (r5 == null) goto L5;
        String r27 = "drawable";
        OPopoverEntranceMenuView.Builder.a(r15, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_export_data, "drawable", "ic_memory_export_data")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r2.getString(ZeusTransformUtils.mapRes(R.string.memory_card_menu_export_build_package_text, TypedValues.Custom.S_STRING, "memory_card_menu_export_build_package_text")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$e$Va5ukTyv6hkpYRdTZFdhXiKam14(r8, r5), 182, null);
    L6:
        String r16 = r27;
        OPopoverEntranceMenuView.Builder.a(r15, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_menu_feedback, r16, "ic_memory_list_menu_feedback")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r2.getString(ZeusTransformUtils.mapRes(R.string.memory_card_menu_feedback_text, TypedValues.Custom.S_STRING, "memory_card_menu_feedback_text")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$e$jy2wbrCtFxMN4h41ne1YNZ2JPc(r8, r6), 182, null);
        OPopoverEntranceMenuView.Builder.a(r15, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_menu_delete, r16, "ic_memory_list_menu_delete")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r2.getString(ZeusTransformUtils.mapRes(R.string.memory_detail_notice_delete, TypedValues.Custom.S_STRING, "memory_detail_notice_delete")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, true, null, new $$Lambda$e$lYrVg4FNdbco4NUWz4l8RzyeqG8(r8, r7), 182, null);
        ?? r10 = ((com.obric.oui.popover.v2.a.C0765a) ZeusTransformUtils.preCheckCast(new com.obric.oui.popover.v2.a.C0765a((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin")).a((View) ZeusTransformUtils.preCheckCast(r15.c(), View.class, "com.obric.memorydata.plugin")), com.obric.oui.popover.v2.a.C0765a.class, "com.obric.memorydata.plugin")).F();
        if (r31 != null) goto L9;
    L11:
        int[] r1 = new int[2];
        r30.getLocationOnScreen(r1);
        int r13 = r1[0] + r30.getWidth();
        int r14 = (r1[1] + r30.getHeight()) + MathKt.roundToInt(TypedValue.applyDimension(1, 2, Resources.getSystem().getDisplayMetrics()));
        com.obric.oui.popover.v2.e r11 = com.obric.oui.popover.v2.e.f14366a;
        Activity r12 = (Activity) ZeusTransformUtils.preCheckCast(r2, Activity.class, "com.obric.memorydata.plugin");
    L12:
        com.obric.oui.popover.v2.e.a(r11, r12, r10, r13, r14, false, 0, 48, null);
        r8.element = r10;
        ((com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r8.element, com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin")).setOnDismissListener(new $$Lambda$e$woTwVsFJljzYOm2u53eXg7I6xc(r9, r30));
        return (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r8.element, com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
    L9:
        if (r31.length < 2) goto L11;
        r11 = com.obric.oui.popover.v2.e.f14366a;
        r12 = (Activity) ZeusTransformUtils.preCheckCast(r2, Activity.class, "com.obric.memorydata.plugin");
        r13 = r31[0];
        r14 = r31[1];
        goto L12
    L5:
        r27 = "drawable";
        goto L6
    }

    private static final Unit b(Ref.ObjectRef r1, Function0 r2, View r3, int r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        com.obric.oui.popover.v2.a r6 = (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r1.element, com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L5;
        r6.dismiss();
    L5:
        r5.invoke();
        return Unit.INSTANCE;
    }

    private static final void b(AutoMemoryCollectionListActivity r5, String r6, String r7, Function0<Unit> r8) {
        AutoMemoryCollectionListActivity r9 = (AutoMemoryCollectionListActivity) ZeusTransformUtils.wrapperContextForParams(r5, AutoMemoryCollectionListActivity.class, "com.obric.memorydata.plugin");
        final Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        com.obric.oui.dialog.v2.alert.b r11 = com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).a(true);
        String r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_cancel, TypedValues.Custom.S_STRING, "memory_card_delete_notice_cancel"));
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");
        com.obric.oui.dialog.v2.alert.b r13 = r11.b((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$e$NJUn6NPPuhsQQavbVjoc3LqFsM.INSTANCE);
        String r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_detail_notice_delete, TypedValues.Custom.S_STRING, "memory_detail_notice_delete"));
        Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r15 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(r13.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$e$aPwxPlIL75zG0VaWAa78rN2vjQ(r10)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r15.setCanceledOnTouchOutside(true);
        r15.setCancelable(true);
        r15.show();
    }

    private static final Unit c(Ref.ObjectRef r1, Function0 r2, View r3, int r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        com.obric.oui.popover.v2.a r6 = (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r1.element, com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L5;
        r6.dismiss();
    L5:
        r5.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$-aPwxPlIL75zG0VaWAa78rN2vjQ, reason: not valid java name */
    public static /* synthetic */ Unit m809lambda$aPwxPlIL75zG0VaWAa78rN2vjQ(Function0 r0, DialogInterface r1, int r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$8v0mjJQ7Kn4ZqgpJPitcbzg6Svk(Ref.BooleanRef r0, Ref.ObjectRef r1, Function0 r2, View r3, int r4) {
        return a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$NJUn6-NPPuhsQQavbVjoc3LqFsM, reason: not valid java name */
    public static /* synthetic */ Unit m810lambda$NJUn6NPPuhsQQavbVjoc3LqFsM(DialogInterface r0, int r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$Va5ukTyv6hkpYRdTZFdhXiKam14(Ref.ObjectRef r0, Function0 r1, View r2, int r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$jy2wbr-CtFxMN4h41ne1YNZ2JPc, reason: not valid java name */
    public static /* synthetic */ Unit m811lambda$jy2wbrCtFxMN4h41ne1YNZ2JPc(Ref.ObjectRef r0, Function0 r1, View r2, int r3) {
        return b(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$lYrVg4FNdbco4NUWz4l8RzyeqG8(Ref.ObjectRef r0, Function0 r1, View r2, int r3) {
        return c(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$woTwVsFJljzY-Om2u53eXg7I6xc, reason: not valid java name */
    public static /* synthetic */ void m812lambda$woTwVsFJljzYOm2u53eXg7I6xc(Ref.BooleanRef r0, View r1) {
        a(r0, r1);
    }
}
