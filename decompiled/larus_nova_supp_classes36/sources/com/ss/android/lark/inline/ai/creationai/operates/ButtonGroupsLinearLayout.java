package com.ss.android.lark.inline.ai.creationai.operates;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.inline.ai.creationai.n0;
import com.ss.android.lark.language.service.impl.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yob.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000bJ\f\u0010\u001d\u001a\u00020\u0007*\u00020\u0007H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/ButtonGroupsLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onOperateClickListener", "Lcom/ss/android/lark/inline/ai/creationai/operates/ButtonGroupsLinearLayout$OnOperateClickListener;", "menuItems", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "isFirstSetData", "", "setData", "", "data", "updateButtons", "createButton", "Lcom/ss/android/lark/inline/ai/creationai/operates/MenuButton;", "menuItem", "index", "buildReactionText", "", "setOnOperateClickListener", "listener", "dp", "Companion", "OnOperateClickListener", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ButtonGroupsLinearLayout extends LinearLayout {
    public b a;
    public List<MenuItem> b;
    public boolean c;

    public static final class a {
    }

    public interface b {
        void a(MenuItem r1);
    }

    static {
    }

    public ButtonGroupsLinearLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ButtonGroupsLinearLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int a(int r3) {
        Resources r0 = getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.widget.LinearLayout, com.ss.android.lark.inline.ai.creationai.operates.ButtonGroupsLinearLayout] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v19, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.View, android.widget.Button, com.ss.android.lark.inline.ai.creationai.operates.MenuButton] */
    public final void setData(List<MenuItem> r11) {
        if (r11 != null) goto L5;
        r11 = CollectionsKt.emptyList();
    L5:
        if (this.c == false) goto L7;
    L9:
        this.b = CollectionsKt.toList(r11);
        removeAllViews();
        if (this.b.isEmpty() == true) goto L45;
        Iterator r12 = this.b.iterator();
        int r1 = 0;
    L14:
        if (r12.hasNext() == false) goto L45;
        Object r2 = r12.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        MenuItem r4 = (MenuItem) r2;
        Drawable r7 = null;
        ?? r5 = new MenuButton(getContext(), null, 6, 0);
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(0, -2, 1.0f / this.b.size());
        if (r1 >= (this.b.size() - 1)) goto L21;
        r6.setMarginEnd(a(8));
    L21:
        r6.gravity = 17;
        r5.setLayoutParams(r6);
        r5.setPadding(a(16), a(7), a(16), a(7));
        r5.setTextSize(16.0f);
        r5.setType(r4.getType());
        if (Intrinsics.areEqual(r4.getType(), INotificationHitPoint.NoticeType.REACTION) == false) goto L43;
        Context r8 = getContext();
        if (r8 == null) goto L36;
        e.a().getClass();
        Locale r9 = c.a.a.a();
        String r10 = r4.getIcon();
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "locale");
        Intrinsics.checkNotNullParameter(r10, "reactionKey");
        if (Intrinsics.areEqual(r9.getLanguage(), "zh") == false) goto L28;
        Drawable r13 = UIUtils.getDrawable(r8, 2131234975);
    L30:
        if (Intrinsics.areEqual(r9.getLanguage(), "zh") == false) goto L33;
        if (r13 == null) goto L35;
        r13.setBounds(new Rect(0, 0, n0.a(86), n0.a(25)));
    L35:
        r7 = r13;
        goto L36
    L33:
        if (r13 == null) goto L35;
        r13.setBounds(new Rect(0, 0, n0.a(113), n0.a(25)));
        goto L35
    L28:
        r13 = UIUtils.getDrawable(r8, 2131234976);
    L36:
        if (r7 != null) goto L39;
        Log.e("ButtonGroupsLinearLayout", "set ai apply drawable failed");
        ?? r14 = r4.getIcon();
    L44:
        r5.setText(r14);
        r5.setMaxLines(1);
        r5.setEllipsize(TextUtils.TruncateAt.END);
        r5.setEnabled(!r4.getDisabled());
        r5.setTag(r4);
        r5.setOnClickListener(new com.ss.android.lark.inline.ai.creationai.operates.a(this, r4));
        addView(r5);
        r1 = r3;
        goto L14
    L39:
        if (r4.getDisabled() == false) goto L41;
        r7.setAlpha(127);
    L42:
        r14 = new SpannableStringBuilder();
        r14.append(" ");
        r14.setSpan(new xlb.a(r7), 0, 1, 33);
        goto L44
    L41:
        r7.setAlpha(255);
        goto L42
    L43:
        r14 = r4.getText();
    L45:
        this.c = false;
        return;
    L7:
        if (Intrinsics.areEqual(r11, this.b) == false) goto L9;
    }

    public final void setOnOperateClickListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = r2;
    }

    public ButtonGroupsLinearLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = CollectionsKt.emptyList();
        this.c = true;
        setOrientation(0);
    }

    public /* synthetic */ ButtonGroupsLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
