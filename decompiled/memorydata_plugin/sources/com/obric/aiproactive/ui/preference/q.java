package com.obric.aiproactive.ui.preference;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.obric.aiproactive.api.AiProactivePreferenceExampleDto;
import com.obric.aiproactive.ui.databinding.ItemProactivePreferenceSugBinding;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/aiproactive/ui/preference/ProactivePreferenceAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/aiproactive/ui/preference/ProactivePreferenceAdapter$ViewHolder;", "items", "", "Lcom/obric/aiproactive/api/AiProactivePreferenceExampleDto;", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "ViewHolder", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<AiProactivePreferenceExampleDto> f6789a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/ui/preference/ProactivePreferenceAdapter$ViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/aiproactive/ui/databinding/ItemProactivePreferenceSugBinding;", "<init>", "(Lcom/obric/aiproactive/ui/databinding/ItemProactivePreferenceSugBinding;)V", "getBinding", "()Lcom/obric/aiproactive/ui/databinding/ItemProactivePreferenceSugBinding;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ItemProactivePreferenceSugBinding f6790a;

        public a(ItemProactivePreferenceSugBinding r4) {
            Intrinsics.checkNotNullParameter(r4, "binding");
            super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f6790a = r4;
        }

        public final ItemProactivePreferenceSugBinding a() {
            return this.f6790a;
        }
    }

    public q(List<AiProactivePreferenceExampleDto> r3) {
        List<AiProactivePreferenceExampleDto> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "items");
        this.f6789a = r4;
    }

    private static final void a(Context r2, String r3, View r4) {
        Toast.makeText((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Clicked: " + r3, CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
    }

    /* JADX INFO: renamed from: lambda$iq9LCvUPOXWYNZHPOwM1-kHhLvk, reason: not valid java name */
    public static /* synthetic */ void m333lambda$iq9LCvUPOXWYNZHPOwM1kHhLvk(Context r0, String r1, View r2) {
        a(r0, r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public void a(a r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        AiProactivePreferenceExampleDto r7 = (AiProactivePreferenceExampleDto) ZeusTransformUtils.preCheckCast(this.f6789a.get(r9), AiProactivePreferenceExampleDto.class, "com.obric.memorydata.plugin");
        r8.a().tvContent.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7.getTitle(), CharSequence.class, "com.obric.memorydata.plugin"));
        if (Intrinsics.areEqual(r7.getIconType(), "weather") == false) goto L5;
        int r10 = R.drawable.ic_menu_compass;
    L6:
        r8.a().ivIcon.setImageResource(r10);
        r8.a().llActions.removeAllViews();
        final Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Iterator<String> r12 = r7.getActions().iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        final String r2 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
        TextView r3 = new TextView(r11);
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        r3.setTextSize(14.0f);
        r3.setTextColor(Color.parseColor("#333333"));
        r3.setBackgroundResource(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.drawable.bg_proactive_preference_button, "drawable", "bg_proactive_preference_button"));
        r3.setPadding(40, 32, 40, 32);
        r3.setGravity(17);
        r3.setOnClickListener(new $$Lambda$q$iq9LCvUPOXWYNZHPOwM1kHhLvk(r11, r2));
        r8.a().llActions.addView((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        return;
    L5:
        r10 = ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.drawable.oic_pen_with_start, "drawable", "oic_pen_with_start");
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), r4);
    }

    public a b(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        ItemProactivePreferenceSugBinding r1 = ItemProactivePreferenceSugBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r2, false);
        Intrinsics.checkNotNullExpressionValue(r1, "inflate(...)");
        return new a(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.f6789a.size();
    }
}
