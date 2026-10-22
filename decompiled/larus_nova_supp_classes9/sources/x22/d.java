package x22;

import android.util.LongSparseArray;
import com.bytedance.android.livesdk.interactivity.api.comment.CommentComponentType;
import com.bytedance.android.livesdk.interactivity.api.comment.data.InputDraftType;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements t22.a {
    public final CommentComponentType a;
    public final LongSparseArray<com.bytedance.android.livesdk.interactivity.api.comment.data.e> b;

    public static final class a {
    }

    static {
    }

    @Override // t22.a
    public final void onLoad() {
    }

    @Override // t22.a
    public final void onUnload() {
        this.b.clear();
    }

    public d() {
        this.a = CommentComponentType.Draft;
        this.b = new LongSparseArray();
    }

    @Override // t22.a
    public CommentComponentType getType() {
        return this.a;
    }

    public final com.bytedance.android.livesdk.interactivity.api.comment.data.e a(long r5) {
        com.bytedance.android.livesdk.interactivity.api.comment.data.e r0 = this.b.get(r5);
        if (r5 <= 0) goto L5;
        InputDraftType r1 = InputDraftType.Channel;
    L6:
        if (r0 != null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.comment.data.e r2 = new com.bytedance.android.livesdk.interactivity.api.comment.data.e(BuildConfig.FLAVOR, r1, r5);
        this.b.put(r5, r2);
        return r2;
    L9:
        return r0;
    L5:
        r1 = InputDraftType.Default;
        goto L6
    }
}
