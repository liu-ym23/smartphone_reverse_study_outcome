package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/AiAgentViewChangeReason;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "desc", "INIT", "CONTAINER_SHOW", "CONTAINER_HIDE", "MESSAGE_INSERT", "MESSAGE_REMOVE", "ZOOM_OUT", "ZOOM_IN", "MODE_CHANGE", "TIMEOUT", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AiAgentViewChangeReason extends Enum<AiAgentViewChangeReason> {
    public static final AiAgentViewChangeReason CONTAINER_HIDE = null;
    public static final AiAgentViewChangeReason CONTAINER_SHOW = null;
    public static final AiAgentViewChangeReason INIT = null;
    public static final AiAgentViewChangeReason MESSAGE_INSERT = null;
    public static final AiAgentViewChangeReason MESSAGE_REMOVE = null;
    public static final AiAgentViewChangeReason MODE_CHANGE = null;
    public static final AiAgentViewChangeReason TIMEOUT = null;
    public static final AiAgentViewChangeReason ZOOM_IN = null;
    public static final AiAgentViewChangeReason ZOOM_OUT = null;
    public static final /* synthetic */ AiAgentViewChangeReason[] a = null;

    static {
        AiAgentViewChangeReason r1 = new AiAgentViewChangeReason("INIT", 0);
        INIT = r1;
        AiAgentViewChangeReason r2 = new AiAgentViewChangeReason("CONTAINER_SHOW", 1);
        CONTAINER_SHOW = r2;
        AiAgentViewChangeReason r3 = new AiAgentViewChangeReason("CONTAINER_HIDE", 2);
        CONTAINER_HIDE = r3;
        AiAgentViewChangeReason r4 = new AiAgentViewChangeReason("MESSAGE_INSERT", 3);
        MESSAGE_INSERT = r4;
        AiAgentViewChangeReason r5 = new AiAgentViewChangeReason("MESSAGE_REMOVE", 4);
        MESSAGE_REMOVE = r5;
        AiAgentViewChangeReason r6 = new AiAgentViewChangeReason("ZOOM_OUT", 5);
        ZOOM_OUT = r6;
        AiAgentViewChangeReason r7 = new AiAgentViewChangeReason("ZOOM_IN", 6);
        ZOOM_IN = r7;
        AiAgentViewChangeReason r8 = new AiAgentViewChangeReason("MODE_CHANGE", 7);
        MODE_CHANGE = r8;
        AiAgentViewChangeReason r9 = new AiAgentViewChangeReason("TIMEOUT", 8);
        TIMEOUT = r9;
        a = new AiAgentViewChangeReason[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public static AiAgentViewChangeReason valueOf(String r1) {
        return (AiAgentViewChangeReason) r27.a.a(AiAgentViewChangeReason.class, r1);
    }

    public static AiAgentViewChangeReason[] values() {
        return (AiAgentViewChangeReason[]) a.clone();
    }

    public final String desc() {
        switch(i.a[ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return "TIMEOUT";
    L7:
        return "MODE_CHANGE";
    L8:
        return "ZOOM_IN";
    L9:
        return "ZOOM_OUT";
    L10:
        return "MESSAGE_REMOVE";
    L11:
        return "MESSAGE_INSERT";
    L12:
        return "CONTAINER_HIDE";
    L13:
        return "CONTAINER_SHOW";
    L14:
        return "INIT";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public AiAgentViewChangeReason(String r1, int r2) {
        super(r1, r2);
    }
}
