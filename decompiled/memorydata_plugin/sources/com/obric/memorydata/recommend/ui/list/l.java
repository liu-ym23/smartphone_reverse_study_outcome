package com.obric.memorydata.recommend.ui.list;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.obric.memory.model.UserTodo;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ItemRecommendMemoryCardBinding;
import com.obric.memorydata.recommend.databinding.ItemRecommendTodoDataBinding;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/TodoDataViewHolder;", "Lcom/obric/memorydata/recommend/ui/list/MemoryCardViewHolder;", "stubBinding", "Lcom/obric/memorydata/recommend/databinding/ItemRecommendTodoDataBinding;", "binding", "Lcom/obric/memorydata/recommend/databinding/ItemRecommendMemoryCardBinding;", "<init>", "(Lcom/obric/memorydata/recommend/databinding/ItemRecommendTodoDataBinding;Lcom/obric/memorydata/recommend/databinding/ItemRecommendMemoryCardBinding;)V", "bind", "", "memoryItem", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ItemRecommendTodoDataBinding f12712b;

    public l(ItemRecommendTodoDataBinding r2, ItemRecommendMemoryCardBinding r3) {
        Intrinsics.checkNotNullParameter(r2, "stubBinding");
        Intrinsics.checkNotNullParameter(r3, "binding");
        super(r3);
        this.f12712b = r2;
    }

    @Override // com.obric.memorydata.recommend.ui.list.d, com.obric.memorydata.recommend.ui.list.j
    public void a(f r11) {
        Intrinsics.checkNotNullParameter(r11, "memoryItem");
        super.a(r11);
        ViewGroup.LayoutParams r0 = this.f12712b.getRoot().getLayoutParams();
        if (r0 == null) goto L5;
        r0.width = -1;
    L5:
        this.f12712b.getRoot().setLayoutParams(r0);
        if (ZeusTransformUtils.instanceOf(r11, f.d.class) == false) goto L8;
        f.d r12 = (f.d) ZeusTransformUtils.preCheckCast(r11, f.d.class, "com.obric.memorydata.plugin");
    L9:
        if (r12 == null) goto L14;
        UserTodo r13 = r12.a();
        if (r13 == null) goto L15;
        this.f12712b.titleText.setText((CharSequence) ZeusTransformUtils.preCheckCast(r13.eventDescription, CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r1 = this.f12712b.eventTimeText;
        String r2 = at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_todo_event_time, TypedValues.Custom.S_STRING, "recommend_memory_todo_event_time")) + r13.eventDatetimeText;
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r3 = this.f12712b.possibilityText;
        String r4 = at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_todo_possibility_type, TypedValues.Custom.S_STRING, "recommend_memory_todo_possibility_type")) + r13.possibility;
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r5 = this.f12712b.extraText;
        String r6 = at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_todo_extra, TypedValues.Custom.S_STRING, "recommend_memory_todo_extra")) + r13.extraInfo;
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r7 = this.f12712b.createTimeText;
        StringBuilder r8 = new StringBuilder();
        r8.append(at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_todo_create_time, TypedValues.Custom.S_STRING, "recommend_memory_todo_create_time")));
        long r9 = 1000;
        r8.append(com.obric.memorydata.recommend.ui.a.f12641a.a(r13.createdAt * r9));
        String r10 = r8.toString();
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
        r7.setText((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r14 = this.f12712b.updateTimeText;
        String r15 = at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_todo_update_time, TypedValues.Custom.S_STRING, "recommend_memory_todo_update_time")) + com.obric.memorydata.recommend.ui.a.f12641a.a(r13.updatedAt * r9);
        Intrinsics.checkNotNullExpressionValue(r15, "toString(...)");
        r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r12 = null;
        goto L9
    }
}
