package com.larus.audio.call.mgr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface StateTriggerEvent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Connect;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Connect implements StateTriggerEvent {
        public static final Connect a = null;

        static {
            a = new Connect();
        }

        private Connect() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Connected;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Connected implements StateTriggerEvent {
        public static final Connected a = null;

        static {
            a = new Connected();
        }

        private Connected() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$CurrentReplyPlayEnd;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "expectedState", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "<init>", "(Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;)V", "getExpectedState", "()Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CurrentReplyPlayEnd implements StateTriggerEvent {
        public final AVKitDuplexState.DownState a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof CurrentReplyPlayEnd) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((CurrentReplyPlayEnd) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "CurrentReplyPlayEnd(expectedState=" + this.a + ')';
        }

        public CurrentReplyPlayEnd(AVKitDuplexState.DownState r2) {
            Intrinsics.checkNotNullParameter(r2, "expectedState");
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$DeepThinkEnd;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DeepThinkEnd implements StateTriggerEvent {
        public static final DeepThinkEnd a = null;

        static {
            a = new DeepThinkEnd();
        }

        private DeepThinkEnd() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$DeepThinkStart;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DeepThinkStart implements StateTriggerEvent {
        public static final DeepThinkStart a = null;

        static {
            a = new DeepThinkStart();
        }

        private DeepThinkStart() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Error;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "code", "", "msg", "", "extra", "", "", "<init>", "(ILjava/lang/String;Ljava/util/Map;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Error implements StateTriggerEvent {
        public final int a;
        public final String b;
        public final Map<String, Object> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Error) == true) goto L8;
            return false;
        L8:
            Error r6 = (Error) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "Error(code=" + this.a + ", msg=" + this.b + ", extra=" + this.c + ')';
        }

        public Error(int r2, String r3, Map<String, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            Intrinsics.checkNotNullParameter(r4, "extra");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Interrupt;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Interrupt implements StateTriggerEvent {
        public static final Interrupt a = null;

        static {
            a = new Interrupt();
        }

        private Interrupt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Pause;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Pause implements StateTriggerEvent {
        public static final Pause a = null;

        static {
            a = new Pause();
        }

        private Pause() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$PlayEnd;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class PlayEnd implements StateTriggerEvent {
        public static final PlayEnd a = null;

        static {
            a = new PlayEnd();
        }

        private PlayEnd() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$QueryBegin;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class QueryBegin implements StateTriggerEvent {
        public static final QueryBegin a = null;

        static {
            a = new QueryBegin();
        }

        private QueryBegin() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$QueryEnd;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "noContent", "", "<init>", "(Z)V", "getNoContent", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class QueryEnd implements StateTriggerEvent {
        public final boolean a;

        public QueryEnd() {
            this(false);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof QueryEnd) == true) goto L9;
            return false;
        L9:
            if (this.a == ((QueryEnd) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "QueryEnd(noContent=" + this.a + ')';
        }

        public QueryEnd(boolean r1) {
            this.a = r1;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$ReplyStart;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ReplyStart implements StateTriggerEvent {
        public static final ReplyStart a = null;

        static {
            a = new ReplyStart();
        }

        private ReplyStart() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$RequestSpeaking;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class RequestSpeaking implements StateTriggerEvent {
        public static final RequestSpeaking a = null;

        static {
            a = new RequestSpeaking();
        }

        private RequestSpeaking() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$RequestThinking;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class RequestThinking implements StateTriggerEvent {
        public static final RequestThinking a = null;

        static {
            a = new RequestThinking();
        }

        private RequestThinking() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$RequestWaiting;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class RequestWaiting implements StateTriggerEvent {
        public static final RequestWaiting a = null;

        static {
            a = new RequestWaiting();
        }

        private RequestWaiting() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Reset;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Reset implements StateTriggerEvent {
        public static final Reset a = null;

        static {
            a = new Reset();
        }

        private Reset() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Resume;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Resume implements StateTriggerEvent {
        public static final Resume a = null;

        static {
            a = new Resume();
        }

        private Resume() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$SceneSwitched;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SceneSwitched implements StateTriggerEvent {
        public static final SceneSwitched a = null;

        static {
            a = new SceneSwitched();
        }

        private SceneSwitched() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Stop;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Stop implements StateTriggerEvent {
        public static final Stop a = null;

        static {
            a = new Stop();
        }

        private Stop() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$TtsStreamEnd;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TtsStreamEnd implements StateTriggerEvent {
        public static final TtsStreamEnd a = null;

        static {
            a = new TtsStreamEnd();
        }

        private TtsStreamEnd() {
        }
    }
}
