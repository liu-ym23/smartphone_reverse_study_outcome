package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.b.a;
import com.obric.capabilitykit.EntityProvider;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J>\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010 J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\b\u0010&\u001a\u00020\bH\u0016J\u0012\u0010'\u001a\u00020\u00012\b\u0010(\u001a\u0004\u0018\u00010$H\u0016J\t\u0010)\u001a\u00020\u0004HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/obric/capabilitykit/common/intent/NetEaseCloudMusicSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", ChatMessage.TYPE_QUERY, "", EntityProvider.KEY_ENTITY_TYPE, "", "auto_play", "", CommonConsts.COUNT_TYPE, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getAuto_play", "()Ljava/lang/Boolean;", "setAuto_play", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCount", "()Ljava/lang/Integer;", "setCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEntity_type", "setEntity_type", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/NetEaseCloudMusicSearchParams;", "describeContents", "equals", "other", "", "hashCode", "isParamsCompleted", "mergeParams", TrackerImpl.PARAMS, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NetEaseCloudMusicSearchParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<NetEaseCloudMusicSearchParams> CREATOR = null;
    private Boolean auto_play;
    private Integer count;
    private Integer entity_type;
    private String query;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NetEaseCloudMusicSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NetEaseCloudMusicSearchParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            Intrinsics.checkNotNullParameter(r10, "parcel");
            String r2 = r10.readString();
            Integer r4 = null;
            if (r10.readInt() != 0) goto L5;
            Integer r3 = null;
        L6:
            int r7 = 1;
            if (r10.readInt() != 0) goto L10;
            Boolean r5 = null;
        L15:
            if (r10.readInt() == 0) goto L18;
            r4 = Integer.valueOf(r10.readInt());
        L18:
            NetEaseCloudMusicSearchParams r1 = new NetEaseCloudMusicSearchParams(r2, r3, r5, r4);
            int r6 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
        L19:
            if (r7 > r6) goto L21;
            r7 = r7 + 1;
        L21:
            if (r7 > r0) goto L23;
            a.a(r10, r9);
            r7 = r7 + 1;
            goto L21
        L23:
            return r1;
        L10:
            if (r10.readInt() == 0) goto L12;
            boolean r8 = true;
        L13:
            r5 = Boolean.valueOf(r8);
            goto L15
        L12:
            r8 = false;
            goto L13
        L5:
            r3 = Integer.valueOf(r10.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NetEaseCloudMusicSearchParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NetEaseCloudMusicSearchParams[] newArray(int r1) {
            return new NetEaseCloudMusicSearchParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NetEaseCloudMusicSearchParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public NetEaseCloudMusicSearchParams() {
        this(null, null, null, null, 15, null);
    }

    public NetEaseCloudMusicSearchParams(String r1, Integer r2, Boolean r3, Integer r4) {
        this.query = r1;
        this.entity_type = r2;
        this.auto_play = r3;
        this.count = r4;
    }

    public /* synthetic */ NetEaseCloudMusicSearchParams(String r2, Integer r3, Boolean r4, Integer r5, int r6, DefaultConstructorMarker r7) {
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

    public static /* synthetic */ NetEaseCloudMusicSearchParams copy$default(NetEaseCloudMusicSearchParams r0, String r1, Integer r2, Boolean r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.query;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.entity_type;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.auto_play;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.count;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.query;
    }

    public final Integer component2() {
        return this.entity_type;
    }

    public final Boolean component3() {
        return this.auto_play;
    }

    public final Integer component4() {
        return this.count;
    }

    public final NetEaseCloudMusicSearchParams copy(String r1, Integer r2, Boolean r3, Integer r4) {
        return new NetEaseCloudMusicSearchParams(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NetEaseCloudMusicSearchParams.class) == true) goto L8;
        return false;
    L8:
        NetEaseCloudMusicSearchParams r6 = (NetEaseCloudMusicSearchParams) ZeusTransformUtils.preCheckCast(r5, NetEaseCloudMusicSearchParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entity_type, r6.entity_type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.auto_play, r6.auto_play) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.count, r6.count) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final Boolean getAuto_play() {
        return this.auto_play;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final Integer getEntity_type() {
        return this.entity_type;
    }

    public final String getQuery() {
        return this.query;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        String r0 = this.query;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.entity_type;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.auto_play;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.count;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.query == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, NetEaseCloudMusicSearchParams.class) == true) goto L7;
        Object r5 = ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    L6:
        return (IntentParams) r5;
    L7:
        String r1 = this.query;
        if (r1 != null) goto L10;
        r1 = ((NetEaseCloudMusicSearchParams) ZeusTransformUtils.preCheckCast(r6, NetEaseCloudMusicSearchParams.class, "com.obric.memorydata.plugin")).query;
    L10:
        Integer r3 = this.entity_type;
        if (r3 != null) goto L13;
        r3 = ((NetEaseCloudMusicSearchParams) ZeusTransformUtils.preCheckCast(r6, NetEaseCloudMusicSearchParams.class, "com.obric.memorydata.plugin")).entity_type;
    L13:
        Boolean r4 = this.auto_play;
        if (r4 != null) goto L16;
        r4 = ((NetEaseCloudMusicSearchParams) ZeusTransformUtils.preCheckCast(r6, NetEaseCloudMusicSearchParams.class, "com.obric.memorydata.plugin")).auto_play;
    L16:
        Integer r7 = this.count;
        if (r7 != null) goto L19;
        r7 = ((NetEaseCloudMusicSearchParams) ZeusTransformUtils.preCheckCast(r6, NetEaseCloudMusicSearchParams.class, "com.obric.memorydata.plugin")).count;
    L19:
        r5 = ZeusTransformUtils.preCheckCast(new NetEaseCloudMusicSearchParams(r1, r3, r4, r7), IntentParams.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void setAuto_play(Boolean r1) {
        this.auto_play = r1;
    }

    public final void setCount(Integer r1) {
        this.count = r1;
    }

    public final void setEntity_type(Integer r1) {
        this.entity_type = r1;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    public String toString() {
        return "NetEaseCloudMusicSearchParams(query=" + this.query + ", entity_type=" + this.entity_type + ", auto_play=" + this.auto_play + ", count=" + this.count + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeString(this.query);
        Integer r0 = this.entity_type;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        Boolean r1 = this.auto_play;
        if (r1 != null) goto L9;
        r3.writeInt(0);
    L10:
        Integer r2 = this.count;
        if (r2 != null) goto L13;
        r3.writeInt(0);
        return;
    L13:
        r3.writeInt(1);
        r3.writeInt(r2.intValue());
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r1.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.intValue());
        goto L6
    }
}
