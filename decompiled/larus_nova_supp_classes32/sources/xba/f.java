package xba;

import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.venus.ShapeConstraintLayout;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OTitleCardProcessBlock;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardOmniProgressBinding;
import com.obric.assistant.view.ObricShimmerProgressBar;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends com.obric.assistant.block.base.c<xba.a> {
    public ObricCardOmniProgressBinding e;
    public final Lazy f;
    public ValueAnimator g;
    public String h;

    public static final class a {
    }

    static {
    }

    public final void i() {
        this.h = null;
        ValueAnimator r0 = this.g;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        FLogger.a.i("ProgressCardBlockHolder", "onViewRecycled");
    }

    public f() {
        this.f = LazyKt.lazy(new b());
    }

    @Override // com.obric.assistant.block.base.c
    public final void g(jc8.a r21) {
        final xba.a r1 = (xba.a) r21;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        super.g(r1);
        final ObricCardOmniProgressBinding r2 = this.e;
        if (r2 != null) goto L5;
        FLogger.a.w("ProgressCardBlockHolder", "onBindBlockView: binding is null, return");
        return;
    L5:
        final Block r4 = ((jc8.a) r1).a;
        BlockContent r5 = r4.getContent();
        if (r5 == null) goto L52;
        final OTitleCardProcessBlock r6 = r5.getOTitleCardProcessBlock();
        if (r6 == null) goto L52;
        e1.x(r2.a);
        FLogger.a.i("ProgressCardBlockHolder", "onBindBlockView: isFinish = " + r4.isFinish() + ", progress = " + r6.progress);
        String r3 = this.h;
        String r7 = NameKeys.UnloadStrategy_No_Strategy;
        if (r3 != null) goto L13;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        this.h = r4.getBlockId();
        if (r4.isFinish() == false) goto L20;
        e1.o(r2.d);
        e1.x(r2.b);
        TextView r8 = r2.b;
        String r9 = r6.title;
        if (r9 == null) goto L19;
        r7 = r9;
    L19:
        r8.setText(r7);
    L51:
        we8.a.b(r2.b, i5.t(), false, null, null, 12);
        we8.a.b(r2.f, i5.t(), false, null, null, 12);
        we8.a.b(r2.e, i5.m(), false, null, null, 12);
        e1.d(r2.a, new c(r6, r2, r1, r4));
        r2.a.setOnLongClickListener(new d(this));
        return;
    L20:
        e1.x(r2.d);
        e1.o(r2.b);
        TextView r10 = r2.f;
        String r11 = r6.title;
        if (r11 != null) goto L23;
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L23:
        r10.setText(r11);
        TextView r12 = r2.e;
        String r13 = r6.subtitle;
        if (r13 != null) goto L26;
        r13 = NameKeys.UnloadStrategy_No_Strategy;
    L26:
        r12.setText(r13);
        e1.x(r2.c);
        Double r14 = r6.progress;
        if (r14 == null) goto L29;
        int r15 = MathKt.roundToInt(r14.doubleValue());
    L30:
        Message r16 = r1.j();
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Map r17 = r16.getExt();
        if (r17 == null) goto L33;
        String r18 = (String) r17.get("o_did");
    L34:
        if (r18 == null) goto L38;
        r7 = r18;
    L38:
        if (Intrinsics.areEqual(r7, (String) this.f.getValue()) == true) goto L40;
    L44:
        boolean r19 = false;
    L45:
        final ObricShimmerProgressBar r20 = r2.c;
        ValueAnimator r22 = this.g;
        if (r22 == null) goto L48;
        r22.cancel();
    L48:
        if (r19 == false) goto L50;
        ValueAnimator r23 = ValueAnimator.ofInt(new int[]{r20.getProgress(), r15});
        r23.setDuration(300);
        r23.setInterpolator(new AccelerateDecelerateInterpolator());
        r23.addUpdateListener(new e(r20));
        r23.start();
        this.g = r23;
        goto L51
    L50:
        r20.setProgress(r15);
        goto L51
    L40:
        if (Intrinsics.areEqual(r3, this.h) == false) goto L42;
    L43:
        r19 = true;
        goto L45
    L42:
        if (Math.abs((AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000)) - r16.getCreateTime()) > 3) goto L44;
    L33:
        r18 = null;
        goto L34
    L29:
        r15 = 0;
    L52:
        FLogger.a.w("ProgressCardBlockHolder", "onBindBlockView: progressBlock is null, return");
        e1.o(r2.a);
    }

    public final View h(ViewGroup r18) {
        Intrinsics.checkNotNullParameter(r18, "viewGroup");
        FLogger.a.i("ProgressCardBlockHolder", "onCreatedBlockView");
        View r0 = LayoutInflater.from(r18.getContext()).inflate(2131563970, r18, false);
        int r1 = 2131372571;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r0, 2131372571);
        if (r2 == null) goto L15;
        r1 = 2131383297;
        ObricShimmerProgressBar r6 = ViewBindings.findChildViewById(r0, 2131383297);
        if (r6 == null) goto L15;
        r1 = 2131383309;
        ShapeConstraintLayout r7 = ViewBindings.findChildViewById(r0, 2131383309);
        if (r7 == null) goto L15;
        r1 = 2131387625;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r0, 2131387625);
        if (r10 == null) goto L15;
        r1 = 2131388772;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r0, 2131388772);
        if (r11 == null) goto L15;
        RelativeLayout r3 = (RelativeLayout) r0;
        ObricCardOmniProgressBinding r4 = new ObricCardOmniProgressBinding(r3, r2, r6, r7, r10, r11);
        we8.a.b(r11, r11.getTextSize(), false, null, null, 12);
        we8.a.b(r10, r10.getTextSize(), false, null, null, 12);
        we8.a.b(r2, r2.getTextSize(), false, null, null, 12);
        this.e = r4;
        return r3;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
