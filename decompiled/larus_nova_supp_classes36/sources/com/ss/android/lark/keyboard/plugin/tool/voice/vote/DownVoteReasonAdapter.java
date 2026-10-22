package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001d\u001e\u001fB#\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\r\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0016R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteReasonAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteReasonAdapter$DownVoteReasonViewHolder;", "reasonSelectListener", "Lkotlin/Function1;", "", "", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/ReasonSelectListener;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "reasonList", "", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteReasonAdapter$DownVoteReason;", "updateReasonList", "", "getSelectedReasonList", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "setupReasonView", "textView", "Landroid/widget/TextView;", "isSelected", "", "getItemCount", "DownVoteReasonViewHolder", "DownVoteReason", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DownVoteReasonAdapter extends RecyclerView.Adapter<DownVoteReasonViewHolder> {
    public static final /* synthetic */ int c = 0;
    public final Function1<Integer, Unit> a;
    public final List<b> b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteReasonAdapter$DownVoteReasonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "getTextView", "()Landroidx/appcompat/widget/AppCompatTextView;", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class DownVoteReasonViewHolder extends RecyclerView.ViewHolder {
        public final AppCompatTextView a;

        public DownVoteReasonViewHolder(AppCompatTextView r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2;
        }
    }

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "DownVoteReason(id=" + this.a + ", text=" + this.b + ", isSelected=" + this.c + ')';
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "text");
            this.a = r2;
            this.b = r3;
            this.c = false;
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public DownVoteReasonAdapter() {
        this.a = null;
        this.b = new ArrayList();
    }

    public static void y2(AppCompatTextView r1, boolean r2) {
        Context r0 = r1.getContext();
        if (r2 == false) goto L5;
        Intrinsics.checkNotNull(r0);
        r1.setTextColor(UDColorUtils.getColor(r0, 2131105568));
        r1.setBackgroundResource(2131231963);
        return;
    L5:
        Intrinsics.checkNotNull(r0);
        r1.setTextColor(UDColorUtils.getColor(r0, 2131106622));
        r1.setBackgroundResource(2131231962);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        DownVoteReasonViewHolder r6 = (DownVoteReasonViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        b r0 = (b) ListProtector.get(this.b, r5);
        r6.a.setText(r0.b);
        y2(r6.a, r0.c);
        r6.a.setOnClickListener(new c(r0, this, r6, r5));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Context r6 = r4.getContext();
        AppCompatTextView r7 = new AppCompatTextView(r6);
        Intrinsics.checkNotNull(r6);
        r7.setTextSize(0, zz7.b.g(r6, 16));
        r7.setGravity(1);
        int r0 = UIUtils.dp2px(r6, 7.0f);
        r7.setPadding(0, r0, 0, r0);
        r7.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r7.setMinHeight(UIUtils.dp2px(r6, 36.0f));
        return new DownVoteReasonViewHolder(r7);
    }
}
