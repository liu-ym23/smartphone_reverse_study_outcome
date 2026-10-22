package ng;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static AudioManager a;
    public static AudioFocusRequest b;
    public static final List<WeakReference<ng.a>> c = null;
    public static final a d = null;

    public static final class a implements AudioManager.OnAudioFocusChangeListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int r10) {
            if (r10 != (-3)) goto L5;
        L22:
            Iterator r11 = ((ArrayList) b.c).iterator();
        L24:
            if (r11.hasNext() == false) goto L28;
            ng.a r0 = (ng.a) ((WeakReference) r11.next()).get();
            if (r0 == null) goto L24;
            r0.b();
            goto L24
        L28:
            AudioManager r12 = b.a;
            return;
        L5:
            if (r10 == (-2)) goto L22;
            if (r10 == (-1)) goto L22;
            if (r10 != 1) goto L11;
        L15:
            Iterator r13 = ((ArrayList) b.c).iterator();
        L17:
            if (r13.hasNext() == false) goto L21;
            ng.a r1 = (ng.a) ((WeakReference) r13.next()).get();
            if (r1 == null) goto L17;
            r1.a();
            goto L17
        L21:
            AudioManager r14 = b.a;
            return;
        L11:
            if (r10 == 2) goto L15;
            if (r10 == 3) goto L15;
        }
    }

    static {
        c = new ArrayList();
        d = a.a;
    }
}
