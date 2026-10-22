package com.larus.audio.audiov3.task.sami.v2.flow;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/larus/audio/audiov3/task/sami/v2/flow/MockEventType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "NONE", "TASK_FAILED", "SESSION_CANCELED", "SESSION_FAILED", "WEB_SOCKET_CHANGE_FAIL", "WEB_SOCKET_CONNECTION_FAIL", "Companion", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum MockEventType extends Enum<MockEventType> {
    public static final a Companion = null;
    public static final MockEventType NONE = null;
    public static final MockEventType SESSION_CANCELED = null;
    public static final MockEventType SESSION_FAILED = null;
    public static final MockEventType TASK_FAILED = null;
    public static final MockEventType WEB_SOCKET_CHANGE_FAIL = null;
    public static final MockEventType WEB_SOCKET_CONNECTION_FAIL = null;
    public static final /* synthetic */ MockEventType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MockEventType> getEntries() {
        return b;
    }

    static {
        MockEventType r0 = new MockEventType("NONE", 0, 0);
        NONE = r0;
        MockEventType r1 = new MockEventType("TASK_FAILED", 1, 1);
        TASK_FAILED = r1;
        MockEventType r3 = new MockEventType("SESSION_CANCELED", 2, 2);
        SESSION_CANCELED = r3;
        MockEventType r5 = new MockEventType("SESSION_FAILED", 3, 3);
        SESSION_FAILED = r5;
        MockEventType r7 = new MockEventType("WEB_SOCKET_CHANGE_FAIL", 4, 4);
        WEB_SOCKET_CHANGE_FAIL = r7;
        MockEventType r9 = new MockEventType("WEB_SOCKET_CONNECTION_FAIL", 5, 5);
        WEB_SOCKET_CONNECTION_FAIL = r9;
        MockEventType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static MockEventType[] values() {
        return (MockEventType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static MockEventType valueOf(String r1) {
        return (MockEventType) r27.a.a(MockEventType.class, r1);
    }

    public MockEventType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
