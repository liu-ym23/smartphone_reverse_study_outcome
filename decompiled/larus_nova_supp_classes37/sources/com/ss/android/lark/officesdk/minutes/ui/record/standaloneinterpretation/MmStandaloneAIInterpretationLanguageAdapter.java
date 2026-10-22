package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001#B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ2\u0010\u0017\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eH\u0016J\u001c\u0010\u001f\u001a\u00020\b2\n\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationLanguageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationLanguageAdapter$ViewHolder;", "context", "Landroid/content/Context;", "onLanguageClick", "Lkotlin/Function1;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationLanguage;", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "colorProvider", "Lcom/ss/android/lark/officesdk/minutes/ui/style/contract/IMmUIColorProvider;", "primaryTextColor", "", "checkIconColor", "data", "", "selectedLanguage", "disabledReasons", "", "", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationLanguageDisabledReason;", "submitList", "languages", "selected", "reasons", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "ViewHolder", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmStandaloneAIInterpretationLanguageAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Context a;
    public final Function1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c, Unit> b;
    public final int c;
    public final int d;
    public List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> e;
    public com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c f;
    public Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason> g;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationLanguageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationLanguageAdapter;Landroid/view/View;)V", "tvLanguage", "Landroid/widget/TextView;", "ivChecked", "Landroid/widget/ImageView;", "dividerLine", "bind", "", "item", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationLanguage;", "position", "", "totalSize", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ImageView b;
        public final View c;
        public final /* synthetic */ MmStandaloneAIInterpretationLanguageAdapter d;

        public ViewHolder(MmStandaloneAIInterpretationLanguageAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.d = r2;
            super(r3);
            this.a = (TextView) r3.findViewById(2131390042);
            this.b = (ImageView) r3.findViewById(2131375903);
            this.c = r3.findViewById(2131369203);
        }
    }

    public final int getItemCount() {
        return this.e.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmStandaloneAIInterpretationLanguageAdapter(Context r2, Function1<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onLanguageClick");
        this.a = r2;
        this.b = r3;
        com.ss.android.lark.officesdk.minutes.ui.style.contract.d r4 = com.ss.android.lark.officesdk.minutes.ui.style.a.a(r2);
        this.c = UDColorUtils.getColor(r2, r4.o());
        this.d = UDColorUtils.getColor(r2, r4.f());
        this.e = CollectionsKt.emptyList();
        this.g = MapsKt.emptyMap();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        ViewHolder r11 = (ViewHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r0 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) ListProtector.get(this.e, r10);
        int r1 = this.e.size();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        String r2 = r0.a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r3 = r11.d.f;
        String r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.a;
    L6:
        final boolean r6 = Intrinsics.areEqual(r2, r5);
        boolean r7 = r11.d.g.containsKey(r0.a);
        TextView r8 = r11.a;
        String r12 = r0.b;
        if ((!StringsKt.isBlank(r12)) == false) goto L9;
        r4 = r12;
    L9:
        if (r4 != null) goto L12;
        r4 = r0.a;
    L12:
        r8.setText(r4);
        TextView r13 = r11.a;
        int r14 = h18.e.a;
        r13.setTypeface(h18.e.a(r11.d.a));
        TextView r15 = r11.a;
        if (r7 == false) goto L15;
        int r16 = UDColorUtils.getColor(r11.d.a, 2131106610);
    L16:
        r15.setTextColor(r16);
        r11.b.setImageTintList(ColorStateList.valueOf(r11.d.d));
        ImageView r17 = r11.b;
        int r18 = 8;
        if (r6 == false) goto L19;
        int r19 = 0;
    L20:
        r17.setVisibility(r19);
        View r20 = r11.c;
        if (r10 == (r1 - 1)) goto L24;
        r18 = 0;
    L24:
        r20.setVisibility(r18);
        View r110 = ((RecyclerView.ViewHolder) r11).itemView;
        final MmStandaloneAIInterpretationLanguageAdapter r21 = r11.d;
        h.a(r110, new MmStandaloneAIInterpretationLanguageAdapter$ViewHolder$bind$2(r6, r21, r0));
        return;
    L19:
        r19 = 8;
        goto L20
    L15:
        r16 = r11.d.c;
        goto L16
    L5:
        r5 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131564081, r3, false);
        if (com.ss.android.lark.officesdk.minutes.ui.style.c.a(this.a) != MmRecordingUILaunchMode.WITH_DOUBAO_UI) goto L5;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        r6.height = UIUtils.dp2px(this.a, 56.0f);
    L5:
        Intrinsics.checkNotNull(r5);
        return new ViewHolder(this, r5);
    }
}
