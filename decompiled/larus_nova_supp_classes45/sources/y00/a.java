package y00;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.livehostapi.TTLiveSDK;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ Activity a;

    public a(Activity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        Bundle r5 = new Bundle();
        r5.putString("fragment_type", "simple");
        TTLiveSDK.hostService().action().openLiveBrowser("https://webcast.amemv.com/falcon/webcast_douyin/page/anchor_agreement/index.html?type=fullscreen&title=&hide_more=0&hide_nav_bar=0&hide_status_bar=0&__live_platform__=webcast", r5, this.a);
    }
}
