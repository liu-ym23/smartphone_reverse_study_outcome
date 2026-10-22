package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.memory.databinding.ItemPendingPersonalInfoCardBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u000bJ\u0014\u0010\r\u001a\u00020\u0005*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoCardBinder;", "", "<init>", "()V", "bind", "", "binding", "Lcom/obric/memorydata/memory/databinding/ItemPendingPersonalInfoCardBinding;", "item", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", "onConfirm", "Lkotlin/Function1;", "onIgnore", "setOperating", "Lcom/obric/oui/button/OButton;", "operating", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aq f11203a = null;

    static {
        f11203a = new aq();
    }

    private aq() {
    }

    private final void a(OButton r2, boolean r3) {
        if (r2.isEnabled() != (!r3)) goto L5;
        return;
    L5:
        r2.resetAlphaAnim();
        r2.setEnabled(!r3);
    }

    private static final void a(Function1 r1, ar r2, View r3) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r1, Function1.class, "com.obric.memorydata.plugin")).invoke(r2);
    }

    private static final void b(Function1 r1, ar r2, View r3) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r1, Function1.class, "com.obric.memorydata.plugin")).invoke(r2);
    }

    public static /* synthetic */ void lambda$DE7x5Fd2smWbzL9HohhPRNaLOzg(Function1 r0, ar r1, View r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$PL8L_q8AdUZllBGPgelbDgNBobI(Function1 r0, ar r1, View r2) {
        a(r0, r1, r2);
    }

    public final void a(ItemPendingPersonalInfoCardBinding r7, final ar r8, Function1<? super ar, Unit> r9, Function1<? super ar, Unit> r10) {
        final Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        final Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "binding");
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r11, "onConfirm");
        Intrinsics.checkNotNullParameter(r12, "onIgnore");
        r7.pendingContent.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8.c(), CharSequence.class, "com.obric.memorydata.plugin"));
        OTextView r0 = r7.pendingSource;
        String r2 = r8.d();
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        r2 = null;
    L12:
        if (r2 != null) goto L15;
        r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_pending_source_default, TypedValues.Custom.S_STRING, "memory_pending_source_default"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
    L15:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        OButton r1 = r7.pendingConfirm;
        Intrinsics.checkNotNullExpressionValue(r1, "pendingConfirm");
        a(r1, r8.h());
        OButton r5 = r7.pendingIgnore;
        Intrinsics.checkNotNullExpressionValue(r5, "pendingIgnore");
        a(r5, r8.h());
        r7.pendingConfirm.setOnClickListener(new $$Lambda$aq$PL8L_q8AdUZllBGPgelbDgNBobI(r11, r8));
        r7.pendingIgnore.setOnClickListener(new $$Lambda$aq$DE7x5Fd2smWbzL9HohhPRNaLOzg(r12, r8));
        return;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r4 = false;
        goto L9
    }
}
