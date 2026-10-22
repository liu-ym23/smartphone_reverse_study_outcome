package com.ss.android.lark.officesdk.minutes.ui.record.speaker;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerCandidateType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.d;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.e;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSubtitleSpeakerAvatarView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.f;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J \u0010\u001c\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u000b0\u000b0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/speaker/MmSpeakerMarkAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "uccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "meetingId", "", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "onSpeakerClick", "Lkotlin/Function1;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmRecordingSpeakerCandidate;", "", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;Lkotlin/jvm/functions/Function1;)V", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemCount", "submitList", "items", "", "commitCallback", "Ljava/lang/Runnable;", "Companion", "AddSpeakerViewHolder", "CandidateViewHolder", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSpeakerMarkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final /* synthetic */ int f = 0;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final String b;
    public final MmRecordingUILaunchMode c;
    public final Function1<e, Unit> d;
    public final AsyncListDiffer<e> e;

    public static final class a extends RecyclerView.ViewHolder {
        public final View a;
        public final TextView b;

        public a(kwb.a r2) {
            Intrinsics.checkNotNullParameter(r2, "contract");
            super(r2.a);
            this.a = r2.b;
            this.b = r2.c;
        }
    }

    public static final class b extends RecyclerView.ViewHolder {
        public final MmSubtitleSpeakerAvatarView a;
        public final TextView b;
        public final TextView c;

        public b(kwb.b r4, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r5, String r6) {
            Intrinsics.checkNotNullParameter(r4, "contract");
            Intrinsics.checkNotNullParameter(r5, "uccApi");
            Intrinsics.checkNotNullParameter(r6, "meetingId");
            super(r4.a);
            MmSubtitleSpeakerAvatarView r1 = r4.b;
            this.a = r1;
            this.b = r4.c;
            this.c = r4.d;
            MmUserInfoHelper r7 = r5.O();
            r1.getClass();
            Intrinsics.checkNotNullParameter(r7, "helper");
            Intrinsics.checkNotNullParameter(r6, "meetingId");
            r1.e = r7;
        }
    }

    public static final class c {
    }

    static {
    }

    public final int getItemCount() {
        return this.e.getCurrentList().size();
    }

    public final int getItemViewType(int r2) {
        if (((e) ListProtector.get(this.e.getCurrentList(), r2)).getType() != MmRecordingSpeakerCandidateType.ADD_NEW) goto L5;
        return 0;
    L5:
        return 1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "holder");
        final e r16 = (e) ListProtector.get(this.e.getCurrentList(), r15);
        boolean r3 = true;
        boolean r4 = false;
        if ((r14 instanceof a) == false) goto L13;
        a r0 = (a) r14;
        Intrinsics.checkNotNull(r16);
        final Function1<e, Unit> r5 = this.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r16, "item");
        Intrinsics.checkNotNullParameter(r5, "onClick");
        r0.a.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(((RecyclerView.ViewHolder) r0).itemView.getContext()).p(((RecyclerView.ViewHolder) r0).itemView.getContext()));
        int r1 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.e.a;
        String r7 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.e.b(2131894015, "user", r16.c);
        TextView r2 = r0.b;
        SpannableString r6 = new SpannableString(r7);
        int r8 = StringsKt.indexOf$default(r7, r16.c, 0, false, 6, null);
        if (r8 >= 0) goto L7;
    L11:
        r2.setText(r6);
        h.a(((RecyclerView.ViewHolder) r0).itemView, new MmSpeakerMarkAdapter$AddSpeakerViewHolder$bind$2(r5, r16));
    L43:
        View r17 = r14.itemView;
        r17.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r17.getContext()).u(r14.itemView.getContext()));
        return;
    L7:
        if (r16.c.length() <= 0) goto L9;
        r4 = true;
    L9:
        if (r4 == false) goto L11;
        r6.setSpan(new StyleSpan(1), r8, r16.c.length() + r8, 33);
        goto L11
    L13:
        if ((r14 instanceof b) == false) goto L43;
        b r9 = (b) r14;
        Intrinsics.checkNotNull(r16);
        final Function1<e, Unit> r10 = this.d;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r16, "item");
        Intrinsics.checkNotNullParameter(r10, "onClick");
        r9.b.setText(r16.c);
        if ((!StringsKt.isBlank(r16.d)) == false) goto L17;
        r9.c.setVisibility(0);
        r9.c.setText(r16.d);
    L18:
        MmSubtitleSpeakerAvatarView r11 = r9.a;
        String r12 = null;
        if (r16.g.isLarkUser() == false) goto L33;
        d r13 = r16.f;
        if (r13 == null) goto L32;
        String r18 = r13.a;
        if (r18 == null) goto L32;
        if (r18.length() > 0) goto L28;
        r3 = false;
    L28:
        if (r3 == false) goto L30;
        r12 = r18;
    L30:
        if (r12 == null) goto L32;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b r19 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.C0046b(r12, r16.b);
    L42:
        r11.b(r19, UIHelper.dp2px(40.0f));
        h.a(((RecyclerView.ViewHolder) r9).itemView, new MmSpeakerMarkAdapter$CandidateViewHolder$bind$5(r10, r16));
    L32:
        r19 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.e(r16.b);
        goto L42
    L33:
        String r20 = r16.e;
        if (r20.length() > 0) goto L37;
        r3 = false;
    L37:
        if (r3 == false) goto L39;
        r12 = r20;
    L39:
        if (r12 == null) goto L41;
        r19 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.d(r12);
        goto L42
    L41:
        r19 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b.e(r16.b);
        goto L42
    L17:
        r9.c.setVisibility(8);
        goto L18
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        LayoutInflater r0 = LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r3.getContext(), this.c));
        if (r4 != 0) goto L5;
        com.ss.android.lark.officesdk.minutes.ui.style.e r5 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r1 = this.c;
        r5.getClass();
        f r6 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r1).getLayout();
        Intrinsics.checkNotNull(r0);
        return new a(r6.m(r0, r3));
    L5:
        com.ss.android.lark.officesdk.minutes.ui.style.e r7 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r2 = this.c;
        r7.getClass();
        f r8 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r2).getLayout();
        Intrinsics.checkNotNull(r0);
        return new b(r8.c(r0, r3), this.a, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmSpeakerMarkAdapter(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2, String r3, MmRecordingUILaunchMode r4, Function1<? super e, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "uccApi");
        Intrinsics.checkNotNullParameter(r3, "meetingId");
        Intrinsics.checkNotNullParameter(r4, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r5, "onSpeakerClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new AsyncListDiffer(this, new MmSpeakerMarkAdapter$differ$1());
    }
}
