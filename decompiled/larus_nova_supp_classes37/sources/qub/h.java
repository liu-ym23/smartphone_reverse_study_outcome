package qub;

import android.content.Context;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface h extends IOfficeSDKProtocol {

    public static final class a implements h {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // qub.h
        public final void u(Context r2, rub.e r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "config");
        }
    }

    void u(Context r1, rub.e r2);
}
