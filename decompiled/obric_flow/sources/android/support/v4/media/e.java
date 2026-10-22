package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserProtocol;

/* JADX INFO: loaded from: classes.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaBrowser f369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f370c;
    public final a d;
    public final ArrayMap e;
    public s6.c f;
    public Messenger g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MediaSessionCompat$Token f371h;

    public e(Context r5, ComponentName r10, d r11) {
        this.d = new a(this);
        this.e = new ArrayMap();
        this.f368a = r5;
        Bundle r12 = new Bundle();
        this.f370c = r12;
        r12.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
        r11.setInternalConnectionCallback(this);
        this.f369b = new MediaBrowser(r5, r10, (MediaBrowser.ConnectionCallback) r11.mConnectionCallbackObj, r12);
    }
}
