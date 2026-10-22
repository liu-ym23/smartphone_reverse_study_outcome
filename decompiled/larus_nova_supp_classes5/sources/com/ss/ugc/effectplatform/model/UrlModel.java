package com.ss.ugc.effectplatform.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B9\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\bHÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/ss/ugc/effectplatform/model/UrlModel;", "Lcom/ss/ugc/effectplatform/model/AndroidParcelable;", "url_list", "", "", "uri", DBDefinition.MD5, "url_type", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getMd5", "()Ljava/lang/String;", "setMd5", "(Ljava/lang/String;)V", "getUri", "setUri", "getUrl_list", "()Ljava/util/List;", "setUrl_list", "(Ljava/util/List;)V", "getUrl_type", "()Ljava/lang/Integer;", "setUrl_type", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "describeContents", "equals", "", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class UrlModel implements AndroidParcelable {
    public static final Parcelable.Creator CREATOR = null;
    private String md5;
    private String uri;
    private List<String> url_list;
    private Integer url_type;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r6) {
            ArrayList<String> r1 = r6.createStringArrayList();
            String r2 = r6.readString();
            String r3 = r6.readString();
            if (r6.readInt() == 0) goto L5;
            Integer r7 = Integer.valueOf(r6.readInt());
        L7:
            return new UrlModel(r1, r2, r3, r7);
        L5:
            r7 = null;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r1) {
            return new UrlModel[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public UrlModel() {
        this(null, null, null, null, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeStringList(this.url_list);
        r2.writeString(this.uri);
        r2.writeString(this.md5);
        Integer r4 = this.url_type;
        if (r4 == null) goto L5;
        r2.writeInt(1);
        int r5 = r4.intValue();
    L6:
        r2.writeInt(r5);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public String toString() {
        return "UrlModel(url_list=" + getUrl_list() + ", uri=" + getUri() + ')';
    }

    public int hashCode() {
        List<String> r0 = getUrl_list();
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.hashCode());
    L6:
        int r2 = r1.intValue() * 31;
        String r3 = getUri();
        int r4 = 0;
        if (r3 == null) goto L9;
        int r5 = r3.hashCode();
    L10:
        int r6 = (r2 + r5) * 31;
        String r7 = getMd5();
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = getUrl_type();
        if (r10 == null) goto L18;
        r4 = r10.hashCode();
    L18:
        return r9 + r4;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public String getMd5() {
        return this.md5;
    }

    public String getUri() {
        return this.uri;
    }

    public List<String> getUrl_list() {
        return this.url_list;
    }

    public Integer getUrl_type() {
        return this.url_type;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UrlModel) == true) goto L8;
        return false;
    L8:
        UrlModel r6 = (UrlModel) r5;
        if ((!Intrinsics.areEqual(getUrl_list(), r6.getUrl_list())) == false) goto L12;
        return false;
    L12:
        if ((!Intrinsics.areEqual(getUri(), r6.getUri())) == false) goto L15;
        return false;
    L15:
        if ((!Intrinsics.areEqual(getMd5(), r6.getMd5())) == false) goto L18;
        return false;
    L18:
        if ((!Intrinsics.areEqual(getUrl_type(), r6.getUrl_type())) == false) goto L20;
        return false;
    L20:
        return true;
    }

    public void setMd5(String r1) {
        this.md5 = r1;
    }

    public void setUri(String r1) {
        this.uri = r1;
    }

    public void setUrl_list(List<String> r1) {
        this.url_list = r1;
    }

    public void setUrl_type(Integer r1) {
        this.url_type = r1;
    }

    public UrlModel(List<String> r1, String r2, String r3, Integer r4) {
        this.url_list = r1;
        this.uri = r2;
        this.md5 = r3;
        this.url_type = r4;
    }

    public /* synthetic */ UrlModel(List r2, String r3, String r4, Integer r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = new ArrayList();
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
