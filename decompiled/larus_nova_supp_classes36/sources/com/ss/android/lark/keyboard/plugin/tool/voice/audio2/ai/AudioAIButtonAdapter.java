package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.ai;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import slb.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/ai/AudioAIButtonAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/ai/AudioAIButtonViewHolder;", "controller", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;", "<init>", "(Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;)V", "prompts", "", "Lcom/ss/android/lark/inline/ai/api/Prompt;", "getPrompts", "()Ljava/util/List;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "showAIBtn", "btn", "Landroidx/appcompat/widget/AppCompatTextView;", "prompt", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioAIButtonAdapter extends RecyclerView.Adapter<AudioAIButtonViewHolder> {

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.ai.AudioAIButtonAdapter$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/ss/android/lark/inline/ai/api/Prompt;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    final class AnonymousClass1 extends Lambda implements Function1<List<? extends j>, Unit> {
        final /* synthetic */ AudioAIButtonAdapter this$0;

        public AnonymousClass1(AudioAIButtonAdapter r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(List<j> r4) {
            StringBuilder r0 = new StringBuilder("AI prompts changed: ");
            if (r4 == null) goto L8;
            List<j> r5 = r4;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator<T> r6 = r5.iterator();
        L6:
            if (r6.hasNext() == false) goto L9;
            r1.add(((j) r6.next()).d);
        L9:
            r0.append(r1);
            Log.i("AudioAIButtonAdapter", r0.toString());
            this.this$0.notifyDataSetChanged();
            return;
        L8:
            r1 = null;
            goto L9
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((List) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        List<j> r0 = y2();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final List<j> y2() {
        throw null;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        AudioAIButtonViewHolder r8 = (AudioAIButtonViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        AppCompatTextView r9 = (AudioAIGradientButton) r8.a.getValue();
        List<j> r0 = y2();
        if (r0 == null) goto L5;
        j r10 = (j) ListProtector.get(r0, r7);
    L6:
        if (r10 == null) goto L10;
        Drawable r1 = UIHelper.getDrawable(r10.c);
        r1.setBounds(0, 0, UIHelper.dp2px(18.0f), UIHelper.dp2px(18.0f));
        r9.setCompoundDrawables(r1, null, null, null);
        r9.setText(r10.d);
        r9.setVisibility(0);
        r9.setOnClickListener(new com.ss.android.lark.keyboard.plugin.tool.voice.audio2.ai.a(this, r10));
        return;
    L10:
        return;
    L5:
        r10 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new AudioAIButtonViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131563271, r4, false));
    }
}
