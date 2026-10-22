package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(NotifyServiceCenterStateRequestSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest;", "Lvh7/j;", "State", "b", "c", "d", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "core.service.NotifyServiceCenterStateRequest")
public interface NotifyServiceCenterStateRequest extends vh7.j<NotifyServiceCenterStateRequest> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$State;", "", "", "tag", "I", "getTag", "()I", "UNKNOWN", "STARTED", "SCRIPTS_LOADED", "SERVICES_LOADED", "STOPPED", "PRE_STARTED", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum State extends Enum<State> {
        public static final State PRE_STARTED = null;
        public static final State SCRIPTS_LOADED = null;
        public static final State SERVICES_LOADED = null;
        public static final State STARTED = null;
        public static final State STOPPED = null;
        public static final State UNKNOWN = null;
        public static final /* synthetic */ State[] a = null;
        private final int tag;

        static {
            State r1 = new State("UNKNOWN", 0, 0);
            UNKNOWN = r1;
            State r2 = new State("STARTED", 1, 1);
            STARTED = r2;
            State r3 = new State("SCRIPTS_LOADED", 2, 3);
            SCRIPTS_LOADED = r3;
            State r4 = new State("SERVICES_LOADED", 3, 4);
            SERVICES_LOADED = r4;
            State r5 = new State("STOPPED", 4, 20);
            STOPPED = r5;
            State r6 = new State("PRE_STARTED", 5, 21);
            PRE_STARTED = r6;
            a = new State[]{r1, r2, r3, r4, r5, r6};
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public final int getTag() {
            return this.tag;
        }

        public State(String r1, int r2, int r3) {
            super(r1, r2);
            this.tag = r3;
        }
    }

    @JsonAdapter(NotifyServiceCenterStateRequestSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(NotifyServiceCenterStateRequest_StateLoadedSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$b;", "Lvh7/j;", "b", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    @RpcMessage(messageName = "core.service.NotifyServiceCenterStateRequest.StateLoaded")
    public interface b extends vh7.j<b> {

        @JsonAdapter(NotifyServiceCenterStateRequest_StateLoadedSerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.container.impl.core.NotifyServiceCenterStateRequest$b$b, reason: collision with other inner class name */
        @JsonAdapter(NotifyServiceCenterStateRequest_StateLoaded_ServicesSerializableObjectImpl.Adapter.class)
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$b$b;", "Lvh7/j;", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
        @RpcMessage(messageName = "core.service.NotifyServiceCenterStateRequest.StateLoaded.Service")
        public interface InterfaceC0090b extends vh7.j<InterfaceC0090b> {

            /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.container.impl.core.NotifyServiceCenterStateRequest$b$b$a */
            @JsonAdapter(NotifyServiceCenterStateRequest_StateLoaded_ServicesSerializableObjectImpl.Adapter.class)
            @Metadata(k = 3, mv = {1, 5, 1})
            public static final class a {
            }

            @FieldName(name = "interface_id")
            String T1();
        }

        @FieldName(name = "services")
        List<InterfaceC0090b> getServices();

        @FieldName(name = "services#setter")
        void setServices(List<? extends InterfaceC0090b> r1);
    }

    @JsonAdapter(NotifyServiceCenterStateRequest_StateStartedSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$c;", "Lvh7/j;", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    @RpcMessage(messageName = "core.service.NotifyServiceCenterStateRequest.StateStarted")
    public interface c extends vh7.j<c> {
    }

    @JsonAdapter(NotifyServiceCenterStateRequest_StateStoppedSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyServiceCenterStateRequest$d;", "Lvh7/j;", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    @RpcMessage(messageName = "core.service.NotifyServiceCenterStateRequest.StateStopped")
    public interface d extends vh7.j<d> {
    }

    @FieldName(name = "state_loaded")
    b I1();

    @FieldName(name = "state#setter")
    void N(int r1);

    @FieldName(name = "service_version")
    String getServiceVersion();

    @FieldName(name = "state")
    int getState();

    @FieldName(name = "state_loaded#setter")
    void t6(b r1);
}
