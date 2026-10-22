package com.larus.bmhome.nestedfile;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003JP\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006*"}, d2 = {"Lcom/larus/bmhome/nestedfile/EntityState;", "Ljava/io/Serializable;", "fileIdentifier", "", "updateFields", "", "", "reviewState", "parseState", "audioDetailUrl", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getFileIdentifier", "()Ljava/lang/String;", "setFileIdentifier", "(Ljava/lang/String;)V", "getUpdateFields", "()Ljava/util/List;", "setUpdateFields", "(Ljava/util/List;)V", "getReviewState", "()Ljava/lang/Integer;", "setReviewState", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getParseState", "setParseState", "getAudioDetailUrl", "setAudioDetailUrl", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/bmhome/nestedfile/EntityState;", "equals", "", "other", "", "hashCode", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntityState implements Serializable {

    @SerializedName("audio_detail_url")
    private String audioDetailUrl;

    @SerializedName("identifier")
    private String fileIdentifier;

    @SerializedName("parse_state")
    private Integer parseState;

    @SerializedName("review_state")
    private Integer reviewState;

    @SerializedName("update_fields")
    private List<Integer> updateFields;

    public EntityState() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntityState copy$default(EntityState r3, String r4, List r5, Integer r6, Integer r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.fileIdentifier;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.updateFields;
    L8:
        List r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.reviewState;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.parseState;
    L14:
        Integer r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.audioDetailUrl;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.fileIdentifier;
    }

    public final List<Integer> component2() {
        return this.updateFields;
    }

    public final Integer component3() {
        return this.reviewState;
    }

    public final Integer component4() {
        return this.parseState;
    }

    public final String component5() {
        return this.audioDetailUrl;
    }

    public final EntityState copy(String r8, List<Integer> r9, Integer r10, Integer r11, String r12) {
        return new EntityState(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EntityState) == true) goto L8;
        return false;
    L8:
        EntityState r6 = (EntityState) r5;
        if (Intrinsics.areEqual(this.fileIdentifier, r6.fileIdentifier) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.updateFields, r6.updateFields) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.reviewState, r6.reviewState) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.parseState, r6.parseState) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.audioDetailUrl, r6.audioDetailUrl) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.fileIdentifier;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<Integer> r4 = this.updateFields;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.reviewState;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.parseState;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.audioDetailUrl;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(new Gson().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        if (r2 != null) goto L15;
        return "";
    L15:
        return r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final String getAudioDetailUrl() {
        return this.audioDetailUrl;
    }

    public final String getFileIdentifier() {
        return this.fileIdentifier;
    }

    public final Integer getParseState() {
        return this.parseState;
    }

    public final Integer getReviewState() {
        return this.reviewState;
    }

    public final List<Integer> getUpdateFields() {
        return this.updateFields;
    }

    public final void setAudioDetailUrl(String r1) {
        this.audioDetailUrl = r1;
    }

    public final void setFileIdentifier(String r1) {
        this.fileIdentifier = r1;
    }

    public final void setParseState(Integer r1) {
        this.parseState = r1;
    }

    public final void setReviewState(Integer r1) {
        this.reviewState = r1;
    }

    public final void setUpdateFields(List<Integer> r1) {
        this.updateFields = r1;
    }

    public EntityState(String r1, List<Integer> r2, Integer r3, Integer r4, String r5) {
        this.fileIdentifier = r1;
        this.updateFields = r2;
        this.reviewState = r3;
        this.parseState = r4;
        this.audioDetailUrl = r5;
    }

    public /* synthetic */ EntityState(String r5, List r6, Integer r7, Integer r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        List r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        Integer r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        Integer r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        String r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
