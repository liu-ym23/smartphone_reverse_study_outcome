package com.larus.bmhome.chat.markdown.imagegroup.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.search.api.event.HybridEventParams;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nh8.a;
import oi8.j;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ(\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/markdown/imagegroup/view/MarkdownSourceImageView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initSourceIcon", "", "openUrl", "", "iconUrl", "hybridEventParams", "Lcom/larus/search/api/event/HybridEventParams;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MarkdownSourceImageView extends SimpleDraweeView {
    public static final /* synthetic */ int a = 0;

    public MarkdownSourceImageView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public MarkdownSourceImageView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    public MarkdownSourceImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f(final MarkdownSourceImageView r14, final String r15, String r16, HybridEventParams r17, int r18) {
        if ((r18 & 2) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r18 & 4) == 0) goto L9;
        final HybridEventParams r12 = null;
    L10:
        r14.getClass();
        if (AppHost.a.isOversea() == true) goto L13;
        r14.setVisibility(8);
        return;
    L13:
        boolean r0 = true;
        if (r15 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == false) goto L22;
        r14.setVisibility(8);
        return;
    L22:
        r14.setVisibility(0);
        if (r2 == null) goto L29;
        if (r2.length() == 0) goto L29;
        r0 = false;
    L29:
        if (r0 == false) goto L31;
        r14.setImageResource(2131242994);
    L32:
        e1.d(r14, new a(r15, r14, r12));
        return;
    L31:
        r14.getHierarchy().setFailureImage(2131242994);
        int r1 = j.a;
        j.b(r14, r2, "chat.searchlist_icon", Integer.valueOf(i5.q()), Integer.valueOf(i5.q()), null, null, null, false, 992);
        goto L32
    L16:
        if (r15.length() == 0) goto L19;
        r4 = false;
        goto L20
    L9:
        r12 = r17;
        goto L10
    L5:
        r2 = r16;
        goto L7
    }
}
