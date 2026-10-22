package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/topcontainer/ConflictStrategy;", BuildConfig.FLAVOR, "DISCARD", "QUEUE", "INTERRUPT", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ConflictStrategy extends Enum<ConflictStrategy> {
    public static final ConflictStrategy DISCARD = null;
    public static final ConflictStrategy INTERRUPT = null;
    public static final ConflictStrategy QUEUE = null;
    public static final /* synthetic */ ConflictStrategy[] a = null;

    static {
        ConflictStrategy r1 = new ConflictStrategy("DISCARD", 0);
        DISCARD = r1;
        ConflictStrategy r2 = new ConflictStrategy("QUEUE", 1);
        QUEUE = r2;
        ConflictStrategy r3 = new ConflictStrategy("INTERRUPT", 2);
        INTERRUPT = r3;
        a = new ConflictStrategy[]{r1, r2, r3};
    }

    public static ConflictStrategy valueOf(String r1) {
        return (ConflictStrategy) a.a(ConflictStrategy.class, r1);
    }

    public static ConflictStrategy[] values() {
        return (ConflictStrategy[]) a.clone();
    }

    public ConflictStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
