package com.bytedance.android.livesdk.interactivity.api.comment.plugin;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.event.c0;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;
import y22.c;
import y22.e;
import y22.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CommentFlowContext {
    public State a;
    public final e b;
    public final CommentScene c;
    public CommentInputConfig d;
    public CommentContentType e;
    public CommentBusinessType f;
    public f g;
    public c0 h;
    public Object i;
    public Exception j;
    public long k;
    public final long l;
    public final Map<Object, Object> m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/plugin/CommentFlowContext$State;", BuildConfig.FLAVOR, "Init", "Input", "Send", "Success", "Failed", "Canceled", "UnHandled", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State Canceled = null;
        public static final State Failed = null;
        public static final State Init = null;
        public static final State Input = null;
        public static final State Send = null;
        public static final State Success = null;
        public static final State UnHandled = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r1 = new State("Init", 0);
            Init = r1;
            State r2 = new State("Input", 1);
            Input = r2;
            State r3 = new State("Send", 2);
            Send = r3;
            State r4 = new State("Success", 3);
            Success = r4;
            State r5 = new State("Failed", 4);
            Failed = r5;
            State r6 = new State("Canceled", 5);
            Canceled = r6;
            State r7 = new State("UnHandled", 6);
            UnHandled = r7;
            a = new State[]{r1, r2, r3, r4, r5, r6, r7};
        }

        public static State valueOf(String r1) {
            return (State) a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean a() {
        this.k = System.currentTimeMillis();
        e r0 = this.b;
        if (r0 == null) goto L5;
        r0.f(this);
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        this.a = State.UnHandled;
    L8:
        int r2 = c.a;
        Intrinsics.checkNotNullParameter(this, "context");
        ALogger.i("CommentFlowContext", "[" + hashCode() + "] send, contentType is " + this.e + ", businessType is " + this.f + ", handle state is " + this.a);
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    public CommentFlowContext(e r2, CommentEntry r3, CommentScene r4, long r5, Map<Object, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r2, "plugin");
        Intrinsics.checkNotNullParameter(r3, "entry");
        Intrinsics.checkNotNullParameter(r4, "scene");
        this.l = r5;
        this.m = r7;
        this.a = State.Init;
        this.b = r2;
        this.c = r4;
        int r8 = c.a;
        Intrinsics.checkNotNullParameter(this, "context");
        StringBuilder r9 = new StringBuilder("[");
        r9.append(hashCode());
        r9.append("] create, plugin is ");
        if (r2 == null) goto L5;
        String r6 = r2.getName();
    L6:
        r9.append(r6);
        r9.append(", entry is ");
        r9.append(r3);
        r9.append(", scene is ");
        r9.append(r4);
        r9.append(", sceneId is ");
        r9.append(r5);
        ALogger.i("CommentFlowContext", r9.toString());
        return;
    L5:
        r6 = null;
        goto L6
    }
}
