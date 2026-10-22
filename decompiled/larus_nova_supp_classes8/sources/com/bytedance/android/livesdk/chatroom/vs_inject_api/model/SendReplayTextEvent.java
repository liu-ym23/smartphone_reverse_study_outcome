package com.bytedance.android.livesdk.chatroom.vs_inject_api.model;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class SendReplayTextEvent {
    public String a;
    public Sender b;
    public Map<String, ? extends Object> c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_inject_api/model/SendReplayTextEvent$Sender;", "", DSLType.Unknown, "CommentWidget", "Lottery", "VsPlusOne", "vs-inject-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Sender extends Enum<Sender> {
        public static final Sender CommentWidget = null;
        public static final Sender Lottery = null;
        public static final Sender Unknown = null;
        public static final Sender VsPlusOne = null;
        public static final /* synthetic */ Sender[] a = null;

        static {
            Sender r1 = new Sender(DSLType.Unknown, 0);
            Unknown = r1;
            Sender r2 = new Sender("CommentWidget", 1);
            CommentWidget = r2;
            Sender r3 = new Sender("Lottery", 2);
            Lottery = r3;
            Sender r4 = new Sender("VsPlusOne", 3);
            VsPlusOne = r4;
            a = new Sender[]{r1, r2, r3, r4};
        }

        public static Sender valueOf(String r1) {
            return (Sender) r27.a.a(Sender.class, r1);
        }

        public static Sender[] values() {
            return (Sender[]) a.clone();
        }

        public Sender(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public SendReplayTextEvent() {
        this.a = "";
        this.b = Sender.Unknown;
        this.c = MapsKt.emptyMap();
    }
}
