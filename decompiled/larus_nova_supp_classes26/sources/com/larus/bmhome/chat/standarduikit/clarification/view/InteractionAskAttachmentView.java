package com.larus.bmhome.chat.standarduikit.clarification.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/clarification/view/InteractionAskAttachmentView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "resourceBarOperator", "Lcom/larus/bmhome/view/resourcebar/bean/IResourceItemOperator;", "bind", "", "attachmentItems", "", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "ensureResourceBarOperator", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionAskAttachmentView extends FrameLayout {
    public static final /* synthetic */ int b = 0;
    public mt8.a a;

    public static final class a {
    }

    static {
    }

    public InteractionAskAttachmentView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InteractionAskAttachmentView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public InteractionAskAttachmentView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public final void a(List<ResourceItemBean> r6, BaseResourceViewHolder.a r7, ResourceBarConfig r8) {
        Intrinsics.checkNotNullParameter(r6, "attachmentItems");
        Intrinsics.checkNotNullParameter(r8, "config");
        List<ResourceItemBean> r9 = r6;
        boolean r0 = !r9.isEmpty();
        if (r0 == false) goto L5;
        int r1 = 0;
    L6:
        setVisibility(r1);
        if (r0 == true) goto L12;
        mt8.a r10 = this.a;
        if (r10 == null) goto L29;
        r10.e(new ArrayList());
        return;
    L29:
        return;
    L12:
        mt8.a r2 = this.a;
        if (r2 == null) goto L27;
    L23:
        if (r2 != null) goto L25;
        return;
    L25:
        r2.h(r8, new ArrayList(r9), r7);
        return;
    L27:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L17
        Object r4 = Result.constructor-impl(InputViewCreatorDelegate.b.e(getContext()));     // Catch: Throwable -> L17
    L19:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 != null) goto L22;
        r2 = (mt8.a) r4;
        addView(r2.getView(), new FrameLayout.LayoutParams(-1, -2));
        this.a = r2;
        goto L23
    L22:
        FLogger.a.e("InteractionAskAttachmentView", "create resource bar failed", r5);
        r2 = null;
    L17:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L5:
        r1 = 8;
        goto L6
    }

    public /* synthetic */ InteractionAskAttachmentView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
