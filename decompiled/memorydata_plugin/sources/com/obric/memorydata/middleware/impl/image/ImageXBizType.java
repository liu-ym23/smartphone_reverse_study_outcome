package com.obric.memorydata.middleware.impl.image;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXBizType;", "", "<init>", "(Ljava/lang/String;I)V", "RECOMMENDER", "DOUBAO", "O_ASSISTANT_FEEDBACK", "O_ASSISTANT_FEEDBACK_FILE", "AUDITORY_MEMORY_FILE", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ImageXBizType extends Enum<ImageXBizType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ImageXBizType[] $VALUES = null;
    public static final ImageXBizType AUDITORY_MEMORY_FILE = null;
    public static final ImageXBizType DOUBAO = null;
    public static final ImageXBizType O_ASSISTANT_FEEDBACK = null;
    public static final ImageXBizType O_ASSISTANT_FEEDBACK_FILE = null;
    public static final ImageXBizType RECOMMENDER = null;

    private static final /* synthetic */ ImageXBizType[] $values() {
        return new ImageXBizType[]{RECOMMENDER, DOUBAO, O_ASSISTANT_FEEDBACK, O_ASSISTANT_FEEDBACK_FILE, AUDITORY_MEMORY_FILE};
    }

    static {
        RECOMMENDER = new ImageXBizType("RECOMMENDER", 0);
        DOUBAO = new ImageXBizType("DOUBAO", 1);
        O_ASSISTANT_FEEDBACK = new ImageXBizType("O_ASSISTANT_FEEDBACK", 2);
        O_ASSISTANT_FEEDBACK_FILE = new ImageXBizType("O_ASSISTANT_FEEDBACK_FILE", 3);
        AUDITORY_MEMORY_FILE = new ImageXBizType("AUDITORY_MEMORY_FILE", 4);
        ImageXBizType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ImageXBizType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ImageXBizType> getEntries() {
        return $ENTRIES;
    }

    public static ImageXBizType valueOf(String r2) {
        return (ImageXBizType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ImageXBizType.class, r2), ImageXBizType.class, "com.obric.memorydata.plugin");
    }

    public static ImageXBizType[] values() {
        return (ImageXBizType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ImageXBizType[].class, "com.obric.memorydata.plugin");
    }
}
