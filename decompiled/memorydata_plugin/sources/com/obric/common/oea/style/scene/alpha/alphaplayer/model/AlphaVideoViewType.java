package com.obric.common.oea.style.scene.alpha.alphaplayer.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/AlphaVideoViewType;", "", "(Ljava/lang/String;I)V", "GL_TEXTURE_VIEW", "GL_SURFACE_VIEW", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum AlphaVideoViewType extends Enum<AlphaVideoViewType> {
    private static final /* synthetic */ AlphaVideoViewType[] $VALUES = null;
    public static final AlphaVideoViewType GL_SURFACE_VIEW = null;
    public static final AlphaVideoViewType GL_TEXTURE_VIEW = null;

    static {
        AlphaVideoViewType r1 = new AlphaVideoViewType("GL_TEXTURE_VIEW", 0);
        GL_TEXTURE_VIEW = r1;
        AlphaVideoViewType r2 = new AlphaVideoViewType("GL_SURFACE_VIEW", 1);
        GL_SURFACE_VIEW = r2;
        $VALUES = new AlphaVideoViewType[]{r1, r2};
    }

    private AlphaVideoViewType(String r1, int r2) {
        super(r1, r2);
    }

    public static AlphaVideoViewType valueOf(String r2) {
        return (AlphaVideoViewType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AlphaVideoViewType.class, r2), AlphaVideoViewType.class, "com.obric.memorydata.plugin");
    }

    public static AlphaVideoViewType[] values() {
        return (AlphaVideoViewType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AlphaVideoViewType[].class, "com.obric.memorydata.plugin");
    }
}
