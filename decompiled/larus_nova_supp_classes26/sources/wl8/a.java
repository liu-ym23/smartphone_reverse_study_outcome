package wl8;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.uaigc.music.ILyricsToSongBoxWrapper;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Context a;
    public final ILyricsToSongBoxWrapper b;
    public final View c;
    public Fragment d;
    public boolean e;

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r3;
        ILyricsToSongBoxWrapper r0 = (ILyricsToSongBoxWrapper) ServiceManager.get().getService(ILyricsToSongBoxWrapper.class);
        this.b = r0;
        this.c = r0.b(r3);
    }
}
