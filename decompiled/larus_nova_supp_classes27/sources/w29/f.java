package w29;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.actionbar.model.e0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.instruction.core.model.ActionBarDisplayType;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.api.IActionBarSegmentV2;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.larus.contextwindow.api.a$b;
import com.larus.contextwindow.impl.actionbar.ContextWindowActionBarHolder;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.im.bean.bot.BotModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f implements IActionBarSegmentV2 {
    public final t1a.b a;
    public final Context b;
    public final Lazy c;
    public final String d;
    public final int e;
    public final IActionBarSegmentV2.Position f;

    public final boolean g() {
        return false;
    }

    public final boolean isEnabled() {
        int r0 = y29.a.a;
        y29.b.a.getClass();
        if (y29.b.a() == false) goto L7;
        int r1 = oa9.a.a;
        if (ga9.a.b("context_window_usage_action_bar_enabled", true) == false) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L17;
        v29.c r3 = (v29.c) this.c.getValue();
        if (r3 == null) goto L12;
        com.larus.contextwindow.api.a r4 = r3.O90();
    L14:
        if ((r4 instanceof a$b) == false) goto L18;
        return true;
    L18:
        return false;
    L12:
        r4 = null;
        goto L14
    L17:
        return false;
    L7:
        r2 = false;
        goto L8
    }

    public final String c() {
        return this.d;
    }

    public final IActionBarSegmentV2.Position getPosition() {
        return this.f;
    }

    public final int getPriority() {
        return this.e;
    }

    public final boolean h(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return Intrinsics.areEqual(r2.b, "context_window_usage");
    }

    public f(t1a.b r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new e(this));
        this.d = "context_window_usage";
        this.e = 500;
        this.f = IActionBarSegmentV2.Position.AFTER_DEFAULT;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, w29.b] */
    public final List b(BotModel r25, wc9.e r26) {
        Intrinsics.checkNotNullParameter(r25, "bot");
        Intrinsics.checkNotNullParameter(r26, FlowProtocolAbility.FEATURE_CONVERSATION);
        if (isEnabled() == false) goto L5;
        v29.c r1 = (v29.c) this.c.getValue();
        z0 r2 = null;
        if (r1 == null) goto L9;
        com.larus.contextwindow.api.a r3 = r1.O90();
    L11:
        if ((r3 instanceof a$b) == false) goto L13;
        a$b r4 = (a$b) r3;
    L14:
        if (r4 == null) goto L16;
        v29.c r5 = (v29.c) this.c.getValue();
        if (r5 == null) goto L32;
        ContextWindowEntryRequest r6 = r5.dO();
        if (r6 == null) goto L32;
        int r7 = c.a;
        String r11 = this.b.getString(2131906727);
        int r8 = r4.a.g;
        ?? r9 = new b();
        Intrinsics.checkNotNullParameter(r6, "request");
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r9, "schemaBuilder");
        String r10 = (String) r9.invoke(r6);
        if (r10 == null) goto L26;
        r2 = new z0(-2026082101L, "context_window_usage", null, null, r11, Integer.valueOf(ActionBarDisplayType.NORMAL.getValue()), Integer.valueOf(ActionBarExecutionType.OPEN_BY_SCHEMA.getValue()), null, new e0(r10, 2), null, null, null, true, MapsKt.mapOf(new Pair[]{TuplesKt.to("retain_in_task_mode", "true"), TuplesKt.to("context_window_total_percent_tenths", String.valueOf(RangesKt.coerceIn(r8, 0, 1000)))}), null, 536866700, 13);
    L26:
        if (r2 != null) goto L30;
        return CollectionsKt.emptyList();
    L30:
        return CollectionsKt.listOf(r2);
    L32:
        return CollectionsKt.emptyList();
    L16:
        return CollectionsKt.emptyList();
    L13:
        r4 = null;
        goto L14
    L9:
        r3 = null;
        goto L11
    L5:
        return CollectionsKt.emptyList();
    }

    public final boolean d(z0 r4, z0 r5) {
        Intrinsics.checkNotNullParameter(r4, "old");
        Intrinsics.checkNotNullParameter(r5, "next");
        int r2 = c.a;
        Intrinsics.checkNotNullParameter(r4, "old");
        Intrinsics.checkNotNullParameter(r5, "next");
        if (Intrinsics.areEqual(r4.b, r5.b) == true) goto L5;
    L18:
        return false;
    L5:
        if (Intrinsics.areEqual(r4.e, r5.e) == false) goto L18;
        e0 r0 = r4.m;
        String r1 = null;
        if (r0 == null) goto L9;
        String r3 = r0.a;
    L10:
        e0 r6 = r5.m;
        if (r6 == null) goto L14;
        r1 = r6.a;
    L14:
        if (Intrinsics.areEqual(r3, r1) == false) goto L18;
        if (c.a(r4) != c.a(r5)) goto L18;
        return true;
    L9:
        r3 = null;
        goto L10
    }

    public final void e(BaseActionBarHolder r5, final z0 r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "cell");
        Intrinsics.checkNotNullParameter(r6, "item");
        if ((r5 instanceof ContextWindowActionBarHolder) == false) goto L5;
        final ContextWindowActionBarHolder r8 = (ContextWindowActionBarHolder) r5;
    L6:
        if (r8 == null) goto L12;
        Intrinsics.checkNotNullParameter(r6, "item");
        TextView r9 = r8.c;
        String r0 = r6.e;
        if (r0 != null) goto L10;
        r0 = "";
    L10:
        r9.setText(r0);
        ((RecyclerView.ViewHolder) r8).itemView.setContentDescription(r6.e);
        ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new a(r8, r6));
        r8.a.d(((RecyclerView.ViewHolder) r8).itemView, r8.b, r8.c, r6);
        r8.b.setImageTintList(null);
        r8.b.clearColorFilter();
        r8.b.setImageDrawable(r8.d);
        return;
    L12:
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final BaseActionBarHolder f(ViewGroup r3, t1 r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r4, "defaultClickCallback");
        View r6 = LayoutInflater.from(r3.getContext()).inflate(2131562521, r3, false);
        Intrinsics.checkNotNull(r6);
        return new ContextWindowActionBarHolder(r6, r4);
    }
}
