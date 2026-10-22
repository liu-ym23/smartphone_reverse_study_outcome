package com.larus.avlink.env.diary.detail;

import android.content.Context;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.avlink.env.diary.feedback.ui.DiaryFeedbackEntryView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.lynx.lottieadapter.LottieAdapterView;
import java.util.List;
import kc8.v0;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\b\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001eB-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/avlink/env/diary/detail/DiaryDetailItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "onFeedbackEntryAction", "Lkotlin/Function1;", "Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter$FeedbackEntryAction;", "", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "FeedbackEntryAction", "Companion", "DateHeaderViewHolder", "TitleViewHolder", "RecordStatusViewHolder", "FeedbackEntryViewHolder", "BlockContentViewHolder", "EmptyViewHolder", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DiaryDetailAdapter extends ListAdapter<g, RecyclerView.ViewHolder> {
    public static final DiaryDetailAdapter$Companion$DIFF$1 d = null;
    public final Context a;
    public final Fragment b;
    public final Function1<b, Unit> c;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter$BlockContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter;Landroid/view/View;)V", "isFirst", "", "lastIsHeading", "bind", "", "item", "Lcom/larus/avlink/env/diary/detail/DiaryDetailItem$BlockContent;", "generateBlockDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public final class BlockContentViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int d = 0;
        public boolean a;
        public boolean b;
        public final /* synthetic */ DiaryDetailAdapter c;

        public BlockContentViewHolder(DiaryDetailAdapter r2, hk9.a r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.c = r2;
            super(r3);
            this.a = true;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter$DateHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter;Landroid/view/View;)V", "diaryDay", "Landroid/widget/TextView;", "diaryYearMonth", "diaryWeekday", "diaryStatusIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "diaryStatusText", "bind", "", "item", "Lcom/larus/avlink/env/diary/detail/DiaryDetailItem$DateHeader;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public final class DateHeaderViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;
        public final TextView c;
        public final SimpleDraweeView d;
        public final TextView e;

        public DateHeaderViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131369035);
            this.b = (TextView) r2.findViewById(2131369083);
            this.c = (TextView) r2.findViewById(2131369082);
            this.d = r2.findViewById(2131369057);
            this.e = (TextView) r2.findViewById(2131369058);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter$EmptyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter;Landroid/view/View;)V", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public final class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter$FeedbackEntryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter;Landroid/view/View;)V", "feedbackEntryView", "Lcom/larus/avlink/env/diary/feedback/ui/DiaryFeedbackEntryView;", "bind", "", "item", "Lcom/larus/avlink/env/diary/detail/DiaryDetailItem$FeedbackEntry;", "handleFeedbackActionClick", "actionType", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public final class FeedbackEntryViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int c = 0;
        public final DiaryFeedbackEntryView a;
        public final /* synthetic */ DiaryDetailAdapter b;

        public FeedbackEntryViewHolder(DiaryDetailAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.b = r2;
            super(r3);
            this.a = (DiaryFeedbackEntryView) r3.findViewById(2131369545);
        }

        public final void T3(g.c r3, int r4) {
            if (this.a.getSelectedActionType() != r4) goto L6;
            this.b.c.invoke(b.a.a);
            return;
        L6:
            this.b.c.invoke(new b.C0006b(r4, r3.a));
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter$RecordStatusViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter;Landroid/view/View;)V", "recordingAnimation", "Lcom/lynx/lottieadapter/LottieAdapterView;", "titleTag", "Landroid/widget/TextView;", "nextUpdateTime", "bind", "", "item", "Lcom/larus/avlink/env/diary/detail/DiaryDetailItem$RecordStatus;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public final class RecordStatusViewHolder extends RecyclerView.ViewHolder {
        public final LottieAdapterView a;
        public final TextView b;
        public final TextView c;

        public RecordStatusViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131369046);
            this.b = (TextView) r2.findViewById(2131369078);
            this.c = (TextView) r2.findViewById(2131369043);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter;Landroid/view/View;)V", "diaryTitle", "Landroid/widget/TextView;", "bind", "", "item", "Lcom/larus/avlink/env/diary/detail/DiaryDetailItem$Title;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public final class TitleViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public TitleViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131369077);
        }
    }

    public static final class a {
    }

    public static abstract class b {

        public static final class a extends b {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.larus.avlink.env.diary.detail.DiaryDetailAdapter$b$b, reason: collision with other inner class name */
        public static final class C0006b extends b {
            public final int a;
            public final String b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0006b) == true) goto L8;
                return false;
            L8:
                C0006b r6 = (C0006b) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "OpenSheet(actionType=" + this.a + ", diaryId=" + this.b + ')';
            }

            public C0006b(int r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, "diaryId");
                this.a = r2;
                this.b = r3;
            }
        }

        public b() {
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.avlink.env.diary.detail.DiaryDetailAdapter$Companion$DIFF$1] */
    static {
        d = new DiaryDetailAdapter$Companion$DIFF$1();
    }

    public final int getItemViewType(int r2) {
        g r3 = (g) getItem(r2);
        if ((r3 instanceof g.b) == false) goto L6;
        return 0;
    L6:
        if ((r3 instanceof g.e) == false) goto L9;
        return 1;
    L9:
        if ((r3 instanceof g.d) == false) goto L12;
        return 2;
    L12:
        if ((r3 instanceof g.c) == false) goto L14;
        return 4;
    L14:
        return 3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r56, int r57) {
        Intrinsics.checkNotNullParameter(r56, "holder");
        g r2 = (g) getItem(r57);
        boolean r6 = true;
        if ((r2 instanceof g.b) == false) goto L24;
        DateHeaderViewHolder r0 = (DateHeaderViewHolder) r56;
        g.b r3 = (g.b) r2;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "item");
        r0.a.setText(r3.a);
        r0.b.setText(r3.b);
        r0.c.setText(r3.c);
        String r4 = r3.d;
        if (r4 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        r0.d.setVisibility(4);
    L14:
        String r7 = r3.e;
        if (r7 != null) goto L17;
    L20:
        if (r6 == false) goto L22;
        r0.e.setVisibility(8);
        return;
    L22:
        r0.e.setVisibility(0);
        r0.e.setText(r3.e);
        return;
    L17:
        if (r7.length() == 0) goto L20;
        r6 = false;
        goto L20
    L13:
        r0.d.setVisibility(0);
        ImageLoaderKt.u(r0.d, r3.d, "dora_diary_emotion");
        goto L14
    L7:
        if (r4.length() == 0) goto L10;
        r5 = false;
        goto L11
    L24:
        if ((r2 instanceof g.e) == false) goto L27;
        TitleViewHolder r1 = (TitleViewHolder) r56;
        g.e r8 = (g.e) r2;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "item");
        r1.a.setText(r8.a);
        return;
    L27:
        if ((r2 instanceof g.d) == false) goto L36;
        RecordStatusViewHolder r9 = (RecordStatusViewHolder) r56;
        g.d r10 = (g.d) r2;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "item");
        if (r10.a == false) goto L34;
        r9.a.setVisibility(0);
        r9.b.setVisibility(8);
        r9.a.setAnimation("lottie/dora_diary_recording.json");
        r9.a.playAnimation();
        if (r10.b == null) goto L33;
        r9.c.setVisibility(0);
        TextView r11 = r9.c;
        StringBuilder r12 = new StringBuilder();
        int r13 = com.larus.utils.j0.a;
        r12.append(com.larus.utils.j0.d(2131902477));
        r12.append(' ');
        r12.append(r10.b);
        r11.setText(r12.toString());
        return;
    L33:
        r9.c.setVisibility(8);
        return;
    L34:
        r9.a.setVisibility(8);
        r9.c.setVisibility(8);
        r9.b.setVisibility(0);
        return;
    L36:
        if ((r2 instanceof g.c) == false) goto L47;
        final FeedbackEntryViewHolder r14 = (FeedbackEntryViewHolder) r56;
        final g.c r15 = (g.c) r2;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "item");
        DiaryFeedbackEntryView r16 = r14.a;
        j98.c r17 = r15.b;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "model");
        r16.a.i.setText(r17.a);
        r16.a.h.setText(r17.b);
        r16.a.d.setText(r17.c);
        int r18 = r17.d;
        r16.b = r18;
        ImageView r19 = r16.a.f;
        if (r18 != 1) goto L40;
        boolean r20 = true;
    L41:
        r19.setSelected(r20);
        ImageView r21 = r16.a.b;
        if (r18 == 2) goto L45;
        r6 = false;
    L45:
        r21.setSelected(r6);
        r14.a.setOnLikeClick(new e(r14, r15));
        r14.a.setOnDislikeClick(new f(r14, r15));
        return;
    L40:
        r20 = false;
        goto L41
    L47:
        if ((r2 instanceof g.a) == false) goto L57;
        final BlockContentViewHolder r22 = (BlockContentViewHolder) r56;
        g.a r23 = (g.a) r2;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "item");
        FLogger.a.i("DiaryDetailAdapter", "bind item: " + r23.a.getClass());
        r22.a = true;
        r22.b = false;
        hk9.a r24 = ((RecyclerView.ViewHolder) r22).itemView;
        if ((r24 instanceof hk9.a) == false) goto L51;
        hk9.a r25 = r24;
    L52:
        if (r25 == null) goto L65;
        List r26 = CollectionsKt.listOf(r23.a);
        Message r27 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
        Boolean r110 = Boolean.TRUE;
        kc8.f r28 = new kc8.f(r27, r110, true, false, null, null, 504);
        int r29 = kc8.y.J;
        kc8.y.a r30 = new kc8.y.a();
        r30.p = new com.larus.avlink.env.diary.detail.b();
        r30.q = Boolean.FALSE;
        kc8.y r31 = r30.a();
        int r111 = v0.p;
        v0.a r112 = new v0.a();
        int r113 = m0.a;
        r112.b = Integer.valueOf(m0.b(((RecyclerView.ViewHolder) r22).itemView.getContext()) - i5.Z());
        r112.a = r110;
        r112.c = true;
        r112.d = true;
        r112.g = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        i5.m();
        i5.E();
        r112.m = h98.i.a(new c(r22));
        final DiaryDetailAdapter r32 = r22.c;
        r112.h = new d(r32);
        v0 r33 = r112.a();
        int r34 = kc8.b.y;
        kc8.b.a r35 = new kc8.b.a();
        r35.a = r33;
        r35.n = new kc8.t(false);
        r35.b = r31;
        r25.b(kc8.b.class, r35.a());
        ((RecyclerView.ViewHolder) r22).itemView.setPadding(i5.A(), 0, i5.A(), 0);
        ra8.a.d(r25, r26, r28, false);
        return;
    L65:
        return;
    L51:
        r25 = null;
        goto L52
    L57:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LayoutInflater r0 = LayoutInflater.from(r4.getContext());
        if (r5 != 0) goto L5;
        RecyclerView.ViewHolder r6 = new DateHeaderViewHolder(r0.inflate(2131562540, r4, false));
    L19:
        return r6;
    L5:
        if (r5 != 1) goto L7;
        r6 = new TitleViewHolder(r0.inflate(2131562543, r4, false));
        goto L19
    L7:
        if (r5 != 2) goto L9;
        r6 = new RecordStatusViewHolder(r0.inflate(2131562542, r4, false));
        goto L19
    L9:
        if (r5 != 3) goto L11;
        int r7 = ra8.a.a;
        return new BlockContentViewHolder(this, ra8.a.a(this.a));
    L11:
        if (r5 != 4) goto L20;
        r6 = new FeedbackEntryViewHolder(this, r0.inflate(2131562541, r4, false));
        goto L19
    L20:
        return new EmptyViewHolder(new View(this.a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DiaryDetailAdapter(Context r2, Fragment r3, Function1<? super b, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "onFeedbackEntryAction");
        super(d);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
