package cs9;

import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import com.larus.praise.PraiseServiceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class b implements SettingsUpdateListener {
    public final /* synthetic */ PraiseServiceImpl a;

    public /* synthetic */ b(PraiseServiceImpl r1) {
        this.a = r1;
    }

    public final void onSettingsUpdate(SettingsData r1) {
        this.a.d();
    }
}
