package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenTouchEvent;
import com.ss.android.common.applog.EventVerify;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0006J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J%\u0010\u001e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\u0019HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ScreenTouchEventRule;", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "targetActions", "", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "options", "", "<init>", "(Ljava/util/List;I)V", "getTargetActions", "()Ljava/util/List;", "getOptions", "()I", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "isMatch", "", EventVerify.TYPE_EVENT_V1, "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "context", "Landroid/content/Context;", "matchScrollAction", "eventPkg", "", "hasOption", "option", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ScreenTouchEventRule extends ScreenEventRule {
    public static final a CREATOR = null;
    public final List<ScreenTouchEvent.TouchAction> b;
    public final int c;

    public static final class a implements Parcelable.Creator<ScreenTouchEventRule> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenTouchEventRule createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return (ScreenTouchEventRule) GsonProtectorUtils.fromJson(new Gson(), r3.readString(), ScreenTouchEventRule.class);
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenTouchEventRule[] newArray(int r1) {
            return new ScreenTouchEventRule[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ScreenTouchEventRule) == true) goto L8;
        return false;
    L8:
        ScreenTouchEventRule r6 = (ScreenTouchEventRule) r5;
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
        return false;
    L12:
        if (this.c == r6.c) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<ScreenTouchEvent.TouchAction> r0 = this.b;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.c;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "ScreenTouchEventRule(targetActions=" + this.b + ", options=" + this.c + ')';
    }

    public ScreenTouchEventRule() {
        this.b = null;
        this.c = 0;
        ScreenEvent.EventType r0 = ScreenEvent.EventType.TOUCH;
    }
}
