package com.larus.dora.impl.device.manage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementDiaryBinding;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementDocBinding;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementFeedbackBinding;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementFirmwareUpdateBinding;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementHealthBinding;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementMoreFeaturesBinding;
import com.larus.dora.impl.device.manage.holder.BaseViewHolder;
import com.larus.dora.impl.device.manage.holder.DeviceUIComponent;
import com.larus.dora.impl.device.manage.holder.DiaryViewHolder;
import com.larus.dora.impl.device.manage.holder.DocViewHolder;
import com.larus.dora.impl.device.manage.holder.FeedbackViewHolder;
import com.larus.dora.impl.device.manage.holder.FirmwareUpdateViewHolder;
import com.larus.dora.impl.device.manage.holder.HealthViewHolder;
import com.larus.dora.impl.device.manage.holder.LifecycleUIComponentHolder;
import com.larus.dora.impl.device.manage.holder.MediaAlbumUIComponent;
import com.larus.dora.impl.device.manage.holder.MoreFeaturesViewHolder;
import com.larus.dora.impl.device.manage.holder.RecordMinutesUIComponent;
import com.larus.dora.impl.device.manage.holder.SimultaneousInterpretUIComponent;
import com.larus.dora.impl.device.manage.holder.SodaBannerComponent;
import com.larus.dora.impl.view.DoraTextView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 >2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0002=>Bó\u0001\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0016H\u0016J\u001e\u0010(\u001a\u00020\u00072\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010#\u001a\u00020\u0016H\u0016J\u0016\u0010*\u001a\u00020\u00072\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u0016\u0010+\u001a\u00020\u00072\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u0016\u0010,\u001a\u00020\u00072\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\r\u0010-\u001a\u00020\u0007H\u0001¢\u0006\u0002\b.J\r\u0010/\u001a\u00020\u0007H\u0001¢\u0006\u0002\b0J\r\u00101\u001a\u00020\u0007H\u0001¢\u0006\u0002\b2J\u0015\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6J\r\u00107\u001a\u00020\u0007H\u0001¢\u0006\u0002\b8J\u000e\u00109\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016J\u0010\u0010:\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010<R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u001ej\b\u0012\u0004\u0012\u00020\u000f`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "Lcom/larus/dora/impl/device/manage/holder/BaseViewHolder;", "onDeviceSelectorClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "onAddDeviceClick", "Lkotlin/Function0;", "onReconnectClick", "onMoreFeaturesClick", "onFeedbackClick", "onDiaryListClick", "onDiaryContentClick", "", "onQuickNoteClick", "onHealthClick", "onDiaryEmptyStateAction", "onFirmwareUpdateClick", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementFirmwareUpdateItem;", "onSodaBannerClosed", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "lifecycleUIComponents", "Ljava/util/LinkedHashSet;", "Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;", "Lkotlin/collections/LinkedHashSet;", "reportedItems", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "sodaBannerComponent", "Lcom/larus/dora/impl/device/manage/holder/SodaBannerComponent;", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "onStart", "onStart$impl_mainlandRelease", "onStop", "onStop$impl_mainlandRelease", "onDestroyView", "onDestroyView$impl_mainlandRelease", "dispatchDeviceSwitchEvent", "event", "Lcom/larus/dora/impl/device/manage/DeviceSwitchEvent;", "dispatchDeviceSwitchEvent$impl_mainlandRelease", "resetConnectingState", "resetConnectingState$impl_mainlandRelease", "getSpanSize", "checkExposure", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "DiffCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGDeviceManagementAdapter extends ListAdapter<p0, BaseViewHolder<p0>> {
    public final Function1<View, Unit> a;
    public final Function0<Unit> b;
    public final Function0<Unit> c;
    public final Function0<Unit> d;
    public final Function0<Unit> e;
    public final Function0<Unit> f;
    public final Function1<String, Unit> g;
    public final Function1<String, Unit> h;
    public final Function1<String, Unit> i;
    public final Function0<Unit> j;
    public final Function1<g, Unit> k;
    public final Function1<Integer, Unit> l;
    public final LinkedHashSet<LifecycleUIComponent> m;
    public final HashSet<String> n;

    public static final class a {
    }

    public static final class b extends DiffUtil.ItemCallback<p0> {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean areContentsTheSame(Object r2, Object r3) {
            p0 r4 = (p0) r2;
            p0 r5 = (p0) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4, r5);
        }

        public final boolean areItemsTheSame(Object r2, Object r3) {
            p0 r4 = (p0) r2;
            p0 r5 = (p0) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4.getId(), r5.getId());
        }
    }

    static {
    }

    public final void z2() {
        g49.d.d("DoraGDeviceManagementAdapter", "resetConnectingState");
        Iterator<T> r0 = this.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        LifecycleUIComponent r2 = (LifecycleUIComponent) r0.next();
        View r3 = r2.b;
        if (r3 == null) goto L10;
        boolean r5 = true;
        if (r3.isAttachedToWindow() != true) goto L10;
    L11:
        if (r5 == false) goto L4;
        if ((r2 instanceof DeviceUIComponent) == false) goto L4;
        g49.d.d("DeviceUIComponent", "resetConnectingState");
        ((DeviceUIComponent) r2).k(false);
    L10:
        r5 = false;
        goto L11
    }

    public final int getItemViewType(int r2) {
        p0 r3 = (p0) getItem(r2);
        if ((r3 instanceof c) == false) goto L6;
        return 1;
    L6:
        if ((r3 instanceof d) == false) goto L9;
        return 2;
    L9:
        if ((r3 instanceof e) == false) goto L12;
        return 3;
    L12:
        if ((r3 instanceof o0) == false) goto L15;
        return 10;
    L15:
        if ((r3 instanceof q0) == false) goto L18;
        return 4;
    L18:
        if ((r3 instanceof t0) == false) goto L21;
        return 5;
    L21:
        if ((r3 instanceof u0) == false) goto L24;
        return 6;
    L24:
        if ((r3 instanceof s0) == false) goto L27;
        return 7;
    L27:
        if ((r3 instanceof f) == false) goto L30;
        return 11;
    L30:
        if ((r3 instanceof g) == false) goto L33;
        return 9;
    L33:
        if ((r3 instanceof b1) == false) goto L37;
        return 8;
    L37:
        throw new NoWhenBranchMatchedException();
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        BaseViewHolder r3 = (BaseViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewAttachedToWindow(r3);
        r3.T3();
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        BaseViewHolder r3 = (BaseViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewDetachedFromWindow(r3);
        r3.V3();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        BaseViewHolder r3 = (BaseViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r3);
        if ((r3 instanceof LifecycleUIComponentHolder) == false) goto L6;
        ((LifecycleUIComponentHolder) r3).b.g();
        return;
    }

    public final void y2(RecyclerView r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        LinearLayoutManager r7 = r6.getLayoutManager();
        if ((r7 instanceof LinearLayoutManager) == false) goto L7;
        LinearLayoutManager r8 = r7;
    L8:
        if (r8 != null) goto L10;
        return;
    L10:
        int r0 = r8.findFirstVisibleItemPosition();
        int r9 = r8.findLastVisibleItemPosition();
        if (r0 == (-1)) goto L55;
        if (r9 == (-1)) goto L58;
        if (r0 > r9) goto L57;
    L15:
        if (r0 >= 0) goto L17;
    L53:
        if (r0 == r9) goto L59;
        r0 = r0 + 1;
        goto L15
    L59:
        return;
    L17:
        if (r0 >= getItemCount()) goto L53;
        p0 r2 = (p0) getItem(r0);
        if (this.n.add(r2.getId()) == false) goto L53;
        if ((r2 instanceof u0) == false) goto L24;
        String r3 = "dora_interpretation";
    L51:
        if (r3 == null) goto L53;
        com.larus.dora.impl.device.manage.b.b("device_management", r3);
        goto L53
    L24:
        if ((r2 instanceof e) == false) goto L27;
        r3 = "ai_doc_detail";
        goto L51
    L27:
        if ((r2 instanceof o0) == false) goto L30;
        r3 = "dora_health";
        goto L51
    L30:
        if ((r2 instanceof q0) == false) goto L33;
        r3 = "dora_album";
        goto L51
    L33:
        if ((r2 instanceof t0) == false) goto L36;
        r3 = "dora_voice_memos";
        goto L51
    L36:
        if ((r2 instanceof c) == false) goto L39;
        r3 = "dora_setting";
        goto L51
    L39:
        if ((r2 instanceof s0) == false) goto L42;
        r3 = "dora_feature_introduction";
        goto L51
    L42:
        if ((r2 instanceof f) == false) goto L45;
        r3 = "dora_feedback";
        goto L51
    L45:
        if ((r2 instanceof d) == false) goto L48;
        r3 = "dora_diary";
        goto L51
    L48:
        if ((r2 instanceof b1) == false) goto L50;
        r3 = "dora_soda_banner";
        goto L51
    L50:
        r3 = null;
        goto L51
    L57:
        return;
    L58:
        return;
    L55:
        return;
    L7:
        r8 = null;
        goto L8
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        BaseViewHolder r6 = (BaseViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        p0 r0 = (p0) getItem(r5);
        g49.d.d("DoraGDeviceManagementAdapter", "onBindViewHolder position=" + r5 + " itemType=" + r0.getClass().getSimpleName());
        Intrinsics.checkNotNull(r0);
        r6.U3(r0);
        if ((r6 instanceof LifecycleUIComponentHolder) == false) goto L6;
        this.m.add(((LifecycleUIComponentHolder) r6).b);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r36, int r37) {
        Intrinsics.checkNotNullParameter(r36, "parent");
        g49.d.d("DoraGDeviceManagementAdapter", "onCreateViewHolder viewType=" + r37);
        LayoutInflater r4 = LayoutInflater.from(r36.getContext());
        if (r37 != 8) goto L9;
        SodaBannerComponent r2 = new SodaBannerComponent();
        r2.f = this.l;
        this.m.add(r2);
        if (r2.a() == false) goto L7;
        r2.m62getLifecycle().setCurrentState(Lifecycle.State.CREATED);
    L7:
        Intrinsics.checkNotNull(r4);
        return new LifecycleUIComponentHolder(r2.f(r4, r36), r2);
    L9:
        if (r37 == 1) goto L17;
        if (r37 == 4) goto L16;
        if (r37 == 5) goto L15;
        if (r37 == 6) goto L14;
        LifecycleUIComponent r9 = null;
    L18:
        if (r9 == null) goto L34;
        this.m.add(r9);
        if (r9.a() == false) goto L22;
        r9.m62getLifecycle().setCurrentState(Lifecycle.State.CREATED);
    L22:
        Intrinsics.checkNotNull(r4);
        View r1 = r9.f(r4, r36);
        if (r37 == 1) goto L32;
        if (r37 == 4) goto L31;
        if (r37 == 5) goto L30;
        if (r37 != 6) goto L29;
        LifecycleUIComponentHolder r3 = new LifecycleUIComponentHolder(r1, r9);
    L178:
        return r3;
    L29:
        throw new RuntimeException("won't reach here.");
    L30:
        r3 = new LifecycleUIComponentHolder(r1, r9);
        goto L178
    L31:
        r3 = new LifecycleUIComponentHolder(r1, r9);
        goto L178
    L32:
        r3 = new LifecycleUIComponentHolder(r1, r9);
        goto L178
    L34:
        int r5 = 2131367858;
        int r12 = 2131374285;
        int r13 = 2131387557;
        if (r37 != 2) goto L37;
        int r6 = DiaryViewHolder.e;
        Intrinsics.checkNotNull(r4);
        Function0<Unit> r7 = this.f;
        Function1<String, Unit> r8 = this.g;
        Function0<Unit> r14 = this.j;
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r36, "parent");
        ConstraintLayout r10 = r4.inflate(2131562550, r36, false);
        LinearLayout r24 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131362149);
        if (r24 == null) goto L175;
        DoraTextView r25 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131367858);
        if (r25 == null) goto L177;
        ConstraintLayout r26 = ViewBindings.findChildViewById(r10, 2131368540);
        if (r26 == null) goto L174;
        r5 = 2131371598;
        DoraTextView r27 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131371598);
        if (r27 == null) goto L177;
        LinearLayout r28 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131371599);
        if (r28 == null) goto L173;
        DoraTextView r210 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131371601);
        if (r210 == null) goto L172;
        ConstraintLayout r30 = ViewBindings.findChildViewById(r10, 2131374285);
        if (r30 != null) goto L152;
        r5 = 2131374285;
        goto L177
    L152:
        if (((ImageView) ViewBindings.findChildViewById(r10, 2131374718)) != null) goto L154;
        r5 = 2131374718;
        goto L177
    L154:
        if (((ImageView) ViewBindings.findChildViewById(r10, 2131379041)) == null) goto L169;
        LinearLayout r31 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131379076);
        if (r31 == null) goto L168;
        DoraTextView r32 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131387557);
        if (r32 == null) goto L167;
        SimpleDraweeView r33 = ViewBindings.findChildViewById(r10, 2131388625);
        if (r33 == null) goto L166;
        DoraTextView r34 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131388915);
        if (r34 == null) goto L165;
        RecyclerView.ViewHolder r11 = new DiaryViewHolder(new LarusItemDoraGDeviceManagementDiaryBinding(r10, r24, r25, r26, r27, r28, r210, r30, r31, r32, r33, r34), r7, r8, r14);
    L179:
        return r11;
    L165:
        r5 = 2131388915;
        goto L177
    L166:
        r5 = 2131388625;
        goto L177
    L167:
        r5 = 2131387557;
        goto L177
    L168:
        r5 = 2131379076;
        goto L177
    L169:
        r5 = 2131379041;
        goto L177
    L172:
        r5 = 2131371601;
        goto L177
    L173:
        r5 = 2131371599;
        goto L177
    L174:
        r5 = 2131368540;
    L177:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r5)));
    L175:
        r5 = 2131362149;
        goto L177
    L37:
        if (r37 == 3) goto L99;
        switch(r37) {
            case 9: goto L81;
            case 10: goto L58;
            case 11: goto L48;
            default: goto L39;
        };
    L39:
        int r15 = MoreFeaturesViewHolder.c;
        Intrinsics.checkNotNull(r4);
        Function0<Unit> r16 = this.d;
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r36, "parent");
        ConstraintLayout r17 = r4.inflate(2131562556, r36, false);
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r17, 2131362149);
        if (r18 == null) goto L96;
        ImageView r110 = (ImageView) ViewBindings.findChildViewById(r17, 2131374718);
        if (r110 == null) goto L95;
        DoraTextView r20 = (DoraTextView) ViewBindings.findChildViewById(r17, 2131387557);
        if (r20 == null) goto L98;
        DoraTextView r21 = (DoraTextView) ViewBindings.findChildViewById(r17, 2131388915);
        if (r21 == null) goto L94;
        r11 = new MoreFeaturesViewHolder(new LarusItemDoraGDeviceManagementMoreFeaturesBinding(r17, r18, r110, r20, r21), r16);
        goto L179
    L94:
        r13 = 2131388915;
    L98:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r13)));
    L95:
        r13 = 2131374718;
        goto L98
    L96:
        r13 = 2131362149;
        goto L98
    L48:
        int r22 = FeedbackViewHolder.c;
        Intrinsics.checkNotNull(r4);
        Function0<Unit> r23 = this.e;
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r36, "parent");
        ConstraintLayout r35 = r4.inflate(2131562552, r36, false);
        int r38 = 2131372265;
        if (((ImageView) ViewBindings.findChildViewById(r35, 2131372265)) == null) goto L57;
        r38 = 2131372288;
        if (((ImageView) ViewBindings.findChildViewById(r35, 2131372288)) == null) goto L57;
        r38 = 2131372318;
        DoraTextView r40 = (DoraTextView) ViewBindings.findChildViewById(r35, 2131372318);
        if (r40 == null) goto L57;
        r11 = new FeedbackViewHolder(new LarusItemDoraGDeviceManagementFeedbackBinding(r35, r40), r23);
    L57:
        throw new NullPointerException("Missing required view with ID: ".concat(r35.getResources().getResourceName(r38)));
    L58:
        int r41 = HealthViewHolder.c;
        Intrinsics.checkNotNull(r4);
        Function1<String, Unit> r42 = this.i;
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r36, "parent");
        ConstraintLayout r43 = r4.inflate(2131562554, r36, false);
        LinearLayout r111 = (LinearLayout) ViewBindings.findChildViewById(r43, 2131362082);
        if (r111 == null) goto L78;
        DoraTextView r112 = (DoraTextView) ViewBindings.findChildViewById(r43, 2131362149);
        if (r112 == null) goto L77;
        DoraTextView r211 = (DoraTextView) ViewBindings.findChildViewById(r43, 2131364110);
        if (r211 == null) goto L76;
        DoraTextView r212 = (DoraTextView) ViewBindings.findChildViewById(r43, 2131368840);
        if (r212 != null) goto L67;
        r12 = 2131368840;
    L80:
        throw new NullPointerException("Missing required view with ID: ".concat(r43.getResources().getResourceName(r12)));
    L67:
        if (ViewBindings.findChildViewById(r43, 2131374285) == null) goto L80;
        if (((ImageView) ViewBindings.findChildViewById(r43, 2131374718)) == null) goto L74;
        DoraTextView r213 = (DoraTextView) ViewBindings.findChildViewById(r43, 2131388915);
        if (r213 == null) goto L73;
        r11 = new HealthViewHolder(new LarusItemDoraGDeviceManagementHealthBinding(r43, r111, r112, r211, r212, r213), r42);
        goto L179
    L73:
        r12 = 2131388915;
        goto L80
    L74:
        r12 = 2131374718;
        goto L80
    L76:
        r12 = 2131364110;
        goto L80
    L77:
        r12 = 2131362149;
        goto L80
    L78:
        r12 = 2131362082;
        goto L80
    L81:
        int r44 = FirmwareUpdateViewHolder.c;
        Intrinsics.checkNotNull(r4);
        Function1<g, Unit> r45 = this.k;
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r36, "parent");
        ConstraintLayout r46 = r4.inflate(2131562553, r36, false);
        if (((ImageView) ViewBindings.findChildViewById(r46, 2131374718)) == null) goto L91;
        DoraTextView r47 = (DoraTextView) ViewBindings.findChildViewById(r46, 2131387557);
        if (r47 == null) goto L93;
        DoraTextView r48 = (DoraTextView) ViewBindings.findChildViewById(r46, 2131388915);
        if (r48 == null) goto L90;
        r13 = 2131391896;
        DoraTextView r50 = (DoraTextView) ViewBindings.findChildViewById(r46, 2131391896);
        if (r50 == null) goto L93;
        r11 = new FirmwareUpdateViewHolder(new LarusItemDoraGDeviceManagementFirmwareUpdateBinding(r46, r47, r48, r50), r45);
        goto L179
    L90:
        r13 = 2131388915;
    L93:
        throw new NullPointerException("Missing required view with ID: ".concat(r46.getResources().getResourceName(r13)));
    L91:
        r13 = 2131374718;
        goto L93
    L99:
        int r51 = DocViewHolder.d;
        Intrinsics.checkNotNull(r4);
        Function1<String, Unit> r52 = this.h;
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r36, "parent");
        ConstraintLayout r53 = r4.inflate(2131562551, r36, false);
        LinearLayout r214 = (LinearLayout) ViewBindings.findChildViewById(r53, 2131362149);
        if (r214 == null) goto L134;
        DoraTextView r215 = (DoraTextView) ViewBindings.findChildViewById(r53, 2131367858);
        if (r215 == null) goto L136;
        ConstraintLayout r216 = ViewBindings.findChildViewById(r53, 2131368540);
        if (r216 == null) goto L133;
        LinearLayout r217 = (LinearLayout) ViewBindings.findChildViewById(r53, 2131371599);
        if (r217 != null) goto L108;
        r5 = 2131371599;
        goto L136
    L108:
        if (((DoraTextView) ViewBindings.findChildViewById(r53, 2131371601)) != null) goto L110;
        r5 = 2131371601;
        goto L136
    L110:
        if (ViewBindings.findChildViewById(r53, 2131374285) != null) goto L112;
        r5 = 2131374285;
        goto L136
    L112:
        if (((ImageView) ViewBindings.findChildViewById(r53, 2131374718)) != null) goto L114;
        r5 = 2131374718;
        goto L136
    L114:
        if (((ImageView) ViewBindings.findChildViewById(r53, 2131379041)) == null) goto L128;
        LinearLayout r218 = (LinearLayout) ViewBindings.findChildViewById(r53, 2131379076);
        if (r218 == null) goto L127;
        DoraTextView r219 = (DoraTextView) ViewBindings.findChildViewById(r53, 2131387557);
        if (r219 == null) goto L126;
        SimpleDraweeView r220 = ViewBindings.findChildViewById(r53, 2131388625);
        if (r220 == null) goto L125;
        DoraTextView r310 = (DoraTextView) ViewBindings.findChildViewById(r53, 2131388915);
        if (r310 == null) goto L124;
        r11 = new DocViewHolder(new LarusItemDoraGDeviceManagementDocBinding(r53, r214, r215, r216, r217, r218, r219, r220, r310), r52);
        goto L179
    L124:
        r5 = 2131388915;
        goto L136
    L125:
        r5 = 2131388625;
        goto L136
    L126:
        r5 = 2131387557;
        goto L136
    L127:
        r5 = 2131379076;
        goto L136
    L128:
        r5 = 2131379041;
        goto L136
    L133:
        r5 = 2131368540;
    L136:
        throw new NullPointerException("Missing required view with ID: ".concat(r53.getResources().getResourceName(r5)));
    L134:
        r5 = 2131362149;
        goto L136
    L14:
        r9 = new SimultaneousInterpretUIComponent();
        goto L18
    L15:
        r9 = new RecordMinutesUIComponent();
        goto L18
    L16:
        r9 = new MediaAlbumUIComponent();
        goto L18
    L17:
        DeviceUIComponent r54 = new DeviceUIComponent();
        r54.f = this.a;
        r54.g = this.b;
        r54.h = this.c;
        r9 = r54;
        goto L18
    }

    public DoraGDeviceManagementAdapter(c0 r2, j r3, k r4, l r5, m r6, n r7, o r8, p r9, q r10, r r11, d0 r12, i r13) {
        Intrinsics.checkNotNullParameter(r2, "onDeviceSelectorClick");
        Intrinsics.checkNotNullParameter(r3, "onAddDeviceClick");
        Intrinsics.checkNotNullParameter(r4, "onReconnectClick");
        Intrinsics.checkNotNullParameter(r5, "onMoreFeaturesClick");
        Intrinsics.checkNotNullParameter(r6, "onFeedbackClick");
        super(b.a);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = new LinkedHashSet();
        this.n = new HashSet();
    }
}
