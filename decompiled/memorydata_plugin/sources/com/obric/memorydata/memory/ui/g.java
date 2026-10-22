package com.obric.memorydata.memory.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.ba;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B©\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/ui/MemoryOperationMenuDialog;", "", "anchor", "Landroid/view/View;", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "location", "", "onItemDelete", "Lkotlin/Function1;", "", "onItemDislike", "multiSelect", "blockMemory", "onItemFeedback", "onDismiss", "Lkotlin/Function0;", "<init>", "(Landroid/view/View;Lcom/obric/memorydata/memory/ui/data/MemoryItem;[ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "oPopover", "Lcom/obric/oui/popover/v2/OPopover;", "show", "gravity", "", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10964a = null;
    private static final CopyOnWriteArrayList<WeakReference<com.obric.oui.popover.v2.a>> l = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f10965b;
    private final com.obric.memorydata.memory.ui.data.a c;
    private final int[] d;
    private final Function1<com.obric.memorydata.memory.ui.data.a, Unit> e;
    private final Function1<com.obric.memorydata.memory.ui.data.a, Unit> f;
    private final Function1<com.obric.memorydata.memory.ui.data.a, Unit> g;
    private final Function1<com.obric.memorydata.memory.ui.data.a, Unit> h;
    private final Function1<com.obric.memorydata.memory.ui.data.a, Unit> i;
    private final Function0<Unit> j;
    private com.obric.oui.popover.v2.a k;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/MemoryOperationMenuDialog$Companion;", "", "<init>", "()V", "TAG", "", "currentShowPopovers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/popover/v2/OPopover;", "closeAllPopover", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private static final boolean a(WeakReference r0) {
            if (r0.get() != null) goto L5;
            return true;
        L5:
            return false;
        }

        private static final boolean a(Function1 r2, Object r3) {
            return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        private static final Unit b() {
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(g.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            com.obric.oui.popover.v2.a r1 = (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L4;
            r1.dismiss();
            goto L4
        L9:
            return Unit.INSTANCE;
        }

        public static /* synthetic */ boolean lambda$RJijnraWQyvSSSdT4d1DFVZCorc(WeakReference r0) {
            return a(r0);
        }

        public static /* synthetic */ boolean lambda$VAm5Eg78MlKZyzE19U5p2qyzpCw(Function1 r0, Object r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ Unit lambda$pgAf955A0YCmIs4HJ9FwDRDHx88() {
            return b();
        }

        public final void a() {
            if ((!((Collection) ZeusTransformUtils.preCheckCast(g.a(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
            com.obric.memorydata.utils.j.a($$Lambda$g$a$pgAf955A0YCmIs4HJ9FwDRDHx88.INSTANCE);
        L5:
            CopyOnWriteArrayList r2 = g.a();
            final $$Lambda$g$a$RJijnraWQyvSSSdT4d1DFVZCorc r0 = $$Lambda$g$a$RJijnraWQyvSSSdT4d1DFVZCorc.INSTANCE;
            r2.removeIf(new $$Lambda$g$a$VAm5Eg78MlKZyzE19U5p2qyzpCw(r0));
        }
    }

    static {
        f10964a = new a(null);
        l = new CopyOnWriteArrayList();
    }

    public g(View r3, com.obric.memorydata.memory.ui.data.a r4, int[] r5, Function1<? super com.obric.memorydata.memory.ui.data.a, Unit> r6, Function1<? super com.obric.memorydata.memory.ui.data.a, Unit> r7, Function1<? super com.obric.memorydata.memory.ui.data.a, Unit> r8, Function1<? super com.obric.memorydata.memory.ui.data.a, Unit> r9, Function1<? super com.obric.memorydata.memory.ui.data.a, Unit> r10, Function0<Unit> r11) {
        Function1<com.obric.memorydata.memory.ui.data.a, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function1<com.obric.memorydata.memory.ui.data.a, Unit> r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Function1<com.obric.memorydata.memory.ui.data.a, Unit> r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Function1<com.obric.memorydata.memory.ui.data.a, Unit> r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Function1<com.obric.memorydata.memory.ui.data.a, Unit> r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Function0<Unit> r17 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "anchor");
        Intrinsics.checkNotNullParameter(r4, "memoryItem");
        Intrinsics.checkNotNullParameter(r12, "onItemDelete");
        this.f10965b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
    }

    public /* synthetic */ g(View r14, com.obric.memorydata.memory.ui.data.a r15, int[] r16, Function1 r17, Function1 r18, Function1 r19, Function1 r20, Function1 r21, Function0 r22, int r23, DefaultConstructorMarker r24) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r17, Function1.class, "com.obric.memorydata.plugin");
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r20, Function1.class, "com.obric.memorydata.plugin");
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r22, Function0.class, "com.obric.memorydata.plugin");
        if ((r23 & 4) == 0) goto L5;
        int[] r6 = null;
    L7:
        if ((r23 & 16) == 0) goto L10;
        r1 = null;
    L10:
        if ((r23 & 32) == 0) goto L12;
        Function1 r9 = null;
    L14:
        if ((r23 & 64) == 0) goto L16;
        Function1 r10 = null;
    L18:
        if ((r23 & 128) == 0) goto L20;
        Function1 r11 = null;
    L22:
        if ((r23 & 256) == 0) goto L24;
        Function0 r12 = null;
    L25:
        this(r14, r15, r6, r7, r1, r9, r10, r11, r12);
        return;
    L24:
        r12 = r2;
        goto L25
    L20:
        r11 = r5;
        goto L22
    L16:
        r10 = r4;
        goto L18
    L12:
        r9 = r3;
        goto L14
    L5:
        r6 = r16;
        goto L7
    }

    public static final /* synthetic */ CopyOnWriteArrayList a() {
        return l;
    }

    private static final Unit a(g r0, View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        r0.g.invoke(r0.c);
        com.obric.oui.popover.v2.a r3 = r0.k;
        if (r3 == null) goto L6;
        r3.dismiss();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit a(Function1 r1, g r2, View r3, int r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r1, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        r5.invoke(r2.c);
        com.obric.oui.popover.v2.a r6 = r2.k;
        if (r6 == null) goto L6;
        r6.dismiss();
    L6:
        return Unit.INSTANCE;
    }

    private static final void a(final g r3) {
        CopyOnWriteArrayList<WeakReference<com.obric.oui.popover.v2.a>> r0 = l;
        final Function1 r1 = new $$Lambda$g$Kkb8fonDdmBpeuUPTq0TgMGJAFI(r3);
        r0.removeIf(new $$Lambda$g$5V1mAGaFGyNafrjrYCxJNs8KJ5U(r1));
        Function0<Unit> r4 = r3.j;
        if (r4 == null) goto L6;
        r4.invoke();
        return;
    }

    private static final boolean a(g r0, WeakReference r1) {
        return Intrinsics.areEqual(r1.get(), r0.k);
    }

    private static final boolean a(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final Unit b(g r0, View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        r0.h.invoke(r0.c);
        com.obric.oui.popover.v2.a r3 = r0.k;
        if (r3 == null) goto L6;
        r3.dismiss();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit c(g r0, View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        r0.f.invoke(r0.c);
        com.obric.oui.popover.v2.a r3 = r0.k;
        if (r3 == null) goto L6;
        r3.dismiss();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit d(g r0, View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        r0.e.invoke(r0.c);
        com.obric.oui.popover.v2.a r3 = r0.k;
        if (r3 == null) goto L6;
        r3.dismiss();
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ boolean lambda$5V1mAGaFGyNafrjrYCxJNs8KJ5U(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$Kkb8fonDdmBpeuUPTq0TgMGJAFI(g r0, WeakReference r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$WKoINVnWKR_yg26_KF0PhHB6jJs(g r0, View r1, int r2) {
        return b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$ZgpqfXIK1vw-lVUrZqExP1hugFY, reason: not valid java name */
    public static /* synthetic */ Unit m863lambda$ZgpqfXIK1vwlVUrZqExP1hugFY(Function1 r0, g r1, View r2, int r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$sxZ1ZIDoFE4iGpXC9xDzw3f81yY(g r0, View r1, int r2) {
        return c(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$w7-XTL6KUSExt_NsnoUQ1vbDyY4, reason: not valid java name */
    public static /* synthetic */ Unit m864lambda$w7XTL6KUSExt_NsnoUQ1vbDyY4(g r0, View r1, int r2) {
        return d(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$x7BQw_91IKx6NLLdDoxLVa_ezrE(g r0, View r1, int r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$xqPXpgNZoXuOa12fMrc66lzQsWQ(g r0) {
        a(r0);
    }

    public final void a(int r24) {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f10965b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "getContext(...)");
        Activity r4 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r1), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L27;
        OPopoverEntranceMenuView.Builder r2 = new OPopoverEntranceMenuView.Builder((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"));
        if (this.g == null) goto L9;
        OPopoverEntranceMenuView.Builder.a(r2, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_menu_multi_select, "drawable", "ic_memory_list_menu_multi_select")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.memory_card_menu_multi_select_text, TypedValues.Custom.S_STRING, "memory_card_menu_multi_select_text")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$g$x7BQw_91IKx6NLLdDoxLVa_ezrE(this), 246, null);
    L9:
        if (this.h == null) goto L11;
        r2.a(MathKt.roundToInt(TypedValue.applyDimension(1, 200, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 240, Resources.getSystem().getDisplayMetrics())));
        String r19 = "drawable";
        OPopoverEntranceMenuView.Builder.a(r2, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_menu_block, "drawable", "ic_memory_list_menu_block")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.memory_card_menu_block_text, TypedValues.Custom.S_STRING, "memory_card_menu_block_text")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$g$WKoINVnWKR_yg26_KF0PhHB6jJs(this), 246, null);
    L13:
        if (this.f != null) goto L15;
    L17:
        String r21 = r19;
    L18:
        final Function1<com.obric.memorydata.memory.ui.data.a, Unit> r5 = this.i;
        if (r5 == null) goto L21;
        String r15 = r21;
        String r22 = r15;
        OPopoverEntranceMenuView.Builder.a(r2, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_menu_feedback, r15, "ic_memory_list_menu_feedback")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.memory_card_menu_feedback_text, r15, "memory_card_menu_feedback_text")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$g$ZgpqfXIK1vwlVUrZqExP1hugFY(r5, this), 182, null);
    L22:
        OPopoverEntranceMenuView.Builder.a(r2, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_menu_delete, r22, "ic_memory_list_menu_delete")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.memory_card_menu_delete_text, r15, "memory_card_menu_delete_text")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, true, null, new $$Lambda$g$w7XTL6KUSExt_NsnoUQ1vbDyY4(this), 182, null);
        com.obric.oui.popover.v2.a r3 = ((com.obric.oui.popover.v2.a.C0765a) ZeusTransformUtils.preCheckCast(new com.obric.oui.popover.v2.a.C0765a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin")).a((View) ZeusTransformUtils.preCheckCast(r2.c(), View.class, "com.obric.memorydata.plugin")), com.obric.oui.popover.v2.a.C0765a.class, "com.obric.memorydata.plugin")).F();
        if (this.d == null) goto L25;
        com.obric.oui.popover.v2.e r6 = com.obric.oui.popover.v2.e.f14366a;
        int[] r7 = this.d;
        com.obric.oui.popover.v2.e.a(r6, r4, r3, r7[0], r7[1], false, 0, 48, null);
    L26:
        this.k = r3;
    L30:
        com.obric.oui.popover.v2.a r8 = this.k;
        if (r8 == null) goto L33;
        r8.setOnDismissListener(new $$Lambda$g$xqPXpgNZoXuOa12fMrc66lzQsWQ(this));
    L33:
        l.add(new WeakReference(this.k));
        return;
    L25:
        com.obric.oui.popover.v2.e.a(com.obric.oui.popover.v2.e.f14366a, r3, this.f10965b, 17, false, 0, false, 0, 0, 248, null);
        goto L26
    L21:
        r22 = r21;
        goto L22
    L15:
        if (AppContext.INSTANCE.isDebug() == false) goto L17;
        String r16 = r19;
        int r9 = ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_menu_dislike, r16, "ic_memory_list_menu_dislike");
        String r10 = at.a(ZeusTransformUtils.mapRes(R.string.memory_card_menu_dislike_text, r15, "memory_card_menu_dislike_text"));
        r21 = r16;
        OPopoverEntranceMenuView.Builder.a(r2, Integer.valueOf(r9), null, Integer.valueOf(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_text_1, TypedValues.Custom.S_COLOR, "oui_text_1"))), (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$g$sxZ1ZIDoFE4iGpXC9xDzw3f81yY(this), 242, null);
        goto L18
    L11:
        r19 = r14;
        goto L13
    L27:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryOperationMenuDialog", "Activity is null, cannot show menu", null, 4, null);
        Function0<Unit> r11 = this.j;
        if (r11 == null) goto L30;
        r11.invoke();
        goto L30
    }
}
