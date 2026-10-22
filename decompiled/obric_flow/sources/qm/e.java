package qm;

import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterator f21531b;

    public e(ReadableCompactArrayBuffer r5) {
        this.f21530a = 0;
        this.f21531b = new b(r5);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch(this.f21530a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.f21531b.hasNext();
    L7:
        return ((b) this.f21531b).hasNext();
    L9:
        return ((b) this.f21531b).hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch(this.f21530a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return new kn.c((Map.Entry) this.f21531b.next());
    L7:
        return (c) ((b) this.f21531b).next();
    L9:
        return (c) ((b) this.f21531b).next();
    }

    public e(ReadableMapBuffer r5) {
        this.f21530a = 1;
        this.f21531b = new b(r5);
    }

    public e(Iterator r5) {
        this.f21530a = 2;
        this.f21531b = r5;
    }
}
