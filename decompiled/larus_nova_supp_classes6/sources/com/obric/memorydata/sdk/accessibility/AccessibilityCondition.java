package com.obric.memorydata.sdk.accessibility;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.sdk.screencapture.rule.KeywordsMatchRuleEnum;
import com.obric.memorydata.sdk.screencapture.rule.RectMatchRuleEnum;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B«\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u000bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0012HÆ\u0003J\t\u0010?\u001a\u00020\u0014HÆ\u0003J\t\u0010@\u001a\u00020\u0016HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0016HÆ\u0003J±\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0016HÆ\u0001J\u0006\u0010E\u001a\u00020\u0003J\u0013\u0010F\u001a\u00020\u00162\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020\u0003HÖ\u0001J\t\u0010J\u001a\u00020\u0005HÖ\u0001J\u0016\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u001a\u0010\u001a\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00105¨\u0006P"}, d2 = {"Lcom/obric/memorydata/sdk/accessibility/AccessibilityCondition;", "Landroid/os/Parcelable;", "eventType", "", "activityName", "", "activityList", "", "keywordMatchRules", "Lcom/obric/memorydata/sdk/accessibility/KeywordMatchRule;", "keywordsMatchRule", "Lcom/obric/memorydata/sdk/screencapture/rule/KeywordsMatchRuleEnum;", "keywordMatchExpression", "visibleNodeCountCondition", "Lcom/obric/memorydata/sdk/accessibility/VisibleNodeCountCondition;", "touchRects", "Landroid/graphics/Rect;", "touchRectMatchRule", "Lcom/obric/memorydata/sdk/screencapture/rule/RectMatchRuleEnum;", "timeThreshold", "", "optional", "", "screenshotOpt", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "resetToStep", "matched", "<init>", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/obric/memorydata/sdk/screencapture/rule/KeywordsMatchRuleEnum;Ljava/lang/String;Lcom/obric/memorydata/sdk/accessibility/VisibleNodeCountCondition;Ljava/util/List;Lcom/obric/memorydata/sdk/screencapture/rule/RectMatchRuleEnum;JZLcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;IZ)V", "getEventType", "()I", "getActivityName", "()Ljava/lang/String;", "getActivityList", "()Ljava/util/List;", "getKeywordMatchRules", "getKeywordsMatchRule", "()Lcom/obric/memorydata/sdk/screencapture/rule/KeywordsMatchRuleEnum;", "getKeywordMatchExpression", "getVisibleNodeCountCondition", "()Lcom/obric/memorydata/sdk/accessibility/VisibleNodeCountCondition;", "getTouchRects", "getTouchRectMatchRule", "()Lcom/obric/memorydata/sdk/screencapture/rule/RectMatchRuleEnum;", "getTimeThreshold", "()J", "getOptional", "()Z", "getScreenshotOpt", "()Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "getResetToStep", "getMatched", "setMatched", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class AccessibilityCondition implements Parcelable {
    public static final Parcelable.Creator<AccessibilityCondition> CREATOR = null;
    public final int a;
    public final String b;
    public final List<String> c;
    public final List<KeywordMatchRule> d;
    public final KeywordsMatchRuleEnum e;
    public final String f;
    public final VisibleNodeCountCondition g;
    public final List<Rect> h;
    public final RectMatchRuleEnum i;
    public final long j;
    public final boolean k;
    public final ScreenshotOption l;
    public final int m;
    public final boolean n;

    public static final class a implements Parcelable.Creator<AccessibilityCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AccessibilityCondition createFromParcel(Parcel r20) {
            Intrinsics.checkNotNullParameter(r20, "parcel");
            int r3 = r20.readInt();
            String r4 = r20.readString();
            ArrayList<String> r5 = r20.createStringArrayList();
            int r1 = r20.readInt();
            ArrayList r6 = new ArrayList(r1);
            int r7 = 0;
        L3:
            if (r7 == r1) goto L5;
            r6.add(KeywordMatchRule.CREATOR.createFromParcel(r20));
            r7 = r7 + 1;
            goto L3
        L5:
            KeywordsMatchRuleEnum r8 = KeywordsMatchRuleEnum.valueOf(r20.readString());
            String r9 = r20.readString();
            ScreenshotOption r10 = null;
            if (r20.readInt() != 0) goto L8;
            VisibleNodeCountCondition r2 = null;
        L9:
            VisibleNodeCountCondition r11 = r2;
            if (r20.readInt() != 0) goto L12;
            ArrayList r12 = null;
        L16:
            RectMatchRuleEnum r13 = RectMatchRuleEnum.valueOf(r20.readString());
            long r14 = r20.readLong();
            if (r20.readInt() == 0) goto L19;
            boolean r15 = true;
        L21:
            if (r20.readInt() == 0) goto L24;
            r10 = ScreenshotOption.CREATOR.createFromParcel(r20);
        L24:
            ScreenshotOption r16 = r10;
            int r17 = r20.readInt();
            if (r20.readInt() == 0) goto L27;
            boolean r0 = true;
        L29:
            return new AccessibilityCondition(r3, r4, r5, r6, r8, r9, r11, r12, r13, r14, r15, r16, r17, r0);
        L27:
            r0 = false;
            goto L29
        L19:
            r15 = false;
            goto L21
        L12:
            int r18 = r20.readInt();
            ArrayList r19 = new ArrayList(r18);
            int r110 = 0;
        L13:
            if (r110 == r18) goto L15;
            r19.add(r20.readParcelable(AccessibilityCondition.class.getClassLoader()));
            r110 = r110 + 1;
            goto L13
        L15:
            r12 = r19;
            goto L16
        L8:
            r2 = VisibleNodeCountCondition.CREATOR.createFromParcel(r20);
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final AccessibilityCondition[] newArray(int r1) {
            return new AccessibilityCondition[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AccessibilityCondition) == true) goto L8;
        return false;
    L8:
        AccessibilityCondition r9 = (AccessibilityCondition) r8;
        if (this.a == r9.a) goto L12;
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
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
        List<String> r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        VisibleNodeCountCondition r8 = this.g;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        List<Rect> r11 = this.h;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + this.i.hashCode()) * 31;
        long r14 = this.j;
        int r15 = (r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31;
        int r16 = 1231;
        if (this.k == false) goto L21;
        int r17 = 1231;
    L22:
        int r18 = (r15 + r17) * 31;
        ScreenshotOption r19 = this.l;
        if (r19 == null) goto L26;
        r2 = r19.hashCode();
    L26:
        int r20 = (((r18 + r2) * 31) + this.m) * 31;
        if (this.n == true) goto L31;
        r16 = 1237;
    L31:
        return r20 + r16;
    L21:
        r17 = 1237;
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

    public final String toString() {
        return "AccessibilityCondition(eventType=" + this.a + ", activityName=" + this.b + ", activityList=" + this.c + ", keywordMatchRules=" + this.d + ", keywordsMatchRule=" + this.e + ", keywordMatchExpression=" + this.f + ", visibleNodeCountCondition=" + this.g + ", touchRects=" + this.h + ", touchRectMatchRule=" + this.i + ", timeThreshold=" + this.j + ", optional=" + this.k + ", screenshotOpt=" + this.l + ", resetToStep=" + this.m + ", matched=" + this.n + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeInt(this.a);
        r6.writeString(this.b);
        r6.writeStringList(this.c);
        List<KeywordMatchRule> r0 = this.d;
        r6.writeInt(r0.size());
        Iterator<KeywordMatchRule> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().writeToParcel(r6, r7);
        goto L4
    L6:
        r6.writeString(this.e.name());
        r6.writeString(this.f);
        VisibleNodeCountCondition r2 = this.g;
        if (r2 != null) goto L9;
        r6.writeInt(0);
    L10:
        List<Rect> r3 = this.h;
        if (r3 != null) goto L13;
        r6.writeInt(0);
    L17:
        r6.writeString(this.i.name());
        r6.writeLong(this.j);
        r6.writeInt(this.k ? 1 : 0);
        ScreenshotOption r4 = this.l;
        if (r4 != null) goto L20;
        r6.writeInt(0);
    L21:
        r6.writeInt(this.m);
        r6.writeInt(this.n ? 1 : 0);
        return;
    L20:
        r6.writeInt(1);
        r4.writeToParcel(r6, r7);
        goto L21
    L13:
        r6.writeInt(1);
        r6.writeInt(r3.size());
        Iterator<Rect> r5 = r3.iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        r6.writeParcelable(r5.next(), r7);
        goto L15
    L9:
        r6.writeInt(1);
        r2.writeToParcel(r6, r7);
        goto L10
    }

    public AccessibilityCondition(int r7, String r8, List<String> r9, List<KeywordMatchRule> r10, KeywordsMatchRuleEnum r11, String r12, VisibleNodeCountCondition r13, List<Rect> r14, RectMatchRuleEnum r15, long r16, boolean r18, ScreenshotOption r19, int r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r8, "activityName");
        Intrinsics.checkNotNullParameter(r10, "keywordMatchRules");
        Intrinsics.checkNotNullParameter(r11, "keywordsMatchRule");
        Intrinsics.checkNotNullParameter(r15, "touchRectMatchRule");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r18;
        this.l = r19;
        this.m = r20;
        this.n = r21;
    }
}
