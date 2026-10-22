package com.ss.ugc.effectplatform.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJD\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006+"}, d2 = {"Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;", "Lcom/ss/ugc/effectplatform/model/AndroidParcelable;", "uri", "", "url_list", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "getUrl_list", "()Ljava/util/List;", "setUrl_list", "(Ljava/util/List;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;", "describeContents", "equals", "", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class AuthorThumbModel implements AndroidParcelable {
    public static final Parcelable.Creator CREATOR = null;
    private Integer height;
    private String uri;
    private List<String> url_list;
    private Integer width;

    static {
        CREATOR = new a();
    }

    public AuthorThumbModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuthorThumbModel copy$default(AuthorThumbModel r0, String r1, List r2, Integer r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.uri;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.url_list;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.width;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.height;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.uri;
    }

    public final List<String> component2() {
        return this.url_list;
    }

    public final Integer component3() {
        return this.width;
    }

    public final Integer component4() {
        return this.height;
    }

    public final AuthorThumbModel copy(String r2, List<String> r3, Integer r4, Integer r5) {
        return new AuthorThumbModel(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AuthorThumbModel) == false) goto L14;
        AuthorThumbModel r4 = (AuthorThumbModel) r3;
        if (Intrinsics.areEqual(this.uri, r4.uri) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.url_list, r4.url_list) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.width, r4.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r4.height) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.uri;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.url_list;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.width;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.height;
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

    public String toString() {
        return "AuthorThumbModel(uri=" + this.uri + ", url_list=" + this.url_list + ", width=" + this.width + ", height=" + this.height + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.uri);
        r3.writeStringList(this.url_list);
        Integer r5 = this.width;
        if (r5 == null) goto L5;
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
    L6:
        Integer r6 = this.height;
        if (r6 == null) goto L9;
        r3.writeInt(1);
        r3.writeInt(r6.intValue());
        return;
    L9:
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(0);
        goto L6
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getUri() {
        return this.uri;
    }

    public final List<String> getUrl_list() {
        return this.url_list;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setHeight(Integer r1) {
        this.height = r1;
    }

    public final void setUri(String r1) {
        this.uri = r1;
    }

    public final void setUrl_list(List<String> r1) {
        this.url_list = r1;
    }

    public final void setWidth(Integer r1) {
        this.width = r1;
    }

    public AuthorThumbModel(String r1, List<String> r2, Integer r3, Integer r4) {
        this.uri = r1;
        this.url_list = r2;
        this.width = r3;
        this.height = r4;
    }

    public /* synthetic */ AuthorThumbModel(String r2, List r3, Integer r4, Integer r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
