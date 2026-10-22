package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.sdk.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 K2\u00020\u0001:\u0001KB_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0011\u0010\u0015J\u0018\u00104\u001a\u0002052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u0003H\u0016J\b\u00107\u001a\u00020\u0003H\u0016J\u0016\u00108\u001a\u0002052\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020;J\u0010\u00102\u001a\u0004\u0018\u00010;2\u0006\u00109\u001a\u00020\u0005J\u000e\u0010<\u001a\u0002052\u0006\u00109\u001a\u00020\u0005J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003Je\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010I\u001a\u00020\u0003HÖ\u0001J\t\u0010J\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001d¨\u0006L"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "Landroid/os/Parcelable;", "code", "", "message", "", "entityResult", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchEntityResult;", "kgResult", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchKgResult;", "domainResult", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchDomainResult;", "memoryResult", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchMemoryResult;", "proactiveRecommendationResult", "Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult;", WsConstants.KEY_EXTRA, "<init>", "(ILjava/lang/String;Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchEntityResult;Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchKgResult;Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchDomainResult;Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchMemoryResult;Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getEntityResult", "()Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchEntityResult;", "setEntityResult", "(Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchEntityResult;)V", "getKgResult", "()Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchKgResult;", "setKgResult", "(Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchKgResult;)V", "getDomainResult", "()Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchDomainResult;", "setDomainResult", "(Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchDomainResult;)V", "getMemoryResult", "()Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchMemoryResult;", "setMemoryResult", "(Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchMemoryResult;)V", "getProactiveRecommendationResult", "()Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult;", "setProactiveRecommendationResult", "(Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult;)V", "getExtra", "setExtra", "writeToParcel", "", "flags", "describeContents", "addExtra", "key", EventBody.KEY_VALUE, "", "removeExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalAssistantSearchResponse implements Parcelable {
    public static final a CREATOR = null;
    private int code;
    private GlobalAssistantSearchDomainResult domainResult;
    private GlobalAssistantSearchEntityResult entityResult;
    private String extra;
    private GlobalAssistantSearchKgResult kgResult;
    private GlobalAssistantSearchMemoryResult memoryResult;
    private String message;
    private ProactiveRecommendationSearchResult proactiveRecommendationResult;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<GlobalAssistantSearchResponse> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public GlobalAssistantSearchResponse a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new GlobalAssistantSearchResponse(r1);
        }

        public GlobalAssistantSearchResponse[] a(int r1) {
            return new GlobalAssistantSearchResponse[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalAssistantSearchResponse createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalAssistantSearchResponse[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public GlobalAssistantSearchResponse(int r2, String r3, GlobalAssistantSearchEntityResult r4, GlobalAssistantSearchKgResult r5, GlobalAssistantSearchDomainResult r6, GlobalAssistantSearchMemoryResult r7, ProactiveRecommendationSearchResult r8, String r9) {
        Intrinsics.checkNotNullParameter(r3, "message");
        this.code = r2;
        this.message = r3;
        this.entityResult = r4;
        this.kgResult = r5;
        this.domainResult = r6;
        this.memoryResult = r7;
        this.proactiveRecommendationResult = r8;
        this.extra = r9;
    }

    public /* synthetic */ GlobalAssistantSearchResponse(int r13, String r14, GlobalAssistantSearchEntityResult r15, GlobalAssistantSearchKgResult r16, GlobalAssistantSearchDomainResult r17, GlobalAssistantSearchMemoryResult r18, ProactiveRecommendationSearchResult r19, String r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 4) == 0) goto L5;
        GlobalAssistantSearchEntityResult r6 = null;
    L7:
        if ((r21 & 8) == 0) goto L9;
        GlobalAssistantSearchKgResult r7 = null;
    L11:
        if ((r21 & 16) == 0) goto L13;
        GlobalAssistantSearchDomainResult r8 = null;
    L15:
        if ((r21 & 32) == 0) goto L17;
        GlobalAssistantSearchMemoryResult r9 = null;
    L19:
        if ((r21 & 64) == 0) goto L21;
        ProactiveRecommendationSearchResult r10 = null;
    L23:
        if ((r21 & 128) == 0) goto L25;
        String r11 = null;
    L26:
        this(r13, r14, r6, r7, r8, r9, r10, r11);
        return;
    L25:
        r11 = r20;
        goto L26
    L21:
        r10 = r19;
        goto L23
    L17:
        r9 = r18;
        goto L19
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    public GlobalAssistantSearchResponse(Parcel r11) {
        Intrinsics.checkNotNullParameter(r11, "parcel");
        int r2 = r11.readInt();
        String r0 = r11.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this(r2, r0, (GlobalAssistantSearchEntityResult) ZeusTransformUtils.preCheckCast(r11.readParcelable(GlobalAssistantSearchEntityResult.class.getClassLoader()), GlobalAssistantSearchEntityResult.class, "com.obric.memorydata.plugin"), (GlobalAssistantSearchKgResult) ZeusTransformUtils.preCheckCast(r11.readParcelable(GlobalAssistantSearchKgResult.class.getClassLoader()), GlobalAssistantSearchKgResult.class, "com.obric.memorydata.plugin"), (GlobalAssistantSearchDomainResult) ZeusTransformUtils.preCheckCast(r11.readParcelable(GlobalAssistantSearchDomainResult.class.getClassLoader()), GlobalAssistantSearchDomainResult.class, "com.obric.memorydata.plugin"), (GlobalAssistantSearchMemoryResult) ZeusTransformUtils.preCheckCast(r11.readParcelable(GlobalAssistantSearchMemoryResult.class.getClassLoader()), GlobalAssistantSearchMemoryResult.class, "com.obric.memorydata.plugin"), (ProactiveRecommendationSearchResult) ZeusTransformUtils.preCheckCast(r11.readParcelable(ProactiveRecommendationSearchResult.class.getClassLoader()), ProactiveRecommendationSearchResult.class, "com.obric.memorydata.plugin"), r11.readString());
    }

    private static final JSONObject addExtra$lambda$0(GlobalAssistantSearchResponse r1) {
        return new JSONObject(r1.extra);
    }

    public static /* synthetic */ GlobalAssistantSearchResponse copy$default(GlobalAssistantSearchResponse r9, int r10, String r11, GlobalAssistantSearchEntityResult r12, GlobalAssistantSearchKgResult r13, GlobalAssistantSearchDomainResult r14, GlobalAssistantSearchMemoryResult r15, ProactiveRecommendationSearchResult r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        int r2 = r9.code;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.message;
    L11:
        if ((r18 & 4) == 0) goto L13;
        GlobalAssistantSearchEntityResult r4 = r9.entityResult;
    L15:
        if ((r18 & 8) == 0) goto L17;
        GlobalAssistantSearchKgResult r5 = r9.kgResult;
    L19:
        if ((r18 & 16) == 0) goto L21;
        GlobalAssistantSearchDomainResult r6 = r9.domainResult;
    L23:
        if ((r18 & 32) == 0) goto L25;
        GlobalAssistantSearchMemoryResult r7 = r9.memoryResult;
    L27:
        if ((r18 & 64) == 0) goto L29;
        ProactiveRecommendationSearchResult r8 = r9.proactiveRecommendationResult;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.extra;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    private static final Object getExtra$lambda$1(GlobalAssistantSearchResponse r1, String r2) {
        return new JSONObject(r1.extra).opt(r2);
    }

    public static /* synthetic */ Unit lambda$VDQp1qNc19pCCw1VOwq7fePRjBc(GlobalAssistantSearchResponse r0, String r1) {
        return removeExtra$lambda$2(r0, r1);
    }

    public static /* synthetic */ Object lambda$_cMg8ssDhK1nf8hAbJV3EtcWRvs(GlobalAssistantSearchResponse r0, String r1) {
        return getExtra$lambda$1(r0, r1);
    }

    public static /* synthetic */ JSONObject lambda$sylWcy4Cro3QzFR8tWvrleoazpc(GlobalAssistantSearchResponse r0) {
        return addExtra$lambda$0(r0);
    }

    private static final Unit removeExtra$lambda$2(GlobalAssistantSearchResponse r2, String r3) {
        JSONObject r0 = new JSONObject(r2.extra);
        r0.remove(r3);
        r2.extra = r0.toString();
        return Unit.INSTANCE;
    }

    public final void addExtra(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.extra, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        JSONObject r2 = new JSONObject();
    L14:
        r2.put(r4, r5);
        this.extra = r2.toString();
        return;
    L11:
        r2 = (JSONObject) ZeusTransformUtils.preCheckCast(d.a(new $$Lambda$GlobalAssistantSearchResponse$sylWcy4Cro3QzFR8tWvrleoazpc(this)), JSONObject.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L14;
        r2 = new JSONObject();
        goto L14
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final GlobalAssistantSearchEntityResult component3() {
        return this.entityResult;
    }

    public final GlobalAssistantSearchKgResult component4() {
        return this.kgResult;
    }

    public final GlobalAssistantSearchDomainResult component5() {
        return this.domainResult;
    }

    public final GlobalAssistantSearchMemoryResult component6() {
        return this.memoryResult;
    }

    public final ProactiveRecommendationSearchResult component7() {
        return this.proactiveRecommendationResult;
    }

    public final String component8() {
        return this.extra;
    }

    public final GlobalAssistantSearchResponse copy(int r11, String r12, GlobalAssistantSearchEntityResult r13, GlobalAssistantSearchKgResult r14, GlobalAssistantSearchDomainResult r15, GlobalAssistantSearchMemoryResult r16, ProactiveRecommendationSearchResult r17, String r18) {
        Intrinsics.checkNotNullParameter(r12, "message");
        return new GlobalAssistantSearchResponse(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalAssistantSearchResponse.class) == true) goto L8;
        return false;
    L8:
        GlobalAssistantSearchResponse r6 = (GlobalAssistantSearchResponse) ZeusTransformUtils.preCheckCast(r5, GlobalAssistantSearchResponse.class, "com.obric.memorydata.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entityResult, r6.entityResult) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.kgResult, r6.kgResult) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.domainResult, r6.domainResult) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.memoryResult, r6.memoryResult) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.proactiveRecommendationResult, r6.proactiveRecommendationResult) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final GlobalAssistantSearchDomainResult getDomainResult() {
        return this.domainResult;
    }

    public final GlobalAssistantSearchEntityResult getEntityResult() {
        return this.entityResult;
    }

    public final Object getExtra(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.extra, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return null;
    L12:
        return d.a(new $$Lambda$GlobalAssistantSearchResponse$_cMg8ssDhK1nf8hAbJV3EtcWRvs(this, r4));
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final String getExtra() {
        return this.extra;
    }

    public final GlobalAssistantSearchKgResult getKgResult() {
        return this.kgResult;
    }

    public final GlobalAssistantSearchMemoryResult getMemoryResult() {
        return this.memoryResult;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ProactiveRecommendationSearchResult getProactiveRecommendationResult() {
        return this.proactiveRecommendationResult;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31;
        GlobalAssistantSearchEntityResult r1 = this.entityResult;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        GlobalAssistantSearchKgResult r5 = this.kgResult;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        GlobalAssistantSearchDomainResult r8 = this.domainResult;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        GlobalAssistantSearchMemoryResult r11 = this.memoryResult;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        ProactiveRecommendationSearchResult r14 = this.proactiveRecommendationResult;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.extra;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void removeExtra(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.extra, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        d.a(new $$Lambda$GlobalAssistantSearchResponse$VDQp1qNc19pCCw1VOwq7fePRjBc(this, r4));
        return;
    L12:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void setCode(int r1) {
        this.code = r1;
    }

    public final void setDomainResult(GlobalAssistantSearchDomainResult r1) {
        this.domainResult = r1;
    }

    public final void setEntityResult(GlobalAssistantSearchEntityResult r1) {
        this.entityResult = r1;
    }

    public final void setExtra(String r1) {
        this.extra = r1;
    }

    public final void setKgResult(GlobalAssistantSearchKgResult r1) {
        this.kgResult = r1;
    }

    public final void setMemoryResult(GlobalAssistantSearchMemoryResult r1) {
        this.memoryResult = r1;
    }

    public final void setMessage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.message = r2;
    }

    public final void setProactiveRecommendationResult(ProactiveRecommendationSearchResult r1) {
        this.proactiveRecommendationResult = r1;
    }

    public String toString() {
        return "GlobalAssistantSearchResponse(code=" + this.code + ", message=" + this.message + ", entityResult=" + this.entityResult + ", kgResult=" + this.kgResult + ", domainResult=" + this.domainResult + ", memoryResult=" + this.memoryResult + ", proactiveRecommendationResult=" + this.proactiveRecommendationResult + ", extra=" + this.extra + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        r4.writeInt(this.code);
        r4.writeString(this.message);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.entityResult, Parcelable.class, "com.obric.memorydata.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.kgResult, Parcelable.class, "com.obric.memorydata.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.domainResult, Parcelable.class, "com.obric.memorydata.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.memoryResult, Parcelable.class, "com.obric.memorydata.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.proactiveRecommendationResult, Parcelable.class, "com.obric.memorydata.plugin"), r5);
        r4.writeString(this.extra);
    }
}
