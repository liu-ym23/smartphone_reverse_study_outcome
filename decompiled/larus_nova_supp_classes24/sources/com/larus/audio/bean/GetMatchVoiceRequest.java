package com.larus.audio.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003JO\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0006\u0010(\u001a\u00020)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020)HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020)R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00065"}, d2 = {"Lcom/larus/audio/bean/GetMatchVoiceRequest;", "Landroid/os/Parcelable;", "botName", "", "botDesc", "voiceId", "botId", "botModelType", "", "languageCode", "scene", "Lcom/larus/audio/bean/RecommendScene;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/larus/audio/bean/RecommendScene;)V", "getBotName", "()Ljava/lang/String;", "setBotName", "(Ljava/lang/String;)V", "getBotDesc", "setBotDesc", "getVoiceId", "setVoiceId", "getBotId", "setBotId", "getBotModelType", "()J", "setBotModelType", "(J)V", "getLanguageCode", "setLanguageCode", "getScene", "()Lcom/larus/audio/bean/RecommendScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class GetMatchVoiceRequest implements Parcelable {
    public static final Parcelable.Creator<GetMatchVoiceRequest> CREATOR = null;
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public String f;
    public final RecommendScene g;

    public static final class a implements Parcelable.Creator<GetMatchVoiceRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GetMatchVoiceRequest createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            return new GetMatchVoiceRequest(r11.readString(), r11.readString(), r11.readString(), r11.readString(), r11.readLong(), r11.readString(), RecommendScene.valueOf(r11.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final GetMatchVoiceRequest[] newArray(int r1) {
            return new GetMatchVoiceRequest[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public GetMatchVoiceRequest() {
        this(null, null, null, null, 0, null, null, 127);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof GetMatchVoiceRequest) == true) goto L8;
        return false;
    L8:
        GetMatchVoiceRequest r9 = (GetMatchVoiceRequest) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r1 = this.e;
        return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "GetMatchVoiceRequest(botName=" + this.a + ", botDesc=" + this.b + ", voiceId=" + this.c + ", botId=" + this.d + ", botModelType=" + this.e + ", languageCode=" + this.f + ", scene=" + this.g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeString(this.c);
        r3.writeString(this.d);
        r3.writeLong(this.e);
        r3.writeString(this.f);
        r3.writeString(this.g.name());
    }

    public GetMatchVoiceRequest(String r2, String r3, String r4, String r5, long r6, String r8, RecommendScene r9) {
        Intrinsics.checkNotNullParameter(r2, "botName");
        Intrinsics.checkNotNullParameter(r3, "botDesc");
        Intrinsics.checkNotNullParameter(r4, "voiceId");
        Intrinsics.checkNotNullParameter(r5, "botId");
        Intrinsics.checkNotNullParameter(r8, "languageCode");
        Intrinsics.checkNotNullParameter(r9, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
    }

    public /* synthetic */ GetMatchVoiceRequest(String r9, String r10, String r11, String r12, long r13, String r15, RecommendScene r16, int r17) {
        String r1 = "";
        if ((r17 & 1) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r2 = "";
    L11:
        if ((r17 & 4) == 0) goto L13;
        String r3 = "";
    L15:
        if ((r17 & 8) == 0) goto L17;
        String r4 = "";
    L19:
        if ((r17 & 16) == 0) goto L21;
        long r5 = 0;
    L23:
        if ((r17 & 32) != 0) goto L27;
        r1 = r15;
    L27:
        if ((r17 & 64) == 0) goto L29;
        RecommendScene r7 = RecommendScene.NULL;
    L30:
        this(r0, r2, r3, r4, r5, r1, r7);
        return;
    L29:
        r7 = r16;
        goto L30
    L21:
        r5 = r13;
        goto L23
    L17:
        r4 = r12;
        goto L19
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L11
    L5:
        r0 = r9;
        goto L7
    }
}
