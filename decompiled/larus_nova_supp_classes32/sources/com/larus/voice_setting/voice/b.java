package com.larus.voice_setting.voice;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.EditPos;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements com.larus.audio.w0 {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final LiveData<Integer> b(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        if (r3.isAdded() == true) goto L7;
        FLogger.a.e("ChatSpeakerSettingViewModelDelegate", "getLanguageItemStyle");
        return new MutableLiveData(1);
    L7:
        return new ViewModelProvider(r3).get(TtsSpeakerSettingViewModel.class).getLanguageItemStyle();
    }

    public final LiveData<ArrayList<p68.h>> c(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        if (r3.isAdded() == true) goto L7;
        FLogger.a.e("ChatSpeakerSettingViewModelDelegate", "getTtsSpeakerGroups");
        return new MutableLiveData(new ArrayList());
    L7:
        return new ViewModelProvider(r3).get(TtsSpeakerSettingViewModel.class).getTtsSpeakerGroups();
    }

    public final void a(Fragment r2, SpeakerVoice r3, EditPos r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        if (r2.isAdded() == true) goto L6;
        FLogger.a.e("ChatSpeakerSettingViewModelDelegate", "refreshLanguageItemStyle");
        return;
    L6:
        new ViewModelProvider(r2).get(TtsSpeakerSettingViewModel.class).refreshLanguageItemStyle(r3, r4);
    }
}
