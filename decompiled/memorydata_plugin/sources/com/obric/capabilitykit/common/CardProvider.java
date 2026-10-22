package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/obric/capabilitykit/common/CardProvider;", "Landroid/os/Parcelable;", "cardUri", "", "viewHeight", "", "title", "extraParams", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCardUri", "()Ljava/lang/String;", "setCardUri", "(Ljava/lang/String;)V", "getExtraParams", "setExtraParams", "getTitle", "setTitle", "getViewHeight", "()Ljava/lang/Integer;", "setViewHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "describeContents", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardProvider implements Parcelable {
    public static final a CREATOR = null;
    private String cardUri;
    private String extraParams;
    private String title;
    private Integer viewHeight;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/common/CardProvider$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/common/CardProvider;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/common/CardProvider;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<CardProvider> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public CardProvider a(Parcel r6) {
            int r5 = r6.readInt();
            Intrinsics.checkNotNullParameter(r6, "parcel");
            String r1 = r6.readString();
            Object r2 = r6.readValue(Integer.TYPE.getClassLoader());
            if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L5;
            Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin");
        L6:
            CardProvider r0 = new CardProvider(r1, r3, r6.readString(), r6.readString());
            int r4 = Math.min(r5, 0);
            ClassLoader r7 = a.class.getClassLoader();
            int r8 = 1;
        L7:
            if (r8 > r4) goto L9;
            r8 = r8 + 1;
        L9:
            if (r8 > r5) goto L11;
            com.obric.b.a.a(r6, r7);
            r8 = r8 + 1;
            goto L9
        L11:
            return r0;
        L5:
            r3 = null;
            goto L6
        }

        public CardProvider[] a(int r1) {
            return new CardProvider[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CardProvider createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CardProvider[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public CardProvider() {
        this(null, null, null, null, 15, null);
    }

    public CardProvider(String r1, Integer r2, String r3, String r4) {
        this.cardUri = r1;
        this.viewHeight = r2;
        this.title = r3;
        this.extraParams = r4;
    }

    public /* synthetic */ CardProvider(String r2, Integer r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getCardUri() {
        return this.cardUri;
    }

    public final String getExtraParams() {
        return this.extraParams;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getViewHeight() {
        return this.viewHeight;
    }

    public final void setCardUri(String r1) {
        this.cardUri = r1;
    }

    public final void setExtraParams(String r1) {
        this.extraParams = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setViewHeight(Integer r1) {
        this.viewHeight = r1;
    }

    public String toString() {
        return "CardProvider(cardUri=" + this.cardUri + ", viewHeight=" + this.viewHeight + ", title=" + this.title + ", extraParams=" + this.extraParams + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.cardUri);
        r1.writeValue(this.viewHeight);
        r1.writeString(this.title);
        r1.writeString(this.extraParams);
    }
}
