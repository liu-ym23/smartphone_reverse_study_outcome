package nz;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface o {
    void a();

    com.bytedance.android.live.pushstream.d getLiveStream();

    void onLiveModeChange(LiveMode r1);
}
