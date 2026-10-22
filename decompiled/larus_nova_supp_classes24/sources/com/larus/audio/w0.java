package com.larus.audio;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.EditPos;
import java.util.ArrayList;
import p68.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface w0 {
    void a(Fragment r1, SpeakerVoice r2, EditPos r3);

    LiveData<Integer> b(Fragment r1);

    LiveData<ArrayList<h>> c(Fragment r1);
}
