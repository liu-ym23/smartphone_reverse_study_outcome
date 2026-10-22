package com.larus.chat.search.impl.chat.section;

import com.larus.chat.search.api.model.SectionItemData;
import com.larus.chat.search.api.model.SectionViewType;
import com.larus.chat.search.impl.databinding.LarusItemSearchSectionNormalBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lz8.b;
import lz8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/chat/search/impl/chat/section/SectionItemNormalViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "Lcom/larus/chat/search/impl/chat/section/ISectionItemViewHolder;", "viewBing", "Lcom/larus/chat/search/impl/databinding/LarusItemSearchSectionNormalBinding;", "<init>", "(Lcom/larus/chat/search/impl/databinding/LarusItemSearchSectionNormalBinding;)V", "bindData", "", "data", "Lcom/larus/chat/search/api/model/SectionItemData;", "listener", "Lcom/larus/chat/search/impl/chat/section/ISectionItemListener;", "getRootView", "Landroid/view/View;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SectionItemNormalViewHolder extends ViewBindingHolder implements b {
    public static final /* synthetic */ int b = 0;
    public final LarusItemSearchSectionNormalBinding a;

    public static final class a {
    }

    static {
    }

    public SectionItemNormalViewHolder(LarusItemSearchSectionNormalBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBing");
        super(r2);
        this.a = r2;
    }

    @Override // lz8.b
    public final void C1(final SectionItemData r3, final lz8.a r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (r3.getViewType() == SectionViewType.NORMAL) goto L5;
        return;
    L5:
        String r0 = r3.getSectionName();
        if (o0.d(r0) == false) goto L8;
        this.a.b.setText(r0);
        this.a.a.setOnClickListener(new d(r4, r3));
    L8:
        String r5 = r3.getConversationId();
        if (r5 != null) goto L11;
    L14:
        boolean r6 = true;
    L16:
        if ((!r6) == true) goto L18;
    L20:
        this.a.c.z(0);
        return;
    L18:
        if (r3.getUnreadCount() <= 0) goto L20;
        this.a.c.z(r3.getUnreadCount());
        return;
    L11:
        if (StringsKt.isBlank(r5) == true) goto L14;
        r6 = false;
        goto L16
    }
}
