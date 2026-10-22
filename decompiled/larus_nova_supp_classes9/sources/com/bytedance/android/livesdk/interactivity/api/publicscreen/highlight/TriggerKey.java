package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/TriggerKey;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "id", "J", "getId", "()J", "TopicDismiss", "ComponentShowDismiss", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TriggerKey extends Enum<TriggerKey> {
    public static final TriggerKey ComponentShowDismiss = null;
    public static final TriggerKey TopicDismiss = null;
    public static final /* synthetic */ TriggerKey[] a = null;
    private final long id;

    static {
        TriggerKey r1 = new TriggerKey("TopicDismiss", 0, 1);
        TopicDismiss = r1;
        TriggerKey r2 = new TriggerKey("ComponentShowDismiss", 1, 2);
        ComponentShowDismiss = r2;
        a = new TriggerKey[]{r1, r2};
    }

    public static TriggerKey valueOf(String r1) {
        return (TriggerKey) r27.a.a(TriggerKey.class, r1);
    }

    public static TriggerKey[] values() {
        return (TriggerKey[]) a.clone();
    }

    public final long getId() {
        return this.id;
    }

    public TriggerKey(String r1, int r2, long r3) {
        super(r1, r2);
        this.id = r3;
    }
}
