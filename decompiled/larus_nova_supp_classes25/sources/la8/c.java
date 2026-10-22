package la8;

import android.widget.ImageView;
import android.widget.TextView;
import com.larus.aweme.impl.bot.DouYinBotWrapperFragment;
import com.larus.aweme.impl.databinding.LarusFragmentDouyinBotBinding;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import kotlin.jvm.internal.Intrinsics;
import pr9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements pr9.b {
    public final /* synthetic */ DouYinBotWrapperFragment a;

    public final d a() {
        return null;
    }

    public final void b(CustomFeedPlayerEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void onLoadError(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void onLoadSuccess() {
        DouYinBotWrapperFragment r0 = this.a;
        LarusFragmentDouyinBotBinding r1 = r0.f;
        if (r1 == null) goto L7;
        TextView r2 = r1.g;
        if (r2 == null) goto L7;
        r2.setText(r0.requireActivity().getString(2131909748));
    L7:
        LarusFragmentDouyinBotBinding r3 = this.a.f;
        if (r3 == null) goto L12;
        TextView r4 = r3.g;
        if (r4 == null) goto L12;
        r4.setVisibility(0);
    L12:
        LarusFragmentDouyinBotBinding r5 = this.a.f;
        if (r5 == null) goto L18;
        ImageView r6 = r5.d;
        if (r6 == null) goto L19;
        r6.setVisibility(0);
        return;
    L19:
        return;
    }

    public c(DouYinBotWrapperFragment r1) {
        this.a = r1;
    }

    public final void c(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "aid");
        if (r2 == false) goto L16;
        DouYinBotWrapperFragment r4 = this.a;
        if (r4.h == true) goto L16;
        LarusFragmentDouyinBotBinding r5 = r4.f;
        if (r5 == null) goto L11;
        TextView r6 = r5.g;
        if (r6 == null) goto L11;
        r6.setVisibility(8);
    L11:
        LarusFragmentDouyinBotBinding r7 = this.a.f;
        if (r7 == null) goto L16;
        ImageView r8 = r7.d;
        if (r8 == null) goto L16;
        r8.setVisibility(8);
    L16:
        this.a.h = false;
    }
}
