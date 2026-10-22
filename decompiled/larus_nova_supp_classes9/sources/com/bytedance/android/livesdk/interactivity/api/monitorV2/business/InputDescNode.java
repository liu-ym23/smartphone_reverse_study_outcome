package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/InputDescNode;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "descNodeName", "Ljava/lang/String;", "getDescNodeName", "()Ljava/lang/String;", "LastSubTab", "CommentInterceptReason", "SendInterceptReason", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputDescNode extends Enum<InputDescNode> {
    public static final InputDescNode CommentInterceptReason = null;
    public static final InputDescNode LastSubTab = null;
    public static final InputDescNode SendInterceptReason = null;
    public static final /* synthetic */ InputDescNode[] a = null;
    private final String descNodeName;

    static {
        InputDescNode r1 = new InputDescNode("LastSubTab", 0, "last_tab");
        LastSubTab = r1;
        InputDescNode r2 = new InputDescNode("CommentInterceptReason", 1, "comment_intercept");
        CommentInterceptReason = r2;
        InputDescNode r3 = new InputDescNode("SendInterceptReason", 2, "send_intercept");
        SendInterceptReason = r3;
        a = new InputDescNode[]{r1, r2, r3};
    }

    public static InputDescNode valueOf(String r1) {
        return (InputDescNode) a.a(InputDescNode.class, r1);
    }

    public static InputDescNode[] values() {
        return (InputDescNode[]) a.clone();
    }

    public final String getDescNodeName() {
        return this.descNodeName;
    }

    public InputDescNode(String r1, int r2, String r3) {
        super(r1, r2);
        this.descNodeName = r3;
    }
}
