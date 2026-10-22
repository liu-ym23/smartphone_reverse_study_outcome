package tv8;

import android.content.DialogInterface;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.business.debug.base.audio.module.AudioDebugUtil;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.q3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;

    public /* synthetic */ f(String r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        String r6 = this.a;
        if (r6 != null) goto L6;
    L20:
        r4.dismiss();
        return;
    L6:
        if (AudioDebugUtil.c == false) goto L20;
        Intrinsics.checkNotNullParameter(r6, MusicAppletPage.KEY_PATH);
        if (AudioDebugUtil.m != null) goto L11;
        AudioDebugUtil.m = q3.b("audio_debug", null, 6);
    L11:
        IVideoController r0 = AudioDebugUtil.m;
        if (r0 == null) goto L14;
        r0.stop();
    L14:
        IVideoController r1 = AudioDebugUtil.m;
        if (r1 == null) goto L17;
        r1.setLocalURL(r6);
    L17:
        IVideoController r7 = AudioDebugUtil.m;
        if (r7 == null) goto L20;
        r7.play();
        goto L20
    }
}
