package b;

import android.os.Bundle;
import android.os.IInterface;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final String f802g1 = null;

    static {
        f802g1 = "android$support$v4$os$IResultReceiver".replace(Typography.dollar, '.');
    }

    void a(int r5, Bundle r10);
}
