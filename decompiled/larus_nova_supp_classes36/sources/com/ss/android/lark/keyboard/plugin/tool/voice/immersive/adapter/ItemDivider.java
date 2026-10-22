package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rob.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/ItemDivider;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/BaseActionItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "onBind", "", "item", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/MoreActionItem;", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ItemDivider extends BaseActionItemViewHolder {
    public ItemDivider(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.BaseActionItemViewHolder
    public final void T3(View r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "item");
        View r4 = r2.findViewById(2131377914);
        Intrinsics.checkNotNull(r4);
        r4.setVisibility(0);
        AppCompatTextView r5 = r2.findViewById(2131390846);
        Intrinsics.checkNotNull(r5);
        r5.setVisibility(8);
        AppCompatImageView r6 = r2.findViewById(2131376099);
        Intrinsics.checkNotNull(r6);
        r6.setVisibility(8);
        ViewGroup.LayoutParams r7 = r2.getLayoutParams();
        r7.height = UIUtils.dp2px(r2.getContext(), 16.0f);
    }
}
