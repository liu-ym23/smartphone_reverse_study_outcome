package com.larus.dora.impl.dynamic.viewholder;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoGeneraGroupLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.o1;
import com.larus.dora.impl.dynamic.p1;
import com.larus.dora.impl.dynamic.s1;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00013B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016JN\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eJL\u0010 \u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001fH\u0002J\u000e\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0017J.\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001a2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016J\"\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u00064"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/GeneraGroupHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/entity/CardInstance;", "Lcom/ixigua/lib/track/ITrackNode;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoGeneraGroupLayoutBinding;", "traceNode", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoGeneraGroupLayoutBinding;Lcom/ixigua/lib/track/ITrackNode;)V", "getTraceNode", "()Lcom/ixigua/lib/track/ITrackNode;", "dynamicItems", "Lcom/larus/dora/impl/device_v2/widget/DynamicItemViews;", "getDynamicItems", "()Lcom/larus/dora/impl/device_v2/widget/DynamicItemViews;", "parentTrackNode", "generateViews", "", "context", "Landroid/content/Context;", "doraDevice", "Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "parentViewGroup", "Landroid/view/ViewGroup;", "items", "", "Lcom/larus/dora/impl/dynamic/GeneraItem;", "desc", "Lcom/larus/dora/impl/dynamic/Identifier;", "startling", "", "", "createChildView", "itemCount", "", "itemGroup", "Lcom/larus/bmhome/view/item/ItemGroup;", "createDescView", "Landroid/widget/TextView;", "appendItemGroup", "container", "setStyle", "itemView", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "item", "bind", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class GeneraGroupHolder extends BaseViewHolder<d59.c> implements by7.e {
    public static final /* synthetic */ int e = 0;
    public final LarusDoraDeviceInfoGeneraGroupLayoutBinding b;
    public final by7.e c;
    public final a59.a d;

    public static final class a {
        public static GeneraGroupHolder a(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            Intrinsics.checkNotNullParameter(null, "traceNode");
            return new GeneraGroupHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding.a(LayoutInflater.from(r2.getContext()), r2));
        }
    }

    static {
    }

    public final void fillTrackParams(TrackParams r1) {
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public final by7.e parentTrackNode() {
        return this.c;
    }

    public GeneraGroupHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding r3) {
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(null, "traceNode");
        super(r3.a);
        this.b = r3;
        this.c = null;
        this.d = new a59.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.larus.dora.impl.dynamic.viewholder.GeneraGroupHolder] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.dora.impl.dynamic.s1] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.larus.dora.impl.dynamic.s1] */
    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(d59.c r12, e59.b r13, d59.b r14) {
        d59.c r15 = r12;
        Intrinsics.checkNotNullParameter(r15, "data");
        Intrinsics.checkNotNullParameter(r13, "connectionState");
        LarusDoraDeviceInfoGeneraGroupLayoutBinding r16 = this.b;
        if (r16 == null) goto L65;
        d59.j r0 = r15.e;
        Object r2 = null;
        if ((r0 instanceof o1) == false) goto L17;
        if (r14 == null) goto L66;
        z49.b r5 = r14.a;
        if (r5 == null) goto L67;
        if (r0 != null) goto L11;
        return;
    L11:
        if ((r0 instanceof o1) == false) goto L69;
        Application r4 = AppHost.a.getApplication();
        LinearLayout r6 = r16.b;
        o1 r1 = (o1) r0;
        List<p1> r17 = r1.c();
        if (r17 == null) goto L15;
        r2 = CollectionsKt.filterNotNull(r17);
    L15:
        Y3(r4, r5, r6, r2, r1.b(), r14.c);
        return;
    L69:
        return;
    L67:
        return;
    L66:
        return;
    L17:
        if ((r0 instanceof com.larus.dora.impl.dynamic.g) == false) goto L71;
        boolean r3 = false;
        if (r15.f == false) goto L42;
        com.larus.dora.impl.dynamic.g r7 = (com.larus.dora.impl.dynamic.g) r0;
        com.larus.dora.impl.dynamic.f r18 = r7.b();
        if (r18 == null) goto L27;
        List<p1> r110 = r18.b();
        if (r110 == null) goto L27;
        if (r110.isEmpty() != true) goto L27;
        r3 = true;
    L27:
        if (r3 == false) goto L29;
        FLogger.a.i("GeneraGroupHolder", "connection is empty");
        return;
    L29:
        if (r14 == null) goto L73;
        z49.b r8 = r14.a;
        if (r8 == null) goto L74;
        Application r9 = AppHost.a.getApplication();
        LinearLayout r10 = r16.b;
        com.larus.dora.impl.dynamic.f r111 = r7.b();
        if (r111 == null) goto L37;
        List<p1> r112 = r111.b();
        if (r112 == null) goto L37;
        List r11 = CollectionsKt.filterNotNull(r112);
    L38:
        com.larus.dora.impl.dynamic.f r113 = r7.b();
        if (r113 == null) goto L41;
        r2 = r113.a();
    L41:
        Y3(r9, r8, r10, r11, r2, r14.c);
        return;
    L37:
        r11 = null;
        goto L38
    L74:
        return;
    L73:
        return;
    L42:
        com.larus.dora.impl.dynamic.g r20 = (com.larus.dora.impl.dynamic.g) r0;
        com.larus.dora.impl.dynamic.k r114 = r20.c();
        if (r114 == null) goto L49;
        List<p1> r115 = r114.b();
        if (r115 == null) goto L49;
        if (r115.isEmpty() != true) goto L49;
        r3 = true;
    L49:
        if (r3 == false) goto L51;
        FLogger.a.i("GeneraGroupHolder", "disconnection is empty");
        return;
    L51:
        if (r14 == null) goto L77;
        z49.b r21 = r14.a;
        if (r21 == null) goto L78;
        Application r22 = AppHost.a.getApplication();
        LinearLayout r23 = r16.b;
        com.larus.dora.impl.dynamic.k r116 = r20.c();
        if (r116 == null) goto L59;
        List<p1> r117 = r116.b();
        if (r117 == null) goto L59;
        List r24 = CollectionsKt.filterNotNull(r117);
    L60:
        com.larus.dora.impl.dynamic.k r118 = r20.c();
        if (r118 == null) goto L63;
        r2 = r118.a();
    L63:
        Y3(r22, r21, r23, r24, r2, r14.c);
        return;
    L59:
        r24 = null;
        goto L60
    L78:
        return;
    L77:
        return;
    L71:
        return;
    }

    public void X3(z49.b r5, int r6, List r7, final Context r8, ItemGroup r9) {
        Intrinsics.checkNotNullParameter(r5, "doraDevice");
        Intrinsics.checkNotNullParameter(r7, "items");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "itemGroup");
        z49.a.a(r5);
        int r10 = 0;
    L3:
        if (r10 >= r6) goto L9;
        final p1 r0 = (p1) ListProtector.get(r7, r10);
        a59.a r1 = this.d;
        s1 r2 = r0.e();
        if (r2 == null) goto L7;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = "";
    L8:
        String r4 = String.valueOf(r3);
        r1.getClass();
        ItemTextArrow r11 = a59.a.b(r9, r4);
        r11.U5();
        e1.d(r11, new q(r0, r8, this));
        r10 = r10 + 1;
        goto L3
    L7:
        r3 = null;
        goto L8
    }

    public final void Y3(Context r8, z49.b r9, ViewGroup r10, List<p1> r11, s1 r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "doraDevice");
        Intrinsics.checkNotNullParameter(r10, "parentViewGroup");
        List<p1> r14 = r11;
        if (r14 != null) goto L5;
    L8:
        boolean r15 = true;
    L9:
        if (r15 == false) goto L11;
        return;
    L11:
        r10.removeAllViews();
        int r3 = r11.size();
        this.d.getClass();
        X3(r9, r3, r11, r8, a59.a.a(r10));
        if (r12 == null) goto L15;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        AppCompatTextView r16 = new AppCompatTextView(r8);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(-1, -2);
        Resources r18 = r8.getResources();
        int r110 = r18.getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786));
        r17.setMargins(r110, r18.getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462)), r110, 0);
        r16.setLayoutParams(r17);
        r16.setText("");
        r16.setTextAlignment(5);
        r16.setTextColor(ContextCompat.getColor(r8, 2131103143));
        r16.setTextSize(r18.getDimension(v19.c.b(2130972271, null, 2131167612)) / WindowDisplayMetricsOverride.apply(r18, r18.getDisplayMetrics()).scaledDensity);
        r10.addView(r16);
        return;
    L15:
        return;
    L5:
        if (r14.isEmpty() == true) goto L8;
        r15 = false;
        goto L9
    }
}
