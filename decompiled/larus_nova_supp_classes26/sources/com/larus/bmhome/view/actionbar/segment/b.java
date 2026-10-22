package com.larus.bmhome.view.actionbar.segment;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.actionbar.model.e0;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.databinding.LarusChatItemCustomActionbarNormalHolderBinding;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.im.bean.bot.BotModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ss8.e;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements e {
    public final t1a.b a;
    public final Context b;

    public static final class a {
    }

    static {
    }

    @Override // ss8.e
    public final boolean g() {
        return false;
    }

    public final Context getContext() {
        return this.b;
    }

    @Override // ss8.e
    public final boolean h(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return Intrinsics.areEqual(r2.b, "coco_message_history");
    }

    public b(t1a.b r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
    }

    @Override // ss8.e
    public final List b(BotModel r27, wc9.e r28) {
        Intrinsics.checkNotNullParameter(r27, "bot");
        Intrinsics.checkNotNullParameter(r28, "conversation");
        com.larus.bmhome.chat.component.immerse.a r1 = this.a.getAbility(com.larus.bmhome.chat.component.immerse.a.class);
        boolean r2 = false;
        if (r1 == null) goto L5;
        boolean r3 = r1.ui();
    L6:
        FLogger r4 = FLogger.a;
        r4.i("ImmerseHistorySegment", this + ", getFinalList, isImmersiveSlidingFeedVertical = " + r3);
        if (r3 == false) goto L22;
        if (z2.a.V1() == false) goto L22;
        com.larus.bmhome.chat.component.immerse.a r5 = this.a.getAbility(com.larus.bmhome.chat.component.immerse.a.class);
        if (r5 == null) goto L13;
        r2 = r5.hV();
    L13:
        if (r2 == false) goto L15;
        int r6 = 2131241533;
    L16:
        r4.i("ImmerseHistorySegment", this + ", getFinalList, historyChecked = " + r2);
        String r7 = y0.k(UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + '/' + r6));
        Resources r8 = this.b.getResources();
        if (r8 == null) goto L19;
        String r9 = r8.getString(2131900194);
    L20:
        String r13 = r9;
        int r10 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        return CollectionsKt.listOf(new z0(null, "coco_message_history", null, new g1(null, r7, null, null, 29), r13, null, Integer.valueOf(r10), null, new e0("sslocal://flow/switch_message_history", 2), null, null, null, true, null, null, -536875099, 15));
    L19:
        r9 = null;
        goto L20
    L15:
        r6 = 2131241534;
    L22:
        return CollectionsKt.emptyList();
    L5:
        r3 = false;
        goto L6
    }

    @Override // ss8.e
    public final boolean d(z0 r2, z0 r3) {
        Intrinsics.checkNotNullParameter(r2, "old");
        Intrinsics.checkNotNullParameter(r3, "next");
        return false;
    }

    @Override // ss8.e
    public final void e(BaseActionBarHolder r7, final z0 r8, final int r9) {
        Intrinsics.checkNotNullParameter(r7, "cell");
        Intrinsics.checkNotNullParameter(r8, "item");
        com.larus.bmhome.chat.component.immerse.a r1 = this.a.getAbility(com.larus.bmhome.chat.component.immerse.a.class);
        if (r1 == null) goto L5;
        boolean r2 = r1.hV();
    L6:
        Resources r3 = this.b.getResources();
        String r4 = "";
        if (r3 == null) goto L10;
        String r5 = r3.getString(2131900194);
        if (r5 == null) goto L10;
    L11:
        if (r2 == false) goto L13;
        int r6 = 2131241533;
    L14:
        String r10 = y0.k(UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + '/' + r6));
        if (r10 == null) goto L18;
        r4 = r10;
    L18:
        RoundConstraintLayout r11 = null;
        if ((r7 instanceof ImmerseHistorySegmentCell) == false) goto L21;
        final ImmerseHistorySegmentCell r12 = (ImmerseHistorySegmentCell) r7;
    L22:
        if (r12 == null) goto L54;
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r4, ShareType.URL);
        Intrinsics.checkNotNullParameter(r8, "item");
        ImageLoaderKt.u(r12.a.b, r4, null);
        r12.a.c.setText(r5);
        e1.d(r12.a.a, new c(r12, r8, r9));
        if (r12.c == false) goto L33;
        RoundConstraintLayout r13 = ((RecyclerView.ViewHolder) r12).itemView;
        if ((r13 instanceof RoundConstraintLayout) == false) goto L28;
        r11 = r13;
    L28:
        if (r11 == null) goto L32;
        c29.a r14 = r11.getDelegate();
        if (r14 == null) goto L32;
        int r0 = ContextCompat.getColor(((RecyclerView.ViewHolder) r12).itemView.getContext(), 2131106535);
        r14.a(r0);
        r14.b(r0);
        r14.g(ContextCompat.getColor(((RecyclerView.ViewHolder) r12).itemView.getContext(), 2131106536));
    L32:
        r12.a.c.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r12).itemView.getContext(), 2131103298));
    L52:
        t1 r15 = r12.b;
        View r16 = ((RecyclerView.ViewHolder) r12).itemView;
        LarusChatItemCustomActionbarNormalHolderBinding r17 = r12.a;
        r15.d(r16, r17.b, r17.c, r8);
        return;
    L33:
        boolean r18 = h.a;
        if (h.b(((RecyclerView.ViewHolder) r12).itemView.getContext()) == false) goto L36;
        int r19 = 2131103292;
    L37:
        RoundConstraintLayout r20 = ((RecyclerView.ViewHolder) r12).itemView;
        if ((r20 instanceof RoundConstraintLayout) == false) goto L40;
        RoundConstraintLayout r21 = r20;
    L41:
        if (r21 == null) goto L45;
        c29.a r22 = r21.getDelegate();
        if (r22 == null) goto L45;
        r22.a(ContextCompat.getColor(((RecyclerView.ViewHolder) r12).itemView.getContext(), r19));
    L45:
        RoundConstraintLayout r23 = ((RecyclerView.ViewHolder) r12).itemView;
        if ((r23 instanceof RoundFrameLayout) == false) goto L48;
        r11 = (RoundFrameLayout) r23;
    L48:
        if (r11 == null) goto L52;
        c29.a r24 = r11.getDelegate();
        if (r24 == null) goto L52;
        r24.a(ContextCompat.getColor(((RecyclerView.ViewHolder) r12).itemView.getContext(), r19));
        goto L52
    L40:
        r21 = null;
        goto L41
    L36:
        r19 = 2131102563;
        goto L37
    L54:
        return;
    L21:
        r12 = null;
        goto L22
    L13:
        r6 = 2131241534;
    L10:
        r5 = "";
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    @Override // ss8.e
    public final BaseActionBarHolder f(ViewGroup r2, t1 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "defaultClickCallback");
        return new ImmerseHistorySegmentCell(LarusChatItemCustomActionbarNormalHolderBinding.b(LayoutInflater.from(r2.getContext()), r2), r3, r4);
    }
}
