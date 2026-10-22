package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.suite.lark.emm.design.edittext.SCAppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\rJ\b\u0010\u0019\u001a\u00020\u0012H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteInputAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteInputAdapter$DownVoteInputViewHolder;", "listener", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteInputAdapter$InputContentListener;", "<init>", "(Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteInputAdapter$InputContentListener;)V", "getListener", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteInputAdapter$InputContentListener;", "setListener", "editText", "Landroidx/appcompat/widget/AppCompatEditText;", "getText", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "setHint", "hint", "getItemCount", "DownVoteInputViewHolder", "InputContentListener", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DownVoteInputAdapter extends RecyclerView.Adapter<DownVoteInputViewHolder> {
    public SCAppCompatEditText a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/vote/DownVoteInputAdapter$DownVoteInputViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "container", "Landroid/widget/FrameLayout;", "getContainer", "()Landroid/widget/FrameLayout;", "editText", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class DownVoteInputViewHolder extends RecyclerView.ViewHolder {
        public final FrameLayout a;

        public DownVoteInputViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            FrameLayout r3 = (FrameLayout) r2;
            this.a = r3;
            View r4 = r3.getChildAt(0);
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.EditText");
            EditText r5 = (EditText) r4;
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return 1;
    }

    public DownVoteInputAdapter() {
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        DownVoteInputViewHolder r3 = (DownVoteInputViewHolder) r1;
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.getClass();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        Context r8 = r6.getContext();
        FrameLayout r9 = new FrameLayout(r8);
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r9.setPadding(0, UIUtils.dp2px(r8, 18.0f), 0, 0);
        Intrinsics.checkNotNull(r8);
        SCAppCompatEditText r0 = new SCAppCompatEditText(r8, null);
        r0.setTextSize(0, zz7.b.g(r8, 16));
        int r3 = UIUtils.dp2px(r8, 10.0f);
        int r4 = UIUtils.dp2px(r8, 16.0f);
        r0.setPadding(r4, r3, r4, r3);
        r0.setBackgroundResource(2131231960);
        r0.setTextColor(UDColorUtils.getColor(r8, 2131106622));
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, UIUtils.dp2px(r8, 122.0f)));
        r0.setHint(2131892932);
        r0.setHintTextColor(UIUtils.getColor(r8, 2131106620));
        r0.setMinLines(5);
        r0.setGravity(8388611);
        r0.addTextChangedListener(new uob.a(this));
        if (r0.isAttachedToWindow() == false) goto L5;
        r0.setCursorVisible(false);
        r0.setCursorVisible(true);
        r0.setOnTouchListener(b.a);
    L6:
        this.a = r0;
        r9.addView(r0);
        return new DownVoteInputViewHolder(r9);
    L5:
        r0.addOnAttachStateChangeListener(new uob.b(r0, r0));
        goto L6
    }
}
