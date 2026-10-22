package qub;

import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface e extends IOfficeSDKProtocol {

    public static final class a implements e {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // qub.e
        public final void w(FragmentManager r2, rub.d r3) {
            Intrinsics.checkNotNullParameter(r2, "fragmentManager");
            Intrinsics.checkNotNullParameter(r3, "config");
        }

        @Override // qub.e
        public final void T(FragmentManager r2) {
            Intrinsics.checkNotNullParameter(r2, "fragmentManager");
            Intrinsics.checkNotNullParameter("MmStandaloneAIInterpretationLanguagePanel", "id");
        }

        @Override // qub.e
        public final void m0(FragmentManager r2) {
            Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        }
    }

    void T(FragmentManager r1);

    void m0(FragmentManager r1);

    void w(FragmentManager r1, rub.d r2);
}
