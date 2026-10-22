package com.obric.memorydata.sdk.screencapture.rule;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.obric.memorydata.sdk.screencapture.event.InputMethodEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/InputMethodEventRule;", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "visible", "", "<init>", "(Ljava/lang/Boolean;)V", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "isMatch", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "context", "Landroid/content/Context;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/obric/memorydata/sdk/screencapture/rule/InputMethodEventRule;", "equals", "other", "", "hashCode", "", "toString", "", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InputMethodEventRule extends ScreenEventRule {
    public static final a CREATOR = null;
    private final ScreenEvent.EventType eventType;
    private final Boolean visible;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/InputMethodEventRule$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/screencapture/rule/InputMethodEventRule;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/screencapture/rule/InputMethodEventRule;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<InputMethodEventRule> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public InputMethodEventRule a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            Object r1 = new Gson().fromJson(r2.readString(), InputMethodEventRule.class);
            Intrinsics.checkNotNullExpressionValue(r1, "fromJson(...)");
            return (InputMethodEventRule) ZeusTransformUtils.preCheckCast(r1, InputMethodEventRule.class, "com.obric.memorydata.plugin");
        }

        public InputMethodEventRule[] a(int r1) {
            return new InputMethodEventRule[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ InputMethodEventRule createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ InputMethodEventRule[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InputMethodEventRule() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public InputMethodEventRule(Boolean r1) {
        this.visible = r1;
        this.eventType = ScreenEvent.EventType.INPUT_METHOD;
    }

    public /* synthetic */ InputMethodEventRule(Boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public static /* synthetic */ InputMethodEventRule copy$default(InputMethodEventRule r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.visible;
    L6:
        return r0.copy(r1);
    }

    public final Boolean component1() {
        return this.visible;
    }

    public final InputMethodEventRule copy(Boolean r1) {
        return new InputMethodEventRule(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InputMethodEventRule.class) == true) goto L8;
        return false;
    L8:
        InputMethodEventRule r6 = (InputMethodEventRule) ZeusTransformUtils.preCheckCast(r5, InputMethodEventRule.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.visible, r6.visible) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule
    public ScreenEvent.EventType getEventType() {
        return this.eventType;
    }

    public final Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean r0 = this.visible;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    @Override // com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule
    public boolean isMatch(ScreenEvent r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (ZeusTransformUtils.instanceOf(r3, InputMethodEvent.class) == true) goto L5;
    L11:
        return false;
    L5:
        if (isFilter$memoryDataSDK_obricRelease(r3.getPackageName(), r5) == true) goto L11;
        Boolean r2 = this.visible;
        if (r2 != null) goto L9;
    L10:
        return true;
    L9:
        if (Intrinsics.areEqual(r2, Boolean.valueOf(((InputMethodEvent) ZeusTransformUtils.preCheckCast(r3, InputMethodEvent.class, "com.obric.memorydata.plugin")).getVisible())) == false) goto L11;
        goto L10
    }

    public String toString() {
        return "InputMethodEventRule(visible=" + this.visible + ')';
    }
}
