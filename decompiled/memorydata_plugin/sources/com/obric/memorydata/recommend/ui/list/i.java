package com.obric.memorydata.recommend.ui.list;

import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.obric.memory.model.MemoryData;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ItemRecommendMemoryCardBinding;
import com.obric.memorydata.recommend.databinding.ItemRecommendPortraitDataBinding;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/PortraitDataViewHolder;", "Lcom/obric/memorydata/recommend/ui/list/MemoryCardViewHolder;", "stubBinding", "Lcom/obric/memorydata/recommend/databinding/ItemRecommendPortraitDataBinding;", "binding", "Lcom/obric/memorydata/recommend/databinding/ItemRecommendMemoryCardBinding;", "<init>", "(Lcom/obric/memorydata/recommend/databinding/ItemRecommendPortraitDataBinding;Lcom/obric/memorydata/recommend/databinding/ItemRecommendMemoryCardBinding;)V", "bind", "", "memoryItem", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ItemRecommendPortraitDataBinding f12709b;

    public i(ItemRecommendPortraitDataBinding r2, ItemRecommendMemoryCardBinding r3) {
        Intrinsics.checkNotNullParameter(r2, "stubBinding");
        Intrinsics.checkNotNullParameter(r3, "binding");
        super(r3);
        this.f12709b = r2;
    }

    @Override // com.obric.memorydata.recommend.ui.list.d, com.obric.memorydata.recommend.ui.list.j
    public void a(f r9) {
        Intrinsics.checkNotNullParameter(r9, "memoryItem");
        super.a(r9);
        if (ZeusTransformUtils.instanceOf(r9, f.c.class) == false) goto L5;
        f.c r10 = (f.c) ZeusTransformUtils.preCheckCast(r9, f.c.class, "com.obric.memorydata.plugin");
    L6:
        if (r10 == null) goto L28;
        MemoryData r11 = r10.a();
        if (r11 == null) goto L29;
        this.f12709b.titleText.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11.content, CharSequence.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("MemoryItemViewHolder", "tag prefix: " + at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_portrait_tag_prefix, TypedValues.Custom.S_STRING, "recommend_memory_portrait_tag_prefix")));
        String r0 = r11.tag;
        Intrinsics.checkNotNullExpressionValue(r0, LocationMonitorConst.TAG);
        int r2 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L12;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L17;
        TextView r3 = this.f12709b.tagText;
        r2 = 8;
    L16:
        r3.setVisibility(r2);
        TextView r4 = this.f12709b.observationText;
        String r5 = at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_observation, TypedValues.Custom.S_STRING, "recommend_memory_general_observation")) + r11.observation;
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r6 = this.f12709b.updateTimeText;
        String r7 = at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_update_time, TypedValues.Custom.S_STRING, "recommend_memory_general_update_time")) + com.obric.memorydata.recommend.ui.a.f12641a.a(com.obric.memorydata.recommend.model.a.b(r11));
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        r6.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r8 = this.f12709b.createTimeText;
        String r12 = at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_create_time, TypedValues.Custom.S_STRING, "recommend_memory_general_create_time")) + com.obric.memorydata.recommend.ui.a.f12641a.a(com.obric.memorydata.recommend.model.a.a(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r13 = this.f12709b.profileText;
        StringBuilder r14 = new StringBuilder();
        r14.append(at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_portrait_profile_type, TypedValues.Custom.S_STRING, "recommend_memory_portrait_profile_type")));
        if (r11.profileType != 0) goto L25;
        int r15 = R.string.recommend_memory_portrait_profile_shallow;
        String r16 = "recommend_memory_portrait_profile_shallow";
    L26:
        r14.append(at.a(ZeusTransformUtils.mapRes(r15, TypedValues.Custom.S_STRING, r16)));
        String r17 = r14.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "toString(...)");
        r13.setText((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L25:
        r15 = R.string.recommend_memory_portrait_profile_deep;
        r16 = "recommend_memory_portrait_profile_deep";
        goto L26
    L17:
        TextView r18 = this.f12709b.tagText;
        StringBuilder r19 = new StringBuilder();
        r19.append(at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_portrait_tag_prefix, TypedValues.Custom.S_STRING, "recommend_memory_portrait_tag_prefix")));
        if (Intrinsics.areEqual(r11.tag, PortraitTag.f12672a.c()) == false) goto L20;
        String r20 = r11.tagOther;
    L21:
        r19.append(r20);
        String r21 = r19.toString();
        Intrinsics.checkNotNullExpressionValue(r21, "toString(...)");
        r18.setText((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin"));
        r3 = this.f12709b.tagText;
        goto L16
    L20:
        r20 = r11.tag;
        goto L21
    L12:
        r1 = false;
        goto L14
    L29:
        return;
    L28:
        return;
    L5:
        r10 = null;
        goto L6
    }
}
