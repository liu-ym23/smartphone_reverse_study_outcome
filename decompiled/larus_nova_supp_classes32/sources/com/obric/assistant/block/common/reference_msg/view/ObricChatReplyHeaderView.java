package com.obric.assistant.block.common.reference_msg.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common.apphost.AppHost;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricLayoutChatReplyHeaderBinding;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.oui.material.OMaterialHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ve8.d;
import yba.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J3\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a¢\u0006\u0002\u0010\u001dR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/block/common/reference_msg/view/ObricChatReplyHeaderView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricLayoutChatReplyHeaderBinding;", "arrowDrawable", "Landroid/graphics/drawable/Drawable;", "getArrowDrawable", "()Landroid/graphics/drawable/Drawable;", "arrowDrawable$delegate", "Lkotlin/Lazy;", "setImmerseMode", "getClickView", "Landroid/view/View;", "show", NameKeys.UnloadStrategy_No_Strategy, "text", NameKeys.UnloadStrategy_No_Strategy, "isImmerse", NameKeys.UnloadStrategy_No_Strategy, "isSelf", "showArrow", "(Ljava/lang/String;Ljava/lang/Boolean;ZZ)V", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatReplyHeaderView extends LinearLayout {
    public static final /* synthetic */ int c = 0;
    public final ObricLayoutChatReplyHeaderBinding a;
    public final Lazy b;

    public ObricChatReplyHeaderView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ObricChatReplyHeaderView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Drawable getArrowDrawable() {
        return (Drawable) this.b.getValue();
    }

    public final View getClickView() {
        ObricLayoutChatReplyHeaderBinding r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public ObricChatReplyHeaderView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setOrientation(0);
        LayoutInflater.from(r2).inflate(2131564028, this);
        int r5 = 2131384353;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(this, 2131384353);
        if (r6 == null) goto L9;
        r5 = 2131384362;
        TextView r0 = (TextView) ViewBindings.findChildViewById(this, 2131384362);
        if (r0 == null) goto L9;
        this.a = new ObricLayoutChatReplyHeaderBinding(this, r6, r0);
        this.b = LazyKt.lazy(new a(r2));
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ ObricChatReplyHeaderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void a(String r4, Boolean r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.areEqual(r5, Boolean.TRUE);
        ObricLayoutChatReplyHeaderBinding r8 = this.a;
        if (r8 == null) goto L24;
        r8.c.setText(r4);
        if (r6 == true) goto L8;
        r8.c.setTextColor(d.a(2131103684, AppHost.a.getApplication()));
        r8.b.setImageResource(2131244503);
    L8:
        if (IWindowContextKt.isWindowContext(getContext()) == true) goto L10;
    L12:
        TextView r9 = r8.c;
        if (r7 == false) goto L15;
        Drawable r10 = getArrowDrawable();
    L16:
        r9.setCompoundDrawables(null, null, r10, null);
        TextView r11 = r8.c;
        if (r4.length() != 0) goto L19;
        boolean r12 = true;
    L20:
        if (r12 == false) goto L22;
        int r13 = 4;
    L23:
        r11.setVisibility(r13);
        goto L24
    L22:
        r13 = 0;
        goto L23
    L19:
        r12 = false;
        goto L20
    L15:
        r10 = null;
        goto L16
    L10:
        if (OMaterialHelper.f() < 3) goto L12;
        r8.c.setTextColor(d.a(2131103684, getContext()));
    L24:
        setVisibility(0);
    }
}
