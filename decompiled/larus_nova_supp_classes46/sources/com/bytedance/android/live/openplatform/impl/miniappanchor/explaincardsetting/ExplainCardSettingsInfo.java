package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.livesdk.utils.r2;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001:\u0001!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000eR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001a¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardSettingsInfo;", "Landroid/os/Parcelable;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "shelfMicroAppInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "g", "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "shelfCardInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "", "homePath", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "isShelf", "Z", "i", "()Z", "isEdit", "h", "", "mountType", "I", "e", "()I", "openExtra", "getOpenExtra", "mpLiveChannel", "getMpLiveChannel", "cardPosition", "c", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainCardSettingsInfo implements Parcelable {
    public static final Parcelable.Creator<ExplainCardSettingsInfo> CREATOR = null;

    @SerializedName("card_position")
    private final int cardPosition;

    @SerializedName("homePath")
    private final String homePath;

    @SerializedName("isEdit")
    private final boolean isEdit;

    @SerializedName("isShelf")
    private final boolean isShelf;

    @SerializedName("mountType")
    private final int mountType;

    @SerializedName("mp_live_channel")
    private final String mpLiveChannel;

    @SerializedName("openExtra")
    private final String openExtra;

    @SerializedName("shelfCardInfo")
    public final ShelfCardInfo shelfCardInfo;

    @SerializedName("shelfMicroAppInfo")
    private final ShelfMicroAppInfo shelfMicroAppInfo;

    public static final class a {
    }

    public static class b implements Parcelable.Creator<ExplainCardSettingsInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ExplainCardSettingsInfo createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "in");
            ShelfMicroAppInfo r2 = (ShelfMicroAppInfo) r12.readParcelable(ExplainCardSettingsInfo.class.getClassLoader());
            ShelfCardInfo r3 = (ShelfCardInfo) r12.readParcelable(ExplainCardSettingsInfo.class.getClassLoader());
            String r4 = r12.readString();
            boolean r6 = false;
            if (r12.readInt() == 0) goto L5;
            boolean r7 = true;
        L7:
            if (r12.readInt() == 0) goto L9;
            r6 = true;
        L9:
            boolean r5 = r7;
            return new ExplainCardSettingsInfo(r2, r3, r4, r5, r6, r12.readInt(), r12.readString(), r12.readString(), r12.readInt());
        L5:
            r7 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ExplainCardSettingsInfo[] newArray(int r1) {
            return new ExplainCardSettingsInfo[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    public ExplainCardSettingsInfo() {
        this(null, null, null, false, false, 0, null, null, 0, 511);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ExplainCardSettingsInfo) == false) goto L24;
        ExplainCardSettingsInfo r4 = (ExplainCardSettingsInfo) r3;
        if (Intrinsics.areEqual(this.shelfMicroAppInfo, r4.shelfMicroAppInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shelfCardInfo, r4.shelfCardInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.homePath, r4.homePath) == true) goto L12;
        return false;
    L12:
        if (this.isShelf == r4.isShelf) goto L14;
        return false;
    L14:
        if (this.isEdit == r4.isEdit) goto L16;
        return false;
    L16:
        if (this.mountType == r4.mountType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.openExtra, r4.openExtra) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.mpLiveChannel, r4.mpLiveChannel) == true) goto L22;
        return false;
    L22:
        if (this.cardPosition == r4.cardPosition) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        ShelfMicroAppInfo r0 = this.shelfMicroAppInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ShelfCardInfo r4 = this.shelfCardInfo;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.homePath;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.isShelf;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L17;
        r12 = 1;
    L17:
        int r13 = (r9 + r12) * 31;
        boolean r14 = this.isEdit;
        if (r14 == true) goto L21;
        r11 = r14;
    L21:
        int r15 = (((r13 + r11) * 31) + this.mountType) * 31;
        String r16 = this.openExtra;
        if (r16 == null) goto L24;
        int r17 = r16.hashCode();
    L25:
        int r18 = (r15 + r17) * 31;
        String r19 = this.mpLiveChannel;
        if (r19 == null) goto L29;
        r1 = r19.hashCode();
    L29:
        return ((r18 + r1) * 31) + this.cardPosition;
    L24:
        r17 = 0;
        goto L25
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

    public final String toString() {
        return "ExplainCardSettingsInfo(shelfMicroAppInfo=" + this.shelfMicroAppInfo + ", shelfCardInfo=" + this.shelfCardInfo + ", homePath=" + this.homePath + ", isShelf=" + this.isShelf + ", isEdit=" + this.isEdit + ", mountType=" + this.mountType + ", openExtra=" + this.openExtra + ", mpLiveChannel=" + this.mpLiveChannel + ", cardPosition=" + this.cardPosition + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeParcelable(this.shelfMicroAppInfo, r3);
        r2.writeParcelable(this.shelfCardInfo, r3);
        r2.writeString(this.homePath);
        r2.writeInt(this.isShelf ? 1 : 0);
        r2.writeInt(this.isEdit ? 1 : 0);
        r2.writeInt(this.mountType);
        r2.writeString(this.openExtra);
        r2.writeString(this.mpLiveChannel);
        r2.writeInt(this.cardPosition);
    }

    public final ShelfInfo j() {
        ShelfMicroAppInfo r1 = this.shelfMicroAppInfo;
        ShelfCardInfo r0 = this.shelfCardInfo;
        if (r0 == null) goto L5;
        List r2 = CollectionsKt.mutableListOf(new ShelfCardInfo[]{r0});
    L7:
        return new ShelfInfo(r1, r2, this.mountType, this.openExtra, this.homePath, this.mpLiveChannel, 131004);
    L5:
        r2 = null;
        goto L7
    }

    public final int c() {
        return this.cardPosition;
    }

    public final String d() {
        return this.homePath;
    }

    public final int e() {
        return this.mountType;
    }

    public final ShelfMicroAppInfo g() {
        return this.shelfMicroAppInfo;
    }

    public final boolean h() {
        return this.isEdit;
    }

    public final boolean i() {
        return this.isShelf;
    }

    public static ExplainCardSettingsInfo a(ExplainCardSettingsInfo r10, ShelfCardInfo r11) {
        ShelfMicroAppInfo r1 = r10.shelfMicroAppInfo;
        String r3 = r10.homePath;
        boolean r4 = r10.isShelf;
        boolean r5 = r10.isEdit;
        int r6 = r10.mountType;
        String r7 = r10.openExtra;
        String r8 = r10.mpLiveChannel;
        int r9 = r10.cardPosition;
        r10.getClass();
        return new ExplainCardSettingsInfo(r1, r11, r3, r4, r5, r6, r7, r8, r9);
    }

    public final ExplainCardSettingsInfo b(com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.e r27, final String r28, String r29) {
        Intrinsics.checkNotNullParameter(r27, "data");
        final String r1 = r27.b();
        final String r14 = r27.f();
        ShelfCardInfo r3 = this.shelfCardInfo;
        if (r3 == null) goto L5;
        String r13 = r3.F();
    L6:
        Iterator r5 = SequencesKt.sequenceOf(new Function0[]{new ExplainCardSettingsInfo$fillInfo$defaultSelectedCoverTypeAndUrl$1(r1), new ExplainCardSettingsInfo$fillInfo$defaultSelectedCoverTypeAndUrl$2(r14), new ExplainCardSettingsInfo$fillInfo$defaultSelectedCoverTypeAndUrl$3(r28)}).iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        Object r6 = r5.next();
        if (r2.a((String) ((Pair) ((Function0) r6).invoke()).getSecond()) == false) goto L8;
    L13:
        Function0 r7 = (Function0) r6;
        if (r7 == null) goto L17;
        Pair r8 = (Pair) r7.invoke();
        if (r8 == null) goto L17;
    L18:
        ShelfCardInfo r4 = this.shelfCardInfo;
        if (r4 == null) goto L35;
        int r22 = ((Number) r8.getFirst()).intValue();
        String r9 = (String) r8.getSecond();
        String r10 = r27.c();
        if (r10 != null) goto L38;
        r10 = this.shelfCardInfo.I();
    L38:
        String r2 = this.shelfCardInfo.t();     // Catch: JSONException -> L33
        if (r2 != null) goto L27;
        r2 = "{}";
    L27:
        JSONObject r15 = new JSONObject(r2);     // Catch: JSONException -> L33
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L33
        r11.put("is_default_cover_from_cache", r27.i() ? 1 : 0);     // Catch: JSONException -> L33
        if (r27.j() == false) goto L30;
        int r12 = 1;
    L31:
        r11.put("is_default_title_from_cache", r12);     // Catch: JSONException -> L33
        Unit r16 = Unit.INSTANCE;     // Catch: JSONException -> L33
        r15.put("extra", r11);     // Catch: JSONException -> L33
        String r17 = r15.toString();     // Catch: JSONException -> L33
    L34:
        String r18 = r13;
        ShelfCardInfo r19 = ShelfCardInfo.g(r4, null, r10, r9, null, false, null, 0, 0, r17, null, r27.g(), 0, null, r14, r28, r29, r18, r22, 0, 528416743, 4);
    L37:
        return a(this, r19);
    L30:
        r12 = 0;
    L33:
        r17 = null;
        goto L34
    L35:
        r19 = null;
    L17:
        r8 = TuplesKt.to(3, r13);
        goto L18
    L12:
        r6 = null;
        goto L13
    L5:
        r13 = null;
        goto L6
    }

    public ExplainCardSettingsInfo(ShelfMicroAppInfo r1, ShelfCardInfo r2, String r3, boolean r4, boolean r5, int r6, String r7, String r8, int r9) {
        this.shelfMicroAppInfo = r1;
        this.shelfCardInfo = r2;
        this.homePath = r3;
        this.isShelf = r4;
        this.isEdit = r5;
        this.mountType = r6;
        this.openExtra = r7;
        this.mpLiveChannel = r8;
        this.cardPosition = r9;
    }

    public /* synthetic */ ExplainCardSettingsInfo(ShelfMicroAppInfo r11, ShelfCardInfo r12, String r13, boolean r14, boolean r15, int r16, String r17, String r18, int r19, int r20) {
        String r2 = null;
        if ((r20 & 1) == 0) goto L5;
        ShelfMicroAppInfo r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        ShelfCardInfo r3 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = null;
    L14:
        boolean r6 = false;
        if ((r20 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r20 & 16) != 0) goto L23;
        r6 = r15;
    L23:
        if ((r20 & 32) == 0) goto L25;
        int r7 = ShelfInfo.MountType.UnsetMount.getValue();
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r20 & 128) != 0) goto L35;
        r2 = r18;
    L35:
        if ((r20 & 256) == 0) goto L37;
        int r0 = -1;
    L38:
        this(r1, r3, r4, r5, r6, r7, r8, r2, r0);
        return;
    L37:
        r0 = r19;
        goto L38
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L14
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
