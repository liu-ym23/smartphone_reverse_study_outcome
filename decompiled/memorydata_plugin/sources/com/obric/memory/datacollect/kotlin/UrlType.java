package com.obric.memory.datacollect.kotlin;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/UrlType;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "Image", "Companion", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final enum UrlType extends Enum<UrlType> {
    private static final /* synthetic */ UrlType[] $VALUES = null;
    public static final a Companion = null;

    @SerializedName("0")
    public static final UrlType Image = null;
    private final int value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/UrlType$Companion;", "", "()V", "findByValue", "Lcom/obric/memory/datacollect/kotlin/UrlType;", "i", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final UrlType a(int r1) {
            if (r1 == 0) goto L5;
            return null;
        L5:
            return UrlType.Image;
        }
    }

    static {
        UrlType r1 = new UrlType("Image", 0, 0);
        Image = r1;
        $VALUES = new UrlType[]{r1};
        Companion = new a(null);
    }

    private UrlType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    @JvmStatic
    public static final UrlType findByValue(int r1) {
        return Companion.a(r1);
    }

    public static UrlType valueOf(String r2) {
        return (UrlType) ZeusTransformUtils.preCheckCast(Enum.valueOf(UrlType.class, r2), UrlType.class, "com.obric.memorydata.plugin");
    }

    public static UrlType[] values() {
        return (UrlType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UrlType[].class, "com.obric.memorydata.plugin");
    }

    public final int getValue() {
        return this.value;
    }
}
