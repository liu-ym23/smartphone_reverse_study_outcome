package qub;

import android.content.Context;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface c extends IOfficeSDKProtocol {

    public static final class a implements c {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // qub.c
        public final void u0(Context r2, rub.b r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "config");
        }

        @Override // qub.c
        public final void B(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
        }
    }

    void B(Context r1);

    void u0(Context r1, rub.b r2);
}
