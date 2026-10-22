package com.larus.bot.impl.feature.edit.feature.language;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.EditPos;
import com.larus.platform.spi.IAIChatAudioService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/language/LanguageItemViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_languageItemStyle", "Landroidx/lifecycle/MutableLiveData;", "", "languageItemStyle", "Landroidx/lifecycle/LiveData;", "getLanguageItemStyle", "()Landroidx/lifecycle/LiveData;", "refreshLanguageItemStyle", "", "speakerVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "editPos", "Lcom/larus/platform/model/EditPos;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LanguageItemViewModel extends ViewModel {
    private final MutableLiveData<Integer> _languageItemStyle;
    private final LiveData<Integer> languageItemStyle;

    public LanguageItemViewModel() {
        MutableLiveData<Integer> r0 = new MutableLiveData(1);
        this._languageItemStyle = r0;
        this.languageItemStyle = r0;
    }

    public final LiveData<Integer> getLanguageItemStyle() {
        return this.languageItemStyle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final void refreshLanguageItemStyle(SpeakerVoice r4, EditPos r5) {
        boolean r0 = true;
        ?? r1 = 0;
        if (r4 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L17;
        if (r4 != null) goto L11;
    L13:
        r0 = false;
    L14:
        if (r0 == false) goto L17;
        this._languageItemStyle.setValue(0);
        return;
    L11:
        if (r4.getStatus() != 4) goto L13;
    L17:
        MutableLiveData<Integer> r6 = this._languageItemStyle;
        if (r5 == null) goto L20;
        r1 = r5.b();
    L20:
        r6.setValue(Integer.valueOf(r1));
        return;
    L5:
        if (IAIChatAudioService.a.p(r4) != true) goto L7;
        r2 = true;
        goto L8
    }
}
