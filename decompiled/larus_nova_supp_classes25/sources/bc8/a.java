package bc8;

import android.view.View;
import com.larus.common.venue.impl.venue.component.g;
import com.larus.common_ui.view.SuggestedActionBar;
import com.larus.feishu.office.im.impl.base.q0;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionScene;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface a extends m1a.a {

    /* JADX INFO: renamed from: bc8.a$a, reason: collision with other inner class name */
    public static final class C0001a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(a r8, SuggestedActionScene r9, String r10, boolean r11, List r12, boolean r13, int r14) {
            if ((r14 & 4) == 0) goto L5;
            boolean r5 = false;
        L7:
            if ((r14 & 8) == 0) goto L9;
            r12 = null;
        L9:
            List r6 = r12;
            if ((r14 & 16) == 0) goto L12;
            boolean r7 = false;
        L13:
            r8.YP(r9, r10, r5, r6, r7);
            return;
        L12:
            r7 = r13;
            goto L13
        L5:
            r5 = r11;
            goto L7
        }
    }

    void Bz();

    void G8(q0 r1);

    boolean Ge(SuggestedAction r1);

    void Gh(g r1);

    SuggestedActionBar JU();

    void Rg(String r1);

    void YP(SuggestedActionScene r1, String r2, boolean r3, List<UplinkFileEntity> r4, boolean r5);

    void Zv(SuggestedActionScene r1, String r2, List<SuggestedAction> r3, boolean r4, boolean r5);

    void cL(SuggestedActionScene r1, String r2, boolean r3, List<UplinkFileEntity> r4, Function1<? super List<SuggestedAction>, Unit> r5);

    boolean d3();

    void kC(String r1, iq9.e r2, boolean r3);

    void mX();

    boolean mt();

    void np();

    void nv(boolean r1);

    void r10();

    List<SuggestedAction> r4(SuggestedActionScene r1, String r2, boolean r3);

    void r40(SuggestedActionScene r1, String r2, List<SuggestedAction> r3, Set<String> r4);

    View y8();
}
