package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.text.SpannableString;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016J\"\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitlePureContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmSubtitleItemPureViewContract;", "onSubtitleLongClick", "Lkotlin/Function3;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmSubtitleItem;", "", "Landroid/view/View;", "", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmSubtitleItemPureViewContract;Lkotlin/jvm/functions/Function3;)V", "highlightBackgroundColor", "selectedBackgroundColor", "highlightPadding", "highlightRadius", "", "currentItem", "bind", "", "item", "highlightStyle", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleHighlightStyle;", "bindPartial", "payloads", "", "bindHighlightStyle", "bindContent", "setSubtitleTextIfChanged", "textView", "Landroid/widget/TextView;", "text", "", "resolveHighlightColor", "setVisibilityIfChanged", "view", "visibility", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSubtitlePureContentViewHolder extends RecyclerView.ViewHolder {
    public final mwb.k a;
    public final Function3<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, Integer, View, Boolean> b;
    public final int c;
    public final int d;
    public final int e;
    public final float f;
    public com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h g;

    public static final class a implements View.OnLongClickListener {
        public final /* synthetic */ MmSubtitlePureContentViewHolder a;

        public a(MmSubtitlePureContentViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r5) {
            MmSubtitlePureContentViewHolder r6 = this.a;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r0 = r6.g;
            if (r0 != null) goto L5;
            return false;
        L5:
            Integer r7 = Integer.valueOf(r6.getBindingAdapterPosition());
            if (r7.intValue() == (-1)) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == true) goto L12;
            r7 = null;
        L12:
            if (r7 == null) goto L15;
            int r8 = r7.intValue();
            return ((Boolean) this.a.b.invoke(r0, Integer.valueOf(r8), this.a.a.a)).booleanValue();
        L15:
            return false;
        L8:
            r2 = false;
            goto L9
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmSubtitleHighlightStyle.values().length];
            r0[MmSubtitleHighlightStyle.SELECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmSubtitlePureContentViewHolder(mwb.k r2, Function3<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, ? super Integer, ? super View, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "onSubtitleLongClick");
        super(r2.a);
        this.a = r2;
        this.b = r3;
        this.c = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), com.ss.android.lark.officesdk.minutes.ui.style.a.a(((RecyclerView.ViewHolder) this).itemView.getContext()).j());
        this.d = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131108731);
        this.e = UIUtils.dp2px(((RecyclerView.ViewHolder) this).itemView.getContext(), 8.0f);
        this.f = UIUtils.dp2px(((RecyclerView.ViewHolder) this).itemView.getContext(), 8.0f);
        r2.a.setOnLongClickListener(new a(this));
    }

    public final void T3(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r3, MmSubtitleHighlightStyle r4) {
        if (r3.m == true) goto L5;
    L10:
        U3(this.a.b, r3.f, r4);
        TextView r5 = this.a.c;
        if (r5.getVisibility() == 8) goto L15;
        r5.setVisibility(8);
        return;
    L15:
        return;
    L5:
        if (r3.n == true) goto L10;
        U3(this.a.b, r3.e, r4);
        TextView r0 = this.a.c;
        if (r0.getVisibility() == 0) goto L9;
        r0.setVisibility(0);
    L9:
        U3(this.a.c, r3.f, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v3 */
    public final void U3(TextView r7, String r8, MmSubtitleHighlightStyle r9) {
        CharSequence r0 = r7.getText();
        String r2 = null;
        if ((r0 instanceof Spanned) == false) goto L5;
        Spanned r1 = (Spanned) r0;
    L7:
        if (r1 == null) goto L17;
        q[] r3 = (q[]) r1.getSpans(0, r7.getText().length(), q.class);
        if (r3 == null) goto L17;
        if (r3.length != 0) goto L13;
        boolean r4 = true;
    L15:
        if ((!r4) != true) goto L17;
        boolean r5 = true;
    L19:
        if (r9 != MmSubtitleHighlightStyle.NONE) goto L21;
    L26:
        boolean r6 = false;
    L27:
        if (r6 == true) goto L35;
        CharSequence r10 = r7.getText();
        if (r10 == null) goto L32;
        r2 = r10.toString();
    L32:
        if (Intrinsics.areEqual(r2, r8) == false) goto L35;
        if (r5 == true) goto L35;
        return;
    L35:
        if (r6 == false) goto L41;
        SpannableString r11 = new SpannableString(r8);
        if (b.a[r9.ordinal()] != 1) goto L39;
        int r12 = this.d;
    L40:
        int r13 = this.e;
        r11.setSpan(new q(r12, r13, r13, this.f), 0, r8.length(), 33);
        r8 = r11;
        goto L41
    L39:
        r12 = this.c;
    L41:
        r7.setText(r8);
        return;
    L21:
        if (r8.length() <= 0) goto L23;
        boolean r14 = true;
    L24:
        if (r14 == false) goto L26;
        r6 = true;
        goto L27
    L23:
        r14 = false;
        goto L24
    L13:
        r4 = false;
    L17:
        r5 = false;
        goto L19
    L5:
        r1 = null;
        goto L7
    }
}
