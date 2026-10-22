package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000¡\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0018\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001LBc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010*\u001a\u00020\u000f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010'J\u000e\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\"J\u0014\u00100\u001a\u00020\u000f2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\"0%J\u0010\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u0012H\u0016J\u0018\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0012H\u0016J\u0018\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0012H\u0016J&\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00122\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0016J\u0010\u0010=\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0012H\u0016J\b\u0010>\u001a\u00020\u0012H\u0016J\u0010\u0010?\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u0012H\u0002J\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0,J\u0018\u0010A\u001a\u00020\u000f2\u0006\u00109\u001a\u00020B2\u0006\u00103\u001a\u00020\u0012H\u0002J\u0017\u0010C\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u000eH\u0002J\u0018\u0010H\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u000eH\u0002J\u0018\u0010K\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u000e0\u000e0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "recordingSessionId", "", "uccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "meetingId", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onEditSpeakerClick", "Lkotlin/Function1;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmSubtitleItem;", "", "onSubtitleLongClick", "Lkotlin/Function3;", "", "Landroid/view/View;", "", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "diffCallback", "com/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleAdapter$diffCallback$1", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleAdapter$diffCallback$1;", "mDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "firstSubtitleItemTopMargin", "subtitleItemTopMargin", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "highlightedSegId", "", "Ljava/lang/Long;", "selectedSegIds", "", "clearHighlightRunnable", "Ljava/lang/Runnable;", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "submitList", "list", "", "commitCallback", "highlightSubtitle", "segId", "updateSelectedSegIds", "segIds", "getItemId", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "getItemViewType", "getItemCount", "getItem", "currentItems", "applyNormalItemTopMargin", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleNormalContentViewHolder;", "notifyHighlightChanged", "(Ljava/lang/Long;)V", "resolveHighlightStyle", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleHighlightStyle;", "item", "isSpeakerDisplayChanged", "oldItem", "newItem", "isSpeakerAvatarChanged", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSubtitleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final /* synthetic */ int o = 0;
    public final String a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;
    public final String c;
    public final MmRecordingUILaunchMode d;
    public final LifecycleOwner e;
    public final Function1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, Unit> f;
    public final Function3<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, Integer, View, Boolean> g;
    public final AsyncListDiffer<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h> h;
    public final int i;
    public final int j;
    public RecyclerView k;
    public Long l;
    public Set<Long> m;
    public f n;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.h.getCurrentList().size();
    }

    public final MmSubtitleHighlightStyle A2(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r5) {
        if (this.m.contains(Long.valueOf(r5.a)) == true) goto L13;
        long r0 = r5.a;
        Long r6 = this.l;
        if (r6 == null) goto L12;
        if (r0 != r6.longValue()) goto L12;
        return MmSubtitleHighlightStyle.JUMP;
    L12:
        return MmSubtitleHighlightStyle.NONE;
    L13:
        return MmSubtitleHighlightStyle.SELECTED;
    }

    public final void B2(Set<Long> r3) {
        Intrinsics.checkNotNullParameter(r3, "segIds");
        Set<Long> r0 = this.m;
        if (Intrinsics.areEqual(r0, r3) == false) goto L5;
        return;
    L5:
        this.m = r3;
        Iterator r4 = SetsKt.plus(r0, r3).iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        z2((Long) r4.next());
        goto L7
    }

    public final long getItemId(int r3) {
        return y2(r3).a;
    }

    public final int getItemViewType(int r1) {
        if (y2(r1).l == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        this.k = r2;
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        f r0 = this.n;
        if (r0 == null) goto L5;
        r2.removeCallbacks(r0);
    L5:
        this.n = null;
        this.k = null;
        super.onDetachedFromRecyclerView(r2);
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h y2(int r2) {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ListProtector.get(this.h.getCurrentList(), r2);
    }

    public final void z2(Long r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        Iterator r0 = this.h.getCurrentList().iterator();
        int r2 = 0;
    L6:
        if (r0.hasNext() == false) goto L14;
        if (((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) r0.next()).a != r9.longValue()) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L15;
        r2 = r2 + 1;
    L15:
        if (r2 < 0) goto L30;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r10 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ListProtector.get(this.h.getCurrentList(), r2);
        Intrinsics.checkNotNull(r10);
        MmSubtitleHighlightStyle r1 = A2(r10);
        RecyclerView r4 = this.k;
        if (r4 == null) goto L19;
        RecyclerView.ViewHolder r5 = r4.findViewHolderForAdapterPosition(r2);
    L21:
        if ((r5 instanceof MmSubtitleNormalContentViewHolder) == false) goto L24;
        MmSubtitleNormalContentViewHolder r6 = (MmSubtitleNormalContentViewHolder) r5;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r1, "highlightStyle");
        r6.w = r10;
        r6.V3(r10, r1);
        return;
    L24:
        if ((r5 instanceof MmSubtitlePureContentViewHolder) == false) goto L26;
        MmSubtitlePureContentViewHolder r7 = (MmSubtitlePureContentViewHolder) r5;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r1, "highlightStyle");
        r7.g = r10;
        r7.T3(r10, r1);
        return;
    L26:
        notifyItemChanged(r2, MmSubtitlePayload.HIGHLIGHT);
        return;
    L19:
        r5 = null;
        goto L21
    L30:
        return;
    L10:
        r3 = false;
        goto L11
    L14:
        r2 = -1;
        goto L15
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r0 = y2(r8);
        if ((r7 instanceof MmSubtitleNormalContentViewHolder) == false) goto L13;
        MmSubtitleNormalContentViewHolder r9 = (MmSubtitleNormalContentViewHolder) r7;
        if (r8 != 0) goto L7;
        int r10 = this.i;
    L8:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.b(((RecyclerView.ViewHolder) r9).itemView, null, Integer.valueOf(r10), 13);
        MmSubtitleHighlightStyle r11 = A2(r0);
        Intrinsics.checkNotNullParameter(r0, "item");
        Intrinsics.checkNotNullParameter(r11, "highlightStyle");
        r9.w = r0;
        r9.T3(r0);
        TextView r1 = r9.c.i;
        int r2 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.c.a;
        MmSubtitleNormalContentViewHolder.Z3(r1, com.ss.android.lark.officesdk.minutes.service.foundation.utils.c.a(r0.c));
        r9.W3(r0, true);
        r9.U3(r0);
        Drawable r3 = r9.c.h.getBackground();
        Drawable r4 = r9.r;
        if (r3 == r4) goto L11;
        r9.c.h.setBackground(r4);
    L11:
        r9.V3(r0, r11);
        r9.X3(r0);
        return;
    L7:
        r10 = this.j;
        goto L8
    L13:
        if ((r7 instanceof MmSubtitlePureContentViewHolder) == false) goto L17;
        MmSubtitlePureContentViewHolder r12 = (MmSubtitlePureContentViewHolder) r7;
        MmSubtitleHighlightStyle r13 = A2(r0);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        Intrinsics.checkNotNullParameter(r13, "highlightStyle");
        r12.g = r0;
        r12.T3(r0, r13);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        LayoutInflater r0 = LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r10.getContext(), this.d));
        if (r11 != 1) goto L5;
        com.ss.android.lark.officesdk.minutes.ui.style.e r12 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r1 = this.d;
        r12.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.f r13 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r1).getLayout();
        Intrinsics.checkNotNull(r0);
        mwb.j r4 = r13.p(r0, r10);
        uvb.b.b(r4.a);
        return new MmSubtitleNormalContentViewHolder(this.a, this.b, r4, this.c, this.e, this.f, this.g);
    L5:
        if (r11 == 2) goto L7;
        final FrameLayout r14 = new FrameLayout(r10.getContext());
        return new AnonymousClass1(r14);
    L7:
        com.ss.android.lark.officesdk.minutes.ui.style.e r15 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r2 = this.d;
        r15.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.f r16 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r2).getLayout();
        Intrinsics.checkNotNull(r0);
        mwb.k r17 = r16.f(r0, r10);
        uvb.b.b(r17.a);
        return new MmSubtitlePureContentViewHolder(r17, this.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.util.ArrayList] */
    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9, List<Object> r10) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r10, "payloads");
        if (r10.isEmpty() == false) goto L6;
        onBindViewHolder(r8, r9);
        return;
    L6:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r1 = y2(r9);
        ArrayList r2 = new ArrayList();
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L22;
        Object r3 = r11.next();
        if ((r3 instanceof Set) == false) goto L18;
        ?? r4 = new ArrayList();
        Iterator r5 = ((Iterable) r3).iterator();
    L13:
        if (r5.hasNext() == false) goto L21;
        Object r6 = r5.next();
        if ((r6 instanceof MmSubtitlePayload) == false) goto L13;
        r4.add(r6);
    L21:
        CollectionsKt.addAll(r2, (Iterable) r4);
        goto L8
    L18:
        if ((r3 instanceof MmSubtitlePayload) == false) goto L20;
        r4 = CollectionsKt.listOf(r3);
        goto L21
    L20:
        r4 = CollectionsKt.emptyList();
        goto L21
    L22:
        Set r12 = CollectionsKt.toSet(r2);
        if (r12.isEmpty() == false) goto L27;
        onBindViewHolder(r8, r9);
        return;
    L27:
        if ((r8 instanceof MmSubtitleNormalContentViewHolder) == false) goto L51;
        MmSubtitleNormalContentViewHolder r13 = (MmSubtitleNormalContentViewHolder) r8;
        if (r9 != 0) goto L31;
        int r14 = this.i;
    L32:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.b(((RecyclerView.ViewHolder) r13).itemView, null, Integer.valueOf(r14), 13);
        MmSubtitleHighlightStyle r15 = A2(r1);
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r12, "payloads");
        Intrinsics.checkNotNullParameter(r15, "highlightStyle");
        r13.w = r1;
        boolean r0 = r12.contains(MmSubtitlePayload.CONTENT);
        boolean r7 = r12.contains(MmSubtitlePayload.SPEAKER);
        boolean r16 = r12.contains(MmSubtitlePayload.AVATAR);
        boolean r17 = r12.contains(MmSubtitlePayload.EDIT_STATE);
        boolean r18 = r12.contains(MmSubtitlePayload.TIME);
        boolean r19 = r12.contains(MmSubtitlePayload.HIGHLIGHT);
        if (r0 == true) goto L35;
        if (r19 == true) goto L35;
    L36:
        if (r18 == false) goto L38;
        TextView r20 = r13.c.i;
        int r21 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.c.a;
        MmSubtitleNormalContentViewHolder.Z3(r20, com.ss.android.lark.officesdk.minutes.service.foundation.utils.c.a(r1.c));
    L38:
        if (r7 == false) goto L40;
        r13.W3(r1, true);
    L42:
        if (r17 == false) goto L44;
        r13.U3(r1);
    L44:
        if (r19 == true) goto L46;
        if (r17 == true) goto L46;
    L47:
        if (r7 == true) goto L49;
        if (r16 == true) goto L49;
        return;
    L49:
        r13.X3(r1);
        return;
    L46:
        r13.V3(r1, r15);
        goto L47
    L40:
        if (r16 == false) goto L42;
        r13.W3(r1, false);
    L35:
        r13.T3(r1);
        goto L36
    L31:
        r14 = this.j;
        goto L32
    L51:
        if ((r8 instanceof MmSubtitlePureContentViewHolder) == false) goto L57;
        MmSubtitlePureContentViewHolder r22 = (MmSubtitlePureContentViewHolder) r8;
        MmSubtitleHighlightStyle r23 = A2(r1);
        r22.getClass();
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r12, "payloads");
        Intrinsics.checkNotNullParameter(r23, "highlightStyle");
        r22.g = r1;
        if (r12.contains(MmSubtitlePayload.HIGHLIGHT) == false) goto L55;
    L56:
        r22.T3(r1, r23);
        return;
    L55:
        if (r12.contains(MmSubtitlePayload.CONTENT) == true) goto L56;
        return;
    L57:
        onBindViewHolder(r8, r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmSubtitleAdapter(String r2, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r3, String r4, MmRecordingUILaunchMode r5, LifecycleOwner r6, Function1<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, Unit> r7, Function3<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, ? super Integer, ? super View, Boolean> r8) {
        Intrinsics.checkNotNullParameter(r2, "recordingSessionId");
        Intrinsics.checkNotNullParameter(r3, "uccApi");
        Intrinsics.checkNotNullParameter(r4, "meetingId");
        Intrinsics.checkNotNullParameter(r5, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r7, "onEditSpeakerClick");
        Intrinsics.checkNotNullParameter(r8, "onSubtitleLongClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = new AsyncListDiffer(this, new MmSubtitleAdapter$diffCallback$1(this));
        this.i = UIHelper.dp2px(20.0f);
        this.j = UIHelper.dp2px(28.0f);
        this.m = SetsKt.emptySet();
        setHasStableIds(true);
    }
}
