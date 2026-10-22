package xz9;

import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.larus.common_ui.widget.CircleProgressBar;
import com.larus.uaigc.music.widget.LyricsToSongTemplatePlayerView;
import com.larus.utils.e1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ LyricsToSongTemplatePlayerView a;

    public /* synthetic */ i(LyricsToSongTemplatePlayerView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LyricsToSongTemplatePlayerView r0 = this.a;
        ImageView r1 = r0.c;
        if (r1 == null) goto L5;
        r1.setImageDrawable(ResourcesCompat.getDrawable(r0.getResources(), 2131243095, null));
    L5:
        ImageView r2 = r0.c;
        if (r2 == null) goto L8;
        e1.x(r2);
    L8:
        ImageView r3 = r0.d;
        if (r3 == null) goto L11;
        e1.q(r3);
    L11:
        CircleProgressBar r4 = r0.b;
        if (r4 == null) goto L15;
        e1.q(r4);
        return;
    }
}
