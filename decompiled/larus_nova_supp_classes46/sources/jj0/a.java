package jj0;

import com.bytedance.android.livesdk.y;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveBackupSeiSettingConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final long b = 0;
    public final ij0.a a;

    /* JADX INFO: renamed from: jj0.a$a, reason: collision with other inner class name */
    public static final class C0224a {
    }

    static {
        b = ((LiveBackupSeiSettingConfig) y.a.getValue()).getBackupSeiBehindRangeMS();
    }

    public a(ij0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "backupSeiConsumer");
        this.a = r2;
    }
}
