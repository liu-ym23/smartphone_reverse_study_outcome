package com.obric.common.oea.style.scene.alpha.alphaplayer.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/AlphaVideoViewType;", "", "GL_TEXTURE_VIEW", "GL_SURFACE_VIEW", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum AlphaVideoViewType extends Enum<AlphaVideoViewType> {
    public static final AlphaVideoViewType GL_SURFACE_VIEW = null;
    public static final AlphaVideoViewType GL_TEXTURE_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlphaVideoViewType[] f11350a = null;

    static {
        AlphaVideoViewType r5 = new AlphaVideoViewType("GL_TEXTURE_VIEW", 0);
        GL_TEXTURE_VIEW = r5;
        AlphaVideoViewType r10 = new AlphaVideoViewType("GL_SURFACE_VIEW", 1);
        GL_SURFACE_VIEW = r10;
        f11350a = new AlphaVideoViewType[]{r5, r10};
    }

    public static AlphaVideoViewType valueOf(String r5) {
        return (AlphaVideoViewType) Enum.valueOf(AlphaVideoViewType.class, r5);
    }

    public static AlphaVideoViewType[] values() {
        return (AlphaVideoViewType[]) f11350a.clone();
    }
}
