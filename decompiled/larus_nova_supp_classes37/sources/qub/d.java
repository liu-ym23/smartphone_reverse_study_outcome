package qub;

import android.content.Context;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface d extends IOfficeSDKProtocol {

    public static final class a implements d {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // qub.d
        public final void t0(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
        }
    }

    void t0(Context r1);
}
