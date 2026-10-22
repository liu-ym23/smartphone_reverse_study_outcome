package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.universe_design.switch.UDSwitch;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rob.g;
import rob.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/SwitchActionItemViewHolder;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/BaseActionItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "onBind", "", "item", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/MoreActionItem;", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SwitchActionItemViewHolder extends BaseActionItemViewHolder {
    public SwitchActionItemViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.BaseActionItemViewHolder
    public final void T3(View r5, g r6) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        Intrinsics.checkNotNullParameter(r6, "item");
        Object r7 = r6.a();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SwitchActionData");
        j r8 = (j) r7;
        AppCompatImageView r0 = r5.findViewById(2131376297);
        Intrinsics.checkNotNull(r0);
        r0.setVisibility(0);
        r0.setImageResource(r8.a);
        AppCompatTextView r1 = r5.findViewById(2131390846);
        r1.setTextColor(UIUtils.getColor(r1.getContext(), 2131106622));
        r1.setTextSize(16.0f);
        r1.setText(r8.b);
        UDSwitch r9 = r5.findViewById(2131387804);
        if (r9 == null) goto L6;
        r9.setChecked(r8.c);
        r9.setClickable(false);
        r9.setFocusable(false);
        return;
    }
}
