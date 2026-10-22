package com.larus.bmhome.music.player;

import android.media.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a1 implements e {
    public List<WeakReference<e>> a;

    public a1() {
        this.a = new ArrayList();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer r5) {
        List<WeakReference<e>> r0 = this.a;
        ArrayList r1 = new ArrayList();
        Iterator r2 = CollectionsKt.toList(r0).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        WeakReference r3 = (WeakReference) r2.next();
        e r4 = (e) r3.get();
        if (r4 == null) goto L4;
        r4.onCompletion(r5);
        r1.add(r3);
        goto L4
    L8:
        this.a = r1;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer r5) {
        List<WeakReference<e>> r0 = this.a;
        ArrayList r1 = new ArrayList();
        Iterator r2 = CollectionsKt.toList(r0).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        WeakReference r3 = (WeakReference) r2.next();
        e r4 = (e) r3.get();
        if (r4 == null) goto L4;
        r4.onPrepared(r5);
        r1.add(r3);
        goto L4
    L8:
        this.a = r1;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer r5, int r6, int r7) {
        List<WeakReference<e>> r0 = this.a;
        ArrayList r1 = new ArrayList();
        Iterator r2 = CollectionsKt.toList(r0).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        WeakReference r3 = (WeakReference) r2.next();
        e r4 = (e) r3.get();
        if (r4 == null) goto L4;
        r4.onError(r5, r6, r7);
        r1.add(r3);
        goto L4
    L8:
        this.a = r1;
        return false;
    }
}
