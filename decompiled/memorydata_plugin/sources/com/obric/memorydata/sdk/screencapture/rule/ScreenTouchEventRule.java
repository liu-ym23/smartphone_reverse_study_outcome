package com.obric.memorydata.sdk.screencapture.rule;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenTouchEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0006J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J%\u0010\u001e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\u0019HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ScreenTouchEventRule;", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "targetActions", "", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "options", "", "<init>", "(Ljava/util/List;I)V", "getTargetActions", "()Ljava/util/List;", "getOptions", "()I", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "isMatch", "", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "context", "Landroid/content/Context;", "matchScrollAction", "eventPkg", "", "hasOption", "option", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenTouchEventRule extends ScreenEventRule {
    public static final a CREATOR = null;
    public static final int OPTION_IGNORE_WHEN_NOTIFICATION_SHOWN = 1;
    public static final int OPTION_NONE = 0;
    private final ScreenEvent.EventType eventType;
    private final int options;
    private final List<ScreenTouchEvent.TouchAction> targetActions;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ScreenTouchEventRule$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenTouchEventRule;", "<init>", "()V", "OPTION_NONE", "", "OPTION_IGNORE_WHEN_NOTIFICATION_SHOWN", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/memorydata/sdk/screencapture/rule/ScreenTouchEventRule;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ScreenTouchEventRule> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public ScreenTouchEventRule a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            Object r1 = new Gson().fromJson(r2.readString(), ScreenTouchEventRule.class);
            Intrinsics.checkNotNullExpressionValue(r1, "fromJson(...)");
            return (ScreenTouchEventRule) ZeusTransformUtils.preCheckCast(r1, ScreenTouchEventRule.class, "com.obric.memorydata.plugin");
        }

        public ScreenTouchEventRule[] a(int r1) {
            return new ScreenTouchEventRule[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ScreenTouchEventRule createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ScreenTouchEventRule[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScreenTouchEventRule() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public ScreenTouchEventRule(List<? extends ScreenTouchEvent.TouchAction> r3, int r4) {
        this.targetActions = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.options = r4;
        this.eventType = ScreenEvent.EventType.TOUCH;
    }

    public /* synthetic */ ScreenTouchEventRule(List r2, int r3, int r4, DefaultConstructorMarker r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this(r6, r3);
    }

    public static /* synthetic */ ScreenTouchEventRule copy$default(ScreenTouchEventRule r1, List r2, int r3, int r4, Object r5) {
        List<ScreenTouchEvent.TouchAction> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.targetActions;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.options;
    L9:
        return r1.copy(r6, r3);
    }

    public final List<ScreenTouchEvent.TouchAction> component1() {
        return this.targetActions;
    }

    public final int component2() {
        return this.options;
    }

    public final ScreenTouchEventRule copy(List<? extends ScreenTouchEvent.TouchAction> r2, int r3) {
        return new ScreenTouchEventRule((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenTouchEventRule.class) == true) goto L8;
        return false;
    L8:
        ScreenTouchEventRule r6 = (ScreenTouchEventRule) ZeusTransformUtils.preCheckCast(r5, ScreenTouchEventRule.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.targetActions, r6.targetActions) == true) goto L12;
        return false;
    L12:
        if (this.options == r6.options) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule
    public ScreenEvent.EventType getEventType() {
        return this.eventType;
    }

    public final int getOptions() {
        return this.options;
    }

    public final List<ScreenTouchEvent.TouchAction> getTargetActions() {
        return this.targetActions;
    }

    public final boolean hasOption(int r1) {
        if ((this.options & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        List<ScreenTouchEvent.TouchAction> r0 = this.targetActions;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + Integer.hashCode(this.options);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    @Override // com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule
    public boolean isMatch(ScreenEvent r4, Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "event");
        if (ZeusTransformUtils.instanceOf(r4, ScreenTouchEvent.class) == true) goto L6;
        return false;
    L6:
        if (isFilter$memoryDataSDK_obricRelease(r4.getPackageName(), r6) == false) goto L8;
        return false;
    L8:
        List<ScreenTouchEvent.TouchAction> r3 = this.targetActions;
        if (r3 != null) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        if (r3.contains(((ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r4, ScreenTouchEvent.class, "com.obric.memorydata.plugin")).getAction()) == true) goto L14;
        r7 = false;
        goto L15
    }

    public final boolean matchScrollAction(String r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "eventPkg");
        if (isFilter$memoryDataSDK_obricRelease(r3, r5) == false) goto L5;
        return false;
    L5:
        List<ScreenTouchEvent.TouchAction> r6 = this.targetActions;
        if (r6 != null) goto L8;
    L11:
        return true;
    L8:
        if (r6.contains(ScreenTouchEvent.TouchAction.SCROLL_START) == true) goto L11;
        if (this.targetActions.contains(ScreenTouchEvent.TouchAction.SCROLLED) == true) goto L11;
        return false;
    }

    public String toString() {
        return "ScreenTouchEventRule(targetActions=" + this.targetActions + ", options=" + this.options + ')';
    }
}
