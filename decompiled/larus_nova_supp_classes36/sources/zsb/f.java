package zsb;

import com.bytedance.lark.pb.basic.v1.MessageData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[MessageData.Type.values().length];
        a = r0;
        r0[MessageData.Type.AT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L14:
        a[MessageData.Type.URGENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L18:
        a[MessageData.Type.REACTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L22:
        a[MessageData.Type.URGENT_ACK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L16:
        a[MessageData.Type.URGENT_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
        return;
    }
}
