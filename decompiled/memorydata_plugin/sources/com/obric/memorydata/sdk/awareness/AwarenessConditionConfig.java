package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0013\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006&"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;", "Landroid/os/Parcelable;", "valueType", "", "matchMode", "rules", "Ljava/util/ArrayList;", "Lcom/obric/memorydata/sdk/awareness/AwarenessConditionRule;", "Lkotlin/collections/ArrayList;", "extraKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getValueType", "()Ljava/lang/String;", "getMatchMode", "getRules", "()Ljava/util/ArrayList;", "getExtraKey", "isAlways", "", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AwarenessConditionConfig implements Parcelable {
    public static final Parcelable.Creator<AwarenessConditionConfig> CREATOR = null;
    public static final a Companion = null;
    private final String extraKey;
    private final String matchMode;
    private final ArrayList<AwarenessConditionRule> rules;
    private final String valueType;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u001f\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\f\"\u00020\b¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0016J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\n\u0010\u000b\u001a\u00020\u001d\"\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u001fJ\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u001fJ\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u001fJ*\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001f2\b\b\u0002\u0010(\u001a\u00020\u00132\b\b\u0002\u0010)\u001a\u00020\u0013J\u0012\u0010*\u001a\u00020\u00052\n\u0010\u000b\u001a\u00020+\"\u00020\u001fJ'\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\b2\u0012\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0\f\"\u00020/¢\u0006\u0002\u00100J'\u00101\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\b2\u0012\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0\f\"\u00020/¢\u0006\u0002\u00100J\u0016\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u00104\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0010\u001a\u00020\bH\u0002J \u00105\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u00106\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b07H\u0002¨\u00068"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig$Companion;", "", "<init>", "()V", ObricSecurityGuardStub.PermissionLevel.PERMISSION_LEVEL_ALWAYS, "Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;", "stringEq", EventBody.KEY_VALUE, "", "stringNe", "stringOneOf", "values", "", "([Ljava/lang/String;)Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;", "stringListContains", "extraStringEq", "extraKey", "extraStringListContains", "booleanEq", "", "booleanNe", "intEq", "", "intNe", "intGt", "intGte", "intLt", "intLte", "intOneOf", "", "doubleEq", "", "doubleNe", "doubleGt", "doubleGte", "doubleLt", "doubleLte", "doubleBetween", "min", "max", "includeMin", "includeMax", "doubleOneOf", "", "allOf", "valueType", "rules", "Lcom/obric/memorydata/sdk/awareness/AwarenessConditionRule;", "(Ljava/lang/String;[Lcom/obric/memorydata/sdk/awareness/AwarenessConditionRule;)Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;", "anyOf", "rule", "operator", "withExtraKey", LocationInfoConst.SINGLE, "oneOf", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final AwarenessConditionConfig a() {
            return new AwarenessConditionConfig(null, null, null, null, 15, null);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Parcelable.Creator<AwarenessConditionConfig> {
        public b() {
        }

        public final AwarenessConditionConfig a(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            String r5 = r6.readString();
            String r0 = r6.readString();
            int r1 = r6.readInt();
            ArrayList r2 = new ArrayList(r1);
            int r3 = 0;
        L3:
            if (r3 == r1) goto L6;
            r2.add(AwarenessConditionRule.CREATOR.createFromParcel(r6));
            r3 = r3 + 1;
            goto L3
        L6:
            return new AwarenessConditionConfig(r5, r0, r2, r6.readString());
        }

        public final AwarenessConditionConfig[] a(int r1) {
            return new AwarenessConditionConfig[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AwarenessConditionConfig createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AwarenessConditionConfig[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new b(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public AwarenessConditionConfig() {
        this(null, null, null, null, 15, null);
    }

    public AwarenessConditionConfig(String r2, String r3, ArrayList<AwarenessConditionRule> r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "matchMode");
        Intrinsics.checkNotNullParameter(r4, "rules");
        this.valueType = r2;
        this.matchMode = r3;
        this.rules = r4;
        this.extraKey = r5;
    }

    public /* synthetic */ AwarenessConditionConfig(String r2, String r3, ArrayList r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = new ArrayList();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AwarenessConditionConfig copy$default(AwarenessConditionConfig r0, String r1, String r2, ArrayList r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.valueType;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.matchMode;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.rules;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.extraKey;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.valueType;
    }

    public final String component2() {
        return this.matchMode;
    }

    public final ArrayList<AwarenessConditionRule> component3() {
        return this.rules;
    }

    public final String component4() {
        return this.extraKey;
    }

    public final AwarenessConditionConfig copy(String r1, String r2, ArrayList<AwarenessConditionRule> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "matchMode");
        Intrinsics.checkNotNullParameter(r3, "rules");
        return new AwarenessConditionConfig(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AwarenessConditionConfig.class) == true) goto L8;
        return false;
    L8:
        AwarenessConditionConfig r6 = (AwarenessConditionConfig) ZeusTransformUtils.preCheckCast(r5, AwarenessConditionConfig.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.valueType, r6.valueType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.matchMode, r6.matchMode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rules, r6.rules) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extraKey, r6.extraKey) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getExtraKey() {
        return this.extraKey;
    }

    public final String getMatchMode() {
        return this.matchMode;
    }

    public final ArrayList<AwarenessConditionRule> getRules() {
        return this.rules;
    }

    public final String getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        String r0 = this.valueType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.matchMode.hashCode()) * 31) + this.rules.hashCode()) * 31;
        String r4 = this.extraKey;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final boolean isAlways() {
        return this.rules.isEmpty();
    }

    public String toString() {
        return "AwarenessConditionConfig(valueType=" + this.valueType + ", matchMode=" + this.matchMode + ", rules=" + this.rules + ", extraKey=" + this.extraKey + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeString(this.valueType);
        r5.writeString(this.matchMode);
        ArrayList<AwarenessConditionRule> r0 = this.rules;
        r5.writeInt(r0.size());
        Iterator<AwarenessConditionRule> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((AwarenessConditionRule) ZeusTransformUtils.preCheckCast(r1.next(), AwarenessConditionRule.class, "com.obric.memorydata.plugin")).writeToParcel(r5, r6);
        goto L4
    L6:
        r5.writeString(this.extraKey);
    }
}
