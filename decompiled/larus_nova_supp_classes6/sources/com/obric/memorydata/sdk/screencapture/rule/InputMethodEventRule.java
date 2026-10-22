package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/InputMethodEventRule;", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "visible", "", "<init>", "(Ljava/lang/Boolean;)V", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "isMatch", EventVerify.TYPE_EVENT_V1, "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "context", "Landroid/content/Context;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/obric/memorydata/sdk/screencapture/rule/InputMethodEventRule;", "equals", "other", "", "hashCode", "", "toString", "", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class InputMethodEventRule extends ScreenEventRule {
    public static final a CREATOR = null;
    public final Boolean b;

    public static final class a implements Parcelable.Creator<InputMethodEventRule> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final InputMethodEventRule createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return (InputMethodEventRule) GsonProtectorUtils.fromJson(new Gson(), r3.readString(), InputMethodEventRule.class);
        }

        @Override // android.os.Parcelable.Creator
        public final InputMethodEventRule[] newArray(int r1) {
            return new InputMethodEventRule[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof InputMethodEventRule) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.b, ((InputMethodEventRule) r4).b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.b;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "InputMethodEventRule(visible=" + this.b + ')';
    }

    public InputMethodEventRule() {
        this.b = null;
        ScreenEvent.EventType r0 = ScreenEvent.EventType.TOUCH;
    }
}
