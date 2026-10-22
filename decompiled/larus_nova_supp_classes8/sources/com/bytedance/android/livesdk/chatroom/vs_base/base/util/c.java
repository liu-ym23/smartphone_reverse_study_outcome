package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.content.ComponentName;
import android.media.AudioManager;
import androidx.media.session.MediaButtonReceiver;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bpea.entry.common.DataType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final AudioManager a = null;
    public static final ComponentName b = null;
    public static final Set<AudioManager.OnAudioFocusChangeListener> c = null;
    public static final a d = null;

    public static final class a implements AudioManager.OnAudioFocusChangeListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int r3) {
            AudioManager r1 = c.a;
            Iterator r0 = new HashSet(c.c).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((AudioManager.OnAudioFocusChangeListener) r0.next()).onAudioFocusChange(r3);
            goto L4
        }
    }

    static {
        Object r0 = s1.getContext().getSystemService(DataType.AUDIO);
        if (r0 == null) goto L7;
        a = (AudioManager) r0;
        b = new ComponentName(s1.getContext().getPackageName(), MediaButtonReceiver.class.getName());
        c = new HashSet();
        d = a.a;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }
}
