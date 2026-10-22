package qub;

import android.app.Activity;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b extends IOfficeSDKProtocol {

    public static final class a implements b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // qub.b
        public final qub.a L(Activity r2, rub.a r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "config");
            return qub.a.C0180a.a;
        }
    }

    qub.a L(Activity r1, rub.a r2);
}
