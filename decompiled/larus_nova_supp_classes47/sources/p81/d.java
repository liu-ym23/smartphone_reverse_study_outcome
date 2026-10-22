package p81;

import android.view.View;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.ProfileMyLiveTopRightEntranceComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final String a;
    public final View.OnClickListener b;

    public d(String r2, ProfileMyLiveTopRightEntranceComponent.a r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "onClickListener");
        this.a = r2;
        this.b = r3;
    }
}
