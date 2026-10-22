package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.memorydata.ui.recyclerview.OuiPagingDataAdapter;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005789:;Bj\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u00125\u0010\u000e\u001a1\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001aH\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aH\u0016J&\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001a2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\u0006\u0010*\u001a\u00020\rJ\u0006\u0010+\u001a\u00020\rJ\"\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u001a2\b\b\u0002\u00100\u001a\u00020\u001aJ\u0018\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001aH\u0016J\u0010\u00101\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0012\u00102\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u001aH\u0002J\"\u00103\u001a\u00020\r2\u0006\u00104\u001a\u0002052\u0006\u0010 \u001a\u00020\u001a2\b\b\u0002\u00106\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R=\u0010\u000e\u001a1\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006<"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalGroupListAdapter;", "Lcom/obric/memorydata/ui/recyclerview/OuiPagingDataAdapter;", "Lcom/obric/memorydata/memory/ui/list/PersonalListItem;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "selectionManager", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "refreshMarginsOnPositionPayload", "", "onItemClick", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/ui/list/PersonalListItem$Content;", "", "onItemLongClick", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/Function0;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "onDismiss", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "marginHandler", "Lkotlin/Function2;", "Landroid/view/ViewGroup$MarginLayoutParams;", "", "getMarginHandler", "()Lkotlin/jvm/functions/Function2;", "setMarginHandler", "(Lkotlin/jvm/functions/Function2;)V", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "notifyEditModeChanged", "notifyCardPositionsChanged", "notifyVisibleCardPositionsChanged", "rv", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "leadingAdapterItemCount", "buffer", "calculateCardPosition", "peekItem", "updateCardPositionAndDivider", "card", "Lcom/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem;", "cardPos", "Companion", "HeaderViewHolder", "PlaceholderViewHolder", "ContentViewHolder", "DiffCb", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonalGroupListAdapter extends OuiPagingDataAdapter<bc, RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11095a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f11096b;
    private final SelectionStateManager c;
    private final boolean d;
    private final Function1<bc.a, Unit> e;
    private final Function3<View, bc.a, Function0<Unit>, Boolean> f;
    private Function2<? super ViewGroup.MarginLayoutParams, ? super Integer, Unit> g;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalGroupListAdapter$DiffCb;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/memory/ui/list/PersonalListItem;", "<init>", "()V", "areItemsTheSame", "", "old", "new", "areContentsTheSame", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class DiffCb extends DiffUtil.ItemCallback<bc> {
        public DiffCb() {
        }

        /* JADX INFO: renamed from: areContentsTheSame, reason: avoid collision after fix types in other method */
        public boolean areContentsTheSame2(bc r7, bc r8) {
            Intrinsics.checkNotNullParameter(r7, "old");
            Intrinsics.checkNotNullParameter(r8, "new");
            if (ZeusTransformUtils.instanceOf(r7, bc.b.class) == false) goto L8;
            if (ZeusTransformUtils.instanceOf(r8, bc.b.class) == false) goto L8;
            return Intrinsics.areEqual(((bc.b) ZeusTransformUtils.preCheckCast(r7, bc.b.class, "com.obric.memorydata.plugin")).a(), ((bc.b) ZeusTransformUtils.preCheckCast(r8, bc.b.class, "com.obric.memorydata.plugin")).a());
        L8:
            if (ZeusTransformUtils.instanceOf(r7, bc.a.class) == true) goto L10;
            return false;
        L10:
            if (ZeusTransformUtils.instanceOf(r8, bc.a.class) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(((bc.a) ZeusTransformUtils.preCheckCast(r7, bc.a.class, "com.obric.memorydata.plugin")).b(), ((bc.a) ZeusTransformUtils.preCheckCast(r8, bc.a.class, "com.obric.memorydata.plugin")).b()) == true) goto L14;
            return false;
        L14:
            if (((bc.a) ZeusTransformUtils.preCheckCast(r7, bc.a.class, "com.obric.memorydata.plugin")).d() == ((bc.a) ZeusTransformUtils.preCheckCast(r8, bc.a.class, "com.obric.memorydata.plugin")).d()) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(((bc.a) ZeusTransformUtils.preCheckCast(r7, bc.a.class, "com.obric.memorydata.plugin")).g(), ((bc.a) ZeusTransformUtils.preCheckCast(r8, bc.a.class, "com.obric.memorydata.plugin")).g()) == true) goto L18;
            return false;
        L18:
            if (((bc.a) ZeusTransformUtils.preCheckCast(r7, bc.a.class, "com.obric.memorydata.plugin")).h() == ((bc.a) ZeusTransformUtils.preCheckCast(r8, bc.a.class, "com.obric.memorydata.plugin")).h()) goto L20;
            return false;
        L20:
            if (((bc.a) ZeusTransformUtils.preCheckCast(r7, bc.a.class, "com.obric.memorydata.plugin")).e() == ((bc.a) ZeusTransformUtils.preCheckCast(r8, bc.a.class, "com.obric.memorydata.plugin")).e()) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(((bc.a) ZeusTransformUtils.preCheckCast(r7, bc.a.class, "com.obric.memorydata.plugin")).f(), ((bc.a) ZeusTransformUtils.preCheckCast(r8, bc.a.class, "com.obric.memorydata.plugin")).f()) == false) goto L33;
            return true;
        L33:
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public /* synthetic */ boolean areContentsTheSame(bc r3, bc r4) {
            return areContentsTheSame2((bc) ZeusTransformUtils.preCheckCast(r3, bc.class, "com.obric.memorydata.plugin"), (bc) ZeusTransformUtils.preCheckCast(r4, bc.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: areItemsTheSame, reason: avoid collision after fix types in other method */
        public boolean areItemsTheSame2(bc r2, bc r3) {
            Intrinsics.checkNotNullParameter(r2, "old");
            Intrinsics.checkNotNullParameter(r3, "new");
            if (ZeusTransformUtils.instanceOf(r2, bc.b.class) == false) goto L9;
            if (ZeusTransformUtils.instanceOf(r3, bc.b.class) == false) goto L9;
            String r1 = ((bc.b) ZeusTransformUtils.preCheckCast(r2, bc.b.class, "com.obric.memorydata.plugin")).a();
            String r4 = ((bc.b) ZeusTransformUtils.preCheckCast(r3, bc.b.class, "com.obric.memorydata.plugin")).a();
        L15:
            return Intrinsics.areEqual(r1, r4);
        L9:
            if (ZeusTransformUtils.instanceOf(r2, bc.a.class) == true) goto L11;
        L13:
            return false;
        L11:
            if (ZeusTransformUtils.instanceOf(r3, bc.a.class) == false) goto L13;
            r1 = ((bc.a) ZeusTransformUtils.preCheckCast(r2, bc.a.class, "com.obric.memorydata.plugin")).a();
            r4 = ((bc.a) ZeusTransformUtils.preCheckCast(r3, bc.a.class, "com.obric.memorydata.plugin")).a();
            goto L15
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public /* synthetic */ boolean areItemsTheSame(bc r3, bc r4) {
            return areItemsTheSame2((bc) ZeusTransformUtils.preCheckCast(r3, bc.class, "com.obric.memorydata.plugin"), (bc) ZeusTransformUtils.preCheckCast(r4, bc.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalGroupListAdapter$Companion;", "", "<init>", "()V", "TAG", "", "TYPE_HEADER", "", "TYPE_CONTENT", "TYPE_PLACEHOLDER", "PAYLOAD_CARD_POSITION", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalGroupListAdapter$ContentViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "card", "Lcom/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/PersonalGroupListAdapter;Lcom/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem;)V", "getCard", "()Lcom/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem;", "keepPressedUntilMenuDismiss", "", "boundItemId", "", "boundItemSelectable", "bind", "", "item", "Lcom/obric/memorydata/memory/ui/list/PersonalListItem$Content;", "position", "", "releaseTouchLocks", "view", "Landroid/view/View;", "holdPressedUntilMenuDismiss", "Lkotlin/Function0;", "updateEditState", "bindEditState", "bindCheckBox", "updateSelectedPressedState", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class b extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PersonalGroupListAdapter f11097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DeviceAdaptiveCardListItem f11098b;
        private boolean t;
        private String u;
        private boolean v;

        @Metadata(d1 = {"\u0000O\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u0002022\b\b\u0002\u00104\u001a\u00020\u0012J\u0006\u00105\u001a\u000202J\u0018\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000eR\u0014\u0010'\u001a\u00020\fX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000eR\u0014\u0010)\u001a\u00020\"X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006;"}, d2 = {"com/obric/memorydata/memory/ui/list/PersonalGroupListAdapter$ContentViewHolder$bind$1$4", "Landroid/view/View$OnTouchListener;", "downX", "", "getDownX", "()F", "setDownX", "(F)V", "downY", "getDownY", "setDownY", "downTime", "", "getDownTime", "()J", "setDownTime", "(J)V", "touchLockAcquired", "", "getTouchLockAcquired", "()Z", "setTouchLockAcquired", "(Z)V", "longPressLockAcquired", "getLongPressLockAcquired", "setLongPressLockAcquired", "longClickTriggered", "getLongClickTriggered", "setLongClickTriggered", "clickPos", "", "getClickPos", "()[I", "slop", "", "getSlop", "()I", "longPressTimeout", "getLongPressTimeout", "clickTimeThreshold", "getClickTimeThreshold", "clickDistanceThreshold", "getClickDistanceThreshold", "longPressRunnable", "Ljava/lang/Runnable;", "getLongPressRunnable", "()Ljava/lang/Runnable;", "setLongPressRunnable", "(Ljava/lang/Runnable;)V", "showPressed", "", "clearPressed", "force", "cancelLongPress", "onTouch", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements View.OnTouchListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f11099a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ bc.a f11100b;
            final /* synthetic */ PersonalGroupListAdapter c;
            private float d;
            private float e;
            private long f;
            private boolean g;
            private boolean h;
            private boolean i;
            private final int[] j;
            private final int k;
            private final long l;
            private final long m;
            private final int n;
            private Runnable o;

            a(b r1, bc.a r2, PersonalGroupListAdapter r3) {
                this.f11099a = r1;
                this.f11100b = r2;
                this.c = r3;
                this.j = new int[2];
                this.k = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.a().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
                this.l = ViewConfiguration.getLongPressTimeout();
                this.m = 500;
                this.n = 20;
            }

            public static /* synthetic */ void a(a r0, boolean r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L5;
                r1 = false;
            L5:
                r0.a(r1);
            }

            private static final void a(bc.a r2, a r3, b r4, PersonalGroupListAdapter r5) {
                if (r2.h() == false) goto L6;
                return;
            L6:
                if (r3.h == false) goto L13;
                r3.i = true;
                com.obric.memorydata.memory.ui.l.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.a().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 2);
                if (((Boolean) ZeusTransformUtils.preCheckCast(PersonalGroupListAdapter.a(r5).b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L10;
                Function0 r6 = null;
            L11:
                PersonalGroupListAdapter.c(r5).invoke(r4.a(), r2, r6);
                return;
            L10:
                r6 = b.c(r4);
                goto L11
            }

            public static /* synthetic */ void lambda$AvgrX1yMGOKNsZ2yzj6chdeEpvA(bc.a r0, a r1, b r2, PersonalGroupListAdapter r3) {
                a(r0, r1, r2, r3);
            }

            public final void a() {
                k.f11315a.a((View) ZeusTransformUtils.preCheckCast(this.f11099a.a().getContentContainer(), View.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(PersonalGroupListAdapter$ContentViewHolder$bind$1$4$showPressed$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin"));
            }

            public final void a(boolean r4) {
                if (r4 == false) goto L4;
            L5:
                k.f11315a.a((View) ZeusTransformUtils.preCheckCast(this.f11099a.a().getContentContainer(), View.class, "com.obric.memorydata.plugin"));
                b.b(this.f11099a);
                return;
            L4:
                if (b.a(this.f11099a) == false) goto L5;
            }

            public final void b() {
                Runnable r0 = this.o;
                if (r0 == null) goto L5;
                this.f11099a.a().removeCallbacks(r0);
            L5:
                this.o = null;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View r9, MotionEvent r10) {
                Intrinsics.checkNotNullParameter(r9, "view");
                Intrinsics.checkNotNullParameter(r10, "event");
                int r0 = r10.getActionMasked();
                if (r0 != 0) goto L5;
                boolean r1 = com.obric.memorydata.memory.utils.w.f11568a.a(r9);
                this.g = r1;
                if (r1 == true) goto L50;
                return true;
            L50:
                this.h = com.obric.memorydata.memory.utils.w.f11568a.a(r9, true);
                this.i = false;
                this.f = SystemClock.elapsedRealtime();
                this.d = r10.getRawX();
                this.e = r10.getRawY();
                this.j[0] = (int) r10.getRawX();
                this.j[1] = (int) r10.getRawY();
                a();
                final bc.a r11 = this.f11100b;
                final b r12 = this.f11099a;
                final PersonalGroupListAdapter r2 = this.c;
                this.o = new $$Lambda$PersonalGroupListAdapter$b$a$AvgrX1yMGOKNsZ2yzj6chdeEpvA(r11, this, r12, r2);
                this.f11099a.a().postDelayed(this.o, this.l);
            L51:
                return true;
            L5:
                if (r0 == 1) goto L25;
                if (r0 == 2) goto L17;
                if (r0 != 3) goto L51;
                if (this.g == true) goto L14;
                return true;
            L14:
                b();
                a(true);
            L15:
                b.a(this.f11099a, r9);
                goto L51
            L17:
                if (this.g == true) goto L19;
                return true;
            L19:
                this.j[0] = (int) r10.getRawX();
                this.j[1] = (int) r10.getRawY();
                float r13 = r10.getRawX() - this.d;
                float r14 = r10.getRawY() - this.e;
                if (Math.abs(r13) <= this.k) goto L22;
            L23:
                b();
                a(this, false, 1, null);
                goto L51
            L22:
                if (Math.abs(r14) <= this.k) goto L51;
            L25:
                if (this.g == true) goto L27;
                return true;
            L27:
                b();
                if (this.i == false) goto L30;
            L36:
                boolean r15 = false;
            L37:
                if (r15 == true) goto L39;
            L46:
                a(this, false, 1, null);
                goto L15
            L39:
                if (this.f11100b.h() == true) goto L46;
                if (((Boolean) ZeusTransformUtils.preCheckCast(PersonalGroupListAdapter.a(this.c).b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L45;
                OCheckBoxLayout r16 = this.f11099a.a().getStartCheckBox();
                if (r16 == null) goto L46;
                r16.setChecked(!r16.isChecked());
                goto L46
            L45:
                PersonalGroupListAdapter.b(this.c).invoke(this.f11100b);
                goto L46
            L30:
                if ((SystemClock.elapsedRealtime() - this.f) >= this.m) goto L36;
                if (Math.abs(r10.getRawX() - this.d) >= this.n) goto L36;
                if (Math.abs(r10.getRawY() - this.e) >= this.n) goto L36;
                r15 = true;
                goto L37
            }
        }

        public b(PersonalGroupListAdapter r2, DeviceAdaptiveCardListItem r3) {
            Intrinsics.checkNotNullParameter(r3, "card");
            this.f11097a = r2;
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
            this.f11098b = r3;
            this.v = true;
            OCheckBoxLayout r1 = r3.getStartCheckBox();
            if (r1 == null) goto L6;
            r1.setClickable(false);
            r1.setFocusable(false);
            return;
        }

        private final void a(View r1) {
            com.obric.memorydata.memory.utils.w.f11568a.c(r1);
            com.obric.memorydata.memory.utils.w.f11568a.b(r1);
        }

        public static final /* synthetic */ void a(b r0, View r1) {
            r0.a(r1);
        }

        private static final void a(PersonalGroupListAdapter r7, bc.a r8, b r9, OCheckBox r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "<unused var>");
            PersonalGroupListAdapter.a(r7).a(new cu(r8.a(), NetError.ERR_CACHE_READ_FAILURE, "", null, 8, null), r8.b());
            r9.c();
        }

        public static final /* synthetic */ boolean a(b r0) {
            return r0.t;
        }

        private final Function0<Unit> b() {
            this.t = true;
            k.f11315a.a((View) ZeusTransformUtils.preCheckCast(this.f11098b.getContentContainer(), View.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(PersonalGroupListAdapter$ContentViewHolder$holdPressedUntilMenuDismiss$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin"));
            return new $$Lambda$PersonalGroupListAdapter$b$0L07LKKZD6RV7s9W_m3fkn7uM(this);
        }

        private static final void b(View r0) {
        }

        public static final /* synthetic */ void b(b r0) {
            r0.c();
        }

        private final void b(bc.a r1) {
            c(r1);
            c();
        }

        public static final /* synthetic */ Function0 c(b r0) {
            return r0.b();
        }

        private final void c() {
            boolean r1 = true;
            if (this.v == true) goto L5;
        L14:
            r1 = false;
        L15:
            this.f11098b.setContentChecked(r1);
            if (r1 == true) goto L19;
            this.f11098b.a();
            return;
        L19:
            return;
        L5:
            if (((Boolean) ZeusTransformUtils.preCheckCast(PersonalGroupListAdapter.a(this.f11097a).b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L14;
            String r0 = this.u;
            if (r0 != null) goto L9;
        L11:
            boolean r2 = false;
        L12:
            if (r2 == false) goto L14;
        L9:
            if (PersonalGroupListAdapter.a(this.f11097a).a(r0, "PersonalGroupListAdapter") != true) goto L11;
            r2 = true;
            goto L12
        }

        private final void c(final bc.a r9) {
            boolean r1 = true;
            if (((Boolean) ZeusTransformUtils.preCheckCast(PersonalGroupListAdapter.a(this.f11097a).b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            this.f11098b.a(r0);
            OCheckBoxLayout r3 = this.f11098b.getStartCheckBox();
            if (r3 == null) goto L20;
            final PersonalGroupListAdapter r4 = this.f11097a;
            r3.setOnCheckedChangeListener(null);
            r3.setClickable(false);
            r3.setFocusable(false);
            if (r0 == true) goto L13;
        L15:
            r1 = false;
        L16:
            r3.setChecked(r1);
            if (r0 == false) goto L21;
            r3.setOnCheckedChangeListener(new $$Lambda$PersonalGroupListAdapter$b$iYvOlVySQVG83URQ3T6j1gny9g(r4, r9, this));
            return;
        L21:
            return;
        L13:
            if (PersonalGroupListAdapter.a(r4).a(r9.a(), "PersonalGroupListAdapter") == false) goto L15;
        L20:
            return;
        L5:
            if (r9.h() == true) goto L7;
            r0 = true;
            goto L8
        }

        private static final Unit d(b r4) {
            r4.t = false;
            k.f11315a.a((View) ZeusTransformUtils.preCheckCast(r4.f11098b.getContentContainer(), View.class, "com.obric.memorydata.plugin"));
            r4.c();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: lambda$0L07L-KKZD6RV7s9W_-m3fkn7uM, reason: not valid java name */
        public static /* synthetic */ Unit m911lambda$0L07LKKZD6RV7s9W_m3fkn7uM(b r0) {
            return d(r0);
        }

        public static /* synthetic */ void lambda$_KNxnquSrWpK9wctsTst3Q_0zdw(View r0) {
            b(r0);
        }

        /* JADX INFO: renamed from: lambda$iYvOlVySQVG83URQ3T-6j1gny9g, reason: not valid java name */
        public static /* synthetic */ void m912lambda$iYvOlVySQVG83URQ3T6j1gny9g(PersonalGroupListAdapter r0, bc.a r1, b r2, OCheckBox r3, boolean r4) {
            a(r0, r1, r2, r3, r4);
        }

        public final DeviceAdaptiveCardListItem a() {
            return this.f11098b;
        }

        public final void a(bc.a r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.u = r2.a();
            this.v = !r2.h();
            b(r2);
        }

        public final void a(bc.a r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "item");
            this.u = r10.a();
            this.v = !r10.h();
            int r0 = PersonalGroupListAdapter.a(this.f11097a, r11);
            DeviceAdaptiveCardListItem r2 = this.f11098b;
            PersonalGroupListAdapter r3 = this.f11097a;
            r2.setContentChecked(false);
            r2.a();
            r2.setClickable(false);
            r2.setLongClickable(false);
            r2.setDescendantFocusability(393216);
            ImageView r5 = r2.getTailIconView();
            if (r5 == null) goto L5;
            r5.setClickable(false);
        L5:
            ImageView r6 = r2.getTailIconView();
            if (r6 == null) goto L8;
            r6.setFocusable(false);
        L8:
            float r7 = 32;
            r2.b(MathKt.roundToInt(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())));
            r2.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r10.b(), CharSequence.class, "com.obric.memorydata.plugin"));
            r2.c(true);
            String r8 = r10.g();
            if (r8 != null) goto L11;
        L13:
            r8 = null;
        L14:
            if (r8 != null) goto L16;
            String r9 = "";
        L17:
            r2.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
            if (r8 == null) goto L20;
            boolean r12 = true;
        L21:
            r2.d(r12);
            r2.f(true ^ r10.h());
            PersonalGroupListAdapter.a(r3, r2, r11, r0);
            OTextView r13 = r2.getTitleView();
            r13.setSingleLine(false);
            r13.setMaxLines(2);
            r13.setEllipsize(TextUtils.TruncateAt.END);
            monitor-enter(r10);
            b(r10);     // Catch: Throwable -> L27
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L27
            monitor-exit(r10);
            r2.setOnContentClickListener($$Lambda$PersonalGroupListAdapter$b$_KNxnquSrWpK9wctsTst3Q_0zdw.INSTANCE);
            r2.getContentContainer().setOnTouchListener((View.OnTouchListener) ZeusTransformUtils.preCheckCast(new a(this, r10, r3), View.OnTouchListener.class, "com.obric.memorydata.plugin"));
            return;
        L27:
            th = move-exception;
            throw th;
        L20:
            r12 = false;
            goto L21
        L16:
            r9 = r8;
            goto L17
        L11:
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L13;
            goto L13
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalGroupListAdapter$HeaderViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", com.tom_roush.pdfbox.pdmodel.a.d.f.e, "Landroid/widget/TextView;", "<init>", "(Landroid/widget/TextView;)V", "getTv", "()Landroid/widget/TextView;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f11101a;

        public c(TextView r3) {
            Intrinsics.checkNotNullParameter(r3, com.tom_roush.pdfbox.pdmodel.a.d.f.e);
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
            this.f11101a = r3;
        }

        public final TextView a() {
            return this.f11101a;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalGroupListAdapter$PlaceholderViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends RecyclerView.v {
        public d(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    static {
        f11095a = new a(null);
    }

    public PersonalGroupListAdapter(Context r9, SelectionStateManager r10, boolean r11, Function1<? super bc.a, Unit> r12, Function3<? super View, ? super bc.a, ? super Function0<Unit>, Boolean> r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Function1<bc.a, Unit> r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        Function3<View, bc.a, Function0<Unit>, Boolean> r16 = (Function3) ZeusTransformUtils.wrapperContextForParams(r13, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r10, "selectionManager");
        Intrinsics.checkNotNullParameter(r15, "onItemClick");
        Intrinsics.checkNotNullParameter(r16, "onItemLongClick");
        super((DiffUtil.ItemCallback) ZeusTransformUtils.preCheckCast(new DiffCb(), DiffUtil.ItemCallback.class, "com.obric.memorydata.plugin"), null, null, 6, null);
        this.f11096b = ZeusTransformUtils.wrapperContext(r14, "com.obric.memorydata.plugin");
        this.c = r10;
        this.d = r11;
        this.e = r15;
        this.f = r16;
    }

    public static final /* synthetic */ int a(PersonalGroupListAdapter r0, int r1) {
        return r0.h(r1);
    }

    public static final /* synthetic */ SelectionStateManager a(PersonalGroupListAdapter r0) {
        return r0.c;
    }

    public static final /* synthetic */ void a(PersonalGroupListAdapter r0, DeviceAdaptiveCardListItem r1, int r2, int r3) {
        r0.a(r1, r2, r3);
    }

    static /* synthetic */ void a(PersonalGroupListAdapter r0, DeviceAdaptiveCardListItem r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = r0.h(r2);
    L5:
        r0.a(r1, r2, r3);
    }

    public static /* synthetic */ void a(PersonalGroupListAdapter r0, RecyclerView r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 5;
    L8:
        r0.a(r1, r2, r3);
    }

    private final void a(DeviceAdaptiveCardListItem r5, int r6, int r7) {
        bc r0 = i(r6 + 1);
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r0, bc.a.class) == true) goto L9;
        if (r0 == null) goto L6;
    L8:
        r3 = false;
        goto L9
    L6:
        if (r6 >= (d() - 1)) goto L8;
    L9:
        r5.g(r3);
        OCardListItem.a((OCardListItem) ZeusTransformUtils.preCheckCast(r5, OCardListItem.class, "com.obric.memorydata.plugin"), r7, false, 2, null);
    }

    public static final /* synthetic */ Function1 b(PersonalGroupListAdapter r0) {
        return r0.e;
    }

    public static final /* synthetic */ Function3 c(PersonalGroupListAdapter r0) {
        return r0.f;
    }

    private final int h(int r6) {
        bc r0 = i(r6 - 1);
        bc r1 = i(r6 + 1);
        if (r6 > 0) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r6 < (d() - 1)) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r2 == false) goto L19;
        if (r5 == false) goto L19;
        return 0;
    L19:
        if (r2 == true) goto L25;
        if (r5 == false) goto L23;
        return 3;
    L23:
        return 2;
    L25:
        return 1;
    L12:
        if (ZeusTransformUtils.instanceOf(r1, bc.b.class) == true) goto L15;
        r5 = false;
        goto L16
    L5:
        if (ZeusTransformUtils.instanceOf(r0, bc.b.class) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final bc i(int r4) {
        boolean r1 = false;
        if (r4 >= 0) goto L5;
    L7:
        Object r2 = null;
        if (r1 == true) goto L20;
        return null;
    L20:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        Object r5 = Result.m1421constructorimpl((bc) ZeusTransformUtils.preCheckCast(((PersonalGroupListAdapter) ZeusTransformUtils.preCheckCast(this, PersonalGroupListAdapter.class, "com.obric.memorydata.plugin")).d(r4), bc.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
    L15:
        if (Result.m1427isFailureimpl(r5) == true) goto L19;
        r2 = r5;
    L19:
        return (bc) ZeusTransformUtils.preCheckCast(r2, bc.class, "com.obric.memorydata.plugin");
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (r4 >= d()) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r2) {
        bc r1 = (bc) ZeusTransformUtils.preCheckCast(d(r2), bc.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, bc.b.class) == false) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, bc.a.class) == false) goto L8;
        return 1;
    L8:
        if (r1 != null) goto L12;
        return 2;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.v a(ViewGroup r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "parent");
        if (r14 != 0) goto L5;
        TextView r12 = new TextView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r12.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new RecyclerView.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r12.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
        r12.setTypeface(Typeface.create(Typeface.DEFAULT, 500, false));
        r12.setTextSize(12.0f);
        float r15 = 8;
        r12.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r15, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r15, Resources.getSystem().getDisplayMetrics())));
        Object r16 = new c(r12);
    L10:
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(r16, RecyclerView.v.class, "com.obric.memorydata.plugin");
    L5:
        if (r14 == 2) goto L7;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "getContext(...)");
        DeviceAdaptiveCardListItem r17 = new DeviceAdaptiveCardListItem(r7, null, 0, 6, null);
        r17.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new RecyclerView.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r17.setCardType(0);
        OCardListItem.a((OCardListItem) ZeusTransformUtils.preCheckCast(r17, OCardListItem.class, "com.obric.memorydata.plugin"), 0, false, 2, null);
        r17.b(false);
        r17.d(false);
        r17.e(false);
        r17.f(true);
        r17.setDefaultCustomStartView(0);
        r17.a(false);
        r16 = new b(this, r17);
        goto L10
    L7:
        View r18 = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r18.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new RecyclerView.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 72, Resources.getSystem().getDisplayMetrics()))), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r16 = new d(r18);
        goto L10
    }

    public final void a() {
        a(0, d(), "edit_mode");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        ViewGroup.LayoutParams r0 = r6.c.getLayoutParams();
        bc.a r2 = null;
        bc.b r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L11;
        Function2<? super ViewGroup.MarginLayoutParams, ? super Integer, Unit> r4 = this.g;
        if (r4 == null) goto L11;
        r4.invoke(r1, Integer.valueOf(r7));
    L11:
        if (ZeusTransformUtils.instanceOf(r6, c.class) == false) goto L19;
        bc r5 = b(r7);
        if (ZeusTransformUtils.instanceOf(r5, bc.b.class) == false) goto L15;
        r3 = (bc.b) ZeusTransformUtils.preCheckCast(r5, bc.b.class, "com.obric.memorydata.plugin");
    L15:
        if (r3 != null) goto L17;
        return;
    L17:
        ((c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.memorydata.plugin")).a().setText((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L26;
        bc r8 = b(r7);
        if (ZeusTransformUtils.instanceOf(r8, bc.a.class) == false) goto L23;
        r2 = (bc.a) ZeusTransformUtils.preCheckCast(r8, bc.a.class, "com.obric.memorydata.plugin");
    L23:
        if (r2 != null) goto L25;
        return;
    L25:
        ((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin")).a(r2, r7);
        return;
    L26:
        ZeusTransformUtils.instanceOf(r6, d.class);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r11, int r12, List<Object> r13) {
        List<Object> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(r14, "payloads");
        if (r14.isEmpty() == false) goto L7;
        super.a(r11, r12, r14);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r11, b.class) == false) goto L33;
        bc r0 = i(r12);
        if (ZeusTransformUtils.instanceOf(r0, bc.a.class) == false) goto L11;
        bc.a r1 = (bc.a) ZeusTransformUtils.preCheckCast(r0, bc.a.class, "com.obric.memorydata.plugin");
    L12:
        if (r1 != null) goto L14;
        return;
    L14:
        Iterator<Object> r15 = r14.iterator();
    L16:
        if (r15.hasNext() == false) goto L45;
        Object r2 = r15.next();
        if (Intrinsics.areEqual(r2, "payload_card_position") == true) goto L19;
        if (Intrinsics.areEqual(r2, "edit_mode") == false) goto L16;
        ((b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.memorydata.plugin")).a(r1);
        goto L16
    L19:
        a(this, ((b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.memorydata.plugin")).a(), r12, 0, 4, null);
        if (this.d == false) goto L16;
        ViewGroup.LayoutParams r3 = r11.c.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L24;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L25:
        if (r4 == null) goto L29;
        Function2<? super ViewGroup.MarginLayoutParams, ? super Integer, Unit> r5 = this.g;
        if (r5 == null) goto L29;
        r5.invoke(r4, Integer.valueOf(r12));
    L29:
        r11.c.requestLayout();
        goto L16
    L24:
        r4 = null;
        goto L25
    L45:
        return;
    L11:
        r1 = null;
        goto L12
    L33:
        super.a(r11, r12, r14);
    }

    public final void a(RecyclerView r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "rv");
        RecyclerView.h r8 = r5.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r8, LinearLayoutManager.class) == false) goto L5;
        LinearLayoutManager r9 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r8, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L7:
        if (r9 != null) goto L10;
        PersonalGroupListAdapter r4 = (PersonalGroupListAdapter) ZeusTransformUtils.preCheckCast(this, PersonalGroupListAdapter.class, "com.obric.memorydata.plugin");
        r4.a(0, r4.d(), "payload_card_position");
        return;
    L10:
        int r1 = r9.o();
        int r10 = r9.p();
        if (r1 == (-1)) goto L19;
        if (r10 == (-1)) goto L20;
        int r11 = r10 - r6;
        int r12 = RangesKt.coerceAtLeast((r1 - r6) - r7, 0);
        int r13 = RangesKt.coerceAtMost(r11 + r7, d() - 1);
        if (r13 >= r12) goto L17;
        return;
    L17:
        a(r12, (r13 - r12) + 1, "payload_card_position");
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r9 = null;
        goto L7
    }

    public final void a(Function2<? super ViewGroup.MarginLayoutParams, ? super Integer, Unit> r3) {
        this.g = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
    }
}
