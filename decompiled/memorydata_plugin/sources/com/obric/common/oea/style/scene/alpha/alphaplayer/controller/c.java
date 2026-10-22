package com.obric.common.oea.style.scene.alpha.alphaplayer.controller;

import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7785a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f7786b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r0 = new int[AlphaVideoViewType.values().length];
        f7785a = r0;
        r0[AlphaVideoViewType.GL_SURFACE_VIEW.ordinal()] = 1;
        r0[AlphaVideoViewType.GL_TEXTURE_VIEW.ordinal()] = 2;
        int[] r1 = new int[PlayerState.values().length];
        f7786b = r1;
        r1[PlayerState.PREPARED.ordinal()] = 1;
        r1[PlayerState.PAUSED.ordinal()] = 2;
        r1[PlayerState.NOT_PREPARED.ordinal()] = 3;
        r1[PlayerState.STOPPED.ordinal()] = 4;
        int[] r2 = new int[PlayerState.values().length];
        c = r2;
        r2[PlayerState.STARTED.ordinal()] = 1;
        int[] r3 = new int[PlayerState.values().length];
        d = r3;
        r3[PlayerState.STARTED.ordinal()] = 1;
        r3[PlayerState.PAUSED.ordinal()] = 2;
    }
}
