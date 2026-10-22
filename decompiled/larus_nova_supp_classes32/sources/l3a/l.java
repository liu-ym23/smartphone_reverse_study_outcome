package l3a;

import androidx.fragment.app.DialogFragment;
import com.larus.voicecall.impl.component.scene.RealtimeSceneComponent;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class l implements Function0 {
    public final /* synthetic */ RealtimeSceneComponent a;

    public /* synthetic */ l(RealtimeSceneComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        RealtimeSceneComponent r0 = this.a;
        int r1 = RealtimeSceneComponent.D;
        DialogFragment r2 = s1a.a.c(r0).getChildFragmentManager().findFragmentByTag("scene_board");
        if ((r2 instanceof DialogFragment) == true) goto L7;
        return null;
    L7:
        return r2;
    }
}
