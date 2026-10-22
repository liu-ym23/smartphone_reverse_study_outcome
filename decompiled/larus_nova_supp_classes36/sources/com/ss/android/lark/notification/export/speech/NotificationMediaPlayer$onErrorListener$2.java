package com.ss.android.lark.notification.export.speech;

import android.media.MediaPlayer;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/media/MediaPlayer$OnErrorListener;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class NotificationMediaPlayer$onErrorListener$2 extends Lambda implements Function0<MediaPlayer.OnErrorListener> {
    final /* synthetic */ NotificationMediaPlayer this$0;

    public static final class a implements MediaPlayer.OnErrorListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer r1, int r2, int r3) {
            int r4 = NotificationMediaPlayer.a;
            throw null;
        }
    }

    public NotificationMediaPlayer$onErrorListener$2(NotificationMediaPlayer r1) {
        super(0);
    }

    public final MediaPlayer.OnErrorListener invoke() {
        return new a();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1517invoke() {
        return invoke();
    }
}
