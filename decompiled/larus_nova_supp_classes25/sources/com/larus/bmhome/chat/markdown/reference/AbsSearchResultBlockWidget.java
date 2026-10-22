package com.larus.bmhome.chat.markdown.reference;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import fh8.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ_\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H&¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0017H&¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/markdown/reference/AbsSearchResultBlockWidget;", "T", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bindData", "Landroid/util/Size;", "data", "maxWidth", "", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "backgroundResource", "forceHideArrow", "", "blockDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "onClickInterceptor", "Lkotlin/Function0;", "", "(Ljava/lang/Object;ILcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;Lkotlin/jvm/functions/Function0;)Landroid/util/Size;", "onRecycle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class AbsSearchResultBlockWidget<T> extends FrameLayout {
    public abstract Size g(SearchReferenceData r1, int r2, f r3, Integer r4, Boolean r5, Function0 r6);

    public AbsSearchResultBlockWidget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public AbsSearchResultBlockWidget(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    public static /* synthetic */ Size h(AbsSearchResultBlockWidget r9, SearchReferenceData r10, int r11, f r12, Integer r13, Boolean r14, kc8.b r15, com.larus.bmhome.block.holder.deepthink.a r16, int r17) {
        if ((r17 & 16) == 0) goto L5;
        Boolean r7 = null;
    L7:
        if ((r17 & 64) == 0) goto L9;
        com.larus.bmhome.block.holder.deepthink.a r8 = null;
    L11:
        return r9.g(r10, r11, r12, r13, r7, r8);
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r14;
        goto L7
    }
}
