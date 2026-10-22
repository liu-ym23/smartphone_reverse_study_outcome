package com.obric.aivoice.sdk.data;

import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/aivoice/sdk/data/ModelType;", NameKeys.UnloadStrategy_No_Strategy, "typedName", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/String;ILjava/lang/String;)V", "getTypedName", "()Ljava/lang/String;", "setTypedName", "(Ljava/lang/String;)V", NameKeys.ModelType_TextEmbedding, "ImageEmbedding", NameKeys.ModelType_SlmService, "Unknown", "Companion", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ModelType extends Enum<ModelType> {
    private static final /* synthetic */ ModelType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final ModelType ImageEmbedding = null;
    public static final ModelType Slm = null;
    public static final ModelType TextEmbedding = null;
    public static final ModelType Unknown = null;
    private String typedName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aivoice/sdk/data/ModelType$Companion;", NameKeys.UnloadStrategy_No_Strategy, "()V", "fromName", "Lcom/obric/aivoice/sdk/data/ModelType;", EasyGoDbTable.Server.NAME, NameKeys.UnloadStrategy_No_Strategy, "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final ModelType fromName(String r6) {
            Intrinsics.checkNotNullParameter(r6, EasyGoDbTable.Server.NAME);
            ModelType[] r0 = ModelType.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            ModelType r3 = r0[r2];
            if (Intrinsics.areEqual(r3.getTypedName(), r6) == true) goto L12;
            r2 = r2 + 1;
            goto L3
        L12:
            return r3;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ ModelType[] $values() {
        return new ModelType[]{TextEmbedding, ImageEmbedding, Slm, Unknown};
    }

    public static ModelType valueOf(String r1) {
        return (ModelType) a.a(ModelType.class, r1);
    }

    public static ModelType[] values() {
        return (ModelType[]) $VALUES.clone();
    }

    static {
        TextEmbedding = new ModelType(NameKeys.ModelType_TextEmbedding, 0, NameKeys.ModelType_TextEmbedding);
        ImageEmbedding = new ModelType("ImageEmbedding", 1, NameKeys.ModelType_ImgEmbedding);
        Slm = new ModelType(NameKeys.ModelType_SlmService, 2, NameKeys.ModelType_SlmService);
        Unknown = new ModelType("Unknown", 3, NameKeys.UnloadStrategy_No_Strategy);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getTypedName() {
        return this.typedName;
    }

    public final void setTypedName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.typedName = r2;
    }

    private ModelType(String r1, int r2, String r3) {
        super(r1, r2);
        this.typedName = r3;
    }
}
