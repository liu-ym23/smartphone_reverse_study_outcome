package p58;

import com.larus.audio.audiov3.audio.player.AudioPlayerState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public /* synthetic */ class a$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AudioPlayerState.values().length];
        r0[AudioPlayerState.STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[AudioPlayerState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
