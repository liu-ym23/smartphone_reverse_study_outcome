package com.obric.memorydata.memory.ui.automemory;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.plugin.R;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001ar\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0000\u001a4\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0000¨\u0006\u0016"}, d2 = {"showAutoMemoryCollectionMoreMenu", "Lcom/obric/oui/popover/v2/OPopover;", "activity", "Landroid/app/Activity;", "anchor", "Landroid/view/View;", "isPaused", "", "rawPos", "", "showAtAnchorRight", "onTogglePaused", "Lkotlin/Function0;", "", "onEdit", "onDelete", "onDismiss", "showAutoMemoryCollectionDeleteDialog", "title", "", "message", "onConfirm", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class e {
    /* JADX WARN: Type inference failed for: r12v9, types: [T, com.obric.oui.popover.v2.a] */
    public static final com.obric.oui.popover.v2.a a(Activity r26, View r27, boolean r28, int[] r29, boolean r30, Function0<Unit> r31, Function0<Unit> r32, Function0<Unit> r33, Function0<Unit> r34) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r26, Activity.class, "com.obric.memorydata.plugin");
        final Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r31, Function0.class, "com.obric.memorydata.plugin");
        final Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r32, Function0.class, "com.obric.memorydata.plugin");
        final Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r33, Function0.class, "com.obric.memorydata.plugin");
        final Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r34, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r27, "anchor");
        Intrinsics.checkNotNullParameter(r3, "onTogglePaused");
        Intrinsics.checkNotNullParameter(r4, "onEdit");
        Intrinsics.checkNotNullParameter(r5, "onDelete");
        OPopoverEntranceMenuView.Builder r6 = new OPopoverEntranceMenuView.Builder((Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.memorydata.plugin"));
        int r7 = r1.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1"));
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        if (r28 == false) goto L5;
        int r9 = R.drawable.ic_auto_memory_menu_resume;
        String r13 = "ic_auto_memory_menu_resume";
    L6:
        Integer r14 = Integer.valueOf(ZeusTransformUtils.mapRes(r9, "drawable", r13));
        Integer r16 = Integer.valueOf(r7);
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r28 == false) goto L9;
        int r15 = ZeusTransformUtils.mapRes(R.string.memory_auto_memory_resume, TypedValues.Custom.S_STRING, "memory_auto_memory_resume");
    L10:
        OPopoverEntranceMenuView.Builder.a(r6, r14, null, r16, (CharSequence) ZeusTransformUtils.preCheckCast(r11.getString(r15), CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$e$XQ2rg4ORtXr4IWedvRoA8IQaLTM(r10, r3), 242, null);
        OPopoverEntranceMenuView.Builder.a(r6, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_edit, "drawable", "ic_memory_edit")), null, Integer.valueOf(r7), (CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_memory_collection_edit_content, TypedValues.Custom.S_STRING, "memory_memory_collection_edit_content")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$e$4q9POPuWIbw8uokmHc8sKzQ5ySQ(r10, r4), 242, null);
        OPopoverEntranceMenuView.Builder.a(r6, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_menu_delete, "drawable", "ic_memory_list_menu_delete")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_confirm, TypedValues.Custom.S_STRING, "memory_card_delete_notice_confirm")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, true, null, new $$Lambda$e$l_uSs5oW6mmenWid1gqGytvFK3Y(r10, r5), 182, null);
        ?? r17 = ((com.obric.oui.popover.v2.a.C0765a) ZeusTransformUtils.preCheckCast(new com.obric.oui.popover.v2.a.C0765a((Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.memorydata.plugin")).a((View) ZeusTransformUtils.preCheckCast(r6.c(), View.class, "com.obric.memorydata.plugin")), com.obric.oui.popover.v2.a.C0765a.class, "com.obric.memorydata.plugin")).F();
        if (r29 != null) goto L13;
    L15:
        if (r30 == false) goto L17;
        com.obric.oui.popover.v2.e.a(com.obric.oui.popover.v2.e.f14366a, r17, r27, 5, false, 0, false, 0, 0, 248, null);
    L18:
        r10.element = r17;
        ((com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r10.element, com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin")).setOnDismissListener(new $$Lambda$e$dTyaZ3a8DHLdJCS6haZghmBJ0JE(r12));
        return (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r10.element, com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
    L17:
        int[] r0 = new int[2];
        r27.getLocationOnScreen(r0);
        com.obric.oui.popover.v2.e.a(com.obric.oui.popover.v2.e.f14366a, r1, r17, r0[0] + r27.getWidth(), (r0[1] + r27.getHeight()) - MathKt.roundToInt(TypedValue.applyDimension(1, 48, Resources.getSystem().getDisplayMetrics())), false, 0, 48, null);
        goto L18
    L13:
        if (r29.length < 2) goto L15;
        com.obric.oui.popover.v2.e.a(com.obric.oui.popover.v2.e.f14366a, r1, r17, r29[0], r29[1], false, 0, 48, null);
        goto L18
    L9:
        r15 = ZeusTransformUtils.mapRes(R.string.memory_auto_memory_pause, TypedValues.Custom.S_STRING, "memory_auto_memory_pause");
        goto L10
    L5:
        r9 = R.drawable.ic_auto_memory_menu_pause;
        r13 = "ic_auto_memory_menu_pause";
        goto L6
    }

    public static /* synthetic */ com.obric.oui.popover.v2.a a(Activity r12, View r13, boolean r14, int[] r15, boolean r16, Function0 r17, Function0 r18, Function0 r19, Function0 r20, int r21, Object r22) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r12, Activity.class, "com.obric.memorydata.plugin");
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r17, Function0.class, "com.obric.memorydata.plugin");
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r18, Function0.class, "com.obric.memorydata.plugin");
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r19, Function0.class, "com.obric.memorydata.plugin");
        Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
        if ((r21 & 8) == 0) goto L5;
        int[] r6 = null;
    L7:
        if ((r21 & 16) == 0) goto L9;
        boolean r7 = false;
    L11:
        if ((r21 & 256) == 0) goto L13;
        Function0 r11 = null;
    L15:
        return a(r3, r13, r14, r6, r7, r8, r9, r10, r11);
    L13:
        r11 = r1;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
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

    public static final void a(Activity r5, String r6, String r7, Function0<Unit> r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.memorydata.plugin");
        final Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(r6, "title");
        Intrinsics.checkNotNullParameter(r10, "onConfirm");
        com.obric.oui.dialog.v2.alert.b r11 = com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).a(true);
        String r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_cancel, TypedValues.Custom.S_STRING, "memory_card_delete_notice_cancel"));
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");
        com.obric.oui.dialog.v2.alert.b r13 = r11.b((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$e$gUKSXEJ1_tzVaIc9V8KPi8WwQ.INSTANCE);
        String r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_confirm, TypedValues.Custom.S_STRING, "memory_card_delete_notice_confirm"));
        Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r15 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(r13.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$e$mfNYKJ_SWi7b7sn4WBz8vDhZHCE(r10)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r15.setCanceledOnTouchOutside(true);
        r15.setCancelable(true);
        r15.show();
    }

    public static /* synthetic */ void a(Activity r3, String r4, String r5, Function0 r6, int r7, Object r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        if ((r7 & 2) == 0) goto L6;
        r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_delete_memory_collection_title, TypedValues.Custom.S_STRING, "memory_delete_memory_collection_title"));
    L6:
        if ((r7 & 4) == 0) goto L8;
        r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_delete_memory_collection_content, TypedValues.Custom.S_STRING, "memory_delete_memory_collection_content"));
    L8:
        a(r9, r4, r5, r10);
    }

    private static final void a(Function0 r2) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        r3.invoke();
        return;
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

    public static /* synthetic */ Unit lambda$4q9POPuWIbw8uokmHc8sKzQ5ySQ(Ref.ObjectRef r0, Function0 r1, View r2, int r3) {
        return b(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$XQ2rg4ORtXr4IWedvRoA8IQaLTM(Ref.ObjectRef r0, Function0 r1, View r2, int r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$dTyaZ3a8DHLdJCS6haZghmBJ0JE(Function0 r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$gUKSXEJ1_tzVaIc9V8KPi8--WwQ, reason: not valid java name */
    public static /* synthetic */ Unit m799lambda$gUKSXEJ1_tzVaIc9V8KPi8WwQ(DialogInterface r0, int r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$l_uSs5oW6mmenWid1gqGytvFK3Y(Ref.ObjectRef r0, Function0 r1, View r2, int r3) {
        return c(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$mfNYKJ_SWi7b7sn4WBz8vDhZHCE(Function0 r0, DialogInterface r1, int r2) {
        return a(r0, r1, r2);
    }
}
