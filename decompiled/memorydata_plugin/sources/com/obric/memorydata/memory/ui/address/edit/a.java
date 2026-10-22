package com.obric.memorydata.memory.ui.address.edit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.api.model.AddressInfo;
import com.obric.memorydata.memory.databinding.ItemAddressBinding;
import com.obric.memorydata.memory.utils.w;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.i;
import com.obric.oui.orecyclerview.widget.q;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000  2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003 !\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007J\u001a\u0010\u000e\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\u0011\u001a\u00020\b2\n\u0010\u0012\u001a\u00060\u0003R\u00020\u0000H\u0016J\u001c\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\b2\n\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J*\u0010\u0018\u001a\u00020\b2\n\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J$\u0010\u001d\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressAdapter;", "Lcom/obric/oui/orecyclerview/widget/ListAdapter;", "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "Lcom/obric/memorydata/memory/ui/address/edit/AddressAdapter$AddressViewHolder;", "<init>", "()V", "onItemClickListener", "Lkotlin/Function1;", "", "onDeleteButtonClickListener", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "setOnItemClickListener", "listener", "setDeleteButtonClickListener", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "onViewAttachedToWindow", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "position", "payloads", "", "", "onCurrentListChanged", "previousList", "currentList", "Companion", "AddressViewHolder", "DiffCallback", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends q<AddressInfo, C0520a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10578a = null;
    private Function1<? super AddressInfo, Unit> c;
    private Function1<? super AddressInfo, Unit> d;
    private RecyclerView e;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JF\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000eJ\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\u0007J\n\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0002J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tH\u0002J\f\u0010\u001a\u001a\u00020\u0007*\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressAdapter$AddressViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/memorydata/memory/databinding/ItemAddressBinding;", "<init>", "(Lcom/obric/memorydata/memory/ui/address/edit/AddressAdapter;Lcom/obric/memorydata/memory/databinding/ItemAddressBinding;)V", "bind", "", MemoryKeyInfoEntity.KEY_ADDRESS, "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "position", "", "itemCount", "onClick", "Lkotlin/Function1;", "onDeleteClick", "updateItemChrome", "updateSelectionChrome", "refreshCurrentItemChrome", "getCurrentAddress", "applySelectionChrome", "from", "", "forceLayout", "", "ensureEndMark", "fixEndMarkSize", "Landroid/view/View;", "logEndMarkState", "resolveCardPosition", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class C0520a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f10579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ItemAddressBinding f10580b;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.a$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/memory/ui/address/edit/AddressAdapter$AddressViewHolder$bind$1$2", "Lcom/obric/memorydata/memory/utils/EnhancedTouchListener;", "onLongClick", "", "view", "Landroid/view/View;", "rawPos", "", "onClick", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0521a extends com.obric.memorydata.memory.utils.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ C0520a f10581a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function1<AddressInfo, Unit> f10582b;

            C0521a(C0520a r3, Function1<? super AddressInfo, Unit> r4) {
                Function1<AddressInfo, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
                this.f10581a = r3;
                this.f10582b = r5;
            }

            private static final void a(C0520a r3) {
                AddressInfo r0 = C0520a.a(r3);
                if (r0 == null) goto L6;
                C0520a.a(r3, "click:post", r0, true);
                return;
            }

            public static /* synthetic */ void lambda$fRWkPf7cgCKM6IgYnI0evlsMke0(C0520a r0) {
                a(r0);
            }

            @Override // com.obric.memorydata.memory.utils.c
            public boolean a(View r7, int[] r8) {
                Intrinsics.checkNotNullParameter(r7, "view");
                Intrinsics.checkNotNullParameter(r8, "rawPos");
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AddressAdapter", "address long click ignored position=" + this.f10581a.o(), false, 4, null);
                return true;
            }

            @Override // com.obric.memorydata.memory.utils.c
            public boolean b(View r3, int[] r4) {
                Intrinsics.checkNotNullParameter(r3, "view");
                Intrinsics.checkNotNullParameter(r4, "rawPos");
                AddressInfo r5 = C0520a.a(this.f10581a);
                if (r5 != null) goto L5;
                return true;
            L5:
                C0520a.a(this.f10581a, "click:before", r5);
                this.f10582b.invoke(r5);
                C0520a.a(this.f10581a, "click:after", r5);
                DeviceAdaptiveCardListItem r6 = C0520a.b(this.f10581a).addressItem;
                final C0520a r2 = this.f10581a;
                r6.post(new $$Lambda$a$a$a$fRWkPf7cgCKM6IgYnI0evlsMke0(r2));
                return true;
            }
        }

        public C0520a(a r6, ItemAddressBinding r7) {
            Intrinsics.checkNotNullParameter(r7, "binding");
            this.f10579a = r6;
            super((View) ZeusTransformUtils.preCheckCast(r7.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f10580b = r7;
            float r5 = ZeusTransformUtils.getResources(r7.getRoot(), "com.obric.memorydata.plugin").getDisplayMetrics().density;
            if (r5 <= 0.0f) goto L5;
            int r8 = (int) (938.0f / r5);
        L6:
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new OTextView[]{r7.addressItem.getTitleView(), r7.addressItem.getSubTitleView()}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L8:
            if (r9.hasNext() == false) goto L10;
            OTextView r10 = (OTextView) ZeusTransformUtils.preCheckCast(r9.next(), OTextView.class, "com.obric.memorydata.plugin");
            r10.setSingleLine(false);
            r10.setHorizontallyScrolling(false);
            r10.setMaxLines(3);
            r10.setEllipsize(TextUtils.TruncateAt.END);
            r10.setMaxWidth(MathKt.roundToInt(TypedValue.applyDimension(1, r8, Resources.getSystem().getDisplayMetrics())));
            ViewGroup.LayoutParams r3 = r10.getLayoutParams();
            r3.width = -2;
            r10.setLayoutParams(r3);
            goto L8
        L10:
            return;
        L5:
            r8 = 268;
            goto L6
        }

        private final int a(int r1, int r2) {
            if (r2 > 1) goto L5;
            return 0;
        L5:
            if (r1 != 0) goto L8;
            return 1;
        L8:
            if (r1 != (r2 - 1)) goto L10;
            return 3;
        L10:
            return 2;
        }

        public static final /* synthetic */ AddressInfo a(C0520a r0) {
            return r0.b();
        }

        private static final Unit a(Ref.FloatRef r1, Ref.FloatRef r2, int r3, DeviceAdaptiveCardListItem r4, View r5, MotionEvent r6) {
            Intrinsics.checkNotNullParameter(r5, "<unused var>");
            Intrinsics.checkNotNullParameter(r6, "event");
            int r7 = r6.getAction();
            if (r7 != 0) goto L5;
            r1.element = r6.getRawX();
            r2.element = r6.getRawY();
            a(r4);
        L18:
            return Unit.INSTANCE;
        L5:
            if (r7 != 1) goto L7;
        L15:
            b(r4);
            goto L18
        L7:
            if (r7 != 2) goto L9;
            float r8 = r6.getRawX() - r1.element;
            float r9 = r6.getRawY() - r2.element;
            float r10 = r3;
            if (Math.abs(r8) > r10) goto L15;
            if (Math.abs(r9) <= r10) goto L18;
        L9:
            if (r7 == 3) goto L15;
            goto L15
        }

        private final void a(View r7) {
            Integer r6 = Integer.valueOf(r7.getMinimumWidth());
            boolean r2 = true;
            if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
            boolean r0 = true;
        L6:
            Integer r4 = null;
            if (r0 == true) goto L10;
            r6 = null;
        L10:
            if (r6 == null) goto L12;
        L11:
            int r8 = r6.intValue();
            Integer r1 = Integer.valueOf(r7.getMinimumHeight());
            if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L24;
            boolean r5 = true;
        L25:
            if (r5 == true) goto L28;
            r1 = null;
        L28:
            if (r1 == null) goto L30;
            int r3 = r1.intValue();
        L38:
            ViewGroup.LayoutParams r9 = r7.getLayoutParams();
            if (r9 != null) goto L42;
            return;
        L42:
            if (r9.width == r8) goto L44;
        L46:
            r9.width = r8;
            r9.height = r3;
            r7.setLayoutParams(r9);
            return;
        L44:
            if (r9.height != r3) goto L46;
            return;
        L30:
            Integer r10 = Integer.valueOf(r7.getMeasuredHeight());
            if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L34;
            r2 = false;
        L34:
            if (r2 == false) goto L36;
            r4 = r10;
        L36:
            if (r4 == null) goto L49;
            r3 = r4.intValue();
            goto L38
        L49:
            return;
        L24:
            r5 = false;
            goto L25
        L12:
            r6 = Integer.valueOf(r7.getMeasuredWidth());
            if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L15;
            boolean r11 = true;
        L16:
            if (r11 == true) goto L19;
            r6 = null;
        L19:
            if (r6 != null) goto L11;
            return;
        L15:
            r11 = false;
            goto L16
        L5:
            r0 = false;
            goto L6
        }

        public static final /* synthetic */ void a(C0520a r0, String r1, AddressInfo r2) {
            r0.b(r1, r2);
        }

        public static final /* synthetic */ void a(C0520a r0, String r1, AddressInfo r2, boolean r3) {
            r0.a(r1, r2, r3);
        }

        private static final void a(C0520a r2, Function1 r3) {
            Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            AddressInfo r5 = r2.b();
            if (r5 == null) goto L6;
            r4.invoke(r5);
            return;
        }

        private static final void a(C0520a r1, Function1 r2, View r3) {
            Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
            AddressInfo r5 = r1.b();
            if (r5 == null) goto L6;
            r4.invoke(r5);
            return;
        }

        private static final void a(DeviceAdaptiveCardListItem r1) {
            r1.setContentChecked(true);
        }

        private final void a(String r9, AddressInfo r10) {
            if (this.f10580b.addressItem.getEndMark() != null) goto L5;
            this.f10580b.addressItem.setDefaultCustomEndView(2);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AddressAdapter", r9 + " recreate endMark position=" + o() + " selected=" + r10.isSelect(), false, 4, null);
        L5:
            OCheckMark r0 = this.f10580b.addressItem.getEndMark();
            if (r0 == null) goto L12;
            r0.setClickable(false);
            r0.setFocusable(false);
            r0.setChecked(true);
            a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
            r0.setVisibility(0);
            if (r10.isSelect() == false) goto L10;
            float r1 = 1.0f;
        L11:
            r0.setAlpha(r1);
            goto L12
        L10:
            r1 = 0.0f;
        L12:
            b(r9, r10);
        }

        private final void a(String r3, AddressInfo r4, boolean r5) {
            a(r3 + ":beforeShow", r4);
            this.f10580b.addressItem.e(true);
            a(r3 + ":afterShow", r4);
            if (r5 == false) goto L6;
            this.f10580b.addressItem.requestLayout();
            this.f10580b.addressItem.invalidate();
            return;
        }

        private final AddressInfo b() {
            int r0 = o();
            if (r0 != (-1)) goto L6;
            return null;
        L6:
            return a.a(this.f10579a, r0);
        }

        public static final /* synthetic */ ItemAddressBinding b(C0520a r0) {
            return r0.f10580b;
        }

        private static final void b(View r0) {
        }

        private static final void b(DeviceAdaptiveCardListItem r1) {
            r1.setContentChecked(false);
            r1.a();
        }

        private final void b(String r12, AddressInfo r13) {
            OCheckMark r0 = this.f10580b.addressItem.getEndMark();
            View r1 = this.f10580b.addressItem.getCustomEndView();
            Drawable r2 = null;
            if (r1 == null) goto L5;
            ViewParent r3 = r1.getParent();
        L7:
            if (ZeusTransformUtils.instanceOf(r3, View.class) == false) goto L9;
            View r4 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
        L10:
            IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r6 = new StringBuilder();
            StringBuilder r14 = r6.append(r12).append(" position=").append(o()).append(" selected=").append(r13.isSelect()).append(" customEndVisibility=");
            if (r1 == null) goto L13;
            Integer r15 = Integer.valueOf(r1.getVisibility());
        L14:
            StringBuilder r16 = r14.append(r15).append(" customEndSize=");
            if (r1 == null) goto L17;
            Integer r17 = Integer.valueOf(r1.getWidth());
        L18:
            StringBuilder r18 = r16.append(r17).append('x');
            if (r1 == null) goto L21;
            Integer r7 = Integer.valueOf(r1.getHeight());
        L22:
            StringBuilder r19 = r18.append(r7).append(" customEndParentVisibility=");
            if (r4 == null) goto L25;
            Integer r8 = Integer.valueOf(r4.getVisibility());
        L26:
            StringBuilder r110 = r19.append(r8).append(" customEndParentSize=");
            if (r4 == null) goto L29;
            Integer r9 = Integer.valueOf(r4.getWidth());
        L30:
            StringBuilder r111 = r110.append(r9).append('x');
            if (r4 == null) goto L33;
            Integer r10 = Integer.valueOf(r4.getHeight());
        L34:
            StringBuilder r112 = r111.append(r10).append(" markNull=");
            boolean r11 = true;
            if (r0 != null) goto L37;
            boolean r20 = true;
        L38:
            StringBuilder r113 = r112.append(r20).append(" markChecked=");
            if (r0 == null) goto L41;
            Boolean r21 = Boolean.valueOf(r0.isChecked());
        L42:
            StringBuilder r114 = r113.append(r21).append(" markVisibility=");
            if (r0 == null) goto L45;
            Integer r22 = Integer.valueOf(r0.getVisibility());
        L46:
            r114.append(r22);
            StringBuilder r115 = r6.append(" markSize=");
            if (r0 == null) goto L49;
            Integer r23 = Integer.valueOf(r0.getWidth());
        L50:
            StringBuilder r116 = r115.append(r23).append('x');
            if (r0 == null) goto L53;
            Integer r24 = Integer.valueOf(r0.getHeight());
        L54:
            StringBuilder r117 = r116.append(r24).append(" markMinSize=");
            if (r0 == null) goto L57;
            Integer r25 = Integer.valueOf(r0.getMinimumWidth());
        L58:
            StringBuilder r118 = r117.append(r25).append('x');
            if (r0 == null) goto L61;
            Integer r26 = Integer.valueOf(r0.getMinimumHeight());
        L62:
            StringBuilder r119 = r118.append(r26).append(" markLp=");
            if (r0 == null) goto L67;
            ViewGroup.LayoutParams r27 = r0.getLayoutParams();
            if (r27 == null) goto L67;
            Integer r28 = Integer.valueOf(r27.width);
        L68:
            StringBuilder r120 = r119.append(r28).append('x');
            if (r0 == null) goto L73;
            ViewGroup.LayoutParams r29 = r0.getLayoutParams();
            if (r29 == null) goto L73;
            Integer r30 = Integer.valueOf(r29.height);
        L74:
            StringBuilder r121 = r120.append(r30).append(" markAlpha=");
            if (r0 == null) goto L77;
            Float r31 = Float.valueOf(r0.getAlpha());
        L78:
            StringBuilder r122 = r121.append(r31).append(" markBackgroundNull=");
            if (r0 == null) goto L81;
            r2 = r0.getBackground();
        L81:
            if (r2 == null) goto L84;
            r11 = false;
        L84:
            r122.append(r11).append(" itemSize=").append(this.f10580b.addressItem.getWidth()).append('x').append(this.f10580b.addressItem.getHeight());
            IRunLog.a.a(r5, "AddressAdapter", r6.toString(), false, 4, null);
            return;
        L77:
            r31 = null;
        L73:
            r30 = null;
        L67:
            r28 = null;
            goto L68
        L61:
            r26 = null;
            goto L62
        L57:
            r25 = null;
            goto L58
        L53:
            r24 = null;
            goto L54
        L49:
            r23 = null;
            goto L50
        L45:
            r22 = null;
            goto L46
        L41:
            r21 = null;
            goto L42
        L37:
            r20 = false;
            goto L38
        L33:
            r10 = null;
            goto L34
        L29:
            r9 = null;
            goto L30
        L25:
            r8 = null;
            goto L26
        L21:
            r7 = null;
            goto L22
        L17:
            r17 = null;
            goto L18
        L13:
            r15 = null;
            goto L14
        L9:
            r4 = null;
            goto L10
        L5:
            r3 = null;
            goto L7
        }

        public static /* synthetic */ void lambda$JlGSbt47xgDLGYBnYbIMlm7Yj2g(View r0) {
            b(r0);
        }

        public static /* synthetic */ void lambda$PoLmUH1lBfM7Mr44SQBtCHTwZEE(C0520a r0, Function1 r1, View r2) {
            a(r0, r1, r2);
        }

        /* JADX INFO: renamed from: lambda$Ypny63mEWiYPl5wQ1y1oaQYfQ-c, reason: not valid java name */
        public static /* synthetic */ Unit m771lambda$Ypny63mEWiYPl5wQ1y1oaQYfQc(Ref.FloatRef r0, Ref.FloatRef r1, int r2, DeviceAdaptiveCardListItem r3, View r4, MotionEvent r5) {
            return a(r0, r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void lambda$zG0QTUSAS3DMaKdXykiTzDKO4Vs(C0520a r0, Function1 r1) {
            a(r0, r1);
        }

        public final void a() {
            int r0 = o();
            if (r0 != (-1)) goto L5;
            return;
        L5:
            AddressInfo r1 = a.a(this.f10579a, r0);
            Intrinsics.checkNotNullExpressionValue(r1, "access$getItem(...)");
            a(r1, r0, this.f10579a.d());
        }

        public final void a(AddressInfo r3) {
            Intrinsics.checkNotNullParameter(r3, MemoryKeyInfoEntity.KEY_ADDRESS);
            a("updateSelectionChrome", r3, false);
        }

        public final void a(AddressInfo r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, MemoryKeyInfoEntity.KEY_ADDRESS);
            OCardListItem.a((OCardListItem) ZeusTransformUtils.preCheckCast(this.f10580b.addressItem, OCardListItem.class, "com.obric.memorydata.plugin"), a(r5, r6), false, 2, null);
            a("updateItemChrome", r4, true);
            this.f10580b.addressItem.getSwipeLayout().b(false, false);
        }

        public final void a(AddressInfo r8, int r9, int r10, Function1<? super AddressInfo, Unit> r11, Function1<? super AddressInfo, Unit> r12) {
            Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
            final Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, MemoryKeyInfoEntity.KEY_ADDRESS);
            Intrinsics.checkNotNullParameter(r13, "onClick");
            Intrinsics.checkNotNullParameter(r14, "onDeleteClick");
            final DeviceAdaptiveCardListItem r0 = this.f10580b.addressItem;
            r0.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r8.getName(), CharSequence.class, "com.obric.memorydata.plugin"));
            r0.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r8.getDetail(), CharSequence.class, "com.obric.memorydata.plugin"));
            r0.b(false);
            r0.c(true);
            r0.d(true);
            r0.f(false);
            a(r8, r9, r10);
            r0.setOnContentClickListener($$Lambda$a$a$JlGSbt47xgDLGYBnYbIMlm7Yj2g.INSTANCE);
            w r15 = w.f11568a;
            View r16 = (View) ZeusTransformUtils.preCheckCast(r0.getContentContainer(), View.class, "com.obric.memorydata.plugin");
            C0521a r17 = new C0521a(this, r13);
            final Ref.FloatRef r18 = new Ref.FloatRef();
            final Ref.FloatRef r4 = new Ref.FloatRef();
            final int r5 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
            r17.a(new $$Lambda$a$a$Ypny63mEWiYPl5wQ1y1oaQYfQc(r18, r4, r5, r0));
            Unit r19 = Unit.INSTANCE;
            r15.a(r16, (com.obric.memorydata.memory.utils.c) ZeusTransformUtils.preCheckCast(r17, com.obric.memorydata.memory.utils.c.class, "com.obric.memorydata.plugin"));
            r0.getSwipeLayout().b(false, false);
            r0.getSwipeLayout().b();
            r0.setSwipeView(ZeusTransformUtils.mapRes(R.layout.item_address_swipe_delete, "layout", "item_address_swipe_delete"));
            r0.setEnableSwipe(true);
            OSwipeLayout r20 = r0.getSwipeLayout();
            View r21 = r0.getSwipeView();
            if (ZeusTransformUtils.instanceOf(r21, ViewGroup.class) == false) goto L5;
            ViewGroup r22 = (ViewGroup) ZeusTransformUtils.preCheckCast(r21, ViewGroup.class, "com.obric.memorydata.plugin");
        L6:
            if (r20 == null) goto L9;
            if (r22 == null) goto L9;
            new com.obric.oui.swipeaction.a(r20, r22).a(new $$Lambda$a$a$zG0QTUSAS3DMaKdXykiTzDKO4Vs(this, r14));
        L9:
            View r23 = r0.getSwipeView();
            if (r23 == null) goto L15;
            View r24 = r23.findViewById(ZeusTransformUtils.mapRes(R.id.btn_swipe_delete, OaidModel.KEY_ID, "btn_swipe_delete"));
            if (r24 == null) goto L16;
            r24.setOnClickListener(new $$Lambda$a$a$PoLmUH1lBfM7Mr44SQBtCHTwZEE(this, r14));
            return;
        L16:
            return;
        L15:
            return;
        L5:
            r22 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressAdapter$Companion;", "", "<init>", "()V", "TAG", "", "PAYLOAD_CARD_POSITION", "PAYLOAD_SELECTION", "POSITION_REFRESH_DELAY_MS", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressAdapter$DiffCallback;", "Lcom/obric/oui/orecyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "getChangePayload", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends i.e<AddressInfo> {
        public c() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean a2(AddressInfo r7, AddressInfo r8) {
            Intrinsics.checkNotNullParameter(r7, "oldItem");
            Intrinsics.checkNotNullParameter(r8, "newItem");
            if (Intrinsics.areEqual(r7.getName(), r8.getName()) == false) goto L18;
            if (Intrinsics.areEqual(r7.getDetail(), r8.getDetail()) == false) goto L18;
            if (r7.getLatitude() != r8.getLatitude()) goto L9;
            boolean r6 = true;
        L10:
            if (r6 == false) goto L18;
            if (r7.getLongitude() != r8.getLongitude()) goto L14;
            boolean r9 = true;
        L15:
            if (r9 == false) goto L18;
            return true;
        L14:
            r9 = false;
            goto L15
        L9:
            r6 = false;
        L18:
            return false;
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean a(AddressInfo r3, AddressInfo r4) {
            return a2((AddressInfo) ZeusTransformUtils.preCheckCast(r3, AddressInfo.class, "com.obric.memorydata.plugin"), (AddressInfo) ZeusTransformUtils.preCheckCast(r4, AddressInfo.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public boolean b2(AddressInfo r1, AddressInfo r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean b(AddressInfo r3, AddressInfo r4) {
            return b2((AddressInfo) ZeusTransformUtils.preCheckCast(r3, AddressInfo.class, "com.obric.memorydata.plugin"), (AddressInfo) ZeusTransformUtils.preCheckCast(r4, AddressInfo.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
        public Object c2(AddressInfo r12, AddressInfo r13) {
            Intrinsics.checkNotNullParameter(r12, "oldItem");
            Intrinsics.checkNotNullParameter(r13, "newItem");
            if (Intrinsics.areEqual(AddressInfo.copy$default(r12, null, null, 0.0d, 0.0d, r13.isSelect(), false, 47, null), r13) == true) goto L5;
        L7:
            return null;
        L5:
            if (r12.isSelect() == r13.isSelect()) goto L7;
            return "payload_selection";
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ Object c(AddressInfo r3, AddressInfo r4) {
            return c2((AddressInfo) ZeusTransformUtils.preCheckCast(r3, AddressInfo.class, "com.obric.memorydata.plugin"), (AddressInfo) ZeusTransformUtils.preCheckCast(r4, AddressInfo.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f10578a = new b(null);
    }

    public a() {
        super((i.e) ZeusTransformUtils.preCheckCast(new c(), i.e.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ AddressInfo a(a r1, int r2) {
        return (AddressInfo) ZeusTransformUtils.preCheckCast(r1.b(r2), AddressInfo.class, "com.obric.memorydata.plugin");
    }

    private static final Unit a(a r3) {
        if (r3.d() <= 0) goto L6;
        r3.a(0, r3.d(), "payload_card_position");
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit a(a r1, AddressInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        Function1<? super AddressInfo, Unit> r3 = r1.c;
        if (r3 == null) goto L6;
        r3.invoke(r2);
    L6:
        return Unit.INSTANCE;
    }

    private static final void a(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private static final Unit b(a r1, AddressInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        Function1<? super AddressInfo, Unit> r3 = r1.d;
        if (r3 == null) goto L6;
        r3.invoke(r2);
    L6:
        return Unit.INSTANCE;
    }

    private static final void b(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    /* JADX INFO: renamed from: lambda$WhXW_5Jo7fv6-38Zp-zaLYBBqxI, reason: not valid java name */
    public static /* synthetic */ Unit m768lambda$WhXW_5Jo7fv638ZpzaLYBBqxI(a r0, AddressInfo r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$cVMaej4WgenZugt2Olu-ULZ5hTY, reason: not valid java name */
    public static /* synthetic */ Unit m769lambda$cVMaej4WgenZugt2OluULZ5hTY(a r0, AddressInfo r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ void lambda$gQfw5WP7qhGeiSBc93lNV0SvXPw(Function0 r0) {
        b(r0);
    }

    public static /* synthetic */ void lambda$grbOQbyrt3Gsp5Z8kOjaPedmi8U(Function0 r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$uj5Ocx3-IKPjBXMUvoEoWuuxHIc, reason: not valid java name */
    public static /* synthetic */ Unit m770lambda$uj5Ocx3IKPjBXMUvoEoWuuxHIc(a r0) {
        return a(r0);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public void a(C0520a r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.a((RecyclerView.v) ZeusTransformUtils.preCheckCast(r3, RecyclerView.v.class, "com.obric.memorydata.plugin"));
        r3.a();
    }

    public void a(C0520a r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        AddressInfo r0 = b(r9);
        Intrinsics.checkNotNullExpressionValue(r0, "getItem(...)");
        r8.a((AddressInfo) ZeusTransformUtils.preCheckCast(r0, AddressInfo.class, "com.obric.memorydata.plugin"), r9, d(), new $$Lambda$a$WhXW_5Jo7fv638ZpzaLYBBqxI(this), new $$Lambda$a$cVMaej4WgenZugt2OluULZ5hTY(this));
    }

    public void a(C0520a r4, int r5, List<Object> r6) {
        List<Object> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r7, "payloads");
        if (r7.contains("payload_card_position") == false) goto L7;
        AddressInfo r8 = b(r5);
        Intrinsics.checkNotNullExpressionValue(r8, "getItem(...)");
        r4.a((AddressInfo) ZeusTransformUtils.preCheckCast(r8, AddressInfo.class, "com.obric.memorydata.plugin"), r5, d());
        return;
    L7:
        if (r7.contains("payload_selection") == false) goto L10;
        AddressInfo r3 = b(r5);
        Intrinsics.checkNotNullExpressionValue(r3, "getItem(...)");
        r4.a((AddressInfo) ZeusTransformUtils.preCheckCast(r3, AddressInfo.class, "com.obric.memorydata.plugin"));
        return;
    L10:
        super.a((RecyclerView.v) ZeusTransformUtils.preCheckCast(r4, RecyclerView.v.class, "com.obric.memorydata.plugin"), r5, r7);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3) {
        a((C0520a) ZeusTransformUtils.preCheckCast(r3, C0520a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((C0520a) ZeusTransformUtils.preCheckCast(r3, C0520a.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4, List r5) {
        List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        a((C0520a) ZeusTransformUtils.preCheckCast(r3, C0520a.class, "com.obric.memorydata.plugin"), r4, r6);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.a(r2);
        this.e = r2;
    }

    @Override // com.obric.oui.orecyclerview.widget.q
    public void a(List<AddressInfo> r3, List<AddressInfo> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "previousList");
        Intrinsics.checkNotNullParameter(r6, "currentList");
        super.a(r5, r6);
        if (r5.size() != r6.size()) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L18;
        final Function0 r0 = new $$Lambda$a$uj5Ocx3IKPjBXMUvoEoWuuxHIc(this);
        int r7 = r6.size();
        int r8 = r5.size();
        RecyclerView r2 = this.e;
        if (r7 >= r8) goto L11;
        if (r2 == null) goto L13;
        r2.postDelayed(new $$Lambda$a$grbOQbyrt3Gsp5Z8kOjaPedmi8U(r0), 350);
        return;
    L13:
        r0.invoke();
        return;
    L11:
        if (r2 == null) goto L13;
        r2.post(new $$Lambda$a$gQfw5WP7qhGeiSBc93lNV0SvXPw(r0));
        return;
    }

    public final void a(Function1<? super AddressInfo, Unit> r3) {
        Function1<? super AddressInfo, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.c = r4;
    }

    public C0520a b(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ItemAddressBinding r5 = ItemAddressBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r3, false);
        Intrinsics.checkNotNullExpressionValue(r5, "inflate(...)");
        return new C0520a(this, r5);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void b(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        if (this.e != r2) goto L5;
        this.e = null;
    L5:
        super.b(r2);
    }

    public final void b(Function1<? super AddressInfo, Unit> r3) {
        Function1<? super AddressInfo, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.d = r4;
    }
}
