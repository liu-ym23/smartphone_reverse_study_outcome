package be0;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.model.DefaultVoiceLiveThemeResource;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements a {
    public final NextLiveData<IVoiceLiveTheme> a;
    public final NextLiveData<IVoiceLiveTheme> b;
    public final NextLiveData<ArrayList<IVoiceLiveTheme>> c;
    public final NextLiveData<Integer> d;

    public g() {
        this.a = new NextLiveData();
        this.b = new NextLiveData();
        NextLiveData<ArrayList<IVoiceLiveTheme>> r0 = new NextLiveData();
        this.c = r0;
        this.d = new NextLiveData();
        r0.setValue(new ArrayList());
    }

    @Override // be0.a
    public final IVoiceLiveTheme d() {
        return DefaultVoiceLiveThemeResource.videoTalkRoomDefaultTheme();
    }

    @Override // be0.a
    public final NextLiveData<IVoiceLiveTheme> a() {
        return this.b;
    }

    @Override // be0.a
    public final NextLiveData<ArrayList<IVoiceLiveTheme>> b() {
        return this.c;
    }

    @Override // be0.a
    public final NextLiveData<Integer> c() {
        return this.d;
    }

    @Override // be0.a
    public final NextLiveData<IVoiceLiveTheme> getCurrentTheme() {
        return this.a;
    }
}
