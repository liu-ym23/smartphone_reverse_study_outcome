package com.bytedance.sdk.xbridge.cn.registry.core;

import cj.d;
import cj.j;
import cj.k;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000 \u001a2\u00020\u0001:\u0005\u001b\u0007\u001c\u001d\u001eJ5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "", "Lcj/d;", "bridgeContext", "", "", LynxResourceModule.PARAMS_KEY, "Lcj/j;", "callback", "", "realHandle", "(Lcj/d;Ljava/util/Map;Lcj/j;)V", "", "canRunInBackground", "()Z", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "getCompatibility", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "compatibility", "getName", "()Ljava/lang/String;", "name", "Companion", "Access", "cj/k", "Compatibility", "XBridgeThreadType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IDLXBridgeMethod {
    public static final int APPID_EMPTY = 1001;
    public static final int BRIDGE_RELEASED = -12;
    public static final int CANCELLED = -7;
    public static final k Companion = null;
    public static final int EXCEPTION_THROWN = -999;
    public static final int FAIL = 0;
    public static final int HANDLE_ERROR = -11;
    public static final int IDL_ERROR = -10;
    public static final int INVALID_PARAM = -3;
    public static final int INVALID_RESULT = -5;
    public static final int KEY_NOT_FOUND = 2;
    public static final int MALFORMEDRESPONSE_ERROR = -1003;
    public static final int NETWORK_TIMEOUT = -1002;
    public static final int NETWORK_UNREACHABLE = -1001;
    public static final int NOT_FOUND = -9;
    public static final int OPERATION_TIMEOUT = -8;
    public static final String PARAM_CODE = "code";
    public static final String PARAM_DATA = "data";
    public static final String PARAM_MSG = "msg";
    public static final int SUCCESS = 1;
    public static final int UNAUTHORIZED = -1;
    public static final int UNAUTHORIZED_ACCESS = -6;
    public static final int UNKNOWN_APP_ID = 0;
    public static final int UNKNOWN_ERROR = -1000;
    public static final int UNKNOWN_HOST = -4;
    public static final int UNREGISTERED = -2;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final enum Access extends Enum<Access> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Access f7464b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Access f7465c = null;
        public static final Access d = null;
        public static final Access e = null;
        public static final /* synthetic */ Access[] f = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7466a;

        static {
            Access r5 = new Access("PUBLIC", 0, "public");
            f7464b = r5;
            Access r10 = new Access("PROTECT", 1, "protected");
            f7465c = r10;
            Access r11 = new Access("PRIVATE", 2, "private");
            d = r11;
            Access r12 = new Access("SECURE", 3, "secure");
            e = r12;
            f = new Access[]{r5, r10, r11, r12};
        }

        public Access(String r5, int r10, String r11) {
            super(r5, r10);
            this.f7466a = r11;
        }

        public static Access valueOf(String r5) {
            return (Access) Enum.valueOf(Access.class, r5);
        }

        public static Access[] values() {
            return (Access[]) f.clone();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final enum Compatibility extends Enum<Compatibility> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Compatibility f7467b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Compatibility[] f7468c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f7469a;

        static {
            Compatibility r5 = new Compatibility("Compatible", 0, true);
            f7467b = r5;
            f7468c = new Compatibility[]{r5, new Compatibility("InCompatible", 1, false)};
        }

        public Compatibility(String r5, int r10, boolean r11) {
            super(r5, r10);
            this.f7469a = r11;
        }

        public static Compatibility valueOf(String r5) {
            return (Compatibility) Enum.valueOf(Compatibility.class, r5);
        }

        public static Compatibility[] values() {
            return (Compatibility[]) f7468c.clone();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$XBridgeThreadType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final enum XBridgeThreadType extends Enum<XBridgeThreadType> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final XBridgeThreadType f7470b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ XBridgeThreadType[] f7471c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7472a;

        static {
            XBridgeThreadType r5 = new XBridgeThreadType("SYNC_THREAD", 0, "sync_thread");
            XBridgeThreadType r10 = new XBridgeThreadType("MAIN_THREAD", 1, "main_thread");
            XBridgeThreadType r11 = new XBridgeThreadType("ASYNC_THREAD", 2, "async_thread");
            f7470b = r11;
            f7471c = new XBridgeThreadType[]{r5, r10, r11, new XBridgeThreadType("MAIN_THREAD_OPT", 3, "main_thread_opt")};
        }

        public XBridgeThreadType(String r5, int r10, String r11) {
            super(r5, r10);
            this.f7472a = r11;
        }

        public static XBridgeThreadType valueOf(String r5) {
            return (XBridgeThreadType) Enum.valueOf(XBridgeThreadType.class, r5);
        }

        public static XBridgeThreadType[] values() {
            return (XBridgeThreadType[]) f7471c.clone();
        }
    }

    static {
        Companion = k.f1208a;
    }

    boolean canRunInBackground();

    Access getAccess();

    Compatibility getCompatibility();

    String getName();

    void realHandle(d r5, Map<String, ? extends Object> r10, j r11);
}
