package oja;

import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r0 = new int[AlphaVideoViewType.values().length];
        a = r0;
        r0[AlphaVideoViewType.GL_SURFACE_VIEW.ordinal()] = 1;
        r0[AlphaVideoViewType.GL_TEXTURE_VIEW.ordinal()] = 2;
        int[] r1 = new int[PlayerState.values().length];
        b = r1;
        r1[PlayerState.PREPARED.ordinal()] = 1;
        PlayerState r2 = PlayerState.PAUSED;
        r1[r2.ordinal()] = 2;
        r1[PlayerState.NOT_PREPARED.ordinal()] = 3;
        r1[PlayerState.STOPPED.ordinal()] = 4;
        int[] r3 = new int[PlayerState.values().length];
        c = r3;
        PlayerState r4 = PlayerState.STARTED;
        r3[r4.ordinal()] = 1;
        int[] r5 = new int[PlayerState.values().length];
        d = r5;
        r5[r4.ordinal()] = 1;
        r5[r2.ordinal()] = 2;
    }
}
