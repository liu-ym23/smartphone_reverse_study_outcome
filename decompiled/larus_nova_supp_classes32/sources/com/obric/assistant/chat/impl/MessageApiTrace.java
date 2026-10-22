package com.obric.assistant.chat.impl;

import com.larus.platform.service.o;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageApiTrace {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/chat/impl/MessageApiTrace$GetExtResultState;", NameKeys.UnloadStrategy_No_Strategy, "state", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;II)V", "getState", "()I", "Default", "Timeout", "Error", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum GetExtResultState extends Enum<GetExtResultState> {
        public static final GetExtResultState Default = null;
        public static final GetExtResultState Error = null;
        public static final GetExtResultState Timeout = null;
        public static final /* synthetic */ GetExtResultState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int state;

        public static EnumEntries<GetExtResultState> getEntries() {
            return b;
        }

        static {
            GetExtResultState r0 = new GetExtResultState("Default", 0, 0);
            Default = r0;
            GetExtResultState r1 = new GetExtResultState("Timeout", 1, 1);
            Timeout = r1;
            GetExtResultState r3 = new GetExtResultState("Error", 2, 2);
            Error = r3;
            GetExtResultState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static GetExtResultState[] values() {
            return (GetExtResultState[]) a.clone();
        }

        public final int getState() {
            return this.state;
        }

        public static GetExtResultState valueOf(String r1) {
            return (GetExtResultState) r27.a.a(GetExtResultState.class, r1);
        }

        public GetExtResultState(String r1, int r2, int r3) {
            super(r1, r2);
            this.state = r3;
        }
    }

    static {
    }

    public static void a(String r2, long r3, GetExtResultState r5) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r5, "resultState");
        JSONObject r1 = new JSONObject();
        r1.put("scene", r2);
        r1.put("costTime", r3);
        r1.put("result", r5.getState());
        o.a.reportEvent("o_get_message_ext", r1);
    }
}
