package com.ss.android.lark.keyboard.plugin.tool.voice.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.pb.recognition.SpeechLang;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bBG\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/utils/AudioChooseLanguageDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/utils/AudioChooseLanguageDialogAdapter$AudioViewHolder;", "languageList", "", "Lcom/ss/android/lark/pb/recognition/SpeechLang;", "defaultLangKeyList", "", "defaultLangNameList", "chosenLanguageKey", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "mItemClickListener", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/utils/AudioChooseLanguageDialogAdapter$OnLanguageItemClickListener;", "setOnLanguageItemClickListener", "", "l", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "AudioViewHolder", "OnLanguageItemClickListener", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioChooseLanguageDialogAdapter extends RecyclerView.Adapter<AudioViewHolder> {
    public final List<SpeechLang> a;
    public final List<String> b;
    public final List<String> c;
    public String d;
    public a e;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/utils/AudioChooseLanguageDialogAdapter$AudioViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "rootView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvLanguage", "Landroid/widget/TextView;", "getTvLanguage", "()Landroid/widget/TextView;", "ivChosen", "Landroidx/appcompat/widget/AppCompatImageView;", "getIvChosen", "()Landroidx/appcompat/widget/AppCompatImageView;", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class AudioViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final AppCompatImageView b;

        public AudioViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "rootView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131390846);
            this.b = r2.findViewById(2131376099);
        }
    }

    public interface a {
        void j4(String r1, String r2, String r3);
    }

    public final int getItemCount() {
        List<SpeechLang> r0 = this.a;
        boolean r2 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L19;
        List<String> r3 = this.c;
        if (r3 != null) goto L13;
    L15:
        r2 = false;
    L16:
        if (r2 == true) goto L18;
        return 0;
    L18:
        return this.c.size();
    L13:
        if ((!r3.isEmpty()) != true) goto L15;
    L19:
        return this.a.size();
    L5:
        if ((!r0.isEmpty()) != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        AudioViewHolder r7 = (AudioViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        List<SpeechLang> r0 = this.a;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        String r3 = ((SpeechLang) ListProtector.get(this.a, r6)).mlangCode;
        String r4 = ((SpeechLang) ListProtector.get(this.a, r6)).mlangName;
    L30:
        r7.a.setText(r4);
        if (Intrinsics.areEqual(r3, this.d) == false) goto L33;
        UIUtils.setViewVisibility(r7.b, 0);
    L34:
        ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(new com.ss.android.lark.keyboard.plugin.tool.voice.utils.a(this, r6));
        return;
    L33:
        UIUtils.setViewVisibility(r7.b, 8);
        goto L34
    L10:
        List<String> r8 = this.b;
        if (r8 != null) goto L13;
    L15:
        boolean r9 = false;
    L16:
        if (r9 == false) goto L29;
        List<String> r10 = this.c;
        if (r10 != null) goto L20;
    L22:
        r1 = false;
    L23:
        if (r1 == false) goto L29;
        if (r6 >= this.b.size()) goto L29;
        if (r6 >= this.c.size()) goto L29;
        r3 = (String) ListProtector.get(this.b, r6);
        r4 = (String) ListProtector.get(this.c, r6);
        goto L30
    L20:
        if ((!r10.isEmpty()) != true) goto L22;
    L29:
        r3 = "";
        r4 = "";
        goto L30
    L13:
        if ((!r8.isEmpty()) != true) goto L15;
        r9 = true;
        goto L16
    L5:
        if ((!r0.isEmpty()) != true) goto L7;
        r2 = true;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131561614, r3, false);
        Intrinsics.checkNotNull(r5);
        return new AudioViewHolder(r5);
    }

    public AudioChooseLanguageDialogAdapter(List<SpeechLang> r1, List<String> r2, List<String> r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
