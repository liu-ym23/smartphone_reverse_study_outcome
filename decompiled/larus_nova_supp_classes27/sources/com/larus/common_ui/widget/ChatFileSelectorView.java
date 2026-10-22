package com.larus.common_ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusViewChatFileSelectorBinding;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.platform.api.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import z19.c;
import z19.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/common_ui/widget/ChatFileSelectorView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusViewChatFileSelectorBinding;", "selectedList", "", "Lcom/larus/platform/api/FlowSelectedFileItem;", "setSelectedList", "", "setOnSelectedTextClickListener", "listener", "Landroid/view/View$OnClickListener;", "initConfig", "config", "Lcom/larus/common_ui/widget/ChatFileSelectorView$SelectorConfig;", "SelectorConfig", "ISelectorCallback", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatFileSelectorView extends FrameLayout {
    public static final /* synthetic */ int c = 0;
    public final LarusViewChatFileSelectorBinding a;
    public List<u> b;

    public interface a {
        void a();

        void b(String r1);
    }

    public static final class b {
        public final String a;
        public final List<u> b;
        public final a c;

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
            a r4 = this.c;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "SelectorConfig(tag=" + this.a + ", selectedList=" + this.b + ", selectorCallback=" + this.c + ')';
        }

        public b() {
            this(null, CollectionsKt.emptyList(), null);
        }

        public b(String r2, List<u> r3, a r4) {
            Intrinsics.checkNotNullParameter(r3, "selectedList");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public ChatFileSelectorView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChatFileSelectorView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a(final b r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        setSelectedList(r3.b);
        setOnSelectedTextClickListener(new c(r3));
        this.a.c.setOnClickListener(new d(r3));
    }

    public final void setOnSelectedTextClickListener(View.OnClickListener r2) {
        this.a.e.setOnClickListener(r2);
    }

    public final void setSelectedList(List<u> r10) {
        Intrinsics.checkNotNullParameter(r10, "selectedList");
        this.b = r10;
        int r11 = r10.size();
        if (r11 > 0) goto L6;
        setVisibility(8);
        return;
    L6:
        setVisibility(0);
        this.a.b.setText(getContext().getResources().getQuantityString(2131755151, r11, new Object[]{String.valueOf(r11)}));
        AppCompatTextView r0 = this.a.d;
        Context r1 = getContext();
        int r2 = com.larus.common_ui.a.a;
        r0.setText(StringsKt.replace$default(r1.getString(2131900812), "%s", String.valueOf(r11), false, 4, null));
    }

    public ChatFileSelectorView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        View r10 = LayoutInflater.from(r7).inflate(2131563207, this, false);
        addView(r10);
        int r11 = 2131365590;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r10, 2131365590);
        if (r2 == null) goto L13;
        r11 = 2131365592;
        RoundFrameLayout r3 = (RoundFrameLayout) ViewBindings.findChildViewById(r10, 2131365592);
        if (r3 == null) goto L13;
        r11 = 2131365593;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r10, 2131365593);
        if (r4 == null) goto L13;
        r11 = 2131365596;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131365596);
        if (r5 == null) goto L13;
        this.a = new LarusViewChatFileSelectorBinding((LinearLayout) r10, r2, r3, r4, r5);
        this.b = CollectionsKt.emptyList();
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public /* synthetic */ ChatFileSelectorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
