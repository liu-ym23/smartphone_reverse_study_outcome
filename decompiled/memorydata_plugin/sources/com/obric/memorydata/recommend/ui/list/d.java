package com.obric.memorydata.recommend.ui.list;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.recommend.databinding.ItemRecommendMemoryCardBinding;
import com.obric.memorydata.recommend.settings.t;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryCardViewHolder;", "Lcom/obric/memorydata/recommend/ui/list/RecommendMemoryItemViewHolder;", "Lcom/obric/memorydata/recommend/databinding/ItemRecommendMemoryCardBinding;", "binding", "<init>", "(Lcom/obric/memorydata/recommend/databinding/ItemRecommendMemoryCardBinding;)V", "bind", "", "memoryItem", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "setOnLongClickListener", "copyTextToClipboard", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class d extends j<ItemRecommendMemoryCardBinding> {
    public d(ItemRecommendMemoryCardBinding r3) {
        Intrinsics.checkNotNullParameter(r3, "binding");
        super((ViewBinding) ZeusTransformUtils.preCheckCast(r3, ViewBinding.class, "com.obric.memorydata.plugin"));
    }

    private final void a(ItemRecommendMemoryCardBinding r3, final f r4) {
        if (AppContext.INSTANCE.isDebug() == true) goto L7;
        if (t.f12630a.k() == true) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, f.c.class) == false) goto L13;
        if (com.obric.memorydata.utils.b.b(((f.c) ZeusTransformUtils.preCheckCast(r4, f.c.class, "com.obric.memorydata.plugin")).a().ext) == false) goto L13;
        LinearLayout r5 = r3.cardWrapper;
        View.OnLongClickListener r0 = new $$Lambda$d$Dn3qJV12OTRznZi5adZHGTyxsuo(this, r4);
    L11:
        r5.setOnLongClickListener(r0);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r4, f.b.class) == false) goto L18;
        if (com.obric.memorydata.utils.b.b(((f.b) ZeusTransformUtils.preCheckCast(r4, f.b.class, "com.obric.memorydata.plugin")).a().ext) == false) goto L18;
        r5 = r3.cardWrapper;
        r0 = new $$Lambda$d$Zciz7ZBMUJgmEkYVzClvGoL_f_0(this, r4);
    L18:
        if (ZeusTransformUtils.instanceOf(r4, f.d.class) == false) goto L20;
        r5 = r3.cardWrapper;
        r0 = new $$Lambda$d$ObEg5PHHBh4kMeF2WrDKHipDJA(this, r4);
        goto L11
    L20:
        r3.cardWrapper.setOnLongClickListener(null);
    }

    private static final void a(d r1, f r2, View r3) {
        k.a((ItemRecommendMemoryCardBinding) ZeusTransformUtils.preCheckCast(r1.a(), ItemRecommendMemoryCardBinding.class, "com.obric.memorydata.plugin"), r2);
    }

    private final void a(String r7) {
        if (r7 == null) goto L5;
        ba.a(r7, "memory_memory_logId", "memory LogId 已复制到剪贴板", null, 8, null);
        return;
    }

    private static final boolean b(d r1, f r2, View r3) {
        r1.a((String) ZeusTransformUtils.preCheckCast(((f.c) ZeusTransformUtils.preCheckCast(r2, f.c.class, "com.obric.memorydata.plugin")).a().ext.get("log_id"), String.class, "com.obric.memorydata.plugin"));
        return true;
    }

    private static final boolean c(d r1, f r2, View r3) {
        r1.a((String) ZeusTransformUtils.preCheckCast(((f.b) ZeusTransformUtils.preCheckCast(r2, f.b.class, "com.obric.memorydata.plugin")).a().ext.get("log_id"), String.class, "com.obric.memorydata.plugin"));
        return true;
    }

    private static final boolean d(d r1, f r2, View r3) {
        r1.a(((f.d) ZeusTransformUtils.preCheckCast(r2, f.d.class, "com.obric.memorydata.plugin")).a().logid);
        return true;
    }

    public static /* synthetic */ boolean lambda$Dn3qJV12OTRznZi5adZHGTyxsuo(d r0, f r1, View r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$NmLi7rSVOZjJx4NrWvXnkEPjNuo(d r0, f r1, View r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$ObEg5-PHHBh4kMeF2WrDKHipDJA, reason: not valid java name */
    public static /* synthetic */ boolean m1152lambda$ObEg5PHHBh4kMeF2WrDKHipDJA(d r0, f r1, View r2) {
        return d(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$Zciz7ZBMUJgmEkYVzClvGoL_f_0(d r0, f r1, View r2) {
        return c(r0, r1, r2);
    }

    @Override // com.obric.memorydata.recommend.ui.list.j
    public void a(final f r4) {
        Intrinsics.checkNotNullParameter(r4, "memoryItem");
        ((ItemRecommendMemoryCardBinding) ZeusTransformUtils.preCheckCast(a(), ItemRecommendMemoryCardBinding.class, "com.obric.memorydata.plugin")).swipeLayout.setSwipeEnable(false);
        ((ItemRecommendMemoryCardBinding) ZeusTransformUtils.preCheckCast(a(), ItemRecommendMemoryCardBinding.class, "com.obric.memorydata.plugin")).deleteMemory.setOnClickListener(new $$Lambda$d$NmLi7rSVOZjJx4NrWvXnkEPjNuo(this, r4));
        a((ItemRecommendMemoryCardBinding) ZeusTransformUtils.preCheckCast(a(), ItemRecommendMemoryCardBinding.class, "com.obric.memorydata.plugin"), r4);
    }
}
