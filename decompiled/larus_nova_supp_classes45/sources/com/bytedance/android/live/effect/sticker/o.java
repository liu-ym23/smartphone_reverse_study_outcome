package com.bytedance.android.live.effect.sticker;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001R2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010(\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\"\u0010+\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010 \u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\"\u0010.\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010 \u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$¨\u00061"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/o;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "alg", "Ljava/util/ArrayList;", "getAlg", "()Ljava/util/ArrayList;", "setAlg", "(Ljava/util/ArrayList;)V", "relation", "Ljava/lang/String;", "getRelation", "()Ljava/lang/String;", "setRelation", "(Ljava/lang/String;)V", "imgK", "getImgK", "setImgK", "", "loading", "Z", "getLoading", "()Z", "setLoading", "(Z)V", "guide", "getGuide", "setGuide", "", "albumFilter", "I", "getAlbumFilter", "()I", "setAlbumFilter", "(I)V", "faceCountMin", "getFaceCountMin", "setFaceCountMin", "faceCountMax", "getFaceCountMax", "setFaceCountMax", "minCount", "getMinCount", "setMinCount", "maxCount", "getMaxCount", "setMaxCount", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("albumFilter")
    private int albumFilter;

    @SerializedName("alg")
    private ArrayList<String> alg;

    @SerializedName("face_count_max")
    private int faceCountMax;

    @SerializedName("face_count_min")
    private int faceCountMin;

    @SerializedName("guide")
    private boolean guide;

    @SerializedName("imgK")
    private String imgK;

    @SerializedName("loading")
    private boolean loading;

    @SerializedName("max_count")
    private int maxCount;

    @SerializedName("min_count")
    private int minCount;

    @SerializedName("relation")
    private String relation;

    public o() {
        ArrayList<String> r0 = new ArrayList();
        Intrinsics.checkNotNullParameter(r0, "alg");
        this.alg = r0;
        this.relation = null;
        this.imgK = null;
        this.loading = true;
        this.guide = true;
        this.albumFilter = 0;
        this.faceCountMin = 2;
        this.faceCountMax = 5;
        this.minCount = -1;
        this.maxCount = -1;
    }
}
