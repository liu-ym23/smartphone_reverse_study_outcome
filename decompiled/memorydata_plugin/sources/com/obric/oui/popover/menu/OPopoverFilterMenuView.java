package com.obric.oui.popover.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.loc.o;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.popover.view.CheckableImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\"#B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J(\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0007R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverFilterMenuView;", "Lcom/obric/oui/popover/menu/OPopoverMenuView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemContainers", "", "Landroid/view/ViewGroup;", "itemHeight", "itemVerticalMargin", "itemWidth", "items", "Ljava/util/ArrayList;", "Lcom/obric/oui/popover/menu/OPopoverFilterMenuView$PopoverItem;", "Lkotlin/collections/ArrayList;", "radioMap", "", "Lcom/obric/oui/popover/view/CheckableImageView;", "topDividerVisibility", "", "addPopoverItems", "", "initView", "onSizeChanged", "w", o.g, "oldw", "oldh", "selectItem", "index", "Builder", "PopoverItem", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverFilterMenuView extends OPopoverMenuView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<Object> f14341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<Integer, CheckableImageView> f14342b;
    private List<ViewGroup> c;
    private final int d;
    private int e;
    private int f;

    public OPopoverFilterMenuView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPopoverFilterMenuView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OPopoverFilterMenuView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f14341a = new ArrayList();
        this.f14342b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.d = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4);
        this.e = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 188);
        this.f = (int) ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_h_list_item_menu, "dimen", "oui_h_list_item_menu"));
    }

    public /* synthetic */ OPopoverFilterMenuView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    @Override // com.obric.oui.popover.menu.OPopoverMenuView, android.view.View
    public void onSizeChanged(int r6, int r7, int r8, int r9) {
        super.onSizeChanged(r6, r7, r8, r9);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L20;
        ViewGroup r10 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5.next(), ViewGroup.class, "com.obric.memorydata.plugin");
        View r11 = (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r0 = r11.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        ViewGroup.LayoutParams r1 = ((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        ViewGroup.LayoutParams r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class) == true) goto L8;
        r1 = null;
    L8:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if (r2 == null) goto L11;
        int r12 = r2.leftMargin;
    L12:
        int r13 = r6 - r12;
        ViewGroup.LayoutParams r14 = ((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r14, ViewGroup.MarginLayoutParams.class) == false) goto L16;
        r3 = r14;
    L16:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L19;
        r4 = r15.rightMargin;
    L19:
        r0.width = r13 - r4;
        r11.setLayoutParams(r0);
        goto L4
    L11:
        r12 = 0;
        goto L12
    }
}
