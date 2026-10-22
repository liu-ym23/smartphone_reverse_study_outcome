package com.bytedance.android.live.revlink.impl.multianchor.pk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000b\u0010\u000fB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0012J \u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/pk/PkSwitchMultiSelectPkView;", "Landroid/widget/LinearLayout;", "", "Lcom/bytedance/android/livesdk/link/model/p;", "anchorLinkUserList", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "update", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkSwitchMultiSelectPkView extends LinearLayout {
    public PkSwitchMultiSelectPkView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        setOrientation(1);
    }

    public PkSwitchMultiSelectPkView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        setOrientation(1);
    }

    public final void update(List<? extends p> r12, DataCenter r13) {
        Intrinsics.checkNotNullParameter(r12, "anchorLinkUserList");
        removeAllViews();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r12.iterator();
    L3:
        int r1 = 0;
        if (r15.hasNext() == false) goto L11;
        Object r0 = r15.next();
        if (((p) r0) == null) goto L8;
        r1 = 1;
    L8:
        if (r1 == 0) goto L3;
        r14.add(r0);
        goto L3
    L11:
        if (r14.isEmpty() == false) goto L14;
        return;
    L14:
        if (r14.size() >= 4) goto L16;
        int r16 = 50;
    L18:
        if (r14.size() > 4) goto L21;
        int r2 = 16;
    L25:
        if (r14.size() > 6) goto L33;
        b03.a r3 = b03.a.a;
        int r4 = (((s1.y() - UtilityKotlinExtentionsKt.i(32)) - (UtilityKotlinExtentionsKt.i(r16) * 2)) / r14.size()) - (UtilityKotlinExtentionsKt.i(r2) * 2);
        LinearLayout r17 = new LinearLayout(getContext());
        r17.setOrientation(0);
        int r5 = r14.size();
    L27:
        if (r1 >= r5) goto L32;
        MultiAnchorLinkInfoTopSelectSubView r6 = new MultiAnchorLinkInfoTopSelectSubView(getContext());
        p r7 = (p) ListProtector.get(r14, r1);
        if (r7 == null) goto L31;
        r6.b(r7, r4);
    L31:
        UtilityKotlinExtentionsKt.w(r6);
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(r4, -2);
        r8.gravity = 17;
        r8.leftMargin = UtilityKotlinExtentionsKt.i(r2);
        r8.rightMargin = UtilityKotlinExtentionsKt.i(r2);
        r17.addView(r6, r8);
        r1 = r1 + 1;
        goto L27
    L32:
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-2, -2);
        r18.gravity = 17;
        Unit r9 = Unit.INSTANCE;
        addView(r17, r18);
        return;
    L33:
        b03.a r10 = b03.a.a;
        int r19 = (s1.y() - UtilityKotlinExtentionsKt.i(32)) - (UtilityKotlinExtentionsKt.i(r16) * 2);
        int r110 = 5;
        int r20 = (r19 / 5) - (UtilityKotlinExtentionsKt.i(r2) * 2);
        LinearLayout r22 = new LinearLayout(getContext());
        r22.setOrientation(0);
        int r23 = 0;
    L34:
        if (r23 >= 5) goto L39;
        MultiAnchorLinkInfoTopSelectSubView r24 = new MultiAnchorLinkInfoTopSelectSubView(getContext());
        p r25 = (p) ListProtector.get(r14, r23);
        if (r25 == null) goto L38;
        r24.b(r25, r20);
    L38:
        UtilityKotlinExtentionsKt.w(r24);
        LinearLayout.LayoutParams r26 = new LinearLayout.LayoutParams(r20, -2);
        r26.gravity = 17;
        r26.leftMargin = UtilityKotlinExtentionsKt.i(r2);
        r26.rightMargin = UtilityKotlinExtentionsKt.i(r2);
        r22.addView(r24, r26);
        r23 = r23 + 1;
        goto L34
    L39:
        addView(r22, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout r27 = new LinearLayout(getContext());
        r27.setOrientation(0);
        int r28 = r14.size();
    L40:
        if (r110 >= r28) goto L45;
        MultiAnchorLinkInfoTopSelectSubView r29 = new MultiAnchorLinkInfoTopSelectSubView(getContext());
        p r30 = (p) ListProtector.get(r14, r110);
        if (r30 == null) goto L44;
        r29.b(r30, r20);
    L44:
        UtilityKotlinExtentionsKt.w(r29);
        LinearLayout.LayoutParams r32 = new LinearLayout.LayoutParams(r20, -2);
        r32.gravity = 17;
        r32.leftMargin = UtilityKotlinExtentionsKt.i(r2);
        r32.rightMargin = UtilityKotlinExtentionsKt.i(r2);
        r27.addView(r29, r32);
        r110 = r110 + 1;
        goto L40
    L45:
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(-1, -2);
        r111.topMargin = UtilityKotlinExtentionsKt.i(16);
        Unit r112 = Unit.INSTANCE;
        addView(r27, r111);
        return;
    L21:
        if (r14.size() != 6) goto L23;
        r2 = 7;
        goto L25
    L23:
        r2 = 11;
        goto L25
    L16:
        r16 = 0;
        goto L18
    }

    public PkSwitchMultiSelectPkView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setOrientation(1);
    }
}
