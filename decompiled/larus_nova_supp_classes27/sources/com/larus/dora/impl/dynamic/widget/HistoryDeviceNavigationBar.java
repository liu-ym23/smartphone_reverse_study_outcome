package com.larus.dora.impl.dynamic.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c59.s;
import c59.u;
import c59.x;
import c59.y;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.device_v2.l0;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.util.DoraImageType;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.impl.util.o;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 G2\u00020\u0001:\u0002GHB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\fJ\u001e\u00101\u001a\u00020\r2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u000102J\u0010\u00104\u001a\u00020\r2\b\b\u0002\u00105\u001a\u00020\u0017J\b\u00106\u001a\u00020\u0007H\u0002J\u0018\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0002J\u001e\u0010:\u001a\u00020\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\"0<2\b\u0010=\u001a\u0004\u0018\u00010\fJ\u0010\u0010>\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010\fJ\u001a\u0010?\u001a\u00020\r2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ\u001a\u0010A\u001a\u00020\r2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ\u001a\u0010B\u001a\u00020\r2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ(\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u00072\b\b\u0002\u0010E\u001a\u00020\u00172\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010FR\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00060.R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rightSelectDevice", "Lkotlin/Function1;", "", "", "leftSelectDevice", "didSelectDevice", "recyclerViewWidthCalculator", "Lcom/larus/dora/impl/device_v2/RecyclerViewWidthCalculator;", "getRecyclerViewWidthCalculator", "()Lcom/larus/dora/impl/device_v2/RecyclerViewWidthCalculator;", "setRecyclerViewWidthCalculator", "(Lcom/larus/dora/impl/device_v2/RecyclerViewWidthCalculator;)V", "value", "", "isShowListBar", "()Z", "setShowListBar", "(Z)V", "selectedIndex", "getSelectedIndex", "()I", "actionUrl", "historyDevices", "", "Lcom/larus/dora/impl/device_v2/entity/HistoryDeviceListInfo;", "icBack", "Landroid/widget/ImageView;", "titleLabel", "Landroid/widget/TextView;", "centerView", "Landroid/view/View;", "recyclerView", "Lcom/larus/dora/impl/dynamic/widget/CenterSelectedRecyclerView;", "rightButton", "Lcom/facebook/drawee/view/SimpleDraweeView;", "deviceAdapter", "Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar$HistoryDeviceAdapter;", "setTitle", "title", "config", "", "", "reloadData", "animated", "getItemMaxSize", "updateContentInsetIfNeeded", "selectedCellWidth", "notSelectedCellWidth", "loadStoredHistoryDevices", "historyDevice", "", "mac", "notifyTitleUpdate", "setRightClickListener", "listener", "setLeftClickListener", "setDidSelectDevice", "setRightButtonIcon", "iconResId", "removePadding", "Lkotlin/Function0;", "Companion", "HistoryDeviceAdapter", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HistoryDeviceNavigationBar extends ConstraintLayout {
    public static final /* synthetic */ int n = 0;
    public Function1<? super String, Unit> a;
    public Function1<? super String, Unit> b;
    public Function1<? super String, Unit> c;
    public l0 d;
    public boolean e;
    public int f;
    public String g;
    public final List<z49.c> h;
    public final TextView i;
    public final View j;
    public final CenterSelectedRecyclerView k;
    public final SimpleDraweeView l;
    public final HistoryDeviceAdapter m;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\b\b\u0001\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\n¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar$HistoryDeviceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar$HistoryDeviceAdapter$ViewHolder;", "Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar;", "<init>", "(Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "getItem", "Lcom/larus/dora/impl/device_v2/entity/HistoryDeviceListInfo;", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class HistoryDeviceAdapter extends RecyclerView.Adapter<ViewHolder> {
        public final /* synthetic */ HistoryDeviceNavigationBar a;

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar$HistoryDeviceAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar$HistoryDeviceAdapter;Landroid/view/View;)V", "titleText", "Landroid/widget/TextView;", "deviceIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "container", "bind", "", "title", "", "productId", "", "sku", "isSelected", "", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class ViewHolder extends RecyclerView.ViewHolder {
            public final TextView a;
            public final SimpleDraweeView b;
            public final View c;
            public final /* synthetic */ HistoryDeviceAdapter d;

            public ViewHolder(HistoryDeviceAdapter r2, View r3) {
                Intrinsics.checkNotNullParameter(r3, "view");
                this.d = r2;
                super(r3);
                this.a = (TextView) r3.findViewById(2131368928);
                this.b = r3.findViewById(2131368921);
                this.c = r3.findViewById(2131367728);
            }
        }

        public final int getItemCount() {
            return ((ArrayList) this.a.h).size();
        }

        public HistoryDeviceAdapter(HistoryDeviceNavigationBar r1) {
            this.a = r1;
        }

        public final int getItemViewType(int r2) {
            if (this.a.getSelectedIndex() != r2) goto L5;
            return 1;
        L5:
            return 0;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r110, final int r20) {
            ViewHolder r2 = (ViewHolder) r110;
            Intrinsics.checkNotNullParameter(r2, "holder");
            final z49.c r3 = (z49.c) ListProtector.get(this.a.h, r20);
            int r4 = o.a;
            String r5 = o.b(r3.b(), r3.c());
            Integer r6 = r3.d();
            if (r6 == null) goto L5;
            int r7 = r6.intValue();
        L6:
            Integer r8 = r3.f();
            if (r8 == null) goto L9;
            int r9 = r8.intValue();
        L11:
            if (this.a.getSelectedIndex() != r20) goto L13;
            boolean r10 = true;
        L14:
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "title");
            r2.a.setText(r5);
            if (r2.d.getItemCount() >= 2) goto L17;
            e1.o(r2.b);
            r2.c.setBackgroundColor(0);
        L39:
            r2.c.setSelected(r10);
            l0 r11 = r2.d.a.getRecyclerViewWidthCalculator();
            HistoryDeviceNavigationBar r12 = r2.d.a;
            RecyclerView r13 = r12.k;
            int r14 = r12.getSelectedIndex();
            int r17 = r2.d.getItemCount();
            r11.getClass();
            Intrinsics.checkNotNullParameter(r13, "recyclerView");
            RecyclerView.Adapter r15 = r13.getAdapter();
            if (r15 == null) goto L65;
            View r16 = LayoutInflater.from(r13.getContext()).inflate(2131562577, r13, false);
            if ((r15 instanceof HistoryDeviceAdapter) == false) goto L54;
            z49.c r18 = (z49.c) ListProtector.get(((HistoryDeviceAdapter) r15).a.h, r20);
            TextView r111 = (TextView) r16.findViewById(2131368928);
            SimpleDraweeView r112 = r16.findViewById(2131368921);
            View r113 = r16.findViewById(2131367728);
            String r114 = o.b(r18.b(), r18.c());
            Integer r115 = r18.f();
            if (r115 == null) goto L46;
            int r116 = r115.intValue();
        L47:
            Integer r21 = r18.d();
            if (r21 == null) goto L50;
            r21.intValue();
        L50:
            if (r14 != r20) goto L52;
            boolean r117 = true;
        L53:
            Intrinsics.checkNotNull(r111);
            Intrinsics.checkNotNull(r112);
            Intrinsics.checkNotNull(r113);
            l0.a(r114, r116, r117, r111, r112, r113, r17);
            goto L54
        L52:
            r117 = false;
            goto L53
        L46:
            r116 = 0;
        L54:
            Intrinsics.checkNotNull(r16);
            r16.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            ((RecyclerView.ViewHolder) r2).itemView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            if (r10 == false) goto L57;
            e1.x(r2.a);
        L58:
            ViewGroup.LayoutParams r22 = ((RecyclerView.ViewHolder) r2).itemView.getLayoutParams();
            if (r16.getMeasuredWidth() <= a.C0080a.b) goto L61;
            int r23 = HistoryDeviceNavigationBar.R5(r2.d.a);
        L62:
            r22.width = r23;
            r22.height = a.C0080a.a;
            ((RecyclerView.ViewHolder) r2).itemView.setLayoutParams(r22);
            View r24 = ((RecyclerView.ViewHolder) r2).itemView;
            final HistoryDeviceNavigationBar r25 = this.a;
            r24.setOnClickListener(new f(r25, r20, r3));
            return;
        L61:
            r23 = r16.getMeasuredWidth();
            goto L62
        L57:
            e1.o(r2.a);
            goto L58
        L65:
            throw new IllegalStateException("Adapter not set");
        L17:
            e1.x(r2.b);
            r2.c.setBackgroundResource(2131247646);
            r2.b.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            if (r7 != ProductNameType.H_FREE_BUDS_PRO_5.id) goto L21;
            r2.b.setImageResource(2131242644);
            goto L39
        L21:
            if (r7 != ProductNameType.H_DOLPHIN.id) goto L24;
            r2.b.setImageResource(2131242645);
            goto L39
        L24:
            if (r7 != ProductNameType.H_GUITAR.id) goto L27;
            r2.b.setImageResource(2131242646);
            goto L39
        L27:
            if (CollectionsKt.listOf(new Integer[]{Integer.valueOf(ProductNameType.H_FREE_CLIP_2.id), Integer.valueOf(ProductNameType.H_FREE_CLIP_2_HE.id)}).contains(Integer.valueOf(r7)) == false) goto L30;
            r2.b.setImageResource(2131242643);
            goto L39
        L30:
            if (o59.a.o(Integer.valueOf(r7)) == false) goto L35;
            StringBuilder r26 = new StringBuilder("larus_");
            DoraImageType r27 = DoraImageType.ICON_DORA_G_DM_BAR;
            int r118 = n1.a;
            DoraSKU r28 = n1.e(DoraSKU.a.b(DoraSKU.Companion, Integer.valueOf(r9)));
            boolean r119 = v19.h.a;
            Context r120 = r2.d.a.getContext();
            if (r120 != null) goto L34;
            r120 = AppHost.a.getApplication();
        L34:
            r26.append(r27.fileNameNoFilExtension(r28, v19.h.b(r120)));
            String r30 = r26.toString();
            SimpleDraweeView r31 = r2.b;
            DoraResourceUtil r32 = DoraResourceUtil.a;
            r31.setImageBitmap(DoraResourceUtil.e(r30));
            goto L39
        L35:
            SimpleDraweeView r33 = r2.b;
            DoraResourceUtil r121 = DoraResourceUtil.a;
            StringBuilder r122 = new StringBuilder("larus_");
            DoraImageType r123 = DoraImageType.ICON_DORA_MANAGE_NAV_BAR;
            int r124 = n1.a;
            DoraSKU r34 = n1.e(DoraSKU.a.b(DoraSKU.Companion, Integer.valueOf(r9)));
            boolean r125 = v19.h.a;
            Context r126 = r2.d.a.getContext();
            if (r126 != null) goto L38;
            r126 = AppHost.a.getApplication();
        L38:
            r122.append(r123.fileName(r34, v19.h.b(r126), Integer.valueOf(r7)));
            r33.setImageBitmap(DoraResourceUtil.e(r122.toString()));
            goto L39
        L13:
            r10 = false;
            goto L14
        L9:
            r9 = 0;
            goto L11
        L5:
            r7 = 1;
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562577, r3, false);
            Intrinsics.checkNotNull(r5);
            return new ViewHolder(this, r5);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar$a$a, reason: collision with other inner class name */
        public static final class C0080a {
            public static final int a = 0;
            public static final int b = 0;

            static {
                a = c7.b(44);
                c7.b(0);
                b = c7.b(160);
            }
        }
    }

    static {
    }

    public HistoryDeviceNavigationBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HistoryDeviceNavigationBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getItemMaxSize() {
        if (((ArrayList) this.h).isEmpty() == false) goto L7;
        int r0 = a.C0080a.a;
        return a.C0080a.b;
    L7:
        if (((ArrayList) this.h).size() != 1) goto L10;
        int r1 = a.C0080a.a;
        return (a.C0080a.b * 3) / 2;
    L10:
        int r2 = a.C0080a.a;
        return a.C0080a.b;
    }

    public final l0 getRecyclerViewWidthCalculator() {
        return this.d;
    }

    public final int getSelectedIndex() {
        return this.f;
    }

    public static final /* synthetic */ int R5(HistoryDeviceNavigationBar r0) {
        return r0.getItemMaxSize();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void V5(HistoryDeviceNavigationBar r9) {
        List<z49.c> r0 = r9.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((ArrayList) r0).isEmpty() == true) goto L13;
        l0 r1 = r9.d;
        Context r2 = r9.k.getContext();
        CenterSelectedRecyclerView r3 = r9.k;
        HistoryDeviceAdapter r4 = r9.m;
        z49.c r6 = (z49.c) ListProtector.get(r9.h, r9.f);
        int r7 = ((ArrayList) r9.h).size();
        r1.getClass();
        int r5 = l0.b(r2, r3, r4, true, r6, r7).getMeasuredWidth();
        l0 r8 = r9.d;
        Context r10 = r9.k.getContext();
        CenterSelectedRecyclerView r11 = r9.k;
        HistoryDeviceAdapter r12 = r9.m;
        z49.c r13 = (z49.c) ListProtector.get(r9.h, r9.f);
        int r14 = ((ArrayList) r9.h).size();
        r8.getClass();
        l0.b(r10, r11, r12, false, r13, r14).getMeasuredWidth();
        if (r5 <= a.C0080a.b) goto L10;
        r5 = r9.getItemMaxSize();
    L10:
        ((ArrayList) r9.h).size();
        int r15 = (r9.k.getWidth() / 2) - (r5 / 2);
        r9.k.setPadding(r15, 0, r15, 0);
        r9.k.setSelectedIndex(r9.f);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(Map<String, ? extends Object> r7) {
        System.out.println("HistoryDeviceNavigationBar config model: " + r7);
        Lazy r0 = s.a;
        x r8 = (x) s.c(r7, x.class);
        if (r8 == null) goto L30;
        y r9 = r8.b();
        if (r9 == null) goto L31;
        boolean r1 = v19.h.a;
        boolean r2 = v19.h.b(getContext());
        StringBuilder r3 = new StringBuilder("larus_");
        u r4 = r9.b();
        String r5 = null;
        if (r4 == null) goto L10;
        String r6 = r4.a();
    L11:
        r3.append(r6);
        r3.append('_');
        if (r2 == false) goto L14;
        String r10 = "dark";
    L15:
        r3.append(r10);
        String r11 = r3.toString();
        SimpleDraweeView r12 = this.l;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        if (r11 == null) goto L25;
        Context r13 = r12.getContext();
        if (r13 != null) goto L20;
        r13 = AppHost.a.getApplication();
    L20:
        Resources r14 = r13.getResources();
        if (r14 == null) goto L25;
        int r15 = r14.getIdentifier(r11, "drawable", r13.getPackageName());
        if (r15 == 0) goto L25;
        r12.setImageResource(r15);
    L25:
        c59.b r16 = r9.a();
        if (r16 == null) goto L28;
        r5 = r16.e();
    L28:
        this.g = r5;
        return;
    L14:
        r10 = "light";
        goto L15
    L10:
        r6 = null;
        goto L11
    L31:
        return;
    }

    public final void U5(String r4) {
        Iterator r0 = ((ArrayList) this.h).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((z49.c) r0.next()).b(), r4) == true) goto L10;
        r1 = r1 + 1;
    L10:
        this.m.notifyItemChanged(r1);
        this.k.post(new c(this));
        return;
    L9:
        r1 = -1;
        goto L10
    }

    public final void setDidSelectDevice(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c = r2;
    }

    public final void setLeftClickListener(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
    }

    public final void setRecyclerViewWidthCalculator(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setRightClickListener(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = r2;
    }

    public final void setShowListBar(boolean r3) {
        this.e = r3;
        if (r3 == false) goto L5;
        this.i.setVisibility(8);
        this.j.setVisibility(0);
        this.m.notifyDataSetChanged();
        return;
    L5:
        this.i.setVisibility(0);
        this.j.setVisibility(8);
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.i.setText(r2);
    }

    public final void T5(List<z49.c> r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "historyDevice");
        ((ArrayList) this.h).clear();
        ((ArrayList) this.h).addAll(r4);
        this.m.notifyDataSetChanged();
        Iterator<z49.c> r6 = r4.iterator();
        int r0 = 0;
    L4:
        if (r6.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r6.next().b(), r5) == true) goto L10;
        r0 = r0 + 1;
    L10:
        if (r0 == (-1)) goto L17;
        this.f = r0;
        if ((!this.h.isEmpty()) == false) goto L18;
        this.k.post(new e(this));
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r0 = -1;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HistoryDeviceNavigationBar(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.d = new l0(r6);
        this.h = new ArrayList();
        View r9 = LayoutInflater.from(r6).inflate(2131563211, this, true);
        ImageView r10 = (ImageView) r9.findViewById(2131374664);
        TextView r0 = (TextView) r9.findViewById(2131388880);
        this.i = r0;
        View r1 = r9.findViewById(2131365430);
        this.j = r1;
        CenterSelectedRecyclerView r2 = (CenterSelectedRecyclerView) r9.findViewById(2131384076);
        this.k = r2;
        SimpleDraweeView r11 = r9.findViewById(2131384558);
        this.l = r11;
        r0.setTextColor(ContextCompat.getColor(r6, 2131103681));
        r0.setTextSize(17.0f);
        r0.setTextAlignment(4);
        int r4 = 0;
        r2.setLayoutManager(new LinearLayoutManager(r6, 0, false));
        HistoryDeviceAdapter r12 = new HistoryDeviceAdapter(this);
        this.m = r12;
        r2.setAdapter(r12);
        r10.setOnClickListener(new com.larus.dora.impl.dynamic.widget.a(this));
        r11.setOnClickListener(new b(this));
        if (this.e == false) goto L5;
        int r13 = 8;
    L6:
        r0.setVisibility(r13);
        if (this.e == true) goto L10;
        r4 = 8;
    L10:
        r1.setVisibility(r4);
        return;
    L5:
        r13 = 0;
        goto L6
    }

    public /* synthetic */ HistoryDeviceNavigationBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
