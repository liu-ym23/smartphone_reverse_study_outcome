package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface ITextPieceImage extends vh7.c<ITextPieceImage> {

    public static final enum ExtraOpt extends Enum<ExtraOpt> {
        public static final ExtraOpt NONE = null;
        public static final ExtraOpt OTHER = null;
        public static final /* synthetic */ ExtraOpt[] a = null;

        static {
            ExtraOpt r0 = new ExtraOpt("NONE", 0);
            NONE = r0;
            ExtraOpt r1 = new ExtraOpt("OTHER", 1);
            OTHER = r1;
            a = new ExtraOpt[]{r0, r1};
        }

        public static ExtraOpt[] values() {
            return (ExtraOpt[]) a.clone();
        }

        public static ExtraOpt valueOf(String r1) {
            return (ExtraOpt) r27.a.a(ExtraOpt.class, r1);
        }

        public ExtraOpt(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum ResourceType extends Enum<ResourceType> {
        public static final ResourceType Local = null;
        public static final ResourceType NetWork = null;
        public static final /* synthetic */ ResourceType[] a = null;

        static {
            ResourceType r0 = new ResourceType("Local", 0);
            Local = r0;
            ResourceType r1 = new ResourceType("NetWork", 1);
            NetWork = r1;
            a = new ResourceType[]{r0, r1};
        }

        public static ResourceType[] values() {
            return (ResourceType[]) a.clone();
        }

        public static ResourceType valueOf(String r1) {
            return (ResourceType) r27.a.a(ResourceType.class, r1);
        }

        public ResourceType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum ScaleType extends Enum<ScaleType> {
        public static final ScaleType DEFAULT = null;
        public static final ScaleType FIT_TEXT_SIZE = null;
        public static final ScaleType FIT_TEXT_SIZE_CENTER_CANVAS = null;
        public static final ScaleType FIT_Y = null;
        public static final /* synthetic */ ScaleType[] a = null;

        static {
            ScaleType r0 = new ScaleType("DEFAULT", 0);
            DEFAULT = r0;
            ScaleType r1 = new ScaleType("FIT_Y", 1);
            FIT_Y = r1;
            ScaleType r3 = new ScaleType("FIT_TEXT_SIZE", 2);
            FIT_TEXT_SIZE = r3;
            ScaleType r5 = new ScaleType("FIT_TEXT_SIZE_CENTER_CANVAS", 3);
            FIT_TEXT_SIZE_CENTER_CANVAS = r5;
            a = new ScaleType[]{r0, r1, r3, r5};
        }

        public static ScaleType[] values() {
            return (ScaleType[]) a.clone();
        }

        public static ScaleType valueOf(String r1) {
            return (ScaleType) r27.a.a(ScaleType.class, r1);
        }

        public ScaleType(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    ITextPieceImage doClone();

    boolean getEnableTextWhenFailed();

    ExtraOpt getExtraOpt();

    int getHeight();

    py.k getImageModel();

    int getLocalResId();

    ResourceType getResourceType();

    ScaleType getScaleType();

    float getScaleX();

    float getScaleY();

    float getScalingRate();

    int getWidth();

    boolean isNeedExtraSpace();

    void setEnableTextWhenFailed(boolean r1);

    void setExtraOpt(ExtraOpt r1);

    void setHeight(int r1);

    void setImageModel(py.k r1);

    void setLocalResId(int r1);

    void setNeedExtraSpace(boolean r1);

    void setResourceType(ResourceType r1);

    void setScaleType(ScaleType r1);

    void setScaleX(float r1);

    void setScaleY(float r1);

    void setScalingRate(float r1);

    void setWidth(int r1);
}
