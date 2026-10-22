package com.obric.aiagent.assistant.idl.bean;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMConstData;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "()V", "DMTaskType", "DMSimpleTaskState", "DMOAutoTaskState", "DMComplexTaskState", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DMConstData {
    public static final DMConstData INSTANCE = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMConstData$DMComplexTaskState;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "Idle", "Queueing", "Thinking", "CallUser", "Clarify", "ClarifyAck", "TakingOver", "ThinkingCompleted", "Terminated", "TTS", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DMComplexTaskState extends Enum<DMComplexTaskState> {
        public static final DMComplexTaskState CallUser = null;
        public static final DMComplexTaskState Clarify = null;
        public static final DMComplexTaskState ClarifyAck = null;
        public static final DMComplexTaskState Idle = null;
        public static final DMComplexTaskState Queueing = null;
        public static final DMComplexTaskState TTS = null;
        public static final DMComplexTaskState TakingOver = null;
        public static final DMComplexTaskState Terminated = null;
        public static final DMComplexTaskState Thinking = null;
        public static final DMComplexTaskState ThinkingCompleted = null;
        public static final /* synthetic */ DMComplexTaskState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DMComplexTaskState> getEntries() {
            return b;
        }

        static {
            DMComplexTaskState r0 = new DMComplexTaskState("Idle", 0);
            Idle = r0;
            DMComplexTaskState r1 = new DMComplexTaskState("Queueing", 1);
            Queueing = r1;
            DMComplexTaskState r3 = new DMComplexTaskState("Thinking", 2);
            Thinking = r3;
            DMComplexTaskState r5 = new DMComplexTaskState("CallUser", 3);
            CallUser = r5;
            DMComplexTaskState r7 = new DMComplexTaskState("Clarify", 4);
            Clarify = r7;
            DMComplexTaskState r9 = new DMComplexTaskState("ClarifyAck", 5);
            ClarifyAck = r9;
            DMComplexTaskState r11 = new DMComplexTaskState("TakingOver", 6);
            TakingOver = r11;
            DMComplexTaskState r13 = new DMComplexTaskState("ThinkingCompleted", 7);
            ThinkingCompleted = r13;
            DMComplexTaskState r15 = new DMComplexTaskState("Terminated", 8);
            Terminated = r15;
            DMComplexTaskState r14 = new DMComplexTaskState("TTS", 9);
            TTS = r14;
            DMComplexTaskState[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
        }

        public static DMComplexTaskState[] values() {
            return (DMComplexTaskState[]) a.clone();
        }

        public static DMComplexTaskState valueOf(String r1) {
            return (DMComplexTaskState) a.a(DMComplexTaskState.class, r1);
        }

        public DMComplexTaskState(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMConstData$DMOAutoTaskState;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "Idle", "Processing", "Clarify", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DMOAutoTaskState extends Enum<DMOAutoTaskState> {
        public static final DMOAutoTaskState Clarify = null;
        public static final DMOAutoTaskState Idle = null;
        public static final DMOAutoTaskState Processing = null;
        public static final /* synthetic */ DMOAutoTaskState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DMOAutoTaskState> getEntries() {
            return b;
        }

        static {
            DMOAutoTaskState r0 = new DMOAutoTaskState("Idle", 0);
            Idle = r0;
            DMOAutoTaskState r1 = new DMOAutoTaskState("Processing", 1);
            Processing = r1;
            DMOAutoTaskState r3 = new DMOAutoTaskState("Clarify", 2);
            Clarify = r3;
            DMOAutoTaskState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static DMOAutoTaskState[] values() {
            return (DMOAutoTaskState[]) a.clone();
        }

        public static DMOAutoTaskState valueOf(String r1) {
            return (DMOAutoTaskState) a.a(DMOAutoTaskState.class, r1);
        }

        public DMOAutoTaskState(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMConstData$DMSimpleTaskState;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "Idle", "Processing", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DMSimpleTaskState extends Enum<DMSimpleTaskState> {
        public static final DMSimpleTaskState Idle = null;
        public static final DMSimpleTaskState Processing = null;
        public static final /* synthetic */ DMSimpleTaskState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DMSimpleTaskState> getEntries() {
            return b;
        }

        static {
            DMSimpleTaskState r0 = new DMSimpleTaskState("Idle", 0);
            Idle = r0;
            DMSimpleTaskState r1 = new DMSimpleTaskState("Processing", 1);
            Processing = r1;
            DMSimpleTaskState[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static DMSimpleTaskState[] values() {
            return (DMSimpleTaskState[]) a.clone();
        }

        public static DMSimpleTaskState valueOf(String r1) {
            return (DMSimpleTaskState) a.a(DMSimpleTaskState.class, r1);
        }

        public DMSimpleTaskState(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMConstData$DMTaskType;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "SIMPLE", "OAUTO", "COMPLEX", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DMTaskType extends Enum<DMTaskType> {
        public static final DMTaskType COMPLEX = null;
        public static final DMTaskType OAUTO = null;
        public static final DMTaskType SIMPLE = null;
        public static final /* synthetic */ DMTaskType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DMTaskType> getEntries() {
            return b;
        }

        static {
            DMTaskType r0 = new DMTaskType("SIMPLE", 0);
            SIMPLE = r0;
            DMTaskType r1 = new DMTaskType("OAUTO", 1);
            OAUTO = r1;
            DMTaskType r3 = new DMTaskType("COMPLEX", 2);
            COMPLEX = r3;
            DMTaskType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static DMTaskType[] values() {
            return (DMTaskType[]) a.clone();
        }

        public static DMTaskType valueOf(String r1) {
            return (DMTaskType) a.a(DMTaskType.class, r1);
        }

        public DMTaskType(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        INSTANCE = new DMConstData();
    }

    private DMConstData() {
    }
}
