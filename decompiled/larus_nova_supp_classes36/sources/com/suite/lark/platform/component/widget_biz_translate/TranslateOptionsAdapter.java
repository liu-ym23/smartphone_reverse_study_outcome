package com.suite.lark.platform.component.widget_biz_translate;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001f !B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J!\u0010\u0016\u001a\u00020\f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u001aJ\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_translate/TranslateOptionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/suite/lark/platform/component/widget_biz_translate/TranslateOptionsAdapter$TranslateItemViewHolder;", "<init>", "()V", "translateItems", "", "Lcom/suite/lark/platform/component/widget_biz_translate/TranslateOptionsAdapter$TranslateItem;", "lastSelectedIndex", "", "itemSelectHandler", "Lkotlin/Function1;", "", "showLabel", "", "resetData", "newItems", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemSelectHandler", "action", "setOnItemSelectHandler$widget_biz_translate_release", "setShowLabel", "setShowLabel$widget_biz_translate_release", "onBindViewHolder", "holder", "position", "getItemCount", "TranslateItemViewHolder", "TranslateItem", "Companion", "widget-biz-translate_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class TranslateOptionsAdapter extends RecyclerView.Adapter<TranslateItemViewHolder> {
    public final List<b> a;
    public int b;
    public final Function1<? super b, Unit> c;
    public final boolean d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00148@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00148@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_translate/TranslateOptionsAdapter$TranslateItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvLabel", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTvLabel", "()Landroid/widget/TextView;", "checkedIcon", "tvTitle", "value", "", "isSelected", "isSelected$widget_biz_translate_release", "()Z", "setSelected$widget_biz_translate_release", "(Z)V", "", "title", "getTitle$widget_biz_translate_release", "()Ljava/lang/String;", "setTitle$widget_biz_translate_release", "(Ljava/lang/String;)V", "label", "getLabel$widget_biz_translate_release", "setLabel$widget_biz_translate_release", "widget-biz-translate_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class TranslateItemViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final View b;
        public final TextView c;

        public TranslateItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            TextView r3 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131377102);
            r3.setTypeface(Typeface.MONOSPACE);
            this.a = r3;
            this.b = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376097);
            this.c = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131388772);
        }
    }

    public static final class a {
    }

    public static final class b {
        public boolean a;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            r6.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L15;
            return false;
        L15:
            if (this.a == r6.a) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "TranslateItem(languageId=null, language=null, isSelected=" + this.a + ')';
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public TranslateOptionsAdapter() {
        this.a = new ArrayList();
        this.b = -1;
        this.c = TranslateOptionsAdapter$itemSelectHandler$1.INSTANCE;
        this.d = true;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        TranslateItemViewHolder r8 = (TranslateItemViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        b r0 = (b) ListProtector.get(this.a, r7);
        r0.getClass();
        String r2 = StringsKt.trim(null).toString();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r2, "value");
        r8.c.setText(r2);
        Intrinsics.checkNotNullParameter(null, "value");
        r8.a.setText(null);
        TextView r1 = r8.a;
        int r3 = 0;
        if (this.d == false) goto L5;
        int r4 = 0;
    L6:
        r1.setVisibility(r4);
        boolean r5 = r0.a;
        View r9 = r8.b;
        if (r5 == true) goto L10;
        r3 = 8;
    L10:
        r9.setVisibility(r3);
        Log.d("TranslateOptionsAdapter", "onBindViewHolder: current position is : " + r7 + ", item is selected is " + r0.a);
        if (r0.a == false) goto L13;
        Log.i("TranslateOptionsAdapter", "TranslateOptionsAdapter: current select item key is : null");
    L13:
        ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new com.suite.lark.platform.component.widget_biz_translate.a(this, r7, r0));
        return;
    L5:
        r4 = 8;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new TranslateItemViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131561707, r4, false));
    }
}
