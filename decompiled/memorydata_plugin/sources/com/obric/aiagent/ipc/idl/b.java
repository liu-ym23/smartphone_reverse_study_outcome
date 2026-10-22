package com.obric.aiagent.ipc.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/aiagent/ipc/idl/IFileIDLSPI;", "Lcom/obric/aiagent/ipc/idl/IFileIDL;", "asBinder", "Landroid/os/IBinder;", "Companion", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface b extends com.obric.aiagent.ipc.idl.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5935a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/ipc/idl/IFileIDLSPI$Companion;", "", "<init>", "()V", "TAG", "", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f5936a = null;

        static {
            f5936a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.ipc.idl.b$b, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C0239b {
        public static IBinder a(b r2) {
            b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            return null;
        }
    }

    static {
        f5935a = a.f5936a;
    }
}
