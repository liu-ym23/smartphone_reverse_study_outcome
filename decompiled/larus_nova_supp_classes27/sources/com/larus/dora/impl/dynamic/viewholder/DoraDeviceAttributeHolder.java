package com.larus.dora.impl.dynamic.viewholder;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoGeneraGroupLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.p1;
import com.larus.dora.impl.dynamic.s1;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J:\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J:\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u001fH\u0002J.\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00132\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010%H\u0016J\"\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DoraDeviceAttributeHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/entity/CardInstance;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoGeneraGroupLayoutBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoGeneraGroupLayoutBinding;)V", "hasUplpad", "", "dynamicItems", "Lcom/larus/dora/impl/device_v2/widget/DynamicItemViews;", "generateViews", "", "context", "Landroid/content/Context;", "parentViewGroup", "Landroid/view/ViewGroup;", "items", "", "Lcom/larus/dora/impl/dynamic/GeneraItem;", "desc", "Lcom/larus/dora/impl/dynamic/Identifier;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "createChildView", "itemCount", "", "itemGroup", "Lcom/larus/bmhome/view/item/ItemGroup;", "createDescView", "Landroid/widget/TextView;", "", "setStyle", "itemView", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "item", "startling", "", "bind", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DoraDeviceAttributeHolder extends BaseViewHolder<d59.c> {
    public static final /* synthetic */ int e = 0;
    public final LarusDoraDeviceInfoGeneraGroupLayoutBinding b;
    public boolean c;
    public final a59.a d;

    public static final class a {
    }

    static {
    }

    public DoraDeviceAttributeHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
        this.d = new a59.a();
    }

    public static void X3(ClipboardManager r18, ClipData r110) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r110};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101807);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.setPrimaryClip(r110);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(d59.c r9, e59.b r10, d59.b r11) {
        d59.c r12 = r9;
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r10, "connectionState");
        LarusDoraDeviceInfoGeneraGroupLayoutBinding r13 = this.b;
        if (r13 == null) goto L29;
        d59.j r0 = r12.e;
        if ((r0 instanceof com.larus.dora.impl.dynamic.h) == false) goto L30;
        s1 r1 = null;
        if (r12.f == false) goto L18;
        Application r3 = AppHost.a.getApplication();
        LinearLayout r4 = r13.b;
        com.larus.dora.impl.dynamic.h r2 = (com.larus.dora.impl.dynamic.h) r0;
        com.larus.dora.impl.dynamic.f r14 = r2.b();
        if (r14 == null) goto L13;
        List<p1> r15 = r14.b();
        if (r15 == null) goto L13;
        List<p1> r5 = CollectionsKt.filterNotNull(r15);
    L14:
        com.larus.dora.impl.dynamic.f r16 = r2.b();
        if (r16 == null) goto L17;
        r1 = r16.a();
    L17:
        Y3(r3, r4, r5, r1, r11);
        return;
    L13:
        r5 = null;
        goto L14
    L18:
        Application r6 = AppHost.a.getApplication();
        LinearLayout r7 = r13.b;
        com.larus.dora.impl.dynamic.h r8 = (com.larus.dora.impl.dynamic.h) r0;
        com.larus.dora.impl.dynamic.k r17 = r8.c();
        if (r17 == null) goto L23;
        List<p1> r18 = r17.b();
        if (r18 == null) goto L23;
        List<p1> r20 = CollectionsKt.filterNotNull(r18);
    L24:
        com.larus.dora.impl.dynamic.k r21 = r8.c();
        if (r21 == null) goto L27;
        r1 = r21.a();
    L27:
        Y3(r6, r7, r20, r1, r11);
        return;
    L23:
        r20 = null;
        goto L24
    L30:
        return;
    }

    public final void Y3(final Context r17, ViewGroup r18, List<p1> r110, s1 r20, d59.b r21) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "parentViewGroup");
        List<p1> r7 = r110;
        if (r7 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == false) goto L11;
        return;
    L11:
        r18.removeAllViews();
        int r9 = r110.size();
        this.d.getClass();
        ItemGroup r10 = a59.a.a(r18);
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r10, "itemGroup");
        if (r110.isEmpty() == true) goto L46;
        int r6 = 0;
    L15:
        if (r6 >= r9) goto L46;
        final p1 r14 = (p1) ListProtector.get(r110, r6);
        a59.a r15 = this.d;
        s1 r11 = r14.e();
        if (r11 == null) goto L19;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Object r12 = "";
    L20:
        String r13 = String.valueOf(r12);
        r15.getClass();
        final ItemTextArrow r16 = a59.a.b(r10, r13);
        e1.d(r16, new i(r14, r17));
        if (Intrinsics.areEqual(r14.c(), "device_sn") == false) goto L31;
        if (r21 == null) goto L26;
        z49.b r22 = r21.a;
        if (r22 == null) goto L26;
        String r23 = r22.h();
    L28:
        if (TextUtils.isEmpty(r23) == true) goto L30;
        Intrinsics.checkNotNull(r23);
        r16.Z5(r23, null);
        r16.setVisible(true);
    L30:
        e1.d(r16, new j(r16, r17, this));
    L42:
        if (TextUtils.isEmpty(r14.d()) == false) goto L44;
        e1.o(r16.getArrowView());
    L45:
        r6 = r6 + 1;
        goto L15
    L44:
        e1.x(r16.getArrowView());
    L26:
        r23 = null;
        goto L28
    L31:
        if (r21 == null) goto L37;
        z49.b r24 = r21.a;
        if (r24 == null) goto L37;
        DoraDevice r25 = r24.a;
        if (r25 == null) goto L37;
        String r26 = o59.a.e(r25);
    L38:
        if (r26 != null) goto L40;
        r26 = "";
    L40:
        r16.Z5(r26, null);
        r16.setVisible(true);
    L37:
        r26 = null;
        goto L38
    L19:
        r12 = null;
    L46:
        if (r20 == null) goto L52;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        AppCompatTextView r3 = new AppCompatTextView(r17);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-1, -2);
        Resources r5 = r17.getResources();
        int r27 = r5.getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786));
        r4.setMargins(r27, r5.getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462)), r27, 0);
        r3.setLayoutParams(r4);
        r3.setText("");
        r3.setTextAlignment(5);
        r3.setTextColor(ContextCompat.getColor(r17, 2131103143));
        r3.setTextSize(r5.getDimension(v19.c.b(2130972271, null, 2131167612)) / WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).scaledDensity);
        r18.addView(r3);
        return;
    L52:
        return;
    L5:
        if (r7.isEmpty() == true) goto L8;
        r8 = false;
        goto L9
    }
}
