package m1;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f19964a = null;

    static {
        int[] r5 = new int[ProtocolMessage.Type.values().length];
        r5[ProtocolMessage.Type.Call.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r5[ProtocolMessage.Type.Callback.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r5[ProtocolMessage.Type.Event.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f19964a = r5;
    }
}
