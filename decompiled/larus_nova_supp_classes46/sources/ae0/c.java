package ae0;

import com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeDownloadManager;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements a {
    public c() {
    }

    @Override // ae0.a
    public final ArrayList<IVoiceLiveTheme> a(ArrayList<IVoiceLiveTheme> r7) {
        Intrinsics.checkNotNullParameter(r7, "themes");
        Iterator<T> r0 = r7.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (IVoiceLiveThemeKt.isUgcVideoTheme((IVoiceLiveTheme) r1) == false) goto L4;
    L9:
        IVoiceLiveTheme r2 = (IVoiceLiveTheme) r1;
        boolean r3 = false;
        if (r2 == null) goto L18;
        IAnimatedBgInfo r4 = r2.getAnimatedBgInfo();
        if (r4 == null) goto L18;
        k r5 = r4.getAnimatedBg();
        if (r5 == null) goto L18;
        List r6 = r5.getUrls();
        if (r6 == null) goto L18;
        String r8 = (String) ListProtector.get(r6, 0);
    L19:
        if (r2 == null) goto L25;
        IAnimatedBgInfo r9 = r2.getAnimatedBgInfo();
        if (r9 == null) goto L25;
        k r10 = r9.getAnimatedBg();
        if (r10 == null) goto L25;
        String r11 = r10.getUri();
    L27:
        if (r8 != null) goto L29;
    L32:
        boolean r12 = true;
    L33:
        if (r12 == true) goto L44;
        if (r11 != null) goto L36;
    L37:
        r3 = true;
    L38:
        if (r3 == true) goto L44;
        if (VideoThemeDownloadManager.e(r11) == true) goto L44;
        Intrinsics.checkNotNullParameter(r11, "id");
        if (VideoThemeDownloadManager.b.containsKey(r11) == true) goto L44;
        VideoThemeDownloadManager.b(r8, r11, null);
        goto L44
    L36:
        if (r11.length() != 0) goto L38;
    L44:
        return r7;
    L29:
        if (r8.length() == 0) goto L32;
        r12 = false;
    L25:
        r11 = null;
    L18:
        r8 = null;
        goto L19
    L8:
        r1 = null;
        goto L9
    }
}
