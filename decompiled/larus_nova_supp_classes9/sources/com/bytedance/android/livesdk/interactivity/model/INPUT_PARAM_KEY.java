package com.bytedance.android.livesdk.interactivity.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/model/INPUT_PARAM_KEY;", BuildConfig.FLAVOR, "TargetUser", "ReplyMsgId", "SecretClickFrom", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum INPUT_PARAM_KEY extends Enum<INPUT_PARAM_KEY> {
    public static final INPUT_PARAM_KEY ReplyMsgId = null;
    public static final INPUT_PARAM_KEY SecretClickFrom = null;
    public static final INPUT_PARAM_KEY TargetUser = null;
    public static final /* synthetic */ INPUT_PARAM_KEY[] a = null;

    static {
        INPUT_PARAM_KEY r1 = new INPUT_PARAM_KEY("TargetUser", 0);
        TargetUser = r1;
        INPUT_PARAM_KEY r2 = new INPUT_PARAM_KEY("ReplyMsgId", 1);
        ReplyMsgId = r2;
        INPUT_PARAM_KEY r3 = new INPUT_PARAM_KEY("SecretClickFrom", 2);
        SecretClickFrom = r3;
        a = new INPUT_PARAM_KEY[]{r1, r2, r3};
    }

    public static INPUT_PARAM_KEY valueOf(String r1) {
        return (INPUT_PARAM_KEY) a.a(INPUT_PARAM_KEY.class, r1);
    }

    public static INPUT_PARAM_KEY[] values() {
        return (INPUT_PARAM_KEY[]) a.clone();
    }

    public INPUT_PARAM_KEY(String r1, int r2) {
        super(r1, r2);
    }
}
