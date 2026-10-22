package com.ss.ugc.effectplatform.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/ss/ugc/effectplatform/model/RankingEffectModel;", "Lcom/ss/ugc/effectplatform/model/AndroidParcelable;", "category_key", "", "category_name", "ranking", "", "ranking_url", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "getCategory_key", "()Ljava/lang/String;", "setCategory_key", "(Ljava/lang/String;)V", "getCategory_name", "setCategory_name", "getRanking", "()Ljava/lang/Integer;", "setRanking", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRanking_url", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setRanking_url", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "describeContents", "equals", "", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "", "hashCode", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class RankingEffectModel implements AndroidParcelable {
    public static final Parcelable.Creator CREATOR = null;
    private String category_key;
    private String category_name;
    private Integer ranking;
    private UrlModel ranking_url;

    static {
        CREATOR = new a();
    }

    public RankingEffectModel() {
        this(null, null, null, null, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.category_key);
        r3.writeString(this.category_name);
        Integer r0 = this.ranking;
        if (r0 == null) goto L5;
        r3.writeInt(1);
        int r1 = r0.intValue();
    L6:
        r3.writeInt(r1);
        r3.writeParcelable(this.ranking_url, r4);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public int hashCode() {
        String r0 = getCategory_key();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = getCategory_name();
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = getRanking();
        if (r7 == null) goto L13;
        int r8 = r7.intValue();
    L14:
        int r9 = (r6 + r8) * 31;
        UrlModel r10 = getRanking_url();
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String getCategory_key() {
        return this.category_key;
    }

    public String getCategory_name() {
        return this.category_name;
    }

    public Integer getRanking() {
        return this.ranking;
    }

    public UrlModel getRanking_url() {
        return this.ranking_url;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L23:
        return false;
    L8:
        if ((!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(getClass()), Reflection.getOrCreateKotlinClass(r5.getClass()))) == true) goto L23;
        RankingEffectModel r6 = (RankingEffectModel) r5;
        if ((!Intrinsics.areEqual(getCategory_key(), r6.getCategory_key())) == false) goto L14;
        return false;
    L14:
        if ((!Intrinsics.areEqual(getCategory_name(), r6.getCategory_name())) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(getRanking(), r6.getRanking())) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(getRanking_url(), r6.getRanking_url())) == false) goto L22;
        return false;
    L22:
        return true;
    }

    public void setCategory_key(String r1) {
        this.category_key = r1;
    }

    public void setCategory_name(String r1) {
        this.category_name = r1;
    }

    public void setRanking(Integer r1) {
        this.ranking = r1;
    }

    public void setRanking_url(UrlModel r1) {
        this.ranking_url = r1;
    }

    public RankingEffectModel(String r1, String r2, Integer r3, UrlModel r4) {
        this.category_key = r1;
        this.category_name = r2;
        this.ranking = r3;
        this.ranking_url = r4;
    }

    public /* synthetic */ RankingEffectModel(String r8, String r9, Integer r10, UrlModel r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r8 = "";
    L6:
        if ((r12 & 2) == 0) goto L9;
        r9 = "";
    L9:
        if ((r12 & 4) == 0) goto L12;
        r10 = 0;
    L12:
        if ((r12 & 8) == 0) goto L14;
        r11 = new UrlModel(null, null, null, null, 15, null);
    L14:
        this(r8, r9, r10, r11);
    }
}
