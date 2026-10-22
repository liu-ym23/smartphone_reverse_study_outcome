package wvb;

import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.location.dto.POIConfig;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(FragmentActivity r10, gqb.a r11) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        Intrinsics.checkNotNullParameter(r11, "listener");
        Application r0 = LarkContext.getApplication();
        if (r0 != null) goto L6;
        int r12 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "launch", "context is null", null);
        return;
    L6:
        POIConfig r4 = new POIConfig();
        r4.setActionText(r0.getString(2131892882));
        r4.setSnapshot(false);
        r4.setSelfDefine(false);
        fqb.a.c(r10, null, r4, new Token("LARK-PSDA-mm_image_share_location"), Scene.Minutes.INSTANCE, r11, false, true);
    }
}
