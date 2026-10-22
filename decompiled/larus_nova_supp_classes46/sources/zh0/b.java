package zh0;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.depend.live.IMiddlewareLiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements yh0.a {
    public Map<String, ? extends IMiddlewareLiveRoomPlayFragment> a;

    public b() {
    }

    @Override // yh0.a
    public final void b(ArrayMap r1) {
        this.a = r1;
    }

    @Override // yh0.a
    public final void a(IVoiceLiveTheme r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "voiceLiveTheme");
        Intrinsics.checkNotNullParameter(r7, "bundle");
        Map<String, ? extends IMiddlewareLiveRoomPlayFragment> r0 = this.a;
        if (r0 == null) goto L17;
        int r1 = a.a;
        Intrinsics.checkNotNullParameter(r7, "args");
        long r2 = r7.getLong("live.intent.extra.ROOM_ID", -1);
        boolean r8 = r7.getBoolean("live.intent.extra.IS_PSEUDO_LIVING", false);
        String r3 = String.valueOf(r2);
        if (r8 == false) goto L7;
        r3 = r3 + "_pseudo";
    L7:
        IMiddlewareLiveRoomPlayFragment r9 = r0.get(r3);
        if (r9 == null) goto L18;
        Fragment r10 = r9.getFragment();
        if (r10 == null) goto L19;
        Bundle r11 = r10.getArguments();
        if (r11 != null) goto L14;
        return;
    L14:
        if (a.a(r11) == true) goto L21;
        r11.putAll(a.c(r6));
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }
}
