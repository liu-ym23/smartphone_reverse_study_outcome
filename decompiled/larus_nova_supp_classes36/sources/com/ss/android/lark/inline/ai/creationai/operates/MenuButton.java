package com.ss.android.lark.inline.ai.creationai.operates;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.ui.f0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/MenuButton;", "Lcom/larksuite/component/universe_design/button/UDButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "type", "", "setType", "", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MenuButton extends UDButton {
    public String a;

    public static final class a {
    }

    static {
    }

    public MenuButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MenuButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setType(String r7) {
        Intrinsics.checkNotNullParameter(r7, "type");
        Log.i("OperateButton", "setType, type = " + r7);
        this.a = r7;
        int r0 = r7.hashCode();
        if (r0 == (-867509719)) goto L17;
        if (r0 == (-314765822)) goto L14;
        if (r0 == 3181155) goto L10;
    L18:
        setTextColor(ContextCompat.getColorStateList(getContext(), 2131101298));
        setBackground(ContextCompat.getDrawable(getContext(), 2131233712));
        setHeight(f0.a(48));
        return;
    L10:
        if (r7.equals("gray") == false) goto L18;
        setTextColor(ContextCompat.getColorStateList(getContext(), 2131101296));
        setBackground(ContextCompat.getDrawable(getContext(), 2131233710));
        setHeight(f0.a(48));
        setTextSize(17.0f);
        return;
    L14:
        if (r7.equals("primary") == false) goto L18;
        setBackground(ContextCompat.getDrawable(getContext(), 2131233711));
        setTextColor(ContextCompat.getColorStateList(getContext(), 2131101297));
        setHeight(f0.a(48));
        return;
    L17:
        if (r7.equals(INotificationHitPoint.NoticeType.REACTION) == false) goto L18;
        setTextColor(ContextCompat.getColorStateList(getContext(), 2131101296));
        setBackground(ContextCompat.getDrawable(getContext(), 2131233710));
        setHeight(f0.a(48));
        setTextSize(17.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = "normal";
        setGravity(17);
        setTextAlignment(4);
        setType(this.a);
    }

    public /* synthetic */ MenuButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
