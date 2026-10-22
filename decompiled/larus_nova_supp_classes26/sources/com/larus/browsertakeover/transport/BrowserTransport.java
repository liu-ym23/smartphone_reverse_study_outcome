package com.larus.browsertakeover.transport;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface BrowserTransport {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/browsertakeover/transport/BrowserTransport$EndpointMode;", "", "<init>", "(Ljava/lang/String;I)V", "BROWSER", "PAGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EndpointMode extends Enum<EndpointMode> {
        public static final EndpointMode BROWSER = null;
        public static final EndpointMode PAGE = null;
        public static final /* synthetic */ EndpointMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<EndpointMode> getEntries() {
            return b;
        }

        static {
            EndpointMode r0 = new EndpointMode("BROWSER", 0);
            BROWSER = r0;
            EndpointMode r1 = new EndpointMode("PAGE", 1);
            PAGE = r1;
            EndpointMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static EndpointMode[] values() {
            return (EndpointMode[]) a.clone();
        }

        public static EndpointMode valueOf(String r1) {
            return (EndpointMode) r27.a.a(EndpointMode.class, r1);
        }

        public EndpointMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/browsertakeover/transport/BrowserTransport$FrameSource;", "", "<init>", "(Ljava/lang/String;I)V", "CDP_SCREENCAST", "RTP_CDP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FrameSource extends Enum<FrameSource> {
        public static final FrameSource CDP_SCREENCAST = null;
        public static final FrameSource RTP_CDP = null;
        public static final /* synthetic */ FrameSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<FrameSource> getEntries() {
            return b;
        }

        static {
            FrameSource r0 = new FrameSource("CDP_SCREENCAST", 0);
            CDP_SCREENCAST = r0;
            FrameSource r1 = new FrameSource("RTP_CDP", 1);
            RTP_CDP = r1;
            FrameSource[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static FrameSource[] values() {
            return (FrameSource[]) a.clone();
        }

        public static FrameSource valueOf(String r1) {
            return (FrameSource) r27.a.a(FrameSource.class, r1);
        }

        public FrameSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void a(JSONObject r1);

        void onConnected();

        void onDisconnected();

        void onError();

        void onMessage(String r1);
    }

    FrameSource a();

    void b(com.larus.browsertakeover.cdp.a r1);

    EndpointMode c();

    void disconnect();

    void release();

    boolean send(String r1);
}
